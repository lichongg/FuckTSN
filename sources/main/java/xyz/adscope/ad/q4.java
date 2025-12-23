package xyz.adscope.ad;

import android.content.Context;
import com.stub.StubApp;
import java.util.List;
import xyz.adscope.ad.e;
import xyz.adscope.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.temp.TemplateModel;
import xyz.adscope.common.v2.thread.pool.IBaseThreadPool;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class q4 extends q2 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Context f55900a;

        /* renamed from: b, reason: collision with root package name */
        private final List<TemplateModel> f55901b;

        /* synthetic */ b(Context context, List list, a aVar) {
            this(context, list);
        }

        private b(Context context, List<TemplateModel> list) {
            this.f55900a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f55901b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            m0.a().getOrCreateImplement(this.f55900a).a(this.f55901b);
        }
    }

    @Override // xyz.adscope.ad.q2
    protected void a(ConfigResponseModel configResponseModel, e.a aVar) {
        IBaseThreadPool orCreateImplement;
        if (configResponseModel == null || configResponseModel.m() == null || (orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55897a)) == null) {
            return;
        }
        orCreateImplement.executeLocalAsyncTask(new b(this.f55897a, configResponseModel.m(), null));
    }

    public q4(Context context) {
        super(context);
    }
}
