package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.TimeUnit;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.DisplayModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.event.EventModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.report.ReportModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.report.rule.RuleModel;
import xyz.adscope.ad.y1;
import xyz.adscope.common.v2.conn.IBaseSimpleRequest;
import xyz.adscope.common.v2.conn.http.RequestMethod;
import xyz.adscope.common.v2.thread.pool.IBaseThreadPool;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;
import xyz.adscope.common.v2.tool.collection.CollectionFetch;
import xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare;
import xyz.adscope.common.v2.tool.str.RegexUtil;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
final class t4 {

    /* renamed from: a, reason: collision with root package name */
    private final IBaseSimpleRequest f55964a;

    /* renamed from: b, reason: collision with root package name */
    private Context f55965b;

    /* renamed from: c, reason: collision with root package name */
    private ReportModel f55966c;

    /* renamed from: d, reason: collision with root package name */
    private List<EventModel> f55967d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f55968e = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ICollectionFetchCompare<RuleModel, l2> {
        @Override // xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean fetch(RuleModel ruleModel, l2 l2Var) {
            return (ruleModel == null || l2Var == null || l2Var.getEventCode() != ruleModel.e()) ? false : true;
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements ICollectionFetchCompare<EventModel, l2> {
        @Override // xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean fetch(EventModel eventModel, l2 l2Var) {
            return (eventModel == null || l2Var == null || eventModel.b() != l2Var.getEventCode()) ? false : true;
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private final b1 f55971a;

        /* synthetic */ c(b1 b1Var, a aVar) {
            this(b1Var);
        }

        private c(b1 b1Var) {
            this.f55971a = b1Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            b1 b1Var = this.f55971a;
            if (b1Var != null) {
                b1Var.a(-1);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final s4 f55972a;

        /* renamed from: b, reason: collision with root package name */
        private final String f55973b;

        /* renamed from: c, reason: collision with root package name */
        private final w1 f55974c;

        /* renamed from: d, reason: collision with root package name */
        private final RequestMethod f55975d;

        /* renamed from: e, reason: collision with root package name */
        private c f55976e;

        /* synthetic */ d(Context context, String str, int i6, l2 l2Var, b1 b1Var, a aVar) {
            this(context, str, i6, l2Var, b1Var);
        }

        private d(Context context, String str, int i6, l2 l2Var, b1 b1Var) {
            this.f55972a = a0.a(context, l2Var, b1Var);
            this.f55973b = str;
            this.f55975d = i6 == 0 ? RequestMethod.GET : RequestMethod.POST;
            this.f55974c = h0.a().getOrCreateImplement(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar) {
            this.f55976e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.f55973b)) {
                String replaceMacros = RegexUtil.replaceMacros(this.f55973b, this.f55972a.getMacrosReplaceMap());
                if (RequestMethod.POST == this.f55975d) {
                    this.f55974c.a(replaceMacros.substring(0, replaceMacros.indexOf("?")), replaceMacros.substring(replaceMacros.indexOf("?") + 1), null);
                } else {
                    this.f55974c.a(replaceMacros, null);
                }
            }
            c cVar = this.f55976e;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public void a(DisplayModel displayModel) {
        if (displayModel != null) {
            this.f55966c = displayModel.e();
            this.f55967d = displayModel.a();
            this.f55968e = true;
        }
    }

    private List<EventModel> b(l2 l2Var) {
        List<EventModel> list = this.f55967d;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return CollectionFetch.fetchAllFromList(this.f55967d, l2Var, new b());
    }

    t4(Context context) {
        this.f55965b = context;
        this.f55964a = new IBaseSimpleRequest(context, true);
    }

    boolean a() {
        return this.f55968e;
    }

    public void a(l2 l2Var, b1 b1Var) {
        int d6;
        List<EventModel> b6 = b(l2Var);
        if (b6 == null || b6.isEmpty()) {
            return;
        }
        IBaseThreadPool orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55965b);
        int a6 = a(l2Var);
        y1.a aVar = y1.a.AD_CLICK;
        if (l2Var == aVar) {
            a(b1Var, a6);
        }
        if (l2Var.getEventCode() > aVar.getEventCode() && b1Var != null && (d6 = b1Var.d()) > 0 && a6 < d6) {
            a6 = d6;
        }
        for (EventModel eventModel : b6) {
            l2 l2Var2 = l2Var;
            d dVar = new d(this.f55965b, eventModel.c(), eventModel.a(), l2Var2, b1Var.deepCopy(), null);
            if (l2Var2 == y1.a.AD_CLICK) {
                dVar.a(new c(b1Var, null));
            }
            orCreateImplement.scheduleAsyncTask(dVar, a6, TimeUnit.MILLISECONDS);
            l2Var = l2Var2;
        }
    }

    private void a(b1 b1Var, int i6) {
        if (b1Var != null) {
            b1Var.a(i6);
        }
    }

    private int a(l2 l2Var) {
        RuleModel ruleModel;
        ReportModel reportModel = this.f55966c;
        if (reportModel == null || reportModel.b() == null || (ruleModel = (RuleModel) CollectionFetch.fetchFirstFromList(this.f55966c.b(), l2Var, new a())) == null) {
            return 0;
        }
        String c6 = ruleModel.c();
        int parseInt = TextUtils.isEmpty(c6) ? 0 : StringUtil.parseInt(c6);
        return ruleModel.d() > 0 ? parseInt + ((int) (Math.random() * ruleModel.d())) + 1 : parseInt;
    }
}
