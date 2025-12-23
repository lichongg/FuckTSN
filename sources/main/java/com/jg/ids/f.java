package com.jg.ids;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes10.dex */
public abstract class f implements i {

    /* renamed from: b, reason: collision with root package name */
    private static String f35522b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f35523c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f35524d = "";

    /* renamed from: a, reason: collision with root package name */
    protected Context f35525a;

    public f(Context context) {
        this.f35525a = null;
        this.f35525a = context;
        try {
            f35522b = k.a().b();
            f35523c = k.a().c();
            f35524d = k.a().d();
        } catch (Throwable th) {
        }
    }

    public final void a(String str) {
        try {
            f35522b = str;
            k.a().a(f35522b);
        } catch (Throwable th) {
        }
    }

    public final void b(String str) {
        try {
            f35523c = str;
            k.a().b(f35523c);
        } catch (Throwable th) {
        }
    }

    public final void c(String str) {
        try {
            f35524d = str;
            k.a().c(f35524d);
        } catch (Throwable th) {
        }
    }

    @Override // com.jg.ids.i
    public String a(Context context) {
        return f35523c;
    }

    @Override // com.jg.ids.i
    public String b(Context context) {
        return f35524d;
    }

    @Override // com.jg.ids.i
    public String c(Context context) {
        return f35522b;
    }

    protected boolean c() {
        return TextUtils.isEmpty(f35522b) || TextUtils.isEmpty(f35523c) || TextUtils.isEmpty(f35524d);
    }

    @Override // com.jg.ids.i
    public boolean d() {
        return true;
    }
}
