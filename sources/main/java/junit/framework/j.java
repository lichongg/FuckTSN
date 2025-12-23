package junit.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    protected List<h> f43485a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    protected List<h> f43486b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    protected List<i> f43487c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    protected int f43488d = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f43489e = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f43490a;

        a(g gVar) throws Throwable {
            this.f43490a = gVar;
        }

        @Override // junit.framework.e
        public void a() throws Throwable {
            this.f43490a.R();
        }
    }

    private synchronized List<i> d() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f43487c);
        return arrayList;
    }

    public synchronized void a(f fVar, Throwable th) {
        this.f43486b.add(new h(fVar, th));
        Iterator<i> it = d().iterator();
        while (it.hasNext()) {
            it.next().a(fVar, th);
        }
    }

    public synchronized void b(f fVar, AssertionFailedError assertionFailedError) {
        this.f43485a.add(new h(fVar, assertionFailedError));
        Iterator<i> it = d().iterator();
        while (it.hasNext()) {
            it.next().b(fVar, assertionFailedError);
        }
    }

    public synchronized void c(i iVar) {
        this.f43487c.add(iVar);
    }

    public synchronized int f() {
        return this.f43486b.size();
    }

    public synchronized Enumeration<h> g() {
        return Collections.enumeration(this.f43486b);
    }

    public synchronized int h() {
        return this.f43485a.size();
    }

    public synchronized Enumeration<h> i() {
        return Collections.enumeration(this.f43485a);
    }

    public synchronized void j(i iVar) {
        this.f43487c.remove(iVar);
    }

    public synchronized int l() {
        return this.f43488d;
    }

    public synchronized boolean n() {
        return this.f43489e;
    }

    public synchronized void p() {
        this.f43489e = true;
    }

    public synchronized boolean q() {
        boolean z5;
        if (h() == 0) {
            z5 = f() == 0;
        }
        return z5;
    }

    public void e(f fVar) {
        Iterator<i> it = d().iterator();
        while (it.hasNext()) {
            it.next().c(fVar);
        }
    }

    protected void k(g gVar) {
        o(gVar);
        m(gVar, new a(gVar));
        e(gVar);
    }

    public void m(f fVar, e eVar) {
        try {
            eVar.a();
        } catch (ThreadDeath e6) {
            throw e6;
        } catch (AssertionFailedError e7) {
            b(fVar, e7);
        } catch (Throwable th) {
            a(fVar, th);
        }
    }

    public void o(f fVar) {
        int c6 = fVar.c();
        synchronized (this) {
            this.f43488d += c6;
        }
        Iterator<i> it = d().iterator();
        while (it.hasNext()) {
            it.next().d(fVar);
        }
    }
}
