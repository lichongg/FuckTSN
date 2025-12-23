package com.kwad.sdk.j;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.z;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    /* renamed from: com.kwad.sdk.j.a$a, reason: collision with other inner class name */
    public static class C0702a extends com.kwad.sdk.commercial.c.a {
        public String aOu;
        public int aTs;
        public String sdkVersion;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class b extends com.kwad.sdk.commercial.c.a {
        public int aTt;
        public String aTu;
        public String aTv;
        public String aTw;
        public String aTx;
        public String aTy;
    }

    public static void NJ() {
        h.execute(new bg() { // from class: com.kwad.sdk.j.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.NK();
            }
        });
    }

    @Nullable
    private static C0702a a(ClassLoader classLoader, b bVar) {
        Class<?> a6 = z.a(bVar.aTu, classLoader);
        if (a6 == null) {
            return null;
        }
        C0702a c0702a = new C0702a();
        c0702a.aTs = z.classExists(bVar.aTv) ? 1 : 0;
        Object callStaticMethod = z.callStaticMethod(a6, bVar.aTw, new Object[0]);
        c0702a.sdkVersion = (String) z.callMethod(callStaticMethod, bVar.aTx, new Object[0]);
        c0702a.aOu = (String) z.callMethod(callStaticMethod, bVar.aTy, new Object[0]);
        return c0702a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void NK() {
        C0702a a6;
        JSONObject jSONObject = (JSONObject) e.Fw().getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.j.a.2
            private static JSONObject o(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return o(jSONObject2);
            }
        });
        if (jSONObject != null) {
            b bVar = new b();
            try {
                bVar.parseJson(jSONObject);
                if (bVar.aTt == 1 && (a6 = a(ServiceProvider.getContext().getClassLoader(), bVar)) != null) {
                    com.kwad.sdk.commercial.b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_tt_sdk_info", "sv").z(a6).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
