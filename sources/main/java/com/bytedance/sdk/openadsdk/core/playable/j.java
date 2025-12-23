package com.bytedance.sdk.openadsdk.core.playable;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.ol;
import com.bytedance.sdk.openadsdk.core.video.xt.j;
import com.bytedance.sdk.openadsdk.l.oq;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements l.j {
    private PlayableVideoContainer ae;
    private final n cw;

    /* renamed from: j, reason: collision with root package name */
    private final String f29854j;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f29855m;
    private boolean qv;
    private cw tl;
    private final int up;
    private final com.bytedance.sdk.openadsdk.core.video.xt.xt ws;
    private final Context xt;

    /* renamed from: r, reason: collision with root package name */
    private final l f29856r = new l(Looper.getMainLooper(), this);

    /* renamed from: g, reason: collision with root package name */
    private boolean f29853g = false;
    private boolean oq = true;
    private boolean vl = false;
    private boolean jy = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void tl() {
        this.vl = true;
        if (this.qv) {
            this.qv = false;
            xt();
        }
        j(this.oq);
    }

    private void ae() {
        ed.j((View) this.f29855m, 0);
        ed.j((View) this.ae, 0);
    }

    private void g() {
        PlayableVideoContainer playableVideoContainer = this.ae;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.xt(true);
        this.f29856r.sendEmptyMessageDelayed(1, 2000L);
    }

    private void m() {
        ed.j((View) this.f29855m, 8);
        ed.j((View) this.ae, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oq() {
        if (this.ae == null || this.f29855m == null) {
            return;
        }
        ae();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ae, "translationX", -ed.cw(this.xt, 150.0f), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ae, "translationY", -ed.cw(this.xt, 100.0f), 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.ae, "alpha", 0.1f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(500L);
        animatorSet.start();
    }

    private void up() {
        if (this.f29855m == null) {
            return;
        }
        if (ol.j(this.cw, this.up) == 1) {
            PlayableVideoContainer playableVideoContainer = new PlayableVideoContainer(this.xt);
            playableVideoContainer.setBackgroundColor(0);
            playableVideoContainer.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ed.cw(this.xt, 156.0f), ed.cw(this.xt, 87.0f));
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = ed.cw(this.xt, 55.0f);
            layoutParams.rightMargin = ed.cw(this.xt, 20.0f);
            this.f29855m.addView(playableVideoContainer, layoutParams);
            this.ae = playableVideoContainer;
            return;
        }
        PlayableVideoContainer playableVideoContainer2 = new PlayableVideoContainer(this.xt);
        playableVideoContainer2.setBackgroundColor(0);
        playableVideoContainer2.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ed.cw(this.xt, 73.0f), ed.cw(this.xt, 130.0f));
        layoutParams2.gravity = 8388661;
        layoutParams2.topMargin = ed.cw(this.xt, 55.0f);
        layoutParams2.rightMargin = ed.cw(this.xt, 30.0f);
        this.f29855m.addView(playableVideoContainer2, layoutParams2);
        this.ae = playableVideoContainer2;
    }

    public void cw() {
        if (this.jy && this.f29853g && this.tl != null) {
            this.qv = false;
            this.f29856r.sendEmptyMessageDelayed(1, 2000L);
            if (this.tl.sm()) {
                return;
            }
            this.tl.tl();
        }
    }

    public void j(long j6, boolean z5) {
        PlayableVideoContainer playableVideoContainer;
        this.jy = true;
        this.oq = z5;
        j(j6);
        if (this.f29853g) {
            if (this.ws != null && (playableVideoContainer = this.ae) != null) {
                playableVideoContainer.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.oq();
                    }
                }, 500L);
                this.ae.setCustomClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.j.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.this.f29855m != null) {
                            j.this.j();
                            j.this.ws.xt();
                        }
                    }
                });
            } else if (oq.j(this.cw)) {
                m();
            } else {
                ae();
            }
        }
    }

    public void r() {
        cw cwVar = this.tl;
        if (cwVar == null) {
            return;
        }
        cwVar.oq();
        this.tl = null;
        this.f29853g = false;
        this.qv = false;
        this.vl = false;
    }

    public void xt() {
        if (this.jy && this.f29853g && this.tl != null) {
            this.f29856r.removeMessages(1);
            if (this.vl) {
                this.tl.m();
            } else {
                this.qv = true;
            }
        }
    }

    public j(String str, Activity activity, n nVar, int i6, com.bytedance.sdk.openadsdk.core.video.xt.xt xtVar, FrameLayout frameLayout) {
        this.f29854j = str;
        this.xt = activity;
        this.cw = nVar;
        this.up = i6;
        if (!kt.r(nVar)) {
            this.f29855m = frameLayout;
        }
        up();
        this.ws = xtVar;
    }

    public void j() {
        this.jy = false;
        r();
        m();
    }

    private void j(long j6) {
        if (this.ae == null) {
            return;
        }
        if (this.ws != null || oq.j(this.cw)) {
            if (this.f29853g) {
                cw cwVar = this.tl;
                if (cwVar != null) {
                    cwVar.xt(j6);
                    this.tl.j(j6);
                    return;
                }
                return;
            }
            this.f29853g = true;
            com.bykv.vk.openvk.component.video.api.cw.r j7 = ln.j(1, this.cw, this.up);
            j7.xt(this.cw.fs());
            j7.xt(this.ae.getWidth());
            j7.cw(this.ae.getHeight());
            j7.cw(this.cw.os());
            j7.j(j6);
            j7.xt(this.oq);
            if (oq.j(this.cw)) {
                j7.j(true);
            }
            cw cwVar2 = new cw(this.xt, this.ae.getVideoContainer(), this.cw, null);
            this.tl = cwVar2;
            cwVar2.j(new j.InterfaceC0494j() { // from class: com.bytedance.sdk.openadsdk.core.playable.j.3
                @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
                public void j() {
                    if (j.this.ws != null) {
                        j.this.j();
                        j.this.ws.cw();
                    } else {
                        if (!oq.j(j.this.cw) || j.this.tl == null || j.this.tl.up()) {
                            return;
                        }
                        j.this.j();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
                public void cw() {
                    j.this.tl();
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
                public void xt() {
                    j.this.ae.j(true);
                    if (j.this.ws != null) {
                        j.this.ws.oq();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
                public void j(int i6, String str) {
                    if (i6 == 308) {
                        return;
                    }
                    j.this.ae.j(true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
                public void j(long j8, long j9) {
                    j.this.ae.j(false);
                    if (j.this.ws != null) {
                        j.this.ws.j(j8, j9);
                    }
                }
            });
            this.tl.xt(j6);
            this.tl.j(j7);
            if (this.ws != null) {
                this.tl.x();
                this.tl.ae(false);
                this.ae.j();
            } else {
                if (oq.j(this.cw)) {
                    this.tl.ae(true);
                }
                g();
            }
        }
    }

    public void j(boolean z5) {
        cw cwVar = this.tl;
        if (cwVar == null) {
            return;
        }
        this.oq = z5;
        cwVar.xt(z5);
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        PlayableVideoContainer playableVideoContainer = this.ae;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.xt(false);
    }
}
