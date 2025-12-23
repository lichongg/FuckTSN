package com.kwad.components.core.webview.tachikoma.d;

import android.app.Activity;
import com.kwad.components.core.webview.tachikoma.d.e;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends com.kwad.sdk.mvp.a {
    public String AI;
    public long AO;
    public com.kwad.components.core.webview.tachikoma.f.c Yd;
    public StyleTemplate Yf;
    public e afi;
    public g ahq;
    public l ahr;
    public k ahs;
    public boolean aht;
    public e.a ahu;
    public Activity mActivity;
    public AdResultData mAdResultData;

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.afi = null;
        this.mActivity = null;
        this.ahq = null;
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
    }
}
