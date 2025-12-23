package com.bytedance.sdk.openadsdk.core.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.j;

/* loaded from: D:\Downloads\app\classes4.dex */
public class BinderPoolService extends Service {

    /* renamed from: j, reason: collision with root package name */
    private Binder f29523j = new j.BinderC0465j();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f29523j;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
