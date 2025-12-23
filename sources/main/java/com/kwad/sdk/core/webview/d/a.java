package com.kwad.sdk.core.webview.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.webview.c.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    /* renamed from: com.kwad.sdk.core.webview.d.a$a, reason: collision with other inner class name */
    public static final class C0694a extends com.kwad.sdk.core.response.a.a {
        public String LN;
        public int Qv;
        public int Qw;
        public String SDKVersion;
        public int SDKVersionCode;
        public String aCk;
        public String aCl;
        public String aHz;
        public String aIB;
        public String aIk;
        public String aIn;
        public String aIo;
        public String aNI;
        public String aNJ;
        public boolean aNK;
        public String aNL;
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

        public static C0694a KX() {
            C0694a c0694a = new C0694a();
            c0694a.SDKVersion = BuildConfig.VERSION_NAME;
            c0694a.SDKVersionCode = BuildConfig.VERSION_CODE;
            c0694a.aHz = "6.1.7";
            c0694a.aNL = "1.3";
            c0694a.sdkApiVersion = ((f) ServiceProvider.get(f.class)).getApiVersion();
            c0694a.sdkApiVersionCode = ((f) ServiceProvider.get(f.class)).getApiVersionCode();
            c0694a.sdkType = 1;
            Context context = ((f) ServiceProvider.get(f.class)).getContext();
            c0694a.appVersion = m.cE(context);
            c0694a.appName = ((f) ServiceProvider.get(f.class)).getAppName();
            c0694a.appId = ((f) ServiceProvider.get(f.class)).getAppId();
            c0694a.aNI = "";
            c0694a.aIo = ag.Qz();
            h hVar = (h) d.f(h.class);
            if (hVar != null) {
                c0694a.aIn = hVar.qd();
            }
            c0694a.adg = String.valueOf(ao.df(context));
            c0694a.adh = br.Sd();
            c0694a.model = br.RT();
            c0694a.LN = br.RV();
            c0694a.adi = 1;
            c0694a.adj = br.getOsVersion();
            c0694a.adk = br.Sg();
            c0694a.adl = br.getLanguage();
            c0694a.adm = br.getLocale();
            c0694a.aNK = ((f) ServiceProvider.get(f.class)).Bk();
            c0694a.aNJ = bd.getDeviceId();
            c0694a.Qw = br.getScreenWidth(context);
            c0694a.Qv = br.getScreenHeight(context);
            c0694a.aCk = bd.m125do(context);
            c0694a.aCl = bd.getOaid();
            c0694a.aIk = bd.dp(context);
            c0694a.aIB = bd.dq(context);
            c0694a.adn = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            c0694a.ado = com.kwad.sdk.c.a.a.a(context, 50.0f);
            return c0694a;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull c cVar) {
        cVar.a(C0694a.KX());
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
