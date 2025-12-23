package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ck extends cq {

    /* renamed from: d, reason: collision with root package name */
    private static final cv f41110d = new cv("");

    /* renamed from: e, reason: collision with root package name */
    private static final cl f41111e = new cl("", (byte) 0, 0);

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f41112f = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};

    /* renamed from: h, reason: collision with root package name */
    private static final byte f41113h = -126;

    /* renamed from: i, reason: collision with root package name */
    private static final byte f41114i = 1;

    /* renamed from: j, reason: collision with root package name */
    private static final byte f41115j = 31;

    /* renamed from: k, reason: collision with root package name */
    private static final byte f41116k = -32;

    /* renamed from: l, reason: collision with root package name */
    private static final int f41117l = 5;

    /* renamed from: a, reason: collision with root package name */
    byte[] f41118a;

    /* renamed from: b, reason: collision with root package name */
    byte[] f41119b;

    /* renamed from: c, reason: collision with root package name */
    byte[] f41120c;

    /* renamed from: m, reason: collision with root package name */
    private bp f41121m;

    /* renamed from: n, reason: collision with root package name */
    private short f41122n;

    /* renamed from: o, reason: collision with root package name */
    private cl f41123o;

    /* renamed from: p, reason: collision with root package name */
    private Boolean f41124p;

    /* renamed from: q, reason: collision with root package name */
    private final long f41125q;

    /* renamed from: r, reason: collision with root package name */
    private byte[] f41126r;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements cs {

        /* renamed from: a, reason: collision with root package name */
        private final long f41127a;

        public a() {
            this.f41127a = -1L;
        }

        @Override // com.umeng.analytics.pro.cs
        public cq a(de deVar) {
            return new ck(deVar, this.f41127a);
        }

        public a(int i6) {
            this.f41127a = i6;
        }
    }

    public ck(de deVar, long j6) {
        super(deVar);
        this.f41121m = new bp(15);
        this.f41122n = (short) 0;
        this.f41123o = null;
        this.f41124p = null;
        this.f41118a = new byte[5];
        this.f41119b = new byte[10];
        this.f41126r = new byte[1];
        this.f41120c = new byte[1];
        this.f41125q = j6;
    }

    private int c(int i6) {
        return (i6 >> 31) ^ (i6 << 1);
    }

    private long d(long j6) {
        return (-(j6 & 1)) ^ (j6 >>> 1);
    }

    private int g(int i6) {
        return (-(i6 & 1)) ^ (i6 >>> 1);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public void b() throws bx {
        this.f41122n = this.f41121m.a();
    }

    @Override // com.umeng.analytics.pro.cq
    public void e() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public void f() throws bx {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final byte f41128a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final byte f41129b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static final byte f41130c = 3;

        /* renamed from: d, reason: collision with root package name */
        public static final byte f41131d = 4;

        /* renamed from: e, reason: collision with root package name */
        public static final byte f41132e = 5;

        /* renamed from: f, reason: collision with root package name */
        public static final byte f41133f = 6;

        /* renamed from: g, reason: collision with root package name */
        public static final byte f41134g = 7;

        /* renamed from: h, reason: collision with root package name */
        public static final byte f41135h = 8;

        /* renamed from: i, reason: collision with root package name */
        public static final byte f41136i = 9;

        /* renamed from: j, reason: collision with root package name */
        public static final byte f41137j = 10;

        /* renamed from: k, reason: collision with root package name */
        public static final byte f41138k = 11;

        /* renamed from: l, reason: collision with root package name */
        public static final byte f41139l = 12;

        private b() {
        }
    }

    private int E() throws bx {
        int i6 = 0;
        if (this.f41155g.h() >= 5) {
            byte[] f6 = this.f41155g.f();
            int g6 = this.f41155g.g();
            int i7 = 0;
            int i8 = 0;
            while (true) {
                byte b6 = f6[g6 + i6];
                i7 |= (b6 & Byte.MAX_VALUE) << i8;
                if ((b6 & 128) != 128) {
                    this.f41155g.a(i6 + 1);
                    return i7;
                }
                i8 += 7;
                i6++;
            }
        } else {
            int i9 = 0;
            while (true) {
                byte u5 = u();
                i6 |= (u5 & Byte.MAX_VALUE) << i9;
                if ((u5 & 128) != 128) {
                    return i6;
                }
                i9 += 7;
            }
        }
    }

    private long F() throws bx {
        int i6 = 0;
        long j6 = 0;
        if (this.f41155g.h() >= 10) {
            byte[] f6 = this.f41155g.f();
            int g6 = this.f41155g.g();
            long j7 = 0;
            int i7 = 0;
            while (true) {
                j7 |= (r7 & Byte.MAX_VALUE) << i7;
                if ((f6[g6 + i6] & 128) != 128) {
                    this.f41155g.a(i6 + 1);
                    return j7;
                }
                i7 += 7;
                i6++;
            }
        } else {
            while (true) {
                j6 |= (r0 & Byte.MAX_VALUE) << i6;
                if ((u() & 128) != 128) {
                    return j6;
                }
                i6 += 7;
            }
        }
    }

    private void b(int i6) throws bx {
        int i7 = 0;
        while ((i6 & (-128)) != 0) {
            this.f41118a[i7] = (byte) ((i6 & 127) | 128);
            i6 >>>= 7;
            i7++;
        }
        byte[] bArr = this.f41118a;
        bArr[i7] = (byte) i6;
        this.f41155g.b(bArr, 0, i7 + 1);
    }

    private long c(long j6) {
        return (j6 >> 63) ^ (j6 << 1);
    }

    private byte[] e(int i6) throws bx {
        if (i6 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i6];
        this.f41155g.d(bArr, 0, i6);
        return bArr;
    }

    private void f(int i6) throws cr {
        if (i6 < 0) {
            throw new cr("Negative length: " + i6);
        }
        long j6 = this.f41125q;
        if (j6 == -1 || i6 <= j6) {
            return;
        }
        throw new cr("Length exceeded max allowed: " + i6);
    }

    @Override // com.umeng.analytics.pro.cq
    public void B() {
        this.f41121m.c();
        this.f41122n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(co coVar) throws bx {
        b(f41113h);
        d(((coVar.f41149b << 5) & (-32)) | 1);
        b(coVar.f41150c);
        a(coVar.f41148a);
    }

    @Override // com.umeng.analytics.pro.cq
    public void d() throws bx {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.cq
    public void g() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public cv j() throws bx {
        this.f41121m.a(this.f41122n);
        this.f41122n = (short) 0;
        return f41110d;
    }

    @Override // com.umeng.analytics.pro.cq
    public void k() throws bx {
        this.f41122n = this.f41121m.a();
    }

    @Override // com.umeng.analytics.pro.cq
    public cu r() throws bx {
        return new cu(p());
    }

    @Override // com.umeng.analytics.pro.cq
    public boolean t() throws bx {
        Boolean bool = this.f41124p;
        if (bool == null) {
            return u() == 1;
        }
        boolean booleanValue = bool.booleanValue();
        this.f41124p = null;
        return booleanValue;
    }

    @Override // com.umeng.analytics.pro.cq
    public byte u() throws bx {
        if (this.f41155g.h() <= 0) {
            this.f41155g.d(this.f41120c, 0, 1);
            return this.f41120c[0];
        }
        byte b6 = this.f41155g.f()[this.f41155g.g()];
        this.f41155g.a(1);
        return b6;
    }

    @Override // com.umeng.analytics.pro.cq
    public double y() throws bx {
        byte[] bArr = new byte[8];
        this.f41155g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    private void d(int i6) throws bx {
        b((byte) i6);
    }

    @Override // com.umeng.analytics.pro.cq
    public ByteBuffer A() throws bx {
        int E = E();
        f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.f41155g.d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.cq
    public void c() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public co h() throws bx {
        byte u5 = u();
        if (u5 == -126) {
            byte u6 = u();
            byte b6 = (byte) (u6 & 31);
            if (b6 == 1) {
                return new co(z(), (byte) ((u6 >> 5) & 3), E());
            }
            throw new cr("Expected version 1 but got " + ((int) b6));
        }
        throw new cr("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(u5));
    }

    @Override // com.umeng.analytics.pro.cq
    public cl l() throws bx {
        short s5;
        Boolean bool;
        byte u5 = u();
        if (u5 == 0) {
            return f41111e;
        }
        short s6 = (short) ((u5 & 240) >> 4);
        if (s6 == 0) {
            s5 = v();
        } else {
            s5 = (short) (this.f41122n + s6);
        }
        byte b6 = (byte) (u5 & 15);
        cl clVar = new cl("", d(b6), s5);
        if (c(u5)) {
            if (b6 == 1) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            this.f41124p = bool;
        }
        this.f41122n = clVar.f41142c;
        return clVar;
    }

    @Override // com.umeng.analytics.pro.cq
    public cn n() throws bx {
        byte u5;
        int E = E();
        if (E == 0) {
            u5 = 0;
        } else {
            u5 = u();
        }
        return new cn(d((byte) (u5 >> 4)), d((byte) (u5 & 15)), E);
    }

    @Override // com.umeng.analytics.pro.cq
    public cm p() throws bx {
        byte u5 = u();
        int i6 = (u5 >> 4) & 15;
        if (i6 == 15) {
            i6 = E();
        }
        return new cm(d(u5), i6);
    }

    @Override // com.umeng.analytics.pro.cq
    public short v() throws bx {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.cq
    public int w() throws bx {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.cq
    public long x() throws bx {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.cq
    public String z() throws bx {
        int E = E();
        f(E);
        if (E == 0) {
            return "";
        }
        try {
            if (this.f41155g.h() >= E) {
                String str = new String(this.f41155g.f(), this.f41155g.g(), E, "UTF-8");
                this.f41155g.a(E);
                return str;
            }
            return new String(e(E), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new bx("UTF-8 not supported!");
        }
    }

    private boolean c(byte b6) {
        int i6 = b6 & 15;
        return i6 == 1 || i6 == 2;
    }

    private byte d(byte b6) throws cr {
        byte b7 = (byte) (b6 & 15);
        switch (b7) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return (byte) 15;
            case 10:
                return (byte) 14;
            case 11:
                return (byte) 13;
            case 12:
                return (byte) 12;
            default:
                throw new cr("don't know what type: " + ((int) b7));
        }
    }

    private void b(long j6) throws bx {
        int i6 = 0;
        while (((-128) & j6) != 0) {
            this.f41119b[i6] = (byte) ((127 & j6) | 128);
            j6 >>>= 7;
            i6++;
        }
        byte[] bArr = this.f41119b;
        bArr[i6] = (byte) j6;
        this.f41155g.b(bArr, 0, i6 + 1);
    }

    private byte e(byte b6) {
        return f41112f[b6];
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cv cvVar) throws bx {
        this.f41121m.a(this.f41122n);
        this.f41122n = (short) 0;
    }

    private void b(byte b6) throws bx {
        byte[] bArr = this.f41126r;
        bArr[0] = b6;
        this.f41155g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cl clVar) throws bx {
        if (clVar.f41141b == 2) {
            this.f41123o = clVar;
        } else {
            a(clVar, (byte) -1);
        }
    }

    public ck(de deVar) {
        this(deVar, -1L);
    }

    private void a(cl clVar, byte b6) throws bx {
        if (b6 == -1) {
            b6 = e(clVar.f41141b);
        }
        short s5 = clVar.f41142c;
        short s6 = this.f41122n;
        if (s5 > s6 && s5 - s6 <= 15) {
            d(b6 | ((s5 - s6) << 4));
        } else {
            b(b6);
            a(clVar.f41142c);
        }
        this.f41122n = clVar.f41142c;
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cn cnVar) throws bx {
        int i6 = cnVar.f41147c;
        if (i6 == 0) {
            d(0);
            return;
        }
        b(i6);
        d(e(cnVar.f41146b) | (e(cnVar.f41145a) << 4));
    }

    @Override // com.umeng.analytics.pro.cq
    public void i() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public void m() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public void o() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public void q() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public void s() throws bx {
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cm cmVar) throws bx {
        a(cmVar.f41143a, cmVar.f41144b);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cu cuVar) throws bx {
        a(cuVar.f41165a, cuVar.f41166b);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(boolean z5) throws bx {
        cl clVar = this.f41123o;
        if (clVar != null) {
            a(clVar, z5 ? (byte) 1 : (byte) 2);
            this.f41123o = null;
        } else {
            b(z5 ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(byte b6) throws bx {
        b(b6);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(short s5) throws bx {
        b(c((int) s5));
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(int i6) throws bx {
        b(c(i6));
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(long j6) throws bx {
        b(c(j6));
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(double d6) throws bx {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d6), bArr, 0);
        this.f41155g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(String str) throws bx {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bx("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(ByteBuffer byteBuffer) throws bx {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i6, int i7) throws bx {
        b(i7);
        this.f41155g.b(bArr, i6, i7);
    }

    protected void a(byte b6, int i6) throws bx {
        if (i6 <= 14) {
            d(e(b6) | (i6 << 4));
        } else {
            d(e(b6) | 240);
            b(i6);
        }
    }

    private void a(long j6, byte[] bArr, int i6) {
        bArr[i6] = (byte) (j6 & 255);
        bArr[i6 + 1] = (byte) ((j6 >> 8) & 255);
        bArr[i6 + 2] = (byte) ((j6 >> 16) & 255);
        bArr[i6 + 3] = (byte) ((j6 >> 24) & 255);
        bArr[i6 + 4] = (byte) ((j6 >> 32) & 255);
        bArr[i6 + 5] = (byte) ((j6 >> 40) & 255);
        bArr[i6 + 6] = (byte) ((j6 >> 48) & 255);
        bArr[i6 + 7] = (byte) ((j6 >> 56) & 255);
    }

    private long a(byte[] bArr) {
        return ((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (255 & bArr[0]);
    }
}
