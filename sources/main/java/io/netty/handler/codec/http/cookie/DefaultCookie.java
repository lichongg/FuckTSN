package io.netty.handler.codec.http.cookie;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultCookie implements Cookie {
    private String domain;
    private boolean httpOnly;
    private long maxAge = Long.MIN_VALUE;
    private final String name;
    private String path;
    private boolean secure;
    private String value;
    private boolean wrap;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        if (!name().equals(cookie.name())) {
            return false;
        }
        if (path() == null) {
            if (cookie.path() != null) {
                return false;
            }
        } else if (cookie.path() == null || !path().equals(cookie.path())) {
            return false;
        }
        return domain() == null ? cookie.domain() == null : domain().equalsIgnoreCase(cookie.domain());
    }

    @Override // java.lang.Comparable
    public int compareTo(Cookie cookie) {
        int compareTo = name().compareTo(cookie.name());
        if (compareTo != 0) {
            return compareTo;
        }
        if (path() == null) {
            if (cookie.path() != null) {
                return -1;
            }
        } else {
            if (cookie.path() == null) {
                return 1;
            }
            int compareTo2 = path().compareTo(cookie.path());
            if (compareTo2 != 0) {
                return compareTo2;
            }
        }
        if (domain() == null) {
            return cookie.domain() != null ? -1 : 0;
        }
        if (cookie.domain() == null) {
            return 1;
        }
        return domain().compareToIgnoreCase(cookie.domain());
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public String domain() {
        return this.domain;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public boolean isHttpOnly() {
        return this.httpOnly;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public boolean isSecure() {
        return this.secure;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public long maxAge() {
        return this.maxAge;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public String name() {
        return this.name;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public String path() {
        return this.path;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setDomain(String str) {
        this.domain = CookieUtil.validateAttributeValue("domain", str);
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setHttpOnly(boolean z5) {
        this.httpOnly = z5;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setMaxAge(long j6) {
        this.maxAge = j6;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setPath(String str) {
        this.path = CookieUtil.validateAttributeValue("path", str);
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setSecure(boolean z5) {
        this.secure = z5;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setValue(String str) {
        this.value = (String) ObjectUtil.checkNotNull(str, "value");
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setWrap(boolean z5) {
        this.wrap = z5;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public String value() {
        return this.value;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public boolean wrap() {
        return this.wrap;
    }

    public DefaultCookie(String str, String str2) {
        String trim = ((String) ObjectUtil.checkNotNull(str, CommonNetImpl.NAME)).trim();
        if (!trim.isEmpty()) {
            this.name = trim;
            setValue(str2);
            return;
        }
        throw new IllegalArgumentException("empty name");
    }

    public int hashCode() {
        return name().hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = CookieUtil.stringBuilder();
        stringBuilder.append(name());
        stringBuilder.append('=');
        stringBuilder.append(value());
        if (domain() != null) {
            stringBuilder.append(", domain=");
            stringBuilder.append(domain());
        }
        if (path() != null) {
            stringBuilder.append(", path=");
            stringBuilder.append(path());
        }
        if (maxAge() >= 0) {
            stringBuilder.append(", maxAge=");
            stringBuilder.append(maxAge());
            stringBuilder.append('s');
        }
        if (isSecure()) {
            stringBuilder.append(", secure");
        }
        if (isHttpOnly()) {
            stringBuilder.append(", HTTPOnly");
        }
        return stringBuilder.toString();
    }

    @Deprecated
    protected String validateValue(String str, String str2) {
        return CookieUtil.validateAttributeValue(str, str2);
    }
}
