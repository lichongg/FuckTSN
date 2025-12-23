package io.netty.handler.codec.http;

import com.bytedance.pangle.provider.ContentProviderManager;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttpRequest extends DefaultHttpMessage implements HttpRequest {
    private static final int HASH_CODE_PRIME = 31;
    private HttpMethod method;
    private String uri;

    public DefaultHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String str) {
        this(httpVersion, httpMethod, str, true);
    }

    public DefaultHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String str, boolean z5) {
        super(httpVersion, z5, false);
        this.method = (HttpMethod) ObjectUtil.checkNotNull(httpMethod, "method");
        this.uri = (String) ObjectUtil.checkNotNull(str, ContentProviderManager.PROVIDER_URI);
    }

    @Override // io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.DefaultHttpObject
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttpRequest)) {
            return false;
        }
        DefaultHttpRequest defaultHttpRequest = (DefaultHttpRequest) obj;
        return method().equals(defaultHttpRequest.method()) && uri().equalsIgnoreCase(defaultHttpRequest.uri()) && super.equals(obj);
    }

    @Override // io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.DefaultHttpObject
    public int hashCode() {
        return ((((this.method.hashCode() + 31) * 31) + this.uri.hashCode()) * 31) + super.hashCode();
    }

    @Override // io.netty.handler.codec.http.HttpRequest
    public HttpMethod method() {
        return this.method;
    }

    public HttpRequest setMethod(HttpMethod httpMethod) {
        if (httpMethod == null) {
            throw new NullPointerException("method");
        }
        this.method = httpMethod;
        return this;
    }

    @Override // io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.HttpMessage, io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
    public HttpRequest setProtocolVersion(HttpVersion httpVersion) {
        super.setProtocolVersion(httpVersion);
        return this;
    }

    public HttpRequest setUri(String str) {
        if (str == null) {
            throw new NullPointerException(ContentProviderManager.PROVIDER_URI);
        }
        this.uri = str;
        return this;
    }

    public String toString() {
        return HttpMessageUtil.appendRequest(new StringBuilder(256), this).toString();
    }

    @Override // io.netty.handler.codec.http.HttpRequest
    public String uri() {
        return this.uri;
    }

    @Override // io.netty.handler.codec.http.HttpRequest
    @Deprecated
    public HttpMethod getMethod() {
        return method();
    }

    @Override // io.netty.handler.codec.http.HttpRequest
    @Deprecated
    public String getUri() {
        return uri();
    }

    public DefaultHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String str, HttpHeaders httpHeaders) {
        super(httpVersion, httpHeaders);
        this.method = (HttpMethod) ObjectUtil.checkNotNull(httpMethod, "method");
        this.uri = (String) ObjectUtil.checkNotNull(str, ContentProviderManager.PROVIDER_URI);
    }
}
