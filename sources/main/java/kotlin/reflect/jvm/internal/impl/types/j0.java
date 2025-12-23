package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j0 {
    @Nullable
    public static final e4.g a(@NotNull i2 i2Var, @NotNull e4.g inlineClassType) {
        kotlin.jvm.internal.g0.p(i2Var, "<this>");
        kotlin.jvm.internal.g0.p(inlineClassType, "inlineClassType");
        return b(i2Var, inlineClassType, new HashSet());
    }

    private static final e4.g b(i2 i2Var, e4.g gVar, HashSet<e4.o> hashSet) {
        e4.g b6;
        boolean z5;
        e4.o X = i2Var.X(gVar);
        if (!hashSet.add(X)) {
            return null;
        }
        e4.p b02 = i2Var.b0(X);
        if (b02 != null) {
            e4.g I0 = i2Var.I0(b02);
            e4.g b7 = b(i2Var, I0, hashSet);
            if (b7 == null) {
                return null;
            }
            if (!i2Var.T(i2Var.X(I0)) && (!(I0 instanceof e4.i) || !i2Var.C0((e4.i) I0))) {
                z5 = false;
            } else {
                z5 = true;
            }
            if ((b7 instanceof e4.i) && i2Var.C0((e4.i) b7) && i2Var.j0(gVar) && z5) {
                return i2Var.l0(I0);
            }
            if (!i2Var.j0(b7) && i2Var.B0(gVar)) {
                return i2Var.l0(b7);
            }
            return b7;
        }
        if (i2Var.T(X)) {
            e4.g x02 = i2Var.x0(gVar);
            if (x02 == null || (b6 = b(i2Var, x02, hashSet)) == null) {
                return null;
            }
            if (!i2Var.j0(gVar)) {
                return b6;
            }
            if (!i2Var.j0(b6) && (!(b6 instanceof e4.i) || !i2Var.C0((e4.i) b6))) {
                return i2Var.l0(b6);
            }
        }
        return gVar;
    }
}
