package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class WXAppLaunchData {
    public static final String ACTION_HANDLE_WXAPPLAUNCH = ".ACTION_HANDLE_WXAPPLAUNCH";
    public static final String ACTION_HANDLE_WXAPP_RESULT = ".ACTION_HANDLE_WXAPP_RESULT";
    public static final String ACTION_HANDLE_WXAPP_SHOW = ".ACTION_HANDLE_WXAPP_SHOW";
    public int launchType;
    public String message;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {
        public static WXAppLaunchData fromBundle(Bundle bundle) {
            WXAppLaunchData wXAppLaunchData = new WXAppLaunchData();
            wXAppLaunchData.launchType = bundle.getInt("_wxapplaunchdata_launchType");
            wXAppLaunchData.message = bundle.getString("_wxapplaunchdata_message");
            return wXAppLaunchData;
        }

        public static Bundle toBundle(WXAppLaunchData wXAppLaunchData) {
            Bundle bundle = new Bundle();
            bundle.putInt("_wxapplaunchdata_launchType", wXAppLaunchData.launchType);
            bundle.putString("_wxapplaunchdata_message", wXAppLaunchData.message);
            return bundle;
        }
    }
}
