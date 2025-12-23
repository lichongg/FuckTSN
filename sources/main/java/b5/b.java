package b5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends org.apache.commons.net.discard.b {

    /* renamed from: j, reason: collision with root package name */
    public static final int f1036j = 7;

    /* renamed from: i, reason: collision with root package name */
    private final DatagramPacket f1037i = new DatagramPacket(new byte[0], 0);

    @Override // org.apache.commons.net.discard.b
    public void p(byte[] bArr, int i6, InetAddress inetAddress) throws IOException {
        q(bArr, i6, inetAddress, 7);
    }

    @Override // org.apache.commons.net.discard.b
    public void r(byte[] bArr, InetAddress inetAddress) throws IOException {
        q(bArr, bArr.length, inetAddress, 7);
    }

    public int s(byte[] bArr) throws IOException {
        return t(bArr, bArr.length);
    }

    public int t(byte[] bArr, int i6) throws IOException {
        this.f1037i.setData(bArr);
        this.f1037i.setLength(i6);
        this.f50541c.receive(this.f1037i);
        return this.f1037i.getLength();
    }
}
