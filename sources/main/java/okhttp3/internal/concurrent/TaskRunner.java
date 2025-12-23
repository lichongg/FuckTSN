package okhttp3.internal.concurrent;

import com.bykv.vk.component.ttvideo.player.C;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.f0;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTaskRunner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskRunner.kt\nokhttp3/internal/concurrent/TaskRunner\n+ 2 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n*L\n1#1,364:1\n55#2,4:365\n55#2,4:369\n55#2,4:373\n55#2,4:377\n55#2,4:381\n63#2:385\n63#2:386\n55#2,4:387\n*S KotlinDebug\n*F\n+ 1 TaskRunner.kt\nokhttp3/internal/concurrent/TaskRunner\n*L\n107#1:365,4\n125#1:369,4\n140#1:373,4\n171#1:377,4\n251#1:381,4\n259#1:385\n268#1:386\n274#1:387,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class TaskRunner implements Lockable {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final TaskRunner INSTANCE;

    @NotNull
    private static final Logger logger;

    @NotNull
    private final Backend backend;

    @NotNull
    private final List<TaskQueue> busyQueues;
    private boolean coordinatorWaiting;
    private long coordinatorWakeUpAt;
    private int executeCallCount;

    @NotNull
    private final Logger logger$1;
    private int nextQueueName;

    @NotNull
    private final List<TaskQueue> readyQueues;
    private int runCallCount;

    @NotNull
    private final Runnable runnable;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Backend {
        void coordinatorNotify(@NotNull TaskRunner taskRunner);

        void coordinatorWait(@NotNull TaskRunner taskRunner, long j6);

        @NotNull
        <T> BlockingQueue<T> decorate(@NotNull BlockingQueue<T> blockingQueue);

        void execute(@NotNull TaskRunner taskRunner, @NotNull Runnable runnable);

        long nanoTime();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Logger getLogger() {
            return TaskRunner.logger;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nTaskRunner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskRunner.kt\nokhttp3/internal/concurrent/TaskRunner$RealBackend\n+ 2 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n*L\n1#1,364:1\n36#2:365\n55#2,4:366\n41#2,6:370\n*S KotlinDebug\n*F\n+ 1 TaskRunner.kt\nokhttp3/internal/concurrent/TaskRunner$RealBackend\n*L\n324#1:365\n337#1:366,4\n339#1:370,6\n*E\n"})
    public static final class RealBackend implements Backend {

        @NotNull
        private final ThreadPoolExecutor executor;

        public RealBackend(@NotNull ThreadFactory threadFactory) {
            g0.p(threadFactory, "threadFactory");
            this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void coordinatorNotify(@NotNull TaskRunner taskRunner) {
            g0.p(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void coordinatorWait(@NotNull TaskRunner taskRunner, long j6) throws InterruptedException {
            g0.p(taskRunner, "taskRunner");
            if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(taskRunner)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + taskRunner);
            }
            if (j6 > 0) {
                long j7 = j6 / C.MICROS_PER_SECOND;
                long j8 = j6 - (C.MICROS_PER_SECOND * j7);
                if (j7 > 0 || j6 > 0) {
                    taskRunner.wait(j7, (int) j8);
                }
            }
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        @NotNull
        public <T> BlockingQueue<T> decorate(@NotNull BlockingQueue<T> queue) {
            g0.p(queue, "queue");
            return queue;
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void execute(@NotNull TaskRunner taskRunner, @NotNull Runnable runnable) {
            g0.p(taskRunner, "taskRunner");
            g0.p(runnable, "runnable");
            this.executor.execute(runnable);
        }

        @NotNull
        public final ThreadPoolExecutor getExecutor() {
            return this.executor;
        }

        public final void shutdown() {
            this.executor.shutdown();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public long nanoTime() {
            return System.nanoTime();
        }
    }

    public TaskRunner(@NotNull Backend backend, @NotNull Logger logger2) {
        g0.p(backend, "backend");
        g0.p(logger2, "logger");
        this.backend = backend;
        this.logger$1 = logger2;
        this.nextQueueName = 10000;
        this.busyQueues = new ArrayList();
        this.readyQueues = new ArrayList();
        this.runnable = new Runnable() { // from class: okhttp3.internal.concurrent.TaskRunner$runnable$1
            @Override // java.lang.Runnable
            public void run() {
                int i6;
                Task awaitTaskToRun;
                long j6;
                Task awaitTaskToRun2;
                TaskRunner taskRunner = TaskRunner.this;
                synchronized (taskRunner) {
                    i6 = taskRunner.runCallCount;
                    taskRunner.runCallCount = i6 + 1;
                    awaitTaskToRun = taskRunner.awaitTaskToRun();
                }
                if (awaitTaskToRun == null) {
                    return;
                }
                Thread currentThread = Thread.currentThread();
                String name = currentThread.getName();
                while (true) {
                    try {
                        currentThread.setName(awaitTaskToRun.getName());
                        Logger logger$okhttp = TaskRunner.this.getLogger$okhttp();
                        TaskQueue queue$okhttp = awaitTaskToRun.getQueue$okhttp();
                        g0.m(queue$okhttp);
                        boolean isLoggable = logger$okhttp.isLoggable(Level.FINE);
                        if (isLoggable) {
                            j6 = queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime();
                            TaskLoggerKt.log(logger$okhttp, awaitTaskToRun, queue$okhttp, "starting");
                        } else {
                            j6 = -1;
                        }
                        try {
                            long runOnce = awaitTaskToRun.runOnce();
                            if (isLoggable) {
                                TaskLoggerKt.log(logger$okhttp, awaitTaskToRun, queue$okhttp, "finished run in " + TaskLoggerKt.formatDuration(queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime() - j6));
                            }
                            TaskRunner taskRunner2 = TaskRunner.this;
                            synchronized (taskRunner2) {
                                taskRunner2.afterRun(awaitTaskToRun, runOnce, true);
                                awaitTaskToRun2 = taskRunner2.awaitTaskToRun();
                            }
                            if (awaitTaskToRun2 == null) {
                                return;
                            } else {
                                awaitTaskToRun = awaitTaskToRun2;
                            }
                        } catch (Throwable th) {
                            if (isLoggable) {
                                TaskLoggerKt.log(logger$okhttp, awaitTaskToRun, queue$okhttp, "failed a run in " + TaskLoggerKt.formatDuration(queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime() - j6));
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        try {
                            TaskRunner taskRunner3 = TaskRunner.this;
                            synchronized (taskRunner3) {
                                taskRunner3.afterRun(awaitTaskToRun, -1L, false);
                                n1 n1Var = n1.f44123a;
                                if (!(th2 instanceof InterruptedException)) {
                                    throw th2;
                                }
                                Thread.currentThread().interrupt();
                                return;
                            }
                        } finally {
                            currentThread.setName(name);
                        }
                    }
                }
            }
        };
    }

    @NotNull
    public final List<TaskQueue> activeQueues() {
        List<TaskQueue> I4;
        synchronized (this) {
            I4 = f0.I4(this.busyQueues, this.readyQueues);
        }
        return I4;
    }

    @NotNull
    public final TaskQueue newQueue() {
        int i6;
        synchronized (this) {
            i6 = this.nextQueueName;
            this.nextQueueName = i6 + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i6);
        return new TaskQueue(this, sb.toString());
    }

    static {
        Logger logger2 = Logger.getLogger(TaskRunner.class.getName());
        g0.o(logger2, "getLogger(...)");
        logger = logger2;
        INSTANCE = new TaskRunner(new RealBackend(_UtilJvmKt.threadFactory(_UtilJvmKt.okHttpName + " TaskRunner", true)), 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void afterRun(Task task, long j6, boolean z5) {
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        TaskQueue queue$okhttp = task.getQueue$okhttp();
        g0.m(queue$okhttp);
        if (queue$okhttp.getActiveTask$okhttp() != task) {
            throw new IllegalStateException("Check failed.");
        }
        boolean cancelActiveTask$okhttp = queue$okhttp.getCancelActiveTask$okhttp();
        queue$okhttp.setCancelActiveTask$okhttp(false);
        queue$okhttp.setActiveTask$okhttp(null);
        this.busyQueues.remove(queue$okhttp);
        if (j6 != -1 && !cancelActiveTask$okhttp && !queue$okhttp.getShutdown$okhttp()) {
            queue$okhttp.scheduleAndDecide$okhttp(task, j6, true);
        }
        if (queue$okhttp.getFutureTasks$okhttp().isEmpty()) {
            return;
        }
        this.readyQueues.add(queue$okhttp);
        if (z5) {
            return;
        }
        startAnotherThread();
    }

    private final void beforeRun(Task task) {
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        task.setNextExecuteNanoTime$okhttp(-1L);
        TaskQueue queue$okhttp = task.getQueue$okhttp();
        g0.m(queue$okhttp);
        queue$okhttp.getFutureTasks$okhttp().remove(task);
        this.readyQueues.remove(queue$okhttp);
        queue$okhttp.setActiveTask$okhttp(task);
        this.busyQueues.add(queue$okhttp);
    }

    private final void startAnotherThread() {
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(this)) {
            int i6 = this.executeCallCount;
            if (i6 > this.runCallCount) {
                return;
            }
            this.executeCallCount = i6 + 1;
            this.backend.execute(this, this.runnable);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    @Nullable
    public final Task awaitTaskToRun() {
        boolean z5;
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        while (!this.readyQueues.isEmpty()) {
            long nanoTime = this.backend.nanoTime();
            Iterator<TaskQueue> it = this.readyQueues.iterator();
            long j6 = Long.MAX_VALUE;
            Task task = null;
            while (true) {
                if (!it.hasNext()) {
                    z5 = false;
                    break;
                }
                Task task2 = it.next().getFutureTasks$okhttp().get(0);
                long max = Math.max(0L, task2.getNextExecuteNanoTime$okhttp() - nanoTime);
                if (max > 0) {
                    j6 = Math.min(max, j6);
                } else {
                    if (task != null) {
                        z5 = true;
                        break;
                    }
                    task = task2;
                }
            }
            if (task != null) {
                beforeRun(task);
                if (z5 || (!this.coordinatorWaiting && !this.readyQueues.isEmpty())) {
                    startAnotherThread();
                }
                return task;
            }
            if (this.coordinatorWaiting) {
                if (j6 < this.coordinatorWakeUpAt - nanoTime) {
                    this.backend.coordinatorNotify(this);
                }
                return null;
            }
            this.coordinatorWaiting = true;
            this.coordinatorWakeUpAt = nanoTime + j6;
            try {
                try {
                    this.backend.coordinatorWait(this, j6);
                } catch (InterruptedException unused) {
                    cancelAll();
                }
            } finally {
                this.coordinatorWaiting = false;
            }
        }
        return null;
    }

    public final void cancelAll() {
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        int size = this.busyQueues.size();
        while (true) {
            size--;
            if (-1 >= size) {
                break;
            } else {
                this.busyQueues.get(size).cancelAllAndDecide$okhttp();
            }
        }
        for (int size2 = this.readyQueues.size() - 1; -1 < size2; size2--) {
            TaskQueue taskQueue = this.readyQueues.get(size2);
            taskQueue.cancelAllAndDecide$okhttp();
            if (taskQueue.getFutureTasks$okhttp().isEmpty()) {
                this.readyQueues.remove(size2);
            }
        }
    }

    @NotNull
    public final Backend getBackend() {
        return this.backend;
    }

    @NotNull
    public final Logger getLogger$okhttp() {
        return this.logger$1;
    }

    public final void kickCoordinator$okhttp(@NotNull TaskQueue taskQueue) {
        g0.p(taskQueue, "taskQueue");
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (taskQueue.getActiveTask$okhttp() == null) {
            if (taskQueue.getFutureTasks$okhttp().isEmpty()) {
                this.readyQueues.remove(taskQueue);
            } else {
                _UtilCommonKt.addIfAbsent(this.readyQueues, taskQueue);
            }
        }
        if (this.coordinatorWaiting) {
            this.backend.coordinatorNotify(this);
        } else {
            startAnotherThread();
        }
    }

    public /* synthetic */ TaskRunner(Backend backend, Logger logger2, int i6, v vVar) {
        this(backend, (i6 & 2) != 0 ? logger : logger2);
    }
}
