package com.tencent.mm.opensdk.diffdev;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum OAuthErrCode {
    WechatAuth_Err_OK(0),
    WechatAuth_Err_NormalErr(-1),
    WechatAuth_Err_NetworkErr(-2),
    WechatAuth_Err_JsonDecodeErr(-3),
    WechatAuth_Err_Cancel(-4),
    WechatAuth_Err_Timeout(-5),
    WechatAuth_Err_Auth_Stopped(-6);

    private int code;

    public int getCode() {
        return this.code;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "OAuthErrCode:" + this.code;
    }

    OAuthErrCode(int i6) {
        this.code = i6;
    }
}
