package com.kwad.components.offline.api.core.video;

import android.view.Surface;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineVideoPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.listener.VideoMuteStateChangeListener;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IKsMediaPlayer {
    void addOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener);

    void addOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener);

    void clear();

    boolean getAlphaVideoValid();

    int getBufferPercentage();

    String getCurrentPlayingUrl();

    long getCurrentPosition();

    long getDuration();

    int getMaxVolume();

    IMediaPlayer getMediaPlayer();

    int getMediaPlayerType();

    long getPlayDuration();

    String getStateString(int i6);

    int getVideoHeight();

    int getVideoWidth();

    int getVolume();

    void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, @NonNull IKsMediaPlayerView iKsMediaPlayerView);

    void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, boolean z5, boolean z6, @NonNull IKsMediaPlayerView iKsMediaPlayerView);

    boolean isPlaying();

    boolean isPrepared();

    boolean isPreparing();

    void notifyOnInfoListener(IMediaPlayer iMediaPlayer, int i6, int i7);

    void onPlayStateChanged(int i6);

    boolean pause();

    void prepareAsync();

    void registerVideoMuteStateListener(VideoMuteStateChangeListener videoMuteStateChangeListener);

    void registerVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener);

    void release();

    void release(ReleaseCallback releaseCallback);

    void release(ReleaseCallback releaseCallback, boolean z5);

    void releaseAsync();

    void removeInfoListener(IMediaPlayer.OnInfoListener onInfoListener);

    void resetAndPlay(PlayVideoInfo playVideoInfo);

    void restart();

    void resume();

    void seekTo(long j6);

    void setAudioEnabled(boolean z5);

    void setDataSource(@NonNull PlayVideoInfo playVideoInfo);

    void setForceGetAudioFocus(boolean z5);

    void setIsAlphaVideoPlayer(boolean z5);

    void setRadius(float f6, float f7, float f8, float f9);

    void setSpeed(float f6);

    void setSurface(Surface surface);

    void setTKPlayer();

    void setVideoAdaptStrategy(int i6);

    void setVolume(float f6, float f7);

    void start();

    void start(long j6);

    void stopAndPrepareAsync();

    void unRegisterVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener);

    void updateKsPlayLogParam(KsPlayerLogParams ksPlayerLogParams);
}
