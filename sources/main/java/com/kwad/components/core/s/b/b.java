package com.kwad.components.core.s.b;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.proxy.f;
import com.kwad.sdk.R;
import com.kwad.sdk.components.o;
import com.kwad.sdk.mvp.Presenter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends Presenter {
    private FrameLayout Yp;
    private com.kwad.components.core.s.a.b Ys;
    private o Yv;

    public final boolean onBackPressed() {
        o oVar = this.Yv;
        return oVar != null && oVar.onBackPressed();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.Ys = (com.kwad.components.core.s.a.b) NN();
        this.Yp = (FrameLayout) findViewById(R.id.ksad_js_container);
        this.Yv = this.Ys.Yj.a(null);
        this.Ys.Rt.add(new com.kwad.components.core.m.a.a() { // from class: com.kwad.components.core.s.b.b.1
            @Override // com.kwad.components.core.m.a.a
            public final void gZ() {
                if (b.this.Ys.Yi != null) {
                    b.this.Ys.Yi.callbackDismiss();
                }
            }

            @Override // com.kwad.components.core.m.a.a
            public final void gY() {
            }

            @Override // com.kwad.components.core.m.a.a
            public final void c(f fVar) {
            }

            @Override // com.kwad.components.core.m.a.a
            public final void d(f fVar) {
            }
        });
        if (this.Yv == null) {
            if (getActivity() != null) {
                getActivity().finish();
            }
        } else {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            View view = this.Yv.getView();
            view.setLayoutParams(layoutParams);
            this.Yp.addView(view);
            this.Yv.bindActivity(getActivity());
            this.Yv.render();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
