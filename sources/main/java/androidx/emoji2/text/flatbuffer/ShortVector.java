package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import kotlin.j1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ShortVector extends BaseVector {
    public ShortVector __assign(int i6, ByteBuffer byteBuffer) {
        __reset(i6, 2, byteBuffer);
        return this;
    }

    public short get(int i6) {
        return this.bb.getShort(__element(i6));
    }

    public int getAsUnsigned(int i6) {
        return get(i6) & j1.f43986d;
    }
}
