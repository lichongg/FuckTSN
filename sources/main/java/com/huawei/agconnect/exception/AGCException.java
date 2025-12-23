package com.huawei.agconnect.exception;

/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class AGCException extends Exception {
    private int code;
    private String errMsg;

    public int getCode() {
        return this.code;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return " code: " + this.code + " message: " + this.errMsg;
    }

    public AGCException(String str, int i6) {
        this.code = i6;
        this.errMsg = str;
    }
}
