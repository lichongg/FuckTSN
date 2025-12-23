package xyz.adscope.common.v2.conn.http.exec;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
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
public class PostExecutor extends IBaseHttpExecutor {
    private void post(HttpURLConnection httpURLConnection) {
        Closeable closeable;
        OutputStream outputStream;
        if (httpURLConnection == null) {
            callbackFailedResult(NetworkError.DEFAULT.ERROR_UNEXPECTED);
            return;
        }
        InputStream inputStream = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
        } catch (Throwable th) {
            th = th;
            closeable = null;
        }
        try {
            outputStream.write(this.mRequest.getRequestBodyBytes());
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                String contentEncoding = httpURLConnection.getContentEncoding();
                inputStream = (TextUtils.isEmpty(contentEncoding) || !contentEncoding.contains("gzip")) ? httpURLConnection.getInputStream() : new GZIPInputStream(httpURLConnection.getInputStream());
                callbackResult(new HttpResponse(responseCode, IOUtils.read(inputStream, "UTF-8")));
            } else if (responseCode == 302) {
                redirected(httpURLConnection.getHeaderField("Location"), responseCode);
            } else {
                callbackFailedResult(new NetworkError(responseCode, "request failed..."));
            }
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
        } catch (Throwable th2) {
            th = th2;
            closeable = null;
            inputStream = outputStream;
            IOUtils.closeQuietly(closeable);
            IOUtils.closeQuietly(inputStream);
            throw th;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IRequest iRequest = this.mRequest;
        if (iRequest == null) {
            callbackFailedResult(NetworkError.DEFAULT.ERROR_INVALID_URL);
            return;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnection = ConnectionFactory.createNewConnection(iRequest);
                recordConnectUrl(this.mRequest.getRequestURL());
                post(httpURLConnection);
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e6) {
                callbackFailedResult(new NetworkError(-100, e6.getMessage()));
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    PostExecutor(IRequest iRequest, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        super(iRequest, iBaseHttpResponseCallback);
    }
}
