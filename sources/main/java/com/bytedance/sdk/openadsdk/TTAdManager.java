package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface TTAdManager {
    TTAdNative createAdNative(Context context);

    String getBiddingToken(AdSlot adSlot);

    String getBiddingToken(AdSlot adSlot, boolean z5, int i6);

    <T> T getExtra(Class<T> cls, Bundle bundle);

    String getPluginVersion();

    String getSDKVersion();

    int getThemeStatus();

    Bundle handleEvent(Bundle bundle);

    void register(Object obj);

    void requestPermissionIfNecessary(Context context);

    void setThemeStatus(int i6);

    boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener);

    void unregister(Object obj);
}
