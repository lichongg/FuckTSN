package okhttp3.internal.platform;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import org.apache.commons.net.imap.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJdk9Platform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Jdk9Platform.kt\nokhttp3/internal/platform/Jdk9Platform\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,109:1\n37#2,2:110\n*S KotlinDebug\n*F\n+ 1 Jdk9Platform.kt\nokhttp3/internal/platform/Jdk9Platform\n*L\n42#1:110,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class Jdk9Platform extends Platform {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final boolean isAvailable;

    @Nullable
    private static final Integer majorVersion;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Jdk9Platform buildIfSupported() {
            if (isAvailable()) {
                return new Jdk9Platform();
            }
            return null;
        }

        @Nullable
        public final Integer getMajorVersion() {
            return Jdk9Platform.majorVersion;
        }

        public final boolean isAvailable() {
            return Jdk9Platform.isAvailable;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0022, code lost:
    
        if (r0.intValue() >= 9) goto L10;
     */
    static {
        /*
            okhttp3.internal.platform.Jdk9Platform$Companion r0 = new okhttp3.internal.platform.Jdk9Platform$Companion
            r1 = 0
            r0.<init>(r1)
            okhttp3.internal.platform.Jdk9Platform.Companion = r0
            java.lang.String r0 = "java.specification.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 == 0) goto L15
            java.lang.Integer r0 = kotlin.text.u.n1(r0)
            goto L16
        L15:
            r0 = r1
        L16:
            okhttp3.internal.platform.Jdk9Platform.majorVersion = r0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L26
            int r0 = r0.intValue()
            r1 = 9
            if (r0 < r1) goto L2e
        L24:
            r2 = 1
            goto L2e
        L26:
            java.lang.Class<javax.net.ssl.SSLSocket> r0 = javax.net.ssl.SSLSocket.class
            java.lang.String r4 = "getApplicationProtocol"
            r0.getMethod(r4, r1)     // Catch: java.lang.NoSuchMethodException -> L2e
            goto L24
        L2e:
            okhttp3.internal.platform.Jdk9Platform.isAvailable = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.Jdk9Platform.<clinit>():void");
    }

    @Override // okhttp3.internal.platform.Platform
    @SuppressSignatureCheck
    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<Protocol> protocols) {
        g0.p(sslSocket, "sslSocket");
        g0.p(protocols, "protocols");
        SSLParameters sSLParameters = sslSocket.getSSLParameters();
        sSLParameters.setApplicationProtocols((String[]) Platform.Companion.alpnProtocolNames(protocols).toArray(new String[0]));
        sslSocket.setSSLParameters(sSLParameters);
    }

    @Override // okhttp3.internal.platform.Platform
    @SuppressSignatureCheck
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        String applicationProtocol;
        g0.p(sslSocket, "sslSocket");
        try {
            applicationProtocol = sslSocket.getApplicationProtocol();
            if (applicationProtocol != null) {
                if (!g0.g(applicationProtocol, "")) {
                    return applicationProtocol;
                }
            }
        } catch (UnsupportedOperationException unused) {
        }
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    @NotNull
    public SSLContext newSSLContext() {
        SSLContext sSLContext;
        Integer num = majorVersion;
        if (num != null && num.intValue() >= 9) {
            SSLContext sSLContext2 = SSLContext.getInstance(b.Q);
            g0.o(sSLContext2, "getInstance(...)");
            return sSLContext2;
        }
        try {
            sSLContext = SSLContext.getInstance("TLSv1.3");
        } catch (NoSuchAlgorithmException unused) {
            sSLContext = SSLContext.getInstance(b.Q);
        }
        g0.m(sSLContext);
        return sSLContext;
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        g0.p(sslSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 8 (>= 252) or JDK 9+");
    }
}
