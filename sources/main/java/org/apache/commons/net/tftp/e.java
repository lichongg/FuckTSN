package org.apache.commons.net.tftp;

import java.net.DatagramPacket;
import java.net.InetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class e extends f {

    /* renamed from: m, reason: collision with root package name */
    public static final int f51207m = 0;

    /* renamed from: n, reason: collision with root package name */
    public static final int f51208n = 1;

    /* renamed from: o, reason: collision with root package name */
    public static final int f51209o = 2;

    /* renamed from: p, reason: collision with root package name */
    public static final int f51210p = 3;

    /* renamed from: q, reason: collision with root package name */
    public static final int f51211q = 4;

    /* renamed from: r, reason: collision with root package name */
    public static final int f51212r = 5;

    /* renamed from: s, reason: collision with root package name */
    public static final int f51213s = 6;

    /* renamed from: t, reason: collision with root package name */
    public static final int f51214t = 7;

    /* renamed from: k, reason: collision with root package name */
    int f51215k;

    /* renamed from: l, reason: collision with root package name */
    String f51216l;

    public e(InetAddress inetAddress, int i6, int i7, String str) {
        super(5, inetAddress, i6);
        this.f51215k = i7;
        this.f51216l = str;
    }

    @Override // org.apache.commons.net.tftp.f
    DatagramPacket a(DatagramPacket datagramPacket, byte[] bArr) {
        int length = this.f51216l.length();
        bArr[0] = 0;
        bArr[1] = (byte) this.f51224a;
        int i6 = this.f51215k;
        bArr[2] = (byte) ((65535 & i6) >> 8);
        bArr[3] = (byte) (i6 & 255);
        System.arraycopy(this.f51216l.getBytes(), 0, bArr, 4, length);
        int i7 = length + 4;
        bArr[i7] = 0;
        datagramPacket.setAddress(this.f51226c);
        datagramPacket.setPort(this.f51225b);
        datagramPacket.setData(bArr);
        datagramPacket.setLength(i7);
        return datagramPacket;
    }

    @Override // org.apache.commons.net.tftp.f
    public DatagramPacket d() {
        int length = this.f51216l.length();
        int i6 = length + 5;
        byte[] bArr = new byte[i6];
        bArr[0] = 0;
        bArr[1] = (byte) this.f51224a;
        int i7 = this.f51215k;
        bArr[2] = (byte) ((65535 & i7) >> 8);
        bArr[3] = (byte) (i7 & 255);
        System.arraycopy(this.f51216l.getBytes(), 0, bArr, 4, length);
        bArr[length + 4] = 0;
        return new DatagramPacket(bArr, i6, this.f51226c, this.f51225b);
    }

    public int h() {
        return this.f51215k;
    }

    public String i() {
        return this.f51216l;
    }

    @Override // org.apache.commons.net.tftp.f
    public String toString() {
        return super.toString() + " ERR " + this.f51215k + " " + this.f51216l;
    }

    e(DatagramPacket datagramPacket) throws TFTPPacketException {
        super(5, datagramPacket.getAddress(), datagramPacket.getPort());
        byte[] data = datagramPacket.getData();
        int length = datagramPacket.getLength();
        if (getType() == data[1]) {
            this.f51215k = ((data[2] & 255) << 8) | (data[3] & 255);
            if (length >= 5) {
                StringBuilder sb = new StringBuilder();
                for (int i6 = 4; i6 < length; i6++) {
                    byte b6 = data[i6];
                    if (b6 == 0) {
                        break;
                    }
                    sb.append((char) b6);
                }
                this.f51216l = sb.toString();
                return;
            }
            throw new TFTPPacketException("Bad error packet. No message.");
        }
        throw new TFTPPacketException("TFTP operator code does not match type.");
    }
}
