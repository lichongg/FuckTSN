package com.bytedance.sdk.openadsdk.tl;

import android.text.TextUtils;
import com.bytedance.sdk.component.g.xt.r;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class cw extends j {

    /* renamed from: j, reason: collision with root package name */
    public static xt f31846j;

    @Override // com.bytedance.sdk.openadsdk.tl.j
    public String j() {
        return TKDownloadReason.KSAD_TK_NET;
    }

    public static String j(r rVar, String str) {
        Map map;
        xt j6 = com.bytedance.sdk.openadsdk.core.wq.j.cw.j(TKDownloadReason.KSAD_TK_NET);
        if (j6 == null || (map = (Map) j6.call(1, str)) == null) {
            return str;
        }
        String str2 = (String) map.get("url");
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Map map2 = (Map) map.get("header");
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                rVar.xt(str3, (String) map2.get(str3));
            }
        }
        return str;
    }

    public static void xt(JSONObject jSONObject, int i6) {
        try {
            xt j6 = com.bytedance.sdk.openadsdk.core.wq.j.cw.j(TKDownloadReason.KSAD_TK_NET);
            if (j6 != null && jSONObject != null) {
                String jSONObject2 = com.bytedance.sdk.component.utils.j.j(jSONObject.toString()).toString();
                HashMap hashMap = new HashMap();
                hashMap.put("body", jSONObject2);
                hashMap.put("type", Integer.valueOf(i6));
                j6.call(3, hashMap);
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(JSONObject jSONObject, int i6) {
        try {
            xt j6 = com.bytedance.sdk.openadsdk.core.wq.j.cw.j(TKDownloadReason.KSAD_TK_NET);
            if (j6 == null) {
                return;
            }
            String jSONObject2 = com.bytedance.sdk.component.utils.j.j(jSONObject.toString()).toString();
            HashMap hashMap = new HashMap();
            hashMap.put("body", jSONObject2);
            hashMap.put("type", Integer.valueOf(i6));
            j6.call(2, hashMap);
        } catch (Throwable unused) {
        }
    }
}
