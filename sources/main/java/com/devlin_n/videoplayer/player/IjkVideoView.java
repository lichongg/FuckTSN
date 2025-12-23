package com.devlin_n.videoplayer.player;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.devlin_n.videoplayer.R;
import com.devlin_n.videoplayer.controller.BaseVideoController;
import com.devlin_n.videoplayer.widget.ResizeSurfaceView;
import com.devlin_n.videoplayer.widget.ResizeTextureView;
import com.devlin_n.videoplayer.widget.StatusView;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.util.List;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.ui.widget.DanmakuView;
import tv.danmaku.ijk.media.player.AndroidMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class IjkVideoView extends FrameLayout implements BaseVideoController.d {
    public static final int M = -1;
    public static final int N = 0;
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 3;
    public static final int R = 4;
    public static final int S = 5;
    public static final int T = 6;
    public static final int U = 7;
    public static final int V = 10;
    public static final int W = 11;

    /* renamed from: a0, reason: collision with root package name */
    public static final int f32349a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    public static final int f32350b0 = 1;

    /* renamed from: c0, reason: collision with root package name */
    public static final int f32351c0 = 2;

    /* renamed from: k0, reason: collision with root package name */
    public static final int f32352k0 = 3;

    /* renamed from: p0, reason: collision with root package name */
    public static final int f32353p0 = 4;
    protected boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private IMediaPlayer.OnErrorListener F;
    private IMediaPlayer.OnCompletionListener G;
    private IMediaPlayer.OnInfoListener H;
    private IMediaPlayer.OnBufferingUpdateListener I;
    private IMediaPlayer.OnPreparedListener J;
    private IMediaPlayer.OnVideoSizeChangedListener K;
    private com.danikula.videocache.e L;

    /* renamed from: a, reason: collision with root package name */
    private IMediaPlayer f32354a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private BaseVideoController f32355b;

    /* renamed from: c, reason: collision with root package name */
    private g1.d f32356c;

    /* renamed from: d, reason: collision with root package name */
    private ResizeSurfaceView f32357d;

    /* renamed from: e, reason: collision with root package name */
    private ResizeTextureView f32358e;

    /* renamed from: f, reason: collision with root package name */
    private SurfaceTexture f32359f;

    /* renamed from: g, reason: collision with root package name */
    private DanmakuView f32360g;

    /* renamed from: h, reason: collision with root package name */
    private DanmakuContext f32361h;

    /* renamed from: i, reason: collision with root package name */
    private master.flame.danmaku.danmaku.parser.a f32362i;

    /* renamed from: j, reason: collision with root package name */
    private FrameLayout f32363j;

    /* renamed from: k, reason: collision with root package name */
    private StatusView f32364k;

    /* renamed from: l, reason: collision with root package name */
    private int f32365l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f32366m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f32367n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f32368o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f32369p;

    /* renamed from: q, reason: collision with root package name */
    private String f32370q;

    /* renamed from: r, reason: collision with root package name */
    private List<com.devlin_n.videoplayer.player.b> f32371r;

    /* renamed from: s, reason: collision with root package name */
    private int f32372s;

    /* renamed from: t, reason: collision with root package name */
    private int f32373t;

    /* renamed from: u, reason: collision with root package name */
    private String f32374u;

    /* renamed from: v, reason: collision with root package name */
    private int f32375v;

    /* renamed from: w, reason: collision with root package name */
    private AudioManager f32376w;

    /* renamed from: x, reason: collision with root package name */
    @NonNull
    private m f32377x;

    /* renamed from: y, reason: collision with root package name */
    private int f32378y;

    /* renamed from: z, reason: collision with root package name */
    protected OrientationEventListener f32379z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements IMediaPlayer.OnVideoSizeChangedListener {
        a() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i6, int i7, int i8, int i9) {
            int videoWidth = iMediaPlayer.getVideoWidth();
            int videoHeight = iMediaPlayer.getVideoHeight();
            if (videoWidth != 0 && videoHeight != 0) {
                if (IjkVideoView.this.f32368o) {
                    IjkVideoView.this.f32357d.setScreenScale(IjkVideoView.this.f32378y);
                    IjkVideoView.this.f32357d.a(videoWidth, videoHeight);
                } else {
                    IjkVideoView.this.f32358e.setScreenScale(IjkVideoView.this.f32378y);
                    IjkVideoView.this.f32358e.a(videoWidth, videoHeight);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements com.danikula.videocache.e {
        b() {
        }

        @Override // com.danikula.videocache.e
        public void a(File file, String str, int i6) {
            IjkVideoView.this.f32365l = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends OrientationEventListener {

        /* renamed from: c, reason: collision with root package name */
        private static final int f32382c = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final int f32383d = 2;

        /* renamed from: e, reason: collision with root package name */
        private static final int f32384e = 3;

        /* renamed from: a, reason: collision with root package name */
        private int f32385a;

        c(Context context) {
            super(context);
            this.f32385a = 0;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i6) {
            int i7;
            int i8;
            if (i6 >= 340) {
                if (IjkVideoView.this.B || IjkVideoView.this.C || (i8 = this.f32385a) == 1) {
                    return;
                }
                if ((i8 == 2 || i8 == 3) && !IjkVideoView.this.a()) {
                    this.f32385a = 1;
                    return;
                }
                this.f32385a = 1;
                h1.f.l(IjkVideoView.this.getContext()).setRequestedOrientation(1);
                IjkVideoView.this.g();
                return;
            }
            if (i6 >= 260 && i6 <= 280) {
                int i9 = this.f32385a;
                if (i9 == 2) {
                    return;
                }
                if (i9 == 1 && IjkVideoView.this.a()) {
                    this.f32385a = 2;
                    return;
                }
                this.f32385a = 2;
                if (!IjkVideoView.this.a()) {
                    IjkVideoView.this.i();
                }
                h1.f.l(IjkVideoView.this.getContext()).setRequestedOrientation(0);
                return;
            }
            if (i6 < 70 || i6 > 90 || (i7 = this.f32385a) == 3) {
                return;
            }
            if (i7 == 1 && IjkVideoView.this.a()) {
                this.f32385a = 3;
                return;
            }
            this.f32385a = 3;
            if (!IjkVideoView.this.a()) {
                IjkVideoView.this.i();
            }
            h1.f.l(IjkVideoView.this.getContext()).setRequestedOrientation(8);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements SurfaceHolder.Callback {
        d() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i6, int i7, int i8) {
            if (IjkVideoView.this.f32354a != null) {
                IjkVideoView.this.f32354a.setDisplay(surfaceHolder);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements TextureView.SurfaceTextureListener {
        e() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i6, int i7) {
            if (IjkVideoView.this.f32359f != null) {
                IjkVideoView.this.f32358e.setSurfaceTexture(IjkVideoView.this.f32359f);
            } else {
                IjkVideoView.this.f32359f = surfaceTexture;
                IjkVideoView.this.f32354a.setSurface(new Surface(surfaceTexture));
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return IjkVideoView.this.f32359f == null;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i6, int i7) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h1.a.f43028d = true;
            IjkVideoView.this.f32363j.removeView(IjkVideoView.this.f32364k);
            IjkVideoView.this.U();
            IjkVideoView.this.j0();
        }

        f() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IjkVideoView.this.f32354a.reset();
            IjkVideoView.this.f32354a.release();
            IjkVideoView.this.f32354a = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h implements IMediaPlayer.OnErrorListener {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IjkVideoView.this.f32363j.removeView(IjkVideoView.this.f32364k);
                IjkVideoView.this.a0();
                IjkVideoView.this.j0();
            }
        }

        h() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i6, int i7) {
            IjkVideoView.this.f32375v = -1;
            if (IjkVideoView.this.f32356c != null) {
                IjkVideoView.this.f32356c.onError();
            }
            if (IjkVideoView.this.f32355b != null) {
                IjkVideoView.this.f32355b.setPlayState(IjkVideoView.this.f32375v);
            }
            IjkVideoView ijkVideoView = IjkVideoView.this;
            ijkVideoView.f32373t = ijkVideoView.getCurrentPosition();
            IjkVideoView.this.f32363j.removeView(IjkVideoView.this.f32364k);
            if (IjkVideoView.this.f32364k == null) {
                IjkVideoView.this.f32364k = new StatusView(IjkVideoView.this.getContext());
            }
            IjkVideoView.this.f32364k.setMessage(IjkVideoView.this.getResources().getString(R.string.error_message));
            IjkVideoView.this.f32364k.b(IjkVideoView.this.getResources().getString(R.string.retry), new a());
            IjkVideoView.this.f32363j.addView(IjkVideoView.this.f32364k);
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class i implements IMediaPlayer.OnCompletionListener {
        i() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            IjkVideoView.this.f32375v = 5;
            if (IjkVideoView.this.f32356c != null) {
                IjkVideoView.this.f32356c.onComplete();
            }
            if (IjkVideoView.this.f32355b != null) {
                IjkVideoView.this.f32355b.setPlayState(IjkVideoView.this.f32375v);
            }
            IjkVideoView.this.setKeepScreenOn(false);
            IjkVideoView.q(IjkVideoView.this);
            if (IjkVideoView.this.f32371r == null || IjkVideoView.this.f32371r.size() <= 1 || IjkVideoView.this.f32372s >= IjkVideoView.this.f32371r.size()) {
                return;
            }
            IjkVideoView.this.Y();
            IjkVideoView.this.a0();
            IjkVideoView.this.j0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class j implements IMediaPlayer.OnInfoListener {
        j() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i6, int i7) {
            if (IjkVideoView.this.f32356c != null) {
                IjkVideoView.this.f32356c.onInfo(i6, i7);
            }
            if (i6 == 3) {
                if (IjkVideoView.this.getWindowVisibility() == 0) {
                    return true;
                }
                IjkVideoView.this.pause();
                return true;
            }
            if (i6 == 10001) {
                if (IjkVideoView.this.f32358e == null) {
                    return true;
                }
                IjkVideoView.this.f32358e.setRotation(i7);
                return true;
            }
            if (i6 == 701) {
                IjkVideoView.this.f32375v = 6;
                if (IjkVideoView.this.f32355b == null) {
                    return true;
                }
                IjkVideoView.this.f32355b.setPlayState(IjkVideoView.this.f32375v);
                return true;
            }
            if (i6 != 702) {
                return true;
            }
            IjkVideoView.this.f32375v = 7;
            if (IjkVideoView.this.f32355b == null) {
                return true;
            }
            IjkVideoView.this.f32355b.setPlayState(IjkVideoView.this.f32375v);
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class k implements IMediaPlayer.OnBufferingUpdateListener {
        k() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i6) {
            if (IjkVideoView.this.D) {
                return;
            }
            IjkVideoView.this.f32365l = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class l implements IMediaPlayer.OnPreparedListener {
        l() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            IjkVideoView.this.f32375v = 2;
            if (IjkVideoView.this.f32356c != null) {
                IjkVideoView.this.f32356c.onPrepared();
            }
            if (IjkVideoView.this.f32355b != null) {
                IjkVideoView.this.f32355b.setPlayState(IjkVideoView.this.f32375v);
            }
            if (IjkVideoView.this.f32373t > 0) {
                IjkVideoView ijkVideoView = IjkVideoView.this;
                ijkVideoView.seekTo(ijkVideoView.f32373t);
            }
            IjkVideoView.this.start();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class m implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        boolean f32397a;

        /* renamed from: b, reason: collision with root package name */
        boolean f32398b;

        /* renamed from: c, reason: collision with root package name */
        int f32399c;

        private m() {
            this.f32397a = false;
            this.f32398b = false;
            this.f32399c = 0;
        }

        boolean a() {
            if (IjkVideoView.this.f32376w == null) {
                return false;
            }
            this.f32397a = false;
            return 1 == IjkVideoView.this.f32376w.abandonAudioFocus(this);
        }

        boolean b() {
            if (this.f32399c == 1) {
                return true;
            }
            if (IjkVideoView.this.f32376w == null) {
                return false;
            }
            if (1 == IjkVideoView.this.f32376w.requestAudioFocus(this, 3, 1)) {
                this.f32399c = 1;
                return true;
            }
            this.f32397a = true;
            return false;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i6) {
            if (this.f32399c == i6) {
                return;
            }
            this.f32399c = i6;
            if (i6 == -3 || i6 == -2) {
                if (IjkVideoView.this.isPlaying()) {
                    this.f32398b = true;
                    IjkVideoView.this.pause();
                    return;
                }
                return;
            }
            if (i6 == -1) {
                if (IjkVideoView.this.isPlaying()) {
                    this.f32398b = true;
                    IjkVideoView.this.pause();
                    return;
                }
                return;
            }
            if (i6 == 1 || i6 == 2) {
                if (this.f32397a || this.f32398b) {
                    IjkVideoView.this.start();
                    this.f32397a = false;
                    this.f32398b = false;
                }
            }
        }

        /* synthetic */ m(IjkVideoView ijkVideoView, d dVar) {
            this();
        }
    }

    public IjkVideoView(@NonNull Context context) {
        this(context, null);
    }

    public IjkVideoView P() {
        this.E = true;
        return this;
    }

    public IjkVideoView Q() {
        this.C = true;
        return this;
    }

    public IjkVideoView R() {
        this.A = true;
        if (this.f32379z == null) {
            this.f32379z = new c(getContext());
        }
        return this;
    }

    public IjkVideoView T() {
        this.D = true;
        return this;
    }

    public IjkVideoView l0() {
        this.f32369p = true;
        return this;
    }

    public IjkVideoView m0() {
        this.f32368o = true;
        return this;
    }

    public IjkVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32372s = 0;
        this.f32374u = "";
        this.f32375v = 0;
        this.f32377x = new m(this, null);
        this.f32378y = 0;
        this.F = new h();
        this.G = new i();
        this.H = new j();
        this.I = new k();
        this.J = new l();
        this.K = new a();
        this.L = new b();
        V();
    }

    private void N() {
        this.f32363j.removeView(this.f32357d);
        ResizeSurfaceView resizeSurfaceView = new ResizeSurfaceView(getContext());
        this.f32357d = resizeSurfaceView;
        SurfaceHolder holder = resizeSurfaceView.getHolder();
        holder.addCallback(new d());
        holder.setFormat(1);
        this.f32363j.addView(this.f32357d, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void O() {
        this.f32363j.removeView(this.f32358e);
        this.f32359f = null;
        ResizeTextureView resizeTextureView = new ResizeTextureView(getContext());
        this.f32358e = resizeTextureView;
        resizeTextureView.setSurfaceTextureListener(new e());
        this.f32363j.addView(this.f32358e, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.f32354a == null) {
            if (this.f32369p) {
                this.f32354a = new AndroidMediaPlayer();
            } else {
                IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
                this.f32354a = ijkMediaPlayer;
                ijkMediaPlayer.setOption(4, "mediacodec", 1L);
                ((IjkMediaPlayer) this.f32354a).setOption(4, "mediacodec-auto-rotate", 1L);
                ((IjkMediaPlayer) this.f32354a).setOption(4, "mediacodec-handle-resolution-change", 1L);
            }
            this.f32376w = (AudioManager) StubApp.getOrigApplicationContext(getContext().getApplicationContext()).getSystemService("audio");
            this.f32354a.setAudioStreamType(3);
            this.f32354a.setOnErrorListener(this.F);
            this.f32354a.setOnCompletionListener(this.G);
            this.f32354a.setOnInfoListener(this.H);
            this.f32354a.setOnBufferingUpdateListener(this.I);
            this.f32354a.setOnPreparedListener(this.J);
            this.f32354a.setOnVideoSizeChangedListener(this.K);
            this.f32375v = 0;
            BaseVideoController baseVideoController = this.f32355b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(0);
            }
        }
        if (this.f32368o) {
            N();
        } else {
            O();
        }
        DanmakuView danmakuView = this.f32360g;
        if (danmakuView != null) {
            this.f32363j.removeView(danmakuView);
            this.f32363j.addView(this.f32360g, 1);
        }
    }

    private boolean W() {
        int i6;
        return (this.f32354a == null || (i6 = this.f32375v) == -1 || i6 == 0 || i6 == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        com.devlin_n.videoplayer.player.b bVar = this.f32371r.get(this.f32372s);
        if (bVar != null) {
            this.f32370q = bVar.f32402a;
            this.f32374u = bVar.f32403b;
            this.f32373t = 0;
            f0(bVar.f32404c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        this.f32354a.reset();
        IMediaPlayer iMediaPlayer = this.f32354a;
        if (iMediaPlayer instanceof IjkMediaPlayer) {
            U();
            return;
        }
        iMediaPlayer.setVolume(1.0f, 1.0f);
        this.f32354a.setOnErrorListener(this.F);
        this.f32354a.setOnCompletionListener(this.G);
        this.f32354a.setOnInfoListener(this.H);
        this.f32354a.setOnBufferingUpdateListener(this.I);
        this.f32354a.setOnPreparedListener(this.J);
        this.f32354a.setOnVideoSizeChangedListener(this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        String str = this.f32370q;
        if (str == null || str.trim().equals("")) {
            return;
        }
        try {
            if (this.D) {
                com.danikula.videocache.i cacheServer = getCacheServer();
                String j6 = cacheServer.j(this.f32370q);
                cacheServer.p(this.L, this.f32370q);
                if (cacheServer.m(this.f32370q)) {
                    this.f32365l = 100;
                }
                this.f32354a.setDataSource(j6);
            } else {
                this.f32354a.setDataSource(this.f32370q);
            }
            this.f32354a.prepareAsync();
            this.f32375v = 1;
            BaseVideoController baseVideoController = this.f32355b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(1);
                this.f32355b.setPlayerState(this.f32366m ? 11 : 10);
            }
            DanmakuView danmakuView = this.f32360g;
            if (danmakuView != null) {
                danmakuView.g(this.f32362i, this.f32361h);
            }
        } catch (IOException e6) {
            this.f32375v = -1;
            BaseVideoController baseVideoController2 = this.f32355b;
            if (baseVideoController2 != null) {
                baseVideoController2.setPlayState(-1);
            }
            e6.printStackTrace();
        }
    }

    static /* synthetic */ int q(IjkVideoView ijkVideoView) {
        int i6 = ijkVideoView.f32372s;
        ijkVideoView.f32372s = i6 + 1;
        return i6;
    }

    public IjkVideoView M(DanmakuView danmakuView, DanmakuContext danmakuContext, master.flame.danmaku.danmaku.parser.a aVar) {
        this.f32360g = danmakuView;
        this.f32361h = danmakuContext;
        this.f32362i = aVar;
        return this;
    }

    public boolean X() {
        BaseVideoController baseVideoController = this.f32355b;
        if (baseVideoController != null && this.B) {
            baseVideoController.g();
            Toast.makeText(getContext(), R.string.lock_tip, 0).show();
            return true;
        }
        if (this.C || !this.f32366m) {
            return false;
        }
        h1.f.l(getContext()).setRequestedOrientation(1);
        g();
        BaseVideoController baseVideoController2 = this.f32355b;
        if (baseVideoController2 != null) {
            baseVideoController2.setPlayerState(10);
        }
        return true;
    }

    public void Z() {
        if (this.f32354a != null) {
            new Thread(new g()).start();
            this.f32375v = 0;
            BaseVideoController baseVideoController = this.f32355b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(0);
            }
            this.f32377x.a();
            setKeepScreenOn(false);
        }
        DanmakuView danmakuView = this.f32360g;
        if (danmakuView != null) {
            danmakuView.release();
            this.f32360g = null;
        }
        OrientationEventListener orientationEventListener = this.f32379z;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        if (this.D) {
            getCacheServer().u(this.L);
        }
        this.f32363j.removeView(this.f32358e);
        this.f32363j.removeView(this.f32357d);
        this.f32363j.removeView(this.f32364k);
        SurfaceTexture surfaceTexture = this.f32359f;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f32359f = null;
        }
        this.B = false;
        this.f32373t = 0;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public boolean a() {
        return this.f32366m;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public IjkVideoView f(int i6) {
        this.f32378y = i6;
        ResizeSurfaceView resizeSurfaceView = this.f32357d;
        if (resizeSurfaceView != null) {
            resizeSurfaceView.setScreenScale(i6);
        }
        ResizeTextureView resizeTextureView = this.f32358e;
        if (resizeTextureView != null) {
            resizeTextureView.setScreenScale(i6);
        }
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void d() {
        StubApp.getOrigApplicationContext(getContext().getApplicationContext()).stopService(new Intent(getContext(), (Class<?>) BackgroundPlayService.class));
    }

    public IjkVideoView d0(String str) {
        if (str != null) {
            this.f32374u = str;
        }
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void e() {
        this.f32372s++;
        List<com.devlin_n.videoplayer.player.b> list = this.f32371r;
        if (list == null || list.size() <= 1 || this.f32372s >= this.f32371r.size()) {
            return;
        }
        Y();
        a0();
        j0();
    }

    public IjkVideoView e0(String str) {
        this.f32370q = str;
        return this;
    }

    public IjkVideoView f0(BaseVideoController baseVideoController) {
        this.f32363j.removeView(this.f32355b);
        if (baseVideoController != null) {
            baseVideoController.setMediaPlayer(this);
            this.f32355b = baseVideoController;
            this.f32363j.addView(this.f32355b, new FrameLayout.LayoutParams(-1, -1));
        }
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void g() {
        if (this.f32366m) {
            h1.f.o(getContext(), true, true);
            h1.f.m(getContext());
            ((ViewGroup) h1.f.l(getContext()).findViewById(android.R.id.content)).removeView(this.f32363j);
            addView(this.f32363j, new FrameLayout.LayoutParams(-1, -1));
            this.f32366m = false;
            BaseVideoController baseVideoController = this.f32355b;
            if (baseVideoController != null) {
                baseVideoController.setPlayerState(10);
            }
        }
    }

    public IjkVideoView g0(List<com.devlin_n.videoplayer.player.b> list) {
        this.f32371r = list;
        Y();
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public int getBufferPercentage() {
        if (this.f32354a != null) {
            return this.f32365l;
        }
        return 0;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public String getTitle() {
        return this.f32374u;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void h() {
        if (this.f32367n) {
            this.f32354a.setVolume(1.0f, 1.0f);
            this.f32367n = false;
        } else {
            this.f32354a.setVolume(0.0f, 0.0f);
            this.f32367n = true;
        }
    }

    public IjkVideoView h0(String str, int i6) {
        this.f32370q = str;
        this.f32373t = i6;
        return this;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void i() {
        if (this.f32366m) {
            return;
        }
        h1.f.k(getContext(), true, true);
        h1.f.i(getContext());
        removeView(this.f32363j);
        ((ViewGroup) h1.f.l(getContext()).findViewById(android.R.id.content)).addView(this.f32363j, new FrameLayout.LayoutParams(-1, -1));
        this.f32366m = true;
        BaseVideoController baseVideoController = this.f32355b;
        if (baseVideoController != null) {
            baseVideoController.setPlayerState(11);
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public boolean isMute() {
        return this.f32367n;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public boolean isPlaying() {
        IMediaPlayer iMediaPlayer = this.f32354a;
        return iMediaPlayer != null && iMediaPlayer.isPlaying();
    }

    public void k0() {
        IMediaPlayer iMediaPlayer = this.f32354a;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.f32354a.release();
            this.f32354a = null;
            this.f32375v = 0;
            BaseVideoController baseVideoController = this.f32355b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(0);
            }
            this.f32377x.a();
            setKeepScreenOn(false);
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void setLock(boolean z5) {
        this.B = z5;
    }

    public void setVideoListener(g1.d dVar) {
        this.f32356c = dVar;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void start() {
        OrientationEventListener orientationEventListener;
        if (this.f32375v == 0) {
            if (this.C) {
                b();
            }
            if (this.E) {
                com.devlin_n.videoplayer.player.c.b().d();
                com.devlin_n.videoplayer.player.c.b().e(this);
            }
            if (this.A && (orientationEventListener = this.f32379z) != null) {
                orientationEventListener.enable();
            }
            if (S()) {
                return;
            }
            U();
            j0();
        } else if (W()) {
            this.f32354a.start();
            this.f32375v = 3;
            BaseVideoController baseVideoController = this.f32355b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(3);
            }
            DanmakuView danmakuView = this.f32360g;
            if (danmakuView != null && danmakuView.isPrepared() && this.f32360g.isPaused()) {
                this.f32360g.resume();
            }
        }
        setKeepScreenOn(true);
        this.f32377x.b();
    }

    private boolean S() {
        if (h1.d.a(getContext()) == 4 && !h1.a.f43028d) {
            this.f32363j.removeView(this.f32364k);
            if (this.f32364k == null) {
                this.f32364k = new StatusView(getContext());
            }
            this.f32364k.setMessage(getResources().getString(R.string.wifi_tip));
            this.f32364k.b(getResources().getString(R.string.continue_play), new f());
            this.f32363j.addView(this.f32364k);
            return true;
        }
        return false;
    }

    private void V() {
        h1.a.f43026b = h1.f.d(getContext(), false);
        h1.a.f43025a = h1.f.e(getContext());
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f32363j = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.f32363j, new FrameLayout.LayoutParams(-1, -1));
    }

    private com.danikula.videocache.i getCacheServer() {
        return com.devlin_n.videoplayer.player.a.c(StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
    }

    private void i0() {
        int i6;
        if (!W()) {
            return;
        }
        Intent intent = new Intent(getContext(), (Class<?>) BackgroundPlayService.class);
        intent.putExtra("url", this.f32370q);
        getCurrentPosition();
        if (getDuration() <= 0) {
            i6 = 0;
        } else {
            i6 = this.f32373t;
        }
        intent.putExtra("position", i6);
        intent.putExtra(h1.b.f43031c, this.D);
        StubApp.getOrigApplicationContext(getContext().getApplicationContext()).startService(intent);
        h1.f.l(getContext()).finish();
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void b() {
        h1.f.l(getContext()).setRequestedOrientation(0);
        i();
    }

    public void b0() {
        if (W() && !this.f32354a.isPlaying() && this.f32375v != 5) {
            this.f32354a.start();
            this.f32375v = 3;
            BaseVideoController baseVideoController = this.f32355b;
            if (baseVideoController != null) {
                baseVideoController.setPlayState(3);
            }
            this.f32377x.b();
            setKeepScreenOn(true);
        }
        DanmakuView danmakuView = this.f32360g;
        if (danmakuView != null && danmakuView.isPrepared() && this.f32360g.isPaused()) {
            this.f32360g.resume();
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void c() {
        if (com.devlin_n.floatWindowPermission.b.f().c(getContext())) {
            i0();
        } else {
            com.devlin_n.floatWindowPermission.b.f().b(getContext());
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public int getCurrentPosition() {
        if (W()) {
            int currentPosition = (int) this.f32354a.getCurrentPosition();
            this.f32373t = currentPosition;
            return currentPosition;
        }
        return 0;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public int getDuration() {
        if (W()) {
            return (int) this.f32354a.getDuration();
        }
        return 0;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void pause() {
        if (W()) {
            if (this.f32354a.isPlaying()) {
                this.f32354a.pause();
                this.f32375v = 4;
                BaseVideoController baseVideoController = this.f32355b;
                if (baseVideoController != null) {
                    baseVideoController.setPlayState(4);
                }
                setKeepScreenOn(false);
                this.f32377x.a();
            }
            DanmakuView danmakuView = this.f32360g;
            if (danmakuView != null && danmakuView.isPrepared()) {
                this.f32360g.pause();
            }
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController.d
    public void seekTo(int i6) {
        if (W()) {
            long j6 = i6;
            this.f32354a.seekTo(j6);
            DanmakuView danmakuView = this.f32360g;
            if (danmakuView != null) {
                danmakuView.m(Long.valueOf(j6));
            }
        }
    }
}
