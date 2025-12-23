package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.bytedance.sdk.openadsdk.core.rn;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {
    public static void j(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        rn jsObject = nativeExpressView.getJsObject();
        if (jsObject != null) {
            jsObject.j("notifyAdClicked", (JSONObject) null);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.express.m uGenV3Render = nativeExpressView.getUGenV3Render();
        if (uGenV3Render != null) {
            uGenV3Render.j("notifyAdClicked", (Map<String, String>) null);
        }
    }
}
