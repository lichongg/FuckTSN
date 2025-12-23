package com.bytedance.sdk.openadsdk.i.j.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final TTAdInteractionListener f31504j;

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f31504j == null) {
            return null;
        }
        ValueSet k6 = a.j(sparseArray).k();
        if (k6.intValue(-99999987) == 100101) {
            this.f31504j.onAdEvent(k6.intValue(0), (Map) k6.objectValue(1, Map.class));
        }
        return null;
    }

    public xt(TTAdInteractionListener tTAdInteractionListener) {
        this.f31504j = tTAdInteractionListener;
    }
}
