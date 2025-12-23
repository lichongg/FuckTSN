package org.apache.commons.net.ntp;

import java.net.DatagramPacket;
import java.util.Arrays;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c implements d {
    private static final int A = 0;
    private static final int B = 0;
    private static final int C = 3;
    private static final int D = 0;
    private static final int E = 6;
    private static final int F = 1;
    private static final int G = 2;
    private static final int H = 3;
    private static final int I = 4;
    private static final int J = 8;
    private static final int K = 12;
    private static final int L = 16;
    private static final int M = 24;
    private static final int N = 32;
    private static final int O = 40;

    /* renamed from: z, reason: collision with root package name */
    private static final int f50957z = 0;

    /* renamed from: x, reason: collision with root package name */
    private final byte[] f50958x = new byte[48];

    /* renamed from: y, reason: collision with root package name */
    private volatile DatagramPacket f50959y;

    private void K(int i6, int i7) {
        for (int i8 = 3; i8 >= 0; i8--) {
            this.f50958x[i6 + i8] = (byte) (i7 & 255);
            i7 >>>= 8;
        }
    }

    @Override // org.apache.commons.net.ntp.d
    public synchronized DatagramPacket s() {
        try {
            if (this.f50959y == null) {
                byte[] bArr = this.f50958x;
                this.f50959y = new DatagramPacket(bArr, bArr.length);
                this.f50959y.setPort(123);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f50959y;
    }

    @Override // org.apache.commons.net.ntp.d
    public void u(int i6) {
        K(4, i6);
    }

    @Override // org.apache.commons.net.ntp.d
    public int y() {
        return E(4);
    }

    private int E(int i6) {
        return M(this.f50958x[i6 + 3]) | (M(this.f50958x[i6]) << 24) | (M(this.f50958x[i6 + 1]) << 16) | (M(this.f50958x[i6 + 2]) << 8);
    }

    private long F(int i6) {
        return (N(this.f50958x[i6]) << 56) | (N(this.f50958x[i6 + 1]) << 48) | (N(this.f50958x[i6 + 2]) << 40) | (N(this.f50958x[i6 + 3]) << 32) | (N(this.f50958x[i6 + 4]) << 24) | (N(this.f50958x[i6 + 5]) << 16) | (N(this.f50958x[i6 + 6]) << 8) | N(this.f50958x[i6 + 7]);
    }

    private TimeStamp G(int i6) {
        return new TimeStamp(F(i6));
    }

    private String I() {
        return M(this.f50958x[12]) + "." + M(this.f50958x[13]) + "." + M(this.f50958x[14]) + "." + M(this.f50958x[15]);
    }

    private String J() {
        char c6;
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 <= 3 && (c6 = (char) this.f50958x[i6 + 12]) != 0; i6++) {
            sb.append(c6);
        }
        return sb.toString();
    }

    private void L(int i6, TimeStamp timeStamp) {
        long ntpValue = timeStamp == null ? 0L : timeStamp.ntpValue();
        for (int i7 = 7; i7 >= 0; i7--) {
            this.f50958x[i6 + i7] = (byte) (255 & ntpValue);
            ntpValue >>>= 8;
        }
    }

    protected static final int M(byte b6) {
        return b6 & 255;
    }

    protected static final long N(byte b6) {
        return b6 & 255;
    }

    @Override // org.apache.commons.net.ntp.d
    public void B(int i6) {
        this.f50958x[2] = (byte) (i6 & 255);
    }

    @Override // org.apache.commons.net.ntp.d
    public TimeStamp C() {
        return G(40);
    }

    @Override // org.apache.commons.net.ntp.d
    public void D(DatagramPacket datagramPacket) {
        if (datagramPacket == null || datagramPacket.getLength() < this.f50958x.length) {
            throw new IllegalArgumentException();
        }
        byte[] data = datagramPacket.getData();
        int length = datagramPacket.getLength();
        byte[] bArr = this.f50958x;
        if (length > bArr.length) {
            length = bArr.length;
        }
        System.arraycopy(data, 0, bArr, 0, length);
        DatagramPacket s5 = s();
        s5.setAddress(datagramPacket.getAddress());
        int port = datagramPacket.getPort();
        if (port <= 0) {
            port = 123;
        }
        s5.setPort(port);
        s5.setData(this.f50958x);
    }

    @Override // org.apache.commons.net.ntp.d
    public int a() {
        return this.f50958x[3];
    }

    @Override // org.apache.commons.net.ntp.d
    public int b() {
        return E(12);
    }

    @Override // org.apache.commons.net.ntp.d
    public int d() {
        return (M(this.f50958x[0]) >> 6) & 3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f50958x, ((c) obj).f50958x);
    }

    @Override // org.apache.commons.net.ntp.d
    public void f(int i6) {
        byte[] bArr = this.f50958x;
        bArr[0] = (byte) (((i6 & 3) << 6) | (bArr[0] & Utf8.REPLACEMENT_BYTE));
    }

    @Override // org.apache.commons.net.ntp.d
    public TimeStamp g() {
        return G(24);
    }

    @Override // org.apache.commons.net.ntp.d
    public int getMode() {
        return M(this.f50958x[0]) & 7;
    }

    @Override // org.apache.commons.net.ntp.d
    public String getType() {
        return d.f50979t;
    }

    @Override // org.apache.commons.net.ntp.d
    public int getVersion() {
        return (M(this.f50958x[0]) >> 3) & 7;
    }

    @Override // org.apache.commons.net.ntp.d
    public void h(int i6) {
        this.f50958x[3] = (byte) (i6 & 255);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f50958x);
    }

    @Override // org.apache.commons.net.ntp.d
    public void i(TimeStamp timeStamp) {
        L(24, timeStamp);
    }

    @Override // org.apache.commons.net.ntp.d
    public int j() {
        return this.f50958x[2];
    }

    @Override // org.apache.commons.net.ntp.d
    public void k(TimeStamp timeStamp) {
        L(32, timeStamp);
    }

    @Override // org.apache.commons.net.ntp.d
    public void l(TimeStamp timeStamp) {
        L(16, timeStamp);
    }

    @Override // org.apache.commons.net.ntp.d
    public void o(int i6) {
        byte[] bArr = this.f50958x;
        bArr[0] = (byte) ((i6 & 7) | (bArr[0] & 248));
    }

    @Override // org.apache.commons.net.ntp.d
    public int p() {
        return E(8);
    }

    @Override // org.apache.commons.net.ntp.d
    public TimeStamp q() {
        return G(16);
    }

    @Override // org.apache.commons.net.ntp.d
    public void r(int i6) {
        K(8, i6);
    }

    @Override // org.apache.commons.net.ntp.d
    public void setVersion(int i6) {
        byte[] bArr = this.f50958x;
        bArr[0] = (byte) (((i6 & 7) << 3) | (bArr[0] & 199));
    }

    @Override // org.apache.commons.net.ntp.d
    public TimeStamp t() {
        return G(32);
    }

    public String toString() {
        return "[version:" + getVersion() + ", mode:" + getMode() + ", poll:" + j() + ", precision:" + a() + ", delay:" + y() + ", dispersion(ms):" + c() + ", id:" + n() + ", xmitTime:" + C().toDateString() + " ]";
    }

    @Override // org.apache.commons.net.ntp.d
    public int v() {
        return M(this.f50958x[1]);
    }

    @Override // org.apache.commons.net.ntp.d
    public void w(TimeStamp timeStamp) {
        L(40, timeStamp);
    }

    @Override // org.apache.commons.net.ntp.d
    public void x(int i6) {
        this.f50958x[1] = (byte) (i6 & 255);
    }

    @Override // org.apache.commons.net.ntp.d
    public void z(int i6) {
        K(12, i6);
    }

    private String H() {
        return Integer.toHexString(b());
    }

    @Override // org.apache.commons.net.ntp.d
    public double A() {
        return y() / 65.536d;
    }

    @Override // org.apache.commons.net.ntp.d
    public double c() {
        return p() / 65.536d;
    }

    @Override // org.apache.commons.net.ntp.d
    public long e() {
        return (p() * 1000) / 65536;
    }

    @Override // org.apache.commons.net.ntp.d
    public String m() {
        return b.b(getMode());
    }

    @Override // org.apache.commons.net.ntp.d
    public String n() {
        int version = getVersion();
        int v5 = v();
        if (version == 3 || version == 4) {
            if (v5 != 0 && v5 != 1) {
                if (version == 4) {
                    return H();
                }
            } else {
                return J();
            }
        }
        if (v5 >= 2) {
            return I();
        }
        return H();
    }
}
