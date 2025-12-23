package com.kwad.components.offline.api.core.video;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IKsMediaPlayerView {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface VideoViewClickListener {
        void onClickRootView();

        void onClickVideoView();
    }

    void adaptVideoSize(int i6, int i7);

    void fixWidth(boolean z5);

    int getTextureViewGravity();

    void setAd(boolean z5);

    void setClickListener(VideoViewClickListener videoViewClickListener);

    void setForce(boolean z5);

    void setHorizontalVideo(boolean z5);

    void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer);

    void setRadius(float f6);

    void updateTextureViewGravity(int i6);
}
