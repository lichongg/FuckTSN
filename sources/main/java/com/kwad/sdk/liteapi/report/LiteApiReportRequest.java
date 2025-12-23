package com.kwad.sdk.liteapi.report;

import android.content.Context;
import androidx.annotation.Keep;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.loader.DexLoadError;
import com.kwad.sdk.liteapi.LiteApiLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class LiteApiReportRequest {
    private static final String TAG = "LiteApiReportRequest";
    public String SDKVersion;
    public int SDKVersionCode;
    public a appInfo;
    public b deviceInfo;
    public DexLoadError dexLoadInfo;
    public String sdkApiVersion;
    public int sdkApiVersionCode;
    public int sdkType;

    public static LiteApiReportRequest newInstance(Context context, String str, int i6) {
        LiteApiLogger.w(TAG, "newInstance start");
        LiteApiReportRequest liteApiReportRequest = new LiteApiReportRequest();
        liteApiReportRequest.sdkType = 1;
        liteApiReportRequest.SDKVersion = BuildConfig.VERSION_NAME;
        liteApiReportRequest.SDKVersionCode = BuildConfig.VERSION_CODE;
        liteApiReportRequest.sdkApiVersion = BuildConfig.VERSION_NAME;
        liteApiReportRequest.sdkApiVersionCode = BuildConfig.VERSION_CODE;
        liteApiReportRequest.dexLoadInfo = new DexLoadError(i6, str);
        liteApiReportRequest.deviceInfo = b.MV();
        liteApiReportRequest.appInfo = a.cg(context);
        LiteApiLogger.w(TAG, "newInstance start end reportRequest: " + liteApiReportRequest);
        return liteApiReportRequest;
    }

    public String getAppId() {
        a aVar = this.appInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.getAppId();
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("SDKVersion", this.SDKVersion);
            jSONObject.putOpt("SDKVersionCode", Integer.valueOf(this.SDKVersionCode));
            jSONObject.putOpt("sdkApiVersion", this.sdkApiVersion);
            jSONObject.putOpt("sdkApiVersionCode", Integer.valueOf(this.sdkApiVersionCode));
            jSONObject.putOpt("sdkType", Integer.valueOf(this.sdkType));
            jSONObject.putOpt("appInfo", this.appInfo.toJson());
            jSONObject.putOpt("dexLoadInfo", this.dexLoadInfo.toJson());
            jSONObject.putOpt("deviceInfo", this.deviceInfo.toJson());
            return jSONObject;
        } catch (JSONException e6) {
            LiteApiLogger.printStackTraceOnly(e6);
            return jSONObject;
        }
    }

    private LiteApiReportRequest() {
    }
}
