package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class au implements com.kwad.sdk.core.webview.c.a {

    @Nullable
    private KsAppDownloadListener abU;

    @Nullable
    private com.kwad.sdk.core.webview.c.c ack;
    private final com.kwad.sdk.core.webview.b eQ;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public double adT;
        public double adU;
        public long soFarBytes;
        public int status;
        public long totalBytes;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public long aeb;
        public String appName;
        public String icon;
        public String md5;
        public String pkgName;
        public String sX;
        public String url;
        public String version;
        public int versionCode;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.ack = null;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.abU) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
        this.abU = null;
    }

    private KsAppDownloadListener uz() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.au.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                au.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                au.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                au.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                au.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i6) {
                au.this.a(3, (i6 * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i6) {
                au.this.a(2, (i6 * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(adTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aG(2);
        } else {
            AdInfo el = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
            a(el, bVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aG(1);
        }
        this.ack = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.abU;
        if (ksAppDownloadListener != null) {
            this.mApkDownloadHelper.d(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener uz = uz();
        this.abU = uz;
        this.mApkDownloadHelper.b(uz);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerApkStatusListener";
    }

    public au(com.kwad.sdk.core.webview.b bVar) {
        this.eQ = bVar;
        try {
            this.mAdTemplate = new AdTemplate();
            AdTemplate adTemplate = bVar.getAdTemplate();
            if (adTemplate != null) {
                if (adTemplate.mOriginJString != null) {
                    this.mAdTemplate.parseJson(new JSONObject(adTemplate.mOriginJString));
                } else {
                    this.mAdTemplate.parseJson(adTemplate.toJson());
                }
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    private static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = bVar.pkgName;
        adBaseInfo.appName = bVar.appName;
        adBaseInfo.appVersion = bVar.version;
        adBaseInfo.packageSize = bVar.aeb;
        adBaseInfo.appIconUrl = bVar.icon;
        adBaseInfo.appDescription = bVar.sX;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = bVar.url;
        adConversionInfo.appDownloadUrl = str;
        adInfo.downloadId = com.kwad.sdk.utils.al.md5(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6, float f6) {
        if (this.ack != null) {
            a aVar = new a();
            aVar.adT = f6;
            aVar.status = i6;
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                aVar.totalBytes = com.kwad.sdk.core.response.b.e.el(adTemplate).totalBytes;
                long j6 = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate).soFarBytes;
                aVar.soFarBytes = j6;
                long j7 = aVar.totalBytes;
                if (j7 > 0) {
                    aVar.adU = (j6 * 1.0d) / j7;
                } else {
                    aVar.adU = 0.0d;
                }
            }
            this.ack.a(aVar);
        }
    }
}
