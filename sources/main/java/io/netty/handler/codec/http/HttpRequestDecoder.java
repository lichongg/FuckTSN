package io.netty.handler.codec.http;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HttpRequestDecoder extends HttpObjectDecoder {
    public HttpRequestDecoder() {
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    protected boolean isDecodingRequest() {
        return true;
    }

    public HttpRequestDecoder(int i6, int i7, int i8) {
        super(i6, i7, i8, true);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    protected HttpMessage createInvalidMessage() {
        return new DefaultFullHttpRequest(HttpVersion.HTTP_1_0, HttpMethod.GET, "/bad-request", this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    protected HttpMessage createMessage(String[] strArr) throws Exception {
        return new DefaultHttpRequest(HttpVersion.valueOf(strArr[2]), HttpMethod.valueOf(strArr[0]), strArr[1], this.validateHeaders);
    }

    public HttpRequestDecoder(int i6, int i7, int i8, boolean z5) {
        super(i6, i7, i8, true, z5);
    }

    public HttpRequestDecoder(int i6, int i7, int i8, boolean z5, int i9) {
        super(i6, i7, i8, true, z5, i9);
    }
}
