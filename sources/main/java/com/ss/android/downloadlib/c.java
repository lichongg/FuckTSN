package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.work.PeriodicWorkRequest;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.socialbase.downloader.ae.cw;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: f, reason: collision with root package name */
    private static volatile c f38009f;

    /* renamed from: e, reason: collision with root package name */
    private long f38014e;

    /* renamed from: b, reason: collision with root package name */
    private final List<com.ss.android.downloadlib.addownload.a> f38011b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, com.ss.android.downloadlib.addownload.a> f38012c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArrayList<Object> f38013d = new CopyOnWriteArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    private final Handler f38010a = new Handler(Looper.getMainLooper());

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.b f38015a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.c f38016b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.g f38017c;

        a(com.ss.android.j.j.cw.b bVar, com.ss.android.j.j.cw.c cVar, com.ss.android.j.j.cw.g gVar) {
            this.f38015a = bVar;
            this.f38016b = cVar;
            this.f38017c = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = c.this.f38013d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (!(next instanceof t2.a) && (next instanceof SoftReference)) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof t2.a) {
                        softReference.get();
                    }
                }
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cw f38019a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.up.j f38020b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f38021c;

        b(cw cwVar, com.ss.android.socialbase.downloader.up.j jVar, String str) {
            this.f38019a = cwVar;
            this.f38020b = jVar;
            this.f38021c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = c.this.f38013d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (!(next instanceof t2.a) && (next instanceof SoftReference)) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof t2.a) {
                        softReference.get();
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.c$c, reason: collision with other inner class name */
    class RunnableC0754c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cw f38023a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f38024b;

        RunnableC0754c(cw cwVar, String str) {
            this.f38023a = cwVar;
            this.f38024b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = c.this.f38013d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (!(next instanceof t2.a) && (next instanceof SoftReference)) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof t2.a) {
                        softReference.get();
                    }
                }
            }
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cw f38026a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f38027b;

        d(cw cwVar, String str) {
            this.f38026a = cwVar;
            this.f38027b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = c.this.f38013d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof t2.a) {
                    ((t2.a) next).j(this.f38026a, this.f38027b);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof t2.a) {
                        ((t2.a) softReference.get()).j(this.f38026a, this.f38027b);
                    }
                }
            }
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cw f38029a;

        e(cw cwVar) {
            this.f38029a = cwVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = c.this.f38013d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (!(next instanceof t2.a) && (next instanceof SoftReference)) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof t2.a) {
                        softReference.get();
                    }
                }
            }
        }
    }

    private synchronized void g(Context context, int i6, com.ss.android.j.j.cw.e eVar, com.ss.android.j.j.cw.b bVar, String str) {
        try {
            try {
                if (this.f38011b.size() <= 0) {
                    u(context, i6, eVar, bVar, str);
                    return;
                }
                com.ss.android.downloadlib.addownload.a remove = this.f38011b.remove(0);
                remove.xt(context).f(i6, eVar).b(bVar).j(str).j();
                this.f38012c.put(str, remove);
                com.ss.android.downloadlib.addownload.g.b().e(str, bVar.j());
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    private synchronized void t(Context context, int i6, com.ss.android.j.j.cw.e eVar, com.ss.android.j.j.cw.b bVar) {
        if (this.f38011b.size() <= 0) {
            b(context, i6, eVar, bVar);
            return;
        }
        com.ss.android.downloadlib.addownload.a remove = this.f38011b.remove(0);
        remove.xt(context).f(i6, eVar).b(bVar).j();
        this.f38012c.put(bVar.j(), remove);
    }

    public void m(String str, long j6, int i6, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar) {
        n(str, j6, i6, gVar, cVar, null, null);
    }

    public void o(String str, long j6, int i6, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar, w2.h hVar) {
        n(str, j6, i6, gVar, cVar, null, hVar);
    }

    private void b(Context context, int i6, com.ss.android.j.j.cw.e eVar, com.ss.android.j.j.cw.b bVar) {
        if (bVar == null) {
            return;
        }
        l lVar = new l();
        lVar.xt(context).f(i6, eVar).b(bVar).j();
        this.f38012c.put(bVar.j(), lVar);
    }

    public static c d() {
        if (f38009f == null) {
            synchronized (c.class) {
                try {
                    if (f38009f == null) {
                        f38009f = new c();
                    }
                } finally {
                }
            }
        }
        return f38009f;
    }

    private void u(Context context, int i6, com.ss.android.j.j.cw.e eVar, com.ss.android.j.j.cw.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        l lVar = new l();
        lVar.xt(context).f(i6, eVar).b(bVar).j(str).j();
        this.f38012c.put(str, lVar);
        com.ss.android.downloadlib.addownload.g.b().e(str, bVar.j());
    }

    public l c(String str) {
        Map<String, com.ss.android.downloadlib.addownload.a> map = this.f38012c;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            com.ss.android.downloadlib.addownload.a aVar = m.f().optInt("filter_download_url_key", 0) == 1 ? this.f38012c.get(com.ss.android.downloadlib.addownload.g.b().d(str)) : this.f38012c.get(str);
            if (aVar instanceof l) {
                return (l) aVar;
            }
        }
        return null;
    }

    public void f(Context context, int i6, com.ss.android.j.j.cw.e eVar, com.ss.android.j.j.cw.b bVar) {
        com.ss.android.downloadlib.addownload.a aVar;
        Context context2;
        com.ss.android.j.j.cw.e eVar2;
        if (bVar == null || TextUtils.isEmpty(bVar.j())) {
            return;
        }
        boolean z5 = m.f().optInt("filter_download_url_key", 0) == 1;
        String d6 = com.ss.android.downloadlib.addownload.g.b().d(bVar.j());
        if (!z5 || TextUtils.isEmpty(d6)) {
            aVar = this.f38012c.get(bVar.j());
        } else {
            aVar = this.f38012c.get(d6);
            if (bVar instanceof com.ss.android.xt.j.j.a) {
                com.ss.android.xt.j.j.a aVar2 = (com.ss.android.xt.j.j.a) bVar;
                if (TextUtils.isEmpty(aVar2.k())) {
                    aVar2.u(d6);
                }
            }
        }
        if (aVar != null) {
            aVar.xt(context).f(i6, eVar).b(bVar).j();
            return;
        }
        if (!this.f38011b.isEmpty()) {
            if (!z5) {
                t(context, i6, eVar, bVar);
                return;
            }
            if (!TextUtils.isEmpty(d6)) {
                g(context, i6, eVar, bVar, d6);
                return;
            }
            String c6 = com.ss.android.downloadlib.addownload.g.b().c(bVar);
            if (TextUtils.isEmpty(c6)) {
                t(context, i6, eVar, bVar);
                return;
            }
            g(context, i6, eVar, bVar, c6);
            if (bVar instanceof com.ss.android.xt.j.j.a) {
                com.ss.android.xt.j.j.a aVar3 = (com.ss.android.xt.j.j.a) bVar;
                if (TextUtils.isEmpty(aVar3.k())) {
                    aVar3.u(c6);
                    return;
                }
                return;
            }
            return;
        }
        if (!z5) {
            context2 = context;
            eVar2 = eVar;
        } else {
            if (!TextUtils.isEmpty(d6)) {
                u(context, i6, eVar, bVar, d6);
                return;
            }
            context2 = context;
            eVar2 = eVar;
            String c7 = com.ss.android.downloadlib.addownload.g.b().c(bVar);
            if (!TextUtils.isEmpty(c7)) {
                u(context2, i6, eVar2, bVar, c7);
                if (bVar instanceof com.ss.android.xt.j.j.a) {
                    com.ss.android.xt.j.j.a aVar4 = (com.ss.android.xt.j.j.a) bVar;
                    if (TextUtils.isEmpty(aVar4.k())) {
                        aVar4.u(c7);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        b(context2, i6, eVar2, bVar);
    }

    public void h(com.ss.android.j.j.cw.b bVar, @Nullable com.ss.android.j.j.cw.c cVar, @Nullable com.ss.android.j.j.cw.g gVar) {
        this.f38010a.post(new a(bVar, cVar, gVar));
    }

    public void i(cw cwVar) {
        this.f38010a.post(new e(cwVar));
    }

    public void j(cw cwVar, com.ss.android.socialbase.downloader.up.j jVar, String str) {
        this.f38010a.post(new b(cwVar, jVar, str));
    }

    public void k(cw cwVar, String str) {
        this.f38010a.post(new RunnableC0754c(cwVar, str));
    }

    public void q(t2.a aVar) {
        if (aVar != null) {
            if (com.ss.android.socialbase.downloader.jy.j.cw().xt("fix_listener_oom", false)) {
                this.f38013d.add(new SoftReference(aVar));
            } else {
                this.f38013d.add(aVar);
            }
        }
    }

    public Handler s() {
        return this.f38010a;
    }

    public void v(cw cwVar, String str) {
        this.f38010a.post(new d(cwVar, str));
    }

    private c() {
    }

    private void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f38014e >= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            this.f38014e = currentTimeMillis;
            if (!this.f38011b.isEmpty()) {
                r();
            }
        }
    }

    private void r() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.a aVar : this.f38011b) {
            if (!aVar.xt() && currentTimeMillis - aVar.r() > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                aVar.tl();
                arrayList.add(aVar);
            }
        }
        if (!arrayList.isEmpty()) {
            this.f38011b.removeAll(arrayList);
        }
    }

    public void l(String str, int i6) {
        com.ss.android.downloadlib.addownload.a aVar;
        if (!TextUtils.isEmpty(str)) {
            boolean z5 = false;
            if (m.f().optInt("filter_download_url_key", 0) == 1) {
                z5 = true;
            }
            String d6 = com.ss.android.downloadlib.addownload.g.b().d(str);
            if (z5 && !TextUtils.isEmpty(d6)) {
                aVar = this.f38012c.get(d6);
            } else {
                aVar = this.f38012c.get(str);
            }
            if (aVar != null) {
                if (aVar.j(i6)) {
                    this.f38011b.add(aVar);
                    if (z5 && !TextUtils.isEmpty(d6)) {
                        this.f38012c.remove(d6);
                        com.ss.android.downloadlib.addownload.g.b().f(d6);
                    } else {
                        this.f38012c.remove(str);
                    }
                }
                a();
            }
        }
    }

    public void n(String str, long j6, int i6, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar, w2.d dVar, w2.h hVar) {
        com.ss.android.downloadlib.addownload.a aVar;
        if (!TextUtils.isEmpty(str)) {
            boolean z5 = false;
            if (m.f().optInt("filter_download_url_key", 0) == 1) {
                z5 = true;
            }
            String d6 = com.ss.android.downloadlib.addownload.g.b().d(str);
            if (z5 && !TextUtils.isEmpty(d6)) {
                aVar = this.f38012c.get(d6);
            } else {
                aVar = this.f38012c.get(str);
            }
            if (aVar != null) {
                aVar.j(j6).c(gVar).e(cVar).d(dVar).a(hVar).xt(i6);
            }
        }
    }

    public void p(String str, boolean z5) {
        com.ss.android.downloadlib.addownload.a aVar;
        if (!TextUtils.isEmpty(str)) {
            boolean z6 = false;
            if (m.f().optInt("filter_download_url_key", 0) == 1) {
                z6 = true;
            }
            String d6 = com.ss.android.downloadlib.addownload.g.b().d(str);
            if (z6 && !TextUtils.isEmpty(d6)) {
                aVar = this.f38012c.get(d6);
            } else {
                aVar = this.f38012c.get(str);
            }
            if (aVar != null) {
                aVar.j(z5);
            }
        }
    }
}
