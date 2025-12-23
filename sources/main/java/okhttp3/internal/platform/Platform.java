package okhttp3.internal.platform;

import com.umeng.analytics.pro.d;
import io.netty.handler.ssl.g;
import io.netty.handler.ssl.h;
import io.netty.handler.ssl.i;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.f0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;
import org.apache.commons.net.imap.b;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y4.j;
import y4.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nPlatform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Platform.kt\nokhttp3/internal/platform/Platform\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,241:1\n1617#2,9:242\n1869#2:251\n1870#2:253\n1626#2:254\n1#3:252\n*S KotlinDebug\n*F\n+ 1 Platform.kt\nokhttp3/internal/platform/Platform\n*L\n134#1:242,9\n134#1:251\n134#1:253\n134#1:254\n134#1:252\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class Platform {

    @NotNull
    public static final Companion Companion;
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger;

    @NotNull
    private static volatile Platform platform;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nPlatform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Platform.kt\nokhttp3/internal/platform/Platform$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,241:1\n774#2:242\n865#2,2:243\n1563#2:245\n1634#2,3:246\n*S KotlinDebug\n*F\n+ 1 Platform.kt\nokhttp3/internal/platform/Platform$Companion\n*L\n219#1:242\n219#1:243,2\n219#1:245\n219#1:246,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Platform findPlatform() {
            return PlatformRegistry.INSTANCE.findPlatform();
        }

        public static /* synthetic */ void resetForTests$default(Companion companion, Platform platform, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                platform = companion.findPlatform();
            }
            companion.resetForTests(platform);
        }

        @NotNull
        public final List<String> alpnProtocolNames(@NotNull List<? extends Protocol> protocols) {
            g0.p(protocols, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : protocols) {
                if (((Protocol) obj) != Protocol.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(f0.d0(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Protocol) it.next()).toString());
            }
            return arrayList2;
        }

        @NotNull
        public final byte[] concatLengthPrefixed(@NotNull List<? extends Protocol> protocols) {
            g0.p(protocols, "protocols");
            Buffer buffer = new Buffer();
            for (String str : alpnProtocolNames(protocols)) {
                buffer.writeByte(str.length());
                buffer.writeUtf8(str);
            }
            return buffer.readByteArray();
        }

        public final boolean isAndroid() {
            return PlatformRegistry.INSTANCE.isAndroid();
        }

        public final void resetForTests(@NotNull Platform platform) {
            g0.p(platform, "platform");
            Platform.platform = platform;
            PublicSuffixDatabase.Companion.resetForTests$okhttp();
        }

        @JvmStatic
        @NotNull
        public final Platform get() {
            return Platform.platform;
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        platform = companion.findPlatform();
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    @JvmStatic
    @NotNull
    public static final Platform get() {
        return Companion.get();
    }

    public static /* synthetic */ void log$default(Platform platform2, String str, int i6, Throwable th, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i7 & 2) != 0) {
            i6 = 4;
        }
        if ((i7 & 4) != 0) {
            th = null;
        }
        platform2.log(str, i6, th);
    }

    public void afterHandshake(@NotNull SSLSocket sslSocket) {
        g0.p(sslSocket, "sslSocket");
    }

    @NotNull
    public CertificateChainCleaner buildCertificateChainCleaner(@NotNull X509TrustManager trustManager) {
        g0.p(trustManager, "trustManager");
        return new BasicCertificateChainCleaner(buildTrustRootIndex(trustManager));
    }

    @NotNull
    public TrustRootIndex buildTrustRootIndex(@NotNull X509TrustManager trustManager) {
        g0.p(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<Protocol> protocols) {
        g0.p(sslSocket, "sslSocket");
        g0.p(protocols, "protocols");
    }

    public void connectSocket(@NotNull Socket socket, @NotNull InetSocketAddress address, int i6) throws IOException {
        g0.p(socket, "socket");
        g0.p(address, "address");
        socket.connect(address, i6);
    }

    @IgnoreJRERequirement
    @NotNull
    public List<String> getHandshakeServerNames(@NotNull SSLSocket sslSocket) {
        List requestedServerNames;
        g0.p(sslSocket, "sslSocket");
        SSLSession session = sslSocket.getSession();
        ExtendedSSLSession a6 = j.a(session) ? k.a(session) : null;
        if (a6 == null) {
            return f0.J();
        }
        try {
            requestedServerNames = a6.getRequestedServerNames();
            g0.o(requestedServerNames, "getRequestedServerNames(...)");
            ArrayList arrayList = new ArrayList();
            Iterator it = requestedServerNames.iterator();
            while (it.hasNext()) {
                SNIServerName a7 = g.a(it.next());
                SNIHostName a8 = h.a(a7) ? i.a(a7) : null;
                String asciiName = a8 != null ? a8.getAsciiName() : null;
                if (asciiName != null) {
                    arrayList.add(asciiName);
                }
            }
            return arrayList;
        } catch (UnsupportedOperationException unused) {
            return f0.J();
        }
    }

    @NotNull
    public final String getPrefix() {
        return "OkHttp";
    }

    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        g0.p(sslSocket, "sslSocket");
        return null;
    }

    @Nullable
    public Object getStackTraceForCloseable(@NotNull String closer) {
        g0.p(closer, "closer");
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(closer);
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(@NotNull String hostname) {
        g0.p(hostname, "hostname");
        return true;
    }

    public void log(@NotNull String message, int i6, @Nullable Throwable th) {
        g0.p(message, "message");
        logger.log(i6 == 5 ? Level.WARNING : Level.INFO, message, th);
    }

    public void logCloseableLeak(@NotNull String message, @Nullable Object obj) {
        g0.p(message, "message");
        if (obj == null) {
            message = message + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        log(message, 5, (Throwable) obj);
    }

    @NotNull
    public SSLContext newSSLContext() {
        SSLContext sSLContext = SSLContext.getInstance(b.Q);
        g0.o(sSLContext, "getInstance(...)");
        return sSLContext;
    }

    @NotNull
    public SSLSocketFactory newSslSocketFactory(@NotNull X509TrustManager trustManager) {
        g0.p(trustManager, "trustManager");
        try {
            SSLContext newSSLContext = newSSLContext();
            newSSLContext.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = newSSLContext.getSocketFactory();
            g0.o(socketFactory, "getSocketFactory(...)");
            return socketFactory;
        } catch (GeneralSecurityException e6) {
            throw new AssertionError("No System TLS: " + e6, e6);
        }
    }

    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        g0.p(sslSocketFactory, "sslSocketFactory");
        try {
            Class<?> cls = Class.forName("sun.security.ssl.SSLContextImpl");
            g0.m(cls);
            Object readFieldOrNull = _UtilJvmKt.readFieldOrNull(sslSocketFactory, cls, d.X);
            if (readFieldOrNull == null) {
                return null;
            }
            return (X509TrustManager) _UtilJvmKt.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (RuntimeException e6) {
            if (!g0.g(e6.getClass().getName(), "java.lang.reflect.InaccessibleObjectException")) {
                throw e6;
            }
            return null;
        }
    }

    @NotNull
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        g0.m(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                g0.n(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                return (X509TrustManager) trustManager;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String arrays = Arrays.toString(trustManagers);
        g0.o(arrays, "toString(...)");
        sb.append(arrays);
        throw new IllegalStateException(sb.toString().toString());
    }

    @NotNull
    public String toString() {
        String simpleName = getClass().getSimpleName();
        g0.o(simpleName, "getSimpleName(...)");
        return simpleName;
    }
}
