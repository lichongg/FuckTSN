package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface TTNativeExpressAd extends TTClientBidding {

    public interface AdInteractionListener extends ExpressAdInteractionListener {
        void onAdDismiss();
    }

    public interface ExpressAdInteractionListener {
        void onAdClicked(View view, int i6);

        void onAdShow(View view, int i6);

        void onRenderFail(View view, String str, int i6);

        void onRenderSuccess(View view, float f6, float f7);
    }

    public interface ExpressVideoAdListener {
        void onClickRetry();

        void onProgressUpdate(long j6, long j7);

        void onVideoAdComplete();

        void onVideoAdContinuePlay();

        void onVideoAdPaused();

        void onVideoAdStartPlay();

        void onVideoError(int i6, int i7);

        void onVideoLoad();
    }

    void destroy();

    TTAdDislike getDislikeDialog(Activity activity);

    DislikeInfo getDislikeInfo();

    View getExpressAdView();

    int getImageMode();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    MediationNativeManager getMediationManager();

    void registerClickableRects(JSONObject jSONObject);

    void render();

    void setCanInterruptVideoPlay(boolean z5);

    void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setExpressInteractionListener(AdInteractionListener adInteractionListener);

    void setExpressInteractionListener(ExpressAdInteractionListener expressAdInteractionListener);

    void setSlideIntervalTime(int i6);

    void setVideoAdListener(ExpressVideoAdListener expressVideoAdListener);

    void showInteractionExpressAd(Activity activity);

    void unRegisterRects();

    void uploadDislikeEvent(String str);
}
