package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bs;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class b implements f {
    private final Map<String, String> mHeader = new HashMap();
    public final JSONObject mBodyParams = new JSONObject();

    protected abstract void buildBaseBody();

    protected abstract void buildBaseHeader();

    protected boolean enableCrashReport() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getBodyMap() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.f
    @Nullable
    public SceneImpl getScene() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.f
    public abstract String getUrl();

    public void putBody(String str, String str2) {
        aa.putValue(this.mBodyParams, str, str2);
    }

    public JSONObject getBodyParams() {
        return this.mBodyParams;
    }

    protected String getBodyParamsString() {
        return this.mBodyParams.toString();
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getHeader() {
        return this.mHeader;
    }

    public void putBody(String str, double d6) {
        aa.putValue(this.mBodyParams, str, d6);
    }

    protected b() {
        try {
            onCreate();
            buildBaseHeader();
            buildBaseBody();
            if (encryptDisable()) {
                addHeader("x-ksad-ignore-decrypt", "true");
            }
            addHeader("cookie", com.kwad.sdk.core.response.b.f.IS().IT());
            com.kwad.sdk.core.a.d.g(getHeader());
            addHeader("User-Agent", p.getUserAgent());
            addHeader("BrowserUa", p.HA());
            addHeader("SystemUa", p.Hz());
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
    }

    public void addHeader(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mHeader.put(str, str2);
        }
    }

    public boolean encryptDisable() {
        return com.kwad.sdk.components.g.encryptDisable();
    }

    @Override // com.kwad.sdk.core.network.f
    public JSONObject getBody() {
        if (encryptDisable()) {
            return this.mBodyParams;
        }
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        aa.putValue(jSONObject, "version", fVar.getSDKVersion());
        if (!TextUtils.isEmpty(bs.getAppId())) {
            aa.putValue(jSONObject, "appId", bs.getAppId());
        } else {
            aa.putValue(jSONObject, "appId", fVar.getAppId());
        }
        aa.putValue(jSONObject, CrashHianalyticsData.MESSAGE, com.kwad.sdk.core.a.d.as(getBodyParamsString()));
        com.kwad.sdk.core.a.d.a(getUrl(), getHeader(), jSONObject.toString());
        return jSONObject;
    }

    protected String getRequestHost() {
        return com.kwad.sdk.h.AK();
    }

    public void putBody(String str, int i6) {
        aa.putValue(this.mBodyParams, str, i6);
    }

    protected void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    public void putBody(String str, float f6) {
        aa.putValue(this.mBodyParams, str, f6);
    }

    public void putBody(String str, byte b6) {
        aa.putValue(this.mBodyParams, str, b6);
    }

    public void putBody(String str, long j6) {
        aa.putValue(this.mBodyParams, str, j6);
    }

    public void putBody(String str, boolean z5) {
        aa.putValue(this.mBodyParams, str, z5);
    }

    public void putBody(String str, JSONObject jSONObject) {
        aa.putValue(this.mBodyParams, str, jSONObject);
    }

    public void putBody(String str, JSONArray jSONArray) {
        aa.putValue(this.mBodyParams, str, jSONArray);
    }

    public void putBody(String str, com.kwad.sdk.core.b bVar) {
        aa.a(this.mBodyParams, str, bVar);
    }

    public void putBody(String str, List<? extends com.kwad.sdk.core.b> list) {
        aa.putValue(this.mBodyParams, str, list);
    }

    protected void onCreate() {
    }
}
