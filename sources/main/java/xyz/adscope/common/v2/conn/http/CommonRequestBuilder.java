package xyz.adscope.common.v2.conn.http;

import android.content.Context;
import java.io.File;
import java.util.Map;
import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;
import xyz.adscope.common.v2.conn.IHttpRequestError;
import xyz.adscope.common.v2.conn.http.NetworkError;
import xyz.adscope.common.v2.conn.http.exec.HttpExecutorCreator;
import xyz.adscope.common.v2.conn.http.exec.IBaseHttpExecutor;
import xyz.adscope.common.v2.conn.http.exec.LocalIOExecutor;
import xyz.adscope.common.v2.thread.pool.IBaseThreadPool;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class CommonRequestBuilder {
    private byte[] mReqBody;
    private RequestMethod mReqMethod;
    private String mReqUrl;
    private IBaseHttpResponseCallback mResponseCallback;
    private File mSaveFile;
    private final CommonHeader mHeader = CommonHeader.obtainBasicHeader();
    private boolean isAutoRedirected = true;

    public CommonRequestBuilder appendHeader(Map<String, String> map) {
        this.mHeader.putAll(map);
        return this;
    }

    private void callbackFailedResult(IHttpRequestError iHttpRequestError) {
        IBaseHttpResponseCallback iBaseHttpResponseCallback = this.mResponseCallback;
        if (iBaseHttpResponseCallback != null) {
            iBaseHttpResponseCallback.failCallback(iHttpRequestError);
        }
    }

    public void appendHeader(String str, String str2) {
        this.mHeader.put(str, str2);
    }

    public CommonRequestBuilder autoRedirected(boolean z5) {
        this.isAutoRedirected = z5;
        return this;
    }

    public CommonRequestBuilder body(byte[] bArr) {
        this.mReqBody = bArr;
        return this;
    }

    public void cacheImage(String str) {
        this.mReqMethod = RequestMethod.CACHE_IMAGE;
        this.mReqUrl = str;
    }

    public CommonRequestBuilder concern(IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        this.mResponseCallback = iBaseHttpResponseCallback;
        return this;
    }

    public void download(String str, File file) {
        this.mReqMethod = RequestMethod.DOWNLOAD;
        this.mReqUrl = str;
        this.mSaveFile = file;
    }

    public void get(String str) {
        this.mReqMethod = RequestMethod.GET;
        this.mReqUrl = str;
    }

    public IBaseHttpExecutor performLocalIO() {
        IBaseHttpExecutor createHttpExecutor = HttpExecutorCreator.createHttpExecutor(new HttpRequest(this.mReqUrl, this.mReqMethod, this.mReqBody, this.mHeader, this.isAutoRedirected), this.mResponseCallback);
        if (createHttpExecutor instanceof LocalIOExecutor) {
            ((LocalIOExecutor) createHttpExecutor).setIOFile(this.mSaveFile);
        }
        return createHttpExecutor;
    }

    public void post(String str) {
        this.mReqMethod = RequestMethod.POST;
        this.mReqUrl = str;
    }

    public void postStream(String str) {
        this.mReqMethod = RequestMethod.STREAM;
        this.mReqUrl = str;
    }

    public void perform(Context context) {
        IBaseThreadPool orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(context);
        IBaseHttpExecutor createHttpExecutor = HttpExecutorCreator.createHttpExecutor(new HttpRequest(this.mReqUrl, this.mReqMethod, this.mReqBody, this.mHeader, this.isAutoRedirected), this.mResponseCallback);
        if (createHttpExecutor != null) {
            if (createHttpExecutor instanceof LocalIOExecutor) {
                ((LocalIOExecutor) createHttpExecutor).setIOFile(this.mSaveFile);
            }
            orCreateImplement.executeRequestAsyncTask(createHttpExecutor);
            return;
        }
        callbackFailedResult(NetworkError.DEFAULT.ERROR_METHOD);
    }
}
