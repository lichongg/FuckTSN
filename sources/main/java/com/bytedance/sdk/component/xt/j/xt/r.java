package com.bytedance.sdk.component.xt.j.xt;

import com.snail.antifake.deviceid.e;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements Serializable, Comparable<r> {

    /* renamed from: m, reason: collision with root package name */
    transient String f27327m;

    /* renamed from: r, reason: collision with root package name */
    final byte[] f27328r;
    transient int up;

    /* renamed from: j, reason: collision with root package name */
    static final char[] f27326j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset xt = Charset.forName("UTF-8");
    public static final r cw = j(new byte[0]);

    public static r j(byte... bArr) {
        if (bArr != null) {
            return new r((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            int cw2 = rVar.cw();
            byte[] bArr = this.f27328r;
            if (cw2 == bArr.length && rVar.j(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int cw() {
        return this.f27328r.length;
    }

    public int hashCode() {
        int i6 = this.up;
        if (i6 != 0) {
            return i6;
        }
        int hashCode = Arrays.hashCode(this.f27328r);
        this.up = hashCode;
        return hashCode;
    }

    public byte[] r() {
        return (byte[]) this.f27328r.clone();
    }

    public String toString() {
        if (this.f27328r.length == 0) {
            return "[size=0]";
        }
        String j6 = j();
        int j7 = j(j6, 64);
        if (j7 == -1) {
            if (this.f27328r.length <= 64) {
                return "[hex=" + xt() + "]";
            }
            return "[size=" + this.f27328r.length + " hex=" + j(0, 64).xt() + "…]";
        }
        String replace = j6.substring(0, j7).replace("\\", "\\\\").replace(e.f37542d, "\\n").replace("\r", "\\r");
        if (j7 >= j6.length()) {
            return "[text=" + replace + "]";
        }
        return "[size=" + this.f27328r.length + " text=" + replace + "…]";
    }

    public String xt() {
        byte[] bArr = this.f27328r;
        char[] cArr = new char[bArr.length * 2];
        int i6 = 0;
        for (byte b6 : bArr) {
            int i7 = i6 + 1;
            char[] cArr2 = f27326j;
            cArr[i6] = cArr2[(b6 >> 4) & 15];
            i6 += 2;
            cArr[i7] = cArr2[b6 & 15];
        }
        return new String(cArr);
    }

    r(byte[] bArr) {
        this.f27328r = bArr;
    }

    public String j() {
        String str = this.f27327m;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f27328r, xt);
        this.f27327m = str2;
        return str2;
    }

    public static r j(String str) {
        if (str != null) {
            r rVar = new r(str.getBytes(oq.f27325j));
            rVar.f27327m = str;
            return rVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public r j(int i6, int i7) {
        if (i6 >= 0) {
            byte[] bArr = this.f27328r;
            if (i7 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.f27328r.length + ")");
            }
            int i8 = i7 - i6;
            if (i8 >= 0) {
                if (i6 == 0 && i7 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i8];
                System.arraycopy(bArr, i6, bArr2, 0, i8);
                return new r(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public byte j(int i6) {
        return this.f27328r[i6];
    }

    public boolean j(int i6, r rVar, int i7, int i8) {
        return rVar.j(i7, this.f27328r, i6, i8);
    }

    public boolean j(int i6, byte[] bArr, int i7, int i8) {
        if (i6 < 0) {
            return false;
        }
        byte[] bArr2 = this.f27328r;
        return i6 <= bArr2.length - i8 && i7 >= 0 && i7 <= bArr.length - i8 && oq.j(bArr2, i6, bArr, i7, i8);
    }

    @Override // java.lang.Comparable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(r rVar) {
        int cw2 = cw();
        int cw3 = rVar.cw();
        int min = Math.min(cw2, cw3);
        for (int i6 = 0; i6 < min; i6++) {
            int j6 = j(i6) & 255;
            int j7 = rVar.j(i6) & 255;
            if (j6 != j7) {
                return j6 < j7 ? -1 : 1;
            }
        }
        if (cw2 == cw3) {
            return 0;
        }
        return cw2 < cw3 ? -1 : 1;
    }

    static int j(String str, int i6) {
        int length = str.length();
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            if (i8 == i6) {
                return i7;
            }
            int codePointAt = str.codePointAt(i7);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i8++;
            i7 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
