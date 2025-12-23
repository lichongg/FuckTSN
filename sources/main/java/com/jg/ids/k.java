package com.jg.ids;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\Downloads\app\classes10.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final k f35553a = new k();

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f35554b = null;

    private k() {
    }

    public final void a(Context context) {
        if (this.f35554b == null) {
            this.f35554b = context.getSharedPreferences("jg_ids", 0);
        }
    }

    public static k a() {
        return f35553a;
    }

    public final String b() {
        return this.f35554b.getString("jg_aaid", "");
    }

    public final void a(String str) {
        SharedPreferences.Editor edit = this.f35554b.edit();
        edit.putString("jg_aaid", str);
        edit.commit();
    }

    public final String c() {
        return this.f35554b.getString("jg_vaid", "");
    }

    public final void b(String str) {
        SharedPreferences.Editor edit = this.f35554b.edit();
        edit.putString("jg_vaid", str);
        edit.commit();
    }

    public final String d() {
        return this.f35554b.getString("jg_oaid", "");
    }

    public final void c(String str) {
        SharedPreferences.Editor edit = this.f35554b.edit();
        edit.putString("jg_oaid", str);
        edit.commit();
    }
}
