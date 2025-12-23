package com.kwad.components.core.j;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInnerAd;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {

    @Nullable
    private Object Rf;

    public final void destroy() {
        this.Rf = null;
    }

    public final void c(c cVar) {
        if (this.Rf == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.Rf).onAdClicked((KsInnerAd) cVar.getHost());
        } catch (Exception unused) {
        }
    }

    public final void d(c cVar) {
        if (this.Rf == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.Rf).onAdShow((KsInnerAd) cVar.getHost());
        } catch (Exception unused) {
        }
    }

    public d(Object obj) {
        this.Rf = obj;
    }
}
