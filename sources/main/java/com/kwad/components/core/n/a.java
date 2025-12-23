package com.kwad.components.core.n;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends l<com.kwad.components.core.request.a, AdResultData> {
    private ImpInfo Rw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.l
    @NonNull
    /* renamed from: af */
    public AdResultData parseData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(this.Rw.adScene);
        adResultData.parseJson(jSONObject);
        return adResultData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.a
    @NonNull
    /* renamed from: ou */
    public com.kwad.components.core.request.a createRequest() {
        return new com.kwad.components.core.request.a(this.Rw);
    }

    public a(ImpInfo impInfo) {
        this.Rw = impInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.l
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void afterParseData(AdResultData adResultData) {
        super.afterParseData(adResultData);
        p(adResultData);
    }

    private static void p(AdResultData adResultData) {
        for (AdTemplate adTemplate : adResultData.getProceedTemplateList()) {
            AdInfo el = e.el(adTemplate);
            if (com.kwad.sdk.core.response.b.a.bd(el)) {
                if (com.kwad.sdk.core.response.b.a.ba(el).size() == 0) {
                    com.kwad.components.core.p.a.se().f(adTemplate, 21005);
                }
            } else if (com.kwad.sdk.core.response.b.a.bi(el) && TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(el))) {
                com.kwad.components.core.p.a.se().f(adTemplate, 21006);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public ExecutorService getExecutor() {
        return GlobalThreadPools.Ju();
    }
}
