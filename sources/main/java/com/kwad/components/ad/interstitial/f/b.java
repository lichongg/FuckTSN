package com.kwad.components.ad.interstitial.f;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends Presenter {
    public c mj;

    @Override // com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        this.mj = (c) NN();
    }

    public void dR() {
        List<Presenter> NM = NM();
        if (NM != null) {
            for (Presenter presenter : NM) {
                if (presenter instanceof b) {
                    ((b) presenter).dR();
                }
            }
        }
    }

    public void dS() {
        List<Presenter> NM = NM();
        if (NM != null) {
            for (Presenter presenter : NM) {
                if (presenter instanceof b) {
                    ((b) presenter).dS();
                }
            }
        }
    }
}
