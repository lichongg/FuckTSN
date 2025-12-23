package androidx.collection;

import androidx.camera.camera2.internal.compat.params.e;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmInline
@SourceDebugExtension({"SMAP\nFloatFloatPair.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatFloatPair.kt\nandroidx/collection/FloatFloatPair\n+ 2 PackingUtils.kt\nandroidx/collection/PackingUtilsKt\n+ 3 PackingHelpers.jvm.kt\nandroidx/collection/internal/PackingHelpers_jvmKt\n*L\n1#1,85:1\n48#1:93\n54#1:95\n24#2,3:86\n22#3:89\n22#3:90\n22#3:91\n22#3:92\n22#3:94\n*S KotlinDebug\n*F\n+ 1 FloatFloatPair.kt\nandroidx/collection/FloatFloatPair\n*L\n83#1:93\n83#1:95\n42#1:86,3\n48#1:89\n54#1:90\n67#1:91\n81#1:92\n83#1:94\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class FloatFloatPair {

    @JvmField
    public final long packedValue;

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5constructorimpl(long j6) {
        return j6;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FloatFloatPair m1boximpl(long j6) {
        return new FloatFloatPair(j6);
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m2component1impl(long j6) {
        return Float.intBitsToFloat((int) (j6 >> 32));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m4constructorimpl(float f6, float f7) {
        return m5constructorimpl((Float.floatToRawIntBits(f7) & 4294967295L) | (Float.floatToRawIntBits(f6) << 32));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m6equalsimpl(long j6, Object obj) {
        return (obj instanceof FloatFloatPair) && j6 == ((FloatFloatPair) obj).m12unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7equalsimpl0(long j6, long j7) {
        return j6 == j7;
    }

    /* renamed from: getFirst-impl, reason: not valid java name */
    public static final float m8getFirstimpl(long j6) {
        return Float.intBitsToFloat((int) (j6 >> 32));
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m11toStringimpl(long j6) {
        return '(' + Float.intBitsToFloat((int) (j6 >> 32)) + ", " + Float.intBitsToFloat((int) (j6 & 4294967295L)) + ')';
    }

    public boolean equals(Object obj) {
        return m6equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m10hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m11toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m12unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ FloatFloatPair(long j6) {
        this.packedValue = j6;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m10hashCodeimpl(long j6) {
        return e.a(j6);
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m3component2impl(long j6) {
        return Float.intBitsToFloat((int) (j6 & 4294967295L));
    }

    /* renamed from: getSecond-impl, reason: not valid java name */
    public static final float m9getSecondimpl(long j6) {
        return Float.intBitsToFloat((int) (j6 & 4294967295L));
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }
}
