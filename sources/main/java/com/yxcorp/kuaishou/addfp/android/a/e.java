package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f42926a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences.Editor f42927b;

    public void a(String str) {
        this.f42927b.putString("kwtk", str);
        this.f42927b.commit();
    }

    public boolean a() {
        return this.f42926a.getBoolean("xytk", true);
    }

    public String b() {
        return this.f42926a.getString("kwtk", "");
    }

    public e(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f42926a = sharedPreferences;
            this.f42927b = sharedPreferences.edit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
