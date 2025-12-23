package com.qq.e.mediation.interfaces;

import android.app.Activity;
import android.view.View;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class BaseBannerAd implements IBaseAd {
    public abstract void destroy();

    public abstract View getAdView();

    public abstract boolean isValid();

    public abstract void loadAD();

    public abstract void setAdListener(ADListener aDListener);

    public abstract void setAdSize(int i6, int i7);

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    public BaseBannerAd(Activity activity, String str, String str2, String str3) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendWinNotification(int i6) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setBidECPM(int i6) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setPayload(String str) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendLossNotification(int i6, int i7, String str) {
    }
}
