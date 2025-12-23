package kotlin.reflect.jvm.internal.impl.builtins;

import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.collections.u1;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.functions.e;
import kotlin.reflect.jvm.internal.impl.name.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o {

    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f A;

    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c B;

    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c C;

    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c D;

    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c E;

    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c F;

    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c G;

    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c H;

    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c I;

    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c J;

    @JvmField
    @NotNull
    public static final Set<kotlin.reflect.jvm.internal.impl.name.c> K;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f44557a = new o();

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44558b;

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44559c;

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44560d;

    /* renamed from: e, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44561e;

    /* renamed from: f, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44562f;

    /* renamed from: g, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44563g;

    /* renamed from: h, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final String f44564h;

    /* renamed from: i, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44565i;

    /* renamed from: j, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44566j;

    /* renamed from: k, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44567k;

    /* renamed from: l, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44568l;

    /* renamed from: m, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44569m;

    /* renamed from: n, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44570n;

    /* renamed from: o, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44571o;

    /* renamed from: p, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44572p;

    /* renamed from: q, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44573q;

    /* renamed from: r, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c f44574r;

    /* renamed from: s, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c f44575s;

    /* renamed from: t, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c f44576t;

    /* renamed from: u, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c f44577u;

    /* renamed from: v, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.f f44578v;

    /* renamed from: w, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c f44579w;

    /* renamed from: x, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c f44580x;

    /* renamed from: y, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c f44581y;

    /* renamed from: z, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final List<String> f44582z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nStandardNames.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StandardNames.kt\norg/jetbrains/kotlin/builtins/StandardNames$FqNames\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,332:1\n11563#2,3:333\n11563#2,3:336\n*S KotlinDebug\n*F\n+ 1 StandardNames.kt\norg/jetbrains/kotlin/builtins/StandardNames$FqNames\n*L\n220#1:333,3\n224#1:336,3\n*E\n"})
    public static final class a {

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c A;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c A0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c B;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c B0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c C;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c C0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c D;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.b D0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c E;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.b E0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.b F;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.b F0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c G;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.b G0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c H;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c H0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.b I;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c I0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c J;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c J0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c K;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c K0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c L;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c L0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.b M;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c M0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c N;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c N0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.b O;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c O0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c P;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c P0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c Q;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c Q0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c R;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c R0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c S;

        @JvmField
        @NotNull
        public static final Set<kotlin.reflect.jvm.internal.impl.name.f> S0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c T;

        @JvmField
        @NotNull
        public static final Set<kotlin.reflect.jvm.internal.impl.name.f> T0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.b U;

        @JvmField
        @NotNull
        public static final Map<kotlin.reflect.jvm.internal.impl.name.d, PrimitiveType> U0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c V;

        @JvmField
        @NotNull
        public static final Map<kotlin.reflect.jvm.internal.impl.name.d, PrimitiveType> V0;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c W;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c X;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c Y;

        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c Z;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f44583a;

        /* renamed from: a0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44584a0;

        /* renamed from: b, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44585b;

        /* renamed from: b0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44586b0;

        /* renamed from: c, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44587c;

        /* renamed from: c0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44588c0;

        /* renamed from: d, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44589d;

        /* renamed from: d0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44590d0;

        /* renamed from: e, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44591e;

        /* renamed from: e0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44592e0;

        /* renamed from: f, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44593f;

        /* renamed from: f0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44594f0;

        /* renamed from: g, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44595g;

        /* renamed from: g0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44596g0;

        /* renamed from: h, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44597h;

        /* renamed from: h0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44598h0;

        /* renamed from: i, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44599i;

        /* renamed from: i0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44600i0;

        /* renamed from: j, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44601j;

        /* renamed from: j0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44602j0;

        /* renamed from: k, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44603k;

        /* renamed from: k0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44604k0;

        /* renamed from: l, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44605l;

        /* renamed from: l0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44606l0;

        /* renamed from: m, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44607m;

        /* renamed from: m0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44608m0;

        /* renamed from: n, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44609n;

        /* renamed from: n0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44610n0;

        /* renamed from: o, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44611o;

        /* renamed from: o0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44612o0;

        /* renamed from: p, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44613p;

        /* renamed from: p0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44614p0;

        /* renamed from: q, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44615q;

        /* renamed from: q0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44616q0;

        /* renamed from: r, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44617r;

        /* renamed from: r0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44618r0;

        /* renamed from: s, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44619s;

        /* renamed from: s0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44620s0;

        /* renamed from: t, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44621t;

        /* renamed from: t0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44622t0;

        /* renamed from: u, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44623u;

        /* renamed from: u0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44624u0;

        /* renamed from: v, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44625v;

        /* renamed from: v0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44626v0;

        /* renamed from: w, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44627w;

        /* renamed from: w0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.b f44628w0;

        /* renamed from: x, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44629x;

        /* renamed from: x0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44630x0;

        /* renamed from: y, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44631y;

        /* renamed from: y0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d f44632y0;

        /* renamed from: z, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44633z;

        /* renamed from: z0, reason: collision with root package name */
        @JvmField
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.c f44634z0;

        static {
            a aVar = new a();
            f44583a = aVar;
            f44585b = aVar.e("Any");
            f44587c = aVar.e("Nothing");
            f44589d = aVar.e("Cloneable");
            f44591e = aVar.d("Suppress");
            f44593f = aVar.e("Unit");
            f44595g = aVar.e("CharSequence");
            f44597h = aVar.e("String");
            f44599i = aVar.e("Array");
            f44601j = aVar.e("Boolean");
            f44603k = aVar.e("Char");
            f44605l = aVar.e("Byte");
            f44607m = aVar.e("Short");
            f44609n = aVar.e("Int");
            f44611o = aVar.e("Long");
            f44613p = aVar.e("Float");
            f44615q = aVar.e("Double");
            f44617r = aVar.e("Number");
            f44619s = aVar.e("Enum");
            f44621t = aVar.e("Function");
            f44623u = aVar.d("Throwable");
            f44625v = aVar.d("Comparable");
            f44627w = aVar.g("IntRange");
            f44629x = aVar.g("LongRange");
            f44631y = aVar.d("Deprecated");
            f44633z = aVar.d("DeprecatedSinceKotlin");
            A = aVar.d("DeprecationLevel");
            B = aVar.d("ReplaceWith");
            C = aVar.d("ExtensionFunctionType");
            D = aVar.d("ContextFunctionTypeParams");
            kotlin.reflect.jvm.internal.impl.name.c d6 = aVar.d("ParameterName");
            E = d6;
            b.a aVar2 = kotlin.reflect.jvm.internal.impl.name.b.f46334d;
            F = aVar2.c(d6);
            G = aVar.d("Annotation");
            kotlin.reflect.jvm.internal.impl.name.c a6 = aVar.a("Target");
            H = a6;
            I = aVar2.c(a6);
            J = aVar.a("AnnotationTarget");
            K = aVar.a("AnnotationRetention");
            kotlin.reflect.jvm.internal.impl.name.c a7 = aVar.a("Retention");
            L = a7;
            M = aVar2.c(a7);
            kotlin.reflect.jvm.internal.impl.name.c a8 = aVar.a("Repeatable");
            N = a8;
            O = aVar2.c(a8);
            P = aVar.a("MustBeDocumented");
            Q = aVar.d("UnsafeVariance");
            R = aVar.d("PublishedApi");
            S = aVar.f("AccessibleLateinitPropertyLiteral");
            kotlin.reflect.jvm.internal.impl.name.c cVar = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.internal.PlatformDependent");
            T = cVar;
            U = aVar2.c(cVar);
            V = aVar.b("Iterator");
            W = aVar.b("Iterable");
            X = aVar.b("Collection");
            Y = aVar.b("List");
            Z = aVar.b("ListIterator");
            f44584a0 = aVar.b("Set");
            kotlin.reflect.jvm.internal.impl.name.c b6 = aVar.b("Map");
            f44586b0 = b6;
            kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h("Entry");
            g0.o(h6, "identifier(...)");
            f44588c0 = b6.b(h6);
            f44590d0 = aVar.b("MutableIterator");
            f44592e0 = aVar.b("MutableIterable");
            f44594f0 = aVar.b("MutableCollection");
            f44596g0 = aVar.b("MutableList");
            f44598h0 = aVar.b("MutableListIterator");
            f44600i0 = aVar.b("MutableSet");
            kotlin.reflect.jvm.internal.impl.name.c b7 = aVar.b("MutableMap");
            f44602j0 = b7;
            kotlin.reflect.jvm.internal.impl.name.f h7 = kotlin.reflect.jvm.internal.impl.name.f.h("MutableEntry");
            g0.o(h7, "identifier(...)");
            f44604k0 = b7.b(h7);
            f44606l0 = h("KClass");
            f44608m0 = h("KType");
            f44610n0 = h("KCallable");
            f44612o0 = h("KProperty0");
            f44614p0 = h("KProperty1");
            f44616q0 = h("KProperty2");
            f44618r0 = h("KMutableProperty0");
            f44620s0 = h("KMutableProperty1");
            f44622t0 = h("KMutableProperty2");
            kotlin.reflect.jvm.internal.impl.name.d h8 = h("KProperty");
            f44624u0 = h8;
            f44626v0 = h("KMutableProperty");
            f44628w0 = aVar2.c(h8.m());
            f44630x0 = h("KDeclarationContainer");
            f44632y0 = h("findAssociatedObject");
            kotlin.reflect.jvm.internal.impl.name.c d7 = aVar.d("UByte");
            f44634z0 = d7;
            kotlin.reflect.jvm.internal.impl.name.c d8 = aVar.d("UShort");
            A0 = d8;
            kotlin.reflect.jvm.internal.impl.name.c d9 = aVar.d("UInt");
            B0 = d9;
            kotlin.reflect.jvm.internal.impl.name.c d10 = aVar.d("ULong");
            C0 = d10;
            D0 = aVar2.c(d7);
            E0 = aVar2.c(d8);
            F0 = aVar2.c(d9);
            G0 = aVar2.c(d10);
            H0 = aVar.d("UByteArray");
            I0 = aVar.d("UShortArray");
            J0 = aVar.d("UIntArray");
            K0 = aVar.d("ULongArray");
            L0 = aVar.c("AtomicInt");
            M0 = aVar.c("AtomicLong");
            N0 = aVar.c("AtomicBoolean");
            O0 = aVar.c("AtomicReference");
            P0 = aVar.c("AtomicIntArray");
            Q0 = aVar.c("AtomicLongArray");
            R0 = aVar.c("AtomicArray");
            HashSet f6 = kotlin.reflect.jvm.internal.impl.utils.a.f(PrimitiveType.values().length);
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                f6.add(primitiveType.getTypeName());
            }
            S0 = f6;
            HashSet f7 = kotlin.reflect.jvm.internal.impl.utils.a.f(PrimitiveType.values().length);
            for (PrimitiveType primitiveType2 : PrimitiveType.values()) {
                f7.add(primitiveType2.getArrayTypeName());
            }
            T0 = f7;
            HashMap e6 = kotlin.reflect.jvm.internal.impl.utils.a.e(PrimitiveType.values().length);
            for (PrimitiveType primitiveType3 : PrimitiveType.values()) {
                a aVar3 = f44583a;
                String b8 = primitiveType3.getTypeName().b();
                g0.o(b8, "asString(...)");
                e6.put(aVar3.e(b8), primitiveType3);
            }
            U0 = e6;
            HashMap e7 = kotlin.reflect.jvm.internal.impl.utils.a.e(PrimitiveType.values().length);
            for (PrimitiveType primitiveType4 : PrimitiveType.values()) {
                a aVar4 = f44583a;
                String b9 = primitiveType4.getArrayTypeName().b();
                g0.o(b9, "asString(...)");
                e7.put(aVar4.e(b9), primitiveType4);
            }
            V0 = e7;
        }

        private final kotlin.reflect.jvm.internal.impl.name.c a(String str) {
            kotlin.reflect.jvm.internal.impl.name.c cVar = o.C;
            kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(str);
            g0.o(h6, "identifier(...)");
            return cVar.b(h6);
        }

        private final kotlin.reflect.jvm.internal.impl.name.c b(String str) {
            kotlin.reflect.jvm.internal.impl.name.c cVar = o.D;
            kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(str);
            g0.o(h6, "identifier(...)");
            return cVar.b(h6);
        }

        private final kotlin.reflect.jvm.internal.impl.name.c c(String str) {
            kotlin.reflect.jvm.internal.impl.name.c cVar = o.I;
            kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(str);
            g0.o(h6, "identifier(...)");
            return cVar.b(h6);
        }

        private final kotlin.reflect.jvm.internal.impl.name.c d(String str) {
            kotlin.reflect.jvm.internal.impl.name.c cVar = o.B;
            kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(str);
            g0.o(h6, "identifier(...)");
            return cVar.b(h6);
        }

        private final kotlin.reflect.jvm.internal.impl.name.c f(String str) {
            kotlin.reflect.jvm.internal.impl.name.c cVar = o.G;
            kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(str);
            g0.o(h6, "identifier(...)");
            return cVar.b(h6);
        }

        private final kotlin.reflect.jvm.internal.impl.name.d g(String str) {
            kotlin.reflect.jvm.internal.impl.name.c cVar = o.E;
            kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(str);
            g0.o(h6, "identifier(...)");
            return cVar.b(h6).i();
        }

        @JvmStatic
        @NotNull
        public static final kotlin.reflect.jvm.internal.impl.name.d h(@NotNull String simpleName) {
            g0.p(simpleName, "simpleName");
            kotlin.reflect.jvm.internal.impl.name.c cVar = o.f44581y;
            kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(simpleName);
            g0.o(h6, "identifier(...)");
            return cVar.b(h6).i();
        }

        private a() {
        }

        private final kotlin.reflect.jvm.internal.impl.name.d e(String str) {
            return d(str).i();
        }
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h("field");
        g0.o(h6, "identifier(...)");
        f44558b = h6;
        kotlin.reflect.jvm.internal.impl.name.f h7 = kotlin.reflect.jvm.internal.impl.name.f.h("value");
        g0.o(h7, "identifier(...)");
        f44559c = h7;
        kotlin.reflect.jvm.internal.impl.name.f h8 = kotlin.reflect.jvm.internal.impl.name.f.h("values");
        g0.o(h8, "identifier(...)");
        f44560d = h8;
        kotlin.reflect.jvm.internal.impl.name.f h9 = kotlin.reflect.jvm.internal.impl.name.f.h("entries");
        g0.o(h9, "identifier(...)");
        f44561e = h9;
        kotlin.reflect.jvm.internal.impl.name.f h10 = kotlin.reflect.jvm.internal.impl.name.f.h("valueOf");
        g0.o(h10, "identifier(...)");
        f44562f = h10;
        kotlin.reflect.jvm.internal.impl.name.f h11 = kotlin.reflect.jvm.internal.impl.name.f.h("copy");
        g0.o(h11, "identifier(...)");
        f44563g = h11;
        f44564h = "component";
        kotlin.reflect.jvm.internal.impl.name.f h12 = kotlin.reflect.jvm.internal.impl.name.f.h("hashCode");
        g0.o(h12, "identifier(...)");
        f44565i = h12;
        kotlin.reflect.jvm.internal.impl.name.f h13 = kotlin.reflect.jvm.internal.impl.name.f.h("toString");
        g0.o(h13, "identifier(...)");
        f44566j = h13;
        kotlin.reflect.jvm.internal.impl.name.f h14 = kotlin.reflect.jvm.internal.impl.name.f.h("equals");
        g0.o(h14, "identifier(...)");
        f44567k = h14;
        kotlin.reflect.jvm.internal.impl.name.f h15 = kotlin.reflect.jvm.internal.impl.name.f.h("code");
        g0.o(h15, "identifier(...)");
        f44568l = h15;
        kotlin.reflect.jvm.internal.impl.name.f h16 = kotlin.reflect.jvm.internal.impl.name.f.h(CommonNetImpl.NAME);
        g0.o(h16, "identifier(...)");
        f44569m = h16;
        kotlin.reflect.jvm.internal.impl.name.f h17 = kotlin.reflect.jvm.internal.impl.name.f.h("main");
        g0.o(h17, "identifier(...)");
        f44570n = h17;
        kotlin.reflect.jvm.internal.impl.name.f h18 = kotlin.reflect.jvm.internal.impl.name.f.h("nextChar");
        g0.o(h18, "identifier(...)");
        f44571o = h18;
        kotlin.reflect.jvm.internal.impl.name.f h19 = kotlin.reflect.jvm.internal.impl.name.f.h("it");
        g0.o(h19, "identifier(...)");
        f44572p = h19;
        kotlin.reflect.jvm.internal.impl.name.f h20 = kotlin.reflect.jvm.internal.impl.name.f.h("count");
        g0.o(h20, "identifier(...)");
        f44573q = h20;
        f44574r = new kotlin.reflect.jvm.internal.impl.name.c("<dynamic>");
        kotlin.reflect.jvm.internal.impl.name.c cVar = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.coroutines");
        f44575s = cVar;
        f44576t = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.coroutines.jvm.internal");
        f44577u = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.coroutines.intrinsics");
        kotlin.reflect.jvm.internal.impl.name.f h21 = kotlin.reflect.jvm.internal.impl.name.f.h("COROUTINE_SUSPENDED");
        g0.o(h21, "identifier(...)");
        f44578v = h21;
        kotlin.reflect.jvm.internal.impl.name.f h22 = kotlin.reflect.jvm.internal.impl.name.f.h("Continuation");
        g0.o(h22, "identifier(...)");
        f44579w = cVar.b(h22);
        f44580x = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.Result");
        kotlin.reflect.jvm.internal.impl.name.c cVar2 = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.reflect");
        f44581y = cVar2;
        f44582z = f0.Q("KProperty", "KMutableProperty", "KFunction", "KSuspendFunction");
        kotlin.reflect.jvm.internal.impl.name.f h23 = kotlin.reflect.jvm.internal.impl.name.f.h("kotlin");
        g0.o(h23, "identifier(...)");
        A = h23;
        kotlin.reflect.jvm.internal.impl.name.c a6 = kotlin.reflect.jvm.internal.impl.name.c.f46338c.a(h23);
        B = a6;
        kotlin.reflect.jvm.internal.impl.name.f h24 = kotlin.reflect.jvm.internal.impl.name.f.h("annotation");
        g0.o(h24, "identifier(...)");
        kotlin.reflect.jvm.internal.impl.name.c b6 = a6.b(h24);
        C = b6;
        kotlin.reflect.jvm.internal.impl.name.f h25 = kotlin.reflect.jvm.internal.impl.name.f.h("collections");
        g0.o(h25, "identifier(...)");
        kotlin.reflect.jvm.internal.impl.name.c b7 = a6.b(h25);
        D = b7;
        kotlin.reflect.jvm.internal.impl.name.f h26 = kotlin.reflect.jvm.internal.impl.name.f.h("ranges");
        g0.o(h26, "identifier(...)");
        kotlin.reflect.jvm.internal.impl.name.c b8 = a6.b(h26);
        E = b8;
        kotlin.reflect.jvm.internal.impl.name.f h27 = kotlin.reflect.jvm.internal.impl.name.f.h(com.baidu.mobads.sdk.internal.a.f10501b);
        g0.o(h27, "identifier(...)");
        F = a6.b(h27);
        kotlin.reflect.jvm.internal.impl.name.f h28 = kotlin.reflect.jvm.internal.impl.name.f.h(UMModuleRegister.INNER);
        g0.o(h28, "identifier(...)");
        kotlin.reflect.jvm.internal.impl.name.c b9 = a6.b(h28);
        G = b9;
        kotlin.reflect.jvm.internal.impl.name.f h29 = kotlin.reflect.jvm.internal.impl.name.f.h("concurrent");
        g0.o(h29, "identifier(...)");
        kotlin.reflect.jvm.internal.impl.name.c b10 = a6.b(h29);
        H = b10;
        kotlin.reflect.jvm.internal.impl.name.f h30 = kotlin.reflect.jvm.internal.impl.name.f.h("atomics");
        g0.o(h30, "identifier(...)");
        kotlin.reflect.jvm.internal.impl.name.c b11 = b10.b(h30);
        I = b11;
        J = new kotlin.reflect.jvm.internal.impl.name.c("error.NonExistentClass");
        K = u1.u(a6, b7, b8, b6, cVar2, b9, cVar, b11);
    }

    @JvmStatic
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.b a(int i6) {
        kotlin.reflect.jvm.internal.impl.name.c cVar = B;
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(b(i6));
        g0.o(h6, "identifier(...)");
        return new kotlin.reflect.jvm.internal.impl.name.b(cVar, h6);
    }

    @JvmStatic
    @NotNull
    public static final String b(int i6) {
        return "Function" + i6;
    }

    @JvmStatic
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c c(@NotNull PrimitiveType primitiveType) {
        g0.p(primitiveType, "primitiveType");
        return B.b(primitiveType.getTypeName());
    }

    @JvmStatic
    @NotNull
    public static final String d(int i6) {
        return e.d.f44427f.a() + i6;
    }

    @JvmStatic
    public static final boolean e(@NotNull kotlin.reflect.jvm.internal.impl.name.d arrayFqName) {
        g0.p(arrayFqName, "arrayFqName");
        return a.V0.get(arrayFqName) != null;
    }

    private o() {
    }
}
