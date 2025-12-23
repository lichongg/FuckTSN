package com.bxkj.base.v2.http.exception;

import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class ApiException extends RuntimeException {

    @Nullable
    private Integer code;

    @Nullable
    private String message;

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    @Nullable
    public String getMessage() {
        return this.message;
    }

    public final void setCode(@Nullable Integer num) {
        this.code = num;
    }

    public void setMessage(@Nullable String str) {
        this.message = str;
    }

    public ApiException(@Nullable Integer num, @Nullable String str) {
        this.code = num;
        this.message = str;
    }
}
