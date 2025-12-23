package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkRequest;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.gx;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.bytedance.sdk.openadsdk.core.tj.wf;
import com.bytedance.sdk.openadsdk.core.tj.xp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class a implements s<com.bytedance.sdk.openadsdk.core.jy.j> {
    private static final AtomicInteger xt = new AtomicInteger(0);
    private AtomicLong cw = new AtomicLong(0);

    /* renamed from: j, reason: collision with root package name */
    private final Context f27767j;

    public static class cw {
        public final com.bytedance.sdk.openadsdk.core.tj.b cw;

        /* renamed from: j, reason: collision with root package name */
        public final int f27805j;
        public final String xt;

        public static cw j(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt("code");
            String optString = jSONObject.optString(CrashHianalyticsData.MESSAGE);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.bytedance.sdk.openadsdk.core.tj.b bVar = new com.bytedance.sdk.openadsdk.core.tj.b();
            if (optJSONObject != null) {
                try {
                    bVar.j(optJSONObject.optBoolean("is_open"));
                    bVar.j(optJSONObject.optString("req_id"));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.j(th);
                }
            }
            return new cw(optInt, optString, bVar);
        }

        private cw(int i6, String str, com.bytedance.sdk.openadsdk.core.tj.b bVar) {
            this.f27805j = i6;
            this.xt = str;
            this.cw = bVar;
        }
    }

    public static class j {
        final String ae;
        final long cw;

        /* renamed from: g, reason: collision with root package name */
        final String f27806g;

        /* renamed from: j, reason: collision with root package name */
        final int f27807j;

        /* renamed from: m, reason: collision with root package name */
        final int f27808m;
        final ArrayList<Integer> oq;

        /* renamed from: r, reason: collision with root package name */
        final int f27809r;
        public final com.bytedance.sdk.openadsdk.core.tj.j tl;
        final String up;
        final long xt;

        public static j j(JSONObject jSONObject) {
            return j(jSONObject, null, null);
        }

        public static j j(JSONObject jSONObject, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, nd ndVar) {
            Object obj;
            String optString = jSONObject.optString("did");
            int optInt = jSONObject.optInt("processing_time_ms");
            long optLong = jSONObject.optLong("s_receive_ts");
            long optLong2 = jSONObject.optLong("s_send_ts");
            int optInt2 = jSONObject.optInt("status_code");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("request_id");
            int optInt3 = jSONObject.optInt(MediationConstant.KEY_REASON);
            Pair<com.bytedance.sdk.openadsdk.core.tj.j, ArrayList<Integer>> j6 = com.bytedance.sdk.openadsdk.core.j.j(jSONObject, xtVar, ndVar, optLong2);
            if (j6 != null && (obj = j6.first) != null) {
                ((com.bytedance.sdk.openadsdk.core.tj.j) obj).j(jSONObject.optLong("request_after"));
            }
            return j6 == null ? new j(optString, optInt, optInt2, optString2, optInt3, optString3, null, optLong, optLong2, null) : new j(optString, optInt, optInt2, optString2, optInt3, optString3, (com.bytedance.sdk.openadsdk.core.tj.j) j6.first, optLong, optLong2, (ArrayList) j6.second);
        }

        private j(String str, int i6, int i7, String str2, int i8, String str3, com.bytedance.sdk.openadsdk.core.tj.j jVar, long j6, long j7, ArrayList<Integer> arrayList) {
            this.f27807j = i6;
            this.f27809r = i7;
            this.up = str2;
            this.ae = str3;
            this.tl = jVar;
            this.f27806g = str;
            this.f27808m = i8;
            this.xt = j6;
            this.cw = j7;
            this.oq = arrayList;
        }
    }

    public static class r {
        public final wf cw;

        /* renamed from: j, reason: collision with root package name */
        public final int f27815j;
        public final boolean xt;

        public static r j(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt("code");
            boolean optBoolean = jSONObject.optBoolean("verify");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            wf wfVar = new wf();
            if (optJSONObject != null) {
                try {
                    wfVar.j(optJSONObject.optInt(MediationConstant.KEY_REASON));
                    wfVar.xt(optJSONObject.optInt("corp_type"));
                    wfVar.cw(optJSONObject.optInt(MediationConstant.REWARD_AMOUNT));
                    wfVar.j(optJSONObject.optString(MediationConstant.REWARD_NAME));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.j(th);
                }
            }
            return new r(optInt, optBoolean, wfVar);
        }

        private r(int i6, boolean z5, wf wfVar) {
            this.f27815j = i6;
            this.xt = z5;
            this.cw = wfVar;
        }
    }

    public static class xt {

        /* renamed from: j, reason: collision with root package name */
        public final int f27816j;
        public final boolean xt;

        public static xt j(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new xt(jSONObject.optInt("error_code"), jSONObject.optBoolean("result"));
        }

        private xt(int i6, boolean z5) {
            this.f27816j = i6;
            this.xt = z5;
        }
    }

    private boolean cw(String str) {
        if (com.bytedance.sdk.openadsdk.core.ws.cw.cw()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.ws.cw.xt(str)) {
            return false;
        }
        String r5 = com.bytedance.sdk.openadsdk.core.ws.cw.r();
        if (!TextUtils.isEmpty(r5)) {
            com.bytedance.sdk.openadsdk.core.kt.ws.j(r5, System.currentTimeMillis(), true);
        }
        return true;
    }

    private boolean xt(int i6) {
        return i6 == 3 || i6 == 4;
    }

    public void r(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, nd ndVar, int i6, s.xt xtVar2) {
        xt(xtVar, ndVar, i6, xtVar2, "/api/ad/union/sdk/get_ads/", 5);
    }

    private boolean r(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        return xtVar != null && xtVar.ae() == 320 && xtVar.m() == 640;
    }

    private boolean xt(String str) {
        if (com.bytedance.sdk.openadsdk.core.ws.cw.j()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.ws.cw.j(str)) {
            return false;
        }
        String xt2 = com.bytedance.sdk.openadsdk.core.ws.cw.xt();
        if (!TextUtils.isEmpty(xt2)) {
            com.bytedance.sdk.openadsdk.core.kt.ws.j(xt2, System.currentTimeMillis(), false);
        }
        return true;
    }

    public void up(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final nd ndVar, final int i6, s.xt xtVar2) {
        final com.bytedance.sdk.openadsdk.core.j.j jVar = new com.bytedance.sdk.openadsdk.core.j.j(xtVar2);
        com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("bid_p_f") { // from class: com.bytedance.sdk.openadsdk.core.a.22
            @Override // java.lang.Runnable
            public void run() {
                a.this.j(xtVar, ndVar, i6, jVar, "/api/ad/union/server_bidding/pre_fetch/", 1);
            }
        });
    }

    a(Context context) {
        this.f27767j = context;
    }

    private void r(String str) {
        com.bytedance.sdk.component.g.xt.cw cw2 = com.bytedance.sdk.openadsdk.core.v.up.j().xt().cw();
        cw2.j(str);
        cw2.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.a.18
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public void cw(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final nd ndVar, final int i6, s.xt xtVar2) {
        final com.bytedance.sdk.openadsdk.core.j.j jVar = new com.bytedance.sdk.openadsdk.core.j.j(xtVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("bid_g_m") { // from class: com.bytedance.sdk.openadsdk.core.a.23
                @Override // java.lang.Runnable
                public void run() {
                    a.this.j(xtVar, ndVar, i6, jVar, "/api/ad/union/server_bidding/get_materials/", 3);
                }
            });
        } else {
            j(xtVar, ndVar, i6, jVar, "/api/ad/union/server_bidding/get_materials/", 3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public void xt(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final nd ndVar, final int i6, s.xt xtVar2) {
        final com.bytedance.sdk.openadsdk.core.j.j jVar = new com.bytedance.sdk.openadsdk.core.j.j(xtVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("bid_pre") { // from class: com.bytedance.sdk.openadsdk.core.a.11
                @Override // java.lang.Runnable
                public void run() {
                    a.this.j(xtVar, ndVar, i6, jVar, "/api/ad/union/server_bidding/pre_cache/", 2);
                }
            });
        } else {
            j(xtVar, ndVar, i6, jVar, "/api/ad/union/server_bidding/pre_cache/", 2);
        }
    }

    private static String cw(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        String a6 = oq.i().a();
        String m6 = oq.i().m();
        oq.i().xt((String) null);
        String f6 = xtVar != null ? xtVar.f() : null;
        if (TextUtils.isEmpty(a6)) {
            return j(f6, m6);
        }
        try {
            if (!TextUtils.isEmpty(a6) && a6.contains("game_adapter_did")) {
                a6 = j(new JSONArray(a6)).toString();
            }
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        if (TextUtils.isEmpty(f6)) {
            return j(a6, m6);
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(f6);
            int length = jSONArray.length();
            boolean z5 = false;
            for (int i6 = 0; i6 < length; i6++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i6);
                if (jSONObject != null) {
                    String optString = jSONObject.optString(CommonNetImpl.NAME, null);
                    if (TextUtils.equals("is_shake_ads", optString)) {
                        if (TextUtils.equals(m6, "0")) {
                            jSONObject.put("value", "0");
                            oq.i().xt("0");
                        } else {
                            oq.i().xt(jSONObject.optString("value"));
                        }
                        z5 = true;
                    }
                    hashSet.add(optString);
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(a6);
                int length2 = jSONArray2.length();
                for (int i7 = 0; i7 < length2; i7++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i7);
                    if (jSONObject2 != null) {
                        String optString2 = jSONObject2.optString(CommonNetImpl.NAME, null);
                        if (!hashSet.contains(optString2)) {
                            if (TextUtils.equals("is_shake_ads", optString2)) {
                                if (TextUtils.equals(m6, "0")) {
                                    jSONObject2.put("value", "0");
                                    oq.i().xt("0");
                                } else {
                                    oq.i().xt(jSONObject2.optString("value"));
                                }
                                z5 = true;
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                if (!z5) {
                    jSONArray = xt(jSONArray, m6);
                }
                return j(j(jSONArray), m6).toString();
            } catch (Throwable unused) {
                return j(f6, m6);
            }
        } catch (Throwable unused2) {
            return j(a6, m6);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(39:0|1|(3:127|128|(1:130)(34:131|4|(2:8|(1:(1:11)(1:12))(1:13))|14|(2:(1:19)|(1:23))(2:121|(1:126))|24|25|(1:27)|(2:29|(3:31|32|33)(1:117))(1:119)|34|(1:36)|37|(1:114)|43|(1:45)(1:113)|46|(1:48)(1:112)|49|(1:51)|52|(1:54)(1:111)|55|(10:57|(1:61)|(1:65)|66|(1:68)|69|70|(1:72)(1:76)|(1:74)|75)|77|78|(1:110)(1:82)|83|(1:85)|86|(1:89)|90|(4:92|(3:94|(1:96)(1:101)|97)(1:102)|98|(1:100))|(1:104)(2:107|(1:109))|105))|3|4|(3:6|8|(0)(0))|14|(0)(0)|24|25|(0)|(0)(0)|34|(0)|37|(1:39)|114|43|(0)(0)|46|(0)(0)|49|(0)|52|(0)(0)|55|(0)|77|78|(1:80)|110|83|(0)|86|(1:89)|90|(0)|(0)(0)|105) */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x00a2, code lost:
    
        r17 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x035b A[Catch: all -> 0x036d, TryCatch #2 {all -> 0x036d, blocks: (B:128:0x0017, B:131:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:43:0x00e5, B:46:0x0113, B:48:0x014c, B:49:0x016b, B:51:0x0182, B:52:0x0187, B:55:0x0196, B:57:0x01bb, B:59:0x01c5, B:61:0x01cb, B:63:0x01d2, B:65:0x01d8, B:66:0x01e1, B:68:0x01eb, B:69:0x01f8, B:72:0x0206, B:74:0x021d, B:75:0x0226, B:76:0x020d, B:77:0x023f, B:80:0x026c, B:82:0x0270, B:83:0x0277, B:85:0x029f, B:86:0x02a4, B:89:0x02ea, B:90:0x02fa, B:92:0x0305, B:94:0x032c, B:97:0x0336, B:98:0x034b, B:100:0x034f, B:102:0x033e, B:104:0x035b, B:109:0x0364, B:124:0x007a, B:126:0x007e, B:3:0x0027), top: B:127:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c A[Catch: all -> 0x036d, TryCatch #2 {all -> 0x036d, blocks: (B:128:0x0017, B:131:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:43:0x00e5, B:46:0x0113, B:48:0x014c, B:49:0x016b, B:51:0x0182, B:52:0x0187, B:55:0x0196, B:57:0x01bb, B:59:0x01c5, B:61:0x01cb, B:63:0x01d2, B:65:0x01d8, B:66:0x01e1, B:68:0x01eb, B:69:0x01f8, B:72:0x0206, B:74:0x021d, B:75:0x0226, B:76:0x020d, B:77:0x023f, B:80:0x026c, B:82:0x0270, B:83:0x0277, B:85:0x029f, B:86:0x02a4, B:89:0x02ea, B:90:0x02fa, B:92:0x0305, B:94:0x032c, B:97:0x0336, B:98:0x034b, B:100:0x034f, B:102:0x033e, B:104:0x035b, B:109:0x0364, B:124:0x007a, B:126:0x007e, B:3:0x0027), top: B:127:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009c A[Catch: all -> 0x00a2, TryCatch #0 {all -> 0x00a2, blocks: (B:25:0x0081, B:27:0x009c, B:29:0x00a7), top: B:24:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7 A[Catch: all -> 0x00a2, TRY_LEAVE, TryCatch #0 {all -> 0x00a2, blocks: (B:25:0x0081, B:27:0x009c, B:29:0x00a7), top: B:24:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c9 A[Catch: all -> 0x00e5, TryCatch #1 {all -> 0x00e5, blocks: (B:33:0x00b7, B:34:0x00c3, B:36:0x00c9, B:37:0x00ce, B:39:0x00d4, B:41:0x00da, B:114:0x00e0), top: B:32:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014c A[Catch: all -> 0x036d, TryCatch #2 {all -> 0x036d, blocks: (B:128:0x0017, B:131:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:43:0x00e5, B:46:0x0113, B:48:0x014c, B:49:0x016b, B:51:0x0182, B:52:0x0187, B:55:0x0196, B:57:0x01bb, B:59:0x01c5, B:61:0x01cb, B:63:0x01d2, B:65:0x01d8, B:66:0x01e1, B:68:0x01eb, B:69:0x01f8, B:72:0x0206, B:74:0x021d, B:75:0x0226, B:76:0x020d, B:77:0x023f, B:80:0x026c, B:82:0x0270, B:83:0x0277, B:85:0x029f, B:86:0x02a4, B:89:0x02ea, B:90:0x02fa, B:92:0x0305, B:94:0x032c, B:97:0x0336, B:98:0x034b, B:100:0x034f, B:102:0x033e, B:104:0x035b, B:109:0x0364, B:124:0x007a, B:126:0x007e, B:3:0x0027), top: B:127:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0182 A[Catch: all -> 0x036d, TryCatch #2 {all -> 0x036d, blocks: (B:128:0x0017, B:131:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:43:0x00e5, B:46:0x0113, B:48:0x014c, B:49:0x016b, B:51:0x0182, B:52:0x0187, B:55:0x0196, B:57:0x01bb, B:59:0x01c5, B:61:0x01cb, B:63:0x01d2, B:65:0x01d8, B:66:0x01e1, B:68:0x01eb, B:69:0x01f8, B:72:0x0206, B:74:0x021d, B:75:0x0226, B:76:0x020d, B:77:0x023f, B:80:0x026c, B:82:0x0270, B:83:0x0277, B:85:0x029f, B:86:0x02a4, B:89:0x02ea, B:90:0x02fa, B:92:0x0305, B:94:0x032c, B:97:0x0336, B:98:0x034b, B:100:0x034f, B:102:0x033e, B:104:0x035b, B:109:0x0364, B:124:0x007a, B:126:0x007e, B:3:0x0027), top: B:127:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01bb A[Catch: all -> 0x036d, TryCatch #2 {all -> 0x036d, blocks: (B:128:0x0017, B:131:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:43:0x00e5, B:46:0x0113, B:48:0x014c, B:49:0x016b, B:51:0x0182, B:52:0x0187, B:55:0x0196, B:57:0x01bb, B:59:0x01c5, B:61:0x01cb, B:63:0x01d2, B:65:0x01d8, B:66:0x01e1, B:68:0x01eb, B:69:0x01f8, B:72:0x0206, B:74:0x021d, B:75:0x0226, B:76:0x020d, B:77:0x023f, B:80:0x026c, B:82:0x0270, B:83:0x0277, B:85:0x029f, B:86:0x02a4, B:89:0x02ea, B:90:0x02fa, B:92:0x0305, B:94:0x032c, B:97:0x0336, B:98:0x034b, B:100:0x034f, B:102:0x033e, B:104:0x035b, B:109:0x0364, B:124:0x007a, B:126:0x007e, B:3:0x0027), top: B:127:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x029f A[Catch: all -> 0x036d, TryCatch #2 {all -> 0x036d, blocks: (B:128:0x0017, B:131:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:43:0x00e5, B:46:0x0113, B:48:0x014c, B:49:0x016b, B:51:0x0182, B:52:0x0187, B:55:0x0196, B:57:0x01bb, B:59:0x01c5, B:61:0x01cb, B:63:0x01d2, B:65:0x01d8, B:66:0x01e1, B:68:0x01eb, B:69:0x01f8, B:72:0x0206, B:74:0x021d, B:75:0x0226, B:76:0x020d, B:77:0x023f, B:80:0x026c, B:82:0x0270, B:83:0x0277, B:85:0x029f, B:86:0x02a4, B:89:0x02ea, B:90:0x02fa, B:92:0x0305, B:94:0x032c, B:97:0x0336, B:98:0x034b, B:100:0x034f, B:102:0x033e, B:104:0x035b, B:109:0x0364, B:124:0x007a, B:126:0x007e, B:3:0x0027), top: B:127:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0305 A[Catch: all -> 0x036d, TryCatch #2 {all -> 0x036d, blocks: (B:128:0x0017, B:131:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:43:0x00e5, B:46:0x0113, B:48:0x014c, B:49:0x016b, B:51:0x0182, B:52:0x0187, B:55:0x0196, B:57:0x01bb, B:59:0x01c5, B:61:0x01cb, B:63:0x01d2, B:65:0x01d8, B:66:0x01e1, B:68:0x01eb, B:69:0x01f8, B:72:0x0206, B:74:0x021d, B:75:0x0226, B:76:0x020d, B:77:0x023f, B:80:0x026c, B:82:0x0270, B:83:0x0277, B:85:0x029f, B:86:0x02a4, B:89:0x02ea, B:90:0x02fa, B:92:0x0305, B:94:0x032c, B:97:0x0336, B:98:0x034b, B:100:0x034f, B:102:0x033e, B:104:0x035b, B:109:0x0364, B:124:0x007a, B:126:0x007e, B:3:0x0027), top: B:127:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject j(com.bytedance.sdk.openadsdk.i.cw.cw.xt r24, com.bytedance.sdk.openadsdk.core.tj.nd r25, int r26, boolean r27, int r28) {
        /*
            Method dump skipped, instructions count: 878
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.a.j(com.bytedance.sdk.openadsdk.i.cw.cw.xt, com.bytedance.sdk.openadsdk.core.tj.nd, int, boolean, int):org.json.JSONObject");
    }

    private void xt(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final nd ndVar, final int i6, s.xt xtVar2, String str, final int i7) {
        final com.bytedance.sdk.openadsdk.core.tj.xt xtVar3;
        final s.xt xtVar4;
        Throwable th;
        com.bytedance.sdk.openadsdk.core.tj.xt xtVar5 = new com.bytedance.sdk.openadsdk.core.tj.xt();
        xtVar5.j(xtVar);
        try {
            xtVar3 = xtVar5;
            xtVar4 = xtVar2;
            if (j(xtVar, xtVar5, xtVar2, i7 == 5, ndVar, i6)) {
                return;
            }
            try {
                com.bytedance.sdk.component.g.xt.up j6 = j(xtVar, ndVar, i6, xtVar4, str, i7, xtVar3);
                if (j6 == null) {
                    try {
                        xtVar3.j(-15);
                        xtVar4.j(-15, g.j(-15), xtVar3);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        j(th, xtVar3, xtVar4);
                    }
                }
                try {
                } catch (Throwable th3) {
                    th = th3;
                }
                try {
                    com.bytedance.sdk.component.g.j.j jVar = new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.a.19
                        @Override // com.bytedance.sdk.component.g.j.j
                        public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar6) {
                            a.this.j(rVar, xtVar6, xtVar3, xtVar4, xtVar, ndVar, i6, i7);
                        }

                        @Override // com.bytedance.sdk.component.g.j.j
                        public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                            a.this.j(rVar, iOException, xtVar3, xtVar4);
                        }
                    };
                    xtVar3 = xtVar3;
                    xtVar4 = xtVar4;
                    j6.j(jVar);
                    com.bytedance.sdk.openadsdk.core.r.j().cw();
                    j();
                } catch (Throwable th4) {
                    th = th4;
                    xtVar3 = xtVar3;
                    xtVar4 = xtVar4;
                    th = th;
                    j(th, xtVar3, xtVar4);
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            xtVar3 = xtVar5;
            xtVar4 = xtVar2;
        }
    }

    private JSONObject xt(com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar, List<com.bytedance.sdk.openadsdk.i.cw.xt.m> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.umeng.ccg.a.f41544t, "dislike");
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", h.cw);
            com.bytedance.sdk.openadsdk.av.xt.j(jSONObject2);
            if (xtVar != null) {
                jSONObject2.put(JThirdPlatFormInterface.KEY_EXTRA, xtVar.r());
                if (xtVar.xt() == null) {
                    xtVar.j("other");
                }
                jSONObject2.put("dislike_source", xtVar.xt());
            }
            String j6 = j(list);
            if (j6 != null) {
                jSONObject2.put("comment", j6);
                list.clear();
            } else {
                jSONObject2.put("comment", (Object) null);
            }
            jSONObject2.put("filter_words", xt(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONArray xt(List<com.bytedance.sdk.openadsdk.i.cw.xt.m> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.sdk.openadsdk.i.cw.xt.m> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().j());
            }
            return jSONArray;
        }
        return new JSONArray();
    }

    private static String xt(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        String cw2 = cw(xtVar);
        Map<String, Object> l6 = oq.i().l();
        if (l6 != null && !l6.isEmpty()) {
            try {
                JSONArray jSONArray = TextUtils.isEmpty(cw2) ? new JSONArray() : new JSONArray(cw2);
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                    String optString = optJSONObject != null ? optJSONObject.optString(CommonNetImpl.NAME) : "";
                    if (!TextUtils.isEmpty(optString) && l6.containsKey(optString)) {
                        l6.remove(optString);
                    }
                }
                for (Map.Entry<String, Object> entry : l6.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(CommonNetImpl.NAME, entry.getKey());
                        jSONObject.put("value", entry.getValue());
                        jSONArray.put(jSONObject);
                    }
                }
                return j(jSONArray).toString();
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        }
        return cw2;
    }

    private static JSONArray xt(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        try {
            if (TextUtils.equals("0", str)) {
                jSONObject = new JSONObject();
                jSONObject.put(CommonNetImpl.NAME, "is_shake_ads");
                jSONObject.put("value", "0");
                oq.i().xt("0");
            } else {
                jSONObject = null;
            }
            if (jSONObject == null) {
                return jSONArray;
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONArray.put(jSONArray.length(), jSONObject);
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, jSONObject);
            return jSONArray2;
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return jSONArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(xp xpVar, String str, String str2, final s.cw cwVar, int i6, long j6) {
        JSONObject j7 = j(xpVar, str, str2);
        com.bytedance.sdk.component.g.xt.up xt2 = com.bytedance.sdk.openadsdk.core.v.up.j().xt().xt();
        if (i6 == 1) {
            xt2.j(xpVar.ae());
        } else {
            xt2.j(xpVar.j());
        }
        xt2.j(j7);
        xt2.up(new HashMap());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.bytedance.sdk.component.utils.tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.12
            @Override // java.lang.Runnable
            public void run() {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                cwVar.j(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN, "time out!");
            }
        }, j6);
        xt2.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.a.13
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                if (xtVar == null) {
                    cwVar.j(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN, "response is null!");
                    return;
                }
                if (!xtVar.tl()) {
                    cwVar.j(xtVar.j(), xtVar.xt());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(xtVar.r());
                    String optString = jSONObject.optString(CrashHianalyticsData.MESSAGE);
                    int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, -1);
                    if (optInt != 200) {
                        cwVar.j(optInt, optString);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        cwVar.j(optJSONObject);
                        return;
                    }
                    cwVar.j(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, optString + ", data is null!");
                } catch (Throwable th) {
                    cwVar.j(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, th.getMessage());
                }
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                cwVar.j(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(JSONObject jSONObject, final s.cw<com.bytedance.sdk.component.g.xt> cwVar) {
        String j6 = com.bytedance.sdk.openadsdk.core.rn.uf.j("/api/ad/union/sdk/apply_coupon/v2", false);
        gx gxVar = new gx(com.bytedance.sdk.openadsdk.core.v.up.j().xt().m());
        gxVar.j(j6);
        gxVar.cw(jSONObject, "coupon_apply");
        gxVar.up(new HashMap());
        gxVar.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.a.17
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                s.cw cwVar2 = cwVar;
                if (cwVar2 != null) {
                    cwVar2.j(xtVar);
                }
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                s.cw cwVar2 = cwVar;
                if (cwVar2 != null) {
                    cwVar2.j(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
                }
            }
        });
    }

    private void j(JSONObject jSONObject, nd ndVar) {
        JSONArray jSONArray;
        if (ndVar == null || (jSONArray = ndVar.up) == null) {
            return;
        }
        try {
            jSONObject.put("source_temai_product_ids", jSONArray);
        } catch (Exception unused) {
        }
    }

    private void j(com.bytedance.sdk.openadsdk.core.tj.xt xtVar, long j6, long j7, long j8, long j9) {
        if (xtVar == null) {
            return;
        }
        xtVar.j(j6);
        xtVar.xt(j8);
        xtVar.cw(j7);
        xtVar.r(j9);
    }

    private boolean j(String str, nd ndVar) {
        float r5 = com.bytedance.sdk.openadsdk.core.cw.up.j().r();
        if (ndVar != null && ndVar.f30365r == 2 && r5 > 0.0f) {
            return cw(str);
        }
        return xt(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final nd ndVar, final int i6, s.xt xtVar2) {
        final com.bytedance.sdk.openadsdk.core.j.j jVar = new com.bytedance.sdk.openadsdk.core.j.j(xtVar2);
        jVar.j(i6);
        if ((i6 != 3 || !com.bytedance.sdk.openadsdk.core.component.splash.r.j(xtVar)) && Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.oq.ae.up(new com.bytedance.sdk.component.oq.g("get_ad") { // from class: com.bytedance.sdk.openadsdk.core.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.r(xtVar, ndVar, i6, jVar);
                }
            });
        } else {
            r(xtVar, ndVar, i6, jVar);
        }
    }

    public com.bytedance.sdk.openadsdk.core.l.xt j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2, nd ndVar, int i6, int i7, s.xt xtVar3) {
        com.bytedance.sdk.openadsdk.core.l.xt xt2;
        com.bytedance.sdk.openadsdk.tools.xt.j(xtVar);
        boolean z5 = i7 == 5;
        ndVar.j("buildAdBodyReady", z5);
        JSONObject j6 = j(xtVar, ndVar, i6, false, i7);
        ndVar.j("doBuildAdBody", z5);
        if (j6 == null) {
            xtVar2.j(-9);
            xtVar3.j(-9, g.j(-9), xtVar2);
            return null;
        }
        String jSONObject = j6.toString();
        if (i7 == 5) {
            long currentTimeMillis = System.currentTimeMillis();
            xt2 = com.bytedance.sdk.openadsdk.core.cw.m.j().j(jSONObject);
            ndVar.j("encrypt", System.currentTimeMillis() - currentTimeMillis, z5);
        } else {
            xt2 = com.bytedance.sdk.openadsdk.core.cw.m.j().xt(jSONObject);
        }
        if (xt2 == null) {
            xtVar2.j(-9);
            xtVar3.j(-9, g.j(-9), xtVar2);
            return null;
        }
        xt2.j(j6);
        return xt2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, nd ndVar, int i6, s.xt xtVar2, String str, int i7) {
        xt(xtVar, ndVar, i6, xtVar2, str, i7);
    }

    private boolean j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2, s.xt xtVar3, boolean z5, nd ndVar, int i6) {
        if (xtVar3 == null) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.p.g.j()) {
            xtVar2.j(1000);
            xtVar3.j(1000, "广告请求开关已关闭,请联系穿山甲管理员", xtVar2);
            return true;
        }
        if (!z5) {
            return false;
        }
        ndVar.j("execGetAdReady", z5);
        if (!TextUtils.isEmpty(xtVar.tj()) && ndVar.f30365r <= 0) {
            j(xtVar2, xtVar, xtVar3, ndVar, i6);
            com.bytedance.sdk.openadsdk.core.kt.xt.j();
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (j(xtVar.r(), ndVar)) {
            xtVar2.j(-8);
            xtVar3.j(-8, g.j(-8), xtVar2);
            com.bytedance.sdk.openadsdk.core.kt.xt.j();
            return true;
        }
        ndVar.j("checkCallFreq", System.currentTimeMillis() - currentTimeMillis, z5);
        return false;
    }

    private void j(com.bytedance.sdk.openadsdk.core.tj.xt xtVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar2, final s.xt xtVar3, nd ndVar, int i6) {
        xtVar.cw(2);
        xtVar.j(xtVar2.tj());
        try {
            boolean z5 = false;
            JSONObject j6 = com.bytedance.sdk.openadsdk.core.cw.m.j(new JSONObject(xtVar2.tj()), false, true);
            if (j6 == null) {
                j(xtVar3, xtVar);
                return;
            }
            j j7 = j.j(j6, xtVar2, ndVar);
            xtVar.j(j7.oq);
            kt.j(j7.f27806g);
            int i7 = j7.f27809r;
            if (i7 != 20000) {
                xtVar.j(i7);
                xtVar3.j(j7.f27809r, "reason: " + j7.f27808m + "  message: " + j7.up, xtVar);
                return;
            }
            com.bytedance.sdk.openadsdk.core.tj.j jVar = j7.tl;
            if (jVar == null) {
                j(xtVar3, xtVar);
                return;
            }
            jVar.j(j6);
            List<com.bytedance.sdk.openadsdk.core.tj.n> xt2 = j7.tl.xt();
            if (xt2 != null) {
                List<com.bytedance.sdk.openadsdk.core.tj.n> arrayList = new ArrayList<>(xt2);
                for (com.bytedance.sdk.openadsdk.core.tj.n nVar : xt2) {
                    com.bytedance.sdk.openadsdk.core.tj.n j8 = com.bytedance.sdk.openadsdk.core.rn.up.j(nVar.wq(), i6);
                    if (j8 != null) {
                        arrayList.remove(nVar);
                        j8.l(nVar.ua());
                        arrayList.add(j8);
                    } else if (nVar.uf()) {
                        final String str = j7.ae;
                        if (!TextUtils.isEmpty(str) && ndVar != null) {
                            ndVar.j(str);
                        }
                        final String r5 = xtVar2.r();
                        final String j9 = com.bytedance.sdk.openadsdk.core.rn.uf.j(xtVar2);
                        v.j().cw(xtVar2, ndVar, i6, new s.xt() { // from class: com.bytedance.sdk.openadsdk.core.a.20
                            @Override // com.bytedance.sdk.openadsdk.core.s.xt
                            public void j(int i8, String str2, com.bytedance.sdk.openadsdk.core.tj.xt xtVar4) {
                                com.bytedance.sdk.openadsdk.core.kt.ws.j().j(i8, str2, str, r5, j9);
                                xtVar3.j(i8, str2, xtVar4);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.s.xt
                            public void j(com.bytedance.sdk.openadsdk.core.tj.j jVar2, com.bytedance.sdk.openadsdk.core.tj.xt xtVar4) {
                                com.bytedance.sdk.openadsdk.core.kt.ws.j().j(0, "success", str, r5, j9);
                                xtVar3.j(jVar2, xtVar4);
                            }
                        });
                        z5 = true;
                    }
                }
                if (z5) {
                    return;
                } else {
                    j7.tl.j(arrayList);
                }
            }
            xtVar3.j(j7.tl, xtVar);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.cw("NetApiImpl", "get ad error: ", th);
            j(xtVar3, xtVar);
        }
    }

    private com.bytedance.sdk.component.g.xt.up j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, nd ndVar, int i6, s.xt xtVar2, String str, int i7, com.bytedance.sdk.openadsdk.core.tj.xt xtVar3) throws JSONException {
        byte[] bytes;
        Map<String, String> j6;
        com.bytedance.sdk.openadsdk.core.l.xt j7 = j(xtVar, xtVar3, ndVar, i6, i7, xtVar2);
        if (j7 == null) {
            return null;
        }
        String j8 = com.bytedance.sdk.openadsdk.core.rn.uf.j(str, true);
        com.bytedance.sdk.component.g.xt.up xt2 = com.bytedance.sdk.openadsdk.core.v.up.j().xt().xt();
        String j9 = com.bytedance.sdk.openadsdk.tl.cw.j(xt2, j8);
        xt2.j(j9);
        if (j7.j() != null) {
            com.bytedance.sdk.openadsdk.tl.cw.j(j7.j(), 0);
        }
        if (i7 == 5) {
            if (j7.r() != null) {
                JSONObject r5 = j7.r();
                xt2.j(r5);
                bytes = r5.toString().getBytes(StandardCharsets.UTF_8);
                xt2.j(false);
            } else {
                if (j7.cw() == null) {
                    return null;
                }
                bytes = j7.cw();
                xt2.j("application/octet-stream", bytes);
                xt2.j(true);
            }
        } else {
            JSONObject r6 = j7.r();
            xt2.j(r6);
            bytes = r6.toString().getBytes(StandardCharsets.UTF_8);
        }
        boolean z5 = i7 == 5;
        ndVar.j("doHttpReqSignReady", z5);
        com.bytedance.sdk.openadsdk.j.j.j j10 = com.bytedance.sdk.openadsdk.j.j.j.j(true);
        ndVar.j("MSInst", z5);
        Map<String, String> j11 = j10.j(j9, bytes);
        ndVar.j("doHttpReqSign", z5);
        if (j11 == null) {
            j11 = new HashMap<>();
        }
        if (i7 == 5 && (j6 = com.bytedance.sdk.openadsdk.tools.xt.j(xtVar.r())) != null) {
            j11.putAll(j6);
        }
        com.bytedance.sdk.openadsdk.core.rn.wq.j(j11);
        Map<String, String> up = j7.up();
        xt2.xt("User-Agent", com.bytedance.sdk.openadsdk.core.rn.uf.ae());
        if (up != null) {
            j11.putAll(up);
        }
        if (j11.size() > 0) {
            for (Map.Entry<String, String> entry : j11.entrySet()) {
                xt2.xt(entry.getKey(), entry.getValue());
            }
        }
        xt2.up(j(bytes, up, j7));
        ndVar.j("appendHeader", z5);
        return xt2;
    }

    private Map<String, Object> j(byte[] bArr, Map<String, String> map, com.bytedance.sdk.openadsdk.core.l.xt xtVar) {
        HashMap hashMap = new HashMap();
        try {
            com.bytedance.sdk.openadsdk.core.l.j jVar = new com.bytedance.sdk.openadsdk.core.l.j();
            jVar.tl(System.currentTimeMillis());
            jVar.g(bArr == null ? 0L : bArr.length);
            jVar.cw(xtVar.xt());
            if (map != null) {
                jVar.j(map.get("x-pglcypher"));
            }
            jVar.j(xtVar.j());
            jVar.xt(com.bytedance.sdk.component.panglearmor.g.cw());
            jVar.j(v.xt().uq());
            hashMap.put("load_time_model", jVar);
        } catch (Exception unused) {
        }
        return hashMap;
    }

    private void j() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cw.get() >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            this.cw.set(currentTimeMillis);
            com.bytedance.sdk.component.utils.tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.21
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.p.tl.j((com.bytedance.sdk.openadsdk.core.p.up) null).cw();
                }
            }, 10000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException, com.bytedance.sdk.openadsdk.core.tj.xt xtVar, s.xt xtVar2) {
        com.bytedance.sdk.openadsdk.core.kt.xt.j();
        if (iOException != null) {
            xtVar.j(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN);
            xtVar2.j(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN, iOException.getMessage(), xtVar);
            com.bytedance.sdk.component.utils.vl.j("NetApiImpl", "onFailure: ", Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE));
        }
    }

    private void j(Throwable th, com.bytedance.sdk.openadsdk.core.tj.xt xtVar, s.xt xtVar2) {
        if (xtVar2 != null) {
            xtVar.j(4000);
            xtVar2.j(4000, th.getMessage(), xtVar);
            com.bytedance.sdk.component.utils.vl.cw("NetApiImpl", " msg = ", th.getMessage());
        }
    }

    private void j(com.bytedance.sdk.component.g.xt xtVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar2, int i6, nd ndVar, s.xt xtVar3, com.bytedance.sdk.openadsdk.core.tj.xt xtVar4, com.bytedance.sdk.component.g.xt.r rVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str;
        String str2;
        j jVar;
        nd ndVar2 = ndVar;
        String str3 = "auction_price";
        if (xtVar != null) {
            if (xtVar.tl()) {
                a aVar = this;
                try {
                    com.bytedance.sdk.openadsdk.core.l.j j6 = aVar.j(rVar);
                    long currentTimeMillis = System.currentTimeMillis();
                    String r5 = xtVar.r();
                    xtVar4.j(r5);
                    LogAdapter logAdapter = LogAdapter.f31848j;
                    if (logAdapter != null) {
                        logAdapter.r("NetApiImpl", "response:");
                        LogAdapter.f31848j.r("NetApiImpl", r5);
                    }
                    JSONObject jSONObject3 = new JSONObject(r5);
                    int optInt = jSONObject3.optInt("status_code");
                    String optString = new JSONObject(xtVar2.tj()).optString("auction_price");
                    int i7 = 20000;
                    if (optInt != 20000) {
                        if (optInt == 40046) {
                            xtVar4.j(optInt);
                            xtVar3.j(40046, g.j(optInt), xtVar4);
                            return;
                        }
                        return;
                    }
                    JSONObject optJSONObject = jSONObject3.optJSONObject("adms");
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        JSONObject jSONObject4 = new JSONObject(optJSONObject.optString(keys.next()));
                        jSONObject4.put(str3, optString);
                        JSONObject j7 = com.bytedance.sdk.openadsdk.core.cw.m.j(jSONObject4, false, true);
                        if (j7 == null) {
                            j(xtVar3, xtVar4);
                            return;
                        }
                        j j8 = j.j(j7, xtVar2, ndVar2);
                        xtVar4.j(j8.oq);
                        int i8 = j8.f27809r;
                        if (i8 != i7) {
                            xtVar4.j(i8);
                            xtVar3.j(j8.f27809r, "reason: " + j8.f27808m + "  message: " + j8.up, xtVar4);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.tj.j jVar2 = j8.tl;
                        if (jVar2 == null) {
                            j(xtVar3, xtVar4);
                            return;
                        }
                        jVar2.j(j7);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (ndVar2 != null) {
                            jSONObject2 = j7;
                            str2 = str3;
                            jVar = j8;
                            jSONObject = optJSONObject;
                            str = optString;
                            aVar.j(xtVar4, j6.g() - ndVar2.ae, j8.f27807j, currentTimeMillis - j6.g(), currentTimeMillis2 - currentTimeMillis);
                        } else {
                            jSONObject = optJSONObject;
                            jSONObject2 = j7;
                            str = optString;
                            str2 = str3;
                            jVar = j8;
                        }
                        xtVar3.j(jVar.tl, xtVar4);
                        com.bytedance.sdk.openadsdk.xt.xt.j().j(jSONObject2);
                        i7 = 20000;
                        aVar = this;
                        str3 = str2;
                        ndVar2 = ndVar;
                        optString = str;
                        optJSONObject = jSONObject;
                    }
                    return;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.cw("NetApiImpl", "get ad error: ", th);
                    j(xtVar3, xtVar4);
                    return;
                }
            }
            int j9 = xtVar.j();
            String xt2 = xtVar.xt();
            xtVar4.j(j9);
            xtVar3.j(j9, xt2, xtVar4);
        }
    }

    private void j(com.bytedance.sdk.component.g.xt xtVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar2, int i6, nd ndVar, s.xt xtVar3, com.bytedance.sdk.openadsdk.core.tj.xt xtVar4) {
        if (xtVar != null) {
            try {
                JSONArray optJSONArray = new JSONObject(xtVar.r()).optJSONArray("ads");
                if (optJSONArray == null || optJSONArray.length() == 0) {
                    if (xtVar3 != null) {
                        xtVar3.j(-9, g.j(-9), xtVar4);
                        return;
                    }
                    return;
                }
                int h6 = v.xt().h();
                for (int i7 = 0; i7 < optJSONArray.length(); i7++) {
                    JSONObject optJSONObject = optJSONArray.getJSONObject(i7).optJSONObject("creative");
                    if (optJSONObject != null) {
                        JSONObject j6 = com.bytedance.sdk.openadsdk.core.cw.m.j(new JSONObject(optJSONObject.optString("adm")), false, true);
                        if (j6 == null && xtVar3 != null) {
                            xtVar3.j(-9, g.j(-9), xtVar4);
                        } else {
                            j j7 = j.j(j6, xtVar2, ndVar);
                            com.bytedance.sdk.openadsdk.core.rn.up.j(j7.tl, i6, h6);
                            if (xtVar3 != null) {
                                xtVar3.j(j7.tl, xtVar4);
                            }
                        }
                    } else if (xtVar3 != null) {
                        xtVar3.j(-9, g.j(-9), xtVar4);
                    }
                }
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
                if (xtVar3 != null) {
                    xtVar3.j(-9, g.j(-9), xtVar4);
                }
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.l.j j(com.bytedance.sdk.component.g.xt.r rVar) {
        try {
            Object obj = rVar.cw().get("load_time_model");
            if (obj instanceof com.bytedance.sdk.openadsdk.core.l.j) {
                com.bytedance.sdk.openadsdk.core.l.j jVar = (com.bytedance.sdk.openadsdk.core.l.j) obj;
                jVar.cw(true);
                return jVar;
            }
        } catch (Throwable unused) {
        }
        return new com.bytedance.sdk.openadsdk.core.l.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2, s.xt xtVar3, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar4, nd ndVar, int i6, int i7) {
        String str;
        final JSONObject j6;
        long j7;
        boolean z5;
        boolean z6;
        JSONObject jSONObject;
        j jVar;
        nd ndVar2;
        com.bytedance.sdk.openadsdk.core.l.j jVar2;
        int i8;
        a aVar;
        if (xtVar == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!xtVar.tl()) {
            int j8 = xtVar.j();
            String xt2 = xtVar.xt();
            xtVar2.j(j8);
            xtVar3.j(j8, xt2, xtVar2);
            com.bytedance.sdk.openadsdk.core.m.xt.xt();
            return;
        }
        if (i7 == 1) {
            j(xtVar, xtVar4, i6, ndVar, xtVar3, xtVar2);
            return;
        }
        if (i7 == 3) {
            j(xtVar, xtVar4, i6, ndVar, xtVar3, xtVar2, rVar);
            return;
        }
        com.bytedance.sdk.openadsdk.core.tj.xt xtVar5 = xtVar2;
        com.bytedance.sdk.openadsdk.core.l.j j9 = j(rVar);
        j9.m(currentTimeMillis);
        com.bytedance.sdk.openadsdk.core.kt.xt.j();
        try {
            final String r5 = xtVar.r();
            long j10 = 0;
            if (i7 == 5) {
                byte[] oq = xtVar.oq();
                Pair<Boolean, JSONObject> j11 = com.bytedance.sdk.openadsdk.core.cw.m.j(xtVar, "get_ads", true);
                j6 = (JSONObject) j11.second;
                final boolean booleanValue = ((Boolean) j11.first).booleanValue();
                if (booleanValue) {
                    if (!TextUtils.isEmpty(r5)) {
                        j10 = r5.getBytes(StandardCharsets.UTF_8).length;
                    }
                    xtVar5.j(r5);
                } else if (oq != null) {
                    j10 = oq.length;
                }
                long j12 = j10;
                if (LogAdapter.f31848j != null && j6 != null) {
                    com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("logAdapter") { // from class: com.bytedance.sdk.openadsdk.core.a.24
                        @Override // java.lang.Runnable
                        public void run() {
                            Object obj;
                            try {
                                String str2 = "";
                                if (booleanValue) {
                                    str2 = r5;
                                } else {
                                    Pair<Integer, JSONObject> j13 = com.bytedance.sdk.openadsdk.core.cw.m.j().j(j6.toString(), false);
                                    if (j13 != null && (obj = j13.second) != null) {
                                        str2 = ((JSONObject) obj).toString();
                                    }
                                }
                                if (LogAdapter.f31848j == null || TextUtils.isEmpty(str2)) {
                                    return;
                                }
                                LogAdapter.f31848j.r("NetApiImpl", "response:");
                                LogAdapter.f31848j.r("NetApiImpl", str2);
                            } catch (Exception e6) {
                                com.bytedance.sdk.component.utils.vl.cw(e6.getMessage());
                            }
                        }
                    });
                }
                z5 = booleanValue;
                j7 = j12;
            } else {
                xtVar5.j(r5);
                LogAdapter logAdapter = LogAdapter.f31848j;
                if (logAdapter != null) {
                    logAdapter.r("NetApiImpl", "response:");
                    LogAdapter.f31848j.r("NetApiImpl", r5);
                }
                JSONObject jSONObject2 = new JSONObject(r5);
                if (!TextUtils.isEmpty(r5)) {
                    j10 = r5.getBytes(StandardCharsets.UTF_8).length;
                }
                j6 = com.bytedance.sdk.openadsdk.core.cw.m.j(jSONObject2, false, true);
                j7 = j10;
                z5 = false;
            }
            JSONObject jSONObject3 = j6;
            j9.ae(j7);
            if (jSONObject3 == null) {
                j(xtVar3, xtVar5);
                return;
            }
            com.bytedance.sdk.openadsdk.tl.cw.xt(jSONObject3, 0);
            j j13 = j.j(jSONObject3, xtVar4, ndVar);
            xtVar5.j(j13.oq);
            kt.j(j13.f27806g);
            int i9 = j13.f27809r;
            if (i9 != 20000) {
                xtVar5.j(i9);
                xtVar5.xt(j13.f27808m);
                xtVar3.j(j13.f27809r, "reason: " + j13.f27808m + "  message: " + j13.up, xtVar5);
                return;
            }
            com.bytedance.sdk.openadsdk.core.tj.j jVar3 = j13.tl;
            if (jVar3 == null) {
                j(xtVar3, xtVar5);
                return;
            }
            jVar3.j(jSONObject3);
            j9.xt(System.currentTimeMillis());
            if (ndVar != null) {
                jVar = j13;
                ndVar2 = ndVar;
                jVar2 = j9;
                z6 = z5;
                jSONObject = jSONObject3;
                str = "NetApiImpl";
                i8 = 5;
                aVar = this;
                try {
                    aVar.j(xtVar5, j9.g() - ndVar.ae, j13.f27807j, j9.m() - j9.g(), j9.xt() - j9.m());
                    xtVar5 = xtVar5;
                } catch (Throwable th) {
                    th = th;
                    xtVar5 = xtVar5;
                    com.bytedance.sdk.component.utils.vl.cw(str, "get ad error: ", th);
                    j(xtVar3, xtVar5);
                }
            } else {
                z6 = z5;
                jSONObject = jSONObject3;
                jVar = j13;
                ndVar2 = ndVar;
                jVar2 = j9;
                str = "NetApiImpl";
                i8 = 5;
                aVar = this;
            }
            try {
                xtVar3.j(jVar.tl, xtVar5);
                for (com.bytedance.sdk.openadsdk.core.tj.n nVar : jVar.tl.xt()) {
                    if (ndVar2 != null) {
                        nVar.ch(ndVar2.xt());
                    }
                    if (com.bytedance.sdk.openadsdk.up.j.j(nVar)) {
                        com.bytedance.sdk.openadsdk.upie.xt.j().j(aVar.f27767j, com.bytedance.sdk.openadsdk.up.j.g(nVar));
                    }
                }
                if (jVar2.vl() && jVar.tl.xt() != null && !jVar.tl.xt().isEmpty()) {
                    com.bytedance.sdk.openadsdk.core.tj.n nVar2 = jVar.tl.xt().get(0);
                    com.bytedance.sdk.openadsdk.core.r.j().j(nVar2);
                    String xt3 = com.bytedance.sdk.openadsdk.core.rn.uf.xt(i6);
                    com.bytedance.sdk.openadsdk.core.l.j jVar4 = jVar2;
                    jVar4.xt(i7 != i8);
                    jVar4.j(i7 != i8 || z6);
                    jVar4.up(xtVar.up());
                    jVar4.r(xtVar.m());
                    jVar4.j(jVar.f27807j);
                    com.bytedance.sdk.component.xt.j.qv qv = xtVar.qv();
                    if (qv != null) {
                        jVar4.oq(qv.f27302j);
                        jVar4.qv(qv.xt);
                        jVar4.vl(qv.cw);
                        jVar4.jy(qv.f27304r);
                        jVar4.ws(qv.up);
                    }
                    aVar.j(ndVar2, nVar2, xt3, jVar4);
                }
                com.bytedance.sdk.openadsdk.xt.xt.j().j(jSONObject);
                com.bytedance.sdk.openadsdk.core.m.xt.xt();
            } catch (Throwable th2) {
                th = th2;
                com.bytedance.sdk.component.utils.vl.cw(str, "get ad error: ", th);
                j(xtVar3, xtVar5);
            }
        } catch (Throwable th3) {
            th = th3;
            str = "NetApiImpl";
        }
    }

    private void j(nd ndVar, com.bytedance.sdk.openadsdk.core.tj.n nVar, String str, com.bytedance.sdk.openadsdk.core.l.j jVar) {
        long j6;
        long j7;
        if (v.xt().ry() && jVar != null) {
            JSONObject jSONObject = new JSONObject();
            if (ndVar != null) {
                try {
                    if (ndVar.ae > 0) {
                        jSONObject.put("client_start_time", jVar.g() - ndVar.ae);
                        j6 = jVar.xt() - ndVar.ae;
                    } else {
                        j6 = 0;
                    }
                    if (ndVar.tl > 0) {
                        jSONObject.put("real_user_duration", jVar.xt() - ndVar.tl);
                        jSONObject.put("switch_st1_time", ndVar.ae - ndVar.tl);
                    }
                    j7 = j6;
                } catch (Exception unused) {
                    return;
                }
            } else {
                j7 = 0;
            }
            jSONObject.put("net_send_time", jVar.up() - jVar.g());
            jSONObject.put("net_rcv_time", jVar.r() - jVar.up());
            jSONObject.put("net_callback_time", jVar.m() - jVar.r());
            jSONObject.put("network_time", jVar.m() - jVar.g());
            jSONObject.put("sever_time", jVar.j());
            jSONObject.put("client_end_time", jVar.xt() - jVar.m());
            if (jVar.oq() > 0) {
                jSONObject.put("req_body_length", jVar.oq());
            }
            if (jVar.tl() > 0) {
                jSONObject.put("res_body_length", jVar.tl());
            }
            if (!TextUtils.isEmpty(jVar.qv())) {
                jSONObject.put("x-pglcypher", jVar.qv());
            }
            jSONObject.put("cypher_v", jVar.w());
            jSONObject.put("armor_s", jVar.mi());
            long cw2 = jVar.cw();
            if (cw2 > 0) {
                jSONObject.put("raw_req_length", cw2);
            }
            int i6 = 1;
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("net_module", com.bytedance.sdk.openadsdk.core.cw.cw.j().m());
            if (!jVar.ae()) {
                i6 = 2;
            }
            jSONObject.put("has_base64", i6);
            jSONObject.put("req_build_opt", com.bytedance.sdk.openadsdk.core.cw.cw.j().ae());
            jSONObject.put("is_boost", com.bytedance.sdk.openadsdk.core.r.j.r());
            jSONObject.put("opt_config", String.valueOf(v.xt().fk()));
            jSONObject.put("report_index", xt.getAndIncrement());
            if (jVar.av() > 0) {
                jSONObject.put("net_whqueue", jVar.ws() - jVar.jy());
                jSONObject.put("net_wtqueue", jVar.az() - jVar.ws());
                jSONObject.put("net_oconn", jVar.i() - jVar.av());
                jSONObject.put("net_bconn", jVar.av() - jVar.az());
            }
            try {
                JSONObject j8 = ndVar.ws.j(-1L);
                Iterator<String> keys = j8.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        jSONObject.put(next, j8.opt(next));
                    }
                }
            } catch (Exception unused2) {
            }
            com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar, str, "load_ad_time", j7, jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public void j(com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar, List<com.bytedance.sdk.openadsdk.i.cw.xt.m> list) {
        JSONObject xt2;
        if (com.bytedance.sdk.openadsdk.core.p.g.j() && (xt2 = xt(xtVar, list)) != null) {
            gx gxVar = new gx(com.bytedance.sdk.openadsdk.core.v.up.j().xt().m());
            gxVar.j(com.bytedance.sdk.openadsdk.core.rn.uf.tl("/api/ad/union/dislike_event/"));
            gxVar.cw(xt2, "dislike");
            gxVar.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.a.25
                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar2) {
                }

                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                }
            });
        }
    }

    private String j(List<com.bytedance.sdk.openadsdk.i.cw.xt.m> list) {
        if (list.get(0).j().equals("0:00")) {
            return list.get(0).xt();
        }
        return null;
    }

    public static void j(s.xt xtVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
        xtVar2.j(-1);
        xtVar.j(-1, g.j(-1), xtVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(s.up upVar) {
        upVar.j(-1, g.j(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(s.r rVar) {
        rVar.j(-1, g.j(-1));
    }

    private JSONObject j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, int i6) {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        try {
            j(jSONObject, "keywords", oq.i().ch());
            jSONObject.put("protection_of_minors", oq.i().ol());
            if (!com.bytedance.sdk.openadsdk.core.cw.r.j().ae(i6)) {
                com.bytedance.sdk.openadsdk.av.xt.xt(this.f27767j, jSONObject);
            }
            String xt2 = xt(xtVar);
            String j6 = com.bytedance.sdk.openadsdk.core.cw.r.j().j(xtVar.r(), "");
            if (!TextUtils.isEmpty(j6)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(CommonNetImpl.NAME, "dynamic_slot_ab_extra");
                jSONObject2.putOpt("value", j6);
                if (TextUtils.isEmpty(xt2)) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(xt2);
                }
                jSONArray.put(jSONObject2);
                String jSONArray2 = jSONArray.toString();
                if (!TextUtils.equals("[]", jSONArray2)) {
                    j(jSONObject, "data", jSONArray2);
                    return jSONObject;
                }
            } else if (!TextUtils.equals("[]", xt2)) {
                j(jSONObject, "data", xt2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONArray j(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                jSONObject = new JSONObject();
                jSONObject.put(CommonNetImpl.NAME, "can_use_sensor");
                jSONObject.put("value", str);
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONArray.put(jSONArray.length(), jSONObject);
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, jSONObject);
            return jSONArray2;
        }
        return jSONArray;
    }

    private static String j(String str, String str2) {
        if (str2 != null) {
            if (TextUtils.isEmpty(str)) {
                JSONArray xt2 = xt(j((JSONArray) null, str2), str2);
                if (xt2 == null) {
                    return null;
                }
                return xt2.toString();
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                boolean z5 = false;
                for (int i6 = 0; i6 < length; i6++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                    if (optJSONObject != null && TextUtils.equals(optJSONObject.optString(CommonNetImpl.NAME), "is_shake_ads")) {
                        if (TextUtils.equals("0", str2)) {
                            optJSONObject.put("value", "0");
                            oq.i().xt("0");
                        } else {
                            oq.i().xt(optJSONObject.optString("value"));
                        }
                        z5 = true;
                    }
                }
                if (!z5) {
                    jSONArray = xt(jSONArray, str2);
                }
                JSONArray j6 = j(jSONArray, str2);
                if (j6 != null) {
                    return j6.toString();
                }
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
                return str;
            }
        }
        return str;
    }

    private static JSONArray j(JSONArray jSONArray) throws JSONException {
        if (h.m() && jSONArray != null && jSONArray.length() != 0) {
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length();
            JSONObject jSONObject = null;
            for (int i6 = 0; i6 < length; i6++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i6);
                if (jSONObject2 != null) {
                    String optString = jSONObject2.optString(CommonNetImpl.NAME, null);
                    if (!"device_id".equals(optString)) {
                        if ("game_adapter_did".equals(optString)) {
                            jSONObject = jSONObject2;
                        } else {
                            jSONArray2.put(jSONObject2);
                        }
                    }
                }
            }
            if (jSONObject != null) {
                jSONObject.put(CommonNetImpl.NAME, "device_id");
                jSONArray2.put(jSONObject);
                return jSONArray2;
            }
        }
        return jSONArray;
    }

    private void j(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private JSONObject j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, int i6, nd ndVar) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", xtVar.r());
            jSONObject.put(MediationConstant.KEY_GM_PRIME_RIT, xtVar.mi());
            jSONObject.put("show_seq", xtVar.w());
            jSONObject.put("adtype", i6);
            jSONObject.put("themeStatus", oq.i().q());
            jSONObject.put("download_type", 0);
            if (!TextUtils.isEmpty(xtVar.j()) || !TextUtils.isEmpty(xtVar.xt()) || !TextUtils.isEmpty(xtVar.cw()) || com.bytedance.sdk.openadsdk.tools.xt.j()) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(xtVar.j())) {
                    jSONObject2.put(MediationConstant.EXTRA_ADID, xtVar.j());
                }
                if (!TextUtils.isEmpty(xtVar.xt())) {
                    jSONObject2.put("creative_id", xtVar.xt());
                }
                if (xtVar.cw() != null) {
                    jSONObject2.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, xtVar.cw());
                }
                com.bytedance.sdk.openadsdk.tools.xt.j(jSONObject2, xtVar.r());
                jSONObject.put("preview_ads", jSONObject2);
            }
            if (com.bytedance.sdk.openadsdk.tools.xt.j() && oq.i().zz()) {
                com.bytedance.sdk.openadsdk.tools.xt.xt(jSONObject, xtVar.r());
            }
            oq.r st = oq.i().st();
            if (st != null && com.bytedance.sdk.openadsdk.core.rn.uf.g().equals("com.pangolin_demo.toutiao")) {
                st.j(jSONObject);
            }
            int i7 = 1;
            if (i6 == 3 || i6 == 4) {
                if (ndVar != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("publisher_timeout_control", ndVar.f30362g);
                    jSONObject3.put("time_out_control", ndVar.oq);
                    jSONObject3.put("time_out", ndVar.qv);
                    jSONObject.put("tmax", jSONObject3);
                }
                jSONObject.put("splash_button_type", 1);
            }
            if (ndVar != null) {
                jSONObject.put("render_method", ndVar.f30364m);
                int i8 = ndVar.f30364m;
                if (i8 == 1) {
                    if (r(xtVar)) {
                        j(i6, jSONObject);
                    } else {
                        j(jSONObject, "accepted_size", xtVar.m(), xtVar.ae());
                    }
                } else if (i8 == 2) {
                    if (xtVar.tl() > 0.0f && xtVar.g() > 0.0f) {
                        j(jSONObject, "accepted_size", com.bytedance.sdk.openadsdk.core.rn.ed.cw(this.f27767j, xtVar.tl()), com.bytedance.sdk.openadsdk.core.rn.ed.cw(this.f27767j, xtVar.g()));
                    }
                    if (r(xtVar)) {
                        j(i6, jSONObject);
                    } else {
                        j(jSONObject, "accepted_size", xtVar.m(), xtVar.ae());
                    }
                }
            } else {
                jSONObject.put("render_method", 1);
                j(jSONObject, "accepted_size", xtVar.m(), xtVar.ae());
            }
            jSONObject.put("ptpl_ids", com.bytedance.sdk.openadsdk.core.cw.xt.j().j(xtVar.r(), i6));
            jSONObject.put("ptpl_ids_v3", com.bytedance.sdk.openadsdk.core.cw.xt.j().xt(xtVar.r(), i6));
            jSONObject.put("pos", com.bytedance.sdk.openadsdk.core.rn.uf.up(i6));
            jSONObject.put("is_support_dpl", xtVar.oq());
            jSONObject.put("if_support_render_control", xtVar.qv() ? 1 : 0);
            jSONObject.put("support_icon_style", (h.xt < 5900 || !xtVar.s()) ? 0 : 1);
            if (i6 == 3 || i6 == 4) {
                jSONObject.put("splash_load_type", v.xt().g(com.bytedance.sdk.openadsdk.core.rn.uf.xt(xtVar)));
            }
            if (i6 == 1 || i6 == 2) {
                jSONObject.put("is_origin_ad", true);
            }
            if (ndVar != null && (obj = ndVar.vl) != null) {
                jSONObject.put("session_params", obj);
            }
            int vl = xtVar.vl();
            if (i6 == 7) {
                if (com.bytedance.sdk.openadsdk.core.tj.la.j()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", com.bytedance.sdk.openadsdk.core.tj.la.up());
                }
                if (com.bytedance.sdk.openadsdk.core.tj.la.cw()) {
                    jSONObject.put("refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", com.bytedance.sdk.openadsdk.core.tj.la.ae());
                }
                if (com.bytedance.sdk.openadsdk.core.tj.la.r()) {
                    jSONObject.put("force_refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", com.bytedance.sdk.openadsdk.core.tj.la.ae());
                }
                vl = 1;
            }
            if (i6 == 8) {
                boolean av = v.xt().av(xtVar.r());
                boolean j6 = com.bytedance.sdk.openadsdk.core.ws.r.j(xtVar.r());
                if (!av) {
                    jSONObject.put("refresh_control", 0);
                } else if (j6) {
                    jSONObject.put("refresh_control", 0);
                    com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.a.2
                        @Override // com.bytedance.sdk.openadsdk.vl.j.j
                        public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put("cid", "");
                            } catch (JSONException e6) {
                                com.bytedance.sdk.component.utils.vl.j(e6);
                            }
                            return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("refresh_max").xt(jSONObject4.toString());
                        }
                    }, "refresh_max");
                } else {
                    jSONObject.put("refresh_control", 1);
                    jSONObject.put("refresh_ad_req_num", v.xt().d());
                }
                if (com.bytedance.sdk.openadsdk.core.tj.la.xt()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", com.bytedance.sdk.openadsdk.core.tj.la.m());
                }
            } else {
                i7 = vl;
            }
            if (ndVar != null && ndVar.up != null) {
                i7 = xtVar.vl();
            }
            jSONObject.put("ad_count", i7);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void j(int i6, JSONObject jSONObject) {
        if (xt(i6)) {
            j(jSONObject, "accepted_size", com.bytedance.sdk.openadsdk.core.rn.ed.r(this.f27767j), com.bytedance.sdk.openadsdk.core.rn.ed.up(this.f27767j));
        } else {
            j(jSONObject, "accepted_size", 640, 320);
        }
    }

    private void j(JSONObject jSONObject, String str, int i6, int i7) {
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (i6 > 0 && i7 > 0) {
                jSONObject2.put("width", i6);
                jSONObject2.put("height", i7);
            } else {
                jSONObject2.put("width", 640);
                jSONObject2.put("height", 320);
            }
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void j(JSONObject jSONObject, String str, float f6, float f7) {
        if (f6 <= 0.0f || f7 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", (int) f6);
            jSONObject2.put("height", (int) f7);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public void j(JSONObject jSONObject, final s.up upVar) {
        if (!com.bytedance.sdk.openadsdk.core.p.g.j()) {
            if (upVar != null) {
                upVar.j(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || upVar == null) {
                return;
            }
            gx gxVar = new gx(com.bytedance.sdk.openadsdk.core.v.up.j().xt().m());
            gxVar.j(com.bytedance.sdk.openadsdk.core.rn.uf.tl("/api/ad/union/sdk/reward_video/reward/"));
            gxVar.cw(jSONObject, "verify");
            gxVar.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.a.3
                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                    if (xtVar != null) {
                        if (!xtVar.tl()) {
                            String j6 = g.j(-2);
                            int j7 = xtVar.j();
                            if (!xtVar.tl() && !TextUtils.isEmpty(xtVar.xt())) {
                                j6 = xtVar.xt();
                            }
                            upVar.j(j7, j6);
                            return;
                        }
                        try {
                            Object obj = com.bytedance.sdk.openadsdk.core.cw.m.j(xtVar, "verify", false).second;
                            r j8 = r.j(obj != null ? (JSONObject) obj : new JSONObject(xtVar.r()));
                            int i6 = j8.f27815j;
                            if (i6 != 20000) {
                                upVar.j(i6, g.j(i6));
                                return;
                            } else if (j8.cw == null) {
                                a.this.j(upVar);
                                return;
                            } else {
                                upVar.j(j8);
                                return;
                            }
                        } catch (Exception e6) {
                            com.bytedance.sdk.component.utils.vl.j(e6);
                        }
                    }
                    a.this.j(upVar);
                }

                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                    upVar.j(-2, iOException.getMessage());
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public void j(JSONObject jSONObject, final s.r rVar) {
        if (!com.bytedance.sdk.openadsdk.core.p.g.j()) {
            if (rVar != null) {
                rVar.j(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || rVar == null) {
                return;
            }
            JSONObject j6 = com.bytedance.sdk.component.utils.j.j(jSONObject);
            com.bytedance.sdk.component.g.xt.up xt2 = com.bytedance.sdk.openadsdk.core.v.up.j().xt().xt();
            xt2.j(com.bytedance.sdk.openadsdk.core.rn.uf.tl("/api/ad/union/sdk/reward_video/live_room/reward"));
            xt2.cw(j6.toString());
            xt2.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.a.4
                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar2, com.bytedance.sdk.component.g.xt xtVar) {
                    if (xtVar != null) {
                        if (!xtVar.tl() || TextUtils.isEmpty(xtVar.r())) {
                            String j7 = g.j(-2);
                            int j8 = xtVar.j();
                            if (!xtVar.tl() && !TextUtils.isEmpty(xtVar.xt())) {
                                j7 = xtVar.xt();
                            }
                            rVar.j(j8, j7);
                            return;
                        }
                        try {
                            JSONObject jSONObject2 = new JSONObject(xtVar.r());
                            String cw2 = jSONObject2.optInt("cypher", -1) == 3 ? com.bytedance.sdk.component.utils.j.cw(jSONObject2.optString(CrashHianalyticsData.MESSAGE)) : null;
                            if (!TextUtils.isEmpty(cw2)) {
                                try {
                                    jSONObject2 = new JSONObject(cw2);
                                } catch (Throwable unused) {
                                }
                            }
                            cw j9 = cw.j(jSONObject2);
                            int i6 = j9.f27805j;
                            if (i6 != 20000) {
                                rVar.j(i6, g.j(i6));
                                return;
                            } else if (j9.cw == null) {
                                a.this.j(rVar);
                                return;
                            } else {
                                rVar.j(j9);
                                return;
                            }
                        } catch (JSONException e6) {
                            com.bytedance.sdk.component.utils.vl.j(e6);
                        }
                    }
                    a.this.j(rVar);
                }

                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar2, IOException iOException) {
                    rVar.j(-2, iOException.getMessage());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce  */
    @Override // com.bytedance.sdk.openadsdk.core.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String j(com.bytedance.sdk.openadsdk.i.cw.cw.xt r12, boolean r13, int r14) {
        /*
            r11 = this;
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            com.bytedance.sdk.openadsdk.core.tj.nd r4 = new com.bytedance.sdk.openadsdk.core.tj.nd
            r4.<init>()
            com.bytedance.sdk.openadsdk.core.ch r8 = r4.ws
            int r0 = r12.kt()
            r9 = 3
            if (r9 != r0) goto L19
            long r2 = java.lang.System.currentTimeMillis()
            r4.ae = r2
        L19:
            r0 = 2
            if (r13 == 0) goto L1e
            r4.f30364m = r0
        L1e:
            int r13 = r12.av()
            r10 = 1
            if (r10 == r13) goto L2b
            int r13 = r12.av()
            if (r0 != r13) goto L2d
        L2b:
            r4.f30364m = r0
        L2d:
            int r13 = r4.f30364m
            if (r13 == r0) goto L41
            com.bytedance.sdk.openadsdk.core.p.oq r13 = com.bytedance.sdk.openadsdk.core.v.xt()
            java.lang.String r2 = r12.r()
            boolean r13 = r13.oq(r2)
            if (r13 == 0) goto L41
            r4.f30364m = r0
        L41:
            int r13 = r12.kt()
            if (r13 <= 0) goto L4d
            int r13 = r12.kt()
            r5 = r13
            goto L53
        L4d:
            if (r14 <= 0) goto L51
            r5 = r14
            goto L53
        L51:
            r13 = 0
            r5 = 0
        L53:
            r6 = 1
            r7 = 4
            r2 = r11
            r3 = r12
            org.json.JSONObject r12 = r2.j(r3, r4, r5, r6, r7)
            java.lang.String r13 = "adbody_time"
            r8.xt(r13)
            r11.j(r3, r4, r5)
            java.lang.String r13 = "prefetch_time"
            r8.xt(r13)
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            java.lang.String r0 = "User-Agent"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.rn.uf.ae()     // Catch: java.lang.Exception -> L86
            r13.putOpt(r0, r3)     // Catch: java.lang.Exception -> L86
            java.lang.String r0 = "request_headers_time"
            r8.xt(r0)     // Catch: java.lang.Exception -> L86
            java.lang.String r0 = "header"
            r1.putOpt(r0, r13)     // Catch: java.lang.Exception -> L86
            java.lang.String r13 = "bid_request"
            r1.putOpt(r13, r12)     // Catch: java.lang.Exception -> L86
            goto L8b
        L86:
            r0 = move-exception
            r12 = r0
            com.bytedance.sdk.component.utils.vl.j(r12)
        L8b:
            java.lang.String r12 = r1.toString()
            com.bytedance.sdk.openadsdk.core.cw.m r13 = com.bytedance.sdk.openadsdk.core.cw.m.j()
            android.util.Pair r12 = r13.j(r12, r10)
            java.lang.String r13 = "encry_time"
            r8.xt(r13)
            com.bytedance.sdk.openadsdk.core.kt.ws r13 = com.bytedance.sdk.openadsdk.core.kt.ws.j()     // Catch: java.lang.Throwable -> La4
            r13.j(r14, r8)     // Catch: java.lang.Throwable -> La4
            goto La5
        La4:
        La5:
            java.lang.String r13 = ""
            if (r12 == 0) goto Lc0
            java.lang.Object r14 = r12.second
            if (r14 == 0) goto Lb5
            org.json.JSONObject r14 = (org.json.JSONObject) r14
            java.lang.String r13 = "message"
            java.lang.String r13 = r14.optString(r13)
        Lb5:
            java.lang.Object r12 = r12.first
            if (r12 == 0) goto Lc0
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            goto Lc1
        Lc0:
            r12 = 3
        Lc1:
            if (r12 == r9) goto Lce
            java.lang.String r12 = "0000000004"
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r12 = r12.concat(r13)
            return r12
        Lce:
            java.lang.String r12 = "0000000003"
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r12 = r12.concat(r13)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.a.j(com.bytedance.sdk.openadsdk.i.cw.cw.xt, boolean, int):java.lang.String");
    }

    private boolean j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, nd ndVar, int i6) {
        boolean j6 = v.xt().j(xtVar.r());
        if (j6) {
            up(xtVar, ndVar, i6, new s.xt() { // from class: com.bytedance.sdk.openadsdk.core.a.5
                @Override // com.bytedance.sdk.openadsdk.core.s.xt
                public void j(int i7, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                    com.bytedance.sdk.openadsdk.core.kt.ws.j().j(i7);
                }

                @Override // com.bytedance.sdk.openadsdk.core.s.xt
                public void j(com.bytedance.sdk.openadsdk.core.tj.j jVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                    com.bytedance.sdk.openadsdk.core.kt.ws.j().j(0);
                }
            });
        }
        return j6;
    }

    private void j(boolean z5, JSONObject jSONObject, String str) throws Exception {
        String j6 = com.bytedance.sdk.openadsdk.core.component.reward.j.j.xt.j().j(z5, str);
        String str2 = "0";
        String str3 = null;
        if (j6 != null && !TextUtils.isEmpty(j6)) {
            if (TextUtils.equals(j6, "0")) {
                str3 = "0";
            } else if (TextUtils.equals(j6, "1")) {
                str3 = "1";
            } else {
                JSONObject jSONObject2 = new JSONObject(j6);
                jSONObject.putOpt("cache_info", jSONObject2);
                str2 = jSONObject2.optString("req_id");
            }
        }
        com.bytedance.sdk.openadsdk.core.kt.ws.j().j(str, str2, str3, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public String j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        return j(xtVar, false, -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public void j(String str, String str2, final s.j jVar) {
        if (!com.bytedance.sdk.openadsdk.core.p.g.j()) {
            if (jVar != null) {
                jVar.j(false, -1L, 0L);
                return;
            }
            return;
        }
        if (str == null || str2 == null || jVar == null) {
            return;
        }
        JSONObject j6 = com.bytedance.sdk.openadsdk.core.up.xt.r.j(str, str2);
        gx gxVar = new gx(com.bytedance.sdk.openadsdk.core.v.up.j().xt().m());
        String tl = com.bytedance.sdk.openadsdk.core.rn.uf.tl("/api/ad/union/sdk/material/check/");
        try {
            if (TextUtils.isEmpty(new URL(tl).getQuery())) {
                tl = tl + "?abort_aes=1";
            } else {
                tl = tl + "&abort_aes=1";
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        gxVar.j(tl);
        gxVar.cw(j6, "check_ad");
        gxVar.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.a.6
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                long j7;
                boolean z5;
                if (xtVar != null) {
                    if (!xtVar.tl()) {
                        jVar.j(false, xtVar.j() != 0 ? xtVar.j() : -1L, xtVar.g());
                        return;
                    }
                    if (xtVar.r() != null) {
                        try {
                            xt j8 = xt.j(new JSONObject(xtVar.r()));
                            r1 = j8.f27816j;
                            j7 = r1;
                            z5 = j8.xt;
                        } catch (JSONException e7) {
                            com.bytedance.sdk.component.utils.vl.j(e7);
                        }
                        jVar.j(z5, j7, xtVar.g());
                    }
                    j7 = r1;
                    z5 = false;
                    jVar.j(z5, j7, xtVar.g());
                }
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                jVar.j(false, 0L, 0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public void j(List<com.bytedance.sdk.openadsdk.core.up.xt.r> list, final com.bytedance.sdk.openadsdk.core.up.xt.xt xtVar) {
        if (list == null || list.isEmpty() || xtVar == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        JSONObject j6 = com.bytedance.sdk.openadsdk.core.up.xt.r.j(list);
        gx gxVar = new gx(com.bytedance.sdk.openadsdk.core.v.up.j().xt().m());
        String tl = com.bytedance.sdk.openadsdk.core.rn.uf.tl("/api/ad/union/sdk/material/check_ads/");
        try {
            if (TextUtils.isEmpty(new URL(tl).getQuery())) {
                tl = tl + "?abort_aes=1";
            } else {
                tl = tl + "&abort_aes=1";
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        gxVar.j(tl);
        gxVar.cw(j6, "check_ads_nosplash");
        gxVar.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.a.7
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar2) {
                if (xtVar2 != null) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (!xtVar2.tl()) {
                        xtVar.j(null, xtVar2.j() != 0 ? xtVar2.j() : -1L, currentTimeMillis2);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.up.xt.cw cwVar = null;
                    if (xtVar2.r() != null) {
                        try {
                            cwVar = com.bytedance.sdk.openadsdk.core.up.xt.cw.j(new JSONObject(xtVar2.r()));
                            if (cwVar != null) {
                                r1 = cwVar.f30934j;
                            }
                        } catch (JSONException e7) {
                            com.bytedance.sdk.component.utils.vl.j(e7);
                        }
                    }
                    xtVar.j(cwVar, r1, currentTimeMillis2);
                }
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                xtVar.j(null, -1L, 0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public void j(JSONObject jSONObject, final com.bytedance.sdk.openadsdk.core.up.xt.xt xtVar) {
        if (xtVar == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        gx gxVar = new gx(com.bytedance.sdk.openadsdk.core.v.up.j().xt().m());
        String tl = com.bytedance.sdk.openadsdk.core.rn.uf.tl("/api/ad/union/sdk/material/cali/");
        try {
            if (TextUtils.isEmpty(new URL(tl).getQuery())) {
                tl = tl + "?abort_aes=1";
            } else {
                tl = tl + "&abort_aes=1";
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        gxVar.j(tl);
        gxVar.cw(jSONObject, "checkAndCorrectAd");
        gxVar.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.a.8
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar2) {
                long j6;
                if (xtVar2 != null) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (xtVar2.tl()) {
                        try {
                            Object obj = com.bytedance.sdk.openadsdk.core.cw.m.j(xtVar2, "checkAndCorrectAd", false).second;
                            com.bytedance.sdk.openadsdk.core.up.xt.up upVar = null;
                            JSONObject jSONObject2 = obj != null ? (JSONObject) obj : null;
                            if (jSONObject2 != null) {
                                try {
                                    upVar = com.bytedance.sdk.openadsdk.core.up.xt.up.j(jSONObject2);
                                    j6 = upVar != null ? upVar.f30946j : -1L;
                                } catch (Exception e7) {
                                    com.bytedance.sdk.component.utils.vl.j(e7);
                                }
                                xtVar.j(upVar, j6, currentTimeMillis2);
                                return;
                            }
                            j6 = -1;
                            xtVar.j(upVar, j6, currentTimeMillis2);
                            return;
                        } catch (Exception unused) {
                        }
                    }
                    xtVar.j(null, xtVar2.j() != 0 ? xtVar2.j() : -1L, currentTimeMillis2);
                }
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                xtVar.j(null, -1L, 0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public com.bytedance.sdk.component.adexpress.j.cw.j j(int i6) {
        String uc;
        if (!com.bytedance.sdk.openadsdk.core.p.g.j()) {
            return null;
        }
        if (i6 == 2) {
            uc = v.xt().ri();
        } else {
            uc = v.xt().uc();
        }
        if (TextUtils.isEmpty(uc)) {
            return null;
        }
        com.bytedance.sdk.component.g.xt.cw cw2 = com.bytedance.sdk.openadsdk.core.v.up.j().xt().cw();
        cw2.j(com.bytedance.sdk.openadsdk.core.rn.wq.xt(uc));
        com.bytedance.sdk.component.g.xt j6 = cw2.j();
        if (j6 != null) {
            try {
                if (j6.tl()) {
                    if (i6 == 2) {
                        return com.bytedance.sdk.openadsdk.core.ugeno.m.xt.up(j6.r());
                    }
                    return com.bytedance.sdk.component.adexpress.j.cw.j.r(j6.r());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public com.bytedance.sdk.openadsdk.core.tj.r j(final com.bytedance.sdk.openadsdk.core.tj.n nVar, String str) {
        String str2;
        String str3;
        Object obj;
        if (nVar != null) {
            str2 = nVar.fk();
            com.bytedance.sdk.openadsdk.core.tj.up by = nVar.by();
            com.bytedance.sdk.openadsdk.core.tj.m et = nVar.et();
            str3 = et != null ? et.jy() : null;
            if (TextUtils.isEmpty(str3) && by != null) {
                str3 = by.r();
            }
            Map<String, Object> lg = nVar.lg();
            if (TextUtils.isEmpty(str3) && lg != null && (obj = lg.get("ad_package_name")) != null) {
                str3 = obj.toString();
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = nVar.xt;
            }
        } else {
            str2 = null;
            str3 = null;
        }
        com.bytedance.sdk.component.g.xt.cw cw2 = com.bytedance.sdk.openadsdk.core.v.up.j().xt().cw();
        cw2.j(JPushConstants.HTTPS_PRE + v.xt().ki() + "/customer/api/app/pkg_info");
        cw2.j("convert_id", str2);
        cw2.j(bi.f40972o, str3);
        cw2.j("download_url", com.bytedance.sdk.openadsdk.l.tl.xt(str));
        String str4 = str2 + "_" + str3 + "_" + str;
        com.bytedance.sdk.openadsdk.core.tj.r j6 = com.bytedance.sdk.openadsdk.core.qv.j.j(str4);
        if (j6 != null) {
            return j6;
        }
        final com.bytedance.sdk.component.g.xt[] xtVarArr = {null};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        cw2.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.a.9
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                xtVarArr[0] = xtVar;
                countDownLatch.countDown();
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(final com.bytedance.sdk.component.g.xt.r rVar, final IOException iOException) {
                countDownLatch.countDown();
                com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.a.9.1
                    @Override // com.bytedance.sdk.openadsdk.vl.j.j
                    public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        com.bytedance.sdk.component.g.xt.r rVar2 = rVar;
                        if (rVar2 != null) {
                            jSONObject.putOpt("net_extra", rVar2.r());
                        }
                        IOException iOException2 = iOException;
                        if (iOException2 != null) {
                            jSONObject.putOpt("io_error", iOException2.getMessage());
                        }
                        com.bytedance.sdk.openadsdk.core.kt.j.xt<com.bytedance.sdk.openadsdk.core.kt.j.xt> xt2 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt();
                        com.bytedance.sdk.openadsdk.core.tj.n nVar2 = nVar;
                        return xt2.tl(nVar2 != null ? nVar2.os() : "").j("pkg_info_failed").xt(jSONObject.toString());
                    }
                }, "pkg_info_failed");
            }
        });
        try {
            countDownLatch.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        try {
            com.bytedance.sdk.component.g.xt xtVar = xtVarArr[0];
            if (xtVar != null && xtVar.tl() && !TextUtils.isEmpty(xtVarArr[0].r()) && new JSONObject(xtVarArr[0].r()).optInt("code", -1) == 0) {
                com.bytedance.sdk.openadsdk.core.tj.r rVar = new com.bytedance.sdk.openadsdk.core.tj.r(new JSONObject(xtVarArr[0].r()));
                com.bytedance.sdk.openadsdk.core.qv.j.j(str4, rVar);
                return rVar;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public void j(final xp xpVar, final String str, final String str2, final s.cw cwVar, final int i6, final long j6) {
        if (cwVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("get_wlink") { // from class: com.bytedance.sdk.openadsdk.core.a.10
                @Override // java.lang.Runnable
                public void run() {
                    a.this.xt(xpVar, str, str2, cwVar, i6, j6);
                }
            });
        } else {
            xt(xpVar, str, str2, cwVar, i6, j6);
        }
    }

    private JSONObject j(xp xpVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adv_id", xpVar.cw());
            jSONObject.put("site_id", xpVar.r());
            jSONObject.put("page_url", str);
            jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, str2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public void j(String str) {
        r(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public void j(final JSONObject jSONObject, final s.cw<com.bytedance.sdk.component.g.xt> cwVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.oq.ae.j().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.14
                @Override // java.lang.Runnable
                public void run() {
                    a.this.xt(jSONObject, (s.cw<com.bytedance.sdk.component.g.xt>) cwVar);
                }
            });
        } else {
            xt(jSONObject, cwVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public void j(final Function<SparseArray<Object>, Object> function) {
        com.bytedance.sdk.component.g.xt.up xt2 = com.bytedance.sdk.openadsdk.core.v.up.j().xt().xt();
        xt2.j(JPushConstants.HTTPS_PRE + oq.i().kc() + "/ad_union_qa/sdk/query_config_list");
        xt2.xt("x-pglcypher", "4");
        xt2.xt("x-ad-sdk-version", h.cw);
        xt2.xt("x-plugin-version", "7.0.1.2");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", oq.i().f());
            jSONObject.put("os", FaceEnvironment.OS);
            jSONObject.put("ad_sdk_version", h.cw);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
        } catch (Throwable unused) {
        }
        xt2.j("application/octet-stream", com.bytedance.sdk.component.panglearmor.g.j().j(com.bytedance.sdk.openadsdk.core.rn.vl.j(jSONObject.toString().getBytes(StandardCharsets.UTF_8))));
        xt2.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.a.15
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                Function function2 = function;
                if (function2 == null || xtVar == null) {
                    a.this.j((Function<SparseArray<Object>, Object>) function2, -1, "response is null");
                    return;
                }
                String xt3 = com.bytedance.sdk.openadsdk.core.rn.vl.xt((TextUtils.equals(xtVar.cw().get("content-type"), "application/octet-stream") || TextUtils.equals(xtVar.cw().get("x-pglcypher"), "4")) ? com.bytedance.sdk.component.panglearmor.g.j().xt(xtVar.oq()) : xtVar.r().getBytes());
                if (TextUtils.isEmpty(xt3)) {
                    a.this.j((Function<SparseArray<Object>, Object>) function, -3, "response unGzipStr is null");
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(xt3);
                    int optInt = jSONObject2.optInt("code", -1);
                    String optString = jSONObject2.optString(CrashHianalyticsData.MESSAGE);
                    if (optInt != 0) {
                        a.this.j((Function<SparseArray<Object>, Object>) function, optInt, optString);
                        return;
                    }
                    String optString2 = jSONObject2.optString("data");
                    if (TextUtils.isEmpty(optString2)) {
                        a.this.j((Function<SparseArray<Object>, Object>) function, optInt, "response data is empty");
                    } else {
                        a.this.j((Function<SparseArray<Object>, Object>) function, optString2);
                    }
                } catch (JSONException unused2) {
                    a.this.j((Function<SparseArray<Object>, Object>) function, -1, "response create json error");
                }
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                a.this.j((Function<SparseArray<Object>, Object>) function, -2, "response onFailure");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Function<SparseArray<Object>, Object> function, String str) {
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(10000).j(Void.class).j(0, str).xt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Function<SparseArray<Object>, Object> function, int i6, String str) {
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(10001).j(Void.class).j(0, Integer.valueOf(i6)).j(1, str).xt());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.s
    public void j(final Map<String, Object> map, final Function<SparseArray<Object>, Object> function) {
        if (map == null || map.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.g.xt.up xt2 = com.bytedance.sdk.openadsdk.core.v.up.j().xt().xt();
        xt2.j(JPushConstants.HTTPS_PRE + oq.i().kc() + "/ad_union_qa/sdk/get_ad_config");
        xt2.xt("x-pglcypher", "4");
        xt2.xt("x-ad-sdk-version", h.cw);
        xt2.xt("x-plugin-version", "7.0.1.2");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", oq.i().f());
            jSONObject.put("os", FaceEnvironment.OS);
            jSONObject.put("ad_sdk_version", h.cw);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            xt2.j("application/octet-stream", com.bytedance.sdk.component.panglearmor.g.j().j(com.bytedance.sdk.openadsdk.core.rn.vl.j(jSONObject.toString().getBytes(StandardCharsets.UTF_8))));
            xt2.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.a.16
                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                    String xt3;
                    int i6 = -1;
                    if (xtVar == null) {
                        a.this.j((Function<SparseArray<Object>, Object>) function, -1, "response is null");
                        return;
                    }
                    String str = xtVar.cw().get("content-type");
                    String str2 = xtVar.cw().get("x-pglcypher");
                    String str3 = "";
                    if (TextUtils.equals(str, "application/octet-stream") || TextUtils.equals(str2, "4")) {
                        xt3 = com.bytedance.sdk.openadsdk.core.rn.vl.xt(com.bytedance.sdk.component.panglearmor.g.j().xt(xtVar.oq()));
                        if (TextUtils.isEmpty(xt3)) {
                            str3 = "data is null";
                        } else {
                            PluginValueSet xt4 = com.bytedance.sdk.openadsdk.i.cw.xt(function);
                            if (!TextUtils.isEmpty(xt3) && function != null && xt4 != null && TextUtils.equals((CharSequence) xt4.objectValue(0, String.class), "GetAdConfigImpl")) {
                                oq.i().j(new oq.r(map, xt3));
                            }
                            i6 = 0;
                        }
                    } else {
                        try {
                            JSONObject jSONObject2 = new JSONObject(xtVar.r());
                            i6 = jSONObject2.optInt("code");
                            String optString = jSONObject2.optString(CrashHianalyticsData.MESSAGE);
                            try {
                                str3 = jSONObject2.optString("data");
                                PluginValueSet xt5 = com.bytedance.sdk.openadsdk.i.cw.xt(function);
                                if (!TextUtils.isEmpty(str3) && function != null && xt5 != null && TextUtils.equals((CharSequence) xt5.objectValue(0, String.class), "GetAdConfigImpl")) {
                                    oq.i().j(new oq.r(map, str3));
                                }
                            } catch (JSONException unused) {
                            }
                            String str4 = str3;
                            str3 = optString;
                            xt3 = str4;
                        } catch (JSONException unused2) {
                            xt3 = "";
                        }
                    }
                    if (i6 == 0) {
                        a.this.j((Function<SparseArray<Object>, Object>) function, xt3);
                    } else {
                        a.this.j((Function<SparseArray<Object>, Object>) function, i6, str3);
                    }
                }

                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                    a.this.j((Function<SparseArray<Object>, Object>) function, -2, "response onFailure");
                }
            });
        } catch (JSONException e6) {
            throw new RuntimeException(e6);
        }
    }
}
