package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private TextView zg;
    private TextView zh;

    /* renamed from: do, reason: not valid java name */
    private void m116do() {
        g gVar = this.tm;
        com.kwad.sdk.core.adlog.c.b(gVar.mAdTemplate, 17, gVar.mReportExtData);
    }

    private void jM() {
        String dZ = com.kwad.sdk.core.response.b.d.dZ(this.tm.mAdTemplate);
        if (this.tm.mScreenOrientation == 1) {
            this.zh.setVisibility(8);
            this.zg.setText(dZ);
            this.zg.setVisibility(0);
            this.zg.setOnClickListener(this);
        } else {
            this.zg.setVisibility(8);
            this.zh.setText(dZ);
            this.zh.setVisibility(0);
            this.zh.setOnClickListener(this);
        }
        m116do();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jN() {
        com.kwad.sdk.core.adlog.c.b dd = new com.kwad.sdk.core.adlog.c.b().f(this.tm.mRootContainer.getTouchCoords()).dd(39);
        g gVar = this.tm;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, "native_id", "endTopBar", dd, gVar.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        this.tm.rD.cW();
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void jO() {
        if (this.tm.sf) {
            return;
        }
        jM();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.zg || view == this.zh) {
            com.kwad.components.core.e.d.a.a(new a.C0616a(view.getContext()).aB(this.tm.mAdTemplate).b(this.tm.mApkDownloadHelper).aq(false).aB(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.d.b.a.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    a.this.jN();
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.zg = (TextView) findViewById(R.id.ksad_end_left_call_btn);
        this.zh = (TextView) findViewById(R.id.ksad_end_right_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.zg.setVisibility(8);
        this.zh.setVisibility(8);
    }
}
