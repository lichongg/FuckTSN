package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.j;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ugeno.ae.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends xt {
    private com.bytedance.sdk.openadsdk.core.ugeno.tl.j av;
    private com.bytedance.sdk.openadsdk.core.ugeno.g.r az;

    /* renamed from: f, reason: collision with root package name */
    private AtomicBoolean f28315f;

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.g.xt f28316i;
    private com.bytedance.sdk.openadsdk.core.ugeno.m.j jy;
    private RewardLpBottomView kt;
    private String mi;
    private AtomicBoolean tj;

    /* renamed from: v, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.xt.up f28317v;

    /* renamed from: w, reason: collision with root package name */
    private AtomicBoolean f28318w;
    private com.bytedance.sdk.openadsdk.core.jy.up ws;

    /* renamed from: x, reason: collision with root package name */
    private boolean f28319x;

    private void i() {
        com.bytedance.sdk.openadsdk.core.ugeno.g.r rVar = new com.bytedance.sdk.openadsdk.core.ugeno.g.r(this.xt, this.ae, this.ws, this.cw, this.mi, uf.xt(this.f28350j));
        this.az = rVar;
        rVar.xt(true);
        this.az.j(new com.bytedance.sdk.openadsdk.core.ugeno.r.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.j.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.j
            public void j(View view) {
                j.this.xt.ae(8);
                j.this.f28318w.set(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.j
            public void j(int i6) {
                tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.j.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.xt.ae(8);
                        j.this.xt.w();
                    }
                });
                j.this.f28318w.set(false);
            }
        });
        this.az.jy();
    }

    private ViewGroup kt() {
        if (this.ae == null) {
            return null;
        }
        PlayableEndcardFrameLayout playableEndcardFrameLayout = new PlayableEndcardFrameLayout(this.xt);
        this.ae.addView(playableEndcardFrameLayout);
        this.kt = new RewardLpBottomView(this.xt);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.ae.addView(this.kt, layoutParams);
        this.kt.j(this.cw, this.mi);
        playableEndcardFrameLayout.j(new PlayableEndcardFrameLayout.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.j.9
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout.j
            public void j() {
                if (j.this.kt != null) {
                    j.this.kt.xt();
                }
            }
        });
        return playableEndcardFrameLayout;
    }

    private void mi() {
        com.bytedance.sdk.openadsdk.core.ugeno.tl.j jVar = new com.bytedance.sdk.openadsdk.core.ugeno.tl.j(this.xt, kt(), this.jy, this.cw);
        this.av = jVar;
        jVar.j(this.xt.nd());
        this.av.j(new com.bytedance.sdk.openadsdk.core.ugeno.r.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.j.8
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.j
            public void j(View view) {
                com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.j.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.xt.ae(8);
                        j.this.f28318w.set(true);
                        if (j.this.kt != null) {
                            j.this.kt.j();
                        }
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.j
            public void j(int i6) {
                tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.j.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.xt.ae(8);
                        j.this.xt.w();
                    }
                });
                j.this.f28318w.set(false);
            }
        });
        this.av.j();
    }

    private void w() {
        FrameLayout frameLayout = new FrameLayout(this.xt);
        this.ae.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ugeno.g.xt xtVar = new com.bytedance.sdk.openadsdk.core.ugeno.g.xt(this.xt, frameLayout, this.ws, this.cw, this.mi, uf.xt(this.f28350j));
        this.f28316i = xtVar;
        xtVar.xt(true);
        this.f28316i.j(new com.bytedance.sdk.openadsdk.core.ugeno.ae.xt() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.j.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.xt
            public void j() {
                j.this.xt.gx();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.xt
            public void xt() {
                j.this.xt.n();
                j.this.tj.set(true);
                j.this.f28316i.kt();
            }
        });
        this.f28316i.j(new com.bytedance.sdk.openadsdk.core.ugeno.r.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.j.4
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.j
            public void j(View view) {
                j.this.xt.ae(8);
                j.this.f28318w.set(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.j
            public void j(int i6) {
                tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.j.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.xt.ae(8);
                        j.this.f28316i.i();
                        j.this.f28316i.j(kt.j(j.this.xt, "tt_ecomm_page_reward_acquire"));
                        j.this.xt.r(0);
                    }
                });
                j.this.f28318w.set(false);
            }
        });
        this.f28316i.j(new j.InterfaceC0478j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.j.5
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.j.InterfaceC0478j
            public void j() {
                tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.j.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.this.xt.q()) {
                            j.this.f28316i.j(kt.j(j.this.xt, "tt_ecomm_page_reward_acquire"));
                        } else {
                            j.this.f28316i.j(String.format(kt.j(j.this.xt, "tt_ecomm_page_reward_tip"), Integer.valueOf(j.this.xt.e().uf())));
                        }
                    }
                });
            }
        });
        this.f28316i.jy();
        com.bytedance.sdk.openadsdk.core.oq.i().r().xt(new j.xt() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.j.6
            @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
            public void j() {
                if (j.this.tj.get() || !j.this.f28316i.ws()) {
                    j.this.f28315f.set(false);
                } else {
                    j.this.f28315f.set(true);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
            public void xt() {
            }
        });
        if (TextUtils.equals(this.jy.j(), "3")) {
            return;
        }
        xt();
    }

    public void ae() {
        com.bytedance.sdk.openadsdk.core.ugeno.g.xt xtVar = this.f28316i;
        if (xtVar != null) {
            xtVar.mi();
        }
    }

    public boolean cw() {
        return this.f28315f.get();
    }

    public void g() {
        com.bytedance.sdk.openadsdk.core.ugeno.g.xt xtVar = this.f28316i;
        if (xtVar != null) {
            xtVar.tj();
        }
    }

    public boolean m() {
        return this.f28318w.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void oq() {
        com.bytedance.sdk.openadsdk.core.ugeno.tl.j jVar = this.av;
        if (jVar != null) {
            jVar.xt();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.g.xt xtVar = this.f28316i;
        if (xtVar != null) {
            xtVar.av();
        }
        RewardLpBottomView rewardLpBottomView = this.kt;
        if (rewardLpBottomView != null) {
            rewardLpBottomView.xt();
        }
    }

    public boolean r() {
        com.bytedance.sdk.openadsdk.core.ugeno.g.xt xtVar = this.f28316i;
        if (xtVar != null) {
            return xtVar.ws();
        }
        return false;
    }

    public void tl() {
        com.bytedance.sdk.openadsdk.core.ugeno.g.xt xtVar = this.f28316i;
        if (xtVar != null) {
            xtVar.w();
        }
    }

    public AtomicInteger up() {
        return new AtomicInteger(0);
    }

    public void xt() {
        final ImageView imageView = new ImageView(this.xt);
        float cw = ed.cw(this.xt, 18.0f);
        float cw2 = ed.cw(this.xt, 20.0f);
        int i6 = (int) cw;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, i6);
        layoutParams.gravity = 53;
        int i7 = (int) cw2;
        layoutParams.setMargins(i7, i7, i7, i7);
        this.ae.addView(imageView, layoutParams);
        kt.j((Context) this.xt, "tt_unmute", imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.j.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.f28319x = !r3.f28319x;
                j jVar = j.this;
                kt.j((Context) jVar.xt, jVar.f28319x ? "tt_mute" : "tt_unmute", imageView);
                j.this.f28316i.cw(j.this.f28319x);
            }
        });
    }

    public j(TTBaseVideoActivity tTBaseVideoActivity, n nVar, boolean z5, com.bytedance.sdk.openadsdk.core.jy.up upVar, com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar2) {
        super(tTBaseVideoActivity, nVar, z5);
        this.jy = nVar.p();
        this.ws = upVar;
        this.xt.ae(0);
        this.f28318w = new AtomicBoolean();
        this.tj = new AtomicBoolean();
        this.f28315f = new AtomicBoolean();
        this.f28317v = upVar2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void j() {
        super.j();
        this.mi = uf.j(uf.xt(this.f28350j));
        com.bytedance.sdk.openadsdk.core.ugeno.m.j jVar = this.jy;
        if (jVar == null) {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.xt.ae(8);
                    j.this.xt.w();
                }
            });
            return;
        }
        int r5 = jVar.r();
        if (r5 == 2) {
            i();
            return;
        }
        if (r5 == 3) {
            w();
        } else if (r5 != 4) {
            this.xt.ae(8);
            this.xt.w();
        } else {
            mi();
        }
    }

    public void xt(boolean z5) {
        if (this.f28316i == null || !com.bytedance.sdk.openadsdk.core.ugeno.oq.r(this.cw)) {
            return;
        }
        this.f28316i.cw(z5);
    }

    public void j(boolean z5) {
        this.f28315f.set(z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void j(com.bytedance.sdk.openadsdk.core.xt.xt xtVar, com.bytedance.sdk.openadsdk.core.xt.xt xtVar2) {
        super.j(xtVar, xtVar2);
        com.bytedance.sdk.openadsdk.core.ugeno.g.r rVar = this.az;
        if (rVar != null) {
            rVar.j(this.xt.nd());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.g.xt xtVar3 = this.f28316i;
        if (xtVar3 != null) {
            xtVar3.j(this.xt.nd());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.tl.j jVar = this.av;
        if (jVar != null) {
            jVar.j(xtVar);
        }
    }

    public void j(int i6) {
        if (this.az == null || !com.bytedance.sdk.openadsdk.core.ugeno.oq.up(this.cw)) {
            return;
        }
        this.az.cw(i6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void j(DownloadListener downloadListener) {
        com.bytedance.sdk.openadsdk.core.ugeno.tl.j jVar = this.av;
        if (jVar != null) {
            jVar.j(downloadListener);
        }
    }
}
