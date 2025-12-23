package cn.jiguang.bl;

import cn.jiguang.ba.j;
import cn.jiguang.bb.f;
import cn.jiguang.bi.e;
import cn.jiguang.bz.y;
import cn.jiguang.net.SSLTrustManager;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.security.SecureRandom;
import java.util.Iterator;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends a {

    /* renamed from: j, reason: collision with root package name */
    protected SSLContext f2345j;

    /* renamed from: k, reason: collision with root package name */
    private SSLEngine f2346k;

    /* renamed from: l, reason: collision with root package name */
    private ByteBuffer f2347l;

    /* renamed from: m, reason: collision with root package name */
    private ByteBuffer f2348m;

    /* renamed from: n, reason: collision with root package name */
    private ByteBuffer f2349n = ByteBuffer.allocate(8192);

    /* renamed from: o, reason: collision with root package name */
    private ByteBuffer f2350o;

    /* renamed from: p, reason: collision with root package name */
    private final int f2351p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f2352q;

    private ByteBuffer b(SSLEngine sSLEngine, ByteBuffer byteBuffer) {
        return a(byteBuffer, sSLEngine.getSession().getApplicationBufferSize());
    }

    private ByteBuffer c(SSLEngine sSLEngine, ByteBuffer byteBuffer) {
        if (sSLEngine.getSession().getPacketBufferSize() < byteBuffer.limit()) {
            return byteBuffer;
        }
        ByteBuffer a6 = a(sSLEngine, byteBuffer);
        byteBuffer.flip();
        a6.put(byteBuffer);
        return a6;
    }

    @Override // cn.jiguang.bl.a
    public synchronized int a(String str, int i6) {
        super.a(str, i6);
        int i7 = 3;
        try {
            if (!d()) {
                f.a("NioSSLSocketClient", "#unexcepted - create SSL failed");
                return -992;
            }
            f.a("NioSSLSocketClient", "tcp connecting...");
            this.f2337b = SocketChannel.open();
            this.f2339d = Selector.open();
            this.f2337b.configureBlocking(false);
            this.f2337b.connect(new InetSocketAddress(str, i6));
            long currentTimeMillis = System.currentTimeMillis();
            while (!this.f2337b.finishConnect()) {
                if (!this.f2340e) {
                    f.c("NioSSLSocketClient", "has close channel when connect...");
                    return -991;
                }
                Thread.sleep(10L);
                if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                    close();
                    cn.jiguang.bw.a.a().a(2);
                    return -994;
                }
            }
            if (!this.f2340e) {
                f.c("NioSSLSocketClient", "has close channel when connected...");
                return -991;
            }
            f.c("NioSSLSocketClient", "begin doHandShake");
            boolean a6 = a(this.f2337b);
            this.f2352q = a6;
            if (!a6) {
                f.c("NioSSLSocketClient", "handShake failed");
                cn.jiguang.bw.a.a().a(3);
                return -992;
            }
            this.f2349n.clear();
            f.c("NioSSLSocketClient", "tcp connected [" + str + ":" + i6 + "]");
            return 0;
        } catch (Throwable th) {
            f.j("NioSSLSocketClient", "tcp connect has failed:" + th);
            cn.jiguang.bw.a a7 = cn.jiguang.bw.a.a();
            if (!(th instanceof SocketTimeoutException)) {
                i7 = 4;
            }
            a7.a(i7);
            close();
            return th instanceof SocketTimeoutException ? -994 : -1000;
        }
    }

    /* renamed from: cn.jiguang.bl.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2353a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f2354b;

        static {
            int[] iArr = new int[SSLEngineResult.HandshakeStatus.values().length];
            f2354b = iArr;
            try {
                iArr[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2354b[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2354b[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2354b[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2354b[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[SSLEngineResult.Status.values().length];
            f2353a = iArr2;
            try {
                iArr2[SSLEngineResult.Status.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2353a[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2353a[SSLEngineResult.Status.BUFFER_UNDERFLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2353a[SSLEngineResult.Status.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private int a(SocketChannel socketChannel, SSLEngine sSLEngine) {
        this.f2350o.clear();
        int read = socketChannel.read(this.f2349n);
        if (read < 0) {
            cn.jiguang.bw.a.a().a(12);
            throw new e(-996, "read len < 0: " + read);
        }
        while (this.f2349n.hasRemaining()) {
            try {
                this.f2349n.flip();
                SSLEngineResult unwrap = sSLEngine.unwrap(this.f2349n, this.f2350o);
                this.f2349n.compact();
                int i6 = AnonymousClass1.f2353a[unwrap.getStatus().ordinal()];
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 == 3) {
                            this.f2349n = c(sSLEngine, this.f2349n);
                            return 0;
                        }
                        if (i6 != 4) {
                            cn.jiguang.bw.a.a().a(11);
                            throw new IllegalStateException("Invalid SSL status: " + unwrap.getStatus());
                        }
                        f.i("NioSSLSocketClient", "ssl connect need to close[" + this.f2343h + ":" + this.f2344i + "]");
                        return -1;
                    }
                    this.f2350o = b(sSLEngine, this.f2350o);
                }
            } catch (Throwable th) {
                f.i("NioSSLSocketClient", "recv data failed for unwrap net data, " + th);
                cn.jiguang.bw.a.a().a(10);
                throw new SSLException("unwrap ssl net data failed: " + th.getMessage());
            }
        }
        return 0;
    }

    private boolean c(byte[] bArr) {
        this.f2347l.clear();
        this.f2347l.put(bArr);
        this.f2347l.flip();
        while (this.f2347l.hasRemaining()) {
            this.f2348m.clear();
            SSLEngineResult wrap = this.f2346k.wrap(this.f2347l, this.f2348m);
            int i6 = AnonymousClass1.f2353a[wrap.getStatus().ordinal()];
            if (i6 == 1) {
                this.f2348m.flip();
                int i7 = 0;
                while (this.f2348m.hasRemaining()) {
                    i7 += this.f2337b.write(this.f2348m);
                }
                f.c("NioSSLSocketClient", "send data to server, writeLen: " + i7 + ", isRemaining: " + this.f2347l.hasRemaining());
            } else {
                if (i6 != 2) {
                    if (i6 == 3) {
                        cn.jiguang.bw.a.a().a(13);
                        throw new SSLException("Buffer underflow occured after a wrap. I don't think we should ever get here.");
                    }
                    if (i6 == 4) {
                        throw new Exception("connect close");
                    }
                    cn.jiguang.bw.a.a().a(11);
                    throw new IllegalStateException("Invalid SSL status: " + wrap.getStatus());
                }
                this.f2348m = a(this.f2346k, this.f2348m);
            }
        }
        return true;
    }

    private SSLEngineResult.HandshakeStatus e() {
        Runnable delegatedTask;
        while (this.f2340e && (delegatedTask = this.f2346k.getDelegatedTask()) != null) {
            f.a("NioSSLSocketClient", "running delegated task...");
            delegatedTask.run();
        }
        SSLEngineResult.HandshakeStatus handshakeStatus = this.f2346k.getHandshakeStatus();
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
            f.a("NioSSLSocketClient", "handshake shouldn't need additional tasks");
        }
        return handshakeStatus;
    }

    private SSLEngineResult.HandshakeStatus f() {
        SSLEngineResult.HandshakeStatus e6;
        do {
            SSLEngineResult unwrap = this.f2346k.unwrap(this.f2349n, this.f2350o);
            e6 = e();
            if (unwrap.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW || !this.f2340e || e6 != SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                break;
            }
        } while (this.f2349n.remaining() > 0);
        this.f2349n.compact();
        return e6;
    }

    private SSLEngineResult.HandshakeStatus g() {
        this.f2346k.wrap(ByteBuffer.wrap("".getBytes()), this.f2348m);
        SSLEngineResult.HandshakeStatus e6 = e();
        this.f2348m.flip();
        return e6;
    }

    @Override // cn.jiguang.bl.a
    public boolean b() {
        return super.b() && this.f2352q;
    }

    @Override // cn.jiguang.bl.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        f.a("NioSSLSocketClient", "close this connect...");
        super.close();
        ByteBuffer byteBuffer = this.f2347l;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f2348m;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        ByteBuffer byteBuffer3 = this.f2350o;
        if (byteBuffer3 != null) {
            byteBuffer3.clear();
        }
        ByteBuffer byteBuffer4 = this.f2349n;
        if (byteBuffer4 != null) {
            byteBuffer4.clear();
        }
        Selector selector = this.f2339d;
        if (selector != null) {
            try {
                selector.close();
            } catch (Exception e6) {
                f.c("NioSSLSocketClient", "selector close error：" + e6.getMessage());
            }
        }
        y.a(this.f2337b);
        this.f2337b = null;
        f.a("NioSSLSocketClient", "tcp has closed");
    }

    protected boolean d() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            this.f2345j = sSLContext;
            sSLContext.init(null, new TrustManager[]{new SSLTrustManager(j.a())}, new SecureRandom());
            SSLEngine createSSLEngine = this.f2345j.createSSLEngine();
            this.f2346k = createSSLEngine;
            createSSLEngine.setUseClientMode(true);
            SSLSession session = this.f2346k.getSession();
            int applicationBufferSize = session.getApplicationBufferSize();
            int packetBufferSize = session.getPacketBufferSize();
            this.f2350o = ByteBuffer.allocate(applicationBufferSize + 10);
            this.f2349n = ByteBuffer.allocate(packetBufferSize);
            this.f2347l = ByteBuffer.allocate(packetBufferSize);
            this.f2348m = ByteBuffer.allocate(packetBufferSize);
            f.a("NioSSLSocketClient", "application size:" + session.getApplicationBufferSize() + ",package size:" + session.getPacketBufferSize());
            return true;
        } catch (Throwable th) {
            cn.jiguang.bw.a.a().a(1);
            f.j("NioSSLSocketClient", "NioSSLSocketClient create ssl error, cur time is:" + System.currentTimeMillis() + ",error:" + th);
            return false;
        }
    }

    public b(int i6, int i7) {
        this.f2351p = i6;
        this.f2341f = i7;
    }

    private boolean b(byte[] bArr) {
        try {
            if (!b()) {
                f.k("NioSSLSocketClient", "send error - connect was invalid");
                return false;
            }
            if (bArr != null && bArr.length > 0) {
                return c(bArr);
            }
            f.c("NioSSLSocketClient", "send error - invalide buffer");
            return false;
        } catch (Exception e6) {
            f.j("NioSSLSocketClient", "send data error:" + e6.getMessage());
            close();
            return false;
        }
    }

    @Override // cn.jiguang.bl.a
    public synchronized int a(byte[] bArr) {
        if (bArr == null) {
            f.c("NioSSLSocketClient", "sendData failed, send data was null");
            return 103;
        }
        f.c("NioSSLSocketClient", "send data length:" + bArr.length);
        if (bArr.length < this.f2351p) {
            return b(bArr) ? 0 : 103;
        }
        f.c("NioSSLSocketClient", "sendData failed, data length must less than " + this.f2351p);
        return 6026;
    }

    @Override // cn.jiguang.bl.a
    public ByteBuffer a(int i6) {
        ByteBuffer b6;
        if (!b()) {
            throw new e(-991, "recv error,the connect is invalid");
        }
        int c6 = c();
        if (c6 > 0 && (b6 = b(c6)) != null) {
            cn.jiguang.bw.a.a().a(0);
            return b6;
        }
        try {
            int i7 = 4;
            if (!b()) {
                f.c("NioSSLSocketClient", "recv register error,the connect is invalid");
                cn.jiguang.bw.a.a().a(4);
                return null;
            }
            int i8 = 1048576;
            int i9 = 0;
            while (b() && this.f2338c < i8) {
                int select = i6 > 0 ? this.f2339d.select(i6) : this.f2339d.select();
                if (select == 0) {
                    f.c("NioSSLSocketClient", "readSelect:" + select + ", time out:" + i6);
                    if (i6 > 0) {
                        cn.jiguang.bw.a.a().a(2);
                        throw new e(-994, "recv time out");
                    }
                } else {
                    Iterator<SelectionKey> it = this.f2339d.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey next = it.next();
                        it.remove();
                        SocketChannel socketChannel = (SocketChannel) next.channel();
                        if (!b()) {
                            f.c("NioSSLSocketClient", "tcp connect has set false in select key");
                            cn.jiguang.bw.a.a().a(i7);
                            return null;
                        }
                        if (!next.isReadable()) {
                            next.isWritable();
                        } else if (this.f2346k.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
                            continue;
                        } else {
                            int a6 = a(socketChannel, this.f2346k);
                            if (a6 != 0) {
                                next.cancel();
                                return null;
                            }
                            this.f2350o.flip();
                            i9 = this.f2350o.limit();
                            if (this.f2336a.remaining() >= i9) {
                                this.f2336a.put(this.f2350o);
                                this.f2338c += i9;
                                this.f2350o.compact();
                                if (this.f2338c < this.f2341f) {
                                    cn.jiguang.bw.a.a().a(6);
                                    f.c("NioSSLSocketClient", "totalbuf can not parse head:" + this.f2338c + ",peerNetData len:" + i9 + ",read:" + a6);
                                } else {
                                    i8 = c();
                                }
                            } else {
                                cn.jiguang.bw.a.a().a(5);
                                throw new e(-996, "the total buf remaining less than readLen,remaining:" + this.f2336a.remaining() + ",readLen:" + i9);
                            }
                        }
                        i7 = 4;
                    }
                }
            }
            if (i8 == 1048576) {
                cn.jiguang.bw.a.a().a(9);
                throw new e(-997, "recv empty data or tcp has close");
            }
            f.c("NioSSLSocketClient", "read len:" + i9 + ",recvTotalLen:" + this.f2338c + ",shouldLen:" + i8);
            ByteBuffer b7 = b(i8);
            if (b7 != null) {
                cn.jiguang.bw.a.a().a(0);
                return b7;
            }
            cn.jiguang.bw.a.a().a(8);
            throw new e(-1001, "parse error");
        } catch (Throwable th) {
            if (th instanceof SocketTimeoutException) {
                cn.jiguang.bw.a.a().a(2);
                throw new e(-994, th.getMessage());
            }
            if (th instanceof e) {
                throw th;
            }
            cn.jiguang.bw.a.a().a(7);
            throw new e(-997, th.getMessage());
        }
    }

    private ByteBuffer a(ByteBuffer byteBuffer, int i6) {
        return i6 > byteBuffer.capacity() ? ByteBuffer.allocate(i6) : ByteBuffer.allocate(byteBuffer.capacity() * 2);
    }

    private ByteBuffer a(SSLEngine sSLEngine, ByteBuffer byteBuffer) {
        return a(byteBuffer, sSLEngine.getSession().getPacketBufferSize());
    }

    private boolean a(SocketChannel socketChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f2346k.beginHandshake();
        SSLEngineResult.HandshakeStatus handshakeStatus = this.f2346k.getHandshakeStatus();
        while (this.f2340e) {
            if (System.currentTimeMillis() - currentTimeMillis > 15000) {
                f.c("NioSSLSocketClient", "ssl hand shake time out");
                cn.jiguang.bw.a.a().a(14);
                return false;
            }
            int i6 = AnonymousClass1.f2354b[handshakeStatus.ordinal()];
            if (i6 == 2) {
                handshakeStatus = e();
            } else if (i6 == 3) {
                if (socketChannel.read(this.f2349n) > 0) {
                    f.c("NioSSLSocketClient", "NEED_UNWRAP read:" + this.f2349n.toString());
                }
                this.f2349n.flip();
                handshakeStatus = f();
            } else if (i6 == 4) {
                handshakeStatus = g();
                socketChannel.write(this.f2348m);
                this.f2348m.clear();
            } else if (i6 == 5) {
                socketChannel.configureBlocking(false);
                socketChannel.register(this.f2339d, 1);
                return true;
            }
        }
        return false;
    }
}
