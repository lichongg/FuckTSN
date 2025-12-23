package com.kwad.components.ad.reward.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class AdLiveEndResultData extends BaseResultData {
    private static final long serialVersionUID = 1126369604146892297L;
    public AdLivePushEndInfo mQLivePushEndInfo = new AdLivePushEndInfo();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class AdLivePushEndInfo implements com.kwad.sdk.core.b, Serializable {
        public static final String KET_CONFIG_DISPLAY_LIKE_USER_COUNT = "displayLikeUserCount";
        public static final String KET_CONFIG_DISPLAY_WATCHING_USER_COUNT = "displayWatchingUserCount";
        public static final String KET_CONFIG_LIKE_USER_COUNT = "likeUserCount";
        public static final String KET_CONFIG_LIVE_DURATION = "liveDuration";
        public static final String KET_CONFIG_TOTAL_WATCHING_DURATION = "totalWatchingDuration";
        public static final String KET_CONFIG_WATCHING_USER_COUNT = "watchingUserCount";
        private static final long serialVersionUID = 7611577990274486211L;
        public int mLikeUserCount;
        public long mLiveDuration;
        public long mTotalWatchingDuration;
        public int mWatchingUserCount;
        public String mDisplayWatchingUserCount = "0";
        public String mDisplayLikeUserCount = "0";

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.mTotalWatchingDuration = jSONObject.optLong("totalWatchingDuration");
            this.mWatchingUserCount = jSONObject.optInt("watchingUserCount");
            this.mDisplayWatchingUserCount = jSONObject.optString("displayWatchingUserCount", "0");
            this.mLiveDuration = jSONObject.optLong("liveDuration");
            this.mLikeUserCount = jSONObject.optInt("likeUserCount");
            this.mDisplayLikeUserCount = jSONObject.optString("displayLikeUserCount", "0");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "totalWatchingDuration", this.mTotalWatchingDuration);
            aa.putValue(jSONObject, "watchingUserCount", this.mWatchingUserCount);
            aa.putValue(jSONObject, "displayWatchingUserCount", this.mDisplayWatchingUserCount);
            aa.putValue(jSONObject, "liveDuration", this.mLiveDuration);
            aa.putValue(jSONObject, "likeUserCount", this.mLikeUserCount);
            aa.putValue(jSONObject, "displayLikeUserCount", this.mDisplayLikeUserCount);
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        return this.mQLivePushEndInfo.toJson();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mQLivePushEndInfo.parseJson(jSONObject);
    }
}
