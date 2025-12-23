package d5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b extends org.apache.commons.net.a {

    /* renamed from: i, reason: collision with root package name */
    public static final int f42992i = 37;

    /* renamed from: j, reason: collision with root package name */
    public static final long f42993j = 2208988800L;

    /* renamed from: g, reason: collision with root package name */
    private final byte[] f42994g = new byte[1];

    /* renamed from: h, reason: collision with root package name */
    private final byte[] f42995h = new byte[4];

    public Date p(InetAddress inetAddress) throws IOException {
        return new Date((s(inetAddress, 37) - 2208988800L) * 1000);
    }

    public Date q(InetAddress inetAddress, int i6) throws IOException {
        return new Date((s(inetAddress, i6) - 2208988800L) * 1000);
    }

    public long r(InetAddress inetAddress) throws IOException {
        return s(inetAddress, 37);
    }

    public long s(InetAddress inetAddress, int i6) throws IOException {
        byte[] bArr = this.f42994g;
        DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, inetAddress, i6);
        byte[] bArr2 = this.f42995h;
        DatagramPacket datagramPacket2 = new DatagramPacket(bArr2, bArr2.length);
        this.f50541c.send(datagramPacket);
        this.f50541c.receive(datagramPacket2);
        byte[] bArr3 = this.f42995h;
        return (bArr3[3] & 255 & 4294967295L) | (((bArr3[0] & 255) << 24) & 4294967295L) | (((bArr3[1] & 255) << 16) & 4294967295L) | (((bArr3[2] & 255) << 8) & 4294967295L);
    }
}
