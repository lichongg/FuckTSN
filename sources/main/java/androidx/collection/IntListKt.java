package androidx.collection;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nIntList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntList.kt\nandroidx/collection/IntListKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 IntList.kt\nandroidx/collection/MutableIntList\n*L\n1#1,969:1\n1#2:970\n713#3,2:971\n713#3,2:973\n713#3,2:975\n713#3,2:977\n713#3,2:979\n713#3,2:981\n*S KotlinDebug\n*F\n+ 1 IntList.kt\nandroidx/collection/IntListKt\n*L\n938#1:971,2\n947#1:973,2\n948#1:975,2\n958#1:977,2\n959#1:979,2\n960#1:981,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class IntListKt {

    @NotNull
    private static final IntList EmptyIntList = new MutableIntList(0);

    @NotNull
    public static final IntList intListOf() {
        return EmptyIntList;
    }

    @NotNull
    public static final MutableIntList mutableIntListOf() {
        return new MutableIntList(0, 1, null);
    }

    @NotNull
    public static final IntList emptyIntList() {
        return EmptyIntList;
    }

    @NotNull
    public static final IntList intListOf(int i6) {
        return mutableIntListOf(i6);
    }

    @NotNull
    public static final MutableIntList mutableIntListOf(int i6) {
        MutableIntList mutableIntList = new MutableIntList(1);
        mutableIntList.add(i6);
        return mutableIntList;
    }

    @NotNull
    public static final IntList intListOf(int i6, int i7) {
        return mutableIntListOf(i6, i7);
    }

    @NotNull
    public static final IntList intListOf(int i6, int i7, int i8) {
        return mutableIntListOf(i6, i7, i8);
    }

    @NotNull
    public static final MutableIntList mutableIntListOf(int i6, int i7) {
        MutableIntList mutableIntList = new MutableIntList(2);
        mutableIntList.add(i6);
        mutableIntList.add(i7);
        return mutableIntList;
    }

    @NotNull
    public static final IntList intListOf(@NotNull int... elements) {
        g0.p(elements, "elements");
        MutableIntList mutableIntList = new MutableIntList(elements.length);
        mutableIntList.plusAssign(elements);
        return mutableIntList;
    }

    @NotNull
    public static final MutableIntList mutableIntListOf(int i6, int i7, int i8) {
        MutableIntList mutableIntList = new MutableIntList(3);
        mutableIntList.add(i6);
        mutableIntList.add(i7);
        mutableIntList.add(i8);
        return mutableIntList;
    }

    @NotNull
    public static final MutableIntList mutableIntListOf(@NotNull int... elements) {
        g0.p(elements, "elements");
        MutableIntList mutableIntList = new MutableIntList(elements.length);
        mutableIntList.plusAssign(elements);
        return mutableIntList;
    }
}
