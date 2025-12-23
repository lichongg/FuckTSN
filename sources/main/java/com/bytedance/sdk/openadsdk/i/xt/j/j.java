package com.bytedance.sdk.openadsdk.i.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements EventListener {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31513j;

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i6, Result result) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, Integer.valueOf(i6));
        if (result != null) {
            sparseArray.put(-999900, Integer.valueOf(result.code()));
            sparseArray.put(-999903, Boolean.valueOf(result.isSuccess()));
            sparseArray.put(-999901, result.message());
            sparseArray.put(-999902, result.values() != null ? result.values().sparseArray() : new SparseArray<>());
        }
        apply = this.f31513j.apply(sparseArray);
        if (apply instanceof SparseArray) {
            return a.j((SparseArray) apply).k();
        }
        return null;
    }

    public j(Function<SparseArray<Object>, Object> function) {
        this.f31513j = function;
    }
}
