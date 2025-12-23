package com.bxkj.base.util.file;

import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f16604b;

    /* renamed from: a, reason: collision with root package name */
    private final OkHttpClient f16605a = new OkHttpClient();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.base.util.file.a$a, reason: collision with other inner class name */
    class C0188a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f16606a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16607b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16608c;

        C0188a(b bVar, String str, String str2) {
            this.f16606a = bVar;
            this.f16607b = str;
            this.f16608c = str2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f16606a.b(iOException);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x008a A[Catch: IOException -> 0x008d, TRY_LEAVE, TryCatch #7 {IOException -> 0x008d, blocks: (B:40:0x0085, B:35:0x008a), top: B:39:0x0085 }] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onResponse(okhttp3.Call r10, okhttp3.Response r11) throws java.io.IOException {
            /*
                r9 = this;
                r10 = 2048(0x800, float:2.87E-42)
                byte[] r10 = new byte[r10]
                java.io.File r0 = new java.io.File
                java.lang.String r1 = r9.f16607b
                r0.<init>(r1)
                boolean r1 = r0.exists()
                if (r1 != 0) goto L14
                r0.mkdirs()
            L14:
                java.io.File r1 = new java.io.File
                java.lang.String r2 = r9.f16608c
                r1.<init>(r0, r2)
                r0 = 0
                okhttp3.ResponseBody r2 = r11.body()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L70
                java.io.InputStream r2 = r2.byteStream()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L70
                okhttp3.ResponseBody r11 = r11.body()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
                long r3 = r11.contentLength()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
                java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
                r11.<init>(r1)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
                r5 = 0
            L33:
                int r0 = r2.read(r10)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
                r7 = -1
                if (r0 == r7) goto L58
                r7 = 0
                r11.write(r10, r7, r0)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
                long r7 = (long) r0     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
                long r5 = r5 + r7
                float r0 = (float) r5     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
                r7 = 1065353216(0x3f800000, float:1.0)
                float r0 = r0 * r7
                float r7 = (float) r3     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
                float r0 = r0 / r7
                r7 = 1120403456(0x42c80000, float:100.0)
                float r0 = r0 * r7
                int r0 = (int) r0     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
                com.bxkj.base.util.file.a$b r7 = r9.f16606a     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
                r7.c(r0)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
                goto L33
            L52:
                r10 = move-exception
            L53:
                r0 = r2
                goto L83
            L55:
                r10 = move-exception
            L56:
                r0 = r2
                goto L72
            L58:
                r11.flush()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
                com.bxkj.base.util.file.a$b r10 = r9.f16606a     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
                r10.a(r1)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
                r2.close()     // Catch: java.io.IOException -> L81
                r11.close()     // Catch: java.io.IOException -> L81
                return
            L67:
                r10 = move-exception
                r11 = r0
                goto L53
            L6a:
                r10 = move-exception
                r11 = r0
                goto L56
            L6d:
                r10 = move-exception
                r11 = r0
                goto L83
            L70:
                r10 = move-exception
                r11 = r0
            L72:
                com.bxkj.base.util.file.a$b r1 = r9.f16606a     // Catch: java.lang.Throwable -> L82
                r1.b(r10)     // Catch: java.lang.Throwable -> L82
                if (r0 == 0) goto L7c
                r0.close()     // Catch: java.io.IOException -> L81
            L7c:
                if (r11 == 0) goto L81
                r11.close()     // Catch: java.io.IOException -> L81
            L81:
                return
            L82:
                r10 = move-exception
            L83:
                if (r0 == 0) goto L88
                r0.close()     // Catch: java.io.IOException -> L8d
            L88:
                if (r11 == 0) goto L8d
                r11.close()     // Catch: java.io.IOException -> L8d
            L8d:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.util.file.a.C0188a.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(File file);

        void b(Exception exc);

        void c(int i6);
    }

    public static a b() {
        if (f16604b == null) {
            f16604b = new a();
        }
        return f16604b;
    }

    public void a(String str, String str2, String str3, b bVar) {
        Request build = new Request.Builder().url(str).build();
        try {
            new OkHttpClient().newCall(build).execute();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        this.f16605a.newCall(build).enqueue(new C0188a(bVar, str2, str3));
    }
}
