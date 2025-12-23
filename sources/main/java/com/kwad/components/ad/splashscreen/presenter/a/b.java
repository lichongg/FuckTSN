package com.kwad.components.ad.splashscreen.presenter.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.webview.tachikoma.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends i {
    public b(Context context, int i6, int i7) {
        super(context, i6, i7);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void f(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(com.kwad.sdk.core.response.b.b.dK(vj()))) {
            com.kwad.components.ad.splashscreen.monitor.b.lZ().c(vj(), str2);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void g(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(com.kwad.sdk.core.response.b.b.dK(vj()))) {
            com.kwad.components.ad.splashscreen.monitor.b.lZ().d(vj(), str2);
        }
    }
}
