package cn.jiguang.api.utils;

import android.content.Context;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bb.f;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JCollectionAuth {
    public static void enableAutoWakeup(Context context, boolean z5) {
        f.e("JCollectAuth", "action: enableAutoWakeup: " + z5);
        JCoreManager.onEvent(context, null, 109, null, null, Boolean.valueOf(z5));
    }

    @Deprecated
    public static void setAuth(Context context, boolean z5) {
        f.e("JCollectionAuth", "action:setAuth: " + z5);
        JCoreManager.onEvent(context, null, 96, null, null, Boolean.valueOf(z5));
    }

    public static void enableAppTerminate(Context context, boolean z5) {
        JCoreManager.onEvent(context, null, 119, null, null, Boolean.valueOf(z5));
    }

    @Deprecated
    public static void enableDynamicLoad(Context context, boolean z5) {
        JCoreManager.onEvent(context, null, 115, null, null, Boolean.valueOf(z5));
    }
}
