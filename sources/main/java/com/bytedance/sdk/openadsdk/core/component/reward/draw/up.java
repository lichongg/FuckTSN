package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.component.reward.r.cw;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.qv;
import com.bytedance.sdk.openadsdk.core.rn.a;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.z;
import com.bytedance.sdk.openadsdk.core.video.xt.j;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends RecyclerView.v implements l.j {

    /* renamed from: a, reason: collision with root package name */
    protected final AtomicBoolean f28203a;

    /* renamed from: c, reason: collision with root package name */
    private int f28204c;
    public r ch;
    private final AnimatorSet ed;

    /* renamed from: f, reason: collision with root package name */
    public FrameLayout f28205f;
    private int gq;

    /* renamed from: h, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.xt f28206h;

    /* renamed from: i, reason: collision with root package name */
    public FullRewardExpressView f28207i;
    public FrameLayout kt;

    /* renamed from: l, reason: collision with root package name */
    private boolean f28208l;
    private boolean la;
    public FrameLayout mi;

    /* renamed from: p, reason: collision with root package name */
    private boolean f28209p;
    private cw.j rn;

    /* renamed from: s, reason: collision with root package name */
    protected final AtomicBoolean f28210s;
    public FrameLayout tj;
    private LinearLayout uf;

    /* renamed from: v, reason: collision with root package name */
    public FrameLayout f28211v;

    /* renamed from: w, reason: collision with root package name */
    public ViewGroup f28212w;
    private final l wq;

    /* renamed from: x, reason: collision with root package name */
    public TTProgressBar f28213x;

    private static class xt implements j.InterfaceC0494j {
        private boolean cw = false;

        /* renamed from: j, reason: collision with root package name */
        private final j.InterfaceC0494j f28218j;

        /* renamed from: r, reason: collision with root package name */
        private final int f28219r;
        private final l up;
        private final j xt;

        interface j {
            void j();

            void j(boolean z5);
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
        public void j() {
            this.cw = false;
            j.InterfaceC0494j interfaceC0494j = this.f28218j;
            if (interfaceC0494j != null) {
                interfaceC0494j.j();
            }
            j jVar = this.xt;
            if (jVar != null) {
                jVar.j();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
        public void xt() {
            j(true);
            j.InterfaceC0494j interfaceC0494j = this.f28218j;
            if (interfaceC0494j != null) {
                interfaceC0494j.xt();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
        public void cw() {
            j.InterfaceC0494j interfaceC0494j = this.f28218j;
            if (interfaceC0494j != null) {
                interfaceC0494j.cw();
            }
        }

        xt(j.InterfaceC0494j interfaceC0494j, int i6, j jVar, l lVar) {
            this.f28218j = interfaceC0494j;
            this.xt = jVar;
            this.f28219r = i6;
            this.up = lVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
        public void j(int i6, String str) {
            j(true);
            this.cw = false;
            j.InterfaceC0494j interfaceC0494j = this.f28218j;
            if (interfaceC0494j != null) {
                interfaceC0494j.j(i6, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
        public void j(long j6, long j7) {
            this.up.removeMessages(101);
            if (j7 > 20000 && j6 > Math.min(this.f28219r * 1000, j7) * 0.75f) {
                j(false);
                this.cw = true;
            }
            j.InterfaceC0494j interfaceC0494j = this.f28218j;
            if (interfaceC0494j != null) {
                interfaceC0494j.j(j6, j7);
            }
        }

        private void j(boolean z5) {
            j jVar;
            if (this.cw || (jVar = this.xt) == null) {
                return;
            }
            jVar.j(z5);
        }
    }

    private static class j implements Interpolator {
        private j() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            if (f6 <= 0.38f) {
                return f6 * 2.631579f;
            }
            return (f6 * (-1.6129032f)) + 1.6129032f;
        }
    }

    private void gx() {
        FullRewardExpressView fullRewardExpressView = this.f28207i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.jy();
        }
        this.f28204c = Integer.MAX_VALUE;
        this.f28209p = false;
        this.f28208l = false;
        this.la = false;
        this.kt.removeAllViews();
        this.tj.removeAllViews();
        this.f28205f.removeAllViews();
        this.f28211v.removeAllViews();
        this.f28210s.set(false);
        this.f28203a.set(false);
        this.mi.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r rVar = this.ch;
        if (rVar != null) {
            rVar.oq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z5) {
        if (this.f28208l) {
            if (this.f28204c > ed.up(this.f27042j.getContext()) * 0.7f) {
                ed.j((View) this.uf, 0);
                this.ed.start();
            }
            if (!z5 || this.f28210s.get()) {
                return;
            }
            ed.j(this.f28212w.getContext(), "视频加载错误，请上滑浏览其他内容", 0);
            this.f28210s.set(true);
        }
    }

    public void a() {
        if (this.ed.isStarted() && this.ed.isRunning()) {
            this.ed.pause();
        }
    }

    public boolean c() {
        return this.f28203a.get();
    }

    public void cw(boolean z5) {
        r rVar = this.ch;
        if (rVar != null) {
            rVar.xt(z5);
        }
    }

    public boolean ed() {
        r rVar = this.ch;
        if (rVar == null) {
            return false;
        }
        return rVar.ch();
    }

    public void gq() {
        r rVar = this.ch;
        if (rVar != null) {
            rVar.m();
        }
    }

    public void h() {
        if (this.ch != null && this.f28208l && this.f28209p) {
            this.f28206h.oq();
            this.f28207i.av();
            if (this.la && this.ch.x()) {
                cw(this.f28206h.m());
                rn();
            } else {
                this.la = true;
                this.wq.sendEmptyMessageDelayed(101, 5000L);
                this.f28206h.j(this.f28207i);
                this.ch.j(this.f28206h.qv());
            }
        }
    }

    public void l() {
        if (this.ed.isStarted() && this.ed.isPaused()) {
            this.ed.resume();
        }
    }

    public long la() {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.xt xtVar = this.f28206h;
        if (xtVar == null) {
            return -1L;
        }
        return xtVar.vl();
    }

    public void p() {
        if (this.ed.isStarted() && this.ed.isRunning()) {
            this.ed.cancel();
        }
    }

    public void rn() {
        r rVar = this.ch;
        if (rVar != null) {
            rVar.tl();
        }
    }

    public com.bykv.vk.openvk.component.video.api.r.cw uf() {
        return this.ch;
    }

    public void wq() {
        FullRewardExpressView fullRewardExpressView = this.f28207i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.jy();
        }
        r rVar = this.ch;
        if (rVar != null) {
            rVar.g();
        }
    }

    public up(View view) {
        super(view);
        this.wq = new l(Looper.getMainLooper(), this);
        this.ed = new AnimatorSet();
        this.f28210s = new AtomicBoolean(false);
        this.f28203a = new AtomicBoolean(false);
        this.f28204c = Integer.MAX_VALUE;
        this.f28212w = (ViewGroup) view.findViewById(2114387898);
        this.mi = (FrameLayout) view.findViewById(2114387784);
        this.kt = (FrameLayout) view.findViewById(2114387818);
        this.tj = (FrameLayout) view.findViewById(2114387676);
        this.f28205f = (FrameLayout) view.findViewById(2114387827);
        this.f28211v = (FrameLayout) view.findViewById(2114387685);
        this.f28213x = (TTProgressBar) view.findViewById(2114387773);
        j(view.getContext());
    }

    public void j(final com.bytedance.sdk.openadsdk.core.component.reward.draw.xt xtVar, float f6, float f7) {
        this.f28206h = xtVar;
        gx();
        this.f28213x.setVisibility(0);
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this.f28212w.getContext(), xtVar.j(), a.j(7, String.valueOf(uf.g(xtVar.j())), f6, f7), xtVar.xt(), false);
        this.f28207i = fullRewardExpressView;
        fullRewardExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.up.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
            public void j(View view, float f8, float f9) {
                if (up.this.f28207i.tj()) {
                    up.this.f28205f.setVisibility(8);
                    up upVar = up.this;
                    upVar.f28211v.addView(upVar.j(view.getContext(), xtVar));
                    up.this.f28211v.setVisibility(0);
                } else {
                    up upVar2 = up.this;
                    upVar2.f28207i.j((ViewGroup) upVar2.mi, false);
                }
                up upVar3 = up.this;
                upVar3.gq = upVar3.f28207i.getDynamicShowType();
                up.this.f28209p = true;
                up.this.h();
                up.this.f28213x.setVisibility(8);
            }
        });
        this.f28207i.setExpressVideoListenerProxy(new qv() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.up.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void j(float f8) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public int xt() {
                if (up.this.f28210s.get()) {
                    return 4;
                }
                up upVar = up.this;
                if (upVar.ch == null || !upVar.la) {
                    return 2;
                }
                if (up.this.ch.ya()) {
                    return 5;
                }
                if (up.this.ch.f()) {
                    return 1;
                }
                if (up.this.ch.sm()) {
                    return 2;
                }
                up.this.ch.x();
                return 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public int cw() {
                r rVar = up.this.ch;
                if (rVar == null) {
                    return 0;
                }
                return (int) (rVar.qv() / 1000);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public long getActualPlayDuration() {
                return 0L;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void j(int i6, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void r() {
                up.this.f28203a.set(true);
                if (up.this.f28208l) {
                    up.this.rn.j();
                    up.this.f28206h.xt(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void j(boolean z5) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void j(int i6) {
                up upVar = up.this;
                r rVar = upVar.ch;
                if (rVar == null) {
                    return;
                }
                if (i6 == 2) {
                    rVar.ae(true);
                    if (up.this.f28208l) {
                        up.this.gq();
                        return;
                    }
                    return;
                }
                if (i6 != 3) {
                    return;
                }
                upVar.f28203a.set(false);
                up.this.ch.ae(false);
                if (up.this.f28208l) {
                    up.this.rn.xt();
                    up.this.rn();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void xt(int i6) {
                up.this.rn.j(i6);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public long j() {
                return up.this.ch.qv();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void j(float f8, float f9, float f10, float f11, int i6) {
                up.this.j(f8, f9, f10, f11, i6);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void ae() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void g() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void m() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void oq() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void qv() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void tl() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void up() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void setPauseFromExpressView(boolean z5) {
            }
        });
        this.f28207i.setOnVideoSizeChangeListener(new FullRewardExpressView.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.up.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.j
            public void j(int i6) {
                up.this.f28204c = i6;
            }
        });
        this.f28205f.addView(this.f28207i);
        r rVar = new r(this.f28212w.getContext(), this.kt, xtVar.j());
        this.ch = rVar;
        this.f28207i.setVideoController(rVar);
        xtVar.j(this.kt, this.tj, this.f28207i);
        this.ch.j(new xt(xtVar.up(), z.cw(this.f28206h.j()), new xt.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.up.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.up.xt.j
            public void j(boolean z5) {
                up.this.r(z5);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.up.xt.j
            public void j() {
                up.this.rn.r();
            }
        }, this.wq));
        this.ch.xt(this.f28206h.vl());
        this.f28207i.i();
        this.f28207i.w();
    }

    public void xt(boolean z5) {
        if (this.f28208l == z5) {
            return;
        }
        this.f28208l = z5;
        if (z5) {
            h();
            return;
        }
        gq();
        ed.j((View) this.uf, 8);
        this.ed.cancel();
    }

    public View j(Context context, com.bytedance.sdk.openadsdk.core.component.reward.draw.xt xtVar) {
        String sf;
        String valueOf;
        View jy = com.bytedance.sdk.openadsdk.res.up.jy(context);
        RelativeLayout relativeLayout = (RelativeLayout) jy.findViewById(2114387655);
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) jy.findViewById(2114387799);
        TextView textView = (TextView) jy.findViewById(2114387881);
        TextView textView2 = (TextView) jy.findViewById(2114387636);
        TextView textView3 = (TextView) jy.findViewById(2114387836);
        TTRatingBar tTRatingBar = (TTRatingBar) jy.findViewById(2114387615);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(ed.cw(context, 15.0f));
            tTRatingBar.setStarImageHeight(ed.cw(context, 14.0f));
            tTRatingBar.setStarImagePadding(ed.cw(context, 4.0f));
            tTRatingBar.j();
        }
        if (tTRoundRectImageView != null) {
            h ig = xtVar.j().ig();
            if (ig != null && !TextUtils.isEmpty(ig.j())) {
                com.bytedance.sdk.openadsdk.g.xt.j(ig).j(tTRoundRectImageView);
            } else {
                kt.j(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView);
            }
        }
        if (textView != null) {
            if (xtVar.j().by() != null && !TextUtils.isEmpty(xtVar.j().by().cw())) {
                textView.setText(xtVar.j().by().cw());
            } else {
                textView.setText(xtVar.j().hw());
            }
        }
        if (textView2 != null) {
            int m6 = xtVar.j().by() != null ? xtVar.j().by().m() : 6870;
            String j6 = kt.j(context, "tt_comment_num");
            if (m6 > 10000) {
                valueOf = (m6 / 10000) + "万";
            } else {
                valueOf = String.valueOf(m6);
            }
            textView2.setText(String.format(j6, valueOf));
        }
        if (textView3 != null) {
            if (TextUtils.isEmpty(xtVar.j().sf())) {
                if (xtVar.j().jl() != 4) {
                    sf = "查看详情";
                } else {
                    sf = "立即下载";
                }
            } else {
                sf = xtVar.j().sf();
            }
            textView3.setText(sf);
        }
        ed.j((View) relativeLayout, (View.OnClickListener) xtVar.cw(), "reward_draw_listener");
        return jy;
    }

    private void j(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.uf = linearLayout;
        linearLayout.setClipChildren(false);
        this.uf.setGravity(1);
        this.uf.setOrientation(1);
        ImageView imageView = new ImageView(context);
        kt.j(context, "tt_ic_back_light", imageView);
        this.uf.addView(imageView, -1, -2);
        ImageView imageView2 = new ImageView(context);
        kt.j(context, "tt_ic_back_light", imageView2);
        imageView2.setAlpha(0.7f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ed.cw(context, -8.0f);
        this.uf.addView(imageView2, layoutParams);
        TextView textView = new TextView(context);
        textView.setGravity(1);
        textView.setTextColor(-1);
        textView.setText("上滑浏览更多内容");
        this.uf.addView(textView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = ed.cw(context, 156.0f);
        this.f28212w.addView(this.uf, layoutParams2);
        this.f28212w.setClipChildren(false);
        this.uf.setVisibility(8);
        j(imageView, imageView2);
    }

    private void j(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(new j());
        ofFloat.setDuration(1300L);
        ofFloat.setStartDelay(700L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, ed.cw(this.f28212w.getContext(), -5.0f));
        ofFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        ofFloat2.setDuration(1300L);
        ofFloat2.setStartDelay(700L);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        ofFloat3.setInterpolator(new j());
        ofFloat3.setDuration(1300L);
        ofFloat3.setStartDelay(500L);
        ofFloat3.setRepeatCount(-1);
        ofFloat3.setRepeatMode(1);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, "translationY", ed.cw(this.f28212w.getContext(), -6.0f));
        ofFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        ofFloat4.setDuration(1300L);
        ofFloat4.setStartDelay(500L);
        ofFloat4.setRepeatCount(-1);
        ofFloat4.setRepeatMode(1);
        this.ed.playTogether(ofFloat, ofFloat3, ofFloat2, ofFloat4);
    }

    public void j(View view) {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.xt xtVar = this.f28206h;
        if (xtVar == null || xtVar.cw() == null) {
            return;
        }
        this.f28206h.cw().onClick(view);
    }

    public void j(float f6, float f7, float f8, float f9, int i6) {
        FullRewardExpressView fullRewardExpressView = this.f28207i;
        if (fullRewardExpressView == null || fullRewardExpressView.getVideoFrameLayout() == null) {
            return;
        }
        int measuredWidth = this.f28207i.getVideoFrameLayout().getMeasuredWidth();
        int measuredHeight = this.f28207i.getVideoFrameLayout().getMeasuredHeight();
        if (this.ch.q()) {
            this.f28207i.getVideoFrameLayout().animate().translationY(-(measuredHeight * (1.0f - f7))).setDuration(i6).start();
        } else {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f6, 1.0f, f7, measuredWidth * f8, measuredHeight * f9);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(i6);
            this.f28207i.getVideoFrameLayout().startAnimation(scaleAnimation);
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        if (message.what != 101) {
            return;
        }
        r(true);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.xt xtVar = this.f28206h;
        if (xtVar != null) {
            xtVar.tl();
        }
    }

    public void j(cw.j jVar) {
        r rVar;
        this.rn = jVar;
        if (jVar == null || (rVar = this.ch) == null) {
            return;
        }
        rVar.xt(jVar.cw());
    }
}
