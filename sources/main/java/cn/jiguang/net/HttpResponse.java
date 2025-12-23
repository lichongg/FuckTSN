package cn.jiguang.net;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes2.dex */
public class HttpResponse {

    /* renamed from: a, reason: collision with root package name */
    private String f3136a;

    /* renamed from: b, reason: collision with root package name */
    private String f3137b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Object> f3138c;

    /* renamed from: d, reason: collision with root package name */
    private int f3139d;

    /* renamed from: e, reason: collision with root package name */
    private long f3140e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3141f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f3142g;

    /* renamed from: h, reason: collision with root package name */
    private int f3143h;

    /* renamed from: i, reason: collision with root package name */
    private int f3144i;

    public HttpResponse() {
        this.f3143h = -1;
        this.f3144i = -1;
        this.f3138c = new HashMap();
    }

    private int a() {
        int indexOf;
        try {
            String str = (String) this.f3138c.get("cache-control");
            if (TextUtils.isEmpty(str) || (indexOf = str.indexOf("max-age=")) == -1) {
                return -1;
            }
            int indexOf2 = str.indexOf(",", indexOf);
            int i6 = indexOf + 8;
            return Integer.parseInt(indexOf2 != -1 ? str.substring(i6, indexOf2) : str.substring(i6));
        } catch (Exception unused) {
            return -1;
        }
    }

    public String getExpiresHeader() {
        try {
            Map<String, Object> map = this.f3138c;
            if (map == null) {
                return null;
            }
            return (String) map.get("expires");
        } catch (Exception unused) {
            return null;
        }
    }

    public void setExpiredTime(long j6) {
        this.f3142g = true;
        this.f3140e = j6;
    }

    public HttpResponse(String str) {
        this.f3143h = -1;
        this.f3144i = -1;
        this.f3136a = str;
        this.f3139d = 0;
        this.f3141f = false;
        this.f3142g = false;
        this.f3138c = new HashMap();
    }

    public long getExpiredTime() {
        if (this.f3142g) {
            return this.f3140e;
        }
        this.f3142g = true;
        long b6 = b();
        this.f3140e = b6;
        return b6;
    }

    public String getResponseBody() {
        return this.f3137b;
    }

    public int getResponseCode() {
        return this.f3143h;
    }

    public Map<String, Object> getResponseHeaders() {
        return this.f3138c;
    }

    public int getStatusCode() {
        return this.f3144i;
    }

    public int getType() {
        return this.f3139d;
    }

    public String getUrl() {
        return this.f3136a;
    }

    public boolean isInCache() {
        return this.f3141f;
    }

    public HttpResponse setInCache(boolean z5) {
        this.f3141f = z5;
        return this;
    }

    public void setResponseBody(String str) {
        this.f3137b = str;
    }

    public void setResponseCode(int i6) {
        this.f3143h = i6;
    }

    public void setResponseHeader(String str, String str2) {
        Map<String, Object> map = this.f3138c;
        if (map != null) {
            map.put(str, str2);
        }
    }

    public void setResponseHeaders(Map<String, Object> map) {
        this.f3138c = map;
    }

    public void setStatusCode(int i6) {
        this.f3144i = i6;
    }

    public void setType(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("The type of HttpResponse cannot be smaller than 0.");
        }
        this.f3139d = i6;
    }

    public void setUrl(String str) {
        this.f3136a = str;
    }

    public String toString() {
        return "HttpResponse{responseBody='" + this.f3137b + "', responseCode=" + this.f3143h + '}';
    }

    private long b() {
        if (a() != -1) {
            return System.currentTimeMillis() + (r0 * 1000);
        }
        if (!TextUtils.isEmpty(getExpiresHeader())) {
            return HttpUtils.parseGmtTime(getExpiresHeader());
        }
        return -1L;
    }

    public boolean isExpired() {
        if (System.currentTimeMillis() > this.f3140e) {
            return true;
        }
        return false;
    }
}
