package org.apache.commons.net.tftp;

import java.net.DatagramPacket;
import java.net.InetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class d extends f {

    /* renamed from: o, reason: collision with root package name */
    public static final int f51201o = 512;

    /* renamed from: p, reason: collision with root package name */
    public static final int f51202p = 0;

    /* renamed from: k, reason: collision with root package name */
    int f51203k;

    /* renamed from: l, reason: collision with root package name */
    int f51204l;

    /* renamed from: m, reason: collision with root package name */
    int f51205m;

    /* renamed from: n, reason: collision with root package name */
    byte[] f51206n;

    public d(InetAddress inetAddress, int i6, int i7, byte[] bArr, int i8, int i9) {
        super(3, inetAddress, i6);
        this.f51203k = i7;
        this.f51206n = bArr;
        this.f51205m = i8;
        if (i9 > 512) {
            this.f51204l = 512;
        } else {
            this.f51204l = i9;
        }
    }

    @Override // org.apache.commons.net.tftp.f
    DatagramPacket a(DatagramPacket datagramPacket, byte[] bArr) {
        bArr[0] = 0;
        bArr[1] = (byte) this.f51224a;
        int i6 = this.f51203k;
        bArr[2] = (byte) ((65535 & i6) >> 8);
        bArr[3] = (byte) (i6 & 255);
        byte[] bArr2 = this.f51206n;
        if (bArr != bArr2) {
            System.arraycopy(bArr2, this.f51205m, bArr, 4, this.f51204l);
        }
        datagramPacket.setAddress(this.f51226c);
        datagramPacket.setPort(this.f51225b);
        datagramPacket.setData(bArr);
        datagramPacket.setLength(this.f51204l + 4);
        return datagramPacket;
    }

    @Override // org.apache.commons.net.tftp.f
    public DatagramPacket d() {
        int i6 = this.f51204l;
        byte[] bArr = new byte[i6 + 4];
        bArr[0] = 0;
        bArr[1] = (byte) this.f51224a;
        int i7 = this.f51203k;
        bArr[2] = (byte) ((65535 & i7) >> 8);
        bArr[3] = (byte) (i7 & 255);
        System.arraycopy(this.f51206n, this.f51205m, bArr, 4, i6);
        return new DatagramPacket(bArr, this.f51204l + 4, this.f51226c, this.f51225b);
    }

    public int h() {
        return this.f51203k;
    }

    public byte[] i() {
        return this.f51206n;
    }

    public int j() {
        return this.f51204l;
    }

    public int k() {
        return this.f51205m;
    }

    public void l(int i6) {
        this.f51203k = i6;
    }

    public void m(byte[] bArr, int i6, int i7) {
        this.f51206n = bArr;
        this.f51205m = i6;
        this.f51204l = i7;
        if (i7 > 512) {
            this.f51204l = 512;
        } else {
            this.f51204l = i7;
        }
    }

    @Override // org.apache.commons.net.tftp.f
    public String toString() {
        return super.toString() + " DATA " + this.f51203k + " " + this.f51204l;
    }

    public d(InetAddress inetAddress, int i6, int i7, byte[] bArr) {
        this(inetAddress, i6, i7, bArr, 0, bArr.length);
    }

    d(DatagramPacket datagramPacket) throws TFTPPacketException {
        super(3, datagramPacket.getAddress(), datagramPacket.getPort());
        this.f51206n = datagramPacket.getData();
        this.f51205m = 4;
        int type = getType();
        byte[] bArr = this.f51206n;
        if (type == bArr[1]) {
            this.f51203k = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
            int length = datagramPacket.getLength() - 4;
            this.f51204l = length;
            if (length > 512) {
                this.f51204l = 512;
                return;
            }
            return;
        }
        throw new TFTPPacketException("TFTP operator code does not match type.");
    }
}
