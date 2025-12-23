package xyz.adscope.common.network;

import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public enum RequestMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    HEAD("HEAD"),
    PATCH("PATCH"),
    OPTIONS("OPTIONS"),
    TRACE("TRACE");


    /* renamed from: a, reason: collision with root package name */
    private final String f56529a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.RequestMethod$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f56530a;

        static {
            int[] iArr = new int[RequestMethod.values().length];
            f56530a = iArr;
            try {
                iArr[RequestMethod.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56530a[RequestMethod.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f56530a[RequestMethod.PATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f56530a[RequestMethod.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static RequestMethod reverse(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        upperCase.getClass();
        switch (upperCase) {
            case "OPTIONS":
                return OPTIONS;
            case "GET":
                return GET;
            case "PUT":
                return PUT;
            case "HEAD":
                return HEAD;
            case "POST":
                return POST;
            case "PATCH":
                return PATCH;
            case "TRACE":
                return TRACE;
            case "DELETE":
                return DELETE;
            default:
                return GET;
        }
    }

    public boolean allowBody() {
        int i6 = AnonymousClass1.f56530a[ordinal()];
        return i6 == 1 || i6 == 2 || i6 == 3 || i6 == 4;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f56529a;
    }

    RequestMethod(String str) {
        this.f56529a = str;
    }
}
