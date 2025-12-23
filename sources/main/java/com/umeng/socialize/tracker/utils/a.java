package com.umeng.socialize.tracker.utils;

import com.qq.e.comm.constants.ErrorCode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum a {
    UnKnownCode(5000),
    Timeout(5001),
    NetworkUnavailable(5002),
    SSLException(5003),
    IOException(ErrorCode.NO_AD_FILL),
    UnKnownHostException(ErrorCode.TRAFFIC_CONTROL_DAY),
    HttpError(ErrorCode.PACKAGE_NAME_ERROR),
    EmptyResponse(ErrorCode.RESOURCE_LOAD_ERROR),
    ErrorResponse(ErrorCode.IMAGE_LOAD_ERROR),
    ErrorMakeRequestBody(ErrorCode.TRAFFIC_CONTROL_HOUR);


    /* renamed from: k, reason: collision with root package name */
    private final int f42517k;

    private String b() {
        return "错误码：" + this.f42517k + " 错误信息：";
    }

    public String a() {
        if (this == UnKnownCode) {
            return b() + "--未知错误--";
        }
        if (this == Timeout) {
            return b() + "--连接超时--";
        }
        if (this == NetworkUnavailable) {
            return b() + "--网络不可用--";
        }
        if (this == SSLException) {
            return b() + "--SSL证书认证失败--";
        }
        if (this == IOException) {
            return b() + "--IO异常--";
        }
        if (this == HttpError) {
            return b() + "--服务端返回HTTP错误--";
        }
        if (this == EmptyResponse) {
            return b() + "--服务端返回数据为空--";
        }
        if (this == ErrorResponse) {
            return b() + "--服务端返回错误数据--";
        }
        if (this != ErrorMakeRequestBody) {
            return "unknown";
        }
        return b() + "--请求报文构建错误--";
    }

    a(int i6) {
        this.f42517k = i6;
    }
}
