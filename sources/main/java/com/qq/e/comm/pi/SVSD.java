package com.qq.e.comm.pi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface SVSD {
    IBinder onBind(Intent intent);

    void onConfigurationChanged(Configuration configuration);

    void onCreate();

    void onDestroy();

    void onLowMemory();

    void onRebind(Intent intent);

    int onStartCommand(Intent intent, int i6, int i7);

    void onTaskRemoved(Intent intent);

    void onTrimMemory(int i6);

    boolean onUnbind(Intent intent);
}
