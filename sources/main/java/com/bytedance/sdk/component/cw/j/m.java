package com.bytedance.sdk.component.cw.j;

import com.snail.antifake.deviceid.e;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements Serializable, Comparable<m> {

    /* renamed from: j, reason: collision with root package name */
    static final char[] f26099j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final m xt = j(new byte[0]);
    final byte[] cw;

    /* renamed from: r, reason: collision with root package name */
    transient int f26100r;
    transient String up;

    public static m j(byte... bArr) {
        if (bArr != null) {
            return new m((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public m cw() {
        return cw("SHA-1");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            int ae = mVar.ae();
            byte[] bArr = this.cw;
            if (ae == bArr.length && mVar.j(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public m m() {
        int i6 = 0;
        while (true) {
            byte[] bArr = this.cw;
            if (i6 >= bArr.length) {
                return this;
            }
            byte b6 = bArr[i6];
            if (b6 >= 65 && b6 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i6] = (byte) (b6 + 32);
                for (int i7 = i6 + 1; i7 < bArr2.length; i7++) {
                    byte b7 = bArr2[i7];
                    if (b7 >= 65 && b7 <= 90) {
                        bArr2[i7] = (byte) (b7 + 32);
                    }
                }
                return new m(bArr2);
            }
            i6++;
        }
    }

    public String xt() {
        return xt.j(this.cw);
    }

    private m cw(String str) {
        try {
            return j(MessageDigest.getInstance(str).digest(this.cw));
        } catch (NoSuchAlgorithmException e6) {
            throw new AssertionError(e6);
        }
    }

    public static m xt(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str));
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i6 * 2;
            bArr[i6] = (byte) ((j(str.charAt(i7)) << 4) + j(str.charAt(i7 + 1)));
        }
        return j(bArr);
    }

    public int ae() {
        return this.cw.length;
    }

    public int hashCode() {
        int i6 = this.f26100r;
        if (i6 != 0) {
            return i6;
        }
        int hashCode = Arrays.hashCode(this.cw);
        this.f26100r = hashCode;
        return hashCode;
    }

    public m r() {
        return cw("SHA-256");
    }

    public byte[] tl() {
        return (byte[]) this.cw.clone();
    }

    public String toString() {
        if (this.cw.length == 0) {
            return "[size=0]";
        }
        String j6 = j();
        int j7 = j(j6, 64);
        if (j7 == -1) {
            if (this.cw.length <= 64) {
                return "[hex=" + up() + "]";
            }
            return "[size=" + this.cw.length + " hex=" + j(0, 64).up() + "…]";
        }
        String replace = j6.substring(0, j7).replace("\\", "\\\\").replace(e.f37542d, "\\n").replace("\r", "\\r");
        if (j7 >= j6.length()) {
            return "[text=" + replace + "]";
        }
        return "[size=" + this.cw.length + " text=" + replace + "…]";
    }

    public String up() {
        byte[] bArr = this.cw;
        char[] cArr = new char[bArr.length * 2];
        int i6 = 0;
        for (byte b6 : bArr) {
            int i7 = i6 + 1;
            char[] cArr2 = f26099j;
            cArr[i6] = cArr2[(b6 >> 4) & 15];
            i6 += 2;
            cArr[i7] = cArr2[b6 & 15];
        }
        return new String(cArr);
    }

    m(byte[] bArr) {
        this.cw = bArr;
    }

    public static m j(String str) {
        if (str != null) {
            m mVar = new m(str.getBytes(tj.f26105j));
            mVar.up = str;
            return mVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public String j() {
        String str = this.up;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.cw, tj.f26105j);
        this.up = str2;
        return str2;
    }

    private static int j(char c6) {
        if (c6 >= '0' && c6 <= '9') {
            return c6 - '0';
        }
        if (c6 >= 'a' && c6 <= 'f') {
            return c6 - 'W';
        }
        if (c6 < 'A' || c6 > 'F') {
            throw new IllegalArgumentException("Unexpected hex digit: ".concat(String.valueOf(c6)));
        }
        return c6 - '7';
    }

    public m j(int i6, int i7) {
        if (i6 >= 0) {
            byte[] bArr = this.cw;
            if (i7 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.cw.length + ")");
            }
            int i8 = i7 - i6;
            if (i8 >= 0) {
                if (i6 == 0 && i7 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i8];
                System.arraycopy(bArr, i6, bArr2, 0, i8);
                return new m(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    @Override // java.lang.Comparable
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public int compareTo(m mVar) {
        int ae = ae();
        int ae2 = mVar.ae();
        int min = Math.min(ae, ae2);
        for (int i6 = 0; i6 < min; i6++) {
            int j6 = j(i6) & 255;
            int j7 = mVar.j(i6) & 255;
            if (j6 != j7) {
                return j6 < j7 ? -1 : 1;
            }
        }
        if (ae == ae2) {
            return 0;
        }
        return ae < ae2 ? -1 : 1;
    }

    public byte j(int i6) {
        return this.cw[i6];
    }

    void j(cw cwVar) {
        byte[] bArr = this.cw;
        cwVar.cw(bArr, 0, bArr.length);
    }

    public boolean j(int i6, m mVar, int i7, int i8) {
        return mVar.j(i7, this.cw, i6, i8);
    }

    public boolean j(int i6, byte[] bArr, int i7, int i8) {
        if (i6 < 0) {
            return false;
        }
        byte[] bArr2 = this.cw;
        return i6 <= bArr2.length - i8 && i7 >= 0 && i7 <= bArr.length - i8 && tj.j(bArr2, i6, bArr, i7, i8);
    }

    public final boolean j(m mVar) {
        return j(0, mVar, 0, mVar.ae());
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
