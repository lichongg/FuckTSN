package xyz.adscope.amps.tool.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSRegularUtil {
    public static boolean isInteger(String str) {
        try {
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("-?\\d+").matcher(str).matches();
    }
}
