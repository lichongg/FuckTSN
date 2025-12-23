package xyz.adscope.common.v2.conn.http.exec;

import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;
import xyz.adscope.common.v2.conn.http.IRequest;
import xyz.adscope.common.v2.conn.http.RequestMethod;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class HttpExecutorCreator {
    public static IBaseHttpExecutor createHttpExecutor(IRequest iRequest, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        if (iRequest == null) {
            return null;
        }
        RequestMethod requestMethod = iRequest.getRequestMethod();
        if (RequestMethod.POST == requestMethod) {
            return new PostExecutor(iRequest, iBaseHttpResponseCallback);
        }
        if (RequestMethod.GET == requestMethod) {
            return new GetExecutor(iRequest, iBaseHttpResponseCallback);
        }
        if (RequestMethod.DOWNLOAD == requestMethod) {
            return new LocalIOExecutor(iRequest, iBaseHttpResponseCallback);
        }
        if (RequestMethod.CACHE_IMAGE == requestMethod) {
            return new ImageCacheExecutor(iRequest, iBaseHttpResponseCallback);
        }
        if (RequestMethod.STREAM == requestMethod) {
            return new PostStreamExecutor(iRequest, iBaseHttpResponseCallback);
        }
        return null;
    }
}
