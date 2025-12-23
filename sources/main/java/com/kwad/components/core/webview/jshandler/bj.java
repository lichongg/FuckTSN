package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class bj implements com.kwad.sdk.core.webview.c.a {
    private a aeG;
    private AdTemplate mAdTemplate;
    protected Context mContext;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        boolean eM();
    }

    public final void a(a aVar) {
        this.aeG = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.aeG;
        boolean eM = aVar != null ? aVar.eM() : true;
        com.kwad.sdk.core.d.c.d("WebShowPlayableHandler", "handleJsCall launch AdPlayableActivityProxy : " + eM);
        if (eM) {
            com.kwad.components.core.page.a.launch(this.mContext, this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showPlayable";
    }

    public bj(Context context, AdTemplate adTemplate) {
        this.mContext = com.kwad.sdk.o.m.wrapContextIfNeed(context);
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
