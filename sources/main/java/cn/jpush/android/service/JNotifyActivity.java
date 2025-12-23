package cn.jpush.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ActionHelper;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JNotifyActivity extends Activity {
    private static final String TAG = "JNotifyActivity";

    static {
        StubApp.interface11(8829);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void handleIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            ActionHelper.getInstance().handleNotificationIntent(StubApp.getOrigApplicationContext(getApplicationContext()), intent);
        } catch (Throwable th) {
            try {
                Logger.d(TAG, "handle intent failed:" + th.getMessage());
            } finally {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        try {
            super.onNewIntent(intent);
            handleIntent(intent);
        } catch (Throwable unused) {
        }
    }
}
