package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\Downloads\app\classes4.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {

    /* renamed from: j, reason: collision with root package name */
    private j f26850j;

    public interface j {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            vl.j("HomeReceiver", "onReceive: action: ".concat(String.valueOf(action)));
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra(MediationConstant.KEY_REASON);
                vl.j("HomeReceiver", "reason: ".concat(String.valueOf(stringExtra)));
                if ("homekey".equals(stringExtra)) {
                    vl.j("HomeReceiver", "homekey");
                } else if ("recentapps".equals(stringExtra)) {
                    vl.j("HomeReceiver", "long press home key or activity switch");
                } else if ("assist".equals(stringExtra)) {
                    vl.j("HomeReceiver", "assist");
                }
            }
        } catch (Throwable unused) {
            vl.r("HomeReceiver", "ACTION_CLOSE_SYSTEM_DIALOGS throw");
        }
    }
}
