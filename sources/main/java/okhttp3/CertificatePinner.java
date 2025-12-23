package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.collections.f0;
import kotlin.collections.n;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCertificatePinner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CertificatePinner.kt\nokhttp3/CertificatePinner\n+ 2 -UtilCommon.kt\nokhttp3/internal/_UtilCommonKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,378:1\n360#2,8:379\n1563#3:387\n1634#3,3:388\n*S KotlinDebug\n*F\n+ 1 CertificatePinner.kt\nokhttp3/CertificatePinner\n*L\n224#1:379,8\n154#1:387\n154#1:388,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CertificatePinner {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final CertificatePinner DEFAULT = new Builder().build();

    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;

    @NotNull
    private final Set<Pin> pins;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {

        @NotNull
        private final List<Pin> pins = new ArrayList();

        @NotNull
        public final Builder add(@NotNull String pattern, @NotNull String... pins) {
            g0.p(pattern, "pattern");
            g0.p(pins, "pins");
            for (String str : pins) {
                this.pins.add(new Pin(pattern, str));
            }
            return this;
        }

        @NotNull
        public final CertificatePinner build() {
            return new CertificatePinner(f0.f6(this.pins), null, 2, 0 == true ? 1 : 0);
        }

        @NotNull
        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nCertificatePinner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CertificatePinner.kt\nokhttp3/CertificatePinner$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,378:1\n1#2:379\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final String pin(@NotNull Certificate certificate) {
            g0.p(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
            }
            return "sha256/" + sha256Hash((X509Certificate) certificate).base64();
        }

        @JvmStatic
        @NotNull
        public final ByteString sha1Hash(@NotNull X509Certificate x509Certificate) {
            g0.p(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            g0.o(encoded, "getEncoded(...)");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha1();
        }

        @JvmStatic
        @NotNull
        public final ByteString sha256Hash(@NotNull X509Certificate x509Certificate) {
            g0.p(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            g0.o(encoded, "getEncoded(...)");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha256();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Pin {

        @NotNull
        private final ByteString hash;

        @NotNull
        private final String hashAlgorithm;

        @NotNull
        private final String pattern;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return g0.g(this.pattern, pin.pattern) && g0.g(this.hashAlgorithm, pin.hashAlgorithm) && g0.g(this.hash, pin.hash);
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0024, code lost:
        
            if (kotlin.text.u.H3(r5, "*", 1, false, 4, null) != (-1)) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Pin(@org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull java.lang.String r13) {
            /*
                Method dump skipped, instructions count: 261
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CertificatePinner.Pin.<init>(java.lang.String, java.lang.String):void");
        }

        @NotNull
        public final ByteString getHash() {
            return this.hash;
        }

        @NotNull
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public final boolean matchesCertificate(@NotNull X509Certificate certificate) {
            g0.p(certificate, "certificate");
            String str = this.hashAlgorithm;
            if (g0.g(str, "sha256")) {
                return g0.g(this.hash, CertificatePinner.Companion.sha256Hash(certificate));
            }
            if (g0.g(str, "sha1")) {
                return g0.g(this.hash, CertificatePinner.Companion.sha1Hash(certificate));
            }
            return false;
        }

        public final boolean matchesHostname(@NotNull String hostname) {
            boolean q22;
            boolean q23;
            g0.p(hostname, "hostname");
            if (u.H2(this.pattern, "**.", false, 2, null)) {
                int length = this.pattern.length() - 3;
                int length2 = hostname.length() - length;
                q23 = kotlin.text.g0.q2(hostname, hostname.length() - length, this.pattern, 3, length, (r12 & 16) != 0 ? false : false);
                return q23 && (length2 == 0 || hostname.charAt(length2 - 1) == '.');
            }
            if (!u.H2(this.pattern, "*.", false, 2, null)) {
                return g0.g(hostname, this.pattern);
            }
            int length3 = this.pattern.length() - 1;
            int length4 = hostname.length() - length3;
            q22 = kotlin.text.g0.q2(hostname, hostname.length() - length3, this.pattern, 1, length3, (r12 & 16) != 0 ? false : false);
            return q22 && u.V3(hostname, '.', length4 + (-1), false, 4, null) == -1;
        }

        @NotNull
        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.base64();
        }
    }

    public CertificatePinner(@NotNull Set<Pin> pins, @Nullable CertificateChainCleaner certificateChainCleaner) {
        g0.p(pins, "pins");
        this.pins = pins;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public final void check(@NotNull final String hostname, @NotNull final List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        g0.p(hostname, "hostname");
        g0.p(peerCertificates, "peerCertificates");
        check$okhttp(hostname, new Function0() { // from class: okhttp3.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List check$lambda$0;
                check$lambda$0 = CertificatePinner.check$lambda$0(CertificatePinner.this, peerCertificates, hostname);
                return check$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List check$lambda$0(CertificatePinner certificatePinner, List list, String str) {
        List<Certificate> clean;
        CertificateChainCleaner certificateChainCleaner = certificatePinner.certificateChainCleaner;
        if (certificateChainCleaner != null && (clean = certificateChainCleaner.clean(list, str)) != null) {
            list = clean;
        }
        List<Certificate> list2 = list;
        ArrayList arrayList = new ArrayList(f0.d0(list2, 10));
        for (Certificate certificate : list2) {
            g0.n(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final String pin(@NotNull Certificate certificate) {
        return Companion.pin(certificate);
    }

    @JvmStatic
    @NotNull
    public static final ByteString sha1Hash(@NotNull X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    @JvmStatic
    @NotNull
    public static final ByteString sha256Hash(@NotNull X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    @Deprecated(message = "replaced with {@link #check(String, List)}.", replaceWith = @ReplaceWith(expression = "check(hostname, peerCertificates.toList())", imports = {}))
    public final void check(@NotNull String hostname, @NotNull Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        g0.p(hostname, "hostname");
        g0.p(peerCertificates, "peerCertificates");
        check(hostname, n.dz(peerCertificates));
    }

    public final void check$okhttp(@NotNull String hostname, @NotNull Function0<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) {
        g0.p(hostname, "hostname");
        g0.p(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<Pin> findMatchingPins = findMatchingPins(hostname);
        if (findMatchingPins.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> invoke = cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : invoke) {
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (Pin pin : findMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                if (g0.g(hashAlgorithm, "sha256")) {
                    if (byteString == null) {
                        byteString = Companion.sha256Hash(x509Certificate);
                    }
                    if (g0.g(pin.getHash(), byteString)) {
                        return;
                    }
                } else {
                    if (!g0.g(hashAlgorithm, "sha1")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                    }
                    if (byteString2 == null) {
                        byteString2 = Companion.sha1Hash(x509Certificate);
                    }
                    if (g0.g(pin.getHash(), byteString2)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : invoke) {
            sb.append("\n    ");
            sb.append(Companion.pin(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(hostname);
        sb.append(":");
        for (Pin pin2 : findMatchingPins) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        return g0.g(certificatePinner.pins, this.pins) && g0.g(certificatePinner.certificateChainCleaner, this.certificateChainCleaner);
    }

    @NotNull
    public final List<Pin> findMatchingPins(@NotNull String hostname) {
        g0.p(hostname, "hostname");
        Set<Pin> set = this.pins;
        List<Pin> J = f0.J();
        for (Object obj : set) {
            if (((Pin) obj).matchesHostname(hostname)) {
                if (J.isEmpty()) {
                    J = new ArrayList<>();
                }
                g0.n(J, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal._UtilCommonKt.filterList>");
                u0.g(J).add(obj);
            }
        }
        return J;
    }

    @Nullable
    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    @NotNull
    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int hashCode = (1517 + this.pins.hashCode()) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return hashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    @NotNull
    public final CertificatePinner withCertificateChainCleaner$okhttp(@NotNull CertificateChainCleaner certificateChainCleaner) {
        g0.p(certificateChainCleaner, "certificateChainCleaner");
        return g0.g(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i6, v vVar) {
        this(set, (i6 & 2) != 0 ? null : certificateChainCleaner);
    }
}
