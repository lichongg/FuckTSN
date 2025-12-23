package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.g0;
import okhttp3.Protocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public interface SocketAdapter {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean matchesSocketFactory(@NotNull SocketAdapter socketAdapter, @NotNull SSLSocketFactory sslSocketFactory) {
            boolean a6;
            g0.p(sslSocketFactory, "sslSocketFactory");
            a6 = b.a(socketAdapter, sslSocketFactory);
            return a6;
        }

        @Deprecated
        @Nullable
        public static X509TrustManager trustManager(@NotNull SocketAdapter socketAdapter, @NotNull SSLSocketFactory sslSocketFactory) {
            X509TrustManager b6;
            g0.p(sslSocketFactory, "sslSocketFactory");
            b6 = b.b(socketAdapter, sslSocketFactory);
            return b6;
        }
    }

    void configureTlsExtensions(@NotNull SSLSocket sSLSocket, @Nullable String str, @NotNull List<? extends Protocol> list);

    @Nullable
    String getSelectedProtocol(@NotNull SSLSocket sSLSocket);

    boolean isSupported();

    boolean matchesSocket(@NotNull SSLSocket sSLSocket);

    boolean matchesSocketFactory(@NotNull SSLSocketFactory sSLSocketFactory);

    @Nullable
    X509TrustManager trustManager(@NotNull SSLSocketFactory sSLSocketFactory);
}
