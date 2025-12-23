package com.kwad.components.offline.api.tk.model.report;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class TKDownloadMsg extends BaseOfflineCompoJsonParse<TKDownloadMsg> implements Serializable {
    public static final int ENV_SUCCESS = 3;
    public static final int FAIL = 2;
    private static final int INVALID_DOWNLOAD_STATE = -1;
    public static final int START = 0;
    public static final int SUCCESS = 1;
    private static final long serialVersionUID = -8872909341685100922L;
    public long availableTime;
    public int downloadState = -1;
    public long downloadTime;
    public String errorDetail;
    public String errorReason;
    public int loadingTimes;
    public long offlineLoadTime;
    public int offlineSource;
    public int preload;
    public int retryCount;
    public long soLoadTime;
    public int soSource;
    public String templateId;
    public int threadPoolCoreSize;
    public String versionCode;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TKDownloadMsg tKDownloadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKDownloadMsg.downloadState = jSONObject.optInt("download_state");
        tKDownloadMsg.downloadTime = jSONObject.optLong("download_time");
        tKDownloadMsg.preload = jSONObject.optInt("preload");
        tKDownloadMsg.errorReason = jSONObject.optString("error_reason");
        Object opt = jSONObject.opt("error_reason");
        Object obj = JSONObject.NULL;
        if (opt == obj) {
            tKDownloadMsg.errorReason = "";
        }
        tKDownloadMsg.templateId = jSONObject.optString("template_id");
        if (jSONObject.opt("template_id") == obj) {
            tKDownloadMsg.templateId = "";
        }
        tKDownloadMsg.versionCode = jSONObject.optString("version_code");
        if (jSONObject.opt("version_code") == obj) {
            tKDownloadMsg.versionCode = "";
        }
        tKDownloadMsg.retryCount = jSONObject.optInt("retry_count");
        tKDownloadMsg.loadingTimes = jSONObject.optInt("loading_times");
        tKDownloadMsg.offlineSource = jSONObject.optInt("offline_source");
        tKDownloadMsg.soSource = jSONObject.optInt("so_source");
        tKDownloadMsg.offlineLoadTime = jSONObject.optLong("offline_load_time");
        tKDownloadMsg.soLoadTime = jSONObject.optLong("so_load_time");
        tKDownloadMsg.errorDetail = jSONObject.optString("error_detail");
        if (jSONObject.opt("error_detail") == obj) {
            tKDownloadMsg.errorDetail = "";
        }
        tKDownloadMsg.threadPoolCoreSize = jSONObject.optInt("thread_pool_core_size");
        tKDownloadMsg.availableTime = jSONObject.optLong("available_time");
    }

    public TKDownloadMsg setDownloadState(int i6) {
        this.downloadState = i6;
        return this;
    }

    public TKDownloadMsg setDownloadTime(long j6) {
        this.downloadTime = j6;
        return this;
    }

    public TKDownloadMsg setErrorDetail(String str) {
        this.errorDetail = str;
        return this;
    }

    public TKDownloadMsg setErrorReason(String str) {
        this.errorReason = str;
        return this;
    }

    public TKDownloadMsg setInitSdkTimeConsuming(long j6) {
        this.availableTime = j6;
        return this;
    }

    public TKDownloadMsg setLoadingTimes(int i6) {
        this.loadingTimes = i6;
        return this;
    }

    public TKDownloadMsg setOfflineLoadTime(long j6) {
        this.offlineLoadTime = j6;
        return this;
    }

    public TKDownloadMsg setOfflineSource(int i6) {
        this.offlineSource = i6;
        return this;
    }

    public TKDownloadMsg setPreload(int i6) {
        this.preload = i6;
        return this;
    }

    public TKDownloadMsg setRetryCount(int i6) {
        this.retryCount = i6;
        return this;
    }

    public TKDownloadMsg setSoLoadTime(long j6) {
        this.soLoadTime = j6;
        return this;
    }

    public TKDownloadMsg setSoSource(int i6) {
        this.soSource = i6;
        return this;
    }

    public TKDownloadMsg setTemplateId(String str) {
        this.templateId = str;
        return this;
    }

    public TKDownloadMsg setThreadPoolCoreSize(int i6) {
        this.threadPoolCoreSize = i6;
        return this;
    }

    public TKDownloadMsg setVersionCode(String str) {
        this.versionCode = str;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKDownloadMsg tKDownloadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JsonHelper.putValue(jSONObject, "download_state", tKDownloadMsg.downloadState);
        JsonHelper.putValue(jSONObject, "thread_pool_core_size", tKDownloadMsg.threadPoolCoreSize);
        JsonHelper.putValue(jSONObject, "available_time", tKDownloadMsg.availableTime);
        long j6 = tKDownloadMsg.downloadTime;
        if (j6 != 0) {
            JsonHelper.putValue(jSONObject, "download_time", j6);
        }
        int i6 = tKDownloadMsg.preload;
        if (i6 != 0) {
            JsonHelper.putValue(jSONObject, "preload", i6);
        }
        String str = tKDownloadMsg.errorReason;
        if (str != null && !str.equals("")) {
            JsonHelper.putValue(jSONObject, "error_reason", tKDownloadMsg.errorReason);
        }
        String str2 = tKDownloadMsg.templateId;
        if (str2 != null && !str2.equals("")) {
            JsonHelper.putValue(jSONObject, "template_id", tKDownloadMsg.templateId);
        }
        String str3 = tKDownloadMsg.versionCode;
        if (str3 != null && !str3.equals("")) {
            JsonHelper.putValue(jSONObject, "version_code", tKDownloadMsg.versionCode);
        }
        int i7 = tKDownloadMsg.retryCount;
        if (i7 != 0) {
            JsonHelper.putValue(jSONObject, "retry_count", i7);
        }
        int i8 = tKDownloadMsg.loadingTimes;
        if (i8 != 0) {
            JsonHelper.putValue(jSONObject, "loading_times", i8);
        }
        int i9 = tKDownloadMsg.offlineSource;
        if (i9 != 0) {
            JsonHelper.putValue(jSONObject, "offline_source", i9);
        }
        int i10 = tKDownloadMsg.soSource;
        if (i10 != 0) {
            JsonHelper.putValue(jSONObject, "so_source", i10);
        }
        long j7 = tKDownloadMsg.offlineLoadTime;
        if (j7 != 0) {
            JsonHelper.putValue(jSONObject, "offline_load_time", j7);
        }
        long j8 = tKDownloadMsg.soLoadTime;
        if (j8 != 0) {
            JsonHelper.putValue(jSONObject, "so_load_time", j8);
        }
        String str4 = tKDownloadMsg.errorDetail;
        if (str4 != null && !str4.equals("")) {
            JsonHelper.putValue(jSONObject, "error_detail", tKDownloadMsg.errorDetail);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKDownloadMsg tKDownloadMsg) {
        return toJson(tKDownloadMsg, (JSONObject) null);
    }
}
