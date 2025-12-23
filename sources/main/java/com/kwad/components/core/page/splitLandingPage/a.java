package com.kwad.components.core.page.splitLandingPage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.page.c.b;
import com.kwad.components.core.page.recycle.e;
import com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView;
import com.kwad.components.core.page.splitLandingPage.view.a;
import com.kwad.components.core.proxy.h;
import com.kwad.components.core.t.o;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bg;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends h {
    private FeedVideoView Tb;
    private LinearLayout Tc;
    private SplitScrollWebView Ve;
    private Presenter Vf;
    private com.kwad.components.core.page.splitLandingPage.view.a Vg;
    private com.kwad.components.core.page.c.a Vh;
    private boolean Vi;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;

    static /* synthetic */ boolean a(a aVar, boolean z5) {
        aVar.Vi = false;
        return false;
    }

    public static a aE(AdTemplate adTemplate) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        aVar.setArguments(bundle);
        return aVar;
    }

    private void initView() {
        e eVar = new e(this.mAdTemplate, this.mApkDownloadHelper, null);
        this.Vf.n(eVar);
        com.kwad.components.core.page.splitLandingPage.view.a aVar = new com.kwad.components.core.page.splitLandingPage.view.a(this.mContext, new com.kwad.components.core.page.splitLandingPage.a.a(eVar.adTemplate, eVar.Pc));
        this.Vg = aVar;
        aVar.a(new a.InterfaceC0630a() { // from class: com.kwad.components.core.page.splitLandingPage.a.3
            @Override // com.kwad.components.core.page.splitLandingPage.view.a.InterfaceC0630a
            public final boolean rK() {
                return a.this.rH();
            }
        });
        this.Tb.post(new bg() { // from class: com.kwad.components.core.page.splitLandingPage.a.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.Ve.setTranslationY(a.this.Ve.getTranslationY() + a.this.Tb.getHeight());
            }
        });
        this.Ve.setSplitScrollWebViewListener(new SplitScrollWebView.a() { // from class: com.kwad.components.core.page.splitLandingPage.a.5
            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final void f(float f6) {
                a.this.Ve.setTranslationY(a.this.Ve.getTranslationY() - f6);
            }

            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final boolean rL() {
                if (!a.this.Vg.rM() && com.kwad.sdk.core.config.e.EP() == 2) {
                    return false;
                }
                AnimatorSet animatorSet = new AnimatorSet();
                Animator a6 = o.a(a.this.Ve, (Interpolator) null, a.this.Ve.getTranslationY(), 0.0f);
                if (com.kwad.sdk.core.config.e.EP() == 2) {
                    if (a.this.Tb.isComplete()) {
                        animatorSet.playTogether(a6);
                    } else {
                        animatorSet.playSequentially(a6, a.this.Vg.aK(true));
                    }
                } else if (com.kwad.sdk.core.config.e.EP() == 1) {
                    animatorSet.playTogether(a6);
                }
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.5.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.Tb.rJ();
                        if (com.kwad.sdk.core.config.e.EP() == 2 && !a.this.Tb.isComplete()) {
                            a.this.Vg.rN();
                        }
                    }
                });
                animatorSet.start();
                return true;
            }
        });
    }

    private void j(ViewGroup viewGroup) {
        Presenter presenter = new Presenter();
        this.Vf = presenter;
        presenter.K(viewGroup);
        b bVar = new b();
        bVar.K(this.Ve);
        com.kwad.components.core.page.c.a aVar = new com.kwad.components.core.page.c.a();
        this.Vh = aVar;
        aVar.K(this.Tb);
        this.Vf.a(bVar);
        this.Vf.a(this.Vh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rH() {
        SplitScrollWebView splitScrollWebView = this.Ve;
        if (splitScrollWebView == null || splitScrollWebView.getTranslationY() != 0.0f || this.Vi) {
            return false;
        }
        this.Ve.setDisableAnimation(false);
        this.Vi = true;
        SplitScrollWebView splitScrollWebView2 = this.Ve;
        Animator a6 = o.a((View) splitScrollWebView2, (Interpolator) null, 0.0f, splitScrollWebView2.getTranslationY() + this.Tb.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        if (com.kwad.sdk.core.config.e.EP() == 2 && this.Vg.isVisible()) {
            this.Vg.rJ();
            animatorSet.playSequentially(this.Vg.aK(false), a6);
        } else {
            animatorSet.play(a6);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.rI();
                a.this.Tb.rN();
                a.a(a.this, false);
            }
        });
        animatorSet.start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rI() {
        this.Vh.ny();
        this.Vh.K(this.Tb);
        this.Vh.n(new e(this.mAdTemplate, this.mApkDownloadHelper, null));
    }

    private void z(View view) {
        this.Tc = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        TextView textView = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        ((ImageView) view.findViewById(R.id.ksad_web_tip_close_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.Tc.setVisibility(8);
            }
        });
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        boolean bz = com.kwad.sdk.core.response.b.a.bz(el);
        String bv = com.kwad.sdk.core.response.b.a.bv(el);
        if (!bz) {
            this.Tc.setVisibility(8);
            return;
        }
        this.Tc.setVisibility(0);
        textView.setText(bv);
        textView.setSelected(true);
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.m.a.b
    public final boolean onBackPressed() {
        SplitScrollWebView splitScrollWebView = this.Ve;
        if (splitScrollWebView != null && splitScrollWebView.canGoBack()) {
            this.Ve.goBack();
            return true;
        }
        if (rH()) {
            return true;
        }
        FeedVideoView feedVideoView = this.Tb;
        if (feedVideoView != null) {
            return feedVideoView.wc();
        }
        return false;
    }

    @Override // com.kwad.components.core.proxy.h
    public final int qN() {
        return R.layout.ksad_split_land_page;
    }

    public final void rJ() {
        this.Tb.rJ();
    }

    public final void setApkDownloadHelper(c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.Tb = (FeedVideoView) findViewById(R.id.ksad_split_land_ad_feed_video);
        this.Ve = (SplitScrollWebView) findViewById(R.id.ksad_video_webView);
        z(view);
        j(this.nY);
        initView();
    }
}
