package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.utils.bw;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends e implements com.kwad.sdk.core.j.c {
    private TextView FX;
    private com.kwad.components.ad.splashscreen.widget.b FY;
    private AdInfo.AdPreloadInfo FZ;
    private boolean Ga = false;
    private View Gb;
    private AdInfo vz;

    private synchronized void md() {
        if (!this.Ga && this.FY != null) {
            if (com.kwad.sdk.core.response.b.a.cD(this.vz) && com.kwad.sdk.core.response.b.a.cE(this.vz)) {
                com.kwad.sdk.core.adlog.c.b(this.Gf.mAdTemplate, 124, (JSONObject) null);
                this.Ga = true;
            }
        }
    }

    private SplashSkipViewModel ma() {
        SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
        AdInfo adInfo = this.vz;
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        int i6 = adSplashInfo.imageDisplaySecond;
        if (i6 <= 0) {
            i6 = 5;
        }
        int min = Math.min(adSplashInfo.videoDisplaySecond, com.kwad.sdk.core.response.b.a.L(adInfo));
        if (com.kwad.sdk.core.response.b.a.bc(this.vz)) {
            i6 = min;
        }
        splashSkipViewModel.skipSecond = i6;
        return splashSkipViewModel;
    }

    private void w(AdInfo adInfo) {
        this.Gb = findViewById(R.id.ksad_skip_view_area);
        if (!com.kwad.sdk.core.response.b.a.cC(adInfo) || adInfo.adSplashInfo.skipButtonPosition != 0) {
            this.Gb.setVisibility(8);
            return;
        }
        this.Gb.setVisibility(0);
        this.Gb.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.presenter.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.mb();
            }
        });
        this.Gb.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.c.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ((View) c.this.FY).post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.c.3.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        int ao = c.this.FY.ao(35);
                        ViewGroup.LayoutParams layoutParams = c.this.Gb.getLayoutParams();
                        layoutParams.width = ao + com.kwad.sdk.c.a.a.a(c.this.Gf.mRootContainer.getContext(), 66.0f);
                        c.this.Gb.setLayoutParams(layoutParams);
                    }
                });
            }
        });
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onPageVisible");
        this.FY.B(this.vz);
        md();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onPageInvisible");
        this.FY.A(this.vz);
    }

    public final void mc() {
        this.Gf.mRootContainer.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.c.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (com.kwad.components.core.e.c.b.oW()) {
                    c.this.Gf.mRootContainer.postDelayed(this, 1000L);
                } else {
                    c.this.Gf.lQ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb() {
        com.kwad.components.ad.splashscreen.monitor.a.lX().ah(this.Gf.mAdTemplate);
        this.Gf.lS();
        JSONObject jSONObject = new JSONObject();
        com.kwad.components.ad.splashscreen.d.a aVar = this.Gf.Fq;
        if (aVar != null) {
            try {
                jSONObject.put("duration", aVar.getCurrentPosition());
            } catch (JSONException e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
        a.C0675a c0675a = new a.C0675a();
        bv bvVar = this.Gf.mTimerHelper;
        if (bvVar != null) {
            c0675a.duration = bvVar.getTime();
        }
        com.kwad.sdk.core.adlog.c.b(this.Gf.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().de(1).dm(22).b(c0675a), jSONObject);
    }

    private void t(AdInfo adInfo) {
        int i6;
        if (com.kwad.components.ad.splashscreen.e.c.z(adInfo)) {
            i6 = R.id.ksad_splash_right_top_root;
        } else {
            i6 = R.id.ksad_splash_left_top_root;
        }
        findViewById(i6).setVisibility(0);
    }

    private static boolean u(AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.cB(adInfo)) {
            return true;
        }
        return false;
    }

    private void v(AdInfo adInfo) {
        int i6;
        if (com.kwad.components.ad.splashscreen.e.c.z(adInfo)) {
            i6 = R.id.ksad_splash_preload_right_tips;
        } else {
            i6 = R.id.ksad_splash_preload_left_tips;
        }
        this.FX = (TextView) findViewById(i6);
        AdInfo.AdPreloadInfo adPreloadInfo = adInfo.adPreloadInfo;
        this.FZ = adPreloadInfo;
        if (adPreloadInfo != null && !bp.isNullString(adPreloadInfo.preloadTips)) {
            this.FX.setVisibility(0);
            this.FX.setText(this.FZ.preloadTips);
        } else {
            this.FX.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void at() {
        int i6;
        int i7;
        super.at();
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onBind");
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate);
        this.vz = el;
        t(el);
        v(this.vz);
        if (u(this.vz)) {
            if (com.kwad.components.ad.splashscreen.e.c.z(this.vz)) {
                i7 = R.id.ksad_splash_skip_right_view;
            } else {
                i7 = R.id.ksad_splash_skip_left_view;
            }
            this.FY = (com.kwad.components.ad.splashscreen.widget.b) findViewById(i7);
        } else {
            if (com.kwad.components.ad.splashscreen.e.c.z(this.vz)) {
                i6 = R.id.ksad_splash_circle_skip_right_view;
            } else {
                i6 = R.id.ksad_splash_circle_skip_left_view;
            }
            this.FY = (com.kwad.components.ad.splashscreen.widget.b) findViewById(i6);
        }
        this.FY.a(ma(), this.vz);
        this.FY.setOnViewListener(new SkipView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.c.1
            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void am(int i8) {
                c.this.Gf.al(i8);
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void me() {
                c.this.mb();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void mf() {
                c.this.mc();
            }
        });
        w(this.vz);
        this.Gf.Fs.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Gf.Fs.b(this);
        bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.c.4
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.FY != null) {
                    c.this.FY.cq();
                }
            }
        });
    }
}
