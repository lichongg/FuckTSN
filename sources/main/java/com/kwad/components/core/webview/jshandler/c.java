package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c implements com.kwad.sdk.core.webview.c.a {

    @Nullable
    private com.kwad.sdk.core.webview.c.c ack;
    private com.kwad.components.core.proxy.launchdialog.b acl = uA();
    private final com.kwad.sdk.core.webview.b eQ;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements com.kwad.sdk.core.b {
        String NN;
        int status;

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, this.status);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", this.NN);
            return jSONObject;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
        com.kwad.components.core.proxy.launchdialog.e.sc().b(this.acl);
        this.acl = null;
    }

    private com.kwad.components.core.proxy.launchdialog.b uA() {
        return new com.kwad.components.core.proxy.launchdialog.b() { // from class: com.kwad.components.core.webview.jshandler.c.1
            @Override // com.kwad.components.core.proxy.launchdialog.b
            public final void b(long j6, int i6) {
                try {
                    String valueOf = String.valueOf(j6);
                    AdTemplate dk = c.this.eQ.dk(valueOf);
                    if (c.this.ack != null && dk != null) {
                        a aVar = new a();
                        aVar.status = i6;
                        aVar.NN = valueOf;
                        c.this.ack.a(aVar);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "dpInterceptPopupListener";
    }

    public c(com.kwad.sdk.core.webview.b bVar) {
        this.eQ = bVar;
        com.kwad.components.core.proxy.launchdialog.e.sc().a(this.acl);
    }
}
