package com.kwad.components.ad.splashscreen.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsShakeView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class o extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.b, com.kwad.sdk.widget.d {
    private boolean FV;
    private com.kwad.components.ad.splashscreen.d GN;
    private TextView Hi;
    private KsShakeView Hl;
    private ViewGroup Hr;
    private com.kwad.sdk.core.g.d gX;
    private Vibrator gZ;
    private long mStartTime;

    @Override // com.kwad.sdk.core.g.b
    public final void a(final double d6) {
        boolean oW = com.kwad.components.core.e.c.b.oW();
        if (!this.Gf.Fs.wl() || oW) {
            return;
        }
        this.Hl.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.presenter.o.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                o oVar = o.this;
                com.kwad.components.ad.splashscreen.h hVar = oVar.Gf;
                if (hVar != null) {
                    hVar.a(1, oVar.getContext(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.o.3.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.l(d6);
                        }
                    });
                }
                o.this.Hl.nx();
            }
        });
        bw.a(getContext(), this.gZ);
        mr();
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onSlide: enableSlickClick: " + this.FV);
        if (this.FV && (hVar = this.Gf) != null) {
            hVar.c(1, view.getContext(), 153, 1);
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void cd() {
        com.kwad.sdk.core.adlog.c.ca(this.Gf.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void fM() {
        this.Hl.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.o.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                o.this.Hl.nx();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void i(int i6, String str) {
        TextView textView = this.Hi;
        if (textView != null) {
            if (i6 == 2) {
                textView.setText(str);
                return;
            }
            textView.setText("或点击" + str);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lG() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bH(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mn() {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate);
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        this.GN = com.kwad.components.ad.splashscreen.d.a(hVar.mAdTemplate, el, hVar.mApkDownloadHelper, 2);
        this.FV = com.kwad.sdk.core.response.b.d.ea(this.Gf.mAdTemplate);
        new com.kwad.sdk.widget.h(this.Hl.getContext(), this.Hl, this);
        this.Gf.a(this);
        TextView textView = this.Hi;
        if (textView != null) {
            textView.setText(this.GN.lA());
        }
        KsShakeView ksShakeView = this.Hl;
        if (ksShakeView != null) {
            ksShakeView.aq(this.GN.lB());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mo() {
        ViewGroup viewGroup = this.Hr;
        if (viewGroup == null || this.Gf == null) {
            return;
        }
        viewGroup.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.Gf.mAdTemplate, 185, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.vI().bm(185);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mp() {
        float dj = com.kwad.sdk.core.response.b.b.dj(this.Gf.mAdTemplate);
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.g(dj);
            return;
        }
        com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(dj);
        this.gX = dVar2;
        dVar2.a(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mq() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bG(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mr() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bH(getContext());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        AdTemplate adTemplate;
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onClick: " + view);
        if (!view.equals(this.Hl) || (hVar = this.Gf) == null || (adTemplate = hVar.mAdTemplate) == null || !com.kwad.sdk.core.response.b.b.ea(com.kwad.sdk.core.response.b.e.el(adTemplate))) {
            return;
        }
        this.Gf.c(1, getContext(), 158, 1);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        getRootView().post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.o.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                o.this.Gf.FH = SystemClock.elapsedRealtime() - o.this.mStartTime;
            }
        });
        Context context = getContext();
        if (context != null) {
            this.gZ = (Vibrator) context.getSystemService("vibrator");
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_shake_layout);
        if (viewStub != null) {
            this.Hr = (ViewGroup) viewStub.inflate();
        } else {
            this.Hr = (ViewGroup) findViewById(R.id.ksad_shake_root);
        }
        this.Hi = (TextView) this.Hr.findViewById(R.id.ksad_shake_action);
        KsShakeView ksShakeView = (KsShakeView) this.Hr.findViewById(R.id.ksad_shake_view);
        this.Hl = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar != null) {
            hVar.b(this);
        }
        KsShakeView ksShakeView = this.Hl;
        if (ksShakeView != null) {
            ksShakeView.ny();
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onSingleTap: " + view);
        if (com.kwad.sdk.core.response.b.b.ea(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate)) && (hVar = this.Gf) != null) {
            hVar.c(1, getContext(), 158, 1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ak(int i6) {
    }
}
