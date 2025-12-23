package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class TaskLoggerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Logger logger, Task task, TaskQueue taskQueue, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.getName$okhttp());
        sb.append(' ');
        t0 t0Var = t0.f44062a;
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        g0.o(format, "format(...)");
        sb.append(format);
        sb.append(": ");
        sb.append(task.getName());
        logger.fine(sb.toString());
    }

    public static final <T> T logElapsed(@NotNull Logger logger, @NotNull Task task, @NotNull TaskQueue queue, @NotNull Function0<? extends T> block) {
        long j6;
        g0.p(logger, "<this>");
        g0.p(task, "task");
        g0.p(queue, "queue");
        g0.p(block, "block");
        boolean isLoggable = logger.isLoggable(Level.FINE);
        if (isLoggable) {
            j6 = queue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(logger, task, queue, "starting");
        } else {
            j6 = -1;
        }
        try {
            T invoke = block.invoke();
            d0.d(1);
            if (isLoggable) {
                log(logger, task, queue, "finished run in " + formatDuration(queue.getTaskRunner$okhttp().getBackend().nanoTime() - j6));
            }
            d0.c(1);
            return invoke;
        } catch (Throwable th) {
            d0.d(1);
            if (isLoggable) {
                log(logger, task, queue, "failed a run in " + formatDuration(queue.getTaskRunner$okhttp().getBackend().nanoTime() - j6));
            }
            d0.c(1);
            throw th;
        }
    }

    public static final void taskLog(@NotNull Logger logger, @NotNull Task task, @NotNull TaskQueue queue, @NotNull Function0<String> messageBlock) {
        g0.p(logger, "<this>");
        g0.p(task, "task");
        g0.p(queue, "queue");
        g0.p(messageBlock, "messageBlock");
        if (logger.isLoggable(Level.FINE)) {
            log(logger, task, queue, messageBlock.invoke());
        }
    }

    @NotNull
    public static final String formatDuration(long j6) {
        String str;
        if (j6 <= -999500000) {
            str = ((j6 - 500000000) / 1000000000) + " s ";
        } else if (j6 <= -999500) {
            str = ((j6 - 500000) / 1000000) + " ms";
        } else if (j6 <= 0) {
            str = ((j6 - 500) / 1000) + " µs";
        } else if (j6 < 999500) {
            str = ((j6 + 500) / 1000) + " µs";
        } else if (j6 < 999500000) {
            str = ((j6 + 500000) / 1000000) + " ms";
        } else {
            str = ((j6 + 500000000) / 1000000000) + " s ";
        }
        t0 t0Var = t0.f44062a;
        String format = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        g0.o(format, "format(...)");
        return format;
    }
}
