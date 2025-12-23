package com.bytedance.sdk.openadsdk.core.cw;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private volatile String f28841a;
    protected volatile String ae;
    private volatile JSONArray ch;
    protected volatile String cw;

    /* renamed from: f, reason: collision with root package name */
    private volatile String f28842f;

    /* renamed from: g, reason: collision with root package name */
    protected volatile String f28843g;

    /* renamed from: h, reason: collision with root package name */
    private volatile String f28844h;

    /* renamed from: i, reason: collision with root package name */
    private volatile String f28845i;

    /* renamed from: j, reason: collision with root package name */
    protected volatile String f28846j;
    private volatile String jy;

    /* renamed from: l, reason: collision with root package name */
    private volatile String f28847l;

    /* renamed from: m, reason: collision with root package name */
    protected volatile String f28848m;
    protected volatile String oq;

    /* renamed from: r, reason: collision with root package name */
    protected volatile String f28850r;

    /* renamed from: s, reason: collision with root package name */
    private volatile String f28851s;
    private volatile String tj;
    protected volatile String tl;
    protected volatile String up;

    /* renamed from: v, reason: collision with root package name */
    private volatile String f28852v;

    /* renamed from: w, reason: collision with root package name */
    private volatile String f28853w;
    private volatile String ws;

    /* renamed from: x, reason: collision with root package name */
    private volatile String f28854x;
    protected volatile String xt;
    private volatile int vl = -1;
    private volatile int az = -1;
    private volatile int av = -1;
    private volatile int mi = -1;
    private volatile int kt = -1;

    /* renamed from: p, reason: collision with root package name */
    private volatile int f28849p = -1;
    private volatile SharedPreferences qv = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(v.getContext(), "sp_exec_getad_config", 0);

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        private static r f28855j = new r();
    }

    public static class xt {

        /* renamed from: j, reason: collision with root package name */
        private Map<String, Object> f28856j = new HashMap();

        public xt j(String str) {
            if (str == null || str.equals(r.j().f28846j)) {
                return this;
            }
            r.j().f28846j = str;
            this.f28856j.put("dev01", str);
            return this;
        }

        public xt ae(String str) {
            if (str == null || str.equals(r.j().f28848m)) {
                return this;
            }
            r.j().f28848m = str;
            this.f28856j.put("dev08", str);
            return this;
        }

        public xt cw(String str) {
            if (str == null || str.equals(r.j().cw)) {
                return this;
            }
            r.j().cw = str;
            this.f28856j.put("dev04", str);
            return this;
        }

        public xt g(String str) {
            if (str == null || str.equals(r.j().tl)) {
                return this;
            }
            r.j().tl = str;
            this.f28856j.put("dev18", str);
            return this;
        }

        public xt m(String str) {
            if (str == null || str.equals(r.j().up)) {
                return this;
            }
            r.j().up = str;
            this.f28856j.put("dev07", str);
            return this;
        }

        public xt oq(String str) {
            if (str == null || str.equals(r.j().f28843g)) {
                return this;
            }
            r.j().f28843g = str;
            this.f28856j.put("dev09", str);
            return this;
        }

        public xt r(String str) {
            if (str == null || str.equals(r.j().f28850r)) {
                return this;
            }
            r.j().f28850r = str;
            this.f28856j.put("dev05", str);
            return this;
        }

        public xt tl(String str) {
            if (str == null || str.equals(r.j().ae)) {
                return this;
            }
            r.j().ae = str;
            this.f28856j.put("dev17", str);
            return this;
        }

        public xt up(String str) {
            if (str == null || str.equals(r.j().oq)) {
                return this;
            }
            r.j().oq = str;
            this.f28856j.put("dev11", str);
            return this;
        }

        public xt xt(String str) {
            if (str == null || str.equals(r.j().xt)) {
                return this;
            }
            r.j().xt = str;
            this.f28856j.put("dev02", com.bytedance.sdk.component.utils.j.xt(str));
            return this;
        }

        public void j() {
            try {
                if (cw.j().xt()) {
                    for (Map.Entry<String, Object> entry : this.f28856j.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            com.bytedance.sdk.component.ae.cw.j.xt.j("sp_exec_getad_config", key, (Boolean) value);
                        } else if (value instanceof Long) {
                            com.bytedance.sdk.component.ae.cw.j.xt.j("sp_exec_getad_config", key, (Long) value);
                        } else if (value instanceof Float) {
                            com.bytedance.sdk.component.ae.cw.j.xt.j("sp_exec_getad_config", key, (Float) value);
                        } else if (value instanceof Integer) {
                            com.bytedance.sdk.component.ae.cw.j.xt.j("sp_exec_getad_config", key, (Integer) value);
                        } else if (value instanceof String) {
                            com.bytedance.sdk.component.ae.cw.j.xt.j("sp_exec_getad_config", key, (String) value);
                        }
                    }
                    return;
                }
                SharedPreferences.Editor edit = r.j().xt().edit();
                for (Map.Entry<String, Object> entry2 : this.f28856j.entrySet()) {
                    String key2 = entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 instanceof Boolean) {
                        edit.putBoolean(key2, ((Boolean) value2).booleanValue());
                    } else if (value2 instanceof Long) {
                        edit.putLong(key2, ((Long) value2).longValue());
                    } else if (value2 instanceof Float) {
                        edit.putFloat(key2, ((Float) value2).floatValue());
                    } else if (value2 instanceof Integer) {
                        edit.putInt(key2, ((Integer) value2).intValue());
                    } else if (value2 instanceof String) {
                        edit.putString(key2, (String) value2);
                    }
                }
                edit.apply();
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
    }

    public static r j() {
        return j.f28855j;
    }

    public boolean ae(int i6) {
        return i6 == 3 || i6 == 4;
    }

    public String av() {
        if (this.oq == null) {
            this.oq = cw("dev11", (String) null);
        }
        return this.oq;
    }

    public String az() {
        if (this.f28854x == null) {
            this.f28854x = cw("dev10", (String) null);
        }
        return this.f28854x;
    }

    public int cw() {
        if (this.vl == -1) {
            this.vl = xt("live_ad_clk_cnt", 0);
        }
        return this.vl;
    }

    public void g(String str) {
        if (str == null || !str.equals(this.f28842f)) {
            this.f28842f = str;
            xt("extra_internal_data", str);
        }
    }

    public String jy() {
        if (this.tl == null) {
            this.tl = cw("dev18", (String) null);
        }
        return this.tl;
    }

    public String m(String str) {
        if (this.f28853w == null) {
            this.f28853w = cw("keywords", str);
        }
        return this.f28853w;
    }

    public String oq(String str) {
        if (this.f28842f == null) {
            this.f28842f = cw("extra_internal_data", str);
        }
        return this.f28842f;
    }

    public String qv(String str) {
        if (this.f28846j == null) {
            this.f28846j = cw("dev01", str);
        }
        return this.f28846j;
    }

    public String r() {
        if (this.jy == null) {
            this.jy = cw("app_id", "");
        }
        return this.jy;
    }

    public String tl(String str) {
        if (this.tj == null) {
            this.tj = cw("extra_data", str);
        }
        return this.tj;
    }

    public String up() {
        if (this.ws == null) {
            this.ws = cw("app_name", "");
        }
        return this.ws;
    }

    public String vl() {
        if (this.ae == null) {
            this.ae = cw("dev17", (String) null);
        }
        return this.ae;
    }

    public String ws() {
        if (this.f28843g == null) {
            this.f28843g = cw("dev09", (String) null);
        }
        return this.f28843g;
    }

    public SharedPreferences xt() {
        return this.qv;
    }

    public void ae(String str) {
        if (str == null || !str.equals(this.tj)) {
            this.tj = str;
            xt("extra_data", str);
        }
    }

    public String f() {
        if (this.f28844h == null) {
            this.f28844h = cw("spl_strategy", "");
        }
        return this.f28844h;
    }

    public JSONArray i() {
        String cw;
        if (this.ch == null && (cw = cw("dev12", (String) null)) != null) {
            try {
                this.ch = new JSONArray(cw);
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
        return this.ch;
    }

    public void j(int i6) {
        if (this.vl == i6) {
            return;
        }
        this.vl = i6;
        j("live_ad_clk_cnt", i6);
    }

    public int kt() {
        return xt("sp_device_app_direction", -1);
    }

    public String mi() {
        if (this.f28841a == null) {
            this.f28841a = cw("dev15", (String) null);
        }
        return this.f28841a;
    }

    public String tj() {
        if (this.f28847l == null) {
            this.f28847l = cw("dev16", "");
        }
        return this.f28847l;
    }

    public String w() {
        if (this.f28851s == null) {
            this.f28851s = cw("dev13", (String) null);
        }
        return this.f28851s;
    }

    public void xt(String str) {
        if (str == null || !str.equals(this.ws)) {
            this.ws = str;
            xt("app_name", str);
        }
    }

    private void x() {
        try {
            this.f28852v = com.bytedance.sdk.openadsdk.core.m.j().up();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, 7012);
            jSONObject.put("log_version", this.f28852v);
            xt("logsdk_version", jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public void v() {
        try {
            SharedPreferences.Editor edit = xt().edit();
            edit.clear();
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public void av(String str) {
        if (str == null || !str.equals(this.f28844h)) {
            this.f28844h = str;
            xt("spl_strategy", this.f28844h);
        }
    }

    public void az(String str) {
        if (str == null || !str.equals(this.f28847l)) {
            this.f28847l = str;
            xt("dev16", str);
        }
    }

    public String cw(String str) {
        if (this.f28845i == null) {
            this.f28845i = cw("dev03", str);
        }
        return this.f28845i;
    }

    public String g() {
        if (this.f28850r == null) {
            this.f28850r = cw("dev05", (String) null);
        }
        return this.f28850r;
    }

    public void jy(String str) {
        if (str == null || str.equals(this.f28851s)) {
            return;
        }
        this.f28851s = str;
        r("dev13", str);
    }

    public int m() {
        if (this.mi == -1) {
            this.mi = xt("age_group", Integer.MIN_VALUE);
        }
        return this.mi;
    }

    public String oq() {
        if (this.up == null) {
            this.up = cw("dev07", (String) null);
        }
        return this.up;
    }

    public String qv() {
        if (this.f28848m == null) {
            this.f28848m = cw("dev08", (String) null);
        }
        return this.f28848m;
    }

    public void r(String str) {
        this.f28845i = str;
        xt("dev03", str);
    }

    public String tl() {
        if (this.cw == null) {
            this.cw = cw("dev04", (String) null);
        }
        return this.cw;
    }

    public void up(String str) {
        if (str == null || !str.equals(this.f28853w)) {
            this.f28853w = str;
            xt("keywords", str);
        }
    }

    public void vl(String str) {
        if (str == null || str.equals(this.f28854x)) {
            return;
        }
        this.f28854x = str;
        xt("dev10", str);
    }

    public void ws(String str) {
        if (str == null || str.equals(this.f28841a)) {
            return;
        }
        this.f28841a = str;
        r("dev15", str);
    }

    public String ae() {
        if (this.xt == null) {
            this.xt = com.bytedance.sdk.component.utils.j.cw(cw("dev02", (String) null));
        }
        return this.xt;
    }

    public void j(String str) {
        if (str == null || !str.equals(this.jy)) {
            this.jy = str;
            xt("app_id", str);
        }
    }

    public void xt(boolean z5) {
        this.az = z5 ? 1 : 2;
        j("is_paid", this.az);
    }

    public int r(int i6) {
        if (this.kt == -1) {
            this.kt = xt("sdk_theme_status", i6);
        }
        return this.kt;
    }

    public void cw(int i6) {
        if (i6 == this.kt) {
            return;
        }
        this.kt = i6;
        j("sdk_theme_status", i6);
    }

    public void m(int i6) {
        j("sp_device_app_direction", i6);
    }

    public void tl(int i6) {
        if (this.f28849p == i6) {
            return;
        }
        this.f28849p = i6;
        j("dev_level", i6);
    }

    public String up(int i6) {
        if (TextUtils.isEmpty(this.f28852v)) {
            try {
                String cw = cw("logsdk_version", "");
                if (!TextUtils.isEmpty(cw)) {
                    JSONObject jSONObject = new JSONObject(cw);
                    int optInt = jSONObject.optInt(PluginConstants.KEY_PLUGIN_VERSION);
                    this.f28852v = jSONObject.optString("log_version");
                    if (optInt != 7012 || TextUtils.isEmpty(this.f28852v)) {
                        x();
                    }
                } else {
                    x();
                }
            } catch (Exception unused) {
            }
        }
        return this.f28852v;
    }

    public void xt(int i6) {
        if (i6 == this.mi) {
            return;
        }
        this.mi = i6;
        j("age_group", i6);
    }

    public boolean j(boolean z5) {
        if (this.az == -1) {
            this.az = xt("is_paid", z5 ? 1 : 2);
        }
        return this.az == 1;
    }

    public void r(boolean z5) {
        int i6 = z5 ? 1 : 2;
        if (this.av != i6) {
            this.av = i6;
            j("is_use_mediation", i6);
        }
    }

    public boolean cw(boolean z5) {
        if (this.av == -1) {
            this.av = xt("is_use_mediation", z5 ? 1 : 2);
        }
        return this.av == 1;
    }

    public long xt(String str, long j6) {
        try {
            if (cw.j().xt()) {
                return com.bytedance.sdk.component.ae.cw.j.xt.j("sp_exec_getad_config", str, j6);
            }
            return xt().getLong(str, j6);
        } catch (Throwable unused) {
            return j6;
        }
    }

    public String j(String str, String str2) {
        return cw("code_group_rit_".concat(String.valueOf(str)), str2);
    }

    public void j(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.toString().equals(this.ch == null ? null : this.ch.toString())) {
            return;
        }
        this.ch = jSONArray;
        xt("dev12", jSONArray.toString());
    }

    public String r(String str, long j6) {
        String cw;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            cw = cw(str, "");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(cw)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(cw);
        if (System.currentTimeMillis() - jSONObject.getLong("time") <= j6) {
            return jSONObject.getString("value");
        }
        return null;
    }

    public String cw(String str, String str2) {
        try {
            if (cw.j().xt()) {
                return com.bytedance.sdk.component.ae.cw.j.xt.xt("sp_exec_getad_config", str, str2);
            }
            return xt().getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public int xt(String str, int i6) {
        try {
            if (cw.j().xt()) {
                return com.bytedance.sdk.component.ae.cw.j.xt.j("sp_exec_getad_config", str, i6);
            }
            return xt().getInt(str, i6);
        } catch (Throwable unused) {
            return i6;
        }
    }

    public String cw(String str, long j6) {
        String cw;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            cw = cw(str, "");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(cw)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(cw);
        if (System.currentTimeMillis() - jSONObject.getLong("time") <= j6) {
            return jSONObject.getString("value");
        }
        return null;
    }

    public void xt(String str, String str2) {
        try {
            if (cw.j().xt()) {
                com.bytedance.sdk.component.ae.cw.j.xt.j("sp_exec_getad_config", str, str2);
                return;
            }
            SharedPreferences.Editor edit = xt().edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public void j(String str, long j6) {
        try {
            if (cw.j().xt()) {
                com.bytedance.sdk.component.ae.cw.j.xt.j("sp_exec_getad_config", str, Long.valueOf(j6));
                return;
            }
            SharedPreferences.Editor edit = xt().edit();
            edit.putLong(str, j6);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public void r(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", str2);
            jSONObject.put("time", System.currentTimeMillis());
            jSONObject.put("p_version", 7012);
            xt(str, jSONObject.toString());
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    public void j(String str, int i6) {
        try {
            if (cw.j().xt()) {
                com.bytedance.sdk.component.ae.cw.j.xt.j("sp_exec_getad_config", str, Integer.valueOf(i6));
                return;
            }
            SharedPreferences.Editor edit = xt().edit();
            edit.putInt(str, i6);
            edit.apply();
        } catch (Throwable unused) {
        }
    }
}
