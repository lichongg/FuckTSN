package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ApiDownloadHandlerService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        cw j6 = cw.j();
        if (j6 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("s", this);
            j6.j(hashMap, 157);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        super.onStartCommand(intent, i6, i7);
        cw j6 = cw.j();
        if (j6 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("i", intent);
            hashMap.put("c", this);
            j6.j(hashMap, 158);
        }
        stopSelf();
        return 2;
    }
}
