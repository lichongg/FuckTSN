package xyz.adscope.common;

import android.content.Context;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import xyz.adscope.common.analyse.model.IBaseEventReportModel;
import xyz.adscope.common.analyse.model.impl.HistoryDbModel;
import xyz.adscope.common.analyse.publish.IEventAnalyser;
import xyz.adscope.common.analyse.publish.IEventConfigModel;
import xyz.adscope.common.n;
import xyz.adscope.common.v2.conn.IBaseHttpResponse;
import xyz.adscope.common.v2.conn.IBaseHttpResponseCallback;
import xyz.adscope.common.v2.conn.IHttpRequestError;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.persistent.db.IBaseDBOperator;
import xyz.adscope.common.v2.thread.pool.IRemoveAbleScheduledTask;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;
import xyz.adscope.common.v2.tool.date.DateUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
final class l implements IEventAnalyser {

    /* renamed from: a, reason: collision with root package name */
    private final o f56426a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, LinkedList<n>> f56427b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Context f56428c;

    /* renamed from: d, reason: collision with root package name */
    private final IBaseDBOperator f56429d;

    /* renamed from: e, reason: collision with root package name */
    private b f56430e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b extends IRemoveAbleScheduledTask {
        public b(Runnable runnable) {
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

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final IBaseDBOperator f56431a;

        /* renamed from: b, reason: collision with root package name */
        private final o f56432b;

        /* synthetic */ c(IBaseDBOperator iBaseDBOperator, o oVar, a aVar) {
            this(iBaseDBOperator, oVar);
        }

        private c(IBaseDBOperator iBaseDBOperator, o oVar) {
            this.f56432b = oVar;
            this.f56431a = iBaseDBOperator;
        }

        private void a() {
            if (this.f56431a != null) {
                long timeMillisBeforeDay = DateUtil.getTimeMillisBeforeDay(3);
                SDKLog.d("EventLoggerImpl", "删除过期的日志... 共计: " + this.f56431a.deleteLessThenWhere(HistoryDbModel.class, HistoryDbModel.COLUMN_STORE_TIME, timeMillisBeforeDay + ""));
            }
        }

        private List<HistoryDbModel> b() {
            IBaseDBOperator iBaseDBOperator = this.f56431a;
            if (iBaseDBOperator == null) {
                return null;
            }
            List<HistoryDbModel> query = iBaseDBOperator.query(HistoryDbModel.class, iBaseDBOperator.getOrderByAsc(HistoryDbModel.COLUMN_STORE_TIME));
            StringBuilder sb = new StringBuilder();
            sb.append("从数据库查询数据...");
            sb.append(query != null ? Integer.valueOf(query.size()) : " 历史数据为空...");
            SDKLog.d("EventLoggerImpl", sb.toString());
            return query;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            List<HistoryDbModel> b6 = b();
            if (b6 != null && !b6.isEmpty()) {
                new d(b6, this.f56431a, this.f56432b, null).run();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final List<HistoryDbModel> f56433a;

        /* renamed from: b, reason: collision with root package name */
        private final IBaseDBOperator f56434b;

        /* renamed from: c, reason: collision with root package name */
        private final o f56435c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class a implements IBaseHttpResponseCallback {

            /* renamed from: a, reason: collision with root package name */
            private final long[] f56436a;

            /* synthetic */ a(d dVar, long[] jArr, a aVar) {
                this(jArr);
            }

            private a(long[] jArr) {
                this.f56436a = jArr;
            }

            private void a(long[] jArr) {
                if (d.this.f56434b != null) {
                    d.this.f56434b.deleteInPrimaryKey(HistoryDbModel.class, jArr);
                }
            }

            @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
            public void failCallback(IHttpRequestError iHttpRequestError) {
                SDKLog.e("EventLoggerImpl", "上报失败..." + iHttpRequestError.getErrorCode() + " " + iHttpRequestError.getErrorMessage());
            }

            @Override // xyz.adscope.common.v2.conn.IBaseHttpResponseCallback
            public void successCallback(IBaseHttpResponse iBaseHttpResponse) {
                a(this.f56436a);
            }
        }

        /* synthetic */ d(List list, IBaseDBOperator iBaseDBOperator, o oVar, a aVar) {
            this(list, iBaseDBOperator, oVar);
        }

        private d(List<HistoryDbModel> list, IBaseDBOperator iBaseDBOperator, o oVar) {
            this.f56433a = list;
            this.f56434b = iBaseDBOperator;
            this.f56435c = oVar;
        }

        private void a(List<HistoryDbModel> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            HistoryDbModel historyDbModel = list.get(0);
            String url = historyDbModel.getUrl();
            String encrypt = historyDbModel.getEncrypt();
            long[] jArr = new long[list.size()];
            for (int i6 = 0; i6 < list.size(); i6++) {
                jArr[i6] = list.get(i6).getPrimaryID();
            }
            this.f56435c.a(url, encrypt, list, new a(this, jArr, null));
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this.f56433a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class e implements n.b {
        private e() {
        }

        @Override // xyz.adscope.common.n.b
        public void a(HistoryDbModel historyDbModel) {
            l.this.a(historyDbModel);
        }

        /* synthetic */ e(l lVar, a aVar) {
            this();
        }

        @Override // xyz.adscope.common.n.b
        public void a(List<HistoryDbModel> list) {
            ScopeThreadPoolManager.getInstance().getOrCreateImplement(l.this.f56428c).executeAnalyseAsyncTask(new d(list, l.this.f56429d, l.this.f56426a, null));
        }
    }

    @Override // xyz.adscope.common.analyse.publish.IEventAnalyser
    public void initializeQueueLinked(List<IEventConfigModel> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        SDKLog.d("EventLoggerImpl", "初始化统计日志队列...");
        synchronized (l.class) {
            try {
                if (!this.f56427b.containsKey(str)) {
                    n nVar = null;
                    e eVar = new e(this, 0 == true ? 1 : 0);
                    LinkedList<n> linkedList = new LinkedList<>();
                    Collections.reverse(list);
                    for (IEventConfigModel iEventConfigModel : list) {
                        n nVar2 = new n();
                        nVar2.a(eVar);
                        nVar2.a(iEventConfigModel);
                        if (nVar != null) {
                            nVar2.a(nVar);
                        }
                        linkedList.addFirst(nVar2);
                        nVar = nVar2;
                    }
                    SDKLog.d("EventLoggerImpl", "记录上报队列 tag: " + str);
                    this.f56427b.put(str, linkedList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // xyz.adscope.common.analyse.publish.IEventAnalyser
    public void reportCrashEvent(List<IBaseEventReportModel> list, String str) {
        SDKLog.d("EventLoggerImpl", "上报崩溃日志...");
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<IBaseEventReportModel> it = list.iterator();
        while (it.hasNext()) {
            reportRealtimeEvent(it.next(), str);
        }
    }

    @Override // xyz.adscope.common.analyse.publish.IEventAnalyser
    public void reportRealtimeEvent(IBaseEventReportModel iBaseEventReportModel, String str) {
        SDKLog.d("EventLoggerImpl", "上报实时日志..." + iBaseEventReportModel.getEventCode());
        synchronized (l.class) {
            try {
                if (this.f56427b.get(str) != null) {
                    LinkedList<n> linkedList = this.f56427b.get(str);
                    if (linkedList != null && !linkedList.isEmpty() && linkedList.getFirst() != null) {
                        linkedList.getFirst().d((IBaseEventReportModel) iBaseEventReportModel.deepCopy());
                    }
                } else {
                    SDKLog.e("EventLoggerImpl", "没有该tag下的上报队列, 理论上不应该发生...");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // xyz.adscope.common.analyse.publish.IEventAnalyser
    public void scheduleHistoryEvent(long j6, long j7, TimeUnit timeUnit) {
        SDKLog.d("EventLoggerImpl", "上报历史日志...");
        b bVar = this.f56430e;
        if (bVar != null) {
            bVar.a();
        } else {
            this.f56430e = new b(new c(this.f56429d, this.f56426a, null));
        }
        this.f56430e.a(j6, j7, timeUnit);
    }

    l(Context context) {
        this.f56428c = context;
        this.f56429d = new xyz.adscope.common.d(context);
        this.f56426a = new o(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HistoryDbModel historyDbModel) {
        historyDbModel.setPrimaryID(this.f56429d.insert(historyDbModel));
    }
}
