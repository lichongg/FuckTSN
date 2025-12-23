package com.bytedance.embedapplog.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.embedapplog.f;
import com.bytedance.embedapplog.uc;

/* loaded from: D:\Downloads\app\classes3.dex */
public class Collector extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra("EMBED_K_DATA");
        if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
            uc.xt((Throwable) null);
        } else {
            f.j(stringArrayExtra);
        }
    }
}
