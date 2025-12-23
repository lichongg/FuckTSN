package com.baidu.liantian.rp.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.liantian.b;
import com.baidu.liantian.b.f;
import com.baidu.liantian.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                f.a(context).a();
                return;
            }
            if (action.equals("com.b.r.p")) {
                b.a();
                e eVar = new e(context);
                int x5 = eVar.x();
                b.a();
                com.baidu.liantian.b.e.a(context, x5 * 3600000);
                f.a(context).c();
                eVar.d(System.currentTimeMillis());
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }
}
