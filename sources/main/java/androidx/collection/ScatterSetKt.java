package androidx.collection;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nScatterSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterSet.kt\nandroidx/collection/ScatterSetKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1100:1\n1#2:1101\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ScatterSetKt {

    @NotNull
    private static final MutableScatterSet<Object> EmptyScatterSet = new MutableScatterSet<>(0);

    @NotNull
    public static final <E> MutableScatterSet<E> mutableScatterSetOf() {
        return new MutableScatterSet<>(0, 1, null);
    }

    @NotNull
    public static final <E> ScatterSet<E> scatterSetOf() {
        MutableScatterSet<Object> mutableScatterSet = EmptyScatterSet;
        g0.n(mutableScatterSet, "null cannot be cast to non-null type androidx.collection.ScatterSet<E of androidx.collection.ScatterSetKt.scatterSetOf>");
        return mutableScatterSet;
    }

    @NotNull
    public static final <E> ScatterSet<E> emptyScatterSet() {
        MutableScatterSet<Object> mutableScatterSet = EmptyScatterSet;
        g0.n(mutableScatterSet, "null cannot be cast to non-null type androidx.collection.ScatterSet<E of androidx.collection.ScatterSetKt.emptyScatterSet>");
        return mutableScatterSet;
    }

    @NotNull
    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e6) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(1);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e6);
        return mutableScatterSet;
    }

    @NotNull
    public static final <E> ScatterSet<E> scatterSetOf(E e6) {
        return mutableScatterSetOf(e6);
    }

    @NotNull
    public static final <E> ScatterSet<E> scatterSetOf(E e6, E e7) {
        return mutableScatterSetOf(e6, e7);
    }

    @NotNull
    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e6, E e7) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(2);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e6);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e7);
        return mutableScatterSet;
    }

    @NotNull
    public static final <E> ScatterSet<E> scatterSetOf(E e6, E e7, E e8) {
        return mutableScatterSetOf(e6, e7, e8);
    }

    @NotNull
    public static final <E> ScatterSet<E> scatterSetOf(@NotNull E... elements) {
        g0.p(elements, "elements");
        MutableScatterSet mutableScatterSet = new MutableScatterSet(elements.length);
        mutableScatterSet.plusAssign((Object[]) elements);
        return mutableScatterSet;
    }

    @NotNull
    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e6, E e7, E e8) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(3);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e6);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e7);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e8);
        return mutableScatterSet;
    }

    @NotNull
    public static final <E> MutableScatterSet<E> mutableScatterSetOf(@NotNull E... elements) {
        g0.p(elements, "elements");
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(elements.length);
        mutableScatterSet.plusAssign((Object[]) elements);
        return mutableScatterSet;
    }
}
