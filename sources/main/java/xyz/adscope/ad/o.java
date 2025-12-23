package xyz.adscope.ad;

import com.qq.e.comm.constants.ErrorCode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public enum o {
    INIT_DONE(1, "init success"),
    ALREADY_INIT(2, "already_init"),
    ERROR_CONFIG_PARSE_FAIL(1003, "config parse fail"),
    ERROR_CONFIG_RESPONSE_ERROR(1004, "config response error"),
    ERROR_CONFIG_APP_ID(1005, "config app id error"),
    ERROR_INIT_WITH_DIFFERENT_APP_ID(1006, "init with different app id"),
    ERROR_CONFIG_REQUEST_TIMEOUT(1007, "request timeout"),
    ERROR_UNEXPECTED(1009, "error unexpected"),
    ERROR_SDK_SUPPORT_CLASS_MISSED(ErrorCode.PrivateError.LOAD_FAIL, "sdk support class missed, please check all necessary aar has implemented...");


    /* renamed from: a, reason: collision with root package name */
    private final int f55743a;

    /* renamed from: b, reason: collision with root package name */
    private final String f55744b;

    public int b() {
        return this.f55743a;
    }

    public String c() {
        return this.f55744b;
    }

    o(int i6, String str) {
        this.f55744b = str;
        this.f55743a = i6;
    }
}
