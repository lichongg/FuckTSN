package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.x;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq {
    private static boolean j(int i6, int i7, int i8, int i9, float f6, float f7) {
        return f6 >= ((float) i6) && f6 <= ((float) (i8 + i6)) && f7 >= ((float) i7) && f7 <= ((float) (i9 + i7));
    }

    public static boolean j(View view, com.bytedance.sdk.component.adexpress.cw cwVar) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i6 = iArr[0];
            int i7 = iArr[1];
            int width = view.getWidth();
            int height = view.getHeight();
            if (cwVar instanceof x) {
                x xVar = (x) cwVar;
                return j(i6, i7, width, height, xVar.f30480j, xVar.xt);
            }
        }
        return false;
    }

    public static String j(com.bytedance.sdk.component.adexpress.cw cwVar) {
        JSONObject j6;
        if (!(cwVar instanceof x) || (j6 = ((x) cwVar).j()) == null) {
            return null;
        }
        return j6.optString("ugen_id");
    }

    public static void j(n nVar, boolean z5, String str, int i6, Map<String, Object> map) {
        JSONObject j6 = uf.j(map);
        if (j6 == null) {
            j6 = new JSONObject();
        }
        try {
            j6.put("success", z5 ? 1 : 0);
            j6.put("style_type", i6);
            j6.put("style_id", str);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar, "easy_play_show", j6);
    }

    public static void j(n nVar, boolean z5, String str, int i6, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("area_type", z5 ? 1 : 2);
            jSONObject.put("style_type", i6);
            jSONObject.put("style_id", str);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar, "easy_play_click", jSONObject);
    }
}
