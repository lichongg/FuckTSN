package com.acse.ottn.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.acse.ottn.c2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class StartProcreeService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c2.a("samon-->", "启动StartProcreeService");
    }
}
