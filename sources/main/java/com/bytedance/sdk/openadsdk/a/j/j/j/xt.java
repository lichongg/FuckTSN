package com.bytedance.sdk.openadsdk.a.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.i.j.j.az;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final TTRewardVideoAd.RewardAdPlayAgainController f27518j;

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f27518j == null) {
            return null;
        }
        ValueSet k6 = a.j(sparseArray).k();
        if (k6.intValue(-99999987) == 122101) {
            this.f27518j.getPlayAgainCondition(k6.intValue(0), new com.bytedance.sdk.openadsdk.w.j.j.j.j.j(az.j(k6.objectValue(1, Object.class))));
        }
        return null;
    }

    public xt(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        this.f27518j = rewardAdPlayAgainController;
    }
}
