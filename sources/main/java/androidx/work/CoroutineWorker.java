package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.Deprecated;
import kotlin.coroutines.e;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {

    @NotNull
    private final m0 coroutineContext;

    @NotNull
    private final SettableFuture<ListenableWorker.Result> future;

    @NotNull
    private final b0 job;

    @Nullable
    public abstract Object doWork(@NotNull e<? super ListenableWorker.Result> eVar);

    @Override // androidx.work.ListenableWorker
    @NotNull
    public final ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        b0 c6;
        c6 = j2.c(null, 1, null);
        r0 a6 = s0.a(getCoroutineContext().plus(c6));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(c6, null, 2, null);
        k.f(a6, null, null, new CoroutineWorker$getForegroundInfoAsync$1(jobListenableFuture, this, null), 3, null);
        return jobListenableFuture;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(@NotNull Context appContext, @NotNull WorkerParameters params) {
        super(appContext, params);
        b0 c6;
        g0.p(appContext, "appContext");
        g0.p(params, "params");
        c6 = j2.c(null, 1, null);
        this.job = c6;
        SettableFuture<ListenableWorker.Result> create = SettableFuture.create();
        g0.o(create, "create()");
        this.future = create;
        create.addListener(new Runnable() { // from class: androidx.work.CoroutineWorker.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CoroutineWorker.this.getFuture$work_runtime_ktx_release().isCancelled()) {
                    e2.a.b(CoroutineWorker.this.getJob$work_runtime_ktx_release(), null, 1, null);
                }
            }
        }, getTaskExecutor().getBackgroundExecutor());
        this.coroutineContext = g1.a();
    }

    static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker, e eVar) {
        throw new IllegalStateException("Not implemented");
    }

    @NotNull
    public m0 getCoroutineContext() {
        return this.coroutineContext;
    }

    @NotNull
    public final SettableFuture<ListenableWorker.Result> getFuture$work_runtime_ktx_release() {
        return this.future;
    }

    @NotNull
    public final b0 getJob$work_runtime_ktx_release() {
        return this.job;
    }

    @Nullable
    public Object getForegroundInfo(@NotNull e<? super ForegroundInfo> eVar) {
        return getForegroundInfo$suspendImpl(this, eVar);
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    @Nullable
    public final Object setForeground(@NotNull ForegroundInfo foregroundInfo, @NotNull e<? super n1> eVar) {
        Object obj;
        ListenableFuture<Void> foregroundAsync = setForegroundAsync(foregroundInfo);
        g0.o(foregroundAsync, "setForegroundAsync(foregroundInfo)");
        if (foregroundAsync.isDone()) {
            try {
                obj = foregroundAsync.get();
            } catch (ExecutionException e6) {
                Throwable cause = e6.getCause();
                if (cause == null) {
                    throw e6;
                }
                throw cause;
            }
        } else {
            q qVar = new q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
            qVar.Q();
            foregroundAsync.addListener(new ListenableFutureKt$await$2$1(qVar, foregroundAsync), DirectExecutor.INSTANCE);
            obj = qVar.x();
            if (obj == kotlin.coroutines.intrinsics.a.l()) {
                kotlin.coroutines.jvm.internal.e.c(eVar);
            }
        }
        if (obj == kotlin.coroutines.intrinsics.a.l()) {
            return obj;
        }
        return n1.f44123a;
    }

    @Nullable
    public final Object setProgress(@NotNull Data data, @NotNull e<? super n1> eVar) {
        Object obj;
        ListenableFuture<Void> progressAsync = setProgressAsync(data);
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
            q qVar = new q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
            qVar.Q();
            progressAsync.addListener(new ListenableFutureKt$await$2$1(qVar, progressAsync), DirectExecutor.INSTANCE);
            obj = qVar.x();
            if (obj == kotlin.coroutines.intrinsics.a.l()) {
                kotlin.coroutines.jvm.internal.e.c(eVar);
            }
        }
        if (obj == kotlin.coroutines.intrinsics.a.l()) {
            return obj;
        }
        return n1.f44123a;
    }

    @Override // androidx.work.ListenableWorker
    @NotNull
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        k.f(s0.a(getCoroutineContext().plus(this.job)), null, null, new CoroutineWorker$startWork$1(this, null), 3, null);
        return this.future;
    }

    @Deprecated(message = "use withContext(...) inside doWork() instead.")
    public static /* synthetic */ void getCoroutineContext$annotations() {
    }
}
