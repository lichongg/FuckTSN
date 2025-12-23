package kotlin.collections;

import com.daimajia.numberprogressbar.BuildConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3051:1\n14484#2,14:3052\n14514#2,14:3066\n14544#2,14:3080\n14574#2,14:3094\n14604#2,14:3108\n14634#2,14:3122\n14664#2,14:3136\n14694#2,14:3150\n14724#2,14:3164\n17456#2,14:3178\n17486#2,14:3192\n17516#2,14:3206\n17546#2,14:3220\n17576#2,14:3234\n17606#2,14:3248\n17636#2,14:3262\n17666#2,14:3276\n17696#2,14:3290\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt\n*L\n2443#1:3052,14\n2450#1:3066,14\n2457#1:3080,14\n2464#1:3094,14\n2471#1:3108,14\n2478#1:3122,14\n2485#1:3136,14\n2492#1:3150,14\n2499#1:3164,14\n2641#1:3178,14\n2648#1:3192,14\n2655#1:3206,14\n2662#1:3220,14\n2669#1:3234,14\n2676#1:3248,14\n2683#1:3262,14\n2690#1:3276,14\n2697#1:3290,14\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class q extends p {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends kotlin.collections.d<Byte> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f43665a;

        a(byte[] bArr) {
            this.f43665a = bArr;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Byte) {
                return e(((Number) obj).byteValue());
            }
            return false;
        }

        public boolean e(byte b6) {
            return a0.v8(this.f43665a, b6);
        }

        @Override // kotlin.collections.d, java.util.List
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Byte get(int i6) {
            return Byte.valueOf(this.f43665a[i6]);
        }

        public int g(byte b6) {
            return a0.Vf(this.f43665a, b6);
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        public int getSize() {
            return this.f43665a.length;
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Byte) {
                return g(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean isEmpty() {
            return this.f43665a.length == 0;
        }

        public int j(byte b6) {
            return a0.Zh(this.f43665a, b6);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Byte) {
                return j(((Number) obj).byteValue());
            }
            return -1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends kotlin.collections.d<Short> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ short[] f43666a;

        b(short[] sArr) {
            this.f43666a = sArr;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Short) {
                return e(((Number) obj).shortValue());
            }
            return false;
        }

        public boolean e(short s5) {
            return a0.C8(this.f43666a, s5);
        }

        @Override // kotlin.collections.d, java.util.List
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Short get(int i6) {
            return Short.valueOf(this.f43666a[i6]);
        }

        public int g(short s5) {
            return a0.cg(this.f43666a, s5);
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        public int getSize() {
            return this.f43666a.length;
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Short) {
                return g(((Number) obj).shortValue());
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean isEmpty() {
            return this.f43666a.length == 0;
        }

        public int j(short s5) {
            return a0.gi(this.f43666a, s5);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Short) {
                return j(((Number) obj).shortValue());
            }
            return -1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends kotlin.collections.d<Integer> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f43667a;

        c(int[] iArr) {
            this.f43667a = iArr;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return e(((Number) obj).intValue());
            }
            return false;
        }

        public boolean e(int i6) {
            return a0.z8(this.f43667a, i6);
        }

        @Override // kotlin.collections.d, java.util.List
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Integer get(int i6) {
            return Integer.valueOf(this.f43667a[i6]);
        }

        public int g(int i6) {
            return a0.Zf(this.f43667a, i6);
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        public int getSize() {
            return this.f43667a.length;
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return g(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean isEmpty() {
            return this.f43667a.length == 0;
        }

        public int j(int i6) {
            return a0.di(this.f43667a, i6);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return j(((Number) obj).intValue());
            }
            return -1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends kotlin.collections.d<Long> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long[] f43668a;

        d(long[] jArr) {
            this.f43668a = jArr;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Long) {
                return e(((Number) obj).longValue());
            }
            return false;
        }

        public boolean e(long j6) {
            return a0.A8(this.f43668a, j6);
        }

        @Override // kotlin.collections.d, java.util.List
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Long get(int i6) {
            return Long.valueOf(this.f43668a[i6]);
        }

        public int g(long j6) {
            return a0.ag(this.f43668a, j6);
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        public int getSize() {
            return this.f43668a.length;
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Long) {
                return g(((Number) obj).longValue());
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean isEmpty() {
            return this.f43668a.length == 0;
        }

        public int j(long j6) {
            return a0.ei(this.f43668a, j6);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return j(((Number) obj).longValue());
            }
            return -1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$5\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3051:1\n13020#2,2:3052\n1832#2,6:3054\n1940#2,6:3060\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$5\n*L\n199#1:3052,2\n201#1:3054,6\n202#1:3060,6\n*E\n"})
    public static final class e extends kotlin.collections.d<Float> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f43669a;

        e(float[] fArr) {
            this.f43669a = fArr;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Float) {
                return e(((Number) obj).floatValue());
            }
            return false;
        }

        public boolean e(float f6) {
            for (float f7 : this.f43669a) {
                if (Float.floatToIntBits(f7) == Float.floatToIntBits(f6)) {
                    return true;
                }
            }
            return false;
        }

        @Override // kotlin.collections.d, java.util.List
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Float get(int i6) {
            return Float.valueOf(this.f43669a[i6]);
        }

        public int g(float f6) {
            float[] fArr = this.f43669a;
            int length = fArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                if (Float.floatToIntBits(fArr[i6]) == Float.floatToIntBits(f6)) {
                    return i6;
                }
            }
            return -1;
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        public int getSize() {
            return this.f43669a.length;
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Float) {
                return g(((Number) obj).floatValue());
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean isEmpty() {
            return this.f43669a.length == 0;
        }

        public int j(float f6) {
            float[] fArr = this.f43669a;
            int length = fArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i6 = length - 1;
                    if (Float.floatToIntBits(fArr[length]) == Float.floatToIntBits(f6)) {
                        return length;
                    }
                    if (i6 < 0) {
                        break;
                    }
                    length = i6;
                }
            }
            return -1;
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Float) {
                return j(((Number) obj).floatValue());
            }
            return -1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$6\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3051:1\n13030#2,2:3052\n1844#2,6:3054\n1952#2,6:3060\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$6\n*L\n213#1:3052,2\n215#1:3054,6\n216#1:3060,6\n*E\n"})
    public static final class f extends kotlin.collections.d<Double> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ double[] f43670a;

        f(double[] dArr) {
            this.f43670a = dArr;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Double) {
                return e(((Number) obj).doubleValue());
            }
            return false;
        }

        public boolean e(double d6) {
            for (double d7 : this.f43670a) {
                if (Double.doubleToLongBits(d7) == Double.doubleToLongBits(d6)) {
                    return true;
                }
            }
            return false;
        }

        @Override // kotlin.collections.d, java.util.List
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Double get(int i6) {
            return Double.valueOf(this.f43670a[i6]);
        }

        public int g(double d6) {
            double[] dArr = this.f43670a;
            int length = dArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                if (Double.doubleToLongBits(dArr[i6]) == Double.doubleToLongBits(d6)) {
                    return i6;
                }
            }
            return -1;
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        public int getSize() {
            return this.f43670a.length;
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Double) {
                return g(((Number) obj).doubleValue());
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean isEmpty() {
            return this.f43670a.length == 0;
        }

        public int j(double d6) {
            double[] dArr = this.f43670a;
            int length = dArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i6 = length - 1;
                    if (Double.doubleToLongBits(dArr[length]) == Double.doubleToLongBits(d6)) {
                        return length;
                    }
                    if (i6 < 0) {
                        break;
                    }
                    length = i6;
                }
            }
            return -1;
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return j(((Number) obj).doubleValue());
            }
            return -1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class g extends kotlin.collections.d<Boolean> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean[] f43671a;

        g(boolean[] zArr) {
            this.f43671a = zArr;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Boolean) {
                return e(((Boolean) obj).booleanValue());
            }
            return false;
        }

        public boolean e(boolean z5) {
            return a0.D8(this.f43671a, z5);
        }

        @Override // kotlin.collections.d, java.util.List
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean get(int i6) {
            return Boolean.valueOf(this.f43671a[i6]);
        }

        public int g(boolean z5) {
            return a0.dg(this.f43671a, z5);
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        public int getSize() {
            return this.f43671a.length;
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Boolean) {
                return g(((Boolean) obj).booleanValue());
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean isEmpty() {
            return this.f43671a.length == 0;
        }

        public int j(boolean z5) {
            return a0.hi(this.f43671a, z5);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Boolean) {
                return j(((Boolean) obj).booleanValue());
            }
            return -1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class h extends kotlin.collections.d<Character> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ char[] f43672a;

        h(char[] cArr) {
            this.f43672a = cArr;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Character) {
                return e(((Character) obj).charValue());
            }
            return false;
        }

        public boolean e(char c6) {
            return a0.w8(this.f43672a, c6);
        }

        @Override // kotlin.collections.d, java.util.List
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Character get(int i6) {
            return Character.valueOf(this.f43672a[i6]);
        }

        public int g(char c6) {
            return a0.Wf(this.f43672a, c6);
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        public int getSize() {
            return this.f43672a.length;
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Character) {
                return g(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean isEmpty() {
            return this.f43672a.length == 0;
        }

        public int j(char c6) {
            return a0.ai(this.f43672a, c6);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Character) {
                return j(((Character) obj).charValue());
            }
            return -1;
        }
    }

    public static final int A(@NotNull int[] iArr, int i6, int i7, int i8) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return Arrays.binarySearch(iArr, i7, i8, i6);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static long[] A0(@NotNull long[] jArr, @NotNull long[] destination, int i6, int i7, int i8) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        System.arraycopy(jArr, i7, destination, i6, i8 - i7);
        return destination;
    }

    @InlineOnly
    private static final float A1(float[] fArr, int i6) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return fArr[i6];
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Object A2(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(objArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.Bl(objArr, comparator);
    }

    @NotNull
    public static short[] A3(@NotNull short[] sArr, short s5) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        int length = sArr.length;
        short[] copyOf = Arrays.copyOf(sArr, length + 1);
        copyOf[length] = s5;
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger A4(short[] sArr, Function1<? super Short, ? extends BigInteger> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (short s5 : sArr) {
            valueOf = valueOf.add(selector.invoke(Short.valueOf(s5)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    public static final int B(@NotNull long[] jArr, long j6, int i6, int i7) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return Arrays.binarySearch(jArr, i6, i7, j6);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> T[] B0(@NotNull T[] tArr, @NotNull T[] destination, int i6, int i7, int i8) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        System.arraycopy(tArr, i7, destination, i6, i8 - i7);
        return destination;
    }

    @InlineOnly
    private static final int B1(int[] iArr, int i6) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return iArr[i6];
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Short B2(short[] sArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.Cl(sArr, comparator);
    }

    @NotNull
    public static short[] B3(@NotNull short[] sArr, @NotNull short[] elements) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = sArr.length;
        int length2 = elements.length;
        short[] copyOf = Arrays.copyOf(sArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger B4(boolean[] zArr, Function1<? super Boolean, ? extends BigInteger> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (boolean z5 : zArr) {
            valueOf = valueOf.add(selector.invoke(Boolean.valueOf(z5)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    public static final <T> int C(@NotNull T[] tArr, T t5, int i6, int i7) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return Arrays.binarySearch(tArr, i6, i7, t5);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static short[] C0(@NotNull short[] sArr, @NotNull short[] destination, int i6, int i7, int i8) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        System.arraycopy(sArr, i7, destination, i6, i8 - i7);
        return destination;
    }

    @InlineOnly
    private static final long C1(long[] jArr, int i6) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return jArr[i6];
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Byte C2(byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return a0.yn(bArr);
    }

    @NotNull
    public static final boolean[] C3(@NotNull boolean[] zArr, @NotNull Collection<Boolean> elements) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = zArr.length;
        boolean[] copyOf = Arrays.copyOf(zArr, elements.size() + length);
        Iterator<Boolean> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().booleanValue();
            length++;
        }
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @NotNull
    public static final SortedSet<Byte> C4(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return (SortedSet) a0.Cy(bArr, new TreeSet());
    }

    public static final <T> int D(@NotNull T[] tArr, T t5, @NotNull Comparator<? super T> comparator, int i6, int i7) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return Arrays.binarySearch(tArr, i6, i7, t5, comparator);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final boolean[] D0(@NotNull boolean[] zArr, @NotNull boolean[] destination, int i6, int i7, int i8) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        System.arraycopy(zArr, i7, destination, i6, i8 - i7);
        return destination;
    }

    @InlineOnly
    private static final <T> T D1(T[] tArr, int i6) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return tArr[i6];
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character D2(char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return a0.zn(cArr);
    }

    @NotNull
    public static final boolean[] D3(@NotNull boolean[] zArr, boolean z5) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        int length = zArr.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + 1);
        copyOf[length] = z5;
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @NotNull
    public static final SortedSet<Character> D4(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return (SortedSet) a0.Dy(cArr, new TreeSet());
    }

    public static final int E(@NotNull short[] sArr, short s5, int i6, int i7) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return Arrays.binarySearch(sArr, i6, i7, s5);
    }

    public static /* synthetic */ byte[] E0(byte[] bArr, byte[] bArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = bArr.length;
        }
        return v0(bArr, bArr2, i6, i7, i8);
    }

    @InlineOnly
    private static final short E1(short[] sArr, int i6) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return sArr[i6];
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Comparable E2(Comparable[] comparableArr) {
        kotlin.jvm.internal.g0.p(comparableArr, "<this>");
        return a0.An(comparableArr);
    }

    @NotNull
    public static final boolean[] E3(@NotNull boolean[] zArr, @NotNull boolean[] elements) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = zArr.length;
        int length2 = elements.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @NotNull
    public static final SortedSet<Double> E4(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return (SortedSet) a0.Ey(dArr, new TreeSet());
    }

    public static /* synthetic */ int F(byte[] bArr, byte b6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = bArr.length;
        }
        return w(bArr, b6, i6, i7);
    }

    public static /* synthetic */ char[] F0(char[] cArr, char[] cArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = cArr.length;
        }
        return w0(cArr, cArr2, i6, i7, i8);
    }

    @InlineOnly
    private static final boolean F1(boolean[] zArr, int i6) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return zArr[i6];
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double F2(double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return a0.Bn(dArr);
    }

    @InlineOnly
    private static final <T> T[] F3(T[] tArr, T t5) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return (T[]) w3(tArr, t5);
    }

    @NotNull
    public static final SortedSet<Float> F4(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return (SortedSet) a0.Fy(fArr, new TreeSet());
    }

    public static /* synthetic */ int G(char[] cArr, char c6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = cArr.length;
        }
        return x(cArr, c6, i6, i7);
    }

    public static /* synthetic */ double[] G0(double[] dArr, double[] dArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = dArr.length;
        }
        return x0(dArr, dArr2, i6, i7, i8);
    }

    public static void G1(@NotNull byte[] bArr, byte b6, int i6, int i7) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        Arrays.fill(bArr, i6, i7, b6);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double G2(Double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return a0.Cn(dArr);
    }

    public static final void G3(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        if (bArr.length > 1) {
            Arrays.sort(bArr);
        }
    }

    @NotNull
    public static final SortedSet<Integer> G4(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return (SortedSet) a0.Gy(iArr, new TreeSet());
    }

    public static /* synthetic */ int H(double[] dArr, double d6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = dArr.length;
        }
        return y(dArr, d6, i6, i7);
    }

    public static /* synthetic */ float[] H0(float[] fArr, float[] fArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = fArr.length;
        }
        return y0(fArr, fArr2, i6, i7, i8);
    }

    public static void H1(@NotNull char[] cArr, char c6, int i6, int i7) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        Arrays.fill(cArr, i6, i7, c6);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float H2(float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return a0.Dn(fArr);
    }

    public static final void H3(@NotNull byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        Arrays.sort(bArr, i6, i7);
    }

    @NotNull
    public static final SortedSet<Long> H4(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return (SortedSet) a0.Hy(jArr, new TreeSet());
    }

    public static /* synthetic */ int I(float[] fArr, float f6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = fArr.length;
        }
        return z(fArr, f6, i6, i7);
    }

    public static /* synthetic */ int[] I0(int[] iArr, int[] iArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = iArr.length;
        }
        return z0(iArr, iArr2, i6, i7, i8);
    }

    public static final void I1(@NotNull double[] dArr, double d6, int i6, int i7) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        Arrays.fill(dArr, i6, i7, d6);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float I2(Float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return a0.En(fArr);
    }

    public static final void I3(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        if (cArr.length > 1) {
            Arrays.sort(cArr);
        }
    }

    @NotNull
    public static final <T extends Comparable<? super T>> SortedSet<T> I4(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return (SortedSet) a0.Iy(tArr, new TreeSet());
    }

    public static /* synthetic */ int J(int[] iArr, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = iArr.length;
        }
        return A(iArr, i6, i7, i8);
    }

    public static /* synthetic */ long[] J0(long[] jArr, long[] jArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = jArr.length;
        }
        return A0(jArr, jArr2, i6, i7, i8);
    }

    public static final void J1(@NotNull float[] fArr, float f6, int i6, int i7) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        Arrays.fill(fArr, i6, i7, f6);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Integer J2(int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return a0.Fn(iArr);
    }

    public static final void J3(@NotNull char[] cArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        Arrays.sort(cArr, i6, i7);
    }

    @NotNull
    public static final <T> SortedSet<T> J4(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return (SortedSet) a0.Iy(tArr, new TreeSet(comparator));
    }

    public static /* synthetic */ int K(long[] jArr, long j6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = jArr.length;
        }
        return B(jArr, j6, i6, i7);
    }

    public static /* synthetic */ Object[] K0(Object[] objArr, Object[] objArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = objArr.length;
        }
        return B0(objArr, objArr2, i6, i7, i8);
    }

    public static void K1(@NotNull int[] iArr, int i6, int i7, int i8) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        Arrays.fill(iArr, i7, i8, i6);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Long K2(long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return a0.Gn(jArr);
    }

    public static final void K3(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        if (dArr.length > 1) {
            Arrays.sort(dArr);
        }
    }

    @NotNull
    public static final SortedSet<Short> K4(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return (SortedSet) a0.Jy(sArr, new TreeSet());
    }

    public static /* synthetic */ int L(Object[] objArr, Object obj, int i6, int i7, int i8, Object obj2) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = objArr.length;
        }
        return C(objArr, obj, i6, i7);
    }

    public static /* synthetic */ short[] L0(short[] sArr, short[] sArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = sArr.length;
        }
        return C0(sArr, sArr2, i6, i7, i8);
    }

    public static void L1(@NotNull long[] jArr, long j6, int i6, int i7) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        Arrays.fill(jArr, i6, i7, j6);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Short L2(short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return a0.Hn(sArr);
    }

    public static final void L3(@NotNull double[] dArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        Arrays.sort(dArr, i6, i7);
    }

    @NotNull
    public static final SortedSet<Boolean> L4(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return (SortedSet) a0.Ky(zArr, new TreeSet());
    }

    public static /* synthetic */ int M(Object[] objArr, Object obj, Comparator comparator, int i6, int i7, int i8, Object obj2) {
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = objArr.length;
        }
        return D(objArr, obj, comparator, i6, i7);
    }

    public static /* synthetic */ boolean[] M0(boolean[] zArr, boolean[] zArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = zArr.length;
        }
        return D0(zArr, zArr2, i6, i7, i8);
    }

    public static <T> void M1(@NotNull T[] tArr, T t5, int i6, int i7) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        Arrays.fill(tArr, i6, i7, t5);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Boolean M2(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z5 = zArr[0];
        int Qe = a0.Qe(zArr);
        if (Qe == 0) {
            return Boolean.valueOf(z5);
        }
        R invoke = selector.invoke(Boolean.valueOf(z5));
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                boolean z6 = zArr[i6];
                R invoke2 = selector.invoke(Boolean.valueOf(z6));
                if (invoke.compareTo(invoke2) > 0) {
                    z5 = z6;
                    invoke = invoke2;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return Boolean.valueOf(z5);
    }

    public static final void M3(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        if (fArr.length > 1) {
            Arrays.sort(fArr);
        }
    }

    @NotNull
    public static final Boolean[] M4(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            boolArr[i6] = Boolean.valueOf(zArr[i6]);
        }
        return boolArr;
    }

    public static /* synthetic */ int N(short[] sArr, short s5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = sArr.length;
        }
        return E(sArr, s5, i6, i7);
    }

    @InlineOnly
    private static final byte[] N0(byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static void N1(@NotNull short[] sArr, short s5, int i6, int i7) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        Arrays.fill(sArr, i6, i7, s5);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Byte N2(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b6 = bArr[0];
        int Ie = a0.Ie(bArr);
        if (Ie == 0) {
            return Byte.valueOf(b6);
        }
        R invoke = selector.invoke(Byte.valueOf(b6));
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte b7 = bArr[i6];
                R invoke2 = selector.invoke(Byte.valueOf(b7));
                if (invoke.compareTo(invoke2) > 0) {
                    b6 = b7;
                    invoke = invoke2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Byte.valueOf(b6);
    }

    public static void N3(@NotNull float[] fArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        Arrays.sort(fArr, i6, i7);
    }

    @NotNull
    public static final Byte[] N4(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        Byte[] bArr2 = new Byte[bArr.length];
        int length = bArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            bArr2[i6] = Byte.valueOf(bArr[i6]);
        }
        return bArr2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    @JvmName(name = "contentDeepEqualsInline")
    @LowPriorityInOverloadResolution
    private static final <T> boolean O(T[] tArr, T[] other) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(other, "other");
        return p.g(tArr, other);
    }

    @InlineOnly
    private static final byte[] O0(byte[] bArr, int i6) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        byte[] copyOf = Arrays.copyOf(bArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static final void O1(@NotNull boolean[] zArr, boolean z5, int i6, int i7) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        Arrays.fill(zArr, i6, i7, z5);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Character O2(char[] cArr, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c6 = cArr[0];
        int Je = a0.Je(cArr);
        if (Je == 0) {
            return Character.valueOf(c6);
        }
        R invoke = selector.invoke(Character.valueOf(c6));
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                char c7 = cArr[i6];
                R invoke2 = selector.invoke(Character.valueOf(c7));
                if (invoke.compareTo(invoke2) > 0) {
                    c6 = c7;
                    invoke = invoke2;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(c6);
    }

    public static final void O3(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    @NotNull
    public static final Character[] O4(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            chArr[i6] = Character.valueOf(cArr[i6]);
        }
        return chArr;
    }

    @InlineOnly
    private static final char[] P0(char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static /* synthetic */ void P1(byte[] bArr, byte b6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = bArr.length;
        }
        G1(bArr, b6, i6, i7);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Double P2(double[] dArr, Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d6 = dArr[0];
        int Ke = a0.Ke(dArr);
        if (Ke == 0) {
            return Double.valueOf(d6);
        }
        R invoke = selector.invoke(Double.valueOf(d6));
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                double d7 = dArr[i6];
                R invoke2 = selector.invoke(Double.valueOf(d7));
                if (invoke.compareTo(invoke2) > 0) {
                    d6 = d7;
                    invoke = invoke2;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(d6);
    }

    public static void P3(@NotNull int[] iArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        Arrays.sort(iArr, i6, i7);
    }

    @NotNull
    public static final Double[] P4(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        Double[] dArr2 = new Double[dArr.length];
        int length = dArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            dArr2[i6] = Double.valueOf(dArr[i6]);
        }
        return dArr2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    @JvmName(name = "contentDeepHashCodeInline")
    @LowPriorityInOverloadResolution
    private static final <T> int Q(T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return o.b(tArr);
    }

    @InlineOnly
    private static final char[] Q0(char[] cArr, int i6) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        char[] copyOf = Arrays.copyOf(cArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static /* synthetic */ void Q1(char[] cArr, char c6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = cArr.length;
        }
        H1(cArr, c6, i6, i7);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Float Q2(float[] fArr, Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int Le = a0.Le(fArr);
        if (Le == 0) {
            return Float.valueOf(f6);
        }
        R invoke = selector.invoke(Float.valueOf(f6));
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                float f7 = fArr[i6];
                R invoke2 = selector.invoke(Float.valueOf(f7));
                if (invoke.compareTo(invoke2) > 0) {
                    f6 = f7;
                    invoke = invoke2;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(f6);
    }

    public static final void Q3(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        if (jArr.length > 1) {
            Arrays.sort(jArr);
        }
    }

    @NotNull
    public static final Float[] Q4(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            fArr2[i6] = Float.valueOf(fArr[i6]);
        }
        return fArr2;
    }

    @InlineOnly
    private static final double[] R0(double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static /* synthetic */ void R1(double[] dArr, double d6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = dArr.length;
        }
        I1(dArr, d6, i6, i7);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Integer R2(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i6 = iArr[0];
        int Me = a0.Me(iArr);
        if (Me == 0) {
            return Integer.valueOf(i6);
        }
        R invoke = selector.invoke(Integer.valueOf(i6));
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                int i8 = iArr[i7];
                R invoke2 = selector.invoke(Integer.valueOf(i8));
                if (invoke.compareTo(invoke2) > 0) {
                    i6 = i8;
                    invoke = invoke2;
                }
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return Integer.valueOf(i6);
    }

    public static void R3(@NotNull long[] jArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        Arrays.sort(jArr, i6, i7);
    }

    @NotNull
    public static final Integer[] R4(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            numArr[i6] = Integer.valueOf(iArr[i6]);
        }
        return numArr;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    @JvmName(name = "contentDeepToStringInline")
    @LowPriorityInOverloadResolution
    private static final <T> String S(T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return p.h(tArr);
    }

    @InlineOnly
    private static final double[] S0(double[] dArr, int i6) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        double[] copyOf = Arrays.copyOf(dArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static /* synthetic */ void S1(float[] fArr, float f6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = fArr.length;
        }
        J1(fArr, f6, i6, i7);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Long S2(long[] jArr, Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int Ne = a0.Ne(jArr);
        if (Ne == 0) {
            return Long.valueOf(j6);
        }
        R invoke = selector.invoke(Long.valueOf(j6));
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long j7 = jArr[i6];
                R invoke2 = selector.invoke(Long.valueOf(j7));
                if (invoke.compareTo(invoke2) > 0) {
                    j6 = j7;
                    invoke = invoke2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Long.valueOf(j6);
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> void S3(T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        U3(tArr);
    }

    @NotNull
    public static final Long[] S4(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            lArr[i6] = Long.valueOf(jArr[i6]);
        }
        return lArr;
    }

    @InlineOnly
    private static final float[] T0(float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static /* synthetic */ void T1(int[] iArr, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = iArr.length;
        }
        K1(iArr, i6, i7, i8);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T T2(T[] tArr, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t5 = tArr[0];
        int Oe = a0.Oe(tArr);
        if (Oe != 0) {
            R invoke = selector.invoke(t5);
            int i6 = 1;
            if (1 <= Oe) {
                while (true) {
                    T t6 = tArr[i6];
                    R invoke2 = selector.invoke(t6);
                    if (invoke.compareTo(invoke2) > 0) {
                        t5 = t6;
                        invoke = invoke2;
                    }
                    if (i6 == Oe) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return t5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final <T extends Comparable<? super T>> void T3(@NotNull T[] tArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        Arrays.sort(tArr, i6, i7);
    }

    @NotNull
    public static final Short[] T4(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        Short[] shArr = new Short[sArr.length];
        int length = sArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            shArr[i6] = Short.valueOf(sArr[i6]);
        }
        return shArr;
    }

    @InlineOnly
    private static final float[] U0(float[] fArr, int i6) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        float[] copyOf = Arrays.copyOf(fArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static /* synthetic */ void U1(long[] jArr, long j6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = jArr.length;
        }
        L1(jArr, j6, i6, i7);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Short U2(short[] sArr, Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s5 = sArr[0];
        int Pe = a0.Pe(sArr);
        if (Pe == 0) {
            return Short.valueOf(s5);
        }
        R invoke = selector.invoke(Short.valueOf(s5));
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short s6 = sArr[i6];
                R invoke2 = selector.invoke(Short.valueOf(s6));
                if (invoke.compareTo(invoke2) > 0) {
                    s5 = s6;
                    invoke = invoke2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Short.valueOf(s5);
    }

    public static final <T> void U3(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    @InlineOnly
    private static final int[] V0(int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static /* synthetic */ void V1(Object[] objArr, Object obj, int i6, int i7, int i8, Object obj2) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = objArr.length;
        }
        M1(objArr, obj, i6, i7);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Boolean V2(boolean[] zArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.Sn(zArr, comparator);
    }

    public static final <T> void V3(@NotNull T[] tArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        Arrays.sort(tArr, i6, i7);
    }

    @InlineOnly
    private static final int[] W0(int[] iArr, int i6) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        int[] copyOf = Arrays.copyOf(iArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static /* synthetic */ void W1(short[] sArr, short s5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = sArr.length;
        }
        N1(sArr, s5, i6, i7);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Byte W2(byte[] bArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.Tn(bArr, comparator);
    }

    public static final void W3(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        if (sArr.length > 1) {
            Arrays.sort(sArr);
        }
    }

    @InlineOnly
    private static final long[] X0(long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static /* synthetic */ void X1(boolean[] zArr, boolean z5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = zArr.length;
        }
        O1(zArr, z5, i6, i7);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character X2(char[] cArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.Un(cArr, comparator);
    }

    public static final void X3(@NotNull short[] sArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        Arrays.sort(sArr, i6, i7);
    }

    @InlineOnly
    private static final long[] Y0(long[] jArr, int i6) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        long[] copyOf = Arrays.copyOf(jArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    @NotNull
    public static final <R> List<R> Y1(@NotNull Object[] objArr, @NotNull Class<R> klass) {
        kotlin.jvm.internal.g0.p(objArr, "<this>");
        kotlin.jvm.internal.g0.p(klass, "klass");
        return (List) Z1(objArr, new ArrayList(), klass);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double Y2(double[] dArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.Vn(dArr, comparator);
    }

    public static /* synthetic */ void Y3(byte[] bArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = bArr.length;
        }
        H3(bArr, i6, i7);
    }

    @InlineOnly
    private static final <T> T[] Z0(T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.g0.o(tArr2, "copyOf(...)");
        return tArr2;
    }

    @NotNull
    public static final <C extends Collection<? super R>, R> C Z1(@NotNull Object[] objArr, @NotNull C destination, @NotNull Class<R> klass) {
        kotlin.jvm.internal.g0.p(objArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(klass, "klass");
        for (Object obj : objArr) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float Z2(float[] fArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.Wn(fArr, comparator);
    }

    public static /* synthetic */ void Z3(char[] cArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = cArr.length;
        }
        J3(cArr, i6, i7);
    }

    @InlineOnly
    private static final <T> T[] a1(T[] tArr, int i6) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i6);
        kotlin.jvm.internal.g0.o(tArr2, "copyOf(...)");
        return tArr2;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Byte a2(byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return a0.al(bArr);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Integer a3(int[] iArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.Xn(iArr, comparator);
    }

    public static /* synthetic */ void a4(double[] dArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = dArr.length;
        }
        L3(dArr, i6, i7);
    }

    @InlineOnly
    private static final short[] b1(short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character b2(char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return a0.bl(cArr);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Long b3(long[] jArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.Yn(jArr, comparator);
    }

    public static /* synthetic */ void b4(float[] fArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = fArr.length;
        }
        N3(fArr, i6, i7);
    }

    @InlineOnly
    private static final short[] c1(short[] sArr, int i6) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        short[] copyOf = Arrays.copyOf(sArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Comparable c2(Comparable[] comparableArr) {
        kotlin.jvm.internal.g0.p(comparableArr, "<this>");
        return a0.cl(comparableArr);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Object c3(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(objArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.Zn(objArr, comparator);
    }

    public static /* synthetic */ void c4(int[] iArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = iArr.length;
        }
        P3(iArr, i6, i7);
    }

    @InlineOnly
    private static final boolean[] d1(boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        boolean[] copyOf = Arrays.copyOf(zArr, zArr.length);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double d2(double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return a0.dl(dArr);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Short d3(short[] sArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.ao(sArr, comparator);
    }

    public static /* synthetic */ void d4(long[] jArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = jArr.length;
        }
        R3(jArr, i6, i7);
    }

    @InlineOnly
    private static final boolean[] e1(boolean[] zArr, int i6) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        boolean[] copyOf = Arrays.copyOf(zArr, i6);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double e2(Double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return a0.el(dArr);
    }

    @NotNull
    public static byte[] e3(@NotNull byte[] bArr, byte b6) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        int length = bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + 1);
        copyOf[length] = b6;
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    public static /* synthetic */ void e4(Comparable[] comparableArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = comparableArr.length;
        }
        T3(comparableArr, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static byte[] f1(@NotNull byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        o.c(i7, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i6, i7);
        kotlin.jvm.internal.g0.o(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float f2(float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return a0.fl(fArr);
    }

    @NotNull
    public static final byte[] f3(@NotNull byte[] bArr, @NotNull Collection<Byte> elements) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, elements.size() + length);
        Iterator<Byte> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().byteValue();
            length++;
        }
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    public static /* synthetic */ void f4(Object[] objArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = objArr.length;
        }
        V3(objArr, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static final char[] g1(@NotNull char[] cArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        o.c(i7, cArr.length);
        char[] copyOfRange = Arrays.copyOfRange(cArr, i6, i7);
        kotlin.jvm.internal.g0.o(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float g2(Float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return a0.gl(fArr);
    }

    @NotNull
    public static byte[] g3(@NotNull byte[] bArr, @NotNull byte[] elements) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = bArr.length;
        int length2 = elements.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    public static /* synthetic */ void g4(short[] sArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = sArr.length;
        }
        X3(sArr, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static final double[] h1(@NotNull double[] dArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        o.c(i7, dArr.length);
        double[] copyOfRange = Arrays.copyOfRange(dArr, i6, i7);
        kotlin.jvm.internal.g0.o(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Integer h2(int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return a0.hl(iArr);
    }

    @NotNull
    public static final char[] h3(@NotNull char[] cArr, char c6) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        int length = cArr.length;
        char[] copyOf = Arrays.copyOf(cArr, length + 1);
        copyOf[length] = c6;
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    public static final <T> void h4(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static final float[] i1(@NotNull float[] fArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        o.c(i7, fArr.length);
        float[] copyOfRange = Arrays.copyOfRange(fArr, i6, i7);
        kotlin.jvm.internal.g0.o(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Long i2(long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return a0.il(jArr);
    }

    @NotNull
    public static final char[] i3(@NotNull char[] cArr, @NotNull Collection<Character> elements) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = cArr.length;
        char[] copyOf = Arrays.copyOf(cArr, elements.size() + length);
        Iterator<Character> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().charValue();
            length++;
        }
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    public static final <T> void i4(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator, int i6, int i7) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        Arrays.sort(tArr, i6, i7, comparator);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static int[] j1(@NotNull int[] iArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        o.c(i7, iArr.length);
        int[] copyOfRange = Arrays.copyOfRange(iArr, i6, i7);
        kotlin.jvm.internal.g0.o(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Short j2(short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return a0.jl(sArr);
    }

    @NotNull
    public static final char[] j3(@NotNull char[] cArr, @NotNull char[] elements) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = cArr.length;
        int length2 = elements.length;
        char[] copyOf = Arrays.copyOf(cArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    public static /* synthetic */ void j4(Object[] objArr, Comparator comparator, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = objArr.length;
        }
        i4(objArr, comparator, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static long[] k1(@NotNull long[] jArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        o.c(i7, jArr.length);
        long[] copyOfRange = Arrays.copyOfRange(jArr, i6, i7);
        kotlin.jvm.internal.g0.o(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Boolean k2(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z5 = zArr[0];
        int Qe = a0.Qe(zArr);
        if (Qe == 0) {
            return Boolean.valueOf(z5);
        }
        R invoke = selector.invoke(Boolean.valueOf(z5));
        int i6 = 1;
        if (1 <= Qe) {
            while (true) {
                boolean z6 = zArr[i6];
                R invoke2 = selector.invoke(Boolean.valueOf(z6));
                if (invoke.compareTo(invoke2) < 0) {
                    z5 = z6;
                    invoke = invoke2;
                }
                if (i6 == Qe) {
                    break;
                }
                i6++;
            }
        }
        return Boolean.valueOf(z5);
    }

    @NotNull
    public static final double[] k3(@NotNull double[] dArr, double d6) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        int length = dArr.length;
        double[] copyOf = Arrays.copyOf(dArr, length + 1);
        copyOf[length] = d6;
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal k4(byte[] bArr, Function1<? super Byte, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (byte b6 : bArr) {
            valueOf = valueOf.add(selector.invoke(Byte.valueOf(b6)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static <T> T[] l1(@NotNull T[] tArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        o.c(i7, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i6, i7);
        kotlin.jvm.internal.g0.o(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Byte l2(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b6 = bArr[0];
        int Ie = a0.Ie(bArr);
        if (Ie == 0) {
            return Byte.valueOf(b6);
        }
        R invoke = selector.invoke(Byte.valueOf(b6));
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte b7 = bArr[i6];
                R invoke2 = selector.invoke(Byte.valueOf(b7));
                if (invoke.compareTo(invoke2) < 0) {
                    b6 = b7;
                    invoke = invoke2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Byte.valueOf(b6);
    }

    @NotNull
    public static final double[] l3(@NotNull double[] dArr, @NotNull Collection<Double> elements) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = dArr.length;
        double[] copyOf = Arrays.copyOf(dArr, elements.size() + length);
        Iterator<Double> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().doubleValue();
            length++;
        }
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal l4(char[] cArr, Function1<? super Character, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (char c6 : cArr) {
            valueOf = valueOf.add(selector.invoke(Character.valueOf(c6)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static short[] m1(@NotNull short[] sArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        o.c(i7, sArr.length);
        short[] copyOfRange = Arrays.copyOfRange(sArr, i6, i7);
        kotlin.jvm.internal.g0.o(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Character m2(char[] cArr, Function1<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c6 = cArr[0];
        int Je = a0.Je(cArr);
        if (Je == 0) {
            return Character.valueOf(c6);
        }
        R invoke = selector.invoke(Character.valueOf(c6));
        int i6 = 1;
        if (1 <= Je) {
            while (true) {
                char c7 = cArr[i6];
                R invoke2 = selector.invoke(Character.valueOf(c7));
                if (invoke.compareTo(invoke2) < 0) {
                    c6 = c7;
                    invoke = invoke2;
                }
                if (i6 == Je) {
                    break;
                }
                i6++;
            }
        }
        return Character.valueOf(c6);
    }

    @NotNull
    public static final double[] m3(@NotNull double[] dArr, @NotNull double[] elements) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = dArr.length;
        int length2 = elements.length;
        double[] copyOf = Arrays.copyOf(dArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal m4(double[] dArr, Function1<? super Double, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (double d6 : dArr) {
            valueOf = valueOf.add(selector.invoke(Double.valueOf(d6)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @NotNull
    public static final List<Byte> n(@NotNull byte[] bArr) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return new a(bArr);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static final boolean[] n1(@NotNull boolean[] zArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        o.c(i7, zArr.length);
        boolean[] copyOfRange = Arrays.copyOfRange(zArr, i6, i7);
        kotlin.jvm.internal.g0.o(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Double n2(double[] dArr, Function1<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d6 = dArr[0];
        int Ke = a0.Ke(dArr);
        if (Ke == 0) {
            return Double.valueOf(d6);
        }
        R invoke = selector.invoke(Double.valueOf(d6));
        int i6 = 1;
        if (1 <= Ke) {
            while (true) {
                double d7 = dArr[i6];
                R invoke2 = selector.invoke(Double.valueOf(d7));
                if (invoke.compareTo(invoke2) < 0) {
                    d6 = d7;
                    invoke = invoke2;
                }
                if (i6 == Ke) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(d6);
    }

    @NotNull
    public static final float[] n3(@NotNull float[] fArr, float f6) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        int length = fArr.length;
        float[] copyOf = Arrays.copyOf(fArr, length + 1);
        copyOf[length] = f6;
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal n4(float[] fArr, Function1<? super Float, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (float f6 : fArr) {
            valueOf = valueOf.add(selector.invoke(Float.valueOf(f6)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @NotNull
    public static final List<Character> o(@NotNull char[] cArr) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return new h(cArr);
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final byte[] o1(byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return f1(bArr, i6, i7);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Float o2(float[] fArr, Function1<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int Le = a0.Le(fArr);
        if (Le == 0) {
            return Float.valueOf(f6);
        }
        R invoke = selector.invoke(Float.valueOf(f6));
        int i6 = 1;
        if (1 <= Le) {
            while (true) {
                float f7 = fArr[i6];
                R invoke2 = selector.invoke(Float.valueOf(f7));
                if (invoke.compareTo(invoke2) < 0) {
                    f6 = f7;
                    invoke = invoke2;
                }
                if (i6 == Le) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(f6);
    }

    @NotNull
    public static final float[] o3(@NotNull float[] fArr, @NotNull Collection<Float> elements) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = fArr.length;
        float[] copyOf = Arrays.copyOf(fArr, elements.size() + length);
        Iterator<Float> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().floatValue();
            length++;
        }
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal o4(int[] iArr, Function1<? super Integer, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (int i6 : iArr) {
            valueOf = valueOf.add(selector.invoke(Integer.valueOf(i6)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @NotNull
    public static List<Double> p(@NotNull double[] dArr) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return new f(dArr);
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final char[] p1(char[] cArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return g1(cArr, i6, i7);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Integer p2(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i6 = iArr[0];
        int Me = a0.Me(iArr);
        if (Me == 0) {
            return Integer.valueOf(i6);
        }
        R invoke = selector.invoke(Integer.valueOf(i6));
        int i7 = 1;
        if (1 <= Me) {
            while (true) {
                int i8 = iArr[i7];
                R invoke2 = selector.invoke(Integer.valueOf(i8));
                if (invoke.compareTo(invoke2) < 0) {
                    i6 = i8;
                    invoke = invoke2;
                }
                if (i7 == Me) {
                    break;
                }
                i7++;
            }
        }
        return Integer.valueOf(i6);
    }

    @NotNull
    public static final float[] p3(@NotNull float[] fArr, @NotNull float[] elements) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = fArr.length;
        int length2 = elements.length;
        float[] copyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal p4(long[] jArr, Function1<? super Long, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (long j6 : jArr) {
            valueOf = valueOf.add(selector.invoke(Long.valueOf(j6)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @NotNull
    public static final List<Float> q(@NotNull float[] fArr) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return new e(fArr);
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final double[] q1(double[] dArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return h1(dArr, i6, i7);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Long q2(long[] jArr, Function1<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int Ne = a0.Ne(jArr);
        if (Ne == 0) {
            return Long.valueOf(j6);
        }
        R invoke = selector.invoke(Long.valueOf(j6));
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long j7 = jArr[i6];
                R invoke2 = selector.invoke(Long.valueOf(j7));
                if (invoke.compareTo(invoke2) < 0) {
                    j6 = j7;
                    invoke = invoke2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Long.valueOf(j6);
    }

    @NotNull
    public static int[] q3(@NotNull int[] iArr, int i6) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, length + 1);
        copyOf[length] = i6;
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigDecimal q4(T[] tArr, Function1<? super T, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (T t5 : tArr) {
            valueOf = valueOf.add(selector.invoke(t5));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @NotNull
    public static List<Integer> r(@NotNull int[] iArr) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return new c(iArr);
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final float[] r1(float[] fArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return i1(fArr, i6, i7);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T r2(T[] tArr, Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t5 = tArr[0];
        int Oe = a0.Oe(tArr);
        if (Oe != 0) {
            R invoke = selector.invoke(t5);
            int i6 = 1;
            if (1 <= Oe) {
                while (true) {
                    T t6 = tArr[i6];
                    R invoke2 = selector.invoke(t6);
                    if (invoke.compareTo(invoke2) < 0) {
                        t5 = t6;
                        invoke = invoke2;
                    }
                    if (i6 == Oe) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return t5;
    }

    @NotNull
    public static final int[] r3(@NotNull int[] iArr, @NotNull Collection<Integer> elements) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, elements.size() + length);
        Iterator<Integer> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().intValue();
            length++;
        }
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal r4(short[] sArr, Function1<? super Short, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (short s5 : sArr) {
            valueOf = valueOf.add(selector.invoke(Short.valueOf(s5)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @NotNull
    public static List<Long> s(@NotNull long[] jArr) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return new d(jArr);
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final int[] s1(int[] iArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        return j1(iArr, i6, i7);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> Short s2(short[] sArr, Function1<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s5 = sArr[0];
        int Pe = a0.Pe(sArr);
        if (Pe == 0) {
            return Short.valueOf(s5);
        }
        R invoke = selector.invoke(Short.valueOf(s5));
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short s6 = sArr[i6];
                R invoke2 = selector.invoke(Short.valueOf(s6));
                if (invoke.compareTo(invoke2) < 0) {
                    s5 = s6;
                    invoke = invoke2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Short.valueOf(s5);
    }

    @NotNull
    public static int[] s3(@NotNull int[] iArr, @NotNull int[] elements) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = iArr.length;
        int length2 = elements.length;
        int[] copyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal s4(boolean[] zArr, Function1<? super Boolean, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (boolean z5 : zArr) {
            valueOf = valueOf.add(selector.invoke(Boolean.valueOf(z5)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @NotNull
    public static <T> List<T> t(@NotNull T[] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        List<T> a6 = b0.a(tArr);
        kotlin.jvm.internal.g0.o(a6, "asList(...)");
        return a6;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final long[] t1(long[] jArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        return k1(jArr, i6, i7);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Boolean t2(boolean[] zArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.ul(zArr, comparator);
    }

    @NotNull
    public static long[] t3(@NotNull long[] jArr, long j6) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, length + 1);
        copyOf[length] = j6;
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger t4(byte[] bArr, Function1<? super Byte, ? extends BigInteger> selector) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (byte b6 : bArr) {
            valueOf = valueOf.add(selector.invoke(Byte.valueOf(b6)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @NotNull
    public static final List<Short> u(@NotNull short[] sArr) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return new b(sArr);
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final <T> T[] u1(T[] tArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        return (T[]) l1(tArr, i6, i7);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Byte u2(byte[] bArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.vl(bArr, comparator);
    }

    @NotNull
    public static final long[] u3(@NotNull long[] jArr, @NotNull Collection<Long> elements) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, elements.size() + length);
        Iterator<Long> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().longValue();
            length++;
        }
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger u4(char[] cArr, Function1<? super Character, ? extends BigInteger> selector) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (char c6 : cArr) {
            valueOf = valueOf.add(selector.invoke(Character.valueOf(c6)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @NotNull
    public static final List<Boolean> v(@NotNull boolean[] zArr) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return new g(zArr);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static byte[] v0(@NotNull byte[] bArr, @NotNull byte[] destination, int i6, int i7, int i8) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        System.arraycopy(bArr, i7, destination, i6, i8 - i7);
        return destination;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final short[] v1(short[] sArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        return m1(sArr, i6, i7);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Character v2(char[] cArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.wl(cArr, comparator);
    }

    @NotNull
    public static long[] v3(@NotNull long[] jArr, @NotNull long[] elements) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = jArr.length;
        int length2 = elements.length;
        long[] copyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger v4(double[] dArr, Function1<? super Double, ? extends BigInteger> selector) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (double d6 : dArr) {
            valueOf = valueOf.add(selector.invoke(Double.valueOf(d6)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    public static final int w(@NotNull byte[] bArr, byte b6, int i6, int i7) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return Arrays.binarySearch(bArr, i6, i7, b6);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final char[] w0(@NotNull char[] cArr, @NotNull char[] destination, int i6, int i7, int i8) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        System.arraycopy(cArr, i7, destination, i6, i8 - i7);
        return destination;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final boolean[] w1(boolean[] zArr, int i6, int i7) {
        kotlin.jvm.internal.g0.p(zArr, "<this>");
        return n1(zArr, i6, i7);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double w2(double[] dArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.xl(dArr, comparator);
    }

    @NotNull
    public static final <T> T[] w3(@NotNull T[] tArr, T t5) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + 1);
        tArr2[length] = t5;
        kotlin.jvm.internal.g0.m(tArr2);
        return tArr2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger w4(float[] fArr, Function1<? super Float, ? extends BigInteger> selector) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (float f6 : fArr) {
            valueOf = valueOf.add(selector.invoke(Float.valueOf(f6)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    public static final int x(@NotNull char[] cArr, char c6, int i6, int i7) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return Arrays.binarySearch(cArr, i6, i7, c6);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final double[] x0(@NotNull double[] dArr, @NotNull double[] destination, int i6, int i7, int i8) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        System.arraycopy(dArr, i7, destination, i6, i8 - i7);
        return destination;
    }

    @InlineOnly
    private static final byte x1(byte[] bArr, int i6) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        return bArr[i6];
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float x2(float[] fArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.yl(fArr, comparator);
    }

    @NotNull
    public static final <T> T[] x3(@NotNull T[] tArr, @NotNull Collection<? extends T> elements) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, elements.size() + length);
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            tArr2[length] = it.next();
            length++;
        }
        kotlin.jvm.internal.g0.m(tArr2);
        return tArr2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger x4(int[] iArr, Function1<? super Integer, ? extends BigInteger> selector) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (int i6 : iArr) {
            valueOf = valueOf.add(selector.invoke(Integer.valueOf(i6)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    public static final int y(@NotNull double[] dArr, double d6, int i6, int i7) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return Arrays.binarySearch(dArr, i6, i7, d6);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static float[] y0(@NotNull float[] fArr, @NotNull float[] destination, int i6, int i7, int i8) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        System.arraycopy(fArr, i7, destination, i6, i8 - i7);
        return destination;
    }

    @InlineOnly
    private static final char y1(char[] cArr, int i6) {
        kotlin.jvm.internal.g0.p(cArr, "<this>");
        return cArr[i6];
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Integer y2(int[] iArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.zl(iArr, comparator);
    }

    @NotNull
    public static <T> T[] y3(@NotNull T[] tArr, @NotNull T[] elements) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = tArr.length;
        int length2 = elements.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(elements, 0, tArr2, length, length2);
        kotlin.jvm.internal.g0.m(tArr2);
        return tArr2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger y4(long[] jArr, Function1<? super Long, ? extends BigInteger> selector) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (long j6 : jArr) {
            valueOf = valueOf.add(selector.invoke(Long.valueOf(j6)));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    public static final int z(@NotNull float[] fArr, float f6, int i6, int i7) {
        kotlin.jvm.internal.g0.p(fArr, "<this>");
        return Arrays.binarySearch(fArr, i6, i7, f6);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static int[] z0(@NotNull int[] iArr, @NotNull int[] destination, int i6, int i7, int i8) {
        kotlin.jvm.internal.g0.p(iArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        System.arraycopy(iArr, i7, destination, i6, i8 - i7);
        return destination;
    }

    @InlineOnly
    private static final double z1(double[] dArr, int i6) {
        kotlin.jvm.internal.g0.p(dArr, "<this>");
        return dArr[i6];
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = cn.bluemobi.dylan.photoview.a.f1297f, warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Long z2(long[] jArr, Comparator comparator) {
        kotlin.jvm.internal.g0.p(jArr, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        return a0.Al(jArr, comparator);
    }

    @NotNull
    public static final short[] z3(@NotNull short[] sArr, @NotNull Collection<Short> elements) {
        kotlin.jvm.internal.g0.p(sArr, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        int length = sArr.length;
        short[] copyOf = Arrays.copyOf(sArr, elements.size() + length);
        Iterator<Short> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[length] = it.next().shortValue();
            length++;
        }
        kotlin.jvm.internal.g0.m(copyOf);
        return copyOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigInteger z4(T[] tArr, Function1<? super T, ? extends BigInteger> selector) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        kotlin.jvm.internal.g0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.g0.o(valueOf, "valueOf(...)");
        for (T t5 : tArr) {
            valueOf = valueOf.add(selector.invoke(t5));
            kotlin.jvm.internal.g0.o(valueOf, "add(...)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "contentDeepEqualsNullable")
    private static final <T> boolean P(T[] tArr, T[] tArr2) {
        return p.g(tArr, tArr2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "contentDeepHashCodeNullable")
    private static final <T> int R(T[] tArr) {
        return o.b(tArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "contentDeepToStringNullable")
    private static final <T> String T(T[] tArr) {
        return p.h(tArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final boolean U(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final boolean V(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final boolean W(double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final boolean X(float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final boolean Y(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final boolean Z(long[] jArr, long[] jArr2) {
        return Arrays.equals(jArr, jArr2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <T> boolean a0(T[] tArr, T[] tArr2) {
        return Arrays.equals(tArr, tArr2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final boolean b0(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final boolean c0(boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int d0(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int e0(char[] cArr) {
        return Arrays.hashCode(cArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int f0(double[] dArr) {
        return Arrays.hashCode(dArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int g0(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int h0(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int i0(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <T> int j0(T[] tArr) {
        return Arrays.hashCode(tArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int k0(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final int l0(boolean[] zArr) {
        return Arrays.hashCode(zArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final String m0(byte[] bArr) {
        String arrays = Arrays.toString(bArr);
        kotlin.jvm.internal.g0.o(arrays, "toString(...)");
        return arrays;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final String n0(char[] cArr) {
        String arrays = Arrays.toString(cArr);
        kotlin.jvm.internal.g0.o(arrays, "toString(...)");
        return arrays;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final String o0(double[] dArr) {
        String arrays = Arrays.toString(dArr);
        kotlin.jvm.internal.g0.o(arrays, "toString(...)");
        return arrays;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final String p0(float[] fArr) {
        String arrays = Arrays.toString(fArr);
        kotlin.jvm.internal.g0.o(arrays, "toString(...)");
        return arrays;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final String q0(int[] iArr) {
        String arrays = Arrays.toString(iArr);
        kotlin.jvm.internal.g0.o(arrays, "toString(...)");
        return arrays;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final String r0(long[] jArr) {
        String arrays = Arrays.toString(jArr);
        kotlin.jvm.internal.g0.o(arrays, "toString(...)");
        return arrays;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final <T> String s0(T[] tArr) {
        String arrays = Arrays.toString(tArr);
        kotlin.jvm.internal.g0.o(arrays, "toString(...)");
        return arrays;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final String t0(short[] sArr) {
        String arrays = Arrays.toString(sArr);
        kotlin.jvm.internal.g0.o(arrays, "toString(...)");
        return arrays;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final String u0(boolean[] zArr) {
        String arrays = Arrays.toString(zArr);
        kotlin.jvm.internal.g0.o(arrays, "toString(...)");
        return arrays;
    }
}
