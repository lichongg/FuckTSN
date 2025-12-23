package com.beizi.ad.internal.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.collection.LruCache;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class t {

    /* renamed from: d, reason: collision with root package name */
    private static t f12152d;

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f12153a = Executors.newFixedThreadPool(4);

    /* renamed from: b, reason: collision with root package name */
    private LruCache<String, String> f12154b = new LruCache<>(1048576);

    /* renamed from: c, reason: collision with root package name */
    private Handler f12155c = new Handler();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();

        void a(String str);
    }

    public static t a() {
        return b();
    }

    private static t b() {
        if (f12152d == null) {
            synchronized (t.class) {
                try {
                    if (f12152d == null) {
                        f12152d = new t();
                    }
                } finally {
                }
            }
        }
        return f12152d;
    }

    private boolean c() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public void a(final Context context, final String str, final a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = this.f12154b.get(str);
        if (!TextUtils.isEmpty(str2)) {
            aVar.a(str2);
            return;
        }
        File file = new File(com.beizi.ad.lance.a.h.d(context), f.a(str.substring(str.lastIndexOf("/") + 1)));
        String absolutePath = (!file.exists() || file.length() <= 0) ? null : file.getAbsolutePath();
        if (!TextUtils.isEmpty(absolutePath)) {
            this.f12154b.put(str, absolutePath);
            aVar.a(absolutePath);
        } else {
            this.f12153a.submit(new Runnable() { // from class: com.beizi.ad.internal.h.t.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        InputStream inputStream = ((HttpURLConnection) new URL(str).openConnection()).getInputStream();
                        String str3 = str;
                        File file2 = new File(com.beizi.ad.lance.a.h.d(context), f.a(str3.substring(str3.lastIndexOf("/") + 1)));
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, read);
                            }
                        }
                        final String absolutePath2 = file2.getAbsolutePath();
                        t.this.f12155c.post(new Runnable() { // from class: com.beizi.ad.internal.h.t.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar.a(absolutePath2);
                            }
                        });
                        t.this.f12154b.put(str, absolutePath2);
                        fileOutputStream.close();
                        inputStream.close();
                        bufferedInputStream.close();
                    } catch (Exception unused) {
                        t.this.f12155c.post(new Runnable() { // from class: com.beizi.ad.internal.h.t.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar.a();
                            }
                        });
                    }
                    com.beizi.ad.lance.a.h.e(context);
                }
            });
        }
    }

    public void a(final Context context, final String str, final boolean z5, final a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final String str2 = this.f12154b.get(str);
        if (!TextUtils.isEmpty(str2)) {
            if (z5) {
                if (c()) {
                    aVar.a(str2);
                    return;
                }
                Handler handler = this.f12155c;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.beizi.ad.internal.h.t.2
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a(str2);
                        }
                    });
                    return;
                }
                return;
            }
            aVar.a(str2);
            return;
        }
        File file = new File(com.beizi.ad.lance.a.h.d(context), f.a(str.substring(str.lastIndexOf("/") + 1)));
        final String absolutePath = (!file.exists() || file.length() <= 0) ? null : file.getAbsolutePath();
        if (!TextUtils.isEmpty(absolutePath)) {
            this.f12154b.put(str, absolutePath);
            if (z5) {
                if (c()) {
                    aVar.a(absolutePath);
                    return;
                }
                Handler handler2 = this.f12155c;
                if (handler2 != null) {
                    handler2.post(new Runnable() { // from class: com.beizi.ad.internal.h.t.3
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a(absolutePath);
                        }
                    });
                    return;
                }
                return;
            }
            aVar.a(absolutePath);
            return;
        }
        this.f12153a.submit(new Runnable() { // from class: com.beizi.ad.internal.h.t.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InputStream inputStream = ((HttpURLConnection) new URL(str).openConnection()).getInputStream();
                    String str3 = str;
                    File file2 = new File(com.beizi.ad.lance.a.h.d(context), f.a(str3.substring(str3.lastIndexOf("/") + 1)));
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    }
                    final String absolutePath2 = file2.getAbsolutePath();
                    if (!z5) {
                        aVar.a(absolutePath2);
                    } else if (t.this.f12155c != null) {
                        t.this.f12155c.post(new Runnable() { // from class: com.beizi.ad.internal.h.t.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar.a(absolutePath2);
                            }
                        });
                    }
                    t.this.f12154b.put(str, absolutePath2);
                    fileOutputStream.close();
                    inputStream.close();
                    bufferedInputStream.close();
                } catch (Exception unused) {
                    aVar.a();
                }
                com.beizi.ad.lance.a.h.e(context);
            }
        });
    }
}
