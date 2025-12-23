package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.b2;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.e2;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.f2;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.n0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.t1;
import kotlin.reflect.jvm.internal.impl.types.w0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.reflect.jvm.internal.impl.types.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRawSubstitution.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RawSubstitution.kt\norg/jetbrains/kotlin/load/java/lazy/types/RawSubstitution\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,95:1\n1563#2:96\n1634#2,3:97\n*S KotlinDebug\n*F\n+ 1 RawSubstitution.kt\norg/jetbrains/kotlin/load/java/lazy/types/RawSubstitution\n*L\n73#1:96\n73#1:97,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h extends f2 {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f45718e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a f45719f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a f45720g;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final f f45721c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final b2 f45722d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    public h() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    public boolean f() {
        return false;
    }

    static {
        TypeUsage typeUsage = TypeUsage.COMMON;
        f45719f = b.b(typeUsage, false, true, null, 5, null).l(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
        f45720g = b.b(typeUsage, false, true, null, 5, null).l(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    }

    public h(@Nullable b2 b2Var) {
        f fVar = new f();
        this.f45721c = fVar;
        if (b2Var == null) {
            b2Var = new b2(fVar, null, 2, 0 == true ? 1 : 0);
        }
        this.f45722d = b2Var;
    }

    private final Pair<e1, Boolean> j(e1 e1Var, kotlin.reflect.jvm.internal.impl.descriptors.d dVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        if (e1Var.I0().getParameters().isEmpty()) {
            return o0.a(e1Var, Boolean.FALSE);
        }
        if (kotlin.reflect.jvm.internal.impl.builtins.j.d0(e1Var)) {
            c2 c2Var = e1Var.G0().get(0);
            Variance c6 = c2Var.c();
            t0 type = c2Var.getType();
            g0.o(type, "getType(...)");
            return o0.a(w0.m(e1Var.H0(), e1Var.I0(), f0.l(new e2(c6, l(type, aVar))), e1Var.J0(), null, 16, null), Boolean.FALSE);
        }
        if (x0.a(e1Var)) {
            return o0.a(kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.ERROR_RAW_TYPE, e1Var.I0().toString()), Boolean.FALSE);
        }
        k v02 = dVar.v0(this);
        g0.o(v02, "getMemberScope(...)");
        t1 H0 = e1Var.H0();
        w1 o5 = dVar.o();
        g0.o(o5, "getTypeConstructor(...)");
        List<j1> parameters = dVar.o().getParameters();
        g0.o(parameters, "getParameters(...)");
        List<j1> list = parameters;
        ArrayList arrayList = new ArrayList(f0.d0(list, 10));
        for (j1 j1Var : list) {
            f fVar = this.f45721c;
            g0.m(j1Var);
            arrayList.add(h0.b(fVar, j1Var, aVar, this.f45722d, null, 8, null));
        }
        return o0.a(w0.p(H0, o5, arrayList, e1Var.J0(), v02, new g(dVar, this, e1Var, aVar)), Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e1 k(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, h hVar, e1 e1Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.reflect.jvm.internal.impl.descriptors.d b6;
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.reflect.jvm.internal.impl.name.b n6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.n(dVar);
        if (n6 == null || (b6 = kotlinTypeRefiner.b(n6)) == null || g0.g(b6, dVar)) {
            return null;
        }
        return hVar.j(e1Var, b6, aVar).getFirst();
    }

    static /* synthetic */ t0 m(h hVar, t0 t0Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            aVar = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a(TypeUsage.COMMON, null, false, false, null, null, 62, null);
        }
        return hVar.l(t0Var, aVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public e2 e(@NotNull t0 key) {
        g0.p(key, "key");
        return new e2(m(this, key, null, 2, null));
    }

    private final t0 l(t0 t0Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        if (c6 instanceof j1) {
            return l(this.f45722d.e((j1) c6, aVar.j(true)), aVar);
        }
        if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            kotlin.reflect.jvm.internal.impl.descriptors.f c7 = n0.d(t0Var).I0().c();
            if (c7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                Pair<e1, Boolean> j6 = j(n0.c(t0Var), (kotlin.reflect.jvm.internal.impl.descriptors.d) c6, f45719f);
                e1 component1 = j6.component1();
                boolean booleanValue = j6.component2().booleanValue();
                Pair<e1, Boolean> j7 = j(n0.d(t0Var), (kotlin.reflect.jvm.internal.impl.descriptors.d) c7, f45720g);
                e1 component12 = j7.component1();
                boolean booleanValue2 = j7.component2().booleanValue();
                if (!booleanValue && !booleanValue2) {
                    return w0.e(component1, component12);
                }
                return new j(component1, component12);
            }
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + c7 + "\" while for lower it's \"" + c6 + '\"').toString());
        }
        throw new IllegalStateException(("Unexpected declaration kind: " + c6).toString());
    }

    public /* synthetic */ h(b2 b2Var, int i6, v vVar) {
        this((i6 & 1) != 0 ? null : b2Var);
    }
}
