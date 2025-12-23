package com.beizi.fusion.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.beizi.fusion.BeiZiInitCallBack;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.tool.ad;
import com.beizi.fusion.tool.ae;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ao;
import com.beizi.fusion.tool.n;
import com.beizi.fusion.tool.x;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f13293a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f13294b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f13295c = "AdManager";

    /* renamed from: d, reason: collision with root package name */
    private static b f13296d;

    /* renamed from: e, reason: collision with root package name */
    private static String f13297e;

    /* renamed from: j, reason: collision with root package name */
    private static String f13298j;

    /* renamed from: k, reason: collision with root package name */
    private static String f13299k;

    /* renamed from: f, reason: collision with root package name */
    private Context f13300f;

    /* renamed from: h, reason: collision with root package name */
    private com.beizi.fusion.update.b f13302h;

    /* renamed from: i, reason: collision with root package name */
    private com.beizi.fusion.events.b f13303i;

    /* renamed from: q, reason: collision with root package name */
    private BeiZiInitCallBack f13309q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f13310r;

    /* renamed from: g, reason: collision with root package name */
    private boolean f13301g = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f13304l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f13305m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f13306n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f13307o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f13308p = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0009, B:5:0x0019, B:8:0x002b, B:15:0x0058, B:17:0x0072, B:19:0x0082, B:24:0x0095, B:26:0x009d, B:27:0x00a7, B:29:0x004d), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0095 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0009, B:5:0x0019, B:8:0x002b, B:15:0x0058, B:17:0x0072, B:19:0x0082, B:24:0x0095, B:26:0x009d, B:27:0x00a7, B:29:0x004d), top: B:2:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void t() {
        /*
            r10 = this;
            r0 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "0"
            java.lang.String r2 = "SM_STATUS"
            android.content.Context r3 = r10.f13300f     // Catch: java.lang.Throwable -> L43
            com.beizi.fusion.model.ResponseInfo r3 = com.beizi.fusion.model.ResponseInfo.getInstance(r3)     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = r3.getSmFlag()     // Catch: java.lang.Throwable -> L43
            boolean r3 = r1.equals(r3)     // Catch: java.lang.Throwable -> L43
            if (r3 == 0) goto Lb0
            android.content.Context r3 = r10.f13300f     // Catch: java.lang.Throwable -> L43
            java.lang.Object r3 = com.beizi.fusion.tool.an.b(r3, r2, r0)     // Catch: java.lang.Throwable -> L43
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L43
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L43
            java.lang.String r4 = "SM_STATUS_EXPIRE_TIME"
            r5 = 3
            r6 = 1
            if (r3 != r6) goto L45
            android.content.Context r3 = r10.f13300f     // Catch: java.lang.Throwable -> L43
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L43
            com.beizi.fusion.tool.an.a(r3, r2, r7)     // Catch: java.lang.Throwable -> L43
            android.content.Context r3 = r10.f13300f     // Catch: java.lang.Throwable -> L43
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L43
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L43
            com.beizi.fusion.tool.an.a(r3, r4, r7)     // Catch: java.lang.Throwable -> L43
            r3 = 3
            goto L45
        L43:
            r0 = move-exception
            goto Lb1
        L45:
            r7 = 2
            if (r3 == 0) goto L4d
            if (r3 != r7) goto L4b
            goto L4d
        L4b:
            r6 = r3
            goto L56
        L4d:
            android.content.Context r3 = r10.f13300f     // Catch: java.lang.Throwable -> L43
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L43
            com.beizi.fusion.tool.an.a(r3, r2, r8)     // Catch: java.lang.Throwable -> L43
        L56:
            if (r6 != r5) goto L95
            android.content.Context r3 = r10.f13300f     // Catch: java.lang.Throwable -> L43
            long r5 = java.lang.Long.parseLong(r1)     // Catch: java.lang.Throwable -> L43
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L43
            java.lang.Object r3 = com.beizi.fusion.tool.an.b(r3, r4, r5)     // Catch: java.lang.Throwable -> L43
            java.lang.Long r3 = (java.lang.Long) r3     // Catch: java.lang.Throwable -> L43
            long r5 = r3.longValue()     // Catch: java.lang.Throwable -> L43
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto Lb0
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L43
            long r7 = r3.longValue()     // Catch: java.lang.Throwable -> L43
            long r5 = r5 - r7
            r7 = 864000000(0x337f9800, double:4.26872718E-315)
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 <= 0) goto Lb0
            android.content.Context r3 = r10.f13300f     // Catch: java.lang.Throwable -> L43
            com.beizi.fusion.tool.an.a(r3, r2, r0)     // Catch: java.lang.Throwable -> L43
            android.content.Context r0 = r10.f13300f     // Catch: java.lang.Throwable -> L43
            long r1 = java.lang.Long.parseLong(r1)     // Catch: java.lang.Throwable -> L43
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L43
            com.beizi.fusion.tool.an.a(r0, r4, r1)     // Catch: java.lang.Throwable -> L43
            return
        L95:
            android.content.Context r0 = r10.f13300f     // Catch: java.lang.Throwable -> L43
            boolean r0 = com.beizi.fusion.sm.b.a.a(r0)     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto La7
            android.content.Context r0 = r10.f13300f     // Catch: java.lang.Throwable -> L43
            com.beizi.fusion.c.b$3 r1 = new com.beizi.fusion.c.b$3     // Catch: java.lang.Throwable -> L43
            r1.<init>()     // Catch: java.lang.Throwable -> L43
            com.beizi.fusion.sm.b.a.a(r0, r1)     // Catch: java.lang.Throwable -> L43
        La7:
            android.content.Context r0 = r10.f13300f     // Catch: java.lang.Throwable -> L43
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L43
            com.beizi.fusion.tool.an.a(r0, r2, r1)     // Catch: java.lang.Throwable -> L43
        Lb0:
            return
        Lb1:
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.c.b.t():void");
    }

    public static b a() {
        if (f13296d == null) {
            synchronized (b.class) {
                try {
                    if (f13296d == null) {
                        f13296d = new b();
                    }
                } finally {
                }
            }
        }
        return f13296d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        BeiZiInitCallBack beiZiInitCallBack;
        if (!this.f13307o) {
            n.a().a(this.f13300f);
        }
        ResponseInfo.getInstance(this.f13300f).init();
        if (!this.f13305m) {
            this.f13303i.f13486a.a(1);
            l();
        }
        g();
        if (!this.f13305m && this.f13303i.f13486a.a() == 1) {
            this.f13303i.f13486a.a(2);
        }
        if (BeiZis.isIsSyncInit() || (beiZiInitCallBack = this.f13309q) == null) {
            return;
        }
        beiZiInitCallBack.success();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        try {
            new com.beizi.fusion.d.a.b(ad.f13585b).a(this.f13300f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        try {
            if (Build.BRAND.equalsIgnoreCase("HONOR")) {
                String str = (String) an.b(this.f13300f, "__HONOROAID__", "");
                if (!TextUtils.isEmpty(str) && RequestInfo.getInstance(this.f13300f).getDevInfo() != null) {
                    RequestInfo.getInstance(this.f13300f).getDevInfo().setHonorOaid(str);
                }
                com.beizi.fusion.tool.e.b().c().execute(new Runnable() { // from class: com.beizi.fusion.c.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        String a6 = com.beizi.fusion.sm.a.a.a(b.this.f13300f);
                        String unused = b.f13295c;
                        if (!TextUtils.isEmpty(a6)) {
                            an.a(b.this.f13300f, "__HONOROAID__", (Object) a6);
                        }
                        if (TextUtils.isEmpty(a6) || RequestInfo.getInstance(b.this.f13300f).getDevInfo() == null) {
                            return;
                        }
                        RequestInfo.getInstance(b.this.f13300f).getDevInfo().setHonorOaid(a6);
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void v() {
        try {
            com.beizi.fusion.update.b.a(this.f13300f).b(5);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public String b() {
        return f13293a;
    }

    public String c() {
        return f13298j;
    }

    public String d() {
        return f13299k;
    }

    public Context e() {
        return this.f13300f;
    }

    public com.beizi.fusion.events.b f() {
        return this.f13303i;
    }

    public void h() {
        if (this.f13310r) {
            return;
        }
        this.f13310r = true;
        if (ae.b()) {
            if (BeiZis.isLimitPersonalAds()) {
                return;
            }
            if (BeiZis.getCustomController() != null && (BeiZis.getCustomController() == null || !BeiZis.getCustomController().isCanUseOaid())) {
                return;
            }
        }
        com.beizi.fusion.tool.e.b().c().execute(new Runnable() { // from class: com.beizi.fusion.c.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.u();
                b.this.t();
            }
        });
    }

    public boolean i() {
        return this.f13305m;
    }

    public boolean j() {
        return this.f13306n;
    }

    public void l() {
        Context context = this.f13300f;
        if (context != null && this.f13302h == null) {
            if (ResponseInfo.getInstance(context).isInit()) {
                EventCar.getInstance(this.f13300f).goRoad(new EventBean(f13294b, "", "410.000", "", a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                EventCar.getInstance(this.f13300f).goRoad(new EventBean(f13294b, "", "410.200", "", a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            } else {
                EventCar.getInstance(this.f13300f).goRoad(new EventBean(f13294b, "", "410.000", "", a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                EventCar.getInstance(this.f13300f).goRoad(new EventBean(f13294b, "", "410.500", "", a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            }
            com.beizi.fusion.update.b a6 = com.beizi.fusion.update.b.a(this.f13300f);
            this.f13302h = a6;
            a6.b(0);
        }
    }

    public boolean m() {
        return this.f13308p;
    }

    public String b(String str) {
        String str2;
        String str3;
        try {
            if (TextUtils.isEmpty(str) || this.f13300f == null || !this.f13301g) {
                return null;
            }
            h();
            AdSpacesBean adSpaceBean = ResponseInfo.getInstance(this.f13300f).getAdSpaceBean(str);
            if (adSpaceBean == null) {
                v();
                return l.a(this.f13300f, null, null);
            }
            List<AdSpacesBean.BuyerBean> buyer = adSpaceBean.getBuyer();
            if (buyer != null && !buyer.isEmpty()) {
                Iterator<AdSpacesBean.BuyerBean> it = buyer.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str2 = null;
                        str3 = null;
                        break;
                    }
                    AdSpacesBean.BuyerBean next = it.next();
                    if (next != null && AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(next.getBidType())) {
                        str2 = next.getAppId();
                        str3 = next.getSpaceId();
                        break;
                    }
                }
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    return l.a(this.f13300f, str2, str3);
                }
                v();
                return l.a(this.f13300f, null, null);
            }
            v();
            return l.a(this.f13300f, null, null);
        } catch (Exception e6) {
            e6.printStackTrace();
            return l.a(this.f13300f, null, null);
        }
    }

    public void g() {
        if (ae.b()) {
            if (!BeiZis.isLimitPersonalAds()) {
                if (BeiZis.getCustomController() != null && (BeiZis.getCustomController() == null || !BeiZis.getCustomController().isCanUseOaid())) {
                    return;
                }
            } else {
                return;
            }
        }
        String str = (String) an.b(this.f13300f, "__OAID__", "");
        if (!TextUtils.isEmpty(str) && RequestInfo.getInstance(this.f13300f).getDevInfo() != null) {
            RequestInfo.getInstance(this.f13300f).getDevInfo().setOaid(str);
        }
    }

    public void k() {
        h();
        if (this.f13305m && this.f13301g && this.f13300f != null && this.f13303i.f13486a.a() == 0) {
            this.f13303i.f13486a.a(1);
            this.f13303i.f13486a.a(2);
        }
    }

    public boolean n() {
        if (BeiZis.getCustomController() == null || !BeiZis.getCustomController().forbidSensor() || ResponseInfo.getInstance(this.f13300f).isOpenSensor()) {
            return false;
        }
        return true;
    }

    public boolean o() {
        if (BeiZis.getCustomController() == null || BeiZis.getCustomController().isCanUseAndroidId()) {
            return true;
        }
        return false;
    }

    public String p() {
        if (BeiZis.getCustomController() == null) {
            return "";
        }
        return BeiZis.getCustomController().getAndroidId();
    }

    public b a(String str) {
        f13297e = str;
        return f13296d;
    }

    public void a(Context context, String str, String str2, String str3) {
        BeiZiInitCallBack beiZiInitCallBack;
        synchronized (b.class) {
            try {
                if (context != null) {
                    if (!this.f13301g) {
                        this.f13300f = StubApp.getOrigApplicationContext(context.getApplicationContext());
                        String a6 = ao.a();
                        f13294b = a6;
                        EventBean eventBean = new EventBean(a6, "", "", "", str, "", "", String.valueOf(System.currentTimeMillis()), "");
                        com.beizi.fusion.events.b bVar = new com.beizi.fusion.events.b(eventBean);
                        this.f13303i = bVar;
                        f13293a = str;
                        f13298j = str2;
                        f13299k = str3;
                        bVar.f13486a.addObserver(bVar);
                        this.f13303i.a().a(eventBean);
                        AppEventId.getInstance(this.f13300f).setAppStart();
                        AppEventId.getInstance(this.f13300f).setAppSdkInit();
                        x.a().b(this.f13300f);
                        if (this.f13303i.f13486a.a() == 0) {
                            if (BeiZis.isIsSyncInit()) {
                                r();
                            } else {
                                com.beizi.fusion.tool.e.b().c().execute(new Runnable() { // from class: com.beizi.fusion.c.b.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.r();
                                    }
                                });
                            }
                            this.f13301g = true;
                        }
                    } else if (!BeiZis.isIsSyncInit() && (beiZiInitCallBack = this.f13309q) != null) {
                        beiZiInitCallBack.success();
                    }
                } else {
                    throw new IllegalArgumentException("Context cannot be null.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        try {
            if (map.containsKey("forbid_config_network")) {
                Object obj = map.get("forbid_config_network");
                if (obj instanceof Boolean) {
                    this.f13305m = ((Boolean) obj).booleanValue();
                }
            }
            if (map.containsKey("speed_first_strategy")) {
                Object obj2 = map.get("speed_first_strategy");
                if (obj2 instanceof Boolean) {
                    this.f13306n = ((Boolean) obj2).booleanValue();
                }
            }
            if (map.containsKey("forbid_collect_crash")) {
                Object obj3 = map.get("forbid_collect_crash");
                if (obj3 instanceof Boolean) {
                    this.f13307o = ((Boolean) obj3).booleanValue();
                }
            }
            if (map.containsKey("forbid_verify_window_focus")) {
                Object obj4 = map.get("forbid_verify_window_focus");
                if (obj4 instanceof Boolean) {
                    this.f13308p = ((Boolean) obj4).booleanValue();
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(BeiZiInitCallBack beiZiInitCallBack) {
        this.f13309q = beiZiInitCallBack;
    }
}
