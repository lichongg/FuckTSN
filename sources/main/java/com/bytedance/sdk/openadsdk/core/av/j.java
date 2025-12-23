package com.bytedance.sdk.openadsdk.core.av;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.qv.cw.oq;
import com.bytedance.sdk.openadsdk.core.qv.tl;
import com.bytedance.sdk.openadsdk.core.qv.xt.r;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.i;
import com.bytedance.sdk.openadsdk.core.tj.m;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.tj;
import com.bytedance.sdk.openadsdk.core.tj.up;
import com.bytedance.sdk.openadsdk.core.tj.xp;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements cw {
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private final n f27955j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.qv.xt.j f27956m;
    private final xt xt;

    /* renamed from: r, reason: collision with root package name */
    private final Map<String, com.bytedance.sdk.openadsdk.core.qv.xt.r> f27957r = new HashMap();
    private boolean up = true;
    private boolean ae = false;

    public static j j(xt xtVar, n nVar, boolean z5) {
        return new j(xtVar, nVar, z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.av.cw
    public void xt() {
        Iterator<com.bytedance.sdk.openadsdk.core.qv.xt.r> it = this.f27957r.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private j(xt xtVar, n nVar, boolean z5) {
        this.xt = xtVar;
        this.f27955j = nVar;
        this.cw = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.av.cw
    public void cw() {
        xt();
        for (com.bytedance.sdk.openadsdk.core.qv.xt.r rVar : this.f27957r.values()) {
            if (rVar != null) {
                rVar.xt();
            }
        }
        this.f27957r.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.av.cw
    public void j() {
        for (com.bytedance.sdk.openadsdk.core.qv.xt.r rVar : this.f27957r.values()) {
            if (rVar != null) {
                rVar.j();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.av.cw
    public void xt(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || this.xt == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.qv.xt.r rVar = this.f27957r.get(j(this.f27955j, optJSONObject, (String) null).by().xt());
        if (rVar != null) {
            rVar.r();
        }
    }

    public static n j(n nVar, JSONObject jSONObject, String str) {
        String str2;
        boolean z5;
        n j6;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (jSONObject != null) {
            str2 = jSONObject.optString("download_url");
            z5 = true;
        } else {
            str2 = "";
            z5 = false;
        }
        if (TextUtils.isEmpty(str2)) {
            z5 = false;
        }
        boolean z6 = (nVar.by() == null || nVar.by().xt() == null || !nVar.by().xt().equals(str2)) ? z5 : false;
        if (jSONObject != null && (optJSONObject2 = jSONObject.optJSONObject("download_config_json")) != null && !optJSONObject2.optBoolean("has_valid_download_url", true)) {
            z6 = true;
        }
        if (z6) {
            j6 = new n();
            j6.up(nVar.ae());
            j6.h(nVar.om());
            j6.p(nVar.nu());
            j6.h(jSONObject.optInt("lp_down_rule"));
            j6.gq(4);
            j6.kt(jSONObject.optString("id"));
            j6.jy(jSONObject.optString(SocialConstants.PARAM_SOURCE));
            up upVar = new up();
            upVar.r(jSONObject.optString(Constants.PARAM_PKG_NAME));
            upVar.cw(jSONObject.optString(CommonNetImpl.NAME));
            upVar.xt(str2);
            j6.j(upVar);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("download_config_json");
            if (optJSONObject3 != null) {
                j6.j(new tj(optJSONObject3));
                if (!optJSONObject3.optBoolean("has_valid_download_url", true)) {
                    j6.oq(true);
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("app_manage_json");
            if (optJSONObject4 != null) {
                m et = j6.et();
                if (et == null) {
                    et = new m();
                }
                et.j(optJSONObject4.optInt("score"));
                et.j(optJSONObject4.optJSONArray("creative_tags"));
                j6.j(et);
                j6.vl(optJSONObject4.toString());
                h ig = j6.ig();
                if (ig == null) {
                    ig = new h();
                }
                ig.j(optJSONObject4.optString("icon_url"));
                j6.j(ig);
                j6.w(optJSONObject4.optString("desc"));
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("app_manage_type_json");
            if (optJSONObject5 != null) {
                j6.p(optJSONObject5.optInt("app_manage_type"));
            }
            int optInt = jSONObject.optInt("live_interaction_type");
            String optString = jSONObject.optString("live_room_id");
            if (optInt > 0 && !TextUtils.isEmpty(optString)) {
                j6.qb(optInt);
                j6.rn(optString);
            }
            j6.q(jSONObject.optInt("ad_type"));
            xp j7 = xp.j(jSONObject.optJSONObject("wc_miniapp_info"));
            if (j7 != null) {
                j6.j(j7);
            }
            String optString2 = jSONObject.optString("quick_app_url");
            if (!TextUtils.isEmpty(optString2)) {
                up by = j6.by() != null ? j6.by() : new up();
                by.j(optString2);
                j6.j(by);
            }
        } else {
            j6 = com.bytedance.sdk.openadsdk.core.j.j(nVar.tv());
        }
        if (!TextUtils.isEmpty(str)) {
            j6.tj(str);
        }
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("deep_link")) != null) {
            i iVar = new i();
            if (nVar.m111if() != null) {
                iVar.j(nVar.m111if());
            }
            iVar.j(new i(optJSONObject));
            j6.j(iVar);
        }
        return j6;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.av.j$j, reason: collision with other inner class name */
    public static class C0431j {

        /* renamed from: j, reason: collision with root package name */
        private static ConcurrentHashMap<String, JSONObject> f27962j = new ConcurrentHashMap<>();

        public static synchronized JSONObject j(String str) {
            synchronized (C0431j.class) {
                if (TextUtils.isEmpty(str)) {
                    return new JSONObject();
                }
                ConcurrentHashMap<String, JSONObject> concurrentHashMap = f27962j;
                if (concurrentHashMap == null) {
                    return new JSONObject();
                }
                JSONObject jSONObject = concurrentHashMap.get(str);
                if (jSONObject != null) {
                    return jSONObject;
                }
                return new JSONObject();
            }
        }

        public static synchronized void j(String str, int i6, int i7) {
            synchronized (C0431j.class) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (f27962j == null) {
                        f27962j = new ConcurrentHashMap<>();
                    }
                    JSONObject jSONObject = f27962j.get(str);
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                        f27962j.put(str, jSONObject);
                    }
                    try {
                        jSONObject.put("downloadStatus", i6);
                        jSONObject.put("downloadProcessRate", i7);
                        jSONObject.put("code", 0);
                        jSONObject.put("codeMsg", "get ad_down_load_id success");
                    } catch (Exception e6) {
                        vl.j(e6);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.av.cw
    public void xt(boolean z5) {
        this.ae = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.av.cw
    public void j(Context context, JSONObject jSONObject, String str, int i6, boolean z5, boolean z6) {
        JSONObject optJSONObject;
        if (context == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        n j6 = j(this.f27955j, optJSONObject, str);
        j(context, j6, optJSONObject, i6, z5 ? oq.j(j6) : 0, z6);
    }

    private void j(Context context, n nVar, JSONObject jSONObject, int i6, int i7, boolean z5) {
        if (context == null || nVar == null || nVar.by() == null || jSONObject == null || this.xt == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.qv.xt.r rVar = this.f27957r.get(nVar.by().xt());
        if (rVar != null) {
            rVar.j(i7);
            return;
        }
        String j6 = uf.j(i6);
        if (TextUtils.isEmpty(j6)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.qv.xt.r j7 = j(context, nVar, jSONObject, j6);
        j7.j(i7);
        if (j7 instanceof com.bytedance.sdk.openadsdk.core.qv.cw.r) {
            ((com.bytedance.sdk.openadsdk.core.qv.cw.r) j7).m(z5);
        }
        this.f27957r.put(nVar.by().xt(), j7);
    }

    @Override // com.bytedance.sdk.openadsdk.core.av.cw
    public void j(Context context, JSONObject jSONObject, String str, String str2) {
        JSONObject optJSONObject;
        if (context == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        j(context, j(this.f27955j, optJSONObject, str2), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j(Context context, n nVar, String str) {
        if (context == 0 || nVar == null) {
            return;
        }
        if (nVar.by() == null) {
            com.bytedance.sdk.openadsdk.core.qv.xt.cw xt = tl.xt(context, nVar, str, false);
            if (xt instanceof com.bytedance.sdk.openadsdk.core.qv.cw.up) {
                ((com.bytedance.sdk.openadsdk.core.qv.cw.up) xt).m(this.cw);
            }
            xt.j(nVar, false);
        } else {
            final String fs = nVar.fs();
            com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = (com.bytedance.sdk.openadsdk.core.qv.xt.r) this.f27957r.get(nVar.by().xt());
            if (cwVar != null) {
                cwVar.cw(this.ae);
                if (cwVar instanceof com.bytedance.sdk.openadsdk.core.qv.cw.up) {
                    ((com.bytedance.sdk.openadsdk.core.qv.cw.up) cwVar).tl().j(this.up);
                } else if (cwVar instanceof com.bytedance.sdk.openadsdk.core.qv.cw.tl) {
                    ((com.bytedance.sdk.openadsdk.core.qv.cw.tl) cwVar).m().j(this.up);
                }
                cwVar.j(nVar, false);
                cwVar.j(new com.bytedance.sdk.openadsdk.core.qv.xt.j() { // from class: com.bytedance.sdk.openadsdk.core.av.j.1
                    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                    public void j() {
                        C0431j.j(fs, 1, 0);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                    public void cw(long j6, long j7, String str2, String str3) {
                        if (j6 > 0) {
                            C0431j.j(fs, 4, (int) ((j7 * 100) / j6));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                    public void j(long j6, long j7, String str2, String str3) {
                        if (j6 > 0) {
                            C0431j.j(fs, 3, (int) ((j7 * 100) / j6));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                    public void xt(long j6, long j7, String str2, String str3) {
                        if (j6 > 0) {
                            C0431j.j(fs, 2, (int) ((j7 * 100) / j6));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                    public void j(long j6, String str2, String str3) {
                        C0431j.j(fs, 5, 100);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
                    public void j(String str2, String str3) {
                        C0431j.j(fs, 6, 100);
                    }
                });
            }
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.tl.xt) {
            ((com.bytedance.sdk.openadsdk.core.tl.xt) context).j(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.av.cw
    public void j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        j(j(this.f27955j, optJSONObject, (String) null), optJSONObject);
    }

    private void j(n nVar, JSONObject jSONObject) {
        if (this.xt == null || nVar == null || nVar.by() == null) {
            return;
        }
        String xt = nVar.by().xt();
        if (this.f27957r.containsKey(xt)) {
            com.bytedance.sdk.openadsdk.core.qv.xt.r remove = this.f27957r.remove(xt);
            if (remove != null) {
                try {
                    remove.xt();
                } catch (JSONException e6) {
                    vl.j(e6);
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CrashHianalyticsData.MESSAGE, "success");
            jSONObject2.put(NotificationCompat.CATEGORY_STATUS, "unsubscribed");
            jSONObject2.put("appad", jSONObject);
            this.xt.j("app_ad_event", jSONObject2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.av.cw
    public void j(boolean z5) {
        this.up = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.av.cw
    public void j(String str, boolean z5) {
        com.bytedance.sdk.openadsdk.core.qv.xt.r rVar;
        if (TextUtils.isEmpty(str) || (rVar = this.f27957r.get(str)) == null) {
            return;
        }
        rVar.xt(z5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bytedance.sdk.openadsdk.core.qv.xt.r j(Context context, n nVar, final JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.qv.xt.r xt = tl.xt(context, nVar, str, false);
        if (xt instanceof com.bytedance.sdk.openadsdk.core.qv.cw.up) {
            ((com.bytedance.sdk.openadsdk.core.qv.cw.up) xt).m(this.cw);
        }
        xt.j(new com.bytedance.sdk.openadsdk.core.qv.xt.j() { // from class: com.bytedance.sdk.openadsdk.core.av.j.2
            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j() {
                j(NotificationCompat.CATEGORY_STATUS, "idle");
                if (j.this.f27956m == null) {
                    return;
                }
                j.this.f27956m.j();
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void cw(long j6, long j7, String str2, String str3) {
                j(NotificationCompat.CATEGORY_STATUS, "download_failed", "total_bytes", String.valueOf(j6), "current_bytes", String.valueOf(j7));
                if (j.this.f27956m == null) {
                    return;
                }
                j.this.f27956m.cw(j6, j7, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void xt(long j6, long j7, String str2, String str3) {
                j(NotificationCompat.CATEGORY_STATUS, "download_paused", "total_bytes", String.valueOf(j6), "current_bytes", String.valueOf(j7));
                if (j.this.f27956m == null) {
                    return;
                }
                j.this.f27956m.xt(j6, j7, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j(long j6, long j7, String str2, String str3) {
                j(NotificationCompat.CATEGORY_STATUS, "download_active", "total_bytes", String.valueOf(j6), "current_bytes", String.valueOf(j7));
                if (j.this.f27956m == null) {
                    return;
                }
                j.this.f27956m.j(j6, j7, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j(long j6, String str2, String str3) {
                j(NotificationCompat.CATEGORY_STATUS, "download_finished", "total_bytes", String.valueOf(j6), "current_bytes", String.valueOf(j6));
                if (j.this.f27956m == null) {
                    return;
                }
                j.this.f27956m.j(j6, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j(String str2, String str3) {
                j(NotificationCompat.CATEGORY_STATUS, "installed");
                if (j.this.f27956m == null) {
                    return;
                }
                j.this.f27956m.j(str2, str3);
            }

            private void j(String... strArr) {
                if (strArr == null || strArr.length % 2 != 0) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(CrashHianalyticsData.MESSAGE, "success");
                    jSONObject2.put("appad", jSONObject);
                    for (int i6 = 0; i6 < strArr.length; i6 += 2) {
                        jSONObject2.put(strArr[i6], strArr[i6 + 1]);
                    }
                    j.this.xt.j("app_ad_event", jSONObject2);
                } catch (JSONException unused) {
                }
            }
        });
        xt.j(new r.j() { // from class: com.bytedance.sdk.openadsdk.core.av.j.3
        });
        return xt;
    }
}
