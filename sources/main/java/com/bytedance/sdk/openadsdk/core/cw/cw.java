package com.bytedance.sdk.openadsdk.core.cw;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm.common.utility.Logger;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.rn.oq;
import com.bytedance.sdk.openadsdk.core.rn.s;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class cw {
    private static volatile cw xt;
    private SharedPreferences oq;
    private volatile boolean tl;

    /* renamed from: j, reason: collision with root package name */
    private AtomicBoolean f28832j = new AtomicBoolean(false);
    private AtomicBoolean cw = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    private AtomicInteger f28834r = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger up = new AtomicInteger(Integer.MAX_VALUE);

    /* renamed from: m, reason: collision with root package name */
    private volatile String f28833m = null;
    private AtomicInteger ae = new AtomicInteger(Integer.MAX_VALUE);

    /* renamed from: g, reason: collision with root package name */
    private AtomicInteger f28831g = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger qv = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger vl = new AtomicInteger(Integer.MAX_VALUE);

    private boolean j(int i6, int i7) {
        if (i7 == 0) {
            return false;
        }
        if (i7 == 1) {
            return true;
        }
        return i7 == 3 && i6 != 5;
    }

    public boolean cw() {
        try {
            if (this.f28834r.get() == Integer.MAX_VALUE) {
                if (this.f28832j.get()) {
                    this.f28834r.set(com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", "key_req_body_opt", 1));
                } else {
                    if (this.oq == null) {
                        this.oq = vl();
                    }
                    this.f28834r.set(this.oq.getInt("key_req_body_opt", 1));
                }
            }
        } catch (Throwable unused) {
        }
        return this.f28834r.get() == 1;
    }

    public boolean g() {
        try {
            if (this.vl.get() == Integer.MAX_VALUE) {
                if (this.f28832j.get()) {
                    this.vl.set(com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", "boost_save_config", 0));
                } else {
                    if (this.oq == null) {
                        this.oq = vl();
                    }
                    this.vl.set(this.oq.getInt("boost_save_config", 0));
                }
                Logger.i("bstsdk", "isBstTwConf get: " + this.vl.get());
            }
        } catch (Throwable unused) {
        }
        return this.vl.get() == 1;
    }

    public int m() {
        try {
            if (this.ae.get() == Integer.MAX_VALUE) {
                if (this.f28832j.get()) {
                    this.ae.set(com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", "key_network_module", 1));
                } else {
                    if (this.oq == null) {
                        this.oq = vl();
                    }
                    this.ae.set(this.oq.getInt("key_network_module", 1));
                }
            }
            return this.ae.get();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public boolean tl() {
        try {
            if (this.qv.get() == Integer.MAX_VALUE) {
                if (this.f28832j.get()) {
                    this.qv.set(com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", "_use_pl_", 0));
                } else {
                    if (this.oq == null) {
                        this.oq = vl();
                    }
                    this.qv.set(this.oq.getInt("_use_pl_", 0));
                }
            }
        } catch (Throwable unused) {
        }
        return this.qv.get() == 1;
    }

    public int up() {
        try {
            if (this.up.get() == Integer.MAX_VALUE) {
                if (this.f28832j.get()) {
                    this.up.set(com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", "key_net_queue_limit", 7));
                } else {
                    if (this.oq == null) {
                        this.oq = vl();
                    }
                    this.up.set(this.oq.getInt("key_net_queue_limit", 7));
                }
            }
            return this.up.get();
        } catch (Throwable unused) {
            return 7;
        }
    }

    private void ws() {
        com.bytedance.sdk.openadsdk.core.x.j jVar = new com.bytedance.sdk.openadsdk.core.x.j();
        kt.j(jVar);
        kt.m();
        kt.cw(jVar);
        kt.r(jVar);
        kt.xt(jVar);
        kt.up(jVar);
        kt.i();
    }

    public int ae() {
        try {
            if (this.f28831g.get() == Integer.MAX_VALUE) {
                if (this.f28832j.get()) {
                    this.f28831g.set(com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", "key_req_build_opt", 1));
                } else {
                    if (this.oq == null) {
                        this.oq = vl();
                    }
                    this.f28831g.set(this.oq.getInt("key_req_build_opt", 1));
                }
            }
            return this.f28831g.get();
        } catch (Exception unused) {
            return 0;
        }
    }

    public void oq() {
        try {
            com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra");
            SharedPreferences.Editor edit = vl().edit();
            edit.clear();
            edit.apply();
            this.f28834r.set(0);
            this.up.set(7);
            this.f28831g.set(0);
        } catch (Throwable unused) {
        }
    }

    public void qv() {
        ae.j(new g("advance_init_rb") { // from class: com.bytedance.sdk.openadsdk.core.cw.cw.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (cw.this.cw.get()) {
                        return;
                    }
                    cw.this.cw.set(true);
                    cw.this.jy();
                } catch (Throwable unused) {
                }
            }
        }, 10);
    }

    public String r() {
        try {
            if (TextUtils.isEmpty(this.f28833m)) {
                if (this.f28832j.get()) {
                    this.f28833m = com.bytedance.sdk.component.ae.cw.j.xt.xt("sp_bidding_opt_libra", "key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                } else {
                    if (this.oq == null) {
                        this.oq = vl();
                    }
                    this.f28833m = this.oq.getString("key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                }
            }
        } catch (Throwable unused) {
        }
        this.f28833m = TextUtils.isEmpty(this.f28833m) ? "api-access.pangolin-sdk-toutiao.com" : this.f28833m;
        return this.f28833m;
    }

    public boolean xt() {
        if (!this.tl) {
            this.f28832j.set(com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", "key_support_multiprocess", 2) == 1);
            this.tl = true;
        }
        return this.f28832j.get();
    }

    private cw() {
    }

    public static cw j() {
        if (xt == null) {
            synchronized (cw.class) {
                try {
                    if (xt == null) {
                        xt = new cw();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jy() {
        boolean cw = cw();
        if (cw) {
            com.bytedance.sdk.openadsdk.core.component.splash.j.r.r();
            r.j();
            xt.j();
        }
        try {
            if (!com.bytedance.sdk.openadsdk.core.r.j.cw()) {
                String j6 = j("/api/ad/union/ping");
                if (!TextUtils.isEmpty(j6)) {
                    com.bytedance.sdk.component.g.xt.cw cw2 = com.bytedance.sdk.openadsdk.core.v.up.j().xt().cw();
                    cw2.j(j6);
                    cw2.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.cw.cw.2
                        @Override // com.bytedance.sdk.component.g.j.j
                        public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                        }

                        @Override // com.bytedance.sdk.component.g.j.j
                        public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
        if (cw) {
            oq.xt(3);
            j.j(v.getContext(), 3);
            com.bytedance.sdk.openadsdk.core.rn.v.r();
            int i6 = com.bytedance.sdk.openadsdk.core.jy.cw.f29199j;
            LogAdapter logAdapter = LogAdapter.f31848j;
            ws();
            s.j(259200000L);
        }
    }

    private SharedPreferences vl() {
        return com.bytedance.sdk.openadsdk.api.plugin.xt.xt(v.getContext(), "sp_bidding_opt_libra", 0);
    }

    public void j(boolean z5) {
        this.f28832j.set(z5);
        if (z5) {
            j("key_support_multiprocess", 1);
        }
    }

    private void j(String str, int i6) {
        try {
            if (this.f28832j.get()) {
                com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", str, Integer.valueOf(i6));
                return;
            }
            if (this.oq == null) {
                this.oq = vl();
            }
            SharedPreferences.Editor edit = this.oq.edit();
            edit.putInt(str, i6);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    private void j(String str, String str2) {
        try {
            if (this.f28832j.get()) {
                com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", str, str2);
                return;
            }
            if (this.oq == null) {
                this.oq = vl();
            }
            SharedPreferences.Editor edit = this.oq.edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public static String j(String str) {
        String r5 = j().r();
        if (TextUtils.isEmpty(r5)) {
            return null;
        }
        return String.format("https://%s%s", r5, str);
    }

    public void j(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("ads_url", "api-access.pangolin-sdk-toutiao.com");
            this.f28833m = optString;
            JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
            if (optJSONObject == null) {
                if (com.bytedance.sdk.openadsdk.core.r.j.m()) {
                    return;
                }
                j("key_url_ads", optString);
                return;
            }
            int optInt = optJSONObject.optInt("network_module", 1);
            int optInt2 = optJSONObject.optInt("if_req_body_opt", 1);
            this.f28834r.set(optInt2);
            int optInt3 = optJSONObject.optInt("net_queue_limit", 7);
            this.up.set(optInt3);
            int optInt4 = optJSONObject.optInt("req_build_opt", 0);
            this.f28831g.set(optInt4);
            boolean optBoolean = optJSONObject.optBoolean("_use_pl_", false);
            int optInt5 = optJSONObject.optInt("boost_save_config", 0);
            this.vl.set(optInt5);
            if (com.bytedance.sdk.openadsdk.core.r.j.m()) {
                return;
            }
            if (this.f28832j.get()) {
                com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", "key_network_module", Integer.valueOf(optInt));
                com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", "key_req_body_opt", Integer.valueOf(optInt2));
                com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", "key_net_queue_limit", Integer.valueOf(optInt3));
                com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", "key_req_build_opt", Integer.valueOf(optInt4));
                com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", "_use_pl_", Integer.valueOf(optBoolean ? 1 : 0));
                com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", "key_url_ads", optString);
                com.bytedance.sdk.component.ae.cw.j.xt.j("sp_bidding_opt_libra", "boost_save_config", Integer.valueOf(optInt5));
                return;
            }
            if (this.oq == null) {
                this.oq = vl();
            }
            SharedPreferences.Editor edit = this.oq.edit();
            edit.putInt("key_network_module", optInt);
            edit.putInt("key_req_body_opt", optInt2);
            edit.putInt("key_net_queue_limit", optInt3);
            edit.putInt("key_req_build_opt", optInt4);
            edit.putInt("_use_pl_", optBoolean ? 1 : 0);
            edit.putString("key_url_ads", optString);
            edit.putInt("boost_save_config", optInt5);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    public boolean j(int i6) {
        if (i6 <= 0) {
            return false;
        }
        return j(i6, ae());
    }
}
