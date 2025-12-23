package com.baidu.idl.main.facesdk.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.vis.unified.license.AndroidLicenser;
import com.baidu.vis.unified.license.HttpStatus;
import com.baidu.vis.unified.license.HttpUtils;
import com.stub.StubApp;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PostDeviceInfo {
    public static void uploadDeviceInfo(final Context context, final Callback callback) {
        new Thread(new Runnable() { // from class: com.baidu.idl.main.facesdk.statistic.PostDeviceInfo.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                String deviceId = AndroidLicenser.getDeviceId(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                String systemVersion = DeviceInfoUtil.getSystemVersion();
                float ramInfo = (DeviceInfoUtil.getRamInfo(context) / 1024) / 1024;
                float deviceBasicFrequency = DeviceInfoUtil.getDeviceBasicFrequency() / 1000;
                int numberOfCPUCores = DeviceInfoUtil.getNumberOfCPUCores();
                int intValue = DeviceInfoUtil.getCPUBit().intValue();
                Integer networkState = NetWorkUtil.getNetworkState(context);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("analysisType", "offline_Sdk");
                    jSONObject.put("deviceId", deviceId);
                    jSONObject.put("cpuCore", numberOfCPUCores);
                    jSONObject.put("cpuBit", intValue);
                    jSONObject.put("ghz", Math.round(deviceBasicFrequency));
                    jSONObject.put("ram", Math.round(ramInfo));
                    jSONObject.put("networkType", networkState);
                    jSONObject.put("networkDesc", networkState.intValue() == 1 ? "WIFI网络" : networkState.intValue() == 2 ? "2G网络" : networkState.intValue() == 3 ? "3G网络" : networkState.intValue() == 4 ? "4G网络" : networkState.intValue() == 5 ? "有线网卡" : "其他网络模块");
                    jSONObject.put("os", 1);
                    jSONObject.put("osVersion", systemVersion);
                    jSONObject.put("sdk", 1);
                    jSONObject.put("sdkVersion", "4.1");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("mh", "offlineSdkStatistic");
                    jSONObject2.put(SocializeProtocolConstants.PROTOCOL_KEY_DT, jSONObject);
                    str = jSONObject2.toString();
                } catch (JSONException e6) {
                    e6.getStackTrace();
                    str = null;
                }
                HttpStatus requestPost = HttpUtils.requestPost("http://brain.baidu.com/record/api", str, "application/json", "zxq");
                if (requestPost == null) {
                    callback.onResponse(-1, "请求失败");
                    return;
                }
                String str2 = requestPost.responseStr;
                try {
                    if (TextUtils.isEmpty(str2)) {
                        callback.onResponse(-1, "request error");
                    } else {
                        JSONObject jSONObject3 = new JSONObject(str2);
                        callback.onResponse(jSONObject3.optInt("code"), jSONObject3.optString("msg"));
                    }
                } catch (JSONException e7) {
                    e7.getStackTrace();
                    callback.onResponse(-1, "request error = " + e7.getMessage());
                } catch (Exception e8) {
                    e8.getStackTrace();
                    callback.onResponse(-1, "request error = " + e8.getMessage());
                }
            }
        }).start();
    }
}
