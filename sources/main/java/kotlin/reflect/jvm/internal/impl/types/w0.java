package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.q1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nKotlinTypeFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinTypeFactory.kt\norg/jetbrains/kotlin/types/KotlinTypeFactory\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,276:1\n1#2:277\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class w0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w0 f47361a = new w0();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Function1<kotlin.reflect.jvm.internal.impl.types.checker.g, e1> f47362b = a.f47363a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f47363a = new a();

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            kotlin.jvm.internal.g0.p(gVar, "<unused var>");
            return null;
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private final e1 f47364a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final w1 f47365b;

        @Nullable
        public final e1 a() {
            return this.f47364a;
        }

        @Nullable
        public final w1 b() {
            return this.f47365b;
        }

        public b(@Nullable e1 e1Var, @Nullable w1 w1Var) {
            this.f47364a = e1Var;
            this.f47365b = w1Var;
        }
    }

    @JvmStatic
    @NotNull
    public static final e1 c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.i1 i1Var, @NotNull List<? extends c2> arguments) {
        kotlin.jvm.internal.g0.p(i1Var, "<this>");
        kotlin.jvm.internal.g0.p(arguments, "arguments");
        return new o1(q1.a.f47324a, false).i(p1.f47311e.a(null, i1Var, arguments), t1.f47332b.k());
    }

    @JvmStatic
    @NotNull
    public static final m2 e(@NotNull e1 lowerBound, @NotNull e1 upperBound) {
        kotlin.jvm.internal.g0.p(lowerBound, "lowerBound");
        kotlin.jvm.internal.g0.p(upperBound, "upperBound");
        return kotlin.jvm.internal.g0.g(lowerBound, upperBound) ? lowerBound : new l0(lowerBound, upperBound);
    }

    @JvmStatic
    @NotNull
    public static final e1 f(@NotNull t1 attributes, @NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.q constructor, boolean z5) {
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        kotlin.jvm.internal.g0.p(constructor, "constructor");
        return o(attributes, constructor, kotlin.collections.f0.J(), z5, kotlin.reflect.jvm.internal.impl.types.error.i.a(ErrorScopeKind.INTEGER_LITERAL_TYPE_SCOPE, true, "unknown integer literal type"));
    }

    @JvmStatic
    @NotNull
    public static final e1 h(@NotNull t1 attributes, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d descriptor, @NotNull List<? extends c2> arguments) {
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        kotlin.jvm.internal.g0.p(arguments, "arguments");
        w1 o5 = descriptor.o();
        kotlin.jvm.internal.g0.o(o5, "getTypeConstructor(...)");
        return m(attributes, o5, arguments, false, null, 16, null);
    }

    @JvmStatic
    @NotNull
    public static final e1 i(@NotNull e1 baseType, @NotNull t1 annotations, @NotNull w1 constructor, @NotNull List<? extends c2> arguments, boolean z5) {
        kotlin.jvm.internal.g0.p(baseType, "baseType");
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        kotlin.jvm.internal.g0.p(constructor, "constructor");
        kotlin.jvm.internal.g0.p(arguments, "arguments");
        return m(annotations, constructor, arguments, z5, null, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final e1 j(@NotNull t1 attributes, @NotNull w1 constructor, @NotNull List<? extends c2> arguments, boolean z5) {
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        kotlin.jvm.internal.g0.p(constructor, "constructor");
        kotlin.jvm.internal.g0.p(arguments, "arguments");
        return m(attributes, constructor, arguments, z5, null, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final e1 k(@NotNull t1 attributes, @NotNull w1 constructor, @NotNull List<? extends c2> arguments, boolean z5, @Nullable kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        kotlin.jvm.internal.g0.p(constructor, "constructor");
        kotlin.jvm.internal.g0.p(arguments, "arguments");
        if (!attributes.isEmpty() || !arguments.isEmpty() || z5 || constructor.c() == null) {
            return p(attributes, constructor, arguments, z5, f47361a.d(constructor, arguments, gVar), new u0(constructor, arguments, attributes, z5));
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = constructor.c();
        kotlin.jvm.internal.g0.m(c6);
        e1 s5 = c6.s();
        kotlin.jvm.internal.g0.o(s5, "getDefaultType(...)");
        return s5;
    }

    public static /* synthetic */ e1 l(e1 e1Var, t1 t1Var, w1 w1Var, List list, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            t1Var = e1Var.H0();
        }
        if ((i6 & 4) != 0) {
            w1Var = e1Var.I0();
        }
        if ((i6 & 8) != 0) {
            list = e1Var.G0();
        }
        if ((i6 & 16) != 0) {
            z5 = e1Var.J0();
        }
        return i(e1Var, t1Var, w1Var, list, z5);
    }

    public static /* synthetic */ e1 m(t1 t1Var, w1 w1Var, List list, boolean z5, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, int i6, Object obj) {
        if ((i6 & 16) != 0) {
            gVar = null;
        }
        return k(t1Var, w1Var, list, z5, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e1 n(w1 w1Var, List list, t1 t1Var, boolean z5, kotlin.reflect.jvm.internal.impl.types.checker.g refiner) {
        kotlin.jvm.internal.g0.p(refiner, "refiner");
        b g6 = f47361a.g(w1Var, refiner, list);
        if (g6 == null) {
            return null;
        }
        e1 a6 = g6.a();
        if (a6 != null) {
            return a6;
        }
        w1 b6 = g6.b();
        kotlin.jvm.internal.g0.m(b6);
        return k(t1Var, b6, list, z5, refiner);
    }

    @JvmStatic
    @NotNull
    public static final e1 o(@NotNull t1 attributes, @NotNull w1 constructor, @NotNull List<? extends c2> arguments, boolean z5, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.k memberScope) {
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        kotlin.jvm.internal.g0.p(constructor, "constructor");
        kotlin.jvm.internal.g0.p(arguments, "arguments");
        kotlin.jvm.internal.g0.p(memberScope, "memberScope");
        f1 f1Var = new f1(constructor, arguments, z5, memberScope, new v0(constructor, arguments, attributes, z5, memberScope));
        return attributes.isEmpty() ? f1Var : new g1(f1Var, attributes);
    }

    @JvmStatic
    @NotNull
    public static final e1 p(@NotNull t1 attributes, @NotNull w1 constructor, @NotNull List<? extends c2> arguments, boolean z5, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.k memberScope, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends e1> refinedTypeFactory) {
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        kotlin.jvm.internal.g0.p(constructor, "constructor");
        kotlin.jvm.internal.g0.p(arguments, "arguments");
        kotlin.jvm.internal.g0.p(memberScope, "memberScope");
        kotlin.jvm.internal.g0.p(refinedTypeFactory, "refinedTypeFactory");
        f1 f1Var = new f1(constructor, arguments, z5, memberScope, refinedTypeFactory);
        return attributes.isEmpty() ? f1Var : new g1(f1Var, attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e1 q(w1 w1Var, List list, t1 t1Var, boolean z5, kotlin.reflect.jvm.internal.impl.resolve.scopes.k kVar, kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        b g6 = f47361a.g(w1Var, kotlinTypeRefiner, list);
        if (g6 == null) {
            return null;
        }
        e1 a6 = g6.a();
        if (a6 != null) {
            return a6;
        }
        w1 b6 = g6.b();
        kotlin.jvm.internal.g0.m(b6);
        return o(t1Var, b6, list, z5, kVar);
    }

    private w0() {
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.k d(w1 w1Var, List<? extends c2> list, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = w1Var.c();
        if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.j1) {
            return ((kotlin.reflect.jvm.internal.impl.descriptors.j1) c6).s().r();
        }
        if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            if (gVar == null) {
                gVar = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.r(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.s(c6));
            }
            if (list.isEmpty()) {
                return kotlin.reflect.jvm.internal.impl.descriptors.impl.a0.b((kotlin.reflect.jvm.internal.impl.descriptors.d) c6, gVar);
            }
            return kotlin.reflect.jvm.internal.impl.descriptors.impl.a0.a((kotlin.reflect.jvm.internal.impl.descriptors.d) c6, x1.f47366c.b(w1Var, list), gVar);
        }
        if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.i1) {
            return kotlin.reflect.jvm.internal.impl.types.error.i.a(ErrorScopeKind.SCOPE_FOR_ABBREVIATION_TYPE, true, ((kotlin.reflect.jvm.internal.impl.descriptors.i1) c6).getName().toString());
        }
        if (w1Var instanceof s0) {
            return ((s0) w1Var).h();
        }
        throw new IllegalStateException("Unsupported classifier: " + c6 + " for constructor: " + w1Var);
    }

    private final b g(w1 w1Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, List<? extends c2> list) {
        kotlin.reflect.jvm.internal.impl.descriptors.f f6;
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = w1Var.c();
        if (c6 == null || (f6 = gVar.f(c6)) == null) {
            return null;
        }
        if (f6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.i1) {
            return new b(c((kotlin.reflect.jvm.internal.impl.descriptors.i1) f6, list), null);
        }
        w1 a6 = f6.o().a(gVar);
        kotlin.jvm.internal.g0.o(a6, "refine(...)");
        return new b(null, a6);
    }
}
