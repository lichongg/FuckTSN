package com.kwad.components.core.h;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.offline.api.core.imageplayer.IImagePlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d implements IImagePlayer {
    private c QQ = new c();

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void destroy() {
        this.QQ.destroy();
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final FrameLayout getImagePlayerView(Context context) {
        return this.QQ.getImagePlayerView(context);
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void pause() {
        this.QQ.pause();
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void play() {
        this.QQ.play();
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void registerMediaPlayStateListener(OfflineMediaPlayStateListener offlineMediaPlayStateListener) {
        this.QQ.c(com.kwad.components.core.o.b.c.d.a(offlineMediaPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void resume() {
        this.QQ.resume();
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setDuration(long j6) {
        this.QQ.E(j6 * 1000);
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setHorizontalGravity(int i6) {
        this.QQ.setHorizontalGravity(i6);
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setImageResize(int i6) {
        if (i6 == 0) {
            this.QQ.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
            return;
        }
        if (i6 == 1) {
            this.QQ.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (i6 == 2) {
            this.QQ.setImageScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            if (i6 != 3) {
                return;
            }
            this.QQ.setImageScaleType(ImageView.ScaleType.CENTER);
        }
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setRadius(float f6, float f7, float f8, float f9) {
        this.QQ.setRadius(f6, f7, f8, f9);
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setSpeed(float f6) {
        this.QQ.setSpeed(f6);
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setURLs(List<String> list) {
        this.QQ.setURLs(list);
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setVerticalGravity(int i6) {
        this.QQ.setVerticalGravity(i6);
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void stop() {
        this.QQ.stop();
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void unregisterMediaPlayStateListener(OfflineMediaPlayStateListener offlineMediaPlayStateListener) {
        this.QQ.d(com.kwad.components.core.o.b.c.d.a(offlineMediaPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void prepareToPlay() {
    }

    @Override // com.kwad.components.offline.api.core.imageplayer.IImagePlayer
    public final void setEnableCache(boolean z5) {
    }
}
