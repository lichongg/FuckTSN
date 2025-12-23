package xyz.adscope.common.network.download;

import android.text.TextUtils;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.Url;
import xyz.adscope.common.network.download.Download;
import xyz.adscope.common.network.exception.DownloadError;
import xyz.adscope.common.network.util.IOUtils;
import xyz.adscope.common.network.util.UrlUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class BasicWorker<T extends Download> implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    private final T f56612a;

    /* renamed from: b, reason: collision with root package name */
    private String f56613b;

    /* renamed from: c, reason: collision with root package name */
    private String f56614c;

    /* renamed from: d, reason: collision with root package name */
    private Download.ProgressBar f56615d;

    /* renamed from: e, reason: collision with root package name */
    private Download.Policy f56616e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class AsyncProgressBar implements Download.ProgressBar {

        /* renamed from: a, reason: collision with root package name */
        private final Download.ProgressBar f56617a;

        /* renamed from: b, reason: collision with root package name */
        private final Executor f56618b = Kalle.getConfig().getMainExecutor();

        @Override // xyz.adscope.common.network.download.Download.ProgressBar
        public void onProgress(final int i6, final long j6, final long j7) {
            this.f56618b.execute(new Runnable() { // from class: xyz.adscope.common.network.download.BasicWorker.AsyncProgressBar.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncProgressBar.this.f56617a.onProgress(i6, j6, j7);
                }
            });
        }

        AsyncProgressBar(Download.ProgressBar progressBar) {
            this.f56617a = progressBar;
        }
    }

    private String a(Headers headers) {
        String contentDisposition = headers.getContentDisposition();
        String str = null;
        if (!TextUtils.isEmpty(contentDisposition)) {
            str = Headers.parseSubValue(contentDisposition, "filename", null);
            if (!TextUtils.isEmpty(str)) {
                str = UrlUtils.urlDecode(str, "utf-8");
                if (str.startsWith("\"") && str.endsWith("\"")) {
                    str = str.substring(1, str.length() - 1);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        Url url = this.f56612a.url();
        String path = url.getPath();
        if (TextUtils.isEmpty(path)) {
            return Integer.toString(url.toString().hashCode());
        }
        String[] split = path.split("/");
        return split[split.length - 1];
    }

    protected abstract Response a(T t5);

    public abstract void cancel();

    /* JADX WARN: Not initialized variable reg: 26, insn: 0x018d: MOVE (r2 I:??[OBJECT, ARRAY]) = (r26 I:??[OBJECT, ARRAY]), block:B:60:0x018d */
    @Override // java.util.concurrent.Callable
    public String call() {
        File file;
        int code;
        Headers headers;
        Response response;
        long contentLength;
        int i6;
        long j6;
        if (TextUtils.isEmpty(this.f56613b)) {
            throw new IOException("Please specify the directory.");
        }
        IOUtils.createFolder(new File(this.f56613b));
        Response response2 = null;
        try {
            if (TextUtils.isEmpty(this.f56614c)) {
                response2 = a((BasicWorker<T>) this.f56612a);
                code = response2.code();
                headers = response2.headers();
                this.f56614c = a(headers);
                file = new File(this.f56613b, this.f56614c + ".kalle");
            } else {
                file = new File(this.f56613b, this.f56614c + ".kalle");
                if (this.f56616e.isRange() && file.exists()) {
                    this.f56612a.headers().set("Range", "bytes=" + file.length() + "-");
                    response2 = a((BasicWorker<T>) this.f56612a);
                    code = response2.code();
                    headers = response2.headers();
                } else {
                    response2 = a((BasicWorker<T>) this.f56612a);
                    code = response2.code();
                    headers = response2.headers();
                    IOUtils.delFileOrFolder(file);
                }
            }
            try {
                try {
                    if (!this.f56616e.allowDownload(code, headers)) {
                        throw new DownloadError(code, headers, "The download policy prohibits the program from continuing to download.");
                    }
                    File file2 = new File(this.f56613b, this.f56614c);
                    if (file2.exists()) {
                        String absolutePath = file2.getAbsolutePath();
                        if (this.f56616e.oldAvailable(absolutePath, code, headers)) {
                            this.f56615d.onProgress(100, file2.length(), 0L);
                            IOUtils.closeQuietly(response2);
                            return absolutePath;
                        }
                        IOUtils.delFileOrFolder(file2);
                    }
                    if (code == 206) {
                        String contentRange = headers.getContentRange();
                        contentLength = Long.parseLong(contentRange.substring(contentRange.indexOf(47) + 1));
                    } else {
                        IOUtils.createNewFile(file);
                        contentLength = headers.getContentLength();
                    }
                    long length = file.length();
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rws");
                    randomAccessFile.seek(length);
                    byte[] bArr = new byte[HttpPostBodyUtil.chunkSize];
                    long currentTimeMillis = System.currentTimeMillis();
                    InputStream stream = response2.body().stream();
                    int i7 = 0;
                    long j7 = length;
                    long j8 = 0;
                    int i8 = 0;
                    long j9 = 0;
                    while (true) {
                        int read = stream.read(bArr);
                        Response response3 = response2;
                        if (read == -1) {
                            this.f56615d.onProgress(100, j7, j9);
                            file.renameTo(file2);
                            String absolutePath2 = file2.getAbsolutePath();
                            IOUtils.closeQuietly(response3);
                            return absolutePath2;
                        }
                        randomAccessFile.write(bArr, i7, read);
                        int i9 = i8;
                        long j10 = read;
                        long j11 = j7 + j10;
                        j8 += j10;
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 < 400) {
                            j6 = j9;
                            i6 = i9;
                        } else {
                            long j12 = (1000 * j8) / currentTimeMillis2;
                            if (contentLength != 0) {
                                int i10 = (int) ((100 * j11) / contentLength);
                                i6 = i9;
                                if (i10 == i6 && j12 == j9) {
                                    j6 = j9;
                                }
                                long currentTimeMillis3 = System.currentTimeMillis();
                                this.f56615d.onProgress(i10, j11, j12);
                                currentTimeMillis = currentTimeMillis3;
                                j8 = 0;
                                i8 = i10;
                                j9 = j12;
                            } else {
                                i6 = i9;
                                if (j9 != j12) {
                                    long currentTimeMillis4 = System.currentTimeMillis();
                                    this.f56615d.onProgress(0, j11, j12);
                                    currentTimeMillis = currentTimeMillis4;
                                    i8 = i6;
                                    j8 = 0;
                                    j9 = j12;
                                } else {
                                    j6 = j9;
                                    this.f56615d.onProgress(0, j11, j6);
                                }
                            }
                            response2 = response3;
                            j7 = j11;
                            i7 = 0;
                        }
                        i8 = i6;
                        j9 = j6;
                        response2 = response3;
                        j7 = j11;
                        i7 = 0;
                    }
                } catch (Throwable th) {
                    th = th;
                    response2 = response;
                    IOUtils.closeQuietly(response2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    BasicWorker(T t5) {
        this.f56612a = t5;
        this.f56613b = t5.directory();
        this.f56614c = t5.fileName();
        this.f56615d = new AsyncProgressBar(t5.progressBar());
        this.f56616e = t5.policy();
    }
}
