package androidx.work;

import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.e;
import kotlin.jvm.internal.d0;
import kotlinx.coroutines.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ListenableFutureKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public static final <R> Object await(@NotNull ListenableFuture<R> listenableFuture, @NotNull e<? super R> eVar) {
        if (listenableFuture.isDone()) {
            try {
                return listenableFuture.get();
            } catch (ExecutionException e6) {
                Throwable cause = e6.getCause();
                if (cause == null) {
                    throw e6;
                }
                throw cause;
            }
        }
        q qVar = new q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        listenableFuture.addListener(new ListenableFutureKt$await$2$1(qVar, listenableFuture), DirectExecutor.INSTANCE);
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private static final <R> Object await$$forInline(ListenableFuture<R> listenableFuture, e<? super R> eVar) {
        if (listenableFuture.isDone()) {
            try {
                return listenableFuture.get();
            } catch (ExecutionException e6) {
                Throwable cause = e6.getCause();
                if (cause == null) {
                    throw e6;
                }
                throw cause;
            }
        }
        d0.e(0);
        q qVar = new q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        listenableFuture.addListener(new ListenableFutureKt$await$2$1(qVar, listenableFuture), DirectExecutor.INSTANCE);
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        d0.e(1);
        return x5;
    }
}
