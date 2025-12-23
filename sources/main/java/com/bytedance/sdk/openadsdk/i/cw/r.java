package com.bytedance.sdk.openadsdk.i.cw;

import a1.b;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.j.j.j.j.f;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Supplier;
import r0.a;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    public static boolean j(int i6) {
        return i6 >= 6803 && i6 < 7000;
    }

    public static <T> Object j(final Supplier<T> supplier) {
        return j(a.a().c()) ? new ValueSet.ValueGetter<Object>() { // from class: com.bytedance.sdk.openadsdk.i.cw.r.1
            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            public T get() {
                ?? r02;
                r02 = supplier.get();
                return r02;
            }
        } : supplier;
    }

    public static boolean xt(int i6) {
        return i6 >= 7000;
    }

    public static Object j(SparseArray<Object> sparseArray) {
        return j(a.a().c()) ? com.bykv.j.j.j.j.a.j(sparseArray).k() : sparseArray;
    }

    public static PluginValueSet j(int i6, PluginValueSet pluginValueSet) {
        if (j(a.a().c())) {
            return e.i(((ValueSet) pluginValueSet.objectValue(i6, ValueSet.class)).sparseArray()).k();
        }
        return e.i((SparseArray) pluginValueSet.objectValue(i6, SparseArray.class)).k();
    }

    public static Object j(Object obj) {
        return (a.a().c() < 6803 || a.a().c() >= 6900 || !f.a(obj)) ? obj : new com.bytedance.sdk.openadsdk.i.xt.j.j(b.a(obj));
    }
}
