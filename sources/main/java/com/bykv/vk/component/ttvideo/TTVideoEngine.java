package com.bykv.vk.component.ttvideo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.log.d;
import com.bykv.vk.component.ttvideo.log.e;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.component.ttvideo.player.TTPlayerConfiger;
import com.bykv.vk.component.ttvideo.utils.EngineThreadPool;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import com.kuaishou.weapon.p0.t;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class TTVideoEngine implements com.bykv.vk.component.ttvideo.log.a, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
    public static final int ENGINE_STATE_ERROR = 4;
    public static final int ENGINE_STATE_PLAYER_RUNNING = 3;
    public static final int ENGINE_STATE_RELEASE = 5;
    public static final int ENGINE_STATE_UNKNOWN = 0;
    public static final int LOAD_STATE_ERROR = 3;
    public static final int LOAD_STATE_PLAYABLE = 1;
    public static final int LOAD_STATE_STALLED = 2;
    public static final int LOAD_STATE_UNKNOWN = 0;
    public static final int PLAYBACK_STATE_ERROR = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_STOPPED = 0;
    public static final int PLAYER_BUFFERING_DATA_OF_MILLISECONDS = 118;
    public static final int PLAYER_BUFFERING_TIMEOUT = 11;
    public static final int PLAYER_MAX_BUFFERING_DATA_OF_MILLISECONDS = 202;
    public static final int PLAYER_NETWORK_TIMEOUT = 12;
    public static final int PLAYER_OPTION_ENABLE_DATALOADER = 160;
    public static final int PLAYER_OPTION_NOTIFY_BUFFERING_DIRECTLY = 322;
    public static final int PLAYER_OPTION_OUTPUT_LOG = 472;
    public static final int PLAYER_TIME_BASE = 1000000;
    public static final int PLAYER_TYPE_OS = 1;
    public static final int PLAYER_TYPE_OWN = 0;

    /* renamed from: l0, reason: collision with root package name */
    private static boolean f22842l0;
    VideoEngineSimpleCallback B;
    SeekCompletionListener C;
    private final Context D;
    private Surface E;
    private SurfaceHolder F;
    private final com.bykv.vk.component.ttvideo.log.b G;
    private MediaPlayer H;
    private Handler I;
    private boolean K;
    private final com.bykv.vk.component.ttvideo.utils.a W;

    /* renamed from: a, reason: collision with root package name */
    private boolean f22843a;

    /* renamed from: b, reason: collision with root package name */
    private int f22845b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f22847c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f22849d;

    /* renamed from: e, reason: collision with root package name */
    private int f22851e;

    /* renamed from: e0, reason: collision with root package name */
    private long f22852e0;

    /* renamed from: f0, reason: collision with root package name */
    private long f22854f0;

    /* renamed from: g0, reason: collision with root package name */
    private FileDescriptor f22856g0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f22857h;

    /* renamed from: h0, reason: collision with root package name */
    private com.bykv.vk.component.ttvideo.b f22858h0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f22859i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f22861j;

    /* renamed from: o, reason: collision with root package name */
    private boolean f22868o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f22869p;

    /* renamed from: t, reason: collision with root package name */
    private boolean f22873t;

    /* renamed from: v, reason: collision with root package name */
    private boolean f22875v;

    /* renamed from: x, reason: collision with root package name */
    private int f22877x;

    /* renamed from: y, reason: collision with root package name */
    private String f22878y;

    /* renamed from: z, reason: collision with root package name */
    private int f22879z;

    /* renamed from: f, reason: collision with root package name */
    private boolean f22853f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f22855g = true;

    /* renamed from: k, reason: collision with root package name */
    private int f22863k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f22865l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f22866m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f22867n = 0;

    /* renamed from: q, reason: collision with root package name */
    private int f22870q = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f22871r = 30;

    /* renamed from: s, reason: collision with root package name */
    private int f22872s = 5000;

    /* renamed from: u, reason: collision with root package name */
    private int f22874u = 1;

    /* renamed from: w, reason: collision with root package name */
    private boolean f22876w = true;
    private final HashMap<String, String> A = new HashMap<>();
    private int J = 0;
    private float L = -1.0f;
    private boolean M = false;
    private String N = "";
    private boolean O = false;
    private String P = "";
    private int Q = 0;
    private boolean R = false;
    private Error S = null;
    private boolean T = false;
    private boolean U = false;
    private int V = -1;
    private boolean X = false;
    private final Map<String, String> Y = new HashMap();
    private final List<String> Z = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    private String f22844a0 = null;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f22846b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    private long f22848c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    private int f22850d0 = -1;

    /* renamed from: i0, reason: collision with root package name */
    private int f22860i0 = 0;

    /* renamed from: j0, reason: collision with root package name */
    private int f22862j0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    private int f22864k0 = 5000;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MediaPlayer f22880a;

        a(TTVideoEngine tTVideoEngine, MediaPlayer mediaPlayer) {
            this.f22880a = mediaPlayer;
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayer mediaPlayer = this.f22880a;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.release();
                } catch (Exception e6) {
                    TTVideoEngineLog.i("TTVideoEngine", "release Exception " + e6);
                }
            }
        }
    }

    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VideoEngineSimpleCallback videoEngineSimpleCallback;
            super.handleMessage(message);
            if (message.what == 10) {
                String str = (String) message.obj;
                long j6 = message.arg1;
                if (TTVideoEngine.this.f22845b != 5 && TTVideoEngine.this.Y.containsKey(str) && (videoEngineSimpleCallback = TTVideoEngine.this.B) != null) {
                    videoEngineSimpleCallback.onMDLHitCache(str, j6);
                }
            }
        }
    }

    private static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, String> f22882a;

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference<TTVideoEngine> f22883b;

        @Override // java.lang.Runnable
        public void run() {
            Map<String, String> map;
            TTVideoEngine tTVideoEngine = this.f22883b.get();
            if (tTVideoEngine == null || tTVideoEngine.f22845b == 5 || (map = this.f22882a) == null || map.size() <= 0) {
                return;
            }
            for (String str : this.f22882a.keySet()) {
                String str2 = this.f22882a.get(str);
                long cacheFileSizeByFilePath = !TextUtils.isEmpty(str2) ? TTVideoEngine.getCacheFileSizeByFilePath(str, str2) : TTVideoEngine.getCacheFileSize(str);
                if (tTVideoEngine.I != null) {
                    int i6 = (int) cacheFileSizeByFilePath;
                    tTVideoEngine.I.sendMessage(Message.obtain(tTVideoEngine.I, 10, i6, i6, str));
                }
            }
        }

        public c(TTVideoEngine tTVideoEngine, Map<String, String> map) {
            this.f22883b = new WeakReference<>(tTVideoEngine);
            this.f22882a = map;
        }
    }

    private void d() {
        DataLoaderHelper.getDataLoader()._addEngine(this, this.f22844a0);
    }

    private void e() {
        DataLoaderHelper.getDataLoader()._removeEngine(this, this.f22844a0);
        Iterator<String> it = this.Y.keySet().iterator();
        while (it.hasNext()) {
            DataLoaderHelper.getDataLoader()._removePlayTask(it.next());
        }
        n();
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        c(true);
    }

    public void setDirectUrlUseDataLoader(String str, String str2) {
        setDirectUrlUseDataLoader(str, str2, this.f22878y);
    }

    public void setLocalURL(String str) {
        if (str != null && !str.equals(this.N)) {
            TTVideoEngineLog.i("TTVideoEngine", String.format("set local url:%s", str));
            b();
        }
        this.f22861j = false;
        this.M = true;
        this.N = str;
    }

    private String a(String str, String str2, long j6, String[] strArr, String str3) {
        String _proxyUrl = DataLoaderHelper.getDataLoader()._proxyUrl(str, str2, j6, strArr, str3);
        if (!TextUtils.isEmpty(_proxyUrl)) {
            TTVideoEngineLog.i("TTVideoEngine", "_mdlUrl get proxyUrl: key = " + str + ", videoId = " + str2);
            this.f22844a0 = TextUtils.isEmpty(str2) ? str : str2;
            if (!TextUtils.isEmpty(str)) {
                this.Y.put(str, str3);
            }
            d();
        }
        return _proxyUrl;
    }

    private void b() {
        this.M = false;
        this.O = false;
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null && mediaPlayer.getPlayerType() == 0) {
            this.H.release();
            this.H = null;
        }
        m();
        this.f22845b = 0;
        this.Q = 0;
        this.P = null;
        this.N = null;
        this.f22878y = null;
        this.f22856g0 = null;
        this.f22846b0 = false;
        this.f22843a = false;
        this.f22868o = false;
        this.f22869p = false;
        this.W.c();
        this.X = false;
        this.f22848c0 = 0L;
        this.f22850d0 = -1;
        this.Z.clear();
        this.f22849d = false;
        this.f22855g = true;
        this.f22851e = 0;
    }

    private void c() {
        TTVideoEngineLog.i("TTVideoEngine", "_audioRenderStart, this:".concat(String.valueOf(this)));
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer == null) {
            return;
        }
        if (!this.f22869p) {
            this.f22869p = true;
        }
        if (!this.f22843a && mediaPlayer.getIntOption(62, -100) == 0 && !this.f22859i && this.T && this.f22853f) {
            k();
        }
    }

    private void d(int i6) {
        TTVideoEngineLog.i("TTVideoEngine", "render seek complete:".concat(String.valueOf(i6)));
        this.G.a();
        if (this.f22847c) {
            this.f22847c = false;
        }
        if (this.B != null) {
            TTVideoEngineLog.i("TTVideoEngine", "render seek complete call back ".concat(String.valueOf(i6)));
            this.B.onRenderSeekComplete(i6);
        }
    }

    private void e(int i6) {
        if (this.f22863k != i6) {
            TTVideoEngineLog.i("TTVideoEngine", "playback state changed prev:" + this.f22863k + ", new:" + i6);
            this.f22863k = i6;
            VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
            if (videoEngineSimpleCallback != null) {
                videoEngineSimpleCallback.onPlaybackStateChanged(this, i6);
            }
        }
    }

    private int f() {
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    private void g() {
        if (this.I != null) {
            return;
        }
        this.I = new b(getLooper());
    }

    public static String getEngineVersion() {
        return "1.0.2";
    }

    private void h() {
        if (this.G != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f22848c0 = currentTimeMillis;
            this.G.a(currentTimeMillis, (String) null);
        }
    }

    private void i() {
        if (this.f22843a) {
            return;
        }
        this.G.a();
        this.f22843a = true;
    }

    private void j() {
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            aVar.a();
        }
        if (this.M || this.O || this.f22856g0 != null) {
            h();
            b(this.M ? this.N : this.P);
            a(this.M ? this.N : this.P, this.A);
        }
    }

    private void k() {
        TTVideoEngineLog.i("TTVideoEngine", "start to render,this:".concat(String.valueOf(this)));
        if (this.T) {
            e(1);
        }
        i();
        if (!this.f22868o) {
            this.f22868o = true;
        }
        this.f22846b0 = true;
        a(1, -1);
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            aVar.d();
        }
        if (this.R) {
            if (this.f22851e != 0 && isSystemPlayer()) {
                a(this.f22851e);
            }
            this.R = false;
        }
        if (this.J != 0 && isSystemPlayer()) {
            a(this.J);
        }
        this.J = 0;
        this.Q = 0;
        if (this.B != null) {
            TTVideoEngineLog.i("TTVideoEngine", "notify render start");
            this.B.onRenderStart(this);
        }
    }

    private void m() {
        TTVideoEngineLog.i("TTVideoEngine", "reset, this:".concat(String.valueOf(this)));
        this.T = false;
        this.U = false;
        this.f22857h = false;
        this.A.clear();
        a(true, 6);
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(null);
            this.H.reset();
        }
        this.f22843a = false;
        this.f22868o = false;
        this.f22869p = false;
        this.R = false;
        this.G.reset();
    }

    private void n() {
        this.Y.clear();
        this.f22844a0 = null;
    }

    private void o() {
        TTVideoEngineLog.i("TTVideoEngine", "_resumeVideo, shouldplay:" + this.T + ", mediaplayer:" + this.H + ", prepared:" + this.f22857h);
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer == null || !this.T) {
            return;
        }
        mediaPlayer.setScreenOnWhilePlaying(this.f22876w);
        int i6 = this.f22877x;
        if (i6 != 0) {
            this.H.setWakeMode(this.D, i6);
        }
        if (!this.f22857h) {
            this.f22859i = false;
            return;
        }
        this.H.setIntOption(100, this.J);
        this.H.start();
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null && this.f22843a) {
            aVar.d();
        }
        if (this.H.getIntOption(62, -100) == 0 && !this.f22868o && (this.f22863k == 0 || this.X)) {
            k();
        } else {
            e(1);
        }
    }

    private boolean p() {
        int i6 = this.f22863k;
        if ((i6 == 0 || i6 == 3) && !this.f22857h) {
            return true;
        }
        return (this.H == null || !isSystemPlayer() || this.f22857h) ? false : true;
    }

    public static void setVideoEventUploader(VideoEventEngineUploader videoEventEngineUploader) {
        TTVideoEngineLog.i("TTVideoEngine", "setVideoEventUploader uploader");
        e.instance.a(videoEventEngineUploader);
        DataLoaderHelper.getDataLoader().setEngineUploader(videoEventEngineUploader);
    }

    public int getBufferingType() {
        return this.V;
    }

    public int getCurrentPlaybackTime() {
        TTVideoEngineLog.i("TTVideoEngine", "getCurrentPlaybackTime state:" + this.f22845b);
        int i6 = this.f22845b;
        if (i6 == 3) {
            return f();
        }
        if (i6 == 4) {
            return this.f22851e;
        }
        return -1;
    }

    public int getDuration() {
        return this.f22866m;
    }

    public int getLoadState() {
        return this.f22865l;
    }

    public int getLoadedProgress() {
        return this.f22867n;
    }

    public int getPlaybackState() {
        return this.f22863k;
    }

    public boolean isLooping() {
        return this.f22875v;
    }

    public boolean isMute() {
        MediaPlayer mediaPlayer = this.H;
        return mediaPlayer != null ? mediaPlayer.isMute() : this.K;
    }

    public boolean isSystemPlayer() {
        MediaPlayer mediaPlayer = this.H;
        return mediaPlayer == null ? this.f22879z == 1 : mediaPlayer.isOSPlayer();
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i6) {
        if (this.M) {
            i6 = 100;
        }
        this.f22867n = i6;
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onBufferingUpdate(this, i6);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        TTVideoEngineLog.i("TTVideoEngine", "receive onCompletion,this:".concat(String.valueOf(this)));
        if (!this.f22875v) {
            this.X = true;
            e(0);
            com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
            if (aVar != null) {
                aVar.e();
                this.G.b(this.W.b());
            }
            this.G.a(3);
            this.f22843a = false;
            this.f22868o = false;
            this.f22869p = false;
            this.f22851e = 0;
            this.R = false;
            this.f22861j = false;
        }
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onCompletion(this);
        }
        if (mediaPlayer != null && mediaPlayer.isOSPlayer()) {
            this.f22857h = false;
        }
        this.J = 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i6, int i7) {
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            aVar.e();
        }
        e(3);
        a(3, -1);
        Error error = new Error((mediaPlayer == null || !mediaPlayer.isOSPlayer()) ? Error.VideoOwnPlayer : Error.VideoOSPlayer, i6, i7, null);
        this.S = error;
        b(error);
        return true;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        TTVideoEngineLog.i("TTVideoEngine", "onPrepared");
        if (this.U) {
            return;
        }
        if (mediaPlayer == null) {
            TTVideoEngineLog.e("TTVideoEngine", "onPrepared mediaPlayer is null!");
            return;
        }
        TTVideoEngineLog.i("TTVideoEngine", "onPrepared videoCodecId " + mediaPlayer.getIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, -1));
        this.S = null;
        int duration = mediaPlayer.getDuration();
        this.f22866m = duration;
        this.f22857h = true;
        this.G.e(duration);
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onPrepared(this);
        }
        if ((this.f22859i || !this.T) && this.f22853f) {
            return;
        }
        mediaPlayer.start();
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i6, int i7) {
        TTVideoEngineLog.i("TTVideoEngine", "video size changed = " + i6 + ", " + i7);
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onVideoSizeChanged(this, i6, i7);
        }
    }

    public void pause() {
        TTVideoEngineLog.i("TTVideoEngine", "pause, ".concat(String.valueOf(this)));
        this.T = false;
        if (!this.f22857h) {
            this.f22859i = true;
            e(2);
            return;
        }
        if (this.H != null) {
            TTVideoEngineLog.i("TTVideoEngine", "player will pause");
            this.H.pause();
            e(2);
        }
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void play() {
        TTVideoEngineLog.i("TTVideoEngine", "play, ".concat(String.valueOf(this)));
        if (this.f22845b == 5) {
            TTVideoEngineLog.e("TTVideoEngine", "already released, return");
            return;
        }
        boolean z5 = true;
        this.T = true;
        this.U = false;
        this.f22849d = false;
        if (!this.f22853f && this.f22848c0 <= 0 && !this.f22857h) {
            z5 = false;
        }
        a(z5);
        this.X = false;
    }

    public void prepare() {
        TTVideoEngineLog.i("TTVideoEngine", "prepare, ".concat(String.valueOf(this)));
        this.f22853f = false;
        this.T = false;
        this.U = false;
        this.f22849d = false;
        a(false);
        this.X = false;
    }

    public void release() {
        TTVideoEngineLog.i("TTVideoEngine", "release, ".concat(String.valueOf(this)));
        this.U = true;
        this.T = false;
        a(false, 1);
        MediaPlayer mediaPlayer = this.H;
        this.H = null;
        if (mediaPlayer != null) {
            EngineThreadPool.a().execute(new a(this, mediaPlayer));
        }
        e();
        this.f22845b = 5;
    }

    public void seekTo(int i6, SeekCompletionListener seekCompletionListener) {
        TTVideoEngineLog.i("TTVideoEngine", "seek to time:".concat(String.valueOf(i6)));
        this.C = seekCompletionListener;
        a(i6);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j6, long j7) {
        this.f22852e0 = j6;
        this.f22854f0 = j7;
        b();
        this.f22856g0 = fileDescriptor;
    }

    public void setDirectUrlUseDataLoader(String str, String str2, String str3) {
        setDirectUrlUseDataLoader(str, str2, str3, (String) null);
    }

    public void setIntOption(int i6, int i7) {
        MediaPlayer mediaPlayer;
        int i8;
        if (i6 == 11) {
            this.f22871r = i7;
            mediaPlayer = this.H;
            if (mediaPlayer != null) {
                i8 = 81;
                mediaPlayer.setIntOption(i8, i7);
            }
        } else if (i6 == 12) {
            this.f22872s = i7;
            MediaPlayer mediaPlayer2 = this.H;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setIntOption(9, 1000000 * i7);
            }
        } else if (i6 == 118) {
            this.f22862j0 = i7;
            mediaPlayer = this.H;
            if (mediaPlayer != null) {
                i8 = 86;
                mediaPlayer.setIntOption(i8, i7);
            }
        } else if (i6 == 160) {
            this.f22873t = i7 > 0;
        } else if (i6 == 202) {
            this.f22864k0 = i7;
            mediaPlayer = this.H;
            if (mediaPlayer != null) {
                i8 = 110;
                mediaPlayer.setIntOption(i8, i7);
            }
        } else if (i6 == 322) {
            this.f22860i0 = i7;
            mediaPlayer = this.H;
            if (mediaPlayer != null) {
                i8 = 211;
                mediaPlayer.setIntOption(i8, i7);
            }
        } else if (i6 == 472) {
            this.f22870q = i7;
            MediaPlayer mediaPlayer3 = this.H;
            if (mediaPlayer3 != null) {
                mediaPlayer3.setIntOption(223, i7);
            }
            DataLoaderHelper.getDataLoader().setIntValue(512, i7);
        }
        TTVideoEngineLog.i("TTVideoEngine", "set int option key:" + i6 + " value:" + i7);
    }

    public void setLooping(boolean z5) {
        TTVideoEngineLog.i("TTVideoEngine", "setLooping:".concat(String.valueOf(z5)));
        this.f22875v = z5;
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z5);
        }
    }

    public void setMaxRetryCount(int i6) {
        this.f22874u = i6;
    }

    public void setScreenOnWhilePlaying(boolean z5) {
        TTVideoEngineLog.i("TTVideoEngine", "setScreenOnWhilePlaying:".concat(String.valueOf(z5)));
        this.f22876w = z5;
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setScreenOnWhilePlaying(z5);
        }
    }

    public void setStartTime(int i6) {
        TTVideoEngineLog.i("TTVideoEngine", "setStartTime:".concat(String.valueOf(i6)));
        this.J = i6;
    }

    public void setSurface(Surface surface) {
        TTVideoEngineLog.i("TTVideoEngine", "setSurface surface:" + surface + ", pre-surface:" + this.E + ", this:" + this);
        a(surface);
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        Surface surface;
        TTVideoEngineLog.i("TTVideoEngine", "setSurfaceHolder = " + surfaceHolder + ", this:" + this);
        this.F = surfaceHolder;
        if (surfaceHolder == null) {
            surface = null;
        } else {
            com.bykv.vk.component.ttvideo.b bVar = new com.bykv.vk.component.ttvideo.b(this);
            this.f22858h0 = bVar;
            this.F.addCallback(bVar);
            surface = this.F.getSurface();
        }
        a(surface);
    }

    public void setTrackVolume(float f6) {
        TTVideoEngineLog.i("TTVideoEngine", "setTrackVolume ".concat(String.valueOf(f6)));
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer == null) {
            return;
        }
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        this.L = f6;
        mediaPlayer.setVolume(f6, f6);
    }

    public void setVideoEngineSimpleCallback(VideoEngineSimpleCallback videoEngineSimpleCallback) {
        this.B = videoEngineSimpleCallback;
    }

    public void setWakeMode(int i6) {
        TTVideoEngineLog.i("TTVideoEngine", "setWakeMode:".concat(String.valueOf(i6)));
        this.f22877x = i6;
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setWakeMode(this.D, i6);
        }
    }

    public void start() {
        TTVideoEngineLog.i("TTVideoEngine", "start, ".concat(String.valueOf(this)));
        this.T = true;
        this.U = false;
        this.f22849d = false;
        a(true);
        this.X = false;
    }

    public void stop() {
        TTVideoEngineLog.i("TTVideoEngine", "stop, ".concat(String.valueOf(this)));
        this.T = false;
        this.f22846b0 = false;
        this.U = true;
        a(true, 0);
        e();
    }

    @Override // com.bykv.vk.component.ttvideo.log.a
    public Map versionInfo() {
        HashMap hashMap = new HashMap();
        String value = TTPlayerConfiger.getValue(14, "");
        TTVideoEngineLog.i("TTVideoEngine", "SDK version:1.0.2, player version:".concat(String.valueOf(value)));
        hashMap.put(t.f36163x, value);
        hashMap.put("sdk_version", "1.0.2");
        hashMap.put("sv", "5.6");
        return hashMap;
    }

    public TTVideoEngine(Context context, int i6) {
        TTVideoEngineLog.i("TTVideoEngine", "init, type:" + i6 + ", context:" + context + ", this:" + this);
        this.D = context;
        this.f22879z = i6;
        this.f22873t = f22842l0;
        this.G = new d(context, this);
        this.W = new com.bykv.vk.component.ttvideo.utils.a();
        e.instance.a(context);
    }

    public static void addTask(PreloaderURLItem preloaderURLItem) {
        DataLoaderHelper.getDataLoader().addTask(preloaderURLItem);
    }

    private void b(int i6) {
        TTVideoEngineLog.i("TTVideoEngine", "buffering end,this:" + this + ", code:" + i6);
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null && this.f22843a) {
            aVar.d();
        }
        this.V = -1;
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onBufferEnd(i6);
        }
        a(1, i6);
    }

    private void c(int i6) {
        TTVideoEngineLog.i("TTVideoEngine", "buffering start,this:" + this + ", code:" + i6);
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            aVar.e();
        }
        boolean z5 = this.f22846b0;
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onBufferStart(i6, z5 ? 1 : 0, 0);
        }
        a(2, i6);
    }

    public static void cancelAllPreloadTasks() {
        DataLoaderHelper.getDataLoader().cancelAllTasks();
    }

    public static void cancelPreloadTask(String str) {
        DataLoaderHelper.getDataLoader().cancelTask(str);
    }

    public static void clearAllCaches() {
        DataLoaderHelper.getDataLoader().clearAllCaches();
    }

    public static void closeDataLoader() {
        DataLoaderHelper.getDataLoader().close();
    }

    public static void forceRemoveCacheFile(String str) {
        DataLoaderHelper.getDataLoader().removeCacheFile(str, true);
    }

    public static long getCacheFileSize(String str) {
        return DataLoaderHelper.getDataLoader().getCacheSize(str);
    }

    public static long getCacheFileSizeByFilePath(String str, String str2) {
        return DataLoaderHelper.getDataLoader().getCacheSizeByFilePath(str, str2);
    }

    public static DataLoaderHelper.DataLoaderCacheInfo getCacheInfoByFilePath(String str, String str2) {
        return DataLoaderHelper.getDataLoader().getCacheInfoByFilePath(str, str2);
    }

    public static Looper getLooper() {
        if (Looper.myLooper() != null) {
            return Looper.myLooper();
        }
        return Looper.getMainLooper();
    }

    private void l() {
        String str;
        if (p()) {
            if (!this.M && !this.O && this.f22856g0 == null) {
                return;
            }
            h();
            if (this.M) {
                str = this.N;
            } else {
                str = this.P;
            }
            a(str, this.A);
            return;
        }
        if (this.X || (this.f22863k == 0 && this.f22848c0 == 0)) {
            h();
            com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
            if (aVar != null) {
                aVar.a();
            }
        }
        o();
    }

    public static void removeCacheFile(String str) {
        DataLoaderHelper.getDataLoader().removeCacheFile(str, false);
    }

    public static void setCacheInfoLists(String[] strArr, long[] jArr) {
        DataLoaderHelper.getDataLoader().setCacheInfoLists(strArr, jArr);
    }

    public static void setIntValue(int i6, int i7) {
        DataLoaderHelper.getDataLoader().setIntValue(i6, i7);
    }

    public static void setStringValue(int i6, String str) {
        DataLoaderHelper.getDataLoader().setStringValue(i6, str);
    }

    public static void startDataLoader(Context context) {
        DataLoaderHelper.getDataLoader().setContext(context);
        DataLoaderHelper.getDataLoader().start();
        f22842l0 = true;
    }

    void a() {
        if (this.B != null) {
            TTVideoEngineLog.i("TTVideoEngine", "notify cache end. source id: " + this.f22844a0);
            this.B.onUseMDLCacheEnd();
        }
    }

    public int getCurrentPlaybackTimeAsync() {
        if (isSystemPlayer()) {
            return getCurrentPlaybackTime();
        }
        return this.f22850d0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i6, int i7) {
        if (i6 != -268435438) {
            if (i6 != 3) {
                if (i6 != 801) {
                    if (i6 != 251658248) {
                        if (i6 != 251658252) {
                            if (i6 != 701) {
                                if (i6 == 702) {
                                    b(i7);
                                }
                            } else {
                                c(i7);
                            }
                        } else {
                            c();
                        }
                    } else {
                        d(i7);
                    }
                } else {
                    c(false);
                }
            } else {
                TTVideoEngineLog.i("TTVideoEngine", "player callback render start");
                k();
            }
        } else {
            TTVideoEngineLog.i("TTVideoEngine", "player position update ".concat(String.valueOf(i7)));
            this.f22850d0 = i7;
        }
        return false;
    }

    public void reset() {
        b();
    }

    public void setDirectURL(String str) {
        a(str);
    }

    public void setDirectUrlUseDataLoader(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setDirectUrlUseDataLoader(new String[]{str}, str2, str3, str4);
    }

    public void setIsMute(boolean z5) {
        TTVideoEngineLog.i("TTVideoEngine", String.format("setIsMute:%s", Boolean.valueOf(z5)));
        this.K = z5;
        b(z5);
    }

    private void b(Error error) {
        TTVideoEngineLog.i("TTVideoEngine", "videoEngine failed:" + error.toString());
        if (this.f22849d) {
            this.f22845b = 0;
            return;
        }
        int f6 = f();
        if (!this.R) {
            int i6 = this.J;
            if (i6 != 0) {
                this.f22851e = i6;
                this.J = 0;
            } else if (!isSystemPlayer() || (isSystemPlayer() && this.f22857h)) {
                int i7 = this.f22866m;
                if (i7 <= 0 || f6 - i7 <= -1000) {
                    this.f22851e = f6;
                } else {
                    this.f22851e = 0;
                }
            }
        }
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null && mediaPlayer.isOSPlayer()) {
            this.H.release();
            this.H = null;
            this.f22853f = true;
            a(error);
            return;
        }
        this.f22845b = 4;
        if (this.Q >= this.f22874u) {
            TTVideoEngineLog.e("TTVideoEngine", "videoEngine retry failed");
            a(error);
            return;
        }
        if (error.notNeedRetry()) {
            TTVideoEngineLog.e("TTVideoEngine", "not need retry");
            a(error);
            return;
        }
        this.R = true;
        if (this.Q == this.f22874u - 1 || error.needFallbackOS()) {
            MediaPlayer mediaPlayer2 = this.H;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
                this.H = null;
            }
            this.f22879z = 1;
        }
        this.G.a(error, 0, 0);
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onRetry(this.f22879z);
        }
        this.Q++;
        a(this.M ? this.N : this.P, this.A);
    }

    private void c(boolean z5) {
        TTVideoEngineLog.i("TTVideoEngine", "seek complete");
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null && z5 && this.f22843a) {
            aVar.d();
        }
        SeekCompletionListener seekCompletionListener = this.C;
        if (seekCompletionListener != null) {
            seekCompletionListener.onCompletion(z5);
            this.C = null;
        }
    }

    void a(int i6) {
        com.bykv.vk.component.ttvideo.utils.a aVar;
        TTVideoEngineLog.i("TTVideoEngine", "_seekTo:".concat(String.valueOf(i6)));
        if (this.H == null || !this.f22861j) {
            c(false);
            return;
        }
        if (!this.f22847c && (aVar = this.W) != null) {
            aVar.e();
        }
        this.f22847c = true;
        this.H.seekTo(i6);
    }

    public void setDirectUrlUseDataLoader(String[] strArr, String str, String str2, String str3) {
        if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
            TTVideoEngineLog.e("TTVideoEngine", "invalid urls list, it is empty");
            return;
        }
        this.f22878y = str2;
        if (TextUtils.isEmpty(str) || !this.f22873t) {
            a(strArr[0]);
            return;
        }
        n();
        TTVideoEngineLog.i("TTVideoEngine", "setDirectUrlUseDataLoader key:" + str + ", videoId:" + str2 + ", filePath:" + str3);
        String a6 = a(str, str2, 0L, strArr, str3);
        if (!this.Z.contains(str)) {
            this.Z.add(str);
        }
        if (TextUtils.isEmpty(a6)) {
            setDirectURL(strArr[0]);
        } else {
            setDirectURL(a6);
        }
    }

    private void a(int i6, int i7) {
        if (this.f22865l != i6) {
            TTVideoEngineLog.i("TTVideoEngine", "load state changed prev:" + this.f22865l + ", new:" + i6);
            if (i6 == 2 && this.f22843a && !this.f22847c && this.f22865l != 3) {
                this.V = i7;
            }
            this.f22865l = i6;
            VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
            if (videoEngineSimpleCallback != null) {
                if (this.T || i6 != 3) {
                    videoEngineSimpleCallback.onLoadStateChanged(this, i6);
                }
            }
        }
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f22855g) {
            this.f22855g = false;
            this.G.a(str, "");
        }
        this.G.a(str);
    }

    void a(Surface surface) {
        TTVideoEngineLog.i("TTVideoEngine", "_doSetPlayerSurface surface:" + surface + ", pre-surface:" + this.E + ", this:" + this);
        this.E = surface;
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    void b(boolean z5) {
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setIsMute(z5);
        }
    }

    private void a(Error error) {
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            this.G.b(aVar.b());
        }
        this.G.a(error, 0);
        this.f22861j = false;
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onError(error);
        }
        this.Q = 0;
    }

    void a(String str) {
        if (str != null && !str.equals(this.P)) {
            TTVideoEngineLog.i("TTVideoEngine", String.format("set direct url:%s", str));
            b();
        }
        this.f22861j = false;
        this.O = true;
        this.P = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a6, code lost:
    
        if (r13 != null) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r13, java.util.HashMap r14) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.TTVideoEngine.a(java.lang.String, java.util.HashMap):void");
    }

    void a(boolean z5) {
        TTVideoEngineLog.i("TTVideoEngine", "_play, mState:" + this.f22845b + ", byPlay:" + z5 + ", this:" + this);
        this.f22861j = true;
        this.f22859i = false;
        g();
        if (z5) {
            this.G.d(10);
        }
        int i6 = this.f22845b;
        if (i6 != 0) {
            if (i6 == 3) {
                l();
                return;
            } else if (i6 != 4) {
                return;
            }
        }
        j();
    }

    private void a(boolean z5, int i6) {
        com.bykv.vk.component.ttvideo.utils.a aVar;
        TTVideoEngineLog.i("TTVideoEngine", "_stop, mState:" + this.f22845b + ", this:" + this);
        int i7 = this.f22845b;
        if (i7 == 0 || i7 == 3) {
            this.f22849d = true;
        }
        if (this.H != null && z5 && !isSystemPlayer() && this.f22857h) {
            this.H.stop();
        }
        com.bykv.vk.component.ttvideo.utils.a aVar2 = this.W;
        if (aVar2 != null) {
            aVar2.e();
        }
        if (this.f22863k != 0 && (aVar = this.W) != null) {
            this.G.b(aVar.b());
        }
        this.G.c(i6);
        e(0);
        this.f22843a = false;
        this.f22868o = false;
        this.f22869p = false;
        this.f22848c0 = 0L;
        this.Q = 0;
    }
}
