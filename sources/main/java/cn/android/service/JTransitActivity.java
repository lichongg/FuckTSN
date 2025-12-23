package cn.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ActionHelper;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JTransitActivity extends Activity {
    static {
        StubApp.interface11(AVMDLDataLoader.KeyIsMAXIPV4Num);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            ActionHelper.getInstance().handleNotificationIntent(StubApp.getOrigApplicationContext(getApplicationContext()), intent);
        } catch (Throwable th) {
            try {
                Logger.d("JTransitActivity", "handle intent failed:" + th.getMessage());
            } finally {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        try {
            super.onNewIntent(intent);
            a(intent);
        } catch (Throwable unused) {
        }
    }
}
