package cn.jiguang.bz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes2.dex */
public class s {
    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, boolean z5) {
        Intent registerReceiver;
        int i6 = Build.VERSION.SDK_INT;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (i6 < 33) {
            return origApplicationContext.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        }
        registerReceiver = origApplicationContext.registerReceiver(broadcastReceiver, intentFilter, str, handler, z5 ? 2 : 4);
        return registerReceiver;
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, boolean z5) {
        Intent registerReceiver;
        int i6 = Build.VERSION.SDK_INT;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (i6 < 33) {
            return origApplicationContext.registerReceiver(broadcastReceiver, intentFilter);
        }
        registerReceiver = origApplicationContext.registerReceiver(broadcastReceiver, intentFilter, z5 ? 2 : 4);
        return registerReceiver;
    }
}
