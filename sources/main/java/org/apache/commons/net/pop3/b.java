package org.apache.commons.net.pop3;

import com.baidu.mobads.sdk.internal.by;
import java.io.IOException;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ListIterator;
import java.util.StringTokenizer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends a {
    public Reader y0(int i6, int i7) throws IOException {
        if (i7 < 0 || d0() != 1) {
            return null;
        }
        if (g0(10, Integer.toString(i6) + " " + Integer.toString(i7)) != 0) {
            return null;
        }
        return new org.apache.commons.net.io.d(this.f50992w);
    }

    private static d k0(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        if (!stringTokenizer.hasMoreElements()) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(stringTokenizer.nextToken());
            if (stringTokenizer.hasMoreElements()) {
                return new d(parseInt, Integer.parseInt(stringTokenizer.nextToken()));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static d l0(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        if (!stringTokenizer.hasMoreElements()) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(stringTokenizer.nextToken());
            if (stringTokenizer.hasMoreElements()) {
                return new d(parseInt, stringTokenizer.nextToken());
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public boolean m0() throws IOException {
        if (f0(12) != 0) {
            return false;
        }
        a0();
        return true;
    }

    public boolean n0(int i6) throws IOException {
        if (d0() != 1 || g0(6, Integer.toString(i6)) != 0) {
            return false;
        }
        return true;
    }

    public d o0(int i6) throws IOException {
        if (d0() != 1 || g0(4, Integer.toString(i6)) != 0) {
            return null;
        }
        return k0(this.f50994y.substring(3));
    }

    public d[] p0() throws IOException {
        if (d0() != 1 || f0(4) != 0) {
            return null;
        }
        a0();
        int size = this.f50995z.size() - 2;
        d[] dVarArr = new d[size];
        ListIterator<String> listIterator = this.f50995z.listIterator(1);
        for (int i6 = 0; i6 < size; i6++) {
            dVarArr[i6] = k0(listIterator.next());
        }
        return dVarArr;
    }

    public d q0(int i6) throws IOException {
        if (d0() != 1 || g0(11, Integer.toString(i6)) != 0) {
            return null;
        }
        return l0(this.f50994y.substring(3));
    }

    public d[] r0() throws IOException {
        if (d0() != 1 || f0(11) != 0) {
            return null;
        }
        a0();
        int size = this.f50995z.size() - 2;
        d[] dVarArr = new d[size];
        ListIterator<String> listIterator = this.f50995z.listIterator(1);
        for (int i6 = 0; i6 < size; i6++) {
            dVarArr[i6] = l0(listIterator.next());
        }
        return dVarArr;
    }

    public boolean s0(String str, String str2) throws IOException {
        if (d0() != 0 || g0(0, str) != 0 || g0(1, str2) != 0) {
            return false;
        }
        j0(1);
        return true;
    }

    public boolean t0(String str, String str2, String str3) throws IOException, NoSuchAlgorithmException {
        if (d0() != 0) {
            return false;
        }
        byte[] digest = MessageDigest.getInstance(by.f10823a).digest((str2 + str3).getBytes(q()));
        StringBuilder sb = new StringBuilder(128);
        for (byte b6 : digest) {
            int i6 = b6 & 255;
            if (i6 <= 15) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(i6));
        }
        StringBuilder sb2 = new StringBuilder(256);
        sb2.append(str);
        sb2.append(' ');
        sb2.append(sb.toString());
        if (g0(9, sb2.toString()) != 0) {
            return false;
        }
        j0(1);
        return true;
    }

    public boolean u0() throws IOException {
        if (d0() == 1) {
            j0(2);
        }
        f0(2);
        if (this.f50993x == 0) {
            return true;
        }
        return false;
    }

    public boolean v0() throws IOException {
        if (d0() != 1 || f0(7) != 0) {
            return false;
        }
        return true;
    }

    public boolean w0() throws IOException {
        if (d0() != 1 || f0(8) != 0) {
            return false;
        }
        return true;
    }

    public Reader x0(int i6) throws IOException {
        if (d0() != 1 || g0(5, Integer.toString(i6)) != 0) {
            return null;
        }
        return new org.apache.commons.net.io.d(this.f50992w);
    }

    public d z0() throws IOException {
        if (d0() != 1 || f0(3) != 0) {
            return null;
        }
        return k0(this.f50994y.substring(3));
    }
}
