package com.kwad.sdk.api;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public interface KsFeedAd extends BaseKSAd {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsAdSdkApi
    @Keep
    public interface AdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked();

        @KsAdSdkApi
        @Keep
        void onAdShow();

        @KsAdSdkApi
        @Keep
        void onDislikeClicked();

        @KsAdSdkApi
        @Keep
        void onDownloadTipsDialogDismiss();

        @KsAdSdkApi
        @Keep
        void onDownloadTipsDialogShow();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsAdSdkApi
    @Keep
    public interface AdRenderListener {
        @KsAdSdkApi
        @Keep
        void onAdRenderFailed(int i6, String str);

        @KsAdSdkApi
        @Keep
        void onAdRenderSuccess(View view);
    }

    @KsAdSdkApi
    @Keep
    int getECPM();

    @Nullable
    @KsAdSdkApi
    @Keep
    View getFeedView(Context context);

    @KsAdSdkApi
    @Keep
    int getInteractionType();

    @KsAdSdkApi
    @Keep
    int getMaterialType();

    @KsAdSdkApi
    @Keep
    void render(AdRenderListener adRenderListener);

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
    void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig);

    @KsAdSdkApi
    @Keep
    void setVideoSoundEnable(boolean z5);
}
