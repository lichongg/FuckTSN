package com.bytedance.sdk.openadsdk.i.xt.xt;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements Loader {

    /* renamed from: j, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f31517j;

    @Override // com.bykv.vk.openvk.api.proto.Loader
    public void load(int i6, ValueSet valueSet, EventListener eventListener) {
        if (valueSet == null || this.f31517j == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.i.xt.j jVar = new com.bytedance.sdk.openadsdk.i.xt.j(valueSet);
        jVar.put(-99999987, Integer.valueOf(i6));
        jVar.put(-99999982, Integer.valueOf(i6));
        this.f31517j.apply(jVar);
    }

    public cw(Function<SparseArray<Object>, Object> function) {
        this.f31517j = function;
    }
}
