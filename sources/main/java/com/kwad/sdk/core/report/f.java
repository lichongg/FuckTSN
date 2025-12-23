package com.kwad.sdk.core.report;

import android.text.TextUtils;
import com.kwad.sdk.utils.aa;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f extends com.kwad.sdk.core.network.d {
    protected String aGv;

    public f(List<n> list) {
        this.aGv = "";
        if (list == null || list.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<n> it = list.iterator();
        while (it.hasNext()) {
            aa.a(jSONArray, it.next().buildReportData());
        }
        putBody("actionList", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.d
    public final boolean enablePrivateInfoObtain() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        if (encryptDisable() && !TextUtils.isEmpty(this.aGv)) {
            putBody("actionListString", this.aGv);
        }
        return super.getBody();
    }

    @Override // com.kwad.sdk.core.network.b
    public final String getBodyParamsString() {
        String bodyParamsString = super.getBodyParamsString();
        try {
            if (TextUtils.isEmpty(this.aGv)) {
                return bodyParamsString;
            }
            StringBuilder sb = new StringBuilder(bodyParamsString);
            sb.insert(sb.length() - 1, this.aGv);
            return sb.toString();
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            return bodyParamsString;
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.AP();
    }

    public f(String str) {
        this.aGv = str;
    }
}
