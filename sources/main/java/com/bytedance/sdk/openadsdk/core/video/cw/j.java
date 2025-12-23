package com.bytedance.sdk.openadsdk.core.video.cw;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.by;
import com.bytedance.android.metrics.ActionType;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.cw;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.rn.ch;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.f;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.g.xt;
import com.bytedance.sdk.openadsdk.l.ae;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;
import v0.a;
import v0.b;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static void j(final String str, final n nVar, final long j6) {
        ae.xt(new g("csj_live_log_event") { // from class: com.bytedance.sdk.openadsdk.core.video.cw.j.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    uf yv = nVar.yv();
                    String re = nVar.re();
                    if (TextUtils.isEmpty(re) && yv != null) {
                        re = yv.xt();
                    }
                    if (TextUtils.isEmpty(re)) {
                        return;
                    }
                    String m6 = yv != null ? yv.m() : null;
                    if (TextUtils.isEmpty(m6)) {
                        m6 = nVar.ej();
                    }
                    JSONObject c6 = a.c(new b().h(Long.parseLong(re)).b(yv != null ? yv.j() : "").g(m6).e(j.xt(com.bytedance.sdk.openadsdk.core.rn.uf.tl(nVar))).f(j.j(com.bytedance.sdk.openadsdk.core.rn.uf.tl(nVar))).a(ActionType.CLICK).d(j6).c(), j.j(v.getContext()));
                    c6.put("tob_extra", nVar.os());
                    m.xt(str, c6);
                } catch (Throwable th) {
                    vl.cw("TTLiveVideoUtil", "Throwable : ", th);
                }
            }
        });
    }

    public static EnterFromMerge xt(int i6) {
        return i6 == 7 ? EnterFromMerge.AD_UNION_EXCITATION : i6 == 8 ? EnterFromMerge.AD_UNION_INSERT : i6 == 5 ? EnterFromMerge.AD_UNION_FEED : i6 == 9 ? EnterFromMerge.AD_UNION_DRAW : EnterFromMerge.NO_VALUE;
    }

    private static String cw(int i6) {
        return i6 != 120 ? i6 != 160 ? i6 != 240 ? i6 != 320 ? i6 != 480 ? i6 != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    public static Map<String, String> j(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("device_id", kt.cw());
        hashMap.put("sdk_version", h.cw);
        hashMap.put("os", "Android");
        hashMap.put("os_version", Build.VERSION.RELEASE);
        hashMap.put("device_model", kt.v());
        hashMap.put("resolution", ed.up(context) + "x" + ed.r(context));
        hashMap.put("language", Locale.getDefault().getLanguage());
        hashMap.put(bi.M, String.valueOf(xt()));
        hashMap.put(bi.Q, ws.ae(context));
        hashMap.put("openudid", kt.m());
        hashMap.put(CommonNetImpl.AID, "1371");
        hashMap.put("display_name", com.bytedance.sdk.openadsdk.core.tl.j.up());
        hashMap.put("app_version", com.bytedance.sdk.openadsdk.core.tl.j.r());
        hashMap.put(WiseOpenHianalyticsData.UNION_PACKAGE, com.bytedance.sdk.openadsdk.core.rn.uf.g());
        hashMap.put(AgConnectInfo.AgConnectKey.REGION, Locale.getDefault().getCountry());
        hashMap.put("tz_name", Calendar.getInstance().getTimeZone().getID());
        hashMap.put("tz_offset", String.valueOf(Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000));
        hashMap.put("rom", j());
        String str = Build.MANUFACTURER;
        hashMap.put(bi.H, str);
        ArrayList<String> j6 = cw.j(context, by.f10823a);
        if (j6 != null && !j6.isEmpty()) {
            hashMap.put("sig_hash", str);
        }
        hashMap.put("display_density", cw(ed.tl(context)));
        hashMap.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("density_dpi", String.valueOf(ed.tl(context)));
        hashMap.put(bi.F, Build.BRAND);
        hashMap.put("build_serial", kt.vl());
        hashMap.put("version_code", com.bytedance.sdk.openadsdk.core.rn.uf.oq());
        hashMap.put("udid", kt.ae());
        hashMap.put("cpu_abi", Build.CPU_ABI);
        hashMap.put("oaid", f.j(false));
        return hashMap;
    }

    public static void xt(n nVar) {
        if (nVar != null && j(nVar)) {
            String tl = com.bytedance.sdk.openadsdk.core.tj.ed.tl(nVar);
            String g6 = com.bytedance.sdk.openadsdk.core.tj.ed.g(nVar);
            if (!TextUtils.isEmpty(tl)) {
                xt.j(tl).j(new av() { // from class: com.bytedance.sdk.openadsdk.core.video.cw.j.2
                    @Override // com.bytedance.sdk.component.m.av
                    @ATSMethod(2)
                    public void j(int i6, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.m.av
                    @ATSMethod(1)
                    public void j(qv qvVar) {
                    }
                });
            }
            if (TextUtils.isEmpty(g6)) {
                return;
            }
            xt.j(g6).j(new av() { // from class: com.bytedance.sdk.openadsdk.core.video.cw.j.3
                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(2)
                public void j(int i6, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(1)
                public void j(qv qvVar) {
                }
            });
        }
    }

    private static int xt() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static EnterMethod j(int i6) {
        if (i6 == 5) {
            return EnterMethod.LIVE_CARD;
        }
        if (i6 != 7 && i6 != 8 && i6 != 9) {
            return EnterMethod.NO_VALUE;
        }
        return EnterMethod.LIVE_CELL;
    }

    public static boolean j(n nVar) {
        return h.r() && com.bytedance.sdk.openadsdk.core.tj.ed.j(nVar);
    }

    private static String j() {
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
}
