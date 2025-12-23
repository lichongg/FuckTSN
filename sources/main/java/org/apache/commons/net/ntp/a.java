package org.apache.commons.net.ntp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a extends org.apache.commons.net.a {

    /* renamed from: h, reason: collision with root package name */
    public static final int f50955h = 123;

    /* renamed from: g, reason: collision with root package name */
    private int f50956g = 3;

    public e p(InetAddress inetAddress) throws IOException {
        return q(inetAddress, 123);
    }

    public int r() {
        return this.f50956g;
    }

    public void s(int i6) {
        this.f50956g = i6;
    }

    public e q(InetAddress inetAddress, int i6) throws IOException {
        if (!h()) {
            i();
        }
        c cVar = new c();
        cVar.o(3);
        cVar.setVersion(this.f50956g);
        DatagramPacket s5 = cVar.s();
        s5.setAddress(inetAddress);
        s5.setPort(i6);
        c cVar2 = new c();
        DatagramPacket s6 = cVar2.s();
        cVar.w(TimeStamp.getCurrentTime());
        this.f50541c.send(s5);
        this.f50541c.receive(s6);
        return new e((d) cVar2, System.currentTimeMillis(), false);
    }
}
