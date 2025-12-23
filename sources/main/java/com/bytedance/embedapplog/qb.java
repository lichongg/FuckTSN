package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import kotlin.text.v0;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class qb {

    /* renamed from: j, reason: collision with root package name */
    private static final String[] f24035j = {"ab_version", bi.F, "language", "os_api", "resolution", "google_aid", "build_serial", bi.P, "install_id", WiseOpenHianalyticsData.UNION_PACKAGE, "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", CommonNetImpl.AID};
    private static final String[] xt = {"ab_version", bi.F, "language", "os_api", "resolution", "google_aid", "build_serial", bi.P, "iid", "app_name", NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, bi.ai, "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", CommonNetImpl.AID};

    public static String j(Context context, JSONObject jSONObject, String str, boolean z5, xt xtVar) {
        HashMap<String, String> j6;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap hashMap = new HashMap(f24035j.length + 10);
        int i6 = 0;
        while (true) {
            String[] strArr = f24035j;
            if (i6 >= strArr.length) {
                break;
            }
            String optString = jSONObject.optString(strArr[i6], null);
            if (!TextUtils.isEmpty(optString)) {
                hashMap.put(xt[i6], optString);
            }
            i6++;
        }
        if (xtVar != null) {
            try {
                j6 = xtVar.j(context);
            } catch (Exception e6) {
                uc.xt(e6);
            }
        } else {
            j6 = null;
        }
        if (ri.xt(context) && j6 != null) {
            hashMap.putAll(j6);
        }
        try {
            HashMap<String, String> j7 = j.cw() == null ? null : j.cw().j();
            if (j7 != null) {
                hashMap.putAll(j7);
            }
        } catch (Exception e7) {
            uc.xt(e7);
        }
        if (j.cw.size() > 0) {
            hashMap.putAll(j.cw);
        }
        if (z5) {
            hashMap.put("ssmix", "a");
        }
        String j8 = ln.j(context);
        if (!TextUtils.isEmpty(j8)) {
            hashMap.put("ac", j8);
        }
        String str2 = (String) j.j("tweaked_channel", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) j.j("channel", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("channel", str2);
        }
        String optString2 = jSONObject.optString("os_version", null);
        if (optString2 != null && optString2.length() > 10) {
            optString2 = optString2.substring(0, 10);
        }
        hashMap.put("os_version", optString2);
        hashMap.put("_rticket", String.valueOf(System.currentTimeMillis()));
        hashMap.put("device_platform", FaceEnvironment.OS);
        int intValue = ((Integer) j.j("version_code", -1)).intValue();
        if (intValue != -1) {
            hashMap.put("version_code", String.valueOf(intValue));
        }
        int intValue2 = ((Integer) j.j("manifest_version_code", -1)).intValue();
        if (intValue2 != -1) {
            hashMap.put("manifest_version_code", String.valueOf(intValue2));
        }
        int intValue3 = ((Integer) j.j("update_version_code", -1)).intValue();
        if (intValue3 != -1) {
            hashMap.put("update_version_code", String.valueOf(intValue3));
        }
        String j9 = wo.j(jSONObject.optJSONObject("oaid"));
        if (!TextUtils.isEmpty(j9)) {
            hashMap.put("oaid", j9);
        }
        String optString3 = jSONObject.optString("cdid");
        if (!TextUtils.isEmpty(optString3)) {
            hashMap.put("cdid", optString3);
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.indexOf(63) >= 0 ? v0.f47960d : '?');
        return ri.j(sb.toString(), hashMap, "UTF-8");
    }

    public static String[] j(f fVar, Context context, JSONObject jSONObject) {
        String str;
        String[] xt2 = fVar.tl().xt();
        String[] strArr = new String[xt2.length];
        if (j.ae()) {
            str = "?tt_data=a";
        } else {
            str = "?";
        }
        for (int i6 = 0; i6 < xt2.length; i6++) {
            String j6 = j(context, jSONObject, xt2[i6] + str, true, j.r());
            strArr[i6] = j6;
            strArr[i6] = q.j(j6, q.xt);
        }
        return strArr;
    }
}
