package kotlin.collections.unsigned;

import com.daimajia.numberprogressbar.BuildConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.a1;
import kotlin.collections.n;
import kotlin.d1;
import kotlin.e1;
import kotlin.internal.InlineOnly;
import kotlin.j1;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.k1;
import kotlin.o1;
import kotlin.v0;
import kotlin.w0;
import kotlin.z0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class b {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends kotlin.collections.d<z0> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f43698a;

        a(int[] iArr) {
            this.f43698a = iArr;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof z0) {
                return e(((z0) obj).q0());
            }
            return false;
        }

        public boolean e(int i6) {
            return a1.j(this.f43698a, i6);
        }

        public int f(int i6) {
            return a1.p(this.f43698a, i6);
        }

        public int g(int i6) {
            return n.Zf(this.f43698a, i6);
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        public int getSize() {
            return a1.r(this.f43698a);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof z0) {
                return g(((z0) obj).q0());
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean isEmpty() {
            return a1.v(this.f43698a);
        }

        public int j(int i6) {
            return n.di(this.f43698a, i6);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof z0) {
                return j(((z0) obj).q0());
            }
            return -1;
        }

        @Override // kotlin.collections.d, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i6) {
            return z0.b(f(i6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.collections.unsigned.b$b, reason: collision with other inner class name */
    public static final class C0860b extends kotlin.collections.d<d1> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long[] f43699a;

        C0860b(long[] jArr) {
            this.f43699a = jArr;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof d1) {
                return e(((d1) obj).q0());
            }
            return false;
        }

        public boolean e(long j6) {
            return e1.j(this.f43699a, j6);
        }

        public long f(int i6) {
            return e1.p(this.f43699a, i6);
        }

        public int g(long j6) {
            return n.ag(this.f43699a, j6);
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        public int getSize() {
            return e1.r(this.f43699a);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof d1) {
                return g(((d1) obj).q0());
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean isEmpty() {
            return e1.v(this.f43699a);
        }

        public int j(long j6) {
            return n.ei(this.f43699a, j6);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof d1) {
                return j(((d1) obj).q0());
            }
            return -1;
        }

        @Override // kotlin.collections.d, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i6) {
            return d1.b(f(i6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends kotlin.collections.d<v0> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f43700a;

        c(byte[] bArr) {
            this.f43700a = bArr;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof v0) {
                return e(((v0) obj).o0());
            }
            return false;
        }

        public boolean e(byte b6) {
            return w0.j(this.f43700a, b6);
        }

        public byte f(int i6) {
            return w0.p(this.f43700a, i6);
        }

        public int g(byte b6) {
            return n.Vf(this.f43700a, b6);
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        public int getSize() {
            return w0.r(this.f43700a);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof v0) {
                return g(((v0) obj).o0());
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean isEmpty() {
            return w0.v(this.f43700a);
        }

        public int j(byte b6) {
            return n.Zh(this.f43700a, b6);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof v0) {
                return j(((v0) obj).o0());
            }
            return -1;
        }

        @Override // kotlin.collections.d, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i6) {
            return v0.b(f(i6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends kotlin.collections.d<j1> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ short[] f43701a;

        d(short[] sArr) {
            this.f43701a = sArr;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof j1) {
                return e(((j1) obj).o0());
            }
            return false;
        }

        public boolean e(short s5) {
            return k1.j(this.f43701a, s5);
        }

        public short f(int i6) {
            return k1.p(this.f43701a, i6);
        }

        public int g(short s5) {
            return n.cg(this.f43701a, s5);
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        public int getSize() {
            return k1.r(this.f43701a);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof j1) {
                return g(((j1) obj).o0());
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean isEmpty() {
            return k1.v(this.f43701a);
        }

        public int j(short s5) {
            return n.gi(this.f43701a, s5);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof j1) {
                return j(((j1) obj).o0());
            }
            return -1;
        }

        @Override // kotlin.collections.d, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i6) {
            return j1.b(f(i6));
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ j1 A(short[] sArr, Comparator comparator) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$maxWith$0");
        g0.p(comparator, "comparator");
        return g.I6(sArr, comparator);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ d1 B(long[] jArr, Comparator comparator) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$maxWith$0");
        g0.p(comparator, "comparator");
        return g.J6(jArr, comparator);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ z0 C(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$min$0");
        return g.C7(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ v0 D(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$min$0");
        return g.D7(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ d1 E(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$min$0");
        return g.E7(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ j1 F(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$min$0");
        return g.F7(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    private static final /* synthetic */ <R extends Comparable<? super R>> v0 G(byte[] bArr, Function1<? super v0, ? extends R> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$minBy$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            return null;
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        if (Ie == 0) {
            return v0.b(p5);
        }
        R invoke = selector.invoke(v0.b(p5));
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte p6 = w0.p(bArr, i6);
                R invoke2 = selector.invoke(v0.b(p6));
                if (invoke.compareTo(invoke2) > 0) {
                    p5 = p6;
                    invoke = invoke2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return v0.b(p5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    private static final /* synthetic */ <R extends Comparable<? super R>> d1 H(long[] jArr, Function1<? super d1, ? extends R> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$minBy$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            return null;
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        if (Ne == 0) {
            return d1.b(p5);
        }
        R invoke = selector.invoke(d1.b(p5));
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long p6 = e1.p(jArr, i6);
                R invoke2 = selector.invoke(d1.b(p6));
                if (invoke.compareTo(invoke2) > 0) {
                    p5 = p6;
                    invoke = invoke2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return d1.b(p5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    private static final /* synthetic */ <R extends Comparable<? super R>> z0 I(int[] iArr, Function1<? super z0, ? extends R> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$minBy$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            return null;
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        if (Me == 0) {
            return z0.b(p5);
        }
        R invoke = selector.invoke(z0.b(p5));
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                int p6 = a1.p(iArr, i6);
                R invoke2 = selector.invoke(z0.b(p6));
                if (invoke.compareTo(invoke2) > 0) {
                    p5 = p6;
                    invoke = invoke2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return z0.b(p5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    private static final /* synthetic */ <R extends Comparable<? super R>> j1 J(short[] sArr, Function1<? super j1, ? extends R> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$minBy$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            return null;
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        if (Pe == 0) {
            return j1.b(p5);
        }
        R invoke = selector.invoke(j1.b(p5));
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short p6 = k1.p(sArr, i6);
                R invoke2 = selector.invoke(j1.b(p6));
                if (invoke.compareTo(invoke2) > 0) {
                    p5 = p6;
                    invoke = invoke2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return j1.b(p5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ v0 K(byte[] bArr, Comparator comparator) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$minWith$0");
        g0.p(comparator, "comparator");
        return g.K7(bArr, comparator);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ z0 L(int[] iArr, Comparator comparator) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$minWith$0");
        g0.p(comparator, "comparator");
        return g.L7(iArr, comparator);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ j1 M(short[] sArr, Comparator comparator) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$minWith$0");
        g0.p(comparator, "comparator");
        return g.M7(sArr, comparator);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ d1 N(long[] jArr, Comparator comparator) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$minWith$0");
        g0.p(comparator, "comparator");
        return g.N7(jArr, comparator);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal O(byte[] bArr, Function1<? super v0, ? extends BigDecimal> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        g0.o(valueOf, "valueOf(...)");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            valueOf = valueOf.add(selector.invoke(v0.b(w0.p(bArr, i6))));
            g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal P(int[] iArr, Function1<? super z0, ? extends BigDecimal> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        g0.o(valueOf, "valueOf(...)");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            valueOf = valueOf.add(selector.invoke(z0.b(a1.p(iArr, i6))));
            g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal Q(long[] jArr, Function1<? super d1, ? extends BigDecimal> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        g0.o(valueOf, "valueOf(...)");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            valueOf = valueOf.add(selector.invoke(d1.b(e1.p(jArr, i6))));
            g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal R(short[] sArr, Function1<? super j1, ? extends BigDecimal> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        g0.o(valueOf, "valueOf(...)");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            valueOf = valueOf.add(selector.invoke(j1.b(k1.p(sArr, i6))));
            g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger S(byte[] bArr, Function1<? super v0, ? extends BigInteger> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        g0.o(valueOf, "valueOf(...)");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            valueOf = valueOf.add(selector.invoke(v0.b(w0.p(bArr, i6))));
            g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger T(int[] iArr, Function1<? super z0, ? extends BigInteger> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        g0.o(valueOf, "valueOf(...)");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            valueOf = valueOf.add(selector.invoke(z0.b(a1.p(iArr, i6))));
            g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger U(long[] jArr, Function1<? super d1, ? extends BigInteger> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        g0.o(valueOf, "valueOf(...)");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            valueOf = valueOf.add(selector.invoke(d1.b(e1.p(jArr, i6))));
            g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger V(short[] sArr, Function1<? super j1, ? extends BigInteger> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        g0.o(valueOf, "valueOf(...)");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            valueOf = valueOf.add(selector.invoke(j1.b(k1.p(sArr, i6))));
            g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<z0> a(@NotNull int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$asList$0");
        return new a(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<v0> b(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$asList$0");
        return new c(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<d1> c(@NotNull long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$asList$0");
        return new C0860b(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<j1> d(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$asList$0");
        return new d(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int e(@NotNull int[] iArr, int i6, int i7, int i8) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$binarySearch$0");
        kotlin.collections.d.Companion.d(i7, i8, a1.r(iArr));
        int i9 = i8 - 1;
        while (i7 <= i9) {
            int i10 = (i7 + i9) >>> 1;
            int e6 = o1.e(iArr[i10], i6);
            if (e6 < 0) {
                i7 = i10 + 1;
            } else {
                if (e6 <= 0) {
                    return i10;
                }
                i9 = i10 - 1;
            }
        }
        return -(i7 + 1);
    }

    public static /* synthetic */ int f(int[] iArr, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = a1.r(iArr);
        }
        return e(iArr, i6, i7, i8);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int g(@NotNull short[] sArr, short s5, int i6, int i7) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$binarySearch$0");
        kotlin.collections.d.Companion.d(i6, i7, k1.r(sArr));
        int i8 = s5 & j1.f43986d;
        int i9 = i7 - 1;
        while (i6 <= i9) {
            int i10 = (i6 + i9) >>> 1;
            int e6 = o1.e(sArr[i10], i8);
            if (e6 < 0) {
                i6 = i10 + 1;
            } else {
                if (e6 <= 0) {
                    return i10;
                }
                i9 = i10 - 1;
            }
        }
        return -(i6 + 1);
    }

    public static /* synthetic */ int h(short[] sArr, short s5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = k1.r(sArr);
        }
        return g(sArr, s5, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int i(@NotNull long[] jArr, long j6, int i6, int i7) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$binarySearch$0");
        kotlin.collections.d.Companion.d(i6, i7, e1.r(jArr));
        int i8 = i7 - 1;
        while (i6 <= i8) {
            int i9 = (i6 + i8) >>> 1;
            int n6 = o1.n(jArr[i9], j6);
            if (n6 < 0) {
                i6 = i9 + 1;
            } else {
                if (n6 <= 0) {
                    return i9;
                }
                i8 = i9 - 1;
            }
        }
        return -(i6 + 1);
    }

    public static /* synthetic */ int j(long[] jArr, long j6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = e1.r(jArr);
        }
        return i(jArr, j6, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int k(@NotNull byte[] bArr, byte b6, int i6, int i7) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$binarySearch$0");
        kotlin.collections.d.Companion.d(i6, i7, w0.r(bArr));
        int i8 = b6 & 255;
        int i9 = i7 - 1;
        while (i6 <= i9) {
            int i10 = (i6 + i9) >>> 1;
            int e6 = o1.e(bArr[i10], i8);
            if (e6 < 0) {
                i6 = i10 + 1;
            } else {
                if (e6 <= 0) {
                    return i10;
                }
                i9 = i10 - 1;
            }
        }
        return -(i6 + 1);
    }

    public static /* synthetic */ int l(byte[] bArr, byte b6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = w0.r(bArr);
        }
        return k(bArr, b6, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte m(byte[] bArr, int i6) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$elementAt$0");
        return w0.p(bArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short n(short[] sArr, int i6) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$elementAt$0");
        return k1.p(sArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int o(int[] iArr, int i6) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$elementAt$0");
        return a1.p(iArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long p(long[] jArr, int i6) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$elementAt$0");
        return e1.p(jArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ z0 q(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$max$0");
        return g.y6(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ v0 r(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$max$0");
        return g.z6(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ d1 s(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$max$0");
        return g.A6(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ j1 t(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$max$0");
        return g.B6(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    private static final /* synthetic */ <R extends Comparable<? super R>> v0 u(byte[] bArr, Function1<? super v0, ? extends R> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$maxBy$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            return null;
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        if (Ie == 0) {
            return v0.b(p5);
        }
        R invoke = selector.invoke(v0.b(p5));
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte p6 = w0.p(bArr, i6);
                R invoke2 = selector.invoke(v0.b(p6));
                if (invoke.compareTo(invoke2) < 0) {
                    p5 = p6;
                    invoke = invoke2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return v0.b(p5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    private static final /* synthetic */ <R extends Comparable<? super R>> d1 v(long[] jArr, Function1<? super d1, ? extends R> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$maxBy$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            return null;
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        if (Ne == 0) {
            return d1.b(p5);
        }
        R invoke = selector.invoke(d1.b(p5));
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long p6 = e1.p(jArr, i6);
                R invoke2 = selector.invoke(d1.b(p6));
                if (invoke.compareTo(invoke2) < 0) {
                    p5 = p6;
                    invoke = invoke2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return d1.b(p5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    private static final /* synthetic */ <R extends Comparable<? super R>> z0 w(int[] iArr, Function1<? super z0, ? extends R> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$maxBy$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            return null;
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        if (Me == 0) {
            return z0.b(p5);
        }
        R invoke = selector.invoke(z0.b(p5));
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                int p6 = a1.p(iArr, i6);
                R invoke2 = selector.invoke(z0.b(p6));
                if (invoke.compareTo(invoke2) < 0) {
                    p5 = p6;
                    invoke = invoke2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return z0.b(p5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    private static final /* synthetic */ <R extends Comparable<? super R>> j1 x(short[] sArr, Function1<? super j1, ? extends R> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$maxBy$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            return null;
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        if (Pe == 0) {
            return j1.b(p5);
        }
        R invoke = selector.invoke(j1.b(p5));
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short p6 = k1.p(sArr, i6);
                R invoke2 = selector.invoke(j1.b(p6));
                if (invoke.compareTo(invoke2) < 0) {
                    p5 = p6;
                    invoke = invoke2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return j1.b(p5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ v0 y(byte[] bArr, Comparator comparator) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$maxWith$0");
        g0.p(comparator, "comparator");
        return g.G6(bArr, comparator);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ z0 z(int[] iArr, Comparator comparator) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$maxWith$0");
        g0.p(comparator, "comparator");
        return g.H6(iArr, comparator);
    }
}
