package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class az extends com.kwad.components.core.webview.tachikoma.b.w {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements com.kwad.sdk.core.b {
        private String aeh;

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lifeStatus", this.aeh);
            return jSONObject;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }
    }

    private void aY(String str) {
        a aVar = new a();
        aVar.aeh = str;
        b(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerLifecycleListener";
    }

    public final void uF() {
        aY("showStart");
    }

    public final void uG() {
        aY("showEnd");
    }

    public final void uH() {
        aY("hideStart");
    }

    public final void uI() {
        aY("hideEnd");
    }

    public final void uJ() {
        aY("pageVisiable");
    }

    public final void uK() {
        aY("pageInvisiable");
    }
}
