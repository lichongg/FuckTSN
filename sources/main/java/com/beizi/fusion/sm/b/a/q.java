package com.beizi.fusion.sm.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class q implements com.beizi.fusion.sm.b.c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13533a;

    /* renamed from: b, reason: collision with root package name */
    private Class<?> f13534b;

    /* renamed from: c, reason: collision with root package name */
    private Object f13535c;

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        return this.f13535c != null;
    }

    private String b() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) this.f13534b.getMethod("getOAID", Context.class).invoke(this.f13535c, this.f13533a);
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f13533a == null || bVar == null) {
            return;
        }
        if (this.f13534b == null || this.f13535c == null) {
            bVar.a(new com.beizi.fusion.sm.b.d("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String b6 = b();
            if (b6 == null || b6.length() == 0) {
                throw new com.beizi.fusion.sm.b.d("OAID query failed");
            }
            com.beizi.fusion.sm.b.e.a("OAID query success: " + b6);
            bVar.a(b6);
        } catch (Exception e6) {
            com.beizi.fusion.sm.b.e.a(e6);
            bVar.a(e6);
        }
    }

    @SuppressLint({"PrivateApi"})
    public q(Context context) {
        this.f13533a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f13534b = cls;
            this.f13535c = cls.newInstance();
        } catch (Exception e6) {
            com.beizi.fusion.sm.b.e.a(e6);
        }
    }
}
