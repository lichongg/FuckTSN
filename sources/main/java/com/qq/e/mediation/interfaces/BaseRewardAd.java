package com.qq.e.mediation.interfaces;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class BaseRewardAd implements IBaseAd {
    public static final int DEFAULT_PRIORITY = -1;

    /* renamed from: a, reason: collision with root package name */
    private LoadAdParams f36809a = null;

    public int getAdapterPriority() {
        return -1;
    }

    public abstract String getECPMLevel();

    @Deprecated
    public abstract long getExpireTimestamp();

    public int getRewardAdType() {
        return 0;
    }

    public abstract int getVideoDuration();

    public abstract boolean hasShown();

    public abstract boolean isValid();

    public abstract void loadAD();

    public abstract void setAdListener(ADListener aDListener);

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void setVolumeOn(boolean z5);

    public abstract void showAD();

    public void showAD(Activity activity) {
        showAD();
    }

    public LoadAdParams getLoadAdParams() {
        return this.f36809a;
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f36809a = loadAdParams;
    }

    public BaseRewardAd(Context context, String str, String str2, String str3) {
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
