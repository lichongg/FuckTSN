package com.bxkj.base.v2.common.utils;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bxkj.base.BaseApp;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f16886a = new c();

    public final void b(@NotNull final d0 locationObserver) {
        kotlin.jvm.internal.g0.p(locationObserver, "locationObserver");
        AMapLocationClient aMapLocationClient = new AMapLocationClient(BaseApp.c());
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.SignIn);
        aMapLocationClientOption.setOnceLocation(true);
        aMapLocationClientOption.setOnceLocationLatest(true);
        aMapLocationClient.setLocationOption(aMapLocationClientOption);
        aMapLocationClient.setLocationListener(new AMapLocationListener() { // from class: com.bxkj.base.v2.common.utils.b
            @Override // com.amap.api.location.AMapLocationListener
            public final void onLocationChanged(AMapLocation aMapLocation) {
                c.c(d0.this, aMapLocation);
            }
        });
        aMapLocationClient.startLocation();
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(d0 d0Var, AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() == 0) {
            com.orhanobut.logger.j.d("GPS定位成功" + aMapLocation.getAddress(), new Object[0]);
            d0Var.a(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            return;
        }
        d0Var.b(Integer.valueOf(aMapLocation.getErrorCode()), aMapLocation.getErrorInfo());
    }
}
