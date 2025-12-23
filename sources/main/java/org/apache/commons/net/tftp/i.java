package org.apache.commons.net.tftp;

import java.net.DatagramPacket;
import java.net.InetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class i extends h {
    public i(InetAddress inetAddress, int i6, String str, int i7) {
        super(inetAddress, i6, 2, str, i7);
    }

    i(DatagramPacket datagramPacket) throws TFTPPacketException {
        super(2, datagramPacket);
    }

    @Override // org.apache.commons.net.tftp.f
    public String toString() {
        return super.toString() + " WRQ " + h() + " " + a.u(i());
    }
}
