package com.kwad.components.offline.api.tk.model.report;

import com.baidu.mobads.sdk.internal.d;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class TKPerformMsg extends BaseOfflineCompoJsonParse<TKPerformMsg> implements Serializable {
    public static final int ENTER_SCENE = -1;
    public static final int OTHER_FAIL = 3;
    public static final int PAGE_STATUS_FAIL = 2;
    public static final int START = 0;
    public static final int SUCCESS = 1;
    public static final int TK_NOT_READY = 4;
    private static final long serialVersionUID = -5293371882532982729L;
    public String errorDetail;
    public String errorReason;
    public long getViewEndTime;
    public long initTime;
    public long loadTime;
    public long registerEndTime;
    public long renderIdleTime;
    public int renderState;
    public long renderTime;

    @RENDER_TYPE
    public int renderType;
    public int source;
    public String templateId;
    private int tkPublishType;
    public String versionCode;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ERROR_REASON {
        public static final String KSAD_TK_CONFIG_LOST = "config_lost";
        public static final String KSAD_TK_CONFIG_PARSE_FAIL = "config_parse_fail";
        public static final String KSAD_TK_JS_EMPTY = "js_empty";
        public static final String KSAD_TK_MD5_NOT_MATCH = "md5_not_match";
        public static final String KSAD_TK_NO_FILE = "no_file";
        public static final String KSAD_TK_NO_TEMPLATE = "no_template";
        public static final String KSAD_TK_OFFLINE_FAILED = "offline_failed";
        public static final String KSAD_TK_RENDER_FAIL = "ksad_tk_render_fail";
        public static final String KSAD_TK_SO_FAIL = "so_fail";
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public @interface RENDER_TYPE {
        public static final int MULTIPLE_RENDER = 1;
        public static final int SINGLE_RENDER = 0;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TKPerformMsg tKPerformMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKPerformMsg.source = jSONObject.optInt(SocialConstants.PARAM_SOURCE);
        tKPerformMsg.renderState = jSONObject.optInt("render_state");
        tKPerformMsg.errorReason = jSONObject.optString("error_reason");
        Object opt = jSONObject.opt("error_reason");
        Object obj = JSONObject.NULL;
        if (opt == obj) {
            tKPerformMsg.errorReason = "";
        }
        tKPerformMsg.renderTime = jSONObject.optLong("render_time");
        tKPerformMsg.templateId = jSONObject.optString("template_id");
        if (jSONObject.opt("template_id") == obj) {
            tKPerformMsg.templateId = "";
        }
        tKPerformMsg.versionCode = jSONObject.optString("version_code");
        if (jSONObject.opt("version_code") == obj) {
            tKPerformMsg.versionCode = "";
        }
        tKPerformMsg.loadTime = jSONObject.optLong(d.f10986b);
        tKPerformMsg.initTime = jSONObject.optLong(d.f10985a);
        tKPerformMsg.tkPublishType = jSONObject.optInt("tk_publish_type");
        tKPerformMsg.renderType = jSONObject.optInt("render_type");
        tKPerformMsg.renderIdleTime = jSONObject.optLong("render_idle_time");
        tKPerformMsg.registerEndTime = jSONObject.optLong("register_end_time");
    }

    public TKPerformMsg setErrorDetail(String str) {
        this.errorDetail = str;
        return this;
    }

    public TKPerformMsg setErrorReason(String str) {
        this.errorReason = str;
        return this;
    }

    public TKPerformMsg setGetViewEndTime(long j6) {
        this.getViewEndTime = j6;
        return this;
    }

    public TKPerformMsg setInitTime(long j6) {
        this.initTime = j6;
        return this;
    }

    public TKPerformMsg setLoadTime(long j6) {
        this.loadTime = j6;
        return this;
    }

    public TKPerformMsg setRegisterEndTime(long j6) {
        this.registerEndTime = j6;
        return this;
    }

    public TKPerformMsg setRenderIdleTime(long j6) {
        this.renderIdleTime = j6;
        return this;
    }

    public TKPerformMsg setRenderState(int i6) {
        this.renderState = i6;
        return this;
    }

    public TKPerformMsg setRenderTime(long j6) {
        this.renderTime = j6;
        return this;
    }

    public TKPerformMsg setRenderType(int i6) {
        this.renderType = i6;
        return this;
    }

    public TKPerformMsg setSource(int i6) {
        this.source = i6;
        return this;
    }

    public TKPerformMsg setTKPublishType(int i6) {
        this.tkPublishType = i6;
        return this;
    }

    public TKPerformMsg setTemplateId(String str) {
        this.templateId = str;
        return this;
    }

    public TKPerformMsg setVersionCode(String str) {
        this.versionCode = str;
        return this;
    }

    public TKPerformMsg(int i6) {
        setSource(i6);
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKPerformMsg tKPerformMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JsonHelper.putValue(jSONObject, "render_state", tKPerformMsg.renderState);
        int i6 = tKPerformMsg.source;
        if (i6 != 0) {
            JsonHelper.putValue(jSONObject, SocialConstants.PARAM_SOURCE, i6);
        }
        String str = tKPerformMsg.errorReason;
        if (str != null && !str.equals("")) {
            JsonHelper.putValue(jSONObject, "error_reason", tKPerformMsg.errorReason);
        }
        String str2 = tKPerformMsg.errorDetail;
        if (str2 != null && !str2.equals("")) {
            JsonHelper.putValue(jSONObject, "error_detail", tKPerformMsg.errorDetail);
        }
        long j6 = tKPerformMsg.renderTime;
        if (j6 != 0) {
            JsonHelper.putValue(jSONObject, "render_time", j6);
        }
        String str3 = tKPerformMsg.templateId;
        if (str3 != null && !str3.equals("")) {
            JsonHelper.putValue(jSONObject, "template_id", tKPerformMsg.templateId);
        }
        String str4 = tKPerformMsg.versionCode;
        if (str4 != null && !str4.equals("")) {
            JsonHelper.putValue(jSONObject, "version_code", tKPerformMsg.versionCode);
        }
        long j7 = tKPerformMsg.loadTime;
        if (j7 != 0) {
            JsonHelper.putValue(jSONObject, d.f10986b, j7);
        }
        long j8 = tKPerformMsg.initTime;
        if (j8 != 0) {
            JsonHelper.putValue(jSONObject, d.f10985a, j8);
        }
        int i7 = tKPerformMsg.tkPublishType;
        if (i7 != 0) {
            JsonHelper.putValue(jSONObject, "tk_publish_type", i7);
        }
        int i8 = tKPerformMsg.renderType;
        if (i8 != 0) {
            JsonHelper.putValue(jSONObject, "render_type", i8);
        }
        long j9 = tKPerformMsg.renderIdleTime;
        if (j9 != 0) {
            JsonHelper.putValue(jSONObject, "render_idle_time", j9);
        }
        long j10 = tKPerformMsg.registerEndTime;
        if (j10 != 0) {
            JsonHelper.putValue(jSONObject, "register_end_time", j10);
        }
        long j11 = tKPerformMsg.getViewEndTime;
        if (j11 != 0) {
            JsonHelper.putValue(jSONObject, "get_view_end_time", j11);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKPerformMsg tKPerformMsg) {
        return toJson(tKPerformMsg, (JSONObject) null);
    }
}
