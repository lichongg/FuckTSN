package com.kwad.components.core.webview.tachikoma;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.offline.api.tk.model.BundleServiceConfig;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g {
    private final Map<String, a> aeS = new ConcurrentHashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        public i aeX;
        public boolean aeY;
        public List<b> aeZ = new ArrayList();

        public final void a(b bVar) {
            if (bVar != null) {
                this.aeZ.add(bVar);
            }
        }

        public final void aZ(final String str) {
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    Iterator<b> it = a.this.aeZ.iterator();
                    while (it.hasNext()) {
                        it.next().onFailed(str);
                    }
                    a.this.aeZ.clear();
                }
            });
        }

        public final void uQ() {
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.g.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    Iterator<b> it = a.this.aeZ.iterator();
                    while (it.hasNext()) {
                        it.next().onSuccess();
                    }
                    a.this.aeZ.clear();
                }
            });
        }

        a(i iVar) {
            this.aeX = iVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void onFailed(String str);

        void onSuccess();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c {
        private static final g afc = new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(Context context) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "begin load all services");
        SdkConfigData Fw = com.kwad.sdk.core.config.e.Fw();
        if (context == null || (optJSONObject = Fw.toJson().optJSONObject("appConfig")) == null || (optJSONArray = optJSONObject.optJSONArray("tkServiceConfigs")) == null) {
            return;
        }
        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
            BundleServiceConfig bundleServiceConfig = new BundleServiceConfig();
            bundleServiceConfig.parseJson(optJSONArray.optJSONObject(i6));
            if (bundleServiceConfig.loadType == 1) {
                b(context, bundleServiceConfig.bundleName, null);
            }
        }
    }

    private static boolean isLocalDebugEnable() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return false;
    }

    public final void a(Context context, String str, b bVar) {
        if (TextUtils.isEmpty(str)) {
            bVar.onFailed("invalid bundle string");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            StyleTemplate styleTemplate = new StyleTemplate();
            styleTemplate.parseJson(jSONObject);
            if (TextUtils.isEmpty(styleTemplate.templateId) || TextUtils.isEmpty(styleTemplate.templateUrl)) {
                bVar.onFailed("invalid bundle:" + str);
            }
            a(context, styleTemplate, bVar);
        } catch (Throwable th) {
            bVar.onFailed(th.getMessage());
        }
    }

    public final void init() {
        try {
            com.kwad.components.core.o.a.e.b bVar = (com.kwad.components.core.o.a.e.b) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.e.b.class);
            if (bVar != null) {
                bVar.a(new com.kwad.components.core.o.a.e.a() { // from class: com.kwad.components.core.webview.tachikoma.g.1
                    @Override // com.kwad.components.core.o.a.e.a
                    public final void a(int i6, int i7, long j6, long j7) {
                        g.this.aE(KsAdSDK.getContext());
                    }
                });
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void unloadBundle(String str) {
        if (this.aeS.get(str) != null) {
            com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "unload bundle" + str);
            a aVar = this.aeS.get(str);
            if (aVar != null) {
                aVar.aeX.kz();
            }
            this.aeS.remove(str);
        }
    }

    public static g uP() {
        return c.afc;
    }

    public final void b(Context context, String str, b bVar) {
        JSONArray optJSONArray;
        if (isLocalDebugEnable()) {
            unloadBundle(str);
        }
        com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle:" + str);
        if (TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle fail: invalid bundle name");
            if (bVar != null) {
                bVar.onFailed("invalid bundle name");
                return;
            }
            return;
        }
        SdkConfigData Fw = com.kwad.sdk.core.config.e.Fw();
        if (Fw == null) {
            com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle fail: config data empty");
            if (bVar != null) {
                bVar.onFailed("config data empty");
                return;
            }
            return;
        }
        if (context == null) {
            com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle fail: no context");
            if (bVar != null) {
                bVar.onFailed("no context");
                return;
            }
            return;
        }
        JSONObject optJSONObject = Fw.toJson().optJSONObject("styleTemplatesConfig");
        StyleTemplate styleTemplate = null;
        if (optJSONObject == null) {
            optJSONArray = null;
        } else {
            optJSONArray = optJSONObject.optJSONArray("styleTemplates");
        }
        if (optJSONArray != null) {
            int i6 = 0;
            while (true) {
                if (i6 >= optJSONArray.length()) {
                    break;
                }
                StyleTemplate styleTemplate2 = new StyleTemplate();
                styleTemplate2.parseJson(optJSONArray.optJSONObject(i6));
                String str2 = styleTemplate2.templateId;
                if (str2 != null && str2.equals(str)) {
                    styleTemplate = styleTemplate2;
                    break;
                }
                i6++;
            }
        }
        if (isLocalDebugEnable() && styleTemplate == null) {
            styleTemplate = new StyleTemplate();
            styleTemplate.templateId = str;
        }
        if (styleTemplate == null) {
            com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle fail: no bundle");
            if (bVar != null) {
                bVar.onFailed("no bundle");
                return;
            }
            return;
        }
        a(context, styleTemplate, bVar);
    }

    private void a(Context context, final StyleTemplate styleTemplate, b bVar) {
        final String str = styleTemplate.templateId;
        if (str == null) {
            if (bVar != null) {
                bVar.onFailed("no bundle");
                return;
            }
            return;
        }
        a aVar = this.aeS.get(str);
        if (aVar != null) {
            if (aVar.aeY) {
                com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle finish: already load");
                if (bVar != null) {
                    bVar.onSuccess();
                    return;
                }
                return;
            }
            aVar.a(bVar);
            return;
        }
        i iVar = new i(context, false);
        iVar.a("isService", Boolean.TRUE);
        final a aVar2 = new a(iVar);
        aVar2.a(bVar);
        iVar.a(styleTemplate);
        iVar.a((Activity) null, (AdResultData) null, new j() { // from class: com.kwad.components.core.webview.tachikoma.g.2
            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(a.C0637a c0637a) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getRegisterViewKey() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final FrameLayout getTKContainer() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final com.kwad.sdk.widget.g getTouchCoordsView() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(ae.a aVar3) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void az() {
                com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle success: done");
                a aVar3 = aVar2;
                aVar3.aeY = true;
                aVar3.uQ();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTKReaderScene() {
                return "tk_bundle_service";
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTkTemplateId() {
                return styleTemplate.templateId;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(az azVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(o oVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(p pVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(n nVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(u uVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(WebCloseStatus webCloseStatus) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(t tVar, com.kwad.sdk.core.webview.b bVar2) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar3) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(TKRenderFailReason tKRenderFailReason) {
                com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle fail: execute fail");
                aVar2.aZ("execute fail");
                g.this.unloadBundle(str);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void aA() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void aB() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void f(AdTemplate adTemplate) {
            }
        });
        this.aeS.put(str, aVar2);
    }
}
