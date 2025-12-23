package xyz.adscope.ad.publish.ad.video;

import xyz.adscope.ad.a2;
import xyz.adscope.ad.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class IRewardVideoConfig extends a2 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.ad.publish.ad.video.IRewardVideoConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder extends a2.a<IRewardVideoConfig> {
        @Override // xyz.adscope.ad.a2.a
        protected c a() {
            return c.VIDEO;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // xyz.adscope.ad.a2.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public IRewardVideoConfig f(a2.a<IRewardVideoConfig> aVar) {
            return new IRewardVideoConfig(this, null);
        }

        @Override // xyz.adscope.ad.a2.a
        public a2.a<IRewardVideoConfig> setTimeoutMillion(long j6) {
            return (Builder) super.setTimeoutMillion(j6);
        }
    }

    /* synthetic */ IRewardVideoConfig(a2.a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    private IRewardVideoConfig(a2.a<IRewardVideoConfig> aVar) {
        super(aVar);
    }
}
