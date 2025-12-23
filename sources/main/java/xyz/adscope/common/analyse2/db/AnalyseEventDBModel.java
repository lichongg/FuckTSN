package xyz.adscope.common.analyse2.db;

import xyz.adscope.amps.report.AMPSReportConstants;
import xyz.adscope.common.analyse.model.impl.HistoryDbModel;
import xyz.adscope.common.v2.model.annotation.DataBaseNode;
import xyz.adscope.common.v2.persistent.db.IBaseDatabaseModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AnalyseEventDBModel extends IBaseDatabaseModel {

    /* renamed from: a, reason: collision with root package name */
    @DataBaseNode(column = HistoryDbModel.COLUMN_REPORT_URL)
    private String f56281a = "";

    /* renamed from: b, reason: collision with root package name */
    @DataBaseNode(column = AMPSReportConstants.EVENT_TIME_KEY)
    private String f56282b = "";

    /* renamed from: c, reason: collision with root package name */
    @DataBaseNode(column = "encrypt")
    private String f56283c = "";

    /* renamed from: d, reason: collision with root package name */
    @DataBaseNode(column = "body")
    private String f56284d = "";

    /* renamed from: e, reason: collision with root package name */
    private boolean f56285e = false;

    public String a() {
        return this.f56284d;
    }

    public void b(String str) {
        this.f56282b = str;
    }

    public void a(String str) {
        this.f56284d = str;
    }

    public boolean b() {
        return this.f56285e;
    }

    public String getEncrypt() {
        return this.f56283c;
    }

    public String getUrl() {
        return this.f56281a;
    }

    public void setEncrypt(String str) {
        this.f56283c = str;
    }

    public void setUrl(String str) {
        this.f56281a = str;
    }

    public void a(boolean z5) {
        this.f56285e = z5;
    }
}
