package com.bytedance.sdk.component.cw.xt;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class i {
    private final List<Certificate> cw;

    /* renamed from: j, reason: collision with root package name */
    private final gq f26143j;

    /* renamed from: r, reason: collision with root package name */
    private final List<Certificate> f26144r;
    private final tl xt;

    public static i j(SSLSession sSLSession) {
        String str;
        Certificate[] certificateArr = null;
        try {
            str = sSLSession.getCipherSuite();
        } catch (Exception unused) {
            str = null;
        }
        if (str == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        tl j6 = tl.j(str);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        gq j7 = gq.j(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused2) {
        }
        List j8 = certificateArr != null ? com.bytedance.sdk.component.cw.xt.j.cw.j(certificateArr) : Collections.EMPTY_LIST;
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new i(j7, j6, j8, localCertificates != null ? com.bytedance.sdk.component.cw.xt.j.cw.j(localCertificates) : Collections.EMPTY_LIST);
    }

    public List<Certificate> cw() {
        return this.cw;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f26143j.equals(iVar.f26143j) && this.xt.equals(iVar.xt) && this.cw.equals(iVar.cw) && this.f26144r.equals(iVar.f26144r);
    }

    public int hashCode() {
        return ((((((this.f26143j.hashCode() + 527) * 31) + this.xt.hashCode()) * 31) + this.cw.hashCode()) * 31) + this.f26144r.hashCode();
    }

    public List<Certificate> r() {
        return this.f26144r;
    }

    public tl xt() {
        return this.xt;
    }

    private i(gq gqVar, tl tlVar, List<Certificate> list, List<Certificate> list2) {
        this.f26143j = gqVar;
        this.xt = tlVar;
        this.cw = list;
        this.f26144r = list2;
    }

    public gq j() {
        return this.f26143j;
    }
}
