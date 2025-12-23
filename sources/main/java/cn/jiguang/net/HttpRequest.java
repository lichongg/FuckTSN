package cn.jiguang.net;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\Downloads\app\classes2.dex */
public class HttpRequest {

    /* renamed from: a, reason: collision with root package name */
    private String f3120a;

    /* renamed from: b, reason: collision with root package name */
    private String f3121b;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f3124e;

    /* renamed from: g, reason: collision with root package name */
    private Object f3126g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3127h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3128i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3129j;

    /* renamed from: n, reason: collision with root package name */
    private X509TrustManager f3133n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f3134o;

    /* renamed from: p, reason: collision with root package name */
    private HostnameVerifier f3135p;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3130k = true;

    /* renamed from: l, reason: collision with root package name */
    private boolean f3131l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f3132m = false;

    /* renamed from: c, reason: collision with root package name */
    private int f3122c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f3123d = -1;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, String> f3125f = new HashMap();

    public HttpRequest(String str) {
        this.f3120a = str;
    }

    public HttpRequest(String str, Map<String, String> map) {
        this.f3120a = str;
        this.f3124e = map;
    }

    public Object getBody() {
        return this.f3126g;
    }

    public int getConnectTimeout() {
        return this.f3122c;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f3135p;
    }

    public byte[] getParas() {
        Object obj = this.f3126g;
        if (obj != null) {
            if (obj instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) obj)) {
                    return ((String) this.f3126g).getBytes();
                }
            } else if (obj instanceof byte[]) {
                return (byte[]) obj;
            }
        }
        String joinParasWithEncodedValue = HttpUtils.joinParasWithEncodedValue(this.f3124e);
        if (TextUtils.isEmpty(joinParasWithEncodedValue)) {
            return null;
        }
        return joinParasWithEncodedValue.getBytes();
    }

    public Map<String, String> getParasMap() {
        return this.f3124e;
    }

    public int getReadTimeout() {
        return this.f3123d;
    }

    public Map<String, String> getRequestProperties() {
        return this.f3125f;
    }

    public String getRequestProperty(String str) {
        return this.f3125f.get(str);
    }

    public X509TrustManager getSslTrustManager() {
        return this.f3133n;
    }

    public String getType() {
        return this.f3121b;
    }

    public String getUrl() {
        return this.f3120a;
    }

    public boolean isDoInPut() {
        return this.f3128i;
    }

    public boolean isDoOutPut() {
        return this.f3127h;
    }

    public boolean isHaveRspData() {
        return this.f3130k;
    }

    public boolean isNeedErrorInput() {
        return this.f3132m;
    }

    public boolean isNeedRetryIfHttpsFailed() {
        return this.f3134o;
    }

    public boolean isRspDatazip() {
        return this.f3131l;
    }

    public boolean isUseCaches() {
        return this.f3129j;
    }

    public void setBody(Object obj) {
        this.f3126g = obj;
    }

    public void setConnectTimeout(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.f3122c = i6;
    }

    public void setDoInPut(boolean z5) {
        this.f3128i = z5;
    }

    public void setDoOutPut(boolean z5) {
        this.f3127h = z5;
    }

    public void setHaveRspData(boolean z5) {
        this.f3130k = z5;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f3135p = hostnameVerifier;
    }

    public void setNeedErrorInput(boolean z5) {
        this.f3132m = z5;
    }

    public void setNeedRetryIfHttpsFailed(boolean z5) {
        this.f3134o = z5;
    }

    public void setParasMap(Map<String, String> map) {
        this.f3124e = map;
    }

    public void setReadTimeout(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.f3123d = i6;
    }

    public void setRequestProperties(Map<String, String> map) {
        this.f3125f = map;
    }

    public void setRequestProperty(String str, String str2) {
        this.f3125f.put(str, str2);
    }

    public void setRspDatazip(boolean z5) {
        this.f3131l = z5;
    }

    public void setSslTrustManager(X509TrustManager x509TrustManager) {
        this.f3133n = x509TrustManager;
    }

    public void setType(String str) {
        this.f3121b = str;
    }

    public void setUrl(String str) {
        this.f3120a = str;
    }

    public void setUseCaches(boolean z5) {
        this.f3129j = z5;
    }

    public void setUserAgent(String str) {
        this.f3125f.put("User-Agent", str);
    }
}
