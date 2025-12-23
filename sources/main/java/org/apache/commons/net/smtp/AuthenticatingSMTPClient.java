package org.apache.commons.net.smtp;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLContext;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class AuthenticatingSMTPClient extends f {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AUTH_METHOD {
        PLAIN,
        CRAM_MD5,
        LOGIN,
        XOAUTH;

        public static final String getAuthName(AUTH_METHOD auth_method) {
            if (auth_method.equals(PLAIN)) {
                return "PLAIN";
            }
            if (auth_method.equals(CRAM_MD5)) {
                return "CRAM-MD5";
            }
            if (auth_method.equals(LOGIN)) {
                return "LOGIN";
            }
            if (auth_method.equals(XOAUTH)) {
                return "XOAUTH";
            }
            return null;
        }
    }

    public AuthenticatingSMTPClient() {
    }

    public AuthenticatingSMTPClient(String str) {
        super(str);
    }

    private String g1(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b6 : bArr) {
            int i6 = b6 & 255;
            if (i6 <= 15) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(i6));
        }
        return sb.toString();
    }

    public boolean h1(AUTH_METHOD auth_method, String str, String str2) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        if (!e.d(u0(14, AUTH_METHOD.getAuthName(auth_method)))) {
            return false;
        }
        if (auth_method.equals(AUTH_METHOD.PLAIN)) {
            return e.c(v0(org.apache.commons.net.util.a.r(("\u0000" + str + "\u0000" + str2).getBytes(q()))));
        }
        if (!auth_method.equals(AUTH_METHOD.CRAM_MD5)) {
            if (auth_method.equals(AUTH_METHOD.LOGIN)) {
                if (e.d(v0(org.apache.commons.net.util.a.r(str.getBytes(q()))))) {
                    return e.c(v0(org.apache.commons.net.util.a.r(str2.getBytes(q()))));
                }
                return false;
            }
            if (auth_method.equals(AUTH_METHOD.XOAUTH)) {
                return e.d(v0(org.apache.commons.net.util.a.r(str.getBytes(q()))));
            }
            return false;
        }
        byte[] f6 = org.apache.commons.net.util.a.f(g0().substring(4).trim());
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(new SecretKeySpec(str2.getBytes(q()), "HmacMD5"));
        byte[] bytes = g1(mac.doFinal(f6)).getBytes(q());
        byte[] bytes2 = str.getBytes(q());
        byte[] bArr = new byte[bytes2.length + 1 + bytes.length];
        System.arraycopy(bytes2, 0, bArr, 0, bytes2.length);
        bArr[bytes2.length] = 32;
        System.arraycopy(bytes, 0, bArr, bytes2.length + 1, bytes.length);
        return e.c(v0(org.apache.commons.net.util.a.r(bArr)));
    }

    public int i1(String str) throws IOException {
        return u0(15, str);
    }

    public AuthenticatingSMTPClient(String str, boolean z5) {
        super(str, z5);
    }

    public boolean j1() throws IOException {
        String hostName = x().getHostName();
        if (hostName == null) {
            return false;
        }
        return e.c(i1(hostName));
    }

    public boolean k1(String str) throws IOException {
        return e.c(i1(str));
    }

    public int[] l1() {
        String substring = g0().substring(4);
        String[] split = substring.substring(0, substring.indexOf(32)).split("\\.");
        int[] iArr = new int[split.length];
        for (int i6 = 0; i6 < split.length; i6++) {
            iArr[i6] = Integer.parseInt(split[i6]);
        }
        return iArr;
    }

    public AuthenticatingSMTPClient(String str, boolean z5, String str2) {
        super(str, z5, str2);
    }

    public AuthenticatingSMTPClient(boolean z5, SSLContext sSLContext) {
        super(z5, sSLContext);
    }

    public AuthenticatingSMTPClient(String str, String str2) {
        super(str, false, str2);
    }
}
