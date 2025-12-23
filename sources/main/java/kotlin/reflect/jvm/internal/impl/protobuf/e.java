package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.n;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f46477a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f46478b;

    /* renamed from: c, reason: collision with root package name */
    private int f46479c;

    /* renamed from: d, reason: collision with root package name */
    private int f46480d;

    /* renamed from: e, reason: collision with root package name */
    private int f46481e;

    /* renamed from: f, reason: collision with root package name */
    private final InputStream f46482f;

    /* renamed from: g, reason: collision with root package name */
    private int f46483g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f46484h;

    /* renamed from: i, reason: collision with root package name */
    private int f46485i;

    /* renamed from: j, reason: collision with root package name */
    private int f46486j;

    /* renamed from: k, reason: collision with root package name */
    private int f46487k;

    /* renamed from: l, reason: collision with root package name */
    private int f46488l;

    /* renamed from: m, reason: collision with root package name */
    private int f46489m;

    /* renamed from: n, reason: collision with root package name */
    private a f46490n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface a {
        void a();
    }

    private e(InputStream inputStream) {
        this.f46484h = false;
        this.f46486j = Integer.MAX_VALUE;
        this.f46488l = 64;
        this.f46489m = 67108864;
        this.f46490n = null;
        this.f46477a = new byte[4096];
        this.f46479c = 0;
        this.f46481e = 0;
        this.f46485i = 0;
        this.f46482f = inputStream;
        this.f46478b = false;
    }

    public static long c(long j6) {
        return (-(j6 & 1)) ^ (j6 >>> 1);
    }

    public static int B(int i6, InputStream inputStream) throws IOException {
        if ((i6 & 128) == 0) {
            return i6;
        }
        int i7 = i6 & 127;
        int i8 = 7;
        while (i8 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i7 |= (read & 127) << i8;
            if ((read & 128) == 0) {
                return i7;
            }
            i8 += 7;
        }
        while (i8 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((read2 & 128) == 0) {
                return i7;
            }
            i8 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    private void N() {
        int i6 = this.f46479c + this.f46480d;
        this.f46479c = i6;
        int i7 = this.f46485i + i6;
        int i8 = this.f46486j;
        if (i7 <= i8) {
            this.f46480d = 0;
            return;
        }
        int i9 = i7 - i8;
        this.f46480d = i9;
        this.f46479c = i6 - i9;
    }

    private void S(int i6) throws IOException {
        if (i6 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i7 = this.f46485i;
        int i8 = this.f46481e;
        int i9 = i7 + i8 + i6;
        int i10 = this.f46486j;
        if (i9 > i10) {
            R((i10 - i7) - i8);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i11 = this.f46479c;
        int i12 = i11 - i8;
        this.f46481e = i11;
        O(1);
        while (true) {
            int i13 = i6 - i12;
            int i14 = this.f46479c;
            if (i13 <= i14) {
                this.f46481e = i13;
                return;
            } else {
                i12 += i14;
                this.f46481e = i14;
                O(1);
            }
        }
    }

    private boolean T(int i6) throws IOException {
        int i7 = this.f46481e;
        if (i7 + i6 <= this.f46479c) {
            StringBuilder sb = new StringBuilder(77);
            sb.append("refillBuffer() called when ");
            sb.append(i6);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        if (this.f46485i + i7 + i6 > this.f46486j) {
            return false;
        }
        a aVar = this.f46490n;
        if (aVar != null) {
            aVar.a();
        }
        if (this.f46482f != null) {
            int i8 = this.f46481e;
            if (i8 > 0) {
                int i9 = this.f46479c;
                if (i9 > i8) {
                    byte[] bArr = this.f46477a;
                    System.arraycopy(bArr, i8, bArr, 0, i9 - i8);
                }
                this.f46485i += i8;
                this.f46479c -= i8;
                this.f46481e = 0;
            }
            InputStream inputStream = this.f46482f;
            byte[] bArr2 = this.f46477a;
            int i10 = this.f46479c;
            int read = inputStream.read(bArr2, i10, bArr2.length - i10);
            if (read == 0 || read < -1 || read > this.f46477a.length) {
                StringBuilder sb2 = new StringBuilder(102);
                sb2.append("InputStream#read(byte[]) returned invalid result: ");
                sb2.append(read);
                sb2.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb2.toString());
            }
            if (read > 0) {
                this.f46479c += read;
                if ((this.f46485i + i6) - this.f46489m > 0) {
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
                N();
                if (this.f46479c >= i6) {
                    return true;
                }
                return T(i6);
            }
        }
        return false;
    }

    public static int b(int i6) {
        return (-(i6 & 1)) ^ (i6 >>> 1);
    }

    private void d(int i6) throws IOException {
        if (this.f46479c - this.f46481e < i6) {
            O(i6);
        }
    }

    public static e g(InputStream inputStream) {
        return new e(inputStream);
    }

    static e h(m mVar) {
        e eVar = new e(mVar);
        try {
            eVar.j(mVar.size());
            return eVar;
        } catch (InvalidProtocolBufferException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    private byte[] x(int i6) throws IOException {
        if (i6 <= 0) {
            if (i6 == 0) {
                return h.f46502a;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i7 = this.f46485i;
        int i8 = this.f46481e;
        int i9 = i7 + i8 + i6;
        int i10 = this.f46486j;
        if (i9 > i10) {
            R((i10 - i7) - i8);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i6 < 4096) {
            byte[] bArr = new byte[i6];
            int i11 = this.f46479c - i8;
            System.arraycopy(this.f46477a, i8, bArr, 0, i11);
            this.f46481e = this.f46479c;
            int i12 = i6 - i11;
            d(i12);
            System.arraycopy(this.f46477a, 0, bArr, i11, i12);
            this.f46481e = i12;
            return bArr;
        }
        int i13 = this.f46479c;
        this.f46485i = i7 + i13;
        this.f46481e = 0;
        this.f46479c = 0;
        int i14 = i13 - i8;
        int i15 = i6 - i14;
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i15 > 0) {
            int min = Math.min(i15, 4096);
            byte[] bArr2 = new byte[min];
            int i16 = 0;
            while (i16 < min) {
                InputStream inputStream = this.f46482f;
                int read = inputStream == null ? -1 : inputStream.read(bArr2, i16, min - i16);
                if (read == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.f46485i += read;
                i16 += read;
            }
            i15 -= min;
            arrayList.add(bArr2);
        }
        byte[] bArr3 = new byte[i6];
        System.arraycopy(this.f46477a, i8, bArr3, 0, i14);
        for (byte[] bArr4 : arrayList) {
            System.arraycopy(bArr4, 0, bArr3, i14, bArr4.length);
            i14 += bArr4.length;
        }
        return bArr3;
    }

    public int A() throws IOException {
        int i6;
        int i7 = this.f46481e;
        int i8 = this.f46479c;
        if (i8 != i7) {
            byte[] bArr = this.f46477a;
            int i9 = i7 + 1;
            byte b6 = bArr[i7];
            if (b6 >= 0) {
                this.f46481e = i9;
                return b6;
            }
            if (i8 - i9 >= 9) {
                int i10 = i7 + 2;
                int i11 = (bArr[i9] << 7) ^ b6;
                long j6 = i11;
                if (j6 < 0) {
                    i6 = (int) ((-128) ^ j6);
                } else {
                    int i12 = i7 + 3;
                    int i13 = (bArr[i10] << 14) ^ i11;
                    long j7 = i13;
                    if (j7 >= 0) {
                        i6 = (int) (16256 ^ j7);
                    } else {
                        int i14 = i7 + 4;
                        long j8 = i13 ^ (bArr[i12] << 21);
                        if (j8 < 0) {
                            i6 = (int) ((-2080896) ^ j8);
                        } else {
                            i12 = i7 + 5;
                            int i15 = (int) ((r1 ^ (r3 << 28)) ^ 266354560);
                            if (bArr[i14] < 0) {
                                i14 = i7 + 6;
                                if (bArr[i12] < 0) {
                                    i12 = i7 + 7;
                                    if (bArr[i14] < 0) {
                                        i14 = i7 + 8;
                                        if (bArr[i12] < 0) {
                                            i12 = i7 + 9;
                                            if (bArr[i14] < 0) {
                                                int i16 = i7 + 10;
                                                if (bArr[i12] >= 0) {
                                                    i10 = i16;
                                                    i6 = i15;
                                                }
                                            }
                                        }
                                    }
                                }
                                i6 = i15;
                            }
                            i6 = i15;
                        }
                        i10 = i14;
                    }
                    i10 = i12;
                }
                this.f46481e = i10;
                return i6;
            }
        }
        return (int) D();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
    
        if (r2[r7] < 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long C() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 190
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.e.C():long");
    }

    long D() throws IOException {
        long j6 = 0;
        for (int i6 = 0; i6 < 64; i6 += 7) {
            j6 |= (r3 & Byte.MAX_VALUE) << i6;
            if ((w() & 128) == 0) {
                return j6;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public void R(int i6) throws IOException {
        int i7 = this.f46479c;
        int i8 = this.f46481e;
        if (i6 > i7 - i8 || i6 < 0) {
            S(i6);
        } else {
            this.f46481e = i8 + i6;
        }
    }

    public void a(int i6) throws InvalidProtocolBufferException {
        if (this.f46483g != i6) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public int e() {
        int i6 = this.f46486j;
        if (i6 == Integer.MAX_VALUE) {
            return -1;
        }
        return i6 - (this.f46485i + this.f46481e);
    }

    public boolean f() throws IOException {
        return this.f46481e == this.f46479c && !T(1);
    }

    public void i(int i6) {
        this.f46486j = i6;
        N();
    }

    public int j(int i6) throws InvalidProtocolBufferException {
        if (i6 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i7 = i6 + this.f46485i + this.f46481e;
        int i8 = this.f46486j;
        if (i7 > i8) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        this.f46486j = i7;
        N();
        return i8;
    }

    public void r(int i6, n.a aVar, f fVar) throws IOException {
        int i7 = this.f46487k;
        if (i7 >= this.f46488l) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        this.f46487k = i7 + 1;
        aVar.e(this, fVar);
        a(WireFormat.c(i6, 4));
        this.f46487k--;
    }

    public byte w() throws IOException {
        if (this.f46481e == this.f46479c) {
            O(1);
        }
        byte[] bArr = this.f46477a;
        int i6 = this.f46481e;
        this.f46481e = i6 + 1;
        return bArr[i6];
    }

    public int y() throws IOException {
        int i6 = this.f46481e;
        if (this.f46479c - i6 < 4) {
            O(4);
            i6 = this.f46481e;
        }
        byte[] bArr = this.f46477a;
        this.f46481e = i6 + 4;
        return ((bArr[i6 + 3] & 255) << 24) | (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16);
    }

    public long z() throws IOException {
        int i6 = this.f46481e;
        if (this.f46479c - i6 < 8) {
            O(8);
            i6 = this.f46481e;
        }
        byte[] bArr = this.f46477a;
        this.f46481e = i6 + 8;
        return ((bArr[i6 + 7] & 255) << 56) | (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16) | ((bArr[i6 + 3] & 255) << 24) | ((bArr[i6 + 4] & 255) << 32) | ((bArr[i6 + 5] & 255) << 40) | ((bArr[i6 + 6] & 255) << 48);
    }

    private void O(int i6) throws IOException {
        if (T(i6)) {
        } else {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public int E() throws IOException {
        return y();
    }

    public long F() throws IOException {
        return z();
    }

    public int G() throws IOException {
        return b(A());
    }

    public long H() throws IOException {
        return c(C());
    }

    public String I() throws IOException {
        int A = A();
        int i6 = this.f46479c;
        int i7 = this.f46481e;
        if (A <= i6 - i7 && A > 0) {
            String str = new String(this.f46477a, i7, A, "UTF-8");
            this.f46481e += A;
            return str;
        }
        if (A == 0) {
            return "";
        }
        return new String(x(A), "UTF-8");
    }

    public String J() throws IOException {
        byte[] x5;
        int A = A();
        int i6 = this.f46481e;
        if (A <= this.f46479c - i6 && A > 0) {
            x5 = this.f46477a;
            this.f46481e = i6 + A;
        } else {
            if (A == 0) {
                return "";
            }
            x5 = x(A);
            i6 = 0;
        }
        if (u.f(x5, i6, i6 + A)) {
            return new String(x5, i6, A, "UTF-8");
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    public int K() throws IOException {
        if (f()) {
            this.f46483g = 0;
            return 0;
        }
        int A = A();
        this.f46483g = A;
        if (WireFormat.a(A) != 0) {
            return this.f46483g;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int L() throws IOException {
        return A();
    }

    public long M() throws IOException {
        return C();
    }

    public boolean P(int i6, CodedOutputStream codedOutputStream) throws IOException {
        int b6 = WireFormat.b(i6);
        if (b6 != 0) {
            if (b6 != 1) {
                if (b6 != 2) {
                    if (b6 != 3) {
                        if (b6 != 4) {
                            if (b6 == 5) {
                                int y5 = y();
                                codedOutputStream.s0(i6);
                                codedOutputStream.Y(y5);
                                return true;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        return false;
                    }
                    codedOutputStream.s0(i6);
                    Q(codedOutputStream);
                    int c6 = WireFormat.c(WireFormat.a(i6), 4);
                    a(c6);
                    codedOutputStream.s0(c6);
                    return true;
                }
                d l6 = l();
                codedOutputStream.s0(i6);
                codedOutputStream.T(l6);
                return true;
            }
            long z5 = z();
            codedOutputStream.s0(i6);
            codedOutputStream.Z(z5);
            return true;
        }
        long t5 = t();
        codedOutputStream.s0(i6);
        codedOutputStream.D0(t5);
        return true;
    }

    public void Q(CodedOutputStream codedOutputStream) throws IOException {
        int K;
        do {
            K = K();
            if (K == 0) {
                return;
            }
        } while (P(K, codedOutputStream));
    }

    public boolean k() throws IOException {
        if (C() != 0) {
            return true;
        }
        return false;
    }

    public d l() throws IOException {
        d g6;
        int A = A();
        int i6 = this.f46479c;
        int i7 = this.f46481e;
        if (A <= i6 - i7 && A > 0) {
            if (this.f46478b && this.f46484h) {
                g6 = new c(this.f46477a, this.f46481e, A);
            } else {
                g6 = d.g(this.f46477a, i7, A);
            }
            this.f46481e += A;
            return g6;
        }
        if (A == 0) {
            return d.f46469a;
        }
        return new m(x(A));
    }

    public double m() throws IOException {
        return Double.longBitsToDouble(z());
    }

    public int n() throws IOException {
        return A();
    }

    public int o() throws IOException {
        return y();
    }

    public long p() throws IOException {
        return z();
    }

    public float q() throws IOException {
        return Float.intBitsToFloat(y());
    }

    public int s() throws IOException {
        return A();
    }

    public long t() throws IOException {
        return C();
    }

    public <T extends n> T u(p<T> pVar, f fVar) throws IOException {
        int A = A();
        if (this.f46487k < this.f46488l) {
            int j6 = j(A);
            this.f46487k++;
            T d6 = pVar.d(this, fVar);
            a(0);
            this.f46487k--;
            i(j6);
            return d6;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public void v(n.a aVar, f fVar) throws IOException {
        int A = A();
        if (this.f46487k < this.f46488l) {
            int j6 = j(A);
            this.f46487k++;
            aVar.e(this, fVar);
            a(0);
            this.f46487k--;
            i(j6);
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    private e(m mVar) {
        this.f46484h = false;
        this.f46486j = Integer.MAX_VALUE;
        this.f46488l = 64;
        this.f46489m = 67108864;
        this.f46490n = null;
        this.f46477a = mVar.f46513c;
        int E = mVar.E();
        this.f46481e = E;
        this.f46479c = E + mVar.size();
        this.f46485i = -this.f46481e;
        this.f46482f = null;
        this.f46478b = true;
    }
}
