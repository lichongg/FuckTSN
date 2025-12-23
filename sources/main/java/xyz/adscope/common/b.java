package xyz.adscope.common;

import android.content.Context;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.amps.report.AMPSReportConstants;
import xyz.adscope.common.analyse2.db.AnalyseEventDBModel;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.persistent.db.IBaseDBOperator;
import xyz.adscope.common.v2.tool.date.DateUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final IBaseDBOperator f56286a;

    /* renamed from: b, reason: collision with root package name */
    private final h f56287b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f56288c;

    private void a() {
        if (this.f56286a != null) {
            long timeMillisBeforeDay = DateUtil.getTimeMillisBeforeDay(3);
            SDKLog.d("AnalyseDBHistoryTask", "删除过期的日志... 共计: " + this.f56286a.deleteLessThenWhere(AnalyseEventDBModel.class, AMPSReportConstants.EVENT_TIME_KEY, timeMillisBeforeDay + ""));
        }
    }

    private List<AnalyseEventDBModel> b() {
        IBaseDBOperator iBaseDBOperator = this.f56286a;
        if (iBaseDBOperator == null) {
            return null;
        }
        List<AnalyseEventDBModel> query = iBaseDBOperator.query(AnalyseEventDBModel.class, iBaseDBOperator.getOrderByAsc(AMPSReportConstants.EVENT_TIME_KEY));
        StringBuilder sb = new StringBuilder();
        sb.append("从数据库查询数据...");
        sb.append(query != null ? Integer.valueOf(query.size()) : " 历史数据为空...");
        SDKLog.d("AnalyseDBHistoryTask", sb.toString());
        return query;
    }

    b(Context context, IBaseDBOperator iBaseDBOperator, h hVar) {
        this.f56288c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f56287b = hVar;
        this.f56286a = iBaseDBOperator;
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
        List<AnalyseEventDBModel> b6 = b();
        if (b6 != null && !b6.isEmpty()) {
            Iterator<AnalyseEventDBModel> it = b6.iterator();
            while (it.hasNext()) {
                it.next().a(true);
            }
            i iVar = new i(this.f56288c, this.f56286a, this.f56287b);
            iVar.b(b6);
            iVar.run();
        }
    }
}
