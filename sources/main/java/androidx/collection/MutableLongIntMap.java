package androidx.collection;

import androidx.camera.camera2.internal.compat.params.e;
import kotlin.PublishedApi;
import kotlin.collections.n;
import kotlin.d1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLongIntMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongIntMap.kt\nandroidx/collection/MutableLongIntMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 4 LongIntMap.kt\nandroidx/collection/LongIntMap\n+ 5 LongSet.kt\nandroidx/collection/LongSet\n+ 6 LongList.kt\nandroidx/collection/LongList\n+ 7 LongSet.kt\nandroidx/collection/LongSetKt\n*L\n1#1,1047:1\n1037#1,2:1134\n1041#1,5:1142\n1037#1,2:1173\n1041#1,5:1181\n1037#1,2:1198\n1041#1,5:1206\n1037#1,2:1212\n1041#1,5:1220\n1#2:1048\n1672#3,6:1049\n1826#3:1065\n1688#3:1069\n1826#3:1087\n1688#3:1091\n1826#3:1112\n1688#3:1116\n1672#3,6:1136\n1672#3,6:1147\n1615#3:1156\n1619#3:1157\n1795#3,3:1158\n1809#3,3:1161\n1733#3:1164\n1721#3:1165\n1715#3:1166\n1728#3:1167\n1818#3:1168\n1682#3:1169\n1661#3:1170\n1680#3:1171\n1661#3:1172\n1672#3,6:1175\n1795#3,3:1186\n1826#3:1189\n1715#3:1190\n1685#3:1191\n1661#3:1192\n1615#3:1196\n1619#3:1197\n1672#3,6:1200\n1661#3:1211\n1672#3,6:1214\n1672#3,6:1225\n1672#3,6:1231\n385#4,4:1055\n357#4,6:1059\n367#4,3:1066\n370#4,2:1070\n389#4,2:1072\n373#4,6:1074\n391#4:1080\n357#4,6:1081\n367#4,3:1088\n370#4,9:1092\n262#5,4:1101\n232#5,7:1105\n243#5,3:1113\n246#5,2:1117\n266#5,2:1119\n249#5,6:1121\n268#5:1127\n253#6,6:1128\n849#7,3:1153\n849#7,3:1193\n*S KotlinDebug\n*F\n+ 1 LongIntMap.kt\nandroidx/collection/MutableLongIntMap\n*L\n875#1:1134,2\n875#1:1142,5\n933#1:1173,2\n933#1:1181,5\n1007#1:1198,2\n1007#1:1206,5\n1023#1:1212,2\n1023#1:1220,5\n711#1:1049,6\n789#1:1065\n789#1:1069\n828#1:1087\n828#1:1091\n855#1:1112\n855#1:1116\n875#1:1136,6\n885#1:1147,6\n899#1:1156\n900#1:1157\n907#1:1158,3\n908#1:1161,3\n909#1:1164\n910#1:1165\n910#1:1166\n914#1:1167\n917#1:1168\n926#1:1169\n926#1:1170\n932#1:1171\n932#1:1172\n933#1:1175,6\n948#1:1186,3\n949#1:1189\n951#1:1190\n1002#1:1191\n1002#1:1192\n1005#1:1196\n1007#1:1197\n1007#1:1200,6\n1021#1:1211\n1023#1:1214,6\n1038#1:1225,6\n1044#1:1231,6\n789#1:1055,4\n789#1:1059,6\n789#1:1066,3\n789#1:1070,2\n789#1:1072,2\n789#1:1074,6\n789#1:1080\n828#1:1081,6\n828#1:1088,3\n828#1:1092,9\n855#1:1101,4\n855#1:1105,7\n855#1:1113,3\n855#1:1117,2\n855#1:1119,2\n855#1:1121,6\n855#1:1127\n864#1:1128,6\n898#1:1153,3\n1004#1:1193,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class MutableLongIntMap extends LongIntMap {
    private int growthLimit;

    public MutableLongIntMap() {
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
        initializeGrowth();
    }

    public final void minusAssign(long j6) {
        remove(j6);
    }

    public final void put(long j6, int i6) {
        set(j6, i6);
    }

    public final void remove(long j6) {
        int findKeyIndex = findKeyIndex(j6);
        if (findKeyIndex >= 0) {
            removeValueAt(findKeyIndex);
        }
    }

    public /* synthetic */ MutableLongIntMap(int i6, int i7, v vVar) {
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

    private final int findInsertIndex(long j6) {
        int a6 = e.a(j6) * ScatterMapKt.MurmurHashC1;
        int i6 = a6 ^ (a6 << 16);
        int i7 = i6 >>> 7;
        int i8 = i6 & 127;
        int i9 = this._capacity;
        int i10 = i7 & i9;
        int i11 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i12 = i10 >> 3;
            int i13 = (i10 & 7) << 3;
            long j7 = ((jArr[i12 + 1] << (64 - i13)) & ((-i13) >> 63)) | (jArr[i12] >>> i13);
            long j8 = i8;
            int i14 = i11;
            long j9 = j7 ^ (j8 * ScatterMapKt.BitmaskLsb);
            for (long j10 = (~j9) & (j9 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j10 != 0; j10 &= j10 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j10) >> 3) + i10) & i9;
                if (this.keys[numberOfTrailingZeros] == j6) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j7) << 6) & j7 & (-9187201950435737472L)) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i7);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    findFirstAvailableSlot = findFirstAvailableSlot(i7);
                }
                this._size++;
                int i15 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i16 = findFirstAvailableSlot >> 3;
                long j11 = jArr2[i16];
                int i17 = (findFirstAvailableSlot & 7) << 3;
                this.growthLimit = i15 - (((j11 >> i17) & 255) == 128 ? 1 : 0);
                jArr2[i16] = (j11 & (~(255 << i17))) | (j8 << i17);
                int i18 = this._capacity;
                int i19 = ((findFirstAvailableSlot - 7) & i18) + (i18 & 7);
                int i20 = i19 >> 3;
                int i21 = (i19 & 7) << 3;
                jArr2[i20] = ((~(255 << i21)) & jArr2[i20]) | (j8 << i21);
                return ~findFirstAvailableSlot;
            }
            i11 = i14 + 8;
            i10 = (i10 + i11) & i9;
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
        this.keys = new long[max];
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
        long[] jArr;
        MutableLongIntMap mutableLongIntMap = this;
        long[] jArr2 = mutableLongIntMap.metadata;
        long[] jArr3 = mutableLongIntMap.keys;
        int[] iArr = mutableLongIntMap.values;
        int i7 = mutableLongIntMap._capacity;
        initializeStorage(i6);
        long[] jArr4 = mutableLongIntMap.keys;
        int[] iArr2 = mutableLongIntMap.values;
        int i8 = 0;
        while (i8 < i7) {
            if (((jArr2[i8 >> 3] >> ((i8 & 7) << 3)) & 255) < 128) {
                long j6 = jArr3[i8];
                int a6 = e.a(j6) * ScatterMapKt.MurmurHashC1;
                int i9 = a6 ^ (a6 << 16);
                int findFirstAvailableSlot = mutableLongIntMap.findFirstAvailableSlot(i9 >>> 7);
                long j7 = i9 & 127;
                long[] jArr5 = mutableLongIntMap.metadata;
                int i10 = findFirstAvailableSlot >> 3;
                int i11 = (findFirstAvailableSlot & 7) << 3;
                jArr5[i10] = (jArr5[i10] & (~(255 << i11))) | (j7 << i11);
                int i12 = mutableLongIntMap._capacity;
                int i13 = ((findFirstAvailableSlot - 7) & i12) + (i12 & 7);
                int i14 = i13 >> 3;
                int i15 = (i13 & 7) << 3;
                jArr = jArr2;
                jArr5[i14] = (jArr5[i14] & (~(255 << i15))) | (j7 << i15);
                jArr4[findFirstAvailableSlot] = j6;
                iArr2[findFirstAvailableSlot] = iArr[i8];
            } else {
                jArr = jArr2;
            }
            i8++;
            mutableLongIntMap = this;
            jArr2 = jArr;
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

    public final int getOrPut(long j6, @NotNull Function0<Integer> defaultValue) {
        g0.p(defaultValue, "defaultValue");
        int findKeyIndex = findKeyIndex(j6);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        int intValue = defaultValue.invoke().intValue();
        put(j6, intValue);
        return intValue;
    }

    public final void minusAssign(@NotNull long[] keys) {
        g0.p(keys, "keys");
        for (long j6 : keys) {
            remove(j6);
        }
    }

    public final void plusAssign(@NotNull LongIntMap from) {
        g0.p(from, "from");
        putAll(from);
    }

    public final int put(long j6, int i6, int i7) {
        int findInsertIndex = findInsertIndex(j6);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        } else {
            i7 = this.values[findInsertIndex];
        }
        this.keys[findInsertIndex] = j6;
        this.values[findInsertIndex] = i6;
        return i7;
    }

    public final void putAll(@NotNull LongIntMap from) {
        g0.p(from, "from");
        long[] jArr = from.keys;
        int[] iArr = from.values;
        long[] jArr2 = from.metadata;
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
                        set(jArr[i9], iArr[i9]);
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

    public final void removeIf(@NotNull Function2<? super Long, ? super Integer, Boolean> predicate) {
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
                        if (predicate.invoke(Long.valueOf(this.keys[i9]), Integer.valueOf(this.values[i9])).booleanValue()) {
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

    public MutableLongIntMap(int i6) {
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

    public final boolean remove(long j6, int i6) {
        int findKeyIndex = findKeyIndex(j6);
        if (findKeyIndex < 0 || this.values[findKeyIndex] != i6) {
            return false;
        }
        removeValueAt(findKeyIndex);
        return true;
    }

    public final void set(long j6, int i6) {
        int findInsertIndex = findInsertIndex(j6);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        }
        this.keys[findInsertIndex] = j6;
        this.values[findInsertIndex] = i6;
    }

    public final void minusAssign(@NotNull LongSet keys) {
        g0.p(keys, "keys");
        long[] jArr = keys.elements;
        long[] jArr2 = keys.metadata;
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
                        remove(jArr[(i6 << 3) + i8]);
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

    public final void minusAssign(@NotNull LongList keys) {
        g0.p(keys, "keys");
        long[] jArr = keys.content;
        int i6 = keys._size;
        for (int i7 = 0; i7 < i6; i7++) {
            remove(jArr[i7]);
        }
    }
}
