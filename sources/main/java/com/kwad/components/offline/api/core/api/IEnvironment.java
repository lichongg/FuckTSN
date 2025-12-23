package com.kwad.components.offline.api.core.api;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IEnvironment {
    void addOnAudioConflictListener(Context context, OfflineOnAudioConflictListener offlineOnAudioConflictListener);

    String getAppId();

    String getAppVersion();

    String getBiz();

    Context getContext();

    String getDeviceId();

    String getKpf();

    String getKpn();

    double getLatitude(Context context);

    double getLongitude(Context context);

    String getOperator(Context context);

    String getOsVersion();

    String getProcessName(Context context);

    String getSdkVersion();

    int getStatusBarHeight(Context context);

    String getUserAgent();

    boolean isArm64(Context context);

    boolean isDebug();

    boolean isDevelopEnable();

    boolean isInMainProcess(Context context);

    boolean isTKCrashCollectEnable();

    String localIpAddress();

    void removeOnAudioConflictListener(Context context, OfflineOnAudioConflictListener offlineOnAudioConflictListener);

    boolean requestAudioFocus(Context context, boolean z5);
}
