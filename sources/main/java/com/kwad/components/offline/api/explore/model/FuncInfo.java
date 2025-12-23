package com.kwad.components.offline.api.explore.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FuncInfo extends BaseOfflineCompoJsonParse<FuncInfo> implements Serializable {
    public static final int EXTRA_TYPE_HAS_CSJ = 1;
    public static final int EXTRA_TYPE_HAS_GROMORE = 2;
    public static final int REPORT_AD_EXPOSED = 1;
    public static final int REPORT_AD_NOT_EXPOSED = 0;
    public static final int REPORT_SCENE_DRAW = 6;
    public static final int REPORT_SCENE_FEED = 5;
    public static final int REPORT_SCENE_FULL = 2;
    public static final int REPORT_SCENE_INTERSTITIAL = 4;
    public static final int REPORT_SCENE_REWARD = 1;
    public static final int REPORT_SCENE_SPLASH = 3;
    public static final int VALUE_FROM_CPM = 1;
    public static final int VALUE_FROM_EXTRA = 2;
    public static final int VALUE_FROM_PRICE = 3;
    private static final long serialVersionUID = -6149616231567033421L;
    public long adId;
    public int adOperationType;
    public String adSource;
    public int adSubType;
    public String appName;
    public int biddingType;
    public int count;
    public String endCardUrl;
    public int exposed;
    public int extraFlagType;
    public int failedCount;
    public String imageUrl;
    public String landUrl;
    public long llsId;
    public String name;
    public String pkgName;
    public String relateId;
    public String reqId;
    public int scene;
    public int sdkType;
    public long timeCost;
    public long timestamp;
    public int type;
    public double value;
    public int valueFrom;
    public String videoUrl;

    public FuncInfo() {
        this.adSubType = 1;
        this.biddingType = -1;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(FuncInfo funcInfo, JSONObject jSONObject) {
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(FuncInfo funcInfo, JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    public FuncInfo(int i6, String str, int i7, int i8) {
        this.adSubType = 1;
        this.biddingType = -1;
        this.type = i6;
        this.name = str;
        this.scene = i7;
        this.sdkType = i8;
        this.timestamp = System.currentTimeMillis();
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(FuncInfo funcInfo) {
        return toJson(funcInfo, (JSONObject) null);
    }
}
