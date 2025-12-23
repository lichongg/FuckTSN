package com.huawei.hms.framework.common;

import android.content.ContentResolver;
import android.provider.Settings;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class SettingUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33350a = "SettingUtil";

    public static int getSecureInt(ContentResolver contentResolver, String str, int i6) {
        try {
            return Settings.Secure.getInt(contentResolver, str, i6);
        } catch (RuntimeException e6) {
            Logger.e(f33350a, "Settings Secure getInt throwFromSystemServer:", e6);
            return i6;
        }
    }

    public static int getSystemInt(ContentResolver contentResolver, String str, int i6) {
        try {
            return Settings.System.getInt(contentResolver, str, i6);
        } catch (RuntimeException e6) {
            Logger.e(f33350a, "Settings System getInt throwFromSystemServer:", e6);
            return i6;
        }
    }
}
