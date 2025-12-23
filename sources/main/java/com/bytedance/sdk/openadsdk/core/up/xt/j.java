package com.bytedance.sdk.openadsdk.core.up.xt;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private n ae;

    /* renamed from: m, reason: collision with root package name */
    private m f30939m;
    private int qv;
    private String up;

    /* renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f30938j = new AtomicBoolean(false);
    private final AtomicBoolean xt = new AtomicBoolean(false);
    private int cw = -1;

    /* renamed from: r, reason: collision with root package name */
    private long f30940r = -1;
    private long tl = -1;

    /* renamed from: g, reason: collision with root package name */
    private long f30937g = -1;
    private long oq = -1;
    private Runnable vl = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.up.xt.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.xt.get()) {
                return;
            }
            j.this.f30938j.set(true);
            j.this.r(100003L);
        }
    };

    private void cw(long j6) {
        this.oq = j6;
    }

    private void r(n nVar, m mVar) {
        j(2, nVar, mVar);
    }

    private void up(n nVar, m mVar) {
        j(3, nVar, mVar);
    }

    private void cw(n nVar, m mVar) {
        j(1, nVar, mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j6) {
        this.f30940r = j6;
        cw();
        n nVar = this.ae;
        m mVar = this.f30939m;
        if (mVar != null) {
            mVar.xt();
        }
        j(nVar);
        j();
    }

    public void xt(long j6) {
        this.f30937g = j6;
    }

    public j(int i6) {
        this.qv = i6;
    }

    private void cw() {
        n nVar = this.ae;
        if (nVar != null) {
            nVar.ae(this.cw);
            nVar.tl(this.f30940r);
        }
    }

    private void xt(n nVar, m mVar) {
        JSONObject qf = nVar.qf();
        if (qf == null) {
            j(-1);
            xt();
            return;
        }
        int optInt = qf.optInt("cache_correct_type", 0);
        int optInt2 = qf.optInt("is_need_cache_correct", 0);
        boolean z5 = qf.optInt("is_need_cache_check", 0) == 1;
        if (optInt == 0) {
            j(0);
            xt();
            return;
        }
        if (!TextUtils.isEmpty(nVar.kg())) {
            j(1);
            xt();
            return;
        }
        if (optInt2 == 0) {
            if (z5) {
                j(3);
                cw(nVar, mVar);
                return;
            } else {
                j(2);
                r(100002L);
                return;
            }
        }
        long optLong = qf.optLong("creative_check_duration", 0L);
        if (optLong > 0) {
            if (Math.abs((System.currentTimeMillis() / 1000) - uf.vl(nVar)) <= optLong) {
                if (!z5) {
                    j(4);
                    r(100002L);
                    return;
                } else {
                    j(6);
                    cw(nVar, mVar);
                    return;
                }
            }
        }
        if (!z5) {
            j(5);
            r(nVar, mVar);
        } else {
            j(7);
            up(nVar, mVar);
        }
    }

    public void j() {
        this.f30939m = null;
        tl.cw().removeCallbacks(this.vl);
    }

    public void j(long j6) {
        this.tl = j6;
    }

    public long j(n nVar, m mVar) {
        this.f30939m = mVar;
        this.ae = nVar;
        xt(nVar, mVar);
        return this.cw;
    }

    private void j(final int i6, final n nVar, m mVar) {
        JSONObject qf = nVar.qf();
        long optLong = qf == null ? 0L : qf.optLong("correct_interface_timeout", 0L);
        if (optLong > 0) {
            tl.cw().postDelayed(this.vl, optLong);
        }
        v.j().j(j(i6, nVar), new xt<up>() { // from class: com.bytedance.sdk.openadsdk.core.up.xt.j.2
            @Override // com.bytedance.sdk.openadsdk.core.up.xt.xt
            public void j(up upVar, long j6, long j7) {
                try {
                    j.this.j(i6, nVar, upVar, j6);
                } catch (Exception e6) {
                    vl.j(e6);
                    e6.getMessage();
                }
            }
        });
    }

    private JSONObject j(int i6, n nVar) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(j(nVar, i6));
            jSONObject.put("ads", jSONArray);
            jSONObject.put("check_type", i6);
            return jSONObject;
        } catch (JSONException e6) {
            e6.getMessage();
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, n nVar, up upVar, long j6) throws JSONException {
        if (this.f30938j.get()) {
            return;
        }
        this.xt.set(true);
        if (upVar == null || upVar.j()) {
            j(false, j6);
            return;
        }
        if (j6 != 20000) {
            r(100001L);
            return;
        }
        String j7 = up.j(nVar.fs(), nVar.ej());
        JSONObject jSONObject = TextUtils.isEmpty(j7) ? null : upVar.xt.get(j7);
        if (jSONObject == null) {
            r(100004L);
            return;
        }
        if (jSONObject.has("is_valid")) {
            if (jSONObject.optBoolean("is_valid")) {
                if (i6 == 2 || i6 == 3) {
                    String optString = jSONObject.optString(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND);
                    String optString2 = jSONObject.optString("media_ext");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        nVar.tj(optString);
                        nVar.j(j(new JSONObject(optString2), nVar.lg()));
                    } else {
                        r(100006L);
                        return;
                    }
                }
                j(true, 100000L);
                return;
            }
            this.up = jSONObject.optString(MediationConstant.KEY_REASON);
            j(false, 100007L);
            return;
        }
        r(100005L);
    }

    private void xt() {
        cw();
        n nVar = this.ae;
        m mVar = this.f30939m;
        if (mVar != null) {
            mVar.j();
        }
        j(nVar);
        j();
    }

    public static Map<String, Object> j(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject == null) {
            return map;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    private JSONObject j(n nVar, int i6) {
        JSONObject jSONObject = new JSONObject();
        try {
            String fs = nVar.fs();
            String os = nVar.os();
            Map<String, Object> lg = nVar.lg();
            String str = "";
            if (lg != null) {
                JSONObject jSONObject2 = new JSONObject();
                Set<Map.Entry<String, Object>> entrySet = lg.entrySet();
                if (!entrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : entrySet) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                if (jSONObject2.length() > 0) {
                    str = jSONObject2.toString();
                }
            }
            j(fs, os, str, nVar.ej(), i6, jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void j(String str, String str2, String str3, String str4, int i6, JSONObject jSONObject) throws JSONException {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String upperCase = com.bytedance.sdk.component.utils.up.xt("id=" + str + "&timestamp=" + currentTimeMillis + "&ext=" + str2 + "&media_ext=" + str3 + "&req_id=" + str4).toUpperCase();
        jSONObject.put("id", str);
        jSONObject.put("timestamp", currentTimeMillis);
        jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, str2);
        jSONObject.put("media_ext", str3);
        jSONObject.put("req_id", str4);
        jSONObject.put("sign", upperCase);
    }

    private void j(boolean z5, long j6) {
        this.f30940r = j6;
        cw();
        n nVar = this.ae;
        m mVar = this.f30939m;
        if (mVar != null) {
            mVar.j(z5, j6);
        }
        j(nVar);
        j();
    }

    private void j(int i6) {
        this.cw = i6;
    }

    private void j(n nVar) {
        cw(System.currentTimeMillis());
        if (this.cw == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String xt = uf.xt(this.qv);
            long j6 = this.f30937g;
            long j7 = this.tl;
            jSONObject.put("cache_get_duration", j6 - j7 < 0 ? -1L : j6 - j7);
            long j8 = this.oq;
            long j9 = this.f30937g;
            jSONObject.put("network_check_duration", j8 - j9 < 0 ? -1L : j8 - j9);
            long j10 = this.oq;
            long j11 = this.tl;
            jSONObject.put("cache_total_duration", j10 - j11 < 0 ? -1L : j10 - j11);
            jSONObject.put("correct_action_code", this.cw);
            jSONObject.put("correct_result_code", this.f30940r);
            jSONObject.put("cache_loss_reason", this.up);
            if (nVar != null) {
                jSONObject.put("creative_check_duration", nVar.qf() != null ? nVar.qf().optLong("creative_check_duration", 0L) : -1L);
            }
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(nVar, xt, jSONObject);
        } catch (Exception unused) {
        }
    }
}
