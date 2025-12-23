package master.flame.danmaku.danmaku.model.android;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import master.flame.danmaku.danmaku.model.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class e implements m {

    /* renamed from: e, reason: collision with root package name */
    public Collection<master.flame.danmaku.danmaku.model.d> f50019e;

    /* renamed from: f, reason: collision with root package name */
    private e f50020f;

    /* renamed from: g, reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.d f50021g;

    /* renamed from: h, reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.d f50022h;

    /* renamed from: i, reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.d f50023i;

    /* renamed from: j, reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.d f50024j;

    /* renamed from: k, reason: collision with root package name */
    private volatile AtomicInteger f50025k;

    /* renamed from: l, reason: collision with root package name */
    private int f50026l;

    /* renamed from: m, reason: collision with root package name */
    private m.a f50027m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f50028n;

    /* renamed from: o, reason: collision with root package name */
    private Object f50029o;

    public e() {
        this(0, false);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public boolean e(master.flame.danmaku.danmaku.model.d dVar) {
        if (dVar == null) {
            return false;
        }
        if (dVar.s()) {
            dVar.G(false);
        }
        if (!this.f50019e.remove(dVar)) {
            return false;
        }
        this.f50025k.decrementAndGet();
        return true;
    }

    public e(int i6) {
        this(i6, false);
    }

    private master.flame.danmaku.danmaku.model.d k(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    private void l(boolean z5) {
        this.f50027m.b(z5);
        this.f50028n = z5;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> n(long j6, long j7) {
        Collection<master.flame.danmaku.danmaku.model.d> collection;
        if (this.f50026l == 4 || (collection = this.f50019e) == null || collection.size() == 0) {
            return null;
        }
        if (this.f50020f == null) {
            e eVar = new e(this.f50028n);
            this.f50020f = eVar;
            eVar.f50029o = this.f50029o;
        }
        if (this.f50024j == null) {
            this.f50024j = k("start");
        }
        if (this.f50023i == null) {
            this.f50023i = k("end");
        }
        this.f50024j.D(j6);
        this.f50023i.D(j7);
        return ((SortedSet) this.f50019e).subSet(this.f50024j, this.f50023i);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(m.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.f50029o) {
            f(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void b(boolean z5) {
        this.f50028n = z5;
        this.f50022h = null;
        this.f50021g = null;
        if (this.f50020f == null) {
            e eVar = new e(z5);
            this.f50020f = eVar;
            eVar.f50029o = this.f50029o;
        }
        this.f50020f.l(z5);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public Object c() {
        return this.f50029o;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void clear() {
        Collection<master.flame.danmaku.danmaku.model.d> collection = this.f50019e;
        if (collection != null) {
            collection.clear();
            this.f50025k.set(0);
        }
        if (this.f50020f != null) {
            this.f50020f = null;
            this.f50021g = k("start");
            this.f50022h = k("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public m d(long j6, long j7) {
        Collection<master.flame.danmaku.danmaku.model.d> collection = this.f50019e;
        if (collection == null || collection.size() == 0) {
            return null;
        }
        if (this.f50020f == null) {
            if (this.f50026l == 4) {
                e eVar = new e(4);
                this.f50020f = eVar;
                eVar.f50029o = this.f50029o;
                synchronized (this.f50029o) {
                    this.f50020f.m(this.f50019e);
                }
            } else {
                e eVar2 = new e(this.f50028n);
                this.f50020f = eVar2;
                eVar2.f50029o = this.f50029o;
            }
        }
        if (this.f50026l == 4) {
            return this.f50020f;
        }
        if (this.f50021g == null) {
            this.f50021g = k("start");
        }
        if (this.f50022h == null) {
            this.f50022h = k("end");
        }
        if (this.f50020f != null && j6 - this.f50021g.b() >= 0 && j7 <= this.f50022h.b()) {
            return this.f50020f;
        }
        this.f50021g.D(j6);
        this.f50022h.D(j7);
        synchronized (this.f50029o) {
            this.f50020f.m(((SortedSet) this.f50019e).subSet(this.f50021g, this.f50022h));
        }
        return this.f50020f;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public master.flame.danmaku.danmaku.model.d first() {
        Collection<master.flame.danmaku.danmaku.model.d> collection = this.f50019e;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        return this.f50026l == 4 ? (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.f50019e).peek() : (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.f50019e).first();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public boolean g(master.flame.danmaku.danmaku.model.d dVar) {
        Collection<master.flame.danmaku.danmaku.model.d> collection = this.f50019e;
        return collection != null && collection.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public Collection<master.flame.danmaku.danmaku.model.d> h() {
        return this.f50019e;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public boolean isEmpty() {
        Collection<master.flame.danmaku.danmaku.model.d> collection = this.f50019e;
        return collection == null || collection.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public boolean j(master.flame.danmaku.danmaku.model.d dVar) {
        Collection<master.flame.danmaku.danmaku.model.d> collection = this.f50019e;
        if (collection == null) {
            return false;
        }
        try {
            if (!collection.add(dVar)) {
                return false;
            }
            this.f50025k.incrementAndGet();
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public master.flame.danmaku.danmaku.model.d last() {
        Collection<master.flame.danmaku.danmaku.model.d> collection = this.f50019e;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        return this.f50026l == 4 ? (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.f50019e).peekLast() : (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.f50019e).last();
    }

    public void m(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        if (!this.f50028n || this.f50026l == 4) {
            this.f50019e = collection;
        } else {
            this.f50019e.clear();
            this.f50019e.addAll(collection);
            collection = this.f50019e;
        }
        if (collection instanceof List) {
            this.f50026l = 4;
        }
        this.f50025k.set(collection == null ? 0 : collection.size());
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int size() {
        return this.f50025k.get();
    }

    public e(int i6, boolean z5) {
        m.a fVar;
        this.f50025k = new AtomicInteger(0);
        this.f50026l = 0;
        this.f50029o = new Object();
        if (i6 == 0) {
            fVar = new m.d(z5);
        } else if (i6 == 1) {
            fVar = new m.e(z5);
        } else {
            fVar = i6 == 2 ? new m.f(z5) : null;
        }
        if (i6 == 4) {
            this.f50019e = new LinkedList();
        } else {
            this.f50028n = z5;
            fVar.b(z5);
            this.f50019e = new TreeSet(fVar);
            this.f50027m = fVar;
        }
        this.f50026l = i6;
        this.f50025k.set(0);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void f(m.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.c();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.f50019e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            master.flame.danmaku.danmaku.model.d next = it.next();
            if (next != null) {
                int a6 = bVar.a(next);
                if (a6 == 1) {
                    break;
                }
                if (a6 == 2) {
                    it.remove();
                    this.f50025k.decrementAndGet();
                } else if (a6 == 3) {
                    it.remove();
                    this.f50025k.decrementAndGet();
                    break;
                }
            }
        }
        bVar.b();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public m i(long j6, long j7) {
        Collection<master.flame.danmaku.danmaku.model.d> n6 = n(j6, j7);
        if (n6 != null && !n6.isEmpty()) {
            return new e(new LinkedList(n6));
        }
        return null;
    }

    public e(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        this.f50025k = new AtomicInteger(0);
        this.f50026l = 0;
        this.f50029o = new Object();
        m(collection);
    }

    public e(boolean z5) {
        this(0, z5);
    }
}
