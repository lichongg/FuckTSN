package cn.jpush.android.service;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.android.IDataShare;
import cn.jiguang.bb.f;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JCommonService extends Service {
    private static final String TAG = "JCommonService";
    private static IDataShare.Stub mBinder;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i6, int i7) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            f.i(TAG, "onStartCommand intent is empty or action is empty");
            return 2;
        }
        JCoreInternalHelper.getInstance().onEvent(this, JConstants.SDK_TYPE, 2, true, intent.getAction(), intent.getExtras(), new Object[0]);
        return 2;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        JConstants.getAppContext(StubApp.getOrigApplicationContext(getApplicationContext()));
        if (mBinder == null) {
            mBinder = new DataShare();
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i6) {
        super.onStart(intent, i6);
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i6) {
        super.onTrimMemory(i6);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
