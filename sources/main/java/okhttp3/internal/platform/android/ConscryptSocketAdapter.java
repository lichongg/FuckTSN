package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okhttp3.Protocol;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import org.conscrypt.Conscrypt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nConscryptSocketAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConscryptSocketAdapter.kt\nokhttp3/internal/platform/android/ConscryptSocketAdapter\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,97:1\n37#2,2:98\n*S KotlinDebug\n*F\n+ 1 ConscryptSocketAdapter.kt\nokhttp3/internal/platform/android/ConscryptSocketAdapter\n*L\n50#1:98,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class ConscryptSocketAdapter implements SocketAdapter {

    @NotNull
    public static final Companion Companion;

    @NotNull
    private static final DeferredSocketAdapter.Factory factory;
    private static final boolean isSupported;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ boolean atLeastVersion$default(Companion companion, int i6, int i7, int i8, int i9, Object obj) {
            if ((i9 & 2) != 0) {
                i7 = 0;
            }
            if ((i9 & 4) != 0) {
                i8 = 0;
            }
            return companion.atLeastVersion(i6, i7, i8);
        }

        public final boolean atLeastVersion(int i6, int i7, int i8) {
            Conscrypt.Version version = Conscrypt.version();
            if (version == null) {
                return false;
            }
            if (version.major() != i6) {
                if (version.major() <= i6) {
                    return false;
                }
                return true;
            }
            if (version.minor() != i7) {
                if (version.minor() <= i7) {
                    return false;
                }
                return true;
            }
            if (version.patch() < i8) {
                return false;
            }
            return true;
        }

        @NotNull
        public final DeferredSocketAdapter.Factory getFactory() {
            return ConscryptSocketAdapter.factory;
        }

        public final boolean isSupported() {
            return ConscryptSocketAdapter.isSupported;
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        factory = new DeferredSocketAdapter.Factory() { // from class: okhttp3.internal.platform.android.ConscryptSocketAdapter$Companion$factory$1
            @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
            public SocketAdapter create(SSLSocket sslSocket) {
                g0.p(sslSocket, "sslSocket");
                return new ConscryptSocketAdapter();
            }

            @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
            public boolean matchesSocket(SSLSocket sslSocket) {
                g0.p(sslSocket, "sslSocket");
                return ConscryptSocketAdapter.Companion.isSupported() && Conscrypt.isConscrypt(sslSocket);
            }
        };
        boolean z5 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, companion.getClass().getClassLoader());
            if (Conscrypt.isAvailable()) {
                if (companion.atLeastVersion(2, 1, 0)) {
                    z5 = true;
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        isSupported = z5;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<? extends Protocol> protocols) {
        g0.p(sslSocket, "sslSocket");
        g0.p(protocols, "protocols");
        if (matchesSocket(sslSocket)) {
            Conscrypt.setUseSessionTickets(sslSocket, true);
            Conscrypt.setApplicationProtocols(sslSocket, (String[]) Platform.Companion.alpnProtocolNames(protocols).toArray(new String[0]));
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        g0.p(sslSocket, "sslSocket");
        if (matchesSocket(sslSocket)) {
            return Conscrypt.getApplicationProtocol(sslSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return isSupported;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(@NotNull SSLSocket sslSocket) {
        g0.p(sslSocket, "sslSocket");
        return Conscrypt.isConscrypt(sslSocket);
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
