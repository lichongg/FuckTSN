package com.sun.mail.iap;

import com.baidu.mobads.sdk.internal.ca;
import com.sun.mail.util.ASCIIUtility;
import io.netty.util.internal.StringUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class g {

    /* renamed from: g, reason: collision with root package name */
    private static final int f39196g = 100;

    /* renamed from: h, reason: collision with root package name */
    public static final int f39197h = 3;

    /* renamed from: i, reason: collision with root package name */
    public static final int f39198i = 1;

    /* renamed from: j, reason: collision with root package name */
    public static final int f39199j = 2;

    /* renamed from: k, reason: collision with root package name */
    public static final int f39200k = 3;

    /* renamed from: l, reason: collision with root package name */
    public static final int f39201l = 28;

    /* renamed from: m, reason: collision with root package name */
    public static final int f39202m = 4;

    /* renamed from: n, reason: collision with root package name */
    public static final int f39203n = 8;

    /* renamed from: o, reason: collision with root package name */
    public static final int f39204o = 12;

    /* renamed from: p, reason: collision with root package name */
    public static final int f39205p = 16;

    /* renamed from: q, reason: collision with root package name */
    public static final int f39206q = 32;

    /* renamed from: a, reason: collision with root package name */
    protected int f39207a;

    /* renamed from: b, reason: collision with root package name */
    protected int f39208b;

    /* renamed from: c, reason: collision with root package name */
    protected int f39209c;

    /* renamed from: d, reason: collision with root package name */
    protected byte[] f39210d;

    /* renamed from: e, reason: collision with root package name */
    protected int f39211e;

    /* renamed from: f, reason: collision with root package name */
    protected String f39212f;

    public g(String str) {
        this.f39210d = null;
        this.f39211e = 0;
        this.f39212f = null;
        byte[] bytes = ASCIIUtility.getBytes(str);
        this.f39210d = bytes;
        this.f39209c = bytes.length;
        l();
    }

    private void l() {
        this.f39207a = 0;
        byte b6 = this.f39210d[0];
        if (b6 == 43) {
            this.f39211e |= 1;
            this.f39207a = 1;
            return;
        }
        if (b6 == 42) {
            this.f39211e |= 3;
            this.f39207a = 1;
        } else {
            this.f39211e |= 2;
            this.f39212f = o();
        }
        int i6 = this.f39207a;
        String o5 = o();
        if (o5 == null) {
            o5 = "";
        }
        if (o5.equalsIgnoreCase(ca.f10845k)) {
            this.f39211e |= 4;
        } else if (o5.equalsIgnoreCase("NO")) {
            this.f39211e |= 8;
        } else if (o5.equalsIgnoreCase("BAD")) {
            this.f39211e |= 12;
        } else if (o5.equalsIgnoreCase("BYE")) {
            this.f39211e |= 16;
        } else {
            this.f39207a = i6;
        }
        this.f39208b = this.f39207a;
    }

    public String o() {
        return p((char) 0);
    }

    public String q() {
        return (String) m(true, true);
    }

    public String w() {
        return (String) m(false, true);
    }

    public static g a(Exception exc) {
        g gVar = new g(("* BYE JavaMail Exception: " + exc.toString()).replace(StringUtil.CARRIAGE_RETURN, ' ').replace('\n', ' '));
        gVar.f39211e = gVar.f39211e | 32;
        return gVar;
    }

    public void A(int i6) {
        this.f39207a += i6;
    }

    public void B() {
        while (true) {
            int i6 = this.f39207a;
            if (i6 >= this.f39209c || this.f39210d[i6] != 32) {
                return;
            } else {
                this.f39207a = i6 + 1;
            }
        }
    }

    public void C() {
        while (true) {
            int i6 = this.f39207a;
            if (i6 >= this.f39209c || this.f39210d[i6] == 32) {
                return;
            } else {
                this.f39207a = i6 + 1;
            }
        }
    }

    public String c() {
        return this.f39212f;
    }

    public boolean d() {
        return (this.f39211e & 28) == 12;
    }

    public boolean e() {
        return (this.f39211e & 28) == 16;
    }

    public boolean f() {
        return (this.f39211e & 3) == 1;
    }

    public boolean g() {
        return (this.f39211e & 28) == 8;
    }

    public int getType() {
        return this.f39211e;
    }

    public boolean h() {
        return (this.f39211e & 28) == 4;
    }

    public boolean i() {
        return (this.f39211e & 32) == 32;
    }

    public boolean j() {
        return (this.f39211e & 3) == 2;
    }

    public boolean k() {
        return (this.f39211e & 3) == 3;
    }

    public byte n() {
        int i6 = this.f39207a;
        if (i6 < this.f39209c) {
            return this.f39210d[i6];
        }
        return (byte) 0;
    }

    public byte r() {
        int i6 = this.f39207a;
        if (i6 >= this.f39209c) {
            return (byte) 0;
        }
        byte[] bArr = this.f39210d;
        this.f39207a = i6 + 1;
        return bArr[i6];
    }

    public String toString() {
        return ASCIIUtility.toString(this.f39210d, 0, this.f39209c);
    }

    public void z() {
        this.f39207a = this.f39208b;
    }

    private Object m(boolean z5, boolean z6) {
        byte[] bArr;
        int i6;
        byte[] bArr2;
        int i7;
        B();
        byte[] bArr3 = this.f39210d;
        int i8 = this.f39207a;
        byte b6 = bArr3[i8];
        if (b6 == 34) {
            int i9 = i8 + 1;
            this.f39207a = i9;
            int i10 = i9;
            while (true) {
                bArr2 = this.f39210d;
                i7 = this.f39207a;
                byte b7 = bArr2[i7];
                if (b7 == 34) {
                    break;
                }
                if (b7 == 92) {
                    this.f39207a = i7 + 1;
                }
                int i11 = this.f39207a;
                if (i11 != i10) {
                    bArr2[i10] = bArr2[i11];
                }
                i10++;
                this.f39207a = i11 + 1;
            }
            this.f39207a = i7 + 1;
            if (z6) {
                return ASCIIUtility.toString(bArr2, i9, i10);
            }
            return new d(bArr2, i9, i10 - i9);
        }
        if (b6 == 123) {
            int i12 = i8 + 1;
            this.f39207a = i12;
            while (true) {
                bArr = this.f39210d;
                i6 = this.f39207a;
                if (bArr[i6] == 125) {
                    try {
                        break;
                    } catch (NumberFormatException unused) {
                        return null;
                    }
                }
                this.f39207a = i6 + 1;
            }
            int parseInt = ASCIIUtility.parseInt(bArr, i12, i6);
            int i13 = this.f39207a + 3;
            int i14 = i13 + parseInt;
            this.f39207a = i14;
            if (z6) {
                return ASCIIUtility.toString(this.f39210d, i13, i14);
            }
            return new d(this.f39210d, i13, parseInt);
        }
        if (z5) {
            String o5 = o();
            if (z6) {
                return o5;
            }
            return new d(this.f39210d, i8, this.f39207a);
        }
        if (b6 != 78 && b6 != 110) {
            return null;
        }
        this.f39207a = i8 + 3;
        return null;
    }

    public String b() {
        B();
        return ASCIIUtility.toString(this.f39210d, this.f39207a, this.f39209c);
    }

    public String p(char c6) {
        int i6;
        byte b6;
        B();
        int i7 = this.f39207a;
        if (i7 >= this.f39209c) {
            return null;
        }
        while (true) {
            i6 = this.f39207a;
            if (i6 >= this.f39209c || (b6 = this.f39210d[i6]) <= 32 || b6 == 40 || b6 == 41 || b6 == 37 || b6 == 42 || b6 == 34 || b6 == 92 || b6 == Byte.MAX_VALUE || (c6 != 0 && b6 == c6)) {
                break;
            }
            this.f39207a = i6 + 1;
        }
        return ASCIIUtility.toString(this.f39210d, i7, i6);
    }

    public d s() {
        if (f()) {
            B();
            byte[] bArr = this.f39210d;
            int i6 = this.f39207a;
            return new d(bArr, i6, this.f39209c - i6);
        }
        return (d) m(false, false);
    }

    public ByteArrayInputStream t() {
        d s5 = s();
        if (s5 != null) {
            return s5.g();
        }
        return null;
    }

    public long u() {
        B();
        int i6 = this.f39207a;
        while (true) {
            int i7 = this.f39207a;
            if (i7 >= this.f39209c || !Character.isDigit((char) this.f39210d[i7])) {
                break;
            }
            this.f39207a++;
        }
        int i8 = this.f39207a;
        if (i8 > i6) {
            try {
                return ASCIIUtility.parseLong(this.f39210d, i6, i8);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
        return -1L;
    }

    public int v() {
        B();
        int i6 = this.f39207a;
        while (true) {
            int i7 = this.f39207a;
            if (i7 >= this.f39209c || !Character.isDigit((char) this.f39210d[i7])) {
                break;
            }
            this.f39207a++;
        }
        int i8 = this.f39207a;
        if (i8 > i6) {
            try {
                return ASCIIUtility.parseInt(this.f39210d, i6, i8);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return -1;
    }

    public String x(char c6) {
        int i6;
        B();
        int i7 = this.f39207a;
        if (i7 >= this.f39209c) {
            return null;
        }
        while (true) {
            i6 = this.f39207a;
            if (i6 >= this.f39209c || this.f39210d[i6] == c6) {
                break;
            }
            this.f39207a = i6 + 1;
        }
        return ASCIIUtility.toString(this.f39210d, i7, i6);
    }

    public String[] y() {
        byte[] bArr;
        int i6;
        B();
        byte[] bArr2 = this.f39210d;
        int i7 = this.f39207a;
        if (bArr2[i7] != 40) {
            return null;
        }
        this.f39207a = i7 + 1;
        Vector vector = new Vector();
        do {
            vector.addElement(w());
            bArr = this.f39210d;
            i6 = this.f39207a;
            this.f39207a = i6 + 1;
        } while (bArr[i6] != 41);
        int size = vector.size();
        if (size <= 0) {
            return null;
        }
        String[] strArr = new String[size];
        vector.copyInto(strArr);
        return strArr;
    }

    public g(f fVar) throws IOException, ProtocolException {
        this.f39210d = null;
        this.f39211e = 0;
        this.f39212f = null;
        this.f39210d = fVar.d().b(fVar.f()).a();
        this.f39209c = r3.b() - 2;
        l();
    }

    public g(g gVar) {
        this.f39210d = null;
        this.f39211e = 0;
        this.f39212f = null;
        this.f39207a = gVar.f39207a;
        this.f39209c = gVar.f39209c;
        this.f39210d = gVar.f39210d;
        this.f39211e = gVar.f39211e;
        this.f39212f = gVar.f39212f;
    }
}
