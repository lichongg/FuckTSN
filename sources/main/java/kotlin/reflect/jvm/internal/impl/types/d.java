package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f47201a = new d();

    private final boolean c(e4.r rVar, e4.g gVar, e4.g gVar2) {
        if (gVar == gVar2) {
            return true;
        }
        e4.h f6 = rVar.f(gVar);
        e4.h f7 = rVar.f(gVar2);
        if (f6 != null && f7 != null) {
            return a(rVar, f6, f7);
        }
        e4.e a02 = rVar.a0(gVar);
        e4.e a03 = rVar.a0(gVar2);
        return a02 != null && a03 != null && a(rVar, rVar.e(a02), rVar.e(a03)) && a(rVar, rVar.h(a02), rVar.h(a03));
    }

    public final boolean b(@NotNull e4.r context, @NotNull e4.g a6, @NotNull e4.g b6) {
        kotlin.jvm.internal.g0.p(context, "context");
        kotlin.jvm.internal.g0.p(a6, "a");
        kotlin.jvm.internal.g0.p(b6, "b");
        return c(context, a6, b6);
    }

    private d() {
    }

    private final boolean a(e4.r rVar, e4.h hVar, e4.h hVar2) {
        if (rVar.v(hVar) != rVar.v(hVar2) || rVar.B0(hVar) != rVar.B0(hVar2) || rVar.H(hVar) != rVar.H(hVar2) || !rVar.q0(rVar.c(hVar), rVar.c(hVar2))) {
            return false;
        }
        if (rVar.H0(hVar, hVar2)) {
            return true;
        }
        int v5 = rVar.v(hVar);
        for (int i6 = 0; i6 < v5; i6++) {
            e4.l I = rVar.I(hVar, i6);
            e4.l I2 = rVar.I(hVar2, i6);
            if (rVar.g(I) != rVar.g(I2)) {
                return false;
            }
            if (!rVar.g(I)) {
                if (rVar.M(I) != rVar.M(I2)) {
                    return false;
                }
                e4.g type = rVar.getType(I);
                kotlin.jvm.internal.g0.m(type);
                e4.g type2 = rVar.getType(I2);
                kotlin.jvm.internal.g0.m(type2);
                if (!c(rVar, type, type2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
