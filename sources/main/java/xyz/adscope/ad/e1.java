package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import xyz.adscope.ad.e;
import xyz.adscope.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.statistics.task.TaskModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.statistics.task.pkg.PkgModel;
import xyz.adscope.common.analyse.model.IBaseEventReportModel;
import xyz.adscope.common.v2.conn.IBaseHttpResponse;
import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;
import xyz.adscope.common.v2.conn.IHttpRequestError;
import xyz.adscope.common.v2.dev.info.PackageUtil;
import xyz.adscope.common.v2.encrypt.ILinkedEncrypt;
import xyz.adscope.common.v2.encrypt.LinkedEncryptManager;
import xyz.adscope.common.v2.thread.pool.IBaseThreadPool;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;
import xyz.adscope.common.v2.tool.collection.CollectionFetch;
import xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare;
import xyz.adscope.common.v2.tool.date.DateUtil;
import xyz.adscope.common.v2.tool.json.JsonUtil;
import xyz.adscope.common.v2.tool.str.RegexUtil;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class e1 extends q2 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Context f55117a;

        /* renamed from: b, reason: collision with root package name */
        private final List<TaskModel> f55118b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements ICollectionFetchCompare<TaskModel, Integer> {
            @Override // xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean fetch(TaskModel taskModel, Integer num) {
                return taskModel != null && taskModel.e() == num.intValue();
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: xyz.adscope.ad.e1$b$b, reason: collision with other inner class name */
        private class RunnableC1088b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final TaskModel f55120a;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: xyz.adscope.ad.e1$b$b$a */
            class a implements ICollectionFetchCompare<c1, String> {
                a() {
                }

                @Override // xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public boolean fetch(c1 c1Var, String str) {
                    return c1Var != null && c1Var.b().equals(str);
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: xyz.adscope.ad.e1$b$b$b, reason: collision with other inner class name */
            class C1089b implements IBaseHttpResponseCallback {
                C1089b() {
                }

                @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
                public void failCallback(IHttpRequestError iHttpRequestError) {
                }

                @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
                public void successCallback(IBaseHttpResponse iBaseHttpResponse) {
                }
            }

            /* synthetic */ RunnableC1088b(b bVar, TaskModel taskModel, a aVar) {
                this(taskModel);
            }

            private List<c1> a(List<PkgModel> list, List<c1> list2) {
                if (list == null || list.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (PkgModel pkgModel : list) {
                    c1 c1Var = (c1) CollectionFetch.fetchFirstFromList(list2, pkgModel.b(), new a());
                    if (c1Var == null) {
                        c1Var = new c1();
                        c1Var.a(pkgModel.b());
                        c1Var.a(System.currentTimeMillis());
                        c1Var.a(PackageUtil.isInstall(b.this.f55117a, pkgModel.a()));
                    }
                    arrayList.add(c1Var);
                }
                return arrayList;
            }

            private RunnableC1088b(TaskModel taskModel) {
                this.f55120a = taskModel;
            }

            @Override // java.lang.Runnable
            public void run() {
                List<PkgModel> b6;
                TaskModel taskModel = this.f55120a;
                if (taskModel == null || (b6 = taskModel.b()) == null || b6.isEmpty()) {
                    return;
                }
                int d6 = this.f55120a.d();
                List<c1> b7 = b.this.b();
                if (d6 == 1) {
                    a(a(b6, b7));
                } else if (d6 == 2) {
                    a(b.this.a(b7, a(b6, b7)));
                } else {
                    if (d6 != 999) {
                        return;
                    }
                    a(this.f55120a, a(b6, b7));
                }
            }

            private void a(List<c1> list) {
                i0.a(b.this.f55117a, i0.a(), "appInstall", StringUtil.jsonMappingListToStringSet(list));
                k.a().getOrCreateImplement(b.this.f55117a).a(list);
            }

            private void a(TaskModel taskModel, List<c1> list) {
                String str;
                if (list == null || list.isEmpty()) {
                    return;
                }
                IBaseEventReportModel a6 = d0.a(b.this.f55117a, n1.EVENT_REPORT_APP_INSTALLS_CODE, StringUtil.escapeJsonAsString(StringUtil.jsonMappingListToString(list, "[]")));
                String macros = taskModel.getMacros();
                if (!TextUtils.isEmpty(macros)) {
                    str = RegexUtil.replaceMacros(macros, a6.getMacrosReplaceMap());
                } else {
                    str = "";
                }
                String encrypt = LinkedEncryptManager.getInstance().getOrCreateImplement(b.this.f55117a).encrypt(str, "101,1001", ILinkedEncrypt.B64Model.AS_LAST_OR_FIRST, false);
                String c6 = taskModel.c();
                if (TextUtils.isEmpty(c6) || TextUtils.isEmpty(str)) {
                    return;
                }
                new v5(b.this.f55117a, true).requestWithPostMethod(c6, encrypt, new C1089b());
            }
        }

        /* synthetic */ b(Context context, List list, a aVar) {
            this(context, list);
        }

        private b(Context context, List<TaskModel> list) {
            this.f55117a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f55118b = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<c1> b() {
            Set<String> c6 = i0.c(this.f55117a, i0.a(), "appInstall");
            if (c6 == null || c6.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long timeMillisBeforeDay = DateUtil.getTimeMillisBeforeDay(7);
            Iterator<String> it = c6.iterator();
            while (it.hasNext()) {
                JSONObject parseJSONObject = JsonUtil.parseJSONObject(it.next());
                if (parseJSONObject != null) {
                    c1 c1Var = new c1(parseJSONObject);
                    long c7 = c1Var.c();
                    if (c7 > 0 && c7 > timeMillisBeforeDay) {
                        arrayList.add(c1Var);
                    }
                }
            }
            return arrayList;
        }

        private List<TaskModel> a() {
            List<TaskModel> list = this.f55118b;
            if (list == null || list.isEmpty()) {
                return null;
            }
            return CollectionFetch.fetchAllFromList(this.f55118b, 1, new a());
        }

        @Override // java.lang.Runnable
        public void run() {
            List<TaskModel> a6 = a();
            if (a6 != null && !a6.isEmpty()) {
                Iterator<TaskModel> it = a6.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
        }

        private void a(TaskModel taskModel) {
            if (taskModel != null) {
                int a6 = taskModel.a();
                IBaseThreadPool orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55117a);
                if (orCreateImplement != null) {
                    orCreateImplement.scheduleAsyncTask(new RunnableC1088b(this, taskModel, null), a6, TimeUnit.MILLISECONDS);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<c1> a(List<c1> list, List<c1> list2) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            arrayList.addAll(list2);
            return arrayList;
        }
    }

    @Override // xyz.adscope.ad.q2
    protected void a(ConfigResponseModel configResponseModel, e.a aVar) {
        List<TaskModel> b6;
        IBaseThreadPool orCreateImplement;
        if (configResponseModel == null || configResponseModel.h() == null || (b6 = configResponseModel.h().b()) == null || b6.isEmpty() || (orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55897a)) == null) {
            return;
        }
        orCreateImplement.executeLocalAsyncTask(new b(this.f55897a, b6, null));
    }

    public e1(Context context) {
        super(context);
    }
}
