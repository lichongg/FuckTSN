package com.kwad.components.ad.a;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.d;
import com.kwad.sdk.h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.sdk.core.network.b {
    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
        putBody("protocolVersion", "2.0");
        putBody("SDKVersion", BuildConfig.VERSION_NAME);
        putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
        putBody("sdkApiVersion", ((f) ServiceProvider.get(f.class)).getApiVersion());
        putBody("sdkApiVersionCode", ((f) ServiceProvider.get(f.class)).getApiVersionCode());
        putBody("sdkType", 1);
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
        if (com.kwad.framework.a.a.oz.booleanValue()) {
            d.f(DevelopMangerComponents.class);
            addHeader("trace-context", "{\"laneId\":\"STAGING.online.u\"}");
        }
    }

    public b(String str, List<String> list) {
        putBody("adxId", str);
        putBody("materialIds", new JSONArray((Collection) list));
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.AO();
    }
}
