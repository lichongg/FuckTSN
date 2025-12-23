package xyz.adscope.common.v2.conn.http.exec;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import xyz.adscope.common.v2.conn.IBaseHttpInputStreamCallback;
import xyz.adscope.common.v2.conn.IBaseHttpResponse;
import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;
import xyz.adscope.common.v2.conn.IHttpRequestError;
import xyz.adscope.common.v2.conn.http.HttpRedirected;
import xyz.adscope.common.v2.conn.http.HttpRequest;
import xyz.adscope.common.v2.conn.http.IRequest;
import xyz.adscope.common.v2.conn.http.NetworkError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class IBaseHttpExecutor implements Runnable {
    protected static final String REQ_ENCODING_GZIP = "gzip";
    protected boolean isAutoRedirected;
    protected IRequest mRequest;
    protected IBaseHttpResponseCallback mResponseCallback;
    private final Set<String> urlRecord = new HashSet();

    protected void callbackFailedResult(IHttpRequestError iHttpRequestError) {
        this.urlRecord.clear();
        IBaseHttpResponseCallback iBaseHttpResponseCallback = this.mResponseCallback;
        if (iBaseHttpResponseCallback != null) {
            iBaseHttpResponseCallback.failCallback(iHttpRequestError);
        }
    }

    public void callbackInputStream(InputStream inputStream) {
        IBaseHttpResponseCallback iBaseHttpResponseCallback = this.mResponseCallback;
        if (iBaseHttpResponseCallback instanceof IBaseHttpInputStreamCallback) {
            ((IBaseHttpInputStreamCallback) iBaseHttpResponseCallback).onInputStream(inputStream);
        }
    }

    protected void callbackResult(IBaseHttpResponse iBaseHttpResponse) {
        this.urlRecord.clear();
        IBaseHttpResponseCallback iBaseHttpResponseCallback = this.mResponseCallback;
        if (iBaseHttpResponseCallback != null) {
            iBaseHttpResponseCallback.successCallback(iBaseHttpResponse);
        }
    }

    protected void recordConnectUrl(String str) {
        this.urlRecord.add(str);
    }

    protected void redirected(String str, int i6) {
        if (!this.isAutoRedirected) {
            callbackResult(new HttpRedirected(i6, str));
        } else if (this.urlRecord.contains(str)) {
            callbackFailedResult(NetworkError.DEFAULT.ERROR_REDIRECT_LOOP);
        } else {
            this.mRequest = new HttpRequest(str, this.mRequest);
            run();
        }
    }

    IBaseHttpExecutor(IRequest iRequest, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        this.mRequest = iRequest;
        this.isAutoRedirected = iRequest.isAutoRedirected();
        this.mResponseCallback = iBaseHttpResponseCallback;
    }
}
