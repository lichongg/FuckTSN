package com.baidu.idl.face.platform.ui.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.net.Uri;
import android.provider.Settings;
import android.view.WindowManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BrightnessUtils {
    private static final String TAG = "BrightnessUtils";

    public static boolean isAutoBrightness(ContentResolver contentResolver) {
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static void saveBrightness(ContentResolver contentResolver, int i6) {
        Uri uriFor = Settings.System.getUriFor("screen_brightness");
        Settings.System.putInt(contentResolver, "screen_brightness", i6);
        contentResolver.notifyChange(uriFor, null);
    }

    public static int getScreenBrightness(Activity activity) {
        try {
            return Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    public static void setBrightness(Activity activity, int i6) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = i6 * 0.003921569f;
        activity.getWindow().setAttributes(attributes);
    }

    public static void startAutoBrightness(Activity activity) {
        Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 1);
    }

    public static void stopAutoBrightness(Activity activity) {
        Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 0);
    }
}
