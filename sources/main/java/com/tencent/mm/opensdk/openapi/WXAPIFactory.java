package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import com.tencent.mm.opensdk.utils.Log;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WXAPIFactory {
    private static final String TAG = "MicroMsg.PaySdk.WXFactory";

    public static IWXAPI createWXAPI(Context context, String str) {
        return createWXAPI(context, str, true);
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z5) {
        Log.d(TAG, "createWXAPI, appId = " + str + ", checkSignature = " + z5);
        return createWXAPI(context, str, z5, 2);
    }

    private WXAPIFactory() {
        throw new RuntimeException(WXAPIFactory.class.getSimpleName() + " should not be instantiated");
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z5, int i6) {
        Log.d(TAG, "createWXAPI, appId = " + str + ", checkSignature = " + z5 + ", launchMode = " + i6);
        return new WXApiImplV10(context, str, z5, i6);
    }
}
