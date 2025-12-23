package com.tencent.tauth;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UiError {
    public int errorCode;
    public String errorDetail;
    public String errorMessage;

    public String toString() {
        return "errorCode: " + this.errorCode + ", errorMsg: " + this.errorMessage + ", errorDetail: " + this.errorDetail;
    }

    public UiError(int i6, String str, String str2) {
        this.errorMessage = str;
        this.errorCode = i6;
        this.errorDetail = str2;
    }
}
