package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i0 {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f45945k = new a(null);

    /* renamed from: l, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final i0 f45946l;

    /* renamed from: m, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final i0 f45947m;

    /* renamed from: n, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final i0 f45948n;

    /* renamed from: o, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final i0 f45949o;

    /* renamed from: p, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final i0 f45950p;

    /* renamed from: q, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final i0 f45951q;

    /* renamed from: r, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final i0 f45952r;

    /* renamed from: s, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final i0 f45953s;

    /* renamed from: t, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final i0 f45954t;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f45955a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f45956b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f45957c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f45958d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f45959e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private final i0 f45960f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f45961g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private final i0 f45962h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private final i0 f45963i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f45964j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    public i0() {
        this(false, false, false, false, false, null, false, null, null, false, 1023, null);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45965a;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f45965a = iArr;
        }
    }

    static {
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        i0 i0Var = new i0(z5, z6, z7, z8, z9, null, false, null, null, z10, 1023, null);
        f45946l = i0Var;
        i0 i0Var2 = new i0(false, false, z10, false, false, null, false, null, null, true, 511, null);
        f45947m = i0Var2;
        f45948n = new i0(false, true, false, false, false, null, false, null, null, false, 1021, null);
        f45949o = new i0(z5, z6, z7, z8, z9, i0Var, false, null, null, z10, 988, null);
        f45950p = new i0(false, false, z10, false, false, i0Var2, false, null, null, true, 476, null);
        kotlin.jvm.internal.v vVar = null;
        boolean z11 = false;
        i0 i0Var3 = null;
        i0 i0Var4 = null;
        f45951q = new i0(z5, true, z7, z8, z9, i0Var, z11, i0Var3, i0Var4, z10, 988, vVar);
        boolean z12 = false;
        boolean z13 = true;
        f45952r = new i0(z5, z12, z7, z13, z9, i0Var, z11, i0Var3, i0Var4, z10, 983, vVar);
        f45953s = new i0(z5, z12, z7, z13, z9, i0Var, z11, i0Var3, i0Var4, z10, 919, vVar);
        f45954t = new i0(z5, z12, true, false, z9, i0Var, z11, i0Var3, i0Var4, z10, 984, vVar);
    }

    public i0(boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, @Nullable i0 i0Var, boolean z10, @Nullable i0 i0Var2, @Nullable i0 i0Var3, boolean z11) {
        this.f45955a = z5;
        this.f45956b = z6;
        this.f45957c = z7;
        this.f45958d = z8;
        this.f45959e = z9;
        this.f45960f = i0Var;
        this.f45961g = z10;
        this.f45962h = i0Var2;
        this.f45963i = i0Var3;
        this.f45964j = z11;
    }

    public final boolean a() {
        return this.f45961g;
    }

    public final boolean b() {
        return this.f45964j;
    }

    public final boolean c() {
        return this.f45956b;
    }

    public final boolean d() {
        return this.f45955a;
    }

    public final boolean e() {
        return this.f45957c;
    }

    @NotNull
    public final i0 f(@NotNull Variance effectiveVariance, boolean z5) {
        kotlin.jvm.internal.g0.p(effectiveVariance, "effectiveVariance");
        if (!z5 || !this.f45957c) {
            int i6 = b.f45965a[effectiveVariance.ordinal()];
            if (i6 == 1) {
                i0 i0Var = this.f45962h;
                if (i0Var != null) {
                    return i0Var;
                }
            } else if (i6 != 2) {
                i0 i0Var2 = this.f45960f;
                if (i0Var2 != null) {
                    return i0Var2;
                }
            } else {
                i0 i0Var3 = this.f45963i;
                if (i0Var3 != null) {
                    return i0Var3;
                }
            }
        }
        return this;
    }

    @NotNull
    public final i0 g() {
        return new i0(this.f45955a, true, this.f45957c, this.f45958d, this.f45959e, this.f45960f, this.f45961g, this.f45962h, this.f45963i, false, 512, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ i0(boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, kotlin.reflect.jvm.internal.impl.load.kotlin.i0 r8, boolean r9, kotlin.reflect.jvm.internal.impl.load.kotlin.i0 r10, kotlin.reflect.jvm.internal.impl.load.kotlin.i0 r11, boolean r12, int r13, kotlin.jvm.internal.v r14) {
        /*
            r2 = this;
            r14 = r13 & 1
            r0 = 1
            if (r14 == 0) goto L6
            r3 = 1
        L6:
            r14 = r13 & 2
            if (r14 == 0) goto Lb
            r4 = 1
        Lb:
            r14 = r13 & 4
            r1 = 0
            if (r14 == 0) goto L11
            r5 = 0
        L11:
            r14 = r13 & 8
            if (r14 == 0) goto L16
            r6 = 0
        L16:
            r14 = r13 & 16
            if (r14 == 0) goto L1b
            r7 = 0
        L1b:
            r14 = r13 & 32
            if (r14 == 0) goto L20
            r8 = 0
        L20:
            r14 = r13 & 64
            if (r14 == 0) goto L25
            r9 = 1
        L25:
            r14 = r13 & 128(0x80, float:1.8E-43)
            if (r14 == 0) goto L2a
            r10 = r8
        L2a:
            r14 = r13 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L2f
            r11 = r8
        L2f:
            r13 = r13 & 512(0x200, float:7.17E-43)
            if (r13 == 0) goto L3f
            r13 = 0
        L34:
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            goto L41
        L3f:
            r13 = r12
            goto L34
        L41:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.i0.<init>(boolean, boolean, boolean, boolean, boolean, kotlin.reflect.jvm.internal.impl.load.kotlin.i0, boolean, kotlin.reflect.jvm.internal.impl.load.kotlin.i0, kotlin.reflect.jvm.internal.impl.load.kotlin.i0, boolean, int, kotlin.jvm.internal.v):void");
    }
}
