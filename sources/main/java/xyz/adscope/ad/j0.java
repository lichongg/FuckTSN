package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.e;
import xyz.adscope.ad.model.impl.db.StrategyEventDBModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.StrategyFilterModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.frequency.StrategyFrequencyModel;
import xyz.adscope.amps.report.AMPSReportConstants;
import xyz.adscope.common.analyse.model.impl.HistoryDbModel;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f55259a;

    /* renamed from: b, reason: collision with root package name */
    private final h f55260b;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, LinkedList<StrategyEventDBModel>> f55262d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, StrategyFilterModel> f55263e = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final e f55261c = new e(this, null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(j0 j0Var, a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            int queryNumEntries = j0.this.f55260b.queryNumEntries(StrategyEventDBModel.class);
            if (queryNumEntries > 1000) {
                long[] queryPrimerByDeleteCount = j0.this.f55260b.queryPrimerByDeleteCount(StrategyEventDBModel.class, queryNumEntries / 2);
                if (queryPrimerByDeleteCount == null || queryPrimerByDeleteCount.length <= 0) {
                    return;
                }
                j0.this.f55260b.deleteBetweenPrimaryKey(StrategyEventDBModel.class, queryPrimerByDeleteCount);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final StrategyEventDBModel f55265a;

        /* synthetic */ c(j0 j0Var, StrategyEventDBModel strategyEventDBModel, a aVar) {
            this(strategyEventDBModel);
        }

        private c(StrategyEventDBModel strategyEventDBModel) {
            this.f55265a = strategyEventDBModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.f55260b.insert(this.f55265a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class d implements Runnable {
        private d() {
        }

        /* synthetic */ d(j0 j0Var, a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            List<StrategyEventDBModel> query = j0.this.f55260b.query(StrategyEventDBModel.class, j0.this.f55260b.whereEquals(HistoryDbModel.COLUMN_API_KEY), new String[]{f0.a()}, j0.this.f55260b.getOrderByAsc(AMPSReportConstants.EVENT_TIME_KEY), -1);
            if (query != null) {
                for (StrategyEventDBModel strategyEventDBModel : query) {
                    j0.this.a(strategyEventDBModel.c(), strategyEventDBModel.a(), strategyEventDBModel);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class e implements d3 {
        private e() {
        }

        @Override // xyz.adscope.ad.d3
        public void a(ConfigResponseModel configResponseModel, e.a aVar, boolean z5) {
            if (configResponseModel != null) {
                j0.this.f55263e.clear();
                j0.this.f55263e.putAll(a(configResponseModel.e()));
            }
            j0.this.b();
        }

        /* synthetic */ e(j0 j0Var, a aVar) {
            this();
        }

        private Map<String, StrategyFilterModel> a(List<StrategyFilterModel> list) {
            HashMap hashMap = new HashMap();
            if (list != null && !list.isEmpty()) {
                for (StrategyFilterModel strategyFilterModel : list) {
                    hashMap.put(strategyFilterModel.d(), strategyFilterModel);
                }
            }
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55259a).executeLocalAsyncTask(new b(this, null));
    }

    public void c() {
        f.a().getOrCreateImplement(this.f55259a).a(this.f55261c);
        a();
    }

    j0(Context context) {
        this.f55259a = context;
        this.f55260b = i.a().getOrCreateImplement(context);
    }

    public synchronized void a(String str, n1 n1Var) {
        if (!TextUtils.isEmpty(str) && n1Var != null && a(str)) {
            StrategyEventDBModel strategyEventDBModel = new StrategyEventDBModel();
            strategyEventDBModel.a(f0.a());
            strategyEventDBModel.b(n1Var.getEventCode());
            strategyEventDBModel.c(System.currentTimeMillis() + "");
            strategyEventDBModel.d(str);
            a(str, n1Var.getEventCode(), strategyEventDBModel);
            a(strategyEventDBModel);
        }
    }

    public synchronized LinkedList<StrategyEventDBModel> b(String str, String str2) {
        Map<String, LinkedList<StrategyEventDBModel>> map = this.f55262d;
        if (map == null) {
            return null;
        }
        return map.get(a(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, StrategyEventDBModel strategyEventDBModel) {
        String a6 = a(str, str2);
        if (this.f55262d == null) {
            this.f55262d = new HashMap();
        }
        LinkedList<StrategyEventDBModel> linkedList = this.f55262d.get(a6);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        linkedList.addFirst(strategyEventDBModel);
        this.f55262d.put(a6, linkedList);
    }

    private void a(StrategyEventDBModel strategyEventDBModel) {
        ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55259a).executeLocalAsyncTask(new c(this, strategyEventDBModel, null));
        a(strategyEventDBModel.c(), strategyEventDBModel.a(), strategyEventDBModel);
    }

    private String a(String str, String str2) {
        return String.format("HS_%s_%s", str, str2);
    }

    private void a() {
        ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55259a).executeLocalAsyncTask(new d(this, null));
    }

    private boolean a(String str) {
        StrategyFilterModel strategyFilterModel;
        List<StrategyFrequencyModel> b6;
        return (!this.f55263e.containsKey(str) || (strategyFilterModel = this.f55263e.get(str)) == null || (b6 = strategyFilterModel.b()) == null || b6.isEmpty()) ? false : true;
    }
}
