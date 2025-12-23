package com.huawei.hms.framework.network.grs.g;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f33477b = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, q1.b> f33478c = new ConcurrentHashMap(16);

    /* renamed from: d, reason: collision with root package name */
    private static final Object f33479d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private o1.a f33480a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Callable<d> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q1.c f33481a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f33482b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ o1.c f33483c;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public d call() {
            return new c(this.f33481a, g.this.f33480a).a(g.f33477b, this.f33482b, this.f33483c);
        }

        a(q1.c cVar, String str, o1.c cVar2) {
            this.f33481a = cVar;
            this.f33482b = str;
            this.f33483c = cVar2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q1.c f33485a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f33486b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ o1.c f33487c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f33488d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.b f33489e;

        b(q1.c cVar, String str, o1.c cVar2, int i6, com.huawei.hms.framework.network.grs.b bVar) {
            this.f33485a = cVar;
            this.f33486b = str;
            this.f33487c = cVar2;
            this.f33488d = i6;
            this.f33489e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.d(gVar.a(this.f33485a, this.f33486b, this.f33487c, this.f33488d), this.f33489e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(d dVar, com.huawei.hms.framework.network.grs.b bVar) {
        if (bVar != null) {
            if (dVar == null) {
                Logger.v("RequestController", "GrsResponse is null");
                bVar.a();
            } else {
                Logger.v("RequestController", "GrsResponse is not null");
                bVar.a(dVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x006c, code lost:
    
        if (r3.a() != false) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.framework.network.grs.g.d a(q1.c r9, java.lang.String r10, o1.c r11, int r12) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.g.a(q1.c, java.lang.String, o1.c, int):com.huawei.hms.framework.network.grs.g.d");
    }

    public void f(String str) {
        synchronized (f33479d) {
            f33478c.remove(str);
        }
    }

    public void g(o1.a aVar) {
        this.f33480a = aVar;
    }

    public void h(q1.c cVar, com.huawei.hms.framework.network.grs.b bVar, String str, o1.c cVar2, int i6) {
        f33477b.execute(new b(cVar, str, cVar2, i6, bVar));
    }
}
