package com.bytedance.sdk.component.cw.xt.j.g;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j extends cw {

    /* renamed from: j, reason: collision with root package name */
    private final m f26181j;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof j) && ((j) obj).f26181j.equals(this.f26181j);
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.g.cw
    public List<Certificate> j(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        boolean z5 = false;
        for (int i6 = 0; i6 < 9; i6++) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate j6 = this.f26181j.j(x509Certificate);
            if (j6 == null) {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (j(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (!z5) {
                    throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed ".concat(String.valueOf(x509Certificate)));
                }
                return arrayList;
            }
            if (arrayList.size() > 1 || !x509Certificate.equals(j6)) {
                arrayList.add(j6);
            }
            if (j(j6, j6)) {
                return arrayList;
            }
            z5 = true;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: ".concat(String.valueOf(arrayList)));
    }

    public int hashCode() {
        return this.f26181j.hashCode();
    }

    public j(m mVar) {
        this.f26181j = mVar;
    }

    private boolean j(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
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
