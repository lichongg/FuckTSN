package io.netty.handler.codec.http.cookie;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Cookie extends Comparable<Cookie> {
    public static final long UNDEFINED_MAX_AGE = Long.MIN_VALUE;

    String domain();

    boolean isHttpOnly();

    boolean isSecure();

    long maxAge();

    String name();

    String path();

    void setDomain(String str);

    void setHttpOnly(boolean z5);

    void setMaxAge(long j6);

    void setPath(String str);

    void setSecure(boolean z5);

    void setValue(String str);

    void setWrap(boolean z5);

    String value();

    boolean wrap();
}
