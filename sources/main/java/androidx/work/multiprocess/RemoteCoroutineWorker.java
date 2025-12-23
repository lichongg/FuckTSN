package androidx.work.multiprocess;

import android.content.Context;
import androidx.work.Data;
import androidx.work.DirectExecutor;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.Result;
import kotlin.coroutines.e;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;
import kotlinx.coroutines.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class RemoteCoroutineWorker extends RemoteListenableWorker {

    @NotNull
    private final SettableFuture<ListenableWorker.Result> future;

    @NotNull
    private final b0 job;

    @Nullable
    public abstract Object doRemoteWork(@NotNull e<? super ListenableWorker.Result> eVar);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteCoroutineWorker(@NotNull Context context, @NotNull WorkerParameters parameters) {
        super(context, parameters);
        b0 c6;
        g0.p(context, "context");
        g0.p(parameters, "parameters");
        c6 = j2.c(null, 1, null);
        this.job = c6;
        SettableFuture<ListenableWorker.Result> create = SettableFuture.create();
        g0.o(create, "create()");
        this.future = create;
        create.addListener(new Runnable() { // from class: androidx.work.multiprocess.RemoteCoroutineWorker.1
            @Override // java.lang.Runnable
            public final void run() {
                if (RemoteCoroutineWorker.this.future.isCancelled()) {
                    e2.a.b(RemoteCoroutineWorker.this.job, null, 1, null);
                }
            }
        }, getTaskExecutor().getBackgroundExecutor());
    }

    @Override // androidx.work.multiprocess.RemoteListenableWorker, androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(true);
    }

    @Nullable
    public final Object setProgress(@NotNull Data data, @NotNull e<? super n1> eVar) {
        Object obj;
        final ListenableFuture<Void> progressAsync = setProgressAsync(data);
        g0.o(progressAsync, "setProgressAsync(data)");
        if (progressAsync.isDone()) {
            try {
                obj = progressAsync.get();
            } catch (ExecutionException e6) {
                Throwable cause = e6.getCause();
                if (cause == null) {
                    throw e6;
                }
                throw cause;
            }
        } else {
            final q qVar = new q(a.e(eVar), 1);
            qVar.Q();
            progressAsync.addListener(new Runnable() { // from class: androidx.work.multiprocess.RemoteCoroutineWorker$setProgress$$inlined$await$1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        p pVar = p.this;
                        V v5 = progressAsync.get();
                        Result.a aVar = Result.Companion;
                        pVar.resumeWith(Result.m130constructorimpl(v5));
                    } catch (Throwable th) {
                        Throwable cause2 = th.getCause();
                        if (cause2 == null) {
                            cause2 = th;
                        }
                        if (th instanceof CancellationException) {
                            p.this.a(cause2);
                            return;
                        }
                        p pVar2 = p.this;
                        Result.a aVar2 = Result.Companion;
                        pVar2.resumeWith(Result.m130constructorimpl(kotlin.g0.a(cause2)));
                    }
                }
            }, DirectExecutor.INSTANCE);
            obj = qVar.x();
            if (obj == a.l()) {
                kotlin.coroutines.jvm.internal.e.c(eVar);
            }
        }
        if (obj == a.l()) {
            return obj;
        }
        return n1.f44123a;
    }

    @Override // androidx.work.multiprocess.RemoteListenableWorker
    @NotNull
    public ListenableFuture<ListenableWorker.Result> startRemoteWork() {
        k.f(s0.a(g1.a().plus(this.job)), null, null, new RemoteCoroutineWorker$startRemoteWork$1(this, null), 3, null);
        return this.future;
    }
}
