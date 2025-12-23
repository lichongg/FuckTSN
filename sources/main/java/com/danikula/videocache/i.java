package com.danikula.videocache;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class i {

    /* renamed from: i, reason: collision with root package name */
    private static final org.slf4j.c f32183i = org.slf4j.d.j("HttpProxyCacheServer");

    /* renamed from: j, reason: collision with root package name */
    private static final String f32184j = "127.0.0.1";

    /* renamed from: a, reason: collision with root package name */
    private final Object f32185a;

    /* renamed from: b, reason: collision with root package name */
    private final ExecutorService f32186b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, j> f32187c;

    /* renamed from: d, reason: collision with root package name */
    private final ServerSocket f32188d;

    /* renamed from: e, reason: collision with root package name */
    private final int f32189e;

    /* renamed from: f, reason: collision with root package name */
    private final Thread f32190f;

    /* renamed from: g, reason: collision with root package name */
    private final f f32191g;

    /* renamed from: h, reason: collision with root package name */
    private final m f32192h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: e, reason: collision with root package name */
        private static final long f32193e = 536870912;

        /* renamed from: a, reason: collision with root package name */
        private File f32194a;

        /* renamed from: d, reason: collision with root package name */
        private com.danikula.videocache.sourcestorage.c f32197d;

        /* renamed from: c, reason: collision with root package name */
        private com.danikula.videocache.file.a f32196c = new com.danikula.videocache.file.h(536870912);

        /* renamed from: b, reason: collision with root package name */
        private com.danikula.videocache.file.c f32195b = new com.danikula.videocache.file.f();

        /* JADX INFO: Access modifiers changed from: private */
        public f c() {
            return new f(this.f32194a, this.f32195b, this.f32196c, this.f32197d);
        }

        public b g(int i6) {
            this.f32196c = new com.danikula.videocache.file.g(i6);
            return this;
        }

        public b h(long j6) {
            this.f32196c = new com.danikula.videocache.file.h(j6);
            return this;
        }

        public b(Context context) {
            this.f32197d = com.danikula.videocache.sourcestorage.d.b(context);
            this.f32194a = t.c(context);
        }

        public i b() {
            return new i(c(), null);
        }

        public b d(File file) {
            this.f32194a = (File) n.d(file);
            return this;
        }

        public b e(com.danikula.videocache.file.a aVar) {
            this.f32196c = (com.danikula.videocache.file.a) n.d(aVar);
            return this;
        }

        public b f(com.danikula.videocache.file.c cVar) {
            this.f32195b = (com.danikula.videocache.file.c) n.d(cVar);
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Socket f32198a;

        public c(Socket socket) {
            this.f32198a = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.o(this.f32198a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final CountDownLatch f32200a;

        public d(CountDownLatch countDownLatch) {
            this.f32200a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f32200a.countDown();
            i.this.w();
        }
    }

    /* synthetic */ i(f fVar, a aVar) {
        this(fVar);
    }

    public String j(String str) {
        return k(str, true);
    }

    public void p(e eVar, String str) {
        n.a(eVar, str);
        synchronized (this.f32185a) {
            try {
                h(str).e(eVar);
            } catch (ProxyCacheException e6) {
                f32183i.warn("Error registering cache listener", (Throwable) e6);
            }
        }
    }

    public void v(e eVar, String str) {
        n.a(eVar, str);
        synchronized (this.f32185a) {
            try {
                h(str).h(eVar);
            } catch (ProxyCacheException e6) {
                f32183i.warn("Error registering cache listener", (Throwable) e6);
            }
        }
    }

    public i(Context context) {
        this(new b(context).c());
    }

    private String c(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", f32184j, Integer.valueOf(this.f32189e), p.f(str));
    }

    private File g(String str) {
        f fVar = this.f32191g;
        return new File(fVar.f32158a, fVar.f32159b.generate(str));
    }

    private j h(String str) throws ProxyCacheException {
        j jVar;
        synchronized (this.f32185a) {
            try {
                jVar = this.f32187c.get(str);
                if (jVar == null) {
                    jVar = new j(str, this.f32191g);
                    this.f32187c.put(str, jVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
    }

    private int i() {
        int i6;
        synchronized (this.f32185a) {
            try {
                Iterator<j> it = this.f32187c.values().iterator();
                i6 = 0;
                while (it.hasNext()) {
                    i6 += it.next().b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i6;
    }

    private boolean l() {
        return this.f32192h.e(3, 70);
    }

    private void n(Throwable th) {
        f32183i.error("HttpProxyCacheServer error", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Socket socket) {
        try {
            try {
                g c6 = g.c(socket.getInputStream());
                org.slf4j.c cVar = f32183i;
                cVar.debug("Request to cache proxy:" + c6);
                String e6 = p.e(c6.f32176a);
                if (this.f32192h.d(e6)) {
                    this.f32192h.g(socket);
                } else {
                    h(e6).d(c6, socket);
                }
                q(socket);
                cVar.debug("Opened connections: " + i());
            } catch (ProxyCacheException e7) {
                e = e7;
                n(new ProxyCacheException("Error processing request", e));
                q(socket);
                f32183i.debug("Opened connections: " + i());
            } catch (SocketException unused) {
                org.slf4j.c cVar2 = f32183i;
                cVar2.debug("Closing socket… Socket is closed by client.");
                q(socket);
                cVar2.debug("Opened connections: " + i());
            } catch (IOException e8) {
                e = e8;
                n(new ProxyCacheException("Error processing request", e));
                q(socket);
                f32183i.debug("Opened connections: " + i());
            }
        } catch (Throwable th) {
            q(socket);
            f32183i.debug("Opened connections: " + i());
            throw th;
        }
    }

    private void s() {
        synchronized (this.f32185a) {
            try {
                Iterator<j> it = this.f32187c.values().iterator();
                while (it.hasNext()) {
                    it.next().f();
                }
                this.f32187c.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void t(File file) {
        try {
            this.f32191g.f32160c.a(file);
        } catch (IOException e6) {
            f32183i.error("Error touching file " + file, (Throwable) e6);
        }
    }

    public String k(String str, boolean z5) {
        if (!z5 || !m(str)) {
            return l() ? c(str) : str;
        }
        File g6 = g(str);
        t(g6);
        return Uri.fromFile(g6).toString();
    }

    public boolean m(String str) {
        n.e(str, "Url can't be null!");
        return g(str).exists();
    }

    public void r() {
        f32183i.info("Shutdown proxy server");
        s();
        this.f32191g.f32161d.release();
        this.f32190f.interrupt();
        try {
            if (this.f32188d.isClosed()) {
                return;
            }
            this.f32188d.close();
        } catch (IOException e6) {
            n(new ProxyCacheException("Error shutting down proxy server", e6));
        }
    }

    private i(f fVar) {
        this.f32185a = new Object();
        this.f32186b = Executors.newFixedThreadPool(8);
        this.f32187c = new ConcurrentHashMap();
        this.f32191g = (f) n.d(fVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName(f32184j));
            this.f32188d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f32189e = localPort;
            l.a(f32184j, localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new d(countDownLatch));
            this.f32190f = thread;
            thread.start();
            countDownLatch.await();
            this.f32192h = new m(f32184j, localPort);
            f32183i.info("Proxy cache server started. Is it alive? " + l());
        } catch (IOException | InterruptedException e6) {
            this.f32186b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e6);
        }
    }

    private void d(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e6) {
            n(new ProxyCacheException("Error closing socket", e6));
        }
    }

    private void e(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException unused) {
            f32183i.debug("Releasing input stream… Socket is closed by client.");
        } catch (IOException e6) {
            n(new ProxyCacheException("Error closing socket input stream", e6));
        }
    }

    private void f(Socket socket) {
        try {
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException e6) {
            f32183i.warn("Failed to close socket on proxy side: {}. It seems client have already closed connection.", e6.getMessage());
        }
    }

    private void q(Socket socket) {
        e(socket);
        f(socket);
        d(socket);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f32188d.accept();
                f32183i.debug("Accept new socket " + accept);
                this.f32186b.submit(new c(accept));
            } catch (IOException e6) {
                n(new ProxyCacheException("Error during waiting connection", e6));
                return;
            }
        }
    }

    public void u(e eVar) {
        n.d(eVar);
        synchronized (this.f32185a) {
            try {
                Iterator<j> it = this.f32187c.values().iterator();
                while (it.hasNext()) {
                    it.next().h(eVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
