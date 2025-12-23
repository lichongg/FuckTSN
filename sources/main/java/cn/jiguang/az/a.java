package cn.jiguang.az;

import android.content.Context;
import cn.jiguang.internal.JConstants;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {
    public static JSONObject a(Context context) {
        try {
            Object a6 = f.a(context, JConstants.SDK_TYPE, 101, null, null, new Object[0]);
            if (a6 instanceof JSONObject) {
                return (JSONObject) a6;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.ay.b.e("JDeviceHelper", "getDInfo exception: " + th.getMessage());
            return null;
        }
    }
}
