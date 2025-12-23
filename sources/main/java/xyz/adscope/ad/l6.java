package xyz.adscope.ad;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import java.io.File;
import xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a;
import xyz.adscope.ad.b4;
import xyz.adscope.ad.h4;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.AssetModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.type.VideoModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.amps.R;
import xyz.adscope.common.v2.cache.IResourceLruCache;
import xyz.adscope.common.v2.cache.LruCacheModel;
import xyz.adscope.common.v2.cache.VideoLruCache;
import xyz.adscope.common.v2.dev.info.NetworkUtil;
import xyz.adscope.common.v2.dev.info.ScreenUtil;
import xyz.adscope.common.v2.handle.WeakReferenceHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class l6 extends n6 {

    /* renamed from: e, reason: collision with root package name */
    private VideoView f55363e;

    /* renamed from: f, reason: collision with root package name */
    private MediaPlayer f55364f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f55365g;

    /* renamed from: h, reason: collision with root package name */
    private h f55366h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f55367i;

    /* renamed from: j, reason: collision with root package name */
    private int f55368j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f55369k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f55370l;

    /* renamed from: m, reason: collision with root package name */
    private final i f55371m;

    /* renamed from: n, reason: collision with root package name */
    private final g4 f55372n;

    /* renamed from: o, reason: collision with root package name */
    private g f55373o;

    /* renamed from: p, reason: collision with root package name */
    private d f55374p;

    /* renamed from: q, reason: collision with root package name */
    private final f f55375q;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l6.this.f55366h == h.VIDEO_PLAYING) {
                l6.this.i();
            }
            if (l6.this.f55366h == h.VIDEO_PAUSE || l6.this.f55366h == h.VIDEO_STANDBY) {
                l6.this.j();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements View.OnClickListener {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements e {
            a() {
            }

            @Override // xyz.adscope.ad.l6.e
            public void a(boolean z5) {
                if (z5) {
                    l6.this.f55367i.setImageResource(R.drawable.asnp_voice_off);
                } else {
                    l6.this.f55367i.setImageResource(R.drawable.asnp_voice_on);
                }
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l6.this.a(new a());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements IResourceLruCache.IResourceCacheCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b4.a f55379a;

        c(b4.a aVar) {
            this.f55379a = aVar;
        }

        @Override // xyz.adscope.common.v2.cache.IResourceLruCache.IResourceCacheCallback
        public void onCacheDone(File file) {
            if (file == null || !file.exists()) {
                return;
            }
            try {
                file.setLastModified(System.currentTimeMillis());
            } catch (IllegalArgumentException | SecurityException unused) {
            }
            l6.this.f55363e.setVideoPath(file.getAbsolutePath());
            b4.a aVar = this.f55379a;
            if (aVar != null) {
                aVar.b(l6.this.f55727b.a());
            }
        }

        @Override // xyz.adscope.common.v2.cache.IResourceLruCache.IResourceCacheCallback
        public void onCacheException() {
            b4.a aVar = this.f55379a;
            if (aVar != null) {
                aVar.a(l6.this.f55727b.a());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d {
        public static final int AUTO_PLAY_ALWAYS = 0;
        public static final int AUTO_PLAY_NEVER = 2;
        public static final int AUTO_PLAY_WIFI = 1;

        public int getAutoPlayCondition() {
            return 0;
        }

        public boolean isLoopPlayback() {
            return false;
        }

        public boolean isSilentPlayback() {
            return false;
        }

        public boolean renderForUnified() {
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e {
        void a(boolean z5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private final l6 f55381a;

        /* synthetic */ f(l6 l6Var, a aVar) {
            this(l6Var);
        }

        public void a() {
            this.f55381a.i();
        }

        private f(l6 l6Var) {
            this.f55381a = l6Var;
        }

        public void a(boolean z5) {
            if (z5) {
                this.f55381a.l();
            } else {
                this.f55381a.m();
            }
        }

        public void b() {
            this.f55381a.j();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class g extends WeakReferenceHandler {

        /* renamed from: a, reason: collision with root package name */
        private final MediaPlayer f55382a;

        /* renamed from: b, reason: collision with root package name */
        private final int f55383b;

        /* renamed from: c, reason: collision with root package name */
        private final g4 f55384c;

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (hasMessages(1)) {
                removeMessages(1);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.f55382a.isPlaying()) {
                sendEmptyMessageAtTime(1, 1000L);
            }
        }

        @Override // xyz.adscope.common.v2.handle.WeakReferenceHandler
        public void scopeHandleMessage(Message message) {
            MediaPlayer mediaPlayer = this.f55382a;
            if (mediaPlayer != null) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                g4 g4Var = this.f55384c;
                if (g4Var != null) {
                    g4Var.a(h4.a.VIDEO_PROCESS, Integer.valueOf(currentPosition));
                }
                if (currentPosition < this.f55382a.getDuration()) {
                    b();
                }
            }
        }

        public g(Context context, MediaPlayer mediaPlayer, g4 g4Var) {
            super(context);
            this.f55383b = 1;
            this.f55382a = mediaPlayer;
            this.f55384c = g4Var;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum h {
        VIDEO_PLAYING,
        VIDEO_PAUSE,
        VIDEO_STANDBY,
        VIDEO_IDLE,
        VIDEO_STOPPED
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class i implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
        private i() {
        }

        /* synthetic */ i(l6 l6Var, a aVar) {
            this();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            l6.this.f55369k = true;
            l6.this.f55372n.a(h4.a.VIDEO_FINISHED, Integer.valueOf(mediaPlayer.getDuration()));
            l6.this.f55366h = h.VIDEO_STANDBY;
            if (l6.this.f55365g.getVisibility() != 0) {
                l6.this.f55365g.setVisibility(0);
                l6.this.f55365g.setImageResource(R.drawable.asnp_video_replay_icon);
            }
            l6.this.g();
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i6, int i7) {
            l6.this.o();
            l6.this.f55372n.a(h4.a.VIDEO_ERROR, Integer.valueOf(mediaPlayer.getCurrentPosition()));
            return true;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            l6.this.f55364f = mediaPlayer;
            l6.this.f55373o = new g(l6.this.getContext(), mediaPlayer, l6.this.f55372n);
            l6.this.f55366h = h.VIDEO_STANDBY;
            l6.this.f55372n.a(h4.a.VIDEO_PREPARED, Integer.valueOf(mediaPlayer.getDuration()));
            l6.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        d dVar = this.f55374p;
        if (dVar != null) {
            int autoPlayCondition = dVar.getAutoPlayCondition();
            if (autoPlayCondition == 0) {
                j();
            } else if (autoPlayCondition == 1 && NetworkUtil.isWifiConnected(getContext())) {
                j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        d dVar = this.f55374p;
        if (dVar == null || !dVar.isLoopPlayback()) {
            return;
        }
        j();
    }

    private void h() {
        VideoView videoView = new VideoView(getContext());
        this.f55363e = videoView;
        addView(videoView, new ViewGroup.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(getContext());
        this.f55365g = imageView;
        imageView.setOnClickListener(new a());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenUtil.Calculate.dip2px(getContext(), 90.0f), ScreenUtil.Calculate.dip2px(getContext(), 90.0f));
        layoutParams.addRule(13, -1);
        addView(this.f55365g, layoutParams);
        ImageView imageView2 = new ImageView(getContext());
        this.f55367i = imageView2;
        imageView2.setOnClickListener(new b());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ScreenUtil.Calculate.dip2px(getContext(), 30.0f), ScreenUtil.Calculate.dip2px(getContext(), 30.0f));
        layoutParams2.leftMargin = ScreenUtil.Calculate.dip2px(getContext(), 5.0f);
        layoutParams2.topMargin = ScreenUtil.Calculate.dip2px(getContext(), 5.0f);
        addView(this.f55367i, layoutParams2);
        this.f55367i.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f55366h == h.VIDEO_PLAYING) {
            this.f55366h = h.VIDEO_PAUSE;
            if (this.f55365g.getVisibility() != 0) {
                this.f55365g.setVisibility(0);
                this.f55365g.setImageResource(android.R.drawable.ic_media_play);
            }
            g gVar = this.f55373o;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        h hVar = this.f55366h;
        if (hVar == h.VIDEO_PAUSE || hVar == h.VIDEO_STANDBY) {
            if (hVar == h.VIDEO_STANDBY && this.f55369k) {
                this.f55368j = 0;
            }
            n();
            if (this.f55365g.getVisibility() == 0) {
                this.f55365g.setVisibility(8);
            }
            g gVar = this.f55373o;
            if (gVar != null) {
                gVar.b();
            }
        }
    }

    private void k() {
        setExpressRoot(getExpressRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        MediaPlayer mediaPlayer = this.f55364f;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        }
        this.f55370l = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        MediaPlayer mediaPlayer = this.f55364f;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.0f, 1.0f);
        }
        this.f55370l = false;
    }

    private void n() {
        this.f55363e.seekTo(this.f55368j);
        if (this.f55368j == 0) {
            this.f55372n.a(h4.a.VIDEO_START, 0);
        }
        this.f55363e.start();
        this.f55366h = h.VIDEO_PLAYING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        h hVar = this.f55366h;
        if (hVar == h.VIDEO_PLAYING || hVar == h.VIDEO_PAUSE) {
            this.f55363e.stopPlayback();
            this.f55366h = h.VIDEO_STOPPED;
        }
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void b() {
        i();
        this.f55372n.b();
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void c() {
        j();
        this.f55372n.a();
    }

    public f getVideoController() {
        return this.f55375q;
    }

    public void setVideoConfig(d dVar) {
        if (dVar != null) {
            this.f55374p = dVar;
            if (dVar.renderForUnified()) {
                this.f55365g.setVisibility(8);
            }
            if (this.f55363e == null || !dVar.isSilentPlayback()) {
                return;
            }
            l();
        }
    }

    public l6(Context context) {
        super(context);
        this.f55366h = h.VIDEO_IDLE;
        this.f55368j = 0;
        this.f55369k = false;
        this.f55370l = false;
        a aVar = null;
        this.f55371m = new i(this, aVar);
        this.f55372n = new g4();
        this.f55374p = new d();
        this.f55375q = new f(this, aVar);
        h();
        k();
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void setExpressRoot(xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a aVar) {
        super.setExpressRoot(aVar);
        a.c.a(aVar, this);
    }

    private String b(AssetModel assetModel) {
        if (assetModel != null && assetModel.d() != null) {
            VideoModel d6 = assetModel.d();
            String d7 = d6.d();
            String a6 = d6.a();
            String b6 = d6.b();
            return !TextUtils.isEmpty(d7) ? d7 : !TextUtils.isEmpty(a6) ? a6 : !TextUtils.isEmpty(b6) ? b6 : "";
        }
        return "";
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void a() {
        VideoView videoView = this.f55363e;
        if (videoView != null) {
            videoView.stopPlayback();
        }
    }

    @Override // xyz.adscope.ad.n6, xyz.adscope.ad.b4
    public void a(b4.a aVar) {
        b(aVar);
    }

    public void a(e eVar) {
        if (this.f55370l) {
            m();
        } else {
            l();
        }
        if (eVar != null) {
            eVar.a(this.f55370l);
        }
    }

    private void b(b4.a aVar) {
        RenderModel renderModel = this.f55727b;
        if (renderModel != null && renderModel.f() != null) {
            if (this.f55727b.f().q()) {
                l();
            } else {
                m();
            }
        }
        VideoView videoView = this.f55363e;
        if (videoView != null) {
            videoView.setOnPreparedListener(this.f55371m);
            this.f55363e.setOnCompletionListener(this.f55371m);
            this.f55363e.setOnErrorListener(this.f55371m);
            VideoLruCache.getInstance().getCacheResource(getContext(), b(this.f55728c), LruCacheModel.TEMPORARY, new c(aVar));
        }
    }

    public void a(h4 h4Var) {
        g4 g4Var = this.f55372n;
        if (g4Var != null) {
            g4Var.a(h4Var);
        }
    }
}
