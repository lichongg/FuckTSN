package com.bytedance.sdk.openadsdk.core.xt.j;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private final Map<Class, j> f31335j = new HashMap();

    public cw j(n nVar, Context context, com.bytedance.sdk.openadsdk.core.xt.r rVar, boolean z5) {
        cw cwVar = new cw(rVar);
        com.bytedance.sdk.openadsdk.core.xt.j.xt.j jVar = new com.bytedance.sdk.openadsdk.core.xt.j.xt.j(nVar, context);
        this.f31335j.put(com.bytedance.sdk.openadsdk.core.xt.j.xt.j.class, jVar);
        xt xtVar = new xt(nVar, context);
        this.f31335j.put(xt.class, xtVar);
        com.bytedance.sdk.openadsdk.core.xt.j.j.j j6 = j(nVar, context);
        this.f31335j.put(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class, j6);
        com.bytedance.sdk.openadsdk.core.xt.j.cw.j jVar2 = new com.bytedance.sdk.openadsdk.core.xt.j.cw.j(nVar, context);
        this.f31335j.put(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class, jVar2);
        com.bytedance.sdk.openadsdk.core.xt.j.cw.cw cwVar2 = new com.bytedance.sdk.openadsdk.core.xt.j.cw.cw(nVar, context);
        this.f31335j.put(com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.class, cwVar2);
        cwVar.j(cwVar2);
        cwVar.j(jVar);
        cwVar.j(xtVar);
        cwVar.j(j6);
        cwVar.j(jVar2);
        return cwVar;
    }

    private <T extends j> T xt(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (Throwable unused) {
            try {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(n.class, Context.class);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(null, null);
            } catch (Throwable unused2) {
                return null;
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.xt.j.j.j j(n nVar, Context context) {
        com.bytedance.sdk.openadsdk.core.xt.j.j.cw cwVar = new com.bytedance.sdk.openadsdk.core.xt.j.j.cw();
        cwVar.j(nVar);
        cwVar.j(context);
        return cwVar;
    }

    public <T extends j> T j(Class<T> cls) {
        T t5 = (T) this.f31335j.get(cls);
        return t5 == null ? (T) xt(cls) : t5;
    }
}
