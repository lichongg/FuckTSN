package org.apache.commons.net.ftp;

import io.netty.util.internal.StringUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.net.MalformedServerReplyException;
import org.apache.commons.net.io.CopyStreamEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c extends org.apache.commons.net.ftp.b implements org.apache.commons.net.ftp.a {
    public static final String C0 = "org.apache.commons.net.ftp.systemType";
    public static final String D0 = "org.apache.commons.net.ftp.systemType.default";
    public static final String E0 = "/systemType.properties";
    public static final int F0 = 0;
    public static final int G0 = 1;
    public static final int H0 = 2;
    public static final int I0 = 3;
    private static final Pattern J0 = Pattern.compile("(\\d{1,3},\\d{1,3},\\d{1,3},\\d{1,3}),(\\d{1,3}),(\\d{1,3})");
    private HashMap<String, Set<String>> B0;
    private int W;
    private int X;
    private int Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private final Random f50564a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f50565b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f50566c0;

    /* renamed from: d0, reason: collision with root package name */
    private InetAddress f50567d0;

    /* renamed from: e0, reason: collision with root package name */
    private InetAddress f50568e0;

    /* renamed from: f0, reason: collision with root package name */
    private InetAddress f50569f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f50570g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f50571h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f50572i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f50573j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f50574k0;

    /* renamed from: l0, reason: collision with root package name */
    private long f50575l0;

    /* renamed from: m0, reason: collision with root package name */
    private org.apache.commons.net.ftp.parser.e f50576m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f50577n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f50578o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f50579p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f50580q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f50581r0;

    /* renamed from: s0, reason: collision with root package name */
    private String f50582s0;

    /* renamed from: t0, reason: collision with root package name */
    private f f50583t0;

    /* renamed from: u0, reason: collision with root package name */
    private String f50584u0;

    /* renamed from: v0, reason: collision with root package name */
    private org.apache.commons.net.ftp.d f50585v0;

    /* renamed from: w0, reason: collision with root package name */
    private org.apache.commons.net.io.c f50586w0;

    /* renamed from: x0, reason: collision with root package name */
    private long f50587x0;

    /* renamed from: y0, reason: collision with root package name */
    private int f50588y0 = 1000;

    /* renamed from: z0, reason: collision with root package name */
    private b f50589z0 = new C0980c(this);
    private boolean A0 = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a implements org.apache.commons.net.io.c {

        /* renamed from: a, reason: collision with root package name */
        private final c f50590a;

        /* renamed from: b, reason: collision with root package name */
        private final long f50591b;

        /* renamed from: c, reason: collision with root package name */
        private final int f50592c;

        /* renamed from: d, reason: collision with root package name */
        private long f50593d = System.currentTimeMillis();

        /* renamed from: e, reason: collision with root package name */
        private int f50594e;

        void e() throws IOException {
            while (true) {
                try {
                    int i6 = this.f50594e;
                    this.f50594e = i6 - 1;
                    if (i6 <= 0) {
                        return;
                    } else {
                        this.f50590a.c0();
                    }
                } finally {
                    this.f50590a.V(this.f50592c);
                }
            }
        }

        a(c cVar, long j6, int i6) throws SocketException {
            this.f50591b = j6;
            this.f50590a = cVar;
            this.f50592c = cVar.G();
            cVar.V(i6);
        }

        @Override // org.apache.commons.net.io.c
        public void a(CopyStreamEvent copyStreamEvent) {
            c(copyStreamEvent.getTotalBytesTransferred(), copyStreamEvent.getBytesTransferred(), copyStreamEvent.getStreamSize());
        }

        @Override // org.apache.commons.net.io.c
        public void c(long j6, int i6, long j7) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f50593d > this.f50591b) {
                try {
                    this.f50590a.e0();
                } catch (SocketTimeoutException unused) {
                    this.f50594e++;
                } catch (IOException unused2) {
                }
                this.f50593d = currentTimeMillis;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        String resolve(String str) throws UnknownHostException;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d {

        /* renamed from: a, reason: collision with root package name */
        static final Properties f50596a;

        static {
            Properties properties;
            InputStream resourceAsStream = c.class.getResourceAsStream(c.E0);
            if (resourceAsStream != null) {
                properties = new Properties();
                try {
                    properties.load(resourceAsStream);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    try {
                        resourceAsStream.close();
                    } catch (IOException unused2) {
                    }
                    throw th;
                }
                try {
                    resourceAsStream.close();
                } catch (IOException unused3) {
                }
            } else {
                properties = null;
            }
            f50596a = properties;
        }

        private d() {
        }
    }

    private void w1() {
        this.W = 0;
        this.Z = null;
        this.Y = -1;
        this.f50567d0 = null;
        this.f50568e0 = null;
        this.f50565b0 = 0;
        this.f50566c0 = 0;
        this.f50570g0 = 0;
        this.f50572i0 = 7;
        this.f50571h0 = 4;
        this.f50573j0 = 10;
        this.f50575l0 = 0L;
        this.f50582s0 = null;
        this.f50583t0 = null;
        this.f50584u0 = "";
        this.B0 = null;
    }

    static String y1(String str) {
        String substring = str.substring(4);
        if (!substring.startsWith("\"")) {
            return substring;
        }
        StringBuilder sb = new StringBuilder();
        boolean z5 = false;
        for (int i6 = 1; i6 < substring.length(); i6++) {
            char charAt = substring.charAt(i6);
            if (charAt != '\"') {
                if (z5) {
                    return sb.toString();
                }
                sb.append(charAt);
            } else if (z5) {
                sb.append(charAt);
                z5 = false;
            } else {
                z5 = true;
            }
        }
        return z5 ? sb.toString() : substring;
    }

    public k F2() throws IOException {
        return G2(null);
    }

    public k G2(String str) throws IOException {
        return H2(null, str);
    }

    public FTPFile[] M2() throws IOException {
        return N2(null);
    }

    public FTPFile[] O2() throws IOException {
        return P2(null);
    }

    public FTPFile[] P2(String str) throws IOException {
        return H2(null, str).a();
    }

    public FTPFile[] Q2(String str, h hVar) throws IOException {
        return H2(null, str).b(hVar);
    }

    public String[] T2() throws IOException {
        return U2(null);
    }

    public void V1() {
        this.W = 0;
        this.Z = null;
        this.Y = -1;
    }

    public void W1() {
        this.W = 2;
        this.Z = null;
        this.Y = -1;
    }

    public FTPFile[] a3() throws IOException {
        return b3(null);
    }

    @Override // org.apache.commons.net.ftp.b, org.apache.commons.net.g
    protected void b() throws IOException {
        h0(null);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: org.apache.commons.net.ftp.c$c, reason: collision with other inner class name */
    public static class C0980c implements b {

        /* renamed from: a, reason: collision with root package name */
        private c f50595a;

        public C0980c(c cVar) {
            this.f50595a = cVar;
        }

        @Override // org.apache.commons.net.ftp.c.b
        public String resolve(String str) throws UnknownHostException {
            if (InetAddress.getByName(str).isSiteLocalAddress()) {
                InetAddress B = this.f50595a.B();
                if (!B.isSiteLocalAddress()) {
                    return B.getHostAddress();
                }
                return str;
            }
            return str;
        }
    }

    private boolean E2() throws IOException {
        String substring;
        String str;
        if (this.B0 == null) {
            int s02 = s0();
            if (s02 == 530) {
                return false;
            }
            boolean c6 = l.c(s02);
            this.B0 = new HashMap<>();
            if (!c6) {
                return false;
            }
            for (String str2 : x0()) {
                if (str2.startsWith(" ")) {
                    int indexOf = str2.indexOf(32, 1);
                    if (indexOf > 0) {
                        substring = str2.substring(1, indexOf);
                        str = str2.substring(indexOf + 1);
                    } else {
                        substring = str2.substring(1);
                        str = "";
                    }
                    String upperCase = substring.toUpperCase(Locale.ENGLISH);
                    Set<String> set = this.B0.get(upperCase);
                    if (set == null) {
                        set = new HashSet<>();
                        this.B0.put(upperCase, set);
                    }
                    set.add(str);
                }
            }
        }
        return true;
    }

    private k I2(f fVar, String str) throws IOException {
        Socket D1 = D1(FTPCmd.LIST, n2(str));
        k kVar = new k(fVar, this.f50585v0);
        if (D1 == null) {
            return kVar;
        }
        try {
            kVar.h(D1.getInputStream(), t0());
            org.apache.commons.net.io.l.b(D1);
            R1();
            return kVar;
        } catch (Throwable th) {
            org.apache.commons.net.io.l.b(D1);
            throw th;
        }
    }

    private k J2(String str) throws IOException {
        Socket D1 = D1(FTPCmd.MLSD, str);
        k kVar = new k(org.apache.commons.net.ftp.parser.h.f(), this.f50585v0);
        if (D1 == null) {
            return kVar;
        }
        try {
            kVar.h(D1.getInputStream(), t0());
            return kVar;
        } finally {
            org.apache.commons.net.io.l.b(D1);
            R1();
        }
    }

    private int c2() {
        int i6;
        int i7 = this.f50565b0;
        if (i7 <= 0 || (i6 = this.f50566c0) < i7) {
            return 0;
        }
        return i6 == i7 ? i6 : this.f50564a0.nextInt((i6 - i7) + 1) + this.f50565b0;
    }

    private InputStream f2(InputStream inputStream) {
        return this.f50577n0 > 0 ? new BufferedInputStream(inputStream, this.f50577n0) : new BufferedInputStream(inputStream);
    }

    private OutputStream g2(OutputStream outputStream) {
        return this.f50577n0 > 0 ? new BufferedOutputStream(outputStream, this.f50577n0) : new BufferedOutputStream(outputStream);
    }

    private InetAddress m2() {
        InetAddress inetAddress = this.f50567d0;
        return inetAddress != null ? inetAddress : x();
    }

    private static Properties q2() {
        return d.f50596a;
    }

    private InetAddress v2() {
        InetAddress inetAddress = this.f50568e0;
        return inetAddress != null ? inetAddress : m2();
    }

    private org.apache.commons.net.io.c x1(org.apache.commons.net.io.c cVar) {
        if (cVar == null) {
            return this.f50586w0;
        }
        if (this.f50586w0 == null) {
            return cVar;
        }
        org.apache.commons.net.io.b bVar = new org.apache.commons.net.io.b();
        bVar.e(cVar);
        bVar.e(this.f50586w0);
        return bVar;
    }

    @Deprecated
    public String A2() throws IOException {
        if (this.f50582s0 == null && l.c(r1())) {
            this.f50582s0 = this.f50559v.get(r0.size() - 1).substring(4);
        }
        return this.f50582s0;
    }

    public String B2() throws IOException {
        if (this.f50582s0 == null) {
            if (l.c(r1())) {
                this.f50582s0 = this.f50559v.get(r0.size() - 1).substring(4);
            } else {
                String property = System.getProperty(D0);
                if (property == null) {
                    throw new IOException("Unable to determine system type - response: " + w0());
                }
                this.f50582s0 = property;
            }
        }
        return this.f50582s0;
    }

    protected Socket C1(String str, String str2) throws IOException {
        Socket socket;
        int i6 = this.W;
        if (i6 != 0 && i6 != 2) {
            return null;
        }
        boolean z5 = B() instanceof Inet6Address;
        if (this.W == 0) {
            ServerSocket createServerSocket = this.f50807k.createServerSocket(c2(), 1, m2());
            try {
                if (z5) {
                    if (!l.c(q0(v2(), createServerSocket.getLocalPort()))) {
                        return null;
                    }
                } else if (!l.c(R0(v2(), createServerSocket.getLocalPort()))) {
                    return null;
                }
                long j6 = this.f50575l0;
                if (j6 > 0 && !n3(j6)) {
                    return null;
                }
                if (!l.e(d1(str, str2))) {
                    return null;
                }
                int i7 = this.X;
                if (i7 >= 0) {
                    createServerSocket.setSoTimeout(i7);
                }
                socket = createServerSocket.accept();
                int i8 = this.X;
                if (i8 >= 0) {
                    socket.setSoTimeout(i8);
                }
                int i9 = this.f50579p0;
                if (i9 > 0) {
                    socket.setReceiveBufferSize(i9);
                }
                int i10 = this.f50578o0;
                if (i10 > 0) {
                    socket.setSendBufferSize(i10);
                }
            } finally {
                createServerSocket.close();
            }
        } else {
            if ((L2() || z5) && r0() == 229) {
                E1(this.f50559v.get(0));
            } else {
                if (z5 || Q0() != 227) {
                    return null;
                }
                F1(this.f50559v.get(0));
            }
            Socket createSocket = this.f50806j.createSocket();
            int i11 = this.f50579p0;
            if (i11 > 0) {
                createSocket.setReceiveBufferSize(i11);
            }
            int i12 = this.f50578o0;
            if (i12 > 0) {
                createSocket.setSendBufferSize(i12);
            }
            if (this.f50569f0 != null) {
                createSocket.bind(new InetSocketAddress(this.f50569f0, 0));
            }
            int i13 = this.X;
            if (i13 >= 0) {
                createSocket.setSoTimeout(i13);
            }
            createSocket.connect(new InetSocketAddress(this.Z, this.Y), this.f50808l);
            long j7 = this.f50575l0;
            if (j7 > 0 && !n3(j7)) {
                createSocket.close();
                return null;
            }
            if (!l.e(d1(str, str2))) {
                createSocket.close();
                return null;
            }
            socket = createSocket;
        }
        if (!this.f50574k0 || Y(socket)) {
            return socket;
        }
        socket.close();
        throw new IOException("Host attempting data connection " + socket.getInetAddress().getHostAddress() + " is not same as server " + B().getHostAddress());
    }

    protected void E1(String str) throws MalformedServerReplyException {
        String trim = str.substring(str.indexOf(40) + 1, str.indexOf(41)).trim();
        char charAt = trim.charAt(0);
        char charAt2 = trim.charAt(1);
        char charAt3 = trim.charAt(2);
        char charAt4 = trim.charAt(trim.length() - 1);
        if (charAt != charAt2 || charAt2 != charAt3 || charAt3 != charAt4) {
            throw new MalformedServerReplyException("Could not parse extended passive host information.\nServer Reply: " + trim);
        }
        try {
            int parseInt = Integer.parseInt(trim.substring(3, trim.length() - 1));
            this.Z = B().getHostAddress();
            this.Y = parseInt;
        } catch (NumberFormatException unused) {
            throw new MalformedServerReplyException("Could not parse extended passive host information.\nServer Reply: " + trim);
        }
    }

    public void E3(boolean z5) {
        this.f50580q0 = z5;
    }

    protected void F1(String str) throws MalformedServerReplyException {
        Matcher matcher = J0.matcher(str);
        if (!matcher.find()) {
            throw new MalformedServerReplyException("Could not parse passive host information.\nServer Reply: " + str);
        }
        this.Z = matcher.group(1).replace(StringUtil.COMMA, '.');
        try {
            this.Y = Integer.parseInt(matcher.group(3)) | (Integer.parseInt(matcher.group(2)) << 8);
            b bVar = this.f50589z0;
            if (bVar != null) {
                try {
                    String resolve = bVar.resolve(this.Z);
                    if (this.Z.equals(resolve)) {
                        return;
                    }
                    p(0, "[Replacing PASV mode reply address " + this.Z + " with " + resolve + "]\n");
                    this.Z = resolve;
                } catch (UnknownHostException unused) {
                    throw new MalformedServerReplyException("Could not parse passive host information.\nServer Reply: " + str);
                }
            }
        } catch (NumberFormatException unused2) {
            throw new MalformedServerReplyException("Could not parse passive port information.\nServer Reply: " + str);
        }
    }

    public void G3(org.apache.commons.net.ftp.parser.e eVar) {
        this.f50576m0 = eVar;
    }

    public void I3(InetAddress inetAddress) {
        this.f50569f0 = inetAddress;
    }

    @Deprecated
    public void J3(boolean z5) {
        if (z5) {
            this.f50589z0 = new C0980c(this);
        } else {
            this.f50589z0 = null;
        }
    }

    public boolean K2() {
        return this.f50574k0;
    }

    public void K3(b bVar) {
        this.f50589z0 = bVar;
    }

    public boolean L2() {
        return this.f50581r0;
    }

    public void L3(int i6) {
        this.f50579p0 = i6;
    }

    public void M3(boolean z5) {
        this.f50574k0 = z5;
    }

    public boolean N1(String str, InputStream inputStream) throws IOException {
        return z1(FTPCmd.APPE, str, inputStream);
    }

    public FTPFile[] N2(String str) throws IOException {
        return Q2(str, i.f50669c);
    }

    public OutputStream O1(String str) throws IOException {
        return A1(FTPCmd.APPE, str);
    }

    public void O3(long j6) {
        if (j6 >= 0) {
            this.f50575l0 = j6;
        }
    }

    public void P3(int i6) {
        this.f50578o0 = i6;
    }

    public void Q3(boolean z5) {
        this.f50581r0 = z5;
    }

    public boolean R3(String str, InputStream inputStream) throws IOException {
        return z1(FTPCmd.STOR, str, inputStream);
    }

    public OutputStream S3(String str) throws IOException {
        return A1(FTPCmd.STOR, str);
    }

    public boolean T3(InputStream inputStream) throws IOException {
        return z1(FTPCmd.STOU, null, inputStream);
    }

    public String[] U2(String str) throws IOException {
        Socket D1 = D1(FTPCmd.NLST, n2(str));
        if (D1 == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(D1.getInputStream(), t0()));
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            arrayList.add(readLine);
        }
        bufferedReader.close();
        D1.close();
        if (R1()) {
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return null;
    }

    public boolean U3(String str, InputStream inputStream) throws IOException {
        return z1(FTPCmd.STOU, str, inputStream);
    }

    public OutputStream V3() throws IOException {
        return A1(FTPCmd.STOU, null);
    }

    public OutputStream W3(String str) throws IOException {
        return A1(FTPCmd.STOU, str);
    }

    @Override // org.apache.commons.net.ftp.a
    public void c(org.apache.commons.net.ftp.d dVar) {
        this.f50585v0 = dVar;
    }

    public boolean d2() {
        return this.A0;
    }

    public FTPFile d3(String str) throws IOException {
        if (!l.c(f1(FTPCmd.MLST, str))) {
            return null;
        }
        String str2 = x0()[1];
        if (str2.length() >= 3 && str2.charAt(0) == ' ') {
            return org.apache.commons.net.ftp.parser.h.g(str2.substring(1));
        }
        throw new MalformedServerReplyException("Invalid server reply (MLST): '" + str2 + "'");
    }

    public int e2() {
        return this.f50577n0;
    }

    public boolean g3(String str) throws IOException {
        int i6 = this.W;
        if (i6 == 1 || i6 == 3) {
            return l.e(m0(str));
        }
        return false;
    }

    public int h2() {
        return this.f50588y0;
    }

    public boolean h3(String str) throws IOException {
        int i6 = this.W;
        if (i6 == 1 || i6 == 3) {
            return l.e(W0(str));
        }
        return false;
    }

    public long i2() {
        return this.f50587x0 / 1000;
    }

    public boolean i3(String str) throws IOException {
        int i6 = this.W;
        if (i6 == 1 || i6 == 3) {
            return l.e(n1(str));
        }
        return false;
    }

    public org.apache.commons.net.io.c j2() {
        return this.f50586w0;
    }

    public boolean j3() throws IOException {
        int i6 = this.W;
        if (i6 == 1 || i6 == 3) {
            return l.e(o1());
        }
        return false;
    }

    public int k2() {
        return this.W;
    }

    public boolean k3(String str) throws IOException {
        int i6 = this.W;
        if (i6 == 1 || i6 == 3) {
            return l.e(p1(str));
        }
        return false;
    }

    f l2() {
        return this.f50583t0;
    }

    protected boolean n3(long j6) throws IOException {
        this.f50575l0 = 0L;
        return l.d(V0(Long.toString(j6)));
    }

    public boolean o2() {
        return this.f50580q0;
    }

    public boolean o3(String str, OutputStream outputStream) throws IOException {
        return G1(FTPCmd.RETR.getCommand(), str, outputStream);
    }

    public InputStream p3(String str) throws IOException {
        return H1(FTPCmd.RETR.getCommand(), str);
    }

    public String r2() {
        return this.Z;
    }

    public InetAddress s2() {
        return this.f50569f0;
    }

    public int t2() {
        return this.Y;
    }

    public void t3(int i6, int i7) {
        this.f50565b0 = i6;
        this.f50566c0 = i7;
    }

    public int u2() {
        return this.f50579p0;
    }

    public void u3(boolean z5) {
        this.A0 = z5;
    }

    void v1(String str) throws IOException {
        String property;
        if (this.f50583t0 == null || !(str == null || this.f50584u0.equals(str))) {
            if (str != null) {
                this.f50583t0 = this.f50576m0.a(str);
                this.f50584u0 = str;
                return;
            }
            org.apache.commons.net.ftp.d dVar = this.f50585v0;
            if (dVar != null && dVar.e().length() > 0) {
                this.f50583t0 = this.f50576m0.b(this.f50585v0);
                this.f50584u0 = this.f50585v0.e();
                return;
            }
            String property2 = System.getProperty(C0);
            if (property2 == null) {
                property2 = B2();
                Properties q22 = q2();
                if (q22 != null && (property = q22.getProperty(property2)) != null) {
                    property2 = property;
                }
            }
            if (this.f50585v0 != null) {
                this.f50583t0 = this.f50576m0.b(new org.apache.commons.net.ftp.d(property2, this.f50585v0));
            } else {
                this.f50583t0 = this.f50576m0.a(property2);
            }
            this.f50584u0 = property2;
        }
    }

    public void v3(int i6) {
        this.f50577n0 = i6;
    }

    public long w2() {
        return this.f50575l0;
    }

    public void w3(int i6) {
        this.f50588y0 = i6;
    }

    public int x2() {
        return this.f50578o0;
    }

    public void x3(long j6) {
        this.f50587x0 = j6 * 1000;
    }

    public void y3(org.apache.commons.net.io.c cVar) {
        this.f50586w0 = cVar;
    }

    public void z3(int i6) {
        this.X = i6;
    }

    public c() {
        w1();
        this.X = -1;
        this.f50574k0 = true;
        this.f50576m0 = new org.apache.commons.net.ftp.parser.c();
        this.f50585v0 = null;
        this.f50580q0 = false;
        this.f50581r0 = false;
        this.f50564a0 = new Random();
        this.f50569f0 = null;
    }

    private OutputStream A1(FTPCmd fTPCmd, String str) throws IOException {
        return J1(fTPCmd.getCommand(), str);
    }

    private boolean z1(FTPCmd fTPCmd, String str, InputStream inputStream) throws IOException {
        return I1(fTPCmd.getCommand(), str, inputStream);
    }

    public boolean A3(int i6) throws IOException {
        if (l.c(q1(i6))) {
            this.f50572i0 = i6;
            return true;
        }
        return false;
    }

    @Deprecated
    protected Socket B1(int i6, String str) throws IOException {
        return C1(e.b(i6), str);
    }

    public boolean B3(int i6) throws IOException {
        if (l.c(L0(i6))) {
            this.f50573j0 = i6;
            return true;
        }
        return false;
    }

    public boolean C2(String str) throws IOException {
        if (!E2()) {
            return false;
        }
        return this.B0.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    public boolean C3(int i6) throws IOException {
        if (l.c(s1(i6))) {
            this.f50570g0 = i6;
            this.f50571h0 = 4;
            return true;
        }
        return false;
    }

    protected Socket D1(FTPCmd fTPCmd, String str) throws IOException {
        return C1(fTPCmd.getCommand(), str);
    }

    public boolean D2(String str, String str2) throws IOException {
        Set<String> set;
        if (!E2() || (set = this.B0.get(str.toUpperCase(Locale.ENGLISH))) == null) {
            return false;
        }
        return set.contains(str2);
    }

    public boolean D3(int i6, int i7) throws IOException {
        if (l.c(t1(i6, i7))) {
            this.f50570g0 = i6;
            this.f50571h0 = i7;
            return true;
        }
        return false;
    }

    public boolean F3(String str, String str2) throws IOException {
        return l.c(F0(str, str2));
    }

    protected boolean G1(String str, String str2, OutputStream outputStream) throws IOException {
        InputStream f22;
        a aVar;
        Socket C1 = C1(str, str2);
        if (C1 == null) {
            return false;
        }
        if (this.f50570g0 == 0) {
            f22 = new org.apache.commons.net.io.f(f2(C1.getInputStream()));
        } else {
            f22 = f2(C1.getInputStream());
        }
        InputStream inputStream = f22;
        long j6 = this.f50587x0;
        if (j6 > 0) {
            aVar = new a(this, j6, this.f50588y0);
        } else {
            aVar = null;
        }
        try {
            org.apache.commons.net.io.l.i(inputStream, outputStream, e2(), -1L, x1(aVar), false);
            org.apache.commons.net.io.l.a(inputStream);
            org.apache.commons.net.io.l.b(C1);
            if (aVar != null) {
                aVar.e();
            }
            return R1();
        } finally {
        }
    }

    protected InputStream H1(String str, String str2) throws IOException {
        InputStream inputStream;
        Socket C1 = C1(str, str2);
        if (C1 == null) {
            return null;
        }
        if (this.f50570g0 == 0) {
            inputStream = new org.apache.commons.net.io.f(f2(C1.getInputStream()));
        } else {
            inputStream = C1.getInputStream();
        }
        return new org.apache.commons.net.io.h(C1, inputStream);
    }

    public k H2(String str, String str2) throws IOException {
        v1(str);
        return I2(this.f50583t0, str2);
    }

    public void H3(String str) throws UnknownHostException {
        this.f50569f0 = InetAddress.getByName(str);
    }

    protected boolean I1(String str, String str2, InputStream inputStream) throws IOException {
        OutputStream g22;
        a aVar;
        Socket C1 = C1(str, str2);
        if (C1 == null) {
            return false;
        }
        if (this.f50570g0 == 0) {
            g22 = new org.apache.commons.net.io.k(g2(C1.getOutputStream()));
        } else {
            g22 = g2(C1.getOutputStream());
        }
        OutputStream outputStream = g22;
        long j6 = this.f50587x0;
        if (j6 > 0) {
            aVar = new a(this, j6, this.f50588y0);
        } else {
            aVar = null;
        }
        try {
            org.apache.commons.net.io.l.i(inputStream, outputStream, e2(), -1L, x1(aVar), false);
            outputStream.close();
            C1.close();
            if (aVar != null) {
                aVar.e();
            }
            return R1();
        } catch (IOException e6) {
            org.apache.commons.net.io.l.b(C1);
            if (aVar != null) {
                aVar.e();
                throw e6;
            }
            throw e6;
        }
    }

    protected OutputStream J1(String str, String str2) throws IOException {
        OutputStream outputStream;
        Socket C1 = C1(str, str2);
        if (C1 == null) {
            return null;
        }
        if (this.f50570g0 == 0) {
            outputStream = new org.apache.commons.net.io.k(g2(C1.getOutputStream()));
        } else {
            outputStream = C1.getOutputStream();
        }
        return new org.apache.commons.net.io.i(C1, outputStream);
    }

    public boolean K1() throws IOException {
        return l.c(i0());
    }

    public boolean L1(int i6) throws IOException {
        return l.c(k0(i6));
    }

    public boolean M1(int i6, int i7) throws IOException {
        return l.c(l0(i6, i7));
    }

    public void N3(String str) throws UnknownHostException {
        this.f50568e0 = InetAddress.getByName(str);
    }

    public boolean P1() throws IOException {
        return l.c(n0());
    }

    public boolean Q1(String str) throws IOException {
        return l.c(o0(str));
    }

    public boolean R1() throws IOException {
        return l.c(u0());
    }

    public String R2() throws IOException {
        if (l.c(y0())) {
            return w0();
        }
        return null;
    }

    public boolean S1(String str) throws IOException {
        return l.c(p0(str));
    }

    public String S2(String str) throws IOException {
        if (l.c(z0(str))) {
            return w0();
        }
        return null;
    }

    public boolean T1(String str, String str2) throws IOException {
        return l.c(d1(str, str2));
    }

    public String[] U1(String str, String str2) throws IOException {
        if (l.c(d1(str, str2))) {
            return x0();
        }
        return null;
    }

    public boolean V2(String str, String str2) throws IOException {
        u1(str);
        if (l.c(this.f50558u)) {
            return true;
        }
        if (!l.d(this.f50558u)) {
            return false;
        }
        return l.c(P0(str2));
    }

    public boolean W2(String str, String str2, String str3) throws IOException {
        u1(str);
        if (l.c(this.f50558u)) {
            return true;
        }
        if (!l.d(this.f50558u)) {
            return false;
        }
        P0(str2);
        if (l.c(this.f50558u)) {
            return true;
        }
        if (!l.d(this.f50558u)) {
            return false;
        }
        return l.c(j0(str3));
    }

    public boolean X1(InetAddress inetAddress, int i6) throws IOException {
        if (l.c(R0(inetAddress, i6))) {
            this.W = 1;
            this.Z = null;
            this.Y = -1;
            return true;
        }
        return false;
    }

    public boolean X2() throws IOException {
        return l.c(T0());
    }

    public boolean X3(String str) throws IOException {
        return l.c(k1(str));
    }

    public boolean Y1() throws IOException {
        if (Q0() != 227) {
            return false;
        }
        this.W = 3;
        F1(this.f50559v.get(0));
        return true;
    }

    public boolean Y2(String str) throws IOException {
        return l.c(G0(str));
    }

    public String Z1(String str) throws IOException {
        String[] a22 = a2(str);
        if (a22 != null) {
            return a22[0];
        }
        return null;
    }

    public FTPFile Z2(String str) throws IOException {
        if (l.c(E0(str))) {
            String substring = x0()[0].substring(4);
            FTPFile fTPFile = new FTPFile();
            fTPFile.setName(str);
            fTPFile.setRawListing(substring);
            fTPFile.setTimestamp(org.apache.commons.net.ftp.parser.h.h(substring));
            return fTPFile;
        }
        return null;
    }

    public String[] a2(String str) throws IOException {
        Set<String> set;
        if (!E2() || (set = this.B0.get(str.toUpperCase(Locale.ENGLISH))) == null) {
            return null;
        }
        return (String[]) set.toArray(new String[set.size()]);
    }

    public boolean b2() throws IOException {
        return l.c(s0());
    }

    public FTPFile[] b3(String str) throws IOException {
        return J2(str).a();
    }

    public FTPFile[] c3(String str, h hVar) throws IOException {
        return J2(str).b(hVar);
    }

    public String e3() throws IOException {
        if (S0() != 257) {
            return null;
        }
        return y1(this.f50559v.get(r0.size() - 1));
    }

    public boolean f3() throws IOException {
        U0();
        if (!l.c(this.f50558u) && (!l.e(this.f50558u) || !l.c(u0()))) {
            return false;
        }
        w1();
        return true;
    }

    @Override // org.apache.commons.net.ftp.b
    protected void h0(Reader reader) throws IOException {
        super.h0(reader);
        w1();
        if (this.A0) {
            ArrayList arrayList = new ArrayList(this.f50559v);
            int i6 = this.f50558u;
            if (C2("UTF8") || C2("UTF-8")) {
                g1("UTF-8");
                this.C = new org.apache.commons.net.io.a(new InputStreamReader(this.f50804h, t0()));
                this.D = new BufferedWriter(new OutputStreamWriter(this.f50805i, t0()));
            }
            this.f50559v.clear();
            this.f50559v.addAll(arrayList);
            this.f50558u = i6;
            this.f50560w = true;
        }
    }

    public boolean l3(String str) throws IOException {
        return l.c(X0(str));
    }

    public boolean m3(String str, String str2) throws IOException {
        if (!l.d(Y0(str))) {
            return false;
        }
        return l.c(Z0(str2));
    }

    @Override // org.apache.commons.net.ftp.b, org.apache.commons.net.g
    public void n() throws IOException {
        super.n();
        w1();
    }

    protected String n2(String str) {
        if (o2()) {
            if (str != null) {
                StringBuilder sb = new StringBuilder(str.length() + 3);
                sb.append("-a ");
                sb.append(str);
                return sb.toString();
            }
            return "-a";
        }
        return str;
    }

    public String p2(String str) throws IOException {
        if (l.c(E0(str))) {
            return x0()[0].substring(4);
        }
        return null;
    }

    public boolean q3() throws IOException {
        return l.c(O0());
    }

    public boolean r3(String str) throws IOException {
        return l.c(j1(str));
    }

    public void s3(String str) throws UnknownHostException {
        this.f50567d0 = InetAddress.getByName(str);
    }

    public String y2() throws IOException {
        if (l.c(l1())) {
            return w0();
        }
        return null;
    }

    public String z2(String str) throws IOException {
        if (l.c(m1(str))) {
            return w0();
        }
        return null;
    }
}
