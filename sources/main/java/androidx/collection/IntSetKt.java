package androidx.collection;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nIntSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntSet.kt\nandroidx/collection/IntSetKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,853:1\n1#2:854\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class IntSetKt {

    @NotNull
    private static final MutableIntSet EmptyIntSet = new MutableIntSet(0);

    @NotNull
    private static final int[] EmptyIntArray = new int[0];

    @NotNull
    public static final IntSet intSetOf() {
        return EmptyIntSet;
    }

    @NotNull
    public static final MutableIntSet mutableIntSetOf() {
        return new MutableIntSet(0, 1, null);
    }

    @NotNull
    public static final IntSet emptyIntSet() {
        return EmptyIntSet;
    }

    @NotNull
    public static final int[] getEmptyIntArray() {
        return EmptyIntArray;
    }

    @NotNull
    public static final IntSet intSetOf(int i6) {
        return mutableIntSetOf(i6);
    }

    @NotNull
    public static final MutableIntSet mutableIntSetOf(int i6) {
        MutableIntSet mutableIntSet = new MutableIntSet(1);
        mutableIntSet.plusAssign(i6);
        return mutableIntSet;
    }

    public static final int hash(int i6) {
        int i7 = i6 * ScatterMapKt.MurmurHashC1;
        return i7 ^ (i7 << 16);
    }

    @NotNull
    public static final IntSet intSetOf(int i6, int i7) {
        return mutableIntSetOf(i6, i7);
    }

    @NotNull
    public static final IntSet intSetOf(int i6, int i7, int i8) {
        return mutableIntSetOf(i6, i7, i8);
    }

    @NotNull
    public static final MutableIntSet mutableIntSetOf(int i6, int i7) {
        MutableIntSet mutableIntSet = new MutableIntSet(2);
        mutableIntSet.plusAssign(i6);
        mutableIntSet.plusAssign(i7);
        return mutableIntSet;
    }

    @NotNull
    public static final IntSet intSetOf(@NotNull int... elements) {
        g0.p(elements, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(elements.length);
        mutableIntSet.plusAssign(elements);
        return mutableIntSet;
    }

    @NotNull
    public static final MutableIntSet mutableIntSetOf(int i6, int i7, int i8) {
        MutableIntSet mutableIntSet = new MutableIntSet(3);
        mutableIntSet.plusAssign(i6);
        mutableIntSet.plusAssign(i7);
        mutableIntSet.plusAssign(i8);
        return mutableIntSet;
    }

    @NotNull
    public static final MutableIntSet mutableIntSetOf(@NotNull int... elements) {
        g0.p(elements, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(elements.length);
        mutableIntSet.plusAssign(elements);
        return mutableIntSet;
    }
}
