package p2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {
    @SuppressLint({"MissingPermission"})
    public static String a(Context context) {
        String e6 = c.e(context);
        if (TextUtils.isEmpty(e6)) {
            String e7 = b.e(context);
            if (!TextUtils.isEmpty(e7)) {
                return e7;
            }
            e6 = c.d(context);
            if (TextUtils.isEmpty(e6)) {
                String d6 = b.d(context);
                if (!TextUtils.isEmpty(d6)) {
                    return d6;
                }
                e6 = b.c(context);
                if (TextUtils.isEmpty(e6)) {
                    String c6 = c.c(context);
                    if (!TextUtils.isEmpty(c6)) {
                        return c6;
                    }
                    return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                }
            }
        }
        return e6;
    }

    private static boolean b(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i6 = 0; i6 < str.length(); i6++) {
            if (str.charAt(i6) != '0') {
                return false;
            }
        }
        return true;
    }

    public static boolean c(Context context) {
        return b(a(context));
    }
}
