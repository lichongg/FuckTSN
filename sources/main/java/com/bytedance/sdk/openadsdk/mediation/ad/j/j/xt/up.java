package com.bytedance.sdk.openadsdk.mediation.ad.j.j.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final IMediationViewBinder f31661j;

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Object apply;
        if (this.f31661j == null) {
            return null;
        }
        switch (a.j(sparseArray).k().intValue(-99999987)) {
            case 271021:
                return Integer.class.cast(Integer.valueOf(this.f31661j.getLayoutId()));
            case 271022:
                return Integer.class.cast(Integer.valueOf(this.f31661j.getTitleId()));
            case 271023:
                return Integer.class.cast(Integer.valueOf(this.f31661j.getDecriptionTextId()));
            case 271024:
                return Integer.class.cast(Integer.valueOf(this.f31661j.getCallToActionId()));
            case 271025:
                return Integer.class.cast(Integer.valueOf(this.f31661j.getIconImageId()));
            case 271026:
                return Integer.class.cast(Integer.valueOf(this.f31661j.getMainImageId()));
            case 271027:
                return Integer.class.cast(Integer.valueOf(this.f31661j.getMediaViewId()));
            case 271028:
                return Integer.class.cast(Integer.valueOf(this.f31661j.getSourceId()));
            case 271029:
                return Integer.class.cast(Integer.valueOf(this.f31661j.getGroupImage1Id()));
            case 271030:
                return Integer.class.cast(Integer.valueOf(this.f31661j.getGroupImage2Id()));
            case 271031:
                return Integer.class.cast(Integer.valueOf(this.f31661j.getGroupImage3Id()));
            case 271032:
                return Integer.class.cast(Integer.valueOf(this.f31661j.getLogoLayoutId()));
            case 271033:
                return Integer.class.cast(Integer.valueOf(this.f31661j.getShakeViewContainerId()));
            case 271034:
                return this.f31661j.getExtras();
            default:
                apply = a.f22765e.apply(sparseArray);
                return apply;
        }
    }

    public up(IMediationViewBinder iMediationViewBinder) {
        this.f31661j = iMediationViewBinder;
    }
}
