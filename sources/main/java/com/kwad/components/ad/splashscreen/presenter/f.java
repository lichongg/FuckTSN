package com.kwad.components.ad.splashscreen.presenter;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f extends e {
    private ComplianceTextView dI;

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        int i6;
        super.at();
        if (com.kwad.components.ad.splashscreen.e.c.z(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate))) {
            i6 = R.id.ksad_compliance_right_view;
        } else {
            i6 = R.id.ksad_compliance_left_view;
        }
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(i6);
        this.dI = complianceTextView;
        complianceTextView.setBackgroundColor(0);
        this.dI.setVisibility(0);
        this.dI.setAdTemplate(this.Gf.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
