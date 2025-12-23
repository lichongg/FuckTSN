package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class cj extends cq {

    /* renamed from: a, reason: collision with root package name */
    protected static final int f41092a = -65536;

    /* renamed from: b, reason: collision with root package name */
    protected static final int f41093b = -2147418112;

    /* renamed from: h, reason: collision with root package name */
    private static final cv f41094h = new cv();

    /* renamed from: c, reason: collision with root package name */
    protected boolean f41095c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f41096d;

    /* renamed from: e, reason: collision with root package name */
    protected int f41097e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f41098f;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f41099i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f41100j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f41101k;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f41102l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f41103m;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f41104n;

    /* renamed from: o, reason: collision with root package name */
    private byte[] f41105o;

    /* renamed from: p, reason: collision with root package name */
    private byte[] f41106p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements cs {

        /* renamed from: a, reason: collision with root package name */
        protected boolean f41107a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f41108b;

        /* renamed from: c, reason: collision with root package name */
        protected int f41109c;

        public a() {
            this(false, true);
        }

        public a(boolean z5, boolean z6) {
            this(z5, z6, 0);
        }

        @Override // com.umeng.analytics.pro.cs
        public cq a(de deVar) {
            cj cjVar = new cj(deVar, this.f41107a, this.f41108b);
            int i6 = this.f41109c;
            if (i6 != 0) {
                cjVar.c(i6);
            }
            return cjVar;
        }

        public a(boolean z5, boolean z6, int i6) {
            this.f41107a = z5;
            this.f41108b = z6;
            this.f41109c = i6;
        }
    }

    public cj(de deVar) {
        this(deVar, false, true);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void b() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void c() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void d() throws bx {
        a((byte) 0);
    }

    public cj(de deVar, boolean z5, boolean z6) {
        super(deVar);
        this.f41098f = false;
        this.f41099i = new byte[1];
        this.f41100j = new byte[2];
        this.f41101k = new byte[4];
        this.f41102l = new byte[8];
        this.f41103m = new byte[1];
        this.f41104n = new byte[2];
        this.f41105o = new byte[4];
        this.f41106p = new byte[8];
        this.f41095c = z5;
        this.f41096d = z6;
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cv cvVar) {
    }

    public String b(int i6) throws bx {
        try {
            d(i6);
            byte[] bArr = new byte[i6];
            this.f41155g.d(bArr, 0, i6);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new bx("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void c(int i6) {
        this.f41097e = i6;
        this.f41098f = true;
    }

    protected void d(int i6) throws bx {
        if (i6 < 0) {
            throw new cr("Negative length: " + i6);
        }
        if (this.f41098f) {
            int i7 = this.f41097e - i6;
            this.f41097e = i7;
            if (i7 >= 0) {
                return;
            }
            throw new cr("Message length exceeded: " + i6);
        }
    }

    @Override // com.umeng.analytics.pro.cq
    public cv j() {
        return f41094h;
    }

    @Override // com.umeng.analytics.pro.cq
    public cn n() throws bx {
        return new cn(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.cq
    public cm p() throws bx {
        return new cm(u(), w());
    }

    @Override // com.umeng.analytics.pro.cq
    public cu r() throws bx {
        return new cu(u(), w());
    }

    @Override // com.umeng.analytics.pro.cq
    public byte u() throws bx {
        if (this.f41155g.h() < 1) {
            a(this.f41103m, 0, 1);
            return this.f41103m[0];
        }
        byte b6 = this.f41155g.f()[this.f41155g.g()];
        this.f41155g.a(1);
        return b6;
    }

    @Override // com.umeng.analytics.pro.cq
    public short v() throws bx {
        int i6;
        byte[] bArr = this.f41104n;
        if (this.f41155g.h() >= 2) {
            bArr = this.f41155g.f();
            i6 = this.f41155g.g();
            this.f41155g.a(2);
        } else {
            a(this.f41104n, 0, 2);
            i6 = 0;
        }
        return (short) ((bArr[i6 + 1] & 255) | ((bArr[i6] & 255) << 8));
    }

    @Override // com.umeng.analytics.pro.cq
    public int w() throws bx {
        int i6;
        byte[] bArr = this.f41105o;
        if (this.f41155g.h() >= 4) {
            bArr = this.f41155g.f();
            i6 = this.f41155g.g();
            this.f41155g.a(4);
        } else {
            a(this.f41105o, 0, 4);
            i6 = 0;
        }
        return (bArr[i6 + 3] & 255) | ((bArr[i6] & 255) << 24) | ((bArr[i6 + 1] & 255) << 16) | ((bArr[i6 + 2] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.cq
    public long x() throws bx {
        int i6;
        byte[] bArr = this.f41106p;
        if (this.f41155g.h() >= 8) {
            bArr = this.f41155g.f();
            i6 = this.f41155g.g();
            this.f41155g.a(8);
        } else {
            a(this.f41106p, 0, 8);
            i6 = 0;
        }
        return (bArr[i6 + 7] & 255) | ((bArr[i6] & 255) << 56) | ((bArr[i6 + 1] & 255) << 48) | ((bArr[i6 + 2] & 255) << 40) | ((bArr[i6 + 3] & 255) << 32) | ((bArr[i6 + 4] & 255) << 24) | ((bArr[i6 + 5] & 255) << 16) | ((bArr[i6 + 6] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.cq
    public ByteBuffer A() throws bx {
        int w5 = w();
        d(w5);
        if (this.f41155g.h() >= w5) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f41155g.f(), this.f41155g.g(), w5);
            this.f41155g.a(w5);
            return wrap;
        }
        byte[] bArr = new byte[w5];
        this.f41155g.d(bArr, 0, w5);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(co coVar) throws bx {
        if (this.f41096d) {
            a(f41093b | coVar.f41149b);
            a(coVar.f41148a);
            a(coVar.f41150c);
        } else {
            a(coVar.f41148a);
            a(coVar.f41149b);
            a(coVar.f41150c);
        }
    }

    @Override // com.umeng.analytics.pro.cq
    public co h() throws bx {
        int w5 = w();
        if (w5 < 0) {
            if (((-65536) & w5) == f41093b) {
                return new co(z(), (byte) (w5 & 255), w());
            }
            throw new cr(4, "Bad version in readMessageBegin");
        }
        if (!this.f41095c) {
            return new co(b(w5), u(), w());
        }
        throw new cr(4, "Missing version in readMessageBegin, old client?");
    }

    @Override // com.umeng.analytics.pro.cq
    public cl l() throws bx {
        short v5;
        byte u5 = u();
        if (u5 == 0) {
            v5 = 0;
        } else {
            v5 = v();
        }
        return new cl("", u5, v5);
    }

    @Override // com.umeng.analytics.pro.cq
    public boolean t() throws bx {
        if (u() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.umeng.analytics.pro.cq
    public double y() throws bx {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.cq
    public String z() throws bx {
        int w5 = w();
        if (this.f41155g.h() >= w5) {
            try {
                String str = new String(this.f41155g.f(), this.f41155g.g(), w5, "UTF-8");
                this.f41155g.a(w5);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new bx("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return b(w5);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cl clVar) throws bx {
        a(clVar.f41141b);
        a(clVar.f41142c);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cn cnVar) throws bx {
        a(cnVar.f41145a);
        a(cnVar.f41146b);
        a(cnVar.f41147c);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cm cmVar) throws bx {
        a(cmVar.f41143a);
        a(cmVar.f41144b);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(cu cuVar) throws bx {
        a(cuVar.f41165a);
        a(cuVar.f41166b);
    }

    @Override // com.umeng.analytics.pro.cq
    public void e() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void f() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void g() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void i() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void k() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void m() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void o() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void q() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void s() {
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(boolean z5) throws bx {
        a(z5 ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(byte b6) throws bx {
        byte[] bArr = this.f41099i;
        bArr[0] = b6;
        this.f41155g.b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(short s5) throws bx {
        byte[] bArr = this.f41100j;
        bArr[0] = (byte) ((s5 >> 8) & 255);
        bArr[1] = (byte) (s5 & 255);
        this.f41155g.b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(int i6) throws bx {
        byte[] bArr = this.f41101k;
        bArr[0] = (byte) ((i6 >> 24) & 255);
        bArr[1] = (byte) ((i6 >> 16) & 255);
        bArr[2] = (byte) ((i6 >> 8) & 255);
        bArr[3] = (byte) (i6 & 255);
        this.f41155g.b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(long j6) throws bx {
        byte[] bArr = this.f41102l;
        bArr[0] = (byte) ((j6 >> 56) & 255);
        bArr[1] = (byte) ((j6 >> 48) & 255);
        bArr[2] = (byte) ((j6 >> 40) & 255);
        bArr[3] = (byte) ((j6 >> 32) & 255);
        bArr[4] = (byte) ((j6 >> 24) & 255);
        bArr[5] = (byte) ((j6 >> 16) & 255);
        bArr[6] = (byte) ((j6 >> 8) & 255);
        bArr[7] = (byte) (j6 & 255);
        this.f41155g.b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(double d6) throws bx {
        a(Double.doubleToLongBits(d6));
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(String str) throws bx {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.f41155g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bx("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.cq
    public void a(ByteBuffer byteBuffer) throws bx {
        int limit = byteBuffer.limit() - byteBuffer.position();
        a(limit);
        this.f41155g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    private int a(byte[] bArr, int i6, int i7) throws bx {
        d(i7);
        return this.f41155g.d(bArr, i6, i7);
    }
}
