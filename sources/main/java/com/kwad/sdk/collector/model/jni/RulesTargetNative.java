package com.kwad.sdk.collector.model.jni;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.aa;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class RulesTargetNative extends NativeObject implements d {
    private static final long serialVersionUID = -4726982809581153390L;

    public RulesTargetNative() {
        this.mPtr = AppStatusNative.nativeCreateRulesTarget();
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j6 = this.mPtr;
        if (j6 != 0) {
            AppStatusNative.nativeDeleteRulesTarget(j6);
            this.mPtr = 0L;
        }
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            AppStatusNative.rulesTargetSetPackageName(this, jSONObject.optString(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME));
            JSONArray optJSONArray = jSONObject.optJSONArray("paths");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                String[] strArr = new String[length];
                for (int i6 = 0; i6 < length; i6++) {
                    strArr[i6] = optJSONArray.getString(i6);
                }
                AppStatusNative.rulesTargetSetPaths(this, strArr);
            }
        } catch (Exception e6) {
            com.kwad.sdk.service.d.gatherException(e6);
            c.printStackTrace(e6);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, AppStatusNative.rulesTargetGetPackageName(this));
        aa.putValue(jSONObject, "paths", (List<?>) Arrays.asList(AppStatusNative.rulesTargetGetPaths(this)));
        return jSONObject;
    }

    public RulesTargetNative(long j6) {
        this.mPtr = j6;
    }
}
