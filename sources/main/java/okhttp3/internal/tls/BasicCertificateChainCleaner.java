package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int MAX_SIGNERS = 9;

    @NotNull
    private final TrustRootIndex trustRootIndex;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof BasicCertificateChainCleaner) && g0.g(((BasicCertificateChainCleaner) obj).trustRootIndex, this.trustRootIndex);
    }

    public BasicCertificateChainCleaner(@NotNull TrustRootIndex trustRootIndex) {
        g0.p(trustRootIndex, "trustRootIndex");
        this.trustRootIndex = trustRootIndex;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    @NotNull
    public List<Certificate> clean(@NotNull List<? extends Certificate> chain, @NotNull String hostname) throws SSLPeerUnverifiedException {
        g0.p(chain, "chain");
        g0.p(hostname, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(chain);
        ArrayList arrayList = new ArrayList();
        Object removeFirst = arrayDeque.removeFirst();
        g0.o(removeFirst, "removeFirst(...)");
        arrayList.add(removeFirst);
        boolean z5 = false;
        for (int i6 = 0; i6 < 9; i6++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            g0.n(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate x509Certificate = (X509Certificate) obj;
            X509Certificate findByIssuerAndSignature = this.trustRootIndex.findByIssuerAndSignature(x509Certificate);
            if (findByIssuerAndSignature == null) {
                Iterator it = arrayDeque.iterator();
                g0.o(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    g0.n(next, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    X509Certificate x509Certificate2 = (X509Certificate) next;
                    if (verifySignature(x509Certificate, x509Certificate2, arrayList.size() - 1)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (!z5) {
                    throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                }
                return arrayList;
            }
            if (arrayList.size() > 1 || !g0.g(x509Certificate, findByIssuerAndSignature)) {
                arrayList.add(findByIssuerAndSignature);
            }
            if (verifySignature(findByIssuerAndSignature, findByIssuerAndSignature, arrayList.size() - 2)) {
                return arrayList;
            }
            z5 = true;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }

    private final boolean verifySignature(X509Certificate x509Certificate, X509Certificate x509Certificate2, int i6) {
        if (!g0.g(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN()) || x509Certificate2.getBasicConstraints() < i6) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
