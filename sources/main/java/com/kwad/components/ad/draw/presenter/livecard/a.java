package com.kwad.components.ad.draw.presenter.livecard;

import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.ad.draw.b.a {
    private AdLiveHandleClickListener ea = new AdLiveHandleClickListener() { // from class: com.kwad.components.ad.draw.presenter.livecard.a.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener
        public final void handleAdLiveClick(int i6) {
            if (i6 == 1) {
                a.this.dz.a(1, a.this.getContext(), 115, 1);
            } else if (i6 == 2) {
                a.this.dz.a(1, a.this.getContext(), 117, 2);
            }
        }
    };

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        IAdLiveOfflineView iAdLiveOfflineView = this.dz.dD;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.registerClickListener(this.ea);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        IAdLiveOfflineView iAdLiveOfflineView = this.dz.dD;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.unRegisterClickListener(this.ea);
        }
    }
}
