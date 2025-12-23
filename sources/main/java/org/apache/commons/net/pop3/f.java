package org.apache.commons.net.pop3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f extends b {
    private static final int T = 995;
    private static final String U = "TLS";
    private final boolean K;
    private final String L;
    private SSLContext M;
    private String[] N;
    private String[] O;
    private TrustManager P;
    private KeyManager Q;
    private HostnameVerifier R;
    private boolean S;

    public f() {
        this("TLS", false);
    }

    public void J0(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        this.N = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
    }

    public void K0(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        this.O = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
    }

    public f(boolean z5) {
        this("TLS", z5);
    }

    private KeyManager E0() {
        return this.Q;
    }

    private void G0() throws IOException {
        if (this.M == null) {
            this.M = org.apache.commons.net.util.d.a(this.L, E0(), F0());
        }
    }

    public boolean A0() throws SSLException, IOException {
        if (h0("STLS") != 0) {
            return false;
        }
        I0();
        return true;
    }

    public String[] B0() {
        Socket socket = this.f50801e;
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getEnabledCipherSuites();
        }
        return null;
    }

    public String[] C0() {
        Socket socket = this.f50801e;
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getEnabledProtocols();
        }
        return null;
    }

    public HostnameVerifier D0() {
        return this.R;
    }

    public TrustManager F0() {
        return this.P;
    }

    public boolean H0() {
        return this.S;
    }

    public void L0(boolean z5) {
        this.S = z5;
    }

    public void M0(HostnameVerifier hostnameVerifier) {
        this.R = hostnameVerifier;
    }

    public void N0(KeyManager keyManager) {
        this.Q = keyManager;
    }

    public void O0(TrustManager trustManager) {
        this.P = trustManager;
    }

    @Override // org.apache.commons.net.pop3.a, org.apache.commons.net.g
    protected void b() throws IOException {
        if (this.K) {
            I0();
        }
        super.b();
    }

    public f(String str) {
        this(str, false);
    }

    private void I0() throws IOException {
        G0();
        SSLSocketFactory socketFactory = this.M.getSocketFactory();
        String str = this.f50802f;
        if (str == null) {
            str = B().getHostAddress();
        }
        SSLSocket sSLSocket = (SSLSocket) socketFactory.createSocket(this.f50801e, str, C(), true);
        sSLSocket.setEnableSessionCreation(true);
        sSLSocket.setUseClientMode(true);
        if (this.S) {
            org.apache.commons.net.util.e.a(sSLSocket);
        }
        String[] strArr = this.O;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = this.N;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
        sSLSocket.startHandshake();
        this.f50801e = sSLSocket;
        this.f50804h = sSLSocket.getInputStream();
        this.f50805i = sSLSocket.getOutputStream();
        this.f50992w = new org.apache.commons.net.io.a(new InputStreamReader(this.f50804h, org.apache.commons.net.ftp.b.T));
        this.f50991v = new BufferedWriter(new OutputStreamWriter(this.f50805i, org.apache.commons.net.ftp.b.T));
        HostnameVerifier hostnameVerifier = this.R;
        if (hostnameVerifier != null && !hostnameVerifier.verify(str, sSLSocket.getSession())) {
            throw new SSLHandshakeException("Hostname doesn't match certificate");
        }
    }

    public f(String str, boolean z5) {
        this(str, z5, null);
    }

    public f(String str, boolean z5, SSLContext sSLContext) {
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.L = str;
        this.K = z5;
        this.M = sSLContext;
        if (z5) {
            N(T);
        }
    }

    public f(boolean z5, SSLContext sSLContext) {
        this("TLS", z5, sSLContext);
    }

    public f(SSLContext sSLContext) {
        this(false, sSLContext);
    }
}
