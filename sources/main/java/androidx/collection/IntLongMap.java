package androidx.collection;

import androidx.camera.camera2.internal.compat.params.e;
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
@SourceDebugExtension({"SMAP\nIntLongMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntLongMap.kt\nandroidx/collection/IntLongMap\n+ 2 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 3 IntSet.kt\nandroidx/collection/IntSetKt\n*L\n1#1,1047:1\n357#1,6:1050\n367#1,3:1057\n370#1,9:1061\n357#1,6:1070\n367#1,3:1077\n370#1,9:1081\n357#1,6:1090\n367#1,3:1097\n370#1,9:1101\n385#1,4:1110\n357#1,6:1114\n367#1,3:1121\n370#1,2:1125\n389#1,2:1127\n373#1,6:1129\n391#1:1135\n385#1,4:1136\n357#1,6:1140\n367#1,3:1147\n370#1,2:1151\n389#1,2:1153\n373#1,6:1155\n391#1:1161\n385#1,4:1162\n357#1,6:1166\n367#1,3:1173\n370#1,2:1177\n389#1,2:1179\n373#1,6:1181\n391#1:1187\n410#1,3:1188\n357#1,6:1191\n367#1,3:1198\n370#1,2:1202\n413#1,2:1204\n373#1,6:1206\n415#1:1212\n385#1,4:1213\n357#1,6:1217\n367#1,3:1224\n370#1,2:1228\n389#1,2:1230\n373#1,6:1232\n391#1:1238\n385#1,4:1239\n357#1,6:1243\n367#1,3:1250\n370#1,2:1254\n389#1,2:1256\n373#1,6:1258\n391#1:1264\n385#1,4:1265\n357#1,6:1269\n367#1,3:1276\n370#1,2:1280\n389#1,2:1282\n373#1,6:1284\n391#1:1290\n385#1,4:1291\n357#1,6:1295\n367#1,3:1302\n370#1,2:1306\n389#1,2:1308\n373#1,6:1310\n391#1:1316\n385#1,4:1317\n357#1,6:1321\n367#1,3:1328\n370#1,2:1332\n389#1,2:1334\n373#1,6:1336\n391#1:1342\n385#1,4:1343\n357#1,6:1347\n367#1,3:1354\n370#1,2:1358\n389#1,2:1360\n373#1,6:1362\n391#1:1368\n519#1,11:1385\n385#1,4:1396\n357#1,6:1400\n367#1,3:1407\n370#1,2:1411\n389#1:1413\n530#1,10:1414\n390#1:1424\n373#1,6:1425\n391#1:1431\n540#1,2:1432\n519#1,11:1434\n385#1,4:1445\n357#1,6:1449\n367#1,3:1456\n370#1,2:1460\n389#1:1462\n530#1,10:1463\n390#1:1473\n373#1,6:1474\n391#1:1480\n540#1,2:1481\n519#1,11:1483\n385#1,4:1494\n357#1,6:1498\n367#1,3:1505\n370#1,2:1509\n389#1:1511\n530#1,10:1512\n390#1:1522\n373#1,6:1523\n391#1:1529\n540#1,2:1530\n519#1,11:1532\n385#1,4:1543\n357#1,6:1547\n367#1,3:1554\n370#1,2:1558\n389#1:1560\n530#1,10:1561\n390#1:1571\n373#1,6:1572\n391#1:1578\n540#1,2:1579\n519#1,11:1581\n385#1,4:1592\n357#1,6:1596\n367#1,3:1603\n370#1,2:1607\n389#1:1609\n530#1,10:1610\n390#1:1620\n373#1,6:1621\n391#1:1627\n540#1,2:1628\n1826#2:1048\n1688#2:1049\n1826#2:1056\n1688#2:1060\n1826#2:1076\n1688#2:1080\n1826#2:1096\n1688#2:1100\n1826#2:1120\n1688#2:1124\n1826#2:1146\n1688#2:1150\n1826#2:1172\n1688#2:1176\n1826#2:1197\n1688#2:1201\n1826#2:1223\n1688#2:1227\n1826#2:1249\n1688#2:1253\n1826#2:1275\n1688#2:1279\n1826#2:1301\n1688#2:1305\n1826#2:1327\n1688#2:1331\n1826#2:1353\n1688#2:1357\n1619#2:1372\n1615#2:1373\n1795#2,3:1374\n1809#2,3:1377\n1733#2:1380\n1721#2:1381\n1715#2:1382\n1728#2:1383\n1818#2:1384\n1826#2:1406\n1688#2:1410\n1826#2:1455\n1688#2:1459\n1826#2:1504\n1688#2:1508\n1826#2:1553\n1688#2:1557\n1826#2:1602\n1688#2:1606\n849#3,3:1369\n*S KotlinDebug\n*F\n+ 1 IntLongMap.kt\nandroidx/collection/IntLongMap\n*L\n388#1:1050,6\n388#1:1057,3\n388#1:1061,9\n400#1:1070,6\n400#1:1077,3\n400#1:1081,9\n412#1:1090,6\n412#1:1097,3\n412#1:1101,9\n421#1:1110,4\n421#1:1114,6\n421#1:1121,3\n421#1:1125,2\n421#1:1127,2\n421#1:1129,6\n421#1:1135\n431#1:1136,4\n431#1:1140,6\n431#1:1147,3\n431#1:1151,2\n431#1:1153,2\n431#1:1155,6\n431#1:1161\n447#1:1162,4\n447#1:1166,6\n447#1:1173,3\n447#1:1177,2\n447#1:1179,2\n447#1:1181,6\n447#1:1187\n470#1:1188,3\n470#1:1191,6\n470#1:1198,3\n470#1:1202,2\n470#1:1204,2\n470#1:1206,6\n470#1:1212\n494#1:1213,4\n494#1:1217,6\n494#1:1224,3\n494#1:1228,2\n494#1:1230,2\n494#1:1232,6\n494#1:1238\n529#1:1239,4\n529#1:1243,6\n529#1:1250,3\n529#1:1254,2\n529#1:1256,2\n529#1:1258,6\n529#1:1264\n529#1:1265,4\n529#1:1269,6\n529#1:1276,3\n529#1:1280,2\n529#1:1282,2\n529#1:1284,6\n529#1:1290\n550#1:1291,4\n550#1:1295,6\n550#1:1302,3\n550#1:1306,2\n550#1:1308,2\n550#1:1310,6\n550#1:1316\n576#1:1317,4\n576#1:1321,6\n576#1:1328,3\n576#1:1332,2\n576#1:1334,2\n576#1:1336,6\n576#1:1342\n598#1:1343,4\n598#1:1347,6\n598#1:1354,3\n598#1:1358,2\n598#1:1360,2\n598#1:1362,6\n598#1:1368\n-1#1:1385,11\n-1#1:1396,4\n-1#1:1400,6\n-1#1:1407,3\n-1#1:1411,2\n-1#1:1413\n-1#1:1414,10\n-1#1:1424\n-1#1:1425,6\n-1#1:1431\n-1#1:1432,2\n-1#1:1434,11\n-1#1:1445,4\n-1#1:1449,6\n-1#1:1456,3\n-1#1:1460,2\n-1#1:1462\n-1#1:1463,10\n-1#1:1473\n-1#1:1474,6\n-1#1:1480\n-1#1:1481,2\n-1#1:1483,11\n-1#1:1494,4\n-1#1:1498,6\n-1#1:1505,3\n-1#1:1509,2\n-1#1:1511\n-1#1:1512,10\n-1#1:1522\n-1#1:1523,6\n-1#1:1529\n-1#1:1530,2\n-1#1:1532,11\n-1#1:1543,4\n-1#1:1547,6\n-1#1:1554,3\n-1#1:1558,2\n-1#1:1560\n-1#1:1561,10\n-1#1:1571\n-1#1:1572,6\n-1#1:1578\n-1#1:1579,2\n-1#1:1581,11\n-1#1:1592,4\n-1#1:1596,6\n-1#1:1603,3\n-1#1:1607,2\n-1#1:1609\n-1#1:1610,10\n-1#1:1620\n-1#1:1621,6\n-1#1:1627\n-1#1:1628,2\n362#1:1048\n369#1:1049\n388#1:1056\n388#1:1060\n400#1:1076\n400#1:1080\n412#1:1096\n412#1:1100\n421#1:1120\n421#1:1124\n431#1:1146\n431#1:1150\n447#1:1172\n447#1:1176\n470#1:1197\n470#1:1201\n494#1:1223\n494#1:1227\n529#1:1249\n529#1:1253\n529#1:1275\n529#1:1279\n550#1:1301\n550#1:1305\n576#1:1327\n576#1:1331\n598#1:1353\n598#1:1357\n618#1:1372\n621#1:1373\n625#1:1374,3\n626#1:1377,3\n627#1:1380\n628#1:1381\n628#1:1382\n632#1:1383\n635#1:1384\n-1#1:1406\n-1#1:1410\n-1#1:1455\n-1#1:1459\n-1#1:1504\n-1#1:1508\n-1#1:1553\n-1#1:1557\n-1#1:1602\n-1#1:1606\n617#1:1369,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class IntLongMap {

    @JvmField
    public int _capacity;

    @JvmField
    public int _size;

    @JvmField
    @NotNull
    public int[] keys;

    @JvmField
    @NotNull
    public long[] metadata;

    @JvmField
    @NotNull
    public long[] values;

    public /* synthetic */ IntLongMap(v vVar) {
        this();
    }

    public static /* synthetic */ String joinToString$default(IntLongMap intLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, int i7, Object obj) {
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
        return intLongMap.joinToString(charSequence, charSequence2, charSequence6, i6, charSequence5);
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final int count() {
        return getSize();
    }

    @JvmOverloads
    @NotNull
    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    private IntLongMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = IntSetKt.getEmptyIntArray();
        this.values = LongSetKt.getEmptyLongArray();
    }

    public final boolean all(@NotNull Function2<? super Integer, ? super Long, Boolean> predicate) {
        g0.p(predicate, "predicate");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return true;
        }
        int i6 = 0;
        while (true) {
            long j6 = jArr2[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i6 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j6) < 128) {
                        int i9 = (i6 << 3) + i8;
                        if (!predicate.invoke(Integer.valueOf(iArr[i9]), Long.valueOf(jArr[i9])).booleanValue()) {
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

    public final boolean any(@NotNull Function2<? super Integer, ? super Long, Boolean> predicate) {
        g0.p(predicate, "predicate");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j6 = jArr2[i6];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j6) < 128) {
                            int i9 = (i6 << 3) + i8;
                            if (predicate.invoke(Integer.valueOf(iArr[i9]), Long.valueOf(jArr[i9])).booleanValue()) {
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

    public final boolean containsValue(long j6) {
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j7 = jArr2[i6];
                if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j7) < 128 && j6 == jArr[(i6 << 3) + i8]) {
                            return true;
                        }
                        j7 >>= 8;
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

    public final int count(@NotNull Function2<? super Integer, ? super Long, Boolean> predicate) {
        g0.p(predicate, "predicate");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i6 = 0;
        int i7 = 0;
        while (true) {
            long j6 = jArr2[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i6 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j6) < 128) {
                        int i10 = (i6 << 3) + i9;
                        if (predicate.invoke(Integer.valueOf(iArr[i10]), Long.valueOf(jArr[i10])).booleanValue()) {
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

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntLongMap)) {
            return false;
        }
        IntLongMap intLongMap = (IntLongMap) obj;
        if (intLongMap.getSize() != getSize()) {
            return false;
        }
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j6 = jArr2[i6];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j6) < 128) {
                            int i9 = (i6 << 3) + i8;
                            if (jArr[i9] != intLongMap.get(iArr[i9])) {
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

    public final void forEach(@NotNull Function2<? super Integer, ? super Long, n1> block) {
        g0.p(block, "block");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            long j6 = jArr2[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i6 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j6) < 128) {
                        int i9 = (i6 << 3) + i8;
                        block.invoke(Integer.valueOf(iArr[i9]), Long.valueOf(jArr[i9]));
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

    public final void forEachKey(@NotNull Function1<? super Integer, n1> block) {
        g0.p(block, "block");
        int[] iArr = this.keys;
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
                        block.invoke(Integer.valueOf(iArr[(i6 << 3) + i8]));
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

    public final void forEachValue(@NotNull Function1<? super Long, n1> block) {
        g0.p(block, "block");
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            long j6 = jArr2[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i6 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j6) < 128) {
                        block.invoke(Long.valueOf(jArr[(i6 << 3) + i8]));
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

    public final long getOrElse(int i6, @NotNull Function0<Long> defaultValue) {
        g0.p(defaultValue, "defaultValue");
        int findKeyIndex = findKeyIndex(i6);
        return findKeyIndex < 0 ? defaultValue.invoke().longValue() : this.values[findKeyIndex];
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i6 = 0;
        int i7 = 0;
        while (true) {
            long j6 = jArr2[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i6 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j6) < 128) {
                        int i10 = (i6 << 3) + i9;
                        i7 += e.a(jArr[i10]) ^ iArr[i10];
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
        int i6;
        int i7;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i8 = 0;
            int i9 = 0;
            while (true) {
                long j6 = jArr2[i8];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i10 = 8 - ((~(i8 - length)) >>> 31);
                    int i11 = 0;
                    while (i11 < i10) {
                        if ((255 & j6) < 128) {
                            int i12 = (i8 << 3) + i11;
                            int i13 = iArr[i12];
                            i7 = i8;
                            long j7 = jArr[i12];
                            sb.append(i13);
                            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                            sb.append(j7);
                            i9++;
                            if (i9 < this._size) {
                                sb.append(StringUtil.COMMA);
                                sb.append(' ');
                            }
                        } else {
                            i7 = i8;
                        }
                        j6 >>= 8;
                        i11++;
                        i8 = i7;
                    }
                    int i14 = i8;
                    if (i10 != 8) {
                        break;
                    }
                    i6 = i14;
                } else {
                    i6 = i8;
                }
                if (i6 == length) {
                    break;
                }
                i8 = i6 + 1;
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        g0.o(sb2, "s.append('}').toString()");
        return sb2;
    }

    public final boolean contains(int i6) {
        if (findKeyIndex(i6) >= 0) {
            return true;
        }
        return false;
    }

    public final boolean containsKey(int i6) {
        if (findKeyIndex(i6) >= 0) {
            return true;
        }
        return false;
    }

    @PublishedApi
    public final int findKeyIndex(int i6) {
        int i7 = ScatterMapKt.MurmurHashC1 * i6;
        int i8 = i7 ^ (i7 << 16);
        int i9 = i8 & 127;
        int i10 = this._capacity;
        int i11 = (i8 >>> 7) & i10;
        int i12 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i13 = i11 >> 3;
            int i14 = (i11 & 7) << 3;
            long j6 = ((jArr[i13 + 1] << (64 - i14)) & ((-i14) >> 63)) | (jArr[i13] >>> i14);
            long j7 = (i9 * ScatterMapKt.BitmaskLsb) ^ j6;
            for (long j8 = (~j7) & (j7 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j8 != 0; j8 &= j8 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j8) >> 3) + i11) & i10;
                if (this.keys[numberOfTrailingZeros] == i6) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j6 & ((~j6) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i12 += 8;
            i11 = (i11 + i12) & i10;
        }
    }

    public final long get(int i6) {
        int findKeyIndex = findKeyIndex(i6);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        throw new NoSuchElementException("Cannot find value for key " + i6);
    }

    public final long getOrDefault(int i6, long j6) {
        int findKeyIndex = findKeyIndex(i6);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        return j6;
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

    public static /* synthetic */ String joinToString$default(IntLongMap intLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, Function2 transform, int i7, Object obj) {
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
            int[] iArr = intLongMap.keys;
            long[] jArr3 = intLongMap.values;
            long[] jArr4 = intLongMap.metadata;
            int length = jArr4.length - 2;
            if (length >= 0) {
                int i9 = 0;
                int i10 = 0;
                loop0: while (true) {
                    long j6 = jArr4[i9];
                    int i11 = i9;
                    if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        int i13 = 0;
                        while (i13 < i12) {
                            if ((j6 & 255) < 128) {
                                int i14 = (i11 << 3) + i13;
                                int i15 = iArr[i14];
                                long j7 = jArr3[i14];
                                if (i10 == i8) {
                                    sb.append(truncated);
                                    break loop0;
                                }
                                if (i10 != 0) {
                                    sb.append(separator);
                                }
                                c6 = '\b';
                                jArr2 = jArr4;
                                sb.append((CharSequence) transform.invoke(Integer.valueOf(i15), Long.valueOf(j7)));
                                i10++;
                            } else {
                                jArr2 = jArr4;
                                c6 = '\b';
                            }
                            j6 >>= c6;
                            i13++;
                            jArr4 = jArr2;
                        }
                        jArr = jArr4;
                        if (i12 != 8) {
                            break;
                        }
                    } else {
                        jArr = jArr4;
                    }
                    if (i11 == length) {
                        break;
                    }
                    i9 = i11 + 1;
                    jArr4 = jArr;
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
        long j6;
        char c6;
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        g0.p(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i7 = 0;
            int i8 = 0;
            loop0: while (true) {
                long j7 = jArr2[i7];
                if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i9 = 8 - ((~(i7 - length)) >>> 31);
                    for (int i10 = 0; i10 < i9; i10++) {
                        if ((j7 & 255) < 128) {
                            int i11 = (i7 << 3) + i10;
                            c6 = '\b';
                            int i12 = iArr[i11];
                            j6 = j7;
                            long j8 = jArr[i11];
                            if (i8 == i6) {
                                sb.append(truncated);
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb.append(separator);
                            }
                            sb.append(i12);
                            sb.append('=');
                            sb.append(j8);
                            i8++;
                        } else {
                            j6 = j7;
                            c6 = '\b';
                        }
                        j7 = j6 >> c6;
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
    public final String joinToString(@NotNull CharSequence charSequence, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @NotNull Function2<? super Integer, ? super Long, ? extends CharSequence> transform) {
        CharSequence separator = charSequence;
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        g0.p(truncated, "truncated");
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i7 = 0;
            int i8 = 0;
            loop0: while (true) {
                long j6 = jArr2[i7];
                int i9 = i7;
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i10 = 8 - ((~(i9 - length)) >>> 31);
                    int i11 = 0;
                    while (i11 < i10) {
                        if ((j6 & 255) < 128) {
                            int i12 = (i9 << 3) + i11;
                            int i13 = iArr[i12];
                            long j7 = jArr[i12];
                            if (i8 == i6) {
                                sb.append(truncated);
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb.append(separator);
                            }
                            sb.append(transform.invoke(Integer.valueOf(i13), Long.valueOf(j7)));
                            i8++;
                        }
                        j6 >>= 8;
                        i11++;
                        separator = charSequence;
                    }
                    if (i10 != 8) {
                        break;
                    }
                }
                if (i9 == length) {
                    break;
                }
                i7 = i9 + 1;
                separator = charSequence;
            }
        }
        sb.append(postfix);
        String sb2 = sb.toString();
        g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence charSequence, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull Function2<? super Integer, ? super Long, ? extends CharSequence> transform) {
        char c6;
        CharSequence separator = charSequence;
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i7 = 0;
            int i8 = 0;
            loop0: while (true) {
                long j6 = jArr2[i7];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i9 = 8 - ((~(i7 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j6 & 255) < 128) {
                            int i11 = (i7 << 3) + i10;
                            int i12 = iArr[i11];
                            long j7 = jArr[i11];
                            c6 = '\b';
                            if (i8 == i6) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i8 != 0) {
                                sb.append(separator);
                            }
                            sb.append(transform.invoke(Integer.valueOf(i12), Long.valueOf(j7)));
                            i8++;
                        } else {
                            c6 = '\b';
                        }
                        j6 >>= c6;
                        i10++;
                        separator = charSequence;
                    }
                    if (i9 != 8) {
                        break;
                    }
                }
                if (i7 == length) {
                    break;
                }
                i7++;
                separator = charSequence;
            }
        }
        sb.append(postfix);
        String sb2 = sb.toString();
        g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, @NotNull Function2<? super Integer, ? super Long, ? extends CharSequence> transform) {
        char c6;
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0: while (true) {
                long j6 = jArr2[i6];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((j6 & 255) < 128) {
                            int i10 = (i6 << 3) + i9;
                            int i11 = iArr[i10];
                            long j7 = jArr[i10];
                            c6 = '\b';
                            if (i7 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(separator);
                            }
                            sb.append(transform.invoke(Integer.valueOf(i11), Long.valueOf(j7)));
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
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull Function2<? super Integer, ? super Long, ? extends CharSequence> transform) {
        char c6;
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0: while (true) {
                long j6 = jArr2[i6];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((j6 & 255) < 128) {
                            int i10 = (i6 << 3) + i9;
                            int i11 = iArr[i10];
                            long j7 = jArr[i10];
                            if (i7 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(separator);
                            }
                            c6 = '\b';
                            sb.append(transform.invoke(Integer.valueOf(i11), Long.valueOf(j7)));
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
    public final String joinToString(@NotNull CharSequence separator, @NotNull Function2<? super Integer, ? super Long, ? extends CharSequence> transform) {
        char c6;
        g0.p(separator, "separator");
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0: while (true) {
                long j6 = jArr2[i6];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((j6 & 255) < 128) {
                            int i10 = (i6 << 3) + i9;
                            int i11 = iArr[i10];
                            long j7 = jArr[i10];
                            c6 = '\b';
                            if (i7 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append(separator);
                            }
                            sb.append(transform.invoke(Integer.valueOf(i11), Long.valueOf(j7)));
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
    public final String joinToString(@NotNull Function2<? super Integer, ? super Long, ? extends CharSequence> transform) {
        char c6;
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            loop0: while (true) {
                long j6 = jArr2[i6];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((j6 & 255) < 128) {
                            int i10 = (i6 << 3) + i9;
                            int i11 = iArr[i10];
                            long j7 = jArr[i10];
                            if (i7 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i7 != 0) {
                                sb.append((CharSequence) ", ");
                            }
                            Integer valueOf = Integer.valueOf(i11);
                            c6 = '\b';
                            sb.append(transform.invoke(valueOf, Long.valueOf(j7)));
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
