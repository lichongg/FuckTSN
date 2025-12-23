package org.apache.commons.net.discard;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends org.apache.commons.net.a {

    /* renamed from: h, reason: collision with root package name */
    public static final int f50552h = 9;

    /* renamed from: g, reason: collision with root package name */
    DatagramPacket f50553g = new DatagramPacket(new byte[0], 0);

    public void r(byte[] bArr, InetAddress inetAddress) throws IOException {
        q(bArr, bArr.length, inetAddress, 9);
    }

    public void p(byte[] bArr, int i6, InetAddress inetAddress) throws IOException {
        q(bArr, i6, inetAddress, 9);
    }

    public void q(byte[] bArr, int i6, InetAddress inetAddress, int i7) throws IOException {
        this.f50553g.setData(bArr);
        this.f50553g.setLength(i6);
        this.f50553g.setAddress(inetAddress);
        this.f50553g.setPort(i7);
        this.f50541c.send(this.f50553g);
    }
}
