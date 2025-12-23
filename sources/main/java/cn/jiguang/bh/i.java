package cn.jiguang.bh;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class i implements Serializable, Cloneable, Comparable {

    /* renamed from: e, reason: collision with root package name */
    private static final DecimalFormat f2195e;

    /* renamed from: a, reason: collision with root package name */
    protected g f2196a;

    /* renamed from: b, reason: collision with root package name */
    protected int f2197b;

    /* renamed from: c, reason: collision with root package name */
    protected int f2198c;

    /* renamed from: d, reason: collision with root package name */
    protected long f2199d;

    static i a(b bVar, int i6) {
        g gVar = new g(bVar);
        int g6 = bVar.g();
        int g7 = bVar.g();
        return i6 == 0 ? a(gVar, g6, g7) : a(gVar, g6, g7, bVar.h(), bVar.g(), bVar);
    }

    abstract void a(b bVar);

    abstract void a(c cVar, a aVar, boolean z5);

    abstract String b();

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof i)) {
            i iVar = (i) obj;
            if (this.f2197b == iVar.f2197b && this.f2198c == iVar.f2198c && this.f2196a.equals(iVar.f2196a)) {
                return Arrays.equals(a(), iVar.a());
            }
        }
        return false;
    }

    public int hashCode() {
        int i6 = 0;
        for (byte b6 : a(true)) {
            i6 += (i6 << 3) + (b6 & 255);
        }
        return i6;
    }

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        f2195e = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    public static i a(g gVar, int i6, int i7) {
        return a(gVar, i6, i7, 0L);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        i iVar = (i) obj;
        if (this == iVar) {
            return 0;
        }
        int compareTo = this.f2196a.compareTo(iVar.f2196a);
        if (compareTo != 0) {
            return compareTo;
        }
        int i6 = this.f2198c - iVar.f2198c;
        if (i6 != 0) {
            return i6;
        }
        int i7 = this.f2197b - iVar.f2197b;
        if (i7 != 0) {
            return i7;
        }
        byte[] a6 = a();
        byte[] a7 = iVar.a();
        for (int i8 = 0; i8 < a6.length && i8 < a7.length; i8++) {
            int i9 = (a6[i8] & 255) - (a7[i8] & 255);
            if (i9 != 0) {
                return i9;
            }
        }
        return a6.length - a7.length;
    }

    public g d() {
        return this.f2196a;
    }

    public int e() {
        return this.f2197b;
    }

    public int f() {
        return this.f2197b;
    }

    public int g() {
        return this.f2198c;
    }

    public long h() {
        return this.f2199d;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f2196a);
        if (stringBuffer.length() < 8) {
            stringBuffer.append("\t");
        }
        if (stringBuffer.length() < 16) {
            stringBuffer.append("\t");
        }
        stringBuffer.append("\t");
        String b6 = b();
        if (!b6.equals("")) {
            stringBuffer.append("\t");
            stringBuffer.append(b6);
        }
        return stringBuffer.toString();
    }

    protected i() {
    }

    public static i a(g gVar, int i6, int i7, long j6) {
        if (gVar.a()) {
            return a(gVar, i6, i7, j6, false);
        }
        throw new j(gVar);
    }

    public String c() {
        return b();
    }

    i i() {
        try {
            return (i) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    private static i a(g gVar, int i6, int i7, long j6, int i8, b bVar) {
        i a6 = a(gVar, i6, i7, j6, bVar != null);
        if (bVar == null) {
            return a6;
        }
        if (bVar.b() < i8) {
            throw new IOException("truncated record");
        }
        bVar.a(i8);
        a6.a(bVar);
        if (bVar.b() > 0) {
            throw new IOException("invalid record length");
        }
        bVar.c();
        return a6;
    }

    private static final i a(g gVar, int i6, int i7, long j6, boolean z5) {
        m mVar = new m();
        mVar.f2196a = gVar;
        mVar.f2197b = i6;
        mVar.f2198c = i7;
        mVar.f2199d = j6;
        return mVar;
    }

    void a(long j6) {
        this.f2199d = j6;
    }

    void a(c cVar, int i6, a aVar) {
        this.f2196a.a(cVar, aVar);
        cVar.c(this.f2197b);
        cVar.c(this.f2198c);
    }

    private void a(c cVar, boolean z5) {
        this.f2196a.a(cVar);
        cVar.c(this.f2197b);
        cVar.c(this.f2198c);
        cVar.a(z5 ? 0L : this.f2199d);
        int a6 = cVar.a();
        cVar.c(0);
        a(cVar, (a) null, true);
        cVar.a((cVar.a() - a6) - 2, a6);
    }

    public boolean a(i iVar) {
        return f() == iVar.f() && this.f2198c == iVar.f2198c && this.f2196a.equals(iVar.f2196a);
    }

    public byte[] a() {
        c cVar = new c();
        a(cVar, (a) null, true);
        return cVar.b();
    }

    private byte[] a(boolean z5) {
        c cVar = new c();
        a(cVar, z5);
        return cVar.b();
    }
}
