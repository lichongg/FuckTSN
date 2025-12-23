package com.bytedance.j.xt.up.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: D:\Downloads\app\classes3.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private int f24282a;

    static /* synthetic */ class a {
    }

    private class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(e eVar, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    e.this.f24282a = (int) ((intent.getIntExtra("level", 0) * 100.0f) / intent.getIntExtra("scale", 100));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void c(Context context) {
        context.registerReceiver(new b(this, null), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public int a() {
        return this.f24282a;
    }

    e(Context context) {
        try {
            c(context);
        } catch (Throwable unused) {
        }
    }
}
