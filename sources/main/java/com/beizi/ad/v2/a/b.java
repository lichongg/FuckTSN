package com.beizi.ad.v2.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.beizi.ad.internal.e;
import com.beizi.ad.internal.f.c;
import com.beizi.ad.internal.h.o;
import com.beizi.ad.internal.k;
import com.beizi.ad.model.f;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.AdSpacesBean;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {
    protected boolean A;
    protected boolean B;
    protected boolean C;
    protected boolean D;
    protected boolean E;
    private String G;
    private String H;
    private Map<String, Object> I;

    /* renamed from: a, reason: collision with root package name */
    protected Context f13084a;

    /* renamed from: b, reason: collision with root package name */
    protected e f13085b;

    /* renamed from: c, reason: collision with root package name */
    protected c f13086c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f13087d;

    /* renamed from: e, reason: collision with root package name */
    protected String f13088e;

    /* renamed from: f, reason: collision with root package name */
    protected String f13089f;

    /* renamed from: k, reason: collision with root package name */
    protected String f13094k;

    /* renamed from: l, reason: collision with root package name */
    protected String f13095l;

    /* renamed from: m, reason: collision with root package name */
    protected k f13096m;

    /* renamed from: n, reason: collision with root package name */
    protected int f13097n;

    /* renamed from: o, reason: collision with root package name */
    protected int f13098o;

    /* renamed from: p, reason: collision with root package name */
    protected int f13099p;

    /* renamed from: q, reason: collision with root package name */
    protected int f13100q;

    /* renamed from: r, reason: collision with root package name */
    protected com.beizi.ad.internal.a.b f13101r;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f13102s;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f13103t;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f13104u;

    /* renamed from: v, reason: collision with root package name */
    protected boolean f13105v;

    /* renamed from: w, reason: collision with root package name */
    protected EventBean f13106w;

    /* renamed from: x, reason: collision with root package name */
    protected boolean f13107x;

    /* renamed from: y, reason: collision with root package name */
    protected String f13108y;

    /* renamed from: z, reason: collision with root package name */
    protected AdSpacesBean.BuyerBean f13109z;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f13090g = false;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f13091h = false;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f13092i = false;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f13093j = false;
    private boolean J = false;
    protected Handler F = new Handler(Looper.getMainLooper()) { // from class: com.beizi.ad.v2.a.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 16) {
                return;
            }
            b.this.n();
        }
    };

    public b(Context context, k kVar) {
        this.f13085b = null;
        this.f13084a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        String a6 = o.a();
        this.f13095l = a6;
        this.f13094k = a6;
        this.f13096m = kVar;
        e eVar = new e(context, this.f13095l);
        this.f13085b = eVar;
        eVar.a(kVar);
    }

    public void a(c cVar) {
    }

    public void b(int i6) {
    }

    public void c() {
    }

    public String d() {
        return this.f13108y;
    }

    public String e() {
        return this.f13095l;
    }

    private void u() {
        if (this.f13100q <= 0) {
            return;
        }
        v();
        int i6 = this.f13099p;
        if (i6 <= 0) {
            n();
            return;
        }
        Handler handler = this.F;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(16, i6);
        }
    }

    private void v() {
        Object obj;
        com.beizi.ad.model.b bVar = new com.beizi.ad.model.b();
        bVar.a(this.f13108y);
        Map<String, Object> map = this.I;
        if (map != null && map.containsKey("orderList") && (obj = this.I.get("orderList")) != null && (obj instanceof List)) {
            List<String> list = (List) obj;
            if (list.size() > 0) {
                bVar.a(list);
            }
        }
        com.beizi.ad.internal.a.a.a().a(this.f13106w, this.f13100q, bVar, this.f13096m);
    }

    private void w() {
        if (this.f13105v || !this.f13103t || this.f13104u) {
            return;
        }
        this.f13105v = true;
        com.beizi.ad.internal.a.a.a().a(this.f13101r, 1, this.f13100q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.beizi.ad.model.b x() {
        Object obj;
        com.beizi.ad.model.b bVar = new com.beizi.ad.model.b();
        bVar.a(this.f13108y);
        bVar.b(this.f13095l);
        bVar.a(false);
        Map<String, Object> map = this.I;
        if (map != null && map.containsKey("orderList") && (obj = this.I.get("orderList")) != null && (obj instanceof List)) {
            List<String> list = (List) obj;
            if (list.size() > 0) {
                bVar.a(list);
            }
        }
        return bVar;
    }

    public void b() {
        if (this.f13091h) {
            return;
        }
        this.f13091h = true;
        if (TextUtils.isEmpty(this.G)) {
            if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.H)) {
                b(3);
                return;
            } else {
                u();
                com.beizi.ad.lance.a.c.b().c().execute(new Runnable() { // from class: com.beizi.ad.v2.a.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        new com.beizi.ad.v2.e.b().a(b.this.x(), new com.beizi.ad.v2.e.a() { // from class: com.beizi.ad.v2.a.b.2.1
                            @Override // com.beizi.ad.v2.e.a
                            public void a(String str) {
                                try {
                                    c cVar = new c(str, null, b.this.f13085b.i());
                                    b bVar = b.this;
                                    if (bVar.f13103t) {
                                        bVar.a(cVar, str);
                                        return;
                                    }
                                    bVar.r();
                                    if (cVar.h()) {
                                        b.this.a(true, cVar.W(), null, cVar);
                                    } else {
                                        if (b.this.n()) {
                                            return;
                                        }
                                        b.this.b(3);
                                    }
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }

                            @Override // com.beizi.ad.v2.e.a
                            public void a(int i6) {
                                b bVar = b.this;
                                bVar.f13091h = false;
                                if (bVar.f13103t) {
                                    return;
                                }
                                bVar.r();
                                if (b.this.n()) {
                                    return;
                                }
                                b.this.b(i6);
                            }
                        });
                    }
                });
                return;
            }
        }
        c cVar = new c(this.G, null, this.f13085b.i());
        if (!cVar.h()) {
            b(3);
        } else if (!a(cVar.x())) {
            b(12);
        } else {
            this.f13095l = cVar.aa();
            a(true, cVar.W(), null, cVar);
        }
    }

    public void c(String str) {
        this.f13089f = str;
    }

    public void d(String str) {
        this.G = str;
    }

    public void e(String str) {
        this.H = str;
    }

    public boolean f() {
        return this.f13107x;
    }

    public String g() {
        return this.f13088e;
    }

    public String h() {
        return this.f13089f;
    }

    public boolean i() {
        return this.f13090g;
    }

    public boolean j() {
        return this.f13087d;
    }

    public Map k() {
        c cVar = this.f13086c;
        if (cVar == null) {
            return null;
        }
        return cVar.Q();
    }

    public String l() {
        c cVar = this.f13086c;
        if (cVar == null) {
            return null;
        }
        return cVar.R();
    }

    public c m() {
        return this.f13086c;
    }

    protected boolean n() {
        c a6;
        if (this.J) {
            return false;
        }
        this.J = true;
        if (this.f13100q <= 0 || this.f13102s) {
            return false;
        }
        try {
            com.beizi.ad.internal.a.b b6 = com.beizi.ad.internal.a.a.a().b(d());
            if (b6 == null || (a6 = com.beizi.ad.internal.a.a.a().a(b6, this.f13096m)) == null) {
                return false;
            }
            if (this.f13102s) {
                com.beizi.ad.internal.a.a.a().a(b6, 1, this.f13100q);
                return false;
            }
            if (!a(a6, b6)) {
                return false;
            }
            a(false, null, b6, a6);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean o() {
        return this.f13103t;
    }

    public long p() {
        com.beizi.ad.internal.a.b bVar;
        try {
            if (this.f13103t && (bVar = this.f13101r) != null) {
                return bVar.b();
            }
            return 0L;
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0L;
        }
    }

    public void q() {
        c cVar = this.f13086c;
        if (cVar != null) {
            cVar.d(false);
        }
        w();
        r();
    }

    public void r() {
        Handler handler = this.F;
        if (handler != null) {
            handler.removeMessages(16);
        }
    }

    public int s() {
        int i6 = this.f13097n;
        if (i6 <= 0) {
            return 5;
        }
        return i6;
    }

    public JSONObject t() {
        int intValue;
        try {
            Map<String, Object> map = this.I;
            if (map == null || !map.containsKey("materialInfo")) {
                return null;
            }
            Object obj = this.I.get("materialInfo");
            if (!(obj instanceof Integer) || (intValue = ((Integer) obj).intValue()) == 0) {
                return null;
            }
            if (intValue != 1 && intValue != 101 && intValue != 1001) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f13086c != null) {
                JSONObject jSONObject2 = new JSONObject();
                if (intValue == 1 || intValue == 101 || intValue == 1001) {
                    k kVar = this.f13096m;
                    String S = kVar == k.NEW_SPLASH ? this.f13086c.S() : kVar == k.NATIVE ? this.f13086c.S() : kVar == k.INTERSTITIAL ? this.f13086c.L() : kVar == k.REWARDEDVIDEO ? this.f13086c.L() : kVar == k.SPLASHUNIFIED ? this.f13086c.U() : null;
                    if (!TextUtils.isEmpty(S) && S.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                        jSONObject2.put("imageUrl", S);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(S);
                        jSONObject2.put("imageUrls", jSONArray);
                    }
                    String M = this.f13086c.M();
                    if (!TextUtils.isEmpty(M)) {
                        jSONObject2.put("videoUrl", M);
                    }
                    String ah = this.f13086c.ah();
                    if (!TextUtils.isEmpty(ah)) {
                        jSONObject2.put("crid", ah);
                    }
                }
                if (intValue == 101 || intValue == 1001) {
                    String ab = this.f13086c.ab();
                    if (!TextUtils.isEmpty(ab)) {
                        jSONObject2.put("deeplinkUrl", ab);
                    }
                    String ac = this.f13086c.ac();
                    if (!TextUtils.isEmpty(ac)) {
                        jSONObject2.put("landingPageUrl", ac);
                    }
                    String ad = this.f13086c.ad();
                    if (!TextUtils.isEmpty(ad)) {
                        jSONObject2.put("downloadUrl", ad);
                    }
                    String ae = this.f13086c.ae();
                    if (!TextUtils.isEmpty(ae)) {
                        jSONObject2.put("miniProgramId", ae);
                    }
                    String af = this.f13086c.af();
                    if (!TextUtils.isEmpty(af)) {
                        jSONObject2.put("miniProgramPath", af);
                    }
                }
                if (intValue == 1001) {
                    String ag = this.f13086c.ag();
                    if (!TextUtils.isEmpty(ag)) {
                        jSONObject2.put("orderId", ag);
                    }
                }
                jSONObject.put("materialInfo", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private void y() {
        com.beizi.ad.lance.a.c.b().d().execute(new Runnable() { // from class: com.beizi.ad.v2.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventBean m86clone = b.this.f13106w.m86clone();
                    m86clone.setEventCode("280.000");
                    if (b.this.f13103t) {
                        m86clone.setIsCacheAd("1");
                    }
                    EventCar.getInstance(b.this.f13084a).goRoad(m86clone);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public void c(Map<String, Object> map) {
        this.I = map;
    }

    public void a(int i6) {
        this.f13098o = i6;
    }

    public void a(AdSpacesBean.BuyerBean buyerBean) {
        if (buyerBean == null) {
            return;
        }
        this.f13109z = buyerBean;
        int cacheNum = buyerBean.getCacheNum();
        this.f13100q = cacheNum;
        if (cacheNum > 0) {
            int waitTime = buyerBean.getWaitTime();
            int lastTime = buyerBean.getLastTime();
            if (lastTime <= 0) {
                lastTime = 100;
            }
            if (waitTime >= 0) {
                this.f13099p = Math.min(waitTime, this.f13098o - lastTime);
            } else {
                this.f13099p = this.f13098o - lastTime;
            }
            if (this.f13099p <= 0) {
                this.f13099p = 100;
            }
        }
        this.B = buyerBean.getIsImageSpeed() == 1;
        this.C = buyerBean.getIsHideInteraction() == 1;
        this.D = buyerBean.getIsPlaceHolder() == 1;
        this.E = buyerBean.getIsAnimation() == 1;
    }

    public b(Context context, String str, k kVar) {
        this.f13085b = null;
        this.f13084a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        String a6 = o.a();
        this.f13095l = a6;
        this.f13094k = a6;
        this.f13108y = str;
        this.f13096m = kVar;
        e eVar = new e(context, this.f13095l);
        this.f13085b = eVar;
        eVar.b(str);
        this.f13085b.a(kVar);
    }

    public AdSpacesBean.BuyerBean a() {
        return this.f13109z;
    }

    public void a(EventBean eventBean) {
        this.f13106w = eventBean;
    }

    public void b(String str) {
        this.f13088e = str;
    }

    public void a(String str) {
        this.f13108y = str;
        e eVar = this.f13085b;
        if (eVar != null) {
            eVar.b(str);
        }
    }

    public void b(Map map) {
        if (this.f13086c == null || map == null) {
            return;
        }
        w();
        this.f13086c.b(map);
    }

    public void a(boolean z5) {
        this.f13087d = z5;
    }

    public void a(Map map) {
        c cVar = this.f13086c;
        if (cVar == null || map == null) {
            return;
        }
        cVar.a(map);
    }

    private boolean a(c cVar, com.beizi.ad.internal.a.b bVar) {
        Object obj;
        try {
            Map<String, Object> map = this.I;
            if (map == null || !map.containsKey("orderList") || (obj = this.I.get("orderList")) == null || !(obj instanceof List)) {
                return true;
            }
            List list = (List) obj;
            if (list.isEmpty()) {
                return true;
            }
            String ag = cVar.ag();
            if (TextUtils.isEmpty(ag) || list.contains(ag)) {
                return true;
            }
            com.beizi.ad.internal.a.a.a().a(bVar);
            return false;
        } catch (Exception e6) {
            e6.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z5, String str, com.beizi.ad.internal.a.b bVar, c cVar) {
        try {
            if (this.A) {
                if (z5) {
                    a(cVar, str);
                } else if (this.f13102s) {
                    com.beizi.ad.internal.a.a.a().a(bVar, 1, this.f13100q);
                }
                return;
            }
            this.A = true;
            this.f13086c = cVar;
            if (z5) {
                this.f13102s = true;
            } else {
                this.f13103t = true;
                if (bVar != null) {
                    String d6 = bVar.d();
                    this.f13095l = d6;
                    e eVar = this.f13085b;
                    if (eVar != null) {
                        eVar.a(d6);
                    }
                }
                this.f13101r = bVar;
                c cVar2 = this.f13086c;
                if (cVar2 != null) {
                    cVar2.c(true);
                }
            }
            y();
            a(cVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(c cVar, String str) {
        if (cVar == null || !cVar.h() || TextUtils.isEmpty(str)) {
            return;
        }
        com.beizi.ad.internal.a.a.a().a(cVar, str, this.f13094k, this.f13108y, this.f13096m);
    }

    public boolean a(f.a aVar) {
        k kVar = this.f13096m;
        return (kVar == k.NEW_SPLASH || kVar == k.SPLASHUNIFIED || kVar == k.SPLASH) ? aVar == f.a.ADP_LOADING : kVar == k.NATIVE ? aVar == f.a.ADP_NATIVE : kVar == k.INTERSTITIAL ? aVar == f.a.ADP_TABLE : kVar == k.REWARDEDVIDEO && aVar == f.a.ADP_IVIDEO;
    }
}
