package com.bytedance.sdk.openadsdk.i.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTImage;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv extends TTImage {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31494j;
    private ValueSet xt;

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public double getDuration() {
        return this.xt.doubleValue(230004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public int getHeight() {
        return this.xt.intValue(230002);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public String getImageUrl() {
        return this.xt.stringValue(230003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public int getWidth() {
        return this.xt.intValue(230001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public boolean isValid() {
        return this.xt.booleanValue(230005);
    }

    public qv(Function<SparseArray<Object>, Object> function) {
        Object apply;
        this.xt = a.f22763c;
        function = function == null ? a.f22765e : function;
        this.f31494j = function;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            this.xt = a.j((SparseArray) apply).k();
        }
    }
}
