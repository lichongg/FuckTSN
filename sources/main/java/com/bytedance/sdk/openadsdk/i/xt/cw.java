package com.bytedance.sdk.openadsdk.i.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final Bridge f31508j;

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Object apply;
        Object call;
        if (sparseArray == null || this.f31508j == null) {
            apply = a.f22765e.apply(sparseArray);
            return apply;
        }
        int intValue = ((Integer) sparseArray.get(-99999987)).intValue();
        Class cls = (Class) sparseArray.get(-99999985);
        if (intValue == -99999977) {
            Bridge bridge = this.f31508j;
            return (!(bridge instanceof xt) || (call = bridge.call(-99999977, a.f22763c, Object.class)) == null) ? this.f31508j : call;
        }
        if (intValue != -99999986) {
            return com.bytedance.sdk.openadsdk.i.xt.cw.j.j(this.f31508j.call(intValue, com.bytedance.sdk.openadsdk.i.xt.cw.j.xt(sparseArray), cls));
        }
        ValueSet values = this.f31508j.values();
        if (values == null) {
            return null;
        }
        return new j(values);
    }

    public cw(Bridge bridge) {
        this.f31508j = bridge;
    }
}
