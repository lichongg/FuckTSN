package org.apache.commons.net.ftp;

import androidx.exifinterface.media.ExifInterface;
import java.io.BufferedReader;
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
public class m extends c {
    public static final int Z0 = 989;

    /* renamed from: a1, reason: collision with root package name */
    public static final int f50700a1 = 990;

    /* renamed from: d1, reason: collision with root package name */
    private static final String f50703d1 = "TLS";

    /* renamed from: e1, reason: collision with root package name */
    private static final String f50704e1 = "AUTH";

    /* renamed from: f1, reason: collision with root package name */
    private static final String f50705f1 = "ADAT";

    /* renamed from: g1, reason: collision with root package name */
    private static final String f50706g1 = "PROT";

    /* renamed from: h1, reason: collision with root package name */
    private static final String f50707h1 = "PBSZ";

    /* renamed from: i1, reason: collision with root package name */
    private static final String f50708i1 = "MIC";

    /* renamed from: j1, reason: collision with root package name */
    private static final String f50709j1 = "CONF";

    /* renamed from: k1, reason: collision with root package name */
    private static final String f50710k1 = "ENC";

    /* renamed from: l1, reason: collision with root package name */
    private static final String f50711l1 = "CCC";

    /* renamed from: m1, reason: collision with root package name */
    @Deprecated
    public static String f50712m1;

    /* renamed from: n1, reason: collision with root package name */
    @Deprecated
    public static String f50713n1;

    /* renamed from: o1, reason: collision with root package name */
    @Deprecated
    public static String f50714o1;

    /* renamed from: p1, reason: collision with root package name */
    @Deprecated
    public static String f50715p1;
    private final boolean K0;
    private final String L0;
    private String M0;
    private SSLContext N0;
    private Socket O0;
    private boolean P0;
    private boolean Q0;
    private boolean R0;
    private boolean S0;
    private String[] T0;
    private String[] U0;
    private TrustManager V0;
    private KeyManager W0;
    private HostnameVerifier X0;
    private boolean Y0;

    /* renamed from: c1, reason: collision with root package name */
    private static final String f50702c1 = "C";

    /* renamed from: b1, reason: collision with root package name */
    private static final String[] f50701b1 = {f50702c1, ExifInterface.LONGITUDE_EAST, ExifInterface.LATITUDE_SOUTH, "P"};

    public m() {
        this("TLS", false);
    }

    public void A4(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        this.U0 = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
    }

    public void z4(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        this.T0 = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
    }

    public m(boolean z5) {
        this("TLS", z5);
    }

    private boolean Z3(String str) {
        for (String str2 : f50701b1) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private KeyManager p4() {
        return this.W0;
    }

    private void u4() throws IOException {
        if (this.N0 == null) {
            this.N0 = org.apache.commons.net.util.d.a(this.L0, p4(), r4());
        }
    }

    public void B4(boolean z5) {
        this.P0 = z5;
    }

    public void C4(boolean z5) {
        this.Y0 = z5;
    }

    public void D4(HostnameVerifier hostnameVerifier) {
        this.X0 = hostnameVerifier;
    }

    public void E4(KeyManager keyManager) {
        this.W0 = keyManager;
    }

    public void F4(boolean z5) {
        this.R0 = z5;
    }

    public void G4(TrustManager trustManager) {
        this.V0 = trustManager;
    }

    public void H4(boolean z5) {
        this.Q0 = z5;
    }

    public void I4(boolean z5) {
        this.S0 = z5;
    }

    protected void J4() throws IOException {
        HostnameVerifier hostnameVerifier;
        this.O0 = this.f50801e;
        u4();
        SSLSocketFactory socketFactory = this.N0.getSocketFactory();
        String str = this.f50802f;
        if (str == null) {
            str = B().getHostAddress();
        }
        SSLSocket sSLSocket = (SSLSocket) socketFactory.createSocket(this.f50801e, str, this.f50801e.getPort(), false);
        sSLSocket.setEnableSessionCreation(this.P0);
        sSLSocket.setUseClientMode(this.Q0);
        if (!this.Q0) {
            sSLSocket.setNeedClientAuth(this.R0);
            sSLSocket.setWantClientAuth(this.S0);
        } else if (this.Y0) {
            org.apache.commons.net.util.e.a(sSLSocket);
        }
        String[] strArr = this.U0;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = this.T0;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
        sSLSocket.startHandshake();
        this.f50801e = sSLSocket;
        this.C = new BufferedReader(new InputStreamReader(sSLSocket.getInputStream(), t0()));
        this.D = new BufferedWriter(new OutputStreamWriter(sSLSocket.getOutputStream(), t0()));
        if (this.Q0 && (hostnameVerifier = this.X0) != null && !hostnameVerifier.verify(str, sSLSocket.getSession())) {
            throw new SSLHandshakeException("Hostname doesn't match certificate");
        }
    }

    public int a4(byte[] bArr) throws IOException {
        return bArr != null ? d1(f50705f1, org.apache.commons.net.util.a.r(bArr)) : c1(f50705f1);
    }

    @Override // org.apache.commons.net.ftp.c, org.apache.commons.net.ftp.b, org.apache.commons.net.g
    protected void b() throws IOException {
        if (this.K0) {
            J4();
        }
        super.b();
        if (this.K0) {
            return;
        }
        c4();
        J4();
    }

    public int b4(String str) throws IOException {
        return d1(f50704e1, str);
    }

    protected void c4() throws SSLException, IOException {
        int d12 = d1(f50704e1, this.M0);
        if (334 != d12 && 234 != d12) {
            throw new SSLException(w0());
        }
    }

    public int d4() throws IOException {
        return c1(f50711l1);
    }

    public int e4(byte[] bArr) throws IOException {
        return bArr != null ? d1(f50709j1, org.apache.commons.net.util.a.r(bArr)) : d1(f50709j1, "");
    }

    public int f4(byte[] bArr) throws IOException {
        return bArr != null ? d1(f50710k1, org.apache.commons.net.util.a.r(bArr)) : d1(f50710k1, "");
    }

    public int g4(byte[] bArr) throws IOException {
        return bArr != null ? d1(f50708i1, org.apache.commons.net.util.a.r(bArr)) : d1(f50708i1, "");
    }

    public void h4(long j6) throws SSLException, IOException {
        if (j6 < 0 || 4294967295L < j6) {
            throw new IllegalArgumentException();
        }
        if (200 != d1(f50707h1, String.valueOf(j6))) {
            throw new SSLException(w0());
        }
    }

    public void i4(String str) throws SSLException, IOException {
        if (str == null) {
            str = f50702c1;
        }
        if (!Z3(str)) {
            throw new IllegalArgumentException();
        }
        if (200 != d1(f50706g1, str)) {
            throw new SSLException(w0());
        }
        if (f50702c1.equals(str)) {
            W(null);
            T(null);
        } else {
            W(new p(this.N0));
            T(new o(this.N0));
            u4();
        }
    }

    public String k4() {
        return this.M0;
    }

    public boolean l4() {
        Socket socket = this.f50801e;
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getEnableSessionCreation();
        }
        return false;
    }

