package com.bytedance.sdk.openadsdk.tj.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.i.j.j.az;
import com.bytedance.sdk.openadsdk.i.j.j.ws;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final TTAdNative.RewardVideoAdListener f31835j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet k6;
        if (this.f31835j != null && (k6 = a.j(sparseArray).k()) != null) {
            switch (k6.intValue(-99999987)) {
                case 124101:
                    this.f31835j.onError(k6.intValue(0), k6.stringValue(1));
                    break;
                case 124102:
                    this.f31835j.onRewardVideoAdLoad(new ws(az.j(k6.objectValue(0, Object.class))));
                    break;
                case 124103:
                    this.f31835j.onRewardVideoCached(new ws(az.j(k6.objectValue(0, Object.class))));
                    break;
                case 124104:
                    this.f31835j.onRewardVideoCached();
                    break;
            }
        }
        return null;
    }

    public m(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.f31835j = rewardVideoAdListener;
    }
}
