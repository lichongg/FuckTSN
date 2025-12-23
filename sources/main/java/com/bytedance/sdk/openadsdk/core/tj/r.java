package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    private String ae;
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private String f30411g;

    /* renamed from: j, reason: collision with root package name */
    private String f30412j;
    private JSONObject jy;

    /* renamed from: m, reason: collision with root package name */
    private String f30413m;
    private String oq;
    private JSONArray qv;

    /* renamed from: r, reason: collision with root package name */
    private List<j> f30414r;
    private float tl;
    private String up;
    private String vl;
    private String xt;

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        private final String f30415j;
        private final String xt;

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject j() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("permission_desc", this.xt);
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
            try {
                jSONObject.put("permission_name", this.f30415j);
            } catch (JSONException e7) {
                com.bytedance.sdk.component.utils.vl.j(e7);
            }
            return jSONObject;
        }

        public j(JSONObject jSONObject) {
            this.f30415j = jSONObject.optString("permission_name");
            this.xt = jSONObject.optString("permission_desc");
        }
    }

    public String j() {
        return this.f30412j;
    }

    public r(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(WiseOpenHianalyticsData.UNION_PACKAGE);
            this.f30412j = optJSONObject.optString("app_name");
            this.xt = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            this.cw = optJSONObject.optString("developer_name");
            this.f30414r = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    this.f30414r.add(new j(optJSONArray.optJSONObject(i6)));
                }
            }
            this.up = optJSONObject.optString("policy_url");
            String optString = optJSONObject.optString(WiseOpenHianalyticsData.UNION_PACKAGE);
            this.f30413m = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f30413m = optJSONObject.optString(bi.f40972o);
            }
            this.ae = optJSONObject.optString("icon_url");
            this.f30411g = optJSONObject.optString("desc_url");
            this.oq = optJSONObject.optString("reg_number");
            this.vl = optJSONObject.optString("reg_url");
            this.jy = optJSONObject.optJSONObject("reg_info");
        } catch (Throwable unused) {
        }
    }

    public String cw() {
        return this.ae;
    }

    public void j(float f6) {
        this.tl = f6;
    }

    public String m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", this.f30412j);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        try {
            jSONObject.put("app_version", this.xt);
        } catch (JSONException e7) {
            com.bytedance.sdk.component.utils.vl.j(e7);
        }
        try {
            jSONObject.put("developer_name", this.cw);
        } catch (JSONException e8) {
            com.bytedance.sdk.component.utils.vl.j(e8);
        }
        try {
            jSONObject.put(bi.f40972o, this.f30413m);
        } catch (JSONException e9) {
            com.bytedance.sdk.component.utils.vl.j(e9);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<j> it = this.f30414r.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().j());
        }
        try {
            jSONObject.put("permissions", jSONArray);
        } catch (JSONException e10) {
            com.bytedance.sdk.component.utils.vl.j(e10);
        }
        try {
            jSONObject.put("privacy_policy_url", this.up);
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.vl.j(e11);
        }
        try {
            jSONObject.put("score", this.tl);
        } catch (JSONException e12) {
            com.bytedance.sdk.component.utils.vl.j(e12);
        }
        try {
            jSONObject.put("creative_tags", this.qv);
        } catch (JSONException e13) {
            com.bytedance.sdk.component.utils.vl.j(e13);
        }
        try {
            jSONObject.put("desc_url", this.f30411g);
        } catch (JSONException e14) {
            com.bytedance.sdk.component.utils.vl.j(e14);
        }
        try {
            jSONObject.put("reg_number", this.oq);
        } catch (JSONException e15) {
            com.bytedance.sdk.component.utils.vl.j(e15);
        }
        try {
            jSONObject.put("icon_url", this.ae);
        } catch (JSONException e16) {
            com.bytedance.sdk.component.utils.vl.j(e16);
        }
        try {
            jSONObject.put("reg_url", this.vl);
        } catch (JSONException e17) {
            com.bytedance.sdk.component.utils.vl.j(e17);
        }
        try {
            jSONObject.put("reg_info", this.jy);
        } catch (JSONException e18) {
            com.bytedance.sdk.component.utils.vl.j(e18);
        }
        return jSONObject.toString();
    }

    public String r() {
        return this.f30411g;
    }

    public boolean up() {
        List<j> list;
        return (TextUtils.isEmpty(this.f30412j) || TextUtils.isEmpty(this.xt) || TextUtils.isEmpty(xt()) || (list = this.f30414r) == null || list.size() == 0 || TextUtils.isEmpty(this.up) || TextUtils.isEmpty(this.f30411g)) ? false : true;
    }

    public String xt() {
        return this.cw;
    }

    public void j(JSONArray jSONArray) {
        this.qv = jSONArray;
    }
}
