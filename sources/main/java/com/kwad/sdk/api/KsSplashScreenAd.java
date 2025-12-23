package com.kwad.sdk.api;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public interface KsSplashScreenAd extends BaseKSAd {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsAdSdkApi
    @Keep
    public interface SplashScreenAdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked();

        @KsAdSdkApi
        @Keep
        void onAdShowEnd();

        @KsAdSdkApi
        @Keep
        void onAdShowError(int i6, String str);

        @KsAdSdkApi
        @Keep
        void onAdShowStart();

        @KsAdSdkApi
        @Keep
        void onDownloadTipsDialogCancel();

        @KsAdSdkApi
        @Keep
        void onDownloadTipsDialogDismiss();

        @KsAdSdkApi
        @Keep
        void onDownloadTipsDialogShow();

        @KsAdSdkApi
        @Keep
        void onSkippedAd();
    }

    @KsAdSdkApi
    @Keep
    int getECPM();

    @KsAdSdkApi
    @Keep
    int getInteractionType();

    @KsAdSdkApi
    @Keep
    KSAdInfoData getKSAdInfoData();

    @KsAdSdkApi
    @Keep
    int getMaterialType();

    @KsAdSdkApi
    @Keep
    View getView(Context context, SplashScreenAdInteractionListener splashScreenAdInteractionListener);

    @KsAdSdkApi
    @Keep
    boolean isAdEnable();

    @KsAdSdkApi
    @Keep
    @Deprecated
    boolean isVideo();

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
}
