package com.kwad.components.ad.splashscreen.monitor;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.Serializable;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class SplashMonitorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    public static final int ADD_PARENT_NULL = 207;
    public static final int ADD_ROOT_NULL = 206;
    public static final int CACHE_IMAGE = 1;
    public static final int CACHE_VIDEO = 2;
    public static final int CHECK_BACKUP_FAILED = 4;
    public static final int CHECK_BACKUP_SUCCESS = 3;
    public static final int CHECK_CACHE = 2;
    public static final int CHECK_INVALID_VIDEO = 5;
    public static final int CHECK_LIVE_NO_CACHE = 8;
    public static final int CHECK_TIME_OUT = 7;
    public static final int ERROR_DOWNLOAD = 4;
    public static final int ERROR_NET = 1;
    public static final String ERROR_NET_MSG = "networkError";
    public static final int ERROR_PRELOAD_ID_INVALID = 3;
    public static final String ERROR_PRELOAD_ID_INVALID_MSG = "preloadIdError";
    public static final int ERROR_URL_INVALID = 2;
    public static final String ERROR_URL_INVALID_MSG = "urlError";
    public static final long LOAD_PROCESS_TYPE_NEW = 1;
    public static final long LOAD_PROCESS_TYPE_OLD = 2;
    public static final int LOAD_STATUS_CHECK_FAILED = 5;
    public static final int LOAD_STATUS_CHECK_SUCCESS = 3;
    public static final int LOAD_STATUS_DATA_FINISH = 2;
    public static final int LOAD_STATUS_FAILED = 4;
    public static final int LOAD_STATUS_LOAD_DATA_PRE = 11;
    public static final int LOAD_STATUS_START = 1;
    public static final int LOAD_TYPE_CACHE = 2;
    public static final int LOAD_TYPE_ONLINE = 1;
    public static final int MATERIAL_IMAGE = 2;
    public static final int MATERIAL_LOAD_NO_TIMEOUT = 3002;
    public static final int MATERIAL_LOAD_START = 3001;
    public static final int MATERIAL_LOAD_TIMEOUT = 3003;
    public static final int MATERIAL_VIDEO = 1;
    public static final int PARENT_CONTAINER_VISIBLE = 200;
    public static final int PRE_LOAD_FAIL = 3;
    public static final int PRE_LOAD_START = 1;
    public static final int PRE_LOAD_SUCCESS = 2;
    public static final int REQUEST_TYPE_FIRST = 1;
    public static final int REQUEST_TYPE_SECOND = 2;
    public static final int SHOW_AD_CALL = 4;
    public static final int SHOW_CALL = 6;
    public static final int SHOW_CALL_ERROR = 7;
    public static final int SHOW_END_RECORD = 8;
    public static final int SHOW_FAIL = 3;
    public static final int SHOW_START = 1;
    public static final int SHOW_SUCCESS = 2;
    public static final int SHOW_TK_OFFLINE_READY = 5;
    public static final int SINGLE_CACHE_FAIL = 2;
    public static final int SINGLE_CACHE_SUCCESS = 1;
    public static final int SPLASH_FROM_FRAGMENT = 2;
    public static final int SPLASH_FROM_VIEW = 1;
    public static final String TEMPLATE_ID_EMPTY = "template_id_empty";
    public static final String TEMPLATE_RENER_TYPE_ERROR = "template_render_type_error";
    public static final int TK_ENTER = 101;
    public static final int TK_ENV_NOT_READY = 103;
    public static final int TK_LOAD_FAILED = 105;
    public static final int TK_LOAD_START = 102;
    public static final int TK_LOAD_SUCCESS = 104;
    public static final int TK_RENDER_FAILED = 2;
    public static final int TK_RENDER_TIMEOUT = 106;
    public static final int TOTAL_CACHE_REPORT = 2;
    public static final int TOTAL_CACHE_START = 1;
    public static final int TOTAL_CACHE_UPDATE = 3;
    public static final int TYPE_DOWNLOAD = 1;
    public static final int TYPE_UPDATE = 2;
    public static final int UPDATE_TYPE_REPORT = 2;
    public static final int UPDATE_TYPE_WRITE = 1;
    public static final int VIEW_DETACHED_TIME = 203;
    public static final int VIEW_INVISIBLE = 205;
    public static final int VIEW_VISIBLE_AND_IMPRESSION_CHECK_FAILED = 202;
    public static final int VIEW_VISIBLE_AND_IMPRESSION_SUCCESS = 201;
    public static final int VIEW_VISIBLE_AND_IMPRESSION_UNKNOWN_FAILED = 204;
    public static final int WITHOUT_TK_INFO = 1;
    private static final long serialVersionUID = 3528420046810658543L;
    public int actionType;
    public long addLoadTime;
    public long beforeLoadDataTime;
    public int buriedPointOptimizeType;
    public long cacheValidTime;
    public int callbackType;
    public long checkDataTime;
    public int checkStatus;
    public int clearCount;
    public int clearImageCount;
    public int clearVideoCount;
    public long costTime;
    public int count;
    public long creativeId;
    public List<String> creativeIds;
    public List<Integer> elementTypes;
    public boolean hasUnbind;
    public List<String> ids;
    public String interactiveStyle;
    public String interactivityDefaultStyle;
    public boolean isRotateComposeTimeout;
    public boolean isWebTimeout;
    public long loadAndCheckDataTime;
    public long loadDataTime;
    public long loadProcessType;
    public int loadType;
    public int materialType;
    public List<Integer> materialTypes;
    public long nativeLoadTime;
    public long offlineLoadTime;
    public int offlineSource;
    public boolean parentVisible;
    public long posId;
    public String preloadId;
    public List<String> preloadIds;
    public long requestLoadTime;
    public int requestType;
    public boolean rootVisible;
    public long showDurationMs;
    public long showEndTime;
    public int showType;
    public long size;
    public long soLoadTime;
    public int soSource;
    public int status;
    public String templateId;
    public int templateVersionCode;
    public long tkDefaultTimeout;
    public long tkFileLoadTime;
    public long tkInitTime;
    public long tkRenderTime;
    public long tkRenderType;
    public long tkTotalTime;
    public int totalCount;
    public int type;
    public int updateType;
    public String url;
    public int viewSource;
    public long visibleCheckDelayTime;
    public long webLoadTime;

    public SplashMonitorInfo setActionType(int i6) {
        this.actionType = i6;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public SplashMonitorInfo setAdTemplate(AdTemplate adTemplate) {
        return (SplashMonitorInfo) super.setAdTemplate(adTemplate);
    }

    public SplashMonitorInfo setAddLoadTime(long j6) {
        this.addLoadTime = j6;
        return this;
    }

    public SplashMonitorInfo setBeforeLoadDataTime(long j6) {
        this.beforeLoadDataTime = j6;
        return this;
    }

    public SplashMonitorInfo setBuriedPointOptimizeType(int i6) {
        this.buriedPointOptimizeType = i6;
        return this;
    }

    public SplashMonitorInfo setCacheValidTime(long j6) {
        this.cacheValidTime = j6;
        return this;
    }

    public SplashMonitorInfo setCallbackType(int i6) {
        this.callbackType = i6;
        return this;
    }

    public SplashMonitorInfo setCheckDataTime(long j6) {
        this.checkDataTime = j6;
        return this;
    }

    public SplashMonitorInfo setCheckStatus(int i6) {
        this.checkStatus = i6;
        return this;
    }

    public SplashMonitorInfo setClearCount(int i6) {
        this.clearCount = i6;
        return this;
    }

    public SplashMonitorInfo setClearImageCount(int i6) {
        this.clearImageCount = i6;
        return this;
    }

    public SplashMonitorInfo setClearVideoCount(int i6) {
        this.clearVideoCount = i6;
        return this;
    }

    public SplashMonitorInfo setCostTime(long j6) {
        this.costTime = j6;
        return this;
    }

    public SplashMonitorInfo setCount(int i6) {
        this.count = i6;
        return this;
    }

    public SplashMonitorInfo setCreativeId(long j6) {
        this.creativeId = j6;
        return this;
    }

    public SplashMonitorInfo setCreativeIds(List<String> list) {
        this.creativeIds = list;
        return this;
    }

    public SplashMonitorInfo setElementTypes(List<Integer> list) {
        this.elementTypes = list;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public SplashMonitorInfo setErrorCode(int i6) {
        super.setErrorCode(i6);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public SplashMonitorInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    public SplashMonitorInfo setHasUnbind(boolean z5) {
        this.hasUnbind = z5;
        return this;
    }

    public SplashMonitorInfo setIds(List<String> list) {
        this.ids = list;
        return this;
    }

    public SplashMonitorInfo setLoadAndCheckDataTime(long j6) {
        this.loadAndCheckDataTime = j6;
        return this;
    }

    public SplashMonitorInfo setLoadDataTime(long j6) {
        this.loadDataTime = j6;
        return this;
    }

    public SplashMonitorInfo setLoadProcessType(long j6) {
        this.loadProcessType = j6;
        return this;
    }

    public SplashMonitorInfo setLoadType(int i6) {
        this.loadType = i6;
        return this;
    }

    public SplashMonitorInfo setMaterialType(int i6) {
        this.materialType = i6;
        return this;
    }

    public SplashMonitorInfo setMaterialTypes(List<Integer> list) {
        this.materialTypes = list;
        return this;
    }

    public SplashMonitorInfo setNativeLoadTime(long j6) {
        this.nativeLoadTime = j6;
        return this;
    }

    public SplashMonitorInfo setOfflineLoadTime(long j6) {
        this.offlineLoadTime = j6;
        return this;
    }

    public SplashMonitorInfo setOfflineSource(int i6) {
        this.offlineSource = i6;
        return this;
    }

    public SplashMonitorInfo setParentVisible(boolean z5) {
        this.parentVisible = z5;
        return this;
    }

    public SplashMonitorInfo setPreloadId(String str) {
        this.preloadId = str;
        return this;
    }

    public SplashMonitorInfo setPreloadIds(List<String> list) {
        this.preloadIds = list;
        return this;
    }

    public SplashMonitorInfo setRequestLoadTime(long j6) {
        this.requestLoadTime = j6;
        return this;
    }

    public SplashMonitorInfo setRequestType(int i6) {
        this.requestType = i6;
        return this;
    }

    public SplashMonitorInfo setRootVisible(boolean z5) {
        this.rootVisible = z5;
        return this;
    }

    public SplashMonitorInfo setRotateComposeTimeout(boolean z5) {
        this.isRotateComposeTimeout = z5;
        return this;
    }

    public SplashMonitorInfo setShowDurationMs(long j6) {
        this.showDurationMs = j6;
        return this;
    }

    public SplashMonitorInfo setShowEndTime(long j6) {
        this.showEndTime = j6;
        return this;
    }

    public SplashMonitorInfo setShowType(int i6) {
        this.showType = i6;
        return this;
    }

    public SplashMonitorInfo setSize(long j6) {
        this.size = j6;
        return this;
    }

    public SplashMonitorInfo setSoLoadTime(long j6) {
        this.soLoadTime = j6;
        return this;
    }

    public SplashMonitorInfo setSoSource(int i6) {
        this.soSource = i6;
        return this;
    }

    public SplashMonitorInfo setStatus(int i6) {
        this.status = i6;
        return this;
    }

    public SplashMonitorInfo setTemplateId(String str) {
        this.templateId = str;
        return this;
    }

    public SplashMonitorInfo setTemplateVersionCode(int i6) {
        this.templateVersionCode = i6;
        return this;
    }

    public SplashMonitorInfo setTkDefaultTimeout(long j6) {
        this.tkDefaultTimeout = j6;
        return this;
    }

    public SplashMonitorInfo setTkFileLoadTime(long j6) {
        this.tkFileLoadTime = j6;
        return this;
    }

    public SplashMonitorInfo setTkInitTime(long j6) {
        this.tkInitTime = j6;
        return this;
    }

    public SplashMonitorInfo setTkRenderTime(long j6) {
        this.tkRenderTime = j6;
        return this;
    }

    public SplashMonitorInfo setTkRenderType(long j6) {
        this.tkRenderType = j6;
        return this;
    }

    public SplashMonitorInfo setTkTotalTime(long j6) {
        this.tkTotalTime = j6;
        return this;
    }

    public SplashMonitorInfo setTotalCount(int i6) {
        this.totalCount = i6;
        return this;
    }

    public SplashMonitorInfo setType(int i6) {
        this.type = i6;
        return this;
    }

    public SplashMonitorInfo setUpdateType(int i6) {
        this.updateType = i6;
        return this;
    }

    public SplashMonitorInfo setUrl(String str) {
        this.url = str;
        return this;
    }

    public SplashMonitorInfo setViewSource(int i6) {
        this.viewSource = i6;
        return this;
    }

    public SplashMonitorInfo setVisibleCheckDelayTime(long j6) {
        this.visibleCheckDelayTime = j6;
        return this;
    }

    public SplashMonitorInfo setWebLoadTime(long j6) {
        this.webLoadTime = j6;
        return this;
    }

    public SplashMonitorInfo setWebTimeout(boolean z5) {
        this.isWebTimeout = z5;
        return this;
    }

    public SplashMonitorInfo setInteractiveStyle(int i6) {
        this.interactiveStyle = String.valueOf(i6);
        return this;
    }

    public SplashMonitorInfo setInteractivityDefaultStyle(int i6) {
        this.interactivityDefaultStyle = String.valueOf(i6);
        return this;
    }
}
