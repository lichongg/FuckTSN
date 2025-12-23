package androidx.collection;

import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nScatterMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1850:1\n1661#1:1851\n1661#1:1852\n1661#1:1853\n1715#1:1854\n*S KotlinDebug\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1680#1:1851\n1682#1:1852\n1685#1:1853\n1721#1:1854\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ScatterMapKt {
    public static final long AllEmpty = -9187201950435737472L;
    public static final long BitmaskLsb = 72340172838076673L;
    public static final long BitmaskMsb = -9187201950435737472L;
    public static final int ClonedMetadataCount = 7;
    public static final int DefaultScatterCapacity = 6;
    public static final long Deleted = 254;
    public static final long Empty = 128;

    @JvmField
    @NotNull
    public static final long[] EmptyGroup = {-9187201950435737345L, -1};

    @NotNull
    private static final MutableScatterMap EmptyScatterMap = new MutableScatterMap(0);
    public static final int GroupWidth = 8;
    public static final int MurmurHashC1 = -862048943;
    public static final long Sentinel = 255;

    @PublishedApi
    public static final boolean isFull(long j6) {
        return j6 < 128;
    }

    public static final int loadedCapacity(int i6) {
        if (i6 == 7) {
            return 6;
        }
        return i6 - (i6 / 8);
    }

    public static final long maskEmpty(long j6) {
        return j6 & ((~j6) << 6) & (-9187201950435737472L);
    }

    @PublishedApi
    public static final long maskEmptyOrDeleted(long j6) {
        return j6 & ((~j6) << 7) & (-9187201950435737472L);
    }

    @PublishedApi
    public static final long match(long j6, int i6) {
        long j7 = j6 ^ (i6 * BitmaskLsb);
        return (~j7) & (j7 - BitmaskLsb) & (-9187201950435737472L);
    }

    @NotNull
    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf() {
        return new MutableScatterMap<>(0, 1, null);
    }

    public static final int unloadedCapacity(int i6) {
        if (i6 == 7) {
            return 8;
        }
        return i6 + ((i6 - 1) / 7);
    }

    @NotNull
    public static final <K, V> ScatterMap<K, V> emptyScatterMap() {
        MutableScatterMap mutableScatterMap = EmptyScatterMap;
        g0.n(mutableScatterMap, "null cannot be cast to non-null type androidx.collection.ScatterMap<K of androidx.collection.ScatterMapKt.emptyScatterMap, V of androidx.collection.ScatterMapKt.emptyScatterMap>");
        return mutableScatterMap;
    }

    public static final long group(@NotNull long[] metadata, int i6) {
        g0.p(metadata, "metadata");
        int i7 = i6 >> 3;
        int i8 = (i6 & 7) << 3;
        return (((-i8) >> 63) & (metadata[i7 + 1] << (64 - i8))) | (metadata[i7] >>> i8);
    }

    public static final int h1(int i6) {
        return i6 >>> 7;
    }

    public static final int h2(int i6) {
        return i6 & 127;
    }

    public static final boolean hasNext(long j6) {
        return j6 != 0;
    }

    public static final int hash(@Nullable Object obj) {
        int hashCode = (obj != null ? obj.hashCode() : 0) * MurmurHashC1;
        return hashCode ^ (hashCode << 16);
    }

    public static final boolean isDeleted(@NotNull long[] metadata, int i6) {
        g0.p(metadata, "metadata");
        return ((metadata[i6 >> 3] >> ((i6 & 7) << 3)) & 255) == 254;
    }

    public static final boolean isEmpty(@NotNull long[] metadata, int i6) {
        g0.p(metadata, "metadata");
        return ((metadata[i6 >> 3] >> ((i6 & 7) << 3)) & 255) == 128;
    }

    public static final boolean isFull(@NotNull long[] metadata, int i6) {
        g0.p(metadata, "metadata");
        return ((metadata[i6 >> 3] >> ((i6 & 7) << 3)) & 255) < 128;
    }

    @NotNull
    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf(@NotNull Pair<? extends K, ? extends V>... pairs) {
        g0.p(pairs, "pairs");
        MutableScatterMap<K, V> mutableScatterMap = new MutableScatterMap<>(pairs.length);
        mutableScatterMap.putAll(pairs);
        return mutableScatterMap;
    }

    public static final long next(long j6) {
        return j6 & (j6 - 1);
    }

    public static final int nextCapacity(int i6) {
        if (i6 == 0) {
            return 6;
        }
        return (i6 * 2) + 1;
    }

    public static final int normalizeCapacity(int i6) {
        if (i6 > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i6);
        }
        return 0;
    }

    @PublishedApi
    public static final long readRawMetadata(@NotNull long[] data, int i6) {
        g0.p(data, "data");
        return (data[i6 >> 3] >> ((i6 & 7) << 3)) & 255;
    }

    public static final void writeRawMetadata(@NotNull long[] data, int i6, long j6) {
        g0.p(data, "data");
        int i7 = i6 >> 3;
        int i8 = (i6 & 7) << 3;
        data[i7] = (j6 << i8) | (data[i7] & (~(255 << i8)));
    }

    public static final int get(long j6) {
        return Long.numberOfTrailingZeros(j6) >> 3;
    }

    @PublishedApi
    public static final int lowestBitSet(long j6) {
        return Long.numberOfTrailingZeros(j6) >> 3;
    }

    @PublishedApi
    public static /* synthetic */ void getBitmaskLsb$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getBitmaskMsb$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getSentinel$annotations() {
    }
}
