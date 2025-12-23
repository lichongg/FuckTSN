package org.apache.commons.net.imap;

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
import org.apache.commons.net.util.d;
import org.apache.commons.net.util.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends IMAPClient {
    public static final int P = 993;
    public static final String Q = "TLS";
    private final boolean G;
    private final String H;
    private SSLContext I;
    private String[] J;
    private String[] K;
    private TrustManager L;
    private KeyManager M;
    private HostnameVerifier N;
    private boolean O;

    public b() {
        this(Q, false);
    }

    public void X0(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        this.J = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
    }

    public void Y0(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        this.K = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
    }

    public b(boolean z5) {
        this(Q, z5);
    }

    private KeyManager S0() {
        return this.M;
    }

    private void U0() throws IOException {
        if (this.I == null) {
            this.I = d.a(this.H, S0(), T0());
        }
    }

    public boolean O0() throws SSLException, IOException {
        if (h0(IMAPCommand.getCommand(IMAPCommand.STARTTLS)) != 0) {
            return false;
        }
        W0();
        return true;
    }

    public String[] P0() {
        Socket socket = this.f50801e;
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getEnabledCipherSuites();
        }
        return null;
    }

    public String[] Q0() {
        Socket socket = this.f50801e;
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getEnabledProtocols();
        }
        return null;
    }

    public HostnameVerifier R0() {
        return this.N;
    }

    public TrustManager T0() {
        return this.L;
    }

    public boolean V0() {
        return this.O;
    }

    public void Z0(boolean z5) {
        this.O = z5;
    }

    public void a1(HostnameVerifier hostnameVerifier) {
        this.N = hostnameVerifier;
    }

    @Override // org.apache.commons.net.imap.IMAP, org.apache.commons.net.g
    protected void b() throws IOException {
        if (this.G) {
            W0();
        }
        super.b();
    }

    public void b1(KeyManager keyManager) {
        this.M = keyManager;
    }

    public void c1(TrustManager trustManager) {
        this.L = trustManager;
    }

    public b(String str) {
        this(str, false);
    }

    private void W0() throws IOException {
        U0();
        SSLSocketFactory socketFactory = this.I.getSocketFactory();
        String str = this.f50802f;
        if (str == null) {
            str = B().getHostAddress();
        }
        SSLSocket sSLSocket = (SSLSocket) socketFactory.createSocket(this.f50801e, str, C(), true);
        sSLSocket.setEnableSessionCreation(true);
        sSLSocket.setUseClientMode(true);
        if (this.O) {
            e.a(sSLSocket);
        }
        String[] strArr = this.K;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = this.J;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
        sSLSocket.startHandshake();
        this.f50801e = sSLSocket;
        this.f50804h = sSLSocket.getInputStream();
        this.f50805i = sSLSocket.getOutputStream();
        this.f50816w = new org.apache.commons.net.io.a(new InputStreamReader(this.f50804h, org.apache.commons.net.ftp.b.T));
        this.f50815v = new BufferedWriter(new OutputStreamWriter(this.f50805i, org.apache.commons.net.ftp.b.T));
        HostnameVerifier hostnameVerifier = this.N;
        if (hostnameVerifier != null && !hostnameVerifier.verify(str, sSLSocket.getSession())) {
            throw new SSLHandshakeException("Hostname doesn't match certificate");
        }
    }

    public b(String str, boolean z5) {
        this(str, z5, null);
    }

    public b(String str, boolean z5, SSLContext sSLContext) {
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        N(P);
        this.H = str;
        this.G = z5;
        this.I = sSLContext;
    }

    public b(boolean z5, SSLContext sSLContext) {
        this(Q, z5, sSLContext);
    }

    public b(SSLContext sSLContext) {
        this(false, sSLContext);
    }
}
