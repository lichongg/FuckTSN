package org.apache.commons.net.smtp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f extends c {
    private static final String N = "TLS";
    private final boolean E;
    private final String F;
    private SSLContext G;
    private String[] H;
    private String[] I;
    private TrustManager J;
    private KeyManager K;
    private HostnameVerifier L;
    private boolean M;

    public f() {
        this("TLS", false);
    }

    public void a1(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        this.H = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
    }

    public void b1(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        this.I = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
    }

    public f(boolean z5) {
        this("TLS", z5);
    }

    private void X0() throws IOException {
        if (this.G == null) {
            this.G = org.apache.commons.net.util.d.a(this.F, V0(), W0());
        }
    }

    public boolean R0() throws IOException {
        if (!e.c(v0("STARTTLS"))) {
            return false;
        }
        Z0();
        return true;
    }

    public String[] S0() {
        Socket socket = this.f50801e;
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getEnabledCipherSuites();
        }
        return null;
    }

    public String[] T0() {
        Socket socket = this.f50801e;
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getEnabledProtocols();
        }
        return null;
    }

    public HostnameVerifier U0() {
        return this.L;
    }

    public KeyManager V0() {
        return this.K;
    }

    public TrustManager W0() {
        return this.J;
    }

    public boolean Y0() {
        return this.M;
    }

    @Override // org.apache.commons.net.smtp.b, org.apache.commons.net.g
    protected void b() throws IOException {
        if (this.E) {
            Z0();
        }
        super.b();
    }

    public void c1(boolean z5) {
        this.M = z5;
    }

    public void d1(HostnameVerifier hostnameVerifier) {
        this.L = hostnameVerifier;
    }

    public void e1(KeyManager keyManager) {
        this.K = keyManager;
    }

    public void f1(TrustManager trustManager) {
        this.J = trustManager;
    }

    public f(String str) {
        this(str, false);
    }

    private void Z0() throws IOException {
        X0();
        SSLSocketFactory socketFactory = this.G.getSocketFactory();
        String str = this.f50802f;
        if (str == null) {
            str = B().getHostAddress();
        }
        SSLSocket sSLSocket = (SSLSocket) socketFactory.createSocket(this.f50801e, str, C(), true);
        sSLSocket.setEnableSessionCreation(true);
        sSLSocket.setUseClientMode(true);
        if (this.M) {
            org.apache.commons.net.util.e.a(sSLSocket);
        }
        String[] strArr = this.I;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = this.H;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
        sSLSocket.startHandshake();
        this.f50801e = sSLSocket;
        this.f50804h = sSLSocket.getInputStream();
        this.f50805i = sSLSocket.getOutputStream();
        this.f51022w = new org.apache.commons.net.io.a(new InputStreamReader(this.f50804h, this.f51020u));
        this.f51023x = new BufferedWriter(new OutputStreamWriter(this.f50805i, this.f51020u));
        HostnameVerifier hostnameVerifier = this.L;
        if (hostnameVerifier != null && !hostnameVerifier.verify(str, sSLSocket.getSession())) {
            throw new SSLHandshakeException("Hostname doesn't match certificate");
        }
    }

    public f(String str, boolean z5) {
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.F = str;
        this.E = z5;
    }

    public f(String str, boolean z5, String str2) {
        super(str2);
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.F = str;
        this.E = z5;
    }

    public f(boolean z5, SSLContext sSLContext) {
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.E = z5;
        this.G = sSLContext;
        this.F = "TLS";
    }

    public f(SSLContext sSLContext) {
        this(false, sSLContext);
    }
}
