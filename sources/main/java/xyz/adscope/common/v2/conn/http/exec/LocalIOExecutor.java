package xyz.adscope.common.v2.conn.http.exec;

import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
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
public class LocalIOExecutor extends IBaseHttpExecutor {
    private static final int DEFAULT_LOCAL_IO_TIMEOUT = 5000;
    private File save;

    private void cacheIOFile(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null || outputStream == null) {
            return;
        }
        IOUtils.write(inputStream, outputStream);
    }

    private void cacheRequest(HttpURLConnection httpURLConnection) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (httpURLConnection == null) {
            callbackFailedResult(NetworkError.DEFAULT.ERROR_UNEXPECTED);
            return;
        }
        InputStream inputStream = null;
        try {
            System.currentTimeMillis();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                String contentEncoding = httpURLConnection.getContentEncoding();
                InputStream inputStream2 = (TextUtils.isEmpty(contentEncoding) || !contentEncoding.contains("gzip")) ? httpURLConnection.getInputStream() : new GZIPInputStream(httpURLConnection.getInputStream());
                try {
                    File file = this.save;
                    if (file != null) {
                        if (!file.exists()) {
                            this.save.createNewFile();
                        }
                        if (this.save.canWrite()) {
                            fileOutputStream2 = new FileOutputStream(this.save);
                            try {
                                cacheIOFile(inputStream2, fileOutputStream2);
                                callbackResult(new HttpResponse(responseCode, this.save.getAbsolutePath()));
                                inputStream = inputStream2;
                            } catch (Throwable th) {
                                fileOutputStream = fileOutputStream2;
                                th = th;
                                inputStream = inputStream2;
                                IOUtils.closeQuietly(fileOutputStream);
                                IOUtils.closeQuietly(inputStream);
                                throw th;
                            }
                        }
                    } else {
                        callbackFailedResult(NetworkError.DEFAULT.ERROR_UNEXPECTED);
                    }
                    fileOutputStream2 = null;
                    inputStream = inputStream2;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } else {
                if (responseCode == 302) {
                    redirected(httpURLConnection.getHeaderField("Location"), responseCode);
                } else {
                    callbackFailedResult(new NetworkError(responseCode, "request failed..."));
                }
                fileOutputStream2 = null;
            }
            IOUtils.closeQuietly(fileOutputStream2);
            IOUtils.closeQuietly(inputStream);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
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

    public void setIOFile(File file) {
        this.save = file;
    }

    LocalIOExecutor(IRequest iRequest, IBaseHttpResponseCallback iBaseHttpResponseCallback) {
        super(iRequest, iBaseHttpResponseCallback);
    }
}
