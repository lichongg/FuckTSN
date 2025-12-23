package io.netty.handler.codec.http;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HttpResponseDecoder extends HttpObjectDecoder {
    private static final HttpResponseStatus UNKNOWN_STATUS = new HttpResponseStatus(999, "Unknown");

    public HttpResponseDecoder() {
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    protected boolean isDecodingRequest() {
        return false;
    }

    public HttpResponseDecoder(int i6, int i7, int i8) {
        super(i6, i7, i8, true);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    protected HttpMessage createInvalidMessage() {
        return new DefaultFullHttpResponse(HttpVersion.HTTP_1_0, UNKNOWN_STATUS, this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    protected HttpMessage createMessage(String[] strArr) {
        return new DefaultHttpResponse(HttpVersion.valueOf(strArr[0]), HttpResponseStatus.valueOf(Integer.parseInt(strArr[1]), strArr[2]), this.validateHeaders);
    }

    public HttpResponseDecoder(int i6, int i7, int i8, boolean z5) {
        super(i6, i7, i8, true, z5);
    }

    public HttpResponseDecoder(int i6, int i7, int i8, boolean z5, int i9) {
        super(i6, i7, i8, true, z5, i9);
    }
}
