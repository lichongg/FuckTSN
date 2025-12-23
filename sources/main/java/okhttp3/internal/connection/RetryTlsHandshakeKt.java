package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class RetryTlsHandshakeKt {
    public static final boolean retryTlsHandshake(@NotNull IOException e6) {
        g0.p(e6, "e");
        if ((e6 instanceof ProtocolException) || (e6 instanceof InterruptedIOException)) {
            return false;
        }
        return (((e6 instanceof SSLHandshakeException) && (e6.getCause() instanceof CertificateException)) || (e6 instanceof SSLPeerUnverifiedException) || !(e6 instanceof SSLException)) ? false : true;
    }
}
