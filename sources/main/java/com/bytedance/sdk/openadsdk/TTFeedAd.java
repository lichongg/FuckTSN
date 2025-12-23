package com.bytedance.sdk.openadsdk;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface TTFeedAd extends TTNativeAd {

    public interface CustomizeVideo {
        String getVideoUrl();

        void reportVideoAutoStart();

        void reportVideoBreak(long j6);

        void reportVideoContinue(long j6);

        void reportVideoError(long j6, int i6, int i7);

        void reportVideoFinish();

        void reportVideoPause(long j6);

        void reportVideoStart();

        void reportVideoStartError(int i6, int i7);
    }

    public interface VideoAdListener {
        void onProgressUpdate(long j6, long j7);

        void onVideoAdComplete(TTFeedAd tTFeedAd);

        void onVideoAdContinuePlay(TTFeedAd tTFeedAd);

        void onVideoAdPaused(TTFeedAd tTFeedAd);

        void onVideoAdStartPlay(TTFeedAd tTFeedAd);

        void onVideoError(int i6, int i7);

        void onVideoLoad(TTFeedAd tTFeedAd);
    }

    public interface VideoRewardListener {
        void onFeedRewardCountDown(int i6);
    }

    int getAdViewHeight();

    int getAdViewWidth();

    CustomizeVideo getCustomVideo();

    double getVideoDuration();

    void setVideoAdListener(VideoAdListener videoAdListener);

    void setVideoRewardListener(VideoRewardListener videoRewardListener);
}
