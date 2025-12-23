package io.netty.channel.epoll;

import com.bykv.vk.component.ttvideo.player.C;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.util.IntSupplier;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class EpollEventLoop extends SingleThreadEventLoop {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long MAX_SCHEDULED_TIMERFD_NS = 999999999;
    private final boolean allowGrowing;
    private final IntObjectMap<AbstractEpollChannel> channels;
    private NativeDatagramPacketArray datagramPacketArray;
    private final FileDescriptor epollFd;
    private final FileDescriptor eventFd;
    private final EpollEventArray events;
    private volatile int ioRatio;
    private IovArray iovArray;
    private long prevDeadlineNanos;
    private final IntSupplier selectNowSupplier;
    private final SelectStrategy selectStrategy;
    private final FileDescriptor timerFd;
    private volatile int wakenUp;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) EpollEventLoop.class);
    private static final AtomicIntegerFieldUpdater<EpollEventLoop> WAKEN_UP_UPDATER = AtomicIntegerFieldUpdater.newUpdater(EpollEventLoop.class, "wakenUp");

    private static Queue<Runnable> newTaskQueue(EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        return eventLoopTaskQueueFactory == null ? newTaskQueue0(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS) : eventLoopTaskQueueFactory.newTaskQueue(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS);
    }

    private void processReady(EpollEventArray epollEventArray, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            int fd = epollEventArray.fd(i7);
            if (fd != this.eventFd.intValue() && fd != this.timerFd.intValue()) {
                long events = epollEventArray.events(i7);
                AbstractEpollChannel abstractEpollChannel = this.channels.get(fd);
                if (abstractEpollChannel != null) {
                    AbstractEpollChannel.AbstractEpollUnsafe abstractEpollUnsafe = (AbstractEpollChannel.AbstractEpollUnsafe) abstractEpollChannel.unsafe();
                    int i8 = Native.EPOLLERR;
                    if (((Native.EPOLLOUT | i8) & events) != 0) {
                        abstractEpollUnsafe.epollOutReady();
                    }
                    if (((i8 | Native.EPOLLIN) & events) != 0) {
                        abstractEpollUnsafe.epollInReady();
                    }
                    if ((events & Native.EPOLLRDHUP) != 0) {
                        abstractEpollUnsafe.epollRdHupReady();
                    }
                } else {
                    try {
                        Native.epollCtlDel(this.epollFd.intValue(), fd);
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void cleanup() {
        try {
            try {
                this.epollFd.close();
            } catch (IOException e6) {
                logger.warn("Failed to close the epoll fd.", (Throwable) e6);
            }
            try {
                this.eventFd.close();
            } catch (IOException e7) {
                logger.warn("Failed to close the event fd.", (Throwable) e7);
            }
            try {
                this.timerFd.close();
            } catch (IOException e8) {
                logger.warn("Failed to close the timer fd.", (Throwable) e8);
            }
        } finally {
            IovArray iovArray = this.iovArray;
            if (iovArray != null) {
                iovArray.release();
                this.iovArray = null;
            }
            NativeDatagramPacketArray nativeDatagramPacketArray = this.datagramPacketArray;
            if (nativeDatagramPacketArray != null) {
                nativeDatagramPacketArray.release();
                this.datagramPacketArray = null;
            }
            this.events.free();
        }
    }

    static {
        Epoll.ensureAvailability();
    }

    private int epollBusyWait() throws IOException {
        return Native.epollBusyWait(this.epollFd, this.events);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int epollWaitNow() throws IOException {
        return Native.epollWait(this.epollFd, this.events, this.timerFd, 0, 0);
    }

    void add(AbstractEpollChannel abstractEpollChannel) throws IOException {
        int intValue = abstractEpollChannel.socket.intValue();
        Native.epollCtlAdd(this.epollFd.intValue(), intValue, abstractEpollChannel.flags);
        this.channels.put(intValue, (int) abstractEpollChannel);
    }

    NativeDatagramPacketArray cleanDatagramPacketArray() {
        NativeDatagramPacketArray nativeDatagramPacketArray = this.datagramPacketArray;
        if (nativeDatagramPacketArray == null) {
            this.datagramPacketArray = new NativeDatagramPacketArray();
        } else {
            nativeDatagramPacketArray.clear();
        }
        return this.datagramPacketArray;
    }

    IovArray cleanIovArray() {
        IovArray iovArray = this.iovArray;
        if (iovArray == null) {
            this.iovArray = new IovArray();
        } else {
            iovArray.clear();
        }
        return this.iovArray;
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    void handleLoopException(Throwable th) {
        logger.warn("Unexpected exception in the selector loop.", th);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException unused) {
        }
    }

    void modify(AbstractEpollChannel abstractEpollChannel) throws IOException {
        Native.epollCtlMod(this.epollFd.intValue(), abstractEpollChannel.socket.intValue(), abstractEpollChannel.flags);
    }

    @Override // io.netty.channel.SingleThreadEventLoop
    public int registeredChannels() {
        return this.channels.size();
    }

    void remove(AbstractEpollChannel abstractEpollChannel) throws IOException {
        int intValue = abstractEpollChannel.socket.intValue();
        AbstractEpollChannel remove = this.channels.remove(intValue);
        if (remove != null && remove != abstractEpollChannel) {
            this.channels.put(intValue, (int) remove);
        } else if (abstractEpollChannel.isOpen()) {
            Native.epollCtlDel(this.epollFd.intValue(), intValue);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0000 A[SYNTHETIC] */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void run() {
        /*
            r6 = this;
        L0:
            io.netty.channel.SelectStrategy r0 = r6.selectStrategy     // Catch: java.lang.Throwable -> L1f
            io.netty.util.IntSupplier r1 = r6.selectNowSupplier     // Catch: java.lang.Throwable -> L1f
            boolean r2 = r6.hasTasks()     // Catch: java.lang.Throwable -> L1f
            int r0 = r0.calculateStrategy(r1, r2)     // Catch: java.lang.Throwable -> L1f
            r1 = -3
            if (r0 == r1) goto L2c
            r1 = -2
            if (r0 == r1) goto L0
            r1 = -1
            if (r0 == r1) goto L16
            goto L30
        L16:
            int r1 = r6.wakenUp     // Catch: java.lang.Throwable -> L1f
            r2 = 1
            if (r1 != r2) goto L21
            r1 = 0
            r6.wakenUp = r1     // Catch: java.lang.Throwable -> L1f
            goto L21
        L1f:
            r0 = move-exception
            goto L85
        L21:
            boolean r1 = r6.hasTasks()     // Catch: java.lang.Throwable -> L1f
            if (r1 != 0) goto L30
            int r0 = r6.epollWait()     // Catch: java.lang.Throwable -> L1f
            goto L30
        L2c:
            int r0 = r6.epollBusyWait()     // Catch: java.lang.Throwable -> L1f
        L30:
            int r1 = r6.ioRatio     // Catch: java.lang.Throwable -> L1f
            r2 = 100
            if (r1 != r2) goto L47
            if (r0 <= 0) goto L43
            io.netty.channel.epoll.EpollEventArray r1 = r6.events     // Catch: java.lang.Throwable -> L3e
            r6.processReady(r1, r0)     // Catch: java.lang.Throwable -> L3e
            goto L43
        L3e:
            r0 = move-exception
            r6.runAllTasks()     // Catch: java.lang.Throwable -> L1f
            throw r0     // Catch: java.lang.Throwable -> L1f
        L43:
            r6.runAllTasks()     // Catch: java.lang.Throwable -> L1f
            goto L73
        L47:
            long r2 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L1f
            if (r0 <= 0) goto L64
            io.netty.channel.epoll.EpollEventArray r4 = r6.events     // Catch: java.lang.Throwable -> L53
            r6.processReady(r4, r0)     // Catch: java.lang.Throwable -> L53
            goto L64
        L53:
            r0 = move-exception
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L1f
            long r4 = r4 - r2
            int r2 = 100 - r1
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L1f
            long r4 = r4 * r2
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L1f
            long r4 = r4 / r1
            r6.runAllTasks(r4)     // Catch: java.lang.Throwable -> L1f
            throw r0     // Catch: java.lang.Throwable -> L1f
        L64:
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L1f
            long r4 = r4 - r2
            int r2 = 100 - r1
            long r2 = (long) r2     // Catch: java.lang.Throwable -> L1f
            long r4 = r4 * r2
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L1f
            long r4 = r4 / r1
            r6.runAllTasks(r4)     // Catch: java.lang.Throwable -> L1f
        L73:
            boolean r1 = r6.allowGrowing     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L88
            io.netty.channel.epoll.EpollEventArray r1 = r6.events     // Catch: java.lang.Throwable -> L1f
            int r1 = r1.length()     // Catch: java.lang.Throwable -> L1f
            if (r0 != r1) goto L88
            io.netty.channel.epoll.EpollEventArray r0 = r6.events     // Catch: java.lang.Throwable -> L1f
            r0.increase()     // Catch: java.lang.Throwable -> L1f
            goto L88
        L85:
            r6.handleLoopException(r0)
        L88:
            boolean r0 = r6.isShuttingDown()     // Catch: java.lang.Throwable -> L98
            if (r0 == 0) goto L0
            r6.closeAll()     // Catch: java.lang.Throwable -> L98
            boolean r0 = r6.confirmShutdown()     // Catch: java.lang.Throwable -> L98
            if (r0 == 0) goto L0
            return
        L98:
            r0 = move-exception
            r6.handleLoopException(r0)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.EpollEventLoop.run():void");
    }

    public void setIoRatio(int i6) {
        if (i6 > 0 && i6 <= 100) {
            this.ioRatio = i6;
            return;
        }
        throw new IllegalArgumentException("ioRatio: " + i6 + " (expected: 0 < ioRatio <= 100)");
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void wakeup(boolean z5) {
        if (z5 || WAKEN_UP_UPDATER.getAndSet(this, 1) != 0) {
            return;
        }
        Native.eventFdWrite(this.eventFd.intValue(), 1L);
    }

    EpollEventLoop(EventLoopGroup eventLoopGroup, Executor executor, int i6, SelectStrategy selectStrategy, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        super(eventLoopGroup, executor, false, newTaskQueue(eventLoopTaskQueueFactory), newTaskQueue(eventLoopTaskQueueFactory), rejectedExecutionHandler);
        Throwable th;
        FileDescriptor fileDescriptor;
        FileDescriptor fileDescriptor2;
        this.prevDeadlineNanos = AbstractScheduledEventExecutor.nanoTime() - 1;
        this.channels = new IntObjectHashMap(4096);
        this.selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.epoll.EpollEventLoop.1
            @Override // io.netty.util.IntSupplier
            public int get() throws Exception {
                return EpollEventLoop.this.epollWaitNow();
            }
        };
        this.ioRatio = 50;
        this.selectStrategy = (SelectStrategy) ObjectUtil.checkNotNull(selectStrategy, "strategy");
        if (i6 == 0) {
            this.allowGrowing = true;
            this.events = new EpollEventArray(4096);
        } else {
            this.allowGrowing = false;
            this.events = new EpollEventArray(i6);
        }
        FileDescriptor fileDescriptor3 = null;
        try {
            FileDescriptor newEpollCreate = Native.newEpollCreate();
            try {
                this.epollFd = newEpollCreate;
                fileDescriptor2 = Native.newEventFd();
                try {
                    this.eventFd = fileDescriptor2;
                    try {
                        int intValue = newEpollCreate.intValue();
                        int intValue2 = fileDescriptor2.intValue();
                        int i7 = Native.EPOLLIN;
                        int i8 = Native.EPOLLET;
                        Native.epollCtlAdd(intValue, intValue2, i7 | i8);
                        fileDescriptor3 = Native.newTimerFd();
                        this.timerFd = fileDescriptor3;
                        try {
                            Native.epollCtlAdd(newEpollCreate.intValue(), fileDescriptor3.intValue(), i7 | i8);
                        } catch (IOException e6) {
                            throw new IllegalStateException("Unable to add timerFd filedescriptor to epoll", e6);
                        }
                    } catch (IOException e7) {
                        throw new IllegalStateException("Unable to add eventFd filedescriptor to epoll", e7);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileDescriptor = fileDescriptor3;
                    fileDescriptor3 = newEpollCreate;
                    if (fileDescriptor3 != null) {
                        try {
                            fileDescriptor3.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (fileDescriptor2 != null) {
                        try {
                            fileDescriptor2.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (fileDescriptor != null) {
                        try {
                            fileDescriptor.close();
                            throw th;
                        } catch (Exception unused3) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileDescriptor2 = null;
                fileDescriptor3 = newEpollCreate;
                fileDescriptor = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileDescriptor = null;
            fileDescriptor2 = null;
        }
    }

    private void closeAll() {
        try {
            epollWaitNow();
        } catch (IOException unused) {
        }
        for (AbstractEpollChannel abstractEpollChannel : (AbstractEpollChannel[]) this.channels.values().toArray(new AbstractEpollChannel[0])) {
            abstractEpollChannel.unsafe().close(abstractEpollChannel.unsafe().voidPromise());
        }
    }

    private int epollWait() throws IOException {
        int min;
        int i6;
        long deadlineNanos = deadlineNanos();
        if (deadlineNanos == this.prevDeadlineNanos) {
            i6 = -1;
            min = -1;
        } else {
            long delayNanos = delayNanos(System.nanoTime());
            this.prevDeadlineNanos = deadlineNanos;
            int min2 = (int) Math.min(delayNanos / C.NANOS_PER_SECOND, 2147483647L);
            min = (int) Math.min(delayNanos - (min2 * C.NANOS_PER_SECOND), MAX_SCHEDULED_TIMERFD_NS);
            i6 = min2;
        }
        return Native.epollWait(this.epollFd, this.events, this.timerFd, i6, min);
    }

    private static Queue<Runnable> newTaskQueue0(int i6) {
        if (i6 == Integer.MAX_VALUE) {
            return PlatformDependent.newMpscQueue();
        }
        return PlatformDependent.newMpscQueue(i6);
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected Queue<Runnable> newTaskQueue(int i6) {
        return newTaskQueue0(i6);
    }
}
