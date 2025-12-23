package cn.jpush.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.au.g;
import cn.jiguang.bb.f;
import cn.jiguang.d.a;
import cn.jiguang.internal.JConstants;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes2.dex */
public class BActivity extends Activity {
    private static final String TAG = "BActivity";

    private void handleStart() {
        try {
            g.a(StubApp.getOrigApplicationContext(getApplicationContext()), getIntent() != null ? getIntent().getExtras() : null, 8);
        } catch (Throwable th) {
            f.c(TAG, "handle start error#" + th);
        }
        try {
            finish();
        } catch (Throwable th2) {
            f.c(TAG, "finish error#" + th2);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f.c(TAG, "BActivity oncreate");
        if (a.f(StubApp.getOrigApplicationContext(getApplicationContext())) > 0 && JConstants.isInstrumentationHookFailed) {
            JCoreManager.init(StubApp.getOrigApplicationContext(getApplicationContext()));
        }
        handleStart();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        f.c(TAG, "BActivity onNewIntent");
        handleStart();
    }
}
