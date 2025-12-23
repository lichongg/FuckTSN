package xyz.adscope.amps.tool.request.inter;

import xyz.adscope.common.network.simple.SimpleCallback;
import xyz.adscope.common.network.simple.SimpleResponse;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class IHttpResponseCallback<T> extends SimpleCallback<T> {
    public abstract void failCallback(String str, int i6);

    public abstract void successCallback(T t5);

    @Override // xyz.adscope.common.network.simple.SimpleCallback, xyz.adscope.common.network.simple.Callback
    public void onException(Exception exc) {
        if (exc != null) {
            failCallback(exc.getMessage(), 1100001);
        } else {
            failCallback("network request error", 1100001);
        }
    }

    @Override // xyz.adscope.common.network.simple.Callback
    public void onResponse(SimpleResponse<T, String> simpleResponse) {
        if (simpleResponse.isSucceed()) {
            successCallback(simpleResponse.succeed());
        } else {
            failCallback(simpleResponse.failed(), simpleResponse.code());
        }
    }
}
