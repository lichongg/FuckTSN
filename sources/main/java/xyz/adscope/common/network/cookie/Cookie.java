package xyz.adscope.common.network.cookie;

import android.text.TextUtils;
import java.io.Serializable;
import java.net.HttpCookie;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class Cookie implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    private String f56591b;

    /* renamed from: c, reason: collision with root package name */
    private String f56592c;

    /* renamed from: d, reason: collision with root package name */
    private String f56593d;

    /* renamed from: e, reason: collision with root package name */
    private String f56594e;

    /* renamed from: f, reason: collision with root package name */
    private String f56595f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f56596g;

    /* renamed from: h, reason: collision with root package name */
    private String f56597h;

    /* renamed from: i, reason: collision with root package name */
    private long f56598i;

    /* renamed from: j, reason: collision with root package name */
    private String f56599j;

    /* renamed from: k, reason: collision with root package name */
    private String f56600k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f56601l;

    /* renamed from: a, reason: collision with root package name */
    private long f56590a = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f56602m = 1;

    public static boolean isExpired(Cookie cookie) {
        long j6 = cookie.f56598i;
        return j6 != -1 && j6 < System.currentTimeMillis();
    }

    public static Cookie toCookie(String str, HttpCookie httpCookie) {
        Cookie cookie = new Cookie();
        cookie.setUrl(str);
        cookie.setName(httpCookie.getName());
        cookie.setValue(httpCookie.getValue());
        cookie.setComment(httpCookie.getComment());
        cookie.setCommentURL(httpCookie.getCommentURL());
        cookie.setDiscard(httpCookie.getDiscard());
        cookie.setDomain(httpCookie.getDomain());
        long maxAge = httpCookie.getMaxAge();
        if (maxAge > 0) {
            long currentTimeMillis = (maxAge * 1000) + System.currentTimeMillis();
            if (currentTimeMillis < 0) {
                currentTimeMillis = System.currentTimeMillis() + 3153600000000L;
            }
            cookie.setExpiry(currentTimeMillis);
        } else if (maxAge < 0) {
            cookie.setExpiry(-1L);
        } else {
            cookie.setExpiry(0L);
        }
        String path = httpCookie.getPath();
        if (!TextUtils.isEmpty(path) && path.length() > 1 && path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        cookie.setPath(path);
        cookie.setPortList(httpCookie.getPortlist());
        cookie.setSecure(httpCookie.getSecure());
        cookie.setVersion(httpCookie.getVersion());
        return cookie;
    }

    public static HttpCookie toHttpCookie(Cookie cookie) {
        HttpCookie httpCookie = new HttpCookie(cookie.f56592c, cookie.f56593d);
        httpCookie.setComment(cookie.f56594e);
        httpCookie.setCommentURL(cookie.f56595f);
        httpCookie.setDiscard(cookie.f56596g);
        httpCookie.setDomain(cookie.f56597h);
        long j6 = cookie.f56598i;
        if (j6 == 0) {
            httpCookie.setMaxAge(0L);
        } else if (j6 < 0) {
            httpCookie.setMaxAge(-1L);
        } else {
            long currentTimeMillis = j6 - System.currentTimeMillis();
            httpCookie.setMaxAge((currentTimeMillis > 0 ? currentTimeMillis : 0L) / 1000);
        }
        httpCookie.setPath(cookie.f56599j);
        httpCookie.setPortlist(cookie.f56600k);
        httpCookie.setSecure(cookie.f56601l);
        httpCookie.setVersion(cookie.f56602m);
        return httpCookie;
    }

    public String getComment() {
        return this.f56594e;
    }

    public String getCommentURL() {
        return this.f56595f;
    }

    public String getDomain() {
        return this.f56597h;
    }

    public long getExpiry() {
        return this.f56598i;
    }

    public long getId() {
        return this.f56590a;
    }

    public String getName() {
        return this.f56592c;
    }

    public String getPath() {
        return this.f56599j;
    }

    public String getPortList() {
        return this.f56600k;
    }

    public String getUrl() {
        return this.f56591b;
    }

    public String getValue() {
        return this.f56593d;
    }

    public int getVersion() {
        return this.f56602m;
    }

    public boolean isDiscard() {
        return this.f56596g;
    }

    public boolean isSecure() {
        return this.f56601l;
    }

    public void setComment(String str) {
        this.f56594e = str;
    }

    public void setCommentURL(String str) {
        this.f56595f = str;
    }

    public void setDiscard(boolean z5) {
        this.f56596g = z5;
    }

    public void setDomain(String str) {
        this.f56597h = str;
    }

    public void setExpiry(long j6) {
        this.f56598i = j6;
    }

    public void setId(long j6) {
        this.f56590a = j6;
    }

    public void setName(String str) {
        this.f56592c = str;
    }

    public void setPath(String str) {
        this.f56599j = str;
    }

    public void setPortList(String str) {
        this.f56600k = str;
    }

    public void setSecure(boolean z5) {
        this.f56601l = z5;
    }

    public void setUrl(String str) {
        this.f56591b = str;
    }

    public void setValue(String str) {
        this.f56593d = str;
    }

    public void setVersion(int i6) {
        this.f56602m = i6;
    }
}
