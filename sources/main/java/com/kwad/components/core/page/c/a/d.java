package com.kwad.components.core.page.c.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends a {
    private View Ua;
    private TextView Ub;
    private int Uc;
    private Runnable Ud = new Runnable() { // from class: com.kwad.components.core.page.c.a.d.1
        @Override // java.lang.Runnable
        public final void run() {
            if (com.kwad.components.core.r.a.sF().sI()) {
                bw.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (d.this.Uc > 0) {
                d.this.Ub.setText(String.format("倒计时%d秒", Integer.valueOf(d.this.Uc)));
                d.c(d.this);
                com.kwad.components.core.r.a.sF().aY(d.this.Uc);
                bw.runOnUiThreadDelay(this, 1000L);
                return;
            }
            d.this.Ub.setText("已获得权益");
            bw.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.c.a.d.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.Ua.setVisibility(8);
                }
            }, 500L);
            com.kwad.components.core.r.a.sF().aN(true);
        }
    };

    static /* synthetic */ int c(d dVar) {
        int i6 = dVar.Uc;
        dVar.Uc = i6 - 1;
        return i6;
    }

    private void rk() {
        TextView textView;
        if (this.Ua == null || (textView = this.Ub) == null) {
            return;
        }
        textView.setText(String.format("倒计时%d秒", Integer.valueOf(this.Uc)));
        this.Ua.setVisibility(0);
        bw.runOnUiThreadDelay(this.Ud, 1000L);
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.Uc = com.kwad.sdk.core.response.b.a.aM(com.kwad.sdk.core.response.b.e.el(this.TJ.mAdTemplate));
        com.kwad.components.core.r.a.sF().aY(this.Uc);
        rk();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Ua = findViewById(R.id.ksad_web_reward_task_layout);
        this.Ub = (TextView) findViewById(R.id.ksad_web_reward_task_text);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        bw.c(this.Ud);
    }
}
