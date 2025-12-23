package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.n1;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = BuildConfig.VERSION_NAME)
@SourceDebugExtension({"SMAP\nTypeParameterReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeParameterReference.kt\nkotlin/jvm/internal/TypeParameterReference\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n1#2:59\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v0 implements kotlin.reflect.s {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f44065f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Object f44066a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f44067b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final KVariance f44068c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f44069d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private volatile List<? extends kotlin.reflect.r> f44070e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.jvm.internal.v0$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0868a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f44071a;

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
                f44071a = iArr;
            }
        }

        private a() {
        }

        @NotNull
        public final String a(@NotNull kotlin.reflect.s typeParameter) {
            g0.p(typeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i6 = C0868a.f44071a[typeParameter.l().ordinal()];
            if (i6 == 1) {
                n1 n1Var = n1.f44123a;
            } else if (i6 == 2) {
                sb.append("in ");
            } else {
                if (i6 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                sb.append("out ");
            }
            sb.append(typeParameter.getName());
            return sb.toString();
        }
    }

    public v0(@Nullable Object obj, @NotNull String name, @NotNull KVariance variance, boolean z5) {
        g0.p(name, "name");
        g0.p(variance, "variance");
        this.f44066a = obj;
        this.f44067b = name;
        this.f44068c = variance;
        this.f44069d = z5;
    }

    public final void b(@NotNull List<? extends kotlin.reflect.r> upperBounds) {
        g0.p(upperBounds, "upperBounds");
        if (this.f44070e == null) {
            this.f44070e = upperBounds;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof v0)) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return g0.g(this.f44066a, v0Var.f44066a) && g0.g(getName(), v0Var.getName());
    }

    @Override // kotlin.reflect.s
    @NotNull
    public String getName() {
        return this.f44067b;
    }

    @Override // kotlin.reflect.s
    @NotNull
    public List<kotlin.reflect.r> getUpperBounds() {
        List list = this.f44070e;
        if (list != null) {
            return list;
        }
        List<kotlin.reflect.r> l6 = kotlin.collections.f0.l(o0.n(Object.class));
        this.f44070e = l6;
        return l6;
    }

    public int hashCode() {
        Object obj = this.f44066a;
        return ((obj != null ? obj.hashCode() : 0) * 31) + getName().hashCode();
    }

    @Override // kotlin.reflect.s
    public boolean j() {
        return this.f44069d;
    }

    @Override // kotlin.reflect.s
    @NotNull
    public KVariance l() {
        return this.f44068c;
    }

    @NotNull
    public String toString() {
        return f44065f.a(this);
    }

    public static /* synthetic */ void a() {
    }
}
