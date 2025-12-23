package com.bytedance.sdk.openadsdk.w.j.j.j.j;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements TTRewardVideoAd.RewardAdPlayAgainController.Callback {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31961j;

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController.Callback
    public void onConditionReturn(Bundle bundle) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 123101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, bundle);
        this.f31961j.apply(sparseArray);
    }

    public j(Function<SparseArray<Object>, Object> function) {
        this.f31961j = function == null ? a.f22765e : function;
    }
}
