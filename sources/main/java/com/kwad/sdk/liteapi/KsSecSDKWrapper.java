package com.kwad.sdk.liteapi;

import android.content.Context;
import androidx.annotation.Keep;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsSecSDKWrapper {
    private static final String TAG = "KsSecSDKWrapper";

    public static String doSign(Context context, String str) {
        return a.doSign(context, str);
    }

    public static void getEGidByCallback(Context context, boolean z5, final ResponseDfpCallbackProxy responseDfpCallbackProxy) {
        KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback() { // from class: com.kwad.sdk.liteapi.KsSecSDKWrapper.1
            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onFailed(int i6, String str) {
                ResponseDfpCallbackProxy responseDfpCallbackProxy2 = ResponseDfpCallbackProxy.this;
                if (responseDfpCallbackProxy2 != null) {
                    responseDfpCallbackProxy2.onFailed(i6, str);
                }
            }

            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onSuccess(String str, String str2) {
                ResponseDfpCallbackProxy responseDfpCallbackProxy2 = ResponseDfpCallbackProxy.this;
                if (responseDfpCallbackProxy2 != null) {
                    responseDfpCallbackProxy2.onSuccess(str, str2);
                }
            }
        });
    }

    public static void handlePolicy(JSONObject jSONObject) {
        a.handlePolicy(jSONObject);
    }

    public static boolean setEgid(Context context, String str) {
        return KWEGIDDFP.instance().setEgid(context, str);
    }
}
