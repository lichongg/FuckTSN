package com.amap.api.col.p0003l;

import com.amap.api.services.core.AMapException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class fc extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private String f6214a;

    /* renamed from: b, reason: collision with root package name */
    private int f6215b;

    public fc(String str) {
        super(str);
        this.f6215b = 1000;
        this.f6214a = str;
        a(str);
    }

    public final String a() {
        return this.f6214a;
    }

    private void a(String str) {
        if ("用户签名未通过".equals(str)) {
            this.f6215b = 1001;
            return;
        }
        if (AMapException.AMAP_INVALID_USER_KEY.equals(str)) {
            this.f6215b = 1002;
            return;
        }
        if (AMapException.AMAP_SERVICE_NOT_AVAILBALE.equals(str)) {
            this.f6215b = 1003;
            return;
        }
        if (AMapException.AMAP_DAILY_QUERY_OVER_LIMIT.equals(str)) {
            this.f6215b = 1004;
            return;
        }
        if (AMapException.AMAP_ACCESS_TOO_FREQUENT.equals(str)) {
            this.f6215b = 1005;
            return;
        }
        if (AMapException.AMAP_INVALID_USER_IP.equals(str)) {
            this.f6215b = 1006;
            return;
        }
        if (AMapException.AMAP_INVALID_USER_DOMAIN.equals(str)) {
            this.f6215b = 1007;
            return;
        }
        if (AMapException.AMAP_INVALID_USER_SCODE.equals(str)) {
            this.f6215b = 1008;
            return;
        }
        if (AMapException.AMAP_USERKEY_PLAT_NOMATCH.equals(str)) {
            this.f6215b = 1009;
            return;
        }
        if (AMapException.AMAP_IP_QUERY_OVER_LIMIT.equals(str)) {
            this.f6215b = 1010;
            return;
        }
        if (AMapException.AMAP_NOT_SUPPORT_HTTPS.equals(str)) {
            this.f6215b = 1011;
            return;
        }
        if (AMapException.AMAP_INSUFFICIENT_PRIVILEGES.equals(str)) {
            this.f6215b = 1012;
            return;
        }
        if (AMapException.AMAP_USER_KEY_RECYCLED.equals(str)) {
            this.f6215b = 1013;
            return;
        }
        if (AMapException.AMAP_ENGINE_RESPONSE_ERROR.equals(str)) {
            this.f6215b = 1100;
            return;
        }
        if (AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR.equals(str)) {
            this.f6215b = AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR;
            return;
        }
        if (AMapException.AMAP_ENGINE_CONNECT_TIMEOUT.equals(str)) {
            this.f6215b = AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT;
            return;
        }
        if (AMapException.AMAP_ENGINE_RETURN_TIMEOUT.equals(str)) {
            this.f6215b = AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT;
            return;
        }
        if (AMapException.AMAP_SERVICE_INVALID_PARAMS.equals(str)) {
            this.f6215b = AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS;
            return;
        }
        if (AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS.equals(str)) {
            this.f6215b = AMapException.CODE_AMAP_SERVICE_MISSING_REQUIRED_PARAMS;
            return;
        }
        if (AMapException.AMAP_SERVICE_ILLEGAL_REQUEST.equals(str)) {
            this.f6215b = AMapException.CODE_AMAP_SERVICE_ILLEGAL_REQUEST;
            return;
        }
        if (AMapException.AMAP_SERVICE_UNKNOWN_ERROR.equals(str)) {
            this.f6215b = AMapException.CODE_AMAP_SERVICE_UNKNOWN_ERROR;
            return;
        }
        if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f6215b = AMapException.CODE_AMAP_CLIENT_ERROR_PROTOCOL;
            return;
        }
        if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f6215b = AMapException.CODE_AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION;
            return;
        }
        if ("url异常 - MalformedURLException".equals(str)) {
            this.f6215b = AMapException.CODE_AMAP_CLIENT_URL_EXCEPTION;
            return;
        }
        if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f6215b = AMapException.CODE_AMAP_CLIENT_UNKNOWHOST_EXCEPTION;
            return;
        }
        if (AMapException.AMAP_CLIENT_UNKNOWN_ERROR.equals(str)) {
            this.f6215b = 1900;
            return;
        }
        if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f6215b = AMapException.CODE_AMAP_CLIENT_INVALID_PARAMETER;
            return;
        }
        if (AMapException.AMAP_CLIENT_NETWORK_EXCEPTION.equals(str)) {
            this.f6215b = AMapException.CODE_AMAP_CLIENT_NETWORK_EXCEPTION;
            return;
        }
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f6215b = AMapException.CODE_AMAP_CLIENT_IO_EXCEPTION;
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f6215b = AMapException.CODE_AMAP_CLIENT_NULLPOINT_EXCEPTION;
        } else {
            this.f6215b = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
        }
    }

    public fc() {
        this.f6214a = "";
        this.f6215b = 1000;
    }
}
