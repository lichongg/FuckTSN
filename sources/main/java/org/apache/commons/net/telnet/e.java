package org.apache.commons.net.telnet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e extends d {
    private InputStream V;
    private OutputStream W;
    protected boolean X;
    private g Y;

    public e() {
        super("VT100");
        this.X = true;
        this.V = null;
        this.W = null;
    }

    void R0() throws IOException {
        try {
            this.f50805i.close();
        } finally {
            this.f50805i = null;
        }
    }

    void Y0() {
        g gVar;
        synchronized (this) {
            gVar = this.Y;
        }
        if (gVar != null) {
            gVar.a();
        }
    }

    public synchronized void Z0(g gVar) {
        this.Y = gVar;
    }

    public void d1(int[] iArr) throws IOException, IllegalArgumentException {
        if (iArr.length < 1) {
            throw new IllegalArgumentException("zero length message");
        }
        u0(iArr);
    }

    public synchronized void g1() {
        this.Y = null;
    }

    @Override // org.apache.commons.net.g
    public void n() throws IOException {
        try {
            InputStream inputStream = this.V;
            if (inputStream != null) {
                inputStream.close();
            }
            OutputStream outputStream = this.W;
            if (outputStream != null) {
                outputStream.close();
            }
            this.W = null;
            this.V = null;
            super.n();
        } catch (Throwable th) {
            this.W = null;
            this.V = null;
            super.n();
            throw th;
        }
    }

    void S0() throws IOException {
        this.f50805i.flush();
    }

    public InputStream T0() {
        return this.V;
    }

    public OutputStream V0() {
        return this.W;
    }

    public boolean W0() {
        return this.X;
    }

    public void e1(boolean z5) {
        this.X = z5;
    }

    @Override // org.apache.commons.net.telnet.d
    public void N0(k kVar) throws InvalidTelnetOptionException, IOException {
        super.N0(kVar);
    }

    @Override // org.apache.commons.net.telnet.d
    public void O0(int i6) throws InvalidTelnetOptionException, IOException {
        super.O0(i6);
    }

    @Override // org.apache.commons.net.telnet.d
    public void P0(i iVar) {
        super.P0(iVar);
    }

    @Override // org.apache.commons.net.telnet.d
    public void Q0() {
        super.Q0();
    }

    public boolean U0(int i6) {
        if (K0(i6) && n0(i6)) {
            return true;
        }
        return false;
    }

    public boolean X0(int i6) {
        if (I0(i6) && l0(i6)) {
            return true;
        }
        return false;
    }

    public void a1(OutputStream outputStream) {
        super.g0(outputStream);
    }

    @Override // org.apache.commons.net.telnet.d, org.apache.commons.net.g
    protected void b() throws IOException {
        super.b();
        h hVar = new h(this.f50804h, this, this.X);
        if (this.X) {
            hVar.c();
        }
        this.V = new BufferedInputStream(hVar);
        this.W = new l(this);
    }

    public boolean b1(long j6) throws IOException, IllegalArgumentException, InterruptedException {
        return p0(j6);
    }

    public void c1(byte b6) throws IOException, IllegalArgumentException {
        r0(b6);
    }

    public void f1() {
        super.M0();
    }

    public e(String str) {
        super(str);
        this.X = true;
        this.V = null;
        this.W = null;
    }
}
