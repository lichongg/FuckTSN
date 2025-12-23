package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class al implements com.kwad.sdk.core.webview.c.a {
    private final WebView Ta;
    private Handler acR;

    @Nullable
    private com.kwad.sdk.core.webview.c.c acS;
    private boolean adz;

    @Nullable
    private b eU;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements com.kwad.sdk.core.b {
        public int bottomMargin;
        public int height;
        public int leftMargin;
        public int rightMargin;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.height = jSONObject.optInt("height");
            this.leftMargin = jSONObject.optInt("leftMargin");
            this.rightMargin = jSONObject.optInt("rightMargin");
            this.bottomMargin = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "height", this.height);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "leftMargin", this.leftMargin);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rightMargin", this.rightMargin);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bottomMargin", this.bottomMargin);
            return jSONObject;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        @MainThread
        void a(@NonNull a aVar);
    }

    public al(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2) {
        this(bVar, bVar2, true);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.acS = null;
        this.eU = null;
        this.acR.removeCallbacksAndMessages(null);
    }

    private al(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2, boolean z5) {
        this.adz = true;
        this.acR = new Handler(Looper.getMainLooper());
        this.Ta = bVar.Ta;
        this.eU = bVar2;
        this.adz = true;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.acS = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.parseJson(jSONObject);
            this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.al.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (al.this.Ta != null && al.this.adz) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) al.this.Ta.getLayoutParams();
                        marginLayoutParams.width = -1;
                        a aVar2 = aVar;
                        marginLayoutParams.height = aVar2.height;
                        marginLayoutParams.leftMargin = aVar2.leftMargin;
                        marginLayoutParams.rightMargin = aVar2.rightMargin;
                        marginLayoutParams.bottomMargin = aVar2.bottomMargin;
                        al.this.Ta.setLayoutParams(marginLayoutParams);
                    }
                    if (al.this.eU != null) {
                        al.this.eU.a(aVar);
                    }
                }
            });
            this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.al.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (al.this.acS != null) {
                        al.this.acS.a(null);
                    }
                }
            });
        } catch (JSONException e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            cVar.onError(-1, e6.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "initKsAdFrame";
    }
}
