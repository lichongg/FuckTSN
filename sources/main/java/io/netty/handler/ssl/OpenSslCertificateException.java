package io.netty.handler.ssl;

import io.netty.internal.tcnative.CertificateVerifier;
import java.security.cert.CertificateException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class OpenSslCertificateException extends CertificateException {
    private static final long serialVersionUID = 5542675253797129798L;
    private final int errorCode;

    public OpenSslCertificateException(int i6) {
        this((String) null, i6);
    }

    public OpenSslCertificateException(String str, int i6) {
        super(str);
        this.errorCode = checkErrorCode(i6);
    }

    public int errorCode() {
        return this.errorCode;
    }

    private static int checkErrorCode(int i6) {
        if (OpenSsl.isAvailable() && !CertificateVerifier.isValid(i6)) {
            throw new IllegalArgumentException("errorCode '" + i6 + "' invalid, see https://www.openssl.org/docs/man1.0.2/apps/verify.html.");
        }
        return i6;
    }

    public OpenSslCertificateException(String str, Throwable th, int i6) {
        super(str, th);
        this.errorCode = checkErrorCode(i6);
    }

    public OpenSslCertificateException(Throwable th, int i6) {
        this(null, th, i6);
    }
}
