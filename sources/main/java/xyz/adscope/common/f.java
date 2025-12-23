package xyz.adscope.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import xyz.adscope.common.analyse2.base.model.biz.AnalyseAdCommon;
import xyz.adscope.common.analyse2.base.model.biz.AnalyseAdEventLog;
import xyz.adscope.common.analyse2.base.model.biz.AnalyseSimpleLog;
import xyz.adscope.common.analyse2.base.model.init.AnalyseEventModel;
import xyz.adscope.common.v2.thread.timer.task.ICommonTimeoutTask;
import xyz.adscope.common.v2.tool.roll.RandomProbability;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final String f56314a;

    /* renamed from: b, reason: collision with root package name */
    private final String f56315b;

    /* renamed from: c, reason: collision with root package name */
    private final String f56316c;

    /* renamed from: d, reason: collision with root package name */
    private AnalyseEventModel f56317d;

    /* renamed from: e, reason: collision with root package name */
    private f f56318e;

    /* renamed from: f, reason: collision with root package name */
    private b<AnalyseSimpleLog> f56319f;

    /* renamed from: g, reason: collision with root package name */
    private c f56320g;

    /* renamed from: h, reason: collision with root package name */
    private final d<AnalyseSimpleLog> f56321h = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements d<AnalyseSimpleLog> {
        a() {
        }

        @Override // xyz.adscope.common.f.d
        public void a(List<AnalyseSimpleLog> list) {
            f fVar = f.this;
            fVar.a(list, fVar.f56317d, f.this.f56314a, f.this.f56315b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<E> extends CopyOnWriteArrayList<E> {

        /* renamed from: a, reason: collision with root package name */
        private final int f56323a;

        /* renamed from: b, reason: collision with root package name */
        private final b<E>.a f56324b;

        /* renamed from: c, reason: collision with root package name */
        private d f56325c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class a extends ICommonTimeoutTask {
            public a(long j6) {
                super(j6);
            }

            @Override // xyz.adscope.common.v2.thread.timer.task.ICommonTimeoutTask
            protected void onScheduleTimeout() {
                synchronized (b.this) {
                    b.this.b();
                }
            }
        }

        @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
        public boolean add(E e6) {
            boolean add;
            synchronized (this) {
                try {
                    add = super.add(e6);
                    if (add && size() == 1) {
                        this.f56324b.startCountDown();
                    }
                    if (add && size() == this.f56323a) {
                        b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return add;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f56324b.cancelCountDown();
            a(a());
        }

        void a(d dVar) {
            this.f56325c = dVar;
        }

        b(int i6, long j6) {
            this.f56323a = i6 <= 0 ? 1 : i6;
            this.f56324b = new a(j6);
        }

        private void a(List<E> list) {
            d dVar = this.f56325c;
            if (dVar != null) {
                dVar.a(list);
            }
        }

        private List<E> a() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this);
                clear();
            }
            return arrayList;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface c {
        void a(List<AnalyseSimpleLog> list, AnalyseEventModel analyseEventModel, String str, String str2);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface d<E> {
        void a(List<E> list);
    }

    private void b(AnalyseSimpleLog analyseSimpleLog) {
        f fVar = this.f56318e;
        if (fVar != null) {
            fVar.c(analyseSimpleLog);
        }
    }

    void c(AnalyseSimpleLog analyseSimpleLog) {
        this.f56319f.a(this.f56321h);
        if (!a(analyseSimpleLog)) {
            b(analyseSimpleLog);
            return;
        }
        if (analyseSimpleLog != null) {
            analyseSimpleLog.a(this.f56317d.e() + "");
        }
        this.f56319f.add(analyseSimpleLog);
    }

    void d(f fVar) {
        this.f56318e = fVar;
    }

    f(String str, String str2, String str3) {
        this.f56314a = str;
        this.f56315b = str2;
        this.f56316c = str3;
    }

    void a(c cVar) {
        this.f56320g = cVar;
    }

    void a(AnalyseEventModel analyseEventModel) {
        long j6;
        this.f56317d = analyseEventModel;
        try {
            j6 = Long.parseLong(analyseEventModel.f());
        } catch (NumberFormatException unused) {
            j6 = 0;
        }
        this.f56319f = new b<>(analyseEventModel.b(), j6);
    }

    private boolean a(AnalyseSimpleLog analyseSimpleLog) {
        AnalyseAdCommon c6;
        AnalyseEventModel analyseEventModel = this.f56317d;
        if (analyseEventModel == null || analyseEventModel.d() == null || this.f56317d.d().isEmpty() || !this.f56317d.d().contains(analyseSimpleLog.b())) {
            return false;
        }
        int e6 = this.f56317d.e();
        String str = this.f56316c;
        if ((analyseSimpleLog instanceof AnalyseAdEventLog) && (c6 = ((AnalyseAdEventLog) analyseSimpleLog).c()) != null) {
            str = c6.b();
        }
        return RandomProbability.rollByCRCString(e6, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<AnalyseSimpleLog> list, AnalyseEventModel analyseEventModel, String str, String str2) {
        c cVar = this.f56320g;
        if (cVar != null) {
            cVar.a(list, analyseEventModel, str, str2);
        }
    }
}
