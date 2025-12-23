package com.kwad.sdk.core.request.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.m;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements com.kwad.sdk.core.b {
    private static JSONObject aHZ;
    private String aIa;
    private String appId;
    private String name;
    private String packageName;
    private String version;
    private int versionCode;

    private static boolean l(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString(CommonNetImpl.NAME);
        return !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString) && optString.equals(ServiceProvider.getSDKConfig().appId) && optString2.equals(ServiceProvider.getSDKConfig().appName);
    }

    public static JSONObject II() {
        if (!l(aHZ)) {
            aHZ = IJ().toJson();
        }
        return aHZ;
    }

    public static a IJ() {
        a aVar = new a();
        try {
            aVar.appId = ServiceProvider.getSDKConfig().appId;
            aVar.name = ServiceProvider.getSDKConfig().appName;
            aVar.packageName = ServiceProvider.Pp().getPackageName();
            aVar.version = m.cE(ServiceProvider.Pp());
            aVar.versionCode = m.cG(ServiceProvider.Pp());
            aVar.aIa = com.kwad.sdk.utils.f.cs(ServiceProvider.Pp());
            if (!TextUtils.isEmpty(bs.getAppId())) {
                aVar.appId = bs.getAppId();
            }
            if (!TextUtils.isEmpty(bs.getPackageName())) {
                aVar.packageName = bs.getPackageName();
            }
            return aVar;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return aVar;
        }
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "appId", this.appId);
        aa.putValue(jSONObject, CommonNetImpl.NAME, this.name);
        aa.putValue(jSONObject, MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, this.packageName);
        aa.putValue(jSONObject, "version", this.version);
        aa.putValue(jSONObject, "versionCode", this.versionCode);
        aa.putValue(jSONObject, "sha1", this.aIa);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }
}
