package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class CertificateChainCleaner {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        @NotNull
        public final CertificateChainCleaner get(@NotNull X509TrustManager trustManager) {
            g0.p(trustManager, "trustManager");
            return Platform.Companion.get().buildCertificateChainCleaner(trustManager);
        }

        private Companion() {
        }

        @NotNull
        public final CertificateChainCleaner get(@NotNull X509Certificate... caCerts) {
            g0.p(caCerts, "caCerts");
            return new BasicCertificateChainCleaner(new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(caCerts, caCerts.length)));
        }
    }

    @NotNull
    public abstract List<Certificate> clean(@NotNull List<? extends Certificate> list, @NotNull String str) throws SSLPeerUnverifiedException;
}
