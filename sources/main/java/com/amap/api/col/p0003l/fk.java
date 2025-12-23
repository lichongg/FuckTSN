package com.amap.api.col.p0003l;

import com.amap.api.maps.AMapException;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class fk extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private String f6216a;

    /* renamed from: b, reason: collision with root package name */
    private String f6217b;

    /* renamed from: c, reason: collision with root package name */
    private String f6218c;

    /* renamed from: d, reason: collision with root package name */
    private String f6219d;

    /* renamed from: e, reason: collision with root package name */
    private String f6220e;

    /* renamed from: f, reason: collision with root package name */
    private int f6221f;

    /* renamed from: g, reason: collision with root package name */
    private int f6222g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f6223h;

    /* renamed from: i, reason: collision with root package name */
    private String f6224i;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, List<String>> f6225j;

    public fk(String str) {
        super(str);
        this.f6216a = AMapException.ERROR_UNKNOWN;
        this.f6217b = "";
        this.f6218c = "";
        this.f6219d = "1900";
        this.f6220e = "UnknownError";
        this.f6221f = -1;
        this.f6222g = -1;
        this.f6223h = false;
        this.f6216a = str;
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f6221f = 21;
            this.f6219d = "1902";
            this.f6220e = "IOException";
        } else if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f6221f = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f6221f = 23;
            this.f6219d = "1802";
            this.f6220e = "SocketTimeoutException";
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f6221f = 24;
            this.f6219d = "1901";
            this.f6220e = "IllegalArgumentException";
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f6221f = 25;
            this.f6219d = "1903";
            this.f6220e = "NullPointException";
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f6221f = 26;
            this.f6219d = "1803";
            this.f6220e = "MalformedURLException";
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f6221f = 27;
            this.f6219d = "1804";
            this.f6220e = "UnknownHostException";
        } else if (AMapException.ERROR_UNKNOW_SERVICE.equals(str)) {
            this.f6221f = 28;
            this.f6219d = "1805";
            this.f6220e = "CannotConnectToHostException";
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f6221f = 29;
            this.f6219d = "1801";
            this.f6220e = "ProtocolException";
        } else if (AMapException.ERROR_CONNECTION.equals(str)) {
            this.f6221f = 30;
            this.f6219d = "1806";
            this.f6220e = "ConnectionException";
        } else if ("服务QPS超限".equalsIgnoreCase(str)) {
            this.f6221f = 30;
            this.f6219d = "2001";
            this.f6220e = "ConnectionException";
        } else if (AMapException.ERROR_UNKNOWN.equals(str)) {
            this.f6221f = 31;
        } else if (AMapException.ERROR_FAILURE_AUTH.equals(str)) {
            this.f6221f = 32;
        } else if ("限制访问的接口".equals(str)) {
            this.f6221f = 33;
        } else if ("requeust is null".equals(str)) {
            this.f6221f = 1;
        } else if ("request url is empty".equals(str)) {
            this.f6221f = 2;
        } else if ("response is null".equals(str)) {
            this.f6221f = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f6221f = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f6221f = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f6221f = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f6221f = 7;
        } else if ("线程池为空".equals(str)) {
            this.f6221f = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f6221f = 101;
        } else if ("DNS解析失败".equals(str)) {
            this.f6221f = 3;
        } else {
            this.f6221f = -1;
        }
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f6222g = 7;
            return;
        }
        if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f6222g = 6;
            return;
        }
        if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f6222g = 2;
            return;
        }
        if (!"未知主机 - UnKnowHostException".equals(str)) {
            if (AMapException.ERROR_CONNECTION.equals(str)) {
                this.f6222g = 6;
                return;
            } else if (!AMapException.ERROR_UNKNOWN.equals(str) && "DNS解析失败".equals(str)) {
                this.f6222g = 3;
                return;
            }
        }
        this.f6222g = 9;
    }

    public final String a() {
        return this.f6216a;
    }

    public final void j() {
        this.f6223h = true;
    }

    public final void a(int i6) {
        this.f6221f = i6;
    }

    public final String b() {
        return this.f6219d;
    }

    public final String c() {
        return this.f6220e;
    }

    public final String d() {
        return this.f6217b;
    }

    public final String e() {
        return this.f6218c;
    }

    public final int f() {
        return this.f6221f;
    }

    public final int g() {
        return this.f6222g;
    }

    public final int h() {
        this.f6222g = 10;
        return 10;
    }

    public final boolean i() {
        return this.f6223h;
    }

    public final void a(String str) {
        this.f6224i = str;
    }

    public final void a(Map<String, List<String>> map) {
        this.f6225j = map;
    }

    public fk(String str, String str2, String str3) {
        this(str);
        this.f6217b = str2;
        this.f6218c = str3;
    }
}
