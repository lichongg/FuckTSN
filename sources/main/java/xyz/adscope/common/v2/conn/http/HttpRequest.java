package xyz.adscope.common.v2.conn.http;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class HttpRequest implements IRequest {
    private final boolean isAutoRedirected;
    private final CommonHeader mHeader;
    private final RequestMethod mMethod;
    private final byte[] mRequestBody;
    private final String mRequestUrl;

    HttpRequest(String str, RequestMethod requestMethod, byte[] bArr, CommonHeader commonHeader, boolean z5) {
        this.mRequestUrl = str;
        this.mMethod = requestMethod;
        this.mRequestBody = bArr;
        this.mHeader = commonHeader;
        this.isAutoRedirected = z5;
    }

    @Override // xyz.adscope.common.v2.conn.http.IRequest
    public CommonHeader getHeader() {
        return this.mHeader;
    }

    @Override // xyz.adscope.common.v2.conn.http.IRequest
    public byte[] getRequestBodyBytes() {
        return this.mRequestBody;
    }

    @Override // xyz.adscope.common.v2.conn.http.IRequest
    public RequestMethod getRequestMethod() {
        return this.mMethod;
    }

    @Override // xyz.adscope.common.v2.conn.http.IRequest
    public String getRequestURL() {
        return this.mRequestUrl;
    }

    @Override // xyz.adscope.common.v2.conn.http.IRequest
    public boolean isAutoRedirected() {
        return this.isAutoRedirected;
    }

    public HttpRequest(String str, IRequest iRequest) {
        this.mRequestUrl = str;
        this.mHeader = iRequest.getHeader();
        this.mMethod = iRequest.getRequestMethod();
        this.mRequestBody = new byte[0];
        this.isAutoRedirected = iRequest.isAutoRedirected();
    }
}
