package com.bytedance.sdk.openadsdk.mediation.xt.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements IMediationNativeTokenInfo {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31778j;

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo
    public void loadNativeAdByAdm(String str, TTAdNative.FeedAdListener feedAdListener) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, str);
        sparseArray.put(1, new com.bytedance.sdk.openadsdk.tj.j.j.j.xt(feedAdListener));
        sparseArray.put(-99999987, 270028);
        sparseArray.put(-99999985, Void.class);
        this.f31778j.apply(sparseArray);
    }

    public cw(Function<SparseArray<Object>, Object> function) {
        this.f31778j = function == null ? a.f22765e : function;
    }
}
