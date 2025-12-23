package com.tencent.open.apireq;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class BaseResp {
    public static final int CODE_ERROR_PARAMS = -2000;
    public static final int CODE_NOT_LOGIN = -2001;
    public static final int CODE_PERMISSION_NOT_GRANTED = -1003;
    public static final int CODE_QQ_LOW_VERSION = -1001;
    public static final int CODE_QQ_NOT_INSTALLED = -1000;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNSUPPORTED_BRANCH = -1002;

    /* renamed from: a, reason: collision with root package name */
    private int f40509a = 0;

    /* renamed from: b, reason: collision with root package name */
    private String f40510b = "";

    protected String a(int i6) {
        return "Api call failed.";
    }

    public int getCode() {
        return this.f40509a;
    }

    public String getErrorMsg() {
        return this.f40510b;
    }

    public boolean isSuccess() {
        return this.f40509a == 0;
    }

    public void setCode(int i6) {
        String str;
        this.f40509a = i6;
        if (i6 == -2001) {
            str = "Not login.";
        } else if (i6 == -2000) {
            str = "The given params check failed.";
        } else if (i6 != 0) {
            switch (i6) {
                case -1002:
                    str = "The QQ branch (e.g. TIM) is not supported";
                    break;
                case -1001:
                    str = "QQ version is too low.";
                    break;
                case -1000:
                    str = "QQ is not installed.";
                    break;
                default:
                    str = a(i6);
                    break;
            }
        } else {
            str = "";
        }
        setErrorMsg(str);
    }

    public void setErrorMsg(String str) {
        this.f40510b = str;
    }

    public String toString() {
        return "BaseResp{mCode=" + this.f40509a + ", mErrorMsg='" + this.f40510b + "'}";
    }
}
