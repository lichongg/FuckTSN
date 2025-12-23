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
public final class DeferredSocketAdapter implements SocketAdapter {

    @Nullable
    private SocketAdapter delegate;

    @NotNull
    private final Factory socketAdapterFactory;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Factory {
        @NotNull
        SocketAdapter create(@NotNull SSLSocket sSLSocket);

        boolean matchesSocket(@NotNull SSLSocket sSLSocket);
    }

    private final synchronized SocketAdapter getDelegate(SSLSocket sSLSocket) {
        try {
            if (this.delegate == null && this.socketAdapterFactory.matchesSocket(sSLSocket)) {
                this.delegate = this.socketAdapterFactory.create(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.delegate;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return true;
    }

    public DeferredSocketAdapter(@NotNull Factory socketAdapterFactory) {
        g0.p(socketAdapterFactory, "socketAdapterFactory");
        this.socketAdapterFactory = socketAdapterFactory;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<? extends Protocol> protocols) {
        g0.p(sslSocket, "sslSocket");
        g0.p(protocols, "protocols");
        SocketAdapter delegate = getDelegate(sslSocket);
        if (delegate != null) {
            delegate.configureTlsExtensions(sslSocket, str, protocols);
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        g0.p(sslSocket, "sslSocket");
        SocketAdapter delegate = getDelegate(sslSocket);
        if (delegate != null) {
            return delegate.getSelectedProtocol(sslSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(@NotNull SSLSocket sslSocket) {
        g0.p(sslSocket, "sslSocket");
        return this.socketAdapterFactory.matchesSocket(sslSocket);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public /* bridge */ boolean matchesSocketFactory(@NotNull SSLSocketFactory sSLSocketFactory) {
        return b.a(this, sSLSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public /* bridge */ X509TrustManager trustManager(@NotNull SSLSocketFactory sSLSocketFactory) {
        return b.b(this, sSLSocketFactory);
    }
}
