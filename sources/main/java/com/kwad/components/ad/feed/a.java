package com.kwad.components.ad.feed;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.sdk.components.e implements com.kwad.components.ad.b.d {
    @Override // com.kwad.components.ad.b.d
    public final void loadConfigFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        e.a(ksScene, feedAdListener, true);
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.d.class;
    }

    @Override // com.kwad.components.ad.b.d
    public final void loadFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        if (!l.Cf().CG()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEz;
            feedAdListener.onError(eVar.errorCode, eVar.msg);
        } else {
            e.a(ksScene, feedAdListener, !com.kwad.components.ad.feed.a.b.cg());
        }
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }
}
