package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class f implements com.kwad.sdk.core.webview.c.a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean AC;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(final String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.k.f.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                boolean z5;
                try {
                    a aVar = new a();
                    aVar.parseJson(new JSONObject(str));
                    z5 = aVar.AC;
                } catch (Exception unused) {
                    z5 = false;
                }
                f.this.V(z5);
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "closeVideo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public void V(boolean z5) {
    }
}
