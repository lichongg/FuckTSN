package com.bytedance.embedapplog;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class q {

    /* renamed from: j, reason: collision with root package name */
    public static JSONObject f24032j;

    /* renamed from: r, reason: collision with root package name */
    private static final String[] f24033r = {"GET", "POST"};
    private static final String[] up = {CommonNetImpl.AID, "app_version", "tt_data"};
    static final String[] xt = {CommonNetImpl.AID, "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", "iid", "device_platform"};
    public static final String[] cw = {"tt_data", "device_platform"};

    public static boolean j(int i6) {
        return i6 >= 500 && i6 < 600;
    }

    private static String j(String str) {
        if (TextUtils.isEmpty(str) || !j.ae()) {
            return str;
        }
        Uri parse = Uri.parse(str);
        String query = parse.getQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str2 : up) {
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(new Pair(str2, queryParameter));
            }
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (Pair pair : arrayList) {
            buildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        buildUpon.appendQueryParameter("tt_info", new String(Base64.encode(pz.j(query), 8)));
        return buildUpon.build().toString();
    }

    public static JSONObject xt(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        HashMap hashMap = new HashMap(2);
        if (j.ae()) {
            hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            hashMap.put("Content-Type", "application/json; charset=utf-8");
        }
        String j6 = j(1, str, hashMap, pz.j(jSONObject.toString()));
        if (j6 != null) {
            try {
                jSONObject2 = new JSONObject(j6);
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
            if (jSONObject2 == null && "ss_app_log".equals(jSONObject2.optString("magic_tag", ""))) {
                return jSONObject2.optJSONObject("config");
            }
            return null;
        }
        jSONObject2 = null;
        if (jSONObject2 == null) {
        }
        return null;
    }

    public static JSONObject cw(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String j6 = j(1, str, null, pz.j(jSONObject.toString()));
        if (j6 != null) {
            try {
                jSONObject2 = new JSONObject(j6);
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
            if (jSONObject2 != null || !"success".equals(jSONObject2.optString(CrashHianalyticsData.MESSAGE, ""))) {
                return null;
            }
            return jSONObject2.optJSONObject("data");
        }
        jSONObject2 = null;
        if (jSONObject2 != null) {
        }
        return null;
    }

    public static String j(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        HashMap hashMap = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                hashMap.put(str2, queryParameter);
            }
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (String str3 : hashMap.keySet()) {
            buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
        }
        return buildUpon.build().toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String j(int r7, java.lang.String r8, java.util.HashMap<java.lang.String, java.lang.String> r9, byte[] r10) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.q.j(int, java.lang.String, java.util.HashMap, byte[]):java.lang.String");
    }

    public static JSONObject j(String str, JSONObject jSONObject) {
        HashMap hashMap = new HashMap(2);
        if (j.ae()) {
            hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            hashMap.put("Content-Type", "application/json; charset=utf-8");
        }
        String j6 = j(1, j(str), hashMap, pz.j(jSONObject.toString()));
        if (j6 == null) {
            return null;
        }
        try {
            return new JSONObject(j6);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int j(java.lang.String[] r8, byte[] r9, com.bytedance.embedapplog.rn r10) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.q.j(java.lang.String[], byte[], com.bytedance.embedapplog.rn):int");
    }
}
