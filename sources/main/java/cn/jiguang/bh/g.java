package cn.jiguang.bh;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;

/* loaded from: D:\Downloads\app\classes2.dex */
public class g implements Serializable, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public static final g f2182a;

    /* renamed from: b, reason: collision with root package name */
    public static final g f2183b;

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f2184f = {0};

    /* renamed from: g, reason: collision with root package name */
    private static final byte[] f2185g = {1, 42};

    /* renamed from: h, reason: collision with root package name */
    private static final DecimalFormat f2186h;

    /* renamed from: i, reason: collision with root package name */
    private static final byte[] f2187i;

    /* renamed from: j, reason: collision with root package name */
    private static final g f2188j;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f2189c;

    /* renamed from: d, reason: collision with root package name */
    private long f2190d;

    /* renamed from: e, reason: collision with root package name */
    private int f2191e;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        f2186h = decimalFormat;
        f2187i = new byte[256];
        decimalFormat.setMinimumIntegerDigits(3);
        int i6 = 0;
        while (true) {
            byte[] bArr = f2187i;
            if (i6 >= bArr.length) {
                g gVar = new g();
                f2182a = gVar;
                gVar.b(f2184f, 0, 1);
                g gVar2 = new g();
                f2183b = gVar2;
                gVar2.f2189c = new byte[0];
                g gVar3 = new g();
                f2188j = gVar3;
                gVar3.b(f2185g, 0, 1);
                return;
            }
            if (i6 < 65 || i6 > 90) {
                bArr[i6] = (byte) i6;
            } else {
                bArr[i6] = (byte) (i6 + 32);
            }
            i6++;
        }
    }

    private g() {
    }

    private final int a(int i6) {
        if (i6 == 0 && d() == 0) {
            return 0;
        }
        if (i6 < 0 || i6 >= d()) {
            throw new IllegalArgumentException("label out of range");
        }
        if (i6 < 7) {
            return ((int) (this.f2190d >>> ((7 - i6) * 8))) & 255;
        }
        int a6 = a(6);
        for (int i7 = 6; i7 < i6; i7++) {
            a6 += this.f2189c[a6] + 1;
        }
        return a6;
    }

    public int b() {
        return d();
    }

    public String toString() {
        return a(false);
    }

    public g(b bVar) {
        byte[] bArr = new byte[64];
        boolean z5 = false;
        boolean z6 = false;
        while (!z5) {
            int f6 = bVar.f();
            int i6 = f6 & 192;
            if (i6 != 0) {
                if (i6 != 192) {
                    throw new IOException("bad label type");
                }
                int f7 = bVar.f() + ((f6 & (-193)) << 8);
                if (f7 >= bVar.a() - 2) {
                    throw new IOException("bad compression");
                }
                if (!z6) {
                    bVar.d();
                    z6 = true;
                }
                bVar.b(f7);
            } else {
                if (d() >= 128) {
                    throw new IOException("too many labels");
                }
                if (f6 == 0) {
                    a(f2184f, 0, 1);
                    z5 = true;
                } else {
                    bArr[0] = (byte) f6;
                    bVar.a(bArr, 1, f6);
                    a(bArr, 0, 1);
                }
            }
        }
        if (z6) {
            bVar.e();
        }
    }

    public static g a(g gVar, g gVar2) {
        if (gVar.a()) {
            return gVar;
        }
        g gVar3 = new g();
        b(gVar, gVar3);
        gVar3.a(gVar2.f2189c, gVar2.a(0), gVar2.d());
        return gVar3;
    }

    private final void b(int i6) {
        this.f2190d = (this.f2190d & (-256)) | i6;
    }

    private final int d() {
        return (int) (this.f2190d & 255);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        g gVar = (g) obj;
        if (this == gVar) {
            return 0;
        }
        int b6 = b();
        int b7 = gVar.b();
        int i6 = b6 > b7 ? b7 : b6;
        for (int i7 = 1; i7 <= i6; i7++) {
            int a6 = a(b6 - i7);
            int a7 = gVar.a(b7 - i7);
            byte b8 = this.f2189c[a6];
            byte b9 = gVar.f2189c[a7];
            for (int i8 = 0; i8 < b8 && i8 < b9; i8++) {
                byte[] bArr = f2187i;
                int i9 = bArr[this.f2189c[(i8 + a6) + 1] & 255] - bArr[gVar.f2189c[(i8 + a7) + 1] & 255];
                if (i9 != 0) {
                    return i9;
                }
            }
            if (b8 != b9) {
                return b8 - b9;
            }
        }
        return b6 - b7;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (gVar.f2191e == 0) {
            gVar.hashCode();
        }
        if (this.f2191e == 0) {
            hashCode();
        }
        if (gVar.f2191e == this.f2191e && gVar.b() == b()) {
            return b(gVar.f2189c, gVar.a(0));
        }
        return false;
    }

    public int hashCode() {
        int i6 = this.f2191e;
        if (i6 != 0) {
            return i6;
        }
        int i7 = 0;
        int a6 = a(0);
        while (true) {
            byte[] bArr = this.f2189c;
            if (a6 >= bArr.length) {
                this.f2191e = i7;
                return i7;
            }
            i7 += (i7 << 3) + f2187i[bArr[a6] & 255];
            a6++;
        }
    }

    public g(g gVar, int i6) {
        int b6 = gVar.b();
        if (i6 > b6) {
            throw new IllegalArgumentException("attempted to remove too many labels");
        }
        this.f2189c = gVar.f2189c;
        int i7 = b6 - i6;
        b(i7);
        for (int i8 = 0; i8 < 7 && i8 < i7; i8++) {
            a(i8, gVar.a(i8 + i6));
        }
    }

    public static g a(String str) {
        return a(str, (g) null);
    }

    private static final void b(g gVar, g gVar2) {
        if (gVar.a(0) == 0) {
            gVar2.f2189c = gVar.f2189c;
            gVar2.f2190d = gVar.f2190d;
            return;
        }
        int a6 = gVar.a(0);
        int length = gVar.f2189c.length - a6;
        int b6 = gVar.b();
        byte[] bArr = new byte[length];
        gVar2.f2189c = bArr;
        System.arraycopy(gVar.f2189c, a6, bArr, 0, length);
        for (int i6 = 0; i6 < b6 && i6 < 7; i6++) {
            gVar2.a(i6, gVar.a(i6) - a6);
        }
        gVar2.b(b6);
    }

    public byte[] c() {
        int b6 = b();
        if (b6 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[this.f2189c.length - a(0)];
        int a6 = a(0);
        int i6 = 0;
        for (int i7 = 0; i7 < b6; i7++) {
            byte b7 = this.f2189c[a6];
            if (b7 <= 63) {
                a6++;
                bArr[i6] = b7;
                i6++;
                int i8 = 0;
                while (i8 < b7) {
                    bArr[i6] = f2187i[this.f2189c[a6] & 255];
                    i8++;
                    i6++;
                    a6++;
                }
            } else {
                throw new IllegalStateException("invalid label");
            }
        }
        return bArr;
    }

    public g(String str, g gVar) {
        int i6;
        boolean z5;
        int i7;
        if (str.equals("")) {
            throw a(str, "empty name");
        }
        if (str.equals("@")) {
            if (gVar == null) {
                b(f2183b, this);
                return;
            } else {
                b(gVar, this);
                return;
            }
        }
        if (str.equals(".")) {
            b(f2182a, this);
            return;
        }
        byte[] bArr = new byte[64];
        int i8 = 0;
        boolean z6 = false;
        int i9 = -1;
        int i10 = 1;
        int i11 = 0;
        for (int i12 = 0; i12 < str.length(); i12++) {
            byte charAt = (byte) str.charAt(i12);
            if (z6) {
                if (charAt >= 48 && charAt <= 57 && i8 < 3) {
                    i8++;
                    i11 = (i11 * 10) + (charAt - 48);
                    if (i11 > 255) {
                        throw a(str, "bad escape");
                    }
                    if (i8 < 3) {
                        continue;
                    } else {
                        charAt = (byte) i11;
                    }
                } else if (i8 > 0 && i8 < 3) {
                    throw a(str, "bad escape");
                }
                if (i10 > 63) {
                    throw a(str, "label too long");
                }
                i7 = i10 + 1;
                bArr[i10] = charAt;
                i9 = i10;
                z6 = false;
                i10 = i7;
            } else {
                if (charAt == 92) {
                    i8 = 0;
                    z6 = true;
                    i11 = 0;
                } else if (charAt != 46) {
                    i9 = i9 == -1 ? i12 : i9;
                    if (i10 > 63) {
                        throw a(str, "label too long");
                    }
                    i7 = i10 + 1;
                    bArr[i10] = charAt;
                    i10 = i7;
                } else {
                    if (i9 == -1) {
                        throw a(str, "invalid empty label");
                    }
                    bArr[0] = (byte) (i10 - 1);
                    a(str, bArr, 0, 1);
                    i9 = -1;
                    i10 = 1;
                }
            }
        }
        if (i8 > 0 && i8 < 3) {
            throw a(str, "bad escape");
        }
        if (z6) {
            throw a(str, "bad escape");
        }
        if (i9 == -1) {
            z5 = true;
            i6 = 0;
            a(str, f2184f, 0, 1);
        } else {
            i6 = 0;
            bArr[0] = (byte) (i10 - 1);
            a(str, bArr, 0, 1);
            z5 = false;
        }
        if (gVar == null || z5) {
            return;
        }
        a(str, gVar.f2189c, gVar.a(i6), gVar.d());
    }

    public static g a(String str, g gVar) {
        return (!str.equals("@") || gVar == null) ? str.equals(".") ? f2182a : new g(str, gVar) : gVar;
    }

    private final void b(byte[] bArr, int i6, int i7) {
        try {
            a(bArr, i6, i7);
        } catch (Exception unused) {
        }
    }

    private static IOException a(String str, String str2) {
        return new IOException("'" + str + "': " + str2);
    }

    private final boolean b(byte[] bArr, int i6) {
        int b6 = b();
        int a6 = a(0);
        for (int i7 = 0; i7 < b6; i7++) {
            byte b7 = this.f2189c[a6];
            if (b7 != bArr[i6]) {
                return false;
            }
            a6++;
            i6++;
            if (b7 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i8 = 0;
            while (i8 < b7) {
                byte[] bArr2 = f2187i;
                int i9 = a6 + 1;
                int i10 = i6 + 1;
                if (bArr2[this.f2189c[a6] & 255] != bArr2[bArr[i6] & 255]) {
                    return false;
                }
                i8++;
                i6 = i10;
                a6 = i9;
            }
        }
        return true;
    }

    public String a(boolean z5) {
        int b6 = b();
        if (b6 == 0) {
            return "@";
        }
        int i6 = 0;
        if (b6 == 1 && this.f2189c[a(0)] == 0) {
            return ".";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int a6 = a(0);
        while (true) {
            if (i6 >= b6) {
                break;
            }
            byte b7 = this.f2189c[a6];
            if (b7 > 63) {
                throw new IllegalStateException("invalid label");
            }
            if (b7 != 0) {
                if (i6 > 0) {
                    stringBuffer.append('.');
                }
                stringBuffer.append(a(this.f2189c, a6));
                a6 += b7 + 1;
                i6++;
            } else if (!z5) {
                stringBuffer.append('.');
            }
        }
        return stringBuffer.toString();
    }

    private String a(byte[] bArr, int i6) {
        StringBuffer stringBuffer = new StringBuffer();
        int i7 = i6 + 1;
        int i8 = bArr[i6];
        for (int i9 = i7; i9 < i7 + i8; i9++) {
            int i10 = bArr[i9] & 255;
            if (i10 <= 32 || i10 >= 127) {
                stringBuffer.append('\\');
                stringBuffer.append(f2186h.format(i10));
            } else {
                if (i10 == 34 || i10 == 40 || i10 == 41 || i10 == 46 || i10 == 59 || i10 == 92 || i10 == 64 || i10 == 36) {
                    stringBuffer.append('\\');
                }
                stringBuffer.append((char) i10);
            }
        }
        return stringBuffer.toString();
    }

    private final void a(int i6, int i7) {
        if (i6 >= 7) {
            return;
        }
        int i8 = (7 - i6) * 8;
        this.f2190d = (i7 << i8) | (this.f2190d & (~(255 << i8)));
    }

    public void a(c cVar) {
        cVar.a(c());
    }

    public void a(c cVar, a aVar) {
        int b6 = b();
        int i6 = 0;
        while (i6 < b6 - 1) {
            g gVar = i6 == 0 ? this : new g(this, i6);
            int a6 = aVar != null ? aVar.a(gVar) : -1;
            if (a6 >= 0) {
                cVar.c(49152 | a6);
                return;
            }
            if (aVar != null) {
                aVar.a(cVar.a(), gVar);
            }
            int a7 = a(i6);
            byte[] bArr = this.f2189c;
            cVar.a(bArr, a7, bArr[a7] + 1);
            i6++;
        }
        cVar.b(0);
    }

    public void a(c cVar, a aVar, boolean z5) {
        if (z5) {
            a(cVar);
        } else {
            a(cVar, aVar);
        }
    }

    private final void a(String str, byte[] bArr, int i6, int i7) {
        try {
            a(bArr, i6, i7);
        } catch (Exception unused) {
            throw a(str, "Name too long");
        }
    }

    private final void a(byte[] bArr, int i6, int i7) {
        byte[] bArr2 = this.f2189c;
        int length = bArr2 == null ? 0 : bArr2.length - a(0);
        int i8 = i6;
        int i9 = 0;
        for (int i10 = 0; i10 < i7; i10++) {
            int i11 = bArr[i8];
            if (i11 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i12 = i11 + 1;
            i8 += i12;
            i9 += i12;
        }
        int i13 = length + i9;
        if (i13 > 255) {
            throw new IOException();
        }
        int d6 = d();
        int i14 = d6 + i7;
        if (i14 > 128) {
            throw new IllegalStateException("too many labels");
        }
        byte[] bArr3 = new byte[i13];
        if (length != 0) {
            System.arraycopy(this.f2189c, a(0), bArr3, 0, length);
        }
        System.arraycopy(bArr, i6, bArr3, length, i9);
        this.f2189c = bArr3;
        for (int i15 = 0; i15 < i7; i15++) {
            a(d6 + i15, length);
            length += bArr3[length] + 1;
        }
        b(i14);
    }

    public boolean a() {
        int b6 = b();
        return b6 != 0 && this.f2189c[a(b6 - 1)] == 0;
    }
}
