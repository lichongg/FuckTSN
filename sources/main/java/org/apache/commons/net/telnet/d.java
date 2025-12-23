package org.apache.commons.net.telnet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class d extends org.apache.commons.net.g {
    static final boolean D = false;
    static final boolean E = false;
    static final int L = 1;
    static final int M = 2;
    static final int N = 4;
    static final int O = 8;
    static final int P = 23;
    protected static final int Q = 24;
    protected static final int R = 1;
    protected static final int S = 0;
    private volatile boolean A;
    private volatile OutputStream B;
    private i C;

    /* renamed from: u, reason: collision with root package name */
    int[] f51079u;

    /* renamed from: v, reason: collision with root package name */
    int[] f51080v;

    /* renamed from: w, reason: collision with root package name */
    int[] f51081w;

    /* renamed from: x, reason: collision with root package name */
    private String f51082x;

    /* renamed from: y, reason: collision with root package name */
    private final k[] f51083y;

    /* renamed from: z, reason: collision with root package name */
    private final Object f51084z;
    static final byte[] F = {-1, -3};
    static final byte[] G = {-1, -2};
    static final byte[] H = {-1, -5};
    static final byte[] I = {-1, -4};
    static final byte[] J = {-1, -6};
    static final byte[] K = {-1, -16};
    static final byte[] T = {24, 0};
    static final byte[] U = {-1, -10};

    d() {
        this.f51082x = null;
        this.f51084z = new Object();
        this.A = true;
        this.B = null;
        this.C = null;
        N(23);
        this.f51079u = new int[256];
        this.f51080v = new int[256];
        this.f51081w = new int[256];
        this.f51083y = new k[256];
    }

    void H0(int i6) {
        OutputStream outputStream;
        if ((I0(1) && l0(1)) || (outputStream = this.B) == null) {
            return;
        }
        try {
            outputStream.write(i6);
            outputStream.flush();
        } catch (IOException unused) {
            this.B = null;
        }
    }

    void M0() {
        this.B = null;
    }

    public void Q0() {
        this.C = null;
    }

    final synchronized void Z() {
        if (!this.A) {
            synchronized (this.f51084z) {
                this.A = true;
                this.f51084z.notifyAll();
            }
        }
    }

    @Override // org.apache.commons.net.g
    protected void b() throws IOException {
        for (int i6 = 0; i6 < 256; i6++) {
            this.f51079u[i6] = 0;
            this.f51080v[i6] = 0;
            this.f51081w[i6] = 0;
            k kVar = this.f51083y[i6];
            if (kVar != null) {
                kVar.k(false);
                this.f51083y[i6].n(false);
            }
        }
        super.b();
        this.f50804h = new BufferedInputStream(this.f50804h);
        this.f50805i = new BufferedOutputStream(this.f50805i);
        for (int i7 = 0; i7 < 256; i7++) {
            k kVar2 = this.f51083y[i7];
            if (kVar2 != null) {
                if (kVar2.e()) {
                    j0(this.f51083y[i7].g());
                }
                if (this.f51083y[i7].f()) {
                    h0(this.f51083y[i7].g());
                }
            }
        }
    }

    final synchronized void h0(int i6) throws IOException {
        try {
            if (this.f51079u[i6] == 0) {
                if (!I0(i6)) {
                }
            }
            if (!l0(i6)) {
                A0(i6);
                int[] iArr = this.f51079u;
                iArr[i6] = iArr[i6] + 1;
                s0(i6);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    final synchronized void i0(int i6) throws IOException {
        try {
            if (this.f51079u[i6] == 0) {
                if (!J0(i6)) {
                }
            }
            if (!m0(i6)) {
                B0(i6);
                int[] iArr = this.f51079u;
                iArr[i6] = iArr[i6] + 1;
                t0(i6);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    final synchronized void j0(int i6) throws IOException {
        try {
            if (this.f51080v[i6] == 0) {
                if (!K0(i6)) {
                }
            }
            if (!n0(i6)) {
                C0(i6);
                int[] iArr = this.f51079u;
                iArr[i6] = iArr[i6] + 1;
                w0(i6);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    final synchronized void k0(int i6) throws IOException {
        try {
            if (this.f51080v[i6] == 0) {
                if (!L0(i6)) {
                }
            }
            if (!o0(i6)) {
                D0(i6);
                int[] iArr = this.f51079u;
                iArr[i6] = iArr[i6] + 1;
                x0(i6);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    final synchronized void q0(int i6) throws IOException {
        this.f50805i.write(i6);
        H0(i6);
    }

    final synchronized void r0(byte b6) throws IOException {
        this.f50805i.write(255);
        this.f50805i.write(b6);
        this.f50805i.flush();
    }

    final synchronized void s0(int i6) throws IOException {
        this.f50805i.write(F);
        this.f50805i.write(i6);
        this.f50805i.flush();
    }

    final synchronized void t0(int i6) throws IOException {
        this.f50805i.write(G);
        this.f50805i.write(i6);
        this.f50805i.flush();
    }

    final synchronized void u0(int[] iArr) throws IOException {
        if (iArr != null) {
            try {
                this.f50805i.write(J);
                for (int i6 : iArr) {
                    byte b6 = (byte) i6;
                    if (b6 == -1) {
                        this.f50805i.write(b6);
                    }
                    this.f50805i.write(b6);
                }
                this.f50805i.write(K);
                this.f50805i.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final synchronized void v0() throws IOException {
        if (this.f51082x != null) {
            this.f50805i.write(J);
            this.f50805i.write(T);
            this.f50805i.write(this.f51082x.getBytes(q()));
            this.f50805i.write(K);
            this.f50805i.flush();
        }
    }

    final synchronized void w0(int i6) throws IOException {
        this.f50805i.write(H);
        this.f50805i.write(i6);
        this.f50805i.flush();
    }

    final synchronized void x0(int i6) throws IOException {
        this.f50805i.write(I);
        this.f50805i.write(i6);
        this.f50805i.flush();
    }

    void A0(int i6) {
        int[] iArr = this.f51081w;
        iArr[i6] = iArr[i6] | 8;
    }

    void B0(int i6) {
        int[] iArr = this.f51081w;
        iArr[i6] = iArr[i6] & (-9);
    }

    void C0(int i6) {
        int[] iArr = this.f51081w;
        iArr[i6] = iArr[i6] | 4;
    }

    void D0(int i6) {
        int[] iArr = this.f51081w;
        iArr[i6] = iArr[i6] & (-5);
    }

    void E0(int i6) throws IOException {
        k kVar;
        int[] iArr = this.f51081w;
        iArr[i6] = iArr[i6] | 1;
        if (!n0(i6) || (kVar = this.f51083y[i6]) == null) {
            return;
        }
        kVar.n(true);
        int[] o5 = this.f51083y[i6].o();
        if (o5 != null) {
            u0(o5);
        }
    }

    void F0(int i6) {
        int[] iArr = this.f51081w;
        iArr[i6] = iArr[i6] & (-2);
        k kVar = this.f51083y[i6];
        if (kVar != null) {
            kVar.n(false);
        }
    }

    void G0(int i6) {
        OutputStream outputStream = this.B;
        if (outputStream == null || i6 == 13) {
            return;
        }
        if (i6 == 10) {
            try {
                outputStream.write(13);
            } catch (IOException unused) {
                this.B = null;
                return;
            }
        }
        outputStream.write(i6);
        outputStream.flush();
    }

    boolean I0(int i6) {
        return (this.f51081w[i6] & 2) != 0;
    }

    boolean K0(int i6) {
        return (this.f51081w[i6] & 1) != 0;
    }

    public void P0(i iVar) {
        this.C = iVar;
    }

    void a0(int i6) {
        i iVar = this.C;
        if (iVar != null) {
            iVar.a(5, i6);
        }
    }

    void b0(int i6) throws IOException {
        String str;
        i iVar = this.C;
        if (iVar != null) {
            iVar.a(1, i6);
        }
        k kVar = this.f51083y[i6];
        boolean b6 = kVar != null ? kVar.b() : i6 == 24 && (str = this.f51082x) != null && str.length() > 0;
        int[] iArr = this.f51080v;
        int i7 = iArr[i6];
        if (i7 > 0) {
            int i8 = i7 - 1;
            iArr[i6] = i8;
            if (i8 > 0 && K0(i6)) {
                int[] iArr2 = this.f51080v;
                iArr2[i6] = iArr2[i6] - 1;
            }
        }
        if (this.f51080v[i6] == 0 && o0(i6)) {
            if (b6) {
                C0(i6);
                w0(i6);
            } else {
                int[] iArr3 = this.f51080v;
                iArr3[i6] = iArr3[i6] + 1;
                x0(i6);
            }
        }
        E0(i6);
    }

    void c0(int i6) throws IOException {
        i iVar = this.C;
        if (iVar != null) {
            iVar.a(2, i6);
        }
        int[] iArr = this.f51080v;
        int i7 = iArr[i6];
        if (i7 > 0) {
            int i8 = i7 - 1;
            iArr[i6] = i8;
            if (i8 > 0 && L0(i6)) {
                this.f51080v[i6] = r0[i6] - 1;
            }
        }
        if (this.f51080v[i6] == 0 && n0(i6)) {
            if (K0(i6) || n0(i6)) {
                x0(i6);
            }
            D0(i6);
        }
        F0(i6);
    }

    void d0(int[] iArr, int i6) throws IOException {
        if (i6 > 0) {
            k[] kVarArr = this.f51083y;
            int i7 = iArr[0];
            k kVar = kVarArr[i7];
            if (kVar != null) {
                u0(kVar.a(iArr, i6));
            } else if (i6 > 1 && i7 == 24 && iArr[1] == 1) {
                v0();
            }
        }
    }

    void e0(int i6) throws IOException {
        i iVar = this.C;
        if (iVar != null) {
            iVar.a(3, i6);
        }
        k kVar = this.f51083y[i6];
        boolean c6 = kVar != null ? kVar.c() : false;
        int[] iArr = this.f51079u;
        int i7 = iArr[i6];
        if (i7 > 0) {
            int i8 = i7 - 1;
            iArr[i6] = i8;
            if (i8 > 0 && I0(i6)) {
                this.f51079u[i6] = r1[i6] - 1;
            }
        }
        if (this.f51079u[i6] == 0 && m0(i6)) {
            if (c6) {
                A0(i6);
                s0(i6);
            } else {
                int[] iArr2 = this.f51079u;
                iArr2[i6] = iArr2[i6] + 1;
                t0(i6);
            }
        }
        y0(i6);
    }

    void f0(int i6) throws IOException {
        i iVar = this.C;
        if (iVar != null) {
            iVar.a(4, i6);
        }
        int[] iArr = this.f51079u;
        int i7 = iArr[i6];
        if (i7 > 0) {
            int i8 = i7 - 1;
            iArr[i6] = i8;
            if (i8 > 0 && J0(i6)) {
                this.f51079u[i6] = r0[i6] - 1;
            }
        }
        if (this.f51079u[i6] == 0 && l0(i6)) {
            if (I0(i6) || l0(i6)) {
                t0(i6);
            }
            B0(i6);
        }
        z0(i6);
    }

    void g0(OutputStream outputStream) {
        this.B = outputStream;
    }

    boolean l0(int i6) {
        return (this.f51081w[i6] & 8) != 0;
    }

    boolean n0(int i6) {
        return (this.f51081w[i6] & 4) != 0;
    }

    final boolean p0(long j6) throws IOException, IllegalArgumentException, InterruptedException {
        boolean z5;
        synchronized (this.f51084z) {
            try {
                synchronized (this) {
                    z5 = false;
                    this.A = false;
                    this.f50805i.write(U);
                    this.f50805i.flush();
                }
                this.f51084z.wait(j6);
                if (this.A) {
                    z5 = true;
                } else {
                    this.A = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z5;
    }

    void y0(int i6) throws IOException {
        k kVar;
        int[] iArr = this.f51081w;
        iArr[i6] = iArr[i6] | 2;
        if (!l0(i6) || (kVar = this.f51083y[i6]) == null) {
            return;
        }
        kVar.k(true);
        int[] p5 = this.f51083y[i6].p();
        if (p5 != null) {
            u0(p5);
        }
    }

    void z0(int i6) {
        int[] iArr = this.f51081w;
        iArr[i6] = iArr[i6] & (-3);
        k kVar = this.f51083y[i6];
        if (kVar != null) {
            kVar.k(false);
        }
    }

    boolean J0(int i6) {
        return !I0(i6);
    }

    boolean L0(int i6) {
        return !K0(i6);
    }

    void N0(k kVar) throws InvalidTelnetOptionException, IOException {
        int g6 = kVar.g();
        if (j.b(g6)) {
            k[] kVarArr = this.f51083y;
            if (kVarArr[g6] == null) {
                kVarArr[g6] = kVar;
                if (J()) {
                    if (kVar.e()) {
                        j0(g6);
                    }
                    if (kVar.f()) {
                        h0(g6);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new InvalidTelnetOptionException("Already registered option", g6);
        }
        throw new InvalidTelnetOptionException("Invalid Option Code", g6);
    }

    void O0(int i6) throws InvalidTelnetOptionException, IOException {
        if (j.b(i6)) {
            k[] kVarArr = this.f51083y;
            k kVar = kVarArr[i6];
            if (kVar != null) {
                kVarArr[i6] = null;
                if (kVar.h()) {
                    k0(i6);
                }
                if (kVar.d()) {
                    i0(i6);
                    return;
                }
                return;
            }
            throw new InvalidTelnetOptionException("Unregistered option", i6);
        }
        throw new InvalidTelnetOptionException("Invalid Option Code", i6);
    }

    boolean m0(int i6) {
        return !l0(i6);
    }

    boolean o0(int i6) {
        return !n0(i6);
    }

    d(String str) {
        this.f51082x = null;
        this.f51084z = new Object();
        this.A = true;
        this.B = null;
        this.C = null;
        N(23);
        this.f51079u = new int[256];
        this.f51080v = new int[256];
        this.f51081w = new int[256];
        this.f51082x = str;
        this.f51083y = new k[256];
    }
}
