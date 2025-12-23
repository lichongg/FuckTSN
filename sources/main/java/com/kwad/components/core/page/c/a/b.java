package com.kwad.components.core.page.c.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @Nullable
    public com.kwad.components.core.page.a.a TK;

    @Nullable
    public KsAdWebView.c TL;

    @Nullable
    public f.a TM;

    @Nullable
    @Deprecated
    public com.kwad.components.core.webview.jshandler.b TN;
    public boolean TO = false;
    public boolean TP = false;

    @NonNull
    public AdWebViewActivityProxy.a Tu;

    @NonNull
    public ViewGroup jI;

    @NonNull
    public AdTemplate mAdTemplate;

    @NonNull
    public KsAdWebView mAdWebView;
    public boolean mAutoShow;

    @NonNull
    public Context mContext;

    @Nullable
    public String mPageTitle;

    @NonNull
    public String mPageUrl;
    public boolean mShowPermission;

    @Nullable
    public com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    private void aJ(boolean z5) {
        this.TP = true;
    }

    public final void a(KsAdWebView.c cVar) {
        this.TL = cVar;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.TL = null;
        this.TM = null;
        this.mWebCardCloseListener = null;
        this.TN = null;
    }

    public final void a(f.a aVar) {
        this.TM = aVar;
    }

    public final boolean qT() {
        return this.mShowPermission;
    }

    public final void qY() {
        com.kwad.components.core.webview.jshandler.b bVar = this.TN;
        if (bVar != null) {
            bVar.rs();
        }
    }

    public final boolean re() {
        return this.TP;
    }

    public final void setWebCardCloseListener(@Nullable com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    public final void a(boolean z5, View view) {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null && ksAdWebView.canGoBack()) {
            this.mAdWebView.goBack();
            if (z5) {
                com.kwad.sdk.core.adlog.c.bZ(this.mAdTemplate);
                return;
            }
            return;
        }
        com.kwad.components.core.page.a.a aVar = this.TK;
        if (aVar != null) {
            aVar.qO();
        }
    }

    public final boolean rf() {
        if (qT()) {
            return false;
        }
        return true;
    }

    public final void a(com.kwad.components.core.webview.jshandler.b bVar) {
        this.TN = bVar;
        aJ(true);
    }
}
