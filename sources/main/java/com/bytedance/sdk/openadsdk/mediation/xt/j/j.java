package com.bytedance.sdk.openadsdk.mediation.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements IMediationDislikeCallback {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31777j;

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onCancel() {
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 268014);
        sparseArray.put(-99999985, Void.class);
        this.f31777j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onSelected(int i6, String str) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, Integer.valueOf(i6));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 268013);
        sparseArray.put(-99999985, Void.class);
        this.f31777j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onShow() {
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 268015);
        sparseArray.put(-99999985, Void.class);
        this.f31777j.apply(sparseArray);
    }

    public j(Function<SparseArray<Object>, Object> function) {
        this.f31777j = function == null ? a.f22765e : function;
    }
}
