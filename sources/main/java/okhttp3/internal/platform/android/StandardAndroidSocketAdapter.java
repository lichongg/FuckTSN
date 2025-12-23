package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okhttp3.OkHttpClient;
import okhttp3.internal._UtilJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final Class<?> paramClass;

    @NotNull
    private final Class<? super SSLSocketFactory> sslSocketFactoryClass;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ SocketAdapter buildIfSupported$default(Companion companion, String str, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return companion.buildIfSupported(str);
        }

        @Nullable
        public final SocketAdapter buildIfSupported(@NotNull String packageName) {
            g0.p(packageName, "packageName");
            try {
                Class<?> cls = Class.forName(packageName + ".OpenSSLSocketImpl");
                g0.n(cls, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");
                Class<?> cls2 = Class.forName(packageName + ".OpenSSLSocketFactoryImpl");
                g0.n(cls2, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");
                Class<?> cls3 = Class.forName(packageName + ".SSLParametersImpl");
                g0.m(cls3);
                return new StandardAndroidSocketAdapter(cls, cls2, cls3);
            } catch (Exception e6) {
                AndroidLog androidLog = AndroidLog.INSTANCE;
                String name = OkHttpClient.class.getName();
                g0.o(name, "getName(...)");
                androidLog.androidLog$okhttp(name, 5, "unable to load android socket classes", e6);
                return null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardAndroidSocketAdapter(@NotNull Class<? super SSLSocket> sslSocketClass, @NotNull Class<? super SSLSocketFactory> sslSocketFactoryClass, @NotNull Class<?> paramClass) {
        super(sslSocketClass);
        g0.p(sslSocketClass, "sslSocketClass");
        g0.p(sslSocketFactoryClass, "sslSocketFactoryClass");
        g0.p(paramClass, "paramClass");
        this.sslSocketFactoryClass = sslSocketFactoryClass;
        this.paramClass = paramClass;
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(@NotNull SSLSocketFactory sslSocketFactory) {
        g0.p(sslSocketFactory, "sslSocketFactory");
        return this.sslSocketFactoryClass.isInstance(sslSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        g0.p(sslSocketFactory, "sslSocketFactory");
        Object readFieldOrNull = _UtilJvmKt.readFieldOrNull(sslSocketFactory, this.paramClass, "sslParameters");
        g0.m(readFieldOrNull);
        X509TrustManager x509TrustManager = (X509TrustManager) _UtilJvmKt.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager == null ? (X509TrustManager) _UtilJvmKt.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager") : x509TrustManager;
    }
}
