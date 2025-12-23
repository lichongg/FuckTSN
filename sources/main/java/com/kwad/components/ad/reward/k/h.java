package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h implements com.kwad.sdk.core.webview.c.a {
    private a AF;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void af(int i6);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.AF = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        int i6;
        if (this.AF != null) {
            try {
                i6 = new JSONObject(str).optInt("severCheckResult");
            } catch (JSONException e6) {
                e6.printStackTrace();
                i6 = 0;
            }
            this.AF.af(i6);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "hasReward";
    }

    public h(a aVar) {
        this.AF = aVar;
    }
}
