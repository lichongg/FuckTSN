package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.utils.EngineThreadPool;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import com.bytedance.sdk.openadsdk.api.plugin.xt;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class d implements b {

    /* renamed from: a, reason: collision with root package name */
    private com.bykv.vk.component.ttvideo.log.a f22894a;

    /* renamed from: c, reason: collision with root package name */
    private c f22896c;

    /* renamed from: e, reason: collision with root package name */
    private String f22898e;

    /* renamed from: f, reason: collision with root package name */
    private String f22899f;

    /* renamed from: j, reason: collision with root package name */
    private Context f22903j;

    /* renamed from: g, reason: collision with root package name */
    private int f22900g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f22901h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f22902i = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f22904k = -2147483648L;

    /* renamed from: b, reason: collision with root package name */
    private f f22895b = new f();

    /* renamed from: d, reason: collision with root package name */
    private boolean f22897d = true;

    private static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private f f22905a;

        /* renamed from: b, reason: collision with root package name */
        private Handler f22906b = new Handler(Looper.getMainLooper());

        /* renamed from: c, reason: collision with root package name */
        c f22907c;

        /* renamed from: com.bykv.vk.component.ttvideo.log.d$a$a, reason: collision with other inner class name */
        class RunnableC0303a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ JSONObject f22908a;

            RunnableC0303a(a aVar, JSONObject jSONObject) {
                this.f22908a = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.instance.a(false, this.f22908a);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            TTVideoEngineLog.i("VideoEventLoggerV2", "AyncGetLogDataRunnable enter");
            f fVar = this.f22905a;
            if (fVar == null) {
                TTVideoEngineLog.e("VideoEventLoggerV2", "rEvent is null, return.");
                return;
            }
            JSONObject a6 = fVar.a(this.f22907c);
            Handler handler = this.f22906b;
            if (handler == null || handler.getLooper() == null) {
                TTVideoEngineLog.i("VideoEventLoggerV2", "report in child thread");
                e.instance.a(false, a6);
            } else {
                TTVideoEngineLog.i("VideoEventLoggerV2", "report in main looper");
                this.f22906b.post(new RunnableC0303a(this, a6));
            }
        }

        public a(f fVar, d dVar, c cVar) {
            this.f22905a = fVar;
            this.f22907c = cVar;
        }
    }

    private void b() {
        this.f22902i = 0;
        this.f22897d = true;
        this.f22901h = 0;
        this.f22904k = -2147483648L;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c() {
        /*
            r5 = this;
            java.lang.String r0 = "VideoEventLoggerV2"
            java.lang.String r1 = "exception:"
            java.lang.String r2 = r5.f22898e
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto Lf
            java.lang.String r2 = r5.f22898e
            goto L19
        Lf:
            java.lang.String r2 = r5.f22899f
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L5f
            java.lang.String r2 = r5.f22899f
        L19:
            java.lang.String r3 = "UTF-8"
            java.lang.String r2 = java.net.URLDecoder.decode(r2, r3)     // Catch: java.lang.IllegalArgumentException -> L20 java.io.UnsupportedEncodingException -> L22
            goto L3e
        L20:
            r3 = move-exception
            goto L24
        L22:
            r3 = move-exception
            goto L38
        L24:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
        L29:
            java.lang.String r1 = r3.toString()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog.e(r0, r1)
            goto L3e
        L38:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            goto L29
        L3e:
            java.lang.String r0 = "&l="
            int r0 = r2.indexOf(r0)
            if (r0 <= 0) goto L5f
            int r1 = r0 + 1
            java.lang.String r3 = "&"
            int r1 = r2.indexOf(r3, r1)
            int r0 = r0 + 3
            if (r1 <= 0) goto L57
            java.lang.String r0 = r2.substring(r0, r1)
            goto L5b
        L57:
            java.lang.String r0 = r2.substring(r0)
        L5b:
            com.bykv.vk.component.ttvideo.log.f r1 = r5.f22895b
            r1.f22927o = r0
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.log.d.c():void");
    }

    private void d() {
        if (this.f22895b == null) {
            return;
        }
        TTVideoEngineLog.i("VideoEventLoggerV2", "sendEvent pt_new:" + this.f22895b.f22914b + ", mEvent:" + this.f22895b + ", eventBase:" + this.f22896c);
        if (this.f22895b.f22914b > 0 || this.f22904k > 0) {
            int i6 = this.f22900g;
            if (i6 > 0) {
                this.f22896c.f22893h = i6;
            }
            SharedPreferences xt = xt.xt(this.f22903j, "VideoEventLogger", 0);
            this.f22895b.f22928p = xt.getString("playersessionid", "");
            SharedPreferences.Editor edit = xt.edit();
            edit.putString("playersessionid", this.f22896c.f22891f);
            edit.apply();
            f fVar = this.f22895b;
            fVar.f22926n = this.f22896c.f22891f;
            fVar.f22920h = this.f22901h;
            String str = this.f22898e;
            if (str != null) {
                fVar.f22923k = str;
            }
            String str2 = this.f22899f;
            if (str2 != null) {
                fVar.f22924l = str2;
            }
            fVar.f22915c = fVar.f22914b;
            fVar.f22913a = this.f22904k;
            if (fVar.f22917e <= 0 && fVar.f22916d > 0) {
                fVar.f22917e = System.currentTimeMillis();
            }
            if (TextUtils.isEmpty(this.f22895b.f22927o)) {
                c();
            }
            EngineThreadPool.a().execute(new a(this.f22895b, this, this.f22896c));
            b();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a() {
        if (this.f22902i != 4) {
            this.f22902i = 2;
            this.f22897d = false;
            f fVar = this.f22895b;
            if (fVar.f22916d <= 0) {
                fVar.f22916d = System.currentTimeMillis();
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void reset() {
        this.f22897d = true;
        this.f22898e = null;
        this.f22899f = null;
        this.f22900g = 0;
        this.f22901h = 0;
        this.f22896c = new c(this.f22894a, this.f22903j);
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(int i6) {
        long currentTimeMillis = System.currentTimeMillis();
        if (i6 != 5) {
            int i7 = this.f22902i;
            if (i7 != 3 ? i7 != 4 : false) {
                this.f22896c.a();
            }
        }
        if (this.f22897d) {
            f fVar = this.f22895b;
            if (fVar.f22916d <= 0) {
                fVar.f22918f = currentTimeMillis;
                f(i6);
            }
        }
        this.f22895b.f22917e = currentTimeMillis;
        f(i6);
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void b(int i6) {
        this.f22895b.f22925m = i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    @Override // com.bykv.vk.component.ttvideo.log.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(int r10) {
        /*
            r9 = this;
            int r0 = r9.f22902i
            if (r0 != 0) goto L5
            return
        L5:
            long r0 = java.lang.System.currentTimeMillis()
            int r2 = r9.f22902i
            r3 = 4
            r4 = 0
            if (r2 != r3) goto L11
            r3 = 0
            goto L12
        L11:
            r3 = 1
        L12:
            r5 = 3
            if (r2 != r5) goto L16
            r3 = 0
        L16:
            r9.f22902i = r4
            boolean r2 = r9.f22897d
            if (r2 == 0) goto L35
            com.bykv.vk.component.ttvideo.log.f r2 = r9.f22895b
            long r4 = r2.f22914b
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L35
            long r4 = r2.f22916d
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L35
            long r4 = r2.f22918f
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L39
            r2.f22918f = r0
            goto L39
        L35:
            com.bykv.vk.component.ttvideo.log.f r2 = r9.f22895b
            r2.f22917e = r0
        L39:
            if (r3 == 0) goto L40
            com.bykv.vk.component.ttvideo.log.c r0 = r9.f22896c
            r0.a()
        L40:
            r9.f(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.log.d.c(int):void");
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void d(int i6) {
        long currentTimeMillis = System.currentTimeMillis();
        if (i6 == 10) {
            f fVar = this.f22895b;
            if (fVar.f22914b <= 0) {
                fVar.f22914b = currentTimeMillis;
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void e(int i6) {
        this.f22900g = i6;
        this.f22896c.f22893h = i6;
    }

    public d(Context context, com.bykv.vk.component.ttvideo.log.a aVar) {
        this.f22894a = aVar;
        this.f22896c = new c(aVar, context);
        this.f22903j = context;
    }

    private void f(int i6) {
        d();
        this.f22895b = new f();
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(long j6, String str) {
        this.f22902i = 1;
        this.f22896c.a(str);
        if (this.f22904k <= 0) {
            this.f22904k = j6;
        }
        this.f22897d = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    @Override // com.bykv.vk.component.ttvideo.log.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.bykv.vk.component.ttvideo.utils.Error r11, int r12) {
        /*
            r10 = this;
            long r0 = java.lang.System.currentTimeMillis()
            int r12 = r10.f22902i
            r2 = 0
            r3 = 1
            r4 = 4
            if (r12 != r4) goto Ld
            r5 = 0
            goto Le
        Ld:
            r5 = 1
        Le:
            r6 = 3
            if (r12 != r6) goto L12
            goto L13
        L12:
            r2 = r5
        L13:
            r12 = 5
            r10.f22902i = r12
            boolean r12 = r10.f22897d
            if (r12 == 0) goto L27
            com.bykv.vk.component.ttvideo.log.f r12 = r10.f22895b
            long r5 = r12.f22916d
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 > 0) goto L27
            r12.f22918f = r0
            goto L44
        L27:
            java.lang.String r12 = r11.f22936c
            java.lang.String r5 = "kTTVideoErrorDomainVideoOwnPlayer"
            boolean r12 = r12.equals(r5)
            if (r12 != 0) goto L3b
            java.lang.String r12 = r11.f22936c
            java.lang.String r5 = "kTTVideoErrorDomainVideoOSPlayer"
            boolean r12 = r12.equals(r5)
            if (r12 == 0) goto L40
        L3b:
            int r12 = r10.f22901h
            int r12 = r12 + r3
            r10.f22901h = r12
        L40:
            com.bykv.vk.component.ttvideo.log.f r12 = r10.f22895b
            r12.f22917e = r0
        L44:
            if (r2 == 0) goto L4b
            com.bykv.vk.component.ttvideo.log.c r12 = r10.f22896c
            r12.a()
        L4b:
            com.bykv.vk.component.ttvideo.log.f r12 = r10.f22895b
            int r0 = r11.getType()
            r12.f22921i = r0
            com.bykv.vk.component.ttvideo.log.f r12 = r10.f22895b
            int r11 = r11.f22934a
            r12.f22922j = r11
            r10.f(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.log.d.a(com.bykv.vk.component.ttvideo.utils.Error, int):void");
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(Error error, int i6, int i7) {
        if (error.f22936c.equals(Error.VideoOwnPlayer) || error.f22936c.equals(Error.VideoOSPlayer)) {
            this.f22901h++;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(String str) {
        if (this.f22896c == null || str == null || str.isEmpty()) {
            return;
        }
        this.f22896c.b(str);
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(String str, String str2) {
        this.f22898e = str;
        c cVar = this.f22896c;
        if (cVar != null) {
            cVar.f22892g = str;
        }
        this.f22899f = str2;
    }
}
