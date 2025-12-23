package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsRotateView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class m extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.a {
    private TextView GI;
    private com.kwad.components.ad.splashscreen.d GN;
    private View Hd;
    private KsRotateView He;
    private TextView Hf;
    private com.kwad.sdk.core.g.c gY;
    private long mStartTime;

    @Override // com.kwad.sdk.core.g.a
    public final void ce() {
        com.kwad.sdk.core.adlog.c.ca(this.Gf.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void fM() {
        KsRotateView ksRotateView = this.He;
        if (ksRotateView == null) {
            return;
        }
        ksRotateView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.m.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                m.this.He.fM();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void i(int i6, String str) {
        TextView textView = this.GI;
        if (textView != null) {
            if (i6 == 2) {
                textView.setText(str);
                return;
            }
            textView.setText("或点击" + str);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lG() {
        com.kwad.sdk.core.g.c cVar = this.gY;
        if (cVar != null) {
            cVar.bH(mv());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mn() {
        AdTemplate adTemplate = this.Gf.mAdTemplate;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.GN = com.kwad.components.ad.splashscreen.d.a(adTemplate, el, this.Gf.mApkDownloadHelper, 1);
        TextView textView = this.Hf;
        if (textView != null) {
            textView.setText(com.kwad.sdk.core.response.b.b.dE(el));
        }
        TextView textView2 = this.GI;
        if (textView2 != null) {
            textView2.setText("或点击" + this.GN.lA());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mo() {
        View view = this.Hd;
        if (view == null || this.Gf == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.Gf.mAdTemplate, 184, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.vI().bm(184);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mp() {
        AdMatrixInfo.RotateInfo dk = com.kwad.sdk.core.response.b.b.dk(this.Gf.mAdTemplate);
        com.kwad.sdk.core.g.c cVar = this.gY;
        if (cVar != null) {
            cVar.b(dk);
            return;
        }
        com.kwad.sdk.core.g.c cVar2 = new com.kwad.sdk.core.g.c(dk);
        this.gY = cVar2;
        cVar2.a(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mq() {
        com.kwad.sdk.core.g.c cVar = this.gY;
        if (cVar != null) {
            cVar.bG(mv());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mr() {
        com.kwad.sdk.core.g.c cVar = this.gY;
        if (cVar != null) {
            cVar.bH(mv());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.Gf.c(1, mv(), 162, 1);
    }

    @Override // com.kwad.sdk.core.g.a
    public final void r(final String str) {
        boolean wl = this.Gf.Fs.wl();
        boolean oW = com.kwad.components.core.e.c.b.oW();
        if (!wl || oW) {
            return;
        }
        this.He.nw();
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar != null) {
            hVar.a(1, mv(), 161, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.m.3
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.dv(str);
                }
            });
        }
        mt();
        mr();
    }

    @Nullable
    private Context mv() {
        Context context;
        View view;
        try {
            context = getContext();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            context = null;
        }
        if (context == null && (view = this.Hd) != null) {
            return view.getContext();
        }
        return context;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        View rootView = getRootView();
        if (rootView != null) {
            rootView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.m.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    com.kwad.components.ad.splashscreen.h hVar = m.this.Gf;
                    if (hVar != null) {
                        hVar.FH = SystemClock.elapsedRealtime() - m.this.mStartTime;
                    }
                }
            });
            com.kwad.components.ad.splashscreen.h hVar = this.Gf;
            if (hVar != null) {
                hVar.a(this);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_rotate_layout);
        if (viewStub != null) {
            this.Hd = viewStub.inflate();
        } else {
            this.Hd = findViewById(R.id.ksad_rotate_root);
        }
        this.Hf = (TextView) findViewById(R.id.ksad_rotate_text);
        this.GI = (TextView) findViewById(R.id.ksad_rotate_action);
        KsRotateView ksRotateView = (KsRotateView) findViewById(R.id.ksad_rotate_view);
        this.He = ksRotateView;
        ksRotateView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("SplashRotatePresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar != null) {
            hVar.b(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ak(int i6) {
    }
}
