package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = BuildConfig.VERSION_NAME)
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x0 implements kotlin.reflect.r {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f44082e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final int f44083f = 1;

    /* renamed from: g, reason: collision with root package name */
    public static final int f44084g = 2;

    /* renamed from: h, reason: collision with root package name */
    public static final int f44085h = 4;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.g f44086a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<kotlin.reflect.t> f44087b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final kotlin.reflect.r f44088c;

    /* renamed from: d, reason: collision with root package name */
    private final int f44089d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public x0(@NotNull kotlin.reflect.g classifier, @NotNull List<kotlin.reflect.t> arguments, @Nullable kotlin.reflect.r rVar, int i6) {
        g0.p(classifier, "classifier");
        g0.p(arguments, "arguments");
        this.f44086a = classifier;
        this.f44087b = arguments;
        this.f44088c = rVar;
        this.f44089d = i6;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44090a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f44090a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence g(x0 x0Var, kotlin.reflect.t it) {
        g0.p(it, "it");
        return x0Var.d(it);
    }

    private final String j(Class<?> cls) {
        return g0.g(cls, boolean[].class) ? "kotlin.BooleanArray" : g0.g(cls, char[].class) ? "kotlin.CharArray" : g0.g(cls, byte[].class) ? "kotlin.ByteArray" : g0.g(cls, short[].class) ? "kotlin.ShortArray" : g0.g(cls, int[].class) ? "kotlin.IntArray" : g0.g(cls, float[].class) ? "kotlin.FloatArray" : g0.g(cls, long[].class) ? "kotlin.LongArray" : g0.g(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return g0.g(n(), x0Var.n()) && g0.g(getArguments(), x0Var.getArguments()) && g0.g(this.f44088c, x0Var.f44088c) && this.f44089d == x0Var.f44089d;
    }

    @Override // kotlin.reflect.r
    @NotNull
    public List<kotlin.reflect.t> getArguments() {
        return this.f44087b;
    }

    public final int l() {
        return this.f44089d;
    }

    @Override // kotlin.reflect.r
    @NotNull
    public kotlin.reflect.g n() {
        return this.f44086a;
    }

    @Override // kotlin.reflect.r
    public boolean q() {
        return (this.f44089d & 1) != 0;
    }

    @Nullable
    public final kotlin.reflect.r s() {
        return this.f44088c;
    }

    @NotNull
    public String toString() {
        return e(false) + " (Kotlin reflection is not available)";
    }

    private final String d(kotlin.reflect.t tVar) {
        x0 x0Var;
        String valueOf;
        if (tVar.g() == null) {
            return "*";
        }
        kotlin.reflect.r type = tVar.getType();
        if (type instanceof x0) {
            x0Var = (x0) type;
        } else {
            x0Var = null;
        }
        if (x0Var == null || (valueOf = x0Var.e(true)) == null) {
            valueOf = String.valueOf(tVar.getType());
        }
        int i6 = b.f44090a[tVar.g().ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 3) {
                    return "out " + valueOf;
                }
                throw new NoWhenBranchMatchedException();
            }
            return "in " + valueOf;
        }
        return valueOf;
    }

    private final String e(boolean z5) {
        kotlin.reflect.d dVar;
        String name;
        String r32;
        kotlin.reflect.g n6 = n();
        Class<?> cls = null;
        if (n6 instanceof kotlin.reflect.d) {
            dVar = (kotlin.reflect.d) n6;
        } else {
            dVar = null;
        }
        if (dVar != null) {
            cls = l3.a.e(dVar);
        }
        if (cls == null) {
            name = n().toString();
        } else if ((this.f44089d & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (cls.isArray()) {
            name = j(cls);
        } else if (z5 && cls.isPrimitive()) {
            kotlin.reflect.g n7 = n();
            g0.n(n7, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = l3.a.g((kotlin.reflect.d) n7).getName();
        } else {
            name = cls.getName();
        }
        String str = "";
        if (getArguments().isEmpty()) {
            r32 = "";
        } else {
            r32 = kotlin.collections.f0.r3(getArguments(), ", ", "<", ">", 0, null, new Function1() { // from class: kotlin.jvm.internal.w0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence g6;
                    g6 = x0.g(x0.this, (kotlin.reflect.t) obj);
                    return g6;
                }
            }, 24, null);
        }
        if (q()) {
            str = "?";
        }
        String str2 = name + r32 + str;
        kotlin.reflect.r rVar = this.f44088c;
        if (rVar instanceof x0) {
            String e6 = ((x0) rVar).e(true);
            if (!g0.g(e6, str2)) {
                if (g0.g(e6, str2 + '?')) {
                    return str2 + '!';
                }
                return '(' + str2 + ".." + e6 + ')';
            }
            return str2;
        }
        return str2;
    }

    @Override // kotlin.reflect.b
    @NotNull
    public List<Annotation> getAnnotations() {
        return kotlin.collections.f0.J();
    }

    public int hashCode() {
        return (((n().hashCode() * 31) + getArguments().hashCode()) * 31) + this.f44089d;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x0(@NotNull kotlin.reflect.g classifier, @NotNull List<kotlin.reflect.t> arguments, boolean z5) {
        this(classifier, arguments, null, z5 ? 1 : 0);
        g0.p(classifier, "classifier");
        g0.p(arguments, "arguments");
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public static /* synthetic */ void r() {
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    public static /* synthetic */ void t() {
    }
}
