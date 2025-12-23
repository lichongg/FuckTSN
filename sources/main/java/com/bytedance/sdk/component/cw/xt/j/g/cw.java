package com.bytedance.sdk.component.cw.xt.j.g;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class cw {
    public static cw j(X509TrustManager x509TrustManager) {
        return com.bytedance.sdk.component.cw.xt.j.ae.up.xt().j(x509TrustManager);
    }

    public abstract List<Certificate> j(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