    public String[] m4() {
        Socket socket = this.f50801e;
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getEnabledCipherSuites();
        }
        return null;
    }

    public String[] n4() {
        Socket socket = this.f50801e;
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getEnabledProtocols();
        }
        return null;
    }

    public HostnameVerifier o4() {
        return this.X0;
    }

    public boolean q4() {
        Socket socket = this.f50801e;
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getNeedClientAuth();
        }
        return false;
    }

    public TrustManager r4() {
        return this.V0;
    }

    public boolean s4() {
        Socket socket = this.f50801e;
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getUseClientMode();
        }
        return false;
    }

    public boolean t4() {
        Socket socket = this.f50801e;
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getWantClientAuth();
        }
        return false;
    }

    public boolean v4() {
        return this.Y0;
    }

    public byte[] w4(String str) {
        if (str == null) {
            return null;
        }
        return org.apache.commons.net.util.a.f(j4("ADAT=", str));
    }

    public void y4(String str) {
        this.M0 = str;
    }

    public m(String str) {
        this(str, false);
    }

    private String j4(String str, String str2) {
        int indexOf = str2.indexOf(str);
        if (indexOf == -1) {
            return null;
        }
        return str2.substring(indexOf + str.length()).trim();
    }

    @Override // org.apache.commons.net.ftp.c
    @Deprecated
    protected Socket B1(int i6, String str) throws IOException {
        return C1(e.b(i6), str);
    }

    @Override // org.apache.commons.net.ftp.c
    protected Socket C1(String str, String str2) throws IOException {
        Socket C1 = super.C1(str, str2);
        Y3(C1);
        if (C1 instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) C1;
            sSLSocket.setUseClientMode(this.Q0);
            sSLSocket.setEnableSessionCreation(this.P0);
            if (!this.Q0) {
                sSLSocket.setNeedClientAuth(this.R0);
                sSLSocket.setWantClientAuth(this.S0);
            }
            String[] strArr = this.T0;
            if (strArr != null) {
                sSLSocket.setEnabledCipherSuites(strArr);
            }
            String[] strArr2 = this.U0;
            if (strArr2 != null) {
                sSLSocket.setEnabledProtocols(strArr2);
            }
            sSLSocket.startHandshake();
        }
        return C1;
    }

    @Override // org.apache.commons.net.ftp.b
    public int d1(String str, String str2) throws IOException {
        int d12 = super.d1(str, str2);
        if (f50711l1.equals(str)) {
            if (200 == d12) {
                this.f50801e.close();
                this.f50801e = this.O0;
                this.C = new BufferedReader(new InputStreamReader(this.f50801e.getInputStream(), t0()));
                this.D = new BufferedWriter(new OutputStreamWriter(this.f50801e.getOutputStream(), t0()));
                return d12;
            }
            throw new SSLException(w0());
        }
        return d12;
    }

    @Override // org.apache.commons.net.ftp.c, org.apache.commons.net.ftp.b, org.apache.commons.net.g
    public void n() throws IOException {
        super.n();
        Socket socket = this.O0;
        if (socket != null) {
            socket.close();
        }
        W(null);
        T(null);
    }

    public long x4(long j6) throws SSLException, IOException {
        h4(j6);
        String j42 = j4("PBSZ=", w0());
        if (j42 != null) {
            long parseLong = Long.parseLong(j42);
            if (parseLong < j6) {
                return parseLong;
            }
        }
        return j6;
    }

    public m(String str, boolean z5) {
        this.M0 = "TLS";
        this.P0 = true;
        this.Q0 = true;
        this.R0 = false;
        this.S0 = false;
        this.T0 = null;
        this.U0 = null;
        this.V0 = org.apache.commons.net.util.g.d();
        this.W0 = null;
        this.X0 = null;
        this.L0 = str;
        this.K0 = z5;
        if (z5) {
            N(f50700a1);
        }
    }

    public m(boolean z5, SSLContext sSLContext) {
        this("TLS", z5);
        this.N0 = sSLContext;
    }

    public m(SSLContext sSLContext) {
        this(false, sSLContext);
    }

    protected void Y3(Socket socket) throws IOException {
    }
}
