package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.video.a.e;
import com.kwad.sdk.core.video.a.f;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.i;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends AdBasePvFrameLayout implements TextureView.SurfaceTextureListener, c {
    private static AtomicBoolean aKD = new AtomicBoolean(false);
    private int ZI;
    private com.kwad.sdk.core.video.a.c ZJ;
    private int ZK;
    private long ZL;
    private com.kwad.sdk.contentalliance.a.a.b ZN;
    private com.kwad.sdk.core.video.a aKA;
    private b aKB;
    private boolean aKC;
    private boolean aKE;
    private boolean aKF;
    private ImageView aKG;
    private AudioManager aKz;
    private c.e aaa;
    private c.i aab;
    private c.b aac;
    private c.InterfaceC0691c aad;
    private c.d aae;
    private c.a aaf;
    private SurfaceTexture aan;
    private TextView aao;
    private Surface aap;
    private InterfaceC0692a cz;
    private FrameLayout dm;
    private com.kwad.sdk.contentalliance.a.a.a fh;
    private Context mContext;
    private Map<String, String> mHeaders;
    private String mUrl;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.video.videoview.a$a, reason: collision with other inner class name */
    public interface InterfaceC0692a {
        com.kwad.sdk.core.video.a.c a(com.kwad.sdk.contentalliance.a.a.b bVar);
    }

    public a(Context context) {
        this(context, null);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    private a(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.ZI = 0;
        this.aKC = false;
        this.aKE = false;
        this.aKF = false;
        this.aaa = new c.e() { // from class: com.kwad.sdk.core.video.videoview.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    a.this.ZI = 2;
                    a.this.aKB.onPlayStateChanged(a.this.ZI);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                    cVar.start();
                    if (a.this.aKC) {
                        cVar.seekTo((int) ag.V(a.this.mContext, a.this.mUrl));
                    }
                    if (a.this.ZL != 0) {
                        cVar.seekTo((int) a.this.ZL);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.aab = new c.i() { // from class: com.kwad.sdk.core.video.videoview.a.2
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void l(int i6, int i7) {
                if (!a.this.aKF || i7 <= i6) {
                    a.this.aKA.adaptVideoSize(i6, i7);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i6 + "， height：" + i7);
                }
            }
        };
        this.aac = new c.b() { // from class: com.kwad.sdk.core.video.videoview.a.3
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void qK() {
                if (a.this.ZI != 9) {
                    a.this.ZI = 9;
                    a.this.aKB.onPlayStateChanged(a.this.ZI);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                    a.this.dm.setKeepScreenOn(false);
                }
            }
        };
        this.aad = new c.InterfaceC0691c() { // from class: com.kwad.sdk.core.video.videoview.a.4
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0691c
            public final boolean m(int i6, int i7) {
                if (i6 == -38) {
                    return true;
                }
                a.this.ZI = -1;
                a.this.aKB.o(i6, i7);
                a.this.aKB.onPlayStateChanged(a.this.ZI);
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i6 + ", extra: " + i7);
                return true;
            }
        };
        this.aae = new c.d() { // from class: com.kwad.sdk.core.video.videoview.a.5
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean n(int i6, int i7) {
                if (i6 == 3) {
                    a.this.ZI = 4;
                    a.this.aKB.onPlayStateChanged(a.this.ZI);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING");
                    return true;
                }
                if (i6 == 701) {
                    if (a.this.ZI == 5 || a.this.ZI == 7) {
                        a.this.ZI = 7;
                        com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    } else {
                        a.this.ZI = 6;
                        com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    }
                    a.this.aKB.onPlayStateChanged(a.this.ZI);
                    return true;
                }
                if (i6 == 702) {
                    if (a.this.ZI == 6) {
                        a.this.ZI = 4;
                        a.this.aKB.onPlayStateChanged(a.this.ZI);
                        com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (a.this.ZI != 7) {
                        return true;
                    }
                    a.this.ZI = 5;
                    a.this.aKB.onPlayStateChanged(a.this.ZI);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                    return true;
                }
                if (i6 == 10001) {
                    if (a.this.aKA == null) {
                        return true;
                    }
                    a.this.aKA.setRotation(i7);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "视频旋转角度：" + i7);
                    return true;
                }
                if (i6 == 801) {
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "视频不能seekTo，为直播视频");
                    return true;
                }
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> what：" + i6);
                return true;
            }
        };
        this.aaf = new c.a() { // from class: com.kwad.sdk.core.video.videoview.a.6
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void aK(int i6) {
                a.this.ZK = i6;
            }
        };
        this.mContext = context;
        init();
    }

    private ImageView Kc() {
        ImageView imageView = new ImageView(this.mContext);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        return imageView;
    }

    private boolean Kd() {
        return this.ZI == 6;
    }

    private void Kf() {
        if (this.ZJ == null) {
            f fVar = (f) ServiceProvider.get(f.class);
            boolean z5 = fVar != null && fVar.Bi();
            boolean z6 = fVar != null && fVar.Bj();
            InterfaceC0692a interfaceC0692a = this.cz;
            com.kwad.sdk.core.video.a.c a6 = interfaceC0692a != null ? interfaceC0692a.a(this.ZN) : null;
            if ((z5 && e.DH() && e.Kb()) || a6 == null) {
                this.ZJ = e.a(this.mContext, false, z5, z6, 0);
            } else {
                this.ZJ = a6;
            }
            this.ZJ.setAudioStreamType(3);
            if (this.aKE) {
                return;
            }
            this.ZJ.setVolume(0.0f, 0.0f);
        }
    }

    private void Kg() {
        this.dm.removeView(this.aKA);
        this.dm.addView(this.aKA, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void Kh() {
        if (!com.kwad.framework.c.a.oz.booleanValue() || this.ZJ == null || this.dm == null) {
            return;
        }
        if (this.aao == null) {
            this.aao = new TextView(this.mContext);
        }
        this.dm.removeView(this.aao);
        this.aao.setText(String.valueOf(this.ZJ.getMediaPlayerType()));
        this.aao.setTextColor(SupportMenu.CATEGORY_MASK);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        this.dm.addView(this.aao, r1.getChildCount() - 1, layoutParams);
    }

    private void Ki() {
        com.kwad.sdk.contentalliance.a.a.a aVar;
        this.dm.setKeepScreenOn(true);
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar == null) {
            com.kwad.sdk.core.d.c.w("KSVideoPlayerViewView", "mMediaPlayer is null");
            return;
        }
        cVar.b(this.aaa);
        this.ZJ.a(this.aab);
        this.ZJ.a(this.aac);
        this.ZJ.a(this.aad);
        this.ZJ.c(this.aae);
        this.ZJ.a(this.aaf);
        try {
            com.kwad.sdk.contentalliance.a.a.b bVar = this.ZN;
            if (bVar != null && (aVar = this.fh) != null) {
                bVar.awz = aVar;
            }
            this.ZJ.b(bVar);
            if (this.aap == null) {
                this.aap = new Surface(this.aan);
            }
            this.ZJ.setSurface(this.aap);
            if (this.ZJ.prepareAsync()) {
                this.ZI = 1;
                this.aKB.onPlayStateChanged(1);
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_PREPARING");
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            com.kwad.sdk.core.d.c.e("KSVideoPlayerViewView", "打开播放器发生错误", e6);
        }
    }

    private void Kj() {
        AudioManager audioManager = this.aKz;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this.aKz = null;
        }
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            cVar.release();
            this.ZJ = null;
            com.kwad.sdk.core.video.a.a.a.eE("videoFinishPlay");
        }
        bw.runOnUiThread(new bg() { // from class: com.kwad.sdk.core.video.videoview.a.7
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.dm.removeView(a.this.aKA);
            }
        });
        Surface surface = this.aap;
        if (surface != null) {
            surface.release();
            this.aap = null;
        }
        SurfaceTexture surfaceTexture = this.aan;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.aan = null;
        }
        this.ZI = 0;
    }

    private void eI(AdTemplate adTemplate) {
        i iVar = (i) ServiceProvider.get(i.class);
        if (iVar != null) {
            iVar.load(this.aKG, com.kwad.sdk.core.response.b.e.ep(adTemplate), adTemplate);
        }
    }

    private void setPlayType(int i6) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.a.a.b bVar = this.ZN;
        if (bVar == null || (videoPlayerStatus = bVar.videoPlayerStatus) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i6;
    }

    private void tH() {
        if (this.aKA == null) {
            com.kwad.sdk.core.video.a aVar = new com.kwad.sdk.core.video.a(this.mContext);
            this.aKA = aVar;
            aVar.setSurfaceTextureListener(this);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean Ke() {
        return this.ZI == 7;
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, Map<String, String> map) {
        this.ZN = bVar;
        this.mUrl = bVar.videoUrl;
        this.mHeaders = null;
        eI(bVar.adTemplate);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final int getBufferPercentage() {
        return this.ZK;
    }

    public final b getController() {
        return this.aKB;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMaxVolume() {
        AudioManager audioManager = this.aKz;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final int getMediaPlayerType() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.getMediaPlayerType();
        }
        return 0;
    }

    public final b getVideoController() {
        return this.aKB;
    }

    public final int getVolume() {
        AudioManager audioManager = this.aKz;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public final boolean isCompleted() {
        return this.ZI == 9;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isIdle() {
        return this.ZI == 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isPaused() {
        return this.ZI == 5;
    }

    public final boolean isPlaying() {
        return this.ZI == 4;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i6, int i7) {
        SurfaceTexture surfaceTexture2 = this.aan;
        if (surfaceTexture2 != null) {
            this.aKA.setSurfaceTexture(surfaceTexture2);
        } else {
            this.aan = surfaceTexture;
            Ki();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void pause() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar == null) {
            return;
        }
        int i6 = this.ZI;
        if (i6 == 4) {
            cVar.pause();
            com.kwad.sdk.core.video.a.a.a.eE("videoPausePlay");
            this.ZI = 5;
            this.aKB.onPlayStateChanged(5);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_PAUSED");
            return;
        }
        if (i6 == 6) {
            cVar.pause();
            com.kwad.sdk.core.video.a.a.a.eE("videoPausePlay");
            this.ZI = 7;
            this.aKB.onPlayStateChanged(7);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_BUFFERING_PAUSED");
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void release() {
        if (this.aKC) {
            if (isPlaying() || Kd() || Ke() || isPaused()) {
                ag.e(this.mContext, this.mUrl, getCurrentPosition());
            } else if (isCompleted()) {
                ag.e(this.mContext, this.mUrl, 0L);
            }
        }
        Kj();
        b bVar = this.aKB;
        if (bVar != null) {
            bVar.reset();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void restart() {
        int i6 = this.ZI;
        if (i6 == 5) {
            this.ZJ.start();
            com.kwad.sdk.core.video.a.a.a.eE("videoResumePlay");
            this.ZI = 4;
            this.aKB.onPlayStateChanged(4);
            setPlayType(2);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_PLAYING");
            return;
        }
        if (i6 == 7) {
            this.ZJ.start();
            com.kwad.sdk.core.video.a.a.a.eE("videoResumePlay");
            this.ZI = 6;
            this.aKB.onPlayStateChanged(6);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_BUFFERING_PLAYING");
            return;
        }
        if (i6 == 9 || i6 == -1) {
            this.ZJ.reset();
            Ki();
            setPlayType(3);
        } else {
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "KSVideoPlayer在状态为 " + this.ZI + " 时不能调用restart()方法.");
        }
    }

    public final void seekTo(int i6) {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            cVar.seekTo(i6);
        }
    }

    public final void setController(b bVar) {
        this.dm.removeView(this.aKB);
        this.aKB = bVar;
        bVar.reset();
        this.dm.addView(this.aKB, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void setExternalPlayerListener(InterfaceC0692a interfaceC0692a) {
        this.cz = interfaceC0692a;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void setKsPlayLogParam(@NonNull com.kwad.sdk.contentalliance.a.a.a aVar) {
        this.fh = aVar;
    }

    public final void setLooping(boolean z5) {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            cVar.setLooping(z5);
        }
    }

    public final void setPortraitFullscreen(boolean z5) {
        this.aKF = z5;
    }

    public final void setVideoSoundEnable(boolean z5) {
        this.aKE = z5;
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            if (z5) {
                cVar.setVolume(1.0f, 1.0f);
            } else {
                cVar.setVolume(0.0f, 0.0f);
            }
        }
    }

    public final void setVolume(int i6) {
        AudioManager audioManager = this.aKz;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i6, 0);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void start() {
        VideoPlayerStatus videoPlayerStatus;
        if (this.ZI != 0) {
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
            return;
        }
        Kf();
        tH();
        Kg();
        Kh();
        com.kwad.sdk.contentalliance.a.a.b bVar = this.ZN;
        if (bVar != null && (videoPlayerStatus = bVar.videoPlayerStatus) != null) {
            if (videoPlayerStatus.mVideoPlayerType == 0) {
                setPlayType(1);
            } else {
                setPlayType(3);
            }
        }
        com.kwad.sdk.core.video.a.a.a.eE("videoStartPlay");
    }

    private void init() {
        this.aKG = Kc();
        this.dm = new FrameLayout(this.mContext);
        addView(this.dm, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i6, int i7) {
    }
}
