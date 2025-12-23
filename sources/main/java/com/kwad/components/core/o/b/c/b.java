package com.kwad.components.core.o.b.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.video.BaseKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.sdk.utils.ax;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class b extends BaseKsMediaPlayerView {
    private DetailVideoView SB;

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void adaptVideoSize(int i6, int i7) {
        this.SB.adaptVideoSize(i6, i7);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void fixWidth(boolean z5) {
        this.SB.fixWidth(z5);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final int getTextureViewGravity() {
        return this.SB.getTextureViewGravity();
    }

    public final DetailVideoView qI() {
        return this.SB;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setAd(boolean z5) {
        this.SB.setAd(z5);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setClickListener(final IKsMediaPlayerView.VideoViewClickListener videoViewClickListener) {
        this.SB.setClickListener(videoViewClickListener == null ? null : new DetailVideoView.a() { // from class: com.kwad.components.core.o.b.c.b.1
            @Override // com.kwad.components.core.video.DetailVideoView.a
            public final void onClickRootView() {
                videoViewClickListener.onClickRootView();
            }

            @Override // com.kwad.components.core.video.DetailVideoView.a
            public final void onClickVideoView() {
                videoViewClickListener.onClickVideoView();
            }
        });
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setForce(boolean z5) {
        this.SB.setForce(z5);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setHorizontalVideo(boolean z5) {
        this.SB.setHorizontalVideo(z5);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer) {
        if (!(iKsMediaPlayer instanceof a)) {
            throw new IllegalArgumentException("mediaPlayer not instanceof KsMediaPlayer");
        }
        this.SB.setMediaPlayer(((a) iKsMediaPlayer).qG());
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setRadius(float f6) {
        this.SB.setRadius(f6);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void updateTextureViewGravity(int i6) {
        this.SB.updateTextureViewGravity(i6);
    }

    public b(Context context) {
        super(context);
    }

    public final b b(@NonNull DetailVideoView detailVideoView) {
        ax.checkNotNull(detailVideoView);
        addView(detailVideoView);
        this.SB = detailVideoView;
        return this;
    }
}
