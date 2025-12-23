package com.bytedance.sdk.openadsdk.mediation.ad.j.j.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.i.j.j.az;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final IMediationNativeToBannerListener f31657j;

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f31657j == null) {
            return null;
        }
        ValueSet k6 = a.j(sparseArray).k();
        if (k6.intValue(-99999987) != 266013) {
            return null;
        }
        return this.f31657j.getMediationBannerViewFromNativeAd(new com.bytedance.sdk.openadsdk.mediation.ad.j.j.j.j(az.j(k6.objectValue(0, Object.class))));
    }

    public cw(IMediationNativeToBannerListener iMediationNativeToBannerListener) {
        this.f31657j = iMediationNativeToBannerListener;
    }
}
