package com.amap.api.col.s;

import com.amap.api.maps.AMapException;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class bv extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private String f7882a;

    /* renamed from: b, reason: collision with root package name */
    private String f7883b;

    /* renamed from: c, reason: collision with root package name */
    private String f7884c;

    /* renamed from: d, reason: collision with root package name */
    private String f7885d;

    /* renamed from: e, reason: collision with root package name */
    private String f7886e;

    /* renamed from: f, reason: collision with root package name */
    private int f7887f;

    /* renamed from: g, reason: collision with root package name */
    private int f7888g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f7889h;

    /* renamed from: i, reason: collision with root package name */
    private String f7890i;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, List<String>> f7891j;

    public bv(String str) {
        super(str);
        this.f7882a = AMapException.ERROR_UNKNOWN;
        this.f7883b = "";
        this.f7884c = "";
        this.f7885d = "1900";
        this.f7886e = "UnknownError";
        this.f7887f = -1;
        this.f7888g = -1;
        this.f7889h = false;
        this.f7882a = str;
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f7887f = 21;
            this.f7885d = "1902";
            this.f7886e = "IOException";
        } else if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f7887f = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f7887f = 23;
            this.f7885d = "1802";
            this.f7886e = "SocketTimeoutException";
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f7887f = 24;
            this.f7885d = "1901";
            this.f7886e = "IllegalArgumentException";
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f7887f = 25;
            this.f7885d = "1903";
            this.f7886e = "NullPointException";
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f7887f = 26;
            this.f7885d = "1803";
            this.f7886e = "MalformedURLException";
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f7887f = 27;
            this.f7885d = "1804";
            this.f7886e = "UnknownHostException";
        } else if (AMapException.ERROR_UNKNOW_SERVICE.equals(str)) {
            this.f7887f = 28;
            this.f7885d = "1805";
            this.f7886e = "CannotConnectToHostException";
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f7887f = 29;
            this.f7885d = "1801";
            this.f7886e = "ProtocolException";
        } else if (AMapException.ERROR_CONNECTION.equals(str)) {
            this.f7887f = 30;
            this.f7885d = "1806";
            this.f7886e = "ConnectionException";
        } else if ("服务QPS超限".equalsIgnoreCase(str)) {
            this.f7887f = 30;
            this.f7885d = "2001";
            this.f7886e = "ConnectionException";
        } else if (AMapException.ERROR_UNKNOWN.equals(str)) {
            this.f7887f = 31;
        } else if (AMapException.ERROR_FAILURE_AUTH.equals(str)) {
            this.f7887f = 32;
        } else if ("requeust is null".equals(str)) {
            this.f7887f = 1;
        } else if ("request url is empty".equals(str)) {
            this.f7887f = 2;
        } else if ("response is null".equals(str)) {
            this.f7887f = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f7887f = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f7887f = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f7887f = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f7887f = 7;
        } else if ("线程池为空".equals(str)) {
            this.f7887f = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f7887f = 101;
        } else if ("DNS解析失败".equals(str)) {
            this.f7887f = 3;
        } else {
            this.f7887f = -1;
        }
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f7888g = 7;
            return;
        }
        if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f7888g = 6;
            return;
        }
        if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f7888g = 2;
            return;
        }
        if (!"未知主机 - UnKnowHostException".equals(str)) {
            if (AMapException.ERROR_CONNECTION.equals(str)) {
                this.f7888g = 6;
                return;
            } else if (!AMapException.ERROR_UNKNOWN.equals(str) && "DNS解析失败".equals(str)) {
                this.f7888g = 3;
                return;
            }
        }
        this.f7888g = 9;
    }

    public final String a() {
        return this.f7882a;
    }

    public final void j() {
        this.f7889h = true;
    }

    public final void a(String str) {
        this.f7890i = str;
    }

    public final String b() {
        return this.f7885d;
    }

    public final String c() {
        return this.f7886e;
    }

    public final String d() {
        return this.f7883b;
    }

    public final String e() {
        return this.f7884c;
    }

    public final int f() {
        return this.f7887f;
    }

    public final int g() {
        return this.f7888g;
    }

    public final int h() {
        this.f7888g = 10;
        return 10;
    }

    public final boolean i() {
        return this.f7889h;
    }

    public final void a(Map<String, List<String>> map) {
        this.f7891j = map;
    }

    public bv(String str, String str2, String str3) {
        this(str);
        this.f7883b = str2;
        this.f7884c = str3;
    }
}
