package xyz.adscope.common;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import xyz.adscope.common.analyse2.base.model.biz.AnalyseSimpleLog;
import xyz.adscope.common.analyse2.db.AnalyseEventDBModel;
import xyz.adscope.common.analyse2.publish.IScopeEventAnalyser;
import xyz.adscope.common.analyse2.publish.ScopeEventAnalyserManager;
import xyz.adscope.common.v2.conn.IBaseHttpResponse;
import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;
import xyz.adscope.common.v2.conn.IHttpRequestError;
import xyz.adscope.common.v2.crash.ScopeCrashLog;
import xyz.adscope.common.v2.persistent.db.IBaseDBOperator;
import xyz.adscope.common.v2.tool.json.JsonUtil;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
final class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final IBaseDBOperator f56329a;

    /* renamed from: b, reason: collision with root package name */
    private final h f56330b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f56331c;

    /* renamed from: d, reason: collision with root package name */
    private List<AnalyseSimpleLog> f56332d;

    /* renamed from: e, reason: collision with root package name */
    private List<AnalyseEventDBModel> f56333e;

    /* renamed from: f, reason: collision with root package name */
    private String f56334f;

    /* renamed from: g, reason: collision with root package name */
    private String f56335g;

    /* renamed from: h, reason: collision with root package name */
    private String f56336h;

    /* renamed from: i, reason: collision with root package name */
    private List<ScopeCrashLog> f56337i;

    /* renamed from: j, reason: collision with root package name */
    private b f56338j;

    /* renamed from: k, reason: collision with root package name */
    private List<String> f56339k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface b {
        void a();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements IBaseHttpResponseCallback {

        /* renamed from: a, reason: collision with root package name */
        private final AnalyseEventDBModel f56340a;

        /* synthetic */ c(i iVar, AnalyseEventDBModel analyseEventDBModel, a aVar) {
            this(analyseEventDBModel);
        }

        private void a() {
            if (i.this.f56329a != null) {
                i.this.f56329a.insert(this.f56340a);
            }
        }

        private c(AnalyseEventDBModel analyseEventDBModel) {
            this.f56340a = analyseEventDBModel;
        }

        @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
        public void successCallback(IBaseHttpResponse iBaseHttpResponse) {
            AnalyseEventDBModel analyseEventDBModel = this.f56340a;
            if (analyseEventDBModel != null && analyseEventDBModel.b()) {
                i.this.f56329a.deleteByPrimaryKey(AnalyseEventDBModel.class, this.f56340a.getPrimaryID());
            }
            a(iBaseHttpResponse);
        }

        private void a(IBaseHttpResponse iBaseHttpResponse) {
            if (iBaseHttpResponse == null || iBaseHttpResponse.getResponseCode() != 200 || !b(iBaseHttpResponse) || i.this.f56338j == null) {
                return;
            }
            i.this.f56338j.a();
        }

        private boolean b(IBaseHttpResponse iBaseHttpResponse) {
            JSONObject parseJSONObject;
            JSONObject jSONObject;
            String responseResult = iBaseHttpResponse.getResponseResult();
            if (TextUtils.isEmpty(responseResult) || (parseJSONObject = JsonUtil.parseJSONObject(responseResult)) == null || JsonUtil.getInt(parseJSONObject, "code", 0) != 200 || (jSONObject = JsonUtil.getJSONObject(parseJSONObject, "data")) == null || 1 != JsonUtil.getInt(jSONObject, "isUpdate", 0)) {
                return false;
            }
            return true;
        }

        @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
        public void failCallback(IHttpRequestError iHttpRequestError) {
            a();
        }
    }

    void a(String str, String str2, List<String> list, String str3) {
        this.f56334f = str;
        this.f56335g = str2;
        this.f56336h = str3;
        this.f56339k = list;
    }

    void b(List<AnalyseEventDBModel> list) {
        this.f56333e = list;
    }

    void c(List<AnalyseSimpleLog> list) {
        this.f56332d = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject;
        AnalyseEventDBModel b6;
        List<AnalyseEventDBModel> list = this.f56333e;
        if (list != null && !list.isEmpty()) {
            Iterator<AnalyseEventDBModel> it = this.f56333e.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }
        IScopeEventAnalyser orCreateImplement = ScopeEventAnalyserManager.getInstance().getOrCreateImplement(this.f56331c);
        if (orCreateImplement instanceof m) {
            jSONObject = ((m) orCreateImplement).a(this.f56336h);
            List<String> list2 = this.f56339k;
            JsonUtil.removeJsonObjectKeys(jSONObject, list2 != null ? (String[]) list2.toArray(new String[0]) : new String[0]);
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            List<ScopeCrashLog> list3 = this.f56337i;
            if (list3 != null && !list3.isEmpty()) {
                JsonUtil.updateJSONValue(jSONObject, "custom_id", "crash");
                AnalyseEventDBModel a6 = xyz.adscope.common.c.a(this.f56331c, this.f56334f, this.f56335g, jSONObject, this.f56337i);
                if (a6 != null) {
                    a(a6);
                }
            }
            List<AnalyseSimpleLog> list4 = this.f56332d;
            if (list4 == null || list4.isEmpty() || (b6 = xyz.adscope.common.c.b(this.f56331c, this.f56334f, this.f56335g, jSONObject, this.f56332d)) == null) {
                return;
            }
            a(b6);
        }
    }

    i(Context context, IBaseDBOperator iBaseDBOperator, h hVar) {
        this.f56329a = iBaseDBOperator;
        this.f56330b = hVar;
        this.f56331c = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    void a(List<ScopeCrashLog> list) {
        this.f56337i = list;
    }

    void a(b bVar) {
        this.f56338j = bVar;
    }

    private void a(AnalyseEventDBModel analyseEventDBModel) {
        if (analyseEventDBModel != null) {
            this.f56330b.a(analyseEventDBModel.getUrl(), analyseEventDBModel.getEncrypt(), StringUtil.hexStringToBytes(analyseEventDBModel.a()), new c(this, analyseEventDBModel, null));
        }
    }
}
