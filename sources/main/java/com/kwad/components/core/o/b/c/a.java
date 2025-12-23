package com.kwad.components.core.o.b.c;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineVideoPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.listener.VideoMuteStateChangeListener;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class a implements IKsMediaPlayer {
    private boolean Bj;
    private OfflineOnAudioConflictListener Bm;
    private com.kwad.components.core.video.b Su;
    private c Sv;
    private VideoMuteStateChangeListener Sw;
    private boolean Sx;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private boolean pW = true;
    private int Sy = -1;

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getMaxVolume() {
        return 0;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVolume() {
        return 0;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, @NonNull IKsMediaPlayerView iKsMediaPlayerView) {
        if (!(iKsMediaPlayerView instanceof b)) {
            com.kwad.sdk.core.d.c.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
            return;
        }
        DetailVideoView qI = ((b) iKsMediaPlayerView).qI();
        this.mDetailVideoView = qI;
        this.mContext = StubApp.getOrigApplicationContext(qI.getContext().getApplicationContext());
        this.Su.a(d.a(playVideoInfo), this.mDetailVideoView);
        int i6 = this.Sy;
        if (i6 != -1) {
            setVideoAdaptStrategy(i6);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release(ReleaseCallback releaseCallback, boolean z5) {
        this.Su.a(d.a(releaseCallback), z5);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void start() {
        this.Su.start();
    }

    static /* synthetic */ boolean b(a aVar, boolean z5) {
        aVar.pW = false;
        return false;
    }

    private OfflineOnAudioConflictListener qH() {
        if (this.Bm == null) {
            this.Bm = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.o.b.c.a.2
                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public final void onAudioBeOccupied() {
                    if (a.this.pW) {
                        a.this.Bj = true;
                        a.b(a.this, false);
                    }
                    bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.o.b.c.a.2.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            a.this.Su.setAudioEnabled(false);
                            if (a.this.Sw != null) {
                                a.this.Sw.onMuteStateChanged(true);
                            }
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public final void onAudioBeReleased() {
                    a.this.Bj = false;
                }
            };
        }
        return this.Bm;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void addOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.Su.a(d.a(getMediaPlayer(), onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void addOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.Su.a(d.a(getMediaPlayer(), onPreparedListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void clear() {
        this.Su.clear();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean getAlphaVideoValid() {
        return this.Su.getAlphaVideoValid();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getBufferPercentage() {
        return this.Su.getBufferPercentage();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final String getCurrentPlayingUrl() {
        return this.Su.getCurrentPlayingUrl();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getCurrentPosition() {
        return this.Su.getCurrentPosition();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getDuration() {
        return this.Su.getDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final IMediaPlayer getMediaPlayer() {
        com.kwad.sdk.core.video.a.c tz = this.Su.tz();
        if (tz == null) {
            return null;
        }
        c cVar = this.Sv;
        if (cVar == null || cVar.qJ() != tz) {
            this.Sv = new c().b(tz);
        }
        return this.Sv;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getMediaPlayerType() {
        return this.Su.getMediaPlayerType();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getPlayDuration() {
        return this.Su.getPlayDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVideoHeight() {
        return this.Su.getVideoHeight();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVideoWidth() {
        return this.Su.getVideoWidth();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPlaying() {
        return this.Su.isPlaying();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPrepared() {
        return this.Su.isPrepared();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPreparing() {
        return this.Su.isPreparing();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void notifyOnInfoListener(IMediaPlayer iMediaPlayer, int i6, int i7) {
        if (iMediaPlayer instanceof c) {
            this.Su.a(((c) iMediaPlayer).qJ(), i6, i7);
        } else {
            com.kwad.sdk.core.d.c.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void onPlayStateChanged(int i6) {
        this.Su.onPlayStateChanged(i6);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean pause() {
        return this.Su.pause();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void prepareAsync() {
        this.Su.prepareAsync();
    }

    public final com.kwad.components.core.video.b qG() {
        return this.Su;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void registerVideoMuteStateListener(VideoMuteStateChangeListener videoMuteStateChangeListener) {
        this.Sw = videoMuteStateChangeListener;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void registerVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener) {
        this.Su.c(d.a(offlineVideoPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release(ReleaseCallback releaseCallback) {
        this.Su.a(d.a(releaseCallback));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void releaseAsync() {
        Context context = this.mContext;
        if (context != null) {
            com.kwad.components.core.t.a.aC(context).b(this.Bm);
        }
        this.Su.releaseAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void removeInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.Su.b(d.a(getMediaPlayer(), onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void resetAndPlay(PlayVideoInfo playVideoInfo) {
        com.kwad.components.core.video.b bVar = this.Su;
        d.a(playVideoInfo);
        bVar.tC();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void restart() {
        this.Su.restart();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void resume() {
        this.Su.resume();
        if (this.pW || (this.Sx && this.Bj)) {
            Context context = this.mContext;
            if (context != null) {
                com.kwad.components.core.t.a.aC(context).aQ(this.Sx);
            }
            if (this.Sx && this.Bj) {
                this.Bj = false;
                setAudioEnabled(true);
                this.pW = true;
            } else if (this.Bj) {
                setAudioEnabled(false);
            }
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void seekTo(long j6) {
        this.Su.seekTo(j6);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setAudioEnabled(final boolean z5) {
        Context context;
        if (z5 && (context = this.mContext) != null) {
            com.kwad.components.core.t.a.aC(context).aQ(true);
        }
        if (z5 == this.pW) {
            com.kwad.sdk.core.video.a.a.a.eE("autoVoice");
        } else {
            this.pW = z5;
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.o.b.c.a.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    a.this.Su.setAudioEnabled(z5);
                    if (a.this.Sw != null) {
                        a.this.Sw.onMuteStateChanged(!z5);
                    }
                }
            });
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setDataSource(@NonNull PlayVideoInfo playVideoInfo) {
        this.Su.b(d.a(playVideoInfo));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setForceGetAudioFocus(boolean z5) {
        this.Sx = z5;
        Context context = this.mContext;
        if (context != null) {
            com.kwad.components.core.t.a.aC(context).a(qH());
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setIsAlphaVideoPlayer(boolean z5) {
        this.Su.setIsAlphaVideoPlayer(z5);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setRadius(float f6, float f7, float f8, float f9) {
        this.Su.setRadius(f6, f7, f8, f9);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setSpeed(float f6) {
        this.Su.setSpeed(f6);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setSurface(Surface surface) {
        this.Su.setSurface(surface);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setTKPlayer() {
        this.Su.setTKPlayer();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setVideoAdaptStrategy(int i6) {
        this.Sy = i6;
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.g(true, i6);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setVolume(float f6, float f7) {
        this.Su.setVolume(f6, f7);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void start(long j6) {
        this.Su.start(j6);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void stopAndPrepareAsync() {
        this.Su.stopAndPrepareAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void unRegisterVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener) {
        this.Su.d(d.a(offlineVideoPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void updateKsPlayLogParam(KsPlayerLogParams ksPlayerLogParams) {
        this.Su.a(d.a(ksPlayerLogParams));
    }

    a() {
    }

    public final a a(@NonNull com.kwad.components.core.video.b bVar) {
        ax.checkNotNull(bVar);
        this.Su = bVar;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final String getStateString(int i6) {
        return com.kwad.components.core.video.b.getStateString(i6);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release() {
        this.Su.release();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, boolean z5, boolean z6, @NonNull IKsMediaPlayerView iKsMediaPlayerView) {
        if (!(iKsMediaPlayerView instanceof b)) {
            com.kwad.sdk.core.d.c.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
        } else {
            this.Su.a(d.a(playVideoInfo), z5, z6, ((b) iKsMediaPlayerView).qI());
        }
    }
}
