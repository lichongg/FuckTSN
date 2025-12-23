package com.bxkj.base.util;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static f f16596b;

    /* renamed from: a, reason: collision with root package name */
    private final OkHttpClient f16597a = new OkHttpClient();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f16598a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16599b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16600c;

        a(c cVar, String str, String str2) {
            this.f16598a = cVar;
            this.f16599b = str;
            this.f16600c = str2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f16598a.sendEmptyMessage(4);
            iOException.printStackTrace();
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:47:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onResponse(okhttp3.Call r11, okhttp3.Response r12) throws java.io.IOException {
            /*
                r10 = this;
                r11 = 2048(0x800, float:2.87E-42)
                byte[] r11 = new byte[r11]
                com.bxkj.base.util.f r0 = com.bxkj.base.util.f.this
                java.lang.String r1 = r10.f16599b
                java.lang.String r0 = com.bxkj.base.util.f.b(r0, r1)
                r1 = 0
                okhttp3.ResponseBody r2 = r12.body()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L97
                java.io.InputStream r2 = r2.byteStream()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L97
                okhttp3.ResponseBody r12 = r12.body()     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L91
                long r3 = r12.contentLength()     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L91
                java.io.File r12 = new java.io.File     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L91
                com.bxkj.base.util.f r5 = com.bxkj.base.util.f.this     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L91
                java.lang.String r6 = r10.f16600c     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L91
                java.lang.String r5 = com.bxkj.base.util.f.a(r5, r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L91
                r12.<init>(r0, r5)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L91
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L91
                r0.<init>(r12)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L91
                r5 = 0
            L31:
                int r1 = r2.read(r11)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                r7 = -1
                if (r1 == r7) goto L75
                r7 = 0
                r0.write(r11, r7, r1)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                long r7 = (long) r1     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                long r5 = r5 + r7
                float r1 = (float) r5     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                r7 = 1065353216(0x3f800000, float:1.0)
                float r1 = r1 * r7
                float r7 = (float) r3     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                float r1 = r1 / r7
                r7 = 1120403456(0x42c80000, float:100.0)
                float r1 = r1 * r7
                int r1 = (int) r1     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                android.os.Message r7 = new android.os.Message     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                r7.<init>()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                android.os.Bundle r8 = new android.os.Bundle     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                r8.<init>()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                java.lang.String r9 = "total"
                r8.putLong(r9, r3)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                java.lang.String r9 = "sum"
                r8.putLong(r9, r5)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                java.lang.String r9 = "progress"
                r8.putInt(r9, r1)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                r7.setData(r8)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                r1 = 2
                r7.what = r1     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                com.bxkj.base.util.f$c r1 = r10.f16598a     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                r1.sendMessage(r7)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                goto L31
            L6f:
                r11 = move-exception
            L70:
                r1 = r2
                goto Lae
            L72:
                r11 = move-exception
            L73:
                r1 = r2
                goto L99
            L75:
                r0.flush()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                android.os.Message r11 = new android.os.Message     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                r11.<init>()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                r11.obj = r12     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                r12 = 3
                r11.what = r12     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                com.bxkj.base.util.f$c r12 = r10.f16598a     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                r12.sendMessage(r11)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
                r2.close()     // Catch: java.io.IOException -> L8a
            L8a:
                r0.close()     // Catch: java.io.IOException -> Lac
                goto Lac
            L8e:
                r11 = move-exception
                r0 = r1
                goto L70
            L91:
                r11 = move-exception
                r0 = r1
                goto L73
            L94:
                r11 = move-exception
                r0 = r1
                goto Lae
            L97:
                r11 = move-exception
                r0 = r1
            L99:
                r11.printStackTrace()     // Catch: java.lang.Throwable -> Lad
                com.bxkj.base.util.f$c r11 = r10.f16598a     // Catch: java.lang.Throwable -> Lad
                r12 = 4
                r11.sendEmptyMessage(r12)     // Catch: java.lang.Throwable -> Lad
                if (r1 == 0) goto La9
                r1.close()     // Catch: java.io.IOException -> La8
                goto La9
            La8:
            La9:
                if (r0 == 0) goto Lac
                goto L8a
            Lac:
                return
            Lad:
                r11 = move-exception
            Lae:
                if (r1 == 0) goto Lb5
                r1.close()     // Catch: java.io.IOException -> Lb4
                goto Lb5
            Lb4:
            Lb5:
                if (r0 == 0) goto Lba
                r0.close()     // Catch: java.io.IOException -> Lba
            Lba:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.util.f.a.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private b f16602a;

        public c(b bVar) {
            this.f16602a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar;
            super.handleMessage(message);
            int i6 = message.what;
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 == 4 && (bVar = this.f16602a) != null) {
                        bVar.a();
                        return;
                    }
                    return;
                }
                b bVar2 = this.f16602a;
                if (bVar2 != null) {
                    bVar2.b((File) message.obj);
                    return;
                }
                return;
            }
            long j6 = message.getData().getLong("total");
            long j7 = message.getData().getLong("sum");
            int i7 = message.getData().getInt(NotificationCompat.CATEGORY_PROGRESS);
            b bVar3 = this.f16602a;
            if (bVar3 != null) {
                bVar3.c(j6, j7, i7);
            }
        }
    }

    public static f d() {
        if (f16596b == null) {
            f16596b = new f();
        }
        return f16596b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public String e(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(String str) throws IOException {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (!file.mkdirs()) {
            file.createNewFile();
        }
        return file.getAbsolutePath();
    }

    private f() {
    }

    public void c(String str, String str2, b bVar) {
        if (cn.bluemobi.dylan.base.utils.u.b0(str)) {
            return;
        }
        this.f16597a.newCall(new Request.Builder().url(str).build()).enqueue(new a(new c(bVar), str2, str));
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class b {
        public abstract void b(File file);

        public void a() {
        }

        public void c(long j6, long j7, int i6) {
        }
    }
}
