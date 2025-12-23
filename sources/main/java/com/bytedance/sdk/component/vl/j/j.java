package com.bytedance.sdk.component.vl.j;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.ILiveListener;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.ILiveSettingBundle;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.VideoLiveManager;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.openvk.component.video.api.cw;
import com.bykv.vk.openvk.component.video.api.cw.r;
import com.bykv.vk.openvk.component.video.api.cw.xt;
import com.bykv.vk.openvk.component.video.api.j;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.vl;
import com.bytedance.sdk.component.xt.j.ws;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bykv.vk.openvk.component.video.api.j, l.j {

    /* renamed from: a, reason: collision with root package name */
    private SurfaceTexture f26906a;
    private volatile boolean ae;
    private final Context cw;

    /* renamed from: i, reason: collision with root package name */
    private long f26910i;

    /* renamed from: j, reason: collision with root package name */
    private ILivePlayer f26911j;

    /* renamed from: m, reason: collision with root package name */
    private l f26913m;

    /* renamed from: p, reason: collision with root package name */
    private volatile r f26914p;

    /* renamed from: r, reason: collision with root package name */
    private int f26915r;
    private JSONObject rn;

    /* renamed from: s, reason: collision with root package name */
    private SurfaceHolder f26916s;
    private boolean uf;
    private int up;

    /* renamed from: v, reason: collision with root package name */
    private long f26917v;
    private boolean wq;
    private final List<WeakReference<j.InterfaceC0305j>> xt = Collections.synchronizedList(new ArrayList());
    private AtomicBoolean tl = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    private AtomicBoolean f26908g = new AtomicBoolean(false);
    private volatile boolean oq = false;
    private volatile boolean qv = false;
    private volatile boolean vl = false;
    private volatile boolean jy = false;
    private volatile boolean ws = false;
    private volatile boolean az = false;
    private volatile boolean av = true;

    /* renamed from: w, reason: collision with root package name */
    private long f26918w = 0;
    private long mi = 0;
    private final int kt = 0;
    private int tj = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f26907f = 0;

    /* renamed from: x, reason: collision with root package name */
    private long f26919x = 0;
    private volatile boolean ch = false;

    /* renamed from: l, reason: collision with root package name */
    private volatile int f26912l = 200;

    /* renamed from: h, reason: collision with root package name */
    private long f26909h = 0;
    private final ArrayList<Runnable> la = new ArrayList<>();
    private final Runnable gq = new Runnable() { // from class: com.bytedance.sdk.component.vl.j.j.1
        @Override // java.lang.Runnable
        public void run() {
            long mi = j.this.mi();
            j.this.f26919x += j.this.f26912l;
            if (j.this.w() > 0 && j.this.f26909h != mi) {
                if (cw.r()) {
                    com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "run: lastCur = " + j.this.f26909h + "  currentPosition=" + mi);
                }
                j jVar = j.this;
                jVar.j(mi, jVar.w());
            }
            j.this.f26909h = mi;
            if (j.this.mi() >= j.this.f26917v) {
                j.this.jy = true;
                j.this.up();
                for (WeakReference weakReference : j.this.xt) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((j.InterfaceC0305j) weakReference.get()).j(j.this);
                    }
                }
            }
            if (j.this.jy) {
                j jVar2 = j.this;
                jVar2.j(jVar2.w(), j.this.w());
            } else if (j.this.f26913m != null) {
                j.this.f26913m.postDelayed(this, j.this.f26912l);
            }
        }
    };
    private final ILiveListener ed = new ILiveListener() { // from class: com.bytedance.sdk.component.vl.j.j.7
        private boolean xt = false;

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onError(LiveError liveError) {
            if (liveError != null) {
                if (this.xt) {
                    return;
                }
                this.xt = true;
                xt xtVar = new xt(liveError.code, 0, liveError.getInfoJSON());
                for (WeakReference weakReference : j.this.xt) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((j.InterfaceC0305j) weakReference.get()).j(j.this, xtVar);
                    }
                }
            }
            j.this.av = true;
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCompletion() {
            if (j.this.f26913m == null) {
                return;
            }
            j.this.f26913m.removeCallbacks(j.this.gq);
            for (WeakReference weakReference : j.this.xt) {
                if (weakReference != null && weakReference.get() != null) {
                    ((j.InterfaceC0305j) weakReference.get()).j(j.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onFirstFrame(boolean z5) {
            if (j.this.f26913m == null) {
                return;
            }
            j.this.ch = true;
            j.this.f26913m.removeCallbacks(j.this.gq);
            if (j.this.f26917v > 0) {
                j.this.f26913m.postDelayed(j.this.gq, j.this.f26912l);
            }
            j.this.av = false;
            if (!z5) {
                com.bykv.vk.openvk.component.video.api.m.cw.xt("TTLiveVideoPlayer", "onFirstFrame-> not first frame , isFirstFrame=".concat(String.valueOf(z5)));
                for (WeakReference weakReference : j.this.xt) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((j.InterfaceC0305j) weakReference.get()).j((com.bykv.vk.openvk.component.video.api.j) j.this, -1);
                    }
                }
                return;
            }
            j.this.f26918w = System.currentTimeMillis() - j.this.f26910i;
            for (WeakReference weakReference2 : j.this.xt) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    j.InterfaceC0305j interfaceC0305j = (j.InterfaceC0305j) weakReference2.get();
                    j jVar = j.this;
                    interfaceC0305j.j(jVar, jVar.f26918w);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onMonitorLog(JSONObject jSONObject, String str) {
            for (WeakReference weakReference : j.this.xt) {
                if (weakReference != null && weakReference.get() != null) {
                    ((j.InterfaceC0305j) weakReference.get()).j(j.this, jSONObject, str);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onPrepared() {
            com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "onPrepared.....");
            j.this.ws = true;
            for (WeakReference weakReference : j.this.xt) {
                if (weakReference != null && weakReference.get() != null) {
                    ((j.InterfaceC0305j) weakReference.get()).xt(j.this);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallEnd() {
            if (j.this.f26913m == null) {
                return;
            }
            if (j.this.f26917v > 0) {
                j.this.f26913m.postDelayed(j.this.gq, j.this.f26912l);
            }
            j.this.mi += System.currentTimeMillis() - j.this.f26907f;
            for (WeakReference weakReference : j.this.xt) {
                if (weakReference != null && weakReference.get() != null) {
                    ((j.InterfaceC0305j) weakReference.get()).j((com.bykv.vk.openvk.component.video.api.j) j.this, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallStart() {
            if (j.this.f26913m == null) {
                return;
            }
            j.i(j.this);
            j.this.f26907f = System.currentTimeMillis();
            j.this.f26913m.removeCallbacks(j.this.gq);
            for (WeakReference weakReference : j.this.xt) {
                if (weakReference != null && weakReference.get() != null) {
                    ((j.InterfaceC0305j) weakReference.get()).j(j.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoSizeChanged(int i6, int i7) {
            j.this.f26915r = i6;
            j.this.up = i7;
            for (WeakReference weakReference : j.this.xt) {
                if (weakReference != null && weakReference.get() != null) {
                    ((j.InterfaceC0305j) weakReference.get()).j((com.bykv.vk.openvk.component.video.api.j) j.this, i6, i7);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCacheFileCompletion() {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAbrSwitch(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAudioRenderStall(int i6) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onResolutionDegrade(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onSeiUpdate(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoRenderStall(int i6) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onReportALog(int i6, String str) {
        }
    };

    static /* synthetic */ int i(j jVar) {
        int i6 = jVar.tj;
        jVar.tj = i6 + 1;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void kt() {
        ArrayList<Runnable> arrayList = this.la;
        if (arrayList != null && !arrayList.isEmpty()) {
            tj();
        }
    }

    private synchronized void tj() {
        try {
            if (this.wq) {
                return;
            }
            this.wq = true;
            Iterator it = new ArrayList(this.la).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.la.clear();
            this.wq = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(float f6) {
    }

    /* renamed from: com.bytedance.sdk.component.vl.j.j$j, reason: collision with other inner class name */
    public static class C0420j implements INetworkClient {

        /* renamed from: j, reason: collision with root package name */
        private final vl f26928j;

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doPost(String str, String str2) {
            return null;
        }

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doRequest(String str, String str2) {
            String str3;
            String str4;
            String str5 = null;
            String str6 = null;
            JSONObject jSONObject = null;
            try {
                try {
                    av j6 = this.f26928j.j(new ws.j().j(str).xt("host", str2).xt()).j();
                    if (j6.r()) {
                        str4 = j6.m().xt();
                        try {
                            str6 = j6.ae().toString();
                            jSONObject = new JSONObject(str4);
                        } catch (JSONException e6) {
                            e = e6;
                            String str7 = str6;
                            str5 = str4;
                            str3 = str7;
                            return INetworkClient.Result.newBuilder().setBody(str5).setHeader(str3).setException(e).build();
                        }
                    } else {
                        str4 = null;
                    }
                    return INetworkClient.Result.newBuilder().setResponse(jSONObject).setBody(str4).build();
                } catch (IOException e7) {
                    return INetworkClient.Result.newBuilder().setException(e7).build();
                } catch (Exception e8) {
                    return INetworkClient.Result.newBuilder().setException(e8).build();
                }
            } catch (JSONException e9) {
                e = e9;
                str3 = null;
            }
        }

        public C0420j() {
            vl.j xt = cw.cw().xt();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.f26928j = xt.j(10L, timeUnit).xt(10L, timeUnit).cw(10L, timeUnit).j();
        }
    }

    private void f() {
        l lVar = this.f26913m;
        if (lVar == null || lVar.getLooper() == null) {
            return;
        }
        this.f26913m.post(new Runnable() { // from class: com.bytedance.sdk.component.vl.j.j.6
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f26913m == null || j.this.f26913m.getLooper() == null) {
                    return;
                }
                try {
                    j.this.f26906a = null;
                    j.this.f26916s = null;
                    if (j.this.ae) {
                        j.this.f26913m.removeCallbacksAndMessages(null);
                    } else {
                        com.bytedance.sdk.component.oq.xt.j.j().j(j.this.f26913m);
                    }
                    j.this.f26913m = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public SurfaceHolder ae() {
        return this.f26916s;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public long av() {
        return this.mi;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean az() {
        return this.qv;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean g() {
        com.bykv.vk.openvk.component.video.api.m.cw.xt("TTLiveVideoPlayer", "TTLiveVideoPlayer...isCompleted......isComplete....=" + this.jy);
        return this.jy;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public int i() {
        return this.tj;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(int i6) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean jy() {
        ILivePlayer iLivePlayer = this.f26911j;
        if (iLivePlayer == null) {
            return false;
        }
        try {
            return iLivePlayer.isPlaying();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "isPlaying: catch exception:", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public long mi() {
        return this.f26919x;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean oq() {
        return this.az;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public int qv() {
        return this.f26915r;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public SurfaceTexture tl() {
        return this.f26906a;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public int vl() {
        return this.up;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public long w() {
        return this.f26917v;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean ws() {
        return this.av;
    }

    public j(Context context, boolean z5, long j6, JSONObject jSONObject, Looper looper) {
        long j7;
        this.f26913m = null;
        this.ae = false;
        this.f26917v = 0L;
        this.cw = context;
        this.rn = jSONObject;
        if (j6 > 0) {
            j7 = j6 * 1000;
        } else {
            j7 = -1;
        }
        this.f26917v = j7;
        if (looper != null) {
            this.f26913m = new l(looper, this);
            this.ae = true;
        } else if (this.f26913m == null) {
            this.f26913m = com.bytedance.sdk.component.oq.xt.j.j().j(this, "tt-live-video-player");
        }
        r(z5);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(long j6) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean m() {
        return this.ch;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void up() {
        l lVar = this.f26913m;
        if (lVar != null) {
            lVar.removeCallbacks(this.gq);
            lVar.sendEmptyMessage(103);
            f();
        }
        com.bykv.vk.openvk.component.video.api.m.cw.xt("TTLiveVideoPlayer", "TTLiveVideoPlayer...release......release....");
    }

    private void r(final boolean z5) {
        l lVar = this.f26913m;
        if (lVar != null) {
            lVar.post(new Runnable() { // from class: com.bytedance.sdk.component.vl.j.j.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ILiveSettingBundle iLiveSettingBundle = new ILiveSettingBundle() { // from class: com.bytedance.sdk.component.vl.j.j.2.1
                            /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
                            /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
                            @Override // com.bykv.vk.component.ttvideo.ILiveSettingBundle
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct code enable 'Show inconsistent code' option in preferences
                            */
                            public <T> T getSettingsValueForKey(java.lang.String r2, T r3) {
                                /*
                                    r1 = this;
                                    r2.getClass()
                                    java.lang.String r0 = "live_enable_close_play_retry"
                                    boolean r0 = r2.equals(r0)
                                    if (r0 != 0) goto L14
                                    java.lang.String r0 = "live_sdk_cancel_sdk_dns_fail_retry"
                                    boolean r2 = r2.equals(r0)
                                    if (r2 != 0) goto L23
                                    return r3
                                L14:
                                    java.lang.Class r2 = r3.getClass()
                                    java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
                                    if (r2 != r0) goto L23
                                    java.lang.String r2 = "1"
                                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                                    goto L24
                                L23:
                                    r2 = r3
                                L24:
                                    java.lang.Class r3 = r3.getClass()
                                    java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
                                    if (r3 != r0) goto L2e
                                    java.lang.Boolean r2 = java.lang.Boolean.TRUE
                                L2e:
                                    return r2
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.vl.j.j.AnonymousClass2.AnonymousClass1.getSettingsValueForKey(java.lang.String, java.lang.Object):java.lang.Object");
                            }
                        };
                        j jVar = j.this;
                        jVar.f26911j = VideoLiveManager.newBuilder(jVar.cw).setProjectKey("pangle_ad_live").setNetworkClient(new C0420j()).setForceHttpDns(false).setForceTTNetHttpDns(false).setSettingsBundle(iLiveSettingBundle).setPlayerType(1).setListener(j.this.ed).build();
                        j.this.f26911j.setIntOption(69, z5 ? 1 : 0);
                        j.this.f26911j.setStringOption(72, com.bytedance.sdk.openadsdk.api.plugin.xt.j(j.this.cw, null).getAbsolutePath() + "/pangle_live/");
                    } catch (Exception e6) {
                        com.bykv.vk.openvk.component.video.api.m.cw.cw("TTLiveVideoPlayer", e6.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void cw() {
        com.bykv.vk.openvk.component.video.api.m.cw.xt("TTLiveVideoPlayer", "TTLiveVideoPlayer...pause......pause....currentPosition=" + mi());
        l lVar = this.f26913m;
        if (lVar != null) {
            lVar.removeCallbacks(this.gq);
            lVar.sendEmptyMessage(101);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void xt() {
        l lVar = this.f26913m;
        if (lVar != null) {
            lVar.post(new Runnable() { // from class: com.bytedance.sdk.component.vl.j.j.5
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f26911j == null || j.this.jy()) {
                        return;
                    }
                    try {
                        j.this.f26911j.play();
                        j jVar = j.this;
                        jVar.j(jVar.uf);
                        for (WeakReference weakReference : j.this.xt) {
                            if (weakReference != null && weakReference.get() != null) {
                                weakReference.get();
                            }
                        }
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "play: catch exception", th);
                    }
                    j.this.av = false;
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void r() {
        com.bykv.vk.openvk.component.video.api.m.cw.xt("TTLiveVideoPlayer", "TTLiveVideoPlayer...stop......stop....currentPosition=" + mi());
        l lVar = this.f26913m;
        if (lVar != null) {
            lVar.removeCallbacks(this.gq);
            lVar.sendEmptyMessage(105);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void xt(boolean z5) {
        this.vl = z5;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void cw(boolean z5) {
        com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "setLoop: live is invalid ");
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void xt(int i6) {
        this.f26912l = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j6, long j7) {
        long j8;
        long j9;
        for (WeakReference<j.InterfaceC0305j> weakReference : this.xt) {
            if (weakReference == null || weakReference.get() == null) {
                j8 = j6;
                j9 = j7;
            } else {
                j8 = j6;
                j9 = j7;
                weakReference.get().j(this, j8, j9);
            }
            j6 = j8;
            j7 = j9;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(r rVar) {
        if (rVar == null) {
            return;
        }
        this.f26914p = rVar;
        com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "setDataSource: model = " + rVar.av());
        l lVar = this.f26913m;
        if (lVar != null) {
            lVar.sendEmptyMessage(107);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j() {
        this.tj = 0;
        this.mi = 0L;
        this.f26907f = 0L;
        j(true, 0L, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(boolean z5, final long j6, final boolean z6) {
        l lVar;
        if (this.f26908g.get() && this.oq && this.f26911j != null) {
            this.f26919x = j6;
            this.f26910i = System.currentTimeMillis();
            j(z6);
            l lVar2 = this.f26913m;
            if (lVar2 != null) {
                lVar2.sendEmptyMessage(100);
            }
            com.bytedance.sdk.component.utils.vl.xt("TTLiveVideoPlayer", "TTLiveVideoPlayer...play......");
        } else {
            j(new Runnable() { // from class: com.bytedance.sdk.component.vl.j.j.3
                @Override // java.lang.Runnable
                public void run() {
                    j.this.f26919x = j6;
                    j.this.f26910i = System.currentTimeMillis();
                    j.this.j(z6);
                    if (j.this.f26913m != null) {
                        j.this.f26913m.sendEmptyMessage(100);
                    }
                }
            });
        }
        this.tl.set(true);
        if (!this.f26908g.get() || (lVar = this.f26913m) == null) {
            return;
        }
        lVar.post(new Runnable() { // from class: com.bytedance.sdk.component.vl.j.j.4
            @Override // java.lang.Runnable
            public void run() {
                j.this.kt();
            }
        });
    }

    private synchronized void j(Runnable runnable) {
        this.la.add(runnable);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(boolean z5) {
        this.uf = z5;
        if (this.f26911j != null) {
            com.bykv.vk.openvk.component.video.api.m.cw.xt("TTLiveVideoPlayer", "TTLiveVideoPlayer...setQuietPlay......isMute=".concat(String.valueOf(z5)));
            try {
                this.f26911j.setMute(Boolean.valueOf(z5));
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "setMute: catch exception:", th);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(SurfaceHolder surfaceHolder) {
        this.f26916s = surfaceHolder;
        com.bykv.vk.openvk.component.video.api.m.cw.xt("TTLiveVideoPlayer", "TTLiveVideoPlayer...SurfaceHolder......".concat(String.valueOf(surfaceHolder)));
        l lVar = this.f26913m;
        if (lVar != null) {
            lVar.obtainMessage(110, surfaceHolder).sendToTarget();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(SurfaceTexture surfaceTexture) {
        this.f26906a = surfaceTexture;
        l lVar = this.f26913m;
        if (lVar != null) {
            lVar.obtainMessage(111, surfaceTexture).sendToTarget();
        }
        com.bykv.vk.openvk.component.video.api.m.cw.xt("TTLiveVideoPlayer", "setSurface...surface=");
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(j.InterfaceC0305j interfaceC0305j) {
        if (interfaceC0305j == null) {
            return;
        }
        for (WeakReference<j.InterfaceC0305j> weakReference : this.xt) {
            if (weakReference != null && weakReference.get() == interfaceC0305j) {
                return;
            }
        }
        this.xt.add(new WeakReference<>(interfaceC0305j));
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        try {
            switch (message.what) {
                case 100:
                    xt();
                    this.az = true;
                    return;
                case 101:
                    ILivePlayer iLivePlayer = this.f26911j;
                    if (iLivePlayer != null) {
                        try {
                            iLivePlayer.stop();
                            for (WeakReference<j.InterfaceC0305j> weakReference : this.xt) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "pause: catch exception:", th);
                        }
                        this.av = true;
                        return;
                    }
                    return;
                case 102:
                    ILivePlayer iLivePlayer2 = this.f26911j;
                    if (iLivePlayer2 != null) {
                        try {
                            iLivePlayer2.reset();
                        } catch (Throwable th2) {
                            com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "reset: catch exception:", th2);
                        }
                        this.av = true;
                        return;
                    }
                    return;
                case 103:
                    ILivePlayer iLivePlayer3 = this.f26911j;
                    if (iLivePlayer3 != null) {
                        try {
                            iLivePlayer3.release();
                        } catch (Throwable th3) {
                            com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "release: catch exception:", th3);
                        }
                        this.qv = true;
                        this.av = true;
                        return;
                    }
                    return;
                case 104:
                case 106:
                case 108:
                case 109:
                default:
                    return;
                case 105:
                    ILivePlayer iLivePlayer4 = this.f26911j;
                    if (iLivePlayer4 != null) {
                        try {
                            iLivePlayer4.stop();
                        } catch (Throwable th4) {
                            com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "stop: catch exception:", th4);
                        }
                        this.av = true;
                        return;
                    }
                    return;
                case 107:
                    if (this.f26911j == null || this.f26914p == null) {
                        return;
                    }
                    String av = this.f26914p.av();
                    j(av);
                    this.f26911j.setStreamInfo(av);
                    this.oq = true;
                    com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "set Datasource:" + this.oq);
                    this.tj = 0;
                    return;
                case 110:
                    ILivePlayer iLivePlayer5 = this.f26911j;
                    if (iLivePlayer5 != null) {
                        SurfaceHolder surfaceHolder = (SurfaceHolder) message.obj;
                        iLivePlayer5.setSurfaceHolder(surfaceHolder);
                        this.f26911j.setSurface(surfaceHolder.getSurface());
                        this.f26908g.set(true);
                        if (this.tl.get()) {
                            kt();
                            return;
                        }
                        return;
                    }
                    return;
                case 111:
                    ILivePlayer iLivePlayer6 = this.f26911j;
                    if (iLivePlayer6 != null) {
                        iLivePlayer6.setSurface(new Surface(this.f26906a));
                        this.f26908g.set(true);
                        if (this.tl.get()) {
                            kt();
                            return;
                        }
                        return;
                    }
                    return;
            }
        } catch (Exception e6) {
            e6.getMessage();
        }
        e6.getMessage();
    }

    private void j(String str) {
        String str2 = LiveConfigKey.LOW;
        try {
            JSONObject jSONObject = this.rn;
            if (jSONObject == null) {
                return;
            }
            com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "live ".concat(String.valueOf(jSONObject)));
            int optInt = jSONObject.optInt("enable");
            String optString = jSONObject.optString("appids");
            if (optInt == 1 && !TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject optJSONObject = jSONObject2.optJSONObject("common");
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                if (optJSONObject != null && optJSONObject2 != null) {
                    String optString2 = optJSONObject.optString("app_id");
                    com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "api ".concat(String.valueOf(optString2)));
                    if (optString.contains(optString2)) {
                        if (optJSONObject2.optJSONObject(LiveConfigKey.UHD) != null) {
                            str2 = LiveConfigKey.UHD;
                        } else if (optJSONObject2.optJSONObject(LiveConfigKey.HIGH) != null) {
                            str2 = LiveConfigKey.HIGH;
                        } else if (optJSONObject2.optJSONObject(LiveConfigKey.STANDARD) != null) {
                            str2 = LiveConfigKey.STANDARD;
                        } else if (optJSONObject2.optJSONObject(LiveConfigKey.LOW) == null) {
                            str2 = null;
                        }
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "update reso:".concat(String.valueOf(str2)));
                        this.f26911j.setStringOption(43, str2);
                    }
                }
            }
        } catch (Exception e6) {
            com.bykv.vk.openvk.component.video.api.m.cw.j("TTLiveVideoPlayer", "updateStream: catch exception:", e6.getMessage());
        }
    }
}
