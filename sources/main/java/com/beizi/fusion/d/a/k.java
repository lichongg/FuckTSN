package com.beizi.fusion.d.a;

import android.content.Context;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private Context f13404a;

    /* renamed from: b, reason: collision with root package name */
    private Class f13405b;

    /* renamed from: c, reason: collision with root package name */
    private Object f13406c;

    /* renamed from: d, reason: collision with root package name */
    private Method f13407d;

    private String a(Context context, Method method) {
        Object obj = this.f13406c;
        if (obj == null || method == null) {
            return null;
        }
        try {
            return (String) method.invoke(obj, context);
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public k(Context context) {
        this.f13404a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f13405b = cls;
            this.f13406c = cls.newInstance();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            this.f13407d = this.f13405b.getMethod("getOAID", Context.class);
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    public String a() {
        return a(this.f13404a, this.f13407d);
    }
}
