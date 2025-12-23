package com.kwad.sdk.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.br;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e implements View.OnClickListener {
    private final boolean ato;
    private final boolean atp;
    private View atq;
    private ImageView atr;
    private TextView ats;
    private Button att;
    private int atu;
    private int atv;
    private boolean atw;
    private final AdInfo mAdInfo;

    @NonNull
    private final AdTemplate mAdTemplate;

    @NonNull
    private final Context mContext;

    @NonNull
    private View mRootView = Dc();

    @SuppressLint({"InflateParams"})
    private View Dc() {
        if (this.ato && this.atp) {
            this.mRootView = m.inflate(this.mContext, R.layout.ksad_install_tips_bottom, null);
        } else {
            this.mRootView = m.inflate(this.mContext, R.layout.ksad_install_tips, null);
        }
        ViewCompat.setElevation(this.mRootView, this.mContext.getResources().getDimension(R.dimen.ksad_install_tips_card_elevation));
        this.atq = this.mRootView.findViewById(R.id.ksad_install_tips_close);
        this.atr = (ImageView) this.mRootView.findViewById(R.id.ksad_install_tips_icon);
        this.ats = (TextView) this.mRootView.findViewById(R.id.ksad_install_tips_content);
        this.att = (Button) this.mRootView.findViewById(R.id.ksad_install_tips_install);
        return this.mRootView;
    }

    private Animator F(View view) {
        ObjectAnimator ofFloat = (this.ato && this.atp) ? ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, 0.0f, this.atv) : ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, -this.atu);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
        ofFloat.setDuration(260L);
        return ofFloat;
    }

    private void c(FrameLayout frameLayout) {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_height);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_margin);
        this.atu = dimensionPixelSize + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = dimensionPixelSize2;
        layoutParams2.rightMargin = dimensionPixelSize2;
        layoutParams2.topMargin = dimensionPixelSize2;
        this.mRootView.setTranslationY(-this.atu);
        frameLayout.addView(this.mRootView, layoutParams2);
        show();
    }

    private void d(FrameLayout frameLayout) {
        int screenWidth = br.getScreenWidth(this.mContext);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_left);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_bottom);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ksad_install_tips_bottom_height);
        this.atv = screenWidth - dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelOffset);
        layoutParams2.gravity = 80;
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = 0;
        layoutParams2.bottomMargin = dimensionPixelSize2;
        this.mRootView.setTranslationX(this.atv);
        frameLayout.addView(this.mRootView, layoutParams2);
        show();
    }

    private void nu() {
        this.att.setText(this.ato ? "安装" : "打开");
        this.atq.setOnClickListener(this);
        this.att.setOnClickListener(this);
        KSImageLoader.loadAppIcon(this.atr, com.kwad.sdk.core.response.b.a.co(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate)), this.mAdTemplate, 8);
        String av = com.kwad.sdk.core.response.b.a.av(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate));
        if (av.length() >= 8) {
            av = av.substring(0, 7) + "...";
        }
        this.ats.setText(this.mContext.getString(this.ato ? R.string.ksad_install_tips : R.string.ksad_launch_tips, av));
    }

    private void show() {
        ObjectAnimator ofFloat = (this.ato && this.atp) ? ObjectAnimator.ofFloat(this.mRootView, (Property<View, Float>) View.TRANSLATION_X, this.atv, 0.0f) : ObjectAnimator.ofFloat(this.mRootView, (Property<View, Float>) View.TRANSLATION_Y, -this.atu, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public final void b(FrameLayout frameLayout) {
        if (this.mRootView.getParent() != null) {
            return;
        }
        if (this.ato && this.atp) {
            d(frameLayout);
        } else {
            c(frameLayout);
        }
        this.mRootView.postDelayed(new bg() { // from class: com.kwad.sdk.a.a.e.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                e.this.dismiss();
            }
        }, 10000L);
    }

    public final void dismiss() {
        if (this.mRootView.getParent() == null) {
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
        Animator F = F(this.mRootView);
        F.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.a.a.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewGroup.removeView(e.this.mRootView);
            }
        });
        F.start();
        c.CU().CZ();
    }

    public e(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z5, boolean z6, boolean z7) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.ato = z5;
        this.atp = z6;
        this.atw = z7;
        nu();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        dismiss();
        if (view.getId() == R.id.ksad_install_tips_install) {
            if (this.ato) {
                if (this.atw) {
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    bVar.df(29);
                    bVar.dm(23);
                    com.kwad.sdk.core.adlog.c.e(this.mAdTemplate, null, bVar);
                } else {
                    com.kwad.sdk.core.adlog.c.o(this.mAdTemplate, 45);
                }
                as.a(com.kwad.sdk.core.response.b.a.H(this.mAdInfo), new as.a() { // from class: com.kwad.sdk.a.a.e.3
                    @Override // com.kwad.sdk.utils.as.a
                    public final void d(Throwable th) {
                        com.kwad.sdk.commercial.a.a.i(e.this.mAdTemplate, 100003, Log.getStackTraceString(th));
                    }

                    @Override // com.kwad.sdk.utils.as.a
                    public final void pR() {
                        com.kwad.sdk.core.adlog.c.h(e.this.mAdTemplate, 1);
                        com.kwad.sdk.commercial.a.a.bk(e.this.mAdTemplate);
                    }
                });
                return;
            }
            if (as.as(this.mContext, com.kwad.sdk.core.response.b.a.ay(this.mAdInfo))) {
                com.kwad.sdk.core.adlog.c.bU(this.mAdTemplate);
            }
            com.kwad.sdk.core.adlog.c.n(this.mAdTemplate, 47);
            return;
        }
        if (view.getId() == R.id.ksad_install_tips_close) {
            if (this.ato) {
                if (this.atw) {
                    com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
                    bVar2.df(69);
                    bVar2.dm(23);
                    bVar2.dq(1);
                    com.kwad.sdk.core.adlog.c.e(this.mAdTemplate, null, bVar2);
                    return;
                }
                com.kwad.sdk.core.adlog.c.o(this.mAdTemplate, 46);
                return;
            }
            com.kwad.sdk.core.adlog.c.n(this.mAdTemplate, 48);
        }
    }
}
