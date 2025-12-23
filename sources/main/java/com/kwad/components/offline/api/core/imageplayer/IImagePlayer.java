package com.kwad.components.offline.api.core.imageplayer;

import android.content.Context;
import android.widget.FrameLayout;
import com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IImagePlayer {
    void destroy();

    FrameLayout getImagePlayerView(Context context);

    void pause();

    void play();

    void prepareToPlay();

    void registerMediaPlayStateListener(OfflineMediaPlayStateListener offlineMediaPlayStateListener);

    void resume();

    void setDuration(long j6);

    void setEnableCache(boolean z5);

    void setHorizontalGravity(int i6);

    void setImageResize(int i6);

    void setRadius(float f6, float f7, float f8, float f9);

    void setSpeed(float f6);

    void setURLs(List<String> list);

    void setVerticalGravity(int i6);

    void stop();

    void unregisterMediaPlayStateListener(OfflineMediaPlayStateListener offlineMediaPlayStateListener);
}
