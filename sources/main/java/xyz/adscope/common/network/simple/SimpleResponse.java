package xyz.adscope.common.network.simple;

import xyz.adscope.common.network.Headers;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class SimpleResponse<Succeed, Failed> {

    /* renamed from: a, reason: collision with root package name */
    private final int f56695a;

    /* renamed from: b, reason: collision with root package name */
    private final Headers f56696b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f56697c;

    /* renamed from: d, reason: collision with root package name */
    private final Succeed f56698d;

    /* renamed from: e, reason: collision with root package name */
    private final Failed f56699e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.simple.SimpleResponse$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder<Succeed, Failed> {

        /* renamed from: a, reason: collision with root package name */
        private int f56700a;

        /* renamed from: b, reason: collision with root package name */
        private Headers f56701b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f56702c;

        /* renamed from: d, reason: collision with root package name */
        private Failed f56703d;

        /* renamed from: e, reason: collision with root package name */
        private Succeed f56704e;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
        }

        public SimpleResponse<Succeed, Failed> build() {
            return new SimpleResponse<>(this, null);
        }

        public Builder<Succeed, Failed> code(int i6) {
            this.f56700a = i6;
            return this;
        }

        public Builder<Succeed, Failed> failed(Failed failed) {
            this.f56703d = failed;
            return this;
        }

        public Builder<Succeed, Failed> fromCache(boolean z5) {
            this.f56702c = z5;
            return this;
        }

        public Builder<Succeed, Failed> headers(Headers headers) {
            this.f56701b = headers;
            return this;
        }

        public Builder<Succeed, Failed> succeed(Succeed succeed) {
            this.f56704e = succeed;
            return this;
        }
    }

    /* synthetic */ SimpleResponse(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private SimpleResponse(Builder<Succeed, Failed> builder) {
        this.f56695a = ((Builder) builder).f56700a;
        this.f56696b = ((Builder) builder).f56701b;
        this.f56697c = ((Builder) builder).f56702c;
        this.f56698d = (Succeed) ((Builder) builder).f56704e;
        this.f56699e = (Failed) ((Builder) builder).f56703d;
    }

    public static <Succeed, Failed> Builder<Succeed, Failed> newBuilder() {
        return new Builder<>(null);
    }

    public int code() {
        return this.f56695a;
    }

    public Failed failed() {
        return this.f56699e;
    }

    public boolean fromCache() {
        return this.f56697c;
    }

    public Headers headers() {
        return this.f56696b;
    }

    public boolean isSucceed() {
        return this.f56699e == null || this.f56698d != null;
    }

    public Succeed succeed() {
        return this.f56698d;
    }
}
