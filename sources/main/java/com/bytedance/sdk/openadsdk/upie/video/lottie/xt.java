package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.cw.r;
import com.bykv.vk.openvk.component.video.api.j;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.upie.xt;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements com.bykv.vk.openvk.component.video.api.j {
    private final int cw;

    /* renamed from: g, reason: collision with root package name */
    private final com.bykv.vk.openvk.component.video.api.j f31938g;

    /* renamed from: m, reason: collision with root package name */
    private long f31940m;
    private final com.bykv.vk.openvk.component.video.api.renderview.xt qv;

    /* renamed from: r, reason: collision with root package name */
    private boolean f31941r;
    private LottieAnimationView vl;
    private final int xt;

    /* renamed from: j, reason: collision with root package name */
    private final String f31939j = "UpieVideoPlayer";
    private int up = 0;
    private volatile boolean ae = false;
    private volatile boolean tl = false;
    private final Map<j.InterfaceC0305j, j.InterfaceC0305j> oq = new ConcurrentHashMap();

    static /* synthetic */ int j(xt xtVar) {
        int i6 = xtVar.up;
        xtVar.up = i6 + 1;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kt() {
        com.bytedance.sdk.openadsdk.upie.j.xt.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xt.4
            @Override // java.lang.Runnable
            public void run() {
                if (xt.this.tl && xt.this.ae) {
                    xt.this.f31938g.xt();
                    if (xt.this.vl != null) {
                        xt.this.vl.j();
                        if (xt.this.f31940m > 0) {
                            xt xtVar = xt.this;
                            xtVar.xt(xtVar.f31940m);
                        }
                    }
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public SurfaceHolder ae() {
        return this.f31938g.ae();
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public long av() {
        return this.f31938g.av();
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean az() {
        boolean z5 = !this.f31941r && this.f31938g.az();
        vl.j("UpieVideoPlayer", "--==--isReleased: " + z5 + ",      errorInvoked: " + this.f31941r);
        return z5;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean g() {
        boolean z5 = !this.f31941r && this.f31938g.g();
        vl.j("UpieVideoPlayer", "--==--isCompleted: " + z5 + ",      errorInvoked: " + this.f31941r);
        return z5;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public int i() {
        return this.f31938g.i();
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean jy() {
        boolean z5 = !this.f31941r && this.f31938g.jy();
        vl.j("UpieVideoPlayer", "--==--isPlaying: " + z5 + ",      errorInvoked: " + this.f31941r);
        return z5;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean m() {
        return this.f31938g.m();
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public long mi() {
        return this.f31938g.mi();
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean oq() {
        boolean z5 = !this.f31941r && this.f31938g.oq();
        vl.j("UpieVideoPlayer", "--==--isStarted: " + z5 + ",      errorInvoked: " + this.f31941r);
        return z5;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public int qv() {
        return this.xt;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void r() {
        vl.j("UpieVideoPlayer", "--==--stop");
        this.f31938g.r();
        LottieAnimationView lottieAnimationView = this.vl;
        if (lottieAnimationView != null) {
            lottieAnimationView.ae();
        }
        com.bykv.vk.openvk.component.video.api.renderview.xt xtVar = this.qv;
        if (xtVar instanceof UpieVideoView) {
            ((UpieVideoView) xtVar).xt();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public SurfaceTexture tl() {
        return this.f31938g.tl();
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void up() {
        vl.j("UpieVideoPlayer", "--==--release");
        this.f31938g.up();
        LottieAnimationView lottieAnimationView = this.vl;
        if (lottieAnimationView != null) {
            lottieAnimationView.m();
        }
        com.bykv.vk.openvk.component.video.api.renderview.xt xtVar = this.qv;
        if (xtVar instanceof UpieVideoView) {
            ((UpieVideoView) xtVar).xt();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public int vl() {
        return this.cw;
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public long w() {
        return this.f31938g.w();
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public boolean ws() {
        boolean z5 = !this.f31941r && this.f31938g.ws();
        vl.j("UpieVideoPlayer", "--==--isPaused: " + z5 + ",      errorInvoked: " + this.f31941r);
        return z5;
    }

    public xt(com.bykv.vk.openvk.component.video.api.j jVar, com.bytedance.sdk.openadsdk.upie.j jVar2, com.bykv.vk.openvk.component.video.api.renderview.xt xtVar) {
        this.f31938g = jVar;
        this.xt = jVar2.r();
        this.cw = jVar2.up();
        this.qv = xtVar;
        if (xtVar instanceof UpieVideoView) {
            this.vl = ((UpieVideoView) xtVar).getLottieAnimationView();
        }
        j(jVar2.j());
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void cw() {
        vl.j("UpieVideoPlayer", "--==--pause");
        this.f31938g.cw();
        LottieAnimationView lottieAnimationView = this.vl;
        if (lottieAnimationView != null) {
            lottieAnimationView.ae();
        }
        com.bykv.vk.openvk.component.video.api.renderview.xt xtVar = this.qv;
        if (xtVar instanceof UpieVideoView) {
            ((UpieVideoView) xtVar).xt();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void xt() {
        vl.j("UpieVideoPlayer", "--==--play");
        this.f31938g.xt();
        LottieAnimationView lottieAnimationView = this.vl;
        if (lottieAnimationView != null) {
            lottieAnimationView.xt();
        }
        com.bykv.vk.openvk.component.video.api.renderview.xt xtVar = this.qv;
        if (xtVar instanceof UpieVideoView) {
            ((UpieVideoView) xtVar).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final String str) {
        if (TextUtils.isEmpty(str)) {
            j(new com.bykv.vk.openvk.component.video.api.cw.xt(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.bytedance.sdk.openadsdk.upie.j.xt.cw(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xt.1
                @Override // java.lang.Runnable
                public void run() {
                    String j6 = com.bytedance.sdk.openadsdk.upie.xt.j().j(str);
                    if (!TextUtils.isEmpty(j6)) {
                        vl.j("UpieVideoPlayer", "--==-- lottie use cache ok");
                        xt.this.j(j6, str);
                    } else {
                        com.bytedance.sdk.openadsdk.upie.xt.j().j(str, new xt.j<String>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xt.1.1
                            @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                            public void j(String str2) {
                                vl.j("UpieVideoPlayer", "--==-- lottie load jsonStr ok");
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                xt.this.j(str2, str);
                            }

                            @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                            public void j(int i6, String str2) {
                                vl.j("UpieVideoPlayer", "--==-- lottie jsonStr load fail: " + i6 + ", " + str2);
                                if (i6 == 10006) {
                                    xt.this.j(new com.bykv.vk.openvk.component.video.api.cw.xt(60008, i6, str2));
                                    return;
                                }
                                xt.j(xt.this);
                                if (xt.this.up <= 3) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    xt.this.j(str);
                                } else {
                                    xt.this.j(new com.bykv.vk.openvk.component.video.api.cw.xt(60008, i6, str2));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(long j6) {
        LottieAnimationView lottieAnimationView = this.vl;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = w();
            }
            if (duration > 0) {
                this.vl.setProgress((j6 % duration) / duration);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void cw(boolean z5) {
        this.f31938g.cw(z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final com.bykv.vk.openvk.component.video.api.cw.xt xtVar) {
        com.bytedance.sdk.openadsdk.upie.j.xt.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xt.2
            @Override // java.lang.Runnable
            public void run() {
                if (xt.this.f31941r) {
                    return;
                }
                xt.this.f31941r = true;
                vl.j("UpieVideoPlayer", "--==--play err, code: " + xtVar.j() + ", extra: " + xtVar.xt() + ", msg: " + xtVar.cw());
                Iterator it = xt.this.oq.entrySet().iterator();
                while (it.hasNext()) {
                    ((j.InterfaceC0305j) ((Map.Entry) it.next()).getKey()).j(xt.this, xtVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final String str, final String str2) {
        com.bytedance.sdk.openadsdk.upie.j.xt.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xt.3
            @Override // java.lang.Runnable
            public void run() {
                xt.this.ae = true;
                if (xt.this.vl != null) {
                    xt.this.vl.j(str, str2);
                }
                xt.this.kt();
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(r rVar) {
        vl.j("UpieVideoPlayer", "--==--setDataSource: ".concat(String.valueOf(rVar)));
        this.f31938g.j(rVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void xt(boolean z5) {
        this.f31938g.xt(z5);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(boolean z5) {
        vl.j("UpieVideoPlayer", "--==--isMute: ".concat(String.valueOf(z5)));
        this.f31938g.j(z5);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void xt(int i6) {
        this.f31938g.xt(i6);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(int i6) {
        vl.j("UpieVideoPlayer", "--==--setSeekMode: ".concat(String.valueOf(i6)));
        this.f31938g.j(i6);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(boolean z5, long j6, boolean z6) {
        vl.j("UpieVideoPlayer", "--==--start: " + z5 + ", " + j6 + ", " + z6);
        this.f31938g.j(z5, j6, z6);
        this.f31940m = j6;
        com.bykv.vk.openvk.component.video.api.renderview.xt xtVar = this.qv;
        if (xtVar instanceof UpieVideoView) {
            ((UpieVideoView) xtVar).j();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j() {
        vl.j("UpieVideoPlayer", "--==--restart");
        this.f31938g.j();
        LottieAnimationView lottieAnimationView = this.vl;
        if (lottieAnimationView != null) {
            lottieAnimationView.m();
            this.vl.setProgress(0.0f);
            this.vl.j();
        }
        com.bykv.vk.openvk.component.video.api.renderview.xt xtVar = this.qv;
        if (xtVar instanceof UpieVideoView) {
            ((UpieVideoView) xtVar).j();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(long j6) {
        vl.j("UpieVideoPlayer", "--==--seekTo: ".concat(String.valueOf(j6)));
        this.f31938g.j(j6);
        xt(j6);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(SurfaceHolder surfaceHolder) {
        this.f31938g.j(surfaceHolder);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(SurfaceTexture surfaceTexture) {
        this.f31938g.j(surfaceTexture);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(final j.InterfaceC0305j interfaceC0305j) {
        if (interfaceC0305j == null) {
            return;
        }
        j.InterfaceC0305j interfaceC0305j2 = new j.InterfaceC0305j() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xt.5
            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar) {
                interfaceC0305j.j(xt.this);
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void xt(com.bykv.vk.openvk.component.video.api.j jVar) {
                com.bytedance.sdk.openadsdk.upie.j.xt.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xt.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        xt.this.tl = true;
                        if (!xt.this.ae) {
                            xt.this.f31938g.cw();
                        }
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        interfaceC0305j.xt(xt.this);
                        xt.this.kt();
                    }
                });
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void cw(com.bykv.vk.openvk.component.video.api.j jVar) {
                interfaceC0305j.cw(xt.this);
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, final long j6) {
                com.bytedance.sdk.openadsdk.upie.j.xt.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xt.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        interfaceC0305j.j(xt.this, j6);
                    }
                });
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void xt(com.bykv.vk.openvk.component.video.api.j jVar, int i6) {
                interfaceC0305j.xt(xt.this, i6);
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, com.bykv.vk.openvk.component.video.api.cw.xt xtVar) {
                xt.this.j(xtVar);
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, boolean z5) {
                interfaceC0305j.j(xt.this, z5);
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, int i6, int i7) {
                j.InterfaceC0305j interfaceC0305j3 = interfaceC0305j;
                xt xtVar = xt.this;
                interfaceC0305j3.j((com.bykv.vk.openvk.component.video.api.j) xtVar, xtVar.xt, xt.this.cw);
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, int i6, int i7, int i8) {
                interfaceC0305j.j(xt.this, i6, i7, i8);
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, int i6) {
                interfaceC0305j.j((com.bykv.vk.openvk.component.video.api.j) xt.this, i6);
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, long j6, long j7) {
                interfaceC0305j.j(xt.this, j6, j7);
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, JSONObject jSONObject, String str) {
                interfaceC0305j.j(xt.this, jSONObject, str);
            }
        };
        this.oq.put(interfaceC0305j, interfaceC0305j2);
        this.f31938g.j(interfaceC0305j2);
    }

    @Override // com.bykv.vk.openvk.component.video.api.j
    public void j(float f6) {
        this.f31938g.j(f6);
        LottieAnimationView lottieAnimationView = this.vl;
        if (lottieAnimationView != null) {
            lottieAnimationView.setSpeed(f6);
        }
    }
}
