package com.bytedance.sdk.component.cw.xt.j.xt;

import com.bytedance.sdk.component.cw.xt.qv;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class xt {
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private final List<qv> f26320j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f26321r;
    private int xt = 0;

    public qv j(SSLSocket sSLSocket) throws IOException {
        qv qvVar;
        int i6 = this.xt;
        int size = this.f26320j.size();
        while (true) {
            if (i6 >= size) {
                qvVar = null;
                break;
            }
            qvVar = this.f26320j.get(i6);
            if (qvVar.j(sSLSocket)) {
                this.xt = i6 + 1;
                break;
            }
            i6++;
        }
        if (qvVar != null) {
            this.cw = xt(sSLSocket);
            com.bytedance.sdk.component.cw.xt.j.j.f26187j.j(qvVar, sSLSocket, this.f26321r);
            return qvVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f26321r + ", modes=" + this.f26320j + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    private boolean xt(SSLSocket sSLSocket) {
        for (int i6 = this.xt; i6 < this.f26320j.size(); i6++) {
            if (this.f26320j.get(i6).j(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public xt(List<qv> list) {
        this.f26320j = list;
    }

    public boolean j(IOException iOException) {
        this.f26321r = true;
        if (!this.cw || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z5 = iOException instanceof SSLHandshakeException;
        if ((z5 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z5 || (iOException instanceof SSLProtocolException);
    }
}
