package com.kwad.components.ad.draw;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.t.n;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    public static void loadDrawAd(KsScene ksScene, @NonNull final KsLoadManager.DrawAdListener drawAdListener) {
        final SceneImpl covert = SceneImpl.covert(ksScene);
        if (covert.getAdNum() <= 0) {
            com.kwad.components.ad.draw.a.c.a(covert, "ad_num");
        }
        boolean b6 = n.tn().b(covert, "loadDrawAd");
        covert.setAdStyle(6);
        com.kwad.components.ad.draw.a.c.b(covert);
        com.kwad.sdk.commercial.d.d.c(covert);
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        KsAdLoadManager.M().a(new a.C0634a().e(new ImpInfo(covert)).aM(b6).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.draw.d.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i6, final String str) {
                com.kwad.components.ad.draw.a.c.a(SceneImpl.this, i6, str, SystemClock.elapsedRealtime() - elapsedRealtime);
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.draw.d.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i6), str));
                        drawAdListener.onError(i6, str);
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void b(@NonNull AdResultData adResultData) {
                String str;
                com.kwad.components.ad.draw.a.c.a(SceneImpl.this, adResultData.getAdTemplateList().size(), SystemClock.elapsedRealtime() - elapsedRealtime);
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null) {
                        AdInfo el = e.el(adTemplate);
                        if (adTemplate.adStyle != 6) {
                            com.kwad.components.ad.draw.a.c.h(adTemplate);
                        }
                        if (!com.kwad.sdk.core.response.b.a.cR(el) && TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(el))) {
                            com.kwad.components.ad.draw.a.c.h(adTemplate);
                        } else {
                            arrayList.add(new c(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate)));
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    int i6 = com.kwad.sdk.core.network.e.aEq.errorCode;
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str = com.kwad.sdk.core.network.e.aEq.msg + "(无视频资源)";
                    } else {
                        str = adResultData.testErrorMsg;
                    }
                    onError(i6, str);
                } else {
                    bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.draw.d.1.2
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            KsAdLoadManager.M().b(arrayList);
                            drawAdListener.onDrawAdLoad(arrayList);
                        }
                    });
                }
                com.kwad.components.ad.draw.a.c.b(SceneImpl.this, arrayList.size(), SystemClock.elapsedRealtime() - elapsedRealtime);
                com.kwad.sdk.commercial.d.d.a(SceneImpl.this, arrayList.size());
            }
        }).sw());
    }
}
