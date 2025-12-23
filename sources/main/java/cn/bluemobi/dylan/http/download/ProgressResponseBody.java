package cn.bluemobi.dylan.http.download;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ProgressResponseBody extends ResponseBody {
    private BufferedSource bufferedSource;
    private final ProgressResponseListener progressListener;
    private final ResponseBody responseBody;

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.bufferedSource == null) {
            this.bufferedSource = Okio.buffer(source(this.responseBody.source()));
        }
        return this.bufferedSource;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.responseBody.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.responseBody.contentType();
    }

    public ProgressResponseBody(ResponseBody responseBody, ProgressResponseListener progressResponseListener) {
        this.responseBody = responseBody;
        this.progressListener = progressResponseListener;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: cn.bluemobi.dylan.http.download.ProgressResponseBody.1
            long totalBytesRead = 0;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j6) throws IOException {
                long j7;
                boolean z5;
                long read = super.read(buffer, j6);
                long j8 = this.totalBytesRead;
                if (read != -1) {
                    j7 = read;
                } else {
                    j7 = 0;
                }
                this.totalBytesRead = j8 + j7;
                ProgressResponseListener progressResponseListener = ProgressResponseBody.this.progressListener;
                long j9 = this.totalBytesRead;
                long contentLength = ProgressResponseBody.this.responseBody.contentLength();
                if (read == -1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                progressResponseListener.onResponseProgress(j9, contentLength, z5);
                return read;
            }
        };
    }
}
