package com.bytedance.sdk.openadsdk.api;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements Loader {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Void> f27604j;

    @Override // com.bykv.vk.openvk.api.proto.Loader
    public void load(int i6, ValueSet valueSet, EventListener eventListener) {
        if (this.f27604j != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (valueSet != null) {
                sparseArray = valueSet.sparseArray();
            }
            sparseArray.put(-99999982, Integer.valueOf(i6));
            sparseArray.put(-99999985, Void.class);
            this.f27604j.apply(sparseArray);
        }
    }

    public xt(Function<SparseArray<Object>, Void> function) {
        this.f27604j = function;
    }
}
