package com.bytedance.sdk.openadsdk.core.f;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    static HashSet<String> f28937j = new HashSet<>();

    public static void j(String str) {
        if (!TextUtils.isEmpty(str)) {
            f28937j.add(str);
        }
    }

    public static void xt(final String str) {
        if (!TextUtils.isEmpty(str) && f28937j.contains(str)) {
            f28937j.remove(str);
            ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.f.j.1
                @Override // com.bytedance.sdk.openadsdk.vl.j.j
                public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("union_key", str);
                    return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("listener_process_but_not_register").xt(jSONObject.toString());
                }
            }, "listener_process_but_not_register");
        }
    }
}
