package com.bytedance.sdk.openadsdk.core.component.reward.business.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.sdk.component.adexpress.r.tl;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.video.xt.xt;
import com.bytedance.sdk.openadsdk.l.ae;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private TextView ae;
    private ImageView cw;

    /* renamed from: g, reason: collision with root package name */
    private ObjectAnimator f28129g;

    /* renamed from: j, reason: collision with root package name */
    private final TTBaseVideoActivity f28130j;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f28131m;
    private final xt oq;

    /* renamed from: r, reason: collision with root package name */
    private ViewGroup f28132r;
    private ObjectAnimator tl;
    private View up;
    private final n xt;

    public void cw() {
        r();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.up, "alpha", 1.0f, 0.3f);
        ofFloat.setDuration(1000L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.j.j.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                j.this.up.setAlpha(1.0f);
                j.this.oq.g();
            }
        });
        ofFloat.start();
    }

    public void j(ViewGroup viewGroup, View view) {
        this.f28132r = viewGroup;
        this.up = view;
        this.cw = new ImageView(this.f28130j);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ed.cw(this.f28130j, 76.0f));
        layoutParams.gravity = 80;
        this.cw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f28132r.addView(this.cw, layoutParams);
    }

    public void r() {
        ObjectAnimator objectAnimator = this.tl;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.tl.cancel();
            this.tl = null;
        }
        ObjectAnimator objectAnimator2 = this.f28129g;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.f28129g.cancel();
            this.f28129g = null;
        }
        LinearLayout linearLayout = this.f28131m;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        View view = this.up;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        ImageView imageView = this.cw;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.oq.tl();
    }

    public int xt() {
        int identifier = this.f28130j.getResources().getIdentifier("status_bar_height", "dimen", FaceEnvironment.OS);
        if (identifier > 0) {
            return this.f28130j.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public j(TTBaseVideoActivity tTBaseVideoActivity, n nVar, xt xtVar) {
        this.f28130j = tTBaseVideoActivity;
        this.xt = nVar;
        this.oq = xtVar;
    }

    public void j() {
        int w5;
        LinearLayout linearLayout = new LinearLayout(this.f28130j);
        this.f28131m = linearLayout;
        linearLayout.setGravity(1);
        this.f28131m.setPadding(0, ed.cw(this.f28130j, 16.0f), 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ed.cw(this.f28130j, 76.0f));
        TextView textView = new TextView(this.f28130j);
        this.ae = textView;
        textView.setTextSize(12.0f);
        this.ae.setTextColor(-1);
        this.ae.setSingleLine();
        this.ae.setEllipsize(TextUtils.TruncateAt.START);
        this.ae.setGravity(5);
        this.ae.setMaxWidth(ed.cw(this.f28130j, 260.0f));
        this.f28131m.addView(this.ae);
        TextView textView2 = new TextView(this.f28130j);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(-1);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setGravity(17);
        textView2.setSingleLine();
        textView2.setText("取消");
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.j.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.r();
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = ed.cw(this.f28130j, 10.0f);
        this.f28131m.addView(textView2, layoutParams2);
        j(25, ln.xt(this.xt));
        int cw = ed.cw(this.f28130j, 76.0f);
        this.f28132r.addView(this.f28131m, layoutParams);
        try {
            int xt = tl.xt(this.f28130j);
            if (ed.r((Activity) this.f28130j)) {
                w5 = (tl.cw(this.f28130j) - xt) - xt();
            } else {
                w5 = ed.w(this.f28130j);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f28131m, "translationY", xt, (xt - cw) + w5);
            this.tl = ofFloat;
            ofFloat.setDuration(300L);
            this.tl.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.up, "translationY", 0.0f, -cw);
            this.f28129g = ofFloat2;
            ofFloat2.setDuration(300L);
            this.f28129g.start();
        } catch (Throwable th) {
            vl.r(ResIdentify.RES_TYPE_LAYOUT, th.getMessage());
        }
    }

    public void j(final int i6, String str) {
        com.bytedance.sdk.openadsdk.g.xt.j(str).cw(2).j(Bitmap.Config.ARGB_8888).j(new av<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.j.j.2
            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(2)
            public void j(int i7, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(1)
            public void j(qv<Bitmap> qvVar) {
                try {
                    Bitmap cw = qvVar.cw();
                    if (cw == null) {
                        return;
                    }
                    if (cw.getConfig() == Bitmap.Config.RGB_565) {
                        cw = cw.copy(Bitmap.Config.ARGB_8888, true);
                    }
                    Bitmap j6 = com.bytedance.sdk.component.adexpress.r.xt.j(j.this.f28130j, cw, i6);
                    if (j6 == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(j.this.f28130j.getResources(), j6);
                    ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.j.j.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.f28131m != null) {
                                j.this.f28131m.setBackgroundColor(Color.parseColor("#66000000"));
                            }
                            if (j.this.cw != null) {
                                j.this.cw.setImageDrawable(bitmapDrawable);
                            }
                        }
                    });
                } catch (Throwable th) {
                    vl.r(ResIdentify.RES_TYPE_LAYOUT, th.getMessage());
                }
            }
        }, 4);
    }

    public void j(com.bytedance.sdk.openadsdk.core.xt.xt xtVar) {
        com.bytedance.sdk.openadsdk.core.tj.qv qvVar = new com.bytedance.sdk.openadsdk.core.tj.qv();
        qvVar.xt(true);
        if (xtVar != null) {
            xtVar.j(qvVar);
            xtVar.j(null, qvVar);
        }
    }

    public void j(long j6) {
        TextView textView = this.ae;
        if (textView != null) {
            textView.setText("已为您加载更多详情，" + j6 + "秒后拉起展示");
        }
    }
}
