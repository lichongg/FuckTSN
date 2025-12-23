package com.google.mlkit.acceleration.internal;

import android.content.Context;
import android.util.Log;
import androidx.work.Configuration;
import androidx.work.WorkManager;
import androidx.work.multiprocess.RemoteWorkerService;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class MlKitRemoteWorkerService extends RemoteWorkerService {
    @Override // androidx.work.multiprocess.RemoteWorkerService, android.app.Service
    public final void onCreate() {
        try {
            WorkManager.getInstance(StubApp.getOrigApplicationContext(getApplicationContext()));
        } catch (IllegalStateException unused) {
            Log.isLoggable("MlKitRWService", 3);
            Context origApplicationContext = StubApp.getOrigApplicationContext(getApplicationContext());
            WorkManager.initialize(origApplicationContext, new Configuration.Builder().setDefaultProcessName(origApplicationContext.getPackageName()).build());
        }
        super.onCreate();
    }
}
