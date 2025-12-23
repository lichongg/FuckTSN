package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class SplashEndLandView extends FrameLayout {
    private TextView IA;
    private TextView IB;
    private TextView IC;
    private int ID;
    private CloseCountDownView Ij;
    private ViewGroup Ik;
    private ViewGroup Il;
    private ImageView Im;
    private TextView In;
    private TextView Io;
    private ImageView Iz;
    private KsLogoView cx;

    public SplashEndLandView(@NonNull Context context) {
        super(context);
        this.ID = 24;
    }

    public final void a(AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar, float f6) {
        a(new g(getContext(), f6));
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.Im.setImageResource(R.drawable.ksad_default_app_icon);
        com.kwad.sdk.core.d.c.d("SplashEndLandView", "bindView, appIconRadius: " + this.ID);
        KSImageLoader.loadAppIcon(this.Im, com.kwad.sdk.core.response.b.a.co(el), adTemplate, this.ID);
        this.In.setText(com.kwad.sdk.core.response.b.a.cl(el));
        this.Io.setText(com.kwad.sdk.core.response.b.a.au(el));
        this.cx.aP(adTemplate);
        if (com.kwad.sdk.core.response.b.a.aF(el)) {
            b(adTemplate, el, cVar);
        } else {
            this.IB.setText("点击查看");
            this.IC.setVisibility(0);
            this.IC.setText("跳转详情页/第三方应用");
        }
        this.Ij.a(el, f6);
    }

    private void b(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar) {
        if (cVar == null) {
            return;
        }
        String a6 = com.kwad.components.ad.splashscreen.d.a(adTemplate, adInfo, cVar.pB(), 0);
        if (TextUtils.isEmpty(a6)) {
            this.IB.setText(com.kwad.sdk.core.response.b.a.aE(adInfo));
        } else {
            this.IB.setText(a6);
        }
    }

    public final void ab(String str) {
        TextView textView = this.IB;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public final void bt() {
        CloseCountDownView closeCountDownView = this.Ij;
        if (closeCountDownView != null) {
            closeCountDownView.bt();
        }
    }

    public final void bu() {
        CloseCountDownView closeCountDownView = this.Ij;
        if (closeCountDownView != null) {
            closeCountDownView.bu();
        }
    }

    public ViewGroup getActionBarView() {
        return this.Il;
    }

    public TextView getAppDesc() {
        return this.Io;
    }

    public ImageView getAppIcon() {
        return this.Im;
    }

    public TextView getAppName() {
        return this.In;
    }

    public CloseCountDownView getCloseView() {
        return this.Ij;
    }

    public ViewGroup getGiftBoxView() {
        return this.Ik;
    }

    public final void mI() {
        CloseCountDownView closeCountDownView = this.Ij;
        if (closeCountDownView != null) {
            closeCountDownView.cq();
        }
    }

    public final void t(boolean z5) {
        View.inflate(getContext(), z5 ? R.layout.ksad_splash_end_card_area_land : R.layout.ksad_splash_end_card_area, this);
        this.Iz = (ImageView) findViewById(R.id.ksad_ad_endcard_title_view);
        this.Ik = (ViewGroup) findViewById(R.id.ksad_splash_end_card_giftbox_view);
        this.Im = (ImageView) findViewById(R.id.ksad_ad_endcard_icon);
        this.In = (TextView) findViewById(R.id.ksad_ad_endcard_appname);
        this.IA = (TextView) findViewById(R.id.ksad_ad_endcard_appversion);
        this.Io = (TextView) findViewById(R.id.ksad_ad_endcard_appdesc);
        this.cx = (KsLogoView) findViewById(R.id.ksad_ad_endcard_logo);
        this.IB = (TextView) findViewById(R.id.ksad_ad_btn_title);
        this.IC = (TextView) findViewById(R.id.ksad_ad_btn_sub_title);
        this.Ij = (CloseCountDownView) findViewById(R.id.ksad_ad_endcard_close_root);
        this.Il = (ViewGroup) findViewById(R.id.ksad_splash_endcard_actionbar);
    }

    public SplashEndLandView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ID = 24;
    }

    public SplashEndLandView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.ID = 24;
    }

    @RequiresApi(api = 21)
    public SplashEndLandView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.ID = 24;
    }

    private void a(g gVar) {
        ak.a(this.Iz, gVar.mJ());
        ak.a(this.Ik, gVar.mK());
        ak.a(this.Im, gVar.mL());
        ak.a(this.Il, gVar.mN());
        ak.a(this.In, gVar.mO());
        ak.a(this.IA, gVar.mP());
        ak.a(this.Io, gVar.mQ());
        ak.a(this.Ij, gVar.mR());
        TextView textView = this.In;
        if (textView != null) {
            textView.setTextSize(0, gVar.mS());
        }
        TextView textView2 = this.IA;
        if (textView2 != null) {
            textView2.setTextSize(0, gVar.mT());
        }
        TextView textView3 = this.Io;
        if (textView3 != null) {
            textView3.setTextSize(0, gVar.mU());
        }
        TextView textView4 = this.IB;
        if (textView4 != null) {
            textView4.setTextSize(0, gVar.mV());
        }
        TextView textView5 = this.IC;
        if (textView5 != null) {
            textView5.setTextSize(0, gVar.mW());
        }
        this.ID = gVar.mM();
    }
}
