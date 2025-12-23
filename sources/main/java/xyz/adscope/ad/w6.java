package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.StrategyFilterModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.unite.UniteControlModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class w6 {

    /* renamed from: a, reason: collision with root package name */
    private final String f56063a = "asnp_ad_%s_common";

    /* renamed from: b, reason: collision with root package name */
    private final String f56064b = "%s_unite";

    /* renamed from: c, reason: collision with root package name */
    private final Context f56065c;

    /* renamed from: d, reason: collision with root package name */
    private final String f56066d;

    /* renamed from: e, reason: collision with root package name */
    private long f56067e;

    public boolean a(StrategyFilterModel strategyFilterModel) {
        UniteControlModel e6 = strategyFilterModel.e();
        if (e6 != null) {
            int b6 = e6.b();
            long a6 = e6.a();
            long a7 = a();
            long currentTimeMillis = System.currentTimeMillis() - a7;
            if (a7 > 0 && a6 > 0 && currentTimeMillis < a6 && b6 < this.f56067e && b6 != 100) {
                return true;
            }
        }
        return false;
    }

    public void b(long j6) {
        this.f56067e = j6;
    }

    public w6(Context context, String str) {
        this.f56065c = context;
        this.f56066d = str;
    }

    public void a(long j6) {
        i0.b(this.f56065c, String.format("asnp_ad_%s_common", this.f56066d), String.format("%s_unite", this.f56066d), j6);
    }

    private long a() {
        return i0.a(this.f56065c, String.format("asnp_ad_%s_common", this.f56066d), String.format("%s_unite", this.f56066d), 0L);
    }
}
