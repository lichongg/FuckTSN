package kotlin.collections.unsigned;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.a1;
import kotlin.collections.b1;
import kotlin.collections.c2;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.collections.n;
import kotlin.d1;
import kotlin.e1;
import kotlin.internal.InlineOnly;
import kotlin.j1;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.k1;
import kotlin.n1;
import kotlin.o0;
import kotlin.random.Random;
import kotlin.ranges.m;
import kotlin.ranges.t;
import kotlin.v0;
import kotlin.w0;
import kotlin.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\n_UArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _UArrays.kt\nkotlin/collections/unsigned/UArraysKt___UArraysKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,11226:1\n3976#1:11276\n3984#1:11277\n3992#1:11278\n4000#1:11279\n3976#1:11280\n3984#1:11281\n3992#1:11282\n4000#1:11283\n3976#1:11284\n3984#1:11285\n3992#1:11286\n4000#1:11287\n3976#1:11344\n3984#1:11345\n3992#1:11346\n4000#1:11347\n3976#1:11348\n3984#1:11349\n3992#1:11350\n4000#1:11351\n3976#1:11352\n3984#1:11353\n3992#1:11354\n4000#1:11355\n3976#1:11356\n3984#1:11357\n3992#1:11358\n4000#1:11359\n3976#1:11360\n3984#1:11361\n3992#1:11362\n4000#1:11363\n3976#1:11364\n3984#1:11365\n3992#1:11366\n4000#1:11367\n3976#1:11368\n3984#1:11369\n3992#1:11370\n4000#1:11371\n3976#1:11372\n3984#1:11373\n3992#1:11374\n4000#1:11375\n3976#1:11376\n3984#1:11377\n3992#1:11378\n4000#1:11379\n3976#1:11380\n3984#1:11381\n3992#1:11382\n4000#1:11383\n3976#1:11384\n3984#1:11385\n3992#1:11386\n4000#1:11387\n3976#1:11388\n3984#1:11389\n3992#1:11390\n4000#1:11391\n3976#1:11392\n3984#1:11393\n3992#1:11394\n4000#1:11395\n3976#1:11396\n3984#1:11397\n3992#1:11398\n4000#1:11399\n3976#1:11400\n3984#1:11401\n3992#1:11402\n4000#1:11403\n3976#1:11404\n3984#1:11405\n3992#1:11406\n4000#1:11407\n3976#1:11408\n3984#1:11409\n3992#1:11410\n4000#1:11411\n3976#1:11412\n3984#1:11413\n3992#1:11414\n4000#1:11415\n3976#1:11416\n3984#1:11417\n3992#1:11418\n4000#1:11419\n3976#1:11420\n3984#1:11421\n3992#1:11422\n4000#1:11423\n3976#1:11424\n3984#1:11425\n3992#1:11426\n4000#1:11427\n3976#1:11428\n3984#1:11429\n3992#1:11430\n4000#1:11431\n3976#1:11432\n3984#1:11433\n3992#1:11434\n4000#1:11435\n3976#1:11436\n3984#1:11437\n3992#1:11438\n4000#1:11439\n3976#1:11440\n3984#1:11441\n3992#1:11442\n4000#1:11443\n3976#1:11444\n3984#1:11445\n3992#1:11446\n4000#1:11447\n3976#1:11448\n3984#1:11449\n3992#1:11450\n4000#1:11451\n3976#1:11452\n3984#1:11453\n3992#1:11454\n4000#1:11455\n3976#1:11456\n3984#1:11457\n3992#1:11458\n4000#1:11459\n3976#1:11460\n3984#1:11461\n3992#1:11462\n4000#1:11463\n3976#1:11464\n3984#1:11465\n3992#1:11466\n4000#1:11467\n3976#1:11468\n3984#1:11469\n3992#1:11470\n4000#1:11471\n3976#1:11472\n3984#1:11473\n3992#1:11474\n4000#1:11475\n3976#1:11476\n3984#1:11477\n3992#1:11478\n4000#1:11479\n3976#1:11480\n3984#1:11481\n3992#1:11482\n4000#1:11483\n3976#1:11484\n3984#1:11485\n3992#1:11486\n4000#1:11487\n3976#1:11488\n3984#1:11489\n3992#1:11490\n4000#1:11491\n3976#1:11492\n3984#1:11493\n3992#1:11494\n4000#1:11495\n1808#2,6:11227\n1820#2,6:11233\n1784#2,6:11239\n1796#2,6:11245\n1916#2,6:11251\n1928#2,6:11257\n1892#2,6:11263\n1904#2,6:11269\n1#3:11275\n382#4,7:11288\n382#4,7:11295\n382#4,7:11302\n382#4,7:11309\n382#4,7:11316\n382#4,7:11323\n382#4,7:11330\n382#4,7:11337\n*S KotlinDebug\n*F\n+ 1 _UArrays.kt\nkotlin/collections/unsigned/UArraysKt___UArraysKt\n*L\n1775#1:11276\n1792#1:11277\n1809#1:11278\n1826#1:11279\n2603#1:11280\n2620#1:11281\n2637#1:11282\n2654#1:11283\n2970#1:11284\n2986#1:11285\n3002#1:11286\n3018#1:11287\n5774#1:11344\n5794#1:11345\n5814#1:11346\n5834#1:11347\n5855#1:11348\n5877#1:11349\n5899#1:11350\n5921#1:11351\n6036#1:11352\n6057#1:11353\n6078#1:11354\n6099#1:11355\n6128#1:11356\n6164#1:11357\n6200#1:11358\n6236#1:11359\n6268#1:11360\n6300#1:11361\n6332#1:11362\n6364#1:11363\n6396#1:11364\n6421#1:11365\n6446#1:11366\n6471#1:11367\n6496#1:11368\n6521#1:11369\n6546#1:11370\n6571#1:11371\n6596#1:11372\n6623#1:11373\n6650#1:11374\n6677#1:11375\n6702#1:11376\n6725#1:11377\n6748#1:11378\n6771#1:11379\n6794#1:11380\n6817#1:11381\n6840#1:11382\n6863#1:11383\n6886#1:11384\n6911#1:11385\n6936#1:11386\n6961#1:11387\n6988#1:11388\n7015#1:11389\n7042#1:11390\n7069#1:11391\n7094#1:11392\n7119#1:11393\n7144#1:11394\n7169#1:11395\n7188#1:11396\n7205#1:11397\n7222#1:11398\n7239#1:11399\n7258#1:11400\n7277#1:11401\n7296#1:11402\n7315#1:11403\n7330#1:11404\n7345#1:11405\n7360#1:11406\n7375#1:11407\n7396#1:11408\n7417#1:11409\n7438#1:11410\n7459#1:11411\n7488#1:11412\n7524#1:11413\n7560#1:11414\n7596#1:11415\n7628#1:11416\n7660#1:11417\n7692#1:11418\n7724#1:11419\n7756#1:11420\n7781#1:11421\n7806#1:11422\n7831#1:11423\n7856#1:11424\n7881#1:11425\n7906#1:11426\n7931#1:11427\n7956#1:11428\n7983#1:11429\n8010#1:11430\n8037#1:11431\n8062#1:11432\n8085#1:11433\n8108#1:11434\n8131#1:11435\n8154#1:11436\n8177#1:11437\n8200#1:11438\n8223#1:11439\n8246#1:11440\n8271#1:11441\n8296#1:11442\n8321#1:11443\n8348#1:11444\n8375#1:11445\n8402#1:11446\n8429#1:11447\n8454#1:11448\n8479#1:11449\n8504#1:11450\n8529#1:11451\n8548#1:11452\n8565#1:11453\n8582#1:11454\n8599#1:11455\n8618#1:11456\n8637#1:11457\n8656#1:11458\n8675#1:11459\n8690#1:11460\n8705#1:11461\n8720#1:11462\n8735#1:11463\n8953#1:11464\n8978#1:11465\n9003#1:11466\n9028#1:11467\n9053#1:11468\n9078#1:11469\n9103#1:11470\n9128#1:11471\n9152#1:11472\n9176#1:11473\n9200#1:11474\n9224#1:11475\n9248#1:11476\n9272#1:11477\n9296#1:11478\n9320#1:11479\n9342#1:11480\n9367#1:11481\n9392#1:11482\n9417#1:11483\n9442#1:11484\n9468#1:11485\n9494#1:11486\n9520#1:11487\n9545#1:11488\n9570#1:11489\n9595#1:11490\n9620#1:11491\n9645#1:11492\n9669#1:11493\n9693#1:11494\n9717#1:11495\n881#1:11227,6\n891#1:11233,6\n901#1:11239,6\n911#1:11245,6\n921#1:11251,6\n931#1:11257,6\n941#1:11263,6\n951#1:11269,6\n4992#1:11288,7\n5012#1:11295,7\n5032#1:11302,7\n5052#1:11309,7\n5073#1:11316,7\n5094#1:11323,7\n5115#1:11330,7\n5136#1:11337,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class g extends b {
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static boolean W0(@Nullable short[] sArr, @Nullable short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static boolean X0(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static boolean Y0(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static boolean Z0(@Nullable long[] jArr, @Nullable long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <V, M extends Map<? super d1, ? super V>> M A0(long[] jArr, M destination, Function1<? super d1, ? extends V> valueSelector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$associateWithTo$0");
        g0.p(destination, "destination");
        g0.p(valueSelector, "valueSelector");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            destination.put(d1.b(p5), valueSelector.invoke(d1.b(p5)));
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] A1(long[] jArr, int i6) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$copyOf$0");
        long[] copyOf = Arrays.copyOf(jArr, i6);
        g0.o(copyOf, "copyOf(...)");
        return e1.f(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <C extends Collection<? super v0>> C A2(byte[] bArr, C destination, Function2<? super Integer, ? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$filterIndexedTo$0");
        g0.p(destination, "destination");
        g0.p(predicate, "predicate");
        int r5 = w0.r(bArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            byte p5 = w0.p(bArr, i6);
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), v0.b(p5)).booleanValue()) {
                destination.add(v0.b(p5));
            }
            i6++;
            i7 = i8;
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, C extends Collection<? super R>> C A3(int[] iArr, C destination, Function1<? super z0, ? extends Iterable<? extends R>> transform) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$flatMapTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            f0.s0(destination, transform.invoke(z0.b(a1.p(iArr, i6))));
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K> Map<K, List<v0>> A4(byte[] bArr, Function1<? super v0, ? extends K> keySelector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$groupBy$0");
        g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            K invoke = keySelector.invoke(v0.b(p5));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(v0.b(p5));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> A5(long[] jArr, Function2<? super Integer, ? super d1, ? extends R> transform) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$mapIndexed$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(e1.r(jArr));
        int r5 = e1.r(jArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            arrayList.add(transform.invoke(Integer.valueOf(i7), d1.b(e1.p(jArr, i6))));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final d1 A6(@NotNull long[] jArr) {
        int compare;
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$maxOrNull$0");
        if (e1.v(jArr)) {
            return null;
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long p6 = e1.p(jArr, i6);
                compare = Long.compare(p5 ^ Long.MIN_VALUE, p6 ^ Long.MIN_VALUE);
                if (compare < 0) {
                    p5 = p6;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return d1.b(p5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R A7(short[] sArr, Comparator<? super R> comparator, Function1<? super j1, ? extends R> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$minOfWithOrNull$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            return null;
        }
        Object obj = (R) selector.invoke(j1.b(k1.p(sArr, 0)));
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                Object obj2 = (R) selector.invoke(j1.b(k1.p(sArr, i6)));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short A8(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$random$0");
        return B8(sArr, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<d1> A9(@NotNull long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$reversed$0");
        if (e1.v(jArr)) {
            return f0.J();
        }
        List<d1> d6 = f0.d6(e1.d(jArr));
        f0.t1(d6);
        return d6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final j1 Aa(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$singleOrNull$0");
        if (k1.r(sArr) == 1) {
            return j1.b(k1.p(sArr, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<d1> Ab(@NotNull long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sortedDescending$0");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        g0.o(copyOf, "copyOf(...)");
        long[] f6 = e1.f(copyOf);
        ab(f6);
        return A9(f6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<z0> Ac(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$takeWhile$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            if (!predicate.invoke(z0.b(p5)).booleanValue()) {
                break;
            }
            arrayList.add(z0.b(p5));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <V, M extends Map<? super j1, ? super V>> M B0(short[] sArr, M destination, Function1<? super j1, ? extends V> valueSelector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$associateWithTo$0");
        g0.p(destination, "destination");
        g0.p(valueSelector, "valueSelector");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            destination.put(j1.b(p5), valueSelector.invoke(j1.b(p5)));
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] B1(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$copyOf$0");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        g0.o(copyOf, "copyOf(...)");
        return k1.f(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <C extends Collection<? super d1>> C B2(long[] jArr, C destination, Function2<? super Integer, ? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$filterIndexedTo$0");
        g0.p(destination, "destination");
        g0.p(predicate, "predicate");
        int r5 = e1.r(jArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            long p5 = e1.p(jArr, i6);
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), d1.b(p5)).booleanValue()) {
                destination.add(d1.b(p5));
            }
            i6++;
            i7 = i8;
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, C extends Collection<? super R>> C B3(byte[] bArr, C destination, Function1<? super v0, ? extends Iterable<? extends R>> transform) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$flatMapTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            f0.s0(destination, transform.invoke(v0.b(w0.p(bArr, i6))));
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K, V> Map<K, List<V>> B4(int[] iArr, Function1<? super z0, ? extends K> keySelector, Function1<? super z0, ? extends V> valueTransform) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$groupBy$0");
        g0.p(keySelector, "keySelector");
        g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            K invoke = keySelector.invoke(z0.b(p5));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(z0.b(p5)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> B5(short[] sArr, Function2<? super Integer, ? super j1, ? extends R> transform) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$mapIndexed$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(k1.r(sArr));
        int r5 = k1.r(sArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            arrayList.add(transform.invoke(Integer.valueOf(i7), j1.b(k1.p(sArr, i6))));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final j1 B6(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$maxOrNull$0");
        if (k1.v(sArr)) {
            return null;
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short p6 = k1.p(sArr, i6);
                if (g0.t(p5 & j1.f43986d, 65535 & p6) < 0) {
                    p5 = p6;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return j1.b(p5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R B7(int[] iArr, Comparator<? super R> comparator, Function1<? super z0, ? extends R> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$minOfWithOrNull$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            return null;
        }
        Object obj = (R) selector.invoke(z0.b(a1.p(iArr, 0)));
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                Object obj2 = (R) selector.invoke(z0.b(a1.p(iArr, i6)));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final short B8(@NotNull short[] sArr, @NotNull Random random) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$random$0");
        g0.p(random, "random");
        if (k1.v(sArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return k1.p(sArr, random.nextInt(k1.r(sArr)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<j1> B9(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$reversed$0");
        if (k1.v(sArr)) {
            return f0.J();
        }
        List<j1> d6 = f0.d6(k1.d(sArr));
        f0.t1(d6);
        return d6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final j1 Ba(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$singleOrNull$0");
        g0.p(predicate, "predicate");
        int r5 = k1.r(sArr);
        j1 j1Var = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            if (predicate.invoke(j1.b(p5)).booleanValue()) {
                if (z5) {
                    return null;
                }
                j1Var = j1.b(p5);
                z5 = true;
            }
        }
        if (z5) {
            return j1Var;
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<j1> Bb(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sortedDescending$0");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        g0.o(copyOf, "copyOf(...)");
        short[] f6 = k1.f(copyOf);
        db(f6);
        return B9(f6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<j1> Bc(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$takeWhile$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            if (!predicate.invoke(j1.b(p5)).booleanValue()) {
                break;
            }
            arrayList.add(j1.b(p5));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int C0(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$component1$0");
        return a1.p(iArr, 0);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] C1(long[] jArr, int i6, int i7) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$copyOfRange$0");
        return e1.f(n.k1(jArr, i6, i7));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<v0> C2(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$filterNot$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            if (!predicate.invoke(v0.b(p5)).booleanValue()) {
                arrayList.add(v0.b(p5));
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R C3(long[] jArr, R r5, Function2<? super R, ? super d1, ? extends R> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$fold$0");
        g0.p(operation, "operation");
        int r6 = e1.r(jArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(r5, d1.b(e1.p(jArr, i6)));
        }
        return r5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K> Map<K, List<d1>> C4(long[] jArr, Function1<? super d1, ? extends K> keySelector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$groupBy$0");
        g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            K invoke = keySelector.invoke(d1.b(p5));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(d1.b(p5));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, C extends Collection<? super R>> C C5(int[] iArr, C destination, Function2<? super Integer, ? super z0, ? extends R> transform) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$mapIndexedTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = a1.r(iArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            destination.add(transform.invoke(Integer.valueOf(i7), z0.b(a1.p(iArr, i6))));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    public static final byte C6(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$max$0");
        if (w0.v(bArr)) {
            throw new NoSuchElementException();
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte p6 = w0.p(bArr, i6);
                if (g0.t(p5 & 255, p6 & 255) < 0) {
                    p5 = p6;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final z0 C7(@NotNull int[] iArr) {
        int compare;
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$minOrNull$0");
        if (a1.v(iArr)) {
            return null;
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                int p6 = a1.p(iArr, i6);
                compare = Integer.compare(p5 ^ Integer.MIN_VALUE, p6 ^ Integer.MIN_VALUE);
                if (compare > 0) {
                    p5 = p6;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return z0.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final z0 C8(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$randomOrNull$0");
        return D8(iArr, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] C9(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$reversedArray$0");
        return a1.f(n.Or(iArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<d1> Ca(@NotNull long[] jArr, @NotNull Iterable<Integer> indices) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$slice$0");
        g0.p(indices, "indices");
        int d02 = f0.d0(indices, 10);
        if (d02 == 0) {
            return f0.J();
        }
        ArrayList arrayList = new ArrayList(d02);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(d1.b(e1.p(jArr, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int Cb(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sum$0");
        return z0.k(n.uw(iArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] Cc(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$toByteArray$0");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte D0(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$component1$0");
        return w0.p(bArr, 0);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] D1(byte[] bArr, int i6, int i7) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$copyOfRange$0");
        return w0.f(n.f1(bArr, i6, i7));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<d1> D2(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$filterNot$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            if (!predicate.invoke(d1.b(p5)).booleanValue()) {
                arrayList.add(d1.b(p5));
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R D3(byte[] bArr, R r5, Function2<? super R, ? super v0, ? extends R> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$fold$0");
        g0.p(operation, "operation");
        int r6 = w0.r(bArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(r5, v0.b(w0.p(bArr, i6)));
        }
        return r5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K, V> Map<K, List<V>> D4(byte[] bArr, Function1<? super v0, ? extends K> keySelector, Function1<? super v0, ? extends V> valueTransform) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$groupBy$0");
        g0.p(keySelector, "keySelector");
        g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            K invoke = keySelector.invoke(v0.b(p5));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(v0.b(p5)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, C extends Collection<? super R>> C D5(short[] sArr, C destination, Function2<? super Integer, ? super j1, ? extends R> transform) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$mapIndexedTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = k1.r(sArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            destination.add(transform.invoke(Integer.valueOf(i7), j1.b(k1.p(sArr, i6))));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    public static final int D6(@NotNull int[] iArr) {
        int compare;
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$max$0");
        if (a1.v(iArr)) {
            throw new NoSuchElementException();
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                int p6 = a1.p(iArr, i6);
                compare = Integer.compare(p5 ^ Integer.MIN_VALUE, p6 ^ Integer.MIN_VALUE);
                if (compare < 0) {
                    p5 = p6;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final v0 D7(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$minOrNull$0");
        if (w0.v(bArr)) {
            return null;
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte p6 = w0.p(bArr, i6);
                if (g0.t(p5 & 255, p6 & 255) > 0) {
                    p5 = p6;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return v0.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final z0 D8(@NotNull int[] iArr, @NotNull Random random) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$randomOrNull$0");
        g0.p(random, "random");
        if (a1.v(iArr)) {
            return null;
        }
        return z0.b(a1.p(iArr, random.nextInt(a1.r(iArr))));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] D9(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$reversedArray$0");
        return w0.f(n.Kr(bArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<z0> Da(@NotNull int[] iArr, @NotNull Iterable<Integer> indices) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$slice$0");
        g0.p(indices, "indices");
        int d02 = f0.d0(indices, 10);
        if (d02 == 0) {
            return f0.J();
        }
        ArrayList arrayList = new ArrayList(d02);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(z0.b(a1.p(iArr, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int Db(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sum$0");
        int k6 = z0.k(0);
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            k6 = z0.k(k6 + z0.k(w0.p(bArr, i6) & 255));
        }
        return k6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] Dc(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$toIntArray$0");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long E0(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$component1$0");
        return e1.p(jArr, 0);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] E1(short[] sArr, int i6, int i7) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$copyOfRange$0");
        return k1.f(n.m1(sArr, i6, i7));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<z0> E2(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$filterNot$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            if (!predicate.invoke(z0.b(p5)).booleanValue()) {
                arrayList.add(z0.b(p5));
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R E3(int[] iArr, R r5, Function2<? super R, ? super z0, ? extends R> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$fold$0");
        g0.p(operation, "operation");
        int r6 = a1.r(iArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(r5, z0.b(a1.p(iArr, i6)));
        }
        return r5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K> Map<K, List<z0>> E4(int[] iArr, Function1<? super z0, ? extends K> keySelector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$groupBy$0");
        g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            K invoke = keySelector.invoke(z0.b(p5));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(z0.b(p5));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, C extends Collection<? super R>> C E5(byte[] bArr, C destination, Function2<? super Integer, ? super v0, ? extends R> transform) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$mapIndexedTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = w0.r(bArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            destination.add(transform.invoke(Integer.valueOf(i7), v0.b(w0.p(bArr, i6))));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    public static final long E6(@NotNull long[] jArr) {
        int compare;
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$max$0");
        if (e1.v(jArr)) {
            throw new NoSuchElementException();
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long p6 = e1.p(jArr, i6);
                compare = Long.compare(p5 ^ Long.MIN_VALUE, p6 ^ Long.MIN_VALUE);
                if (compare < 0) {
                    p5 = p6;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final d1 E7(@NotNull long[] jArr) {
        int compare;
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$minOrNull$0");
        if (e1.v(jArr)) {
            return null;
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long p6 = e1.p(jArr, i6);
                compare = Long.compare(p5 ^ Long.MIN_VALUE, p6 ^ Long.MIN_VALUE);
                if (compare > 0) {
                    p5 = p6;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return d1.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final v0 E8(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$randomOrNull$0");
        return H8(bArr, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] E9(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$reversedArray$0");
        return e1.f(n.Pr(jArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<j1> Ea(@NotNull short[] sArr, @NotNull Iterable<Integer> indices) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$slice$0");
        g0.p(indices, "indices");
        int d02 = f0.d0(indices, 10);
        if (d02 == 0) {
            return f0.J();
        }
        ArrayList arrayList = new ArrayList(d02);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(j1.b(k1.p(sArr, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long Eb(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sum$0");
        return d1.k(n.ww(jArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] Ec(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$toLongArray$0");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short F0(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$component1$0");
        return k1.p(sArr, 0);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] F1(int[] iArr, int i6, int i7) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$copyOfRange$0");
        return a1.f(n.j1(iArr, i6, i7));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<j1> F2(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$filterNot$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            if (!predicate.invoke(j1.b(p5)).booleanValue()) {
                arrayList.add(j1.b(p5));
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R F3(short[] sArr, R r5, Function2<? super R, ? super j1, ? extends R> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$fold$0");
        g0.p(operation, "operation");
        int r6 = k1.r(sArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(r5, j1.b(k1.p(sArr, i6)));
        }
        return r5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K> Map<K, List<j1>> F4(short[] sArr, Function1<? super j1, ? extends K> keySelector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$groupBy$0");
        g0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            K invoke = keySelector.invoke(j1.b(p5));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(j1.b(p5));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, C extends Collection<? super R>> C F5(long[] jArr, C destination, Function2<? super Integer, ? super d1, ? extends R> transform) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$mapIndexedTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = e1.r(jArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            destination.add(transform.invoke(Integer.valueOf(i7), d1.b(e1.p(jArr, i6))));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    public static final short F6(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$max$0");
        if (k1.v(sArr)) {
            throw new NoSuchElementException();
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short p6 = k1.p(sArr, i6);
                if (g0.t(p5 & j1.f43986d, 65535 & p6) < 0) {
                    p5 = p6;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final j1 F7(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$minOrNull$0");
        if (k1.v(sArr)) {
            return null;
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short p6 = k1.p(sArr, i6);
                if (g0.t(p5 & j1.f43986d, 65535 & p6) > 0) {
                    p5 = p6;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return j1.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final d1 F8(@NotNull long[] jArr, @NotNull Random random) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$randomOrNull$0");
        g0.p(random, "random");
        if (e1.v(jArr)) {
            return null;
        }
        return d1.b(e1.p(jArr, random.nextInt(e1.r(jArr))));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] F9(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$reversedArray$0");
        return k1.f(n.Rr(sArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<v0> Fa(@NotNull byte[] bArr, @NotNull Iterable<Integer> indices) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$slice$0");
        g0.p(indices, "indices");
        int d02 = f0.d0(indices, 10);
        if (d02 == 0) {
            return f0.J();
        }
        ArrayList arrayList = new ArrayList(d02);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(v0.b(w0.p(bArr, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int Fb(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sum$0");
        int k6 = z0.k(0);
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            k6 = z0.k(k6 + z0.k(k1.p(sArr, i6) & j1.f43986d));
        }
        return k6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] Fc(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$toShortArray$0");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int G0(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$component2$0");
        return a1.p(iArr, 1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int G1(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$count$0");
        g0.p(predicate, "predicate");
        int r5 = w0.r(bArr);
        int i6 = 0;
        for (int i7 = 0; i7 < r5; i7++) {
            if (predicate.invoke(v0.b(w0.p(bArr, i7))).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <C extends Collection<? super d1>> C G2(long[] jArr, C destination, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$filterNotTo$0");
        g0.p(destination, "destination");
        g0.p(predicate, "predicate");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            if (!predicate.invoke(d1.b(p5)).booleanValue()) {
                destination.add(d1.b(p5));
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R G3(byte[] bArr, R r5, Function3<? super Integer, ? super R, ? super v0, ? extends R> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$foldIndexed$0");
        g0.p(operation, "operation");
        int r6 = w0.r(bArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r6) {
            R r7 = r5;
            r5 = operation.invoke(Integer.valueOf(i7), r7, v0.b(w0.p(bArr, i6)));
            i6++;
            i7++;
        }
        return r5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K, M extends Map<? super K, List<z0>>> M G4(int[] iArr, M destination, Function1<? super z0, ? extends K> keySelector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$groupByTo$0");
        g0.p(destination, "destination");
        g0.p(keySelector, "keySelector");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            K invoke = keySelector.invoke(z0.b(p5));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(z0.b(p5));
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, C extends Collection<? super R>> C G5(long[] jArr, C destination, Function1<? super d1, ? extends R> transform) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$mapTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            destination.add(transform.invoke(d1.b(e1.p(jArr, i6))));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final v0 G6(@NotNull byte[] bArr, @NotNull Comparator<? super v0> comparator) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$maxWithOrNull$0");
        g0.p(comparator, "comparator");
        if (w0.v(bArr)) {
            return null;
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte p6 = w0.p(bArr, i6);
                if (comparator.compare(v0.b(p5), v0.b(p6)) < 0) {
                    p5 = p6;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return v0.b(p5);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    public static final byte G7(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$min$0");
        if (w0.v(bArr)) {
            throw new NoSuchElementException();
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte p6 = w0.p(bArr, i6);
                if (g0.t(p5 & 255, p6 & 255) > 0) {
                    p5 = p6;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final d1 G8(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$randomOrNull$0");
        return F8(jArr, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> G9(long[] jArr, R r5, Function2<? super R, ? super d1, ? extends R> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$runningFold$0");
        g0.p(operation, "operation");
        if (e1.v(jArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(e1.r(jArr) + 1);
        arrayList.add(r5);
        int r6 = e1.r(jArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(r5, d1.b(e1.p(jArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<j1> Ga(@NotNull short[] sArr, @NotNull m indices) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$slice$0");
        g0.p(indices, "indices");
        return indices.isEmpty() ? f0.J() : b.d(k1.f(n.m1(sArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final int Gb(byte[] bArr, Function1<? super v0, z0> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sumBy$0");
        g0.p(selector, "selector");
        int r5 = w0.r(bArr);
        int i6 = 0;
        for (int i7 = 0; i7 < r5; i7++) {
            i6 = z0.k(i6 + selector.invoke(v0.b(w0.p(bArr, i7))).q0());
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final z0[] Gc(@NotNull int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$toTypedArray$0");
        int r5 = a1.r(iArr);
        z0[] z0VarArr = new z0[r5];
        for (int i6 = 0; i6 < r5; i6++) {
            z0VarArr[i6] = z0.b(a1.p(iArr, i6));
        }
        return z0VarArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte H0(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$component2$0");
        return w0.p(bArr, 1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int H1(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$count$0");
        g0.p(predicate, "predicate");
        int r5 = e1.r(jArr);
        int i6 = 0;
        for (int i7 = 0; i7 < r5; i7++) {
            if (predicate.invoke(d1.b(e1.p(jArr, i7))).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <C extends Collection<? super j1>> C H2(short[] sArr, C destination, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$filterNotTo$0");
        g0.p(destination, "destination");
        g0.p(predicate, "predicate");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            if (!predicate.invoke(j1.b(p5)).booleanValue()) {
                destination.add(j1.b(p5));
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R H3(short[] sArr, R r5, Function3<? super Integer, ? super R, ? super j1, ? extends R> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$foldIndexed$0");
        g0.p(operation, "operation");
        int r6 = k1.r(sArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r6) {
            R r7 = r5;
            r5 = operation.invoke(Integer.valueOf(i7), r7, j1.b(k1.p(sArr, i6)));
            i6++;
            i7++;
        }
        return r5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K, M extends Map<? super K, List<v0>>> M H4(byte[] bArr, M destination, Function1<? super v0, ? extends K> keySelector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$groupByTo$0");
        g0.p(destination, "destination");
        g0.p(keySelector, "keySelector");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            K invoke = keySelector.invoke(v0.b(p5));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(v0.b(p5));
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, C extends Collection<? super R>> C H5(short[] sArr, C destination, Function1<? super j1, ? extends R> transform) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$mapTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            destination.add(transform.invoke(j1.b(k1.p(sArr, i6))));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final z0 H6(@NotNull int[] iArr, @NotNull Comparator<? super z0> comparator) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$maxWithOrNull$0");
        g0.p(comparator, "comparator");
        if (a1.v(iArr)) {
            return null;
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                int p6 = a1.p(iArr, i6);
                if (comparator.compare(z0.b(p5), z0.b(p6)) < 0) {
                    p5 = p6;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return z0.b(p5);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    public static final int H7(@NotNull int[] iArr) {
        int compare;
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$min$0");
        if (a1.v(iArr)) {
            throw new NoSuchElementException();
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                int p6 = a1.p(iArr, i6);
                compare = Integer.compare(p5 ^ Integer.MIN_VALUE, p6 ^ Integer.MIN_VALUE);
                if (compare > 0) {
                    p5 = p6;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final v0 H8(@NotNull byte[] bArr, @NotNull Random random) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$randomOrNull$0");
        g0.p(random, "random");
        if (w0.v(bArr)) {
            return null;
        }
        return v0.b(w0.p(bArr, random.nextInt(w0.r(bArr))));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> H9(byte[] bArr, R r5, Function2<? super R, ? super v0, ? extends R> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$runningFold$0");
        g0.p(operation, "operation");
        if (w0.v(bArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(w0.r(bArr) + 1);
        arrayList.add(r5);
        int r6 = w0.r(bArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(r5, v0.b(w0.p(bArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<d1> Ha(@NotNull long[] jArr, @NotNull m indices) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$slice$0");
        g0.p(indices, "indices");
        return indices.isEmpty() ? f0.J() : b.c(e1.f(n.k1(jArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final int Hb(long[] jArr, Function1<? super d1, z0> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sumBy$0");
        g0.p(selector, "selector");
        int r5 = e1.r(jArr);
        int i6 = 0;
        for (int i7 = 0; i7 < r5; i7++) {
            i6 = z0.k(i6 + selector.invoke(d1.b(e1.p(jArr, i7))).q0());
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final v0[] Hc(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$toTypedArray$0");
        int r5 = w0.r(bArr);
        v0[] v0VarArr = new v0[r5];
        for (int i6 = 0; i6 < r5; i6++) {
            v0VarArr[i6] = v0.b(w0.p(bArr, i6));
        }
        return v0VarArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long I0(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$component2$0");
        return e1.p(jArr, 1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int I1(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$count$0");
        g0.p(predicate, "predicate");
        int r5 = a1.r(iArr);
        int i6 = 0;
        for (int i7 = 0; i7 < r5; i7++) {
            if (predicate.invoke(z0.b(a1.p(iArr, i7))).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <C extends Collection<? super z0>> C I2(int[] iArr, C destination, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$filterNotTo$0");
        g0.p(destination, "destination");
        g0.p(predicate, "predicate");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            if (!predicate.invoke(z0.b(p5)).booleanValue()) {
                destination.add(z0.b(p5));
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R I3(long[] jArr, R r5, Function3<? super Integer, ? super R, ? super d1, ? extends R> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$foldIndexed$0");
        g0.p(operation, "operation");
        int r6 = e1.r(jArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r6) {
            R r7 = r5;
            r5 = operation.invoke(Integer.valueOf(i7), r7, d1.b(e1.p(jArr, i6)));
            i6++;
            i7++;
        }
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K, V, M extends Map<? super K, List<V>>> M I4(int[] iArr, M destination, Function1<? super z0, ? extends K> keySelector, Function1<? super z0, ? extends V> valueTransform) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$groupByTo$0");
        g0.p(destination, "destination");
        g0.p(keySelector, "keySelector");
        g0.p(valueTransform, "valueTransform");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            K invoke = keySelector.invoke(z0.b(p5));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(z0.b(p5)));
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, C extends Collection<? super R>> C I5(int[] iArr, C destination, Function1<? super z0, ? extends R> transform) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$mapTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            destination.add(transform.invoke(z0.b(a1.p(iArr, i6))));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final j1 I6(@NotNull short[] sArr, @NotNull Comparator<? super j1> comparator) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$maxWithOrNull$0");
        g0.p(comparator, "comparator");
        if (k1.v(sArr)) {
            return null;
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short p6 = k1.p(sArr, i6);
                if (comparator.compare(j1.b(p5), j1.b(p6)) < 0) {
                    p5 = p6;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return j1.b(p5);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    public static final long I7(@NotNull long[] jArr) {
        int compare;
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$min$0");
        if (e1.v(jArr)) {
            throw new NoSuchElementException();
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long p6 = e1.p(jArr, i6);
                compare = Long.compare(p5 ^ Long.MIN_VALUE, p6 ^ Long.MIN_VALUE);
                if (compare > 0) {
                    p5 = p6;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final j1 I8(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$randomOrNull$0");
        return J8(sArr, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> I9(int[] iArr, R r5, Function2<? super R, ? super z0, ? extends R> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$runningFold$0");
        g0.p(operation, "operation");
        if (a1.v(iArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(a1.r(iArr) + 1);
        arrayList.add(r5);
        int r6 = a1.r(iArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(r5, z0.b(a1.p(iArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<v0> Ia(@NotNull byte[] bArr, @NotNull m indices) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$slice$0");
        g0.p(indices, "indices");
        return indices.isEmpty() ? f0.J() : b.b(w0.f(n.f1(bArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final int Ib(int[] iArr, Function1<? super z0, z0> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sumBy$0");
        g0.p(selector, "selector");
        int r5 = a1.r(iArr);
        int i6 = 0;
        for (int i7 = 0; i7 < r5; i7++) {
            i6 = z0.k(i6 + selector.invoke(z0.b(a1.p(iArr, i7))).q0());
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final d1[] Ic(@NotNull long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$toTypedArray$0");
        int r5 = e1.r(jArr);
        d1[] d1VarArr = new d1[r5];
        for (int i6 = 0; i6 < r5; i6++) {
            d1VarArr[i6] = d1.b(e1.p(jArr, i6));
        }
        return d1VarArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short J0(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$component2$0");
        return k1.p(sArr, 1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int J1(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$count$0");
        g0.p(predicate, "predicate");
        int r5 = k1.r(sArr);
        int i6 = 0;
        for (int i7 = 0; i7 < r5; i7++) {
            if (predicate.invoke(j1.b(k1.p(sArr, i7))).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <C extends Collection<? super v0>> C J2(byte[] bArr, C destination, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$filterNotTo$0");
        g0.p(destination, "destination");
        g0.p(predicate, "predicate");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            if (!predicate.invoke(v0.b(p5)).booleanValue()) {
                destination.add(v0.b(p5));
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R J3(int[] iArr, R r5, Function3<? super Integer, ? super R, ? super z0, ? extends R> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$foldIndexed$0");
        g0.p(operation, "operation");
        int r6 = a1.r(iArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r6) {
            R r7 = r5;
            r5 = operation.invoke(Integer.valueOf(i7), r7, z0.b(a1.p(iArr, i6)));
            i6++;
            i7++;
        }
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K, V, M extends Map<? super K, List<V>>> M J4(long[] jArr, M destination, Function1<? super d1, ? extends K> keySelector, Function1<? super d1, ? extends V> valueTransform) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$groupByTo$0");
        g0.p(destination, "destination");
        g0.p(keySelector, "keySelector");
        g0.p(valueTransform, "valueTransform");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            K invoke = keySelector.invoke(d1.b(p5));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(d1.b(p5)));
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, C extends Collection<? super R>> C J5(byte[] bArr, C destination, Function1<? super v0, ? extends R> transform) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$mapTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            destination.add(transform.invoke(v0.b(w0.p(bArr, i6))));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final d1 J6(@NotNull long[] jArr, @NotNull Comparator<? super d1> comparator) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$maxWithOrNull$0");
        g0.p(comparator, "comparator");
        if (e1.v(jArr)) {
            return null;
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long p6 = e1.p(jArr, i6);
                if (comparator.compare(d1.b(p5), d1.b(p6)) < 0) {
                    p5 = p6;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return d1.b(p5);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    public static final short J7(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$min$0");
        if (k1.v(sArr)) {
            throw new NoSuchElementException();
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short p6 = k1.p(sArr, i6);
                if (g0.t(p5 & j1.f43986d, 65535 & p6) > 0) {
                    p5 = p6;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final j1 J8(@NotNull short[] sArr, @NotNull Random random) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$randomOrNull$0");
        g0.p(random, "random");
        if (k1.v(sArr)) {
            return null;
        }
        return j1.b(k1.p(sArr, random.nextInt(k1.r(sArr))));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> J9(short[] sArr, R r5, Function2<? super R, ? super j1, ? extends R> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$runningFold$0");
        g0.p(operation, "operation");
        if (k1.v(sArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(k1.r(sArr) + 1);
        arrayList.add(r5);
        int r6 = k1.r(sArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(r5, j1.b(k1.p(sArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<z0> Ja(@NotNull int[] iArr, @NotNull m indices) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$slice$0");
        g0.p(indices, "indices");
        return indices.isEmpty() ? f0.J() : b.a(a1.f(n.j1(iArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final int Jb(short[] sArr, Function1<? super j1, z0> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sumBy$0");
        g0.p(selector, "selector");
        int r5 = k1.r(sArr);
        int i6 = 0;
        for (int i7 = 0; i7 < r5; i7++) {
            i6 = z0.k(i6 + selector.invoke(j1.b(k1.p(sArr, i7))).q0());
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final j1[] Jc(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$toTypedArray$0");
        int r5 = k1.r(sArr);
        j1[] j1VarArr = new j1[r5];
        for (int i6 = 0; i6 < r5; i6++) {
            j1VarArr[i6] = j1.b(k1.p(sArr, i6));
        }
        return j1VarArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int K0(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$component3$0");
        return a1.p(iArr, 2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<v0> K1(@NotNull byte[] bArr, int i6) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$drop$0");
        if (i6 >= 0) {
            return qc(bArr, t.u(w0.r(bArr) - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <C extends Collection<? super d1>> C K2(long[] jArr, C destination, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$filterTo$0");
        g0.p(destination, "destination");
        g0.p(predicate, "predicate");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            if (predicate.invoke(d1.b(p5)).booleanValue()) {
                destination.add(d1.b(p5));
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R K3(long[] jArr, R r5, Function2<? super d1, ? super R, ? extends R> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$foldRight$0");
        g0.p(operation, "operation");
        for (int Ne = n.Ne(jArr); Ne >= 0; Ne--) {
            r5 = operation.invoke(d1.b(e1.p(jArr, Ne)), r5);
        }
        return r5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K, M extends Map<? super K, List<d1>>> M K4(long[] jArr, M destination, Function1<? super d1, ? extends K> keySelector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$groupByTo$0");
        g0.p(destination, "destination");
        g0.p(keySelector, "keySelector");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            K invoke = keySelector.invoke(d1.b(p5));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(d1.b(p5));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R extends Comparable<? super R>> v0 K5(byte[] bArr, Function1<? super v0, ? extends R> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$maxByOrNull$0");
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

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    public static final byte K6(@NotNull byte[] bArr, @NotNull Comparator<? super v0> comparator) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$maxWith$0");
        g0.p(comparator, "comparator");
        if (w0.v(bArr)) {
            throw new NoSuchElementException();
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte p6 = w0.p(bArr, i6);
                if (comparator.compare(v0.b(p5), v0.b(p6)) < 0) {
                    p5 = p6;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final v0 K7(@NotNull byte[] bArr, @NotNull Comparator<? super v0> comparator) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$minWithOrNull$0");
        g0.p(comparator, "comparator");
        if (w0.v(bArr)) {
            return null;
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte p6 = w0.p(bArr, i6);
                if (comparator.compare(v0.b(p5), v0.b(p6)) > 0) {
                    p5 = p6;
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
    private static final byte K8(byte[] bArr, Function2<? super v0, ? super v0, v0> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$reduce$0");
        g0.p(operation, "operation");
        if (w0.v(bArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                p5 = operation.invoke(v0.b(p5), v0.b(w0.p(bArr, i6))).o0();
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> K9(byte[] bArr, R r5, Function3<? super Integer, ? super R, ? super v0, ? extends R> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$runningFoldIndexed$0");
        g0.p(operation, "operation");
        if (w0.v(bArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(w0.r(bArr) + 1);
        arrayList.add(r5);
        int r6 = w0.r(bArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, v0.b(w0.p(bArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final int[] Ka(@NotNull int[] iArr, @NotNull Collection<Integer> indices) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sliceArray$0");
        g0.p(indices, "indices");
        return a1.f(n.yu(iArr, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final double Kb(byte[] bArr, Function1<? super v0, Double> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sumByDouble$0");
        g0.p(selector, "selector");
        int r5 = w0.r(bArr);
        double d6 = 0.0d;
        for (int i6 = 0; i6 < r5; i6++) {
            d6 += selector.invoke(v0.b(w0.p(bArr, i6))).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] Kc(byte[] bArr) {
        g0.p(bArr, "<this>");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        g0.o(copyOf, "copyOf(...)");
        return w0.f(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte L0(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$component3$0");
        return w0.p(bArr, 2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<j1> L1(@NotNull short[] sArr, int i6) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$drop$0");
        if (i6 >= 0) {
            return rc(sArr, t.u(k1.r(sArr) - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <C extends Collection<? super j1>> C L2(short[] sArr, C destination, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$filterTo$0");
        g0.p(destination, "destination");
        g0.p(predicate, "predicate");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            if (predicate.invoke(j1.b(p5)).booleanValue()) {
                destination.add(j1.b(p5));
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R L3(byte[] bArr, R r5, Function2<? super v0, ? super R, ? extends R> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$foldRight$0");
        g0.p(operation, "operation");
        for (int Ie = n.Ie(bArr); Ie >= 0; Ie--) {
            r5 = operation.invoke(v0.b(w0.p(bArr, Ie)), r5);
        }
        return r5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K, M extends Map<? super K, List<j1>>> M L4(short[] sArr, M destination, Function1<? super j1, ? extends K> keySelector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$groupByTo$0");
        g0.p(destination, "destination");
        g0.p(keySelector, "keySelector");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            K invoke = keySelector.invoke(j1.b(p5));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(j1.b(p5));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R extends Comparable<? super R>> d1 L5(long[] jArr, Function1<? super d1, ? extends R> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$maxByOrNull$0");
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

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    public static final int L6(@NotNull int[] iArr, @NotNull Comparator<? super z0> comparator) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$maxWith$0");
        g0.p(comparator, "comparator");
        if (a1.v(iArr)) {
            throw new NoSuchElementException();
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                int p6 = a1.p(iArr, i6);
                if (comparator.compare(z0.b(p5), z0.b(p6)) < 0) {
                    p5 = p6;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final z0 L7(@NotNull int[] iArr, @NotNull Comparator<? super z0> comparator) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$minWithOrNull$0");
        g0.p(comparator, "comparator");
        if (a1.v(iArr)) {
            return null;
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                int p6 = a1.p(iArr, i6);
                if (comparator.compare(z0.b(p5), z0.b(p6)) > 0) {
                    p5 = p6;
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
    private static final int L8(int[] iArr, Function2<? super z0, ? super z0, z0> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$reduce$0");
        g0.p(operation, "operation");
        if (a1.v(iArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                p5 = operation.invoke(z0.b(p5), z0.b(a1.p(iArr, i6))).q0();
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> L9(short[] sArr, R r5, Function3<? super Integer, ? super R, ? super j1, ? extends R> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$runningFoldIndexed$0");
        g0.p(operation, "operation");
        if (k1.v(sArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(k1.r(sArr) + 1);
        arrayList.add(r5);
        int r6 = k1.r(sArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, j1.b(k1.p(sArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final short[] La(@NotNull short[] sArr, @NotNull m indices) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sliceArray$0");
        g0.p(indices, "indices");
        return k1.f(n.Fu(sArr, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final double Lb(long[] jArr, Function1<? super d1, Double> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sumByDouble$0");
        g0.p(selector, "selector");
        int r5 = e1.r(jArr);
        double d6 = 0.0d;
        for (int i6 = 0; i6 < r5; i6++) {
            d6 += selector.invoke(d1.b(e1.p(jArr, i6))).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] Lc(@NotNull v0[] v0VarArr) {
        g0.p(v0VarArr, "<this>");
        int length = v0VarArr.length;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            bArr[i6] = v0VarArr[i6].o0();
        }
        return w0.f(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long M0(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$component3$0");
        return e1.p(jArr, 2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<z0> M1(@NotNull int[] iArr, int i6) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$drop$0");
        if (i6 >= 0) {
            return sc(iArr, t.u(a1.r(iArr) - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <C extends Collection<? super z0>> C M2(int[] iArr, C destination, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$filterTo$0");
        g0.p(destination, "destination");
        g0.p(predicate, "predicate");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            if (predicate.invoke(z0.b(p5)).booleanValue()) {
                destination.add(z0.b(p5));
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R M3(int[] iArr, R r5, Function2<? super z0, ? super R, ? extends R> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$foldRight$0");
        g0.p(operation, "operation");
        for (int Me = n.Me(iArr); Me >= 0; Me--) {
            r5 = operation.invoke(z0.b(a1.p(iArr, Me)), r5);
        }
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K, V, M extends Map<? super K, List<V>>> M M4(short[] sArr, M destination, Function1<? super j1, ? extends K> keySelector, Function1<? super j1, ? extends V> valueTransform) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$groupByTo$0");
        g0.p(destination, "destination");
        g0.p(keySelector, "keySelector");
        g0.p(valueTransform, "valueTransform");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            K invoke = keySelector.invoke(j1.b(p5));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(j1.b(p5)));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R extends Comparable<? super R>> z0 M5(int[] iArr, Function1<? super z0, ? extends R> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$maxByOrNull$0");
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

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    public static final long M6(@NotNull long[] jArr, @NotNull Comparator<? super d1> comparator) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$maxWith$0");
        g0.p(comparator, "comparator");
        if (e1.v(jArr)) {
            throw new NoSuchElementException();
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long p6 = e1.p(jArr, i6);
                if (comparator.compare(d1.b(p5), d1.b(p6)) < 0) {
                    p5 = p6;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final j1 M7(@NotNull short[] sArr, @NotNull Comparator<? super j1> comparator) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$minWithOrNull$0");
        g0.p(comparator, "comparator");
        if (k1.v(sArr)) {
            return null;
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short p6 = k1.p(sArr, i6);
                if (comparator.compare(j1.b(p5), j1.b(p6)) > 0) {
                    p5 = p6;
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
    @InlineOnly
    private static final long M8(long[] jArr, Function2<? super d1, ? super d1, d1> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$reduce$0");
        g0.p(operation, "operation");
        if (e1.v(jArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                p5 = operation.invoke(d1.b(p5), d1.b(e1.p(jArr, i6))).q0();
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> M9(long[] jArr, R r5, Function3<? super Integer, ? super R, ? super d1, ? extends R> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$runningFoldIndexed$0");
        g0.p(operation, "operation");
        if (e1.v(jArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(e1.r(jArr) + 1);
        arrayList.add(r5);
        int r6 = e1.r(jArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, d1.b(e1.p(jArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final long[] Ma(@NotNull long[] jArr, @NotNull m indices) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sliceArray$0");
        g0.p(indices, "indices");
        return e1.f(n.Bu(jArr, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final double Mb(int[] iArr, Function1<? super z0, Double> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sumByDouble$0");
        g0.p(selector, "selector");
        int r5 = a1.r(iArr);
        double d6 = 0.0d;
        for (int i6 = 0; i6 < r5; i6++) {
            d6 += selector.invoke(z0.b(a1.p(iArr, i6))).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] Mc(int[] iArr) {
        g0.p(iArr, "<this>");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        g0.o(copyOf, "copyOf(...)");
        return a1.f(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short N0(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$component3$0");
        return k1.p(sArr, 2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<d1> N1(@NotNull long[] jArr, int i6) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$drop$0");
        if (i6 >= 0) {
            return tc(jArr, t.u(e1.r(jArr) - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <C extends Collection<? super v0>> C N2(byte[] bArr, C destination, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$filterTo$0");
        g0.p(destination, "destination");
        g0.p(predicate, "predicate");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            if (predicate.invoke(v0.b(p5)).booleanValue()) {
                destination.add(v0.b(p5));
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R N3(short[] sArr, R r5, Function2<? super j1, ? super R, ? extends R> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$foldRight$0");
        g0.p(operation, "operation");
        for (int Pe = n.Pe(sArr); Pe >= 0; Pe--) {
            r5 = operation.invoke(j1.b(k1.p(sArr, Pe)), r5);
        }
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K, V, M extends Map<? super K, List<V>>> M N4(byte[] bArr, M destination, Function1<? super v0, ? extends K> keySelector, Function1<? super v0, ? extends V> valueTransform) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$groupByTo$0");
        g0.p(destination, "destination");
        g0.p(keySelector, "keySelector");
        g0.p(valueTransform, "valueTransform");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            K invoke = keySelector.invoke(v0.b(p5));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(v0.b(p5)));
        }
        return destination;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R extends Comparable<? super R>> j1 N5(short[] sArr, Function1<? super j1, ? extends R> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$maxByOrNull$0");
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

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    public static final short N6(@NotNull short[] sArr, @NotNull Comparator<? super j1> comparator) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$maxWith$0");
        g0.p(comparator, "comparator");
        if (k1.v(sArr)) {
            throw new NoSuchElementException();
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short p6 = k1.p(sArr, i6);
                if (comparator.compare(j1.b(p5), j1.b(p6)) < 0) {
                    p5 = p6;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final d1 N7(@NotNull long[] jArr, @NotNull Comparator<? super d1> comparator) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$minWithOrNull$0");
        g0.p(comparator, "comparator");
        if (e1.v(jArr)) {
            return null;
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long p6 = e1.p(jArr, i6);
                if (comparator.compare(d1.b(p5), d1.b(p6)) > 0) {
                    p5 = p6;
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
    private static final short N8(short[] sArr, Function2<? super j1, ? super j1, j1> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$reduce$0");
        g0.p(operation, "operation");
        if (k1.v(sArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                p5 = operation.invoke(j1.b(p5), j1.b(k1.p(sArr, i6))).o0();
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> N9(int[] iArr, R r5, Function3<? super Integer, ? super R, ? super z0, ? extends R> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$runningFoldIndexed$0");
        g0.p(operation, "operation");
        if (a1.v(iArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(a1.r(iArr) + 1);
        arrayList.add(r5);
        int r6 = a1.r(iArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, z0.b(a1.p(iArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] Na(@NotNull byte[] bArr, @NotNull m indices) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sliceArray$0");
        g0.p(indices, "indices");
        return w0.f(n.ru(bArr, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final double Nb(short[] sArr, Function1<? super j1, Double> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sumByDouble$0");
        g0.p(selector, "selector");
        int r5 = k1.r(sArr);
        double d6 = 0.0d;
        for (int i6 = 0; i6 < r5; i6++) {
            d6 += selector.invoke(j1.b(k1.p(sArr, i6))).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final int[] Nc(@NotNull z0[] z0VarArr) {
        g0.p(z0VarArr, "<this>");
        int length = z0VarArr.length;
        int[] iArr = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            iArr[i6] = z0VarArr[i6].q0();
        }
        return a1.f(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int O0(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$component4$0");
        return a1.p(iArr, 3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<v0> O1(@NotNull byte[] bArr, int i6) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$dropLast$0");
        if (i6 >= 0) {
            return mc(bArr, t.u(w0.r(bArr) - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final v0 O2(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$find$0");
        g0.p(predicate, "predicate");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            if (predicate.invoke(v0.b(p5)).booleanValue()) {
                return v0.b(p5);
            }
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R O3(byte[] bArr, R r5, Function3<? super Integer, ? super v0, ? super R, ? extends R> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$foldRightIndexed$0");
        g0.p(operation, "operation");
        for (int Ie = n.Ie(bArr); Ie >= 0; Ie--) {
            r5 = operation.invoke(Integer.valueOf(Ie), v0.b(w0.p(bArr, Ie)), r5);
        }
        return r5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int O4(long[] jArr, long j6) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$indexOf$0");
        return n.ag(jArr, j6);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "maxByOrThrow-U")
    private static final <R extends Comparable<? super R>> byte O5(byte[] bArr, Function1<? super v0, ? extends R> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$maxBy$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            throw new NoSuchElementException();
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        if (Ie != 0) {
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
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R extends Comparable<? super R>> v0 O6(byte[] bArr, Function1<? super v0, ? extends R> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$minByOrNull$0");
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

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    public static final byte O7(@NotNull byte[] bArr, @NotNull Comparator<? super v0> comparator) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$minWith$0");
        g0.p(comparator, "comparator");
        if (w0.v(bArr)) {
            throw new NoSuchElementException();
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte p6 = w0.p(bArr, i6);
                if (comparator.compare(v0.b(p5), v0.b(p6)) > 0) {
                    p5 = p6;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int O8(int[] iArr, Function3<? super Integer, ? super z0, ? super z0, z0> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$reduceIndexed$0");
        g0.p(operation, "operation");
        if (a1.v(iArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                p5 = operation.invoke(Integer.valueOf(i6), z0.b(p5), z0.b(a1.p(iArr, i6))).q0();
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<v0> O9(byte[] bArr, Function2<? super v0, ? super v0, v0> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$runningReduce$0");
        g0.p(operation, "operation");
        if (w0.v(bArr)) {
            return f0.J();
        }
        byte p5 = w0.p(bArr, 0);
        ArrayList arrayList = new ArrayList(w0.r(bArr));
        arrayList.add(v0.b(p5));
        int r5 = w0.r(bArr);
        for (int i6 = 1; i6 < r5; i6++) {
            p5 = operation.invoke(v0.b(p5), v0.b(w0.p(bArr, i6))).o0();
            arrayList.add(v0.b(p5));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final long[] Oa(@NotNull long[] jArr, @NotNull Collection<Integer> indices) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sliceArray$0");
        g0.p(indices, "indices");
        return e1.f(n.Au(jArr, indices));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double Ob(byte[] bArr, Function1<? super v0, Double> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int r5 = w0.r(bArr);
        double d6 = 0.0d;
        for (int i6 = 0; i6 < r5; i6++) {
            d6 += selector.invoke(v0.b(w0.p(bArr, i6))).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] Oc(long[] jArr) {
        g0.p(jArr, "<this>");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        g0.o(copyOf, "copyOf(...)");
        return e1.f(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte P0(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$component4$0");
        return w0.p(bArr, 3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<j1> P1(@NotNull short[] sArr, int i6) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$dropLast$0");
        if (i6 >= 0) {
            return nc(sArr, t.u(k1.r(sArr) - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final d1 P2(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$find$0");
        g0.p(predicate, "predicate");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            if (predicate.invoke(d1.b(p5)).booleanValue()) {
                return d1.b(p5);
            }
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R P3(short[] sArr, R r5, Function3<? super Integer, ? super j1, ? super R, ? extends R> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$foldRightIndexed$0");
        g0.p(operation, "operation");
        for (int Pe = n.Pe(sArr); Pe >= 0; Pe--) {
            r5 = operation.invoke(Integer.valueOf(Pe), j1.b(k1.p(sArr, Pe)), r5);
        }
        return r5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int P4(short[] sArr, short s5) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$indexOf$0");
        return n.cg(sArr, s5);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "maxByOrThrow-U")
    private static final <R extends Comparable<? super R>> int P5(int[] iArr, Function1<? super z0, ? extends R> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$maxBy$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            throw new NoSuchElementException();
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        if (Me != 0) {
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
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R extends Comparable<? super R>> d1 P6(long[] jArr, Function1<? super d1, ? extends R> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$minByOrNull$0");
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

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    public static final int P7(@NotNull int[] iArr, @NotNull Comparator<? super z0> comparator) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$minWith$0");
        g0.p(comparator, "comparator");
        if (a1.v(iArr)) {
            throw new NoSuchElementException();
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                int p6 = a1.p(iArr, i6);
                if (comparator.compare(z0.b(p5), z0.b(p6)) > 0) {
                    p5 = p6;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte P8(byte[] bArr, Function3<? super Integer, ? super v0, ? super v0, v0> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$reduceIndexed$0");
        g0.p(operation, "operation");
        if (w0.v(bArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                p5 = operation.invoke(Integer.valueOf(i6), v0.b(p5), v0.b(w0.p(bArr, i6))).o0();
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<z0> P9(int[] iArr, Function2<? super z0, ? super z0, z0> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$runningReduce$0");
        g0.p(operation, "operation");
        if (a1.v(iArr)) {
            return f0.J();
        }
        int p5 = a1.p(iArr, 0);
        ArrayList arrayList = new ArrayList(a1.r(iArr));
        arrayList.add(z0.b(p5));
        int r5 = a1.r(iArr);
        for (int i6 = 1; i6 < r5; i6++) {
            p5 = operation.invoke(z0.b(p5), z0.b(a1.p(iArr, i6))).q0();
            arrayList.add(z0.b(p5));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final short[] Pa(@NotNull short[] sArr, @NotNull Collection<Integer> indices) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sliceArray$0");
        g0.p(indices, "indices");
        return k1.f(n.Eu(sArr, indices));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double Pb(int[] iArr, Function1<? super z0, Double> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int r5 = a1.r(iArr);
        double d6 = 0.0d;
        for (int i6 = 0; i6 < r5; i6++) {
            d6 += selector.invoke(z0.b(a1.p(iArr, i6))).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final long[] Pc(@NotNull d1[] d1VarArr) {
        g0.p(d1VarArr, "<this>");
        int length = d1VarArr.length;
        long[] jArr = new long[length];
        for (int i6 = 0; i6 < length; i6++) {
            jArr[i6] = d1VarArr[i6].q0();
        }
        return e1.f(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long Q0(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$component4$0");
        return e1.p(jArr, 3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<z0> Q1(@NotNull int[] iArr, int i6) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$dropLast$0");
        if (i6 >= 0) {
            return oc(iArr, t.u(a1.r(iArr) - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final z0 Q2(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$find$0");
        g0.p(predicate, "predicate");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            if (predicate.invoke(z0.b(p5)).booleanValue()) {
                return z0.b(p5);
            }
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R Q3(long[] jArr, R r5, Function3<? super Integer, ? super d1, ? super R, ? extends R> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$foldRightIndexed$0");
        g0.p(operation, "operation");
        for (int Ne = n.Ne(jArr); Ne >= 0; Ne--) {
            r5 = operation.invoke(Integer.valueOf(Ne), d1.b(e1.p(jArr, Ne)), r5);
        }
        return r5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int Q4(byte[] bArr, byte b6) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$indexOf$0");
        return n.Vf(bArr, b6);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "maxByOrThrow-U")
    private static final <R extends Comparable<? super R>> long Q5(long[] jArr, Function1<? super d1, ? extends R> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$maxBy$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            throw new NoSuchElementException();
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        if (Ne != 0) {
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
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R extends Comparable<? super R>> z0 Q6(int[] iArr, Function1<? super z0, ? extends R> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$minByOrNull$0");
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

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    public static final long Q7(@NotNull long[] jArr, @NotNull Comparator<? super d1> comparator) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$minWith$0");
        g0.p(comparator, "comparator");
        if (e1.v(jArr)) {
            throw new NoSuchElementException();
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                long p6 = e1.p(jArr, i6);
                if (comparator.compare(d1.b(p5), d1.b(p6)) > 0) {
                    p5 = p6;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short Q8(short[] sArr, Function3<? super Integer, ? super j1, ? super j1, j1> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$reduceIndexed$0");
        g0.p(operation, "operation");
        if (k1.v(sArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                p5 = operation.invoke(Integer.valueOf(i6), j1.b(p5), j1.b(k1.p(sArr, i6))).o0();
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<d1> Q9(long[] jArr, Function2<? super d1, ? super d1, d1> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$runningReduce$0");
        g0.p(operation, "operation");
        if (e1.v(jArr)) {
            return f0.J();
        }
        long p5 = e1.p(jArr, 0);
        ArrayList arrayList = new ArrayList(e1.r(jArr));
        arrayList.add(d1.b(p5));
        int r5 = e1.r(jArr);
        for (int i6 = 1; i6 < r5; i6++) {
            p5 = operation.invoke(d1.b(p5), d1.b(e1.p(jArr, i6))).q0();
            arrayList.add(d1.b(p5));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final int[] Qa(@NotNull int[] iArr, @NotNull m indices) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sliceArray$0");
        g0.p(indices, "indices");
        return a1.f(n.zu(iArr, indices));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double Qb(long[] jArr, Function1<? super d1, Double> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int r5 = e1.r(jArr);
        double d6 = 0.0d;
        for (int i6 = 0; i6 < r5; i6++) {
            d6 += selector.invoke(d1.b(e1.p(jArr, i6))).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final short[] Qc(@NotNull j1[] j1VarArr) {
        g0.p(j1VarArr, "<this>");
        int length = j1VarArr.length;
        short[] sArr = new short[length];
        for (int i6 = 0; i6 < length; i6++) {
            sArr[i6] = j1VarArr[i6].o0();
        }
        return k1.f(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short R0(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$component4$0");
        return k1.p(sArr, 3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<d1> R1(@NotNull long[] jArr, int i6) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$dropLast$0");
        if (i6 >= 0) {
            return pc(jArr, t.u(e1.r(jArr) - i6, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final j1 R2(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$find$0");
        g0.p(predicate, "predicate");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            if (predicate.invoke(j1.b(p5)).booleanValue()) {
                return j1.b(p5);
            }
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> R R3(int[] iArr, R r5, Function3<? super Integer, ? super z0, ? super R, ? extends R> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$foldRightIndexed$0");
        g0.p(operation, "operation");
        for (int Me = n.Me(iArr); Me >= 0; Me--) {
            r5 = operation.invoke(Integer.valueOf(Me), z0.b(a1.p(iArr, Me)), r5);
        }
        return r5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int R4(int[] iArr, int i6) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$indexOf$0");
        return n.Zf(iArr, i6);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "maxByOrThrow-U")
    private static final <R extends Comparable<? super R>> short R5(short[] sArr, Function1<? super j1, ? extends R> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$maxBy$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            throw new NoSuchElementException();
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        if (Pe != 0) {
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
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R extends Comparable<? super R>> j1 R6(short[] sArr, Function1<? super j1, ? extends R> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$minByOrNull$0");
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

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    public static final short R7(@NotNull short[] sArr, @NotNull Comparator<? super j1> comparator) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$minWith$0");
        g0.p(comparator, "comparator");
        if (k1.v(sArr)) {
            throw new NoSuchElementException();
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                short p6 = k1.p(sArr, i6);
                if (comparator.compare(j1.b(p5), j1.b(p6)) > 0) {
                    p5 = p6;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long R8(long[] jArr, Function3<? super Integer, ? super d1, ? super d1, d1> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$reduceIndexed$0");
        g0.p(operation, "operation");
        if (e1.v(jArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                p5 = operation.invoke(Integer.valueOf(i6), d1.b(p5), d1.b(e1.p(jArr, i6))).q0();
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<j1> R9(short[] sArr, Function2<? super j1, ? super j1, j1> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$runningReduce$0");
        g0.p(operation, "operation");
        if (k1.v(sArr)) {
            return f0.J();
        }
        short p5 = k1.p(sArr, 0);
        ArrayList arrayList = new ArrayList(k1.r(sArr));
        arrayList.add(j1.b(p5));
        int r5 = k1.r(sArr);
        for (int i6 = 1; i6 < r5; i6++) {
            p5 = operation.invoke(j1.b(p5), j1.b(k1.p(sArr, i6))).o0();
            arrayList.add(j1.b(p5));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] Ra(@NotNull byte[] bArr, @NotNull Collection<Integer> indices) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sliceArray$0");
        g0.p(indices, "indices");
        return w0.f(n.qu(bArr, indices));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double Rb(short[] sArr, Function1<? super j1, Double> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int r5 = k1.r(sArr);
        double d6 = 0.0d;
        for (int i6 = 0; i6 < r5; i6++) {
            d6 += selector.invoke(j1.b(k1.p(sArr, i6))).doubleValue();
        }
        return d6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] Rc(short[] sArr) {
        g0.p(sArr, "<this>");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        g0.o(copyOf, "copyOf(...)");
        return k1.f(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int S0(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$component5$0");
        return a1.p(iArr, 4);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<v0> S1(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$dropLastWhile$0");
        g0.p(predicate, "predicate");
        for (int Ie = n.Ie(bArr); -1 < Ie; Ie--) {
            if (!predicate.invoke(v0.b(w0.p(bArr, Ie))).booleanValue()) {
                return mc(bArr, Ie + 1);
            }
        }
        return f0.J();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final v0 S2(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$findLast$0");
        g0.p(predicate, "predicate");
        int r5 = w0.r(bArr) - 1;
        if (r5 < 0) {
            return null;
        }
        while (true) {
            int i6 = r5 - 1;
            byte p5 = w0.p(bArr, r5);
            if (predicate.invoke(v0.b(p5)).booleanValue()) {
                return v0.b(p5);
            }
            if (i6 < 0) {
                return null;
            }
            r5 = i6;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void S3(byte[] bArr, Function1<? super v0, n1> action) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$forEach$0");
        g0.p(action, "action");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            action.invoke(v0.b(w0.p(bArr, i6)));
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int S4(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$indexOfFirst$0");
        g0.p(predicate, "predicate");
        int length = bArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (predicate.invoke(v0.b(v0.k(bArr[i6]))).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final double S5(byte[] bArr, Function1<? super v0, Double> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$maxOf$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(v0.b(w0.p(bArr, 0))).doubleValue();
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(v0.b(w0.p(bArr, i6))).doubleValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "minByOrThrow-U")
    private static final <R extends Comparable<? super R>> byte S6(byte[] bArr, Function1<? super v0, ? extends R> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$minBy$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            throw new NoSuchElementException();
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        if (Ie != 0) {
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
        }
        return p5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean S7(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$none$0");
        return a1.v(iArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final z0 S8(int[] iArr, Function3<? super Integer, ? super z0, ? super z0, z0> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$reduceIndexedOrNull$0");
        g0.p(operation, "operation");
        if (a1.v(iArr)) {
            return null;
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                p5 = operation.invoke(Integer.valueOf(i6), z0.b(p5), z0.b(a1.p(iArr, i6))).q0();
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return z0.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<z0> S9(int[] iArr, Function3<? super Integer, ? super z0, ? super z0, z0> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$runningReduceIndexed$0");
        g0.p(operation, "operation");
        if (a1.v(iArr)) {
            return f0.J();
        }
        int p5 = a1.p(iArr, 0);
        ArrayList arrayList = new ArrayList(a1.r(iArr));
        arrayList.add(z0.b(p5));
        int r5 = a1.r(iArr);
        for (int i6 = 1; i6 < r5; i6++) {
            p5 = operation.invoke(Integer.valueOf(i6), z0.b(p5), z0.b(a1.p(iArr, i6))).q0();
            arrayList.add(z0.b(p5));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final void Sa(@NotNull int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sort$0");
        if (a1.r(iArr) > 1) {
            c2.l(iArr, 0, a1.r(iArr));
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final int Sb(byte[] bArr, Function1<? super v0, Integer> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int r5 = w0.r(bArr);
        int i6 = 0;
        for (int i7 = 0; i7 < r5; i7++) {
            i6 += selector.invoke(v0.b(w0.p(bArr, i7))).intValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final Iterable<kotlin.collections.a1<z0>> Sc(@NotNull final int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$withIndex$0");
        return new b1(new Function0() { // from class: kotlin.collections.unsigned.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator Yc;
                Yc = g.Yc(iArr);
                return Yc;
            }
        });
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte T0(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$component5$0");
        return w0.p(bArr, 4);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<d1> T1(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$dropLastWhile$0");
        g0.p(predicate, "predicate");
        for (int Ne = n.Ne(jArr); -1 < Ne; Ne--) {
            if (!predicate.invoke(d1.b(e1.p(jArr, Ne))).booleanValue()) {
                return pc(jArr, Ne + 1);
            }
        }
        return f0.J();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final d1 T2(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$findLast$0");
        g0.p(predicate, "predicate");
        int r5 = e1.r(jArr) - 1;
        if (r5 < 0) {
            return null;
        }
        while (true) {
            int i6 = r5 - 1;
            long p5 = e1.p(jArr, r5);
            if (predicate.invoke(d1.b(p5)).booleanValue()) {
                return d1.b(p5);
            }
            if (i6 < 0) {
                return null;
            }
            r5 = i6;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void T3(long[] jArr, Function1<? super d1, n1> action) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$forEach$0");
        g0.p(action, "action");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            action.invoke(d1.b(e1.p(jArr, i6)));
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int T4(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$indexOfFirst$0");
        g0.p(predicate, "predicate");
        int length = jArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (predicate.invoke(d1.b(d1.k(jArr[i6]))).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final float T5(byte[] bArr, Function1<? super v0, Float> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$maxOf$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(v0.b(w0.p(bArr, 0))).floatValue();
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(v0.b(w0.p(bArr, i6))).floatValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "minByOrThrow-U")
    private static final <R extends Comparable<? super R>> int T6(int[] iArr, Function1<? super z0, ? extends R> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$minBy$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            throw new NoSuchElementException();
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        if (Me != 0) {
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
        }
        return p5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean T7(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$none$0");
        return w0.v(bArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final v0 T8(byte[] bArr, Function3<? super Integer, ? super v0, ? super v0, v0> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$reduceIndexedOrNull$0");
        g0.p(operation, "operation");
        if (w0.v(bArr)) {
            return null;
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                p5 = operation.invoke(Integer.valueOf(i6), v0.b(p5), v0.b(w0.p(bArr, i6))).o0();
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return v0.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<v0> T9(byte[] bArr, Function3<? super Integer, ? super v0, ? super v0, v0> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$runningReduceIndexed$0");
        g0.p(operation, "operation");
        if (w0.v(bArr)) {
            return f0.J();
        }
        byte p5 = w0.p(bArr, 0);
        ArrayList arrayList = new ArrayList(w0.r(bArr));
        arrayList.add(v0.b(p5));
        int r5 = w0.r(bArr);
        for (int i6 = 1; i6 < r5; i6++) {
            p5 = operation.invoke(Integer.valueOf(i6), v0.b(p5), v0.b(w0.p(bArr, i6))).o0();
            arrayList.add(v0.b(p5));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void Ta(@NotNull long[] jArr, int i6, int i7) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sort$0");
        kotlin.collections.d.Companion.d(i6, i7, e1.r(jArr));
        if (i6 < i7 - 1) {
            c2.i(jArr, i6, i7);
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final int Tb(int[] iArr, Function1<? super z0, Integer> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int r5 = a1.r(iArr);
        int i6 = 0;
        for (int i7 = 0; i7 < r5; i7++) {
            i6 += selector.invoke(z0.b(a1.p(iArr, i7))).intValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final Iterable<kotlin.collections.a1<v0>> Tc(@NotNull final byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$withIndex$0");
        return new b1(new Function0() { // from class: kotlin.collections.unsigned.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator Wc;
                Wc = g.Wc(bArr);
                return Wc;
            }
        });
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long U0(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$component5$0");
        return e1.p(jArr, 4);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<z0> U1(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$dropLastWhile$0");
        g0.p(predicate, "predicate");
        for (int Me = n.Me(iArr); -1 < Me; Me--) {
            if (!predicate.invoke(z0.b(a1.p(iArr, Me))).booleanValue()) {
                return oc(iArr, Me + 1);
            }
        }
        return f0.J();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final z0 U2(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$findLast$0");
        g0.p(predicate, "predicate");
        int r5 = a1.r(iArr) - 1;
        if (r5 < 0) {
            return null;
        }
        while (true) {
            int i6 = r5 - 1;
            int p5 = a1.p(iArr, r5);
            if (predicate.invoke(z0.b(p5)).booleanValue()) {
                return z0.b(p5);
            }
            if (i6 < 0) {
                return null;
            }
            r5 = i6;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void U3(int[] iArr, Function1<? super z0, n1> action) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$forEach$0");
        g0.p(action, "action");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            action.invoke(z0.b(a1.p(iArr, i6)));
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int U4(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$indexOfFirst$0");
        g0.p(predicate, "predicate");
        int length = iArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (predicate.invoke(z0.b(z0.k(iArr[i6]))).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R U5(byte[] bArr, Function1<? super v0, ? extends R> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$maxOf$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(v0.b(w0.p(bArr, 0)));
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                R invoke2 = selector.invoke(v0.b(w0.p(bArr, i6)));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "minByOrThrow-U")
    private static final <R extends Comparable<? super R>> long U6(long[] jArr, Function1<? super d1, ? extends R> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$minBy$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            throw new NoSuchElementException();
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        if (Ne != 0) {
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
        }
        return p5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean U7(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$none$0");
        g0.p(predicate, "predicate");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            if (predicate.invoke(v0.b(w0.p(bArr, i6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final j1 U8(short[] sArr, Function3<? super Integer, ? super j1, ? super j1, j1> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$reduceIndexedOrNull$0");
        g0.p(operation, "operation");
        if (k1.v(sArr)) {
            return null;
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                p5 = operation.invoke(Integer.valueOf(i6), j1.b(p5), j1.b(k1.p(sArr, i6))).o0();
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return j1.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<j1> U9(short[] sArr, Function3<? super Integer, ? super j1, ? super j1, j1> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$runningReduceIndexed$0");
        g0.p(operation, "operation");
        if (k1.v(sArr)) {
            return f0.J();
        }
        short p5 = k1.p(sArr, 0);
        ArrayList arrayList = new ArrayList(k1.r(sArr));
        arrayList.add(j1.b(p5));
        int r5 = k1.r(sArr);
        for (int i6 = 1; i6 < r5; i6++) {
            p5 = operation.invoke(Integer.valueOf(i6), j1.b(p5), j1.b(k1.p(sArr, i6))).o0();
            arrayList.add(j1.b(p5));
        }
        return arrayList;
    }

    public static /* synthetic */ void Ua(long[] jArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = e1.r(jArr);
        }
        Ta(jArr, i6, i7);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final int Ub(long[] jArr, Function1<? super d1, Integer> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int r5 = e1.r(jArr);
        int i6 = 0;
        for (int i7 = 0; i7 < r5; i7++) {
            i6 += selector.invoke(d1.b(e1.p(jArr, i7))).intValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final Iterable<kotlin.collections.a1<d1>> Uc(@NotNull final long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$withIndex$0");
        return new b1(new Function0() { // from class: kotlin.collections.unsigned.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator Xc;
                Xc = g.Xc(jArr);
                return Xc;
            }
        });
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short V0(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$component5$0");
        return k1.p(sArr, 4);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<j1> V1(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$dropLastWhile$0");
        g0.p(predicate, "predicate");
        for (int Pe = n.Pe(sArr); -1 < Pe; Pe--) {
            if (!predicate.invoke(j1.b(k1.p(sArr, Pe))).booleanValue()) {
                return nc(sArr, Pe + 1);
            }
        }
        return f0.J();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final j1 V2(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$findLast$0");
        g0.p(predicate, "predicate");
        int r5 = k1.r(sArr) - 1;
        if (r5 < 0) {
            return null;
        }
        while (true) {
            int i6 = r5 - 1;
            short p5 = k1.p(sArr, r5);
            if (predicate.invoke(j1.b(p5)).booleanValue()) {
                return j1.b(p5);
            }
            if (i6 < 0) {
                return null;
            }
            r5 = i6;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void V3(short[] sArr, Function1<? super j1, n1> action) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$forEach$0");
        g0.p(action, "action");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            action.invoke(j1.b(k1.p(sArr, i6)));
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int V4(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$indexOfFirst$0");
        g0.p(predicate, "predicate");
        int length = sArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (predicate.invoke(j1.b(j1.k(sArr[i6]))).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final double V5(long[] jArr, Function1<? super d1, Double> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$maxOf$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(d1.b(e1.p(jArr, 0))).doubleValue();
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(d1.b(e1.p(jArr, i6))).doubleValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "minByOrThrow-U")
    private static final <R extends Comparable<? super R>> short V6(short[] sArr, Function1<? super j1, ? extends R> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$minBy$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            throw new NoSuchElementException();
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        if (Pe != 0) {
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
        }
        return p5;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean V7(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$none$0");
        g0.p(predicate, "predicate");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            if (predicate.invoke(d1.b(e1.p(jArr, i6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final d1 V8(long[] jArr, Function3<? super Integer, ? super d1, ? super d1, d1> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$reduceIndexedOrNull$0");
        g0.p(operation, "operation");
        if (e1.v(jArr)) {
            return null;
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                p5 = operation.invoke(Integer.valueOf(i6), d1.b(p5), d1.b(e1.p(jArr, i6))).q0();
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return d1.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<d1> V9(long[] jArr, Function3<? super Integer, ? super d1, ? super d1, d1> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$runningReduceIndexed$0");
        g0.p(operation, "operation");
        if (e1.v(jArr)) {
            return f0.J();
        }
        long p5 = e1.p(jArr, 0);
        ArrayList arrayList = new ArrayList(e1.r(jArr));
        arrayList.add(d1.b(p5));
        int r5 = e1.r(jArr);
        for (int i6 = 1; i6 < r5; i6++) {
            p5 = operation.invoke(Integer.valueOf(i6), d1.b(p5), d1.b(e1.p(jArr, i6))).q0();
            arrayList.add(d1.b(p5));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void Va(@NotNull byte[] bArr, int i6, int i7) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sort$0");
        kotlin.collections.d.Companion.d(i6, i7, w0.r(bArr));
        if (i6 < i7 - 1) {
            c2.j(bArr, i6, i7);
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfInt")
    private static final int Vb(short[] sArr, Function1<? super j1, Integer> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int r5 = k1.r(sArr);
        int i6 = 0;
        for (int i7 = 0; i7 < r5; i7++) {
            i6 += selector.invoke(j1.b(k1.p(sArr, i7))).intValue();
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final Iterable<kotlin.collections.a1<j1>> Vc(@NotNull final short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$withIndex$0");
        return new b1(new Function0() { // from class: kotlin.collections.unsigned.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator Zc;
                Zc = g.Zc(sArr);
                return Zc;
            }
        });
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<v0> W1(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$dropWhile$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = w0.r(bArr);
        boolean z5 = false;
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            if (z5) {
                arrayList.add(v0.b(p5));
            } else if (!predicate.invoke(v0.b(p5)).booleanValue()) {
                arrayList.add(v0.b(p5));
                z5 = true;
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int W2(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$first$0");
        return z0.k(n.fc(iArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void W3(byte[] bArr, Function2<? super Integer, ? super v0, n1> action) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$forEachIndexed$0");
        g0.p(action, "action");
        int r5 = w0.r(bArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            action.invoke(Integer.valueOf(i7), v0.b(w0.p(bArr, i6)));
            i6++;
            i7++;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int W4(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$indexOfLast$0");
        g0.p(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (predicate.invoke(v0.b(v0.k(bArr[length]))).booleanValue()) {
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

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final float W5(long[] jArr, Function1<? super d1, Float> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$maxOf$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(d1.b(e1.p(jArr, 0))).floatValue();
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(d1.b(e1.p(jArr, i6))).floatValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final double W6(byte[] bArr, Function1<? super v0, Double> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$minOf$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(v0.b(w0.p(bArr, 0))).doubleValue();
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(v0.b(w0.p(bArr, i6))).doubleValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean W7(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$none$0");
        return e1.v(jArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final v0 W8(byte[] bArr, Function2<? super v0, ? super v0, v0> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$reduceOrNull$0");
        g0.p(operation, "operation");
        if (w0.v(bArr)) {
            return null;
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                p5 = operation.invoke(v0.b(p5), v0.b(w0.p(bArr, i6))).o0();
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return v0.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> W9(long[] jArr, R r5, Function2<? super R, ? super d1, ? extends R> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$scan$0");
        g0.p(operation, "operation");
        if (e1.v(jArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(e1.r(jArr) + 1);
        arrayList.add(r5);
        int r6 = e1.r(jArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(r5, d1.b(e1.p(jArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    public static /* synthetic */ void Wa(byte[] bArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = w0.r(bArr);
        }
        Va(bArr, i6, i7);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long Wb(byte[] bArr, Function1<? super v0, Long> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int r5 = w0.r(bArr);
        long j6 = 0;
        for (int i6 = 0; i6 < r5; i6++) {
            j6 += selector.invoke(v0.b(w0.p(bArr, i6))).longValue();
        }
        return j6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<d1> X1(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$dropWhile$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = e1.r(jArr);
        boolean z5 = false;
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            if (z5) {
                arrayList.add(d1.b(p5));
            } else if (!predicate.invoke(d1.b(p5)).booleanValue()) {
                arrayList.add(d1.b(p5));
                z5 = true;
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte X2(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$first$0");
        return v0.k(n.Xb(bArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void X3(int[] iArr, Function2<? super Integer, ? super z0, n1> action) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$forEachIndexed$0");
        g0.p(action, "action");
        int r5 = a1.r(iArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            action.invoke(Integer.valueOf(i7), z0.b(a1.p(iArr, i6)));
            i6++;
            i7++;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int X4(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$indexOfLast$0");
        g0.p(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (predicate.invoke(d1.b(d1.k(jArr[length]))).booleanValue()) {
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

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R X5(long[] jArr, Function1<? super d1, ? extends R> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$maxOf$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(d1.b(e1.p(jArr, 0)));
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                R invoke2 = selector.invoke(d1.b(e1.p(jArr, i6)));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final float X6(byte[] bArr, Function1<? super v0, Float> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$minOf$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(v0.b(w0.p(bArr, 0))).floatValue();
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(v0.b(w0.p(bArr, i6))).floatValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean X7(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$none$0");
        g0.p(predicate, "predicate");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            if (predicate.invoke(z0.b(a1.p(iArr, i6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final z0 X8(int[] iArr, Function2<? super z0, ? super z0, z0> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$reduceOrNull$0");
        g0.p(operation, "operation");
        if (a1.v(iArr)) {
            return null;
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                p5 = operation.invoke(z0.b(p5), z0.b(a1.p(iArr, i6))).q0();
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return z0.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> X9(byte[] bArr, R r5, Function2<? super R, ? super v0, ? extends R> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$scan$0");
        g0.p(operation, "operation");
        if (w0.v(bArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(w0.r(bArr) + 1);
        arrayList.add(r5);
        int r6 = w0.r(bArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(r5, v0.b(w0.p(bArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void Xa(@NotNull short[] sArr, int i6, int i7) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sort$0");
        kotlin.collections.d.Companion.d(i6, i7, k1.r(sArr));
        if (i6 < i7 - 1) {
            c2.k(sArr, i6, i7);
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long Xb(int[] iArr, Function1<? super z0, Long> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int r5 = a1.r(iArr);
        long j6 = 0;
        for (int i6 = 0; i6 < r5; i6++) {
            j6 += selector.invoke(z0.b(a1.p(iArr, i6))).longValue();
        }
        return j6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<z0> Y1(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$dropWhile$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = a1.r(iArr);
        boolean z5 = false;
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            if (z5) {
                arrayList.add(z0.b(p5));
            } else if (!predicate.invoke(z0.b(p5)).booleanValue()) {
                arrayList.add(z0.b(p5));
                z5 = true;
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte Y2(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$first$0");
        g0.p(predicate, "predicate");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            if (predicate.invoke(v0.b(p5)).booleanValue()) {
                return p5;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void Y3(long[] jArr, Function2<? super Integer, ? super d1, n1> action) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$forEachIndexed$0");
        g0.p(action, "action");
        int r5 = e1.r(jArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            action.invoke(Integer.valueOf(i7), d1.b(e1.p(jArr, i6)));
            i6++;
            i7++;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int Y4(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$indexOfLast$0");
        g0.p(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (predicate.invoke(z0.b(z0.k(iArr[length]))).booleanValue()) {
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

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final double Y5(int[] iArr, Function1<? super z0, Double> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$maxOf$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(z0.b(a1.p(iArr, 0))).doubleValue();
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(z0.b(a1.p(iArr, i6))).doubleValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R Y6(byte[] bArr, Function1<? super v0, ? extends R> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$minOf$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(v0.b(w0.p(bArr, 0)));
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                R invoke2 = selector.invoke(v0.b(w0.p(bArr, i6)));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean Y7(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$none$0");
        return k1.v(sArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final d1 Y8(long[] jArr, Function2<? super d1, ? super d1, d1> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$reduceOrNull$0");
        g0.p(operation, "operation");
        if (e1.v(jArr)) {
            return null;
        }
        long p5 = e1.p(jArr, 0);
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                p5 = operation.invoke(d1.b(p5), d1.b(e1.p(jArr, i6))).q0();
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return d1.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> Y9(int[] iArr, R r5, Function2<? super R, ? super z0, ? extends R> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$scan$0");
        g0.p(operation, "operation");
        if (a1.v(iArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(a1.r(iArr) + 1);
        arrayList.add(r5);
        int r6 = a1.r(iArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(r5, z0.b(a1.p(iArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    public static /* synthetic */ void Ya(short[] sArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = k1.r(sArr);
        }
        Xa(sArr, i6, i7);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long Yb(long[] jArr, Function1<? super d1, Long> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int r5 = e1.r(jArr);
        long j6 = 0;
        for (int i6 = 0; i6 < r5; i6++) {
            j6 += selector.invoke(d1.b(e1.p(jArr, i6))).longValue();
        }
        return j6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<j1> Z1(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$dropWhile$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = k1.r(sArr);
        boolean z5 = false;
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            if (z5) {
                arrayList.add(j1.b(p5));
            } else if (!predicate.invoke(j1.b(p5)).booleanValue()) {
                arrayList.add(j1.b(p5));
                z5 = true;
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long Z2(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$first$0");
        g0.p(predicate, "predicate");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            if (predicate.invoke(d1.b(p5)).booleanValue()) {
                return p5;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void Z3(short[] sArr, Function2<? super Integer, ? super j1, n1> action) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$forEachIndexed$0");
        g0.p(action, "action");
        int r5 = k1.r(sArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            action.invoke(Integer.valueOf(i7), j1.b(k1.p(sArr, i6)));
            i6++;
            i7++;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int Z4(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$indexOfLast$0");
        g0.p(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (predicate.invoke(j1.b(j1.k(sArr[length]))).booleanValue()) {
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

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final float Z5(int[] iArr, Function1<? super z0, Float> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$maxOf$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(z0.b(a1.p(iArr, 0))).floatValue();
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(z0.b(a1.p(iArr, i6))).floatValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final double Z6(long[] jArr, Function1<? super d1, Double> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$minOf$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(d1.b(e1.p(jArr, 0))).doubleValue();
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(d1.b(e1.p(jArr, i6))).doubleValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean Z7(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$none$0");
        g0.p(predicate, "predicate");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            if (predicate.invoke(j1.b(k1.p(sArr, i6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final j1 Z8(short[] sArr, Function2<? super j1, ? super j1, j1> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$reduceOrNull$0");
        g0.p(operation, "operation");
        if (k1.v(sArr)) {
            return null;
        }
        short p5 = k1.p(sArr, 0);
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                p5 = operation.invoke(j1.b(p5), j1.b(k1.p(sArr, i6))).o0();
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return j1.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> Z9(short[] sArr, R r5, Function2<? super R, ? super j1, ? extends R> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$scan$0");
        g0.p(operation, "operation");
        if (k1.v(sArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(k1.r(sArr) + 1);
        arrayList.add(r5);
        int r6 = k1.r(sArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(r5, j1.b(k1.p(sArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final void Za(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sort$0");
        if (w0.r(bArr) > 1) {
            c2.j(bArr, 0, w0.r(bArr));
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long Zb(short[] sArr, Function1<? super j1, Long> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int r5 = k1.r(sArr);
        long j6 = 0;
        for (int i6 = 0; i6 < r5; i6++) {
            j6 += selector.invoke(j1.b(k1.p(sArr, i6))).longValue();
        }
        return j6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean a0(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$all$0");
        g0.p(predicate, "predicate");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            if (!predicate.invoke(v0.b(w0.p(bArr, i6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final int a1(@Nullable byte[] bArr) {
        if (bArr == null) {
            bArr = null;
        }
        return Arrays.hashCode(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short a2(short[] sArr, int i6, Function1<? super Integer, j1> defaultValue) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$elementAtOrElse$0");
        g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= k1.r(sArr)) ? defaultValue.invoke(Integer.valueOf(i6)).o0() : k1.p(sArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long a3(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$first$0");
        return d1.k(n.hc(jArr));
    }

    @NotNull
    public static final m a4(@NotNull int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$indices$0");
        return n.De(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int a5(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$last$0");
        return z0.k(n.Ph(iArr));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R a6(int[] iArr, Function1<? super z0, ? extends R> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$maxOf$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(z0.b(a1.p(iArr, 0)));
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                R invoke2 = selector.invoke(z0.b(a1.p(iArr, i6)));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final float a7(long[] jArr, Function1<? super d1, Float> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$minOf$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(d1.b(e1.p(jArr, 0))).floatValue();
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(d1.b(e1.p(jArr, i6))).floatValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] a8(byte[] bArr, Function1<? super v0, n1> action) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$onEach$0");
        g0.p(action, "action");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            action.invoke(v0.b(w0.p(bArr, i6)));
        }
        return bArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte a9(byte[] bArr, Function2<? super v0, ? super v0, v0> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$reduceRight$0");
        g0.p(operation, "operation");
        int Ie = n.Ie(bArr);
        if (Ie < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte p5 = w0.p(bArr, Ie);
        for (int i6 = Ie - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(v0.b(w0.p(bArr, i6)), v0.b(p5)).o0();
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> aa(byte[] bArr, R r5, Function3<? super Integer, ? super R, ? super v0, ? extends R> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$scanIndexed$0");
        g0.p(operation, "operation");
        if (w0.v(bArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(w0.r(bArr) + 1);
        arrayList.add(r5);
        int r6 = w0.r(bArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, v0.b(w0.p(bArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final void ab(@NotNull long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sort$0");
        if (e1.r(jArr) > 1) {
            c2.i(jArr, 0, e1.r(jArr));
        }
    }

    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfUByte")
    public static final int ac(@NotNull v0[] v0VarArr) {
        g0.p(v0VarArr, "<this>");
        int i6 = 0;
        for (v0 v0Var : v0VarArr) {
            i6 = z0.k(i6 + z0.k(v0Var.o0() & 255));
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, V> List<V> ad(int[] iArr, Iterable<? extends R> other, Function2<? super z0, ? super R, ? extends V> transform) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$zip$0");
        g0.p(other, "other");
        g0.p(transform, "transform");
        int r5 = a1.r(iArr);
        ArrayList arrayList = new ArrayList(Math.min(f0.d0(other, 10), r5));
        int i6 = 0;
        for (R r6 : other) {
            if (i6 >= r5) {
                break;
            }
            arrayList.add(transform.invoke(z0.b(a1.p(iArr, i6)), r6));
            i6++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean b0(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$all$0");
        g0.p(predicate, "predicate");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            if (!predicate.invoke(d1.b(e1.p(jArr, i6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final int b1(@Nullable int[] iArr) {
        if (iArr == null) {
            iArr = null;
        }
        return Arrays.hashCode(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int b2(int[] iArr, int i6, Function1<? super Integer, z0> defaultValue) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$elementAtOrElse$0");
        g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= a1.r(iArr)) ? defaultValue.invoke(Integer.valueOf(i6)).q0() : a1.p(iArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int b3(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$first$0");
        g0.p(predicate, "predicate");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            if (predicate.invoke(z0.b(p5)).booleanValue()) {
                return p5;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte b5(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$last$0");
        return v0.k(n.Hh(bArr));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final double b6(short[] sArr, Function1<? super j1, Double> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$maxOf$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(j1.b(k1.p(sArr, 0))).doubleValue();
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(j1.b(k1.p(sArr, i6))).doubleValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R b7(long[] jArr, Function1<? super d1, ? extends R> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$minOf$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(d1.b(e1.p(jArr, 0)));
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                R invoke2 = selector.invoke(d1.b(e1.p(jArr, i6)));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] b8(long[] jArr, Function1<? super d1, n1> action) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$onEach$0");
        g0.p(action, "action");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            action.invoke(d1.b(e1.p(jArr, i6)));
        }
        return jArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int b9(int[] iArr, Function2<? super z0, ? super z0, z0> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$reduceRight$0");
        g0.p(operation, "operation");
        int Me = n.Me(iArr);
        if (Me < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int p5 = a1.p(iArr, Me);
        for (int i6 = Me - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(z0.b(a1.p(iArr, i6)), z0.b(p5)).q0();
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> ba(short[] sArr, R r5, Function3<? super Integer, ? super R, ? super j1, ? extends R> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$scanIndexed$0");
        g0.p(operation, "operation");
        if (k1.v(sArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(k1.r(sArr) + 1);
        arrayList.add(r5);
        int r6 = k1.r(sArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, j1.b(k1.p(sArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void bb(@NotNull int[] iArr, int i6, int i7) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sort$0");
        kotlin.collections.d.Companion.d(i6, i7, a1.r(iArr));
        if (i6 < i7 - 1) {
            c2.l(iArr, i6, i7);
        }
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final int bc(byte[] bArr, Function1<? super v0, z0> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int k6 = z0.k(0);
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            k6 = z0.k(k6 + selector.invoke(v0.b(w0.p(bArr, i6))).q0());
        }
        return k6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, V> List<V> bd(long[] jArr, R[] other, Function2<? super d1, ? super R, ? extends V> transform) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$zip$0");
        g0.p(other, "other");
        g0.p(transform, "transform");
        int min = Math.min(e1.r(jArr), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(d1.b(e1.p(jArr, i6)), other[i6]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean c0(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$all$0");
        g0.p(predicate, "predicate");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            if (!predicate.invoke(z0.b(a1.p(iArr, i6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final int c1(@Nullable short[] sArr) {
        if (sArr == null) {
            sArr = null;
        }
        return Arrays.hashCode(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long c2(long[] jArr, int i6, Function1<? super Integer, d1> defaultValue) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$elementAtOrElse$0");
        g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= e1.r(jArr)) ? defaultValue.invoke(Integer.valueOf(i6)).q0() : e1.p(jArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short c3(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$first$0");
        return j1.k(n.lc(sArr));
    }

    @NotNull
    public static final m c4(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$indices$0");
        return n.ze(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte c5(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$last$0");
        g0.p(predicate, "predicate");
        int r5 = w0.r(bArr) - 1;
        if (r5 >= 0) {
            while (true) {
                int i6 = r5 - 1;
                byte p5 = w0.p(bArr, r5);
                if (!predicate.invoke(v0.b(p5)).booleanValue()) {
                    if (i6 < 0) {
                        break;
                    }
                    r5 = i6;
                } else {
                    return p5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final float c6(short[] sArr, Function1<? super j1, Float> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$maxOf$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(j1.b(k1.p(sArr, 0))).floatValue();
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(j1.b(k1.p(sArr, i6))).floatValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final double c7(int[] iArr, Function1<? super z0, Double> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$minOf$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(z0.b(a1.p(iArr, 0))).doubleValue();
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(z0.b(a1.p(iArr, i6))).doubleValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] c8(int[] iArr, Function1<? super z0, n1> action) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$onEach$0");
        g0.p(action, "action");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            action.invoke(z0.b(a1.p(iArr, i6)));
        }
        return iArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long c9(long[] jArr, Function2<? super d1, ? super d1, d1> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$reduceRight$0");
        g0.p(operation, "operation");
        int Ne = n.Ne(jArr);
        if (Ne < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long p5 = e1.p(jArr, Ne);
        for (int i6 = Ne - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(d1.b(e1.p(jArr, i6)), d1.b(p5)).q0();
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> ca(long[] jArr, R r5, Function3<? super Integer, ? super R, ? super d1, ? extends R> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$scanIndexed$0");
        g0.p(operation, "operation");
        if (e1.v(jArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(e1.r(jArr) + 1);
        arrayList.add(r5);
        int r6 = e1.r(jArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, d1.b(e1.p(jArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    public static /* synthetic */ void cb(int[] iArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = a1.r(iArr);
        }
        bb(iArr, i6, i7);
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final int cc(int[] iArr, Function1<? super z0, z0> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int k6 = z0.k(0);
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            k6 = z0.k(k6 + selector.invoke(z0.b(a1.p(iArr, i6))).q0());
        }
        return k6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final <R> List<Pair<z0, R>> cd(@NotNull int[] iArr, @NotNull R[] other) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$zip$0");
        g0.p(other, "other");
        int min = Math.min(a1.r(iArr), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            int p5 = a1.p(iArr, i6);
            arrayList.add(o0.a(z0.b(p5), other[i6]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean d0(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$all$0");
        g0.p(predicate, "predicate");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            if (!predicate.invoke(j1.b(k1.p(sArr, i6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final int d1(@Nullable long[] jArr) {
        if (jArr == null) {
            jArr = null;
        }
        return Arrays.hashCode(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte d2(byte[] bArr, int i6, Function1<? super Integer, v0> defaultValue) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$elementAtOrElse$0");
        g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= w0.r(bArr)) ? defaultValue.invoke(Integer.valueOf(i6)).o0() : w0.p(bArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short d3(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$first$0");
        g0.p(predicate, "predicate");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            if (predicate.invoke(j1.b(p5)).booleanValue()) {
                return p5;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long d5(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$last$0");
        g0.p(predicate, "predicate");
        int r5 = e1.r(jArr) - 1;
        if (r5 >= 0) {
            while (true) {
                int i6 = r5 - 1;
                long p5 = e1.p(jArr, r5);
                if (!predicate.invoke(d1.b(p5)).booleanValue()) {
                    if (i6 < 0) {
                        break;
                    }
                    r5 = i6;
                } else {
                    return p5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R d6(short[] sArr, Function1<? super j1, ? extends R> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$maxOf$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(j1.b(k1.p(sArr, 0)));
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                R invoke2 = selector.invoke(j1.b(k1.p(sArr, i6)));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final float d7(int[] iArr, Function1<? super z0, Float> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$minOf$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(z0.b(a1.p(iArr, 0))).floatValue();
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(z0.b(a1.p(iArr, i6))).floatValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] d8(short[] sArr, Function1<? super j1, n1> action) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$onEach$0");
        g0.p(action, "action");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            action.invoke(j1.b(k1.p(sArr, i6)));
        }
        return sArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short d9(short[] sArr, Function2<? super j1, ? super j1, j1> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$reduceRight$0");
        g0.p(operation, "operation");
        int Pe = n.Pe(sArr);
        if (Pe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short p5 = k1.p(sArr, Pe);
        for (int i6 = Pe - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(j1.b(k1.p(sArr, i6)), j1.b(p5)).o0();
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> da(int[] iArr, R r5, Function3<? super Integer, ? super R, ? super z0, ? extends R> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$scanIndexed$0");
        g0.p(operation, "operation");
        if (a1.v(iArr)) {
            return f0.l(r5);
        }
        ArrayList arrayList = new ArrayList(a1.r(iArr) + 1);
        arrayList.add(r5);
        int r6 = a1.r(iArr);
        for (int i6 = 0; i6 < r6; i6++) {
            r5 = operation.invoke(Integer.valueOf(i6), r5, z0.b(a1.p(iArr, i6)));
            arrayList.add(r5);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final void db(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sort$0");
        if (k1.r(sArr) > 1) {
            c2.k(sArr, 0, k1.r(sArr));
        }
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final int dc(long[] jArr, Function1<? super d1, z0> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int k6 = z0.k(0);
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            k6 = z0.k(k6 + selector.invoke(d1.b(e1.p(jArr, i6))).q0());
        }
        return k6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final <R> List<Pair<d1, R>> dd(@NotNull long[] jArr, @NotNull Iterable<? extends R> other) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$zip$0");
        g0.p(other, "other");
        int r5 = e1.r(jArr);
        ArrayList arrayList = new ArrayList(Math.min(f0.d0(other, 10), r5));
        int i6 = 0;
        for (R r6 : other) {
            if (i6 >= r5) {
                break;
            }
            arrayList.add(o0.a(d1.b(e1.p(jArr, i6)), r6));
            i6++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean e0(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$any$0");
        return n.u5(iArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @NotNull
    public static String e1(@Nullable byte[] bArr) {
        String r32;
        return (bArr == null || (r32 = f0.r3(w0.d(bArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : r32;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final v0 e2(byte[] bArr, int i6) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$elementAtOrNull$0");
        return u4(bArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final z0 e3(@NotNull int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$firstOrNull$0");
        if (a1.v(iArr)) {
            return null;
        }
        return z0.b(a1.p(iArr, 0));
    }

    @NotNull
    public static final m e4(@NotNull long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$indices$0");
        return n.Ee(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long e5(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$last$0");
        return d1.k(n.Rh(jArr));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R e6(byte[] bArr, Function1<? super v0, ? extends R> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$maxOfOrNull$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            return null;
        }
        R invoke = selector.invoke(v0.b(w0.p(bArr, 0)));
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                R invoke2 = selector.invoke(v0.b(w0.p(bArr, i6)));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R e7(int[] iArr, Function1<? super z0, ? extends R> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$minOf$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(z0.b(a1.p(iArr, 0)));
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                R invoke2 = selector.invoke(z0.b(a1.p(iArr, i6)));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] e8(byte[] bArr, Function2<? super Integer, ? super v0, n1> action) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$onEachIndexed$0");
        g0.p(action, "action");
        int r5 = w0.r(bArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            action.invoke(Integer.valueOf(i7), v0.b(w0.p(bArr, i6)));
            i6++;
            i7++;
        }
        return bArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int e9(int[] iArr, Function3<? super Integer, ? super z0, ? super z0, z0> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$reduceRightIndexed$0");
        g0.p(operation, "operation");
        int Me = n.Me(iArr);
        if (Me < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int p5 = a1.p(iArr, Me);
        for (int i6 = Me - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(Integer.valueOf(i6), z0.b(a1.p(iArr, i6)), z0.b(p5)).q0();
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void ea(@NotNull int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$shuffle$0");
        fa(iArr, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final void eb(@NotNull int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sortDescending$0");
        if (a1.r(iArr) > 1) {
            Sa(iArr);
            n.rr(iArr);
        }
    }

    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfUInt")
    public static final int ec(@NotNull z0[] z0VarArr) {
        g0.p(z0VarArr, "<this>");
        int i6 = 0;
        for (z0 z0Var : z0VarArr) {
            i6 = z0.k(i6 + z0Var.q0());
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final <R> List<Pair<z0, R>> ed(@NotNull int[] iArr, @NotNull Iterable<? extends R> other) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$zip$0");
        g0.p(other, "other");
        int r5 = a1.r(iArr);
        ArrayList arrayList = new ArrayList(Math.min(f0.d0(other, 10), r5));
        int i6 = 0;
        for (R r6 : other) {
            if (i6 >= r5) {
                break;
            }
            arrayList.add(o0.a(z0.b(a1.p(iArr, i6)), r6));
            i6++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean f0(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$any$0");
        return n.m5(bArr);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @NotNull
    public static String f1(@Nullable int[] iArr) {
        String r32;
        return (iArr == null || (r32 = f0.r3(a1.d(iArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : r32;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final j1 f2(short[] sArr, int i6) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$elementAtOrNull$0");
        return v4(sArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final v0 f3(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$firstOrNull$0");
        if (w0.v(bArr)) {
            return null;
        }
        return v0.b(w0.p(bArr, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int f5(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$last$0");
        g0.p(predicate, "predicate");
        int r5 = a1.r(iArr) - 1;
        if (r5 >= 0) {
            while (true) {
                int i6 = r5 - 1;
                int p5 = a1.p(iArr, r5);
                if (!predicate.invoke(z0.b(p5)).booleanValue()) {
                    if (i6 < 0) {
                        break;
                    }
                    r5 = i6;
                } else {
                    return p5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Double f6(byte[] bArr, Function1<? super v0, Double> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$maxOfOrNull$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            return null;
        }
        double doubleValue = selector.invoke(v0.b(w0.p(bArr, 0))).doubleValue();
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(v0.b(w0.p(bArr, i6))).doubleValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final double f7(short[] sArr, Function1<? super j1, Double> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$minOf$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(j1.b(k1.p(sArr, 0))).doubleValue();
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(j1.b(k1.p(sArr, i6))).doubleValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return doubleValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] f8(int[] iArr, Function2<? super Integer, ? super z0, n1> action) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$onEachIndexed$0");
        g0.p(action, "action");
        int r5 = a1.r(iArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            action.invoke(Integer.valueOf(i7), z0.b(a1.p(iArr, i6)));
            i6++;
            i7++;
        }
        return iArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte f9(byte[] bArr, Function3<? super Integer, ? super v0, ? super v0, v0> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$reduceRightIndexed$0");
        g0.p(operation, "operation");
        int Ie = n.Ie(bArr);
        if (Ie < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte p5 = w0.p(bArr, Ie);
        for (int i6 = Ie - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(Integer.valueOf(i6), v0.b(w0.p(bArr, i6)), v0.b(p5)).o0();
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void fa(@NotNull int[] iArr, @NotNull Random random) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$shuffle$0");
        g0.p(random, "random");
        for (int Me = n.Me(iArr); Me > 0; Me--) {
            int nextInt = random.nextInt(Me + 1);
            int p5 = a1.p(iArr, Me);
            a1.x(iArr, Me, a1.p(iArr, nextInt));
            a1.x(iArr, nextInt, p5);
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void fb(@NotNull long[] jArr, int i6, int i7) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sortDescending$0");
        Ta(jArr, i6, i7);
        n.ur(jArr, i6, i7);
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    private static final int fc(short[] sArr, Function1<? super j1, z0> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        int k6 = z0.k(0);
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            k6 = z0.k(k6 + selector.invoke(j1.b(k1.p(sArr, i6))).q0());
        }
        return k6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <V> List<V> fd(byte[] bArr, byte[] bArr2, Function2<? super v0, ? super v0, ? extends V> transform) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$zip$0");
        g0.p(bArr2, "$v$c$kotlin-UByteArray$-other$0");
        g0.p(transform, "transform");
        int min = Math.min(w0.r(bArr), w0.r(bArr2));
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(v0.b(w0.p(bArr, i6)), v0.b(w0.p(bArr2, i6))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean g0(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$any$0");
        g0.p(predicate, "predicate");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            if (predicate.invoke(v0.b(w0.p(bArr, i6))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @NotNull
    public static String g1(@Nullable short[] sArr) {
        String r32;
        return (sArr == null || (r32 = f0.r3(k1.d(sArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : r32;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final z0 g2(int[] iArr, int i6) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$elementAtOrNull$0");
        return w4(iArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final v0 g3(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$firstOrNull$0");
        g0.p(predicate, "predicate");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            if (predicate.invoke(v0.b(p5)).booleanValue()) {
                return v0.b(p5);
            }
        }
        return null;
    }

    @NotNull
    public static final m g4(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$indices$0");
        return n.Ge(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short g5(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$last$0");
        return j1.k(n.Vh(sArr));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Float g6(byte[] bArr, Function1<? super v0, Float> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$maxOfOrNull$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            return null;
        }
        float floatValue = selector.invoke(v0.b(w0.p(bArr, 0))).floatValue();
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(v0.b(w0.p(bArr, i6))).floatValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final float g7(short[] sArr, Function1<? super j1, Float> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$minOf$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(j1.b(k1.p(sArr, 0))).floatValue();
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(j1.b(k1.p(sArr, i6))).floatValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return floatValue;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] g8(long[] jArr, Function2<? super Integer, ? super d1, n1> action) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$onEachIndexed$0");
        g0.p(action, "action");
        int r5 = e1.r(jArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            action.invoke(Integer.valueOf(i7), d1.b(e1.p(jArr, i6)));
            i6++;
            i7++;
        }
        return jArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short g9(short[] sArr, Function3<? super Integer, ? super j1, ? super j1, j1> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$reduceRightIndexed$0");
        g0.p(operation, "operation");
        int Pe = n.Pe(sArr);
        if (Pe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short p5 = k1.p(sArr, Pe);
        for (int i6 = Pe - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(Integer.valueOf(i6), j1.b(k1.p(sArr, i6)), j1.b(p5)).o0();
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void ga(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$shuffle$0");
        ja(bArr, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void gb(@NotNull byte[] bArr, int i6, int i7) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sortDescending$0");
        Va(bArr, i6, i7);
        n.kr(bArr, i6, i7);
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final long gc(byte[] bArr, Function1<? super v0, d1> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        long k6 = d1.k(0L);
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            k6 = d1.k(k6 + selector.invoke(v0.b(w0.p(bArr, i6))).q0());
        }
        return k6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final <R> List<Pair<j1, R>> gd(@NotNull short[] sArr, @NotNull Iterable<? extends R> other) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$zip$0");
        g0.p(other, "other");
        int r5 = k1.r(sArr);
        ArrayList arrayList = new ArrayList(Math.min(f0.d0(other, 10), r5));
        int i6 = 0;
        for (R r6 : other) {
            if (i6 >= r5) {
                break;
            }
            arrayList.add(o0.a(j1.b(k1.p(sArr, i6)), r6));
            i6++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean h0(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$any$0");
        g0.p(predicate, "predicate");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            if (predicate.invoke(d1.b(e1.p(jArr, i6))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @NotNull
    public static String h1(@Nullable long[] jArr) {
        String r32;
        return (jArr == null || (r32 = f0.r3(e1.d(jArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : r32;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final d1 h2(long[] jArr, int i6) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$elementAtOrNull$0");
        return x4(jArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final d1 h3(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$firstOrNull$0");
        g0.p(predicate, "predicate");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            if (predicate.invoke(d1.b(p5)).booleanValue()) {
                return d1.b(p5);
            }
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short h5(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$last$0");
        g0.p(predicate, "predicate");
        int r5 = k1.r(sArr) - 1;
        if (r5 >= 0) {
            while (true) {
                int i6 = r5 - 1;
                short p5 = k1.p(sArr, r5);
                if (!predicate.invoke(j1.b(p5)).booleanValue()) {
                    if (i6 < 0) {
                        break;
                    }
                    r5 = i6;
                } else {
                    return p5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R h6(long[] jArr, Function1<? super d1, ? extends R> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$maxOfOrNull$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            return null;
        }
        R invoke = selector.invoke(d1.b(e1.p(jArr, 0)));
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                R invoke2 = selector.invoke(d1.b(e1.p(jArr, i6)));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R h7(short[] sArr, Function1<? super j1, ? extends R> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$minOf$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(j1.b(k1.p(sArr, 0)));
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                R invoke2 = selector.invoke(j1.b(k1.p(sArr, i6)));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] h8(short[] sArr, Function2<? super Integer, ? super j1, n1> action) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$onEachIndexed$0");
        g0.p(action, "action");
        int r5 = k1.r(sArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            action.invoke(Integer.valueOf(i7), j1.b(k1.p(sArr, i6)));
            i6++;
            i7++;
        }
        return sArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long h9(long[] jArr, Function3<? super Integer, ? super d1, ? super d1, d1> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$reduceRightIndexed$0");
        g0.p(operation, "operation");
        int Ne = n.Ne(jArr);
        if (Ne < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long p5 = e1.p(jArr, Ne);
        for (int i6 = Ne - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(Integer.valueOf(i6), d1.b(e1.p(jArr, i6)), d1.b(p5)).q0();
        }
        return p5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void ha(@NotNull long[] jArr, @NotNull Random random) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$shuffle$0");
        g0.p(random, "random");
        for (int Ne = n.Ne(jArr); Ne > 0; Ne--) {
            int nextInt = random.nextInt(Ne + 1);
            long p5 = e1.p(jArr, Ne);
            e1.x(jArr, Ne, e1.p(jArr, nextInt));
            e1.x(jArr, nextInt, p5);
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void hb(@NotNull short[] sArr, int i6, int i7) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sortDescending$0");
        Xa(sArr, i6, i7);
        n.yr(sArr, i6, i7);
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final long hc(int[] iArr, Function1<? super z0, d1> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        long k6 = d1.k(0L);
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            k6 = d1.k(k6 + selector.invoke(z0.b(a1.p(iArr, i6))).q0());
        }
        return k6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final <R> List<Pair<v0, R>> hd(@NotNull byte[] bArr, @NotNull Iterable<? extends R> other) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$zip$0");
        g0.p(other, "other");
        int r5 = w0.r(bArr);
        ArrayList arrayList = new ArrayList(Math.min(f0.d0(other, 10), r5));
        int i6 = 0;
        for (R r6 : other) {
            if (i6 >= r5) {
                break;
            }
            arrayList.add(o0.a(v0.b(w0.p(bArr, i6)), r6));
            i6++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean i0(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$any$0");
        return n.w5(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] i1(long[] jArr, long[] jArr2, int i6, int i7, int i8) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$copyInto$0");
        g0.p(jArr2, "$v$c$kotlin-ULongArray$-destination$0");
        n.A0(jArr, jArr2, i6, i7, i8);
        return jArr2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final void i2(@NotNull int[] iArr, int i6, int i7, int i8) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$fill$0");
        n.K1(iArr, i6, i7, i8);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final d1 i3(@NotNull long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$firstOrNull$0");
        if (e1.v(jArr)) {
            return null;
        }
        return d1.b(e1.p(jArr, 0));
    }

    public static final int i4(@NotNull int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$lastIndex$0");
        return n.Me(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int i5(long[] jArr, long j6) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$lastIndexOf$0");
        return n.ei(jArr, j6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Double i6(long[] jArr, Function1<? super d1, Double> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$maxOfOrNull$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            return null;
        }
        double doubleValue = selector.invoke(d1.b(e1.p(jArr, 0))).doubleValue();
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(d1.b(e1.p(jArr, i6))).doubleValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R i7(byte[] bArr, Function1<? super v0, ? extends R> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$minOfOrNull$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            return null;
        }
        R invoke = selector.invoke(v0.b(w0.p(bArr, 0)));
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                R invoke2 = selector.invoke(v0.b(w0.p(bArr, i6)));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] i8(long[] jArr, long j6) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$plus$0");
        return e1.f(n.t3(jArr, j6));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final z0 i9(int[] iArr, Function3<? super Integer, ? super z0, ? super z0, z0> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$reduceRightIndexedOrNull$0");
        g0.p(operation, "operation");
        int Me = n.Me(iArr);
        if (Me < 0) {
            return null;
        }
        int p5 = a1.p(iArr, Me);
        for (int i6 = Me - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(Integer.valueOf(i6), z0.b(a1.p(iArr, i6)), z0.b(p5)).q0();
        }
        return z0.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void ia(@NotNull long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$shuffle$0");
        ha(jArr, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final void ib(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sortDescending$0");
        if (w0.r(bArr) > 1) {
            Za(bArr);
            n.jr(bArr);
        }
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final long ic(long[] jArr, Function1<? super d1, d1> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        long k6 = d1.k(0L);
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            k6 = d1.k(k6 + selector.invoke(d1.b(e1.p(jArr, i6))).q0());
        }
        return k6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <V> List<V> id(int[] iArr, int[] iArr2, Function2<? super z0, ? super z0, ? extends V> transform) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$zip$0");
        g0.p(iArr2, "$v$c$kotlin-UIntArray$-other$0");
        g0.p(transform, "transform");
        int min = Math.min(a1.r(iArr), a1.r(iArr2));
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(z0.b(a1.p(iArr, i6)), z0.b(a1.p(iArr2, i6))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean j0(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$any$0");
        g0.p(predicate, "predicate");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            if (predicate.invoke(z0.b(a1.p(iArr, i6))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ long[] j1(long[] jArr, long[] jArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = e1.r(jArr);
        }
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$copyInto$0");
        g0.p(jArr2, "$v$c$kotlin-ULongArray$-destination$0");
        n.A0(jArr, jArr2, i6, i7, i8);
        return jArr2;
    }

    public static /* synthetic */ void j2(int[] iArr, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = a1.r(iArr);
        }
        i2(iArr, i6, i7, i8);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final z0 j3(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$firstOrNull$0");
        g0.p(predicate, "predicate");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            if (predicate.invoke(z0.b(p5)).booleanValue()) {
                return z0.b(p5);
            }
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int j5(short[] sArr, short s5) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$lastIndexOf$0");
        return n.gi(sArr, s5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Float j6(long[] jArr, Function1<? super d1, Float> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$maxOfOrNull$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            return null;
        }
        float floatValue = selector.invoke(d1.b(e1.p(jArr, 0))).floatValue();
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(d1.b(e1.p(jArr, i6))).floatValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Double j7(byte[] bArr, Function1<? super v0, Double> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$minOfOrNull$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            return null;
        }
        double doubleValue = selector.invoke(v0.b(w0.p(bArr, 0))).doubleValue();
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(v0.b(w0.p(bArr, i6))).doubleValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final int[] j8(@NotNull int[] iArr, @NotNull Collection<z0> elements) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$plus$0");
        g0.p(elements, "elements");
        int r5 = a1.r(iArr);
        int[] copyOf = Arrays.copyOf(iArr, a1.r(iArr) + elements.size());
        g0.o(copyOf, "copyOf(...)");
        Iterator<z0> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[r5] = it.next().q0();
            r5++;
        }
        return a1.f(copyOf);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final v0 j9(byte[] bArr, Function3<? super Integer, ? super v0, ? super v0, v0> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$reduceRightIndexedOrNull$0");
        g0.p(operation, "operation");
        int Ie = n.Ie(bArr);
        if (Ie < 0) {
            return null;
        }
        byte p5 = w0.p(bArr, Ie);
        for (int i6 = Ie - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(Integer.valueOf(i6), v0.b(w0.p(bArr, i6)), v0.b(p5)).o0();
        }
        return v0.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void ja(@NotNull byte[] bArr, @NotNull Random random) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$shuffle$0");
        g0.p(random, "random");
        for (int Ie = n.Ie(bArr); Ie > 0; Ie--) {
            int nextInt = random.nextInt(Ie + 1);
            byte p5 = w0.p(bArr, Ie);
            w0.x(bArr, Ie, w0.p(bArr, nextInt));
            w0.x(bArr, nextInt, p5);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final void jb(@NotNull long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sortDescending$0");
        if (e1.r(jArr) > 1) {
            ab(jArr);
            n.tr(jArr);
        }
    }

    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfULong")
    public static final long jc(@NotNull d1[] d1VarArr) {
        g0.p(d1VarArr, "<this>");
        long j6 = 0;
        for (d1 d1Var : d1VarArr) {
            j6 = d1.k(j6 + d1Var.q0());
        }
        return j6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, V> List<V> jd(byte[] bArr, R[] other, Function2<? super v0, ? super R, ? extends V> transform) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$zip$0");
        g0.p(other, "other");
        g0.p(transform, "transform");
        int min = Math.min(w0.r(bArr), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(v0.b(w0.p(bArr, i6)), other[i6]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean k0(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$any$0");
        return n.A5(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] k1(short[] sArr, short[] sArr2, int i6, int i7, int i8) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$copyInto$0");
        g0.p(sArr2, "$v$c$kotlin-UShortArray$-destination$0");
        n.C0(sArr, sArr2, i6, i7, i8);
        return sArr2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final void k2(@NotNull short[] sArr, short s5, int i6, int i7) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$fill$0");
        n.N1(sArr, s5, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final j1 k3(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$firstOrNull$0");
        if (k1.v(sArr)) {
            return null;
        }
        return j1.b(k1.p(sArr, 0));
    }

    public static final int k4(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$lastIndex$0");
        return n.Ie(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int k5(byte[] bArr, byte b6) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$lastIndexOf$0");
        return n.Zh(bArr, b6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R k6(int[] iArr, Function1<? super z0, ? extends R> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$maxOfOrNull$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            return null;
        }
        R invoke = selector.invoke(z0.b(a1.p(iArr, 0)));
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                R invoke2 = selector.invoke(z0.b(a1.p(iArr, i6)));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Float k7(byte[] bArr, Function1<? super v0, Float> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$minOfOrNull$0");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            return null;
        }
        float floatValue = selector.invoke(v0.b(w0.p(bArr, 0))).floatValue();
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(v0.b(w0.p(bArr, i6))).floatValue());
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] k8(short[] sArr, short s5) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$plus$0");
        return k1.f(n.A3(sArr, s5));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final j1 k9(short[] sArr, Function3<? super Integer, ? super j1, ? super j1, j1> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$reduceRightIndexedOrNull$0");
        g0.p(operation, "operation");
        int Pe = n.Pe(sArr);
        if (Pe < 0) {
            return null;
        }
        short p5 = k1.p(sArr, Pe);
        for (int i6 = Pe - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(Integer.valueOf(i6), j1.b(k1.p(sArr, i6)), j1.b(p5)).o0();
        }
        return j1.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void ka(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$shuffle$0");
        la(sArr, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void kb(@NotNull int[] iArr, int i6, int i7) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sortDescending$0");
        bb(iArr, i6, i7);
        n.sr(iArr, i6, i7);
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    private static final long kc(short[] sArr, Function1<? super j1, d1> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        g0.p(selector, "selector");
        long k6 = d1.k(0L);
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            k6 = d1.k(k6 + selector.invoke(j1.b(k1.p(sArr, i6))).q0());
        }
        return k6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <V> List<V> kd(long[] jArr, long[] jArr2, Function2<? super d1, ? super d1, ? extends V> transform) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$zip$0");
        g0.p(jArr2, "$v$c$kotlin-ULongArray$-other$0");
        g0.p(transform, "transform");
        int min = Math.min(e1.r(jArr), e1.r(jArr2));
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(d1.b(e1.p(jArr, i6)), d1.b(e1.p(jArr2, i6))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final boolean l0(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$any$0");
        g0.p(predicate, "predicate");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            if (predicate.invoke(j1.b(k1.p(sArr, i6))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ short[] l1(short[] sArr, short[] sArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = k1.r(sArr);
        }
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$copyInto$0");
        g0.p(sArr2, "$v$c$kotlin-UShortArray$-destination$0");
        n.C0(sArr, sArr2, i6, i7, i8);
        return sArr2;
    }

    public static /* synthetic */ void l2(short[] sArr, short s5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = k1.r(sArr);
        }
        k2(sArr, s5, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final j1 l3(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$firstOrNull$0");
        g0.p(predicate, "predicate");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            if (predicate.invoke(j1.b(p5)).booleanValue()) {
                return j1.b(p5);
            }
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int l5(int[] iArr, int i6) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$lastIndexOf$0");
        return n.di(iArr, i6);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Double l6(int[] iArr, Function1<? super z0, Double> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$maxOfOrNull$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            return null;
        }
        double doubleValue = selector.invoke(z0.b(a1.p(iArr, 0))).doubleValue();
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(z0.b(a1.p(iArr, i6))).doubleValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R l7(long[] jArr, Function1<? super d1, ? extends R> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$minOfOrNull$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            return null;
        }
        R invoke = selector.invoke(d1.b(e1.p(jArr, 0)));
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                R invoke2 = selector.invoke(d1.b(e1.p(jArr, i6)));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] l8(int[] iArr, int[] iArr2) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$plus$0");
        g0.p(iArr2, "$v$c$kotlin-UIntArray$-elements$0");
        return a1.f(n.s3(iArr, iArr2));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final d1 l9(long[] jArr, Function3<? super Integer, ? super d1, ? super d1, d1> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$reduceRightIndexedOrNull$0");
        g0.p(operation, "operation");
        int Ne = n.Ne(jArr);
        if (Ne < 0) {
            return null;
        }
        long p5 = e1.p(jArr, Ne);
        for (int i6 = Ne - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(Integer.valueOf(i6), d1.b(e1.p(jArr, i6)), d1.b(p5)).q0();
        }
        return d1.b(p5);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final void la(@NotNull short[] sArr, @NotNull Random random) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$shuffle$0");
        g0.p(random, "random");
        for (int Pe = n.Pe(sArr); Pe > 0; Pe--) {
            int nextInt = random.nextInt(Pe + 1);
            short p5 = k1.p(sArr, Pe);
            k1.x(sArr, Pe, k1.p(sArr, nextInt));
            k1.x(sArr, nextInt, p5);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final void lb(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sortDescending$0");
        if (k1.r(sArr) > 1) {
            db(sArr);
            n.xr(sArr);
        }
    }

    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfUShort")
    public static final int lc(@NotNull j1[] j1VarArr) {
        g0.p(j1VarArr, "<this>");
        int i6 = 0;
        for (j1 j1Var : j1VarArr) {
            i6 = z0.k(i6 + z0.k(j1Var.o0() & j1.f43986d));
        }
        return i6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, V> List<V> ld(long[] jArr, Iterable<? extends R> other, Function2<? super d1, ? super R, ? extends V> transform) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$zip$0");
        g0.p(other, "other");
        g0.p(transform, "transform");
        int r5 = e1.r(jArr);
        ArrayList arrayList = new ArrayList(Math.min(f0.d0(other, 10), r5));
        int i6 = 0;
        for (R r6 : other) {
            if (i6 >= r5) {
                break;
            }
            arrayList.add(transform.invoke(d1.b(e1.p(jArr, i6)), r6));
            i6++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] m0(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$asByteArray$0");
        return bArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] m1(byte[] bArr, byte[] bArr2, int i6, int i7, int i8) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$copyInto$0");
        g0.p(bArr2, "$v$c$kotlin-UByteArray$-destination$0");
        n.v0(bArr, bArr2, i6, i7, i8);
        return bArr2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final void m2(@NotNull long[] jArr, long j6, int i6, int i7) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$fill$0");
        n.L1(jArr, j6, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> m3(byte[] bArr, Function1<? super v0, ? extends Iterable<? extends R>> transform) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$flatMap$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            f0.s0(arrayList, transform.invoke(v0.b(w0.p(bArr, i6))));
        }
        return arrayList;
    }

    public static final int m4(@NotNull long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$lastIndex$0");
        return n.Ne(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final z0 m5(@NotNull int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$lastOrNull$0");
        if (a1.v(iArr)) {
            return null;
        }
        return z0.b(a1.p(iArr, a1.r(iArr) - 1));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Float m6(int[] iArr, Function1<? super z0, Float> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$maxOfOrNull$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            return null;
        }
        float floatValue = selector.invoke(z0.b(a1.p(iArr, 0))).floatValue();
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(z0.b(a1.p(iArr, i6))).floatValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Double m7(long[] jArr, Function1<? super d1, Double> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$minOfOrNull$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            return null;
        }
        double doubleValue = selector.invoke(d1.b(e1.p(jArr, 0))).doubleValue();
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(d1.b(e1.p(jArr, i6))).doubleValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] m8(byte[] bArr, byte b6) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$plus$0");
        return w0.f(n.e3(bArr, b6));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final v0 m9(byte[] bArr, Function2<? super v0, ? super v0, v0> operation) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$reduceRightOrNull$0");
        g0.p(operation, "operation");
        int Ie = n.Ie(bArr);
        if (Ie < 0) {
            return null;
        }
        byte p5 = w0.p(bArr, Ie);
        for (int i6 = Ie - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(v0.b(w0.p(bArr, i6)), v0.b(p5)).o0();
        }
        return v0.b(p5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int ma(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$single$0");
        return z0.k(n.wt(iArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<z0> mb(@NotNull int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sorted$0");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        g0.o(copyOf, "copyOf(...)");
        int[] f6 = a1.f(copyOf);
        Sa(f6);
        return b.a(f6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<v0> mc(@NotNull byte[] bArr, int i6) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$take$0");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return f0.J();
        }
        if (i6 >= w0.r(bArr)) {
            return f0.a6(w0.d(bArr));
        }
        if (i6 == 1) {
            return f0.l(v0.b(w0.p(bArr, 0)));
        }
        ArrayList arrayList = new ArrayList(i6);
        int r5 = w0.r(bArr);
        int i7 = 0;
        for (int i8 = 0; i8 < r5; i8++) {
            arrayList.add(v0.b(w0.p(bArr, i8)));
            i7++;
            if (i7 == i6) {
                break;
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, V> List<V> md(byte[] bArr, Iterable<? extends R> other, Function2<? super v0, ? super R, ? extends V> transform) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$zip$0");
        g0.p(other, "other");
        g0.p(transform, "transform");
        int r5 = w0.r(bArr);
        ArrayList arrayList = new ArrayList(Math.min(f0.d0(other, 10), r5));
        int i6 = 0;
        for (R r6 : other) {
            if (i6 >= r5) {
                break;
            }
            arrayList.add(transform.invoke(v0.b(w0.p(bArr, i6)), r6));
            i6++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] n0(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$asIntArray$0");
        return iArr;
    }

    static /* synthetic */ byte[] n1(byte[] bArr, byte[] bArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = w0.r(bArr);
        }
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$copyInto$0");
        g0.p(bArr2, "$v$c$kotlin-UByteArray$-destination$0");
        n.v0(bArr, bArr2, i6, i7, i8);
        return bArr2;
    }

    public static /* synthetic */ void n2(long[] jArr, long j6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = e1.r(jArr);
        }
        m2(jArr, j6, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> n3(long[] jArr, Function1<? super d1, ? extends Iterable<? extends R>> transform) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$flatMap$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            f0.s0(arrayList, transform.invoke(d1.b(e1.p(jArr, i6))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final v0 n5(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$lastOrNull$0");
        if (w0.v(bArr)) {
            return null;
        }
        return v0.b(w0.p(bArr, w0.r(bArr) - 1));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R n6(short[] sArr, Function1<? super j1, ? extends R> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$maxOfOrNull$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            return null;
        }
        R invoke = selector.invoke(j1.b(k1.p(sArr, 0)));
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                R invoke2 = selector.invoke(j1.b(k1.p(sArr, i6)));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Float n7(long[] jArr, Function1<? super d1, Float> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$minOfOrNull$0");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            return null;
        }
        float floatValue = selector.invoke(d1.b(e1.p(jArr, 0))).floatValue();
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(d1.b(e1.p(jArr, i6))).floatValue());
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] n8(byte[] bArr, byte[] bArr2) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$plus$0");
        g0.p(bArr2, "$v$c$kotlin-UByteArray$-elements$0");
        return w0.f(n.g3(bArr, bArr2));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final z0 n9(int[] iArr, Function2<? super z0, ? super z0, z0> operation) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$reduceRightOrNull$0");
        g0.p(operation, "operation");
        int Me = n.Me(iArr);
        if (Me < 0) {
            return null;
        }
        int p5 = a1.p(iArr, Me);
        for (int i6 = Me - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(z0.b(a1.p(iArr, i6)), z0.b(p5)).q0();
        }
        return z0.b(p5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte na(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$single$0");
        return v0.k(n.ot(bArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<v0> nb(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sorted$0");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        g0.o(copyOf, "copyOf(...)");
        byte[] f6 = w0.f(copyOf);
        Za(f6);
        return b.b(f6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<j1> nc(@NotNull short[] sArr, int i6) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$take$0");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return f0.J();
        }
        if (i6 >= k1.r(sArr)) {
            return f0.a6(k1.d(sArr));
        }
        if (i6 == 1) {
            return f0.l(j1.b(k1.p(sArr, 0)));
        }
        ArrayList arrayList = new ArrayList(i6);
        int r5 = k1.r(sArr);
        int i7 = 0;
        for (int i8 = 0; i8 < r5; i8++) {
            arrayList.add(j1.b(k1.p(sArr, i8)));
            i7++;
            if (i7 == i6) {
                break;
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, V> List<V> nd(int[] iArr, R[] other, Function2<? super z0, ? super R, ? extends V> transform) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$zip$0");
        g0.p(other, "other");
        g0.p(transform, "transform");
        int min = Math.min(a1.r(iArr), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(z0.b(a1.p(iArr, i6)), other[i6]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] o0(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$asLongArray$0");
        return jArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] o1(int[] iArr, int[] iArr2, int i6, int i7, int i8) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$copyInto$0");
        g0.p(iArr2, "$v$c$kotlin-UIntArray$-destination$0");
        n.z0(iArr, iArr2, i6, i7, i8);
        return iArr2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final void o2(@NotNull byte[] bArr, byte b6, int i6, int i7) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$fill$0");
        n.G1(bArr, b6, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> o3(int[] iArr, Function1<? super z0, ? extends Iterable<? extends R>> transform) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$flatMap$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            f0.s0(arrayList, transform.invoke(z0.b(a1.p(iArr, i6))));
        }
        return arrayList;
    }

    public static final int o4(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$lastIndex$0");
        return n.Pe(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final v0 o5(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$lastOrNull$0");
        g0.p(predicate, "predicate");
        int r5 = w0.r(bArr) - 1;
        if (r5 < 0) {
            return null;
        }
        while (true) {
            int i6 = r5 - 1;
            byte p5 = w0.p(bArr, r5);
            if (predicate.invoke(v0.b(p5)).booleanValue()) {
                return v0.b(p5);
            }
            if (i6 < 0) {
                return null;
            }
            r5 = i6;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Double o6(short[] sArr, Function1<? super j1, Double> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$maxOfOrNull$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            return null;
        }
        double doubleValue = selector.invoke(j1.b(k1.p(sArr, 0))).doubleValue();
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(j1.b(k1.p(sArr, i6))).doubleValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R o7(int[] iArr, Function1<? super z0, ? extends R> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$minOfOrNull$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            return null;
        }
        R invoke = selector.invoke(z0.b(a1.p(iArr, 0)));
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                R invoke2 = selector.invoke(z0.b(a1.p(iArr, i6)));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final long[] o8(@NotNull long[] jArr, @NotNull Collection<d1> elements) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$plus$0");
        g0.p(elements, "elements");
        int r5 = e1.r(jArr);
        long[] copyOf = Arrays.copyOf(jArr, e1.r(jArr) + elements.size());
        g0.o(copyOf, "copyOf(...)");
        Iterator<d1> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[r5] = it.next().q0();
            r5++;
        }
        return e1.f(copyOf);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final d1 o9(long[] jArr, Function2<? super d1, ? super d1, d1> operation) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$reduceRightOrNull$0");
        g0.p(operation, "operation");
        int Ne = n.Ne(jArr);
        if (Ne < 0) {
            return null;
        }
        long p5 = e1.p(jArr, Ne);
        for (int i6 = Ne - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(d1.b(e1.p(jArr, i6)), d1.b(p5)).q0();
        }
        return d1.b(p5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte oa(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$single$0");
        g0.p(predicate, "predicate");
        int r5 = w0.r(bArr);
        v0 v0Var = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            if (predicate.invoke(v0.b(p5)).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                v0Var = v0.b(p5);
                z5 = true;
            }
        }
        if (z5) {
            return v0Var.o0();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<d1> ob(@NotNull long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sorted$0");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        g0.o(copyOf, "copyOf(...)");
        long[] f6 = e1.f(copyOf);
        ab(f6);
        return b.c(f6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<z0> oc(@NotNull int[] iArr, int i6) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$take$0");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return f0.J();
        }
        if (i6 >= a1.r(iArr)) {
            return f0.a6(a1.d(iArr));
        }
        if (i6 == 1) {
            return f0.l(z0.b(a1.p(iArr, 0)));
        }
        ArrayList arrayList = new ArrayList(i6);
        int r5 = a1.r(iArr);
        int i7 = 0;
        for (int i8 = 0; i8 < r5; i8++) {
            arrayList.add(z0.b(a1.p(iArr, i8)));
            i7++;
            if (i7 == i6) {
                break;
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<Pair<z0, z0>> od(@NotNull int[] iArr, @NotNull int[] iArr2) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$zip$0");
        g0.p(iArr2, "$v$c$kotlin-UIntArray$-other$0");
        int min = Math.min(a1.r(iArr), a1.r(iArr2));
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(o0.a(z0.b(a1.p(iArr, i6)), z0.b(a1.p(iArr2, i6))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] p0(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$asShortArray$0");
        return sArr;
    }

    static /* synthetic */ int[] p1(int[] iArr, int[] iArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = a1.r(iArr);
        }
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$copyInto$0");
        g0.p(iArr2, "$v$c$kotlin-UIntArray$-destination$0");
        n.z0(iArr, iArr2, i6, i7, i8);
        return iArr2;
    }

    public static /* synthetic */ void p2(byte[] bArr, byte b6, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = w0.r(bArr);
        }
        o2(bArr, b6, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> p3(short[] sArr, Function1<? super j1, ? extends Iterable<? extends R>> transform) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$flatMap$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            f0.s0(arrayList, transform.invoke(j1.b(k1.p(sArr, i6))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final d1 p5(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$lastOrNull$0");
        g0.p(predicate, "predicate");
        int r5 = e1.r(jArr) - 1;
        if (r5 < 0) {
            return null;
        }
        while (true) {
            int i6 = r5 - 1;
            long p5 = e1.p(jArr, r5);
            if (predicate.invoke(d1.b(p5)).booleanValue()) {
                return d1.b(p5);
            }
            if (i6 < 0) {
                return null;
            }
            r5 = i6;
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Float p6(short[] sArr, Function1<? super j1, Float> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$maxOfOrNull$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            return null;
        }
        float floatValue = selector.invoke(j1.b(k1.p(sArr, 0))).floatValue();
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(j1.b(k1.p(sArr, i6))).floatValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Double p7(int[] iArr, Function1<? super z0, Double> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$minOfOrNull$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            return null;
        }
        double doubleValue = selector.invoke(z0.b(a1.p(iArr, 0))).doubleValue();
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(z0.b(a1.p(iArr, i6))).doubleValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] p8(short[] sArr, short[] sArr2) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$plus$0");
        g0.p(sArr2, "$v$c$kotlin-UShortArray$-elements$0");
        return k1.f(n.B3(sArr, sArr2));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final j1 p9(short[] sArr, Function2<? super j1, ? super j1, j1> operation) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$reduceRightOrNull$0");
        g0.p(operation, "operation");
        int Pe = n.Pe(sArr);
        if (Pe < 0) {
            return null;
        }
        short p5 = k1.p(sArr, Pe);
        for (int i6 = Pe - 1; i6 >= 0; i6--) {
            p5 = operation.invoke(j1.b(k1.p(sArr, i6)), j1.b(p5)).o0();
        }
        return j1.b(p5);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long pa(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$single$0");
        g0.p(predicate, "predicate");
        int r5 = e1.r(jArr);
        d1 d1Var = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            if (predicate.invoke(d1.b(p5)).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                d1Var = d1.b(p5);
                z5 = true;
            }
        }
        if (z5) {
            return d1Var.q0();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<j1> pb(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sorted$0");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        g0.o(copyOf, "copyOf(...)");
        short[] f6 = k1.f(copyOf);
        db(f6);
        return b.d(f6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<d1> pc(@NotNull long[] jArr, int i6) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$take$0");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return f0.J();
        }
        if (i6 >= e1.r(jArr)) {
            return f0.a6(e1.d(jArr));
        }
        if (i6 == 1) {
            return f0.l(d1.b(e1.p(jArr, 0)));
        }
        ArrayList arrayList = new ArrayList(i6);
        int r5 = e1.r(jArr);
        int i7 = 0;
        for (int i8 = 0; i8 < r5; i8++) {
            arrayList.add(d1.b(e1.p(jArr, i8)));
            i7++;
            if (i7 == i6) {
                break;
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, V> List<V> pd(short[] sArr, R[] other, Function2<? super j1, ? super R, ? extends V> transform) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$zip$0");
        g0.p(other, "other");
        g0.p(transform, "transform");
        int min = Math.min(k1.r(sArr), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(j1.b(k1.p(sArr, i6)), other[i6]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] q0(byte[] bArr) {
        g0.p(bArr, "<this>");
        return w0.f(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] q1(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$copyOf$0");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        g0.o(copyOf, "copyOf(...)");
        return a1.f(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<v0> q2(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$filter$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            if (predicate.invoke(v0.b(p5)).booleanValue()) {
                arrayList.add(v0.b(p5));
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> List<R> q3(byte[] bArr, Function2<? super Integer, ? super v0, ? extends Iterable<? extends R>> transform) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$flatMapIndexed$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int r5 = w0.r(bArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            f0.s0(arrayList, transform.invoke(Integer.valueOf(i7), v0.b(w0.p(bArr, i6))));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short q4(short[] sArr, int i6, Function1<? super Integer, j1> defaultValue) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$getOrElse$0");
        g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= k1.r(sArr)) ? defaultValue.invoke(Integer.valueOf(i6)).o0() : k1.p(sArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final d1 q5(@NotNull long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$lastOrNull$0");
        if (e1.v(jArr)) {
            return null;
        }
        return d1.b(e1.p(jArr, e1.r(jArr) - 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R q6(long[] jArr, Comparator<? super R> comparator, Function1<? super d1, ? extends R> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$maxOfWith$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(d1.b(e1.p(jArr, 0)));
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                Object obj2 = (R) selector.invoke(d1.b(e1.p(jArr, i6)));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Float q7(int[] iArr, Function1<? super z0, Float> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$minOfOrNull$0");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            return null;
        }
        float floatValue = selector.invoke(z0.b(a1.p(iArr, 0))).floatValue();
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(z0.b(a1.p(iArr, i6))).floatValue());
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final short[] q8(@NotNull short[] sArr, @NotNull Collection<j1> elements) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$plus$0");
        g0.p(elements, "elements");
        int r5 = k1.r(sArr);
        short[] copyOf = Arrays.copyOf(sArr, k1.r(sArr) + elements.size());
        g0.o(copyOf, "copyOf(...)");
        Iterator<j1> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[r5] = it.next().o0();
            r5++;
        }
        return k1.f(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void q9(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$reverse$0");
        n.rr(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long qa(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$single$0");
        return d1.k(n.yt(jArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final int[] qb(@NotNull int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sortedArray$0");
        if (a1.v(iArr)) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        g0.o(copyOf, "copyOf(...)");
        int[] f6 = a1.f(copyOf);
        Sa(f6);
        return f6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<v0> qc(@NotNull byte[] bArr, int i6) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$takeLast$0");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return f0.J();
        }
        int r5 = w0.r(bArr);
        if (i6 >= r5) {
            return f0.a6(w0.d(bArr));
        }
        if (i6 == 1) {
            return f0.l(v0.b(w0.p(bArr, r5 - 1)));
        }
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = r5 - i6; i7 < r5; i7++) {
            arrayList.add(v0.b(w0.p(bArr, i7)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final <R> List<Pair<d1, R>> qd(@NotNull long[] jArr, @NotNull R[] other) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$zip$0");
        g0.p(other, "other");
        int min = Math.min(e1.r(jArr), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            long p5 = e1.p(jArr, i6);
            arrayList.add(o0.a(d1.b(p5), other[i6]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] r0(int[] iArr) {
        g0.p(iArr, "<this>");
        return a1.f(iArr);
    }

    @SinceKotlin(version = "2.2")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] r1(short[] sArr, int i6, Function1<? super Integer, j1> init) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$copyOf$0");
        g0.p(init, "init");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i6 + '.').toString());
        }
        short[] copyOf = Arrays.copyOf(sArr, i6);
        g0.o(copyOf, "copyOf(...)");
        short[] f6 = k1.f(copyOf);
        for (int r5 = k1.r(sArr); r5 < i6; r5++) {
            k1.x(f6, r5, init.invoke(Integer.valueOf(r5)).o0());
        }
        return f6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<d1> r2(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$filter$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            if (predicate.invoke(d1.b(p5)).booleanValue()) {
                arrayList.add(d1.b(p5));
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> List<R> r3(int[] iArr, Function2<? super Integer, ? super z0, ? extends Iterable<? extends R>> transform) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$flatMapIndexed$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int r5 = a1.r(iArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            f0.s0(arrayList, transform.invoke(Integer.valueOf(i7), z0.b(a1.p(iArr, i6))));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int r4(int[] iArr, int i6, Function1<? super Integer, z0> defaultValue) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$getOrElse$0");
        g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= a1.r(iArr)) ? defaultValue.invoke(Integer.valueOf(i6)).q0() : a1.p(iArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final z0 r5(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$lastOrNull$0");
        g0.p(predicate, "predicate");
        int r5 = a1.r(iArr) - 1;
        if (r5 < 0) {
            return null;
        }
        while (true) {
            int i6 = r5 - 1;
            int p5 = a1.p(iArr, r5);
            if (predicate.invoke(z0.b(p5)).booleanValue()) {
                return z0.b(p5);
            }
            if (i6 < 0) {
                return null;
            }
            r5 = i6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R r6(byte[] bArr, Comparator<? super R> comparator, Function1<? super v0, ? extends R> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$maxOfWith$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(v0.b(w0.p(bArr, 0)));
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                Object obj2 = (R) selector.invoke(v0.b(w0.p(bArr, i6)));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R extends Comparable<? super R>> R r7(short[] sArr, Function1<? super j1, ? extends R> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$minOfOrNull$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            return null;
        }
        R invoke = selector.invoke(j1.b(k1.p(sArr, 0)));
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                R invoke2 = selector.invoke(j1.b(k1.p(sArr, i6)));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return invoke;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] r8(int[] iArr, int i6) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$plus$0");
        return a1.f(n.q3(iArr, i6));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void r9(long[] jArr, int i6, int i7) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$reverse$0");
        n.ur(jArr, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int ra(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$single$0");
        g0.p(predicate, "predicate");
        int r5 = a1.r(iArr);
        z0 z0Var = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            if (predicate.invoke(z0.b(p5)).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                z0Var = z0.b(p5);
                z5 = true;
            }
        }
        if (z5) {
            return z0Var.q0();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] rb(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sortedArray$0");
        if (w0.v(bArr)) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        g0.o(copyOf, "copyOf(...)");
        byte[] f6 = w0.f(copyOf);
        Za(f6);
        return f6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<j1> rc(@NotNull short[] sArr, int i6) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$takeLast$0");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return f0.J();
        }
        int r5 = k1.r(sArr);
        if (i6 >= r5) {
            return f0.a6(k1.d(sArr));
        }
        if (i6 == 1) {
            return f0.l(j1.b(k1.p(sArr, r5 - 1)));
        }
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = r5 - i6; i7 < r5; i7++) {
            arrayList.add(j1.b(k1.p(sArr, i7)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <V> List<V> rd(short[] sArr, short[] sArr2, Function2<? super j1, ? super j1, ? extends V> transform) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$zip$0");
        g0.p(sArr2, "$v$c$kotlin-UShortArray$-other$0");
        g0.p(transform, "transform");
        int min = Math.min(k1.r(sArr), k1.r(sArr2));
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(transform.invoke(j1.b(k1.p(sArr, i6)), j1.b(k1.p(sArr2, i6))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] s0(long[] jArr) {
        g0.p(jArr, "<this>");
        return e1.f(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] s1(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$copyOf$0");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        g0.o(copyOf, "copyOf(...)");
        return w0.f(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<z0> s2(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$filter$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            if (predicate.invoke(z0.b(p5)).booleanValue()) {
                arrayList.add(z0.b(p5));
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> List<R> s3(long[] jArr, Function2<? super Integer, ? super d1, ? extends Iterable<? extends R>> transform) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$flatMapIndexed$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int r5 = e1.r(jArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            f0.s0(arrayList, transform.invoke(Integer.valueOf(i7), d1.b(e1.p(jArr, i6))));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long s4(long[] jArr, int i6, Function1<? super Integer, d1> defaultValue) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$getOrElse$0");
        g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= e1.r(jArr)) ? defaultValue.invoke(Integer.valueOf(i6)).q0() : e1.p(jArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final j1 s5(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$lastOrNull$0");
        if (k1.v(sArr)) {
            return null;
        }
        return j1.b(k1.p(sArr, k1.r(sArr) - 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R s6(short[] sArr, Comparator<? super R> comparator, Function1<? super j1, ? extends R> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$maxOfWith$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(j1.b(k1.p(sArr, 0)));
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                Object obj2 = (R) selector.invoke(j1.b(k1.p(sArr, i6)));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Double s7(short[] sArr, Function1<? super j1, Double> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$minOfOrNull$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            return null;
        }
        double doubleValue = selector.invoke(j1.b(k1.p(sArr, 0))).doubleValue();
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(j1.b(k1.p(sArr, i6))).doubleValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] s8(long[] jArr, long[] jArr2) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$plus$0");
        g0.p(jArr2, "$v$c$kotlin-ULongArray$-elements$0");
        return e1.f(n.v3(jArr, jArr2));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void s9(byte[] bArr, int i6, int i7) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$reverse$0");
        n.kr(bArr, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short sa(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$single$0");
        return j1.k(n.Ct(sArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final long[] sb(@NotNull long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sortedArray$0");
        if (e1.v(jArr)) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        g0.o(copyOf, "copyOf(...)");
        long[] f6 = e1.f(copyOf);
        ab(f6);
        return f6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<z0> sc(@NotNull int[] iArr, int i6) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$takeLast$0");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return f0.J();
        }
        int r5 = a1.r(iArr);
        if (i6 >= r5) {
            return f0.a6(a1.d(iArr));
        }
        if (i6 == 1) {
            return f0.l(z0.b(a1.p(iArr, r5 - 1)));
        }
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = r5 - i6; i7 < r5; i7++) {
            arrayList.add(z0.b(a1.p(iArr, i7)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, V> List<V> sd(short[] sArr, Iterable<? extends R> other, Function2<? super j1, ? super R, ? extends V> transform) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$zip$0");
        g0.p(other, "other");
        g0.p(transform, "transform");
        int r5 = k1.r(sArr);
        ArrayList arrayList = new ArrayList(Math.min(f0.d0(other, 10), r5));
        int i6 = 0;
        for (R r6 : other) {
            if (i6 >= r5) {
                break;
            }
            arrayList.add(transform.invoke(j1.b(k1.p(sArr, i6)), r6));
            i6++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] t0(short[] sArr) {
        g0.p(sArr, "<this>");
        return k1.f(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] t1(byte[] bArr, int i6) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$copyOf$0");
        byte[] copyOf = Arrays.copyOf(bArr, i6);
        g0.o(copyOf, "copyOf(...)");
        return w0.f(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<j1> t2(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$filter$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            if (predicate.invoke(j1.b(p5)).booleanValue()) {
                arrayList.add(j1.b(p5));
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> List<R> t3(short[] sArr, Function2<? super Integer, ? super j1, ? extends Iterable<? extends R>> transform) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$flatMapIndexed$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int r5 = k1.r(sArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            f0.s0(arrayList, transform.invoke(Integer.valueOf(i7), j1.b(k1.p(sArr, i6))));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte t4(byte[] bArr, int i6, Function1<? super Integer, v0> defaultValue) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$getOrElse$0");
        g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= w0.r(bArr)) ? defaultValue.invoke(Integer.valueOf(i6)).o0() : w0.p(bArr, i6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final j1 t5(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$lastOrNull$0");
        g0.p(predicate, "predicate");
        int r5 = k1.r(sArr) - 1;
        if (r5 < 0) {
            return null;
        }
        while (true) {
            int i6 = r5 - 1;
            short p5 = k1.p(sArr, r5);
            if (predicate.invoke(j1.b(p5)).booleanValue()) {
                return j1.b(p5);
            }
            if (i6 < 0) {
                return null;
            }
            r5 = i6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R t6(int[] iArr, Comparator<? super R> comparator, Function1<? super z0, ? extends R> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$maxOfWith$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(z0.b(a1.p(iArr, 0)));
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                Object obj2 = (R) selector.invoke(z0.b(a1.p(iArr, i6)));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final Float t7(short[] sArr, Function1<? super j1, Float> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$minOfOrNull$0");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            return null;
        }
        float floatValue = selector.invoke(j1.b(k1.p(sArr, 0))).floatValue();
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(j1.b(k1.p(sArr, i6))).floatValue());
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] t8(@NotNull byte[] bArr, @NotNull Collection<v0> elements) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$plus$0");
        g0.p(elements, "elements");
        int r5 = w0.r(bArr);
        byte[] copyOf = Arrays.copyOf(bArr, w0.r(bArr) + elements.size());
        g0.o(copyOf, "copyOf(...)");
        Iterator<v0> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[r5] = it.next().o0();
            r5++;
        }
        return w0.f(copyOf);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void t9(short[] sArr, int i6, int i7) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$reverse$0");
        n.yr(sArr, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short ta(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$single$0");
        g0.p(predicate, "predicate");
        int r5 = k1.r(sArr);
        j1 j1Var = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            if (predicate.invoke(j1.b(p5)).booleanValue()) {
                if (z5) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                j1Var = j1.b(p5);
                z5 = true;
            }
        }
        if (z5) {
            return j1Var.o0();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final short[] tb(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sortedArray$0");
        if (k1.v(sArr)) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        g0.o(copyOf, "copyOf(...)");
        short[] f6 = k1.f(copyOf);
        db(f6);
        return f6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<d1> tc(@NotNull long[] jArr, int i6) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$takeLast$0");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i6 + " is less than zero.").toString());
        }
        if (i6 == 0) {
            return f0.J();
        }
        int r5 = e1.r(jArr);
        if (i6 >= r5) {
            return f0.a6(e1.d(jArr));
        }
        if (i6 == 1) {
            return f0.l(d1.b(e1.p(jArr, r5 - 1)));
        }
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = r5 - i6; i7 < r5; i7++) {
            arrayList.add(d1.b(e1.p(jArr, i7)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<Pair<v0, v0>> td(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$zip$0");
        g0.p(bArr2, "$v$c$kotlin-UByteArray$-other$0");
        int min = Math.min(w0.r(bArr), w0.r(bArr2));
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(o0.a(v0.b(w0.p(bArr, i6)), v0.b(w0.p(bArr2, i6))));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <V> Map<v0, V> u0(byte[] bArr, Function1<? super v0, ? extends V> valueSelector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$associateWith$0");
        g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t.u(i1.j(w0.r(bArr)), 16));
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            linkedHashMap.put(v0.b(p5), valueSelector.invoke(v0.b(p5)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] u1(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$copyOf$0");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        g0.o(copyOf, "copyOf(...)");
        return e1.f(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<v0> u2(byte[] bArr, Function2<? super Integer, ? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$filterIndexed$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = w0.r(bArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            byte p5 = w0.p(bArr, i6);
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), v0.b(p5)).booleanValue()) {
                arrayList.add(v0.b(p5));
            }
            i6++;
            i7 = i8;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R, C extends Collection<? super R>> C u3(int[] iArr, C destination, Function2<? super Integer, ? super z0, ? extends Iterable<? extends R>> transform) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$flatMapIndexedTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = a1.r(iArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            f0.s0(destination, transform.invoke(Integer.valueOf(i7), z0.b(a1.p(iArr, i6))));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final v0 u4(@NotNull byte[] bArr, int i6) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$getOrNull$0");
        if (i6 < 0 || i6 >= w0.r(bArr)) {
            return null;
        }
        return v0.b(w0.p(bArr, i6));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> u5(byte[] bArr, Function1<? super v0, ? extends R> transform) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$map$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(w0.r(bArr));
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            arrayList.add(transform.invoke(v0.b(w0.p(bArr, i6))));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R u6(long[] jArr, Comparator<? super R> comparator, Function1<? super d1, ? extends R> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$maxOfWithOrNull$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            return null;
        }
        Object obj = (R) selector.invoke(d1.b(e1.p(jArr, 0)));
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                Object obj2 = (R) selector.invoke(d1.b(e1.p(jArr, i6)));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R u7(long[] jArr, Comparator<? super R> comparator, Function1<? super d1, ? extends R> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$minOfWith$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(d1.b(e1.p(jArr, 0)));
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                Object obj2 = (R) selector.invoke(d1.b(e1.p(jArr, i6)));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int u8(int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$random$0");
        return v8(iArr, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void u9(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$reverse$0");
        n.jr(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final z0 ua(@NotNull int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$singleOrNull$0");
        if (a1.r(iArr) == 1) {
            return z0.b(a1.p(iArr, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final int[] ub(@NotNull int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sortedArrayDescending$0");
        if (a1.v(iArr)) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        g0.o(copyOf, "copyOf(...)");
        int[] f6 = a1.f(copyOf);
        eb(f6);
        return f6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<v0> uc(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$takeLastWhile$0");
        g0.p(predicate, "predicate");
        for (int Ie = n.Ie(bArr); -1 < Ie; Ie--) {
            if (!predicate.invoke(v0.b(w0.p(bArr, Ie))).booleanValue()) {
                return K1(bArr, Ie + 1);
            }
        }
        return f0.a6(w0.d(bArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<Pair<j1, j1>> ud(@NotNull short[] sArr, @NotNull short[] sArr2) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$zip$0");
        g0.p(sArr2, "$v$c$kotlin-UShortArray$-other$0");
        int min = Math.min(k1.r(sArr), k1.r(sArr2));
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(o0.a(j1.b(k1.p(sArr, i6)), j1.b(k1.p(sArr2, i6))));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <V> Map<d1, V> v0(long[] jArr, Function1<? super d1, ? extends V> valueSelector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$associateWith$0");
        g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t.u(i1.j(e1.r(jArr)), 16));
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            linkedHashMap.put(d1.b(p5), valueSelector.invoke(d1.b(p5)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "2.2")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] v1(int[] iArr, int i6, Function1<? super Integer, z0> init) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$copyOf$0");
        g0.p(init, "init");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i6 + '.').toString());
        }
        int[] copyOf = Arrays.copyOf(iArr, i6);
        g0.o(copyOf, "copyOf(...)");
        int[] f6 = a1.f(copyOf);
        for (int r5 = a1.r(iArr); r5 < i6; r5++) {
            a1.x(f6, r5, init.invoke(Integer.valueOf(r5)).q0());
        }
        return f6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<z0> v2(int[] iArr, Function2<? super Integer, ? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$filterIndexed$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = a1.r(iArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            int p5 = a1.p(iArr, i6);
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), z0.b(p5)).booleanValue()) {
                arrayList.add(z0.b(p5));
            }
            i6++;
            i7 = i8;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R, C extends Collection<? super R>> C v3(short[] sArr, C destination, Function2<? super Integer, ? super j1, ? extends Iterable<? extends R>> transform) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$flatMapIndexedTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = k1.r(sArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            f0.s0(destination, transform.invoke(Integer.valueOf(i7), j1.b(k1.p(sArr, i6))));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final j1 v4(@NotNull short[] sArr, int i6) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$getOrNull$0");
        if (i6 < 0 || i6 >= k1.r(sArr)) {
            return null;
        }
        return j1.b(k1.p(sArr, i6));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> v5(long[] jArr, Function1<? super d1, ? extends R> transform) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$map$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(e1.r(jArr));
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            arrayList.add(transform.invoke(d1.b(e1.p(jArr, i6))));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R v6(byte[] bArr, Comparator<? super R> comparator, Function1<? super v0, ? extends R> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$maxOfWithOrNull$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            return null;
        }
        Object obj = (R) selector.invoke(v0.b(w0.p(bArr, 0)));
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                Object obj2 = (R) selector.invoke(v0.b(w0.p(bArr, i6)));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R v7(byte[] bArr, Comparator<? super R> comparator, Function1<? super v0, ? extends R> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$minOfWith$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(v0.b(w0.p(bArr, 0)));
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                Object obj2 = (R) selector.invoke(v0.b(w0.p(bArr, i6)));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int v8(@NotNull int[] iArr, @NotNull Random random) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$random$0");
        g0.p(random, "random");
        if (a1.v(iArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return a1.p(iArr, random.nextInt(a1.r(iArr)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void v9(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$reverse$0");
        n.tr(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final v0 va(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$singleOrNull$0");
        if (w0.r(bArr) == 1) {
            return v0.b(w0.p(bArr, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] vb(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sortedArrayDescending$0");
        if (w0.v(bArr)) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        g0.o(copyOf, "copyOf(...)");
        byte[] f6 = w0.f(copyOf);
        ib(f6);
        return f6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<d1> vc(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$takeLastWhile$0");
        g0.p(predicate, "predicate");
        for (int Ne = n.Ne(jArr); -1 < Ne; Ne--) {
            if (!predicate.invoke(d1.b(e1.p(jArr, Ne))).booleanValue()) {
                return N1(jArr, Ne + 1);
            }
        }
        return f0.a6(e1.d(jArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final <R> List<Pair<v0, R>> vd(@NotNull byte[] bArr, @NotNull R[] other) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$zip$0");
        g0.p(other, "other");
        int min = Math.min(w0.r(bArr), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            byte p5 = w0.p(bArr, i6);
            arrayList.add(o0.a(v0.b(p5), other[i6]));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <V> Map<z0, V> w0(int[] iArr, Function1<? super z0, ? extends V> valueSelector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$associateWith$0");
        g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t.u(i1.j(a1.r(iArr)), 16));
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            linkedHashMap.put(z0.b(p5), valueSelector.invoke(z0.b(p5)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "2.2")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] w1(long[] jArr, int i6, Function1<? super Integer, d1> init) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$copyOf$0");
        g0.p(init, "init");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i6 + '.').toString());
        }
        long[] copyOf = Arrays.copyOf(jArr, i6);
        g0.o(copyOf, "copyOf(...)");
        long[] f6 = e1.f(copyOf);
        for (int r5 = e1.r(jArr); r5 < i6; r5++) {
            e1.x(f6, r5, init.invoke(Integer.valueOf(r5)).q0());
        }
        return f6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<d1> w2(long[] jArr, Function2<? super Integer, ? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$filterIndexed$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = e1.r(jArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            long p5 = e1.p(jArr, i6);
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), d1.b(p5)).booleanValue()) {
                arrayList.add(d1.b(p5));
            }
            i6++;
            i7 = i8;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R, C extends Collection<? super R>> C w3(byte[] bArr, C destination, Function2<? super Integer, ? super v0, ? extends Iterable<? extends R>> transform) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$flatMapIndexedTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = w0.r(bArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            f0.s0(destination, transform.invoke(Integer.valueOf(i7), v0.b(w0.p(bArr, i6))));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final z0 w4(@NotNull int[] iArr, int i6) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$getOrNull$0");
        if (i6 < 0 || i6 >= a1.r(iArr)) {
            return null;
        }
        return z0.b(a1.p(iArr, i6));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> w5(int[] iArr, Function1<? super z0, ? extends R> transform) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$map$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(a1.r(iArr));
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            arrayList.add(transform.invoke(z0.b(a1.p(iArr, i6))));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R w6(short[] sArr, Comparator<? super R> comparator, Function1<? super j1, ? extends R> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$maxOfWithOrNull$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            return null;
        }
        Object obj = (R) selector.invoke(j1.b(k1.p(sArr, 0)));
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                Object obj2 = (R) selector.invoke(j1.b(k1.p(sArr, i6)));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R w7(short[] sArr, Comparator<? super R> comparator, Function1<? super j1, ? extends R> selector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$minOfWith$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (k1.v(sArr)) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(j1.b(k1.p(sArr, 0)));
        int Pe = n.Pe(sArr);
        int i6 = 1;
        if (1 <= Pe) {
            while (true) {
                Object obj2 = (R) selector.invoke(j1.b(k1.p(sArr, i6)));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Pe) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte w8(byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$random$0");
        return z8(bArr, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void w9(int[] iArr, int i6, int i7) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$reverse$0");
        n.sr(iArr, i6, i7);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final v0 wa(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$singleOrNull$0");
        g0.p(predicate, "predicate");
        int r5 = w0.r(bArr);
        v0 v0Var = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            if (predicate.invoke(v0.b(p5)).booleanValue()) {
                if (z5) {
                    return null;
                }
                v0Var = v0.b(p5);
                z5 = true;
            }
        }
        if (z5) {
            return v0Var;
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final long[] wb(@NotNull long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$sortedArrayDescending$0");
        if (e1.v(jArr)) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        g0.o(copyOf, "copyOf(...)");
        long[] f6 = e1.f(copyOf);
        jb(f6);
        return f6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<z0> wc(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$takeLastWhile$0");
        g0.p(predicate, "predicate");
        for (int Me = n.Me(iArr); -1 < Me; Me--) {
            if (!predicate.invoke(z0.b(a1.p(iArr, Me))).booleanValue()) {
                return M1(iArr, Me + 1);
            }
        }
        return f0.a6(a1.d(iArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final <R> List<Pair<j1, R>> wd(@NotNull short[] sArr, @NotNull R[] other) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$zip$0");
        g0.p(other, "other");
        int min = Math.min(k1.r(sArr), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            short p5 = k1.p(sArr, i6);
            arrayList.add(o0.a(j1.b(p5), other[i6]));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <V> Map<j1, V> x0(short[] sArr, Function1<? super j1, ? extends V> valueSelector) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$associateWith$0");
        g0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t.u(i1.j(k1.r(sArr)), 16));
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            linkedHashMap.put(j1.b(p5), valueSelector.invoke(j1.b(p5)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "2.2")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] x1(byte[] bArr, int i6, Function1<? super Integer, v0> init) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$copyOf$0");
        g0.p(init, "init");
        if (i6 < 0) {
            throw new IllegalArgumentException(("Invalid new array size: " + i6 + '.').toString());
        }
        byte[] copyOf = Arrays.copyOf(bArr, i6);
        g0.o(copyOf, "copyOf(...)");
        byte[] f6 = w0.f(copyOf);
        for (int r5 = w0.r(bArr); r5 < i6; r5++) {
            w0.x(f6, r5, init.invoke(Integer.valueOf(r5)).o0());
        }
        return f6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<j1> x2(short[] sArr, Function2<? super Integer, ? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$filterIndexed$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = k1.r(sArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            short p5 = k1.p(sArr, i6);
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), j1.b(p5)).booleanValue()) {
                arrayList.add(j1.b(p5));
            }
            i6++;
            i7 = i8;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R, C extends Collection<? super R>> C x3(long[] jArr, C destination, Function2<? super Integer, ? super d1, ? extends Iterable<? extends R>> transform) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$flatMapIndexedTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = e1.r(jArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            f0.s0(destination, transform.invoke(Integer.valueOf(i7), d1.b(e1.p(jArr, i6))));
            i6++;
            i7++;
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final d1 x4(@NotNull long[] jArr, int i6) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$getOrNull$0");
        if (i6 < 0 || i6 >= e1.r(jArr)) {
            return null;
        }
        return d1.b(e1.p(jArr, i6));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> x5(short[] sArr, Function1<? super j1, ? extends R> transform) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$map$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(k1.r(sArr));
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            arrayList.add(transform.invoke(j1.b(k1.p(sArr, i6))));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R x6(int[] iArr, Comparator<? super R> comparator, Function1<? super z0, ? extends R> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$maxOfWithOrNull$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            return null;
        }
        Object obj = (R) selector.invoke(z0.b(a1.p(iArr, 0)));
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                Object obj2 = (R) selector.invoke(z0.b(a1.p(iArr, i6)));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R x7(int[] iArr, Comparator<? super R> comparator, Function1<? super z0, ? extends R> selector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$minOfWith$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (a1.v(iArr)) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(z0.b(a1.p(iArr, 0)));
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                Object obj2 = (R) selector.invoke(z0.b(a1.p(iArr, i6)));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long x8(@NotNull long[] jArr, @NotNull Random random) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$random$0");
        g0.p(random, "random");
        if (e1.v(jArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return e1.p(jArr, random.nextInt(e1.r(jArr)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final void x9(short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$reverse$0");
        n.xr(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final d1 xa(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$singleOrNull$0");
        g0.p(predicate, "predicate");
        int r5 = e1.r(jArr);
        d1 d1Var = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            if (predicate.invoke(d1.b(p5)).booleanValue()) {
                if (z5) {
                    return null;
                }
                d1Var = d1.b(p5);
                z5 = true;
            }
        }
        if (z5) {
            return d1Var;
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final short[] xb(@NotNull short[] sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$sortedArrayDescending$0");
        if (k1.v(sArr)) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        g0.o(copyOf, "copyOf(...)");
        short[] f6 = k1.f(copyOf);
        lb(f6);
        return f6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<j1> xc(short[] sArr, Function1<? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$takeLastWhile$0");
        g0.p(predicate, "predicate");
        for (int Pe = n.Pe(sArr); -1 < Pe; Pe--) {
            if (!predicate.invoke(j1.b(k1.p(sArr, Pe))).booleanValue()) {
                return L1(sArr, Pe + 1);
            }
        }
        return f0.a6(k1.d(sArr));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<Pair<d1, d1>> xd(@NotNull long[] jArr, @NotNull long[] jArr2) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$zip$0");
        g0.p(jArr2, "$v$c$kotlin-ULongArray$-other$0");
        int min = Math.min(e1.r(jArr), e1.r(jArr2));
        ArrayList arrayList = new ArrayList(min);
        for (int i6 = 0; i6 < min; i6++) {
            arrayList.add(o0.a(d1.b(e1.p(jArr, i6)), d1.b(e1.p(jArr2, i6))));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <V, M extends Map<? super z0, ? super V>> M y0(int[] iArr, M destination, Function1<? super z0, ? extends V> valueSelector) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$associateWithTo$0");
        g0.p(destination, "destination");
        g0.p(valueSelector, "valueSelector");
        int r5 = a1.r(iArr);
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            destination.put(z0.b(p5), valueSelector.invoke(z0.b(p5)));
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] y1(short[] sArr, int i6) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$copyOf$0");
        short[] copyOf = Arrays.copyOf(sArr, i6);
        g0.o(copyOf, "copyOf(...)");
        return k1.f(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <C extends Collection<? super z0>> C y2(int[] iArr, C destination, Function2<? super Integer, ? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$filterIndexedTo$0");
        g0.p(destination, "destination");
        g0.p(predicate, "predicate");
        int r5 = a1.r(iArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            int p5 = a1.p(iArr, i6);
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), z0.b(p5)).booleanValue()) {
                destination.add(z0.b(p5));
            }
            i6++;
            i7 = i8;
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, C extends Collection<? super R>> C y3(long[] jArr, C destination, Function1<? super d1, ? extends Iterable<? extends R>> transform) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$flatMapTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            f0.s0(destination, transform.invoke(d1.b(e1.p(jArr, i6))));
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K, V> Map<K, List<V>> y4(long[] jArr, Function1<? super d1, ? extends K> keySelector, Function1<? super d1, ? extends V> valueTransform) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$groupBy$0");
        g0.p(keySelector, "keySelector");
        g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            K invoke = keySelector.invoke(d1.b(p5));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(d1.b(p5)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> y5(byte[] bArr, Function2<? super Integer, ? super v0, ? extends R> transform) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$mapIndexed$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(w0.r(bArr));
        int r5 = w0.r(bArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            arrayList.add(transform.invoke(Integer.valueOf(i7), v0.b(w0.p(bArr, i6))));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final z0 y6(@NotNull int[] iArr) {
        int compare;
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$maxOrNull$0");
        if (a1.v(iArr)) {
            return null;
        }
        int p5 = a1.p(iArr, 0);
        int Me = n.Me(iArr);
        int i6 = 1;
        if (1 <= Me) {
            while (true) {
                int p6 = a1.p(iArr, i6);
                compare = Integer.compare(p5 ^ Integer.MIN_VALUE, p6 ^ Integer.MIN_VALUE);
                if (compare < 0) {
                    p5 = p6;
                }
                if (i6 == Me) {
                    break;
                }
                i6++;
            }
        }
        return z0.b(p5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R y7(long[] jArr, Comparator<? super R> comparator, Function1<? super d1, ? extends R> selector) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$minOfWithOrNull$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (e1.v(jArr)) {
            return null;
        }
        Object obj = (R) selector.invoke(d1.b(e1.p(jArr, 0)));
        int Ne = n.Ne(jArr);
        int i6 = 1;
        if (1 <= Ne) {
            while (true) {
                Object obj2 = (R) selector.invoke(d1.b(e1.p(jArr, i6)));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ne) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long y8(long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$random$0");
        return x8(jArr, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<z0> y9(@NotNull int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$reversed$0");
        if (a1.v(iArr)) {
            return f0.J();
        }
        List<z0> d6 = f0.d6(a1.d(iArr));
        f0.t1(d6);
        return d6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    public static final d1 ya(@NotNull long[] jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$singleOrNull$0");
        if (e1.r(jArr) == 1) {
            return d1.b(e1.p(jArr, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<z0> yb(@NotNull int[] iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$sortedDescending$0");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        g0.o(copyOf, "copyOf(...)");
        int[] f6 = a1.f(copyOf);
        Sa(f6);
        return y9(f6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<v0> yc(byte[] bArr, Function1<? super v0, Boolean> predicate) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$takeWhile$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            if (!predicate.invoke(v0.b(p5)).booleanValue()) {
                break;
            }
            arrayList.add(v0.b(p5));
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <V, M extends Map<? super v0, ? super V>> M z0(byte[] bArr, M destination, Function1<? super v0, ? extends V> valueSelector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$associateWithTo$0");
        g0.p(destination, "destination");
        g0.p(valueSelector, "valueSelector");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            byte p5 = w0.p(bArr, i6);
            destination.put(v0.b(p5), valueSelector.invoke(v0.b(p5)));
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] z1(int[] iArr, int i6) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$copyOf$0");
        int[] copyOf = Arrays.copyOf(iArr, i6);
        g0.o(copyOf, "copyOf(...)");
        return a1.f(copyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <C extends Collection<? super j1>> C z2(short[] sArr, C destination, Function2<? super Integer, ? super j1, Boolean> predicate) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$filterIndexedTo$0");
        g0.p(destination, "destination");
        g0.p(predicate, "predicate");
        int r5 = k1.r(sArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            short p5 = k1.p(sArr, i6);
            int i8 = i7 + 1;
            if (predicate.invoke(Integer.valueOf(i7), j1.b(p5)).booleanValue()) {
                destination.add(j1.b(p5));
            }
            i6++;
            i7 = i8;
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R, C extends Collection<? super R>> C z3(short[] sArr, C destination, Function1<? super j1, ? extends Iterable<? extends R>> transform) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$flatMapTo$0");
        g0.p(destination, "destination");
        g0.p(transform, "transform");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            f0.s0(destination, transform.invoke(j1.b(k1.p(sArr, i6))));
        }
        return destination;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <K, V> Map<K, List<V>> z4(short[] sArr, Function1<? super j1, ? extends K> keySelector, Function1<? super j1, ? extends V> valueTransform) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-$this$groupBy$0");
        g0.p(keySelector, "keySelector");
        g0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            short p5 = k1.p(sArr, i6);
            K invoke = keySelector.invoke(j1.b(p5));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(j1.b(p5)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final <R> List<R> z5(int[] iArr, Function2<? super Integer, ? super z0, ? extends R> transform) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$mapIndexed$0");
        g0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(a1.r(iArr));
        int r5 = a1.r(iArr);
        int i6 = 0;
        int i7 = 0;
        while (i6 < r5) {
            arrayList.add(transform.invoke(Integer.valueOf(i7), z0.b(a1.p(iArr, i6))));
            i6++;
            i7++;
        }
        return arrayList;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @Nullable
    public static final v0 z6(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$maxOrNull$0");
        if (w0.v(bArr)) {
            return null;
        }
        byte p5 = w0.p(bArr, 0);
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                byte p6 = w0.p(bArr, i6);
                if (g0.t(p5 & 255, p6 & 255) < 0) {
                    p5 = p6;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return v0.b(p5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    private static final <R> R z7(byte[] bArr, Comparator<? super R> comparator, Function1<? super v0, ? extends R> selector) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$minOfWithOrNull$0");
        g0.p(comparator, "comparator");
        g0.p(selector, "selector");
        if (w0.v(bArr)) {
            return null;
        }
        Object obj = (R) selector.invoke(v0.b(w0.p(bArr, 0)));
        int Ie = n.Ie(bArr);
        int i6 = 1;
        if (1 <= Ie) {
            while (true) {
                Object obj2 = (R) selector.invoke(v0.b(w0.p(bArr, i6)));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i6 == Ie) {
                    break;
                }
                i6++;
            }
        }
        return (R) obj;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte z8(@NotNull byte[] bArr, @NotNull Random random) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$random$0");
        g0.p(random, "random");
        if (w0.v(bArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return w0.p(bArr, random.nextInt(w0.r(bArr)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<v0> z9(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$reversed$0");
        if (w0.v(bArr)) {
            return f0.J();
        }
        List<v0> d6 = f0.d6(w0.d(bArr));
        f0.t1(d6);
        return d6;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final z0 za(int[] iArr, Function1<? super z0, Boolean> predicate) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-$this$singleOrNull$0");
        g0.p(predicate, "predicate");
        int r5 = a1.r(iArr);
        z0 z0Var = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < r5; i6++) {
            int p5 = a1.p(iArr, i6);
            if (predicate.invoke(z0.b(p5)).booleanValue()) {
                if (z5) {
                    return null;
                }
                z0Var = z0.b(p5);
                z5 = true;
            }
        }
        if (z5) {
            return z0Var;
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<v0> zb(@NotNull byte[] bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-$this$sortedDescending$0");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        g0.o(copyOf, "copyOf(...)");
        byte[] f6 = w0.f(copyOf);
        Za(f6);
        return z9(f6);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final List<d1> zc(long[] jArr, Function1<? super d1, Boolean> predicate) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-$this$takeWhile$0");
        g0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            long p5 = e1.p(jArr, i6);
            if (!predicate.invoke(d1.b(p5)).booleanValue()) {
                break;
            }
            arrayList.add(d1.b(p5));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator Wc(byte[] bArr) {
        return w0.w(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator Xc(long[] jArr) {
        return e1.w(jArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator Yc(int[] iArr) {
        return a1.w(iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator Zc(short[] sArr) {
        return k1.w(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static /* synthetic */ void b4(int[] iArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static /* synthetic */ void d4(byte[] bArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static /* synthetic */ void f4(long[] jArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static /* synthetic */ void h4(short[] sArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static /* synthetic */ void j4(int[] iArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static /* synthetic */ void l4(byte[] bArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static /* synthetic */ void n4(long[] jArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static /* synthetic */ void p4(short[] sArr) {
    }
}
