package org.apache.commons.net.pop3;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ExtendedPOP3Client extends f {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AUTH_METHOD {
        PLAIN("PLAIN"),
        CRAM_MD5("CRAM-MD5");

        private final String methodName;

        public final String getAuthName() {
            return this.methodName;
        }

        AUTH_METHOD(String str) {
            this.methodName = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f50989a;

        static {
            int[] iArr = new int[AUTH_METHOD.values().length];
            f50989a = iArr;
            try {
                iArr[AUTH_METHOD.PLAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50989a[AUTH_METHOD.CRAM_MD5.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private String P0(byte[] bArr) {
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

    public boolean Q0(AUTH_METHOD auth_method, String str, String str2) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        if (g0(13, auth_method.getAuthName()) != 2) {
            return false;
        }
        int i6 = a.f50989a[auth_method.ordinal()];
        if (i6 == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("\u0000");
            sb.append(str);
            sb.append("\u0000");
            sb.append(str2);
            return h0(new String(org.apache.commons.net.util.a.k(sb.toString().getBytes(q())), q())) == 0;
        }
        if (i6 != 2) {
            return false;
        }
        byte[] f6 = org.apache.commons.net.util.a.f(b0().substring(2).trim());
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(new SecretKeySpec(str2.getBytes(q()), "HmacMD5"));
        byte[] bytes = P0(mac.doFinal(f6)).getBytes(q());
        byte[] bytes2 = str.getBytes(q());
        byte[] bArr = new byte[bytes2.length + 1 + bytes.length];
        System.arraycopy(bytes2, 0, bArr, 0, bytes2.length);
        bArr[bytes2.length] = 32;
        System.arraycopy(bytes, 0, bArr, bytes2.length + 1, bytes.length);
        return h0(org.apache.commons.net.util.a.r(bArr)) == 0;
    }
}
