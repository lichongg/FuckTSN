package cn.bluemobi.dylan.base.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import androidx.collection.LruCache;
import cn.bluemobi.dylan.base.utils.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ImageLoader {

    /* renamed from: k, reason: collision with root package name */
    private static ImageLoader f1174k = null;

    /* renamed from: l, reason: collision with root package name */
    private static final int f1175l = 1;

    /* renamed from: m, reason: collision with root package name */
    private static final String f1176m = "ImageLoader";

    /* renamed from: a, reason: collision with root package name */
    private LruCache<String, Bitmap> f1177a;

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f1178b;

    /* renamed from: d, reason: collision with root package name */
    private LinkedList<Runnable> f1180d;

    /* renamed from: e, reason: collision with root package name */
    private Thread f1181e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f1182f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f1183g;

    /* renamed from: i, reason: collision with root package name */
    private Semaphore f1185i;

    /* renamed from: c, reason: collision with root package name */
    private Type f1179c = Type.LIFO;

    /* renamed from: h, reason: collision with root package name */
    private Semaphore f1184h = new Semaphore(0);

    /* renamed from: j, reason: collision with root package name */
    private boolean f1186j = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Type {
        FIFO,
        LIFO
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends LruCache<String, Bitmap> {
        a(int i6) {
            super(i6);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends Thread {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends Handler {
            a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ImageLoader.this.f1178b.execute(ImageLoader.this.r());
                try {
                    ImageLoader.this.f1185i.acquire();
                } catch (InterruptedException unused) {
                }
            }
        }

        b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            ImageLoader.this.f1182f = new a();
            ImageLoader.this.f1184h.release();
            Looper.loop();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            Bitmap bitmap = eVar.f1195a;
            ImageView imageView = eVar.f1196b;
            if (imageView.getTag().toString().equals(eVar.f1197c)) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f1191a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f1192b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f1193c;

        d(boolean z5, ImageView imageView, String str) {
            this.f1191a = z5;
            this.f1192b = imageView;
            this.f1193c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap v5;
            if (this.f1191a) {
                File o5 = ImageLoader.this.o(this.f1192b.getContext(), ImageLoader.this.w(this.f1193c));
                if (o5.exists()) {
                    v5 = ImageLoader.this.v(o5.getAbsolutePath(), this.f1192b);
                } else if (!ImageLoader.this.f1186j) {
                    v5 = cn.bluemobi.dylan.base.utils.e.b(this.f1193c, this.f1192b);
                } else if (cn.bluemobi.dylan.base.utils.e.c(this.f1193c, o5)) {
                    o5.getAbsolutePath();
                    v5 = ImageLoader.this.v(o5.getAbsolutePath(), this.f1192b);
                } else {
                    v5 = null;
                }
            } else {
                v5 = ImageLoader.this.v(this.f1193c, this.f1192b);
            }
            ImageLoader.this.i(this.f1193c, v5);
            ImageLoader.this.x(this.f1193c, this.f1192b, v5);
            ImageLoader.this.f1185i.release();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class e {

        /* renamed from: a, reason: collision with root package name */
        Bitmap f1195a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f1196b;

        /* renamed from: c, reason: collision with root package name */
        String f1197c;

        private e() {
        }

        /* synthetic */ e(ImageLoader imageLoader, a aVar) {
            this();
        }
    }

    private synchronized void j(Runnable runnable) {
        this.f1180d.add(runnable);
        try {
            if (this.f1182f == null) {
                this.f1184h.acquire();
            }
        } catch (InterruptedException unused) {
        }
        this.f1182f.sendEmptyMessage(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME);
    }

    private Runnable k(String str, ImageView imageView, boolean z5) {
        return new d(z5, imageView, str);
    }

    private Bitmap n(String str) {
        return this.f1177a.get(str);
    }

    public static ImageLoader p() {
        if (f1174k == null) {
            synchronized (ImageLoader.class) {
                try {
                    if (f1174k == null) {
                        f1174k = new ImageLoader(1, Type.LIFO);
                    }
                } finally {
                }
            }
        }
        return f1174k;
    }

    public static ImageLoader q(int i6, Type type) {
        if (f1174k == null) {
            synchronized (ImageLoader.class) {
                try {
                    if (f1174k == null) {
                        f1174k = new ImageLoader(i6, type);
                    }
                } finally {
                }
            }
        }
        return f1174k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable r() {
        Type type = this.f1179c;
        if (type == Type.FIFO) {
            return this.f1180d.removeFirst();
        }
        if (type == Type.LIFO) {
            return this.f1180d.removeLast();
        }
        return null;
    }

    private void t() {
        b bVar = new b();
        this.f1181e = bVar;
        bVar.start();
    }

    public String l(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b6 : bArr) {
            String hexString = Integer.toHexString(b6 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    protected Bitmap m(String str, int i6, int i7) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = i.a(options, i6, i7);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public File o(Context context, String str) {
        return new File(("mounted".equals(Environment.getExternalStorageState()) ? context.getExternalCacheDir().getPath() : context.getCacheDir().getPath()) + File.separator + str);
    }

    public String w(String str) {
        try {
            return l(MessageDigest.getInstance(TKDownloadReason.KSAD_TK_MD5).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private ImageLoader(int i6, Type type) {
        s(i6, type);
    }

    private void s(int i6, Type type) {
        t();
        this.f1177a = new a(((int) Runtime.getRuntime().maxMemory()) / 8);
        this.f1178b = Executors.newFixedThreadPool(i6);
        this.f1180d = new LinkedList<>();
        this.f1179c = type;
        this.f1185i = new Semaphore(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap v(String str, ImageView imageView) {
        i.a c6 = i.c(imageView);
        return m(str, c6.f1226a, c6.f1227b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, ImageView imageView, Bitmap bitmap) {
        Message obtain = Message.obtain();
        e eVar = new e(this, null);
        eVar.f1195a = bitmap;
        eVar.f1197c = str;
        eVar.f1196b = imageView;
        obtain.obj = eVar;
        this.f1183g.sendMessage(obtain);
    }

    protected void i(String str, Bitmap bitmap) {
        if (n(str) == null && bitmap != null) {
            this.f1177a.put(str, bitmap);
        }
    }

    public void u(String str, ImageView imageView, boolean z5) {
        imageView.setTag(str);
        if (this.f1183g == null) {
            this.f1183g = new c();
        }
        Bitmap n6 = n(str);
        if (n6 != null) {
            x(str, imageView, n6);
        } else {
            j(k(str, imageView, z5));
        }
    }
}
