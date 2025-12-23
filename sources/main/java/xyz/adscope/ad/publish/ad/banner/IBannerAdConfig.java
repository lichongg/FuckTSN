package xyz.adscope.ad.publish.ad.banner;

import xyz.adscope.ad.a2;
import xyz.adscope.ad.c;
import xyz.adscope.ad.u3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class IBannerAdConfig extends a2 implements u3 {

    /* renamed from: g, reason: collision with root package name */
    private final long f55840g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.ad.publish.ad.banner.IBannerAdConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder extends a2.a<IBannerAdConfig> {

        /* renamed from: f, reason: collision with root package name */
        private long f55841f;

        public Builder setIntervalSec(int i6) {
            this.f55841f = i6 * 1000;
            return this;
        }

        @Override // xyz.adscope.ad.a2.a
        protected c a() {
            return c.BANNER;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // xyz.adscope.ad.a2.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public IBannerAdConfig f(a2.a<IBannerAdConfig> aVar) {
            return new IBannerAdConfig(this, null);
        }

        @Override // xyz.adscope.ad.a2.a
        public a2.a<IBannerAdConfig> setExpressSizePixel(float f6, float f7) {
            return (Builder) super.setExpressSizePixel(f6, f7);
        }

        @Override // xyz.adscope.ad.a2.a
        public a2.a<IBannerAdConfig> setTimeoutMillion(long j6) {
            return (Builder) super.setTimeoutMillion(j6);
        }
    }

    /* synthetic */ IBannerAdConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private IBannerAdConfig(Builder builder) {
        super(builder);
        this.f55840g = builder.f55841f;
    }

    @Override // xyz.adscope.ad.u3
    public long getIntervalMillion() {
        return this.f55840g;
    }
}
