package cn.jpush.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: D:\Downloads\app\classes2.dex */
public class PushService extends Service {
    private static final String TAG = "PushService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        return 2;
    }
}
