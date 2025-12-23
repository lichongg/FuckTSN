package com.bytedance.sdk.component.adexpress.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<j> f25849j;

    public void j(j jVar) {
        this.f25849j = new WeakReference<>(jVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_status_change", 0);
        WeakReference<j> weakReference = this.f25849j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f25849j.get().b_(intExtra);
    }
}
