package com.bytedance.pangle.tl;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes4.dex */
class av extends w {

    /* renamed from: j, reason: collision with root package name */
    private final byte[] f25517j;
    private int xt;

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof av)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((av) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // com.bytedance.pangle.tl.w, java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.f25517j;
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.xt == -1) {
            try {
                this.xt = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.xt = 0;
            }
        }
        return this.xt;
    }

    av(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.xt = -1;
        this.f25517j = bArr;
    }
}
