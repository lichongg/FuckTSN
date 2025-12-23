package com.jg.ids.i;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: D:\Downloads\app\classes10.dex */
public class j implements com.jg.ids.i {

    /* renamed from: a, reason: collision with root package name */
    private Context f35545a;

    /* renamed from: b, reason: collision with root package name */
    private com.jg.ids.m.a f35546b;

    /* renamed from: c, reason: collision with root package name */
    private com.jg.ids.m.a f35547c;

    /* renamed from: d, reason: collision with root package name */
    private com.jg.ids.m.a f35548d = null;

    public static boolean d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.oplus.stdid", 0) != null;
        } catch (PackageManager.NameNotFoundException e6) {
            return false;
        }
    }

    public j(Context context) {
        this.f35545a = context;
        this.f35546b = new com.jg.ids.j(context);
        this.f35547c = new g(context);
    }

    @Override // com.jg.ids.i
    public String a(Context context) {
        return null;
    }

    @Override // com.jg.ids.i
    public String b(Context context) {
        return this.f35548d.b();
    }

    @Override // com.jg.ids.i
    public String c(Context context) {
        return null;
    }

    @Override // com.jg.ids.i
    public boolean d() {
        if (this.f35545a == null) {
            return false;
        }
        if (this.f35546b.a()) {
            this.f35548d = this.f35546b;
        }
        if (this.f35547c.a()) {
            this.f35548d = this.f35547c;
        }
        return this.f35548d != null;
    }
}
