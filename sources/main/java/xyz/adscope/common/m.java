package xyz.adscope.common;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.analyse2.base.model.biz.AMPSExtraLog;
import xyz.adscope.common.analyse2.base.model.biz.ASNPExtraLog;
import xyz.adscope.common.analyse2.base.model.biz.AnalyseSimpleLog;
import xyz.adscope.common.analyse2.base.model.init.AnalyseCrashModel;
import xyz.adscope.common.analyse2.base.model.init.AnalyseEventModel;
import xyz.adscope.common.analyse2.base.model.init.AnalyseInitConfigModel;
import xyz.adscope.common.analyse2.base.model.init.AnalyseLogStrategyModel;
import xyz.adscope.common.analyse2.publish.IScopeAnalyserUpdater;
import xyz.adscope.common.analyse2.publish.IScopeEventAnalyser;
import xyz.adscope.common.f;
import xyz.adscope.common.i;
import xyz.adscope.common.v2.crash.ScopeCrashLog;
import xyz.adscope.common.v2.encrypt.impl.Base64Util;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.persistent.db.IBaseDBOperator;
import xyz.adscope.common.v2.thread.pool.IBaseThreadPool;
import xyz.adscope.common.v2.thread.pool.IRemoveAbleScheduledTask;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;
import xyz.adscope.common.v2.tool.json.JsonUtil;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
final class m implements IScopeEventAnalyser {

    /* renamed from: a, reason: collision with root package name */
    private final h f56439a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, g> f56440b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, AnalyseInitConfigModel> f56441c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Context f56442d;

    /* renamed from: e, reason: collision with root package name */
    private final IBaseDBOperator f56443e;

    /* renamed from: f, reason: collision with root package name */
    private c f56444f;

