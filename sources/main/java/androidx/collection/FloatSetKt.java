package androidx.collection;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFloatSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatSet.kt\nandroidx/collection/FloatSetKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,853:1\n1#2:854\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class FloatSetKt {

    @NotNull
    private static final MutableFloatSet EmptyFloatSet = new MutableFloatSet(0);

    @NotNull
    private static final float[] EmptyFloatArray = new float[0];

    @NotNull
    public static final FloatSet floatSetOf() {
        return EmptyFloatSet;
    }

    @NotNull
    public static final MutableFloatSet mutableFloatSetOf() {
        return new MutableFloatSet(0, 1, null);
    }

    @NotNull
    public static final FloatSet emptyFloatSet() {
        return EmptyFloatSet;
    }

    @NotNull
    public static final FloatSet floatSetOf(float f6) {
        return mutableFloatSetOf(f6);
    }

    @NotNull
    public static final float[] getEmptyFloatArray() {
        return EmptyFloatArray;
    }

    @NotNull
    public static final MutableFloatSet mutableFloatSetOf(float f6) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(1);
        mutableFloatSet.plusAssign(f6);
        return mutableFloatSet;
    }

    @NotNull
    public static final FloatSet floatSetOf(float f6, float f7) {
        return mutableFloatSetOf(f6, f7);
    }

    public static final int hash(float f6) {
        int floatToIntBits = Float.floatToIntBits(f6) * ScatterMapKt.MurmurHashC1;
        return floatToIntBits ^ (floatToIntBits << 16);
    }

    @NotNull
    public static final FloatSet floatSetOf(float f6, float f7, float f8) {
        return mutableFloatSetOf(f6, f7, f8);
    }

    @NotNull
    public static final MutableFloatSet mutableFloatSetOf(float f6, float f7) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(2);
        mutableFloatSet.plusAssign(f6);
        mutableFloatSet.plusAssign(f7);
        return mutableFloatSet;
    }

    @NotNull
    public static final FloatSet floatSetOf(@NotNull float... elements) {
        g0.p(elements, "elements");
        MutableFloatSet mutableFloatSet = new MutableFloatSet(elements.length);
        mutableFloatSet.plusAssign(elements);
        return mutableFloatSet;
    }

    @NotNull
    public static final MutableFloatSet mutableFloatSetOf(float f6, float f7, float f8) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(3);
        mutableFloatSet.plusAssign(f6);
        mutableFloatSet.plusAssign(f7);
        mutableFloatSet.plusAssign(f8);
        return mutableFloatSet;
    }

    @NotNull
    public static final MutableFloatSet mutableFloatSetOf(@NotNull float... elements) {
        g0.p(elements, "elements");
        MutableFloatSet mutableFloatSet = new MutableFloatSet(elements.length);
        mutableFloatSet.plusAssign(elements);
        return mutableFloatSet;
    }
}
