package com.bytedance.msdk.core.ws;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.internal.d;
import com.bytedance.msdk.api.r.up;
import com.bytedance.msdk.j.up.m;
import com.bytedance.msdk.j.up.tl;
import com.bytedance.msdk.m.r;
import com.bytedance.msdk.tl.az;
import com.bytedance.msdk.tl.f;
import com.bytedance.msdk.tl.l;
import com.bytedance.msdk.tl.rn;
import com.bytedance.msdk.tl.s;
import com.bytedance.msdk.tl.x;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.kuaishou.weapon.p0.t;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements tl.j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f24808j;

    /* renamed from: r, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile xt f24809r;
    private final Context cw;
    private final tl tl;
    private final com.bytedance.msdk.core.ws.j xt;
    private final AtomicInteger up = new AtomicInteger(0);

    /* renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f24811m = new AtomicBoolean(false);
    private final AtomicBoolean ae = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f24810g = new AtomicBoolean(false);
    private int oq = -1;

    private class cw extends BroadcastReceiver {
        private cw() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || oq.i().la()) {
                return;
            }
            com.bytedance.msdk.j.up.cw.j("SdkSettingsHelper", "--==-- settings receiver");
            if (intent.getIntExtra("b_msg_id", -1) == 1) {
                try {
                    if (TextUtils.equals(intent.getStringExtra("b_msg_process_name"), s.xt(xt.this.cw))) {
                        com.bytedance.msdk.j.up.cw.j("SdkSettingsHelper", "--==-- settings receiver, same process, return");
                    } else if (xt.this.xt != null) {
                        com.bytedance.msdk.j.up.cw.j("SdkSettingsHelper", "--==-- settings receiver loadData");
                        xt.this.xt.j(false);
                        com.bytedance.msdk.ae.j.cw.j().xt();
                        com.bytedance.msdk.j.up.cw.j("SdkSettingsHelper", "--==-- settings receiver loadData end");
                    }
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        }
    }

    interface j {

        /* renamed from: j, reason: collision with root package name */
        public static final String f24821j = rn.j() + ".openadsdk.permission.TT_PANGOLIN";
    }

    /* renamed from: com.bytedance.msdk.core.ws.xt$xt, reason: collision with other inner class name */
    private class RunnableC0364xt implements Runnable {
        private int cw;
        private final up xt;

        RunnableC0364xt(up upVar, int i6) {
            this.xt = upVar;
            this.cw = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!x.j(xt.this.cw)) {
                try {
                    xt.this.xt.j(false);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            xt.this.f24811m.set(true);
            boolean l6 = com.bytedance.msdk.core.xt.xt().l();
            if (!xt.f24808j) {
                boolean unused2 = xt.f24808j = true;
                r.j(l6);
            }
            if (com.bytedance.msdk.tl.r.j.j()) {
                return;
            }
            xt.this.j(l6, this.xt, this.cw);
        }
    }

    private JSONObject ae() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.msdk.m.xt.xt.j();
        List<String> tl = tl();
        if (tl != null) {
            for (String str : tl) {
                com.bytedance.msdk.j.j.r j6 = com.bytedance.msdk.m.xt.xt.j().j(str);
                if (j6 != null) {
                    try {
                        jSONObject.put(str, j6.xt());
                    } catch (JSONException e6) {
                        vl.j(e6);
                    }
                }
            }
        }
        return jSONObject;
    }

    private static List<String> tl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MediationConstant.ADN_PANGLE);
        arrayList.add(MediationConstant.ADN_GDT);
        arrayList.add(MediationConstant.ADN_ADMOB);
        arrayList.add(MediationConstant.ADN_UNITY);
        arrayList.add("baidu");
        arrayList.add(MediationConstant.ADN_SIGMOB);
        arrayList.add(MediationConstant.ADN_MINTEGRAL);
        arrayList.add(MediationConstant.ADN_KS);
        arrayList.add(MediationConstant.ADN_KLEVIN);
        arrayList.add("xiaomi");
        return arrayList;
    }

    public void cw(int i6) {
        x.j();
        try {
            if (!m()) {
                com.bytedance.msdk.j.up.cw.xt("SdkSettingsHelper", "setting 缓存未过期，无需再次发起请求...");
            } else if (this.f24811m.get()) {
                com.bytedance.msdk.j.up.cw.xt("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                m.r(new RunnableC0364xt(null, i6));
            }
        } catch (Throwable th) {
            com.bytedance.msdk.j.up.cw.j("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    public void xt(int i6) {
        if (this.f24810g.get()) {
            com.bytedance.msdk.j.up.cw.r("SdkSettingsHelper", "setting 正在尝试拉取配置中...");
            return;
        }
        com.bytedance.msdk.j.up.cw.r("SdkSettingsHelper", "setting 尝试拉取配置...");
        j();
        cw(i6);
    }

    private xt(com.bytedance.msdk.core.ws.j jVar) {
        this.xt = jVar == null ? com.bytedance.msdk.core.xt.xt() : jVar;
        Context context = com.bytedance.msdk.core.xt.getContext();
        this.cw = context;
        this.tl = new tl(Looper.getMainLooper(), this);
        if (com.bytedance.msdk.core.j.qv().jy()) {
            try {
                context.registerReceiver(new cw(), new IntentFilter("com.bytedance.msdk.core.setting.SettingsReceiver"), j.f24821j, null);
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }

    private boolean m() {
        long xt = com.bytedance.msdk.ae.j.j().xt("max_expire_time", 0L);
        if (this.ae.get() && System.currentTimeMillis() > xt) {
            com.bytedance.msdk.j.up.cw.xt("SdkSettingsHelper", "setting 缓存过期，再次发起请求...");
            this.ae.set(false);
            j();
        }
        if (System.currentTimeMillis() <= xt) {
            return false;
        }
        return true;
    }

    private static void up() {
        if (!oq.i().la() && com.bytedance.msdk.core.xt.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(rn.j());
                intent.setAction("com.bytedance.msdk.core.setting.SettingsReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_process_name", s.xt(com.bytedance.msdk.core.xt.getContext()));
                com.bytedance.msdk.core.xt.getContext().sendBroadcast(intent, j.f24821j);
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }

    public static xt j(com.bytedance.msdk.core.ws.j jVar) {
        if (f24809r == null) {
            synchronized (xt.class) {
                try {
                    if (f24809r == null) {
                        f24809r = new xt(jVar);
                    }
                } finally {
                }
            }
        }
        return f24809r;
    }

    private JSONObject xt(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ts", System.currentTimeMillis());
            jSONObject2.put("media_sdk_version", com.bytedance.msdk.xt.xt.xt());
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, com.bytedance.msdk.xt.xt.r());
            jSONObject2.put("is_fusion", 1);
            jSONObject2.put("app_id", com.bytedance.msdk.core.j.qv().vl());
            jSONObject2.put(bi.f40972o, rn.j());
            jSONObject2.put("app_version", rn.cw());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, x.r());
            jSONObject3.put("imei", x.tj());
            jSONObject3.put("imei_md5", f.j(x.tj()));
            jSONObject3.put("oaid", x.xt());
            jSONObject3.put("gaid", com.bytedance.msdk.tl.tl.j().xt());
            jSONObject3.put("applog_did", x.j());
            jSONObject3.put("publisher_did", com.bytedance.msdk.core.j.qv().w());
            jSONObject3.put("conn_type", x.up());
            jSONObject3.put("os", x.jy());
            jSONObject3.put("os_version", x.ws());
            jSONObject3.put("vendor", x.i());
            jSONObject3.put("device_model", x.ae());
            jSONObject3.put("mcc", x.qv());
            jSONObject3.put("mnc", x.vl());
            jSONObject3.put("time_zone", x.w());
            jSONObject3.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, x.f());
            jSONObject3.put("locale_language", x.oq());
            jSONObject3.put("total_space", x.av());
            jSONObject3.put("carrier_name", x.kt());
            jSONObject3.put(bi.J, x.tl());
            jSONObject3.put("pb", "");
            jSONObject3.put("boot", x.mi());
            jSONObject3.put("country_code", com.bytedance.msdk.core.xt.xt().tl());
            jSONObject3.put("total_mem", x.az());
            jSONObject3.put(bi.ai, x.ae());
            jSONObject3.put("language", x.g());
            jSONObject3.put("android_os_version_int", Build.VERSION.SDK_INT);
            jSONObject2.put(ConstantHelper.LOG_DE, jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(d.f10985a, com.bytedance.msdk.core.j.qv().cw());
            jSONObject2.put(Constants.JumpUrlConstants.SRC_TYPE_APP, jSONObject4);
            jSONObject2.put("grouping_params", xt());
            JSONObject cw2 = cw();
            if (cw2 != null) {
                jSONObject2.put("user_defined_grouping_params", cw2);
            }
            if (!com.bytedance.msdk.core.j.qv().ae()) {
                jSONObject2.put("etag", com.bytedance.msdk.core.xt.xt().oq());
            }
            if (com.bytedance.msdk.tl.m.j(this.cw) != null) {
                jSONObject2.put("latitude", r1.f25239j);
                jSONObject2.put("longitude", r1.xt);
            }
            jSONObject2.put("adn_version_list", ae());
            com.bytedance.msdk.core.g.up.r().j(jSONObject2, jSONObject);
            com.bytedance.msdk.core.g.up.r().j(jSONObject2);
            List<String> rn = com.bytedance.msdk.core.j.qv().rn();
            if (rn != null && rn.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = rn.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("primerit_list", jSONArray);
            }
            if (!az.j()) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("err_type", 1);
                jSONObject5.put("err_msg", "applog so加载失败");
                jSONObject2.put("monitor_alarm", jSONObject5);
            }
            return jSONObject2;
        } catch (Exception e6) {
            vl.j(e6);
            return jSONObject2;
        }
    }

    public static JSONObject cw() {
        Map<String, String> j6;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.msdk.api.r.m l6 = com.bytedance.msdk.core.j.qv().l();
        if (l6 != null && (j6 = l6.j()) != null) {
            try {
                for (String str : j6.keySet()) {
                    jSONObject.put(str, j6.get(str));
                }
                return jSONObject;
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        return null;
    }

    public xt j() {
        com.bytedance.msdk.j.up.cw.r("SdkSettingsHelper", "setting resetRetryCount...");
        this.up.set(0);
        this.f24810g.set(false);
        tl tlVar = this.tl;
        if (tlVar != null) {
            tlVar.removeCallbacksAndMessages(null);
        }
        return this;
    }

    private String cw(JSONObject jSONObject) {
        JSONObject j6 = rn.j(jSONObject);
        if (j6 != null) {
            return j6.toString();
        }
        return null;
    }

    public void j(int i6) {
        try {
            if (this.f24811m.get()) {
                this.oq = i6;
                com.bytedance.msdk.j.up.cw.xt("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                m.r(new RunnableC0364xt(null, i6));
            }
        } catch (Throwable th) {
            com.bytedance.msdk.j.up.cw.j("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    private void j(up upVar, com.bytedance.msdk.api.j jVar, int i6) throws Throwable {
        long j6;
        com.bytedance.msdk.ae.j.j().m("server_dist_host");
        j(upVar, jVar);
        com.bytedance.msdk.m.cw.up();
        com.bytedance.msdk.j.up.cw.r("SdkSettingsHelper", "setting 配置拉取失败，尝试再次拉取... mLoadingSuccess:" + this.ae.get() + " mRetryCount:" + (this.up.get() + 1));
        this.f24811m.set(false);
        if (this.ae.get()) {
            this.f24810g.set(false);
            this.tl.removeCallbacksAndMessages(null);
            return;
        }
        if (this.up.get() > 3) {
            com.bytedance.msdk.j.up.cw.r("SdkSettingsHelper", "setting 最多尝试四次拉取... ");
            return;
        }
        this.f24810g.set(true);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = this.up.get();
        obtain.arg2 = i6;
        int i7 = this.up.get();
        if (i7 < 3) {
            long j7 = 1;
            for (int i8 = 0; i8 <= i7; i8++) {
                j7 *= 3;
            }
            j6 = j7 * 1000;
        } else {
            j6 = 120000;
        }
        this.up.incrementAndGet();
        this.tl.removeCallbacksAndMessages(null);
        this.tl.sendMessageDelayed(obtain, j6);
        com.bytedance.msdk.j.up.cw.xt("SdkSettingsHelper", "setting 重试次数:" + (i7 + 1) + "  重试间隔：" + j6);
    }

    private Map<String, String> j(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(str.toLowerCase(), map.get(str));
            }
        }
        return hashMap;
    }

    private void j(final up upVar, final com.bytedance.msdk.api.j jVar) {
        m.cw(new Runnable() { // from class: com.bytedance.msdk.core.ws.xt.1
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    public void j(final up upVar) {
        int i6 = this.oq;
        if (i6 == 2 || i6 == 3) {
            this.oq = -1;
            j(i6);
        }
        if (upVar != null) {
            final List<String> rn = com.bytedance.msdk.core.j.qv().rn();
            m.cw(new Runnable() { // from class: com.bytedance.msdk.core.ws.xt.2
                @Override // java.lang.Runnable
                public void run() {
                    upVar.j(com.bytedance.msdk.core.xt.xt().j(rn));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final boolean z5, final up upVar, final int i6) {
        final int[] iArr = {0};
        final int[] iArr2 = new int[1];
        final long currentTimeMillis = System.currentTimeMillis();
        Map<String, JSONObject> xt = com.bytedance.msdk.core.g.up.r().xt(i6);
        final JSONObject jSONObject = xt.get("event_label_value_root");
        JSONObject jSONObject2 = xt.get("config_req_label_value_root");
        com.bytedance.sdk.component.g.xt.up xt2 = com.bytedance.msdk.r.xt.j().xt().xt();
        xt2.j(com.bytedance.msdk.core.cw.j());
        String tl = com.bytedance.msdk.core.j.qv().tl();
        if (!TextUtils.isEmpty(tl)) {
            xt2.xt("X-Tt-Env", tl);
            xt2.xt("x-use-ppe", "1");
        }
        xt2.xt("User-Agent", com.bytedance.msdk.xt.xt.f25363j);
        try {
            JSONObject xt3 = xt(jSONObject2);
            boolean r5 = com.bytedance.msdk.core.xt.xt().r();
            final boolean z6 = !r5;
            if (!r5) {
                xt2.xt("x-pglcypher", "4");
                xt2.j("application/octet-stream", rn.xt(xt3.toString()));
            } else {
                xt2.cw(cw(xt3));
            }
            xt2.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.msdk.core.ws.xt.3
                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, final com.bytedance.sdk.component.g.xt xtVar) {
                    m.j(new Runnable() { // from class: com.bytedance.msdk.core.ws.xt.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String str;
                            JSONObject jSONObject3;
                            String str2;
                            JSONObject jSONObject4;
                            JSONObject jSONObject5 = new JSONObject();
                            int[] iArr3 = {-1};
                            com.bytedance.sdk.component.g.xt xtVar2 = xtVar;
                            if (xtVar2 != null) {
                                iArr2[0] = xtVar2.j();
                                if (rn.j(xtVar)) {
                                    long elapsedRealtime = SystemClock.elapsedRealtime();
                                    String j6 = rn.j(xtVar.oq());
                                    try {
                                        jSONObject5.put("decrypt_time", SystemClock.elapsedRealtime() - elapsedRealtime);
                                    } catch (JSONException unused) {
                                    }
                                    if (TextUtils.isEmpty(j6)) {
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        iArr2[0] = 81015;
                                        xt.this.j(upVar, i6, 81015, "response body is null", z6);
                                    } else {
                                        try {
                                            JSONObject jSONObject6 = new JSONObject(j6);
                                            AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                            xt.this.j(iArr2, iArr, xtVar, jSONObject6, j6, iArr3, upVar, jSONObject5, i6, z6, currentTimeMillis);
                                        } catch (Throwable th) {
                                            AnonymousClass3 anonymousClass33 = AnonymousClass3.this;
                                            iArr2[0] = 81014;
                                            xt.this.j(upVar, i6, 81014, th.getMessage(), z6);
                                        }
                                    }
                                } else if (xtVar.r() != null) {
                                    try {
                                        JSONObject jSONObject7 = new JSONObject(xtVar.r());
                                        int optInt = jSONObject7.optInt("cypher", -1);
                                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                        if (optInt == 2) {
                                            str = rn.j(jSONObject7.optString(CrashHianalyticsData.MESSAGE));
                                            if (!TextUtils.isEmpty(str)) {
                                                try {
                                                    jSONObject3 = new JSONObject(str);
                                                    str2 = str;
                                                    jSONObject4 = jSONObject3;
                                                } catch (Throwable th2) {
                                                    com.bytedance.msdk.j.up.cw.j("SdkSettingsHelper", ">>>>> setting data error: " + th2.toString());
                                                }
                                            }
                                            str2 = str;
                                            jSONObject4 = jSONObject7;
                                        } else {
                                            if (optInt == 1) {
                                                str = com.bytedance.msdk.tl.j.xt(jSONObject7.optString(CrashHianalyticsData.MESSAGE), com.bytedance.msdk.tl.xt.j());
                                                if (!TextUtils.isEmpty(str)) {
                                                    try {
                                                        com.bytedance.msdk.j.up.cw.j("SdkSettingsHelper", "setting data : " + str.toString());
                                                        jSONObject3 = new JSONObject(str);
                                                        str2 = str;
                                                        jSONObject4 = jSONObject3;
                                                    } catch (Throwable th3) {
                                                        com.bytedance.msdk.j.up.cw.j("SdkSettingsHelper", "setting data error: ", th3);
                                                    }
                                                }
                                            } else if (optInt == 0) {
                                                str = jSONObject7.optString(CrashHianalyticsData.MESSAGE);
                                                jSONObject7 = new JSONObject(str);
                                            } else {
                                                str = null;
                                            }
                                            str2 = str;
                                            jSONObject4 = jSONObject7;
                                        }
                                        jSONObject5.put("decrypt_time", SystemClock.elapsedRealtime() - elapsedRealtime2);
                                        AnonymousClass3 anonymousClass34 = AnonymousClass3.this;
                                        xt.this.j(iArr2, iArr, xtVar, jSONObject4, str2, iArr3, upVar, jSONObject5, i6, z6, currentTimeMillis);
                                    } catch (Throwable th4) {
                                        AnonymousClass3 anonymousClass35 = AnonymousClass3.this;
                                        iArr2[0] = 81006;
                                        xt.this.j(upVar, i6, 81006, th4.getMessage(), z6);
                                    }
                                } else {
                                    AnonymousClass3 anonymousClass36 = AnonymousClass3.this;
                                    iArr2[0] = 81013;
                                    xt.this.j(upVar, i6, 81013, "response body is null", z6);
                                }
                            } else {
                                AnonymousClass3 anonymousClass37 = AnonymousClass3.this;
                                iArr2[0] = 81007;
                                xt.this.j(upVar, i6, 81007, "response is null", z6);
                            }
                            AnonymousClass3 anonymousClass38 = AnonymousClass3.this;
                            int i7 = iArr[0];
                            int i8 = iArr2[0];
                            long currentTimeMillis2 = System.currentTimeMillis();
                            AnonymousClass3 anonymousClass39 = AnonymousClass3.this;
                            r.j(i7, i8, currentTimeMillis2 - currentTimeMillis, z5, i6 == 0, jSONObject, iArr3[0], jSONObject5);
                        }
                    });
                }

                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, final IOException iOException) {
                    m.j(new Runnable() { // from class: com.bytedance.msdk.core.ws.xt.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.msdk.j.up.cw.r("SdkSettingsHelper", "----网络错误，服务器无响应，稍后会尝试重新拉取配置----，setting request failed..." + iOException.getMessage());
                            xt.this.f24811m.set(false);
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            iArr[0] = 0;
                            iArr2[0] = -2;
                            xt.this.j(upVar, i6, -2, "request fail：" + iOException.getMessage(), z6);
                            AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                            int i7 = iArr[0];
                            int i8 = iArr2[0];
                            long currentTimeMillis2 = System.currentTimeMillis();
                            AnonymousClass3 anonymousClass33 = AnonymousClass3.this;
                            r.j(i7, i8, currentTimeMillis2 - currentTimeMillis, z5, i6 == 0, jSONObject, -1L, null);
                        }
                    });
                }
            });
        } catch (UnsatisfiedLinkError e6) {
            vl.j(e6);
            com.bytedance.msdk.core.qv.j.j().j(81017, "GM接口请求异常");
        }
    }

    public static JSONObject xt() {
        String xt;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.msdk.api.r.m l6 = com.bytedance.msdk.core.j.qv().l();
        if (l6 != null) {
            try {
                xt = l6.xt();
            } catch (JSONException e6) {
                vl.j(e6);
                return jSONObject;
            }
        } else {
            xt = "";
        }
        jSONObject.put(SocializeConstants.TENCENT_UID, xt);
        jSONObject.put("channel", l6 != null ? l6.cw() : "");
        jSONObject.put("sub_channel", l6 != null ? l6.r() : "");
        jSONObject.put("age", l6 != null ? l6.up() : 0);
        jSONObject.put("gender", l6 != null ? l6.m() : "");
        jSONObject.put("user_value_group", l6 != null ? l6.ae() : "");
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int[] iArr, int[] iArr2, com.bytedance.sdk.component.g.xt xtVar, JSONObject jSONObject, String str, int[] iArr3, up upVar, JSONObject jSONObject2, int i6, boolean z5, long j6) throws Throwable {
        String str2;
        String str3;
        String str4;
        long currentTimeMillis = System.currentTimeMillis() - j6;
        Map<String, String> j7 = j(xtVar.cw());
        if (j7 != null) {
            str3 = j7.get("active-control");
            str4 = j7.get("ts");
            str2 = j7.get(t.f36158s);
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
        }
        String j8 = f.j(str + str3 + str4);
        if (!TextUtils.isEmpty(j8) && j8.equalsIgnoreCase(str2)) {
            com.bytedance.msdk.core.xt.xt().r(str3);
        }
        j(jSONObject);
        int optInt = jSONObject.optInt("state_code", -80000);
        String optString = jSONObject.optString(CrashHianalyticsData.MESSAGE);
        if (optInt == 20000) {
            iArr[0] = 20000;
        }
        if (optInt == 30004) {
            iArr[0] = 30004;
            this.f24811m.set(false);
            this.f24810g.set(false);
            this.tl.removeCallbacksAndMessages(null);
            this.xt.j(jSONObject);
            j(upVar);
            com.bytedance.msdk.m.cw.r();
            j(z5, currentTimeMillis);
            return;
        }
        if (optInt == 20000 && !TextUtils.isEmpty(jSONObject.toString())) {
            iArr2[0] = 1;
            iArr[0] = 20000;
            String r5 = xtVar.r();
            if (r5 != null) {
                iArr3[0] = r5.length();
            }
            this.f24810g.set(false);
            this.tl.removeCallbacksAndMessages(null);
            this.ae.set(true);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.xt.j(jSONObject, false);
            jSONObject2.put("parse_save_time", SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f24811m.set(false);
            j(upVar);
            com.bytedance.msdk.m.cw.r();
            if (com.bytedance.msdk.core.j.qv().jy()) {
                up();
            }
            j(z5, currentTimeMillis);
            return;
        }
        if (optInt != -80000) {
            iArr[0] = optInt;
        }
        if (TextUtils.isEmpty(optString) && !TextUtils.isEmpty(jSONObject.optString("msg"))) {
            optString = jSONObject.optString("msg");
        }
        j(upVar, i6, iArr[0], optString, z5);
    }

    private void j(boolean z5, long j6) {
        l.j(z5 ? "v4Enc_config" : "v2Enc_config", true, j6, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(up upVar, int i6, int i7, String str, boolean z5) {
        if (z5) {
            try {
                com.bytedance.msdk.core.xt.xt().xt(true);
            } catch (Throwable th) {
                vl.j(th);
                return;
            }
        }
        l.j(z5 ? "v4Enc_config" : "v2Enc_config", false, 0L, "code = " + i7 + "，msg = " + str);
        com.bytedance.msdk.j.up.cw.r("SdkSettingsHelper", "----拉取配置失败: " + i7 + " msg = " + str);
        j(upVar, new com.bytedance.msdk.api.j(i7, str), i6);
        if (com.bytedance.msdk.core.xt.xt().l()) {
            return;
        }
        com.bytedance.msdk.core.qv.j.j().j(i7, "聚合config请求失败 code = " + i7 + " msg = " + str);
    }

    public static String j(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            try {
                th.printStackTrace(printWriter);
                String stringWriter2 = stringWriter.toString();
                try {
                    stringWriter.close();
                } catch (IOException unused) {
                }
                printWriter.close();
                return stringWriter2;
            } catch (Exception unused2) {
                stringWriter.close();
                printWriter.close();
                return null;
            } catch (Throwable th2) {
                try {
                    stringWriter.close();
                } catch (IOException unused3) {
                }
                printWriter.close();
                throw th2;
            }
        } catch (IOException unused4) {
            printWriter.close();
            return null;
        }
    }

    private void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optBoolean("remote_log_enabled")) {
                com.bytedance.msdk.j.up.cw.j();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.msdk.j.up.tl.j
    public void j(Message message) {
        if (message.what != 1) {
            return;
        }
        int i6 = message.arg1;
        int i7 = message.arg2;
        if (i6 == 3) {
            this.f24810g.set(false);
        }
        com.bytedance.msdk.j.up.cw.r("SdkSettingsHelper", "setting 发起尝试拉取配置请求... mLoadingSuccess:" + this.ae.get() + "tryCount:" + (i6 + 1));
        try {
            if (this.ae.get()) {
                return;
            }
            cw(i7);
        } catch (Throwable unused) {
        }
    }
}
