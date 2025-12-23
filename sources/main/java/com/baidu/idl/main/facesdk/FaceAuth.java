package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.license.BDFaceLicenseAuthInfo;
import com.baidu.idl.main.facesdk.license.BDFaceLicenseLocalInfo;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.idl.main.facesdk.statistic.PostDeviceInfo;
import com.baidu.idl.main.facesdk.utils.PreferencesUtil;
import com.baidu.vis.unified.license.AndroidLicenser;
import com.baidu.vis.unified.license.BDLicenseAuthInfo;
import com.baidu.vis.unified.license.BDLicenseLocalInfo;
import com.baidu.vis.unified.license.HttpStatus;
import com.baidu.vis.unified.license.HttpUtils;
import com.stub.StubApp;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceAuth {
    private static int ALGORITHM_ID = 3;
    private static final String LICENSE_FILE_NAME = "idl-license.face-android";
    private static final String TAG = "FaceSDK";

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeCreatInstance();

    private native void nativeSetActiveLog(int i6, int i7);

    private native void nativeSetCoreConfigure(int i6, int i7);

    static {
        try {
            System.loadLibrary("bdface_sdk");
            System.loadLibrary("bd_unifylicense");
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void initLicense(final Context context, final String str, final String str2, final boolean z5, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceAuth.1
            @Override // java.lang.Runnable
            public void run() {
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    callback.onResponse(2, "license 关键字为空");
                    return;
                }
                AndroidLicenser androidLicenser = AndroidLicenser.getInstance();
                AndroidLicenser.ErrorCode authFromFile = androidLicenser.authFromFile(context, str, str2, z5, FaceAuth.ALGORITHM_ID);
                if (authFromFile != AndroidLicenser.ErrorCode.SUCCESS) {
                    BDLicenseLocalInfo authGetLocalInfo = androidLicenser.authGetLocalInfo(context, FaceAuth.ALGORITHM_ID);
                    if (authGetLocalInfo != null) {
                        authGetLocalInfo.toString();
                    }
                } else {
                    FaceAuth.this.nativeCreatInstance();
                }
                callback.onResponse(authFromFile.ordinal(), androidLicenser.getErrorMsg(FaceAuth.ALGORITHM_ID));
            }
        });
    }

    public void initLicenseBatchLine(final Context context, final String str, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceAuth.3
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                if (context2 == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                PreferencesUtil.initPrefs(context2);
                if (TextUtils.isEmpty(PreferencesUtil.getString("statics", ""))) {
                    PostDeviceInfo.uploadDeviceInfo(context, new Callback() { // from class: com.baidu.idl.main.facesdk.FaceAuth.3.1
                        @Override // com.baidu.idl.main.facesdk.callback.Callback
                        public void onResponse(int i6, String str2) {
                            if (i6 == 0) {
                                PreferencesUtil.putString("statics", "ok");
                            }
                        }
                    });
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(FaceAuth.LICENSE_FILE_NAME)) {
                    callback.onResponse(2, "license 关键字为空");
                    return;
                }
                AndroidLicenser androidLicenser = AndroidLicenser.getInstance();
                AndroidLicenser.ErrorCode authFromFile = androidLicenser.authFromFile(context, str, FaceAuth.LICENSE_FILE_NAME, true, FaceAuth.ALGORITHM_ID);
                if (authFromFile != AndroidLicenser.ErrorCode.SUCCESS) {
                    BDLicenseLocalInfo authGetLocalInfo = androidLicenser.authGetLocalInfo(context, FaceAuth.ALGORITHM_ID);
                    if (authGetLocalInfo != null) {
                        authGetLocalInfo.toString();
                    }
                } else {
                    FaceAuth.this.nativeCreatInstance();
                }
                callback.onResponse(authFromFile.ordinal(), androidLicenser.getErrorMsg(FaceAuth.ALGORITHM_ID));
            }
        });
    }

    public void initLicenseOnLine(final Context context, final String str, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceAuth.2
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                String[] split;
                Context context2 = context;
                if (context2 == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                PreferencesUtil.initPrefs(context2);
                if (TextUtils.isEmpty(PreferencesUtil.getString("statics", ""))) {
                    PostDeviceInfo.uploadDeviceInfo(context, new Callback() { // from class: com.baidu.idl.main.facesdk.FaceAuth.2.1
                        @Override // com.baidu.idl.main.facesdk.callback.Callback
                        public void onResponse(int i6, String str3) {
                            if (i6 == 0) {
                                PreferencesUtil.putString("statics", "ok");
                            }
                        }
                    });
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(FaceAuth.LICENSE_FILE_NAME)) {
                    callback.onResponse(2, "license 关键字为空");
                    return;
                }
                AndroidLicenser androidLicenser = AndroidLicenser.getInstance();
                AndroidLicenser.ErrorCode authFromFile = androidLicenser.authFromFile(context, str, FaceAuth.LICENSE_FILE_NAME, false, FaceAuth.ALGORITHM_ID);
                Objects.toString(authFromFile);
                if (authFromFile == AndroidLicenser.ErrorCode.SUCCESS) {
                    FaceAuth.this.nativeCreatInstance();
                    callback.onResponse(authFromFile.ordinal(), androidLicenser.getErrorMsg(FaceAuth.ALGORITHM_ID));
                    return;
                }
                String deviceId = AndroidLicenser.getDeviceId(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("deviceId", deviceId);
                    jSONObject.put("key", str);
                    jSONObject.put("platformType", 2);
                    jSONObject.put("version", 5);
                    str2 = jSONObject.toString();
                } catch (JSONException e6) {
                    e6.printStackTrace();
                    str2 = null;
                }
                HttpStatus requestPost = HttpUtils.requestPost("https://ai.baidu.com/activation/key/activate", str2, "application/json", FaceAuth.TAG);
                if (requestPost == null) {
                    callback.onResponse(-1, "在线激活失败");
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(requestPost.responseStr);
                    if (jSONObject2.optInt("error_code") != 0) {
                        callback.onResponse(-1, jSONObject2.optString("error_msg"));
                        return;
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject("result");
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("license");
                        if (TextUtils.isEmpty(optString) || (split = optString.split(",")) == null || split.length != 2) {
                            return;
                        }
                        PreferencesUtil.putString("activate_online_key", str);
                        AndroidLicenser.ErrorCode authFromMemory = androidLicenser.authFromMemory(context, str, split, FaceAuth.LICENSE_FILE_NAME, FaceAuth.ALGORITHM_ID);
                        if (authFromMemory != AndroidLicenser.ErrorCode.SUCCESS) {
                            BDLicenseLocalInfo authGetLocalInfo = androidLicenser.authGetLocalInfo(context, FaceAuth.ALGORITHM_ID);
                            if (authGetLocalInfo != null) {
                                authGetLocalInfo.toString();
                            }
                        } else {
                            FaceAuth.this.nativeCreatInstance();
                        }
                        callback.onResponse(authFromMemory.ordinal(), androidLicenser.getErrorMsg(FaceAuth.ALGORITHM_ID));
                    }
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
            }
        });
    }

    public BDFaceLicenseAuthInfo getAuthInfo(Context context) {
        BDLicenseAuthInfo authGetAuthInfo = AndroidLicenser.getInstance().authGetAuthInfo(context, ALGORITHM_ID);
        BDFaceLicenseAuthInfo bDFaceLicenseAuthInfo = new BDFaceLicenseAuthInfo();
        bDFaceLicenseAuthInfo.algorithmId = authGetAuthInfo.algorithmId;
        bDFaceLicenseAuthInfo.deviceId = authGetAuthInfo.deviceId;
        bDFaceLicenseAuthInfo.expireTime = authGetAuthInfo.expireTime;
        bDFaceLicenseAuthInfo.functionList = authGetAuthInfo.functionList;
        bDFaceLicenseAuthInfo.licenseKey = authGetAuthInfo.licenseKey;
        bDFaceLicenseAuthInfo.md5 = authGetAuthInfo.md5;
        bDFaceLicenseAuthInfo.packageName = authGetAuthInfo.packageName;
        return bDFaceLicenseAuthInfo;
    }

    public String getDeviceId(Context context) {
        return AndroidLicenser.getDeviceId(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public BDFaceLicenseLocalInfo getLocalInfo(Context context) {
        BDLicenseLocalInfo authGetLocalInfo = AndroidLicenser.getInstance().authGetLocalInfo(context, ALGORITHM_ID);
        BDFaceLicenseLocalInfo bDFaceLicenseLocalInfo = new BDFaceLicenseLocalInfo();
        bDFaceLicenseLocalInfo.algorithmId = authGetLocalInfo.algorithmId;
        bDFaceLicenseLocalInfo.deviceId = authGetLocalInfo.deviceId;
        bDFaceLicenseLocalInfo.fingerVersion = authGetLocalInfo.fingerVersion;
        bDFaceLicenseLocalInfo.licenseSdkVersion = authGetLocalInfo.licenseSdkVersion;
        bDFaceLicenseLocalInfo.licenseKey = authGetLocalInfo.licenseKey;
        bDFaceLicenseLocalInfo.md5 = authGetLocalInfo.md5;
        bDFaceLicenseLocalInfo.packageName = authGetLocalInfo.packageName;
        return bDFaceLicenseLocalInfo;
    }

    public void setActiveLog(BDFaceSDKCommon.BDFaceLogInfo bDFaceLogInfo, int i6) {
        nativeSetActiveLog(bDFaceLogInfo.ordinal(), i6);
    }

    public void setCoreConfigure(BDFaceSDKCommon.BDFaceCoreRunMode bDFaceCoreRunMode, int i6) {
        nativeSetCoreConfigure(bDFaceCoreRunMode.ordinal(), i6);
    }
}
