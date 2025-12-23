package com.kwad.components.ad.reward.monitor;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class RewardMonitorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    public static final int DOWNLOAD_TYPE_ALL = 2;
    public static final int DOWNLOAD_TYPE_ONLINE = 1;
    public static final int DOWNLOAD_TYPE_PART = 3;
    public static final int LOAD_STATUS_DATA_FINISH = 2;
    public static final int LOAD_STATUS_FAIL = 4;
    public static final int LOAD_STATUS_LOAD_FINISH = 3;
    public static final int LOAD_STATUS_RESPONSE_DATA = 6;
    public static final int LOAD_STATUS_START = 1;
    public static final int LOAD_STATUS_START_CACHE = 7;
    public static final int LOAD_STATUS_START_REQUEST = 5;
    public static final int LOAD_TYPE_LOCAL = 2;
    public static final int LOAD_TYPE_NET = 1;
    public static final int PAGE_STATUS_AD_PV = 6;
    public static final int PAGE_STATUS_ENTRY = 1;
    public static final int PAGE_STATUS_FRAUD_VERIFY = 10;
    public static final int PAGE_STATUS_PAGE_RESUME = 5;
    public static final int PAGE_STATUS_PREVIEW_H5_ERROR = 9;
    public static final int PAGE_STATUS_PREVIEW_H5_START = 7;
    public static final int PAGE_STATUS_PREVIEW_H5_SUCCESS = 8;
    public static final int PAGE_STATUS_SHOW_AD_CALL = 3;
    public static final int PAGE_STATUS_SHOW_INTERCEPT = 4;
    public static final int PAGE_STATUS_START_PLAY = 2;
    public static final int PAGE_STATUS_SUB_PAGE_CREATE = 101;
    public static final int REWARD_TYPE_DEEP = 1;
    public static final int REWARD_TYPE_NORMAL = 0;
    public static final int SCENE_TYPE_IMAGE = 2;
    public static final int SCENE_TYPE_LIVE = 1;
    public static final int SCENE_TYPE_SCAN_AGGREGATION = 3;
    public static final int SCENE_TYPE_VIDEO = 0;
    public static final long serialVersionUID = 1080394611500009098L;
    public int adCount;
    public int adSceneType;
    public String callbackType;
    public long creativeId;
    public long currentDuration;
    public long dataDownloadInterval;
    public long dataLoadInterval;
    public long downloadDuration;
    public long downloadSize;
    public int downloadType;
    public int fraudVerifyCode;
    public int fraudVerifyType;
    public String interceptReason;
    public String launchFrom;
    public long loadDataDuration;
    public int loadStatus;
    public int loadType;
    public String materialRenderType;
    public int materialType;
    public int operationType;
    public int pageStatus;
    public long posId;
    public long renderDuration;
    public int rewardTaskType;
    public String subStage;
    public int tkRenderType;
    public long totalDuration;
    public long videoDuration;
    public String videoUrl;
    public int rewardType = -1;
    public int taskType = -1;
    public int taskStep = -1;
    public boolean enableRewardLayoutOptimise = com.kwad.components.ad.reward.a.b.hN();
    public boolean enableFullscreenLayoutOptimise = com.kwad.components.ad.reward.a.b.hO();

    public RewardMonitorInfo setAdCount(int i6) {
        this.adCount = i6;
        return this;
    }

    public RewardMonitorInfo setAdSceneType(int i6) {
        this.adSceneType = i6;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public RewardMonitorInfo setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return this;
        }
        RewardMonitorInfo rewardMonitorInfo = (RewardMonitorInfo) super.setAdTemplate(adTemplate);
        int ef = e.ef(adTemplate);
        AdInfo el = e.el(adTemplate);
        rewardMonitorInfo.setOperationType(com.kwad.sdk.core.response.b.a.aQ(el));
        rewardMonitorInfo.setMaterialRenderType(com.kwad.components.ad.reward.model.d.m(el));
        rewardMonitorInfo.setTKRenderType(com.kwad.sdk.core.response.b.b.a(ef == 2, el));
        return rewardMonitorInfo;
    }

    public RewardMonitorInfo setCallbackType(String str) {
        this.callbackType = str;
        return this;
    }

    public RewardMonitorInfo setCreativeId(long j6) {
        this.creativeId = j6;
        return this;
    }

    public RewardMonitorInfo setCurrentDuration(long j6) {
        this.currentDuration = j6;
        return this;
    }

    public RewardMonitorInfo setDataDownloadInterval(long j6) {
        this.dataDownloadInterval = j6;
        return this;
    }

    public RewardMonitorInfo setDataLoadInterval(long j6) {
        this.dataLoadInterval = j6;
        return this;
    }

    public RewardMonitorInfo setDownloadDuration(long j6) {
        this.downloadDuration = j6;
        return this;
    }

    public RewardMonitorInfo setDownloadSize(long j6) {
        this.downloadSize = j6;
        return this;
    }

    public RewardMonitorInfo setDownloadType(int i6) {
        this.downloadType = i6;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public RewardMonitorInfo setErrorCode(int i6) {
        super.setErrorCode(i6);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public RewardMonitorInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    public RewardMonitorInfo setFraudVerifyCode(int i6) {
        this.fraudVerifyCode = i6;
        return this;
    }

    public RewardMonitorInfo setFraudVerifyType(int i6) {
        this.fraudVerifyType = i6;
        return this;
    }

    public RewardMonitorInfo setInterceptReason(String str) {
        this.interceptReason = str;
        return this;
    }

    public RewardMonitorInfo setLaunchFrom(String str) {
        this.launchFrom = str;
        return this;
    }

    public RewardMonitorInfo setLoadDataDuration(long j6) {
        this.loadDataDuration = j6;
        return this;
    }

    public RewardMonitorInfo setLoadStatus(int i6) {
        this.loadStatus = i6;
        return this;
    }

    public RewardMonitorInfo setLoadType(int i6) {
        this.loadType = i6;
        return this;
    }

    public RewardMonitorInfo setMaterialRenderType(String str) {
        this.materialRenderType = str;
        return this;
    }

    public RewardMonitorInfo setMaterialType(int i6) {
        this.materialType = i6;
        return this;
    }

    public RewardMonitorInfo setOperationType(int i6) {
        this.operationType = i6;
        return this;
    }

    public RewardMonitorInfo setPageStatus(int i6) {
        this.pageStatus = i6;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public RewardMonitorInfo setPosId(long j6) {
        return (RewardMonitorInfo) super.setPosId(j6);
    }

    public RewardMonitorInfo setRenderDuration(long j6) {
        this.renderDuration = j6;
        return this;
    }

    public RewardMonitorInfo setRewardTaskType(int i6) {
        this.rewardTaskType = i6;
        return this;
    }

    public RewardMonitorInfo setRewardType(int i6) {
        this.rewardType = i6;
        return this;
    }

    public RewardMonitorInfo setSubStage(String str) {
        this.subStage = str;
        return this;
    }

    public RewardMonitorInfo setTKRenderType(int i6) {
        this.tkRenderType = i6;
        return this;
    }

    public RewardMonitorInfo setTaskStep(int i6) {
        this.taskStep = i6;
        return this;
    }

    public RewardMonitorInfo setTaskType(int i6) {
        this.taskType = i6;
        return this;
    }

    public RewardMonitorInfo setTotalDuration(long j6) {
        this.totalDuration = j6;
        return this;
    }

    public RewardMonitorInfo setVideoDuration(long j6) {
        this.videoDuration = j6;
        return this;
    }

    public RewardMonitorInfo setVideoUrl(String str) {
        this.videoUrl = str;
        return this;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        int i6 = this.rewardType;
        if (i6 != -1) {
            aa.putValue(jSONObject, "reward_type", i6);
        } else {
            jSONObject.remove("reward_type");
        }
        int i7 = this.taskType;
        if (i7 != -1) {
            aa.putValue(jSONObject, "task_type", i7);
        } else {
            jSONObject.remove("task_type");
        }
        int i8 = this.taskStep;
        if (i8 != -1) {
            aa.putValue(jSONObject, "task_step", i8);
        } else {
            jSONObject.remove("task_step");
        }
    }
}
