package com.bytedance.sdk.openadsdk.api;

import a1.b;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements Initializer {

    /* renamed from: j, reason: collision with root package name */
    Function<SparseArray<Object>, Object> f27603j;

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public Manager getManager() {
        Object apply;
        if (this.f27603j == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -999000);
        apply = this.f27603j.apply(sparseArray);
        return new cw(b.a(apply));
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public void init(Context context, ValueSet valueSet) {
        if (this.f27603j == null || valueSet == null || context == null) {
            return;
        }
        SparseArray<Object> sparseArray = valueSet.sparseArray();
        sparseArray.put(-99999987, -999001);
        sparseArray.put(-998000, context);
        this.f27603j.apply(sparseArray);
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public boolean isInitSuccess() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -999002);
        Function<SparseArray<Object>, Object> function = this.f27603j;
        if (function == null) {
            return false;
        }
        apply = function.apply(sparseArray);
        if (apply instanceof Boolean) {
            return ((Boolean) apply).booleanValue();
        }
        return false;
    }

    public r(Function<SparseArray<Object>, Object> function) {
        this.f27603j = function;
    }
}
