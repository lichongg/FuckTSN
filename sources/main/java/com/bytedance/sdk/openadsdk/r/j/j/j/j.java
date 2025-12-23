package com.bytedance.sdk.openadsdk.r.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.i.j.j.az;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final CSJSplashAd.SplashAdListener f31812j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f31812j != null && sparseArray != null) {
            ValueSet k6 = a.j(sparseArray).k();
            switch (k6.intValue(-99999987)) {
                case 111101:
                    this.f31812j.onSplashAdShow(new com.bytedance.sdk.openadsdk.i.j.j.xt(az.j(k6.objectValue(0, Object.class))));
                    break;
                case 111102:
                    this.f31812j.onSplashAdClick(new com.bytedance.sdk.openadsdk.i.j.j.xt(az.j(k6.objectValue(0, Object.class))));
                    break;
                case 111103:
                    this.f31812j.onSplashAdClose(new com.bytedance.sdk.openadsdk.i.j.j.xt(az.j(k6.objectValue(0, Object.class))), k6.intValue(1));
                    break;
            }
        }
        return null;
    }

    public j(CSJSplashAd.SplashAdListener splashAdListener) {
        this.f31812j = splashAdListener;
    }
}
