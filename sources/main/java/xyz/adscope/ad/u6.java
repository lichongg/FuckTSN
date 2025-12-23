package xyz.adscope.ad;

import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.StrategyFilterModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class u6 {

    /* renamed from: a, reason: collision with root package name */
    private long f56011a = 0;

    public void a(long j6) {
        this.f56011a = j6;
    }

    public boolean a(StrategyFilterModel strategyFilterModel) {
        return strategyFilterModel != null && this.f56011a <= ((long) strategyFilterModel.c());
    }
}
