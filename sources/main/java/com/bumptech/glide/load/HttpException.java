package com.bumptech.glide.load;

import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public HttpException(int i6) {
        this("Http request failed", i6);
    }

    @Deprecated
    public HttpException(String str) {
        this(str, -1);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public HttpException(String str, int i6) {
        this(str, i6, null);
    }

    public HttpException(String str, int i6, @Nullable Throwable th) {
        super(str + ", status code: " + i6, th);
        this.statusCode = i6;
    }
}
