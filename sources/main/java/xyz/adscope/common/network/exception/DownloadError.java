package xyz.adscope.common.network.exception;

import xyz.adscope.common.network.Headers;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DownloadError extends ReadException {

    /* renamed from: a, reason: collision with root package name */
    private int f56659a;

    /* renamed from: b, reason: collision with root package name */
    private Headers f56660b;

    public DownloadError(int i6, Headers headers, String str) {
        super(str);
        this.f56659a = i6;
        this.f56660b = headers;
    }

    public int getCode() {
        return this.f56659a;
    }

    public Headers getHeaders() {
        return this.f56660b;
    }

    public DownloadError(int i6, Headers headers, Throwable th) {
        super(th);
        this.f56659a = i6;
        this.f56660b = headers;
    }
}
