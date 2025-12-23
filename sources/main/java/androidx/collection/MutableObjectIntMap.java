package androidx.collection;

import java.util.Iterator;
import kotlin.PublishedApi;
import kotlin.collections.n;
import kotlin.d1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.sequences.m;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nObjectIntMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectIntMap.kt\nandroidx/collection/MutableObjectIntMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 4 ObjectIntMap.kt\nandroidx/collection/ObjectIntMap\n+ 5 ScatterSet.kt\nandroidx/collection/ScatterSet\n*L\n1#1,1074:1\n1064#1,2:1155\n1068#1,5:1163\n1064#1,2:1194\n1068#1,5:1202\n1064#1,2:1219\n1068#1,5:1227\n1064#1,2:1233\n1068#1,5:1241\n1#2:1075\n1672#3,6:1076\n1826#3:1092\n1688#3:1096\n1826#3:1114\n1688#3:1118\n1826#3:1139\n1688#3:1143\n1672#3,6:1157\n1672#3,6:1168\n1605#3,3:1174\n1615#3:1177\n1619#3:1178\n1795#3,3:1179\n1809#3,3:1182\n1733#3:1185\n1721#3:1186\n1715#3:1187\n1728#3:1188\n1818#3:1189\n1682#3:1190\n1661#3:1191\n1680#3:1192\n1661#3:1193\n1672#3,6:1196\n1795#3,3:1207\n1826#3:1210\n1715#3:1211\n1685#3:1212\n1661#3:1213\n1605#3,3:1214\n1615#3:1217\n1619#3:1218\n1672#3,6:1221\n1661#3:1232\n1672#3,6:1235\n1672#3,6:1246\n1672#3,6:1252\n401#4,4:1082\n373#4,6:1086\n383#4,3:1093\n386#4,2:1097\n406#4,2:1099\n389#4,6:1101\n408#4:1107\n373#4,6:1108\n383#4,3:1115\n386#4,9:1119\n267#5,4:1128\n237#5,7:1132\n248#5,3:1140\n251#5,2:1144\n272#5,2:1146\n254#5,6:1148\n274#5:1154\n*S KotlinDebug\n*F\n+ 1 ObjectIntMap.kt\nandroidx/collection/MutableObjectIntMap\n*L\n900#1:1155,2\n900#1:1163,5\n960#1:1194,2\n960#1:1202,5\n1034#1:1219,2\n1034#1:1227,5\n1050#1:1233,2\n1050#1:1241,5\n728#1:1076,6\n804#1:1092\n804#1:1096\n843#1:1114\n843#1:1118\n889#1:1139\n889#1:1143\n900#1:1157,6\n911#1:1168,6\n925#1:1174,3\n926#1:1177\n927#1:1178\n934#1:1179,3\n935#1:1182,3\n936#1:1185\n937#1:1186\n937#1:1187\n941#1:1188\n944#1:1189\n953#1:1190\n953#1:1191\n959#1:1192\n959#1:1193\n960#1:1196,6\n975#1:1207,3\n976#1:1210\n978#1:1211\n1029#1:1212\n1029#1:1213\n1031#1:1214,3\n1032#1:1217\n1034#1:1218\n1034#1:1221,6\n1048#1:1232\n1050#1:1235,6\n1065#1:1246,6\n1071#1:1252,6\n804#1:1082,4\n804#1:1086,6\n804#1:1093,3\n804#1:1097,2\n804#1:1099,2\n804#1:1101,6\n804#1:1107\n843#1:1108,6\n843#1:1115,3\n843#1:1119,9\n889#1:1128,4\n889#1:1132,7\n889#1:1140,3\n889#1:1144,2\n889#1:1146,2\n889#1:1148,6\n889#1:1154\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class MutableObjectIntMap<K> extends ObjectIntMap<K> {
    private int growthLimit;

    public MutableObjectIntMap() {
        this(0, 1, null);
    }

    public final void clear() {
        this._size = 0;
        long[] jArr = this.metadata;
        if (jArr != ScatterMapKt.EmptyGroup) {
            n.U1(jArr, -9187201950435737472L, 0, 0, 6, null);
            long[] jArr2 = this.metadata;
            int i6 = this._capacity;
            int i7 = i6 >> 3;
            long j6 = 255 << ((i6 & 7) << 3);
            jArr2[i7] = (jArr2[i7] & (~j6)) | j6;
        }
        n.M1(this.keys, null, 0, this._capacity);
        initializeGrowth();
    }

    public final void minusAssign(K k6) {
        remove(k6);
    }

    public final void put(K k6, int i6) {
        set(k6, i6);
    }

    public final void remove(K k6) {
        int findKeyIndex = findKeyIndex(k6);
        if (findKeyIndex >= 0) {
            removeValueAt(findKeyIndex);
        }
    }

    public /* synthetic */ MutableObjectIntMap(int i6, int i7, v vVar) {
        this((i7 & 1) != 0 ? 6 : i6);
    }

    private final void adjustStorage() {
        int compare;
        if (this._capacity > 8) {
            compare = Long.compare(d1.k(d1.k(this._size) * 32) ^ Long.MIN_VALUE, d1.k(d1.k(this._capacity) * 25) ^ Long.MIN_VALUE);
            if (compare <= 0) {
                removeDeletedMarkers();
                return;
            }
        }
        resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
    }

    private final int findFirstAvailableSlot(int i6) {
        int i7 = this._capacity;
        int i8 = i6 & i7;
        int i9 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i10 = i8 >> 3;
            int i11 = (i8 & 7) << 3;
            long j6 = ((jArr[i10 + 1] << (64 - i11)) & ((-i11) >> 63)) | (jArr[i10] >>> i11);
            long j7 = j6 & ((~j6) << 7) & (-9187201950435737472L);
            if (j7 != 0) {
                return (i8 + (Long.numberOfTrailingZeros(j7) >> 3)) & i7;
            }
            i9 += 8;
            i8 = (i8 + i9) & i7;
        }
    }

    private final int findIndex(K k6) {
        int hashCode = (k6 != null ? k6.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i6 = hashCode ^ (hashCode << 16);
        int i7 = i6 >>> 7;
        int i8 = i6 & 127;
        int i9 = this._capacity;
        int i10 = i7 & i9;
        int i11 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i12 = i10 >> 3;
            int i13 = (i10 & 7) << 3;
            long j6 = ((jArr[i12 + 1] << (64 - i13)) & ((-i13) >> 63)) | (jArr[i12] >>> i13);
            long j7 = i8;
            int i14 = i8;
            long j8 = j6 ^ (j7 * ScatterMapKt.BitmaskLsb);
            for (long j9 = (~j8) & (j8 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j9 != 0; j9 &= j9 - 1) {
                int numberOfTrailingZeros = (i10 + (Long.numberOfTrailingZeros(j9) >> 3)) & i9;
                if (g0.g(this.keys[numberOfTrailingZeros], k6)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j6) << 6) & j6 & (-9187201950435737472L)) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i7);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    findFirstAvailableSlot = findFirstAvailableSlot(i7);
                }
                this._size++;
                int i15 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i16 = findFirstAvailableSlot >> 3;
                long j10 = jArr2[i16];
                int i17 = (findFirstAvailableSlot & 7) << 3;
                this.growthLimit = i15 - (((j10 >> i17) & 255) == 128 ? 1 : 0);
                jArr2[i16] = (j10 & (~(255 << i17))) | (j7 << i17);
                int i18 = this._capacity;
                int i19 = ((findFirstAvailableSlot - 7) & i18) + (i18 & 7);
                int i20 = i19 >> 3;
                int i21 = (i19 & 7) << 3;
                jArr2[i20] = ((~(255 << i21)) & jArr2[i20]) | (j7 << i21);
                return ~findFirstAvailableSlot;
            }
            i11 += 8;
            i10 = (i10 + i11) & i9;
            i8 = i14;
        }
    }

    private final void initializeMetadata(int i6) {
        long[] jArr;
        if (i6 == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            long[] jArr2 = new long[((i6 + 15) & (-8)) >> 3];
            n.U1(jArr2, -9187201950435737472L, 0, 0, 6, null);
            jArr = jArr2;
        }
        this.metadata = jArr;
        int i7 = i6 >> 3;
        long j6 = 255 << ((i6 & 7) << 3);
        jArr[i7] = (jArr[i7] & (~j6)) | j6;
        initializeGrowth();
    }

    private final void initializeStorage(int i6) {
        int max = i6 > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(i6)) : 0;
        this._capacity = max;
        initializeMetadata(max);
        this.keys = new Object[max];
        this.values = new int[max];
    }

    private final void removeDeletedMarkers() {
        long[] jArr = this.metadata;
        int i6 = this._capacity;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            int i9 = i8 >> 3;
            int i10 = (i8 & 7) << 3;
            if (((jArr[i9] >> i10) & 255) == 254) {
                long[] jArr2 = this.metadata;
                jArr2[i9] = (128 << i10) | (jArr2[i9] & (~(255 << i10)));
                int i11 = this._capacity;
                int i12 = ((i8 - 7) & i11) + (i11 & 7);
                int i13 = i12 >> 3;
                int i14 = (i12 & 7) << 3;
                jArr2[i13] = ((~(255 << i14)) & jArr2[i13]) | (128 << i14);
                i7++;
            }
        }
        this.growthLimit += i7;
    }

    private final void resizeStorage(int i6) {
        int i7;
        long[] jArr = this.metadata;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        int i8 = this._capacity;
        initializeStorage(i6);
        Object[] objArr2 = this.keys;
        int[] iArr2 = this.values;
        int i9 = 0;
        while (i9 < i8) {
            if (((jArr[i9 >> 3] >> ((i9 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i9];
                int hashCode = (obj != null ? obj.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
                int i10 = hashCode ^ (hashCode << 16);
                int findFirstAvailableSlot = findFirstAvailableSlot(i10 >>> 7);
                long j6 = i10 & 127;
                long[] jArr2 = this.metadata;
                int i11 = findFirstAvailableSlot >> 3;
                int i12 = (findFirstAvailableSlot & 7) << 3;
                i7 = i9;
                jArr2[i11] = (jArr2[i11] & (~(255 << i12))) | (j6 << i12);
                int i13 = this._capacity;
                int i14 = ((findFirstAvailableSlot - 7) & i13) + (i13 & 7);
                int i15 = i14 >> 3;
                int i16 = (i14 & 7) << 3;
                jArr2[i15] = (jArr2[i15] & (~(255 << i16))) | (j6 << i16);
                objArr2[findFirstAvailableSlot] = obj;
                iArr2[findFirstAvailableSlot] = iArr[i7];
            } else {
                i7 = i9;
            }
            i9 = i7 + 1;
        }
    }

    private final void writeMetadata(int i6, long j6) {
        long[] jArr = this.metadata;
        int i7 = i6 >> 3;
        int i8 = (i6 & 7) << 3;
        jArr[i7] = (jArr[i7] & (~(255 << i8))) | (j6 << i8);
        int i9 = this._capacity;
        int i10 = ((i6 - 7) & i9) + (i9 & 7);
        int i11 = i10 >> 3;
        int i12 = (i10 & 7) << 3;
        jArr[i11] = (j6 << i12) | (jArr[i11] & (~(255 << i12)));
    }

    public final int getOrPut(K k6, @NotNull Function0<Integer> defaultValue) {
        g0.p(defaultValue, "defaultValue");
        int findKeyIndex = findKeyIndex(k6);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        int intValue = defaultValue.invoke().intValue();
        set(k6, intValue);
        return intValue;
    }

    public final void minusAssign(@NotNull K[] keys) {
        g0.p(keys, "keys");
        for (K k6 : keys) {
            remove(k6);
        }
    }

    public final void plusAssign(@NotNull ObjectIntMap<K> from) {
        g0.p(from, "from");
        putAll(from);
    }

    public final int put(K k6, int i6, int i7) {
        int findIndex = findIndex(k6);
        if (findIndex < 0) {
            findIndex = ~findIndex;
        } else {
            i7 = this.values[findIndex];
        }
        this.keys[findIndex] = k6;
        this.values[findIndex] = i6;
        return i7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(@NotNull ObjectIntMap<K> from) {
        g0.p(from, "from");
        Object[] objArr = from.keys;
        int[] iArr = from.values;
        long[] jArr = from.metadata;
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
                        set(objArr[i9], iArr[i9]);
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

    public final void removeIf(@NotNull Function2<? super K, ? super Integer, Boolean> predicate) {
        g0.p(predicate, "predicate");
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
                        if (predicate.invoke(this.keys[i9], Integer.valueOf(this.values[i9])).booleanValue()) {
                            removeValueAt(i9);
                        }
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
    public final void removeValueAt(int i6) {
        this._size--;
        long[] jArr = this.metadata;
        int i7 = i6 >> 3;
        int i8 = (i6 & 7) << 3;
        jArr[i7] = (jArr[i7] & (~(255 << i8))) | (254 << i8);
        int i9 = this._capacity;
        int i10 = ((i6 - 7) & i9) + (i9 & 7);
        int i11 = i10 >> 3;
        int i12 = (i10 & 7) << 3;
        jArr[i11] = (jArr[i11] & (~(255 << i12))) | (254 << i12);
        this.keys[i6] = null;
    }

    public final int trim() {
        int i6 = this._capacity;
        int normalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (normalizeCapacity >= i6) {
            return 0;
        }
        resizeStorage(normalizeCapacity);
        return i6 - this._capacity;
    }

    public MutableObjectIntMap(int i6) {
        super(null);
        if (i6 >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i6));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(getCapacity()) - this._size;
    }

    public final boolean remove(K k6, int i6) {
        int findKeyIndex = findKeyIndex(k6);
        if (findKeyIndex < 0 || this.values[findKeyIndex] != i6) {
            return false;
        }
        removeValueAt(findKeyIndex);
        return true;
    }

    public final void set(K k6, int i6) {
        int findIndex = findIndex(k6);
        if (findIndex < 0) {
            findIndex = ~findIndex;
        }
        this.keys[findIndex] = k6;
        this.values[findIndex] = i6;
    }

    public final void minusAssign(@NotNull Iterable<? extends K> keys) {
        g0.p(keys, "keys");
        Iterator<? extends K> it = keys.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final void minusAssign(@NotNull m<? extends K> keys) {
        g0.p(keys, "keys");
        Iterator<? extends K> it = keys.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(@NotNull ScatterSet<K> keys) {
        g0.p(keys, "keys");
        Object[] objArr = keys.elements;
        long[] jArr = keys.metadata;
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
                        remove(objArr[(i6 << 3) + i8]);
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
}
