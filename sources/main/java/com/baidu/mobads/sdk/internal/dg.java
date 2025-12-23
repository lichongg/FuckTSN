package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class dg extends di {

    /* renamed from: a, reason: collision with root package name */
    private FullScreenVideoAd.FullScreenVideoAdListener f11011a;

    public dg(Context context, String str, boolean z5) {
        super(context, str, z5, IAdInterListener.AdProdType.PRODUCT_FULLSCREENVIDEO);
    }

    @Override // com.baidu.mobads.sdk.internal.di, com.baidu.mobads.sdk.internal.bj
    protected void g(String str) {
        FullScreenVideoAd.FullScreenVideoAdListener fullScreenVideoAdListener = this.f11011a;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }

    @Override // com.baidu.mobads.sdk.internal.di
    public void a(ScreenVideoAdListener screenVideoAdListener) {
        super.a(screenVideoAdListener);
        if (screenVideoAdListener instanceof FullScreenVideoAd.FullScreenVideoAdListener) {
            this.f11011a = (FullScreenVideoAd.FullScreenVideoAdListener) screenVideoAdListener;
        }
    }
}
