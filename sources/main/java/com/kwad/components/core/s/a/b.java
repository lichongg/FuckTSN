package com.kwad.components.core.s.a;

import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.n;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.core.m.a {
    public StyleTemplate Yf;
    public n Yi;
    public k Yj;
    public AdResultData mAdResultData;
    public AdBaseFrameLayout mRootContainer;

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = c.r(adResultData);
    }

    public b(a aVar) {
        super(aVar);
    }
}
