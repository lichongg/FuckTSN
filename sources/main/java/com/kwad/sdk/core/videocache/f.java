package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.ax;
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
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {
    private final Object aKY;
    private final ExecutorService aKZ;
    private final Map<String, g> aLa;
    private final ServerSocket aLb;
    private final Thread aLc;
    private final com.kwad.sdk.core.videocache.c aLd;
    private final int port;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        private File aKK;
        private com.kwad.sdk.core.videocache.d.c aKN;
        private int aKP;
        private Context context;
        private int aKQ = 0;
        private com.kwad.sdk.core.videocache.a.a aKM = new com.kwad.sdk.core.videocache.a.g(IjkMediaMeta.AV_CH_STEREO_LEFT);
        private com.kwad.sdk.core.videocache.a.c aKL = new com.kwad.sdk.core.videocache.a.f();
        private com.kwad.sdk.core.videocache.b.b aKO = new com.kwad.sdk.core.videocache.b.a();

        private com.kwad.sdk.core.videocache.c Ko() {
            return new com.kwad.sdk.core.videocache.c(this.aKK, this.aKL, this.aKM, this.aKN, this.aKO, this.aKP, this.aKQ);
        }

        public final f Kn() {
            this.aKN = com.kwad.sdk.core.videocache.d.d.k(this.context, this.aKQ);
            return new f(Ko(), (byte) 0);
        }

        public final a aJ(long j6) {
            this.aKM = new com.kwad.sdk.core.videocache.a.g(IjkMediaMeta.AV_CH_STEREO_LEFT);
            return this;
        }

        public final a dN(int i6) {
            this.aKP = i6;
            return this;
        }

        public final a dO(int i6) {
            this.aKQ = i6;
            return this;
        }

        public a(Context context) {
            this.context = context;
            this.aKK = o.bQ(context);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements Runnable {
        private final Socket aLe;

        public b(Socket socket) {
            this.aLe = socket;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
            f.this.a(this.aLe);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class c implements Runnable {
        private final CountDownLatch aLg;

        public c(CountDownLatch countDownLatch) {
            this.aLg = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.aLg.countDown();
                f.this.Kl();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
    }

    /* synthetic */ f(com.kwad.sdk.core.videocache.c cVar, byte b6) {
        this(cVar);
    }

    private f(com.kwad.sdk.core.videocache.c cVar) {
        this.aKY = new Object();
        this.aKZ = GlobalThreadPools.Jw();
        this.aLa = new ConcurrentHashMap();
        this.aLd = (com.kwad.sdk.core.videocache.c) ax.checkNotNull(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.aLb = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.port = localPort;
            i.install("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.aLc = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e6) {
            this.aKZ.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e6);
        }
    }

    private int Km() {
        int i6;
        synchronized (this.aKY) {
            try {
                Iterator<g> it = this.aLa.values().iterator();
                i6 = 0;
                while (it.hasNext()) {
                    i6 += it.next().Km();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i6;
    }

    private File aa(String str) {
        com.kwad.sdk.core.videocache.c cVar = this.aLd;
        return new File(cVar.aKK, cVar.aKL.generate(str));
    }

    private String eN(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.port), l.encode(str));
    }

    private File eO(String str) {
        return new File(this.aLd.aKK, this.aLd.aKL.generate(str) + ".download");
    }

    private g eP(String str) {
        g gVar;
        synchronized (this.aKY) {
            try {
                gVar = this.aLa.get(str);
                if (gVar == null) {
                    gVar = new g(str, this.aLd);
                    this.aLa.put(str, gVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    private void r(File file) {
        try {
            this.aLd.aKM.s(file);
        } catch (IOException unused) {
            com.kwad.sdk.core.d.c.e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    public final String eJ(String str) {
        return str == null ? "" : f(str, true);
    }

    public final boolean eK(String str) {
        ax.ax(str, "Url can't be null!");
        return aa(str).exists();
    }

    public final boolean eL(String str) {
        ax.ax(str, "Url can't be null!");
        return eO(str).exists() || aa(str).exists();
    }

    public final boolean eM(String str) {
        g gVar = this.aLa.get(str);
        if (gVar == null) {
            return false;
        }
        gVar.shutdown();
        this.aLa.remove(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kl() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.aLb.accept();
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Accept new socket " + accept);
                this.aKZ.submit(new b(accept));
            } catch (IOException e6) {
                onError(new ProxyCacheException("Error during waiting connection", e6));
                return;
            }
        }
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private void c(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException unused) {
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e6) {
            onError(new ProxyCacheException("Error closing socket input stream", e6));
        }
    }

    private static void d(Socket socket) {
        try {
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException unused) {
            com.kwad.sdk.core.d.c.w("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private void e(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e6) {
            onError(new ProxyCacheException("Error closing socket", e6));
        }
    }

    private String f(String str, boolean z5) {
        if (aa(str).exists()) {
            File aa = aa(str);
            r(aa);
            return Uri.fromFile(aa).toString();
        }
        return eN(str);
    }

    private static void onError(Throwable th) {
        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
    }

    public final boolean a(String str, long j6, a.C0688a c0688a, AdHttpResponseListener adHttpResponseListener) {
        com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (eK(str)) {
            return true;
        }
        return com.kwad.sdk.core.network.a.a.a(eN(str), null, c0688a, j6, false, adHttpResponseListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.kwad.sdk.core.videocache.f] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public void a(Socket socket) {
        ?? r6;
        ?? r02 = "Opened connections: ";
        try {
            try {
                d b6 = d.b(socket.getInputStream());
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Request to cache proxy:" + b6);
                eP(l.decode(b6.uri)).a(b6, socket);
                b(socket);
                r6 = new StringBuilder("Opened connections: ");
            } catch (ProxyCacheException e6) {
                e = e6;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                r6 = new StringBuilder("Opened connections: ");
            } catch (SocketException e7) {
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                e7.printStackTrace();
                b(socket);
                r6 = new StringBuilder("Opened connections: ");
            } catch (IOException e8) {
                e = e8;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                r6 = new StringBuilder("Opened connections: ");
            }
            r02 = Km();
            r6.append(r02);
            socket = r6.toString();
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", (String) socket);
        } catch (Throwable th) {
            b(socket);
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", ((String) r02) + Km());
            throw th;
        }
    }
}
