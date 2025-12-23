package kotlin.reflect;

import kotlin.NoWhenBranchMatchedException;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.1")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f47635c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final t f47636d = new t(null, null);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final KVariance f47637a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final r f47638b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @JvmStatic
        @NotNull
        public final t a(@NotNull r type) {
            g0.p(type, "type");
            return new t(KVariance.IN, type);
        }

        @JvmStatic
        @NotNull
        public final t b(@NotNull r type) {
            g0.p(type, "type");
            return new t(KVariance.OUT, type);
        }

        @NotNull
        public final t c() {
            return t.f47636d;
        }

        @JvmStatic
        @NotNull
        public final t e(@NotNull r type) {
            g0.p(type, "type");
            return new t(KVariance.INVARIANT, type);
        }

        @PublishedApi
        public static /* synthetic */ void d() {
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f47637a == tVar.f47637a && g0.g(this.f47638b, tVar.f47638b);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47639a;

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
            f47639a = iArr;
        }
    }

    @JvmStatic
    @NotNull
    public static final t c(@NotNull r rVar) {
        return f47635c.a(rVar);
    }

    public static /* synthetic */ t e(t tVar, KVariance kVariance, r rVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            kVariance = tVar.f47637a;
        }
        if ((i6 & 2) != 0) {
            rVar = tVar.f47638b;
        }
        return tVar.d(kVariance, rVar);
    }

    @JvmStatic
    @NotNull
    public static final t f(@NotNull r rVar) {
        return f47635c.b(rVar);
    }

    @JvmStatic
    @NotNull
    public static final t h(@NotNull r rVar) {
        return f47635c.e(rVar);
    }

    @Nullable
    public final KVariance a() {
        return this.f47637a;
    }

    @Nullable
    public final r b() {
        return this.f47638b;
    }

    @NotNull
    public final t d(@Nullable KVariance kVariance, @Nullable r rVar) {
        return new t(kVariance, rVar);
    }

    @Nullable
    public final KVariance g() {
        return this.f47637a;
    }

    @Nullable
    public final r getType() {
        return this.f47638b;
    }

    public int hashCode() {
        KVariance kVariance = this.f47637a;
        int hashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        r rVar = this.f47638b;
        return hashCode + (rVar != null ? rVar.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        KVariance kVariance = this.f47637a;
        int i6 = kVariance == null ? -1 : b.f47639a[kVariance.ordinal()];
        if (i6 == -1) {
            return "*";
        }
        if (i6 == 1) {
            return String.valueOf(this.f47638b);
        }
        if (i6 == 2) {
            return "in " + this.f47638b;
        }
        if (i6 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "out " + this.f47638b;
    }

    public t(@Nullable KVariance kVariance, @Nullable r rVar) {
        boolean z5;
        String str;
        this.f47637a = kVariance;
        this.f47638b = rVar;
        if (kVariance == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 == (rVar == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }
}
