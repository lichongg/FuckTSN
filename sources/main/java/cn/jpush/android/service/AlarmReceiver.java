package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.ba.h;
import cn.jiguang.ba.i;
import cn.jiguang.bb.f;
import cn.jiguang.bi.a;
import cn.jiguang.bz.b;
import cn.jiguang.internal.JConstants;

/* loaded from: D:\Downloads\app\classes2.dex */
public class AlarmReceiver extends BroadcastReceiver {
    private static final String TAG = "AlarmReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f.c(TAG, "onReceive");
        if (h.b()) {
            f.d(TAG, "[key-step]Your sdk is disabled already, no receiver task can be handled.");
            return;
        }
        if (i.a()) {
            f.d(TAG, "[key-step]Your sdk is limited already, no receiver task can be handled.");
            return;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            f.d(TAG, "sdk is android 12, return");
            return;
        }
        if (!b.b(context)) {
            f.d(TAG, "auto wakeup is closed");
        } else if (!JConstants.isCallInit.get()) {
            f.d(TAG, "please call init");
        } else {
            a.b(context);
            JCoreManager.onEvent(context, JConstants.SDK_TYPE, 10, "a2", null, new Object[0]);
        }
    }
}
