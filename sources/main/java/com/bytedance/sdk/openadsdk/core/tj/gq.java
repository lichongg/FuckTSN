package com.bytedance.sdk.openadsdk.core.tj;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.sdk.component.xt.j.g;
import com.bytedance.sdk.openadsdk.core.rn.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes4.dex */
public class gq {
    private static final Set<String> ae;

    /* renamed from: g, reason: collision with root package name */
    private static final Set<String> f30274g;

    /* renamed from: j, reason: collision with root package name */
    public static final Set<String> f30275j;

    /* renamed from: m, reason: collision with root package name */
    private static final Set<String> f30276m;
    private static boolean oq;
    private static final Map<String, String> qv;
    private static final Set<String> tl;
    private static final Set<String> up;
    private static volatile boolean vl;
    private int xt;
    private static final Set<String> cw = new HashSet();

    /* renamed from: r, reason: collision with root package name */
    private static final Set<String> f30277r = new CopyOnWriteArraySet();

    public static void xt(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("turn_up_white_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                f30277r.clear();
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    String optString = optJSONArray.optString(i6);
                    if (!TextUtils.isEmpty(optString)) {
                        f30277r.add(optString);
                    }
                }
            }
        } catch (Exception unused) {
        }
        try {
            JSONArray optJSONArray2 = jSONObject.optJSONArray("turn_up_black_list_1");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                up.clear();
                for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                    String optString2 = optJSONArray2.optString(i7);
                    if (!TextUtils.isEmpty(optString2)) {
                        up.add(optString2);
                    }
                }
            }
        } catch (Exception unused2) {
        }
        try {
            JSONArray optJSONArray3 = jSONObject.optJSONArray("turn_up_black_list_2");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                f30276m.clear();
                for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                    String optString3 = optJSONArray3.optString(i8);
                    if (!TextUtils.isEmpty(optString3)) {
                        f30276m.add(optString3);
                    }
                }
            }
        } catch (Exception unused3) {
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject != null) {
            try {
                JSONArray optJSONArray4 = optJSONObject.optJSONArray("url_report_rule_list");
                if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                    ae.clear();
                    for (int i9 = 0; i9 < optJSONArray4.length(); i9++) {
                        String optString4 = optJSONArray4.optString(i9);
                        if (!TextUtils.isEmpty(optString4)) {
                            ae.add(optString4);
                        }
                    }
                }
                JSONArray optJSONArray5 = optJSONObject.optJSONArray("net_url_block_list");
                if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                    tl.clear();
                    for (int i10 = 0; i10 < optJSONArray5.length(); i10++) {
                        String optString5 = optJSONArray5.optString(i10);
                        if (!TextUtils.isEmpty(optString5)) {
                            tl.add(optString5);
                        }
                    }
                }
                JSONArray optJSONArray6 = optJSONObject.optJSONArray("dialog_black_list");
                if (optJSONArray6 != null && optJSONArray6.length() > 0) {
                    f30274g.clear();
                    for (int i11 = 0; i11 < optJSONArray6.length(); i11++) {
                        String optString6 = optJSONArray6.optString(i11);
                        if (!TextUtils.isEmpty(optString6)) {
                            f30274g.add(optString6);
                        }
                    }
                }
            } catch (Exception unused4) {
            }
        }
        oq = true;
    }

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        up = copyOnWriteArraySet;
        f30276m = new CopyOnWriteArraySet();
        ae = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        tl = copyOnWriteArraySet2;
        f30274g = new CopyOnWriteArraySet();
        oq = false;
        qv = new HashMap();
        f30275j = new CopyOnWriteArraySet();
        vl = false;
        copyOnWriteArraySet2.addAll(Arrays.asList(".*thefatherofsalmon\\.com.*@3", ".*qallzmx\\.quicklyopen\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*@3"));
        copyOnWriteArraySet.addAll(Arrays.asList("^hap://app", "^hwfastapp://", ".*thefatherofsalmon\\.com.*", ".*qallzmx\\.quicklyopen\\.com.*", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*"));
    }

    public gq(JSONObject jSONObject) {
        this.xt = jSONObject.optInt("block_auto_open");
    }

    public void j(JSONObject jSONObject) {
        try {
            jSONObject.put("block_auto_open", this.xt);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public static void j(com.bytedance.sdk.component.r.j.xt xtVar) {
        xtVar.j("turn_up_white_list", f30277r);
        xtVar.j("turn_up_black_list_1", up);
        xtVar.j("turn_up_black_list_2", f30276m);
        xtVar.j("url_report_rule_list", ae);
        xtVar.j("net_url_block_list", tl);
        xtVar.j("_turn_up_is_get_list", oq);
        xtVar.j("dialog_black_list", f30274g);
    }

    public static int j(n nVar) {
        gq jm;
        if (nVar == null || (jm = nVar.jm()) == null) {
            return 0;
        }
        return jm.xt;
    }

    public static boolean j(WebView webView, AtomicInteger atomicInteger, com.bytedance.sdk.openadsdk.core.rn rnVar, String str, boolean z5, boolean z6) {
        if (!str.startsWith("bytedance") && !str.startsWith("nativeapp") && !str.startsWith("bds")) {
            if (!com.bytedance.sdk.openadsdk.core.rn.uf.j(str, atomicInteger) && j(webView, atomicInteger, str, true)) {
                return true;
            }
            if (rnVar == null || !TextUtils.isEmpty(xt(str, cw)) || !TextUtils.isEmpty(xt(str, f30277r))) {
                return false;
            }
            String xt = xt(str, ae);
            if (!TextUtils.isEmpty(xt)) {
                xt(rnVar.tl(), str, xt);
            }
            String j6 = j(str, rnVar.up(z6), z5, z6);
            if (!TextUtils.isEmpty(j6) && oq) {
                j(rnVar.tl(), str, j6);
            }
            if (!TextUtils.isEmpty(j6)) {
                return true;
            }
        }
        return false;
    }

    private static boolean j(WebView webView, AtomicInteger atomicInteger, String str, boolean z5) {
        if (TextUtils.isEmpty(str) || webView == null) {
            return false;
        }
        final String[] strArr = {""};
        try {
            final String path = Uri.parse(str).getPath();
            Map<String, String> map = qv;
            if (map.containsKey(path)) {
                return j(atomicInteger, map.get(path), str, webView, z5);
            }
            if (!vl) {
                for (String str2 : com.bytedance.sdk.openadsdk.core.rn.h.j("cloud_path_check_res").xt("cloud_path_check_res", new HashSet())) {
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split = str2.split(",");
                        qv.put(split[0], split[1]);
                    }
                }
                Map<String, String> map2 = qv;
                if (map2.containsKey(path)) {
                    return j(atomicInteger, map2.get(path), str, webView, z5);
                }
            }
            com.bytedance.sdk.component.g.xt.up xt = com.bytedance.sdk.openadsdk.core.v.up.j().xt().xt();
            xt.j(Uri.parse("https://scc.bytedance.com/scc_sdk/url_scan_v4").buildUpon().appendQueryParameter(CommonNetImpl.AID, "1181").appendQueryParameter("device_platform", FaceEnvironment.OS).appendQueryParameter("device_id", com.bytedance.sdk.openadsdk.core.kt.cw()).appendQueryParameter("scc_mode", ResIdentify.RES_TYPE_RAW).appendQueryParameter("scc_from", "App").toString());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put("scene", "common");
            jSONObject.put("url", str);
            jSONObject.put(JThirdPlatFormInterface.KEY_EXTRA, "");
            xt.j(jSONObject);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            xt.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.tj.gq.1
                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                    try {
                        strArr[0] = new JSONObject(xtVar.r()).optJSONObject("data").optString("label");
                    } catch (Throwable unused) {
                    }
                    if (TextUtils.isEmpty(strArr[0])) {
                        return;
                    }
                    if (gq.qv.size() > 1000) {
                        Iterator it = gq.qv.entrySet().iterator();
                        for (int i6 = 0; i6 < 200; i6++) {
                            it.next();
                            it.remove();
                        }
                    }
                    gq.qv.put(path, strArr[0]);
                    if (!gq.vl) {
                        boolean unused2 = gq.vl = true;
                        com.bytedance.sdk.component.utils.tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tj.gq.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.rn.h.j("cloud_path_check_res");
                                j6.j();
                                HashSet hashSet = new HashSet();
                                for (Map.Entry entry : gq.qv.entrySet()) {
                                    hashSet.add(((String) entry.getKey()) + "," + ((String) entry.getValue()));
                                }
                                j6.j("cloud_path_check_res", hashSet);
                                boolean unused3 = gq.vl = false;
                            }
                        }, 1800000L);
                    }
                    countDownLatch.countDown();
                }

                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            return j(atomicInteger, strArr[0], str, webView, z5);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void xt(com.bytedance.sdk.component.r.j.xt xtVar) {
        Set<String> set = f30277r;
        set.addAll(xtVar.xt("turn_up_white_list", set));
        Set<String> set2 = up;
        set2.addAll(xtVar.xt("turn_up_black_list_1", set2));
        Set<String> set3 = f30276m;
        set3.addAll(xtVar.xt("turn_up_black_list_2", set3));
        Set<String> set4 = ae;
        set4.addAll(xtVar.xt("url_report_rule_list", set4));
        Set<String> set5 = tl;
        set5.addAll(xtVar.xt("net_url_block_list", set5));
        oq = xtVar.xt("_turn_up_is_get_list", false);
        Set<String> set6 = f30274g;
        set6.addAll(xtVar.xt("dialog_black_list", set6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String xt(String str, Set<String> set) {
        if (str == null) {
            return null;
        }
        try {
            for (String str2 : set) {
                if (!TextUtils.isEmpty(str2) && Pattern.compile(str2).matcher(str).find()) {
                    return str2;
                }
            }
            return null;
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.r("JumpModel", e6.getMessage());
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static boolean j(AtomicInteger atomicInteger, String str, String str2, WebView webView, boolean z5) {
        String str3;
        if (webView == null || TextUtils.isEmpty(str) || atomicInteger == null) {
            return false;
        }
        if (atomicInteger.get() == 1) {
            return true;
        }
        switch (str.hashCode()) {
            case -284840886:
                str3 = "unknown";
                str.equals(str3);
                break;
            case 3181155:
                str3 = "gray";
                str.equals(str3);
                break;
            case 93818879:
                if (str.equals("black")) {
                    atomicInteger.set(1);
                    com.bytedance.sdk.openadsdk.core.rn.m.j(webView.getContext(), (String) null, true, (m.j) null);
                    break;
                }
                break;
            case 113101865:
                str3 = "white";
                str.equals(str3);
                break;
        }
        return false;
    }

    public static void xt(final n nVar, final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.tj.gq.4
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("url", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(CommonNetImpl.AID, nVar.so());
                jSONObject2.put("cid", nVar.fs());
                jSONObject2.put("req_id", nVar.ej());
                jSONObject2.put("customer_id", com.bytedance.sdk.openadsdk.core.rn.uf.qv(nVar));
                jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject2.toString());
                jSONObject.putOpt("pattern", str2);
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("stats_url_report_rule").tl(nVar.os()).xt(jSONObject.toString());
            }
        }, "stats_url_report_rule");
    }

    public static com.bytedance.sdk.component.xt.j.g xt() {
        return new com.bytedance.sdk.component.xt.j.g() { // from class: com.bytedance.sdk.openadsdk.core.tj.gq.5
            @Override // com.bytedance.sdk.component.xt.j.g
            public com.bytedance.sdk.component.xt.j.av j(g.j jVar) throws IOException {
                String str;
                com.bytedance.sdk.component.xt.j.av j6 = jVar.j(jVar.j());
                String str2 = "";
                final String j7 = j6.j("csj-location-record", "");
                final String j8 = j6.j("csj-source-from", "");
                final String j9 = j6.j("csj-extra-info", "");
                if (j6.cw() == 8848) {
                    final String up2 = j6.up();
                    com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.tj.gq.5.1
                        @Override // com.bytedance.sdk.openadsdk.vl.j.j
                        public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.putOpt("url", up2);
                            jSONObject.putOpt("sourceFrom", j8);
                            jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, j9);
                            return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("stats_net_block_url").xt(jSONObject.toString());
                        }
                    }, "stats_net_block_url");
                }
                int i6 = 0;
                try {
                    String[] j10 = gq.j(j7);
                    if (j10 == null || j10.length <= 1) {
                        str = "";
                    } else {
                        String str3 = j10[0];
                        try {
                            str = j10[j10.length - 1];
                            str2 = str3;
                        } catch (Exception unused) {
                            str = "";
                            str2 = str3;
                        }
                    }
                    try {
                        i6 = Integer.parseInt(j8);
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    str = "";
                }
                final String str4 = str2;
                final String str5 = str;
                if (!TextUtils.isEmpty(j7) && i6 != 0 && TextUtils.isEmpty(gq.xt(str4, gq.f30277r))) {
                    com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.tj.gq.5.2
                        @Override // com.bytedance.sdk.openadsdk.vl.j.j
                        public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.putOpt("url", j7);
                            jSONObject.putOpt("sourceFrom", j8);
                            jSONObject.putOpt("sourceUrl", str4);
                            jSONObject.putOpt("destUrl", str5);
                            jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, j9);
                            return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("stats_net_locations_url").xt(jSONObject.toString());
                        }
                    }, "stats_net_locations_url");
                }
                return j6;
            }
        };
    }

    public static boolean j(WebView webView, AtomicInteger atomicInteger, com.bytedance.sdk.openadsdk.core.rn rnVar, WebResourceRequest webResourceRequest, boolean z5, boolean z6) {
        Uri url;
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) {
            return false;
        }
        return j(webView, atomicInteger, rnVar, url.toString(), z5, z6);
    }

    public static boolean j(final com.bytedance.sdk.openadsdk.core.rn rnVar, final int i6, final String str) {
        final String xt = xt(str, f30274g);
        final boolean z5 = (oq && TextUtils.isEmpty(xt)) ? false : true;
        com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.tj.gq.2
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("url", str);
                    jSONObject.putOpt("type", Integer.valueOf(i6));
                    jSONObject.putOpt("is_block", Boolean.valueOf(z5));
                    jSONObject.putOpt("is_get_setting", Boolean.valueOf(gq.oq));
                    jSONObject.putOpt("pattern", xt);
                    jSONObject.putOpt("customer_id", com.bytedance.sdk.openadsdk.core.rn.uf.qv(rnVar.tl()));
                    return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("stats_dialog_report_rule").tl(rnVar.tl().os()).xt(jSONObject.toString());
                } catch (Throwable unused) {
                    return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt();
                }
            }
        }, "stats_dialog_report_rule");
        return z5;
    }

    private static String j(String str, int i6, boolean z5, boolean z6) {
        boolean z7 = (!z6 || str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE)) ? false : true;
        if (i6 == 1) {
            if (oq) {
                return xt(str, f30276m);
            }
            return null;
        }
        if (i6 == 2) {
            if (!oq) {
                if (z5) {
                    return "local://no-setting";
                }
                return null;
            }
            if (z7) {
                return "local://short-internal";
            }
            String xt = xt(str, up);
            if (!TextUtils.isEmpty(xt)) {
                return xt;
            }
            String xt2 = xt(str, f30276m);
            if (TextUtils.isEmpty(xt2)) {
                return null;
            }
            return xt2;
        }
        if (i6 != 3) {
            return null;
        }
        if (z5 || !oq) {
            return "local://preload-setting:" + oq;
        }
        if (z7) {
            return "local://short-internal";
        }
        String xt3 = xt(str, up);
        if (!TextUtils.isEmpty(xt3)) {
            return xt3;
        }
        String xt4 = xt(str, f30276m);
        if (TextUtils.isEmpty(xt4)) {
            return null;
        }
        return xt4;
    }

    public static void j(final n nVar, final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.tj.gq.3
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("url", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(CommonNetImpl.AID, nVar.so());
                jSONObject2.put("cid", nVar.fs());
                jSONObject2.put("req_id", nVar.ej());
                jSONObject2.put("customer_id", com.bytedance.sdk.openadsdk.core.rn.uf.qv(nVar));
                jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject2.toString());
                jSONObject.putOpt("pattern", str2);
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("stats_block_report").tl(nVar.os()).xt(jSONObject.toString());
            }
        }, "stats_block_report");
    }

    public static Set<String> j() {
        return tl;
    }

    public static String[] j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.substring(1, str.length() - 1).split(",");
    }
}
