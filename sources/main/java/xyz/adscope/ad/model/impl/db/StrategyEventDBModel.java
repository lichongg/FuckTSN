package xyz.adscope.ad.model.impl.db;

import android.text.TextUtils;
import xyz.adscope.amps.report.AMPSReportConstants;
import xyz.adscope.common.analyse.model.impl.HistoryDbModel;
import xyz.adscope.common.v2.model.annotation.DataBaseNode;
import xyz.adscope.common.v2.persistent.db.IBaseDatabaseModel;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class StrategyEventDBModel extends IBaseDatabaseModel {

    /* renamed from: a, reason: collision with root package name */
    @DataBaseNode(column = HistoryDbModel.COLUMN_API_KEY)
    private String f55429a;

    /* renamed from: b, reason: collision with root package name */
    @DataBaseNode(column = "eventCode")
    private String f55430b;

    /* renamed from: c, reason: collision with root package name */
    @DataBaseNode(column = "spaceId")
    private String f55431c;

    /* renamed from: d, reason: collision with root package name */
    @DataBaseNode(column = AMPSReportConstants.EVENT_TIME_KEY)
    private String f55432d;

    public void a(String str) {
        this.f55429a = str;
    }

    public void b(String str) {
        this.f55430b = str;
    }

    public String c() {
        return this.f55431c;
    }

    public String a() {
        return this.f55430b;
    }

    public long b() {
        if (TextUtils.isEmpty(this.f55432d)) {
            return 0L;
        }
        return StringUtil.parseLong(this.f55432d);
    }

    public void c(String str) {
        this.f55432d = str;
    }

    public void d(String str) {
        this.f55431c = str;
    }
}
