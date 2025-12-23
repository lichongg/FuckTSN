package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class aj implements com.kwad.sdk.core.webview.c.a {
    private final Handler acR = new Handler(Looper.getMainLooper());
    private final com.kwad.sdk.core.webview.b acw;
    private final AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int adr;
        public String ads;
        public String adt;

        @Deprecated
        public boolean adu;
        public boolean adv;
        public boolean adw;
        public String appId;
        public String appName;
        public String icon;
        public String md5;
        public String pkgName;
        public String sX;
        public int type;
        public String url;
        public String version;
        public int versionCode;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aG(2);
        } else {
            AdInfo el = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
            a(el, aVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aG(1);
        }
        this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.aj.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.components.core.e.d.a.a(new a.C0616a(aj.this.acw.TG.getContext()).aB(aj.this.mAdTemplate).b(aj.this.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.aj.1.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                    }
                }));
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "handleAdUrl";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.acR.removeCallbacksAndMessages(null);
    }

    public aj(com.kwad.sdk.core.webview.b bVar) {
        this.acw = bVar;
        AdTemplate adTemplate = new AdTemplate();
        this.mAdTemplate = adTemplate;
        try {
            AdTemplate adTemplate2 = bVar.getAdTemplate();
            if (adTemplate2 != null) {
                if (adTemplate2.mOriginJString != null) {
                    adTemplate.parseJson(new JSONObject(adTemplate2.mOriginJString));
                } else {
                    adTemplate.parseJson(adTemplate2.toJson());
                }
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    private static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.ads;
        adConversionInfo.marketUrl = aVar.adt;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = aVar.type;
        adBaseInfo.appPackageName = aVar.pkgName;
        adBaseInfo.appName = aVar.appName;
        adBaseInfo.appVersion = aVar.version;
        adBaseInfo.packageSize = aVar.adr;
        adBaseInfo.appIconUrl = aVar.icon;
        adBaseInfo.appDescription = aVar.sX;
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
            String str = aVar.url;
            adConversionInfo2.appDownloadUrl = str;
            adInfo.downloadId = com.kwad.sdk.utils.al.md5(str);
            return;
        }
        adInfo.adConversionInfo.h5Url = aVar.url;
    }
}
