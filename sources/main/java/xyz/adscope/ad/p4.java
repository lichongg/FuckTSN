package xyz.adscope.ad;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import xyz.adscope.ad.e;
import xyz.adscope.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.statistics.task.TaskModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.statistics.task.taskurl.TaskUrlModel;
import xyz.adscope.ad.p4;
import xyz.adscope.common.v2.conn.http.RequestMethod;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.thread.pool.IBaseThreadPool;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;
import xyz.adscope.common.v2.tool.collection.CollectionFetch;
import xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class p4 extends q2 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Context f55793a;

        /* renamed from: b, reason: collision with root package name */
        private final List<TaskModel> f55794b;

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

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: xyz.adscope.ad.p4$b$b, reason: collision with other inner class name */
        class RunnableC1090b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final TaskModel f55796a;

            /* synthetic */ RunnableC1090b(b bVar, TaskModel taskModel, a aVar) {
                this(taskModel);
            }

            private RunnableC1090b(TaskModel taskModel) {
                this.f55796a = taskModel;
            }

            private void a(TaskUrlModel taskUrlModel) {
                IBaseThreadPool orCreateImplement;
                String a6 = taskUrlModel.a();
                long b6 = b(taskUrlModel);
                final String d6 = taskUrlModel.d();
                if (TextUtils.isEmpty(d6)) {
                    return;
                }
                Runnable runnable = RequestMethod.GET.getMethodName().equalsIgnoreCase(a6) ? new Runnable() { // from class: xyz.adscope.ad.o7
                    @Override // java.lang.Runnable
                    public final void run() {
                        p4.b.RunnableC1090b.this.a(d6);
                    }
                } : RequestMethod.POST.getMethodName().equalsIgnoreCase(a6) ? new Runnable() { // from class: xyz.adscope.ad.p7
                    @Override // java.lang.Runnable
                    public final void run() {
                        p4.b.RunnableC1090b.this.b(d6);
                    }
                } : "WEBVIEW".equalsIgnoreCase(a6) ? new Runnable() { // from class: xyz.adscope.ad.q7
                    @Override // java.lang.Runnable
                    public final void run() {
                        p4.b.RunnableC1090b.this.c(d6);
                    }
                } : "DEEPLINK".equalsIgnoreCase(a6) ? new Runnable() { // from class: xyz.adscope.ad.r7
                    @Override // java.lang.Runnable
                    public final void run() {
                        p4.b.RunnableC1090b.this.d(d6);
                    }
                } : null;
                if (runnable == null || b6 < 0 || (orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(b.this.f55793a)) == null) {
                    return;
                }
                orCreateImplement.scheduleAsyncTask(runnable, b6, TimeUnit.MILLISECONDS);
            }

            private long b(TaskUrlModel taskUrlModel) {
                return taskUrlModel.b() + new Random(System.currentTimeMillis()).nextInt((int) taskUrlModel.c()) + 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void c(String str) {
                n4.a(b.this.f55793a, str, (Bundle) null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void d(String str) {
                n4.a(b.this.f55793a, str);
            }

            @Override // java.lang.Runnable
            public void run() {
                List<TaskUrlModel> f6 = this.f55796a.f();
                if (f6 == null || f6.isEmpty()) {
                    return;
                }
                Iterator<TaskUrlModel> it = f6.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b(String str) {
                h0.a().getOrCreateImplement(b.this.f55793a).a(str, "", null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(String str) {
                h0.a().getOrCreateImplement(b.this.f55793a).a(str, null);
            }
        }

        /* synthetic */ b(Context context, List list, a aVar) {
            this(context, list);
        }

        private b(Context context, List<TaskModel> list) {
            this.f55793a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f55794b = list;
        }

        private List<TaskModel> a() {
            List<TaskModel> list = this.f55794b;
            if (list == null || list.isEmpty()) {
                return null;
            }
            return CollectionFetch.fetchAllFromList(this.f55794b, 2, new a());
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
                IBaseThreadPool orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55793a);
                if (orCreateImplement != null) {
                    orCreateImplement.scheduleAsyncTask(new RunnableC1090b(this, taskModel, null), a6, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    @Override // xyz.adscope.ad.q2
    protected void a(ConfigResponseModel configResponseModel, e.a aVar) {
        List<TaskModel> b6;
        if (configResponseModel == null || configResponseModel.h() == null || (b6 = configResponseModel.h().b()) == null || b6.isEmpty()) {
            return;
        }
        SDKLog.d("InvokeRequestByUpdate", "配置更新, 检查是否存在上报...");
        IBaseThreadPool orCreateImplement = ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55897a);
        if (orCreateImplement != null) {
            orCreateImplement.executeLocalAsyncTask(new b(this.f55897a, b6, null));
        }
    }

    public p4(Context context) {
        super(context);
    }
}
