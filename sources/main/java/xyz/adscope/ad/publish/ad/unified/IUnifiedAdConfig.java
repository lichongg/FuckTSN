package xyz.adscope.ad.publish.ad.unified;

import xyz.adscope.ad.a2;
import xyz.adscope.ad.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class IUnifiedAdConfig extends a2 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder extends a2.a<IUnifiedAdConfig> {
        @Override // xyz.adscope.ad.a2.a
        protected c a() {
            return c.UNIFIED;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // xyz.adscope.ad.a2.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public IUnifiedAdConfig f(a2.a<IUnifiedAdConfig> aVar) {
            return new IUnifiedAdConfig(this);
        }

        @Override // xyz.adscope.ad.a2.a
        public a2.a<IUnifiedAdConfig> setAdCount(int i6) {
            return (Builder) super.setAdCount(i6);
        }

        @Override // xyz.adscope.ad.a2.a
        public a2.a<IUnifiedAdConfig> setExpressSizePixel(float f6, float f7) {
            return (Builder) super.setExpressSizePixel(f6, f7);
        }

        @Override // xyz.adscope.ad.a2.a
        public a2.a<IUnifiedAdConfig> setTimeoutMillion(long j6) {
            return (Builder) super.setTimeoutMillion(j6);
        }
    }

    protected IUnifiedAdConfig(Builder builder) {
        super(builder);
    }
}
