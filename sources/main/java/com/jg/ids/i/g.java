package com.jg.ids.i;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes10.dex */
public class g implements com.jg.ids.m.a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f35540a;

    /* renamed from: b, reason: collision with root package name */
    private Class<?> f35541b;

    /* renamed from: c, reason: collision with root package name */
    private Object f35542c;

    public static boolean a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e6) {
            return false;
        }
    }

    public g(Context context) {
        this.f35540a = context;
        try {
            this.f35541b = Class.forName("android.app.ZteDeviceIdentifyManager");
            this.f35542c = this.f35541b.newInstance();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.jg.ids.m.a
    public boolean a() {
        return this.f35542c != null;
    }

    @Override // com.jg.ids.m.a
    public String b() {
        if (this.f35540a == null || this.f35541b == null || this.f35542c == null) {
            return "";
        }
        try {
            String str = (String) this.f35541b.getMethod("getOAID", Context.class).invoke(this.f35542c, this.f35540a);
            if (str != null) {
                if (str.length() != 0) {
                    return str;
                }
            }
            return "";
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }
}
