package com.bytedance.sdk.openadsdk.mediation.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.j.j.j.j.b;
import com.bykv.j.j.j.j.c;
import com.bykv.j.j.j.j.f;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;
import java.util.function.IntSupplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j implements Function<SparseArray<Object>, Object>, IntSupplier {
    public abstract <T> T applyFunction(int i6, ValueSet valueSet, Class<T> cls);

    public abstract SparseArray<Object> get();

    public static <T> T objectValue(Object obj, Class<T> cls, T t5) {
        Object obj2;
        if (obj instanceof ValueSet.ValueGetter) {
            obj = (T) ((ValueSet.ValueGetter) obj).get();
        } else if (b.a(obj) && !f.a(obj) && !(obj instanceof ValueSet)) {
            obj2 = c.a(obj).get();
            obj = (T) obj2;
        }
        return cls.isInstance(obj) ? (T) obj : t5;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet k6 = a.j(sparseArray).k();
        int intValue = k6.intValue(-99999987, 0);
        return intValue == -99999986 ? get() : applyFunction(intValue, k6, (Class) k6.objectValue(-99999985, Class.class));
    }

    @Override // java.util.function.IntSupplier
    public int getAsInt() {
        return 7000;
    }
}
