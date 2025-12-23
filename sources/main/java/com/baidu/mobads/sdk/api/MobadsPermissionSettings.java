package com.baidu.mobads.sdk.api;

import android.os.Bundle;
import com.baidu.mobads.sdk.internal.aa;
import com.baidu.mobads.sdk.internal.ay;
import com.baidu.mobads.sdk.internal.az;
import com.baidu.mobads.sdk.internal.bd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class MobadsPermissionSettings {
    private static final String PERMISSION_APP_LIST = "permission_app_list";
    private static final String PERMISSION_APP_UPDATE = "permission_app_update";
    private static final String PERMISSION_DEVICE_INFO = "permission_device_info";
    private static final String PERMISSION_LIMIT_STATE = "permission_limitpersonalads";
    private static final String PERMISSION_LOCATION = "permission_location";
    private static final String PERMISSION_OAID = "permission_oaid";
    private static final String PERMISSION_PHONE_STATE = "permission_read_phone_state";
    private static final String PERMISSION_RUNNING_APP = "permission_running_app";
    private static final String PERMISSION_STORAGE = "permission_storage";
    private static boolean mAccessAppListGranted = false;
    private static boolean mAccessLocationGranted = false;
    private static boolean mAppUpdateGranted = true;
    private static boolean mCheckSPLimit = false;
    private static boolean mDeviceInfoGranted = true;
    private static boolean mExternalStorageGranted = false;
    private static boolean mLimitPrivacyAds = false;
    private static boolean mOAIDGranted = true;
    private static boolean mReadPhoneStateGranted = false;
    private static boolean mRunningAppGranted = true;

    private static boolean handleIntegrationInfo(Bundle bundle) {
        try {
            switchDebugLog(bundle);
            IXAdContainerFactory c6 = aa.a().c();
            if (c6 != null) {
                c6.getRemoteParam("integrationInfo", bundle);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static JSONObject getLimitInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PERMISSION_LIMIT_STATE, mLimitPrivacyAds);
            return jSONObject;
        } catch (JSONException e6) {
            e6.printStackTrace();
            return jSONObject;
        }
    }

    public static JSONObject getPermissionInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PERMISSION_LOCATION, "" + mAccessLocationGranted);
            jSONObject.put(PERMISSION_STORAGE, "" + mExternalStorageGranted);
            jSONObject.put(PERMISSION_APP_LIST, "" + mAccessAppListGranted);
            jSONObject.put(PERMISSION_PHONE_STATE, "" + mReadPhoneStateGranted);
            jSONObject.put(PERMISSION_OAID, "" + mOAIDGranted);
            jSONObject.put(PERMISSION_APP_UPDATE, "" + mAppUpdateGranted);
            jSONObject.put(PERMISSION_RUNNING_APP, "" + mRunningAppGranted);
            jSONObject.put(PERMISSION_DEVICE_INFO, "" + mDeviceInfoGranted);
            return jSONObject;
        } catch (JSONException e6) {
            e6.printStackTrace();
            return jSONObject;
        }
    }

    public static void setLimitPersonalAds(boolean z5) {
        mLimitPrivacyAds = z5;
        postLimitInfoRemote();
    }

    public static void setPermissionAppList(boolean z5) {
        mAccessAppListGranted = z5;
        postPermissionInfoRemote();
    }

    public static void setPermissionAppUpdate(boolean z5) {
        mAppUpdateGranted = z5;
        postPermissionInfoRemote();
    }

    public static void setPermissionDeviceInfo(boolean z5) {
        mDeviceInfoGranted = z5;
        postPermissionInfoRemote();
    }

    public static void setPermissionLocation(boolean z5) {
        mAccessLocationGranted = z5;
        postPermissionInfoRemote();
    }

    public static void setPermissionOAID(boolean z5) {
        mOAIDGranted = z5;
        postPermissionInfoRemote();
    }

    public static void setPermissionReadDeviceID(boolean z5) {
        mReadPhoneStateGranted = z5;
        postPermissionInfoRemote();
    }

    public static void setPermissionRunningApp(boolean z5) {
        mRunningAppGranted = z5;
        postPermissionInfoRemote();
    }

    public static void setPermissionStorage(boolean z5) {
        mExternalStorageGranted = z5;
        postPermissionInfoRemote();
    }

    private static void switchDebugLog(Bundle bundle) {
        if (bundle != null && bundle.containsKey("debug_mode")) {
            if (bundle.getBoolean("debug_mode")) {
                az.a(true);
                return;
            } else {
                az.a();
                return;
            }
        }
        if (bundle == null || !bundle.containsKey(ay.f10666b)) {
            return;
        }
        if (bundle.getBoolean(ay.f10666b)) {
            az.a((az.a) new ay());
        } else {
            az.i(ay.f10666b);
        }
    }

    private static void updateSPLimitTag() {
        aa a6;
        IXAdContainerFactory c6;
        try {
            if (mCheckSPLimit || (a6 = aa.a()) == null || (c6 = a6.c()) == null) {
                return;
            }
            Object remoteParam = c6.getRemoteParam("limitPersonalAds", new Object[0]);
            if (remoteParam instanceof Boolean) {
                mLimitPrivacyAds = ((Boolean) remoteParam).booleanValue();
                mCheckSPLimit = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean getLimitPersonalAdsStatus() {
        updateSPLimitTag();
        return mLimitPrivacyAds;
    }

    private static void postLimitInfoRemote() {
        IXAdContainerFactory c6 = aa.a().c();
        if (c6 != null) {
            c6.onTaskDistribute(bd.f10705b, getLimitInfo());
        }
    }

    private static void postPermissionInfoRemote() {
        IXAdContainerFactory c6 = aa.a().c();
        if (c6 != null) {
            c6.onTaskDistribute(bd.f10704a, getPermissionInfo());
        }
    }
}
