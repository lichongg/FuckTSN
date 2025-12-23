package com.kwad.sdk.core.f;

import android.content.Context;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static String doSign(Context context, String str) {
        return KWEGIDDFP.doSign(context, str);
    }

    public static void handlePolicy(JSONObject jSONObject) {
        KWEGIDDFP.handlePolicy(jSONObject);
    }
}
