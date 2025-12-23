package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j extends b {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        try {
            this.tm.rE.kS();
        } catch (Throwable th) {
            bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.presenter.j.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    ServiceProvider.reportSdkCaughtException(th);
                    j.this.iz();
                }
            });
        }
    }
}
