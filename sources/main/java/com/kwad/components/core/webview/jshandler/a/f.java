package com.kwad.components.core.webview.jshandler.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.o;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f implements com.kwad.sdk.core.webview.c.a {
    private final WeakReference<Context> aeJ;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String text;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            Context context = this.aeJ.get() != null ? this.aeJ.get() : null;
            if (context != null) {
                a aVar = new a();
                aVar.parseJson(new JSONObject(str));
                if (o.a(context, "ksad_landing_page", aVar.text)) {
                    cVar.a(null);
                } else {
                    cVar.onError(-1, "写入错误");
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "setClipBoard";
    }

    public f(Context context) {
        this.aeJ = new WeakReference<>(context);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
