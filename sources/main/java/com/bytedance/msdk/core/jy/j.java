package com.bytedance.msdk.core.jy;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.msdk.core.oq.ae;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.core.oq.tl;
import com.bytedance.msdk.core.xt;
import com.bytedance.msdk.cw.tl.cw;
import com.bytedance.msdk.j.j.r;
import com.bytedance.msdk.tl.jy;
import com.bytedance.msdk.tl.l;
import com.bytedance.msdk.tl.m;
import com.bytedance.msdk.tl.rn;
import com.bytedance.msdk.tl.v;
import com.bytedance.msdk.tl.x;
import com.bytedance.sdk.component.g.xt.up;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f24617j;

    /* renamed from: com.bytedance.msdk.core.jy.j$j, reason: collision with other inner class name */
    public interface InterfaceC0359j {
        void j(com.bytedance.msdk.api.j jVar);

        void j(ae aeVar);
    }

    private void cw(JSONObject jSONObject) {
        if (m.j(xt.getContext()) != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", r0.f25239j);
                jSONObject2.put("longitude", r0.xt);
                jSONObject.put("geo", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    public static int j(int i6) {
        if (i6 == 1) {
            return 2;
        }
        if (i6 != 2) {
            return (i6 == 3 || i6 == 4 || i6 == 7 || i6 == 8) ? 5 : 3;
        }
        return 4;
    }

    private JSONObject xt() {
        if (TextUtils.isEmpty(xt.xt().jy())) {
            return null;
        }
        try {
            return new JSONObject(xt.xt().jy());
        } catch (Exception e6) {
            vl.j(e6);
            return null;
        }
    }

    private String j(Map<String, com.bytedance.msdk.cw.j.j> map, Context context, com.bytedance.msdk.api.j.xt xtVar, oq oqVar, Map<String, Object> map2) {
        if (xtVar != null && oqVar != null) {
            if (TextUtils.equals("baidu", oqVar.az())) {
                com.bytedance.msdk.cw.m.xt.xt j6 = com.bytedance.msdk.cw.m.xt.xt.j(oqVar, (com.bytedance.msdk.cw.xt.xt.j) null);
                com.bytedance.msdk.cw.j.j j7 = cw.j(j6, xtVar, (com.bytedance.msdk.cw.j.xt) null);
                if (j7 == null) {
                    return "";
                }
                try {
                    map.put(String.format("%1$s_%2$s_%3$s", xtVar.j(), xtVar.v(), oqVar.w()), j7);
                    return j7.j(context, j6, xtVar);
                } catch (Throwable unused) {
                    return "";
                }
            }
            return com.bytedance.msdk.m.xt.j.j(map2, oqVar.az());
        }
        com.bytedance.msdk.j.up.cw.xt("serverBiddingRequest", "adSlot is null or waterFallConfig is null can not get server bidding token");
        return "";
    }

    private JSONObject xt(com.bytedance.msdk.api.j.xt xtVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            int f6 = xtVar.f();
            jSONObject.put("id", xtVar.v());
            jSONObject.put("adtype", f6);
            jSONObject.put("pos", j(f6));
            j(jSONObject, "accepted_size", xtVar.ch(), xtVar.s());
            jSONObject.put("is_support_dpl", xtVar.l());
            int a6 = xtVar.a();
            int i6 = 1;
            if (a6 <= 0) {
                a6 = 1;
            }
            if (a6 > 3) {
                a6 = 3;
            }
            if (f6 != 7 && f6 != 8) {
                i6 = a6;
            }
            jSONObject.put("ad_count", i6);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject cw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", com.bytedance.msdk.core.j.qv().vl());
            jSONObject.put(CommonNetImpl.NAME, com.bytedance.msdk.core.j.qv().tj());
            xt(jSONObject);
            cw(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static j j() {
        if (f24617j == null) {
            synchronized (j.class) {
                try {
                    if (f24617j == null) {
                        f24617j = new j();
                    }
                } finally {
                }
            }
        }
        return f24617j;
    }

    private void xt(JSONObject jSONObject) {
        try {
            jSONObject.put(bi.f40972o, rn.j());
            jSONObject.put("version_code", rn.xt());
            jSONObject.put("version", rn.cw());
        } catch (Exception unused) {
        }
    }

    private String xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            com.bytedance.msdk.api.r.j.xt.m.j j6 = com.bytedance.msdk.m.xt.j.j(str);
            if (j6 != null) {
                return j6.j();
            }
            r j7 = com.bytedance.msdk.m.xt.xt.j().j(str);
            if (j7 == null) {
                return null;
            }
            return j7.xt();
        } catch (Throwable th) {
            vl.j(th);
            com.bytedance.msdk.j.up.cw.r("TTMediationSDK_SDK_Init", "GDT SDK 初始化失败。。 e=" + th.toString());
            return null;
        }
    }

    public void j(Map<String, com.bytedance.msdk.cw.j.j> map, Context context, com.bytedance.msdk.api.j.xt xtVar, List<oq> list, List<com.bytedance.msdk.xt.cw> list2, com.bytedance.msdk.core.oq.xt xtVar2, int i6, boolean z5, final InterfaceC0359j interfaceC0359j) {
        final JSONObject jSONObject = new JSONObject();
        final long currentTimeMillis = System.currentTimeMillis();
        up xt = com.bytedance.msdk.r.xt.j().xt().xt();
        xt.j(com.bytedance.msdk.core.cw.cw());
        String tl = com.bytedance.msdk.core.j.qv().tl();
        if (!TextUtils.isEmpty(tl)) {
            xt.xt("X-Tt-Env", tl);
            xt.xt("x-use-ppe", "1");
        }
        xt.xt("User-Agent", com.bytedance.msdk.xt.xt.f25363j);
        boolean up = xt.xt().up();
        final boolean z6 = !up;
        if (!up) {
            xt.xt("x-pglcypher", "4");
            xt.j("application/octet-stream", rn.xt(j(map, context, xtVar, list, list2, xtVar2, i6, z5, jSONObject, true)));
        } else {
            xt.cw(j(map, context, xtVar, list, list2, xtVar2, i6, z5, jSONObject, false));
        }
        xt.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.msdk.core.jy.j.1
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar3) {
                JSONObject jSONObject2;
                JSONObject jSONObject3;
                if (xtVar3 == null) {
                    com.bytedance.msdk.j.up.cw.r("ServerBiddingHelper", "Server Bidding Request onResponse...response is null");
                    j.this.j(-1, "response is null", interfaceC0359j, z6);
                    return;
                }
                int j6 = xtVar3.j();
                if (rn.j(xtVar3)) {
                    String j7 = rn.j(xtVar3.oq());
                    if (TextUtils.isEmpty(j7)) {
                        com.bytedance.msdk.j.up.cw.r("ServerBiddingHelper", "Server Bidding Request onResponse...response v4 is empty");
                        j.this.j(j6, "response is empty", interfaceC0359j, z6);
                        return;
                    }
                    try {
                        j.this.j(new JSONObject(j7), jSONObject, interfaceC0359j, z6, currentTimeMillis);
                        return;
                    } catch (Throwable th) {
                        j.this.j(81014, th.getMessage(), interfaceC0359j, z6);
                        return;
                    }
                }
                if (TextUtils.isEmpty(xtVar3.r())) {
                    com.bytedance.msdk.j.up.cw.r("ServerBiddingHelper", "Server Bidding Request onResponse...response is empty");
                    j.this.j(j6, "response is empty", interfaceC0359j, z6);
                    return;
                }
                try {
                    JSONObject jSONObject4 = new JSONObject(xtVar3.r());
                    int optInt = jSONObject4.optInt("cypher", -1);
                    String optString = jSONObject4.optString(CrashHianalyticsData.MESSAGE);
                    if (optInt < 0 || TextUtils.isEmpty(optString)) {
                        int optInt2 = jSONObject4.optInt("status_code", -2);
                        int optInt3 = jSONObject4.optInt(MediationConstant.KEY_REASON, -2);
                        String optString2 = jSONObject4.optString("desc");
                        com.bytedance.msdk.j.up.cw.r("ServerBiddingHelper", "Server Bidding onResponse error ");
                        j.this.j(optInt2, "reason is " + optInt3 + "，desc is " + optString2, interfaceC0359j, z6);
                        return;
                    }
                    if (optInt == 2) {
                        String j8 = rn.j(optString);
                        if (!TextUtils.isEmpty(j8)) {
                            try {
                                jSONObject3 = new JSONObject(j8);
                            } catch (Throwable th2) {
                                com.bytedance.msdk.j.up.cw.j("ServerBiddingHelper", ">>>>> server bidding data error: " + th2.toString());
                            }
                            jSONObject2 = jSONObject3;
                        }
                        jSONObject3 = null;
                        jSONObject2 = jSONObject3;
                    } else {
                        if (optInt == 1) {
                            String xt2 = com.bytedance.msdk.tl.j.xt(optString, com.bytedance.msdk.tl.xt.j());
                            if (!TextUtils.isEmpty(xt2)) {
                                try {
                                    jSONObject3 = new JSONObject(xt2);
                                } catch (Throwable th3) {
                                    com.bytedance.msdk.j.up.cw.j("ServerBiddingHelper", "server bidding data error: ", th3);
                                }
                                jSONObject2 = jSONObject3;
                            }
                        } else if (optInt == 0) {
                            jSONObject2 = new JSONObject(optString);
                        }
                        jSONObject3 = null;
                        jSONObject2 = jSONObject3;
                    }
                    j.this.j(jSONObject2, jSONObject, interfaceC0359j, z6, currentTimeMillis);
                } catch (Throwable th4) {
                    j.this.j(81006, th4.getMessage(), interfaceC0359j, z6);
                }
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                int i7 = iOException instanceof SocketTimeoutException ? 44405 : 44404;
                com.bytedance.msdk.j.up.cw.r("ServerBiddingHelper", "Server Bidding Request onError...errorCode=".concat(String.valueOf(i7)));
                j.this.j(i7, "request fail " + iOException.getMessage(), interfaceC0359j, z6);
            }
        });
    }

    private void j(boolean z5, long j6) {
        l.j(z5 ? "v4Enc_exchange" : "v2Enc_exchange", true, j6, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, String str, InterfaceC0359j interfaceC0359j, boolean z5) {
        l.j(z5 ? "v4Enc_exchange" : "v2Enc_exchange", false, 0L, "code = " + i6 + "，msg = " + str);
        j(interfaceC0359j, new com.bytedance.msdk.api.j(i6, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(JSONObject jSONObject, JSONObject jSONObject2, InterfaceC0359j interfaceC0359j, boolean z5, long j6) {
        String str;
        String str2;
        JSONArray jSONArray;
        String str3;
        String str4;
        long currentTimeMillis = System.currentTimeMillis() - j6;
        if (jSONObject == null) {
            com.bytedance.msdk.j.up.cw.r("ServerBiddingHelper", "Server Bidding Request onResponse...data is null");
            j(-1, "data is null", interfaceC0359j, z5);
            return;
        }
        if (TextUtils.isEmpty(jSONObject.toString())) {
            com.bytedance.msdk.j.up.cw.r("ServerBiddingHelper", "Server Bidding Request onResponse..data.string is null ");
            j(-1, "data.string is null", interfaceC0359j, z5);
            return;
        }
        ae aeVar = new ae();
        aeVar.j(jSONObject2);
        aeVar.cw(jSONObject.optString("request_id"));
        aeVar.up(jSONObject.optString("server_bidding_extra"));
        aeVar.r(jSONObject.optString("server_request_id"));
        tl tlVar = new tl();
        JSONObject optJSONObject = jSONObject.optJSONObject("winner");
        String str5 = "price";
        if (optJSONObject == null) {
            str = "ServerBiddingHelper";
        } else {
            tlVar.xt(optJSONObject.optInt("req_bidding_type"));
            tlVar.cw(optJSONObject.optString("price"));
            tlVar.r(optJSONObject.optString("load_price"));
            tlVar.oq(optJSONObject.optString("adm"));
            tlVar.up(optJSONObject.optString(CommonNetImpl.NAME));
            tlVar.ae(optJSONObject.optString("app_id"));
            tlVar.m(optJSONObject.optString("slot_id"));
            str = "ServerBiddingHelper";
            tlVar.tl(optJSONObject.optString("win_callback", null));
            tlVar.g(optJSONObject.optString("fail_callback", null));
            tlVar.j(optJSONObject.optInt("pricing_type", 1));
            aeVar.j(tlVar);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("winners");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            str2 = str;
        } else {
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            while (i6 < optJSONArray.length()) {
                try {
                    tl tlVar2 = new tl();
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
                    jSONArray = optJSONArray;
                    try {
                        tlVar2.xt(optJSONObject2.optInt("req_bidding_type"));
                        tlVar2.cw(optJSONObject2.optString(str5));
                        tlVar2.r(optJSONObject2.optString("load_price"));
                        tlVar2.oq(optJSONObject2.optString("adm"));
                        tlVar2.up(optJSONObject2.optString(CommonNetImpl.NAME));
                        tlVar2.ae(optJSONObject2.optString("app_id"));
                        tlVar2.m(optJSONObject2.optString("slot_id"));
                        str3 = str5;
                    } catch (Throwable th) {
                        th = th;
                        str3 = str5;
                        str4 = str;
                        com.bytedance.msdk.j.up.cw.j(str4, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                        i6++;
                        str = str4;
                        str5 = str3;
                        optJSONArray = jSONArray;
                    }
                    try {
                        tlVar2.tl(optJSONObject2.optString("win_callback", null));
                        tlVar2.g(optJSONObject2.optString("fail_callback", null));
                        tlVar2.j(optJSONObject2.optString("m_aid", null));
                        tlVar2.xt(optJSONObject2.optString("ad_extra", null));
                    } catch (Throwable th2) {
                        th = th2;
                        str4 = str;
                        com.bytedance.msdk.j.up.cw.j(str4, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                        i6++;
                        str = str4;
                        str5 = str3;
                        optJSONArray = jSONArray;
                    }
                    try {
                        tlVar2.j(optJSONObject2.optInt("pricing_type", 1));
                        arrayList.add(tlVar2);
                        str4 = str;
                    } catch (Throwable th3) {
                        th = th3;
                        str4 = str;
                        com.bytedance.msdk.j.up.cw.j(str4, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                        i6++;
                        str = str4;
                        str5 = str3;
                        optJSONArray = jSONArray;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    jSONArray = optJSONArray;
                }
                i6++;
                str = str4;
                str5 = str3;
                optJSONArray = jSONArray;
            }
            str2 = str;
            aeVar.j(arrayList);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("auto_detail");
        if (optJSONObject3 != null) {
            aeVar.j(optJSONObject3.optString("est_price"));
            aeVar.j(optJSONObject3.optInt("est_price_source"));
            aeVar.xt(optJSONObject3.optString("bidding_ecpm"));
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("waterfall");
        if (optJSONObject4 != null) {
            ae.j jVar = new ae.j();
            jVar.j(optJSONObject4.optString("version"));
            JSONArray optJSONArray2 = optJSONObject4.optJSONArray("adn_rit_conf");
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                    try {
                        JSONObject optJSONObject5 = optJSONArray2.optJSONObject(i7);
                        oq oqVar = new oq();
                        oqVar.cw(optJSONObject5.optString(MediationConstant.EXTRA_ADN_NAME));
                        oqVar.up(optJSONObject5.optString("adn_slot_id"));
                        arrayList2.add(oqVar);
                    } catch (Throwable th5) {
                        com.bytedance.msdk.j.up.cw.j(str2, "new waterfallListJson parse error: " + th5.toString());
                    }
                }
            }
            jVar.j(arrayList2);
            aeVar.j(jVar);
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("invalid_non_server_bidding_results");
        ArrayList arrayList3 = new ArrayList();
        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
            for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                try {
                    JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i8);
                    com.bytedance.msdk.core.oq.m mVar = new com.bytedance.msdk.core.oq.m();
                    mVar.j(optJSONObject6.optString(CommonNetImpl.NAME));
                    mVar.xt(optJSONObject6.optString("slot_id"));
                    mVar.j(optJSONObject6.optInt("req_bidding_type"));
                    mVar.xt(optJSONObject6.optInt("error_code"));
                    mVar.cw(optJSONObject6.optString("error_msg"));
                    mVar.r(optJSONObject6.optString("level_tag"));
                    arrayList3.add(mVar);
                } catch (Throwable th6) {
                    com.bytedance.msdk.j.up.cw.j(str2, "new invalid_non_server_bidding_results parse error: " + th6.toString());
                }
            }
            aeVar.xt(arrayList3);
        }
        j(interfaceC0359j, aeVar);
        j(z5, currentTimeMillis);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007e A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:6:0x000e, B:8:0x0022, B:12:0x002b, B:16:0x007e, B:18:0x0088, B:21:0x00a4, B:23:0x00aa, B:29:0x003c, B:32:0x0057, B:38:0x006c, B:40:0x0074, B:41:0x00b0, B:35:0x0065, B:26:0x0035), top: B:5:0x000e, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00aa A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:6:0x000e, B:8:0x0022, B:12:0x002b, B:16:0x007e, B:18:0x0088, B:21:0x00a4, B:23:0x00aa, B:29:0x003c, B:32:0x0057, B:38:0x006c, B:40:0x0074, B:41:0x00b0, B:35:0x0065, B:26:0x0035), top: B:5:0x000e, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(com.bytedance.msdk.core.oq.ae r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "ServerBiddingHelper"
            if (r4 != 0) goto L6
            goto Laf
        L6:
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto Le
            goto Laf
        Le:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L52
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L52
            java.lang.String r5 = "cypher"
            r2 = -1
            int r5 = r1.optInt(r5, r2)     // Catch: java.lang.Throwable -> L52
            java.lang.String r2 = "message"
            java.lang.String r1 = r1.optString(r2)     // Catch: java.lang.Throwable -> L52
            if (r5 < 0) goto Lb0
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L52
            if (r2 != 0) goto Lb0
            r2 = 2
            if (r5 != r2) goto L54
            java.lang.String r5 = com.bytedance.msdk.tl.rn.j(r1)     // Catch: java.lang.Throwable -> L52
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L52
            if (r1 != 0) goto L7b
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L3b
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L3b
            goto L7c
        L3b:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            java.lang.String r2 = ">>>>> m_meta data error: "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L52
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L52
            r1.append(r5)     // Catch: java.lang.Throwable -> L52
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L52
            com.bytedance.msdk.j.up.cw.j(r0, r5)     // Catch: java.lang.Throwable -> L52
            goto L7b
        L52:
            r4 = move-exception
            goto Lb6
        L54:
            r2 = 1
            if (r5 != r2) goto L72
            java.lang.String r5 = com.bytedance.msdk.tl.xt.j()     // Catch: java.lang.Throwable -> L52
            java.lang.String r5 = com.bytedance.msdk.tl.j.xt(r1, r5)     // Catch: java.lang.Throwable -> L52
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L52
            if (r1 != 0) goto L7b
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6b
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L6b
            goto L7c
        L6b:
            r5 = move-exception
            java.lang.String r1 = "m_meta data error: "
            com.bytedance.msdk.j.up.cw.j(r0, r1, r5)     // Catch: java.lang.Throwable -> L52
            goto L7b
        L72:
            if (r5 != 0) goto L7b
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L52
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L52
            r1 = r5
            goto L7c
        L7b:
            r1 = 0
        L7c:
            if (r1 == 0) goto Laa
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L52
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L52
            if (r5 != 0) goto La4
            java.lang.String r5 = "request_id"
            java.lang.String r5 = r1.optString(r5)     // Catch: java.lang.Throwable -> L52
            r4.cw(r5)     // Catch: java.lang.Throwable -> L52
            java.lang.String r5 = "server_bidding_extra"
            java.lang.String r5 = r1.optString(r5)     // Catch: java.lang.Throwable -> L52
            r4.up(r5)     // Catch: java.lang.Throwable -> L52
            java.lang.String r5 = "server_request_id"
            java.lang.String r5 = r1.optString(r5)     // Catch: java.lang.Throwable -> L52
            r4.r(r5)     // Catch: java.lang.Throwable -> L52
            goto Laf
        La4:
            java.lang.String r4 = "m_meta..data.string is null "
            com.bytedance.msdk.j.up.cw.r(r0, r4)     // Catch: java.lang.Throwable -> L52
            goto Laf
        Laa:
            java.lang.String r4 = "m_meta...data is null"
            com.bytedance.msdk.j.up.cw.r(r0, r4)     // Catch: java.lang.Throwable -> L52
        Laf:
            return
        Lb0:
            java.lang.String r4 = "m_meta onResponse error "
            com.bytedance.msdk.j.up.cw.r(r0, r4)     // Catch: java.lang.Throwable -> L52
            return
        Lb6:
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "m_meta onResponse throwable ："
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r4 = r5.concat(r4)
            com.bytedance.msdk.j.up.cw.r(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.jy.j.j(com.bytedance.msdk.core.oq.ae, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008a A[Catch: all -> 0x005e, TryCatch #2 {all -> 0x005e, blocks: (B:9:0x0019, B:11:0x002d, B:15:0x0037, B:19:0x008a, B:21:0x0094, B:23:0x0109, B:25:0x010f, B:31:0x0048, B:33:0x0063, B:39:0x0078, B:41:0x0080, B:42:0x0115, B:36:0x0071, B:28:0x0041), top: B:8:0x0019, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010f A[Catch: all -> 0x005e, TryCatch #2 {all -> 0x005e, blocks: (B:9:0x0019, B:11:0x002d, B:15:0x0037, B:19:0x008a, B:21:0x0094, B:23:0x0109, B:25:0x010f, B:31:0x0048, B:33:0x0063, B:39:0x0078, B:41:0x0080, B:42:0x0115, B:36:0x0071, B:28:0x0041), top: B:8:0x0019, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.msdk.core.oq.tl j(org.json.JSONObject r7) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.jy.j.j(org.json.JSONObject):com.bytedance.msdk.core.oq.tl");
    }

    public void j(String str, InterfaceC0359j interfaceC0359j) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ae aeVar = new ae();
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("items");
                String optString = jSONObject.optString("m_meta");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                        try {
                            tl j6 = j(optJSONArray.optJSONObject(i6));
                            if (j6 != null) {
                                arrayList.add(j6);
                            }
                        } catch (Throwable th) {
                            com.bytedance.msdk.j.up.cw.j("ServerBiddingHelper", "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                        }
                    }
                    aeVar.j(arrayList);
                }
                j(aeVar, optString);
                j(interfaceC0359j, aeVar);
                return;
            } catch (Throwable th2) {
                String th3 = th2.toString();
                com.bytedance.msdk.j.up.cw.r("ServerBiddingHelper", "Server Bidding onResponse throwable ：".concat(String.valueOf(th3)));
                if (TextUtils.isEmpty(th3)) {
                    th3 = com.bytedance.msdk.api.j.j(-1);
                }
                j(interfaceC0359j, new com.bytedance.msdk.api.j(-1, th3));
                return;
            }
        }
        com.bytedance.msdk.j.up.cw.r("ServerBiddingHelper", "Server Bidding Request onResponse...response is invalid");
        j(interfaceC0359j, new com.bytedance.msdk.api.j(-1, "response is invalid"));
    }

    private void j(final InterfaceC0359j interfaceC0359j, final com.bytedance.msdk.api.j jVar) {
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.core.jy.j.2
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0359j interfaceC0359j2 = interfaceC0359j;
                if (interfaceC0359j2 != null) {
                    interfaceC0359j2.j(jVar);
                }
            }
        });
    }

    private void j(final InterfaceC0359j interfaceC0359j, final ae aeVar) {
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.core.jy.j.3
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0359j interfaceC0359j2 = interfaceC0359j;
                if (interfaceC0359j2 != null) {
                    interfaceC0359j2.j(aeVar);
                }
            }
        });
    }

    private JSONObject j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception e6) {
            vl.j(e6);
            return null;
        }
    }

    public String j(Map<String, com.bytedance.msdk.cw.j.j> map, Context context, com.bytedance.msdk.api.j.xt xtVar, List<oq> list, com.bytedance.msdk.core.oq.xt xtVar2, int i6, boolean z5, JSONObject jSONObject) {
        if (context == null) {
            return "";
        }
        return j(map, context, xtVar, list, null, xtVar2, i6, z5, jSONObject, false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:42|43|(4:44|45|46|(6:47|48|49|50|51|52))|(3:139|140|(28:142|143|144|145|146|147|148|(1:150)|151|60|(3:133|134|(1:136))|62|63|64|65|(2:67|(1:69))(2:126|(1:128))|70|71|(6:97|98|99|100|101|(8:(1:104)(1:118)|105|106|107|108|109|110|111)(1:119))(2:73|(13:(1:88)(1:96)|89|90|91|92|76|77|78|79|(1:81)|36|37|39))|75|76|77|78|79|(0)|36|37|39))|54|55|56|(1:58)|59|60|(0)|62|63|64|65|(0)(0)|70|71|(0)(0)|75|76|77|78|79|(0)|36|37|39) */
    /* JADX WARN: Can't wrap try/catch for region: R(33:0|1|2|3|(2:254|255)|5|(1:7)|8|(1:10)|11|(1:13)|14|(1:16)|26|27|(8:28|29|30|(3:32|33|(4:35|36|37|39)(36:42|43|44|45|46|47|48|49|50|51|52|(3:139|140|(28:142|143|144|145|146|147|148|(1:150)|151|60|(3:133|134|(1:136))|62|63|64|65|(2:67|(1:69))(2:126|(1:128))|70|71|(6:97|98|99|100|101|(8:(1:104)(1:118)|105|106|107|108|109|110|111)(1:119))(2:73|(13:(1:88)(1:96)|89|90|91|92|76|77|78|79|(1:81)|36|37|39))|75|76|77|78|79|(0)|36|37|39))|54|55|56|(1:58)|59|60|(0)|62|63|64|65|(0)(0)|70|71|(0)(0)|75|76|77|78|79|(0)|36|37|39))(1:175)|21|22|23|24)|176|177|178|179|(4:181|182|183|184)(1:246)|185|(1:243)(1:189)|190|(3:223|224|(7:226|(2:196|(1:198))|199|(4:201|(4:204|(7:206|(1:208)(1:217)|(1:210)|211|(1:213)|214|215)(2:218|219)|216|202)|220|221)|22|23|24)(2:227|(4:229|(4:233|234|230|231)|235|236)))|192|(3:194|196|(0))|199|(0)|22|23|24|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x02d5, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02d6, code lost:
    
        r24 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x04bb, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x04bc, code lost:
    
        r1 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0439, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0270 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0561 A[Catch: Exception -> 0x04b8, TryCatch #2 {Exception -> 0x04b8, blocks: (B:184:0x04b0, B:185:0x04c2, B:187:0x04f9, B:189:0x04ff, B:190:0x051c, B:194:0x0561, B:196:0x0564, B:198:0x056e, B:199:0x0573, B:201:0x0583, B:202:0x0587, B:204:0x058d, B:206:0x0595, B:208:0x05a7, B:210:0x05ba, B:211:0x05c1, B:213:0x05f9, B:214:0x0602, B:217:0x05b0, B:221:0x0619, B:240:0x055a), top: B:183:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x056e A[Catch: Exception -> 0x04b8, TryCatch #2 {Exception -> 0x04b8, blocks: (B:184:0x04b0, B:185:0x04c2, B:187:0x04f9, B:189:0x04ff, B:190:0x051c, B:194:0x0561, B:196:0x0564, B:198:0x056e, B:199:0x0573, B:201:0x0583, B:202:0x0587, B:204:0x058d, B:206:0x0595, B:208:0x05a7, B:210:0x05ba, B:211:0x05c1, B:213:0x05f9, B:214:0x0602, B:217:0x05b0, B:221:0x0619, B:240:0x055a), top: B:183:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0583 A[Catch: Exception -> 0x04b8, TryCatch #2 {Exception -> 0x04b8, blocks: (B:184:0x04b0, B:185:0x04c2, B:187:0x04f9, B:189:0x04ff, B:190:0x051c, B:194:0x0561, B:196:0x0564, B:198:0x056e, B:199:0x0573, B:201:0x0583, B:202:0x0587, B:204:0x058d, B:206:0x0595, B:208:0x05a7, B:210:0x05ba, B:211:0x05c1, B:213:0x05f9, B:214:0x0602, B:217:0x05b0, B:221:0x0619, B:240:0x055a), top: B:183:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02c1 A[Catch: all -> 0x02d5, TryCatch #15 {all -> 0x02d5, blocks: (B:65:0x02b8, B:67:0x02c1, B:69:0x02cb, B:70:0x02e5, B:128:0x02de), top: B:64:0x02b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0391 A[Catch: all -> 0x0373, TryCatch #11 {all -> 0x0373, blocks: (B:111:0x0340, B:73:0x0391, B:85:0x03ab, B:89:0x03c4), top: B:110:0x0340 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0303 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String j(java.util.Map<java.lang.String, com.bytedance.msdk.cw.j.j> r36, android.content.Context r37, com.bytedance.msdk.api.j.xt r38, java.util.List<com.bytedance.msdk.core.oq.oq> r39, java.util.List<com.bytedance.msdk.xt.cw> r40, com.bytedance.msdk.core.oq.xt r41, int r42, boolean r43, org.json.JSONObject r44, boolean r45) {
        /*
            Method dump skipped, instructions count: 1608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.jy.j.j(java.util.Map, android.content.Context, com.bytedance.msdk.api.j.xt, java.util.List, java.util.List, com.bytedance.msdk.core.oq.xt, int, boolean, org.json.JSONObject, boolean):java.lang.String");
    }

    private String j(com.bytedance.msdk.api.j.xt xtVar, oq oqVar) {
        String j6 = xtVar != null ? xtVar.j() : null;
        if (oqVar == null) {
            return j6;
        }
        return (j6 + "_") + oqVar.w();
    }

    private String j(JSONObject jSONObject, boolean z5, boolean z6) {
        if (z6) {
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.putOpt("token_type", Integer.valueOf(z5 ? 1 : 0));
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }
        JSONObject j6 = rn.j(jSONObject);
        if (j6 == null) {
            return null;
        }
        try {
            j6.putOpt("token_type", Integer.valueOf(z5 ? 1 : 0));
        } catch (Exception unused2) {
        }
        return j6.toString();
    }

    private JSONObject j(com.bytedance.msdk.api.j.xt xtVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request_id", xtVar.j());
            jSONObject.put("ad_sdk_version", com.bytedance.msdk.xt.xt.xt());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.bytedance.msdk.xt.xt.r());
            jSONObject.put("source_type", Constants.JumpUrlConstants.SRC_TYPE_APP);
            jSONObject.put(Constants.JumpUrlConstants.SRC_TYPE_APP, cw());
            JSONObject j6 = v.j(xt.getContext());
            if (j6 != null && xtVar.rn() > 0) {
                j6.put("orientation", xtVar.rn());
            }
            jSONObject.put(ConstantHelper.LOG_DE, j6);
            jSONObject.put(au.f40899d, com.bytedance.msdk.xt.xt.f25363j);
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, x.f());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(xt(xtVar));
            jSONObject.put("adslots", jSONArray);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            String str = "";
            if (xtVar.v() != null && xtVar.j() != null) {
                str = String.valueOf(currentTimeMillis).concat(xtVar.v()).concat(xtVar.j());
            }
            jSONObject.put("req_sign", jy.j(str));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void j(JSONObject jSONObject, String str, int i6, int i7) {
        if (i6 <= 0 || i7 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i6);
            jSONObject2.put("height", i7);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }
}
