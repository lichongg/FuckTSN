package androidx.work;

import androidx.work.Operation;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.e;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.q;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class OperationKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object await(@org.jetbrains.annotations.NotNull androidx.work.Operation r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super androidx.work.Operation.State.SUCCESS> r5) {
        /*
            boolean r0 = r5 instanceof androidx.work.OperationKt$await$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.work.OperationKt$await$1 r0 = (androidx.work.OperationKt$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.work.OperationKt$await$1 r0 = new androidx.work.OperationKt$await$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.google.common.util.concurrent.ListenableFuture r4 = (com.google.common.util.concurrent.ListenableFuture) r4
            kotlin.g0.n(r5)
            goto L80
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.g0.n(r5)
            com.google.common.util.concurrent.ListenableFuture r4 = r4.getResult()
            java.lang.String r5 = "result"
            kotlin.jvm.internal.g0.o(r4, r5)
            boolean r5 = r4.isDone()
            if (r5 == 0) goto L56
            java.lang.Object r4 = r4.get()     // Catch: java.util.concurrent.ExecutionException -> L4c
            goto L81
        L4c:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L54
            goto L55
        L54:
            r4 = r5
        L55:
            throw r4
        L56:
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.q r5 = new kotlinx.coroutines.q
            kotlin.coroutines.e r2 = kotlin.coroutines.intrinsics.a.e(r0)
            r5.<init>(r2, r3)
            r5.Q()
            androidx.work.ListenableFutureKt$await$2$1 r2 = new androidx.work.ListenableFutureKt$await$2$1
            r2.<init>(r5, r4)
            androidx.work.DirectExecutor r3 = androidx.work.DirectExecutor.INSTANCE
            r4.addListener(r2, r3)
            java.lang.Object r5 = r5.x()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.a.l()
            if (r5 != r4) goto L7d
            kotlin.coroutines.jvm.internal.e.c(r0)
        L7d:
            if (r5 != r1) goto L80
            return r1
        L80:
            r4 = r5
        L81:
            java.lang.String r5 = "result.await()"
            kotlin.jvm.internal.g0.o(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.OperationKt.await(androidx.work.Operation, kotlin.coroutines.e):java.lang.Object");
    }

    private static final Object await$$forInline(Operation operation, e<? super Operation.State.SUCCESS> eVar) {
        Object obj;
        ListenableFuture<Operation.State.SUCCESS> result = operation.getResult();
        g0.o(result, "result");
        if (result.isDone()) {
            try {
                obj = result.get();
            } catch (ExecutionException e6) {
                Throwable cause = e6.getCause();
                if (cause == null) {
                    throw e6;
                }
                throw cause;
            }
        } else {
            d0.e(0);
            q qVar = new q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
            qVar.Q();
            result.addListener(new ListenableFutureKt$await$2$1(qVar, result), DirectExecutor.INSTANCE);
            obj = qVar.x();
            if (obj == kotlin.coroutines.intrinsics.a.l()) {
                kotlin.coroutines.jvm.internal.e.c(eVar);
            }
            d0.e(1);
        }
        g0.o(obj, "result.await()");
        return obj;
    }
}
