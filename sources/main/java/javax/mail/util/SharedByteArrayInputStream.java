package javax.mail.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.mail.internet.SharedInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class SharedByteArrayInputStream extends ByteArrayInputStream implements SharedInputStream {
    protected int start;

    public SharedByteArrayInputStream(byte[] bArr) {
        super(bArr);
        this.start = 0;
    }

    @Override // javax.mail.internet.SharedInputStream
    public long getPosition() {
        return ((ByteArrayInputStream) this).pos - this.start;
    }

    @Override // javax.mail.internet.SharedInputStream
    public InputStream newStream(long j6, long j7) {
        if (j6 < 0) {
            throw new IllegalArgumentException("start < 0");
        }
        if (j7 == -1) {
            j7 = ((ByteArrayInputStream) this).count - this.start;
        }
        return new SharedByteArrayInputStream(((ByteArrayInputStream) this).buf, this.start + ((int) j6), (int) (j7 - j6));
    }

    public SharedByteArrayInputStream(byte[] bArr, int i6, int i7) {
        super(bArr, i6, i7);
        this.start = i6;
    }
}
