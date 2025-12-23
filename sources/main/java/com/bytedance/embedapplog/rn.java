package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class rn {
    private volatile JSONObject ae;
    private final SharedPreferences cw;

    /* renamed from: j, reason: collision with root package name */
    private final Context f24042j;

    /* renamed from: m, reason: collision with root package name */
    private volatile JSONObject f24043m;

    /* renamed from: r, reason: collision with root package name */
    private final SharedPreferences f24044r;
    private final SharedPreferences up;
    private final tl xt;

    String ch() {
        return null;
    }

    public int cw() {
        return this.f24044r.getInt("session_order", 0);
    }

    public boolean j(ArrayList<ya> arrayList) {
        return true;
    }

    public String xt() {
        return this.f24044r.getString("session_last_day", "");
    }

    @Nullable
    String a() {
        return this.up.getString("user_agent", null);
    }

    public long ae() {
        return this.up.getLong("app_log_last_config_time", 0L);
    }

    String av() {
        return this.cw.getString("user_unique_id", null);
    }

    String az() {
        return this.cw.getString("ab_sdk_version", "");
    }

    public String c() {
        return this.xt.f();
    }

    void cw(JSONObject jSONObject) {
        uc.j("setAbConfig, " + jSONObject.toString(), null);
        this.cw.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.f24043m = null;
    }

    public String ed() {
        return this.xt.tj();
    }

    public boolean f() {
        return this.up.getBoolean("bav_log_collect", false);
    }

    public String g() {
        return this.xt.cw();
    }

    public String gq() {
        return this.xt.jy();
    }

    public String gx() {
        return this.xt.l() == null ? "" : this.xt.l();
    }

    public int h() {
        return this.xt.av();
    }

    public tl hh() {
        return this.xt;
    }

    public boolean i() {
        if (this.xt.g() == 0) {
            String j6 = ri.j(this.f24042j);
            if (TextUtils.isEmpty(j6)) {
                this.xt.j(0);
            } else {
                this.xt.j(j6.contains(":") ? 2 : 1);
            }
        }
        return this.xt.g() == 1;
    }

    String j() {
        return this.xt.tl();
    }

    String jy() {
        return this.xt.ae();
    }

    public JSONObject kt() {
        JSONObject jSONObject = this.f24043m;
        if (jSONObject != null) {
            return jSONObject;
        }
        synchronized (this) {
            try {
                if (tj()) {
                    jSONObject = new JSONObject(this.cw.getString("ab_configure", ""));
                }
            } catch (JSONException unused) {
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            this.f24043m = jSONObject;
        }
        return jSONObject;
    }

    public String l() {
        return this.xt.vl();
    }

    public int la() {
        return this.xt.i();
    }

    public JSONObject m() {
        return this.ae;
    }

    public String mi() {
        return !TextUtils.isEmpty(this.xt.mi()) ? this.xt.mi() : this.cw.getString("ab_version", null);
    }

    public String n() {
        return this.xt.p() == null ? "" : this.xt.p();
    }

    public boolean nd() {
        return this.xt.x();
    }

    public String ol() {
        return this.xt.a();
    }

    String oq() {
        return this.xt.r();
    }

    public int p() {
        return this.xt.az();
    }

    String qv() {
        return this.xt.up();
    }

    public SharedPreferences r() {
        return this.up;
    }

    public boolean rh() {
        return this.xt.ch();
    }

    public String rn() {
        return this.xt.ws();
    }

    String s() {
        return this.xt.j();
    }

    public boolean tj() {
        return this.up.getBoolean("bav_ab_config", false);
    }

    public int tl() {
        return this.up.getInt("bav_monitor_rate", 0);
    }

    public String uf() {
        return this.xt.kt();
    }

    public boolean up() {
        return this.xt.xt();
    }

    public long v() {
        return this.up.getLong("session_interval", WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
    }

    String vl() {
        return this.xt.m();
    }

    public long w() {
        return this.up.getLong("abtest_fetch_interval", 0L);
    }

    public String wq() {
        return this.xt.w();
    }

    String ws() {
        return this.cw.getString("header_custom_info", null);
    }

    public long x() {
        return this.up.getLong("batch_event_interval", WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
    }

    void xt(JSONObject jSONObject) {
        this.cw.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    public CharSequence z() {
        return this.xt.v();
    }

    public rn(Context context, tl tlVar) {
        this.f24042j = context;
        this.xt = tlVar;
        this.up = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(context, "embed_applog_stats", 0);
        this.cw = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(context, "embed_header_custom", 0);
        this.f24044r = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(context, "embed_last_sp_session", 0);
    }

    public void j(String str, int i6) {
        this.f24044r.edit().putString("session_last_day", str).putInt("session_order", i6).apply();
    }

    public void j(JSONObject jSONObject) {
        if (uc.xt) {
            uc.j("setConfig, " + jSONObject.toString(), null);
        }
        this.ae = jSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.up.edit();
        long optInt = jSONObject.optInt("session_interval", 0);
        if (optInt > 0 && optInt <= 604800) {
            edit.putLong("session_interval", optInt * 1000);
        } else {
            edit.remove("session_interval");
        }
        long optInt2 = jSONObject.optInt("batch_event_interval", 0);
        if (optInt2 > 0 && optInt2 <= 604800) {
            edit.putLong("batch_event_interval", optInt2 * 1000);
        } else {
            edit.remove("batch_event_interval");
        }
        int optInt3 = jSONObject.optInt("send_launch_timely", 0);
        if (optInt3 > 0 && optInt3 <= 604800) {
            edit.putInt("send_launch_timely", optInt3);
        } else {
            edit.remove("send_launch_timely");
        }
        long optInt4 = jSONObject.optInt("abtest_fetch_interval", 0);
        if (optInt4 > 20 && optInt4 <= 604800) {
            edit.putLong("abtest_fetch_interval", optInt4 * 1000);
        } else {
            edit.remove("abtest_fetch_interval");
        }
        boolean optBoolean = jSONObject.optBoolean("bav_log_collect", true);
        if (optBoolean) {
            edit.putBoolean("bav_log_collect", true);
        } else {
            edit.remove("bav_log_collect");
        }
        uc.f24071j = optBoolean;
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            edit.putBoolean("bav_ab_config", true);
        } else {
            edit.remove("bav_ab_config");
        }
        int optInt5 = jSONObject.optInt("bav_monitor_rate", 0);
        if (optInt5 > 0 && optInt5 <= 100) {
            edit.putInt("bav_monitor_rate", optInt5);
            im.j(true);
        } else {
            edit.remove("bav_monitor_rate");
            im.j(false);
        }
        edit.putLong("app_log_last_config_time", currentTimeMillis);
        edit.apply();
    }
}
