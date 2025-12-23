package org.apache.commons.net.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {
    public static SSLContext a(String str, KeyManager keyManager, TrustManager trustManager) throws IOException {
        return b(str, keyManager == null ? null : new KeyManager[]{keyManager}, trustManager != null ? new TrustManager[]{trustManager} : null);
    }

    private d() {
    }

    public static SSLContext b(String str, KeyManager[] keyManagerArr, TrustManager[] trustManagerArr) throws IOException {
        try {
            SSLContext sSLContext = SSLContext.getInstance(str);
            sSLContext.init(keyManagerArr, trustManagerArr, null);
            return sSLContext;
        } catch (GeneralSecurityException e6) {
            IOException iOException = new IOException("Could not initialize SSL context");
            iOException.initCause(e6);
            throw iOException;
        }
    }
}
