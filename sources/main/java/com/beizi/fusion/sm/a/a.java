package com.beizi.fusion.sm.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {
    public static String a(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "oaid_limit_state");
            if (!TextUtils.isEmpty(string) && !Boolean.parseBoolean(string)) {
                String string2 = Settings.Global.getString(context.getContentResolver(), "oaid");
                if (!TextUtils.isEmpty(string2)) {
                    return string2;
                }
                return "";
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
