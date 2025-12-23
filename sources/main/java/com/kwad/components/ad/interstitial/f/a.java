package com.kwad.components.ad.interstitial.f;

import android.view.OrientationEventListener;
import android.view.View;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.aq;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends b {
    private ComplianceTextView me;
    private OrientationEventListener mf;
    private KsAutoCloseView mg;

    private void a(final c cVar) {
        OrientationEventListener orientationEventListener = new OrientationEventListener(cVar.kW.getContext()) { // from class: com.kwad.components.ad.interstitial.f.a.1
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i6) {
                a.this.b(cVar);
            }
        };
        this.mf = orientationEventListener;
        if (orientationEventListener.canDetectOrientation()) {
            this.mf.enable();
        } else {
            this.mf.disable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        i(this.me);
        if (aq.isOrientationPortrait()) {
            com.kwad.sdk.c.a.a.b(this.mg, 0, com.kwad.sdk.c.a.a.a(getContext(), 25.0f), 0, 0);
        } else {
            com.kwad.sdk.c.a.a.b(this.mg, 0, 0, 0, 0);
        }
        this.me.setVisibility(0);
        this.me.setAdTemplate(cVar.mAdTemplate);
    }

    private void i(View view) {
        int a6 = com.kwad.sdk.c.a.a.a(getContext(), 4.0f);
        int a7 = com.kwad.sdk.c.a.a.a(getContext(), 4.0f);
        com.kwad.sdk.c.a.a.b(view, a7, a6, a7, 0);
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        c cVar = (c) NN();
        b(cVar);
        a(cVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.me = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        this.mg = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        OrientationEventListener orientationEventListener = this.mf;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }
}
