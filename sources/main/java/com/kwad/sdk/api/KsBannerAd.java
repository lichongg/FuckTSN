package com.kwad.sdk.api;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public interface KsBannerAd extends BaseKSAd {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsAdSdkApi
    @Keep
    public interface BannerAdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked();

        @KsAdSdkApi
        @Keep
        void onAdClose();

        @KsAdSdkApi
        @Keep
        void onAdShow();

        @KsAdSdkApi
        @Keep
        void onAdShowError(int i6, String str);
    }

    @KsAdSdkApi
    @Keep
    int getECPM();

    @KsAdSdkApi
    @Keep
    int getInteractionType();

    @KsAdSdkApi
    @Keep
    int getMaterialType();

    @KsAdSdkApi
    @Keep
    View getView(Context context, BannerAdInteractionListener bannerAdInteractionListener, KsAdVideoPlayConfig ksAdVideoPlayConfig);

    @KsAdSdkApi
    @Keep
    void reportAdExposureFailed(int i6, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    @Keep
    @Deprecated
    void setBidEcpm(int i6);

    @KsAdSdkApi
    @Keep
    void setBidEcpm(long j6, long j7);

    @KsAdSdkApi
    @Keep
    boolean supportPushAd();
}
