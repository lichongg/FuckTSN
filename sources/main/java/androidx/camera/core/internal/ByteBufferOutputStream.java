package androidx.camera.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class ByteBufferOutputStream extends OutputStream {
    private final ByteBuffer mByteBuffer;

    @Override // java.io.OutputStream
    public void write(int i6) throws IOException {
        if (!this.mByteBuffer.hasRemaining()) {
            throw new EOFException("Output ByteBuffer has no bytes remaining.");
        }
        this.mByteBuffer.put((byte) i6);
    }

    public ByteBufferOutputStream(@NonNull ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) throws IOException {
        int i8;
        bArr.getClass();
        if (i6 < 0 || i6 > bArr.length || i7 < 0 || (i8 = i6 + i7) > bArr.length || i8 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i7 == 0) {
            return;
        }
        if (this.mByteBuffer.remaining() >= i7) {
            this.mByteBuffer.put(bArr, i6, i7);
            return;
        }
        throw new EOFException("Output ByteBuffer has insufficient bytes remaining.");
    }
}
