package androidx.collection;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFloatList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatList.kt\nandroidx/collection/FloatListKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 FloatList.kt\nandroidx/collection/MutableFloatList\n*L\n1#1,969:1\n1#2:970\n713#3,2:971\n713#3,2:973\n713#3,2:975\n713#3,2:977\n713#3,2:979\n713#3,2:981\n*S KotlinDebug\n*F\n+ 1 FloatList.kt\nandroidx/collection/FloatListKt\n*L\n938#1:971,2\n947#1:973,2\n948#1:975,2\n958#1:977,2\n959#1:979,2\n960#1:981,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class FloatListKt {

    @NotNull
    private static final FloatList EmptyFloatList = new MutableFloatList(0);

    @NotNull
    public static final FloatList floatListOf() {
        return EmptyFloatList;
    }

    @NotNull
    public static final MutableFloatList mutableFloatListOf() {
        return new MutableFloatList(0, 1, null);
    }

    @NotNull
    public static final FloatList emptyFloatList() {
        return EmptyFloatList;
    }

    @NotNull
    public static final FloatList floatListOf(float f6) {
        return mutableFloatListOf(f6);
    }

    @NotNull
    public static final MutableFloatList mutableFloatListOf(float f6) {
        MutableFloatList mutableFloatList = new MutableFloatList(1);
        mutableFloatList.add(f6);
        return mutableFloatList;
    }

    @NotNull
    public static final FloatList floatListOf(float f6, float f7) {
        return mutableFloatListOf(f6, f7);
    }

    @NotNull
    public static final FloatList floatListOf(float f6, float f7, float f8) {
        return mutableFloatListOf(f6, f7, f8);
    }

    @NotNull
    public static final MutableFloatList mutableFloatListOf(float f6, float f7) {
        MutableFloatList mutableFloatList = new MutableFloatList(2);
        mutableFloatList.add(f6);
        mutableFloatList.add(f7);
        return mutableFloatList;
    }

    @NotNull
    public static final FloatList floatListOf(@NotNull float... elements) {
        g0.p(elements, "elements");
        MutableFloatList mutableFloatList = new MutableFloatList(elements.length);
        mutableFloatList.plusAssign(elements);
        return mutableFloatList;
    }

    @NotNull
    public static final MutableFloatList mutableFloatListOf(float f6, float f7, float f8) {
        MutableFloatList mutableFloatList = new MutableFloatList(3);
        mutableFloatList.add(f6);
        mutableFloatList.add(f7);
        mutableFloatList.add(f8);
        return mutableFloatList;
    }

    @NotNull
    public static final MutableFloatList mutableFloatListOf(@NotNull float... elements) {
        g0.p(elements, "elements");
        MutableFloatList mutableFloatList = new MutableFloatList(elements.length);
        mutableFloatList.plusAssign(elements);
        return mutableFloatList;
    }
}
