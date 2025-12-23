package com.baidu.mobads.sdk.api;

import android.app.Application;
import com.baidu.mobads.sdk.internal.ao;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class NovelSDKConfig {
    public static void attachBaseContext(Application application, String str, String str2) {
        ao.a(application, str, str2);
    }

    public static boolean isInitNovelSDK() {
        return ao.f();
    }
}
