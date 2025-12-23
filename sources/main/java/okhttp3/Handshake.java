package okhttp3;

import com.acse.ottn.l3;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.f0;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.s;
import kotlin.t;
import okhttp3.Handshake;
import okhttp3.internal._UtilJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nHandshake.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handshake.kt\nokhttp3/Handshake\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,201:1\n1563#2:202\n1634#2,3:203\n1563#2:206\n1634#2,3:207\n*S KotlinDebug\n*F\n+ 1 Handshake.kt\nokhttp3/Handshake\n*L\n131#1:202\n131#1:203,3\n136#1:206\n136#1:207,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Handshake {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final CipherSuite cipherSuite;

    @NotNull
    private final List<Certificate> localCertificates;

    @NotNull
    private final s peerCertificates$delegate;

    @NotNull
    private final TlsVersion tlsVersion;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nHandshake.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handshake.kt\nokhttp3/Handshake$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,201:1\n1#2:202\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        @JvmStatic
        @JvmName(name = l3.f4736f)
        @NotNull
        public final Handshake get(@NotNull SSLSession sSLSession) throws IOException {
            final List J;
            g0.p(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null");
            }
            if (g0.g(cipherSuite, "TLS_NULL_WITH_NULL_NULL") || g0.g(cipherSuite, "SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            CipherSuite forJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            }
            if (g0.g("NONE", protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion forJavaName2 = TlsVersion.Companion.forJavaName(protocol);
            try {
                J = _UtilJvmKt.toImmutableList(sSLSession.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                J = f0.J();
            }
            return new Handshake(forJavaName2, forJavaName, _UtilJvmKt.toImmutableList(sSLSession.getLocalCertificates()), new Function0() { // from class: okhttp3.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List handshake$lambda$2;
                    handshake$lambda$2 = Handshake.Companion.handshake$lambda$2(J);
                    return handshake$lambda$2;
                }
            });
        }

        private Companion() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "sslSession.handshake()", imports = {}))
        @JvmName(name = "-deprecated_get")
        @NotNull
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final Handshake m195deprecated_get(@NotNull SSLSession sslSession) throws IOException {
            g0.p(sslSession, "sslSession");
            return get(sslSession);
        }

        @JvmStatic
        @NotNull
        public final Handshake get(@NotNull TlsVersion tlsVersion, @NotNull CipherSuite cipherSuite, @NotNull List<? extends Certificate> peerCertificates, @NotNull List<? extends Certificate> localCertificates) {
            g0.p(tlsVersion, "tlsVersion");
            g0.p(cipherSuite, "cipherSuite");
            g0.p(peerCertificates, "peerCertificates");
            g0.p(localCertificates, "localCertificates");
            final List immutableList = _UtilJvmKt.toImmutableList(peerCertificates);
            return new Handshake(tlsVersion, cipherSuite, _UtilJvmKt.toImmutableList(localCertificates), new Function0() { // from class: okhttp3.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List list;
                    list = Handshake.Companion.get$lambda$0(immutableList);
                    return list;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List get$lambda$0(List list) {
            return list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List handshake$lambda$2(List list) {
            return list;
        }
    }

    @JvmStatic
    @JvmName(name = l3.f4736f)
    @NotNull
    public static final Handshake get(@NotNull SSLSession sSLSession) throws IOException {
        return Companion.get(sSLSession);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(@NotNull TlsVersion tlsVersion, @NotNull CipherSuite cipherSuite, @NotNull List<? extends Certificate> localCertificates, @NotNull final Function0<? extends List<? extends Certificate>> peerCertificatesFn) {
        g0.p(tlsVersion, "tlsVersion");
        g0.p(cipherSuite, "cipherSuite");
        g0.p(localCertificates, "localCertificates");
        g0.p(peerCertificatesFn, "peerCertificatesFn");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = localCertificates;
        this.peerCertificates$delegate = t.c(new Function0() { // from class: okhttp3.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List peerCertificates_delegate$lambda$0;
                peerCertificates_delegate$lambda$0 = Handshake.peerCertificates_delegate$lambda$0(Function0.this);
                return peerCertificates_delegate$lambda$0;
            }
        });
    }

    @JvmStatic
    @NotNull
    public static final Handshake get(@NotNull TlsVersion tlsVersion, @NotNull CipherSuite cipherSuite, @NotNull List<? extends Certificate> list, @NotNull List<? extends Certificate> list2) {
        return Companion.get(tlsVersion, cipherSuite, list, list2);
    }

    private final String getName(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        g0.o(type, "getType(...)");
        return type;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cipherSuite", imports = {}))
    @JvmName(name = "-deprecated_cipherSuite")
    @NotNull
    /* renamed from: -deprecated_cipherSuite, reason: not valid java name */
    public final CipherSuite m189deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "localCertificates", imports = {}))
    @JvmName(name = "-deprecated_localCertificates")
    @NotNull
    /* renamed from: -deprecated_localCertificates, reason: not valid java name */
    public final List<Certificate> m190deprecated_localCertificates() {
        return this.localCertificates;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "tlsVersion", imports = {}))
    @JvmName(name = "-deprecated_tlsVersion")
    @NotNull
    /* renamed from: -deprecated_tlsVersion, reason: not valid java name */
    public final TlsVersion m194deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    @JvmName(name = "cipherSuite")
    @NotNull
    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return handshake.tlsVersion == this.tlsVersion && g0.g(handshake.cipherSuite, this.cipherSuite) && g0.g(handshake.peerCertificates(), peerCertificates()) && g0.g(handshake.localCertificates, this.localCertificates);
    }

    public int hashCode() {
        return ((((((527 + this.tlsVersion.hashCode()) * 31) + this.cipherSuite.hashCode()) * 31) + peerCertificates().hashCode()) * 31) + this.localCertificates.hashCode();
    }

    @JvmName(name = "localCertificates")
    @NotNull
    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    @JvmName(name = "localPrincipal")
    @Nullable
    public final Principal localPrincipal() {
        Object L2 = f0.L2(this.localCertificates);
        X509Certificate x509Certificate = L2 instanceof X509Certificate ? (X509Certificate) L2 : null;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    @JvmName(name = "peerCertificates")
    @NotNull
    public final List<Certificate> peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    @JvmName(name = "tlsVersion")
    @NotNull
    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List peerCertificates_delegate$lambda$0(Function0 function0) {
        try {
            return (List) function0.invoke();
        } catch (SSLPeerUnverifiedException unused) {
            return f0.J();
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "localPrincipal", imports = {}))
    @JvmName(name = "-deprecated_localPrincipal")
    @Nullable
    /* renamed from: -deprecated_localPrincipal, reason: not valid java name */
    public final Principal m191deprecated_localPrincipal() {
        return localPrincipal();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "peerCertificates", imports = {}))
    @JvmName(name = "-deprecated_peerCertificates")
    @NotNull
    /* renamed from: -deprecated_peerCertificates, reason: not valid java name */
    public final List<Certificate> m192deprecated_peerCertificates() {
        return peerCertificates();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "peerPrincipal", imports = {}))
    @JvmName(name = "-deprecated_peerPrincipal")
    @Nullable
    /* renamed from: -deprecated_peerPrincipal, reason: not valid java name */
    public final Principal m193deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    @JvmName(name = "peerPrincipal")
    @Nullable
    public final Principal peerPrincipal() {
        X509Certificate x509Certificate;
        Object L2 = f0.L2(peerCertificates());
        if (L2 instanceof X509Certificate) {
            x509Certificate = (X509Certificate) L2;
        } else {
            x509Certificate = null;
        }
        if (x509Certificate == null) {
            return null;
        }
        return x509Certificate.getSubjectX500Principal();
    }

    @NotNull
    public String toString() {
        List<Certificate> peerCertificates = peerCertificates();
        ArrayList arrayList = new ArrayList(f0.d0(peerCertificates, 10));
        Iterator<T> it = peerCertificates.iterator();
        while (it.hasNext()) {
            arrayList.add(getName((Certificate) it.next()));
        }
        String obj = arrayList.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{tlsVersion=");
        sb.append(this.tlsVersion);
        sb.append(" cipherSuite=");
        sb.append(this.cipherSuite);
        sb.append(" peerCertificates=");
        sb.append(obj);
        sb.append(" localCertificates=");
        List<Certificate> list = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(f0.d0(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(getName((Certificate) it2.next()));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
