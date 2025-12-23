package com.kwad.components.ad.splashscreen.e;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements com.kwad.sdk.widget.d {
    private a Gy;
    private ViewStub Jq;
    private ViewGroup Jr;
    private View Js;
    private TextView Jt;
    private boolean Ju;

    @Nullable
    private e Jv;
    private h Jw;

    @NonNull
    private ViewGroup jI;

    @Nullable
    private AdInfo mAdInfo;

    @Nullable
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(String str) {
        TextView textView = this.Jt;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.Js = viewGroup.findViewById(R.id.ksad_splash_actionbar_native);
        this.Jt = (TextView) viewGroup.findViewById(R.id.ksad_splash_actionbar_text);
        this.Jw = new h(this.Js.getContext(), this.Js, this);
        a(com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mAdInfo, this.mApkDownloadHelper, 4));
    }

    private void i(boolean z5, boolean z6) {
        e eVar = this.Jv;
        if (eVar != null) {
            eVar.h(z5, z6);
        }
    }

    public final void a(@Nullable e eVar) {
        this.Jv = eVar;
    }

    public final void as(AdTemplate adTemplate) {
        a aVar;
        this.mAdTemplate = adTemplate;
        a aVar2 = this.Gy;
        if (aVar2 == null) {
            this.Gy = new a(this.jI.getContext(), this.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.e.b.1
                {
                    super(r3);
                }

                @Override // com.kwad.components.ad.splashscreen.e.a
                protected final void j(int i6, String str) {
                    b.this.ab(str);
                }
            };
        } else {
            aVar2.setAdTemplate(adTemplate);
        }
        if (adTemplate != null) {
            this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplate);
        }
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (aVar = this.Gy) == null) {
            return;
        }
        cVar.b(aVar);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (this.Ju) {
            i(false, view.equals(this.Js));
        }
    }

    public final void mA() {
        com.kwad.sdk.core.d.c.d("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.Jq);
        if (this.Jr == null) {
            ViewStub viewStub = this.Jq;
            if (viewStub == null || viewStub.getParent() == null) {
                this.Jr = (ViewGroup) this.jI.findViewById(R.id.ksad_splash_actionbar_native_root);
            } else {
                this.Jr = (ViewGroup) this.Jq.inflate();
            }
            g(this.Jr);
        }
        ViewGroup viewGroup = this.Jr;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public final void onUnbind() {
        a aVar;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (aVar = this.Gy) == null) {
            return;
        }
        cVar.c(aVar);
    }

    public b(@NonNull ViewGroup viewGroup, ViewStub viewStub, boolean z5, com.kwad.components.core.e.d.c cVar) {
        this.jI = viewGroup;
        this.Jq = viewStub;
        this.mApkDownloadHelper = cVar;
        this.Ju = z5;
    }

    private void a(com.kwad.components.ad.splashscreen.d dVar) {
        if (dVar == null) {
            return;
        }
        ab(dVar.lA());
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        i(true, view.equals(this.Js));
    }
}
