package com.kwad.components.ad.fullscreen.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private m jE = new m() { // from class: com.kwad.components.ad.fullscreen.c.a.b.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            b.this.k(j7);
        }
    };
    private TextView ka;
    private String kb;
    private long kc;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    private void dm() {
        this.kc = com.kwad.sdk.core.response.b.d.dX(this.mAdTemplate);
        String dY = com.kwad.sdk.core.response.b.d.dY(this.mAdTemplate);
        this.kb = dY;
        if (TextUtils.isEmpty(dY)) {
            return;
        }
        g gVar = this.tm;
        this.mApkDownloadHelper = gVar.mApkDownloadHelper;
        gVar.rE.a(this.jE);
    }

    private void dn() {
        if (this.ka.getVisibility() == 0) {
            return;
        }
        this.ka.setText(com.kwad.sdk.core.response.b.d.dY(this.mAdTemplate));
        this.ka.setVisibility(0);
        this.ka.setOnClickListener(this);
        m114do();
    }

    /* renamed from: do, reason: not valid java name */
    private void m114do() {
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 18, this.tm.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j6) {
        if (j6 >= this.kc) {
            dn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(this.tm.mRootContainer.getTouchCoords()).dd(40), this.tm.mReportExtData);
        this.tm.rD.cW();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.ka) {
            com.kwad.components.core.e.d.a.a(new a.C0616a(view.getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aA(40).az(1).aq(false).al(this.tm.gI()).aB(1).a(new a.b() { // from class: com.kwad.components.ad.fullscreen.c.a.b.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    b.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        dm();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ka = (TextView) findViewById(R.id.ksad_detail_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.ka = null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (!TextUtils.isEmpty(this.kb)) {
            this.tm.rE.b(this.jE);
        }
    }
}
