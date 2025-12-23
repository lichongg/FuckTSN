package com.beizi.ad.internal.i;

import android.text.TextUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class j {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f12247a = Executors.newSingleThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    private final String f12248b;

    /* renamed from: c, reason: collision with root package name */
    private final int f12249c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.i.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements Callable<Boolean> {
        private a() {
        }

        /* synthetic */ a(j jVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            return Boolean.valueOf(j.this.a());
        }
    }

    private String b() {
        String b6 = com.beizi.ad.lance.a.b.b("aHR0cDovLyVzOiVkLyVz");
        if (TextUtils.isEmpty(b6)) {
            return null;
        }
        return String.format(Locale.US, b6, this.f12248b, Integer.valueOf(this.f12249c), "ping");
    }

    boolean a(int i6, int i7) {
        k.a(i6 >= 1);
        k.a(i7 > 0);
        int i8 = 0;
        while (i8 < i6) {
            if (((Boolean) this.f12247a.submit(new a(this, null)).get(i7, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i8++;
            i7 *= 2;
        }
        return false;
    }

    j(String str, int i6) {
        this.f12248b = (String) k.a(str);
        this.f12249c = i6;
    }

    boolean a(String str) {
        return "ping".equals(str);
    }

    void a(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() throws m {
        h hVar = new h(b());
        try {
            byte[] bytes = "ping ok".getBytes();
            hVar.a(0);
            byte[] bArr = new byte[bytes.length];
            hVar.a(bArr);
            return Arrays.equals(bytes, bArr);
        } catch (m unused) {
            return false;
        } finally {
            hVar.b();
        }
    }
}
