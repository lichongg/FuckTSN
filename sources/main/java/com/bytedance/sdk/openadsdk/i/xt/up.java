package com.bytedance.sdk.openadsdk.i.xt;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements EventListener {

    /* renamed from: j, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f31515j;

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i6, Result result) {
        Object apply;
        if (this.f31515j == null) {
            return null;
        }
        apply = this.f31515j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(i6).j(-99999979, result != null ? com.bytedance.sdk.openadsdk.i.up.j().j(result.code()).j(result.isSuccess()).j(result.message()).j(new j(result.values())).xt() : null).j(SparseArray.class).xt());
        if (apply instanceof SparseArray) {
            return com.bytedance.sdk.openadsdk.i.xt.cw.j.xt((SparseArray<Object>) apply);
        }
        return null;
    }

    public up(Function<SparseArray<Object>, Object> function) {
        this.f31515j = function;
    }
}
