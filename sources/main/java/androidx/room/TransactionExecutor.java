package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTransactionExecutor.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransactionExecutor.android.kt\nandroidx/room/TransactionExecutor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n1#2:59\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class TransactionExecutor implements Executor {

    @Nullable
    private Runnable active;

    @NotNull
    private final Executor executor;

    @NotNull
    private final Object syncLock;

    @NotNull
    private final ArrayDeque<Runnable> tasks;

    public TransactionExecutor(@NotNull Executor executor) {
        g0.p(executor, "executor");
        this.executor = executor;
        this.tasks = new ArrayDeque<>();
        this.syncLock = new Object();
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull final Runnable command) {
        g0.p(command, "command");
        synchronized (this.syncLock) {
            try {
                this.tasks.offer(new Runnable() { // from class: androidx.room.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        TransactionExecutor.execute$lambda$1$lambda$0(command, this);
                    }
                });
                if (this.active == null) {
                    scheduleNext();
                }
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void scheduleNext() {
        synchronized (this.syncLock) {
            try {
                Runnable poll = this.tasks.poll();
                Runnable runnable = poll;
                this.active = runnable;
                if (poll != null) {
                    this.executor.execute(runnable);
                }
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$1$lambda$0(Runnable runnable, TransactionExecutor transactionExecutor) {
        try {
            runnable.run();
        } finally {
            transactionExecutor.scheduleNext();
        }
    }
}
