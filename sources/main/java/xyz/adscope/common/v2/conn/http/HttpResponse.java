package xyz.adscope.common.v2.conn.http;

import xyz.adscope.common.v2.conn.IBaseHttpResponse;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class HttpResponse implements IBaseHttpResponse {
    private final int mCode;
    private final String mResult;

    @Override // xyz.adscope.common.v2.conn.IBaseHttpResponse
    public int getResponseCode() {
        return this.mCode;
    }

    @Override // xyz.adscope.common.v2.conn.IBaseHttpResponse
    public String getResponseResult() {
        return this.mResult;
    }

    public HttpResponse(int i6, String str) {
        this.mCode = i6;
        this.mResult = str;
    }
}
