package z4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b extends org.apache.commons.net.a {

    /* renamed from: j, reason: collision with root package name */
    public static final int f56830j = 11;

    /* renamed from: k, reason: collision with root package name */
    public static final int f56831k = 15;

    /* renamed from: l, reason: collision with root package name */
    public static final int f56832l = 17;

    /* renamed from: m, reason: collision with root package name */
    public static final int f56833m = 19;

    /* renamed from: n, reason: collision with root package name */
    public static final int f56834n = 19;

    /* renamed from: g, reason: collision with root package name */
    private final byte[] f56835g;

    /* renamed from: h, reason: collision with root package name */
    private final DatagramPacket f56836h;

    /* renamed from: i, reason: collision with root package name */
    private final DatagramPacket f56837i = new DatagramPacket(new byte[0], 0);

    public byte[] p() throws IOException {
        this.f50541c.receive(this.f56836h);
        int length = this.f56836h.getLength();
        byte[] bArr = new byte[length];
        System.arraycopy(this.f56835g, 0, bArr, 0, length);
        return bArr;
    }

    public void q(InetAddress inetAddress) throws IOException {
        r(inetAddress, 19);
    }

    public void r(InetAddress inetAddress, int i6) throws IOException {
        this.f56837i.setAddress(inetAddress);
        this.f56837i.setPort(i6);
        this.f50541c.send(this.f56837i);
    }

    public b() {
        byte[] bArr = new byte[512];
        this.f56835g = bArr;
        this.f56836h = new DatagramPacket(bArr, bArr.length);
    }
}
