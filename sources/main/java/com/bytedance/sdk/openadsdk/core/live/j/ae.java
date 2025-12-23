package com.bytedance.sdk.openadsdk.core.live.j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.jy.j;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.live.j.m;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.f;
import com.bytedance.sdk.openadsdk.core.tj.c;
import com.bytedance.sdk.openadsdk.core.tj.gx;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qb;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.x;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends m {
    protected String ae;
    private volatile Set<String> qv;

    /* renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f29461g = new AtomicBoolean(false);
    public volatile com.bytedance.sdk.openadsdk.av.r tl = null;
    private volatile int oq = -5;
    private volatile boolean vl = false;
    private final long jy = System.currentTimeMillis();
    private volatile boolean ws = false;
    private long az = -1;

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public void r() {
        if (this.f29472j == null || !m()) {
            return;
        }
        xt("warmingUpBeforeEnter");
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public int up() {
        Object xt;
        return (this.f29472j == null || !m() || (xt = xt("hasAuthenticated")) == null || !(xt instanceof Boolean)) ? false : ((Boolean) xt).booleanValue() ? 2 : 1;
    }

    private Map av() {
        String xt;
        Map hashMap = new HashMap();
        hashMap.put("app_name", v.getContext().getPackageName());
        gx xp = v.xt().xp();
        if (xp != null) {
            hashMap.put("partner", xp.cw());
            hashMap.put("p_secret", xp.r());
            hashMap.put("g_appid", String.valueOf(xp.xt()));
        }
        hashMap.put("channel", "csj_channel");
        hashMap.put("debug", Boolean.valueOf(vl.cw()));
        hashMap.put("ec_host_appid", "1371");
        HashMap hashMap2 = new HashMap();
        if (!oq.i().tl()) {
            hashMap2.put("enable_init_oaid", "false");
        }
        if (!oq.i().up()) {
            hashMap2.put("can_use_sensor", "false");
        }
        if (oq.i().oq()) {
            String j6 = f.j(false);
            if (!oq.i().ae() || TextUtils.isEmpty(j6)) {
                xt = f.xt(this.tl);
            } else {
                hashMap2.remove("enable_init_oaid");
                xt = f.xt(j6);
            }
            if (!TextUtils.isEmpty(xt)) {
                hashMap2.put("oaid_object", xt);
            }
        }
        com.bytedance.sdk.openadsdk.core.p.xt ay = v.xt().ay();
        if (ay != null) {
            boolean j7 = ay.j();
            vl.j("TTLiveSDkBridge", "INIT_SUB_PROCESS=", Boolean.valueOf(j7));
            hashMap.put("sub_process", Boolean.valueOf(j7));
        }
        hashMap.put("c_control", oq.i().w());
        com.bytedance.sdk.openadsdk.core.p.xt ay2 = v.xt().ay();
        if (ay2 == null) {
            j(hashMap, hashMap2);
            return hashMap;
        }
        JSONObject cw = ay2.cw();
        if (cw == null) {
            j(hashMap, hashMap2);
            return hashMap;
        }
        Iterator<String> keys = cw.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap2.put(next, String.valueOf(cw.opt(next)));
        }
        hashMap.put("live_tob_init_extra", hashMap2);
        return hashMap;
    }

    private String cw(int i6) {
        char[] charArray = String.valueOf(i6).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < charArray.length; i7++) {
            sb.append(charArray[i7]);
            if (i7 < charArray.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Object xt = xt("getLiveSdkConfig");
        if (xt == null || !(xt instanceof JSONObject)) {
            return;
        }
        this.cw = (JSONObject) xt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004d, code lost:
    
        r0 = r0.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6).j(java.lang.Boolean.class).j(0, "com.byted.live.lite").xt());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void jy() {
        /*
            r5 = this;
            java.lang.String r0 = "doInitLive"
            java.lang.String r1 = "TTLiveSDkBridge"
            com.bytedance.sdk.component.utils.vl.j(r1, r0)
            java.util.function.Function<android.util.SparseArray<java.lang.Object>, java.lang.Object> r0 = r5.f29472j
            r2 = 2
            if (r0 != 0) goto L16
            com.bytedance.sdk.openadsdk.core.oq r0 = com.bytedance.sdk.openadsdk.core.oq.i()
            java.util.function.Function r0 = r0.m(r2)
            r5.f29472j = r0
        L16:
            java.util.function.Function<android.util.SparseArray<java.lang.Object>, java.lang.Object> r0 = r5.f29472j
            r3 = 0
            if (r0 == 0) goto L3e
            java.util.function.Function<android.util.SparseArray<java.lang.Object>, java.lang.Object> r0 = r5.f29472j
            com.bytedance.sdk.openadsdk.i.r r1 = com.bytedance.sdk.openadsdk.i.r.j()
            r4 = 9
            com.bytedance.sdk.openadsdk.i.r r1 = r1.j(r4)
            java.lang.Class<java.lang.Void> r4 = java.lang.Void.class
            com.bytedance.sdk.openadsdk.i.r r1 = r1.j(r4)
            com.bytedance.sdk.openadsdk.core.live.xt.j r4 = new com.bytedance.sdk.openadsdk.core.live.xt.j
            r4.<init>(r5)
            com.bytedance.sdk.openadsdk.i.r r1 = r1.j(r3, r4)
            android.util.SparseArray r1 = r1.xt()
            com.bytedance.msdk.core.ae.a.a(r0, r1)
            goto L43
        L3e:
            java.lang.String r0 = "No bridge for live"
            com.bytedance.sdk.component.utils.vl.xt(r1, r0)
        L43:
            com.bytedance.sdk.openadsdk.core.oq r0 = com.bytedance.sdk.openadsdk.core.oq.i()
            java.util.function.Function r0 = r0.qb()
            if (r0 == 0) goto L72
            com.bytedance.sdk.openadsdk.i.r r1 = com.bytedance.sdk.openadsdk.i.r.j()
            r4 = 6
            com.bytedance.sdk.openadsdk.i.r r1 = r1.j(r4)
            java.lang.Class<java.lang.Boolean> r4 = java.lang.Boolean.class
            com.bytedance.sdk.openadsdk.i.r r1 = r1.j(r4)
            java.lang.String r4 = "com.byted.live.lite"
            com.bytedance.sdk.openadsdk.i.r r1 = r1.j(r3, r4)
            android.util.SparseArray r1 = r1.xt()
            java.lang.Object r0 = com.bytedance.msdk.core.ae.a.a(r0, r1)
            if (r0 == 0) goto L72
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r3 = r0.booleanValue()
        L72:
            if (r3 == 0) goto L7b
            int r0 = r5.oq
            if (r0 == r2) goto L7b
            r0 = 1
            r5.oq = r0
        L7b:
            int r0 = r5.xt()
            java.lang.String r1 = "0"
            java.lang.String r3 = "1"
            if (r0 <= 0) goto L87
            r0 = r3
            goto L88
        L87:
            r0 = r1
        L88:
            r4 = 21
            com.bytedance.sdk.openadsdk.tools.xt.cw(r4, r0)
            int r0 = r5.xt()
            if (r0 != r2) goto L94
            r1 = r3
        L94:
            r0 = 20
            com.bytedance.sdk.openadsdk.tools.xt.cw(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.live.j.ae.jy():void");
    }

    private void oq() {
        if (this.ws) {
            vl.j("TTLiveSDkBridge", "tryLoad saas hasLoaded");
            return;
        }
        if (vl()) {
            this.ws = true;
            tl.cw().postDelayed(new g("live_init_delay") { // from class: com.bytedance.sdk.openadsdk.core.live.j.ae.2
                @Override // java.lang.Runnable
                public void run() {
                    ae.this.jy();
                }
            }, qv());
        } else {
            vl.j("TTLiveSDkBridge", "tryLoad saas failed mHasSaasMetaClicked = " + this.vl);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public boolean m() {
        return this.oq == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public JSONObject tl() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public int xt() {
        return this.oq;
    }

    public ae() {
        if (com.bytedance.sdk.openadsdk.l.ae.j()) {
            com.bytedance.sdk.openadsdk.l.ae.cw(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.j.ae.1
                @Override // java.lang.Runnable
                public void run() {
                    ae.this.g();
                }
            });
        } else {
            g();
        }
    }

    private boolean az() {
        com.bytedance.sdk.openadsdk.core.p.oq xt = v.xt();
        gx xp = xt.xp();
        int xt2 = oq.i().s().xt();
        if (xp != null && xp.up() && xt.id() && xt2 != 4 && xt2 != 5) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ws();
        this.ae = j(v.getContext());
        oq.i().j("com.byted.live.lite", this.ae, this.up, null);
        if (!v.xt().id()) {
            this.oq = -4;
            vl.xt("TTLiveSDkBridge", "forbiddom init live");
        } else {
            oq();
            this.az = com.bytedance.sdk.openadsdk.core.xt.j().xt("live_last_init_time", 0L);
        }
    }

    private String j(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("ZEUS_PLUGIN_LIVE");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return cw(new JSONObject(string).optInt("apiVersionCode"));
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    private long qv() {
        com.bytedance.sdk.openadsdk.core.p.xt ay = v.xt().ay();
        long j6 = com.bytedance.sdk.openadsdk.core.p.r.f29833j;
        if (ay != null) {
            j6 = ay.xt();
        }
        if (System.currentTimeMillis() - this.jy > j6) {
            return 0L;
        }
        return j6;
    }

    private boolean vl() {
        if (oq.i().oq() && this.tl == null) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.p.xt ay = v.xt().ay();
        if (ay != null) {
            if (ay.up()) {
                return this.vl;
            }
            return true;
        }
        if (com.bytedance.sdk.openadsdk.core.p.r.xt) {
            return this.vl;
        }
        return true;
    }

    private void ws() {
        Function<SparseArray<Object>, Object> qb = oq.i().qb();
        if (qb == null) {
            return;
        }
        a_((String) j(qb, 8, String.class));
    }

    private Object xt(String str) {
        Object apply;
        if (this.oq != 2) {
            vl.xt("TTLiveSDkBridge", "callSimpleExpandMethod " + str + " failed for plugin state = " + this.oq);
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("expand_method_name", str);
        if (this.f29472j == null) {
            return null;
        }
        apply = this.f29472j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(7).j(Void.class).j(0, hashMap).xt());
        return apply;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.j, com.bytedance.sdk.openadsdk.core.live.j.r
    public void r(n nVar) {
        if (nVar == null || this.vl || !up(nVar)) {
            return;
        }
        this.vl = true;
        g();
    }

    private boolean up(n nVar) {
        JSONObject ot = nVar.ot();
        if (ot == null) {
            return false;
        }
        if (ot.optInt("landing_type", 0) != 4 && TextUtils.isEmpty(nVar.re())) {
            return com.bytedance.sdk.openadsdk.core.live.up.j.j(nVar);
        }
        return true;
    }

    private boolean cw(String str) {
        if (str.startsWith("csj_saas")) {
            return true;
        }
        if (this.qv == null) {
            this.qv = new HashSet(11);
            this.qv.add("saas_easyplayable");
            this.qv.add("real_auth_status");
            this.qv.add("live_panel");
            this.qv.add("live_exit");
            this.qv.add("mnpl_user_close");
            this.qv.add("clickarea");
            this.qv.add("enterSection");
            this.qv.add("mini_playable_real_show");
            this.qv.add("mnpl_user_close");
            this.qv.add("mnpl_sdk_lifecycle_status");
        }
        return this.qv.contains(str);
    }

    private <T> T j(Function<SparseArray<Object>, Object> function, int i6, Class<T> cls) {
        Object apply;
        apply = function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(i6).j((Class<?>) cls).j(0, "com.byted.live.lite").xt());
        T t5 = (T) apply;
        if (t5 != null) {
            return t5;
        }
        return null;
    }

    private JSONObject xt(int i6, String str) {
        c yx;
        JSONArray tl;
        if (this.f29473m != null && this.f29473m.get() != null) {
            n nVar = this.f29473m.get();
            if (TextUtils.equals(nVar.uv(), str) && (yx = nVar.yx()) != null && (tl = yx.tl()) != null && tl.length() != 0) {
                int length = tl.length();
                for (int i7 = 0; i7 < length; i7++) {
                    JSONObject optJSONObject = tl.optJSONObject(i7);
                    if (optJSONObject.optInt("type") == i6) {
                        return optJSONObject;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.j, com.bytedance.sdk.openadsdk.core.live.j.r
    public void j() {
        if (this.f29461g.get()) {
            vl.xt("TTLiveSDkBridge", "already init!");
            return;
        }
        if (this.oq != 5) {
            vl.xt("TTLiveSDkBridge", "plugin not Load! " + this.oq);
            return;
        }
        if (this.oq == 2) {
            vl.xt("TTLiveSDkBridge", "init started or successed:" + this.oq);
        } else {
            if (!az()) {
                vl.xt("TTLiveSDkBridge", "init live failed！ not valid env！");
                return;
            }
            if (!com.bytedance.sdk.openadsdk.core.live.up.xt.cw(this.up)) {
                com.bytedance.sdk.openadsdk.core.live.up.xt.r(this.up);
                return;
            }
            this.f29461g.set(true);
            com.bytedance.sdk.openadsdk.core.live.up.xt.j(this.up);
            this.oq = 4;
            if (this.f29472j != null) {
                vl.j("TTLiveSDkBridge", "liveSDkBridge init invoke 5500");
                this.f29472j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(5).j(Void.class).j(0, av()).xt());
            }
            com.bytedance.sdk.openadsdk.core.live.up.xt.xt(this.up);
        }
    }

    public void xt(Map<String, String> map) {
        com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar;
        if (map == null || map.size() == 0) {
            return;
        }
        String str = map.get("type");
        String str2 = map.get(NotificationCompat.CATEGORY_STATUS);
        String str3 = map.get("open_uid");
        String str4 = map.get("task_key");
        if ("1".equals(str2) && !TextUtils.isEmpty(str)) {
            try {
                JSONObject optJSONObject = xt(Integer.parseInt(str), str4).optJSONObject(JThirdPlatFormInterface.KEY_EXTRA);
                if (optJSONObject == null) {
                    return;
                }
                String optString = optJSONObject.optString("callback");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(optString);
                if (!TextUtils.isEmpty(jSONObject.optString(CommonNetImpl.NAME)) && (xtVar = (com.bytedance.sdk.openadsdk.i.cw.j.xt) x.j(this.f29474r, com.bytedance.sdk.openadsdk.i.cw.j.xt.class)) != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("open_uid", str3);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.opt(next));
                    }
                    xtVar.j(3, hashMap);
                    return;
                }
                return;
            } catch (Exception e6) {
                vl.xt("TTLiveSDkBridge", "onTaskFinish parse extra error", e6);
                return;
            }
        }
        vl.xt("TTLiveSDkBridge", "onTaskFinish status is :" + str2);
    }

    public void cw(Map<String, String> map) {
        com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar = (com.bytedance.sdk.openadsdk.i.cw.j.xt) x.j(this.f29474r, com.bytedance.sdk.openadsdk.i.cw.j.xt.class);
        if (xtVar == null) {
            return;
        }
        xtVar.j(4, map);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.j, com.bytedance.sdk.openadsdk.core.live.j.r
    public long cw() {
        return this.az;
    }

    private void j(Map map, Map<String, Object> map2) {
        map2.put("allow_apm_init", com.bytedance.sdk.openadsdk.core.p.r.cw);
        map2.put("allow_npth_init", com.bytedance.sdk.openadsdk.core.p.r.f29835r);
        map2.put("allow_vlog_init", com.bytedance.sdk.openadsdk.core.p.r.up);
        map2.put("sec_init_use_thread", com.bytedance.sdk.openadsdk.core.p.r.f29834m);
        map.put("live_tob_init_extra", map2);
    }

    public void j(int i6, String str, boolean z5) {
        this.oq = i6;
        if (i6 == -3) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("msg", str);
                jSONObject.putOpt("pkg", "com.byted.live.lite");
            } catch (JSONException unused) {
            }
            ws.j().j(TTAdConstant.KEY_INIT_FOR_LIVE, jSONObject, (Throwable) null);
            return;
        }
        if (i6 == 1) {
            com.bytedance.sdk.openadsdk.tools.xt.cw(21, "1");
            return;
        }
        if (i6 != 2) {
            return;
        }
        if (!z5) {
            ws.j().j(true);
        }
        com.bytedance.sdk.openadsdk.tools.xt.cw(21, "1");
        com.bytedance.sdk.openadsdk.tools.xt.cw(20, "1");
        ws();
        i();
        this.az = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.core.xt.j().j("live_last_init_time", this.az);
    }

    public void j(boolean z5, String str) {
        String str2;
        com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar;
        com.bytedance.sdk.openadsdk.l.ae.j(new g("getLiveSdk") { // from class: com.bytedance.sdk.openadsdk.core.live.j.ae.3
            @Override // java.lang.Runnable
            public void run() {
                ae.this.i();
            }
        });
        if (this.f29473m != null && this.f29473m.get() != null) {
            com.bytedance.sdk.openadsdk.core.jy.cw.j(z5 ? 2 : 1, this.xt != null ? this.xt : "", this.f29473m.get());
        }
        if (!z5 || (str2 = this.f29474r) == null || (xtVar = (com.bytedance.sdk.openadsdk.i.cw.j.xt) x.j(str2, com.bytedance.sdk.openadsdk.i.cw.j.xt.class)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("open_uid", str);
        xtVar.j(1, hashMap);
        j(10002, this.f29474r);
    }

    private JSONObject j(int i6, String str) {
        JSONObject xt = xt(i6, str);
        if (xt != null) {
            try {
                xt.putOpt(NotificationCompat.CATEGORY_STATUS, 1);
            } catch (JSONException unused) {
            }
            n nVar = this.f29473m.get();
            if (nVar != null) {
                com.bytedance.sdk.openadsdk.core.live.r.j.j(str, nVar.fs() + "_" + i6);
            }
        }
        return xt;
    }

    public void j(Map<String, String> map) {
        String str = map.get("label");
        final String str2 = map.get("req_id");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!cw(str)) {
            vl.xt("TTLiveSDkBridge", "not valid label " + str);
            return;
        }
        n nVar = this.f29473m != null ? this.f29473m.get() : null;
        final String str3 = map.get("ad_extra_data");
        com.bytedance.sdk.openadsdk.m.j.j jVar = new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.live.j.ae.4
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(str3);
                jSONObject2.put("req_id", str2);
                jSONObject.put("ad_extra_data", jSONObject2);
            }
        };
        if (nVar != null) {
            com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar, this.xt, str, jVar);
            String ej = nVar.ej();
            if (TextUtils.equals(ej, str2)) {
                return;
            }
            j(str2, str, "mate req is " + ej);
            return;
        }
        new j.C0460j().j(this.xt).xt(str).j(jVar);
        j(str2, str, TTAdConstant.MATE_IS_NULL_MSG);
    }

    private void j(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("req_id", str);
            jSONObject.putOpt("label", str2);
            jSONObject.putOpt("mesage", str3);
        } catch (JSONException unused) {
        }
        ws.j().j("reportPangleEvent", jSONObject, (Throwable) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.m, com.bytedance.sdk.openadsdk.core.live.j.r
    public int j(final n nVar, final cw cwVar, final String str) {
        if (nVar == null) {
            return 0;
        }
        final String qb = nVar.qb();
        if (TextUtils.isEmpty(qb)) {
            return 0;
        }
        if (this.oq != 2) {
            return -1;
        }
        this.xt = str;
        this.f29473m = new SoftReference<>(nVar);
        qb uw = nVar.uw();
        if (2 != up() && uw != null) {
            final boolean z5 = uw.r() == 1;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final long currentTimeMillis = System.currentTimeMillis();
            if (j(nVar, new m.j() { // from class: com.bytedance.sdk.openadsdk.core.live.j.ae.5
                @Override // com.bytedance.sdk.openadsdk.core.live.j.m.j
                public void j(boolean z6) {
                    boolean z7;
                    if (atomicBoolean.compareAndSet(false, true)) {
                        ae.this.j(nVar, cwVar, qb, z6, z5, str, 1);
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                    ws.j().j(nVar, System.currentTimeMillis() - currentTimeMillis, z6, z7);
                }
            }, true)) {
                long up = uw.up();
                if (up > 0) {
                    tl.xt().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.j.ae.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                ae.this.j(nVar, cwVar, qb, false, z5, str, 2);
                            }
                        }
                    }, up);
                }
                return 2;
            }
        }
        int j6 = j(qb);
        j(j6, nVar, false, 0);
        return j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(n nVar, cw cwVar, String str, boolean z5, boolean z6, String str2, int i6) {
        int j6 = j(str);
        vl.j("TTLiveSDkBridge", "auth result:" + z5 + ", schema handle:" + j6);
        j(j6, nVar, z5, i6);
        if (j6 != 1) {
            if (cwVar != null) {
                cwVar.j(j6);
            }
        } else {
            if (z5 || !z6) {
                return;
            }
            new com.bytedance.sdk.openadsdk.core.live.cw.j().j(str2).j(v.getContext(), nVar);
        }
    }

    private void j(int i6, n nVar, boolean z5, int i7) {
        if (nVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("handle_result", Integer.valueOf(i6));
            jSONObject.put("req_id", nVar.ej());
            jSONObject.put("auth", z5);
            qb uw = nVar.uw();
            if (uw != null) {
                jSONObject.put("saas_info", uw.j());
            }
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i7);
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, nVar.os());
        } catch (Exception unused) {
        }
        ws.j().xt(jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.j.r
    public void j(com.bytedance.sdk.openadsdk.av.r rVar) {
        this.tl = rVar;
        g();
    }
}
