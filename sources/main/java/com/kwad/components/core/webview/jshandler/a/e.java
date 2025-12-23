package com.kwad.components.core.webview.jshandler.a;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bxkj.base.v2.common.utils.g0;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.local.LocalWriteResult;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.h;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private static SimpleDateFormat aeK = new SimpleDateFormat(g0.f16897b);
    private final WeakReference<Context> aeJ;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String aeM;
        private byte[] aeN;
        private String aeO;

        public final byte[] uN() {
            return this.aeN;
        }

        public final String uO() {
            return this.aeO;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            String[] split = this.aeM.split(";base64,");
            if (split.length >= 2) {
                String str = split[0];
                if (str.startsWith("data:")) {
                    this.aeO = str.substring(5);
                }
                this.aeN = com.kwad.sdk.core.a.c.Hi().decode(split[1]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.d.c.d("SaveImageHandler", "notifySuccess function callback: " + cVar);
        bw.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.e.2
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.webview.c.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "saveImage";
    }

    public e(Context context) {
        this.aeJ = new WeakReference<>(context);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(final String str, @NonNull final com.kwad.sdk.core.webview.c.c cVar) {
        final Context context = this.aeJ.get();
        if (context == null) {
            return;
        }
        h.execute(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.e.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a aVar = new a();
                    aVar.parseJson(new JSONObject(str));
                    com.kwad.sdk.core.d.c.d("SaveImageHandler", "saveImageData mime type: " + aVar.uO());
                    LocalWriteResult a6 = com.kwad.sdk.core.local.b.a(context, aVar.uO(), aVar.uN(), "ksad_image_" + e.aeK.format(new Date()));
                    if (LocalWriteResult.SUCCESS.equals(a6)) {
                        e.this.b(cVar);
                    } else if (LocalWriteResult.FAIL.equals(a6)) {
                        e.this.a(cVar, "write error", -1);
                    } else {
                        e.this.a(cVar, "permission denied", -2);
                    }
                } catch (Throwable th) {
                    e.this.a(cVar, "error_" + th.getMessage(), -3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.core.webview.c.c cVar, final String str, final int i6) {
        com.kwad.sdk.core.d.c.d("SaveImageHandler", "notifyError msg: " + str);
        bw.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.e.3
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.webview.c.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onError(i6, str);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
