package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import okhttp3.internal._UtilJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue\n+ 2 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n+ 3 TaskLogger.kt\nokhttp3/internal/concurrent/TaskLoggerKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,241:1\n63#2:242\n63#2:243\n63#2:252\n49#2,4:268\n63#2:272\n49#2,4:273\n63#2:277\n26#3,4:244\n26#3,4:248\n26#3,4:253\n26#3,4:257\n26#3,4:278\n360#4,7:261\n*S KotlinDebug\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue\n*L\n48#1:242\n64#1:243\n122#1:252\n202#1:268,4\n204#1:272\n212#1:273,4\n214#1:277\n67#1:244,4\n70#1:248,4\n173#1:253,4\n179#1:257,4\n231#1:278,4\n188#1:261,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class TaskQueue {

    @Nullable
    private Task activeTask;
    private boolean cancelActiveTask;

    @NotNull
    private final List<Task> futureTasks;

    @NotNull
    private final String name;
    private boolean shutdown;

    @NotNull
    private final TaskRunner taskRunner;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class AwaitIdleTask extends Task {

        @NotNull
        private final CountDownLatch latch;

        public AwaitIdleTask() {
            super(_UtilJvmKt.okHttpName + " awaitIdle", false);
            this.latch = new CountDownLatch(1);
        }

        @NotNull
        public final CountDownLatch getLatch() {
            return this.latch;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.latch.countDown();
            return -1L;
        }
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j6, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j6 = 0;
        }
        taskQueue.schedule(task, j6);
    }

    public final void schedule(@NotNull Task task, long j6) {
        g0.p(task, "task");
        synchronized (this.taskRunner) {
            if (!this.shutdown) {
                if (scheduleAndDecide$okhttp(task, j6, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                n1 n1Var = n1.f44123a;
            } else if (task.getCancelable()) {
                Logger logger$okhttp = this.taskRunner.getLogger$okhttp();
                if (logger$okhttp.isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(logger$okhttp, task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                Logger logger$okhttp2 = this.taskRunner.getLogger$okhttp();
                if (logger$okhttp2.isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(logger$okhttp2, task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public TaskQueue(@NotNull TaskRunner taskRunner, @NotNull String name) {
        g0.p(taskRunner, "taskRunner");
        g0.p(name, "name");
        this.taskRunner = taskRunner;
        this.name = name;
        this.futureTasks = new ArrayList();
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String str, long j6, boolean z5, Function0 function0, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j6 = 0;
        }
        taskQueue.execute(str, j6, (i6 & 4) != 0 ? true : z5, function0);
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String str, long j6, Function0 function0, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j6 = 0;
        }
        taskQueue.schedule(str, j6, function0);
    }

    public final void cancelAll() {
        TaskRunner taskRunner = this.taskRunner;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(taskRunner)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + taskRunner);
        }
        synchronized (this.taskRunner) {
            try {
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null) {
            g0.m(task);
            if (task.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean z5 = false;
        for (int size = this.futureTasks.size() - 1; -1 < size; size--) {
            if (this.futureTasks.get(size).getCancelable()) {
                Logger logger$okhttp = this.taskRunner.getLogger$okhttp();
                Task task2 = this.futureTasks.get(size);
                if (logger$okhttp.isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(logger$okhttp, task2, this, "canceled");
                }
                this.futureTasks.remove(size);
                z5 = true;
            }
        }
        return z5;
    }

    public final void execute(@NotNull final String name, long j6, final boolean z5, @NotNull final Function0<n1> block) {
        g0.p(name, "name");
        g0.p(block, "block");
        schedule(new Task(name, z5) { // from class: okhttp3.internal.concurrent.TaskQueue$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                block.invoke();
                return -1L;
            }
        }, j6);
    }

    @Nullable
    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    @NotNull
    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    @NotNull
    public final String getName$okhttp() {
        return this.name;
    }

    @NotNull
    public final List<Task> getScheduledTasks() {
        List<Task> a6;
        synchronized (this.taskRunner) {
            a6 = f0.a6(this.futureTasks);
        }
        return a6;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    @NotNull
    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    @NotNull
    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (this.activeTask == null && this.futureTasks.isEmpty()) {
                return new CountDownLatch(0);
            }
            Task task = this.activeTask;
            if (task instanceof AwaitIdleTask) {
                return ((AwaitIdleTask) task).getLatch();
            }
            for (Task task2 : this.futureTasks) {
                if (task2 instanceof AwaitIdleTask) {
                    return ((AwaitIdleTask) task2).getLatch();
                }
            }
            AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
            if (scheduleAndDecide$okhttp(awaitIdleTask, 0L, false)) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            return awaitIdleTask.getLatch();
        }
    }

    public final boolean scheduleAndDecide$okhttp(@NotNull Task task, long j6, boolean z5) {
        String str;
        g0.p(task, "task");
        task.initQueue$okhttp(this);
        long nanoTime = this.taskRunner.getBackend().nanoTime();
        long j7 = nanoTime + j6;
        int indexOf = this.futureTasks.indexOf(task);
        if (indexOf != -1) {
            if (task.getNextExecuteNanoTime$okhttp() <= j7) {
                Logger logger$okhttp = this.taskRunner.getLogger$okhttp();
                if (logger$okhttp.isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(logger$okhttp, task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(indexOf);
        }
        task.setNextExecuteNanoTime$okhttp(j7);
        Logger logger$okhttp2 = this.taskRunner.getLogger$okhttp();
        if (logger$okhttp2.isLoggable(Level.FINE)) {
            if (z5) {
                str = "run again after " + TaskLoggerKt.formatDuration(j7 - nanoTime);
            } else {
                str = "scheduled after " + TaskLoggerKt.formatDuration(j7 - nanoTime);
            }
            TaskLoggerKt.log(logger$okhttp2, task, this, str);
        }
        Iterator<Task> it = this.futureTasks.iterator();
        int i6 = 0;
        while (true) {
            if (!it.hasNext()) {
                i6 = -1;
                break;
            }
            if (it.next().getNextExecuteNanoTime$okhttp() - nanoTime > j6) {
                break;
            }
            i6++;
        }
        if (i6 == -1) {
            i6 = this.futureTasks.size();
        }
        this.futureTasks.add(i6, task);
        return i6 == 0;
    }

    public final void setActiveTask$okhttp(@Nullable Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean z5) {
        this.cancelActiveTask = z5;
    }

    public final void setShutdown$okhttp(boolean z5) {
        this.shutdown = z5;
    }

    public final void shutdown() {
        TaskRunner taskRunner = this.taskRunner;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(taskRunner)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + taskRunner);
        }
        synchronized (this.taskRunner) {
            try {
                this.shutdown = true;
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NotNull
    public String toString() {
        return this.name;
    }

    public final void schedule(@NotNull final String name, long j6, @NotNull final Function0<Long> block) {
        g0.p(name, "name");
        g0.p(block, "block");
        schedule(new Task(name) { // from class: okhttp3.internal.concurrent.TaskQueue$schedule$2
            {
                int i6 = 2;
                v vVar = null;
                boolean z5 = false;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return block.invoke().longValue();
            }
        }, j6);
    }
}
