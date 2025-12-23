package io.netty.handler.codec.marshalling;

import java.io.IOException;
import org.jboss.marshalling.ByteInput;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class LimitingByteInput implements ByteInput {
    private static final TooBigObjectException EXCEPTION = new TooBigObjectException();
    private final ByteInput input;
    private final long limit;
    private long read;

    private int readable(int i6) {
        return (int) Math.min(i6, this.limit - this.read);
    }

    public int read() throws IOException {
        if (readable(1) <= 0) {
            throw EXCEPTION;
        }
        int read = this.input.read();
        this.read++;
        return read;
    }

    public long skip(long j6) throws IOException {
        int readable = readable((int) j6);
        if (readable <= 0) {
            throw EXCEPTION;
        }
        long skip = this.input.skip(readable);
        this.read += skip;
        return skip;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TooBigObjectException extends IOException {
        private static final long serialVersionUID = 1;

        TooBigObjectException() {
        }
    }

    public int available() throws IOException {
        return readable(this.input.available());
    }

    LimitingByteInput(ByteInput byteInput, long j6) {
        if (j6 > 0) {
            this.input = byteInput;
            this.limit = j6;
            return;
        }
        throw new IllegalArgumentException("The limit MUST be > 0");
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i6, int i7) throws IOException {
        int readable = readable(i7);
        if (readable > 0) {
            int read = this.input.read(bArr, i6, readable);
            this.read += read;
            return read;
        }
        throw EXCEPTION;
    }

    public void close() throws IOException {
    }
}
