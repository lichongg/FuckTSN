package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

/* loaded from: D:\Downloads\app\classes3.dex */
final class gr {

    /* renamed from: j, reason: collision with root package name */
    private final SharedPreferences f23994j;

    @WorkerThread
    void j(@Nullable na naVar) {
        if (naVar == null) {
            return;
        }
        this.f23994j.edit().putString("oaid", naVar.xt().toString()).apply();
    }

    @Nullable
    @WorkerThread
    na j() {
        return na.j(this.f23994j.getString("oaid", ""));
    }

    @WorkerThread
    gr(Context context) {
        this.f23994j = com.bytedance.sdk.openadsdk.api.plugin.xt.xt(context, "device_register_oaid_refine", 0);
    }
}
