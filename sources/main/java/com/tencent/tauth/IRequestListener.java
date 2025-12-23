package com.tencent.tauth;

import com.tencent.open.utils.HttpUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface IRequestListener {
    void onComplete(JSONObject jSONObject);

    void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException);

    void onIOException(IOException iOException);

    void onJSONException(JSONException jSONException);

    void onMalformedURLException(MalformedURLException malformedURLException);

    void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException);

    void onSocketTimeoutException(SocketTimeoutException socketTimeoutException);

    void onUnknowException(Exception exc);
}
