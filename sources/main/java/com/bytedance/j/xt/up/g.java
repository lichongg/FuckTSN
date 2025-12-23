package com.bytedance.j.xt.up;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.xt;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f24256a;

    public void b(String str) {
        this.f24256a.edit().putString("device_id", str).apply();
    }

    public g(Context context) {
        this.f24256a = xt.xt(context, "npth", 0);
    }

    public String a() {
        String e6 = com.bytedance.j.xt.e.d().e();
        if (!TextUtils.isEmpty(e6) && !"0".equals(e6)) {
            return e6;
        }
        return this.f24256a.getString("device_id", "0");
    }
}
