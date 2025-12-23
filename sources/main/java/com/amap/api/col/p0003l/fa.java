package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkRequest;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class fa {

    /* renamed from: a, reason: collision with root package name */
    private Context f6197a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<IAMapDelegate> f6198b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f6199c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f6200d;

    /* renamed from: e, reason: collision with root package name */
    private c f6201e;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f6202f = new a();

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f6203g = new b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (fa.this.f6201e == null) {
                fa faVar = fa.this;
                faVar.f6201e = new c(faVar.f6197a, fa.this);
            }
            z2.a().b(fa.this.f6201e);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            IAMapDelegate iAMapDelegate = (IAMapDelegate) fa.this.f6198b.get();
            if (iAMapDelegate != null) {
                iAMapDelegate.setTerrainAuth(false);
            }
            i2.b(fa.this.f6197a, "地形图鉴权失败，当前key没有地形图的使用权限，地形图，将不会呈现！");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c extends b8 {

        /* renamed from: d, reason: collision with root package name */
        private Context f6206d;

        /* renamed from: e, reason: collision with root package name */
        private fa f6207e;

        /* renamed from: g, reason: collision with root package name */
        private d f6208g;

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            try {
                e m6 = this.f6208g.m();
                if (m6 == null) {
                    this.f6207e.d(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
                } else {
                    if (m6.f6213d) {
                        return;
                    }
                    this.f6207e.h();
                }
            } catch (fc e6) {
                e6.printStackTrace();
                this.f6207e.d(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
            }
        }

        public c(Context context, fa faVar) {
            this.f6206d = context;
            this.f6207e = faVar;
            this.f6208g = new d(context, "");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d extends y3<String, e> {

        /* renamed from: w, reason: collision with root package name */
        private boolean f6209w;

        private static e p(byte[] bArr) throws fc {
            String str;
            try {
                str = new String(bArr, "utf-8");
            } catch (Exception e6) {
                e6.printStackTrace();
                str = null;
            }
            if (str == null || "".equals(str)) {
                return null;
            }
            return o(str);
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final boolean isSupportIPV6() {
            return true;
        }

        @Override // com.amap.api.col.p0003l.y3
        protected final String l() {
            return null;
        }

        private static e o(String str) throws fc {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("info");
                String optString2 = jSONObject.optString("infocode");
                String optString3 = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
                boolean z5 = false;
                z5 = false;
                e eVar = new e(z5 ? (byte) 1 : (byte) 0);
                eVar.f6210a = optString;
                eVar.f6211b = optString2;
                eVar.f6212c = optString3;
                if (!TextUtils.isEmpty(optString2) && TextUtils.equals(optString2, "10000")) {
                    z5 = true;
                }
                eVar.f6213d = z5;
                return eVar;
            } catch (JSONException e6) {
                e6.printStackTrace();
                return null;
            }
        }

        @Override // com.amap.api.col.p0003l.g2, com.amap.api.col.p0003l.Cif
        public final Map<String, String> getParams() {
            Hashtable hashtable = new Hashtable(16);
            hashtable.put("key", f4.j(this.f7756t));
            if (this.f6209w) {
                hashtable.put("pname", "3dmap");
            }
            String a6 = h4.a();
            String c6 = h4.c(this.f7756t, a6, q4.r(hashtable));
            hashtable.put("ts", a6);
            hashtable.put("scode", c6);
            return hashtable;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getURL() {
            return "http://restsdk.amap.com" + this.f7757u;
        }

        public d(Context context, String str) {
            super(context, str);
            this.f7757u = "/rest/feedback/terrain";
            this.isPostFlag = false;
            this.f6209w = true;
        }

        @Override // com.amap.api.col.p0003l.y3
        protected final /* synthetic */ e g(String str) throws fc {
            return o(str);
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getIPV6URL() {
            return b3.y(getURL());
        }

        @Override // com.amap.api.col.p0003l.y3
        protected final /* synthetic */ e h(byte[] bArr) throws fc {
            return p(bArr);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f6210a;

        /* renamed from: b, reason: collision with root package name */
        public String f6211b;

        /* renamed from: c, reason: collision with root package name */
        public String f6212c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f6213d;

        private e() {
            this.f6213d = false;
        }

        /* synthetic */ e(byte b6) {
            this();
        }
    }

    private void f() {
        if (this.f6199c == null) {
            HandlerThread handlerThread = new HandlerThread("terrain_auth");
            this.f6199c = handlerThread;
            handlerThread.start();
            this.f6200d = new Handler(this.f6199c.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Handler handler = this.f6200d;
        if (handler != null) {
            handler.postDelayed(this.f6203g, 1000L);
        }
    }

    public final void c() {
        Handler handler = this.f6200d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f6200d = null;
        }
        HandlerThread handlerThread = this.f6199c;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f6199c = null;
        }
    }

    public final void d(long j6) {
        Handler handler = this.f6200d;
        if (handler != null) {
            handler.postDelayed(this.f6202f, j6);
        }
    }

    public fa(Context context, IAMapDelegate iAMapDelegate) {
        this.f6197a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f6198b = new WeakReference<>(iAMapDelegate);
        f();
    }
}
