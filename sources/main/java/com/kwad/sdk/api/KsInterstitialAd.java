package com.kwad.sdk.api;

import android.app.Activity;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public interface KsInterstitialAd extends BaseKSAd {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsAdSdkApi
    @Keep
    public interface AdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked();

        @KsAdSdkApi
        @Keep
        void onAdClosed();

        @KsAdSdkApi
        @Keep
        void onAdShow();

        @KsAdSdkApi
        @Keep
        void onPageDismiss();

        @KsAdSdkApi
        @Keep
        void onSkippedAd();

        @KsAdSdkApi
        @Keep
        void onVideoPlayEnd();

        @KsAdSdkApi
        @Keep
        void onVideoPlayError(int i6, int i7);

        @KsAdSdkApi
        @Keep
        void onVideoPlayStart();
    }

    @KsAdSdkApi
    @Keep
    int getECPM();

    @Keep
    int getInteractionType();

    @Keep
    int getMaterialType();

    @KsAdSdkApi
    @Keep
    @Deprecated
    boolean isVideo();

    @KsAdSdkApi
    @Keep
    void reportAdExposureFailed(int i6, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    @Keep
    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @Keep
    @Deprecated
    void setBidEcpm(int i6);

    @KsAdSdkApi
    @Keep
    void setBidEcpm(long j6, long j7);

    @KsAdSdkApi
    @Keep
    void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig);
}
