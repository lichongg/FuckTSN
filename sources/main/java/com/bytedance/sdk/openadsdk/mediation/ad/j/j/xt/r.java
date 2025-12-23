package com.bytedance.sdk.openadsdk.mediation.ad.j.j.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final IMediationSplashRequestInfo f31660j;

    public r(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.f31660j = iMediationSplashRequestInfo;
    }

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        String str = "";
        switch (a.j(sparseArray).k().intValue(-99999987)) {
            case 267001:
                IMediationSplashRequestInfo iMediationSplashRequestInfo = this.f31660j;
                if (iMediationSplashRequestInfo != null && iMediationSplashRequestInfo.getAdnName() != null) {
                    str = this.f31660j.getAdnName();
                }
                return String.valueOf(str);
            case 267002:
                IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.f31660j;
                if (iMediationSplashRequestInfo2 != null && iMediationSplashRequestInfo2.getAdnSlotId() != null) {
                    str = this.f31660j.getAdnSlotId();
                }
                return String.valueOf(str);
            case 267003:
                IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.f31660j;
                if (iMediationSplashRequestInfo3 != null && iMediationSplashRequestInfo3.getAppId() != null) {
                    str = this.f31660j.getAppId();
                }
                return String.valueOf(str);
            case 267004:
                IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.f31660j;
                if (iMediationSplashRequestInfo4 != null && iMediationSplashRequestInfo4.getAppkey() != null) {
                    str = this.f31660j.getAppkey();
                }
                return String.valueOf(str);
            default:
                return null;
        }
    }
}
