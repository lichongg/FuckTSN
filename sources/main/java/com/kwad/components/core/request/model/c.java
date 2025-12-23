package com.kwad.components.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c implements com.kwad.sdk.core.b {
    public long XI;
    public long photoId;

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "photoId", this.photoId);
        aa.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, this.XI);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }
}
