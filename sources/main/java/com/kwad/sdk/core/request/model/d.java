package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bd;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class d extends com.kwad.sdk.core.response.a.a {
    public String aIB;
    public String aIC;
    public int aID;
    public int operatorType;

    public static d IM() {
        d dVar = new d();
        try {
            Context Pp = ServiceProvider.Pp();
            dVar.aIB = bd.dq(Pp);
            dVar.aIC = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bo();
            dVar.aID = ao.df(Pp);
            dVar.operatorType = ao.d(Pp, bd.dt(Pp), bc.useNetworkStateDisable());
            return dVar;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return dVar;
        }
    }

    public static d IN() {
        d dVar = new d();
        dVar.aID = ao.df(ServiceProvider.getContext());
        return dVar;
    }
}
