package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.content.Context;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ak;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g {
    private float IE;
    private Context mContext;

    public final ak mJ() {
        return new ak(g(this.mContext, R.dimen.ksad_splash_endcard_title_iconw_land), g(this.mContext, R.dimen.ksad_splash_endcard_title_iconh_land));
    }

    public final ak mK() {
        return new ak(g(this.mContext, R.dimen.ksad_splash_endcard_gift_iconw_land), g(this.mContext, R.dimen.ksad_splash_endcard_gift_iconh_land));
    }

    public final ak mL() {
        int g6 = g(this.mContext, R.dimen.ksad_splash_endcard_app_iconw_land);
        int g7 = g(this.mContext, R.dimen.ksad_splash_endcard_app_iconh_land);
        int g8 = g(this.mContext, R.dimen.ksad_splash_endcard_app_margin_top_land);
        ak akVar = new ak(g6, g7);
        akVar.eR(g8);
        return akVar;
    }

    public final int mM() {
        return com.kwad.sdk.c.a.a.px2dip(this.mContext, (int) (g(this.mContext, R.dimen.ksad_splash_endcard_app_iconw_land) * 0.24f));
    }

    public final ak mN() {
        return new ak(g(this.mContext, R.dimen.ksad_splash_endcard_actionbar_iconw_land), g(this.mContext, R.dimen.ksad_splash_endcard_actionbar_iconh_land));
    }

    public final ak mO() {
        int g6 = g(this.mContext, R.dimen.ksad_splash_endcard_appname_h_land);
        int g7 = g(this.mContext, R.dimen.ksad_splash_endcard_appname_margin_top_land);
        ak akVar = new ak(0, g6);
        akVar.eR(g7);
        return akVar;
    }

    public final ak mP() {
        return new ak(0, g(this.mContext, R.dimen.ksad_splash_endcard_appver_h_land));
    }

    public final ak mQ() {
        int g6 = g(this.mContext, R.dimen.ksad_splash_endcard_appdesc_h_land);
        int g7 = g(this.mContext, R.dimen.ksad_splash_endcard_appdesc_margin_top_land);
        ak akVar = new ak(0, g6);
        akVar.eR(g7);
        return akVar;
    }

    public final ak mR() {
        int g6 = g(this.mContext, R.dimen.ksad_splash_endcard_close_root_h_land);
        int g7 = g(this.mContext, R.dimen.ksad_splash_endcard_close_root_margin_top_land);
        ak akVar = new ak(0, g6);
        akVar.eR(g7);
        return akVar;
    }

    public final int mS() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_appname_text_sp_land);
    }

    public final int mT() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_appver_text_sp_land);
    }

    public final int mU() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_appdesc_text_sp_land);
    }

    public final int mV() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_ab_title_text_sp_land);
    }

    public final int mW() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_ab_subtitle_text_sp_land);
    }

    public g(Context context, float f6) {
        this.mContext = context;
        this.IE = f6;
    }

    private int g(Context context, int i6) {
        return (int) (com.kwad.sdk.c.a.a.h(context, i6) * this.IE);
    }
}
