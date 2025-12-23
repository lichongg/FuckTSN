package com.kwad.components.core.e.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import com.kwad.components.core.e.c.b;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.o.m;
import com.kwad.sdk.widget.KSFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends KSFrameLayout {
    private final b OG;
    private final b.C0615b OH;
    private d OI;
    private InterfaceC0614a OJ;
    private final AdTemplate mAdTemplate;
    private final Context mContext;
    private Presenter mPresenter;
    private final AdBaseFrameLayout mRootContainer;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.e.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0614a {
        void oV();
    }

    private void b(View view, String str) {
        if (view != null) {
            return;
        }
        throw new RuntimeException("inflateView fail " + str + "\n--viewCount:" + getChildCount() + "\n--context:" + this.mContext.getClass().getName() + "\n--LayoutInflater context: " + LayoutInflater.from(this.mContext).getContext().getClass().getName() + "\n--classloader:" + a.class.getClassLoader().getClass().getName());
    }

    private static Presenter bD() {
        Presenter presenter = new Presenter();
        presenter.a(new e());
        return presenter;
    }

    private d oU() {
        d dVar = new d();
        dVar.OG = this.OG;
        dVar.OH = this.OH;
        AdTemplate adTemplate = this.mAdTemplate;
        dVar.mAdTemplate = adTemplate;
        dVar.mRootContainer = this.mRootContainer;
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(adTemplate))) {
            dVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        return dVar;
    }

    public final void setChangeListener(InterfaceC0614a interfaceC0614a) {
        this.OJ = interfaceC0614a;
    }

    public a(Context context, b bVar, b.C0615b c0615b) {
        super(context);
        this.mContext = context;
        this.OG = bVar;
        this.OH = c0615b;
        this.mAdTemplate = c0615b.adTemplate;
        m.inflate(context, R.layout.ksad_download_dialog_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        b(adBaseFrameLayout, "rootView is null");
        b((KsAdWebView) adBaseFrameLayout.findViewById(R.id.ksad_download_tips_web_card_webView), "webView is null");
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        this.OI = oU();
        Presenter bD = bD();
        this.mPresenter = bD;
        bD.K(this.mRootContainer);
        this.mPresenter.n(this.OI);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        d dVar = this.OI;
        if (dVar != null) {
            dVar.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        InterfaceC0614a interfaceC0614a = this.OJ;
        if (interfaceC0614a != null) {
            interfaceC0614a.oV();
        }
    }
}
