package com.bytedance.sdk.openadsdk.i.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJAdError;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends CSJAdError {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31489j;
    private ValueSet xt;

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public int getCode() {
        return this.xt.intValue(263001);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public String getMsg() {
        return this.xt.stringValue(263002);
    }

    public j(Function<SparseArray<Object>, Object> function) {
        Object apply;
        this.xt = a.f22763c;
        function = function == null ? a.f22765e : function;
        this.f31489j = function;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            this.xt = a.j((SparseArray) apply).k();
        }
    }
}
