package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.pangle.up.up;

/* loaded from: D:\Downloads\app\classes3.dex */
public class BroadcastReceiverProxy extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (xt.j().j(hashCode())) {
            xt.j().j(context, intent);
        } else {
            up.cw(new Runnable() { // from class: com.bytedance.pangle.receiver.BroadcastReceiverProxy.1
                @Override // java.lang.Runnable
                public void run() {
                    xt.j().j(context, intent);
                }
            });
        }
    }
}
