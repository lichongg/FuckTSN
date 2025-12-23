package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class FloatVector extends BaseVector {
    public FloatVector __assign(int i6, ByteBuffer byteBuffer) {
        __reset(i6, 4, byteBuffer);
        return this;
    }

    public float get(int i6) {
        return this.bb.getFloat(__element(i6));
    }
}
