package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ac implements com.kwad.sdk.core.webview.c.a {
    private boolean acJ;
    private Handler acR;
    private boolean acV;
    private boolean acW;
    private final com.kwad.sdk.core.webview.b acw;

    @Nullable
    private com.kwad.sdk.core.webview.d.a.a eT;

    @Nullable
    private final com.kwad.components.core.e.d.c mApkDownloadHelper;

    public ac(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z5, boolean z6, boolean z7) {
        this.acV = false;
        this.acW = false;
        this.acJ = z5;
        this.acR = new Handler(Looper.getMainLooper());
        this.acw = bVar;
        this.mApkDownloadHelper = cVar;
        this.acV = false;
        if (cVar != null) {
            cVar.aG(1);
        }
        this.eT = aVar;
        this.acW = z7;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.acw.KJ()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
            aVar.OU = true;
        } catch (JSONException e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
        if (this.acw.aMP) {
            this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.ac.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (ac.this.acw.aMQ || aVar.adL) {
                        ac.this.acw.getAdTemplate();
                        com.kwad.components.core.e.d.a.a(ac.this.acw.TG.getContext(), ac.this.acw.getAdTemplate(), new a.b() { // from class: com.kwad.components.core.webview.jshandler.ac.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                if (ac.this.eT != null) {
                                    ac.this.eT.a(aVar);
                                }
                            }
                        }, ac.this.mApkDownloadHelper, aVar.adL, ac.this.acJ, ac.this.acV, ac.this.acW);
                    }
                }
            });
        } else if (this.eT != null) {
            this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.ac.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (ac.this.eT != null) {
                        ac.this.eT.a(aVar);
                    }
                }
            });
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "convert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.acR.removeCallbacksAndMessages(null);
        this.eT = null;
    }

    public ac(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, cVar, aVar, false, false, false);
    }

    public ac(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, byte b6) {
        this(bVar, cVar, aVar, false, false, false);
    }
}
