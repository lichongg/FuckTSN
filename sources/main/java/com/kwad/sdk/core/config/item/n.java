package com.kwad.sdk.core.config.item;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class n extends r {
    private JSONObject aCp;

    public n(String str) {
        this(str, "{}");
    }

    public final int dA(String str) {
        JSONObject jSONObject;
        if (str != null && (jSONObject = this.aCp) != null) {
            try {
                return jSONObject.optInt(str);
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    private n(String str, String str2) {
        super(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.config.item.b
    public void setValue(String str) {
        super.setValue((n) str);
        try {
            this.aCp = new JSONObject(getValue());
        } catch (NullPointerException e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        } catch (JSONException e7) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e7);
        }
    }
}
