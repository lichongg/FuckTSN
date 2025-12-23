package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t3 {
    @Nullable
    public static final Object a(@NotNull kotlin.coroutines.e<? super kotlin.n1> eVar) {
        kotlinx.coroutines.internal.l lVar;
        Object obj;
        kotlin.coroutines.i context = eVar.getContext();
        h2.z(context);
        kotlin.coroutines.e e6 = kotlin.coroutines.intrinsics.a.e(eVar);
        if (e6 instanceof kotlinx.coroutines.internal.l) {
            lVar = (kotlinx.coroutines.internal.l) e6;
        } else {
            lVar = null;
        }
        if (lVar == null) {
            obj = kotlin.n1.f44123a;
        } else {
            if (lVar.f49277d.isDispatchNeeded(context)) {
                lVar.m(context, kotlin.n1.f44123a);
            } else {
                s3 s3Var = new s3();
                kotlin.coroutines.i plus = context.plus(s3Var);
                kotlin.n1 n1Var = kotlin.n1.f44123a;
                lVar.m(plus, n1Var);
                if (s3Var.f49447a) {
                    if (kotlinx.coroutines.internal.m.f(lVar)) {
                        obj = kotlin.coroutines.intrinsics.a.l();
                    } else {
                        obj = n1Var;
                    }
                }
            }
            obj = kotlin.coroutines.intrinsics.a.l();
        }
        if (obj == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        if (obj == kotlin.coroutines.intrinsics.a.l()) {
            return obj;
        }
        return kotlin.n1.f44123a;
    }
}
