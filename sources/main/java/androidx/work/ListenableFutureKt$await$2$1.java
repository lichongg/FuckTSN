package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.e;
import kotlin.g0;
import kotlinx.coroutines.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ListenableFutureKt$await$2$1 implements Runnable {
    final /* synthetic */ p<R> $cancellableContinuation;
    final /* synthetic */ ListenableFuture<R> $this_await;

    /* JADX WARN: Multi-variable type inference failed */
    public ListenableFutureKt$await$2$1(p<? super R> pVar, ListenableFuture<R> listenableFuture) {
        this.$cancellableContinuation = pVar;
        this.$this_await = listenableFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            e eVar = this.$cancellableContinuation;
            Object obj = this.$this_await.get();
            Result.a aVar = Result.Companion;
            eVar.resumeWith(Result.m130constructorimpl(obj));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                this.$cancellableContinuation.a(cause);
                return;
            }
            e eVar2 = this.$cancellableContinuation;
            Result.a aVar2 = Result.Companion;
            eVar2.resumeWith(Result.m130constructorimpl(g0.a(cause)));
        }
    }
}
