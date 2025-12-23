package xyz.adscope.ad;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import xyz.adscope.ad.model.impl.db.StrategyEventDBModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.StrategyFilterModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.frequency.StrategyFrequencyModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class v6 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f56026a;

    /* renamed from: b, reason: collision with root package name */
    private final String f56027b;

    /* renamed from: c, reason: collision with root package name */
    private final String f56028c;

    public boolean a(StrategyFilterModel strategyFilterModel) {
        List<StrategyFrequencyModel> b6;
        if (strategyFilterModel == null || (b6 = strategyFilterModel.b()) == null || b6.isEmpty()) {
            return false;
        }
        for (StrategyFrequencyModel strategyFrequencyModel : b6) {
            LinkedList<StrategyEventDBModel> b7 = k0.a().getOrCreateImplement(this.f56026a).b(this.f56028c, strategyFrequencyModel.b());
            long c6 = strategyFrequencyModel.c();
            long[] a6 = strategyFrequencyModel.a();
            int count = strategyFrequencyModel.getCount();
            if (b7 != null && b7.size() >= count) {
                if (a(c6, b7, count)) {
                    return true;
                }
                return a(a6, b7);
            }
        }
        return false;
    }

    public v6(Context context, String str, String str2) {
        this.f56026a = context;
        this.f56027b = str;
        this.f56028c = str2;
    }

    private boolean a(long[] jArr, LinkedList<StrategyEventDBModel> linkedList) {
        return jArr != null && jArr.length > 1 && a(jArr) && linkedList.getLast().b() > jArr[0];
    }

    private boolean a(long j6, LinkedList<StrategyEventDBModel> linkedList, int i6) {
        return j6 > 0 && linkedList.get(linkedList.size() - i6).b() + j6 > System.currentTimeMillis();
    }

    private boolean a(long[] jArr) {
        long currentTimeMillis = System.currentTimeMillis();
        return jArr[0] <= currentTimeMillis && currentTimeMillis <= jArr[1];
    }
}
