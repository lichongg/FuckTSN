package com.baidu.mobads.sdk.api;

import androidx.annotation.DrawableRes;
import com.baidu.mobads.sdk.internal.cn;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AdSettings {
    public static String getSDKVersion() {
        return cn.c() + "";
    }

    public static void setNotificationChannel(String str) {
        CustomNotification.setNotificationChannel(str);
    }

    public static void setNotificationIcon(@DrawableRes int i6) {
        CustomNotification.setNotificationIcon(i6);
    }
}
