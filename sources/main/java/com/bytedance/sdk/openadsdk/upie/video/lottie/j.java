package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.j;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.g;
import com.bytedance.adsdk.lottie.kt;
import com.bytedance.adsdk.lottie.r;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.upie.xt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import master.flame.danmaku.danmaku.parser.b;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bykv.vk.openvk.component.video.api.j {

    /* renamed from: a, reason: collision with root package name */
    private int f31903a;
    private final Context ae;
    private boolean av;
    private final com.bykv.vk.openvk.component.video.api.j az;
    private boolean ch;
    private final long cw;

    /* renamed from: f, reason: collision with root package name */
    private boolean f31904f;

    /* renamed from: g, reason: collision with root package name */
    private LottieAnimationView f31905g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f31906h;
    private final String jy;
    private boolean kt;

    /* renamed from: l, reason: collision with root package name */
    private long f31909l;

    /* renamed from: m, reason: collision with root package name */
    private final com.bykv.vk.openvk.component.video.api.renderview.xt f31910m;
    private boolean mi;
    private Bitmap oq;

    /* renamed from: r, reason: collision with root package name */
    private final int f31912r;
    private boolean tj;
    private String tl;
    private final int up;

    /* renamed from: v, reason: collision with root package name */
    private boolean f31914v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f31915w;
    private ViewTreeObserverOnGlobalLayoutListenerC0507j wq;
    private final JSONObject ws;

    /* renamed from: x, reason: collision with root package name */
    private boolean f31916x;
    private final String xt;

    /* renamed from: j, reason: collision with root package name */
    private final String f31908j = "TTLottieFakeVideoPlayer";
    private final Map<String, Bitmap> qv = new HashMap();
    private final Map<String, Integer> vl = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private final Set<j.InterfaceC0305j> f31907i = new HashSet();

    /* renamed from: s, reason: collision with root package name */
    private volatile int f31913s = 200;

    /* renamed from: p, reason: collision with root package name */
    private float f31911p = 1.0f;
    private int la = 0;
    private int gq = 0;
    private final Handler uf = new Handler(Looper.getMainLooper());
    private final Runnable ed = new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.4
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = j.this.f31907i.iterator();
            while (it.hasNext()) {
                ((j.InterfaceC0305j) it.next()).j(j.this, r3.f31903a, j.this.w());
            }
            vl.j("TTLottieFakeVideoPlayer", "--==--play curr: " + j.this.f31903a);
            if (j.this.f31903a < j.this.w()) {
                j.this.f31903a += j.this.f31913s;
                j.this.uf.postDelayed(j.this.ed, j.this.f31913s);
                return;
            }
            if (j.this.f31905g != null) {
                j.this.f31905g.m();
            }
            if (j.this.kt && !j.this.f31904f && j.this.az != null && j.this.az.jy()) {
                j.this.az.cw();
            }
            j.this.mi = false;
            j.this.tj = true;
            j.this.ch();
            Iterator it2 = j.this.f31907i.iterator();
            while (it2.hasNext()) {
                ((j.InterfaceC0305j) it2.next()).j(j.this);
            }
        }
    };
    private long rn = SystemClock.elapsedRealtime();

    /* renamed from: com.bytedance.sdk.openadsdk.upie.video.lottie.j$j, reason: collision with other inner class name */
    private class ViewTreeObserverOnGlobalLayoutListenerC0507j implements ViewTreeObserver.OnGlobalLayoutListener {
        private int cw;
        private final ViewGroup xt;

        private ViewTreeObserverOnGlobalLayoutListenerC0507j(ViewGroup viewGroup) {
            this.cw = 10;
            this.xt = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int width = this.xt.getWidth();
            int height = this.xt.getHeight();
            this.xt.removeAllViews();
            int i6 = this.cw;
            this.cw = i6 - 1;
            if (i6 < 0) {
                this.xt.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            if (width <= 0 || height <= 0) {
                this.xt.addView(j.this.f31905g);
            } else {
                this.xt.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                float f6 = j.this.f31912r / j.this.up;
                float f7 = width;
                float f8 = height;
                float f9 = f7 / f8;
                if (j.this.up <= 0 || f6 < f9) {
                    width = (int) (f8 * f6);
                } else {
                    height = (int) (f7 / f6);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
                layoutParams.gravity = 17;
                this.xt.addView(j.this.f31905g, layoutParams);
            }
            if (!j.this.f31915w || j.this.f31905g.up()) {
                return;
            }
            j.this.f31905g.j();
        }
    }

    static /* synthetic */ int f(j jVar) {
        int i6 = jVar.gq;
        jVar.gq = i6 + 1;
        return i6;
    }

    static /* synthetic */ int x(j jVar) {
        int i6 = jVar.la;
        jVar.la = i6 + 1;
        return i6;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public SurfaceHolder ae() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(SurfaceTexture surfaceTexture) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public SurfaceTexture tl() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void xt(boolean z5) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.bykv.vk.openvk.component.video.api.j jVar;
        vl.j("TTLottieFakeVideoPlayer", "--==--pause");
        LottieAnimationView lottieAnimationView = this.f31905g;
        if (lottieAnimationView != null && this.kt && lottieAnimationView.up()) {
            vl.j("TTLottieFakeVideoPlayer", "--==--pause --- enter");
            this.f31905g.ae();
        }
        if (this.kt && !this.f31904f && (jVar = this.az) != null && jVar.jy()) {
            vl.j("TTLottieFakeVideoPlayer", "--==--audio pause --- enter");
            this.az.cw();
        }
        this.mi = false;
        ch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch() {
        this.uf.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.bytedance.sdk.openadsdk.upie.j.xt.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.13
            @Override // java.lang.Runnable
            public void run() {
                if (!j.this.ch) {
                    vl.j("TTLottieFakeVideoPlayer", "--==--audio buffering start");
                    if (j.this.jy()) {
                        j.this.a();
                    }
                    Iterator it = j.this.f31907i.iterator();
                    while (it.hasNext()) {
                        ((j.InterfaceC0305j) it.next()).j(j.this, -1, -1, -1);
                    }
                }
                j.this.ch = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kt() {
        final ViewGroup viewGroup = (ViewGroup) this.f31910m.getView();
        viewGroup.removeAllViews();
        viewGroup.addView(this.f31905g);
        this.wq = new ViewTreeObserverOnGlobalLayoutListenerC0507j(viewGroup);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.wq);
        viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                ViewGroup viewGroup2 = viewGroup;
                if (viewGroup2 == view) {
                    viewGroup2.getViewTreeObserver().removeOnGlobalLayoutListener(j.this.wq);
                    viewGroup.removeOnAttachStateChangeListener(this);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.bykv.vk.openvk.component.video.api.j jVar;
        vl.j("TTLottieFakeVideoPlayer", "--==--play");
        LottieAnimationView lottieAnimationView = this.f31905g;
        if (lottieAnimationView != null && this.kt && !lottieAnimationView.up()) {
            vl.j("TTLottieFakeVideoPlayer", "--==--play --- enter");
            if (this.f31903a > 0) {
                this.f31905g.xt();
            } else {
                this.f31905g.j();
            }
        }
        if (this.kt && !this.f31904f && (jVar = this.az) != null && !jVar.jy()) {
            vl.j("TTLottieFakeVideoPlayer", "--==--audio play --- enter");
            if (this.f31903a > 0) {
                this.az.xt();
            } else {
                this.az.j(0L);
                this.az.xt();
            }
        }
        this.mi = true;
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj() {
        com.bytedance.sdk.openadsdk.upie.j.xt.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.8
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.oq == null || j.this.tl == null || !j.this.av || j.this.f31905g != null) {
                    return;
                }
                j.this.f31905g = new LottieAnimationView(j.this.ae);
                j.this.f31905g.j(j.this.tl, j.this.xt);
                j.this.f31905g.setRepeatCount(-1);
                j.this.f31905g.setSpeed(j.this.f31911p);
                j.this.f31905g.setTextDelegate(new kt(j.this.f31905g) { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.8.1
                    @Override // com.bytedance.adsdk.lottie.kt
                    public String j(String str) {
                        return com.bytedance.sdk.openadsdk.upie.j.j.j(str, j.this.ws != null ? j.this.ws : null);
                    }
                });
                j.this.f31905g.setImageAssetDelegate(new r() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.8.2
                    @Override // com.bytedance.adsdk.lottie.r
                    public Bitmap j(g gVar) {
                        if (gVar != null) {
                            String vl = gVar.vl();
                            if (!TextUtils.isEmpty(vl)) {
                                if (vl.startsWith("${") && vl.endsWith("}")) {
                                    vl = com.bytedance.sdk.openadsdk.upie.j.j.j(vl, j.this.ws);
                                    if (TextUtils.isEmpty(vl)) {
                                        return null;
                                    }
                                    if (!vl.startsWith(b.f50154a) || TextUtils.equals(vl, j.this.jy)) {
                                        Bitmap bitmap = j.this.oq;
                                        if (bitmap != null && (bitmap.getWidth() != gVar.j() || bitmap.getHeight() != gVar.xt())) {
                                            j.this.oq = Bitmap.createScaledBitmap(bitmap, gVar.j(), gVar.xt(), false);
                                        }
                                        return j.this.oq;
                                    }
                                }
                                Bitmap bitmap2 = (Bitmap) j.this.qv.get(vl);
                                if (bitmap2 != null) {
                                    return bitmap2;
                                }
                                j.this.j(vl, gVar.j(), gVar.xt());
                            }
                        }
                        return null;
                    }
                });
                j.this.kt();
                j.this.kt = true;
                vl.j("TTLottieFakeVideoPlayer", "--==--onPrepared");
                j.this.rn = SystemClock.elapsedRealtime() - j.this.rn;
                for (j.InterfaceC0305j interfaceC0305j : j.this.f31907i) {
                    interfaceC0305j.xt(j.this);
                    j jVar = j.this;
                    interfaceC0305j.j((com.bykv.vk.openvk.component.video.api.j) jVar, jVar.f31912r, j.this.up);
                }
                if (j.this.f31915w) {
                    j.this.az.j(j.this.f31906h);
                    j.this.az.cw(true);
                    if (j.this.f31909l > 0) {
                        j jVar2 = j.this;
                        jVar2.xt(jVar2.f31909l);
                    } else {
                        j.this.xt();
                    }
                }
                for (j.InterfaceC0305j interfaceC0305j2 : j.this.f31907i) {
                    j jVar3 = j.this;
                    interfaceC0305j2.j(jVar3, jVar3.rn);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.bytedance.sdk.openadsdk.upie.j.xt.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.15
            @Override // java.lang.Runnable
            public void run() {
                vl.j("TTLottieFakeVideoPlayer", "--==--audio buffering end");
                j.this.ch = false;
                if (j.this.ws()) {
                    j.this.s();
                }
                Iterator it = j.this.f31907i.iterator();
                while (it.hasNext()) {
                    ((j.InterfaceC0305j) it.next()).j((com.bykv.vk.openvk.component.video.api.j) j.this, -1);
                }
            }
        });
    }

    private void x() {
        this.uf.removeCallbacksAndMessages(null);
        this.uf.post(this.ed);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public long av() {
        if (!this.kt) {
            vl.j("TTLottieFakeVideoPlayer", "--==--is not prepared, getTotalBufferTime: 0");
            return 0L;
        }
        vl.j("TTLottieFakeVideoPlayer", "--==--getTotalBufferTime: " + this.rn);
        return this.rn;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean az() {
        vl.j("TTLottieFakeVideoPlayer", "--==--isReleased: " + this.f31904f);
        return this.f31904f;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean g() {
        vl.j("TTLottieFakeVideoPlayer", "--==--isCompleted: " + this.tj);
        return this.tj;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public int i() {
        vl.j("TTLottieFakeVideoPlayer", "--==--getBufferCount: 1");
        return 1;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(SurfaceHolder surfaceHolder) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean jy() {
        vl.j("TTLottieFakeVideoPlayer", "--==--isPlaying: " + this.mi);
        return this.mi;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public long mi() {
        vl.j("TTLottieFakeVideoPlayer", "--==--getCurrentPosition: " + this.f31903a);
        return this.f31903a;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean oq() {
        vl.j("TTLottieFakeVideoPlayer", "--==--isStarted: " + this.f31915w);
        return this.f31915w;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public int qv() {
        vl.j("TTLottieFakeVideoPlayer", "--==--getVideoWidth: " + this.f31912r);
        return this.f31912r;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public int vl() {
        vl.j("TTLottieFakeVideoPlayer", "--==--getVideoHeight: " + this.up);
        return this.up;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public long w() {
        return this.cw;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean ws() {
        boolean z5 = (this.mi || this.tj || this.f31904f || !this.kt) ? false : true;
        vl.j("TTLottieFakeVideoPlayer", "--==--isPaused: ".concat(String.valueOf(z5)));
        return z5;
    }

    public j(com.bykv.vk.openvk.component.video.api.renderview.xt xtVar, com.bytedance.sdk.openadsdk.upie.j jVar, com.bykv.vk.openvk.component.video.api.j jVar2, com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        this.ae = xtVar.getView().getContext();
        this.f31910m = xtVar;
        this.cw = jVar.m();
        this.f31912r = jVar.r();
        this.up = jVar.up();
        String cw = jVar.cw();
        this.jy = cw;
        String j6 = jVar.j();
        this.xt = j6;
        String xt = jVar.xt();
        this.ws = jVar.ae();
        j(j6);
        xt(cw);
        this.az = jVar2;
        j(xt, rVar);
    }

    private void r(final boolean z5) {
        com.bytedance.sdk.openadsdk.upie.j.xt.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.2
            @Override // java.lang.Runnable
            public void run() {
                vl.j("TTLottieFakeVideoPlayer", "--==--seek completed");
                Iterator it = j.this.f31907i.iterator();
                while (it.hasNext()) {
                    ((j.InterfaceC0305j) it.next()).j(j.this, z5);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean m() {
        vl.j("TTLottieFakeVideoPlayer", "--==--isFirstFrameSuccess: " + this.kt);
        return this.kt;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void up() {
        vl.j("TTLottieFakeVideoPlayer", "--==--release");
        this.f31904f = true;
        ch();
        this.qv.clear();
        this.oq = null;
        com.bykv.vk.openvk.component.video.api.j jVar = this.az;
        if (jVar != null) {
            if (this.kt) {
                jVar.r();
            }
            this.az.up();
        }
        com.bytedance.sdk.openadsdk.upie.j.xt.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.7
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) j.this.f31910m.getView();
                if (viewGroup != null) {
                    viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(j.this.wq);
                }
                Iterator it = j.this.f31907i.iterator();
                while (it.hasNext()) {
                    ((j.InterfaceC0305j) it.next()).cw(j.this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(final int i6) {
        com.bytedance.sdk.openadsdk.upie.j.xt.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.14
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = j.this.f31907i.iterator();
                while (it.hasNext()) {
                    ((j.InterfaceC0305j) it.next()).xt(j.this, i6);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void r() {
        com.bykv.vk.openvk.component.video.api.j jVar;
        vl.j("TTLottieFakeVideoPlayer", "--==--stop");
        LottieAnimationView lottieAnimationView = this.f31905g;
        if (lottieAnimationView != null) {
            lottieAnimationView.m();
            this.f31915w = false;
        }
        if (this.kt && !this.f31904f && (jVar = this.az) != null && jVar.jy()) {
            this.az.cw();
        }
        ch();
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void cw() {
        a();
        com.bytedance.sdk.openadsdk.upie.j.xt.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.6
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = j.this.f31907i.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(final String str) {
        if (TextUtils.isEmpty(str)) {
            j(new com.bykv.vk.openvk.component.video.api.cw.xt(60008, 10002, "广告主图url为空"));
        } else {
            com.bytedance.sdk.openadsdk.upie.xt.j().xt(str, new xt.j<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.10
                @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                public void j(Bitmap bitmap) {
                    j.this.oq = bitmap;
                    j.this.tj();
                }

                @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                public void j(int i6, String str2) {
                    j.x(j.this);
                    if (j.this.la <= 3) {
                        j.this.xt(str);
                    } else {
                        j.this.j(new com.bykv.vk.openvk.component.video.api.cw.xt(60008, 10003, "广告主图url加载失败"));
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void cw(boolean z5) {
        vl.j("TTLottieFakeVideoPlayer", "--==--setLoop:".concat(String.valueOf(z5)));
        this.f31914v = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(long j6) {
        LottieAnimationView lottieAnimationView = this.f31905g;
        if (lottieAnimationView != null) {
            lottieAnimationView.j();
        }
        j(j6);
        com.bykv.vk.openvk.component.video.api.j jVar = this.az;
        if (jVar != null) {
            jVar.xt();
        }
        this.mi = true;
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final String str) {
        if (TextUtils.isEmpty(str)) {
            j(new com.bykv.vk.openvk.component.video.api.cw.xt(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.bytedance.sdk.openadsdk.upie.j.xt.cw(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.9
                @Override // java.lang.Runnable
                public void run() {
                    String j6 = com.bytedance.sdk.openadsdk.upie.xt.j().j(str);
                    if (!TextUtils.isEmpty(j6)) {
                        j.this.tl = j6;
                        j.this.tj();
                    } else {
                        com.bytedance.sdk.openadsdk.upie.xt.j().j(str, new xt.j<String>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.9.1
                            @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                            public void j(String str2) {
                                vl.j("TTLottieFakeVideoPlayer", "--==-- lottie jsonStr ok");
                                j.this.tl = str2;
                                j.this.tj();
                            }

                            @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                            public void j(int i6, String str2) {
                                vl.j("TTLottieFakeVideoPlayer", "--==-- lottie jsonStr load fail: " + i6 + ", " + str2);
                                if (i6 == 10006) {
                                    j.this.j(new com.bykv.vk.openvk.component.video.api.cw.xt(60008, i6, str2));
                                    return;
                                }
                                j.f(j.this);
                                if (j.this.gq <= 3) {
                                    AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                    j.this.j(str);
                                } else {
                                    j.this.j(new com.bykv.vk.openvk.component.video.api.cw.xt(60008, i6, str2));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final String str, final int i6, final int i7) {
        Integer num = this.vl.get(str);
        if (num == null || num.intValue() != 1) {
            this.vl.put(str, 1);
            com.bytedance.sdk.openadsdk.upie.xt.j().j(this.ae, str, new xt.j<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.11
                @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                public void j(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (bitmap.getWidth() != i6 || bitmap.getHeight() != i7) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, i6, i7, false);
                        }
                        j.this.qv.put(str, bitmap);
                        com.bytedance.sdk.openadsdk.upie.j.xt.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (j.this.f31905g != null) {
                                    j.this.f31905g.invalidate();
                                }
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                public void j(int i8, String str2) {
                    j.this.vl.put(str, 2);
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void xt() {
        s();
        if (this.f31903a > 0) {
            com.bytedance.sdk.openadsdk.upie.j.xt.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.5
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = j.this.f31907i.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final com.bykv.vk.openvk.component.video.api.cw.xt xtVar) {
        com.bytedance.sdk.openadsdk.upie.j.xt.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.12
            @Override // java.lang.Runnable
            public void run() {
                if (!j.this.f31916x) {
                    vl.j("TTLottieFakeVideoPlayer", "--==--play err, code: " + xtVar.j() + ", extra: " + xtVar.xt() + ", msg: " + xtVar.cw());
                    Iterator it = j.this.f31907i.iterator();
                    while (it.hasNext()) {
                        ((j.InterfaceC0305j) it.next()).j(j.this, xtVar);
                    }
                }
                j.this.f31916x = true;
            }
        });
    }

    private void j(String str, com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        if (TextUtils.isEmpty(str)) {
            j(new com.bykv.vk.openvk.component.video.api.cw.xt(60008, 10004, "lottie音频url为空"));
        } else {
            this.az.j(new j.InterfaceC0305j() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.j.3
                @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
                public void j(com.bykv.vk.openvk.component.video.api.j jVar) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
                public void xt(com.bykv.vk.openvk.component.video.api.j jVar) {
                    j.this.av = true;
                    j.this.tj();
                }

                @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
                public void j(com.bykv.vk.openvk.component.video.api.j jVar, int i6, int i7) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
                public void j(com.bykv.vk.openvk.component.video.api.j jVar, long j6) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
                public void xt(com.bykv.vk.openvk.component.video.api.j jVar, int i6) {
                    j.this.cw(i6);
                }

                @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
                public void j(com.bykv.vk.openvk.component.video.api.j jVar, long j6, long j7) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
                public void j(com.bykv.vk.openvk.component.video.api.j jVar, JSONObject jSONObject, String str2) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
                public void j(com.bykv.vk.openvk.component.video.api.j jVar, boolean z5) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
                public void j(com.bykv.vk.openvk.component.video.api.j jVar, com.bykv.vk.openvk.component.video.api.cw.xt xtVar) {
                    int i6;
                    String str2;
                    int i7;
                    if (xtVar != null) {
                        i6 = xtVar.j();
                        i7 = xtVar.xt();
                        str2 = xtVar.cw();
                    } else {
                        i6 = -1;
                        str2 = "";
                        i7 = -1;
                    }
                    j.this.j(new com.bykv.vk.openvk.component.video.api.cw.xt(i6, i7, "lottie音频播放失败:".concat(String.valueOf(str2))));
                }

                @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
                public void j(com.bykv.vk.openvk.component.video.api.j jVar, int i6, int i7, int i8) {
                    j.this.f();
                }

                @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
                public void j(com.bykv.vk.openvk.component.video.api.j jVar, int i6) {
                    j.this.v();
                }

                @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
                public void cw(com.bykv.vk.openvk.component.video.api.j jVar) {
                }
            });
            this.az.j(rVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void xt(int i6) {
        this.f31913s = i6;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        vl.j("TTLottieFakeVideoPlayer", "--==--setDataSource: ".concat(String.valueOf(rVar)));
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(boolean z5) {
        vl.j("TTLottieFakeVideoPlayer", "--==--setQuietPlay: ".concat(String.valueOf(z5)));
        this.f31906h = z5;
        com.bykv.vk.openvk.component.video.api.j jVar = this.az;
        if (jVar != null) {
            jVar.j(z5);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(long j6) {
        vl.j("TTLottieFakeVideoPlayer", "--==--seekTo: ".concat(String.valueOf(j6)));
        this.f31903a = (int) j6;
        LottieAnimationView lottieAnimationView = this.f31905g;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = w();
            }
            if (duration > 0) {
                this.f31905g.setProgress((j6 % duration) / duration);
            }
        }
        com.bykv.vk.openvk.component.video.api.j jVar = this.az;
        if (jVar != null && jVar.w() > 0) {
            this.az.j((int) (j6 % this.az.w()));
        }
        r(true);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(int i6) {
        vl.j("TTLottieFakeVideoPlayer", "--==--setSeekMode: ".concat(String.valueOf(i6)));
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(boolean z5, long j6, boolean z6) {
        vl.j("TTLottieFakeVideoPlayer", "--==--start: " + z5 + ", " + j6 + ", " + z6);
        this.f31906h = z6;
        this.f31915w = true;
        this.f31909l = j6;
        this.az.j(z5, j6, z6);
        if (this.kt) {
            this.az.j(z6);
            this.az.cw(true);
            if (j6 > 0) {
                xt(j6);
            } else {
                xt();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j() {
        vl.j("TTLottieFakeVideoPlayer", "--==--reStart");
        ch();
        this.f31903a = 0;
        this.kt = true;
        this.tj = false;
        this.f31904f = false;
        LottieAnimationView lottieAnimationView = this.f31905g;
        if (lottieAnimationView != null) {
            lottieAnimationView.m();
            this.f31905g.setProgress(0.0f);
        }
        xt();
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(j.InterfaceC0305j interfaceC0305j) {
        this.f31907i.add(interfaceC0305j);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(float f6) {
        this.f31911p = f6;
    }
}
