package com.kwad.sdk.mobileid.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bp;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class UaidTokenResponse extends BaseResultData implements Serializable {
    private static final long serialVersionUID = -8501365728042530876L;
    public String uaid;

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("data");
                e eVar = (e) d.f(e.class);
                if (!bp.isNullString(optString)) {
                    String responseData = eVar.getResponseData(optString);
                    if (!TextUtils.isEmpty(responseData)) {
                        this.uaid = new JSONObject(responseData).optString("uaid");
                    }
                }
            } catch (Exception e6) {
                c.printStackTraceOnly(e6);
            }
        }
    }
}
