package xyz.adscope.common.network;

import java.io.Closeable;
import xyz.adscope.common.network.util.IOUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class Response implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final int f56531a;

    /* renamed from: b, reason: collision with root package name */
    private final Headers f56532b;

    /* renamed from: c, reason: collision with root package name */
    private final ResponseBody f56533c;

    /* renamed from: d, reason: collision with root package name */
    private final String f56534d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.Response$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private int f56535a;

        /* renamed from: b, reason: collision with root package name */
        private Headers f56536b;

        /* renamed from: c, reason: collision with root package name */
        private ResponseBody f56537c;

        /* renamed from: d, reason: collision with root package name */
        private String f56538d;

        public Builder body(ResponseBody responseBody) {
            this.f56537c = responseBody;
            return this;
        }

        public Response build() {
            return new Response(this, null);
        }

        public Builder code(int i6) {
            this.f56535a = i6;
            return this;
        }

        public Builder headers(Headers headers) {
            this.f56536b = headers;
            return this;
        }

        public Builder locationUrl(String str) {
            this.f56538d = str;
            return this;
        }
    }

    /* synthetic */ Response(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private Response(Builder builder) {
        this.f56531a = builder.f56535a;
        this.f56532b = builder.f56536b;
        this.f56533c = builder.f56537c;
        this.f56534d = builder.f56538d;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public ResponseBody body() {
        return this.f56533c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IOUtils.closeQuietly(this.f56533c);
    }

    public int code() {
        return this.f56531a;
    }

    public Headers headers() {
        return this.f56532b;
    }

    public boolean isRedirect() {
        int i6 = this.f56531a;
        if (i6 == 307 || i6 == 308) {
            return true;
        }
        switch (i6) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public String locationUrl() {
        return this.f56534d;
    }
}
