package org.apache.commons.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.Charset;
import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class g {

    /* renamed from: q, reason: collision with root package name */
    public static final String f50795q = "\r\n";

    /* renamed from: r, reason: collision with root package name */
    private static final SocketFactory f50796r = SocketFactory.getDefault();

    /* renamed from: s, reason: collision with root package name */
    private static final ServerSocketFactory f50797s = ServerSocketFactory.getDefault();

    /* renamed from: t, reason: collision with root package name */
    private static final int f50798t = 0;

    /* renamed from: c, reason: collision with root package name */
    private ProtocolCommandSupport f50799c;

    /* renamed from: o, reason: collision with root package name */
    private Proxy f50811o;

    /* renamed from: l, reason: collision with root package name */
    protected int f50808l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f50809m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f50810n = -1;

    /* renamed from: p, reason: collision with root package name */
    private Charset f50812p = Charset.defaultCharset();

    /* renamed from: e, reason: collision with root package name */
    protected Socket f50801e = null;

    /* renamed from: f, reason: collision with root package name */
    protected String f50802f = null;

    /* renamed from: h, reason: collision with root package name */
    protected InputStream f50804h = null;

    /* renamed from: i, reason: collision with root package name */
    protected OutputStream f50805i = null;

    /* renamed from: d, reason: collision with root package name */
    protected int f50800d = 0;

    /* renamed from: g, reason: collision with root package name */
    protected int f50803g = 0;

    /* renamed from: j, reason: collision with root package name */
    protected SocketFactory f50806j = f50796r;

    /* renamed from: k, reason: collision with root package name */
    protected ServerSocketFactory f50807k = f50797s;

    public void j(InetAddress inetAddress) throws SocketException, IOException {
        this.f50802f = null;
        k(inetAddress, this.f50803g);
    }

    public void k(InetAddress inetAddress, int i6) throws SocketException, IOException {
        this.f50802f = null;
        a(inetAddress, i6, null, -1);
    }

    public void l(InetAddress inetAddress, int i6, InetAddress inetAddress2, int i7) throws SocketException, IOException {
        this.f50802f = null;
        a(inetAddress, i6, inetAddress2, i7);
    }

    private void a(InetAddress inetAddress, int i6, InetAddress inetAddress2, int i7) throws SocketException, IOException {
        Socket createSocket = this.f50806j.createSocket();
        this.f50801e = createSocket;
        int i8 = this.f50809m;
        if (i8 != -1) {
            createSocket.setReceiveBufferSize(i8);
        }
        int i9 = this.f50810n;
        if (i9 != -1) {
            this.f50801e.setSendBufferSize(i9);
        }
        if (inetAddress2 != null) {
            this.f50801e.bind(new InetSocketAddress(inetAddress2, i7));
        }
        this.f50801e.connect(new InetSocketAddress(inetAddress, i6), this.f50808l);
        b();
    }

    private void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private void f(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
        }
    }

    protected int A() {
        return this.f50809m;
    }

    public InetAddress B() {
        return this.f50801e.getInetAddress();
    }

    public int C() {
        return this.f50801e.getPort();
    }

    protected int D() {
        return this.f50810n;
    }

    public ServerSocketFactory E() {
        return this.f50807k;
    }

    public int F() throws SocketException {
        return this.f50801e.getSoLinger();
    }

    public int G() throws SocketException {
        return this.f50801e.getSoTimeout();
    }

    public boolean H() throws SocketException {
        return this.f50801e.getTcpNoDelay();
    }

    public boolean J() {
        Socket socket = this.f50801e;
        if (socket == null) {
            return false;
        }
        return socket.isConnected();
    }

    public void L(Charset charset) {
        this.f50812p = charset;
    }

    public void M(int i6) {
        this.f50808l = i6;
    }

    public void N(int i6) {
        this.f50803g = i6;
    }

    public void O(int i6) {
        this.f50800d = i6;
    }

    public void P(boolean z5) throws SocketException {
        this.f50801e.setKeepAlive(z5);
    }

    public void Q(Proxy proxy) {
        W(new d(proxy));
        this.f50811o = proxy;
    }

    public void R(int i6) throws SocketException {
        this.f50809m = i6;
    }

    public void S(int i6) throws SocketException {
        this.f50810n = i6;
    }

    public void T(ServerSocketFactory serverSocketFactory) {
        if (serverSocketFactory == null) {
            this.f50807k = f50797s;
        } else {
            this.f50807k = serverSocketFactory;
        }
    }

    public void U(boolean z5, int i6) throws SocketException {
        this.f50801e.setSoLinger(z5, i6);
    }

    public void V(int i6) throws SocketException {
        this.f50801e.setSoTimeout(i6);
    }

    public void W(SocketFactory socketFactory) {
        if (socketFactory == null) {
            this.f50806j = f50796r;
        } else {
            this.f50806j = socketFactory;
        }
        this.f50811o = null;
    }

    public void X(boolean z5) throws SocketException {
        this.f50801e.setTcpNoDelay(z5);
    }

    protected void b() throws IOException {
        this.f50801e.setSoTimeout(this.f50800d);
        this.f50804h = this.f50801e.getInputStream();
        this.f50805i = this.f50801e.getOutputStream();
    }

    public void g(String str) throws SocketException, IOException {
        h(str, this.f50803g);
    }

    public void h(String str, int i6) throws SocketException, IOException {
        this.f50802f = str;
        a(InetAddress.getByName(str), i6, null, -1);
    }

    public void i(String str, int i6, InetAddress inetAddress, int i7) throws SocketException, IOException {
        this.f50802f = str;
        a(InetAddress.getByName(str), i6, inetAddress, i7);
    }

    protected void m() {
        this.f50799c = new ProtocolCommandSupport(this);
    }

    public void n() throws IOException {
        f(this.f50801e);
        e(this.f50804h);
        e(this.f50805i);
        this.f50801e = null;
        this.f50802f = null;
        this.f50804h = null;
        this.f50805i = null;
    }

    public Charset q() {
        return this.f50812p;
    }

    @Deprecated
    public String r() {
        return this.f50812p.name();
    }

    protected ProtocolCommandSupport s() {
        return this.f50799c;
    }

    public int t() {
        return this.f50808l;
    }

    public int u() {
        return this.f50803g;
    }

    public int v() {
        return this.f50800d;
    }

    public boolean w() throws SocketException {
        return this.f50801e.getKeepAlive();
    }

    public InetAddress x() {
        return this.f50801e.getLocalAddress();
    }

    public int y() {
        return this.f50801e.getLocalPort();
    }

    public Proxy z() {
        return this.f50811o;
    }

    public boolean I() {
        if (J()) {
            try {
                if (this.f50801e.getInetAddress() == null || this.f50801e.getPort() == 0 || this.f50801e.getRemoteSocketAddress() == null || this.f50801e.isClosed() || this.f50801e.isInputShutdown() || this.f50801e.isOutputShutdown()) {
                    return false;
                }
                this.f50801e.getInputStream();
                this.f50801e.getOutputStream();
                return true;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public void K(f fVar) {
        s().removeProtocolCommandListener(fVar);
    }

    public boolean Y(Socket socket) {
        return socket.getInetAddress().equals(B());
    }

    public void d(f fVar) {
        s().addProtocolCommandListener(fVar);
    }

    protected void o(String str, String str2) {
        if (s().getListenerCount() > 0) {
            s().fireCommandSent(str, str2);
        }
    }

    protected void p(int i6, String str) {
        if (s().getListenerCount() > 0) {
            s().fireReplyReceived(i6, str);
        }
    }
}
