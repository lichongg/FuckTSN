package top.zibin.luban;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class c implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private static final String f54629d = "Luban";

    /* renamed from: e, reason: collision with root package name */
    private static final String f54630e = "luban_disk_cache";

    /* renamed from: f, reason: collision with root package name */
    private static final int f54631f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static final int f54632g = 1;

    /* renamed from: h, reason: collision with root package name */
    private static final int f54633h = 2;

    /* renamed from: a, reason: collision with root package name */
    private File f54634a;

    /* renamed from: b, reason: collision with root package name */
    private d f54635b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f54636c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f54637a;

        a(Context context) {
            this.f54637a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.this.f54636c.sendMessage(c.this.f54636c.obtainMessage(1));
                c.this.f54636c.sendMessage(c.this.f54636c.obtainMessage(0, new top.zibin.luban.b(c.this.f54634a, c.this.i(this.f54637a)).a()));
            } catch (IOException e6) {
                c.this.f54636c.sendMessage(c.this.f54636c.obtainMessage(2, e6));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Context f54639a;

        /* renamed from: b, reason: collision with root package name */
        private File f54640b;

        /* renamed from: c, reason: collision with root package name */
        private d f54641c;

        private c c() {
            return new c(this, null);
        }

        public b f(File file) {
            this.f54640b = file;
            return this;
        }

        public b h(d dVar) {
            this.f54641c = dVar;
            return this;
        }

        b(Context context) {
            this.f54639a = context;
        }

        public File d() throws IOException {
            return c().f(this.f54639a);
        }

        public void e() {
            c().j(this.f54639a);
        }

        public b g(int i6) {
            return this;
        }
    }

    /* synthetic */ c(b bVar, a aVar) {
        this(bVar);
    }

    private c(b bVar) {
        this.f54634a = bVar.f54640b;
        this.f54635b = bVar.f54641c;
        this.f54636c = new Handler(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public File f(Context context) throws IOException {
        return new top.zibin.luban.b(this.f54634a, i(context)).a();
    }

    @Nullable
    private File g(Context context) {
        return h(context, f54630e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void j(Context context) {
        d dVar;
        if (this.f54634a == null && (dVar = this.f54635b) != null) {
            dVar.onError(new NullPointerException("image file cannot be null"));
        }
        new Thread(new a(context)).start();
    }

    public static b k(Context context) {
        return new b(context);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        d dVar = this.f54635b;
        if (dVar == null) {
            return false;
        }
        int i6 = message.what;
        if (i6 == 0) {
            dVar.a((File) message.obj);
        } else if (i6 == 1) {
            dVar.onStart();
        } else if (i6 == 2) {
            dVar.onError((Throwable) message.obj);
        }
        return false;
    }

    @Nullable
    private File h(Context context, String str) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            File file = new File(externalCacheDir, str);
            if (!file.mkdirs() && (!file.exists() || !file.isDirectory())) {
                return null;
            }
            return file;
        }
        Log.isLoggable(f54629d, 6);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File i(Context context) {
        if (g(context) != null) {
            return new File(g(context) + "/" + System.currentTimeMillis() + ((int) (Math.random() * 1000.0d)) + ".jpg");
        }
        return null;
    }
}
