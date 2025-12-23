package com.bytedance.sdk.openadsdk.mediation.ad.j.j.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final MediationShakeViewListener f31656j;

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f31656j != null && a.j(sparseArray).k().intValue(-99999987) == 270012) {
            this.f31656j.onDismissed();
        }
        return null;
    }

    public ae(MediationShakeViewListener mediationShakeViewListener) {
        this.f31656j = mediationShakeViewListener;
    }
}
