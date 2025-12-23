package com.bytedance.sdk.component.cw.xt.j.g;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class xt implements m {

    /* renamed from: j, reason: collision with root package name */
    private final Map<X500Principal, Set<X509Certificate>> f26186j = new LinkedHashMap();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof xt) && ((xt) obj).f26186j.equals(this.f26186j);
    }

    public int hashCode() {
        return this.f26186j.hashCode();
    }

    public xt(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> set = this.f26186j.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet<>(1);
                this.f26186j.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.g.m
    public X509Certificate j(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.f26186j.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
