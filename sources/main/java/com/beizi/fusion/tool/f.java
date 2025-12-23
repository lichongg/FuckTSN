package com.beizi.fusion.tool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.baidu.mobads.sdk.internal.by;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static Context f13685a;

    /* renamed from: e, reason: collision with root package name */
    private static f f13686e;

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f13687b = Executors.newFixedThreadPool(4);

    /* renamed from: c, reason: collision with root package name */
    private LruCache<String, Bitmap> f13688c = new LruCache<>(4194304);

    /* renamed from: d, reason: collision with root package name */
    private Handler f13689d = new Handler();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();

        void a(Bitmap bitmap);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        String f13700a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f13701b;

        public void a(ImageView imageView) {
            this.f13701b = imageView;
            if (TextUtils.isEmpty(this.f13700a)) {
                return;
            }
            Bitmap bitmap = (Bitmap) f.this.f13688c.get(this.f13700a);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            Bitmap a6 = a();
            if (a6 == null) {
                f.this.f13687b.submit(this);
            } else {
                imageView.setImageBitmap(a6);
                f.this.f13688c.put(this.f13700a, a6);
            }
        }

        public b(String str) {
            this.f13700a = str;
        }

        private void b() {
            f.this.f13689d.post(new Runnable() { // from class: com.beizi.fusion.tool.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f13700a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                if (httpURLConnection.getResponseCode() != 200) {
                    b();
                    return;
                }
                final Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                f.this.f13689d.post(new Runnable() { // from class: com.beizi.fusion.tool.f.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.f13701b.setImageBitmap(decodeStream);
                    }
                });
                f.this.f13688c.put(this.f13700a, decodeStream);
                String str = this.f13700a;
                File file = new File(g.b(f.f13685a), f.c(str.substring(str.lastIndexOf("/") + 1)));
                aa.a("BeiZis", "BeiZiImageUtils run file == " + file);
                decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file));
            } catch (FileNotFoundException unused) {
            } catch (Exception e6) {
                e6.printStackTrace();
                b();
            }
        }

        private Bitmap a() {
            String str = this.f13700a;
            File file = new File(g.b(f.f13685a), f.c(str.substring(str.lastIndexOf("/") + 1)));
            aa.a("BeiZis", "BeiZiImageUtils getBitmapFile file == " + file);
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static f a(Context context) {
        if (context == null) {
            ap.b("Illegal Argument: context is null");
        } else {
            f13685a = context;
        }
        return b();
    }

    private static f b() {
        if (f13686e == null) {
            synchronized (f.class) {
                try {
                    if (f13686e == null) {
                        f13686e = new f();
                    }
                } finally {
                }
            }
        }
        return f13686e;
    }

    public b a(String str) {
        return new b(str);
    }

    public void a(final String str, final a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.f13688c.get(str);
        if (bitmap != null) {
            aVar.a(bitmap);
            return;
        }
        File file = new File(g.b(f13685a), c(str.substring(str.lastIndexOf("/") + 1)));
        Bitmap decodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (decodeFile != null) {
            this.f13688c.put(str, decodeFile);
            aVar.a(decodeFile);
        } else {
            this.f13687b.submit(new Runnable() { // from class: com.beizi.fusion.tool.f.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(5000);
                        httpURLConnection.setReadTimeout(5000);
                        if (httpURLConnection.getResponseCode() == 200) {
                            final Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                            httpURLConnection.disconnect();
                            f.this.f13689d.post(new Runnable() { // from class: com.beizi.fusion.tool.f.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.a(decodeStream);
                                }
                            });
                            f.this.f13688c.put(str, decodeStream);
                            String str2 = str;
                            decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(g.b(f.f13685a), f.c(str2.substring(str2.lastIndexOf("/") + 1)))));
                        }
                    } catch (Exception unused) {
                        f.this.f13689d.post(new Runnable() { // from class: com.beizi.fusion.tool.f.1.2
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

    public void b(final String str, final a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.f13688c.get(str);
        if (bitmap != null) {
            aVar.a(bitmap);
            return;
        }
        File file = new File(g.b(f13685a), c(str.substring(str.lastIndexOf("/") + 1)));
        Bitmap decodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (decodeFile != null) {
            this.f13688c.put(str, decodeFile);
            aVar.a(decodeFile);
        } else {
            this.f13687b.submit(new Runnable() { // from class: com.beizi.fusion.tool.f.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(5000);
                        httpURLConnection.setReadTimeout(5000);
                        if (httpURLConnection.getResponseCode() == 200) {
                            Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                            httpURLConnection.disconnect();
                            f.this.f13688c.put(str, decodeStream);
                            String str2 = str;
                            decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(g.b(f.f13685a), f.c(str2.substring(str2.lastIndexOf("/") + 1)))));
                        }
                    } catch (Exception unused) {
                        f.this.f13689d.post(new Runnable() { // from class: com.beizi.fusion.tool.f.2.1
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

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b6 : bArr) {
            int i6 = (b6 >>> 4) & 15;
            int i7 = 0;
            while (true) {
                sb.append((char) ((i6 < 0 || i6 > 9) ? i6 + 87 : i6 + 48));
                i6 = b6 & 15;
                int i8 = i7 + 1;
                if (i7 >= 1) {
                    break;
                }
                i7 = i8;
            }
        }
        return sb.toString();
    }
}
