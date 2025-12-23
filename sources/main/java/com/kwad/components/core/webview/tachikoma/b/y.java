package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class y implements com.kwad.sdk.core.webview.c.a {
    private a agQ;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            com.kwad.sdk.core.d.c.d("UpdateLiveCurrentShopInfoHandler", "handleJsCall: " + str);
            final TKAdLiveShopItemInfo tKAdLiveShopItemInfo = new TKAdLiveShopItemInfo();
            tKAdLiveShopItemInfo.parseJson(new JSONObject(str));
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.b.y.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (y.this.agQ != null) {
                        y.this.agQ.a(tKAdLiveShopItemInfo);
                    }
                }
            });
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateLiveCurrentShopInfo";
    }

    public y(a aVar) {
        this.agQ = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
