package cn.jpush.android.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import cn.jiguang.au.g;
import cn.jiguang.bb.f;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes2.dex */
public class DaemonService extends Service {
    private static final String TAG = "DaemonService";

    @Override // android.app.Service
    public void onDestroy() {
        f.c(TAG, "action onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Bundle bundle;
        Context origApplicationContext = StubApp.getOrigApplicationContext(getApplicationContext());
        if (intent != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        g.a(origApplicationContext, bundle, 2);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f.c(TAG, "action onCreate");
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i6, int i7) {
        Bundle bundle;
        Context origApplicationContext = StubApp.getOrigApplicationContext(getApplicationContext());
        if (intent != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        g.a(origApplicationContext, bundle, 1);
        return 2;
    }
}
