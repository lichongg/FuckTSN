package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bg;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private m jE = new m() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.b.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            b.this.k(j7);
        }
    };
    private TextView ka;
    private long kc;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    private void dm() {
        this.mApkDownloadHelper = this.tm.mApkDownloadHelper;
        this.kc = com.kwad.sdk.core.response.b.d.dX(this.mAdTemplate);
        this.tm.rE.a(this.jE);
    }

    private void dn() {
        if (this.ka.getVisibility() == 0) {
            return;
        }
        this.ka.setText(com.kwad.sdk.core.response.b.d.dY(this.mAdTemplate));
        this.ka.setVisibility(0);
        this.ka.setOnClickListener(this);
        this.ka.post(new bg() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.b.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.this.m117do();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do, reason: not valid java name */
    public void m117do() {
        this.tm.D("native_id");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j6) {
        if (j6 >= this.kc) {
            dn();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.ka) {
            this.tm.a(1, view.getContext(), 40, 1, this.tm.rE.getPlayDuration());
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
        TextView textView = (TextView) findViewById(R.id.ksad_detail_call_btn);
        this.ka = textView;
        textView.setContentDescription("topBarCallLabel");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rE.b(this.jE);
        this.ka.setVisibility(8);
    }
}
