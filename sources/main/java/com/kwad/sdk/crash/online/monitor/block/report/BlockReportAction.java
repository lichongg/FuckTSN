package com.kwad.sdk.crash.online.monitor.block.report;

import com.kwad.sdk.core.report.e;
import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class BlockReportAction extends e implements Serializable {
    private static final long serialVersionUID = 8432448382850235426L;
    public String msg;

    public BlockReportAction(String str) {
        this.actionId = UUID.randomUUID().toString();
        this.msg = str;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.actionId = jSONObject.optString("actionId");
        this.msg = jSONObject.optString("msg");
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "actionId", this.actionId);
        aa.putValue(jSONObject, "msg", this.msg);
        return jSONObject;
    }

    public BlockReportAction(JSONObject jSONObject) {
        parseJson(jSONObject);
    }
}
