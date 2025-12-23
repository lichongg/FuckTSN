package com.kwad.components.core.webview.jshandler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class q implements com.kwad.sdk.core.webview.c.a {
    private BroadcastReceiver acx;
    private com.kwad.sdk.core.webview.c.c qn;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String message;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.qn = cVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ksad_webView_local_broadcast");
        try {
            if (this.acx != null) {
                com.kwad.sdk.utils.ad.cO(ServiceProvider.getContext()).unregisterReceiver(this.acx);
                this.acx = null;
            }
            this.acx = new BroadcastReceiver() { // from class: com.kwad.components.core.webview.jshandler.q.1
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context, Intent intent) {
                    String stringExtra = intent.getStringExtra("data");
                    if (TextUtils.isEmpty(stringExtra)) {
                        return;
                    }
                    a aVar = new a();
                    aVar.message = stringExtra;
                    q.this.qn.a(aVar);
                }
            };
            com.kwad.sdk.utils.ad.cO(ServiceProvider.getContext()).a(this.acx, intentFilter);
        } catch (Throwable th) {
            com.kwad.sdk.crash.b.n(th);
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "onMessage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        try {
            if (this.acx != null) {
                com.kwad.sdk.utils.ad.cO(ServiceProvider.getContext()).unregisterReceiver(this.acx);
                this.acx = null;
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.b.n(th);
        }
    }
}
