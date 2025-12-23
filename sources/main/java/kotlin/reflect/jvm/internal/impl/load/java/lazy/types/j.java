package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.renderer.m;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.types.b2;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.d1;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.k0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.t1;
import kotlin.text.u;
import kotlin.text.v0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRawType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RawType.kt\norg/jetbrains/kotlin/load/java/lazy/types/RawTypeImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,98:1\n1740#2,3:99\n1563#2:102\n1634#2,3:103\n*S KotlinDebug\n*F\n+ 1 RawType.kt\norg/jetbrains/kotlin/load/java/lazy/types/RawTypeImpl\n*L\n80#1:99,3\n61#1:102\n61#1:103,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j extends k0 implements d1 {
    private j(e1 e1Var, e1 e1Var2, boolean z5) {
        super(e1Var, e1Var2);
        if (z5) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.types.checker.e.f47168a.d(e1Var, e1Var2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence W0(String it) {
        g0.p(it, "it");
        return "(raw) " + it;
    }

    private static final boolean X0(String str, String str2) {
        return g0.g(str, u.v4(str2, "out ")) || g0.g(str2, "*");
    }

    private static final String Z0(String str, String str2) {
        if (!u.k3(str, v0.f47961e, false, 2, null)) {
            return str;
        }
        return u.R5(str, v0.f47961e, null, 2, null) + v0.f47961e + str2 + v0.f47962f + u.N5(str, v0.f47962f, null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k0
    @NotNull
    public String S0(@NotNull m renderer, @NotNull kotlin.reflect.jvm.internal.impl.renderer.u options) {
        g0.p(renderer, "renderer");
        g0.p(options, "options");
        String T = renderer.T(Q0());
        String T2 = renderer.T(R0());
        if (options.d()) {
            return "raw (" + T + ".." + T2 + ')';
        }
        if (R0().G0().isEmpty()) {
            return renderer.Q(T, T2, kotlin.reflect.jvm.internal.impl.types.typeUtil.e.o(this));
        }
        List<String> Y0 = Y0(renderer, Q0());
        List<String> Y02 = Y0(renderer, R0());
        List<String> list = Y0;
        String r32 = f0.r3(list, ", ", null, null, 0, null, i.f45723a, 30, null);
        List<Pair> o6 = f0.o6(list, Y02);
        if (!(o6 instanceof Collection) || !o6.isEmpty()) {
            for (Pair pair : o6) {
                if (!X0((String) pair.getFirst(), (String) pair.getSecond())) {
                    break;
                }
            }
        }
        T2 = Z0(T2, r32);
        String Z0 = Z0(T, r32);
        return g0.g(Z0, T2) ? Z0 : renderer.Q(Z0, T2, kotlin.reflect.jvm.internal.impl.types.typeUtil.e.o(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public j M0(boolean z5) {
        return new j(Q0().M0(z5), R0().M0(z5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public k0 S0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        t0 a6 = kotlinTypeRefiner.a(Q0());
        g0.n(a6, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        t0 a7 = kotlinTypeRefiner.a(R0());
        g0.n(a7, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new j((e1) a6, (e1) a7, true);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public j O0(@NotNull t1 newAttributes) {
        g0.p(newAttributes, "newAttributes");
        return new j(Q0().O0(newAttributes), R0().O0(newAttributes));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(@NotNull e1 lowerBound, @NotNull e1 upperBound) {
        this(lowerBound, upperBound, false);
        g0.p(lowerBound, "lowerBound");
        g0.p(upperBound, "upperBound");
    }

    private static final List<String> Y0(m mVar, t0 t0Var) {
        List<c2> G0 = t0Var.G0();
        ArrayList arrayList = new ArrayList(f0.d0(G0, 10));
        Iterator<T> it = G0.iterator();
        while (it.hasNext()) {
            arrayList.add(mVar.U((c2) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k0
    @NotNull
    public e1 P0() {
        return Q0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k0, kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public k r() {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar;
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = I0().c();
        b2 b2Var = null;
        byte b6 = 0;
        if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) c6;
        } else {
            dVar = null;
        }
        if (dVar != null) {
            k v02 = dVar.v0(new h(b2Var, 1, b6 == true ? 1 : 0));
            g0.o(v02, "getMemberScope(...)");
            return v02;
        }
        throw new IllegalStateException(("Incorrect classifier: " + I0().c()).toString());
    }
}
