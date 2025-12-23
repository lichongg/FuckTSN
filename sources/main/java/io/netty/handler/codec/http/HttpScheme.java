package io.netty.handler.codec.http;

import io.netty.util.AsciiString;
import master.flame.danmaku.danmaku.parser.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class HttpScheme {
    public static final HttpScheme HTTP = new HttpScheme(80, b.f50154a);
    public static final HttpScheme HTTPS = new HttpScheme(443, b.f50155b);
    private final AsciiString name;
    private final int port;

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpScheme)) {
            return false;
        }
        HttpScheme httpScheme = (HttpScheme) obj;
        return httpScheme.port() == this.port && httpScheme.name().equals(this.name);
    }

    public int hashCode() {
        return (this.port * 31) + this.name.hashCode();
    }

    public AsciiString name() {
        return this.name;
    }

    public int port() {
        return this.port;
    }

    public String toString() {
        return this.name.toString();
    }

    private HttpScheme(int i6, String str) {
        this.port = i6;
        this.name = AsciiString.cached(str);
    }
}
