package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class j extends o<com.kwad.components.core.request.a, AdResultData> {
    private final com.kwad.components.core.request.model.a NR;

    protected boolean a(com.kwad.components.core.request.model.a aVar, AdResultData adResultData) {
        return false;
    }

    public j(com.kwad.components.core.request.model.a aVar) {
        this.NR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(@NonNull com.kwad.components.core.request.a aVar, @NonNull final AdResultData adResultData) {
        super.onSuccess(aVar, adResultData);
        GlobalThreadPools.Jt().submit(new bg() { // from class: com.kwad.components.core.c.j.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                j jVar = j.this;
                j.m(adResultData);
            }
        });
        if (a(this.NR, adResultData)) {
            return;
        }
        com.kwad.components.core.request.model.a.a(this.NR, adResultData, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static void m(AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        a nZ = a.nZ();
        if (nZ != null && proceedTemplateList.size() > 0) {
            AdTemplate adTemplate = proceedTemplateList.get(0);
            e x5 = e.x(adResultData.getPosId());
            nZ.oa();
            nZ.j(h.a(x5, adResultData));
            nZ.a(e.au(adTemplate));
        }
    }

    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onError(@NonNull com.kwad.components.core.request.a aVar, int i6, String str) {
        super.onError(aVar, i6, str);
        com.kwad.components.core.request.model.a.a(this.NR, i6, str, false);
    }
}
