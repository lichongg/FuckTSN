package com.umeng.socialize.net;

import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class LinkCardResponse extends SocializeReseponse {
    public String url;

    public LinkCardResponse(JSONObject jSONObject) {
        super(jSONObject);
    }

    public LinkCardResponse(Integer num, JSONObject jSONObject) {
        super(num, jSONObject);
    }

    @Override // com.umeng.socialize.net.base.SocializeReseponse
    public void parseJsonObject() {
        JSONObject jSONObject = this.mJsonData;
        if (jSONObject == null) {
            SLog.E(UmengText.NET.JSONNULL);
        } else {
            this.url = jSONObject.optString("linkcard_url");
        }
    }
}
