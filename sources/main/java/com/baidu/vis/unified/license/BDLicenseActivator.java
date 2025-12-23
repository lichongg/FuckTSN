package com.baidu.vis.unified.license;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.vis.unified.license.AndroidLicenser;
import com.stub.StubApp;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BDLicenseActivator {
    public static final String TAG = "BDLicenseActivator";

    public static int initLicenseOnLine(Context context, String str, String str2, int i6) {
        String str3;
        String[] split;
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        String str4 = TextUtils.isEmpty(str2) ? str : str2;
        AndroidLicenser androidLicenser = AndroidLicenser.getInstance();
        if (androidLicenser.authFromFile(context, str, str4, true, i6) == AndroidLicenser.ErrorCode.SUCCESS) {
            return 0;
        }
        String deviceId = AndroidLicenser.getDeviceId(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("deviceId", deviceId);
            jSONObject.put("key", str);
            jSONObject.put("platformType", 2);
            jSONObject.put("version", 1);
            str3 = jSONObject.toString();
        } catch (JSONException e6) {
            e6.printStackTrace();
            str3 = null;
        }
        HttpStatus requestPost = HttpUtils.requestPost("https://ai.baidu.com/activation/key/activate", str3, "application/json", TAG);
        if (requestPost == null) {
            return -2;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(requestPost.responseStr);
            if (jSONObject2.optInt("error_code") != 0) {
                jSONObject2.optString("error_msg");
                return -3;
            }
            JSONObject optJSONObject = jSONObject2.optJSONObject("result");
            if (optJSONObject == null) {
                return -3;
            }
            String optString = optJSONObject.optString("license");
            if (!TextUtils.isEmpty(optString) && (split = optString.split(",")) != null && split.length == 2) {
                if (androidLicenser.authFromMemory(context, str, split, str4, i6) == AndroidLicenser.ErrorCode.SUCCESS) {
                    return 0;
                }
                androidLicenser.authGetLocalInfo(context, i6).toString();
                androidLicenser.getErrorMsg(i6);
                return -4;
            }
            return -3;
        } catch (JSONException e7) {
            e7.printStackTrace();
            return -5;
        }
    }
}
