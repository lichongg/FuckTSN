package xyz.adscope.common.v2.conn.http;

import xyz.adscope.common.v2.conn.IHttpRequestError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class NetworkError implements IHttpRequestError {
    private final int mCode;
    private final String mError;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum DEFAULT implements IHttpRequestError {
        ERROR_UNEXPECTED(-99, "error unexpected"),
        ERROR_METHOD(504, "request method error"),
        ERROR_REDIRECT_LOOP(-97, "error redirect loop"),
        ERROR_INVALID_URL(-98, "error invalid request url");

        private final int mCode;
        private final String mError;

        @Override // xyz.adscope.common.v2.conn.IHttpRequestError
        public int getErrorCode() {
            return this.mCode;
        }

        @Override // xyz.adscope.common.v2.conn.IHttpRequestError
        public String getErrorMessage() {
            return this.mError;
        }

        DEFAULT(int i6, String str) {
            this.mCode = i6;
            this.mError = str;
        }
    }

    @Override // xyz.adscope.common.v2.conn.IHttpRequestError
    public int getErrorCode() {
        return this.mCode;
    }

    @Override // xyz.adscope.common.v2.conn.IHttpRequestError
    public String getErrorMessage() {
        return this.mError;
    }

    public NetworkError(int i6, String str) {
        this.mCode = i6;
        this.mError = str;
    }
}
