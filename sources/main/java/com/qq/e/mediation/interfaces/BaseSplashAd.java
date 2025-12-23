package com.qq.e.mediation.interfaces;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class BaseSplashAd implements IBaseAd {
    public static final int DEFAULT_PRIORITY = -1;

    public abstract void fetchAdOnly();

    public abstract void fetchFullScreenAdOnly();

    public int getAdapterPriority() {
        return -1;
    }

    public abstract String getECPMLevel();

    public abstract Bitmap getZoomOutBitmap();

    public abstract boolean isValid();

    public abstract void setADListener(ADListener aDListener);

    public abstract void setDeveloperLogo(int i6);

    public abstract void setDeveloperLogo(byte[] bArr);

    public abstract void setFetchDelay(int i6);

    public abstract void setLoadAdParams(LoadAdParams loadAdParams);

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void setSkipView(View view);

    public abstract void setSupportZoomOut(boolean z5);

    public abstract void showAd(ViewGroup viewGroup);

    public abstract void showFullScreenAd(ViewGroup viewGroup);

    public abstract void zoomOutAnimationFinish();

    public BaseSplashAd(Context context, String str, String str2, String str3) {
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
