package com.beizi.ad.internal.i;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final Object f12219a;

    /* renamed from: b, reason: collision with root package name */
    private final ExecutorService f12220b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, g> f12221c;

    /* renamed from: d, reason: collision with root package name */
    private final ServerSocket f12222d;

    /* renamed from: e, reason: collision with root package name */
    private final int f12223e;

    /* renamed from: f, reason: collision with root package name */
    private final Thread f12224f;

    /* renamed from: g, reason: collision with root package name */
    private final com.beizi.ad.internal.i.c f12225g;

    /* renamed from: h, reason: collision with root package name */
    private final j f12226h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.i.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private File f12227a;

        /* renamed from: d, reason: collision with root package name */
        private com.beizi.ad.internal.i.b.c f12230d;

        /* renamed from: c, reason: collision with root package name */
        private com.beizi.ad.internal.i.a.a f12229c = new com.beizi.ad.internal.i.a.g(IjkMediaMeta.AV_CH_STEREO_LEFT);

        /* renamed from: b, reason: collision with root package name */
        private com.beizi.ad.internal.i.a.c f12228b = new com.beizi.ad.internal.i.a.f();

        public a a(long j6) {
            this.f12229c = new com.beizi.ad.internal.i.a.g(j6);
            return this;
        }

        private com.beizi.ad.internal.i.c b() {
            return new com.beizi.ad.internal.i.c(this.f12227a, this.f12228b, this.f12229c, this.f12230d);
        }

        public f a() {
            return new f(b(), null);
        }

        public a(Context context) {
            this.f12230d = com.beizi.ad.internal.i.b.d.a(context);
            this.f12227a = q.a(context);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final Socket f12232b;

        public b(Socket socket) {
            this.f12232b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.a(this.f12232b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final CountDownLatch f12234b;

        public c(CountDownLatch countDownLatch) {
            this.f12234b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12234b.countDown();
            f.this.b();
        }
    }

    /* synthetic */ f(com.beizi.ad.internal.i.c cVar, AnonymousClass1 anonymousClass1) {
        this(cVar);
    }

    private void a(Throwable th) {
    }

    private String c(String str) {
        String b6 = com.beizi.ad.lance.a.b.b("aHR0cDovLyVzOiVkLyVz");
        if (TextUtils.isEmpty(b6)) {
            return null;
        }
        return String.format(Locale.US, b6, com.beizi.ad.lance.a.b.b("MTI3LjAuMC4x"), Integer.valueOf(this.f12223e), n.b(str));
    }

    private File d(String str) {
        com.beizi.ad.internal.i.c cVar = this.f12225g;
        return new File(cVar.f12207a, cVar.f12208b.a(str));
    }

    private g e(String str) throws m {
        g gVar;
        synchronized (this.f12219a) {
            try {
                gVar = this.f12221c.get(str);
                if (gVar == null) {
                    gVar = new g(str, this.f12225g);
                    this.f12221c.put(str, gVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    public boolean b(String str) {
        k.a(str, "Url can't be null!");
        return d(str).exists();
    }

    private f(com.beizi.ad.internal.i.c cVar) {
        this.f12219a = new Object();
        this.f12220b = Executors.newFixedThreadPool(8);
        this.f12221c = new ConcurrentHashMap();
        this.f12225g = (com.beizi.ad.internal.i.c) k.a(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName(com.beizi.ad.lance.a.b.b("MTI3LjAuMC4x")));
            this.f12222d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f12223e = localPort;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.f12224f = thread;
            thread.start();
            countDownLatch.await();
            this.f12226h = new j(com.beizi.ad.lance.a.b.b("MTI3LjAuMC4x"), localPort);
        } catch (IOException | InterruptedException e6) {
            this.f12220b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                this.f12220b.submit(new b(this.f12222d.accept()));
            } catch (IOException e6) {
                a(new m("Error during waiting connection", e6));
                return;
            }
        }
    }

    private void c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
        } catch (IOException e6) {
            a(new m("Error closing socket input stream", e6));
        }
    }

    private void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
        }
    }

    public String a(String str) {
        return a(str, true);
    }

    public String a(String str, boolean z5) {
        if (!z5 || !b(str)) {
            return a() ? c(str) : str;
        }
        File d6 = d(str);
        a(d6);
        return Uri.fromFile(d6).toString();
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e6) {
            a(new m("Error closing socket", e6));
        }
    }

    private boolean a() {
        return this.f12226h.a(3, 70);
    }

    private void a(File file) {
        try {
            this.f12225g.f12209c.a(file);
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Socket socket) {
        try {
            try {
                d a6 = d.a(socket.getInputStream());
                String c6 = n.c(a6.f12213a);
                if (this.f12226h.a(c6)) {
                    this.f12226h.a(socket);
                } else {
                    e(c6).a(a6, socket);
                }
                b(socket);
            } catch (m e6) {
                e = e6;
                a(new m("Error processing request", e));
                b(socket);
            } catch (SocketException unused) {
                b(socket);
            } catch (IOException e7) {
                e = e7;
                a(new m("Error processing request", e));
                b(socket);
            }
        } catch (Throwable th) {
            b(socket);
            throw th;
        }
    }
}
