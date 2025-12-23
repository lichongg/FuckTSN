package org.apache.commons.net.tftp;

import java.net.DatagramPacket;
import java.net.InetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b extends f {

    /* renamed from: k, reason: collision with root package name */
    int f51196k;

    public b(InetAddress inetAddress, int i6, int i7) {
        super(4, inetAddress, i6);
        this.f51196k = i7;
    }

    @Override // org.apache.commons.net.tftp.f
    DatagramPacket a(DatagramPacket datagramPacket, byte[] bArr) {
        bArr[0] = 0;
        bArr[1] = (byte) this.f51224a;
        int i6 = this.f51196k;
        bArr[2] = (byte) ((65535 & i6) >> 8);
        bArr[3] = (byte) (i6 & 255);
        datagramPacket.setAddress(this.f51226c);
        datagramPacket.setPort(this.f51225b);
        datagramPacket.setData(bArr);
        datagramPacket.setLength(4);
        return datagramPacket;
    }

    @Override // org.apache.commons.net.tftp.f
    public DatagramPacket d() {
        byte b6 = (byte) this.f51224a;
        int i6 = this.f51196k;
        return new DatagramPacket(new byte[]{0, b6, (byte) ((65535 & i6) >> 8), (byte) (i6 & 255)}, 4, this.f51226c, this.f51225b);
    }

    public int h() {
        return this.f51196k;
    }

    public void i(int i6) {
        this.f51196k = i6;
    }

    @Override // org.apache.commons.net.tftp.f
    public String toString() {
        return super.toString() + " ACK " + this.f51196k;
    }

    b(DatagramPacket datagramPacket) throws TFTPPacketException {
        super(4, datagramPacket.getAddress(), datagramPacket.getPort());
        byte[] data = datagramPacket.getData();
        if (getType() == data[1]) {
            this.f51196k = (data[3] & 255) | ((data[2] & 255) << 8);
            return;
        }
        throw new TFTPPacketException("TFTP operator code does not match type.");
    }
}
