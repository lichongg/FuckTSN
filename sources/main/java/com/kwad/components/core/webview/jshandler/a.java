package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private b acc;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.a$a, reason: collision with other inner class name */
    public static class C0637a extends com.kwad.sdk.core.response.a.a {
        public String NN;
        public String acf;
        public String acg;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void c(C0637a c0637a);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class c extends com.kwad.sdk.core.response.a.a {
        public int ach;
        public long aci;
        public boolean acj;
        public int errorCode;
    }

    private void b(final C0637a c0637a) {
        bw.postOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (a.this.acc != null) {
                    a.this.acc.c(c0637a);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            C0637a c0637a = new C0637a();
            c0637a.parseJson(new JSONObject(str));
            b(c0637a);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "adOutCallback";
    }

    public a(b bVar) {
        this.acc = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