    /* renamed from: g, reason: collision with root package name */
    private IScopeAnalyserUpdater f56445g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements f.c {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: xyz.adscope.common.m$a$a, reason: collision with other inner class name */
        class C1099a implements i.b {
            C1099a() {
            }

            @Override // xyz.adscope.common.i.b
            public void a() {
                if (m.this.f56445g != null) {
                    m.this.f56445g.requireUpdate();
                }
            }
        }

        private a() {
        }

        /* synthetic */ a(m mVar, b bVar) {
            this();
        }

        @Override // xyz.adscope.common.f.c
        public void a(List<AnalyseSimpleLog> list, AnalyseEventModel analyseEventModel, String str, String str2) {
            IBaseThreadPool orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(m.this.f56442d);
            i iVar = new i(m.this.f56442d, m.this.f56443e, m.this.f56439a);
            iVar.a(analyseEventModel.g(), str2, analyseEventModel.c(), str);
            iVar.c(list);
            iVar.a(new C1099a());
            orCreateImplement.executeAnalyseAsyncTask(iVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class b {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c extends IRemoveAbleScheduledTask {
        public c(Runnable runnable) {
            super(runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j6, long j7, TimeUnit timeUnit) {
            startScheduled(j6, j7, timeUnit);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            stopScheduled();
        }
    }

    JSONObject a(String str) {
        AnalyseInitConfigModel analyseInitConfigModel;
        if (TextUtils.isEmpty(str) || !this.f56441c.containsKey(str) || (analyseInitConfigModel = this.f56441c.get(str)) == null) {
            return null;
        }
        return analyseInitConfigModel.a(this.f56442d);
    }

    @Override // xyz.adscope.common.analyse2.publish.IScopeEventAnalyser
    public void initializeAnalyse(String str) {
        AnalyseLogStrategyModel c6;
        synchronized (m.class) {
            try {
                String decodeToString = Base64Util.decodeToString(str);
                if (!TextUtils.isEmpty(decodeToString)) {
                    AnalyseInitConfigModel analyseInitConfigModel = new AnalyseInitConfigModel(JsonUtil.parseJSONObject(decodeToString));
                    if (!analyseInitConfigModel.hasParseException() && (c6 = analyseInitConfigModel.c()) != null) {
                        String f6 = c6.f();
                        if (!TextUtils.isEmpty(f6)) {
                            this.f56441c.put(f6, analyseInitConfigModel);
                            List<AnalyseEventModel> e6 = c6.e();
                            if (e6 != null && !e6.isEmpty() && !this.f56440b.containsKey(f6)) {
                                g gVar = new g(f6, c6.b(), analyseInitConfigModel.b(), e6, new a(this, null));
                                SDKLog.d("EventLoggerImpl2", "记录上报队列 tag: " + f6);
                                this.f56440b.put(f6, gVar);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // xyz.adscope.common.analyse2.publish.IScopeEventAnalyser
    public void registerAnalyseUpdate(IScopeAnalyserUpdater iScopeAnalyserUpdater) {
        this.f56445g = iScopeAnalyserUpdater;
    }

    @Override // xyz.adscope.common.analyse2.publish.IScopeEventAnalyser
    public void reportCrash(String str, String str2, String str3) {
        AnalyseInitConfigModel analyseInitConfigModel;
        AnalyseLogStrategyModel c6;
        AnalyseCrashModel c7;
        synchronized (m.class) {
            JSONArray parseJSONArray = JsonUtil.parseJSONArray(Base64Util.decodeToString(str));
            if (parseJSONArray != null && parseJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 < parseJSONArray.length(); i6++) {
                    try {
                        JSONObject jSONObject = parseJSONArray.getJSONObject(i6);
                        arrayList.add(new ScopeCrashLog(JsonUtil.getStringFromJson(jSONObject, "affiliated"), JsonUtil.getStringFromJson(jSONObject, "exception"), StringUtil.parseLong(JsonUtil.getStringFromJson(jSONObject, "time"))));
                    } catch (JSONException e6) {
                        SDKLog.stack(e6);
                    }
                }
                if (this.f56441c.containsKey(str2) && (analyseInitConfigModel = this.f56441c.get(str2)) != null && (c6 = analyseInitConfigModel.c()) != null && (c7 = c6.c()) != null) {
                    String b6 = c7.b();
                    String b7 = c6.b();
                    if (!TextUtils.isEmpty(b6) && !TextUtils.isEmpty(b7)) {
                        IBaseThreadPool orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f56442d);
                        i iVar = new i(this.f56442d, this.f56443e, this.f56439a);
                        iVar.a(b6, b7, null, str2);
                        iVar.a(arrayList);
                        orCreateImplement.executeAnalyseAsyncTask(iVar);
                    }
                }
            }
        }
    }

    @Override // xyz.adscope.common.analyse2.publish.IScopeEventAnalyser
    public void reportEvent(String str, String str2, String str3) {
        g gVar;
        synchronized (m.class) {
            try {
                JSONObject parseJSONObject = JsonUtil.parseJSONObject(Base64Util.decodeToString(str));
                AnalyseSimpleLog aMPSExtraLog = parseJSONObject != null ? parseJSONObject.has(AMPSConstants.RESOURCE_HEAD) ? new AMPSExtraLog(parseJSONObject) : parseJSONObject.has("asnp") ? new ASNPExtraLog(parseJSONObject) : new AnalyseSimpleLog(parseJSONObject) : null;
                if (aMPSExtraLog != null && this.f56440b.containsKey(str2) && (gVar = this.f56440b.get(str2)) != null) {
                    gVar.a(aMPSExtraLog);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // xyz.adscope.common.analyse2.publish.IScopeEventAnalyser
    public void scheduleHistoryEvent(long j6, long j7, TimeUnit timeUnit, String str) {
        SDKLog.d("EventLoggerImpl2", "上报历史日志...");
        c cVar = this.f56444f;
        if (cVar != null) {
            cVar.a();
        } else {
            this.f56444f = new c(new xyz.adscope.common.b(this.f56442d, this.f56443e, this.f56439a));
        }
        this.f56444f.a(j6, j7, timeUnit);
    }

    m(Context context) {
        this.f56442d = context;
        this.f56443e = new e(context);
        this.f56439a = new h(context);
    }
}
