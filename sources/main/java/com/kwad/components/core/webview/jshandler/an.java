package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class an implements com.kwad.sdk.core.webview.c.a {
    private final Handler acR;
    private final com.kwad.sdk.core.webview.b acw;

    @Nullable
    private final b adF;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public boolean adL;
        public String adM;
        public int adN;
        public com.kwad.sdk.core.webview.d.b.d adO;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        final com.kwad.components.core.e.d.c cVar2;
        final a aVar = new a();
        final AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.adM));
        } catch (JSONException e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
        if (com.kwad.sdk.core.response.b.e.ed(adTemplate)) {
            if (this.acw.aMO != null) {
                cVar2 = (com.kwad.components.core.e.d.c) this.acw.aMO.gZ(com.kwad.sdk.core.response.b.e.el(adTemplate).downloadId);
            } else {
                cVar2 = null;
            }
            if (this.acw.aMP) {
                this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.an.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.components.core.e.d.a.a(new a.C0616a(an.this.acw.TG.getContext()).aB(adTemplate).b(cVar2).aB(aVar.adN).aq(true).am(aVar.adO.Pj).as(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.an.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                            }
                        }));
                    }
                });
            } else if (this.adF != null) {
                this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.an.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                    }
                });
            }
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.acR.removeCallbacksAndMessages(null);
    }
}
