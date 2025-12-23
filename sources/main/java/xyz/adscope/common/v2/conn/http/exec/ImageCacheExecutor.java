package xyz.adscope.common.v2.conn.http.exec;

import android.text.TextUtils;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.zip.GZIPInputStream;
import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;
import xyz.adscope.common.v2.conn.http.HttpResponse;
import xyz.adscope.common.v2.conn.http.IRequest;
import xyz.adscope.common.v2.conn.http.NetworkError;
import xyz.adscope.common.v2.conn.http.pool.ConnectionFactory;
import xyz.adscope.common.v2.tool.io.IOUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ImageCacheExecutor extends IBaseHttpExecutor {
    private static final int DEFAULT_LOCAL_IO_TIMEOUT = 5000;

    private void cacheRequest(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            callbackFailedResult(NetworkError.DEFAULT.ERROR_UNEXPECTED);
            return;
        }
        InputStream inputStream = null;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                String contentEncoding = httpURLConnection.getContentEncoding();
                InputStream inputStream2 = (TextUtils.isEmpty(contentEncoding) || !contentEncoding.contains("gzip")) ? httpURLConnection.getInputStream() : new GZIPInputStream(httpURLConnection.getInputStream());
                try {
                    callbackInputStream(inputStream2);
                    callbackResult(new HttpResponse(responseCode, null));
                    inputStream = inputStream2;
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStream2;
                    IOUtils.closeQuietly(inputStream);
                    throw th;
                }
            } else if (responseCode == 302) {
                redirected(httpURLConnection.getHeaderField("Location"), responseCode);
            } else {
                callbackFailedResult(new NetworkError(responseCode, "request failed..."));
            }
            IOUtils.closeQuietly(inputStream);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mRequest == null) {
            callbackFailedResult(NetworkError.DEFAULT.ERROR_INVALID_URL);
            return;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                System.currentTimeMillis();
                httpURLConnection = ConnectionFactory.createNewConnection(this.mRequest);
                recordConnectUrl(this.mRequest.getRequestURL());
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                cacheRequest(httpURLConnection);
                httpURLConnection.disconnect();
            } catch (Exception e6) {
                callbackFailedResult(new NetworkError(-100, e6.getMessage()));
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    ImageCacheExecutor(IRequest iRequest, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        super(iRequest, iBaseHttpResponseCallback);
    }
}
