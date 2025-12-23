package com.kwad.sdk.liteapi.report;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.liteapi.InputParamHolder;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.PackageManagerUtils;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class a {
    private String appId;
    private String name;
    private String packageName;
    private String version;

    public static a cg(Context context) {
        a aVar = new a();
        SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
        if (sDKConfig != null) {
            aVar.appId = sDKConfig.appId;
            aVar.name = sDKConfig.appName;
        }
        aVar.packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = PackageManagerUtils.getPackageInfo(StubApp.getOrigApplicationContext(context.getApplicationContext()), context.getPackageName(), 64);
            if (packageInfo == null) {
                return aVar;
            }
            aVar.version = packageInfo.versionName;
            return aVar;
        } catch (Exception e6) {
            LiteApiLogger.printStackTraceOnly(e6);
            return aVar;
        }
    }

    public final String getAppId() {
        return this.appId;
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("appId", this.appId);
            jSONObject.putOpt(CommonNetImpl.NAME, this.name);
            jSONObject.putOpt(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, this.packageName);
            jSONObject.putOpt("version", this.version);
            return jSONObject;
        } catch (JSONException e6) {
            LiteApiLogger.printStackTrace(e6);
            return jSONObject;
        }
    }

    a() {
    }
}
