package org.apache.commons.net.ftp;

import com.huawei.hms.common.util.Logger;
import io.netty.util.internal.StringUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.net.MalformedServerReplyException;
import org.apache.commons.net.ProtocolCommandSupport;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends org.apache.commons.net.g {
    public static final int E = 20;
    public static final int F = 21;
    public static final int G = 0;
    public static final int H = 1;
    public static final int I = 2;
    public static final int J = 3;
    public static final int K = 4;
    public static final int L = 5;
    public static final int M = 6;
    public static final int N = 7;
    public static final int O = 8;
    public static final int P = 9;
    public static final int Q = 10;
    public static final int R = 11;
    public static final int S = 12;
    public static final String T = "ISO-8859-1";
    public static final int U = 3;
    private static final String V = "AEILNTCFRPSBC";
    protected boolean A = false;
    private boolean B = true;
    protected BufferedReader C;
    protected BufferedWriter D;

    /* renamed from: u, reason: collision with root package name */
    protected int f50558u;

    /* renamed from: v, reason: collision with root package name */
    protected ArrayList<String> f50559v;

    /* renamed from: w, reason: collision with root package name */
    protected boolean f50560w;

    /* renamed from: x, reason: collision with root package name */
    protected String f50561x;

    /* renamed from: y, reason: collision with root package name */
    protected String f50562y;

    /* renamed from: z, reason: collision with root package name */
    protected ProtocolCommandSupport f50563z;

    private void a0() throws IOException {
        b0(true);
    }

    private void b0(boolean z5) throws IOException {
        this.f50560w = true;
        this.f50559v.clear();
        String readLine = this.C.readLine();
        if (readLine == null) {
            throw new FTPConnectionClosedException("Connection closed without indication.");
        }
        int length = readLine.length();
        if (length < 3) {
            throw new MalformedServerReplyException("Truncated server reply: " + readLine);
        }
        try {
            String substring = readLine.substring(0, 3);
            this.f50558u = Integer.parseInt(substring);
            this.f50559v.add(readLine);
            if (length > 3) {
                char charAt = readLine.charAt(3);
                if (charAt == '-') {
                    while (true) {
                        String readLine2 = this.C.readLine();
                        if (readLine2 == null) {
                            throw new FTPConnectionClosedException("Connection closed without indication.");
                        }
                        this.f50559v.add(readLine2);
                        if (A0()) {
                            if (!g0(readLine2, substring)) {
                                break;
                            }
                        } else if (!d0(readLine2)) {
                            break;
                        }
                    }
                } else if (B0()) {
                    if (length == 4) {
                        throw new MalformedServerReplyException("Truncated server reply: '" + readLine + "'");
                    }
                    if (charAt != ' ') {
                        throw new MalformedServerReplyException("Invalid server reply: '" + readLine + "'");
                    }
                }
            } else if (B0()) {
                throw new MalformedServerReplyException("Truncated server reply: '" + readLine + "'");
            }
            if (z5) {
                p(this.f50558u, w0());
            }
            if (this.f50558u == 421) {
                throw new FTPConnectionClosedException("FTP response 421 received.  Server closed connection.");
            }
        } catch (NumberFormatException unused) {
            throw new MalformedServerReplyException("Could not parse response code.\nServer Reply: " + readLine);
        }
    }

    public int a1(int i6) throws IOException {
        return b1(i6, null);
    }

    @Override // org.apache.commons.net.g
    protected void b() throws IOException {
        h0(null);
    }

    protected void c0() throws IOException {
        b0(false);
    }

    public int c1(String str) throws IOException {
        return d1(str, null);
    }

    public int e1(FTPCmd fTPCmd) throws IOException {
        return f1(fTPCmd, null);
    }

    private String Z(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str2 != null) {
            sb.append(' ');
            sb.append(str2);
        }
        sb.append(org.apache.commons.net.g.f50795q);
        return sb.toString();
    }

    private void f0(String str) throws IOException, FTPConnectionClosedException, SocketException {
        try {
            this.D.write(str);
            this.D.flush();
        } catch (SocketException e6) {
            if (!J()) {
                throw new FTPConnectionClosedException("Connection unexpectedly closed.");
            }
            throw e6;
        }
    }

    public boolean A0() {
        return this.A;
    }

    public boolean B0() {
        return this.B;
    }

    public int C0() throws IOException {
        return e1(FTPCmd.LIST);
    }

    public int D0(String str) throws IOException {
        return f1(FTPCmd.LIST, str);
    }

    public int E0(String str) throws IOException {
        return f1(FTPCmd.MDTM, str);
    }

    public int F0(String str, String str2) throws IOException {
        return f1(FTPCmd.MFMT, str2 + " " + str);
    }

    public int G0(String str) throws IOException {
        return f1(FTPCmd.MKD, str);
    }

    public int H0() throws IOException {
        return e1(FTPCmd.MLSD);
    }

    public int I0(String str) throws IOException {
        return f1(FTPCmd.MLSD, str);
    }

    public int J0() throws IOException {
        return e1(FTPCmd.MLST);
    }

    public int K0(String str) throws IOException {
        return f1(FTPCmd.MLST, str);
    }

    public int L0(int i6) throws IOException {
        return f1(FTPCmd.MODE, V.substring(i6, i6 + 1));
    }

    public int M0() throws IOException {
        return e1(FTPCmd.NLST);
    }

    public int N0(String str) throws IOException {
        return f1(FTPCmd.NLST, str);
    }

    public int O0() throws IOException {
        return e1(FTPCmd.NOOP);
    }

    public int P0(String str) throws IOException {
        return f1(FTPCmd.PASS, str);
    }

    public int Q0() throws IOException {
        return e1(FTPCmd.PASV);
    }

    public int R0(InetAddress inetAddress, int i6) throws IOException {
        StringBuilder sb = new StringBuilder(24);
        sb.append(inetAddress.getHostAddress().replace('.', StringUtil.COMMA));
        sb.append(StringUtil.COMMA);
        sb.append(i6 >>> 8);
        sb.append(StringUtil.COMMA);
        sb.append(i6 & 255);
        return f1(FTPCmd.PORT, sb.toString());
    }

    public int S0() throws IOException {
        return e1(FTPCmd.PWD);
    }

    public int T0() throws IOException {
        return e1(FTPCmd.QUIT);
    }

    public int U0() throws IOException {
        return e1(FTPCmd.REIN);
    }

    public int V0(String str) throws IOException {
        return f1(FTPCmd.REST, str);
    }

    public int W0(String str) throws IOException {
        return f1(FTPCmd.RETR, str);
    }

    public int X0(String str) throws IOException {
        return f1(FTPCmd.RMD, str);
    }

    public int Y0(String str) throws IOException {
        return f1(FTPCmd.RNFR, str);
    }

    public int Z0(String str) throws IOException {
        return f1(FTPCmd.RNTO, str);
    }

    public int d1(String str, String str2) throws IOException {
        if (this.D == null) {
            throw new IOException("Connection is not open");
        }
        String Z = Z(str, str2);
        f0(Z);
        o(str, Z);
        a0();
        return this.f50558u;
    }

    protected void e0() throws IOException {
        f0(Z(FTPCmd.NOOP.getCommand(), null));
        c0();
    }

    public void g1(String str) {
        this.f50562y = str;
    }

    public void h1(boolean z5) {
        this.A = z5;
    }

    public int i0() throws IOException {
        return e1(FTPCmd.ABOR);
    }

    public void i1(boolean z5) {
        this.B = z5;
    }

    public int j0(String str) throws IOException {
        return f1(FTPCmd.ACCT, str);
    }

    public int j1(String str) throws IOException {
        return f1(FTPCmd.SITE, str);
    }

    public int k0(int i6) throws IOException {
        return f1(FTPCmd.ALLO, Integer.toString(i6));
    }

    public int k1(String str) throws IOException {
        return f1(FTPCmd.SMNT, str);
    }

    public int l0(int i6, int i7) throws IOException {
        return f1(FTPCmd.ALLO, Integer.toString(i6) + " R " + Integer.toString(i7));
    }

    public int l1() throws IOException {
        return e1(FTPCmd.STAT);
    }

    public int m0(String str) throws IOException {
        return f1(FTPCmd.APPE, str);
    }

    public int m1(String str) throws IOException {
        return f1(FTPCmd.STAT, str);
    }

    public int n0() throws IOException {
        return e1(FTPCmd.CDUP);
    }

    public int n1(String str) throws IOException {
        return f1(FTPCmd.STOR, str);
    }

    public int o0(String str) throws IOException {
        return f1(FTPCmd.CWD, str);
    }

    public int o1() throws IOException {
        return e1(FTPCmd.STOU);
    }

    public int p0(String str) throws IOException {
        return f1(FTPCmd.DELE, str);
    }

    public int p1(String str) throws IOException {
        return f1(FTPCmd.STOU, str);
    }

    public int q0(InetAddress inetAddress, int i6) throws IOException {
        StringBuilder sb = new StringBuilder();
        String hostAddress = inetAddress.getHostAddress();
        int indexOf = hostAddress.indexOf("%");
        if (indexOf > 0) {
            hostAddress = hostAddress.substring(0, indexOf);
        }
        sb.append(Logger.f33116c);
        if (inetAddress instanceof Inet4Address) {
            sb.append("1");
        } else if (inetAddress instanceof Inet6Address) {
            sb.append("2");
        }
        sb.append(Logger.f33116c);
        sb.append(hostAddress);
        sb.append(Logger.f33116c);
        sb.append(i6);
        sb.append(Logger.f33116c);
        return f1(FTPCmd.EPRT, sb.toString());
    }

    public int q1(int i6) throws IOException {
        return f1(FTPCmd.STRU, V.substring(i6, i6 + 1));
    }

    public int r0() throws IOException {
        return e1(FTPCmd.EPSV);
    }

    public int r1() throws IOException {
        return e1(FTPCmd.SYST);
    }

    @Override // org.apache.commons.net.g
    protected ProtocolCommandSupport s() {
        return this.f50563z;
    }

    public int s0() throws IOException {
        return e1(FTPCmd.FEAT);
    }

    public int s1(int i6) throws IOException {
        return f1(FTPCmd.TYPE, V.substring(i6, i6 + 1));
    }

    public String t0() {
        return this.f50562y;
    }

    public int t1(int i6, int i7) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(V.charAt(i6));
        sb.append(' ');
        if (i6 == 3) {
            sb.append(i7);
        } else {
            sb.append(V.charAt(i7));
        }
        return f1(FTPCmd.TYPE, sb.toString());
    }

    public int u1(String str) throws IOException {
        return f1(FTPCmd.USER, str);
    }

    public int v0() {
        return this.f50558u;
    }

    public String w0() {
        if (!this.f50560w) {
            return this.f50561x;
        }
        StringBuilder sb = new StringBuilder(256);
        Iterator<String> it = this.f50559v.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(org.apache.commons.net.g.f50795q);
        }
        this.f50560w = false;
        String sb2 = sb.toString();
        this.f50561x = sb2;
        return sb2;
    }

    public String[] x0() {
        ArrayList<String> arrayList = this.f50559v;
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public int y0() throws IOException {
        return e1(FTPCmd.HELP);
    }

    public int z0(String str) throws IOException {
        return f1(FTPCmd.HELP, str);
    }

    public b() {
        N(21);
        this.f50559v = new ArrayList<>();
        this.f50560w = false;
        this.f50561x = null;
        this.f50562y = T;
        this.f50563z = new ProtocolCommandSupport(this);
    }

    private boolean d0(String str) {
        if (str.length() > 3 && str.charAt(3) != '-' && Character.isDigit(str.charAt(0))) {
            return false;
        }
        return true;
    }

    private boolean g0(String str, String str2) {
        if (str.startsWith(str2) && str.charAt(3) == ' ') {
            return false;
        }
        return true;
    }

    @Deprecated
    public int b1(int i6, String str) throws IOException {
        return d1(e.b(i6), str);
    }

    public int f1(FTPCmd fTPCmd, String str) throws IOException {
        return d1(fTPCmd.getCommand(), str);
    }

    protected void h0(Reader reader) throws IOException {
        super.b();
        if (reader == null) {
            this.C = new org.apache.commons.net.io.a(new InputStreamReader(this.f50804h, t0()));
        } else {
            this.C = new org.apache.commons.net.io.a(reader);
        }
        this.D = new BufferedWriter(new OutputStreamWriter(this.f50805i, t0()));
        if (this.f50808l > 0) {
            int soTimeout = this.f50801e.getSoTimeout();
            this.f50801e.setSoTimeout(this.f50808l);
            try {
                try {
                    a0();
                    if (l.e(this.f50558u)) {
                        a0();
                    }
                    return;
                } catch (SocketTimeoutException e6) {
                    IOException iOException = new IOException("Timed out waiting for initial connect reply");
                    iOException.initCause(e6);
                    throw iOException;
                }
            } finally {
                this.f50801e.setSoTimeout(soTimeout);
            }
        }
        a0();
        if (l.e(this.f50558u)) {
            a0();
        }
    }

    @Override // org.apache.commons.net.g
    public void n() throws IOException {
        super.n();
        this.C = null;
        this.D = null;
        this.f50560w = false;
        this.f50561x = null;
    }

    public int u0() throws IOException {
        a0();
        return this.f50558u;
    }
}
