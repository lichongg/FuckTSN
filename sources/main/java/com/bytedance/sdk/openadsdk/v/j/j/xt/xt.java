package com.bytedance.sdk.openadsdk.v.j.j.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final TTFeedAd.VideoRewardListener f31957j;

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f31957j == null) {
            return null;
        }
        ValueSet k6 = a.j(sparseArray).k();
        if (k6.intValue(-99999987) == 163101) {
            this.f31957j.onFeedRewardCountDown(k6.intValue(0));
        }
        return null;
    }

    public xt(TTFeedAd.VideoRewardListener videoRewardListener) {
        this.f31957j = videoRewardListener;
    }
}
