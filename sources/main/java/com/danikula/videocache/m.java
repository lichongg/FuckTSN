package com.danikula.videocache;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
class m {

    /* renamed from: d, reason: collision with root package name */
    private static final org.slf4j.c f32220d = org.slf4j.d.j("Pinger");

    /* renamed from: e, reason: collision with root package name */
    private static final String f32221e = "ping";

    /* renamed from: f, reason: collision with root package name */
    private static final String f32222f = "ping ok";

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f32223a = Executors.newSingleThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    private final String f32224b;

    /* renamed from: c, reason: collision with root package name */
    private final int f32225c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements Callable<Boolean> {
        private b() {
        }

        /* synthetic */ b(m mVar, a aVar) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            return Boolean.valueOf(m.this.f());
        }
    }

    boolean e(int i6, int i7) {
        n.b(i6 >= 1);
        n.b(i7 > 0);
        int i8 = 0;
        while (i8 < i6) {
            try {
            } catch (InterruptedException e6) {
                e = e6;
                f32220d.error("Error pinging server due to unexpected error", e);
            } catch (ExecutionException e7) {
                e = e7;
                f32220d.error("Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                f32220d.warn("Error pinging server (attempt: " + i8 + ", timeout: " + i7 + "). ");
            }
            if (((Boolean) this.f32223a.submit(new b(this, null)).get(i7, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i8++;
            i7 *= 2;
        }
        String format = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i8), Integer.valueOf(i7 / 2), b());
        f32220d.error(format, (Throwable) new ProxyCacheException(format));
        return false;
    }

    private String c() {
        return String.format(Locale.US, "http://%s:%d/%s", this.f32224b, Integer.valueOf(this.f32225c), f32221e);
    }

    boolean d(String str) {
        return f32221e.equals(str);
    }

    m(String str, int i6) {
        this.f32224b = (String) n.d(str);
        this.f32225c = i6;
    }

    private List<Proxy> b() {
        try {
            return ProxySelector.getDefault().select(new URI(c()));
        } catch (URISyntaxException e6) {
            throw new IllegalStateException(e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() throws ProxyCacheException {
        k kVar = new k(c());
        try {
            try {
                byte[] bytes = f32222f.getBytes();
                kVar.a(0L);
                byte[] bArr = new byte[bytes.length];
                kVar.read(bArr);
                boolean equals = Arrays.equals(bytes, bArr);
                f32220d.info("Ping response: `" + new String(bArr) + "`, pinged? " + equals);
                return equals;
            } catch (ProxyCacheException e6) {
                f32220d.error("Error reading ping response", (Throwable) e6);
                kVar.close();
                return false;
            }
        } finally {
            kVar.close();
        }
    }

    void g(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write(f32222f.getBytes());
    }
}
