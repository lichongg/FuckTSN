package com.kwad.sdk.core.webview.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e implements com.kwad.sdk.core.b {
    private final String aut;
    private final int result;

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "result", this.result);
        aa.putValue(jSONObject, "error_msg", this.aut);
        return jSONObject;
    }

    public e(int i6, String str) {
        this.result = i6;
        this.aut = str;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }
}
