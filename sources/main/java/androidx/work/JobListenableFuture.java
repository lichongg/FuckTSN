package androidx.work;

import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class JobListenableFuture<R> implements ListenableFuture<R> {

    @NotNull
    private final e2 job;

    @NotNull
    private final SettableFuture<R> underlying;

    public JobListenableFuture(@NotNull e2 job, @NotNull SettableFuture<R> underlying) {
        g0.p(job, "job");
        g0.p(underlying, "underlying");
        this.job = job;
        this.underlying = underlying;
        job.k(new Function1<Throwable, n1>(this) { // from class: androidx.work.JobListenableFuture.1
            final /* synthetic */ JobListenableFuture<R> this$0;

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
                invoke2(th);
                return n1.f44123a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                if (th == null) {
                    if (!((JobListenableFuture) this.this$0).underlying.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                } else {
                    if (th instanceof CancellationException) {
                        ((JobListenableFuture) this.this$0).underlying.cancel(true);
                        return;
                    }
                    SettableFuture settableFuture = ((JobListenableFuture) this.this$0).underlying;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    settableFuture.setException(th);
                }
            }
        });
    }

    @Override // java.util.concurrent.Future
    public R get() {
        return this.underlying.get();
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.underlying.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z5) {
        return this.underlying.cancel(z5);
    }

    public final void complete(R r5) {
        this.underlying.set(r5);
    }

    @Override // java.util.concurrent.Future
    public R get(long j6, TimeUnit timeUnit) {
        return this.underlying.get(j6, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.underlying.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.underlying.isDone();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ JobListenableFuture(kotlinx.coroutines.e2 r1, androidx.work.impl.utils.futures.SettableFuture r2, int r3, kotlin.jvm.internal.v r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto Ld
            androidx.work.impl.utils.futures.SettableFuture r2 = androidx.work.impl.utils.futures.SettableFuture.create()
            java.lang.String r3 = "create()"
            kotlin.jvm.internal.g0.o(r2, r3)
        Ld:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.JobListenableFuture.<init>(kotlinx.coroutines.e2, androidx.work.impl.utils.futures.SettableFuture, int, kotlin.jvm.internal.v):void");
    }
}
