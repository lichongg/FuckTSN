package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import com.huawei.hms.framework.common.ContainerUtils;
import io.netty.util.internal.StringUtil;
import java.util.NoSuchElementException;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nObjectFloatMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectFloatMap.kt\nandroidx/collection/ObjectFloatMap\n+ 2 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1074:1\n373#1,6:1077\n383#1,3:1084\n386#1,9:1088\n373#1,6:1097\n383#1,3:1104\n386#1,9:1108\n373#1,6:1117\n383#1,3:1124\n386#1,9:1128\n401#1,4:1137\n373#1,6:1141\n383#1,3:1148\n386#1,2:1152\n406#1,2:1154\n389#1,6:1156\n408#1:1162\n401#1,4:1163\n373#1,6:1167\n383#1,3:1174\n386#1,2:1178\n406#1,2:1180\n389#1,6:1182\n408#1:1188\n401#1,4:1189\n373#1,6:1193\n383#1,3:1200\n386#1,2:1204\n406#1,2:1206\n389#1,6:1208\n408#1:1214\n428#1,3:1215\n373#1,6:1218\n383#1,3:1225\n386#1,2:1229\n431#1,2:1231\n389#1,6:1233\n433#1:1239\n401#1,4:1240\n373#1,6:1244\n383#1,3:1251\n386#1,2:1255\n406#1,2:1257\n389#1,6:1259\n408#1:1265\n401#1,4:1266\n373#1,6:1270\n383#1,3:1277\n386#1,2:1281\n406#1,2:1283\n389#1,6:1285\n408#1:1291\n401#1,4:1292\n373#1,6:1296\n383#1,3:1303\n386#1,2:1307\n406#1,2:1309\n389#1,6:1311\n408#1:1317\n401#1,4:1318\n373#1,6:1322\n383#1,3:1329\n386#1,2:1333\n406#1,2:1335\n389#1,6:1337\n408#1:1343\n401#1,4:1344\n373#1,6:1348\n383#1,3:1355\n386#1,2:1359\n406#1,2:1361\n389#1,6:1363\n408#1:1369\n401#1,4:1370\n373#1,6:1374\n383#1,3:1381\n386#1,2:1385\n406#1,2:1387\n389#1,6:1389\n408#1:1395\n537#1,11:1412\n401#1,4:1423\n373#1,6:1427\n383#1,3:1434\n386#1,2:1438\n406#1:1440\n548#1,10:1441\n407#1:1451\n389#1,6:1452\n408#1:1458\n558#1,2:1459\n537#1,11:1461\n401#1,4:1472\n373#1,6:1476\n383#1,3:1483\n386#1,2:1487\n406#1:1489\n548#1,10:1490\n407#1:1500\n389#1,6:1501\n408#1:1507\n558#1,2:1508\n537#1,11:1510\n401#1,4:1521\n373#1,6:1525\n383#1,3:1532\n386#1,2:1536\n406#1:1538\n548#1,10:1539\n407#1:1549\n389#1,6:1550\n408#1:1556\n558#1,2:1557\n537#1,11:1559\n401#1,4:1570\n373#1,6:1574\n383#1,3:1581\n386#1,2:1585\n406#1:1587\n548#1,10:1588\n407#1:1598\n389#1,6:1599\n408#1:1605\n558#1,2:1606\n537#1,11:1608\n401#1,4:1619\n373#1,6:1623\n383#1,3:1630\n386#1,2:1634\n406#1:1636\n548#1,10:1637\n407#1:1647\n389#1,6:1648\n408#1:1654\n558#1,2:1655\n1826#2:1075\n1688#2:1076\n1826#2:1083\n1688#2:1087\n1826#2:1103\n1688#2:1107\n1826#2:1123\n1688#2:1127\n1826#2:1147\n1688#2:1151\n1826#2:1173\n1688#2:1177\n1826#2:1199\n1688#2:1203\n1826#2:1224\n1688#2:1228\n1826#2:1250\n1688#2:1254\n1826#2:1276\n1688#2:1280\n1826#2:1302\n1688#2:1306\n1826#2:1328\n1688#2:1332\n1826#2:1354\n1688#2:1358\n1826#2:1380\n1688#2:1384\n1605#2,3:1396\n1619#2:1399\n1615#2:1400\n1795#2,3:1401\n1809#2,3:1404\n1733#2:1407\n1721#2:1408\n1715#2:1409\n1728#2:1410\n1818#2:1411\n1826#2:1433\n1688#2:1437\n1826#2:1482\n1688#2:1486\n1826#2:1531\n1688#2:1535\n1826#2:1580\n1688#2:1584\n1826#2:1629\n1688#2:1633\n*S KotlinDebug\n*F\n+ 1 ObjectFloatMap.kt\nandroidx/collection/ObjectFloatMap\n*L\n404#1:1077,6\n404#1:1084,3\n404#1:1088,9\n417#1:1097,6\n417#1:1104,3\n417#1:1108,9\n430#1:1117,6\n430#1:1124,3\n430#1:1128,9\n439#1:1137,4\n439#1:1141,6\n439#1:1148,3\n439#1:1152,2\n439#1:1154,2\n439#1:1156,6\n439#1:1162\n449#1:1163,4\n449#1:1167,6\n449#1:1174,3\n449#1:1178,2\n449#1:1180,2\n449#1:1182,6\n449#1:1188\n465#1:1189,4\n465#1:1193,6\n465#1:1200,3\n465#1:1204,2\n465#1:1206,2\n465#1:1208,6\n465#1:1214\n488#1:1215,3\n488#1:1218,6\n488#1:1225,3\n488#1:1229,2\n488#1:1231,2\n488#1:1233,6\n488#1:1239\n512#1:1240,4\n512#1:1244,6\n512#1:1251,3\n512#1:1255,2\n512#1:1257,2\n512#1:1259,6\n512#1:1265\n547#1:1266,4\n547#1:1270,6\n547#1:1277,3\n547#1:1281,2\n547#1:1283,2\n547#1:1285,6\n547#1:1291\n547#1:1292,4\n547#1:1296,6\n547#1:1303,3\n547#1:1307,2\n547#1:1309,2\n547#1:1311,6\n547#1:1317\n568#1:1318,4\n568#1:1322,6\n568#1:1329,3\n568#1:1333,2\n568#1:1335,2\n568#1:1337,6\n568#1:1343\n597#1:1344,4\n597#1:1348,6\n597#1:1355,3\n597#1:1359,2\n597#1:1361,2\n597#1:1363,6\n597#1:1369\n619#1:1370,4\n619#1:1374,6\n619#1:1381,3\n619#1:1385,2\n619#1:1387,2\n619#1:1389,6\n619#1:1395\n-1#1:1412,11\n-1#1:1423,4\n-1#1:1427,6\n-1#1:1434,3\n-1#1:1438,2\n-1#1:1440\n-1#1:1441,10\n-1#1:1451\n-1#1:1452,6\n-1#1:1458\n-1#1:1459,2\n-1#1:1461,11\n-1#1:1472,4\n-1#1:1476,6\n-1#1:1483,3\n-1#1:1487,2\n-1#1:1489\n-1#1:1490,10\n-1#1:1500\n-1#1:1501,6\n-1#1:1507\n-1#1:1508,2\n-1#1:1510,11\n-1#1:1521,4\n-1#1:1525,6\n-1#1:1532,3\n-1#1:1536,2\n-1#1:1538\n-1#1:1539,10\n-1#1:1549\n-1#1:1550,6\n-1#1:1556\n-1#1:1557,2\n-1#1:1559,11\n-1#1:1570,4\n-1#1:1574,6\n-1#1:1581,3\n-1#1:1585,2\n-1#1:1587\n-1#1:1588,10\n-1#1:1598\n-1#1:1599,6\n-1#1:1605\n-1#1:1606,2\n-1#1:1608,11\n-1#1:1619,4\n-1#1:1623,6\n-1#1:1630,3\n-1#1:1634,2\n-1#1:1636\n-1#1:1637,10\n-1#1:1647\n-1#1:1648,6\n-1#1:1654\n-1#1:1655,2\n378#1:1075\n385#1:1076\n404#1:1083\n404#1:1087\n417#1:1103\n417#1:1107\n430#1:1123\n430#1:1127\n439#1:1147\n439#1:1151\n449#1:1173\n449#1:1177\n465#1:1199\n465#1:1203\n488#1:1224\n488#1:1228\n512#1:1250\n512#1:1254\n547#1:1276\n547#1:1280\n547#1:1302\n547#1:1306\n568#1:1328\n568#1:1332\n597#1:1354\n597#1:1358\n619#1:1380\n619#1:1384\n638#1:1396,3\n639#1:1399\n642#1:1400\n646#1:1401,3\n647#1:1404,3\n648#1:1407\n649#1:1408\n649#1:1409\n653#1:1410\n656#1:1411\n-1#1:1433\n-1#1:1437\n-1#1:1482\n-1#1:1486\n-1#1:1531\n-1#1:1535\n-1#1:1580\n-1#1:1584\n-1#1:1629\n-1#1:1633\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class ObjectFloatMap<K> {

    @JvmField
    public int _capacity;

    @JvmField
    public int _size;

    @JvmField
    @NotNull
    public Object[] keys;

    @JvmField
    @NotNull
    public long[] metadata;

    @JvmField
    @NotNull
    public float[] values;

    public /* synthetic */ ObjectFloatMap(v vVar) {
        this();
    }

    public static /* synthetic */ String joinToString$default(ObjectFloatMap objectFloatMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i7 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i7 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i7 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i7 & 8) != 0) {
            i6 = -1;
        }
        if ((i7 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return objectFloatMap.joinToString(charSequence, charSequence2, charSequence6, i6, charSequence5);
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final int count() {
        return getSize();
    }

    @PublishedApi
    public final int findKeyIndex(K k6) {
        int i6 = 0;
        int hashCode = (k6 != null ? k6.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i7 = hashCode ^ (hashCode << 16);
        int i8 = i7 & 127;
        int i9 = this._capacity;
        int i10 = i7 >>> 7;
        while (true) {
            int i11 = i10 & i9;
            long[] jArr = this.metadata;
            int i12 = i11 >> 3;
            int i13 = (i11 & 7) << 3;
            long j6 = ((jArr[i12 + 1] << (64 - i13)) & ((-i13) >> 63)) | (jArr[i12] >>> i13);
            long j7 = (i8 * ScatterMapKt.BitmaskLsb) ^ j6;
            for (long j8 = (~j7) & (j7 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j8 != 0; j8 &= j8 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j8) >> 3) + i11) & i9;
                if (g0.g(this.keys[numberOfTrailingZeros], k6)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j6 & ((~j6) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i6 += 8;
            i10 = i11 + i6;
        }
    }

    @JvmOverloads
    @NotNull
    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    private ObjectFloatMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = FloatSetKt.getEmptyFloatArray();
    }

    public final boolean all(@NotNull Function2<? super K, ? super Float, Boolean> predicate) {
        g0.p(predicate, "predicate");
        Object[] objArr = this.keys;
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i6 = 0;
        while (true) {
            long j6 = jArr[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i6 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j6) < 128) {
                        int i9 = (i6 << 3) + i8;
                        if (!predicate.invoke(objArr[i9], Float.valueOf(fArr[i9])).booleanValue()) {
                            return false;
                        }
                    }
                    j6 >>= 8;
                }
                if (i7 != 8) {
                    return true;
                }
            }
            if (i6 == length) {
                return true;
            }
            i6++;
        }
    }

    public final boolean any(@NotNull Function2<? super K, ? super Float, Boolean> predicate) {
        g0.p(predicate, "predicate");
        Object[] objArr = this.keys;
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j6 = jArr[i6];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j6) < 128) {
                            int i9 = (i6 << 3) + i8;
                            if (predicate.invoke(objArr[i9], Float.valueOf(fArr[i9])).booleanValue()) {
                                return true;
                            }
                        }
                        j6 >>= 8;
                    }
                    if (i7 != 8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        return false;
    }

    public final boolean containsValue(float f6) {
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j6 = jArr[i6];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j6) < 128 && f6 == fArr[(i6 << 3) + i8]) {
                            return true;
                        }
                        j6 >>= 8;
                    }
                    if (i7 != 8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        return false;
    }

    public final int count(@NotNull Function2<? super K, ? super Float, Boolean> predicate) {
        g0.p(predicate, "predicate");
        Object[] objArr = this.keys;
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i6 = 0;
        int i7 = 0;
        while (true) {
            long j6 = jArr[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i6 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j6) < 128) {
                        int i10 = (i6 << 3) + i9;
                        if (predicate.invoke(objArr[i10], Float.valueOf(fArr[i10])).booleanValue()) {
                            i7++;
                        }
                    }
                    j6 >>= 8;
                }
                if (i8 != 8) {
                    return i7;
                }
            }
            if (i6 == length) {
                return i7;
            }
            i6++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ObjectFloatMap)) {
            return false;
        }
        ObjectFloatMap objectFloatMap = (ObjectFloatMap) obj;
        if (objectFloatMap.getSize() != getSize()) {
            return false;
        }
        Object[] objArr = this.keys;
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j6 = jArr[i6];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j6) < 128) {
                            int i9 = (i6 << 3) + i8;
                            if (fArr[i9] != objectFloatMap.get(objArr[i9])) {
                                return false;
                            }
                        }
                        j6 >>= 8;
                    }
                    if (i7 != 8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        return true;
    }

    public final void forEach(@NotNull Function2<? super K, ? super Float, n1> block) {
        g0.p(block, "block");
        Object[] objArr = this.keys;
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            long j6 = jArr[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i6 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j6) < 128) {
                        int i9 = (i6 << 3) + i8;
                        block.invoke(objArr[i9], Float.valueOf(fArr[i9]));
                    }
                    j6 >>= 8;
                }
                if (i7 != 8) {
                    return;
                }
            }
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    @PublishedApi
    public final void forEachIndexed(@NotNull Function1<? super Integer, n1> block) {
        g0.p(block, "block");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            long j6 = jArr[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i6 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j6) < 128) {
                        block.invoke(Integer.valueOf((i6 << 3) + i8));
                    }
                    j6 >>= 8;
                }
                if (i7 != 8) {
                    return;
                }
            }
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    public final void forEachKey(@NotNull Function1<? super K, n1> block) {
        g0.p(block, "block");
        Object[] objArr = this.keys;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            long j6 = jArr[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i6 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j6) < 128) {
                        block.invoke(objArr[(i6 << 3) + i8]);
                    }
                    j6 >>= 8;
                }
                if (i7 != 8) {
                    return;
                }
            }
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    public final void forEachValue(@NotNull Function1<? super Float, n1> block) {
        g0.p(block, "block");
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            long j6 = jArr[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i6 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j6) < 128) {
                        block.invoke(Float.valueOf(fArr[(i6 << 3) + i8]));
                    }
                    j6 >>= 8;
                }
                if (i7 != 8) {
                    return;
                }
            }
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final float getOrElse(K k6, @NotNull Function0<Float> defaultValue) {
        g0.p(defaultValue, "defaultValue");
        int findKeyIndex = findKeyIndex(k6);
        return findKeyIndex >= 0 ? this.values[findKeyIndex] : defaultValue.invoke().floatValue();
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        Object[] objArr = this.keys;
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i6 = 0;
        int i7 = 0;
        while (true) {
            long j6 = jArr[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i6 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j6) < 128) {
                        int i10 = (i6 << 3) + i9;
                        Object obj = objArr[i10];
                        i7 += Float.floatToIntBits(fArr[i10]) ^ (obj != null ? obj.hashCode() : 0);
                    }
                    j6 >>= 8;
                }
                if (i8 != 8) {
                    return i7;
                }
            }
            if (i6 == length) {
                return i7;
            }
            i6++;
        }
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator) {
        g0.p(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    public final boolean none() {
        return this._size == 0;
    }

    @NotNull
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Object[] objArr = this.keys;
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            while (true) {
                long j6 = jArr[i6];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((255 & j6) < 128) {
                            int i10 = (i6 << 3) + i9;
                            Object obj = objArr[i10];
                            float f6 = fArr[i10];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                            sb.append(f6);
                            i7++;
                            if (i7 < this._size) {
                                sb.append(StringUtil.COMMA);
                                sb.append(' ');
                            }
                        }
                        j6 >>= 8;
                    }
                    if (i8 != 8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        g0.o(sb2, "s.append('}').toString()");
        return sb2;
    }

    public final boolean contains(K k6) {
        if (findKeyIndex(k6) >= 0) {
            return true;
        }
        return false;
    }

    public final boolean containsKey(K k6) {
        if (findKeyIndex(k6) >= 0) {
            return true;
        }
        return false;
    }

    public final float get(K k6) {
        int findKeyIndex = findKeyIndex(k6);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        throw new NoSuchElementException("There is no key " + k6 + " in the map");
    }

    public final float getOrDefault(K k6, float f6) {
        int findKeyIndex = findKeyIndex(k6);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        return f6;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public static /* synthetic */ String joinToString$default(ObjectFloatMap objectFloatMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, Function2 transform, int i7, Object obj) {
        long[] jArr;
        long[] jArr2;
        char c6;
        if (obj == null) {
            CharSequence separator = (i7 & 1) != 0 ? ", " : charSequence;
            CharSequence prefix = (i7 & 2) != 0 ? "" : charSequence2;
            CharSequence postfix = (i7 & 4) == 0 ? charSequence3 : "";
            int i8 = (i7 & 8) != 0 ? -1 : i6;
            CharSequence truncated = (i7 & 16) != 0 ? "..." : charSequence4;
            g0.p(separator, "separator");
            g0.p(prefix, "prefix");
            g0.p(postfix, "postfix");
            g0.p(truncated, "truncated");
            g0.p(transform, "transform");
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            Object[] objArr = objectFloatMap.keys;
            float[] fArr = objectFloatMap.values;
            long[] jArr3 = objectFloatMap.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i9 = 0;
                int i10 = 0;
                loop0: while (true) {
                    long j6 = jArr3[i9];
                    int i11 = i9;
                    if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        int i13 = 0;
                        while (i13 < i12) {
                            if ((j6 & 255) < 128) {
                                int i14 = (i11 << 3) + i13;
                                c6 = '\b';
                                Object obj2 = objArr[i14];
                                float f6 = fArr[i14];
                                if (i10 == i8) {
                                    sb.append(truncated);
                                    break loop0;
                                }
                                if (i10 != 0) {
                                    sb.append(separator);
                                }
                                jArr2 = jArr3;
                                sb.append((CharSequence) transform.invoke(obj2, Float.valueOf(f6)));
                                i10++;
                            } else {
                                jArr2 = jArr3;
                                c6 = '\b';
                            }
                            j6 >>= c6;
                            i13++;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i12 != 8) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i11 == length) {
                        break;
                    }
                    i9 = i11 + 1;
                    jArr3 = jArr;
                }
            }
            sb.append(postfix);
            String sb2 = sb.toString();
            g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i6, null, 16, null);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated) {
        Object[] objArr;
        Object[] objArr2;
        char c6;
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        g0.p(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        Object[] objArr3 = this.keys;
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i7 = 0;
            int i8 = 0;
            loop0: while (true) {
                long j6 = jArr[i7];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i9 = 8 - ((~(i7 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j6 & 255) < 128) {
                            int i11 = (i7 << 3) + i10;
                            c6 = '\b';
                            Object obj = objArr3[i11];
                            float f6 = fArr[i11];
                            objArr2 = objArr3;
                            if (i8 == i6) {
                                sb.append(truncated);
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb.append(separator);
                            }
                            sb.append(obj);
                            sb.append('=');
                            sb.append(f6);
                            i8++;
                        } else {
                            objArr2 = objArr3;
                            c6 = '\b';
                        }
                        j6 >>= c6;
                        i10++;
                        objArr3 = objArr2;
                    }
                    objArr = objArr3;
                    if (i9 != 8) {
                        break;
                    }
                } else {
                    objArr = objArr3;
                }
                if (i7 == length) {
                    break;
                }
                i7++;
                objArr3 = objArr;
            }
        }
        sb.append(postfix);
        String sb2 = sb.toString();
        g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @PublishedApi
    public static /* synthetic */ void getKeys$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getMetadata$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence charSequence, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @NotNull Function2<? super K, ? super Float, ? extends CharSequence> transform) {
        Object[] objArr;
        Object[] objArr2;
        CharSequence separator = charSequence;
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        g0.p(truncated, "truncated");
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        Object[] objArr3 = this.keys;
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i7 = 0;
            int i8 = 0;
            loop0: while (true) {
                long j6 = jArr[i7];
                int i9 = i7;
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i10 = 8 - ((~(i9 - length)) >>> 31);
                    int i11 = 0;
                    while (i11 < i10) {
                        if ((j6 & 255) < 128) {
                            int i12 = (i9 << 3) + i11;
                            Object obj = objArr3[i12];
                            float f6 = fArr[i12];
                            objArr2 = objArr3;
                            if (i8 == i6) {
                                sb.append(truncated);
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb.append(separator);
                            }
                            sb.append(transform.invoke(obj, Float.valueOf(f6)));
                            i8++;
                        } else {
                            objArr2 = objArr3;
                        }
                        j6 >>= 8;
                        i11++;
                        separator = charSequence;
                        objArr3 = objArr2;
                    }
                    objArr = objArr3;
                    if (i10 != 8) {
                        break;
                    }
                } else {
                    objArr = objArr3;
                }
                if (i9 == length) {
                    break;
                }
                i7 = i9 + 1;
                separator = charSequence;
                objArr3 = objArr;
            }
            String sb2 = sb.toString();
            g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        sb.append(postfix);
        String sb22 = sb.toString();
        g0.o(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull Function2<? super K, ? super Float, ? extends CharSequence> transform) {
        char c6;
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        Object[] objArr = this.keys;
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i7 = 0;
            int i8 = 0;
            loop0: while (true) {
                long j6 = jArr[i7];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i9 = 8 - ((~(i7 - length)) >>> 31);
                    for (int i10 = 0; i10 < i9; i10++) {
                        if ((j6 & 255) < 128) {
                            int i11 = (i7 << 3) + i10;
                            c6 = '\b';
                            Object obj = objArr[i11];
                            float f6 = fArr[i11];
                            if (i8 == i6) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb.append(separator);
                            }
                            sb.append(transform.invoke(obj, Float.valueOf(f6)));
                            i8++;
                        } else {
                            c6 = '\b';
                        }
                        j6 >>= c6;
                    }
                    if (i9 != 8) {
                        break;
                    }
                }
                if (i7 == length) {
                    break;
                }
                i7++;
            }
        }
        sb.append(postfix);
        String sb2 = sb.toString();
        g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, @NotNull Function2<? super K, ? super Float, ? extends CharSequence> transform) {
        char c6;
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        Object[] objArr = this.keys;
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0: while (true) {
                long j6 = jArr[i6];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((j6 & 255) < 128) {
                            int i10 = (i6 << 3) + i9;
                            c6 = '\b';
                            Object obj = objArr[i10];
                            float f6 = fArr[i10];
                            if (i7 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(separator);
                            }
                            sb.append(transform.invoke(obj, Float.valueOf(f6)));
                            i7++;
                        } else {
                            c6 = '\b';
                        }
                        j6 >>= c6;
                    }
                    if (i8 != 8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        sb.append(postfix);
        String sb2 = sb.toString();
        g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull Function2<? super K, ? super Float, ? extends CharSequence> transform) {
        char c6;
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        Object[] objArr = this.keys;
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0: while (true) {
                long j6 = jArr[i6];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((j6 & 255) < 128) {
                            int i10 = (i6 << 3) + i9;
                            Object obj = objArr[i10];
                            float f6 = fArr[i10];
                            c6 = '\b';
                            if (i7 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(separator);
                            }
                            sb.append(transform.invoke(obj, Float.valueOf(f6)));
                            i7++;
                        } else {
                            c6 = '\b';
                        }
                        j6 >>= c6;
                    }
                    if (i8 != 8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
            String sb2 = sb.toString();
            g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        sb.append((CharSequence) "");
        String sb22 = sb.toString();
        g0.o(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull Function2<? super K, ? super Float, ? extends CharSequence> transform) {
        char c6;
        g0.p(separator, "separator");
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        Object[] objArr = this.keys;
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0: while (true) {
                long j6 = jArr[i6];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((j6 & 255) < 128) {
                            int i10 = (i6 << 3) + i9;
                            c6 = '\b';
                            Object obj = objArr[i10];
                            float f6 = fArr[i10];
                            if (i7 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(separator);
                            }
                            sb.append(transform.invoke(obj, Float.valueOf(f6)));
                            i7++;
                        } else {
                            c6 = '\b';
                        }
                        j6 >>= c6;
                    }
                    if (i8 != 8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
            String sb2 = sb.toString();
            g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        sb.append((CharSequence) "");
        String sb22 = sb.toString();
        g0.o(sb22, "StringBuilder().apply(builderAction).toString()");
        return sb22;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull Function2<? super K, ? super Float, ? extends CharSequence> transform) {
        char c6;
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        Object[] objArr = this.keys;
        float[] fArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0: while (true) {
                long j6 = jArr[i6];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((j6 & 255) < 128) {
                            int i10 = (i6 << 3) + i9;
                            Object obj = objArr[i10];
                            float f6 = fArr[i10];
                            c6 = '\b';
                            if (i7 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append((CharSequence) ", ");
                            }
                            sb.append(transform.invoke(obj, Float.valueOf(f6)));
                            i7++;
                        } else {
                            c6 = '\b';
                        }
                        j6 >>= c6;
                    }
                    if (i8 != 8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        sb.append((CharSequence) "");
        String sb2 = sb.toString();
        g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
