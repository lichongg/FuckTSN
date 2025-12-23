package com.baidu.idl.face.platform.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DeviceUtils {
    private static final String TAG = "DeviceUtils";

    public static String getDeviceCode(Context context) {
        String str = "";
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return MD5Utils.encryption(str.getBytes());
        } catch (Exception e6) {
            e6.printStackTrace();
            return str;
        }
    }

    public static String getSerialNumber(Context context) {
        return Build.SERIAL;
    }

    public static String getAndroidID(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        try {
            return MD5Utils.encryption(string.getBytes());
        } catch (Exception e6) {
            e6.printStackTrace();
            return string;
        }
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
