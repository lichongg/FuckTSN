package org.apache.commons.net;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class a {

    /* renamed from: f, reason: collision with root package name */
    private static final b f50538f = new c();

    /* renamed from: a, reason: collision with root package name */
    private Charset f50539a = Charset.defaultCharset();

    /* renamed from: c, reason: collision with root package name */
    protected DatagramSocket f50541c = null;

    /* renamed from: b, reason: collision with root package name */
    protected int f50540b = 0;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f50542d = false;

    /* renamed from: e, reason: collision with root package name */
    protected b f50543e = f50538f;

    public void a() {
        DatagramSocket datagramSocket = this.f50541c;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
        this.f50541c = null;
        this.f50542d = false;
    }

    public Charset b() {
        return this.f50539a;
    }

    public String c() {
        return this.f50539a.name();
    }

    public int d() {
        return this.f50540b;
    }

    public InetAddress e() {
        return this.f50541c.getLocalAddress();
    }

    public int f() {
        return this.f50541c.getLocalPort();
    }

    public int g() throws SocketException {
        return this.f50541c.getSoTimeout();
    }

    public boolean h() {
        return this.f50542d;
    }

    public void i() throws SocketException {
        DatagramSocket c6 = this.f50543e.c();
        this.f50541c = c6;
        c6.setSoTimeout(this.f50540b);
        this.f50542d = true;
    }

    public void j(int i6) throws SocketException {
        DatagramSocket b6 = this.f50543e.b(i6);
        this.f50541c = b6;
        b6.setSoTimeout(this.f50540b);
        this.f50542d = true;
    }

    public void k(int i6, InetAddress inetAddress) throws SocketException {
        DatagramSocket a6 = this.f50543e.a(i6, inetAddress);
        this.f50541c = a6;
        a6.setSoTimeout(this.f50540b);
        this.f50542d = true;
    }

    public void l(Charset charset) {
        this.f50539a = charset;
    }

    public void m(b bVar) {
        if (bVar == null) {
            this.f50543e = f50538f;
        } else {
            this.f50543e = bVar;
        }
    }

    public void n(int i6) {
        this.f50540b = i6;
    }

    public void o(int i6) throws SocketException {
        this.f50541c.setSoTimeout(i6);
    }
}
