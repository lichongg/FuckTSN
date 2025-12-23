package io.netty.handler.codec.http;

import androidx.core.app.NotificationCompat;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttpResponse extends DefaultHttpMessage implements HttpResponse {
    private HttpResponseStatus status;

    public DefaultHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus) {
        this(httpVersion, httpResponseStatus, true, false);
    }

    public DefaultHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, boolean z5) {
        this(httpVersion, httpResponseStatus, z5, false);
    }

    @Override // io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.DefaultHttpObject
    public boolean equals(Object obj) {
        return (obj instanceof DefaultHttpResponse) && this.status.equals(((DefaultHttpResponse) obj).status()) && super.equals(obj);
    }

    @Override // io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.DefaultHttpObject
    public int hashCode() {
        return ((this.status.hashCode() + 31) * 31) + super.hashCode();
    }

    @Override // io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.HttpMessage, io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
    public HttpResponse setProtocolVersion(HttpVersion httpVersion) {
        super.setProtocolVersion(httpVersion);
        return this;
    }

    public HttpResponse setStatus(HttpResponseStatus httpResponseStatus) {
        if (httpResponseStatus == null) {
            throw new NullPointerException(NotificationCompat.CATEGORY_STATUS);
        }
        this.status = httpResponseStatus;
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpResponse
    public HttpResponseStatus status() {
        return this.status;
    }

    public String toString() {
        return HttpMessageUtil.appendResponse(new StringBuilder(256), this).toString();
    }

    public DefaultHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, boolean z5, boolean z6) {
        super(httpVersion, z5, z6);
        this.status = (HttpResponseStatus) ObjectUtil.checkNotNull(httpResponseStatus, NotificationCompat.CATEGORY_STATUS);
    }

    @Override // io.netty.handler.codec.http.HttpResponse
    @Deprecated
    public HttpResponseStatus getStatus() {
        return status();
    }

    public DefaultHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, HttpHeaders httpHeaders) {
        super(httpVersion, httpHeaders);
        this.status = (HttpResponseStatus) ObjectUtil.checkNotNull(httpResponseStatus, NotificationCompat.CATEGORY_STATUS);
    }
}
