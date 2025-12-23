package com.kwad.components.ad.reward;

import android.content.Context;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l {
    public static void j(g gVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = gVar.mAdTemplate;
        Context context = gVar.mContext;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if ((com.kwad.sdk.core.response.b.a.bK(el) && (aVar = gVar.rF) != null && aVar.rS()) || com.kwad.components.ad.reward.a.b.k(el) || adTemplate.mXiaomiAppStoreDetailViewOpen || !com.kwad.sdk.core.response.b.a.aF(el) || !com.kwad.sdk.core.response.b.a.at(el) || adTemplate.hasEnterAdWebViewLandPageActivity) {
            return;
        }
        gVar.mAdTemplate.hasEnterAdWebViewLandPageActivity = true;
        DownloadLandPageActivity.launch(context, adTemplate, true);
    }
}
