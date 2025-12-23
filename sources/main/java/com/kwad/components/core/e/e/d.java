package com.kwad.components.core.e.e;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends b implements View.OnClickListener {
    private TextView PV;
    private TextView PW;
    private TextView tM;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.PU.PT.am(true);
        this.PU.PR.dismiss();
        if (view == this.PV) {
            com.kwad.components.core.e.d.a.a(this.PU.PT);
            com.kwad.sdk.core.adlog.c.p(this.PU.PT.getAdTemplate(), 230);
        } else if (view == this.PW) {
            com.kwad.sdk.core.adlog.c.p(this.PU.PT.getAdTemplate(), 231);
        }
    }

    @Override // com.kwad.components.core.e.e.b, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void at() {
        super.at();
        if (this.PU.PT.pg() == 1) {
            this.tM.setText("即将打开" + com.kwad.sdk.core.response.b.a.cm(this.mAdInfo));
        } else if (this.PU.PT.pg() == 2) {
            this.tM.setText("即将打开第三方页面");
        }
        com.kwad.sdk.c.a.a.a(this, this.PV, this.PW);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.tM = (TextView) findViewById(R.id.ksad_second_confirm_content_view);
        this.PV = (TextView) findViewById(R.id.ksad_second_confirm_ensure);
        this.PW = (TextView) findViewById(R.id.ksad_second_confirm_cancle);
    }
}
