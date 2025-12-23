package com.kwad.components.ad.fullscreen.c.a;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.work.WorkRequest;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ca;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements ca.a {
    private ca bQ;
    private m jE = new m() { // from class: com.kwad.components.ad.fullscreen.c.a.a.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            if (!a.this.tm.rE.kW()) {
                a.this.a(j6, j7);
                a.this.jY = j7;
            } else if (j7 > 800) {
                a.this.jY = j7;
                if (a.this.jY > j6) {
                    a.this.jV.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.jW.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(a.this.getContext(), 0.0f);
                    a.this.jW.setLayoutParams(marginLayoutParams);
                }
                a.this.a(j6, j7);
                a.a(a.this, true);
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.h
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (!a.this.jX) {
                a.this.bQ.sendEmptyMessageDelayed(1, 500L);
            }
        }
    };
    private TextView jV;
    private View jW;
    private boolean jX;
    private long jY;
    private AdInfo mAdInfo;

    private void G(int i6) {
        this.jV.setText(String.valueOf(i6));
    }

    private void dm() {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
        this.mAdInfo = el;
        this.jV.setText(String.valueOf(com.kwad.sdk.core.response.b.a.L(el)));
        this.jV.setVisibility(0);
        this.tm.rE.a(this.jE);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.bQ = new ca(this);
        dm();
        if (this.tm.rE.kW()) {
            G(30);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jV = (TextView) findViewById(R.id.ksad_video_count_down);
        this.jW = findViewById(R.id.ksad_video_sound_switch);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rE.b(this.jE);
        this.jX = false;
        this.bQ.removeCallbacksAndMessages(null);
    }

    static /* synthetic */ boolean a(a aVar, boolean z5) {
        aVar.jX = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j6, long j7) {
        int i6 = (int) (((j6 - j7) / 1000.0f) + 0.5f);
        if (i6 <= 0) {
            i6 = 1;
        }
        G(i6);
    }

    @Override // com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (!this.tm.gV() && !this.tm.gU()) {
                long j6 = this.jY + 500;
                this.jY = j6;
                if (j6 > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                    this.jV.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jW.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(getContext(), 0.0f);
                    this.jW.setLayoutParams(marginLayoutParams);
                    return;
                }
                a(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, j6);
                this.bQ.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.bQ.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
