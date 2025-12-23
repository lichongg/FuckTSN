package xyz.adscope.ad.publish.ad.unified;

import xyz.adscope.ad.l6;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class UnifiedMediaConfig extends l6.d {
    public static int AUTO_PLAY_ALWAYS = 0;
    public static int AUTO_PLAY_NEVER = 2;
    public static int AUTO_PLAY_WIFI = 1;

    /* renamed from: a, reason: collision with root package name */
    private boolean f55843a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f55844b;

    /* renamed from: c, reason: collision with root package name */
    private int f55845c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.ad.publish.ad.unified.UnifiedMediaConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private int f55846a = UnifiedMediaConfig.AUTO_PLAY_ALWAYS;

        /* renamed from: b, reason: collision with root package name */
        private boolean f55847b = false;

        /* renamed from: c, reason: collision with root package name */
        private boolean f55848c = false;

        public Builder autoPlayCondition(int i6) {
            this.f55846a = i6;
            return this;
        }

        public UnifiedMediaConfig build() {
            return new UnifiedMediaConfig(this, null);
        }

        public Builder loopPlayback(boolean z5) {
            this.f55848c = z5;
            return this;
        }

        public Builder silentPlayback(boolean z5) {
            this.f55847b = z5;
            return this;
        }
    }

    /* synthetic */ UnifiedMediaConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    @Override // xyz.adscope.ad.l6.d
    public boolean renderForUnified() {
        return true;
    }

    private UnifiedMediaConfig(Builder builder) {
        this.f55843a = false;
        this.f55844b = false;
        this.f55845c = AUTO_PLAY_ALWAYS;
        this.f55845c = builder.f55846a;
        this.f55843a = builder.f55847b;
        this.f55844b = builder.f55848c;
    }

    @Override // xyz.adscope.ad.l6.d
    public int getAutoPlayCondition() {
        return this.f55845c;
    }

    @Override // xyz.adscope.ad.l6.d
    public boolean isLoopPlayback() {
        return this.f55844b;
    }

    @Override // xyz.adscope.ad.l6.d
    public boolean isSilentPlayback() {
        return this.f55843a;
    }
}
