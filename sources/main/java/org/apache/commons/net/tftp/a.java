package org.apache.commons.net.tftp;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.SocketException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends org.apache.commons.net.a {

    /* renamed from: k, reason: collision with root package name */
    public static final int f51184k = 0;

    /* renamed from: l, reason: collision with root package name */
    public static final int f51185l = 0;

    /* renamed from: m, reason: collision with root package name */
    public static final int f51186m = 1;

    /* renamed from: n, reason: collision with root package name */
    public static final int f51187n = 1;

    /* renamed from: o, reason: collision with root package name */
    public static final int f51188o = 1;

    /* renamed from: p, reason: collision with root package name */
    public static final int f51189p = 5000;

    /* renamed from: q, reason: collision with root package name */
    public static final int f51190q = 69;

    /* renamed from: r, reason: collision with root package name */
    static final int f51191r = 516;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f51192g;

    /* renamed from: h, reason: collision with root package name */
    private DatagramPacket f51193h;

    /* renamed from: i, reason: collision with root package name */
    private DatagramPacket f51194i;

    /* renamed from: j, reason: collision with root package name */
    byte[] f51195j;

    public final void t() {
        this.f51192g = null;
        this.f51193h = null;
        this.f51195j = null;
        this.f51194i = null;
    }

    public static final String u(int i6) {
        return h.f51227m[i6];
    }

    public final void p() {
        this.f51192g = new byte[516];
        byte[] bArr = this.f51192g;
        this.f51193h = new DatagramPacket(bArr, bArr.length);
        this.f51195j = new byte[516];
        byte[] bArr2 = this.f51195j;
        this.f51194i = new DatagramPacket(bArr2, bArr2.length);
    }

    public final f q() throws IOException, InterruptedIOException, SocketException, TFTPPacketException {
        this.f51193h.setData(this.f51192g);
        this.f51193h.setLength(this.f51192g.length);
        this.f50541c.receive(this.f51193h);
        f e6 = f.e(this.f51193h);
        x("<", e6);
        return e6;
    }

    public final void r(f fVar) throws IOException {
        x(">", fVar);
        this.f50541c.send(fVar.a(this.f51194i, this.f51195j));
    }

    public final void s() throws IOException {
        DatagramPacket datagramPacket = new DatagramPacket(new byte[516], 516);
        int g6 = g();
        o(1);
        while (true) {
            try {
                this.f50541c.receive(datagramPacket);
            } catch (InterruptedIOException | SocketException unused) {
                o(g6);
                return;
            }
        }
    }

    public final f v() throws IOException, InterruptedIOException, SocketException, TFTPPacketException {
        DatagramPacket datagramPacket = new DatagramPacket(new byte[516], 516);
        this.f50541c.receive(datagramPacket);
        f e6 = f.e(datagramPacket);
        x("<", e6);
        return e6;
    }

    public final void w(f fVar) throws IOException {
        x(">", fVar);
        this.f50541c.send(fVar.d());
    }

    public a() {
        n(5000);
        this.f51192g = null;
        this.f51193h = null;
    }

    protected void x(String str, f fVar) {
    }
}
