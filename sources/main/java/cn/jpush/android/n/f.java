package cn.jpush.android.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import cn.jpush.android.ad.m;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.amap.api.services.core.AMapException;
import com.stub.StubApp;
import com.umeng.socialize.common.SocializeConstants;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final LocationManager f3724a;

    /* renamed from: b, reason: collision with root package name */
    private Context f3725b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f3726c;

    /* renamed from: e, reason: collision with root package name */
    private volatile a f3728e;

    /* renamed from: f, reason: collision with root package name */
    private volatile b f3729f;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, JSONObject> f3727d = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private boolean f3730g = false;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public long f3733a;

        /* renamed from: b, reason: collision with root package name */
        public double f3734b;

        /* renamed from: c, reason: collision with root package name */
        public double f3735c;

        public void a(Context context) {
            String n6 = cn.jpush.android.cache.a.n(context);
            if (TextUtils.isEmpty(n6)) {
                return;
            }
            Logger.d("GeofencePullHelper", "last pull state:" + n6);
            try {
                a(new JSONObject(n6));
            } catch (JSONException unused) {
            }
        }

        public a() {
        }

        public void a(Context context, JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            Logger.d("GeofencePullHelper", "saveGeofenceLastPullState:" + jSONObject.toString());
            a(jSONObject);
            cn.jpush.android.cache.a.f(f.this.f3725b, jSONObject.toString());
        }

        public void a(JSONObject jSONObject) {
            f.this.f3728e.f3734b = jSONObject.optDouble(com.umeng.analytics.pro.d.C, 200.0d);
            f.this.f3728e.f3735c = jSONObject.optDouble(com.umeng.analytics.pro.d.D, 200.0d);
            f.this.f3728e.f3733a = jSONObject.optLong("time", 0L);
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f3737a = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;

        /* renamed from: b, reason: collision with root package name */
        public int f3738b = 10800;

        /* renamed from: c, reason: collision with root package name */
        public int f3739c = 900;

        /* renamed from: d, reason: collision with root package name */
        public int f3740d = 20;

        public void a(Context context) {
            String m6 = cn.jpush.android.cache.a.m(context);
            if (TextUtils.isEmpty(m6)) {
                return;
            }
            Logger.d("GeofencePullHelper", "pull limit:" + m6);
            try {
                a(new JSONObject(m6));
            } catch (Throwable unused) {
            }
        }

        public b() {
        }

        public void a(Context context, JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                a(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                a(jSONObject, jSONObject2, "minInterval", f.this.f3729f.f3737a);
                a(jSONObject, jSONObject2, "nextInterval", f.this.f3729f.f3738b);
                a(jSONObject, jSONObject2, "minLBSInterval", f.this.f3729f.f3739c);
                a(jSONObject, jSONObject2, "minLBSKilo", f.this.f3729f.f3740d);
                cn.jpush.android.cache.a.e(context, jSONObject2.toString());
            } catch (Throwable unused) {
                Logger.d("GeofencePullHelper", "save limit failed");
            }
        }

        private void a(JSONObject jSONObject) {
            f.this.f3729f.f3737a = jSONObject.optInt("minInterval", f.this.f3729f.f3737a);
            f.this.f3729f.f3738b = jSONObject.optInt("nextInterval", f.this.f3729f.f3738b);
            f.this.f3729f.f3739c = jSONObject.optInt("minLBSInterval", f.this.f3729f.f3739c);
            f.this.f3729f.f3740d = jSONObject.optInt("minLBSKilo", f.this.f3729f.f3740d);
        }

        private void a(JSONObject jSONObject, JSONObject jSONObject2, String str, int i6) {
            if (jSONObject.has(str)) {
                jSONObject2.put(str, i6);
            }
        }
    }

    private void c() {
        try {
            HandlerThread handlerThread = new HandlerThread("jg_gph_thread") { // from class: cn.jpush.android.n.f.1
                @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                    } catch (RuntimeException e6) {
                        Logger.e("GeofencePullHelper", "handler thread run e:" + e6 + "  t=" + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
                    }
                }
            };
            handlerThread.start();
            this.f3726c = new Handler(handlerThread.getLooper()) { // from class: cn.jpush.android.n.f.2
                @Override // android.os.Handler
                @SuppressLint({"MissingPermission"})
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 1000:
                            f.this.a(r3.f3729f.f3738b);
                            break;
                        case 1001:
                            break;
                        case 1002:
                            if (f.this.g()) {
                                f.this.a(0L);
                            }
                            f.this.b(r3.f3729f.f3739c);
                            return;
                        default:
                            return;
                    }
                    f.this.f();
                }
            };
        } catch (Throwable th) {
            Logger.ww("GeofencePullHelper", "init geofence pull handler failed:" + th);
        }
    }

    public void b() {
        Logger.d("GeofencePullHelper", "onTcpDisconnected");
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j6) {
        StringBuilder sb = new StringBuilder();
        sb.append("compile loc after ");
        long j7 = j6 * 1000;
        sb.append(j7);
        sb.append("ms");
        Logger.dd("GeofencePullHelper", sb.toString());
        Handler handler = this.f3726c;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1002)) {
            this.f3726c.removeMessages(1002);
        }
        this.f3726c.sendEmptyMessageDelayed(1002, j7);
    }

    private void d() {
        Logger.dd("GeofencePullHelper", "start schedule geofence pull");
        a((h() || g()) ? 0L : this.f3729f.f3738b);
        b(this.f3729f.f3739c);
    }

    private void e() {
        Logger.dd("GeofencePullHelper", "stop schedule geofence pull");
        Handler handler = this.f3726c;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.f3726c.removeMessages(1000);
        }
        if (this.f3726c.hasMessages(1001)) {
            this.f3726c.removeMessages(1001);
        }
        if (this.f3726c.hasMessages(1002)) {
            this.f3726c.removeMessages(1002);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void f() {
        Logger.dd("GeofencePullHelper", "try pull...");
        Location a6 = c.a(this.f3725b, this.f3724a, false);
        if (a6 == null) {
            Logger.dd("GeofencePullHelper", "stop pull,get loction failed");
        } else {
            a(a6.getLatitude(), a6.getLongitude());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        Location a6 = c.a(this.f3725b, this.f3724a, false);
        if (a6 != null) {
            double a7 = m.a(a6.getLongitude(), a6.getLatitude(), this.f3728e.f3735c, this.f3728e.f3734b);
            Logger.d("GeofencePullHelper", "check current distance to last pull distance:" + a7 + ",lbsKilo:" + (this.f3729f.f3740d * 1000));
            if (a7 > this.f3729f.f3740d * 1000) {
                return true;
            }
        }
        Logger.dd("GeofencePullHelper", "loc limit");
        return false;
    }

    private void i() {
        this.f3728e = new a();
        this.f3728e.a(this.f3725b);
    }

    private void j() {
        this.f3729f = new b();
        this.f3729f.a(this.f3725b);
        this.f3730g = cn.jpush.android.cache.a.l(this.f3725b);
    }

    public void a() {
        Logger.d("GeofencePullHelper", "onLogin");
        if (this.f3730g) {
            d();
        } else {
            Logger.dd("GeofencePullHelper", "do not support pull");
        }
    }

    public f(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f3725b = origApplicationContext;
        this.f3724a = (LocationManager) origApplicationContext.getSystemService(SocializeConstants.KEY_LOCATION);
        c();
        i();
        j();
    }

    private void a(double d6, double d7) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.analytics.pro.d.C, d6);
            jSONObject.put(com.umeng.analytics.pro.d.D, d7);
            jSONObject.put("time", System.currentTimeMillis() / 1000);
            long a6 = cn.jpush.android.helper.f.a();
            Logger.dd("GeofencePullHelper", "will send report geo request:" + jSONObject + ",requestid:" + a6);
            HashMap<String, JSONObject> hashMap = this.f3727d;
            StringBuilder sb = new StringBuilder();
            sb.append(a6);
            sb.append("");
            hashMap.put(sb.toString(), jSONObject);
            JCoreHelper.sendRequest(this.f3725b, JPushConstants.SDK_TYPE, 37, 1, a6, 0L, cn.jpush.android.z.b.c(jSONObject.toString()));
        } catch (Throwable th) {
            Logger.dd("GeofencePullHelper", "send report geo request failed:" + th.getMessage());
        }
    }

    private boolean h() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j6 = this.f3728e.f3733a;
        Logger.dd("GeofencePullHelper", "lastPullTime:" + j6 + ",currentTime:" + currentTimeMillis + ",minInterval:" + this.f3729f.f3737a);
        if (currentTimeMillis - j6 < this.f3729f.f3737a) {
            Logger.dd("GeofencePullHelper", "time limit");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j6) {
        StringBuilder sb = new StringBuilder();
        sb.append("pull geofence after ");
        long j7 = j6 * 1000;
        sb.append(j7);
        sb.append("ms");
        Logger.dd("GeofencePullHelper", sb.toString());
        Handler handler = this.f3726c;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.f3726c.removeMessages(1000);
        }
        this.f3726c.sendEmptyMessageDelayed(1000, j7);
    }

    public void a(long j6, int i6, d dVar) {
        JSONObject remove = this.f3727d.remove(j6 + "");
        if (i6 == JPushInterface.ErrorCode.TIMEOUT) {
            Logger.dd("GeofencePullHelper", "pull geo is timeout,requestid:" + j6);
            return;
        }
        if (remove == null) {
            Logger.dd("GeofencePullHelper", "can not find request from requestid:" + j6);
            return;
        }
        JSONObject a6 = dVar.a();
        if (a6 == null) {
            Logger.dd("GeofencePullHelper", "onPullResponse empty pull response");
            return;
        }
        this.f3729f.a(this.f3725b, a6);
        JSONArray b6 = dVar.b();
        if (b6 == null) {
            b6 = new JSONArray();
        }
        Logger.dd("GeofencePullHelper", "onPullResponse:" + b6);
        if (b6.length() == 0) {
            this.f3730g = false;
            cn.jpush.android.cache.a.d(this.f3725b, false);
            e();
        }
        this.f3728e.a(this.f3725b, remove);
        e.a().a(b6);
        cn.jpush.android.n.a.a(this.f3725b, b6.toString());
    }

    public void a(cn.jpush.android.n.b bVar) {
        if (bVar == null) {
            return;
        }
        int a6 = bVar.a();
        Logger.d("GeofencePullHelper", "control pull geo type:" + a6);
        if (this.f3730g ^ (a6 == 1)) {
            boolean z5 = a6 == 1;
            this.f3730g = z5;
            cn.jpush.android.cache.a.d(this.f3725b, z5);
            if (this.f3730g) {
                d();
            } else {
                e();
            }
        }
    }
}
