package com.kwad.components.offline.api.core.adlive.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.LiveStringUtil;
import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class LiveMessage extends BaseOfflineCompoJsonParse<LiveMessage> implements Serializable {
    private static final long serialVersionUID = 2264410572624564928L;
    public String content;
    public long mSortRank;
    public String userName;

    public boolean isInValid() {
        return LiveStringUtil.isNullString(this.userName) || LiveStringUtil.isNullString(this.content);
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(LiveMessage liveMessage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        liveMessage.userName = jSONObject.optString("userName");
        Object opt = jSONObject.opt("userName");
        Object obj = JSONObject.NULL;
        if (opt == obj) {
            liveMessage.userName = "";
        }
        liveMessage.content = jSONObject.optString("content");
        if (jSONObject.opt("content") == obj) {
            liveMessage.content = "";
        }
        liveMessage.mSortRank = jSONObject.optInt("sortRank");
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(LiveMessage liveMessage, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = liveMessage.userName;
        if (str != null && !str.equals("")) {
            aa.putValue(jSONObject, "userName", liveMessage.userName);
        }
        String str2 = liveMessage.content;
        if (str2 != null && !str2.equals("")) {
            aa.putValue(jSONObject, "content", liveMessage.content);
        }
        long j6 = liveMessage.mSortRank;
        if (j6 != 0) {
            aa.putValue(jSONObject, "sortRank", j6);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(LiveMessage liveMessage) {
        return toJson(liveMessage, (JSONObject) null);
    }
}
