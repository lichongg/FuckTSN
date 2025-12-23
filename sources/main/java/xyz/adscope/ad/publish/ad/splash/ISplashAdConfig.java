package xyz.adscope.ad.publish.ad.splash;

import xyz.adscope.ad.a2;
import xyz.adscope.ad.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class ISplashAdConfig extends a2 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.ad.publish.ad.splash.ISplashAdConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder extends a2.a<ISplashAdConfig> {
        @Override // xyz.adscope.ad.a2.a
        protected c a() {
            return c.SPLASH;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // xyz.adscope.ad.a2.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public ISplashAdConfig f(a2.a<ISplashAdConfig> aVar) {
            return new ISplashAdConfig(this, null);
        }

        @Override // xyz.adscope.ad.a2.a
        public a2.a<ISplashAdConfig> setExpressSizePixel(float f6, float f7) {
            return (Builder) super.setExpressSizePixel(f6, f7);
        }

        @Override // xyz.adscope.ad.a2.a
        public a2.a<ISplashAdConfig> setTimeoutMillion(long j6) {
            return (Builder) super.setTimeoutMillion(j6);
        }
    }

    /* synthetic */ ISplashAdConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ISplashAdConfig(Builder builder) {
        super(builder);
    }
}
