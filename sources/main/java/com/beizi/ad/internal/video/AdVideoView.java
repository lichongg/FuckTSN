package com.beizi.ad.internal.video;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.AssetFileDescriptor;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.beizi.ad.internal.activity.b;
import com.beizi.ad.internal.h;
import com.beizi.ad.internal.h.o;
import com.beizi.ad.internal.h.s;
import com.beizi.ad.internal.h.u;
import com.beizi.ad.internal.video.a;
import com.beizi.ad.internal.view.AdViewImpl;
import com.beizi.ad.internal.view.AdWebView;
import com.beizi.ad.internal.view.InterstitialAdViewImpl;
import com.beizi.ad.internal.view.c;
import com.beizi.ad.model.f;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AdVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, c {

    /* renamed from: a, reason: collision with root package name */
    protected MediaPlayer f12363a;

    /* renamed from: b, reason: collision with root package name */
    protected a.b f12364b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12365c;

    /* renamed from: d, reason: collision with root package name */
    private int f12366d;

    /* renamed from: e, reason: collision with root package name */
    private int f12367e;

    /* renamed from: f, reason: collision with root package name */
    private int f12368f;

    /* renamed from: g, reason: collision with root package name */
    private int f12369g;

    /* renamed from: h, reason: collision with root package name */
    private int f12370h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f12371i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f12372j;

    /* renamed from: k, reason: collision with root package name */
    private a f12373k;

    /* renamed from: l, reason: collision with root package name */
    private Pair<String, Integer> f12374l;

    /* renamed from: m, reason: collision with root package name */
    private int f12375m;
    public AdWebView mAdWebView;

    /* renamed from: n, reason: collision with root package name */
    private long f12376n;

    /* renamed from: o, reason: collision with root package name */
    private float f12377o;

    /* renamed from: p, reason: collision with root package name */
    private float f12378p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f12379q;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum a {
        NRF_NONE,
        NRF_START,
        NRF_PAUSE
    }

    private void setDataSource(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        assetFileDescriptor.close();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void prepare(@Nullable MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        this.f12363a.setOnPreparedListener(onPreparedListener);
        this.f12363a.prepare();
    }

    public void prepareAsync(@Nullable MediaPlayer.OnPreparedListener onPreparedListener) throws IllegalStateException {
        this.f12363a.setOnPreparedListener(onPreparedListener);
        this.f12363a.prepareAsync();
    }

    public AdVideoView(AdWebView adWebView) {
        super(new MutableContextWrapper(adWebView.getContextFromMutableContext()));
        this.f12365c = false;
        this.f12371i = false;
        this.f12372j = false;
        this.f12373k = a.NRF_NONE;
        this.f12374l = null;
        this.f12364b = a.b.FIT_CENTER;
        this.f12375m = -1;
        this.mAdWebView = adWebView;
    }

    private void b(int i6, int i7) {
        if (i6 == 0 && i7 == 0) {
            onResume();
            this.f12371i = true;
        } else {
            onPause();
            this.f12371i = false;
        }
    }

    @Override // com.beizi.ad.internal.view.c
    public boolean failed() {
        return this.f12365c;
    }

    public AdWebView getAdWebView() {
        return this.mAdWebView;
    }

    @Override // com.beizi.ad.internal.view.c
    public int getCreativeHeight() {
        return this.f12369g;
    }

    public int getCreativeLeft() {
        return this.f12366d;
    }

    public int getCreativeTop() {
        return this.f12367e;
    }

    @Override // com.beizi.ad.internal.view.c
    public int getCreativeWidth() {
        return this.f12368f;
    }

    public int getCurrentPosition() {
        return this.f12363a.getCurrentPosition();
    }

    public int getDuration() {
        return this.f12363a.getDuration();
    }

    @Override // com.beizi.ad.internal.view.c
    public int getRefreshInterval() {
        return this.f12370h;
    }

    public int getVideoHeight() {
        return this.f12363a.getVideoHeight();
    }

    public int getVideoWidth() {
        return this.f12363a.getVideoWidth();
    }

    public boolean isLooping() {
        return this.f12363a.isLooping();
    }

    public boolean isPlaying() {
        return this.f12363a.isPlaying();
    }

    @Override // com.beizi.ad.internal.view.c
    public void onPause() {
        if (this.f12373k == a.NRF_START) {
            pause();
            this.f12373k = a.NRF_PAUSE;
        }
    }

    @Override // com.beizi.ad.internal.view.c
    public void onResume() {
        if (this.f12373k == a.NRF_PAUSE) {
            start(1);
            this.f12373k = a.NRF_START;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i6, int i7) {
        Surface surface = new Surface(surfaceTexture);
        MediaPlayer mediaPlayer = this.f12363a;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    public void pause() {
        MediaPlayer mediaPlayer = this.f12363a;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            this.mAdWebView.ad.a(this);
        }
    }

    public void reset() {
        this.f12363a.reset();
    }

    public void seekTo(int i6) {
        MediaPlayer mediaPlayer = this.f12363a;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i6);
        }
    }

    public void setCreativeLeft(int i6) {
        this.f12366d = i6;
    }

    public void setCreativeTop(int i6) {
        this.f12367e = i6;
    }

    public void setLooping(boolean z5) {
        MediaPlayer mediaPlayer = this.f12363a;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z5);
        }
    }

    public void setOnCompletionListener(@Nullable MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f12363a.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(@Nullable MediaPlayer.OnErrorListener onErrorListener) {
        this.f12363a.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(@Nullable MediaPlayer.OnInfoListener onInfoListener) {
        this.f12363a.setOnInfoListener(onInfoListener);
    }

    public void setRefreshInterval(int i6) {
        this.f12370h = i6;
    }

    public void setScalableType(a.b bVar) {
        this.f12364b = bVar;
        a(getVideoWidth(), getVideoHeight());
    }

    public void setVolume(float f6, float f7) {
        MediaPlayer mediaPlayer = this.f12363a;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f6, f7);
        }
    }

    public void start(int i6) {
        MediaPlayer mediaPlayer = this.f12363a;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.mAdWebView.ad.a(this, i6);
        }
    }

    public void stop() {
        MediaPlayer mediaPlayer = this.f12363a;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public boolean toggleMute() {
        boolean z5 = this.f12372j;
        this.f12372j = !z5;
        if (z5) {
            setVolume(1.0f, 1.0f);
        } else {
            setVolume(0.0f, 0.0f);
        }
        return this.f12372j;
    }

    @Override // com.beizi.ad.internal.view.c
    public void visible() {
        AdVideoView adVideoView;
        this.mAdWebView.setVisibility(0);
        this.mAdWebView.adViewImpl.showAdLogo(this);
        AdWebView adWebView = this.mAdWebView;
        if (adWebView == null || !adWebView.shouldDisplayButton()) {
            return;
        }
        AdWebView adWebView2 = this.mAdWebView;
        if (adWebView2.adViewImpl != null) {
            int autoCloseTime = adWebView2.getAutoCloseTime();
            int i6 = this.f12375m;
            if (autoCloseTime > i6) {
                AdWebView adWebView3 = this.mAdWebView;
                adVideoView = this;
                adWebView3.adViewImpl.addCloseButton(i6, adWebView3.getShowCloseBtnTime(), this.f12375m, adVideoView, this.mAdWebView.ad.x() == f.a.ADP_IVIDEO);
            } else {
                adVideoView = this;
                AdWebView adWebView4 = adVideoView.mAdWebView;
                adWebView4.adViewImpl.addCloseButton(i6, adWebView4.getShowCloseBtnTime(), adVideoView.mAdWebView.getAutoCloseTime(), adVideoView, adVideoView.mAdWebView.ad.x() == f.a.ADP_IVIDEO);
                adVideoView.mAdWebView.adViewImpl.addMuteButton(this, adVideoView.f12372j);
            }
        } else {
            adVideoView = this;
        }
        AdViewImpl adViewImpl = adVideoView.mAdWebView.adViewImpl;
        if (adViewImpl == null || adViewImpl.getAdDispatcher() == null) {
            return;
        }
        adVideoView.mAdWebView.adViewImpl.getAdDispatcher().a();
        AdWebView adWebView5 = adVideoView.mAdWebView;
        adWebView5.ad.a(this, adWebView5.adViewImpl.getAdParameters().a());
    }

    @Override // com.beizi.ad.internal.view.c
    public void destroy() {
        stop();
        u.a(this);
    }

    @Override // com.beizi.ad.internal.view.c
    public void onDestroy() {
        destroy();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f12363a == null) {
            return;
        }
        if (isPlaying()) {
            stop();
        }
        release();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        AdWebView adWebView;
        AdViewImpl adViewImpl;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.f12379q && a(this.f12377o, this.f12378p, motionEvent.getX(), motionEvent.getY()) > 15.0f) {
                    this.f12379q = false;
                }
            } else if (System.currentTimeMillis() - this.f12376n < 1000 && this.f12379q && (adWebView = this.mAdWebView) != null && (adViewImpl = adWebView.adViewImpl) != null && adViewImpl.getAdDispatcher() != null) {
                AdViewImpl adViewImpl2 = this.mAdWebView.adViewImpl;
                adViewImpl2.clickCount++;
                adViewImpl2.getAdDispatcher().d();
                AdWebView adWebView2 = this.mAdWebView;
                adWebView2.ad.a(adWebView2.adViewImpl.getOpensNativeBrowser());
            }
            z5 = false;
        } else {
            this.f12376n = System.currentTimeMillis();
            this.f12377o = motionEvent.getX();
            this.f12378p = motionEvent.getY();
            this.f12379q = true;
            z5 = true;
        }
        if (super.onTouchEvent(motionEvent) || z5) {
            return true;
        }
        return false;
    }

    @Override // android.view.TextureView, android.view.View
    public void onVisibilityChanged(View view, int i6) {
        super.onVisibilityChanged(view, i6);
        b(getWindowVisibility(), i6);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        b(i6, getVisibility());
    }

    public void prepare() throws IOException, IllegalStateException {
        prepare(null);
    }

    public void prepareAsync() throws IllegalStateException {
        prepareAsync(null);
    }

    public void release() {
        reset();
        this.f12363a.release();
        this.f12363a = null;
    }

    public void setAssetData(@NonNull String str) throws IOException {
        setDataSource(getContext().getAssets().openFd(str));
    }

    public void setDataSource(@NonNull String str) throws IOException {
        a();
        this.f12363a.setDataSource(str);
    }

    public void setRawData(@RawRes int i6) throws IOException {
        setDataSource(getResources().openRawResourceFd(i6));
    }

    public void transferAd(final AdWebView adWebView, String str) {
        int creativeWidth;
        int creativeHeight;
        if (o.a(str)) {
            return;
        }
        this.f12369g = adWebView.getCreativeHeight();
        this.f12368f = adWebView.getCreativeWidth();
        this.f12367e = adWebView.getCreativeTop();
        this.f12366d = adWebView.getCreativeLeft();
        this.f12370h = adWebView.getRefreshInterval();
        try {
            new URI(str);
            this.f12364b = a.b.FIT_CENTER;
            a(adWebView.getAdExtras());
            try {
                com.beizi.ad.internal.i.f b6 = h.a().b();
                if (!s.a(h.a().e()) && this.mAdWebView.IsVideoWifiOnly() && !b6.b(str)) {
                    failed();
                    return;
                }
                setDataSource(b6.a(str));
                boolean isMuted = adWebView.isMuted();
                this.f12372j = isMuted;
                if (isMuted) {
                    setVolume(0.0f, 0.0f);
                } else {
                    setVolume(1.0f, 1.0f);
                }
                float g6 = h.a().g();
                float h6 = h.a().h();
                if (getCreativeWidth() == 1 && getCreativeHeight() == 1) {
                    creativeHeight = -1;
                    creativeWidth = -1;
                } else {
                    creativeWidth = (int) ((getCreativeWidth() * g6) + 0.5f);
                    creativeHeight = (int) ((getCreativeHeight() * h6) + 0.5f);
                }
                if (getCreativeLeft() == 0 && getCreativeTop() == 0) {
                    setLayoutParams(new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 17));
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 8388659);
                    layoutParams.setMargins((int) ((getCreativeLeft() * g6) + 0.5f), (int) ((getCreativeTop() * h6) + 0.5f), 0, 0);
                    setLayoutParams(layoutParams);
                    setScalableType(a.b.FIT_START);
                }
                setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.beizi.ad.internal.video.AdVideoView.1
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        AdVideoView.this.mAdWebView.ad.y();
                        if (AdVideoView.this.f12374l != null) {
                            AdVideoView.this.mAdWebView.adViewImpl.getAdDispatcher().a((String) AdVideoView.this.f12374l.first, ((Integer) AdVideoView.this.f12374l.second).intValue());
                        }
                        if (AdVideoView.this.mAdWebView.loadAdBy(1)) {
                            AdViewImpl adViewImpl = adWebView.adViewImpl;
                            if (!(adViewImpl instanceof InterstitialAdViewImpl) || ((InterstitialAdViewImpl) adViewImpl).getAdImplementation() == null) {
                                return;
                            }
                            ((b) ((InterstitialAdViewImpl) adWebView.adViewImpl).getAdImplementation()).g();
                        }
                    }
                });
                setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.beizi.ad.internal.video.AdVideoView.2
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer, int i6, int i7) {
                        AdWebView adWebView2;
                        AdViewImpl adViewImpl;
                        if (i6 != 3 || (adWebView2 = AdVideoView.this.mAdWebView) == null || (adViewImpl = adWebView2.adViewImpl) == null || adViewImpl.getAdDispatcher() == null) {
                            return false;
                        }
                        AdVideoView.this.mAdWebView.adViewImpl.getAdDispatcher().f();
                        return false;
                    }
                });
                prepareAsync(new MediaPlayer.OnPreparedListener() { // from class: com.beizi.ad.internal.video.AdVideoView.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        AdVideoView.this.f12375m = mediaPlayer.getDuration() / 1000;
                        int unused = AdVideoView.this.f12375m;
                        if (!AdVideoView.this.f12371i) {
                            AdVideoView.this.f12373k = a.NRF_PAUSE;
                        } else {
                            AdVideoView.this.start(0);
                            AdVideoView.this.f12373k = a.NRF_START;
                        }
                    }
                });
            } catch (IOException | NullPointerException unused) {
                failed();
            }
        } catch (NullPointerException | URISyntaxException unused2) {
            failed();
        }
    }

    private void a(int i6, int i7) {
        Matrix a6;
        if (i6 == 0 || i7 == 0 || (a6 = new com.beizi.ad.internal.video.a(new a.c(getWidth(), getHeight()), new a.c(i6, i7)).a(this.f12364b)) == null) {
            return;
        }
        setTransform(a6);
    }

    public void setDataSource(@NonNull Context context, @NonNull Uri uri, @Nullable Map<String, String> map) throws IOException {
        a();
        this.f12363a.setDataSource(context, uri, map);
    }

    public void setDataSource(@NonNull Context context, @NonNull Uri uri) throws IOException {
        a();
        this.f12363a.setDataSource(context, uri);
    }

    private void a() {
        if (this.f12363a == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f12363a = mediaPlayer;
            mediaPlayer.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        reset();
    }

    public void setDataSource(@NonNull FileDescriptor fileDescriptor, long j6, long j7) throws IOException {
        a();
        this.f12363a.setDataSource(fileDescriptor, j6, j7);
    }

    public void setDataSource(@NonNull FileDescriptor fileDescriptor) throws IOException {
        a();
        this.f12363a.setDataSource(fileDescriptor);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00ed, code lost:
    
        if (r3.equals("CENTER_BOTTOM_CROP") == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.HashMap r7) {
        /*
            Method dump skipped, instructions count: 722
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.internal.video.AdVideoView.a(java.util.HashMap):void");
    }

    @Override // com.beizi.ad.internal.view.c
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    private static float a(float f6, float f7, float f8, float f9) {
        float f10 = f6 - f8;
        float f11 = f7 - f9;
        return a((float) Math.sqrt((f10 * f10) + (f11 * f11)));
    }

    private static float a(float f6) {
        return f6 / h.a().j().density;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i6, int i7) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i6, int i7) {
    }
}
