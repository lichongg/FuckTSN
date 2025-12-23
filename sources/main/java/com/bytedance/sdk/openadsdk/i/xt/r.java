package com.bytedance.sdk.openadsdk.i.xt;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private EventListener f31514j;

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null || this.f31514j == null) {
            return null;
        }
        return this.f31514j.onEvent(((Integer) sparseArray.get(-99999987)).intValue(), com.bytedance.sdk.openadsdk.i.xt.cw.j.j((SparseArray<Object>) sparseArray.get(-99999979)));
    }

    public r(EventListener eventListener) {
        this.f31514j = eventListener;
    }
}
