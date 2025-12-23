package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.ba.h;
import cn.jiguang.ba.i;
import cn.jiguang.bb.f;
import cn.jiguang.internal.JConstants;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes2.dex */
public class PushReceiver extends BroadcastReceiver {
    private static final String TAG = "PushReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        try {
            if (h.b()) {
                str = "[key-step]Your sdk is disabled already, no receiver task can be handled.";
            } else if (i.a()) {
                str = "[key-step]Your sdk is limited already, no receiver task can be handled.";
            } else {
                f.c(TAG, "onReceive:" + intent.getAction());
                if (!JConstants.isCallInit.get()) {
                    str = "please call init";
                } else {
                    JCoreManager.onEvent(StubApp.getOrigApplicationContext(context.getApplicationContext()), intent.getStringExtra("sdktype"), 31, null, null, intent);
                    return;
                }
            }
            f.d(TAG, str);
        } catch (Throwable unused) {
        }
    }
}
