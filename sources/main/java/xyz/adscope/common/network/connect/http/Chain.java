package xyz.adscope.common.network.connect.http;

import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.Response;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface Chain {
    Call call();

    @Deprecated
    Call newCall();

    Response proceed(Request request);

    Request request();
}
