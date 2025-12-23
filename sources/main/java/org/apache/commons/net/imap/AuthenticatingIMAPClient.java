package org.apache.commons.net.imap;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLContext;
import org.apache.commons.net.imap.IMAP;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class AuthenticatingIMAPClient extends b {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AUTH_METHOD {
        PLAIN("PLAIN"),
        CRAM_MD5("CRAM-MD5"),
        LOGIN("LOGIN"),
        XOAUTH("XOAUTH");

        private final String authName;

        public final String getAuthName() {
            return this.authName;
        }

        AUTH_METHOD(String str) {
            this.authName = str;
        }
    }

    public AuthenticatingIMAPClient() {
        this(b.Q, false);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f50813a;

        static {
            int[] iArr = new int[AUTH_METHOD.values().length];
            f50813a = iArr;
            try {
                iArr[AUTH_METHOD.PLAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50813a[AUTH_METHOD.CRAM_MD5.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f50813a[AUTH_METHOD.LOGIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f50813a[AUTH_METHOD.XOAUTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public AuthenticatingIMAPClient(boolean z5) {
        this(b.Q, z5);
    }

    private String d1(byte[] bArr) {
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

    public boolean e1(AUTH_METHOD auth_method, String str, String str2) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        if (!org.apache.commons.net.imap.a.d(k0(IMAPCommand.AUTHENTICATE, auth_method.getAuthName()))) {
            return false;
        }
        int i6 = a.f50813a[auth_method.ordinal()];
        if (i6 == 1) {
            int m02 = m0(org.apache.commons.net.util.a.r(("\u0000" + str + "\u0000" + str2).getBytes(q())));
            if (m02 == 0) {
                o0(IMAP.IMAPState.AUTH_STATE);
            }
            return m02 == 0;
        }
        if (i6 != 2) {
            if (i6 != 3) {
                if (i6 != 4) {
                    return false;
                }
                int m03 = m0(str);
                if (m03 == 0) {
                    o0(IMAP.IMAPState.AUTH_STATE);
                }
                return m03 == 0;
            }
            if (m0(org.apache.commons.net.util.a.r(str.getBytes(q()))) != 3) {
                return false;
            }
            int m04 = m0(org.apache.commons.net.util.a.r(str2.getBytes(q())));
            if (m04 == 0) {
                o0(IMAP.IMAPState.AUTH_STATE);
            }
            return m04 == 0;
        }
        byte[] f6 = org.apache.commons.net.util.a.f(e0().substring(2).trim());
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(new SecretKeySpec(str2.getBytes(q()), "HmacMD5"));
        byte[] bytes = d1(mac.doFinal(f6)).getBytes(q());
        byte[] bytes2 = str.getBytes(q());
        byte[] bArr = new byte[bytes2.length + 1 + bytes.length];
        System.arraycopy(bytes2, 0, bArr, 0, bytes2.length);
        bArr[bytes2.length] = 32;
        System.arraycopy(bytes, 0, bArr, bytes2.length + 1, bytes.length);
        int m05 = m0(org.apache.commons.net.util.a.r(bArr));
        if (m05 == 0) {
            o0(IMAP.IMAPState.AUTH_STATE);
        }
        return m05 == 0;
    }

    public AuthenticatingIMAPClient(String str) {
        this(str, false);
    }

    public boolean f1(AUTH_METHOD auth_method, String str, String str2) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        return e1(auth_method, str, str2);
    }

    public AuthenticatingIMAPClient(String str, boolean z5) {
        this(str, z5, null);
    }

    public AuthenticatingIMAPClient(String str, boolean z5, SSLContext sSLContext) {
        super(str, z5, sSLContext);
    }

    public AuthenticatingIMAPClient(boolean z5, SSLContext sSLContext) {
        this(b.Q, z5, sSLContext);
    }

    public AuthenticatingIMAPClient(SSLContext sSLContext) {
        this(false, sSLContext);
    }
}
