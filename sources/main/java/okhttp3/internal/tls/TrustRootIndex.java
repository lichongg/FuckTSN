package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public interface TrustRootIndex {
    @Nullable
    X509Certificate findByIssuerAndSignature(@NotNull X509Certificate x509Certificate);
}
