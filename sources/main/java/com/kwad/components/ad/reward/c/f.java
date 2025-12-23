package com.kwad.components.ad.reward.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f implements com.kwad.sdk.core.webview.c.a {
    private d tc;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.tc = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            final b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.c.f.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (f.this.tc != null) {
                        f.this.tc.a(bVar);
                    }
                }
            });
        } catch (JSONException e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateExtraReward";
    }

    public f(d dVar) {
        this.tc = dVar;
    }
}
