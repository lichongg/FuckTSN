package com.kwad.components.ad.draw.presenter;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.ad.draw.b.a {
    private ComplianceTextView dI;

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.dI.setVisibility(0);
        this.dI.setAdTemplate(this.dz.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dI = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
    }
}
