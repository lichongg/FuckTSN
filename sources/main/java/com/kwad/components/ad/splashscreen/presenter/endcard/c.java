package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends com.kwad.components.ad.splashscreen.presenter.e implements View.OnClickListener, com.kwad.sdk.widget.d {
    private CloseCountDownView Ij;
    private ViewGroup Ik;
    private ViewGroup Il;
    private ImageView Im;
    private TextView In;
    private TextView Io;
    private SplashEndLandView Ip;
    private CloseCountDownView.a Iq = new CloseCountDownView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.c.1
        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void eh() {
            a.C0675a c0675a = new a.C0675a();
            com.kwad.components.ad.splashscreen.monitor.a.lX().ah(c.this.Gf.mAdTemplate);
            if (c.this.Gf.mTimerHelper != null) {
                c0675a.duration = c.this.Gf.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(c.this.Gf.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().de(1).b(c0675a).dm(6), (JSONObject) null);
            c.this.Gf.lS();
        }

        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void mf() {
            a.C0675a c0675a = new a.C0675a();
            if (c.this.Gf.mTimerHelper != null) {
                c0675a.duration = c.this.Gf.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(c.this.Gf.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().de(14).b(c0675a).dm(6), (JSONObject) null);
            c.this.Gf.lW();
        }
    };

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
    }

    private void w(View view) {
        if (view == this.Ik) {
            this.Gf.c(2, view.getContext(), 104, 2);
            return;
        }
        if (view == this.Il) {
            this.Gf.c(2, view.getContext(), 26, 1);
            return;
        }
        if (view == this.Im) {
            this.Gf.c(2, view.getContext(), 15, 2);
        } else if (view == this.In) {
            this.Gf.c(2, view.getContext(), 16, 2);
        } else if (view == this.Io) {
            this.Gf.c(2, view.getContext(), 17, 2);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        w(view);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        if (this.Ip == null) {
            SplashEndLandView splashEndLandView = (SplashEndLandView) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
            this.Ip = splashEndLandView;
            this.Ij = splashEndLandView.getCloseView();
            this.Ik = this.Ip.getGiftBoxView();
            this.Il = this.Ip.getActionBarView();
            this.Im = this.Ip.getAppIcon();
            this.In = this.Ip.getAppName();
            this.Io = this.Ip.getAppDesc();
        }
        this.Ij.setOnViewClickListener(this.Iq);
        this.Il.setOnClickListener(this);
        new com.kwad.sdk.widget.h(this.Il.getContext(), this.Il, this);
        if (com.kwad.sdk.core.response.b.b.dz(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate))) {
            this.Ik.setOnClickListener(this);
            this.Im.setOnClickListener(this);
            this.In.setOnClickListener(this);
            this.Io.setOnClickListener(this);
            new com.kwad.sdk.widget.h(this.Il.getContext(), this.Ik, this);
            new com.kwad.sdk.widget.h(this.Il.getContext(), this.Im, this);
            new com.kwad.sdk.widget.h(this.Il.getContext(), this.In, this);
            new com.kwad.sdk.widget.h(this.Il.getContext(), this.Io, this);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        w(view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
