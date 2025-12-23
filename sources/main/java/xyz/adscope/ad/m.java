package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.socialize.common.SocializeConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.ad.e;
import xyz.adscope.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.beta.BetaTestPlanModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.log2.Analyse2ConfigModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.statistics.event.ConfigEventModel;
import xyz.adscope.ad.publish.ASNPInitConfig;
import xyz.adscope.common.analyse.model.IBaseEventReportModel;
import xyz.adscope.common.analyse.publish.CommonAnalyserManager;
import xyz.adscope.common.analyse.publish.IEventAnalyser;
import xyz.adscope.common.analyse.publish.IEventConfigModel;
import xyz.adscope.common.analyse2.publish.IScopeEventAnalyser;
import xyz.adscope.common.analyse2.publish.ScopeEventAnalyserManager;
import xyz.adscope.common.v2.beta.BetaTestManager;
import xyz.adscope.common.v2.beta.IBetaTest;
import xyz.adscope.common.v2.encrypt.impl.Base64Util;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class m implements s1 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f55395a;

    /* renamed from: b, reason: collision with root package name */
    private final IEventAnalyser f55396b;

    /* renamed from: c, reason: collision with root package name */
    private final IScopeEventAnalyser f55397c;

    /* renamed from: d, reason: collision with root package name */
    private final IBetaTest f55398d;

    /* renamed from: e, reason: collision with root package name */
    private String f55399e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements d3 {
        a() {
        }

        @Override // xyz.adscope.ad.d3
        public void a(ConfigResponseModel configResponseModel, e.a aVar, boolean z5) {
            if (configResponseModel != null) {
                m.this.f55396b.initializeQueueLinked(m.this.b(configResponseModel), configResponseModel.d());
                m.this.c(configResponseModel);
                m.this.a(configResponseModel);
                m.this.b(configResponseModel.d());
                m mVar = m.this;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                mVar.a(30L, 300L, timeUnit);
                if (!m.this.c("aa2623c4a099eaa875162146c8a9e483") || m.this.f55397c == null) {
                    return;
                }
                m.this.f55397c.scheduleHistoryEvent(30L, 300L, timeUnit, m.this.f55399e);
            }
        }
    }

    m(Context context) {
        this.f55395a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f55396b = CommonAnalyserManager.getInstance().getOrCreateImplement(context);
        this.f55397c = ScopeEventAnalyserManager.getInstance().getOrCreateImplement(context);
        this.f55398d = BetaTestManager.getInstance().getOrCreateImplement(context);
    }

    private void d(ConfigResponseModel configResponseModel) {
        Analyse2ConfigModel b6 = configResponseModel.b();
        if (b6 != null) {
            this.f55399e = b6.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        IBetaTest iBetaTest = this.f55398d;
        if (iBetaTest != null) {
            return iBetaTest.invokeBetaTest(str, f0.e(), 8);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<IEventConfigModel> b(ConfigResponseModel configResponseModel) {
        List<ConfigEventModel> a6;
        if (configResponseModel == null || configResponseModel.h() == null || (a6 = configResponseModel.h().a()) == null || a6.isEmpty()) {
            return null;
        }
        return new ArrayList(a6);
    }

    @Override // xyz.adscope.ad.s1
    public void a() {
        f.a().getOrCreateImplement(this.f55395a).a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ConfigResponseModel configResponseModel) {
        BetaTestPlanModel c6 = configResponseModel.c();
        if (c6 != null) {
            this.f55398d.initBetaConfig(c6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ConfigResponseModel configResponseModel) {
        e orCreateImplement;
        d(configResponseModel);
        if (!c("aa2623c4a099eaa875162146c8a9e483") || (orCreateImplement = f.a().getOrCreateImplement(this.f55395a)) == null) {
            return;
        }
        ASNPInitConfig a6 = orCreateImplement.a();
        j4 b6 = orCreateImplement.b();
        try {
            Objects.requireNonNull(b6);
            String f6 = b6.f();
            String appId = a6.getAppId();
            Objects.requireNonNull(appId);
            if (TextUtils.isEmpty(f6) || TextUtils.isEmpty(appId)) {
                return;
            }
            JSONObject emptyJSONObject = JsonUtil.emptyJSONObject();
            JsonUtil.putObject(emptyJSONObject, "start_id", f6);
            JsonUtil.putObject(emptyJSONObject, "app_id", appId);
            JsonUtil.putObject(emptyJSONObject, "custom_id", f0.e());
            JSONObject emptyJSONObject2 = JsonUtil.emptyJSONObject();
            JsonUtil.putObject(emptyJSONObject2, SocializeConstants.TENCENT_UID, a6.getUserId());
            JsonUtil.putObject(emptyJSONObject2, "user_custom_data", a6.getOptionInfoJson());
            JsonUtil.putObject(emptyJSONObject2, "lmt", (a6.canUseOAIDInfo() ? 1 : 0) + "");
            JSONObject emptyJSONObject3 = JsonUtil.emptyJSONObject();
            JsonUtil.putObject(emptyJSONObject3, "version", f0.c());
            JsonUtil.putObject(emptyJSONObject, au.f40908m, emptyJSONObject2);
            JsonUtil.putObject(emptyJSONObject, "sdk", emptyJSONObject3);
            JsonUtil.putObject(emptyJSONObject, "logStrategy", configResponseModel.b().asJsonObject());
            this.f55397c.initializeAnalyse(Base64Util.encodeToString(emptyJSONObject.toString()));
        } catch (NullPointerException e6) {
            SDKLog.stack(e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str) {
        ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55395a).executeBasicAsyncTask(new Runnable() { // from class: xyz.adscope.ad.m7
            @Override // java.lang.Runnable
            public final void run() {
                m.this.a(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(n1 n1Var, j4 j4Var) {
        Map<String, String> macrosReplaceMap;
        IBaseEventReportModel a6 = d0.a(this.f55395a, n1Var, j4Var);
        this.f55396b.reportRealtimeEvent(a6, j4Var.d());
        if (!c("aa2623c4a099eaa875162146c8a9e483") || this.f55397c == null || (macrosReplaceMap = a6.getMacrosReplaceMap()) == null) {
            return;
        }
        JSONObject emptyJSONObject = JsonUtil.emptyJSONObject();
        JsonUtil.putObject(emptyJSONObject, "event_id", macrosReplaceMap.get("__EVENT_ID__"));
        JsonUtil.putObject(emptyJSONObject, "event_code", macrosReplaceMap.get("__EVENT_CODE__"));
        JsonUtil.putObject(emptyJSONObject, "event_time", macrosReplaceMap.get("__EVENT_TIME__"));
        JsonUtil.putObject(emptyJSONObject, "cost_time", macrosReplaceMap.get("__COST_TIME__"));
        JsonUtil.putObject(emptyJSONObject, "error_code", macrosReplaceMap.get("__AD_ERROR_CODE__"));
        JsonUtil.putObject(emptyJSONObject, "error_info", macrosReplaceMap.get("__AD_ERROR_INFO__"));
        this.f55397c.reportEvent(Base64Util.encodeToString(emptyJSONObject.toString()), this.f55399e, f0.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(n1 n1Var, b1 b1Var) {
        Map<String, String> macrosReplaceMap;
        IBaseEventReportModel a6 = d0.a(this.f55395a, n1Var, b1Var);
        this.f55396b.reportRealtimeEvent(a6, b1Var.r());
        if (!c("aa2623c4a099eaa875162146c8a9e483") || this.f55397c == null || (macrosReplaceMap = a6.getMacrosReplaceMap()) == null) {
            return;
        }
        JSONObject emptyJSONObject = JsonUtil.emptyJSONObject();
        JsonUtil.putObject(emptyJSONObject, "event_id", macrosReplaceMap.get("__EVENT_ID__"));
        JsonUtil.putObject(emptyJSONObject, "event_code", macrosReplaceMap.get("__EVENT_CODE__"));
        JsonUtil.putObject(emptyJSONObject, "event_time", macrosReplaceMap.get("__EVENT_TIME__"));
        JsonUtil.putObject(emptyJSONObject, "cost_time", macrosReplaceMap.get("__COST_TIME__"));
        JsonUtil.putObject(emptyJSONObject, "error_code", macrosReplaceMap.get("__AD_ERROR_CODE__"));
        JsonUtil.putObject(emptyJSONObject, "error_info", macrosReplaceMap.get("__AD_ERROR_INFO__"));
        JsonUtil.putObject(emptyJSONObject, "dsp_id", macrosReplaceMap.get("__DSP_ID__"));
        JsonUtil.putObject(emptyJSONObject, "order_id", macrosReplaceMap.get("__ORDER_ID__"));
        JsonUtil.putObject(emptyJSONObject, "creative_id", macrosReplaceMap.get("__CREATIVE_ID__"));
        JsonUtil.putObject(emptyJSONObject, "material_id", macrosReplaceMap.get("__MATERIAL_ID__"));
        JsonUtil.putObject(emptyJSONObject, "scheme_id", macrosReplaceMap.get("__ADN_RENDER_ID__"));
        JsonUtil.putObject(emptyJSONObject, "click_type", macrosReplaceMap.get("__CLICK_TYPE__"));
        JsonUtil.putObject(emptyJSONObject, "ecpm", macrosReplaceMap.get("__PRICE__"));
        JSONObject emptyJSONObject2 = JsonUtil.emptyJSONObject();
        JsonUtil.putObject(emptyJSONObject2, "space_id", macrosReplaceMap.get("__SPACE_ID__"));
        JsonUtil.putObject(emptyJSONObject2, "session_id", macrosReplaceMap.get("__SESSION_ID__"));
        JsonUtil.putObject(emptyJSONObject2, "ad_type", macrosReplaceMap.get("__AD_TYPE__"));
        JsonUtil.putObject(emptyJSONObject2, "currency", macrosReplaceMap.get("__CURRENCY__"));
        JsonUtil.putObject(emptyJSONObject2, "custom_data", macrosReplaceMap.get("__USER_CUSTOM_DATA__"));
        JsonUtil.putObject(emptyJSONObject2, "time_out", macrosReplaceMap.get("__MAX_WAIT_TIME__"));
        JsonUtil.putObject(emptyJSONObject2, "quantity", macrosReplaceMap.get("__QUANTITY__"));
        JsonUtil.putObject(emptyJSONObject, "asnp", emptyJSONObject2);
        this.f55397c.reportEvent(Base64Util.encodeToString(emptyJSONObject.toString()), this.f55399e, f0.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        List<m1> b6 = g.b(this.f55395a);
        StringBuilder sb = new StringBuilder();
        sb.append("上报历史崩溃日志...");
        sb.append(b6 != null ? Integer.valueOf(b6.size()) : " null ");
        SDKLog.d("ASNPEvertReporter", sb.toString());
        if (b6 == null || b6.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<m1> it = b6.iterator();
        while (it.hasNext()) {
            arrayList.add(d0.a(this.f55395a, n1.EVENT_REPORT_CRASH_CODE, it.next()));
        }
        a(arrayList, str);
        if (!c("aa2623c4a099eaa875162146c8a9e483") || b6.isEmpty()) {
            return;
        }
        JSONArray emptyJSONArray = JsonUtil.emptyJSONArray();
        for (m1 m1Var : b6) {
            JSONObject emptyJSONObject = JsonUtil.emptyJSONObject();
            JsonUtil.putObject(emptyJSONObject, "affiliated", m1Var.a());
            JsonUtil.putObject(emptyJSONObject, "exception", m1Var.b());
            JsonUtil.putObject(emptyJSONObject, "time", m1Var.c() + "");
            emptyJSONArray.put(emptyJSONObject);
        }
        IScopeEventAnalyser iScopeEventAnalyser = this.f55397c;
        if (iScopeEventAnalyser != null) {
            iScopeEventAnalyser.reportCrash(Base64Util.encodeToString(emptyJSONArray.toString()), this.f55399e, f0.e());
        }
    }

    public void a(long j6, long j7, TimeUnit timeUnit) {
        IEventAnalyser iEventAnalyser = this.f55396b;
        if (iEventAnalyser != null) {
            iEventAnalyser.scheduleHistoryEvent(j6, j7, timeUnit);
        }
    }

    private void a(List<IBaseEventReportModel> list, String str) {
        IEventAnalyser iEventAnalyser = this.f55396b;
        if (iEventAnalyser != null) {
            iEventAnalyser.reportCrashEvent(list, str);
        }
    }

    @Override // xyz.adscope.ad.s1
    public void a(final n1 n1Var, final j4 j4Var) {
        if (this.f55396b != null) {
            ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55395a).executeBasicAsyncTask(new Runnable() { // from class: xyz.adscope.ad.n7
                @Override // java.lang.Runnable
                public final void run() {
                    m.this.b(n1Var, j4Var);
                }
            });
        }
    }

    @Override // xyz.adscope.ad.s1
    public void a(final n1 n1Var, final b1 b1Var) {
        if (this.f55396b != null) {
            ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55395a).executeBasicAsyncTask(new Runnable() { // from class: xyz.adscope.ad.l7
                @Override // java.lang.Runnable
                public final void run() {
                    m.this.b(n1Var, b1Var);
                }
            });
        }
    }
}
