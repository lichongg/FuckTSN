package com.bytedance.sdk.openadsdk.mediation.xt.j.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final IMediationPreloadRequestInfo f31784j;

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Object apply;
        if (this.f31784j == null) {
            return null;
        }
        switch (a.j(sparseArray).k().intValue(-99999987)) {
            case 271044:
                return Integer.class.cast(Integer.valueOf(this.f31784j.getAdType()));
            case 271045:
                SparseArray<Object> j6 = com.bytedance.sdk.openadsdk.i.j.cw.xt.j(this.f31784j.getAdSlot());
                return j6 != null ? j6 : new SparseArray();
            case 271046:
                return this.f31784j.getPrimeRitList();
            default:
                apply = a.f22765e.apply(sparseArray);
                return apply;
        }
    }

    public r(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        this.f31784j = iMediationPreloadRequestInfo;
    }
}
