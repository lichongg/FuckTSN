package xyz.adscope.ad;

import java.util.List;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.DisplayModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.report.ReportModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.report.rule.RuleModel;
import xyz.adscope.ad.u1;
import xyz.adscope.common.v2.tool.collection.CollectionFetch;
import xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare;
import xyz.adscope.common.v2.tool.roll.RandomProbability;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class y implements u1 {

    /* renamed from: a, reason: collision with root package name */
    private ReportModel f56138a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ICollectionFetchCompare<RuleModel, l2> {
        @Override // xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean fetch(RuleModel ruleModel, l2 l2Var) {
            return (ruleModel == null || l2Var == null || ruleModel.e() != l2Var.getEventCode()) ? false : true;
        }

        a() {
        }
    }

    @Override // xyz.adscope.ad.u1
    public void a(DisplayModel displayModel) {
        this.f56138a = b(displayModel);
    }

    private ReportModel b(DisplayModel displayModel) {
        if (displayModel != null) {
            return displayModel.e();
        }
        return null;
    }

    @Override // xyz.adscope.ad.u1
    public void a(l2 l2Var, b1 b1Var, u1.a aVar) {
        List<RuleModel> b6;
        RuleModel ruleModel;
        ReportModel reportModel = this.f56138a;
        if (reportModel != null && b1Var != null && (b6 = reportModel.b()) != null && !b6.isEmpty() && (ruleModel = (RuleModel) CollectionFetch.fetchFirstFromList(b6, l2Var, new a())) != null) {
            if (!a(ruleModel, b1Var)) {
                return;
            }
            aVar.b();
            if (!a(ruleModel)) {
                return;
            }
        }
        aVar.b();
        aVar.a();
    }

    y() {
    }

    private boolean a(RuleModel ruleModel, b1 b1Var) {
        return System.currentTimeMillis() - b1Var.l() >= ((long) ruleModel.a());
    }

    private boolean a(RuleModel ruleModel) {
        return ruleModel.b() == 0 || RandomProbability.roll(ruleModel.b());
    }
}
