package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.a.c;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class bj extends Observable {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10721a = "b_f";

    /* renamed from: b, reason: collision with root package name */
    public static final String f10722b = "XAbstractProdTemplate";

    /* renamed from: c, reason: collision with root package name */
    public static final String f10723c = "error_message";

    /* renamed from: d, reason: collision with root package name */
    public static final String f10724d = "error_code";

    /* renamed from: e, reason: collision with root package name */
    public static final String f10725e = "error_uniqueid";

    /* renamed from: f, reason: collision with root package name */
    protected static final String f10726f = "instanceInfo";

    /* renamed from: g, reason: collision with root package name */
    protected static final String f10727g = "showState";

    /* renamed from: h, reason: collision with root package name */
    protected RelativeLayout f10728h;

    /* renamed from: i, reason: collision with root package name */
    protected Context f10729i;

    /* renamed from: j, reason: collision with root package name */
    protected String f10730j;

    /* renamed from: o, reason: collision with root package name */
    public HashMap<String, String> f10735o;

    /* renamed from: p, reason: collision with root package name */
    public String f10736p;

    /* renamed from: q, reason: collision with root package name */
    public String f10737q;

    /* renamed from: k, reason: collision with root package name */
    protected bu f10731k = bu.a();

    /* renamed from: m, reason: collision with root package name */
    public IAdInterListener f10733m = null;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10734n = true;

    /* renamed from: r, reason: collision with root package name */
    public int f10738r = -1;

    /* renamed from: s, reason: collision with root package name */
    protected long f10739s = 0;

    /* renamed from: l, reason: collision with root package name */
    public IOAdEventListener f10732l = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements IOAdEventListener {
        public a() {
        }

        private String a(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            Object obj;
            if (iOAdEvent == null) {
                return null;
            }
            String message = iOAdEvent.getMessage();
            return (!TextUtils.isEmpty(message) || (data = iOAdEvent.getData()) == null || (obj = data.get("msg")) == null || !(obj instanceof String)) ? message : (String) obj;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            bj.a(new bm(this, iOAdEvent));
        }
    }

    public abstract void a();

    protected void a(IOAdEvent iOAdEvent) {
    }

    protected void b() {
    }

    protected void c() {
    }

    protected void d() {
    }

    protected void e(IOAdEvent iOAdEvent) {
    }

    protected void f(IOAdEvent iOAdEvent) {
    }

    protected void g(String str) {
    }

    protected void h(IOAdEvent iOAdEvent) {
    }

    protected void i(IOAdEvent iOAdEvent) {
    }

    protected void j(IOAdEvent iOAdEvent) {
    }

    protected void k(IOAdEvent iOAdEvent) {
    }

    protected void a(String str, boolean z5) {
    }

    protected void b(IOAdEvent iOAdEvent) {
    }

    protected void c(IOAdEvent iOAdEvent) {
    }

    protected void d(IOAdEvent iOAdEvent) {
    }

    protected void e(String str) {
    }

    protected void f(String str) {
    }

    protected void g(IOAdEvent iOAdEvent) {
        r();
    }

    public void h() {
        this.f10733m = (IAdInterListener) av.a(z.f11221k, bt.a(this.f10729i), (Class<?>[]) new Class[]{Context.class}, this.f10729i);
        if (this.f10734n) {
            return;
        }
        a();
    }

    public void i() {
        a("SDK未初始化", 1, "");
    }

    public JSONObject j() {
        return new JSONObject();
    }

    public JSONObject k() {
        return new JSONObject();
    }

    public void m() {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            iAdInterListener.addEventListener(com.baidu.mobads.sdk.internal.a.c.f10533h, new c.a());
            this.f10733m.addEventListener(z.G, this.f10732l);
            this.f10733m.addEventListener(z.I, this.f10732l);
            this.f10733m.addEventListener(z.K, this.f10732l);
            this.f10733m.addEventListener(z.L, this.f10732l);
            this.f10733m.addEventListener(z.V, this.f10732l);
            this.f10733m.addEventListener(z.f11227q, this.f10732l);
            this.f10733m.addEventListener(z.W, this.f10732l);
            this.f10733m.addEventListener(z.f11228r, this.f10732l);
            this.f10733m.addEventListener(z.M, this.f10732l);
            this.f10733m.addEventListener(z.N, this.f10732l);
            this.f10733m.addEventListener(z.J, this.f10732l);
            this.f10733m.addEventListener(z.C, this.f10732l);
            this.f10733m.addEventListener(z.ab, this.f10732l);
            this.f10733m.addEventListener(z.ac, this.f10732l);
            this.f10733m.addEventListener(z.ad, this.f10732l);
            this.f10733m.addEventListener(z.Z, this.f10732l);
            this.f10733m.addEventListener(z.U, this.f10732l);
            this.f10733m.addEventListener(z.ae, this.f10732l);
            this.f10733m.addEventListener(z.af, this.f10732l);
            this.f10733m.addEventListener(z.ag, this.f10732l);
            this.f10733m.addEventListener(z.ah, this.f10732l);
            this.f10733m.addEventListener(z.ai, this.f10732l);
            this.f10733m.addEventListener(z.aj, this.f10732l);
            this.f10733m.addEventListener(z.ak, this.f10732l);
            this.f10733m.addEventListener(z.al, this.f10732l);
            this.f10733m.addEventListener(z.aa, this.f10732l);
            this.f10733m.addEventListener(z.am, this.f10732l);
            this.f10733m.addEventListener(z.X, this.f10732l);
            this.f10733m.addEventListener(z.an, this.f10732l);
            this.f10733m.addEventListener(z.ao, this.f10732l);
        }
    }

    public void n() {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            iAdInterListener.onAttachedToWindow();
        }
    }

    public void o() {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            iAdInterListener.onDetachedFromWindow();
        }
    }

    public void p() {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            iAdInterListener.destroyAd();
        }
    }

    public void r() {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            iAdInterListener.removeAllListeners();
        }
    }

    public View w() {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            return iAdInterListener.getAdContainerView();
        }
        return null;
    }

    public bj(Context context) {
        this.f10729i = context;
        aa.a().a(this.f10729i, new bk(this));
    }

    public void a(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_IMPRESSION, jSONObject));
        }
    }

    protected void b(String str, boolean z5) {
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            a("bidding id is empty", 2, "");
        }
        if (this.f10733m != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bid_id", str);
            a("load_bidding_ad", (Map<String, Object>) hashMap);
            return;
        }
        a("Initialization doesn't finish yet.", 1, "");
    }

    protected void d(String str) {
    }

    public String i(String str) {
        IXAdContainerFactory c6;
        aa a6 = aa.a();
        if (a6 == null || (c6 = a6.c()) == null) {
            return null;
        }
        Object remoteParam = c6.getRemoteParam(str, new Object[0]);
        if (remoteParam instanceof String) {
            return (String) remoteParam;
        }
        return null;
    }

    public String l() {
        JSONObject j6 = j();
        JSONObject k6 = k();
        HashMap hashMap = new HashMap();
        hashMap.put("param_info", j6);
        hashMap.put("ad_buss_param", k6);
        a("get_request_token", (Map<String, Object>) hashMap);
        Object obj = hashMap.get("request_token");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    protected void b(boolean z5) {
    }

    public void a(Activity activity) {
        if (this.f10733m != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("setActivity", activity);
            this.f10733m.onAdTaskProcess(a(IAdInterListener.AdCommandType.CHANGE_ACTIVITY, new JSONObject()), hashMap);
        }
    }

    public void b(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_CLICK, jSONObject));
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            a("bidding data is empty", 2, "");
        }
        if (this.f10733m != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bidding_data", str);
            a("load_bidding_data", (Map<String, Object>) hashMap);
            return;
        }
        a("Initialization doesn't finish yet.", 1, "");
    }

    public void h(String str) {
        this.f10737q = str;
    }

    public void a(JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject));
        }
    }

    public void a(JSONObject jSONObject, Map<String, Object> map) {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
        }
    }

    public void b(int i6) {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowVisibilityChanged(i6);
        }
    }

    public void a(String str, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "server_bidding");
            jSONObject.put("msg", str);
            IAdInterListener iAdInterListener = this.f10733m;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public JSONObject b(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                return new JSONObject(map);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    protected void b(JSONObject jSONObject) {
        int i6 = this.f10738r;
        if (i6 >= 0 && jSONObject != null) {
            try {
                jSONObject.put(f10721a, i6);
            } catch (Throwable th) {
                this.f10731k.a(th);
            }
        }
        if (jSONObject != null) {
            try {
                jSONObject.put(d.f10986b, this.f10739s);
            } catch (Throwable th2) {
                this.f10731k.a(th2);
            }
        }
    }

    protected void q() {
    }

    protected void s() {
    }

    protected void t() {
    }

    protected void u() {
    }

    protected void v() {
    }

    public void a(String str, boolean z5, LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        try {
            if (k.a(z5, linkedHashMap, biddingListener)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uniqueId", str);
                jSONObject.put("result", z5);
                try {
                    for (Map.Entry<String, Object> entry : linkedHashMap.entrySet()) {
                        jSONObject.put(String.valueOf(entry.getKey()), entry.getValue());
                    }
                } catch (Throwable th) {
                    az.f(th.getMessage());
                }
                IAdInterListener iAdInterListener = this.f10733m;
                if (iAdInterListener != null) {
                    iAdInterListener.onAdTaskProcess(a("onBiddingResult", jSONObject), (Map<String, Object>) null);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", str);
            IAdInterListener iAdInterListener = this.f10733m;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.NOVEL_EVENT, jSONObject), hashMap);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(boolean z5) {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowFocusChanged(z5);
        }
    }

    public boolean a(int i6, KeyEvent keyEvent) {
        IAdInterListener iAdInterListener = this.f10733m;
        if (iAdInterListener != null) {
            return iAdInterListener.onKeyDown(i6, keyEvent);
        }
        return false;
    }

    protected void a(int i6, String str, String str2) {
        r();
    }

    protected void a(String str, int i6, String str2) {
        r();
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new bl(runnable));
            }
        } catch (Exception unused) {
        }
    }

    public void a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f10735o = (HashMap) map;
    }

    private String a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return "bdsdk://" + str + "?jsonObj=" + Uri.encode(jSONObject.toString());
    }
}
