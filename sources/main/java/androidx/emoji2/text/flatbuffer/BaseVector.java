package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class BaseVector {
    protected ByteBuffer bb;
    private int element_size;
    private int length;
    private int vector;

    public void reset() {
        __reset(0, 0, null);
    }

    protected int __element(int i6) {
        return this.vector + (i6 * this.element_size);
    }

    protected void __reset(int i6, int i7, ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        if (byteBuffer != null) {
            this.vector = i6;
            this.length = byteBuffer.getInt(i6 - 4);
            this.element_size = i7;
        } else {
            this.vector = 0;
            this.length = 0;
            this.element_size = 0;
        }
    }

    protected int __vector() {
        return this.vector;
    }

    public int length() {
        return this.length;
    }
}
