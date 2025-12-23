package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.br;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ah implements com.kwad.sdk.core.webview.c.a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String LN;
        public int Qv;
        public int Qw;
        public String SDKVersion;
        public int SDKVersionCode;
        public String adg;
        public String adh;
        public int adi;
        public String adj;
        public int adk;
        public String adl;
        public String adm;
        public int adn;
        public int ado;
        public String appId;
        public String appName;
        public String appVersion;
        public String model;
        public String sdkApiVersion;
        public int sdkApiVersionCode;
        public int sdkType;

        public static a uC() {
            a aVar = new a();
            aVar.SDKVersion = BuildConfig.VERSION_NAME;
            aVar.SDKVersionCode = BuildConfig.VERSION_CODE;
            aVar.sdkApiVersion = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
            aVar.sdkApiVersionCode = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersionCode();
            aVar.sdkType = 1;
            Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
            aVar.appVersion = com.kwad.sdk.utils.m.cE(context);
            aVar.appName = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getAppName();
            aVar.appId = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getAppId();
            aVar.adg = String.valueOf(com.kwad.sdk.utils.ao.df(context));
            aVar.adh = br.Sd();
            aVar.model = br.RT();
            aVar.LN = br.RV();
            aVar.adi = 1;
            aVar.adj = br.getOsVersion();
            aVar.adk = br.Sg();
            aVar.adl = br.getLanguage();
            aVar.adm = br.getLocale();
            aVar.Qw = br.getScreenWidth(context);
            aVar.Qv = br.getScreenHeight(context);
            aVar.adn = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            aVar.ado = com.kwad.sdk.c.a.a.a(context, 50.0f);
            return aVar;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKsPlayableDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        cVar.a(a.uC());
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
