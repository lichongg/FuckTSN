package com.bytedance.sdk.openadsdk.core.kt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.mobads.sdk.internal.by;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.rn.ch;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.f;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bytedance.sdk.component.tl.j.tl {

    /* renamed from: j, reason: collision with root package name */
    public static final j f29337j = new j();
    private int cw;

    /* renamed from: r, reason: collision with root package name */
    private String f29338r;
    private long xt;

    public String j(Context context) {
        try {
            return com.bytedance.sdk.openadsdk.core.rn.oq.cw(context) ? "tv" : com.bytedance.sdk.openadsdk.core.rn.oq.xt(context) ? "android_pad" : FaceEnvironment.OS;
        } catch (Throwable unused) {
            return FaceEnvironment.OS;
        }
    }

    @Override // com.bytedance.sdk.component.tl.j.tl
    public byte[] xt(JSONObject jSONObject, int i6) {
        byte[] xt = xt(jSONObject);
        if (xt == null || !com.bytedance.sdk.component.panglearmor.g.xt() || i6 <= 3) {
            return null;
        }
        byte[] j6 = com.bytedance.sdk.component.panglearmor.g.j().j(xt);
        if (j6 == null) {
            ws.j().j(3, -1L, "stats");
        }
        return j6;
    }

    public static String qv() {
        StringBuilder sb = new StringBuilder();
        try {
            if (ch.av()) {
                sb.append("MIUI-");
            } else if (ch.kt()) {
                sb.append("FLYME-");
            } else {
                String tj = ch.tj();
                if (ch.j(tj)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(tj)) {
                    sb.append(tj);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    @Override // com.bytedance.sdk.component.tl.j.tl
    public String ae() {
        return uf.g("/api/ad/union/sdk/stats/batch/");
    }

    @Override // com.bytedance.sdk.component.tl.j.tl
    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", kt.cw());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.tl.j.tl
    public com.bytedance.sdk.component.tl.j.j.m up() {
        return new vl(com.bytedance.sdk.openadsdk.core.v.up.j().xt().xt());
    }

    private j() {
    }

    public static int vl() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    @Override // com.bytedance.sdk.component.tl.j.tl
    public long cw() {
        long v5 = v.xt().v();
        if (v5 >= 0 && v5 != 2147483647L) {
            return v5;
        }
        return 5000L;
    }

    @Override // com.bytedance.sdk.component.tl.j.tl
    public String m() {
        return uf.x();
    }

    @Override // com.bytedance.sdk.component.tl.j.tl
    public int oq() {
        if (v.xt().ik()) {
            return 4;
        }
        return 3;
    }

    @Override // com.bytedance.sdk.component.tl.j.tl
    public int r() {
        int x5 = v.xt().x();
        if (x5 >= 0 && x5 != Integer.MAX_VALUE) {
            return x5;
        }
        return 10;
    }

    @Override // com.bytedance.sdk.component.tl.j.tl
    public boolean tl() {
        return h.j();
    }

    private byte[] xt(JSONObject jSONObject) {
        GZIPOutputStream gZIPOutputStream = null;
        if (jSONObject == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            try {
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(jSONObject.toString().getBytes());
                        gZIPOutputStream2.close();
                    } catch (Exception e6) {
                        e = e6;
                        gZIPOutputStream = gZIPOutputStream2;
                        com.bytedance.sdk.component.utils.vl.j(e);
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e7) {
                                com.bytedance.sdk.component.utils.vl.j(e7);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e8) {
                e = e8;
            }
        } catch (IOException e9) {
            com.bytedance.sdk.component.utils.vl.j(e9);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @SuppressLint({"HardwareIds"})
    private JSONObject j(List<com.bytedance.sdk.component.tl.j.xt> list, boolean z5, boolean z6) {
        JSONObject jSONObject = new JSONObject();
        Context context = v.getContext();
        if (z5) {
            try {
                jSONObject.put("sdk_version", h.cw);
                jSONObject.put("display_name", com.bytedance.sdk.openadsdk.core.tl.j.up());
                jSONObject.put("app_version", com.bytedance.sdk.openadsdk.core.tl.j.r());
                jSONObject.put(WiseOpenHianalyticsData.UNION_PACKAGE, uf.g());
                jSONObject.put(AgConnectInfo.AgConnectKey.REGION, Locale.getDefault().getCountry());
                jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
                jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
                ArrayList<String> j6 = com.bytedance.sdk.component.utils.cw.j(context, by.f10823a);
                if (j6 != null && !j6.isEmpty()) {
                    jSONObject.put("sig_hash", j6.get(0));
                }
                jSONObject.put("version_code", uf.oq());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.r("log_net", th.getMessage());
                return jSONObject;
            }
        }
        jSONObject.put(au.f40899d, uf.ae());
        com.bytedance.sdk.openadsdk.av.xt.j(context, jSONObject);
        jSONObject.put("openudid", kt.m());
        jSONObject.put("oaid", f.j(false));
        jSONObject.put("ad_sdk_version", h.cw);
        jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
        jSONObject.put("is_plugin", h.j());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("client_ipv4", com.bytedance.sdk.openadsdk.core.rn.oq.j((String) null));
        jSONObject2.put("client_ipv6", com.bytedance.sdk.openadsdk.core.rn.oq.ae());
        jSONObject.put("custom", jSONObject2);
        jSONObject.put("sim_op", kt.az());
        jSONObject.put("root", z6 ? 1 : 0);
        jSONObject.put(bi.M, vl());
        jSONObject.put(bi.Q, com.bytedance.sdk.component.utils.ws.ae(context));
        jSONObject.put("os", "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        if (TextUtils.isEmpty(this.f29338r)) {
            this.f29338r = j(context);
        }
        jSONObject.put(bi.ai, this.f29338r);
        jSONObject.put("device_model", kt.v());
        jSONObject.put(bi.F, Build.BRAND);
        jSONObject.put(bi.H, Build.MANUFACTURER);
        jSONObject.put("language", Locale.getDefault().getLanguage());
        jSONObject.put("resolution", ed.up(context) + "x" + ed.r(context));
        jSONObject.put("display_density", j(ed.tl(context)));
        jSONObject.put("density_dpi", ed.tl(context));
        jSONObject.put("device_id", kt.cw());
        int cw = com.bytedance.sdk.component.tl.xt.cw.j.cw(list, com.bytedance.sdk.component.tl.xt.j.up("csj"));
        if (cw != 0) {
            jSONObject.put(CommonNetImpl.AID, String.valueOf(cw));
        } else {
            jSONObject.put(CommonNetImpl.AID, "1371");
        }
        jSONObject.put("rom", qv());
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", kt.vl());
        jSONObject.put("ut", this.cw);
        jSONObject.put("uid", this.xt);
        jSONObject.put("locale_language", com.bytedance.sdk.openadsdk.core.rn.oq.qv());
        jSONObject.put("screen_bright", Math.ceil(com.bytedance.sdk.openadsdk.core.rn.oq.vl() * 10.0f) / 10.0d);
        jSONObject.put("is_screen_off", !com.bytedance.sdk.openadsdk.core.rn.oq.j() ? 1 : 0);
        if (context != null) {
            jSONObject.put("download_channel", com.bytedance.sdk.openadsdk.core.tl.j.j(context));
        }
        if (p.cw() > 0) {
            jSONObject.put("screenshot_time", String.valueOf(p.cw()));
        }
        jSONObject.put("mnc", kt.mi());
        jSONObject.put("mcc", kt.i());
        jSONObject.put("pan_code_serial", Constants.DEFAULT_UIN);
        return jSONObject;
    }

    @Override // com.bytedance.sdk.component.tl.j.tl
    public String xt() {
        return uf.ch();
    }

    @Override // com.bytedance.sdk.component.tl.j.tl
    public JSONObject j(List<com.bytedance.sdk.component.tl.j.xt> list, boolean z5) {
        if (list != null && !list.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            boolean z6 = false;
            try {
                j(list.get(0));
                JSONArray jSONArray = new JSONArray();
                Iterator<com.bytedance.sdk.component.tl.j.xt> it = list.iterator();
                while (it.hasNext()) {
                    JSONObject ae = it.next().ae();
                    if (TextUtils.equals("pangle_live_sdk_monitor", ae.optString("event"))) {
                        if (!z6) {
                            z6 = true;
                        }
                        ae.putOpt("nt", Integer.valueOf(com.bytedance.sdk.component.utils.ws.cw(v.getContext())));
                    }
                    jSONArray.put(ae);
                }
                jSONObject.put("header", j(list, z6, z5));
                jSONObject.put("event_v3", jSONArray);
                jSONObject.put("magic_tag", "ss_app_log");
                jSONObject.put("_gen_time", System.currentTimeMillis());
                return jSONObject;
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.vl.cw(e6.getMessage());
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.j.tl
    public byte[] j(JSONObject jSONObject, int i6) {
        byte[] xt = xt(jSONObject);
        if (xt == null) {
            return null;
        }
        if (i6 > 3) {
            byte[] j6 = com.bytedance.sdk.component.panglearmor.g.j().j(xt);
            if (j6 == null) {
                ws.j().j(3, -1L, "applog");
            }
            return j6;
        }
        return TTEncryptUtils.a(xt, xt.length);
    }

    @Override // com.bytedance.sdk.component.tl.j.tl
    public boolean j() {
        return com.bytedance.sdk.openadsdk.core.oq.i().hl();
    }

    @Override // com.bytedance.sdk.component.tl.j.tl
    public JSONObject j(JSONObject jSONObject) {
        return com.bytedance.sdk.component.utils.j.j(jSONObject);
    }

    private void j(com.bytedance.sdk.component.tl.j.xt xtVar) {
        String optString;
        if (xtVar == null) {
            return;
        }
        JSONObject ae = xtVar.ae();
        JSONObject optJSONObject = ae.optJSONObject("params");
        if (optJSONObject != null) {
            optString = optJSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA, "");
        } else {
            optString = ae.optString(MediationConstant.EXTRA_LOG_EXTRA, "");
        }
        long r5 = uf.r(optString);
        int up = uf.up(optString);
        if (r5 == 0) {
            r5 = this.xt;
        }
        this.xt = r5;
        if (up == 0) {
            up = this.cw;
        }
        this.cw = up;
    }

    public static String j(int i6) {
        if (i6 == 120) {
            return "ldpi";
        }
        if (i6 == 160) {
            return "mdpi";
        }
        if (i6 == 240) {
            return "hdpi";
        }
        if (i6 == 320) {
            return "xhdpi";
        }
        if (i6 == 480) {
            return "xxhdpi";
        }
        if (i6 != 640) {
            return "mdpi";
        }
        return "xxxhdpi";
    }
}
