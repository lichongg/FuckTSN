package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class StringVector extends BaseVector {
    private Utf8 utf8 = Utf8.getDefault();

    public StringVector __assign(int i6, int i7, ByteBuffer byteBuffer) {
        __reset(i6, i7, byteBuffer);
        return this;
    }

    public String get(int i6) {
        return Table.__string(__element(i6), this.bb, this.utf8);
    }
}
