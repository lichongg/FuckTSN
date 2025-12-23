package com.bykv.vk.component.ttvideo.network;

import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
final class NetworkManager {

    interface OnCompletionListener {
        void onCompletion(JSONObject jSONObject);

        void onError(LiveError liveError);
    }

    static void doRequest(INetworkClient iNetworkClient, String str, String str2, OnCompletionListener onCompletionListener) {
        LiveError liveError;
        JSONObject jSONObject;
        if (str2 == null) {
            return;
        }
        INetworkClient.Result doRequest = iNetworkClient.doRequest(str, str2);
        if (doRequest == null) {
            onCompletionListener.onError(new LiveError(LiveError.EMPTY, "result is null", null));
            return;
        }
        Exception exc = doRequest.f22833e;
        if (exc == null && (jSONObject = doRequest.response) != null) {
            onCompletionListener.onCompletion(jSONObject);
            return;
        }
        HashMap hashMap = new HashMap();
        JSONObject jSONObject2 = doRequest.response;
        if (jSONObject2 != null) {
            hashMap.put("rawResp", jSONObject2);
        }
        if (exc instanceof IOException) {
            hashMap.put(SocialConstants.PARAM_COMMENT, "network IO exception");
            liveError = new LiveError(LiveError.NETWORK_IO_ERROR, exc.toString(), hashMap);
        } else if (exc instanceof JSONException) {
            hashMap.put(SocialConstants.PARAM_COMMENT, "parse JSON failure");
            String str3 = doRequest.body;
            if (str3 != null) {
                hashMap.put("rowBody", str3);
            }
            String str4 = doRequest.header;
            if (str4 != null) {
                hashMap.put("responseHeader", str4);
            }
            liveError = new LiveError(LiveError.PARSE_JSON, exc.getMessage(), hashMap);
        } else {
            hashMap.put(SocialConstants.PARAM_COMMENT, "response not successful");
            liveError = new LiveError(-100004, exc.getMessage(), hashMap);
        }
        onCompletionListener.onError(liveError);
    }

    private NetworkManager() {
    }
}
