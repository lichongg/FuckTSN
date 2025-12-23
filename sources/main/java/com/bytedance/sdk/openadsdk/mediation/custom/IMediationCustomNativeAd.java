package com.bytedance.sdk.openadsdk.mediation.custom;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface IMediationCustomNativeAd {
    void callAdClick();

    void callAdShow();

    void callDislikeCancel();

    void callDislikeSelected(int i6, String str);

    void callDislikeShow();

    void callOnDownloadActive(long j6, long j7);

    void callOnDownloadFailed(long j6, long j7, String str, String str2);

    void callOnDownloadFinished(long j6, String str, String str2);

    void callOnDownloadPaused(long j6, long j7, String str, String str2);

    void callOnIdle();

    void callOnInstalled(String str, String str2);

    void callRenderFail(View view, int i6, String str);

    void callRenderSuccess(float f6, float f7);

    void callVideoCompleted();

    void callVideoError(int i6, String str);

    void callVideoPause();

    void callVideoProgressUpdate(long j6, long j7);

    void callVideoResume();

    void callVideoStart();

    int getBiddingType();

    View getExpressView();

    TTFeedAd.CustomizeVideo getNativeCustomVideoReporter();

    String getVideoUrl();

    boolean hasDislike();

    boolean isClientBidding();

    MediationConstant.AdIsReadyStatus isReadyCondition();

    boolean isServerBidding();

    boolean isUseCustomVideo();

    void onDestroy();

    void onPause();

    void onResume();

    void receiveBidResult(boolean z5, double d6, int i6, Map<String, Object> map);

    void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder);

    void render();

    void setActionText(String str);

    void setAdImageMode(int i6);

    void setBiddingPrice(double d6);

    void setDescription(String str);

    void setDislikeDialogCallBack(MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog);

    void setExpressAd(boolean z5);

    void setIconUrl(String str);

    void setImageHeight(int i6);

    void setImageList(List<String> list);

    void setImageUrl(String str);

    void setImageWidth(int i6);

    void setInteractionType(int i6);

    void setMediaExtraInfo(Map<String, Object> map);

    void setNativeAdAppInfo(MediationNativeAdAppInfo mediationNativeAdAppInfo);

    void setPackageName(String str);

    void setSource(String str);

    void setStarRating(double d6);

    void setTitle(String str);

    void setVideoHeight(int i6);

    void setVideoWidth(int i6);
}
