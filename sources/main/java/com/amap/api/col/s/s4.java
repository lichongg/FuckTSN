package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.s.n;
import com.amap.api.col.s.y0;
import com.amap.api.services.core.AMapException;
import com.tencent.mmkv.MMKV;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class s4 {

    /* renamed from: c, reason: collision with root package name */
    private static s4 f8451c;

    /* renamed from: d, reason: collision with root package name */
    private static Context f8452d;

    /* renamed from: e, reason: collision with root package name */
    public static i1 f8453e;

    /* renamed from: a, reason: collision with root package name */
    private b f8454a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f8455b = new a("manifestThread");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends HandlerThread {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.amap.api.col.s.s4$a$a, reason: collision with other inner class name */
        final class C0092a implements y0.b {
            C0092a() {
            }

            @Override // com.amap.api.col.s.y0.b
            public final void a(y0.c cVar) {
                b bVar;
                JSONObject jSONObject;
                JSONObject optJSONObject;
                JSONObject jSONObject2;
                JSONObject optJSONObject2;
                Message message = new Message();
                if (cVar != null) {
                    try {
                        y0.c.a aVar = cVar.f8743g;
                        if (aVar != null) {
                            message.obj = new t4(aVar.f8747b, aVar.f8746a);
                        }
                    } catch (Throwable th) {
                        try {
                            j4.i(th, "ManifestConfig", "run");
                            if (bVar == null) {
                                return;
                            }
                        } finally {
                            message.what = 3;
                            if (s4.this.f8454a != null) {
                                s4.this.f8454a.sendMessage(message);
                            }
                        }
                    }
                }
                if (cVar != null && (jSONObject2 = cVar.f8742f) != null && (optJSONObject2 = jSONObject2.optJSONObject("184")) != null) {
                    s4.l(optJSONObject2);
                    w.a(s4.f8452d, "amap_search", "cache_control", optJSONObject2.toString());
                }
                if (cVar != null && (jSONObject = cVar.f8742f) != null && (optJSONObject = jSONObject.optJSONObject("185")) != null) {
                    s4.k(optJSONObject);
                    w.a(s4.f8452d, "amap_search", "parm_control", optJSONObject.toString());
                }
                message.what = 3;
                if (s4.this.f8454a == null) {
                }
            }
        }

        a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            Thread.currentThread().setName("ManifestConfigThread");
            i1 a6 = i4.a(false);
            s4.j(s4.f8452d);
            y0.g(s4.f8452d, a6, "11K;001;184;185", new C0092a());
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e6) {
                e6.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        String f8458a;

        public b(Looper looper) {
            super(looper);
            this.f8458a = "handleMessage";
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message != null && message.what == 3) {
                try {
                    t4 t4Var = (t4) message.obj;
                    if (t4Var == null) {
                        t4Var = new t4(false, false);
                    }
                    g2.g(s4.f8452d, i4.a(t4Var.a()));
                    s4.f8453e = i4.a(t4Var.a());
                } catch (Throwable th) {
                    j4.i(th, "ManifestConfig", this.f8458a);
                }
            }
        }
    }

    private static n.a b(JSONObject jSONObject, boolean z5, n.a aVar) {
        boolean optBoolean;
        n.a aVar2 = null;
        if (jSONObject != null) {
            try {
                n.a aVar3 = new n.a();
                boolean z6 = true;
                try {
                    if (z5) {
                        String optString = jSONObject.optString("able");
                        if (aVar != null && !aVar.e()) {
                            z6 = false;
                        }
                        optBoolean = y0.u(optString, z6);
                    } else {
                        if (aVar != null && !aVar.e()) {
                            z6 = false;
                        }
                        optBoolean = jSONObject.optBoolean("able", z6);
                    }
                    int optInt = jSONObject.optInt("timeoffset", aVar != null ? (int) aVar.f() : MMKV.ExpireInDay);
                    int optInt2 = jSONObject.optInt("num", aVar != null ? aVar.g() : 10);
                    double optDouble = jSONObject.optDouble("limitDistance", aVar != null ? aVar.h() : 0.0d);
                    aVar3.d(optBoolean);
                    aVar3.c(optInt);
                    aVar3.b(optInt2);
                    aVar3.a(optDouble);
                    return aVar3;
                } catch (Throwable th) {
                    th = th;
                    aVar2 = aVar3;
                    th.printStackTrace();
                    return aVar2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return aVar2;
    }

    public static s4 d(Context context) {
        if (f8451c == null) {
            f8451c = new s4(context);
        }
        return f8451c;
    }

    private static void e(String str, JSONObject jSONObject, n.a aVar) {
        if (jSONObject != null && jSONObject.has(str)) {
            n.b().f(str, b(jSONObject.optJSONObject(str), false, aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(Context context) {
        try {
            String str = (String) w.b(context, "amap_search", "cache_control", "");
            if (!TextUtils.isEmpty(str)) {
                l(new JSONObject(str));
            }
            String str2 = (String) w.b(context, "amap_search", "parm_control", "");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            k(new JSONObject(str2));
        } catch (Throwable th) {
            j4.i(th, "ManifestConfig", "ManifestConfig-readAuthFromCache");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean u5 = y0.u(jSONObject.optString("passAreaAble"), true);
                boolean u6 = y0.u(jSONObject.optString("truckAble"), true);
                boolean u7 = y0.u(jSONObject.optString("poiPageAble"), true);
                boolean u8 = y0.u(jSONObject.optString("rideAble"), true);
                boolean u9 = y0.u(jSONObject.optString("walkAble"), true);
                boolean u10 = y0.u(jSONObject.optString("passPointAble"), true);
                boolean u11 = y0.u(jSONObject.optString("keyWordLenAble"), true);
                int optInt = jSONObject.optInt("poiPageMaxSize", 25);
                int optInt2 = jSONObject.optInt("passAreaMaxCount", 100);
                int optInt3 = jSONObject.optInt("walkMaxLength", 100);
                int optInt4 = jSONObject.optInt("passPointMaxCount", 6);
                int optInt5 = jSONObject.optInt("poiPageMaxNum", 100);
                int optInt6 = jSONObject.optInt("truckMaxLength", 5000);
                int optInt7 = jSONObject.optInt("rideMaxLength", AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS);
                int optInt8 = jSONObject.optInt("passAreaMaxArea", 100000000);
                int optInt9 = jSONObject.optInt("passAreaPointCount", 16);
                int optInt10 = jSONObject.optInt("keyWordLenMaxNum", 100);
                q.a().h(u5);
                q.a().n(optInt2);
                q.a().z(optInt8);
                q.a().A(optInt9);
                q.a().m(u6);
                q.a().w(optInt6);
                q.a().p(u7);
                q.a().u(optInt5);
                q.a().b(optInt);
                q.a().i(optInt10);
                q.a().x(u11);
                q.a().r(u8);
                q.a().y(optInt7);
                q.a().t(u9);
                q.a().q(optInt3);
                q.a().v(u10);
                q.a().s(optInt4);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("able")) {
                    n.a b6 = b(jSONObject, true, null);
                    n.b().d(b6);
                    if (b6.e()) {
                        e("regeo", jSONObject, b6);
                        e("geo", jSONObject, b6);
                        e("placeText", jSONObject, b6);
                        e("placeAround", jSONObject, b6);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private s4(Context context) {
        f8452d = context;
        f8453e = i4.a(false);
        try {
            g();
            this.f8454a = new b(Looper.getMainLooper());
            this.f8455b.start();
        } catch (Throwable th) {
            j4.i(th, "ManifestConfig", "ManifestConfig");
        }
    }

    private static void g() {
        m.a();
    }
}
