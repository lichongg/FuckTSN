package com.kwad.components.core.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g extends com.kwad.sdk.core.video.a.a {
    private static AtomicBoolean aaP = new AtomicBoolean(false);
    private String aaL;
    private com.kwad.components.core.o.a.a.a aaN;
    private IAdWaynePlayerPlayModule aaO;
    private AdTemplate mAdTemplate;
    private final String TAG = "KwaiWaynePlayer";
    private final Object aaK = new Object();
    private boolean aaQ = false;
    private boolean aaR = false;
    private boolean aaS = false;
    private final a aaM = new a(this, "KwaiWaynePlayer");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements IAdWaynePlayerPlayModule.OnBufferingUpdateListener, IAdWaynePlayerPlayModule.OnCompletionListener, IAdWaynePlayerPlayModule.OnErrorListener, IAdWaynePlayerPlayModule.OnInfoListener, IAdWaynePlayerPlayModule.OnPreparedListener, IAdWaynePlayerPlayModule.OnSeekCompleteListener, IAdWaynePlayerPlayModule.OnVideoSizeChangedListener, IAdWaynePlayerPlayModule.OnVseReportListener {
        final String TAG;
        final WeakReference<g> mWeakMediaPlayer;

        private g tZ() {
            return this.mWeakMediaPlayer.get();
        }

        a(g gVar, String str) {
            this.mWeakMediaPlayer = new WeakReference<>(gVar);
            this.TAG = str;
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnBufferingUpdateListener
        public final void onBufferingUpdate(int i6) {
            g tZ = tZ();
            if (tZ != null) {
                tZ.notifyOnBufferingUpdate(i6);
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnCompletionListener
        public final void onCompletion() {
            g tZ = tZ();
            if (tZ != null) {
                tZ.notifyOnCompletion();
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnErrorListener
        public final boolean onError(int i6, int i7) {
            g tZ = tZ();
            if (tZ != null) {
                return tZ.notifyOnError(i6, i7);
            }
            return false;
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnInfoListener
        public final boolean onInfo(int i6, int i7) {
            g tZ = tZ();
            if (tZ == null) {
                return false;
            }
            if (i6 != 3) {
                return tZ.notifyOnInfo(i6, i7);
            }
            if (tZ.aaS) {
                return false;
            }
            g.a(tZ, true);
            return tZ.notifyOnInfo(i6, i7);
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnPreparedListener
        public final void onPrepared() {
            g tZ = tZ();
            if (tZ != null) {
                tZ.notifyOnPrepared();
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnSeekCompleteListener
        public final void onSeekComplete() {
            g tZ = tZ();
            if (tZ != null) {
                tZ.notifyOnSeekComplete();
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(int i6, int i7) {
            g tZ = tZ();
            if (tZ != null) {
                tZ.x(i6, i7);
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnVseReportListener
        public final void onVseReport(String str, String str2) {
            g tZ = tZ();
            if (tZ != null) {
                tZ.n(str, str2);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 3;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        this.aaR = false;
        try {
            IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
            if (iAdWaynePlayerPlayModule != null) {
                iAdWaynePlayerPlayModule.reset();
                resetListeners();
                tX();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
    }

    public static boolean isWaynePlayerReady() {
        return aaP.get();
    }

    private void tX() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setOnPreparedListener(this.aaM);
            this.aaO.setOnCompletionListener(this.aaM);
            this.aaO.setOnBufferingUpdateListener(this.aaM);
            this.aaO.setOnSeekCompleteListener(this.aaM);
            this.aaO.setOnVideoSizeChangedListener(this.aaM);
            this.aaO.setOnErrorListener(this.aaM);
            this.aaO.setOnInfoListener(this.aaM);
            this.aaO.setOnVseReportListener(this.aaM);
        }
    }

    private void tY() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setOnPreparedListener(null);
            this.aaO.setOnCompletionListener(null);
            this.aaO.setOnBufferingUpdateListener(null);
            this.aaO.setOnSeekCompleteListener(null);
            this.aaO.setOnVideoSizeChangedListener(null);
            this.aaO.setOnErrorListener(null);
            this.aaO.setOnInfoListener(null);
            this.aaO.setOnVseReportListener(null);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getAudioSessionId();
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        return iAdWaynePlayerPlayModule != null ? iAdWaynePlayerPlayModule.getCurrentPlayingUrl() : "";
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.aaL;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getDuration();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getVideoHeight();
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getVideoWidth();
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.isLooping();
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.isPlaying();
        }
        return false;
    }

    public final void n(String str, String str2) {
        final com.kwad.components.core.video.a.e eVar = new com.kwad.components.core.video.a.e();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            eVar.setAdTemplate(adTemplate);
        }
        eVar.aN(str);
        eVar.aO(str2);
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.core.video.g.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.w(eVar);
            }
        });
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        if (this.aaO != null) {
            com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "pause");
            this.aaO.pause();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule;
        if (!this.aaR && (iAdWaynePlayerPlayModule = this.aaO) != null) {
            try {
                this.aaR = true;
                boolean prepareAsync = iAdWaynePlayerPlayModule.prepareAsync();
                JV();
                com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "prepareAsync result: " + prepareAsync);
                return prepareAsync;
            } catch (IllegalStateException e6) {
                com.kwad.sdk.core.d.c.e("KwaiWaynePlayer", "prepareAsync failed ", e6);
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            this.aaQ = true;
            iAdWaynePlayerPlayModule.release();
            try {
                resetListeners();
                tY();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j6) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.seekTo(j6);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i6) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setAudioStreamType(i6);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule;
        synchronized (this.aaK) {
            try {
                if (!this.aaQ && (iAdWaynePlayerPlayModule = this.aaO) != null) {
                    iAdWaynePlayerPlayModule.setDisplay(surfaceHolder);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z5) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setLooping(z5);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f6) {
        try {
            IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
            if (iAdWaynePlayerPlayModule != null) {
                iAdWaynePlayerPlayModule.setSpeed(f6);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setSurface(surface);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f6, float f7) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setVolume(f6, f7);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        if (this.aaO != null) {
            com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "start");
            this.aaO.start();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        if (this.aaO != null) {
            com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "stop");
            this.aaO.stop();
        }
    }

    public g(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        com.kwad.components.core.o.a.a.a aVar = (com.kwad.components.core.o.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.a.a.class);
        this.aaN = aVar;
        if (aVar != null && aVar.qt()) {
            if (!TextUtils.isEmpty(bVar.manifest)) {
                String str = bVar.manifest;
                this.aaL = str;
                this.aaO = this.aaN.getAdWaynePlayerPlayModule(str, true);
            } else {
                String str2 = bVar.videoUrl;
                this.aaL = str2;
                this.aaO = this.aaN.getAdWaynePlayerPlayModule(str2, false);
            }
            if (this.aaO != null) {
                aaP.set(true);
                this.aaO.setLooping(false);
                tX();
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        if (this.aaO != null) {
            if (!TextUtils.isEmpty(bVar.manifest)) {
                String str = bVar.manifest;
                this.aaL = str;
                this.aaO.setDataSource(str, true);
            } else {
                String str2 = bVar.videoUrl;
                this.aaL = str2;
                this.aaO.setDataSource(str2, false);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean tW() {
        return prepareAsync();
    }

    static /* synthetic */ boolean a(g gVar, boolean z5) {
        gVar.aaS = true;
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        if (this.aaO != null) {
            this.aaL = str;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(master.flame.danmaku.danmaku.parser.b.f50156c)) {
                this.aaO.setDataSource(parse.getPath(), false);
            } else {
                this.aaO.setDataSource(str, false);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z5) {
    }
}
