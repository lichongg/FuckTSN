package com.bxkj.student.common.download;

import android.content.ContextWrapper;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.bxkj.base.BaseApp;
import java.io.File;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static a f17735d;

    /* renamed from: b, reason: collision with root package name */
    private d f17737b;

    /* renamed from: c, reason: collision with root package name */
    Handler f17738c = new HandlerC0201a();

    /* renamed from: a, reason: collision with root package name */
    private final OkHttpClient f17736a = new OkHttpClient();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.student.common.download.a$a, reason: collision with other inner class name */
    class HandlerC0201a extends Handler {
        HandlerC0201a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int i6 = msg.what;
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 == 4 && a.this.f17737b != null) {
                        a.this.f17737b.onDownloadFailed();
                        return;
                    }
                    return;
                }
                if (a.this.f17737b != null) {
                    a.this.f17737b.a((File) msg.obj);
                    return;
                }
                return;
            }
            long j6 = msg.getData().getLong("total");
            long j7 = msg.getData().getLong("sum");
            int i7 = msg.getData().getInt(NotificationCompat.CATEGORY_PROGRESS);
            if (a.this.f17737b != null) {
                a.this.f17737b.b(j6, j7, i7);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17740a;

        b(final String val$url) {
            this.f17740a = val$url;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e6) {
            a.this.f17738c.sendEmptyMessage(4);
            e6.printStackTrace();
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x00cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:47:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onResponse(okhttp3.Call r11, okhttp3.Response r12) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 211
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.download.a.b.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17742a;

        c(final String val$fileName) {
            this.f17742a = val$fileName;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e6) {
            a.this.f17738c.sendEmptyMessage(4);
            e6.printStackTrace();
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:47:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onResponse(okhttp3.Call r11, okhttp3.Response r12) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 205
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.download.a.c.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void a(File file);

        void b(long totalSize, long bytesWritten, int progress);

        void onDownloadFailed();
    }

    public static a f() {
        if (f17735d == null) {
            f17735d = new a();
        }
        return f17735d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public String g(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h() throws IOException {
        File externalFilesDir = new ContextWrapper(BaseApp.c()).getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (!externalFilesDir.mkdirs()) {
            externalFilesDir.createNewFile();
        }
        return externalFilesDir.getAbsolutePath();
    }

    public void d(final String url, final d listener) {
        this.f17737b = listener;
        this.f17736a.newCall(new Request.Builder().url(url).cacheControl(CacheControl.FORCE_NETWORK).build()).enqueue(new b(url));
    }

    public void e(final String url, final String fileName, final d listener) {
        this.f17737b = listener;
        this.f17736a.newCall(new Request.Builder().url(url).cacheControl(CacheControl.FORCE_NETWORK).build()).enqueue(new c(fileName));
    }

    private a() {
    }
}
