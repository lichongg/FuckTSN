package androidx.collection;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLongList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongList.kt\nandroidx/collection/LongListKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 LongList.kt\nandroidx/collection/MutableLongList\n*L\n1#1,969:1\n1#2:970\n713#3,2:971\n713#3,2:973\n713#3,2:975\n713#3,2:977\n713#3,2:979\n713#3,2:981\n*S KotlinDebug\n*F\n+ 1 LongList.kt\nandroidx/collection/LongListKt\n*L\n938#1:971,2\n947#1:973,2\n948#1:975,2\n958#1:977,2\n959#1:979,2\n960#1:981,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class LongListKt {

    @NotNull
    private static final LongList EmptyLongList = new MutableLongList(0);

    @NotNull
    public static final LongList longListOf() {
        return EmptyLongList;
    }

    @NotNull
    public static final MutableLongList mutableLongListOf() {
        return new MutableLongList(0, 1, null);
    }

    @NotNull
    public static final LongList emptyLongList() {
        return EmptyLongList;
    }

    @NotNull
    public static final LongList longListOf(long j6) {
        return mutableLongListOf(j6);
    }

    @NotNull
    public static final MutableLongList mutableLongListOf(long j6) {
        MutableLongList mutableLongList = new MutableLongList(1);
        mutableLongList.add(j6);
        return mutableLongList;
    }

    @NotNull
    public static final LongList longListOf(long j6, long j7) {
        return mutableLongListOf(j6, j7);
    }

    @NotNull
    public static final LongList longListOf(long j6, long j7, long j8) {
        return mutableLongListOf(j6, j7, j8);
    }

    @NotNull
    public static final MutableLongList mutableLongListOf(long j6, long j7) {
        MutableLongList mutableLongList = new MutableLongList(2);
        mutableLongList.add(j6);
        mutableLongList.add(j7);
        return mutableLongList;
    }

    @NotNull
    public static final LongList longListOf(@NotNull long... elements) {
        g0.p(elements, "elements");
        MutableLongList mutableLongList = new MutableLongList(elements.length);
        mutableLongList.plusAssign(elements);
        return mutableLongList;
    }

    @NotNull
    public static final MutableLongList mutableLongListOf(long j6, long j7, long j8) {
        MutableLongList mutableLongList = new MutableLongList(3);
        mutableLongList.add(j6);
        mutableLongList.add(j7);
        mutableLongList.add(j8);
        return mutableLongList;
    }

    @NotNull
    public static final MutableLongList mutableLongListOf(@NotNull long... elements) {
        g0.p(elements, "elements");
        MutableLongList mutableLongList = new MutableLongList(elements.length);
        mutableLongList.plusAssign(elements);
        return mutableLongList;
    }
}
