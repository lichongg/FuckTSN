package androidx.collection;

import androidx.camera.camera2.internal.compat.params.e;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLongSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongSet.kt\nandroidx/collection/LongSetKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,853:1\n1#2:854\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class LongSetKt {

    @NotNull
    private static final MutableLongSet EmptyLongSet = new MutableLongSet(0);

    @NotNull
    private static final long[] EmptyLongArray = new long[0];

    @NotNull
    public static final LongSet longSetOf() {
        return EmptyLongSet;
    }

    @NotNull
    public static final MutableLongSet mutableLongSetOf() {
        return new MutableLongSet(0, 1, null);
    }

    @NotNull
    public static final LongSet emptyLongSet() {
        return EmptyLongSet;
    }

    @NotNull
    public static final long[] getEmptyLongArray() {
        return EmptyLongArray;
    }

    @NotNull
    public static final LongSet longSetOf(long j6) {
        return mutableLongSetOf(j6);
    }

    @NotNull
    public static final MutableLongSet mutableLongSetOf(long j6) {
        MutableLongSet mutableLongSet = new MutableLongSet(1);
        mutableLongSet.plusAssign(j6);
        return mutableLongSet;
    }

    public static final int hash(long j6) {
        int a6 = e.a(j6) * ScatterMapKt.MurmurHashC1;
        return a6 ^ (a6 << 16);
    }

    @NotNull
    public static final LongSet longSetOf(long j6, long j7) {
        return mutableLongSetOf(j6, j7);
    }

    @NotNull
    public static final LongSet longSetOf(long j6, long j7, long j8) {
        return mutableLongSetOf(j6, j7, j8);
    }

    @NotNull
    public static final MutableLongSet mutableLongSetOf(long j6, long j7) {
        MutableLongSet mutableLongSet = new MutableLongSet(2);
        mutableLongSet.plusAssign(j6);
        mutableLongSet.plusAssign(j7);
        return mutableLongSet;
    }

    @NotNull
    public static final LongSet longSetOf(@NotNull long... elements) {
        g0.p(elements, "elements");
        MutableLongSet mutableLongSet = new MutableLongSet(elements.length);
        mutableLongSet.plusAssign(elements);
        return mutableLongSet;
    }

    @NotNull
    public static final MutableLongSet mutableLongSetOf(long j6, long j7, long j8) {
        MutableLongSet mutableLongSet = new MutableLongSet(3);
        mutableLongSet.plusAssign(j6);
        mutableLongSet.plusAssign(j7);
        mutableLongSet.plusAssign(j8);
        return mutableLongSet;
    }

    @NotNull
    public static final MutableLongSet mutableLongSetOf(@NotNull long... elements) {
        g0.p(elements, "elements");
        MutableLongSet mutableLongSet = new MutableLongSet(elements.length);
        mutableLongSet.plusAssign(elements);
        return mutableLongSet;
    }
}
