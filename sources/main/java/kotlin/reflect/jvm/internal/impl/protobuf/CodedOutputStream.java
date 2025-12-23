package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CodedOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f46434a;

    /* renamed from: b, reason: collision with root package name */
    private final int f46435b;

    /* renamed from: c, reason: collision with root package name */
    private int f46436c;

    /* renamed from: d, reason: collision with root package name */
    private int f46437d;

    /* renamed from: e, reason: collision with root package name */
    private final OutputStream f46438e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(byte[] bArr, int i6, int i7) {
        this.f46437d = 0;
        this.f46438e = null;
        this.f46434a = bArr;
        this.f46436c = i6;
        this.f46435b = i6 + i7;
    }

    public static int E(int i6) {
        return w(WireFormat.c(i6, 0));
    }

    public static long I(long j6) {
        return (j6 >> 63) ^ (j6 << 1);
    }

    public static CodedOutputStream L(byte[] bArr) {
        return M(bArr, 0, bArr.length);
    }

    public static int c(boolean z5) {
        return 1;
    }

    public static int d(byte[] bArr) {
        return w(bArr.length) + bArr.length;
    }

    public static int k(int i6) {
        return 4;
    }

    public static int n(float f6) {
        return 4;
    }

    public static int y(int i6) {
        return 4;
    }

    public void B0(int i6, int i7) throws IOException {
        A0(i6, 0);
        C0(i7);
    }

    public void P(int i6, boolean z5) throws IOException {
        A0(i6, 0);
        Q(z5);
    }

    public void R(byte[] bArr) throws IOException {
        s0(bArr.length);
        o0(bArr);
    }

    public void S(int i6, d dVar) throws IOException {
        A0(i6, 2);
        T(dVar);
    }

    public void U(int i6, double d6) throws IOException {
        A0(i6, 1);
        V(d6);
    }

    public void W(int i6, int i7) throws IOException {
        A0(i6, 0);
        X(i7);
    }

    public void a0(int i6, float f6) throws IOException {
        A0(i6, 5);
        b0(f6);
    }

    public void c0(int i6, n nVar) throws IOException {
        A0(i6, 3);
        d0(nVar);
        A0(i6, 4);
    }

    public void e0(int i6, int i7) throws IOException {
        A0(i6, 0);
        f0(i7);
    }

    public void h0(int i6, n nVar) throws IOException {
        A0(i6, 2);
        i0(nVar);
    }

    public void j0(int i6, n nVar) throws IOException {
        A0(1, 3);
        B0(2, i6);
        h0(3, nVar);
        A0(1, 4);
    }

    public void l0(int i6) throws IOException {
        k0((byte) i6);
    }

    public void m0(d dVar) throws IOException {
        n0(dVar, 0, dVar.size());
    }

    public void o0(byte[] bArr) throws IOException {
        p0(bArr, 0, bArr.length);
    }

    public void r0(long j6) throws IOException {
        l0(((int) j6) & 255);
        l0(((int) (j6 >> 8)) & 255);
        l0(((int) (j6 >> 16)) & 255);
        l0(((int) (j6 >> 24)) & 255);
        l0(((int) (j6 >> 32)) & 255);
        l0(((int) (j6 >> 40)) & 255);
        l0(((int) (j6 >> 48)) & 255);
        l0(((int) (j6 >> 56)) & 255);
    }

    public void x0(int i6, long j6) throws IOException {
        A0(i6, 0);
        y0(j6);
    }

    public static int D(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return w(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException("UTF-8 not supported.", e6);
        }
    }

    public static int H(int i6) {
        return (i6 >> 31) ^ (i6 << 1);
    }

    public static CodedOutputStream K(OutputStream outputStream, int i6) {
        return new CodedOutputStream(outputStream, new byte[i6]);
    }

    public static CodedOutputStream M(byte[] bArr, int i6, int i7) {
        return new CodedOutputStream(bArr, i6, i7);
    }

    private void N() throws IOException {
        OutputStream outputStream = this.f46438e;
        if (outputStream == null) {
            throw new OutOfSpaceException();
        }
        outputStream.write(this.f46434a, 0, this.f46436c);
        this.f46436c = 0;
    }

    public static int h(double d6) {
        return 8;
    }

    public static int l(long j6) {
        return 8;
    }

    public static int q(int i6) {
        if (i6 >= 0) {
            return w(i6);
        }
        return 10;
    }

    static int v(int i6) {
        if (i6 > 4096) {
            return 4096;
        }
        return i6;
    }

    public static int w(int i6) {
        if ((i6 & (-128)) == 0) {
            return 1;
        }
        if ((i6 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i6) == 0) {
            return 3;
        }
        return (i6 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int x(long j6) {
        if (((-128) & j6) == 0) {
            return 1;
        }
        if (((-16384) & j6) == 0) {
            return 2;
        }
        if (((-2097152) & j6) == 0) {
            return 3;
        }
        if (((-268435456) & j6) == 0) {
            return 4;
        }
        if (((-34359738368L) & j6) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j6) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j6) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j6) == 0) {
            return 8;
        }
        return (j6 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int z(long j6) {
        return 8;
    }

    public void J() throws IOException {
        if (this.f46438e != null) {
            N();
        }
    }

    public int O() {
        if (this.f46438e == null) {
            return this.f46435b - this.f46436c;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void f0(int i6) throws IOException {
        if (i6 >= 0) {
            s0(i6);
        } else {
            t0(i6);
        }
    }

    public void k0(byte b6) throws IOException {
        if (this.f46436c == this.f46435b) {
            N();
        }
        byte[] bArr = this.f46434a;
        int i6 = this.f46436c;
        this.f46436c = i6 + 1;
        bArr[i6] = b6;
        this.f46437d++;
    }

    public void n0(d dVar, int i6, int i7) throws IOException {
        int i8 = this.f46435b;
        int i9 = this.f46436c;
        if (i8 - i9 >= i7) {
            dVar.m(this.f46434a, i6, i9, i7);
            this.f46436c += i7;
            this.f46437d += i7;
            return;
        }
        int i10 = i8 - i9;
        dVar.m(this.f46434a, i6, i9, i10);
        int i11 = i6 + i10;
        int i12 = i7 - i10;
        this.f46436c = this.f46435b;
        this.f46437d += i10;
        N();
        if (i12 <= this.f46435b) {
            dVar.m(this.f46434a, i11, 0, i12);
            this.f46436c = i12;
        } else {
            dVar.A(this.f46438e, i11, i12);
        }
        this.f46437d += i12;
    }

    public void p0(byte[] bArr, int i6, int i7) throws IOException {
        int i8 = this.f46435b;
        int i9 = this.f46436c;
        if (i8 - i9 >= i7) {
            System.arraycopy(bArr, i6, this.f46434a, i9, i7);
            this.f46436c += i7;
            this.f46437d += i7;
            return;
        }
        int i10 = i8 - i9;
        System.arraycopy(bArr, i6, this.f46434a, i9, i10);
        int i11 = i6 + i10;
        int i12 = i7 - i10;
        this.f46436c = this.f46435b;
        this.f46437d += i10;
        N();
        if (i12 <= this.f46435b) {
            System.arraycopy(bArr, i11, this.f46434a, 0, i12);
            this.f46436c = i12;
        } else {
            this.f46438e.write(bArr, i11, i12);
        }
        this.f46437d += i12;
    }

    public void q0(int i6) throws IOException {
        l0(i6 & 255);
        l0((i6 >> 8) & 255);
        l0((i6 >> 16) & 255);
        l0((i6 >> 24) & 255);
    }

    public void s0(int i6) throws IOException {
        while ((i6 & (-128)) != 0) {
            l0((i6 & 127) | 128);
            i6 >>>= 7;
        }
        l0(i6);
    }

    public void t0(long j6) throws IOException {
        while (((-128) & j6) != 0) {
            l0((((int) j6) & 127) | 128);
            j6 >>>= 7;
        }
        l0((int) j6);
    }

    public void z0(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        s0(bytes.length);
        o0(bytes);
    }

    public static int A(int i6) {
        return w(H(i6));
    }

    public static int B(int i6, long j6) {
        return E(i6) + C(j6);
    }

    public static int C(long j6) {
        return x(I(j6));
    }

    public static int F(int i6) {
        return w(i6);
    }

    public static int G(long j6) {
        return x(j6);
    }

    public static int b(int i6, boolean z5) {
        return E(i6) + c(z5);
    }

    public static int e(int i6, d dVar) {
        return E(i6) + f(dVar);
    }

    public static int f(d dVar) {
        return w(dVar.size()) + dVar.size();
    }

    public static int g(int i6, double d6) {
        return E(i6) + h(d6);
    }

    public static int i(int i6, int i7) {
        return E(i6) + j(i7);
    }

    public static int j(int i6) {
        return q(i6);
    }

    public static int m(int i6, float f6) {
        return E(i6) + n(f6);
    }

    public static int o(n nVar) {
        return nVar.getSerializedSize();
    }

    public static int p(int i6, int i7) {
        return E(i6) + q(i7);
    }

    public static int r(long j6) {
        return x(j6);
    }

    public static int s(j jVar) {
        int b6 = jVar.b();
        return w(b6) + b6;
    }

    public static int t(int i6, n nVar) {
        return E(i6) + u(nVar);
    }

    public static int u(n nVar) {
        int serializedSize = nVar.getSerializedSize();
        return w(serializedSize) + serializedSize;
    }

    public void A0(int i6, int i7) throws IOException {
        s0(WireFormat.c(i6, i7));
    }

    public void C0(int i6) throws IOException {
        s0(i6);
    }

    public void D0(long j6) throws IOException {
        t0(j6);
    }

    public void Q(boolean z5) throws IOException {
        l0(z5 ? 1 : 0);
    }

    public void T(d dVar) throws IOException {
        s0(dVar.size());
        m0(dVar);
    }

    public void V(double d6) throws IOException {
        r0(Double.doubleToRawLongBits(d6));
    }

    public void X(int i6) throws IOException {
        f0(i6);
    }

    public void Y(int i6) throws IOException {
        q0(i6);
    }

    public void Z(long j6) throws IOException {
        r0(j6);
    }

    public void a() {
        if (O() == 0) {
        } else {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void b0(float f6) throws IOException {
        q0(Float.floatToRawIntBits(f6));
    }

    public void d0(n nVar) throws IOException {
        nVar.writeTo(this);
    }

    public void g0(long j6) throws IOException {
        t0(j6);
    }

    public void i0(n nVar) throws IOException {
        s0(nVar.getSerializedSize());
        nVar.writeTo(this);
    }

    public void u0(int i6) throws IOException {
        q0(i6);
    }

    public void v0(long j6) throws IOException {
        r0(j6);
    }

    public void w0(int i6) throws IOException {
        s0(H(i6));
    }

    public void y0(long j6) throws IOException {
        t0(I(j6));
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.f46437d = 0;
        this.f46438e = outputStream;
        this.f46434a = bArr;
        this.f46436c = 0;
        this.f46435b = bArr.length;
    }
}
