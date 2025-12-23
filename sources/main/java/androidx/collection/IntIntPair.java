package androidx.collection;

import androidx.camera.camera2.internal.compat.params.e;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmInline
@SourceDebugExtension({"SMAP\nIntIntPair.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntIntPair.kt\nandroidx/collection/IntIntPair\n+ 2 PackingUtils.kt\nandroidx/collection/PackingUtilsKt\n*L\n1#1,83:1\n33#2:84\n*S KotlinDebug\n*F\n+ 1 IntIntPair.kt\nandroidx/collection/IntIntPair\n*L\n41#1:84\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class IntIntPair {

    @JvmField
    public final long packedValue;

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m17constructorimpl(long j6) {
        return j6;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntIntPair m13boximpl(long j6) {
        return new IntIntPair(j6);
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final int m14component1impl(long j6) {
        return (int) (j6 >> 32);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m16constructorimpl(int i6, int i7) {
        return m17constructorimpl((i7 & 4294967295L) | (i6 << 32));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m18equalsimpl(long j6, Object obj) {
        return (obj instanceof IntIntPair) && j6 == ((IntIntPair) obj).m24unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m19equalsimpl0(long j6, long j7) {
        return j6 == j7;
    }

    /* renamed from: getFirst-impl, reason: not valid java name */
    public static final int m20getFirstimpl(long j6) {
        return (int) (j6 >> 32);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m23toStringimpl(long j6) {
        return '(' + m20getFirstimpl(j6) + ", " + m21getSecondimpl(j6) + ')';
    }

    public boolean equals(Object obj) {
        return m18equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m22hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m23toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m24unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ IntIntPair(long j6) {
        this.packedValue = j6;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m22hashCodeimpl(long j6) {
        return e.a(j6);
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final int m15component2impl(long j6) {
        return (int) (j6 & 4294967295L);
    }

    /* renamed from: getSecond-impl, reason: not valid java name */
    public static final int m21getSecondimpl(long j6) {
        return (int) (j6 & 4294967295L);
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }
}
