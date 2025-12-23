package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k extends w {
    b agA = new b() { // from class: com.kwad.components.core.webview.tachikoma.b.k.1
        @Override // com.kwad.components.core.webview.tachikoma.b.k.b
        public final void S(final long j6) {
            if (k.this.qn != null) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.b.k.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        a aVar = new a((byte) 0);
                        aVar.creativeId = j6;
                        k.this.qn.a(aVar);
                    }
                });
            }
        }
    };
    private com.kwad.sdk.core.webview.c.c qn;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements com.kwad.sdk.core.b {
        public long creativeId;

        private a() {
        }

        /* synthetic */ a(byte b6) {
            this();
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void S(long j6);
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.qn = cVar;
        com.kwad.components.core.e.d.a.a(this.agA);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAdConvertListener";
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.components.core.e.d.a.b(this.agA);
    }
}
