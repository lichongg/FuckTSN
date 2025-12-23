package xyz.adscope.common.network.connect;

import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.connect.http.Chain;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface Interceptor {
    Response intercept(Chain chain);
}
