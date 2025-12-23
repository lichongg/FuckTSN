package com.bytedance.sdk.openadsdk.i.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements Bridge {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31516j;

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        Function<SparseArray<Object>, Object> function = this.f31516j;
        if (function != null) {
            return com.bytedance.sdk.openadsdk.i.xt.cw.j.xt(com.bytedance.sdk.openadsdk.i.xt.cw.j.j(function));
        }
        return null;
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        this.f31516j = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i6, ValueSet valueSet, Class<T> cls) {
        Object apply;
        Object apply2;
        Object apply3;
        if (i6 == -99999977) {
            if (this.f31516j instanceof cw) {
                apply3 = this.f31516j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(-99999977).j(Bridge.class).xt());
                T t5 = (T) apply3;
                if (t5 instanceof Bridge) {
                    return t5;
                }
            }
            return (T) this.f31516j;
        }
        if (this.f31516j != null) {
            j jVar = new j(valueSet);
            jVar.put(-99999987, Integer.valueOf(i6));
            jVar.put(-99999985, cls);
            apply = this.f31516j.apply(jVar);
            T t6 = (T) com.bytedance.sdk.openadsdk.i.xt.cw.j.xt(apply);
            if (t6 == null) {
                apply2 = a.f22765e.apply(jVar);
                return (T) apply2;
            }
            return t6;
        }
        return null;
    }
}
