package androidx.collection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PackingUtilsKt {
    public static final long packInts(int i6, int i7) {
        return (i7 & 4294967295L) | (i6 << 32);
    }

    public static final long packFloats(float f6, float f7) {
        return (Float.floatToRawIntBits(f7) & 4294967295L) | (Float.floatToRawIntBits(f6) << 32);
    }
}
