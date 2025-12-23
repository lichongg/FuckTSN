package com.bytedance.sdk.openadsdk.mediation.ad.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements MediationAdDislike {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31655j;

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void setDislikeCallback(IMediationDislikeCallback iMediationDislikeCallback) {
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 270033);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.mediation.ad.j.j.xt.xt(iMediationDislikeCallback));
        this.f31655j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void showDislikeDialog() {
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 270032);
        sparseArray.put(-99999985, Void.class);
        this.f31655j.apply(sparseArray);
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        this.f31655j = function == null ? a.f22765e : function;
    }
}
