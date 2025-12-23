package com.beizi.fusion.work.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.beizi.ad.b;
import com.beizi.fusion.c.c;
import com.beizi.fusion.c.d;
import com.beizi.fusion.c.e;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.an;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends com.beizi.fusion.work.a implements c {

    /* renamed from: o, reason: collision with root package name */
    private Context f14080o;

    /* renamed from: p, reason: collision with root package name */
    private String f14081p;

    /* renamed from: q, reason: collision with root package name */
    private long f14082q;

    /* renamed from: r, reason: collision with root package name */
    private long f14083r;

    /* renamed from: s, reason: collision with root package name */
    private com.beizi.ad.v2.c.a f14084s;

    /* renamed from: t, reason: collision with root package name */
    private AdSpacesBean.UniteControlBean f14085t;

    /* renamed from: u, reason: collision with root package name */
    private int f14086u;

    /* renamed from: x, reason: collision with root package name */
    private boolean f14089x;

    /* renamed from: y, reason: collision with root package name */
    private long f14090y;

    /* renamed from: n, reason: collision with root package name */
    protected String f14079n = null;

    /* renamed from: v, reason: collision with root package name */
    private boolean f14087v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f14088w = false;

    @Override // com.beizi.fusion.work.a
    public void e() {
    }

    private void aA() {
        AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickView = this.f14056e.getRegionalClickView();
        if (regionalClickView == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean a6 = a(regionalClickView.getOrderData(), this.f14084s.b());
        AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickView2 = (a6 == null || a6.getRegionalClickView() == null) ? null : a6.getRegionalClickView();
        if (regionalClickView2 != null) {
            EventBean eventBean = this.f14053b;
            if (eventBean != null) {
                eventBean.setRegionalClickUuid(regionalClickView2.getRegionalClickUuid());
                ao();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.f14053b;
        if (eventBean2 != null) {
            eventBean2.setRegionalClickUuid(regionalClickView.getRegionalClickUuid());
            ao();
        }
    }

    private void aB() {
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick = this.f14056e.getFullScreenClick();
        if (fullScreenClick == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean b6 = b(fullScreenClick.getOrderData(), this.f14084s.b());
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick2 = (b6 == null || b6.getFullScreenClick() == null) ? null : b6.getFullScreenClick();
        if (fullScreenClick2 != null) {
            EventBean eventBean = this.f14053b;
            if (eventBean != null) {
                eventBean.setFullScreenClickUuid(fullScreenClick2.getFullScreenClickUuid());
                ao();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.f14053b;
        if (eventBean2 != null) {
            eventBean2.setFullScreenClickUuid(fullScreenClick.getFullScreenClickUuid());
            ao();
        }
    }

    private void aC() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.f14056e.getShakeView();
        if (shakeView == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataShakeViewBean c6 = c(shakeView.getOrderData(), this.f14084s.b());
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView2 = (c6 == null || c6.getShakeView() == null) ? null : c6.getShakeView();
        if (shakeView2 != null) {
            EventBean eventBean = this.f14053b;
            if (eventBean != null) {
                eventBean.setShakeViewUuid(shakeView2.getShakeViewUuid());
                ao();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.f14053b;
        if (eventBean2 != null) {
            eventBean2.setShakeViewUuid(shakeView.getShakeViewUuid());
            ao();
        }
    }

    private void aD() {
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClick = this.f14056e.getScrollClick();
        if (scrollClick == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean d6 = d(scrollClick.getOrderData(), this.f14084s.b());
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClick2 = (d6 == null || d6.getScrollClick() == null) ? null : d6.getScrollClick();
        if (scrollClick2 != null) {
            EventBean eventBean = this.f14053b;
            if (eventBean != null) {
                eventBean.setScrollClickUuid(scrollClick2.getScrollClickUuid());
                ao();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.f14053b;
        if (eventBean2 != null) {
            eventBean2.setScrollClickUuid(scrollClick.getScrollClickUuid());
            ao();
        }
    }

    private void aE() {
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule = this.f14056e.getEulerAngleRule();
        if (eulerAngleRule == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean e6 = e(eulerAngleRule.getOrderData(), this.f14084s.b());
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule2 = (e6 == null || e6.getEulerAngleRule() == null) ? null : e6.getEulerAngleRule();
        if (eulerAngleRule2 != null) {
            EventBean eventBean = this.f14053b;
            if (eventBean != null) {
                eventBean.setEulerAngleUuid(eulerAngleRule2.getEulerAngleUuid());
                ao();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.f14053b;
        if (eventBean2 != null) {
            eventBean2.setEulerAngleUuid(eulerAngleRule.getEulerAngleUuid());
            ao();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay() {
        d dVar = this.f14055d;
        if (dVar == null) {
            return;
        }
        dVar.n().toString();
        Z();
        e eVar = this.f14058g;
        if (eVar == e.SUCCESS) {
            this.f14055d.a(f(), (View) null);
        } else if (eVar == e.FAIL) {
            f();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean c(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBean : list) {
                List<String> orderList = orderDataShakeViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataShakeViewBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.work.a
    public String aw() {
        com.beizi.ad.v2.c.a aVar = this.f14084s;
        if (aVar == null) {
            return null;
        }
        return aVar.h();
    }

    @Override // com.beizi.fusion.work.a
    public JSONObject ax() {
        com.beizi.ad.v2.c.a aVar = this.f14084s;
        if (aVar == null) {
            return null;
        }
        return aVar.m();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0083, code lost:
    
        r6.f14088w = com.beizi.fusion.tool.af.a(java.lang.Integer.parseInt(r3.getRate()));
     */
    @Override // com.beizi.fusion.work.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            r6 = this;
            com.beizi.fusion.c.d r0 = r6.f14055d
            if (r0 != 0) goto L6
            goto Le3
        L6:
            com.beizi.fusion.model.AdSpacesBean$BuyerBean r0 = r6.f14056e
            java.lang.String r0 = r0.getAppId()
            r6.f14059h = r0
            com.beizi.fusion.model.AdSpacesBean$BuyerBean r0 = r6.f14056e
            java.lang.String r0 = r0.getSpaceId()
            r6.f14060i = r0
            com.beizi.fusion.model.AdSpacesBean$BuyerBean r0 = r6.f14056e
            java.lang.String r0 = r0.getBuyerSpaceUuId()
            r6.f14054c = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "complain_config_"
            r0.append(r1)
            java.lang.String r1 = r6.f14060i
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.f14079n = r0
            com.beizi.fusion.model.AdSpacesBean$BuyerBean r0 = r6.f14056e
            com.beizi.fusion.model.AdSpacesBean$FilterBean r0 = r0.getFilter()
            if (r0 == 0) goto L41
            com.beizi.fusion.model.AdSpacesBean$UniteControlBean r0 = r0.getUniteControl()
            r6.f14085t = r0
        L41:
            r0 = 100
            int r0 = com.beizi.fusion.tool.af.b(r0)
            r6.f14086u = r0
            boolean r0 = r6.b()
            if (r0 != 0) goto L59
            r0 = 10170(0x27ba, float:1.4251E-41)
            java.lang.String r1 = java.lang.String.valueOf(r0)
            r6.a(r1, r0)
            return
        L59:
            r0 = 1
            com.beizi.fusion.model.AdSpacesBean$BuyerBean r1 = r6.f14056e     // Catch: java.lang.Exception -> L92
            java.util.List r1 = r1.getCallBackStrategy()     // Catch: java.lang.Exception -> L92
            if (r1 == 0) goto L9a
            int r2 = r1.size()     // Catch: java.lang.Exception -> L92
            if (r2 <= 0) goto L9a
            r6.f14087v = r0     // Catch: java.lang.Exception -> L92
            r2 = 0
        L6b:
            int r3 = r1.size()     // Catch: java.lang.Exception -> L92
            if (r2 >= r3) goto L9a
            java.lang.Object r3 = r1.get(r2)     // Catch: java.lang.Exception -> L92
            com.beizi.fusion.model.AdSpacesBean$CallBackStrategyBean r3 = (com.beizi.fusion.model.AdSpacesBean.CallBackStrategyBean) r3     // Catch: java.lang.Exception -> L92
            java.lang.String r4 = "290.300"
            java.lang.String r5 = r3.getEventCode()     // Catch: java.lang.Exception -> L92
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch: java.lang.Exception -> L92
            if (r4 == 0) goto L94
            java.lang.String r1 = r3.getRate()     // Catch: java.lang.Exception -> L92
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Exception -> L92
            boolean r1 = com.beizi.fusion.tool.af.a(r1)     // Catch: java.lang.Exception -> L92
            r6.f14088w = r1     // Catch: java.lang.Exception -> L92
            goto L9a
        L92:
            r1 = move-exception
            goto L97
        L94:
            int r2 = r2 + 1
            goto L6b
        L97:
            r1.printStackTrace()
        L9a:
            com.beizi.fusion.events.b r1 = r6.f14052a
            if (r1 == 0) goto Lbc
            com.beizi.fusion.events.a r1 = r1.a()
            java.lang.String r2 = r6.f14054c
            com.beizi.fusion.events.EventBean r1 = r1.a(r2)
            r6.f14053b = r1
            if (r1 == 0) goto Lbc
            r6.s()
            r6.t()
            android.content.Context r1 = r6.f14080o
            java.lang.String r2 = r6.f14059h
            com.beizi.fusion.c.l.a(r1, r2)
            r6.u()
        Lbc:
            r6.f()
            long r1 = r6.f14083r
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto Lcd
            android.os.Handler r3 = r6.f14064m
            r3.sendEmptyMessageDelayed(r0, r1)
            goto Le3
        Lcd:
            com.beizi.fusion.c.d r1 = r6.f14055d
            if (r1 == 0) goto Le3
            int r1 = r1.p()
            if (r1 >= r0) goto Le3
            com.beizi.fusion.c.d r0 = r6.f14055d
            int r0 = r0.o()
            r1 = 2
            if (r0 == r1) goto Le3
            r6.k()
        Le3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.a.a.d():void");
    }

    @Override // com.beizi.fusion.work.a
    public String f() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.e.a h() {
        return this.f14061j;
    }

    @Override // com.beizi.fusion.work.a
    public String i() {
        com.beizi.ad.v2.c.a aVar = this.f14084s;
        if (aVar == null) {
            return null;
        }
        return aVar.a();
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean j() {
        return this.f14056e;
    }

    @Override // com.beizi.fusion.work.a
    protected void k() {
        v();
        ab();
        com.beizi.ad.v2.c.a aVar = new com.beizi.ad.v2.c.a(this.f14080o, false);
        this.f14084s = aVar;
        aVar.a(this.f14060i);
        this.f14084s.a(this.f14056e);
        this.f14084s.a(new com.beizi.ad.a() { // from class: com.beizi.fusion.work.a.a.1
            @Override // com.beizi.ad.a
            public void a(int i6) {
                super.a(i6);
                a.this.a(String.valueOf(i6), i6);
            }

            @Override // com.beizi.ad.a
            public void c() {
                if (((com.beizi.fusion.work.a) a.this).f14055d != null && ((com.beizi.fusion.work.a) a.this).f14055d.o() != 2) {
                    ((com.beizi.fusion.work.a) a.this).f14055d.c(a.this.f());
                }
                a.this.F();
            }

            @Override // com.beizi.ad.a
            public void a() {
                super.a();
                ((com.beizi.fusion.work.a) a.this).f14061j = com.beizi.fusion.e.a.ADLOAD;
                if (a.this.f14084s.a() != null) {
                    try {
                        a aVar2 = a.this;
                        aVar2.a(Double.parseDouble(aVar2.f14084s.a()));
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                a aVar3 = a.this;
                aVar3.f14089x = aVar3.f14084s.i();
                if (a.this.f14089x) {
                    a aVar4 = a.this;
                    aVar4.f14090y = aVar4.f14084s.j();
                    ((com.beizi.fusion.work.a) a.this).f14053b.setIsCacheAd("1");
                    if (a.this.f14090y > 0) {
                        ((com.beizi.fusion.work.a) a.this).f14053b.setCacheTime(String.valueOf(System.currentTimeMillis() - a.this.f14090y));
                    }
                    a.this.ao();
                }
                a.this.x();
                if (a.this.Y()) {
                    a.this.ay();
                } else {
                    a.this.P();
                }
                a.this.az();
            }

            @Override // com.beizi.ad.a
            public void b() {
                super.b();
                ((com.beizi.fusion.work.a) a.this).f14061j = com.beizi.fusion.e.a.ADSHOW;
                if (a.this.f14089x) {
                    ((com.beizi.fusion.work.a) a.this).f14053b.setIsCacheAd("1");
                    if (a.this.f14090y > 0) {
                        ((com.beizi.fusion.work.a) a.this).f14053b.setCacheTime(String.valueOf(System.currentTimeMillis() - a.this.f14090y));
                    }
                    a.this.ao();
                }
                if (((com.beizi.fusion.work.a) a.this).f14055d != null && ((com.beizi.fusion.work.a) a.this).f14055d.o() != 2) {
                    ((com.beizi.fusion.work.a) a.this).f14055d.b(a.this.f());
                    a.this.ac();
                }
                a.this.B();
                a.this.V();
                a.this.C();
            }

            @Override // com.beizi.ad.a
            public void e() {
                super.e();
                if (a.this.f14087v && ((com.beizi.fusion.work.a) a.this).f14056e != null) {
                    ((com.beizi.fusion.work.a) a.this).f14053b.setCallBackStrategyUuid(((com.beizi.fusion.work.a) a.this).f14056e.getCallBackStrategyUuid());
                    a.this.ao();
                }
                a.this.E();
                if (a.this.f14087v && !a.this.f14088w) {
                    return;
                }
                if (((com.beizi.fusion.work.a) a.this).f14055d != null && ((com.beizi.fusion.work.a) a.this).f14055d.o() != 2) {
                    ((com.beizi.fusion.work.a) a.this).f14055d.d(a.this.f());
                }
                a.this.D();
                a.this.ad();
            }

            @Override // com.beizi.ad.a
            public void a(String str) {
                super.a(str);
                try {
                    an.a(a.this.f14080o, a.this.f14079n, (Object) Long.valueOf(System.currentTimeMillis()));
                    ((com.beizi.fusion.work.a) a.this).f14053b.setComplain(str);
                    a.this.ao();
                    a.this.H();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        });
        b a6 = new b.a().a();
        this.f14084s.a(true);
        try {
            this.f14084s.a(this.f14053b.m86clone());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        this.f14084s.a((int) this.f14082q);
        this.f14084s.a(this.f14056e);
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equals(g())) {
            this.f14084s.c(g());
            d dVar = this.f14055d;
            if (dVar != null) {
                String w5 = dVar.w();
                if (!TextUtils.isEmpty(w5)) {
                    this.f14084s.b(w5);
                }
            }
        }
        d dVar2 = this.f14055d;
        if (dVar2 != null) {
            this.f14084s.c(dVar2.x());
        }
        this.f14084s.a(a6);
    }

    @Override // com.beizi.fusion.work.a
    public void l() {
        com.beizi.ad.v2.c.a aVar = this.f14084s;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.beizi.fusion.work.a
    protected void z() {
        com.beizi.ad.v2.c.a aVar;
        if (y() && (aVar = this.f14084s) != null && aVar.d()) {
            ag();
        }
    }

    public a(Context context, String str, long j6, long j7, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, d dVar) {
        this.f14080o = context;
        this.f14081p = str;
        this.f14082q = j6;
        this.f14083r = j7;
        this.f14056e = buyerBean;
        this.f14055d = dVar;
        this.f14057f = forwardBean;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        aA();
        aB();
        aC();
        aD();
        aE();
    }

    private boolean b() {
        try {
            AdSpacesBean.UniteControlBean uniteControlBean = this.f14085t;
            if (uniteControlBean == null) {
                return true;
            }
            int random = uniteControlBean.getRandom();
            long duration = this.f14085t.getDuration();
            long longValue = ((Long) an.b(this.f14080o, "uniteTime", 0L)).longValue();
            if (longValue > 0 && duration > 0 && System.currentTimeMillis() - longValue < duration) {
                if (random < this.f14086u && random != 100) {
                    return false;
                }
            }
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return true;
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean e(List<AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBean : list) {
                List<String> orderList = orderDataEulerAngleViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataEulerAngleViewBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        f();
        try {
            if (!b()) {
                a(String.valueOf(10170), 10170);
                return;
            }
            com.beizi.ad.v2.c.a aVar = this.f14084s;
            if (aVar == null || !aVar.d()) {
                return;
            }
            this.f14084s.a(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean b(List<AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBean : list) {
                List<String> orderList = orderDataFullScreenClickBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataFullScreenClickBean;
                }
            }
        }
        return null;
    }

    private AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean a(List<AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBean : list) {
                List<String> orderList = orderDataRegionalClickViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataRegionalClickViewBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.work.a
    public void b(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            com.beizi.ad.v2.c.a aVar = this.f14084s;
            if (aVar == null) {
                return;
            }
            aVar.b(map);
            if (map.containsKey("winPrice") && (obj3 = map.get("winPrice")) != null && (obj3 instanceof String)) {
                String str = (String) obj3;
                if (!TextUtils.isEmpty(str)) {
                    this.f14053b.setWinPrice(str);
                }
            }
            if (map.containsKey("adnId") && (obj2 = map.get("adnId")) != null && (obj2 instanceof String)) {
                String str2 = (String) obj2;
                if (!TextUtils.isEmpty(str2)) {
                    this.f14053b.setAdnId(str2);
                }
            }
            if (map.containsKey("lossReason") && (obj = map.get("lossReason")) != null && (obj instanceof String)) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    this.f14053b.setLossReason(str3);
                }
            }
            ao();
            N();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void a(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            com.beizi.ad.v2.c.a aVar = this.f14084s;
            if (aVar == null) {
                return;
            }
            aVar.a(map);
            if (map.containsKey("winPrice") && (obj4 = map.get("winPrice")) != null && (obj4 instanceof String)) {
                String str = (String) obj4;
                if (!TextUtils.isEmpty(str)) {
                    this.f14053b.setWinPrice(str);
                }
            }
            if (map.containsKey("adnId") && (obj3 = map.get("adnId")) != null && (obj3 instanceof String)) {
                String str2 = (String) obj3;
                if (!TextUtils.isEmpty(str2)) {
                    this.f14053b.setAdnId(str2);
                }
            }
            if (map.containsKey("highestLossPrice") && (obj2 = map.get("highestLossPrice")) != null && (obj2 instanceof String)) {
                String str3 = (String) obj2;
                if (!TextUtils.isEmpty(str3)) {
                    this.f14053b.setHighestLossPrice(str3);
                }
            }
            if (map.containsKey("auctionExt") && (obj = map.get("auctionExt")) != null && (obj instanceof String)) {
                String str4 = (String) obj;
                if (!TextUtils.isEmpty(str4)) {
                    this.f14053b.setSecondPrice(str4);
                }
            }
            ao();
            M();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean d(List<AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBean : list) {
                List<String> orderList = orderDataScrollViewOrderBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataScrollViewOrderBean;
                }
            }
        }
        return null;
    }
}
