package com.beizi.ad.internal.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.collection.LruCache;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static Context f12081a;

    /* renamed from: e, reason: collision with root package name */
    private static i f12082e;

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f12083b = Executors.newFixedThreadPool(4);

    /* renamed from: c, reason: collision with root package name */
    private LruCache<String, Bitmap> f12084c = new LruCache<>(4194304);

    /* renamed from: d, reason: collision with root package name */
    private Handler f12085d = new Handler(Looper.getMainLooper());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();

        void a(Bitmap bitmap);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        String f12108a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f12109b;

        public void a(ImageView imageView) {
            this.f12109b = imageView;
            if (TextUtils.isEmpty(this.f12108a)) {
                return;
            }
            Bitmap bitmap = (Bitmap) i.this.f12084c.get(this.f12108a);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            Bitmap a6 = a();
            if (a6 == null) {
                i.this.f12083b.submit(this);
            } else {
                imageView.setImageBitmap(a6);
                i.this.f12084c.put(this.f12108a, a6);
            }
        }

        public b(String str) {
            this.f12108a = str;
        }

        private void b() {
            i.this.f12085d.post(new Runnable() { // from class: com.beizi.ad.internal.h.i.b.2
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f12108a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(2000);
                if (httpURLConnection.getResponseCode() != 200) {
                    b();
                    return;
                }
                final Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                i.this.f12085d.post(new Runnable() { // from class: com.beizi.ad.internal.h.i.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.f12109b.setImageBitmap(decodeStream);
                    }
                });
                i.this.f12084c.put(this.f12108a, decodeStream);
                String str = this.f12108a;
                decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(com.beizi.ad.lance.a.h.c(i.f12081a), f.a(str.substring(str.lastIndexOf("/") + 1)))));
            } catch (FileNotFoundException unused) {
            } catch (Exception e6) {
                e6.printStackTrace();
                b();
            }
        }

        private Bitmap a() {
            String str = this.f12108a;
            File file = new File(com.beizi.ad.lance.a.h.c(i.f12081a), f.a(str.substring(str.lastIndexOf("/") + 1)));
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }
    }

    private static i b() {
        if (f12082e == null) {
            synchronized (i.class) {
                try {
                    if (f12082e == null) {
                        f12082e = new i();
                    }
                } finally {
                }
            }
        }
        return f12082e;
    }

    private boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static i a(Context context) {
        if (com.beizi.ad.internal.h.a().f12002j != null) {
            f12081a = com.beizi.ad.internal.h.a().f12002j;
        } else {
            f12081a = context;
        }
        return b();
    }

    public b a(String str) {
        return new b(str);
    }

    public void a(final String str, final a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.f12084c.get(str);
        if (bitmap != null) {
            aVar.a(bitmap);
            return;
        }
        File file = new File(com.beizi.ad.lance.a.h.d(f12081a), f.a(str.substring(str.lastIndexOf("/") + 1)));
        Bitmap decodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (decodeFile != null) {
            this.f12084c.put(str, decodeFile);
            aVar.a(decodeFile);
        } else {
            this.f12083b.submit(new Runnable() { // from class: com.beizi.ad.internal.h.i.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(2000);
                        if (httpURLConnection.getResponseCode() == 200) {
                            final Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                            httpURLConnection.disconnect();
                            i.this.f12085d.post(new Runnable() { // from class: com.beizi.ad.internal.h.i.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.a(decodeStream);
                                }
                            });
                            i.this.f12084c.put(str, decodeStream);
                            String str2 = str;
                            decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(com.beizi.ad.lance.a.h.d(i.f12081a), f.a(str2.substring(str2.lastIndexOf("/") + 1)))));
                        }
                    } catch (Exception unused) {
                        i.this.f12085d.post(new Runnable() { // from class: com.beizi.ad.internal.h.i.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar.a();
                            }
                        });
                    }
                    com.beizi.ad.lance.a.h.e(i.f12081a);
                }
            });
        }
    }

    public void b(final String str, final a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.f12084c.get(str);
        if (bitmap != null) {
            aVar.a(bitmap);
            return;
        }
        File file = new File(com.beizi.ad.lance.a.h.c(f12081a), f.a(str.substring(str.lastIndexOf("/") + 1)));
        Bitmap decodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (decodeFile != null) {
            this.f12084c.put(str, decodeFile);
            aVar.a(decodeFile);
        } else {
            this.f12083b.submit(new Runnable() { // from class: com.beizi.ad.internal.h.i.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(2000);
                        if (httpURLConnection.getResponseCode() == 200) {
                            Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                            httpURLConnection.disconnect();
                            i.this.f12084c.put(str, decodeStream);
                            String str2 = str;
                            decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(com.beizi.ad.lance.a.h.c(i.f12081a), f.a(str2.substring(str2.lastIndexOf("/") + 1)))));
                        }
                    } catch (Exception unused) {
                        i.this.f12085d.post(new Runnable() { // from class: com.beizi.ad.internal.h.i.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar.a();
                            }
                        });
                    }
                }
            });
        }
    }

    public void a(final String str, final boolean z5, final a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final Bitmap bitmap = this.f12084c.get(str);
        if (bitmap != null) {
            if (z5) {
                if (c()) {
                    aVar.a(bitmap);
                    return;
                }
                Handler handler = this.f12085d;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.beizi.ad.internal.h.i.2
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a(bitmap);
                        }
                    });
                    return;
                }
                return;
            }
            aVar.a(bitmap);
            return;
        }
        File file = new File(com.beizi.ad.lance.a.h.d(f12081a), f.a(str.substring(str.lastIndexOf("/") + 1)));
        final Bitmap decodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (decodeFile != null) {
            this.f12084c.put(str, decodeFile);
            if (z5) {
                if (c()) {
                    aVar.a(decodeFile);
                    return;
                }
                Handler handler2 = this.f12085d;
                if (handler2 != null) {
                    handler2.post(new Runnable() { // from class: com.beizi.ad.internal.h.i.3
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a(decodeFile);
                        }
                    });
                    return;
                }
                return;
            }
            aVar.a(decodeFile);
            return;
        }
        this.f12083b.submit(new Runnable() { // from class: com.beizi.ad.internal.h.i.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(2000);
                    if (httpURLConnection.getResponseCode() == 200) {
                        final Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                        httpURLConnection.disconnect();
                        if (!z5) {
                            aVar.a(decodeStream);
                        } else if (i.this.f12085d != null) {
                            i.this.f12085d.post(new Runnable() { // from class: com.beizi.ad.internal.h.i.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.a(decodeStream);
                                }
                            });
                        }
                        i.this.f12084c.put(str, decodeStream);
                        String str2 = str;
                        decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(com.beizi.ad.lance.a.h.d(i.f12081a), f.a(str2.substring(str2.lastIndexOf("/") + 1)))));
                    }
                } catch (Exception unused) {
                    aVar.a();
                }
                com.beizi.ad.lance.a.h.e(i.f12081a);
            }
        });
    }
}
