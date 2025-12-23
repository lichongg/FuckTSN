package xyz.adscope.ad;

import xyz.adscope.common.v2.conn.IHttpRequestError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public enum q5 implements IHttpRequestError {
    ERROR_INVALID_URL(1, "url invalid"),
    ERROR_NULL_MODEL_BUILD(2, "model builder is null"),
    ERROR_EMPTY_CONTENT(3, "request content is null");


    /* renamed from: a, reason: collision with root package name */
    private final int f55906a;

    /* renamed from: b, reason: collision with root package name */
    private final String f55907b;

    @Override // xyz.adscope.common.v2.conn.IHttpRequestError
    public int getErrorCode() {
        return this.f55906a;
    }

    @Override // xyz.adscope.common.v2.conn.IHttpRequestError
    public String getErrorMessage() {
        return this.f55907b;
    }

    q5(int i6, String str) {
        this.f55906a = i6;
        this.f55907b = str;
    }
}
