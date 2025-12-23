package com.bytedance.sdk.openadsdk.core.p;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.rn.f;
import com.bytedance.sdk.openadsdk.core.rn.gx;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.v;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.bi;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl extends com.bytedance.sdk.component.oq.g {

    /* renamed from: r, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile tl f29837r;
    private volatile Runnable ae;

    /* renamed from: j, reason: collision with root package name */
    private final up f29838j;
    private final Context xt;
    private static final AtomicLong cw = new AtomicLong(0);
    private static boolean up = true;

    /* renamed from: m, reason: collision with root package name */
    private static volatile boolean f29836m = false;

    private class j extends BroadcastReceiver {
        private j() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            vl.j("SdkSettingsHelper", "onReceive: ");
            int intExtra = intent.getIntExtra("b_msg_id", -1);
            if (intExtra == 1) {
                long longExtra = intent.getLongExtra("b_msg_time", -1L);
                if (longExtra > 0) {
                    tl.cw.set(longExtra);
                    return;
                }
                return;
            }
            if (intExtra == 2) {
                try {
                    if (tl.this.f29838j != null) {
                        tl.this.f29838j.j();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void cw() {
        j(false);
    }

    private tl(up upVar) {
        super("SdkSettingsHelper");
        this.f29838j = upVar == null ? v.xt() : upVar;
        Context context = v.getContext();
        this.xt = context;
        if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
            try {
                context.registerReceiver(new j(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"), uf.s(), com.bytedance.sdk.component.utils.tl.j());
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean r() {
        return f29836m;
    }

    public static void xt() {
        if (v.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(uf.g());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 2);
                v.getContext().sendBroadcast(intent, uf.g() + ".openadsdk.permission.TT_PANGOLIN");
            } catch (Throwable unused) {
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!ws.j(this.xt)) {
            try {
                this.f29838j.j();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        if (tl()) {
            return;
        }
        if (!g.j() || tj.f30204j) {
            JSONObject up2 = up();
            gx gxVar = new gx(com.bytedance.sdk.openadsdk.core.v.up.j().xt().m());
            gxVar.j(com.bytedance.sdk.openadsdk.tl.cw.j(gxVar, uf.tl("/api/ad/union/sdk/settings/")));
            gxVar.xt("User-Agent", uf.ae());
            gxVar.xt(up2, "settings");
            com.bytedance.sdk.openadsdk.tl.cw.j(up2, 1);
            gxVar.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.p.tl.2
                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                    if (xtVar == null || !xtVar.tl()) {
                        try {
                            tl.this.f29838j.j();
                            v.xt().mi();
                        } catch (Throwable unused2) {
                        }
                        tj.xt();
                        return;
                    }
                    try {
                        try {
                            final JSONObject jSONObject = (JSONObject) com.bytedance.sdk.openadsdk.core.cw.m.j(xtVar, "settings", false).second;
                            if (jSONObject == null) {
                                return;
                            }
                            try {
                                if (!tl.this.j(jSONObject)) {
                                    vl.xt("SdkSettingsHelper", "can not update settings");
                                    return;
                                }
                            } catch (Throwable unused3) {
                            }
                            if (h.up) {
                                tl.this.f29838j.j(jSONObject);
                            }
                            new com.bytedance.sdk.openadsdk.core.r.xt("check_and_update_pl").j(5).xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.tl.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    JSONArray optJSONArray;
                                    JSONArray optJSONArray2 = jSONObject.optJSONArray("plugins");
                                    if (optJSONArray2 != null) {
                                        com.bytedance.sdk.openadsdk.core.s.j.xt.j().j(optJSONArray2);
                                    }
                                    JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
                                    if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("plugins")) == null) {
                                        return;
                                    }
                                    com.bytedance.sdk.openadsdk.core.s.j.xt.j().j(optJSONArray);
                                }
                            });
                            try {
                                tl.this.f29838j.xt(jSONObject);
                                tj.j();
                                if (!tl.f29836m) {
                                    boolean unused4 = tl.f29836m = true;
                                }
                                com.bytedance.sdk.openadsdk.core.oq.i().s().up();
                                com.bytedance.sdk.openadsdk.core.h.j.xt();
                            } catch (Throwable th) {
                                com.bytedance.sdk.openadsdk.core.kt.ws.j().j("setting_saveData_failed", tl.this.j(th), th);
                            }
                            com.bytedance.sdk.openadsdk.core.kt.ws.j().xt();
                            if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
                                tl.xt();
                            }
                            com.bytedance.sdk.openadsdk.tl.cw.xt(jSONObject, 1);
                        } catch (Throwable th2) {
                            com.bytedance.sdk.openadsdk.core.kt.ws.j().j("setting_decrypt", th2);
                        }
                    } catch (Throwable th3) {
                        com.bytedance.sdk.openadsdk.core.kt.ws.j().j("setting_parse", th3);
                    }
                }

                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                    try {
                        Iterator<String> keys = com.bytedance.sdk.openadsdk.core.oq.i().rn().keys();
                        while (keys.hasNext()) {
                            com.bytedance.sdk.openadsdk.core.s.j.xt.j().j(keys.next(), 1007);
                        }
                    } catch (Throwable unused2) {
                    }
                    try {
                        tl.this.f29838j.j();
                        v.xt().mi();
                    } catch (Throwable unused3) {
                    }
                    tj.xt();
                }
            });
        }
    }

    public JSONObject up() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, com.bytedance.sdk.openadsdk.core.rn.oq.m());
            jSONObject.put("ipv6", com.bytedance.sdk.openadsdk.core.rn.oq.ae());
            jSONObject.put("oaid", f.j(false));
            jSONObject.put(bn.f10753i, kt.v());
            jSONObject.put("conn_type", ws.xt(this.xt));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put("sdk_version", h.cw);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
            jSONObject.put("is_plugin", h.j());
            jSONObject.put("is_boost", true);
            jSONObject.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.r.j.r());
            jSONObject.put("download_sdk_version", com.bytedance.sdk.openadsdk.core.qv.g.r());
            jSONObject.put(bi.f40972o, uf.g());
            jSONObject.put("position", uf.r() ? 1 : 2);
            jSONObject.put("app_version", uf.qv());
            jSONObject.put("app_code", uf.oq());
            String str = Build.MANUFACTURER;
            jSONObject.put("vendor", str);
            jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.oq.i().f());
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.up.xt(com.bytedance.sdk.openadsdk.core.oq.i().f() != null ? com.bytedance.sdk.openadsdk.core.oq.i().f().concat(String.valueOf(currentTimeMillis)).concat(h.cw) : ""));
            vl.j("isApplicationForeground", "app_version:" + uf.qv() + "，vendor:" + str);
            jSONObject.put("locale_language", com.bytedance.sdk.openadsdk.core.rn.oq.qv());
            jSONObject.put("channel", h.f29117m);
            jSONObject.put("applog_did", com.bytedance.sdk.openadsdk.core.m.j().cw());
            jSONObject.put("can_use_sensor", com.bytedance.sdk.openadsdk.core.oq.i().m());
            com.bytedance.sdk.openadsdk.av.xt.j(jSONObject);
            com.bytedance.sdk.openadsdk.av.xt.xt(jSONObject);
            jSONObject.put("system_app", h.cw());
            if (h.j()) {
                jSONObject.put("plugins", g());
            }
            jSONObject.put("imei", kt.ae());
            jSONObject.put(SocialConstants.PARAM_SOURCE, 1);
            jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            String sm = com.bytedance.sdk.openadsdk.core.oq.i().sm();
            if (!TextUtils.isEmpty(sm)) {
                jSONObject.put("rit_list", sm);
            }
            long gx = v.xt().gx();
            if (gx > 0) {
                jSONObject.put("data_time", gx);
            }
            Object c6 = v.xt().c();
            if (c6 != null) {
                jSONObject.put("digest", c6);
            }
            try {
                jSONObject.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.ch.j.j().j("DeviceRate", "bytebench_value")));
            } catch (NumberFormatException unused) {
                jSONObject.put("device_score", -1);
            }
            jSONObject.put("csj_type", com.bytedance.sdk.openadsdk.core.oq.i().nd() ? 1 : 0);
        } catch (Throwable unused2) {
        }
        return jSONObject;
    }

    private static JSONObject g() {
        JSONObject optJSONObject;
        JSONObject rn = com.bytedance.sdk.openadsdk.core.oq.i().rn();
        if (rn == null) {
            return new JSONObject();
        }
        Iterator<String> keys = rn.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && (optJSONObject = rn.optJSONObject(next)) != null) {
                try {
                    optJSONObject.put("plugin_update_network", com.bytedance.sdk.openadsdk.core.oq.i().s().j(next));
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
        }
        return rn;
    }

    private boolean tl() {
        return TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.oq.i().f());
    }

    public static tl j(up upVar) {
        if (f29837r == null) {
            synchronized (tl.class) {
                try {
                    if (f29837r == null) {
                        f29837r = new tl(upVar);
                    }
                } finally {
                }
            }
        }
        return f29837r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(long j6) {
        cw.set(j6);
        if (com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
            j(j6);
        }
        com.bytedance.sdk.component.oq.ae.j(this, 10);
    }

    public static void j() {
        try {
            com.bytedance.sdk.openadsdk.core.rn.h.j("tt_sdk_settings_other").j();
            com.bytedance.sdk.openadsdk.core.rn.h.j("tt_sdk_settings_other_bst").j();
            com.bytedance.sdk.openadsdk.core.rn.h.j("tt_sdk_settings_slot").j();
            com.bytedance.sdk.openadsdk.core.rn.h.j("tt_sdk_settings_slot_bst").j();
            com.bytedance.sdk.openadsdk.core.rn.h.j("tt_sdk_settings_slot_splash").j();
            com.bytedance.sdk.openadsdk.core.rn.h.j("tt_sdk_settings_slot_splash_bst").j();
        } catch (Throwable unused) {
        }
    }

    public static void j(long j6) {
        if (j6 > 0 && v.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(uf.g());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_time", j6);
                v.getContext().sendBroadcast(intent, uf.s());
            } catch (Throwable unused) {
            }
        }
    }

    public void j(boolean z5) {
        try {
            if (tl()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (!z5) {
                if (currentTimeMillis - cw.get() < TTAdConstant.AD_MAX_EVENT_TIME) {
                    return;
                }
                xt(currentTimeMillis);
            } else {
                if (this.ae != null) {
                    vl.xt("SdkSettingsHelper", "current task is not null !");
                    return;
                }
                long j6 = (cw.get() + 60000) - currentTimeMillis;
                if (j6 > 0) {
                    this.ae = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.tl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            tl.this.ae = null;
                            tl.this.xt(System.currentTimeMillis());
                        }
                    };
                    com.bytedance.sdk.component.utils.tl.j().postDelayed(this.ae, j6);
                } else {
                    this.ae = null;
                    xt(currentTimeMillis);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("active_control", 1);
                g.j(optInt);
                vl.j("SdkSettingsHelper", "sdk status: ".concat(String.valueOf(optInt)));
                return optInt == 1;
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject j(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        if (th != null) {
            int i6 = 0;
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                i6++;
                if (stackTraceElement != null) {
                    try {
                        jSONObject.putOpt(String.valueOf(i6), stackTraceElement.toString());
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return jSONObject;
    }
}
