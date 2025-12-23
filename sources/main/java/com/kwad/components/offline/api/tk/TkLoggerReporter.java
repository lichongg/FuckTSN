package com.kwad.components.offline.api.tk;

import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.commercial.c;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class TkLoggerReporter {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.offline.api.tk.TkLoggerReporter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Holder {
        private static final TkLoggerReporter sInstance = new TkLoggerReporter(null);

        private Holder() {
        }
    }

    /* synthetic */ TkLoggerReporter(AnonymousClass1 anonymousClass1) {
        this();
    }

    private TkLoggerReporter() {
    }

    public static TkLoggerReporter get() {
        return Holder.sInstance;
    }

    private void reportEvent(String str, String str2, JSONObject jSONObject, c cVar) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(cVar);
    }

    public final void reportTKDownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.DS().cF(str).i(0.1d).O("ad_tk_download_performance", "download_state").h(jSONObject));
    }

    public final void reportTKPerform(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.DS().cF(str).i(0.1d).k(0.001d).O("ad_tk_render_performance", "render_state").h(jSONObject));
    }

    public final void reportTKSODownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.DS().cF(str).i(0.1d).O("ad_tk_so_download_event", "download_state").h(jSONObject));
    }

    public final void reportTKSOLoad(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.DS().cF(str).i(0.1d).O("ad_tk_so_load_performence", "download_state").h(jSONObject));
    }
}
