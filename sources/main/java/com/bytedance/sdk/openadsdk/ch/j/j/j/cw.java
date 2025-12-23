package com.bytedance.sdk.openadsdk.ch.j.j.j;

import android.util.SparseArray;
import android.view.View;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final TTNativeAd.ExpressRenderListener f27747j;

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f27747j == null) {
            return null;
        }
        ValueSet k6 = a.j(sparseArray).k();
        if (k6.intValue(-99999987) == 142101) {
            this.f27747j.onRenderSuccess((View) k6.objectValue(0, View.class), k6.floatValue(1), k6.floatValue(2), k6.booleanValue(3));
        }
        return null;
    }

    public cw(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.f27747j = expressRenderListener;
    }
}
