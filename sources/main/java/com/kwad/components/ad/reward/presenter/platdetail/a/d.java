package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView ke;
    private ImageView yM;
    private i.a kf = new i.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1
        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            if (d.this.ke == null || com.kwad.components.ad.reward.a.b.hC()) {
                return;
            }
            d.this.ke.post(new bg() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    d.this.ke.setSelected(false);
                    d.this.tm.rE.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }
    };
    private com.kwad.components.ad.reward.m.c yN = new com.kwad.components.ad.reward.m.c() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.2
        @Override // com.kwad.components.ad.reward.m.c
        public final void jB() {
            d.this.jz();
        }
    };

    private void jA() {
        this.ke.setOnClickListener(this);
        this.yM.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jz() {
        g gVar = this.tm;
        KsVideoPlayConfig ksVideoPlayConfig = gVar.mVideoPlayConfig;
        boolean z5 = true;
        if (!gVar.rC && com.kwad.components.core.t.a.aC(getContext()).sW()) {
            this.yM.setSelected(true);
            this.tm.d(false, false);
            z5 = false;
        } else if (ksVideoPlayConfig != null) {
            z5 = ksVideoPlayConfig.isVideoSoundEnable();
            this.yM.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.tm.d(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.yM.setSelected(true);
            this.tm.d(true, true);
        }
        this.ke.setSelected(z5);
        this.tm.rE.setAudioEnabled(z5, false);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.ke) {
            this.tm.rE.setAudioEnabled(!r0.isSelected(), true);
            this.ke.setSelected(!r3.isSelected());
        } else {
            if (view == this.yM) {
                this.tm.rE.setAudioEnabled(!r0.isSelected(), true);
                this.yM.setSelected(!r3.isSelected());
            }
        }
    }

    private void dm() {
        int i6;
        ImageView imageView;
        int i7 = 8;
        if (iA()) {
            this.ke.setVisibility(8);
            imageView = this.yM;
        } else {
            ImageView imageView2 = this.ke;
            if (g.P(this.mAdTemplate)) {
                i6 = 8;
            } else {
                i6 = 0;
            }
            imageView2.setVisibility(i6);
            imageView = this.yM;
            if (g.P(this.mAdTemplate)) {
                i7 = 0;
            }
        }
        imageView.setVisibility(i7);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.tm.a(this.yN);
        this.tm.rE.a(this.kf);
        dm();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ke = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.yM = (ImageView) findViewById(R.id.ksad_reward_deep_task_sound_switch);
        jA();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rE.b(this.kf);
        this.tm.b(this.yN);
    }
}
