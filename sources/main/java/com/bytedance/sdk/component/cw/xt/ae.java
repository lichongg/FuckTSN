package com.bytedance.sdk.component.cw.xt;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class ae {

    /* renamed from: j, reason: collision with root package name */
    public static final ae f26115j = new j().j();
    private final com.bytedance.sdk.component.cw.xt.j.g.cw cw;
    private final Set<xt> xt;

    public static final class j {

        /* renamed from: j, reason: collision with root package name */
        private final List<xt> f26116j = new ArrayList();

        public ae j() {
            return new ae(new LinkedHashSet(this.f26116j), null);
        }
    }

    static final class xt {
        final String cw;

        /* renamed from: j, reason: collision with root package name */
        final String f26117j;

        /* renamed from: r, reason: collision with root package name */
        final com.bytedance.sdk.component.cw.j.m f26118r;
        final String xt;

        public boolean equals(Object obj) {
            if (!(obj instanceof xt)) {
                return false;
            }
            xt xtVar = (xt) obj;
            return this.f26117j.equals(xtVar.f26117j) && this.cw.equals(xtVar.cw) && this.f26118r.equals(xtVar.f26118r);
        }

        public int hashCode() {
            return ((((this.f26117j.hashCode() + 527) * 31) + this.cw.hashCode()) * 31) + this.f26118r.hashCode();
        }

        boolean j(String str) {
            if (!this.f26117j.startsWith("*.")) {
                return str.equals(this.xt);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 != this.xt.length()) {
                return false;
            }
            String str2 = this.xt;
            return str.regionMatches(false, indexOf + 1, str2, 0, str2.length());
        }

        public String toString() {
            return this.cw + this.f26118r.xt();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ae)) {
            return false;
        }
        ae aeVar = (ae) obj;
        return com.bytedance.sdk.component.cw.xt.j.cw.j(this.cw, aeVar.cw) && this.xt.equals(aeVar.xt);
    }

    public void j(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<xt> j6 = j(str);
        if (j6.isEmpty()) {
            return;
        }
        com.bytedance.sdk.component.cw.xt.j.g.cw cwVar = this.cw;
        if (cwVar != null) {
            list = cwVar.j(list, str);
        }
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i6);
            int size2 = j6.size();
            com.bytedance.sdk.component.cw.j.m mVar = null;
            com.bytedance.sdk.component.cw.j.m mVar2 = null;
            for (int i7 = 0; i7 < size2; i7++) {
                xt xtVar = j6.get(i7);
                if (xtVar.cw.equals("sha256/")) {
                    if (mVar == null) {
                        mVar = xt(x509Certificate);
                    }
                    if (xtVar.f26118r.equals(mVar)) {
                        return;
                    }
                } else {
                    if (!xtVar.cw.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + xtVar.cw);
                    }
                    if (mVar2 == null) {
                        mVar2 = j(x509Certificate);
                    }
                    if (xtVar.f26118r.equals(mVar2)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i8 = 0; i8 < size3; i8++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i8);
            sb.append("\n    ");
            sb.append(j((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = j6.size();
        for (int i9 = 0; i9 < size4; i9++) {
            xt xtVar2 = j6.get(i9);
            sb.append("\n    ");
            sb.append(xtVar2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public int hashCode() {
        com.bytedance.sdk.component.cw.xt.j.g.cw cwVar = this.cw;
        return ((cwVar != null ? cwVar.hashCode() : 0) * 31) + this.xt.hashCode();
    }

    ae(Set<xt> set, com.bytedance.sdk.component.cw.xt.j.g.cw cwVar) {
        this.xt = set;
        this.cw = cwVar;
    }

    static com.bytedance.sdk.component.cw.j.m xt(X509Certificate x509Certificate) {
        return com.bytedance.sdk.component.cw.j.m.j(x509Certificate.getPublicKey().getEncoded()).r();
    }

    List<xt> j(String str) {
        List<xt> list = Collections.EMPTY_LIST;
        for (xt xtVar : this.xt) {
            if (xtVar.j(str)) {
                if (list.isEmpty()) {
                    list = new ArrayList<>();
                }
                list.add(xtVar);
            }
        }
        return list;
    }

    ae j(com.bytedance.sdk.component.cw.xt.j.g.cw cwVar) {
        return com.bytedance.sdk.component.cw.xt.j.cw.j(this.cw, cwVar) ? this : new ae(this.xt, cwVar);
    }

    public static String j(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + xt((X509Certificate) certificate).xt();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static com.bytedance.sdk.component.cw.j.m j(X509Certificate x509Certificate) {
        return com.bytedance.sdk.component.cw.j.m.j(x509Certificate.getPublicKey().getEncoded()).cw();
    }
}
