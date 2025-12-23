package io.netty.channel.nio;

import io.netty.channel.ChannelException;
import io.netty.channel.EventLoopException;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.util.IntSupplier;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReflectionUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class NioEventLoop extends SingleThreadEventLoop {
    private static final int CLEANUP_INTERVAL = 256;
    private static final int MIN_PREMATURE_SELECTOR_RETURNS = 3;
    private static final int SELECTOR_AUTO_REBUILD_THRESHOLD;
    private int cancelledKeys;
    private volatile int ioRatio;
    private boolean needsToSelectAgain;
    private final SelectorProvider provider;
    private final IntSupplier selectNowSupplier;
    private final SelectStrategy selectStrategy;
    private SelectedSelectionKeySet selectedKeys;
    private Selector selector;
    private Selector unwrappedSelector;
    private final AtomicBoolean wakenUp;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioEventLoop.class);
    private static final boolean DISABLE_KEY_SET_OPTIMIZATION = SystemPropertyUtil.getBoolean("io.netty.noKeySetOptimization", false);

    private static Queue<Runnable> newTaskQueue(EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        return eventLoopTaskQueueFactory == null ? newTaskQueue0(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS) : eventLoopTaskQueueFactory.newTaskQueue(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS);
    }

    private void processSelectedKey(SelectionKey selectionKey, AbstractNioChannel abstractNioChannel) {
        AbstractNioChannel.NioUnsafe unsafe = abstractNioChannel.unsafe();
        if (!selectionKey.isValid()) {
            try {
                NioEventLoop eventLoop = abstractNioChannel.eventLoop();
                if (eventLoop != this || eventLoop == null) {
                    return;
                }
                unsafe.close(unsafe.voidPromise());
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        try {
            int readyOps = selectionKey.readyOps();
            if ((readyOps & 8) != 0) {
                selectionKey.interestOps(selectionKey.interestOps() & (-9));
                unsafe.finishConnect();
            }
            if ((readyOps & 4) != 0) {
                abstractNioChannel.unsafe().forceFlush();
            }
            if ((readyOps & 17) == 0 && readyOps != 0) {
                return;
            }
            unsafe.read();
        } catch (CancelledKeyException unused2) {
            unsafe.close(unsafe.voidPromise());
        }
    }

    private void processSelectedKeysOptimized() {
        int i6 = 0;
        while (true) {
            SelectedSelectionKeySet selectedSelectionKeySet = this.selectedKeys;
            if (i6 >= selectedSelectionKeySet.size) {
                return;
            }
            SelectionKey[] selectionKeyArr = selectedSelectionKeySet.keys;
            SelectionKey selectionKey = selectionKeyArr[i6];
            selectionKeyArr[i6] = null;
            Object attachment = selectionKey.attachment();
            if (attachment instanceof AbstractNioChannel) {
                processSelectedKey(selectionKey, (AbstractNioChannel) attachment);
            } else {
                processSelectedKey(selectionKey, (NioTask<SelectableChannel>) attachment);
            }
            if (this.needsToSelectAgain) {
                this.selectedKeys.reset(i6 + 1);
                selectAgain();
                i6 = -1;
            }
            i6++;
        }
    }

    private void selectAgain() {
        this.needsToSelectAgain = false;
        try {
            this.selector.selectNow();
        } catch (Throwable th) {
            logger.warn("Failed to update SelectionKeys.", th);
        }
    }

    static {
        if (SystemPropertyUtil.get("sun.nio.ch.bugLevel") == null) {
            try {
                AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: io.netty.channel.nio.NioEventLoop.2
                    @Override // java.security.PrivilegedAction
                    public Void run() {
                        System.setProperty("sun.nio.ch.bugLevel", "");
                        return null;
                    }
                });
            } catch (SecurityException e6) {
                logger.debug("Unable to get/set System Property: sun.nio.ch.bugLevel", (Throwable) e6);
            }
        }
        int i6 = SystemPropertyUtil.getInt("io.netty.selectorAutoRebuildThreshold", 512);
        int i7 = i6 >= 3 ? i6 : 0;
        SELECTOR_AUTO_REBUILD_THRESHOLD = i7;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("-Dio.netty.noKeySetOptimization: {}", Boolean.valueOf(DISABLE_KEY_SET_OPTIMIZATION));
            internalLogger.debug("-Dio.netty.selectorAutoRebuildThreshold: {}", Integer.valueOf(i7));
        }
    }

    private static void handleLoopException(Throwable th) {
        logger.warn("Unexpected exception in the selector loop.", th);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException unused) {
        }
    }

    private SelectorTuple openSelector() {
        try {
            final AbstractSelector openSelector = this.provider.openSelector();
            if (DISABLE_KEY_SET_OPTIMIZATION) {
                return new SelectorTuple(openSelector);
            }
            Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.channel.nio.NioEventLoop.3
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        return Class.forName("sun.nio.ch.SelectorImpl", false, PlatformDependent.getSystemClassLoader());
                    } catch (Throwable th) {
                        return th;
                    }
                }
            });
            if (doPrivileged instanceof Class) {
                final Class cls = (Class) doPrivileged;
                if (cls.isAssignableFrom(openSelector.getClass())) {
                    final SelectedSelectionKeySet selectedSelectionKeySet = new SelectedSelectionKeySet();
                    Object doPrivileged2 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.channel.nio.NioEventLoop.4
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            try {
                                Field declaredField = cls.getDeclaredField("selectedKeys");
                                Field declaredField2 = cls.getDeclaredField("publicSelectedKeys");
                                if (PlatformDependent.javaVersion() >= 9 && PlatformDependent.hasUnsafe()) {
                                    long objectFieldOffset = PlatformDependent.objectFieldOffset(declaredField);
                                    long objectFieldOffset2 = PlatformDependent.objectFieldOffset(declaredField2);
                                    if (objectFieldOffset != -1 && objectFieldOffset2 != -1) {
                                        PlatformDependent.putObject(openSelector, objectFieldOffset, selectedSelectionKeySet);
                                        PlatformDependent.putObject(openSelector, objectFieldOffset2, selectedSelectionKeySet);
                                        return null;
                                    }
                                }
                                Throwable trySetAccessible = ReflectionUtil.trySetAccessible(declaredField, true);
                                if (trySetAccessible != null) {
                                    return trySetAccessible;
                                }
                                Throwable trySetAccessible2 = ReflectionUtil.trySetAccessible(declaredField2, true);
                                if (trySetAccessible2 != null) {
                                    return trySetAccessible2;
                                }
                                declaredField.set(openSelector, selectedSelectionKeySet);
                                declaredField2.set(openSelector, selectedSelectionKeySet);
                                return null;
                            } catch (IllegalAccessException e6) {
                                e = e6;
                                return e;
                            } catch (NoSuchFieldException e7) {
                                e = e7;
                                return e;
                            }
                        }
                    });
                    if (!(doPrivileged2 instanceof Exception)) {
                        this.selectedKeys = selectedSelectionKeySet;
                        logger.trace("instrumented a special java.util.Set into: {}", openSelector);
                        return new SelectorTuple(openSelector, new SelectedSelectionKeySetSelector(openSelector, selectedSelectionKeySet));
                    }
                    this.selectedKeys = null;
                    logger.trace("failed to instrument a special java.util.Set into: {}", openSelector, (Exception) doPrivileged2);
                    return new SelectorTuple(openSelector);
                }
            }
            if (doPrivileged instanceof Throwable) {
                logger.trace("failed to instrument a special java.util.Set into: {}", openSelector, (Throwable) doPrivileged);
            }
            return new SelectorTuple(openSelector);
        } catch (IOException e6) {
            throw new ChannelException("failed to open a new selector", e6);
        }
    }

    private void processSelectedKeys() {
        if (this.selectedKeys != null) {
            processSelectedKeysOptimized();
        } else {
            processSelectedKeysPlain(this.selector.selectedKeys());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rebuildSelector0() {
        Selector selector = this.selector;
        if (selector == null) {
            return;
        }
        try {
            SelectorTuple openSelector = openSelector();
            int i6 = 0;
            for (SelectionKey selectionKey : selector.keys()) {
                Object attachment = selectionKey.attachment();
                try {
                    if (selectionKey.isValid() && selectionKey.channel().keyFor(openSelector.unwrappedSelector) == null) {
                        int interestOps = selectionKey.interestOps();
                        selectionKey.cancel();
                        SelectionKey register = selectionKey.channel().register(openSelector.unwrappedSelector, interestOps, attachment);
                        if (attachment instanceof AbstractNioChannel) {
                            ((AbstractNioChannel) attachment).selectionKey = register;
                        }
                        i6++;
                    }
                } catch (Exception e6) {
                    logger.warn("Failed to re-register a Channel to the new Selector.", (Throwable) e6);
                    if (attachment instanceof AbstractNioChannel) {
                        AbstractNioChannel abstractNioChannel = (AbstractNioChannel) attachment;
                        abstractNioChannel.unsafe().close(abstractNioChannel.unsafe().voidPromise());
                    } else {
                        invokeChannelUnregistered((NioTask) attachment, selectionKey, e6);
                    }
                }
            }
            this.selector = openSelector.selector;
            this.unwrappedSelector = openSelector.unwrappedSelector;
            try {
                selector.close();
            } catch (Throwable th) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Failed to close the old Selector.", th);
                }
            }
            InternalLogger internalLogger = logger;
            if (internalLogger.isInfoEnabled()) {
                internalLogger.info("Migrated " + i6 + " channel(s) to the new Selector.");
            }
        } catch (Exception e7) {
            logger.warn("Failed to create a new Selector.", (Throwable) e7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void register0(SelectableChannel selectableChannel, int i6, NioTask<?> nioTask) {
        try {
            selectableChannel.register(this.unwrappedSelector, i6, nioTask);
        } catch (Exception e6) {
            throw new EventLoopException("failed to register a channel", e6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void select(boolean r14) throws java.io.IOException {
        /*
            r13 = this;
            java.nio.channels.Selector r0 = r13.selector
            long r1 = java.lang.System.nanoTime()     // Catch: java.nio.channels.CancelledKeyException -> L26
            long r3 = r13.delayNanos(r1)     // Catch: java.nio.channels.CancelledKeyException -> L26
            long r3 = r3 + r1
            r5 = 0
            r6 = 0
        Ld:
            long r7 = r3 - r1
            r9 = 500000(0x7a120, double:2.47033E-318)
            long r7 = r7 + r9
            r9 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r7 / r9
            r9 = 0
            r11 = 1
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 > 0) goto L29
            if (r6 != 0) goto L8d
            r0.selectNow()     // Catch: java.nio.channels.CancelledKeyException -> L26
        L23:
            r6 = 1
            goto L8d
        L26:
            r14 = move-exception
            goto La3
        L29:
            boolean r9 = r13.hasTasks()     // Catch: java.nio.channels.CancelledKeyException -> L26
            if (r9 == 0) goto L3b
            java.util.concurrent.atomic.AtomicBoolean r9 = r13.wakenUp     // Catch: java.nio.channels.CancelledKeyException -> L26
            boolean r9 = r9.compareAndSet(r5, r11)     // Catch: java.nio.channels.CancelledKeyException -> L26
            if (r9 == 0) goto L3b
            r0.selectNow()     // Catch: java.nio.channels.CancelledKeyException -> L26
            goto L23
        L3b:
            int r9 = r0.select(r7)     // Catch: java.nio.channels.CancelledKeyException -> L26
            int r6 = r6 + 1
            if (r9 != 0) goto L8d
            if (r14 != 0) goto L8d
            java.util.concurrent.atomic.AtomicBoolean r9 = r13.wakenUp     // Catch: java.nio.channels.CancelledKeyException -> L26
            boolean r9 = r9.get()     // Catch: java.nio.channels.CancelledKeyException -> L26
            if (r9 != 0) goto L8d
            boolean r9 = r13.hasTasks()     // Catch: java.nio.channels.CancelledKeyException -> L26
            if (r9 != 0) goto L8d
            boolean r9 = r13.hasScheduledTasks()     // Catch: java.nio.channels.CancelledKeyException -> L26
            if (r9 == 0) goto L5a
            goto L8d
        L5a:
            boolean r9 = java.lang.Thread.interrupted()     // Catch: java.nio.channels.CancelledKeyException -> L26
            if (r9 == 0) goto L6e
            io.netty.util.internal.logging.InternalLogger r14 = io.netty.channel.nio.NioEventLoop.logger     // Catch: java.nio.channels.CancelledKeyException -> L26
            boolean r1 = r14.isDebugEnabled()     // Catch: java.nio.channels.CancelledKeyException -> L26
            if (r1 == 0) goto L23
            java.lang.String r1 = "Selector.select() returned prematurely because Thread.currentThread().interrupt() was called. Use NioEventLoop.shutdownGracefully() to shutdown the NioEventLoop."
            r14.debug(r1)     // Catch: java.nio.channels.CancelledKeyException -> L26
            goto L23
        L6e:
            long r9 = java.lang.System.nanoTime()     // Catch: java.nio.channels.CancelledKeyException -> L26
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.nio.channels.CancelledKeyException -> L26
            long r7 = r12.toNanos(r7)     // Catch: java.nio.channels.CancelledKeyException -> L26
            long r7 = r9 - r7
            int r12 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r12 < 0) goto L80
            r6 = 1
            goto L8b
        L80:
            int r1 = io.netty.channel.nio.NioEventLoop.SELECTOR_AUTO_REBUILD_THRESHOLD     // Catch: java.nio.channels.CancelledKeyException -> L26
            if (r1 <= 0) goto L8b
            if (r6 < r1) goto L8b
            java.nio.channels.Selector r0 = r13.selectRebuildSelector(r6)     // Catch: java.nio.channels.CancelledKeyException -> L26
            goto L23
        L8b:
            r1 = r9
            goto Ld
        L8d:
            r14 = 3
            if (r6 <= r14) goto Lc5
            io.netty.util.internal.logging.InternalLogger r14 = io.netty.channel.nio.NioEventLoop.logger     // Catch: java.nio.channels.CancelledKeyException -> L26
            boolean r1 = r14.isDebugEnabled()     // Catch: java.nio.channels.CancelledKeyException -> L26
            if (r1 == 0) goto Lc5
            java.lang.String r1 = "Selector.select() returned prematurely {} times in a row for Selector {}."
            int r6 = r6 - r11
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch: java.nio.channels.CancelledKeyException -> L26
            r14.debug(r1, r2, r0)     // Catch: java.nio.channels.CancelledKeyException -> L26
            return
        La3:
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.channel.nio.NioEventLoop.logger
            boolean r2 = r1.isDebugEnabled()
            if (r2 == 0) goto Lc5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class<java.nio.channels.CancelledKeyException> r3 = java.nio.channels.CancelledKeyException.class
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            java.lang.String r3 = " raised by a Selector {} - JDK bug?"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.debug(r2, r0, r14)
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.NioEventLoop.select(boolean):void");
    }

    private Selector selectRebuildSelector(int i6) throws IOException {
        logger.warn("Selector.select() returned prematurely {} times in a row; rebuilding Selector {}.", Integer.valueOf(i6), this.selector);
        rebuildSelector();
        Selector selector = this.selector;
        selector.selectNow();
        return selector;
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void cleanup() {
        try {
            this.selector.close();
        } catch (IOException e6) {
            logger.warn("Failed to close a selector.", (Throwable) e6);
        }
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    public void register(final SelectableChannel selectableChannel, final int i6, final NioTask<?> nioTask) {
        if (selectableChannel == null) {
            throw new NullPointerException("ch");
        }
        if (i6 == 0) {
            throw new IllegalArgumentException("interestOps must be non-zero.");
        }
        if (((~selectableChannel.validOps()) & i6) != 0) {
            throw new IllegalArgumentException("invalid interestOps: " + i6 + "(validOps: " + selectableChannel.validOps() + ')');
        }
        if (nioTask == null) {
            throw new NullPointerException("task");
        }
        if (isShutdown()) {
            throw new IllegalStateException("event loop shut down");
        }
        if (inEventLoop()) {
            register0(selectableChannel, i6, nioTask);
            return;
        }
        try {
            submit(new Runnable() { // from class: io.netty.channel.nio.NioEventLoop.5
                @Override // java.lang.Runnable
                public void run() {
                    NioEventLoop.this.register0(selectableChannel, i6, nioTask);
                }
            }).sync();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // io.netty.channel.SingleThreadEventLoop
    public int registeredChannels() {
        return this.selector.keys().size() - this.cancelledKeys;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:1|2|4|(1:51)(2:6|(2:50|31)(3:8|9|(11:11|12|13|(8:40|41|42|19|20|22|(3:24|25|(2:27|28)(1:30))(1:32)|31)(9:15|16|17|18|19|20|22|(0)(0)|31)|55|56|19|20|22|(0)(0)|31)))|47|(1:49)|12|13|(0)(0)|55|56|19|20|22|(0)(0)|31) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008b, code lost:
    
        handleLoopException(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048 A[Catch: all -> 0x002e, TRY_LEAVE, TryCatch #3 {all -> 0x002e, blocks: (B:2:0x0000, B:12:0x0032, B:42:0x003f, B:15:0x0048, B:18:0x004f, B:38:0x0060, B:39:0x006f, B:45:0x0044, B:46:0x0047, B:47:0x0017, B:49:0x0028, B:53:0x0070, B:41:0x003c, B:17:0x004c), top: B:1:0x0000, inners: #0, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0000 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void run() {
        /*
            r6 = this;
        L0:
            io.netty.channel.SelectStrategy r0 = r6.selectStrategy     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            io.netty.util.IntSupplier r1 = r6.selectNowSupplier     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            boolean r2 = r6.hasTasks()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            int r0 = r0.calculateStrategy(r1, r2)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            r1 = -3
            r2 = 0
            if (r0 == r1) goto L17
            r1 = -2
            if (r0 == r1) goto L0
            r1 = -1
            if (r0 == r1) goto L17
            goto L32
        L17:
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.wakenUp     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            boolean r0 = r0.getAndSet(r2)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            r6.select(r0)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.wakenUp     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            boolean r0 = r0.get()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            if (r0 == 0) goto L32
            java.nio.channels.Selector r0 = r6.selector     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            r0.wakeup()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            goto L32
        L2e:
            r0 = move-exception
            goto L77
        L30:
            r0 = move-exception
            goto L70
        L32:
            r6.cancelledKeys = r2     // Catch: java.lang.Throwable -> L2e
            r6.needsToSelectAgain = r2     // Catch: java.lang.Throwable -> L2e
            int r0 = r6.ioRatio     // Catch: java.lang.Throwable -> L2e
            r1 = 100
            if (r0 != r1) goto L48
            r6.processSelectedKeys()     // Catch: java.lang.Throwable -> L43
            r6.runAllTasks()     // Catch: java.lang.Throwable -> L2e
            goto L7a
        L43:
            r0 = move-exception
            r6.runAllTasks()     // Catch: java.lang.Throwable -> L2e
            throw r0     // Catch: java.lang.Throwable -> L2e
        L48:
            long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L2e
            r6.processSelectedKeys()     // Catch: java.lang.Throwable -> L5f
            long r3 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L2e
            long r3 = r3 - r1
            int r1 = 100 - r0
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L2e
            long r3 = r3 * r1
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L2e
            long r3 = r3 / r0
            r6.runAllTasks(r3)     // Catch: java.lang.Throwable -> L2e
            goto L7a
        L5f:
            r3 = move-exception
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L2e
            long r4 = r4 - r1
            int r1 = 100 - r0
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L2e
            long r4 = r4 * r1
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L2e
            long r4 = r4 / r0
            r6.runAllTasks(r4)     // Catch: java.lang.Throwable -> L2e
            throw r3     // Catch: java.lang.Throwable -> L2e
        L70:
            r6.rebuildSelector0()     // Catch: java.lang.Throwable -> L2e
            handleLoopException(r0)     // Catch: java.lang.Throwable -> L2e
            goto L0
        L77:
            handleLoopException(r0)
        L7a:
            boolean r0 = r6.isShuttingDown()     // Catch: java.lang.Throwable -> L8a
            if (r0 == 0) goto L0
            r6.closeAll()     // Catch: java.lang.Throwable -> L8a
            boolean r0 = r6.confirmShutdown()     // Catch: java.lang.Throwable -> L8a
            if (r0 == 0) goto L0
            return
        L8a:
            r0 = move-exception
            handleLoopException(r0)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.NioEventLoop.run():void");
    }

    int selectNow() throws IOException {
        try {
            return this.selector.selectNow();
        } finally {
            if (this.wakenUp.get()) {
                this.selector.wakeup();
            }
        }
    }

    public SelectorProvider selectorProvider() {
        return this.provider;
    }

    public void setIoRatio(int i6) {
        if (i6 > 0 && i6 <= 100) {
            this.ioRatio = i6;
            return;
        }
        throw new IllegalArgumentException("ioRatio: " + i6 + " (expected: 0 < ioRatio <= 100)");
    }

    Selector unwrappedSelector() {
        return this.unwrappedSelector;
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void wakeup(boolean z5) {
        if (z5 || !this.wakenUp.compareAndSet(false, true)) {
            return;
        }
        this.selector.wakeup();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class SelectorTuple {
        final Selector selector;
        final Selector unwrappedSelector;

        SelectorTuple(Selector selector) {
            this.unwrappedSelector = selector;
            this.selector = selector;
        }

        SelectorTuple(Selector selector, Selector selector2) {
            this.unwrappedSelector = selector;
            this.selector = selector2;
        }
    }

    NioEventLoop(NioEventLoopGroup nioEventLoopGroup, Executor executor, SelectorProvider selectorProvider, SelectStrategy selectStrategy, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        super(nioEventLoopGroup, executor, false, newTaskQueue(eventLoopTaskQueueFactory), newTaskQueue(eventLoopTaskQueueFactory), rejectedExecutionHandler);
        this.selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.nio.NioEventLoop.1
            @Override // io.netty.util.IntSupplier
            public int get() throws Exception {
                return NioEventLoop.this.selectNow();
            }
        };
        this.wakenUp = new AtomicBoolean();
        this.ioRatio = 50;
        if (selectorProvider != null) {
            if (selectStrategy != null) {
                this.provider = selectorProvider;
                SelectorTuple openSelector = openSelector();
                this.selector = openSelector.selector;
                this.unwrappedSelector = openSelector.unwrappedSelector;
                this.selectStrategy = selectStrategy;
                return;
            }
            throw new NullPointerException("selectStrategy");
        }
        throw new NullPointerException("selectorProvider");
    }

    private void closeAll() {
        selectAgain();
        Set<SelectionKey> keys = this.selector.keys();
        ArrayList<AbstractNioChannel> arrayList = new ArrayList(keys.size());
        for (SelectionKey selectionKey : keys) {
            Object attachment = selectionKey.attachment();
            if (attachment instanceof AbstractNioChannel) {
                arrayList.add((AbstractNioChannel) attachment);
            } else {
                selectionKey.cancel();
                invokeChannelUnregistered((NioTask) attachment, selectionKey, null);
            }
        }
        for (AbstractNioChannel abstractNioChannel : arrayList) {
            abstractNioChannel.unsafe().close(abstractNioChannel.unsafe().voidPromise());
        }
    }

    private static void invokeChannelUnregistered(NioTask<SelectableChannel> nioTask, SelectionKey selectionKey, Throwable th) {
        try {
            nioTask.channelUnregistered(selectionKey.channel(), th);
        } catch (Exception e6) {
            logger.warn("Unexpected exception while running NioTask.channelUnregistered()", (Throwable) e6);
        }
    }

    private static Queue<Runnable> newTaskQueue0(int i6) {
        if (i6 == Integer.MAX_VALUE) {
            return PlatformDependent.newMpscQueue();
        }
        return PlatformDependent.newMpscQueue(i6);
    }

    private void processSelectedKeysPlain(Set<SelectionKey> set) {
        if (!set.isEmpty()) {
            Iterator<SelectionKey> it = set.iterator();
            while (true) {
                SelectionKey next = it.next();
                Object attachment = next.attachment();
                it.remove();
                if (attachment instanceof AbstractNioChannel) {
                    processSelectedKey(next, (AbstractNioChannel) attachment);
                } else {
                    processSelectedKey(next, (NioTask<SelectableChannel>) attachment);
                }
                if (it.hasNext()) {
                    if (this.needsToSelectAgain) {
                        selectAgain();
                        Set<SelectionKey> selectedKeys = this.selector.selectedKeys();
                        if (selectedKeys.isEmpty()) {
                            return;
                        } else {
                            it = selectedKeys.iterator();
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    void cancel(SelectionKey selectionKey) {
        selectionKey.cancel();
        int i6 = this.cancelledKeys + 1;
        this.cancelledKeys = i6;
        if (i6 >= 256) {
            this.cancelledKeys = 0;
            this.needsToSelectAgain = true;
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected Queue<Runnable> newTaskQueue(int i6) {
        return newTaskQueue0(i6);
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected Runnable pollTask() {
        Runnable pollTask = super.pollTask();
        if (this.needsToSelectAgain) {
            selectAgain();
        }
        return pollTask;
    }

    public void rebuildSelector() {
        if (!inEventLoop()) {
            execute(new Runnable() { // from class: io.netty.channel.nio.NioEventLoop.6
                @Override // java.lang.Runnable
                public void run() {
                    NioEventLoop.this.rebuildSelector0();
                }
            });
        } else {
            rebuildSelector0();
        }
    }

    private static void processSelectedKey(SelectionKey selectionKey, NioTask<SelectableChannel> nioTask) {
        try {
            try {
                nioTask.channelReady(selectionKey.channel(), selectionKey);
                if (selectionKey.isValid()) {
                    return;
                }
                invokeChannelUnregistered(nioTask, selectionKey, null);
            } catch (Exception e6) {
                selectionKey.cancel();
                invokeChannelUnregistered(nioTask, selectionKey, e6);
            }
        } catch (Throwable th) {
            selectionKey.cancel();
            invokeChannelUnregistered(nioTask, selectionKey, null);
            throw th;
        }
    }
}
