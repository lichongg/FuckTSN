package com.bytedance.sdk.openadsdk.tl;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.vl;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j implements xt {

    /* renamed from: j, reason: collision with root package name */
    private SparseArray<Method> f31847j = new SparseArray<>();
    private Object xt;

    public abstract String j();

    @Override // com.bytedance.sdk.openadsdk.tl.xt
    public void j(int i6, Method method) {
        this.f31847j.put(i6, method);
    }

    @Override // com.bytedance.sdk.openadsdk.tl.xt
    public <T> T call(int i6, Object... objArr) {
        Object obj;
        Method method = this.f31847j.get(i6);
        if (method == null || (obj = this.xt) == null) {
            vl.xt(j(), "call method " + i6 + " failed for null ");
            return null;
        }
        try {
            return obj instanceof Class ? (T) method.invoke(null, objArr) : (T) method.invoke(obj, objArr);
        } catch (Throwable th) {
            vl.xt(j(), "call method " + i6 + " failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tl.xt
    public void j(Object obj) {
        this.xt = obj;
    }
}
