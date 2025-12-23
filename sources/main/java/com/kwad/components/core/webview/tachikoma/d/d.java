package com.kwad.components.core.webview.tachikoma.d;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.components.o;
import com.kwad.sdk.mvp.Presenter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends Presenter {
    private FrameLayout Yp;
    private o Yv;
    private e afi;
    protected b ahp;

    public final boolean onBackPressed() {
        o oVar = this.Yv;
        return oVar != null && oVar.onBackPressed();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        b bVar = (b) NN();
        this.ahp = bVar;
        e eVar = bVar.afi;
        this.afi = eVar;
        if (eVar != null) {
            eVar.a(new com.kwad.components.core.webview.tachikoma.f.e() { // from class: com.kwad.components.core.webview.tachikoma.d.d.1
                @Override // com.kwad.components.core.webview.tachikoma.f.e
                public final void ha() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.f.e
                public final void hi() {
                }
            });
        }
        o a6 = this.ahp.ahs.a(null);
        this.Yv = a6;
        if (a6 == null) {
            this.ahp.ahr.callbackPageStatus(false, null);
            this.afi.getDialog().dismiss();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View view = this.Yv.getView();
        view.setLayoutParams(layoutParams);
        this.Yp.addView(view);
        this.Yv.render();
        this.ahp.ahr.callbackPageStatus(true, null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Yp = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
