package com.amap.api.col.s;

import com.amap.api.col.s.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class o {

    /* renamed from: a, reason: collision with root package name */
    private boolean f8275a = true;

    /* renamed from: b, reason: collision with root package name */
    private long f8276b = 86400;

    /* renamed from: c, reason: collision with root package name */
    private int f8277c = 10;

    /* renamed from: d, reason: collision with root package name */
    private long f8278d = 0;

    /* renamed from: e, reason: collision with root package name */
    private final LinkedHashMap<n.b, Object> f8279e = new LinkedHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private final Object f8280f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private final LinkedHashMap<n.b, Object> f8281g = new LinkedHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final Object f8282h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<String> f8283i = new ArrayList<>();

    public final boolean j(n.b bVar) {
        if (bVar != null && bVar.f8260a != null) {
            Iterator<String> it = this.f8283i.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && bVar.f8260a.contains(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void b() {
        n.b bVar;
        int size = this.f8279e.size();
        if (size <= 0 || size < this.f8277c) {
            return;
        }
        Iterator<n.b> it = this.f8279e.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            } else {
                bVar = it.next();
                if (bVar != null) {
                    break;
                }
            }
        }
        k(this.f8279e, bVar);
    }

    private void i(n.b bVar, Object obj) {
        synchronized (this.f8280f) {
            b();
            h();
            this.f8279e.put(bVar, obj);
        }
    }

    public final n.c a(n.b bVar) {
        if (!this.f8275a || bVar == null || !j(bVar)) {
            return null;
        }
        h();
        synchronized (this.f8280f) {
            try {
                if (f(this.f8279e, bVar)) {
                    return new n.c(g(this.f8279e, bVar), true);
                }
                synchronized (this.f8282h) {
                    if (f(this.f8281g, bVar)) {
                        while (!f(this.f8279e, bVar) && f(this.f8281g, bVar)) {
                            try {
                                this.f8282h.wait(1000L);
                            } catch (InterruptedException e6) {
                                e6.printStackTrace();
                            }
                        }
                    } else {
                        this.f8281g.put(bVar, null);
                    }
                }
                return new n.c(g(this.f8279e, bVar), false);
            } finally {
            }
        }
    }

    public void c(n.a aVar) {
        if (aVar != null) {
            this.f8275a = aVar.e();
            this.f8276b = aVar.f();
            this.f8277c = aVar.g();
        }
    }

    public final void d(n.b bVar, Object obj) {
        if (this.f8275a && bVar != null && j(bVar)) {
            i(bVar, obj);
            synchronized (this.f8282h) {
                k(this.f8281g, bVar);
                this.f8282h.notify();
            }
        }
    }

    protected boolean f(LinkedHashMap<n.b, Object> linkedHashMap, n.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return false;
        }
        return linkedHashMap.containsKey(bVar);
    }

    protected Object g(LinkedHashMap<n.b, Object> linkedHashMap, n.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.get(bVar);
    }

    protected Object k(LinkedHashMap<n.b, Object> linkedHashMap, n.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.remove(bVar);
    }

    public o(String... strArr) {
        e(strArr);
    }

    private void e(String... strArr) {
        this.f8278d = System.currentTimeMillis();
        this.f8279e.clear();
        this.f8283i.clear();
        for (String str : strArr) {
            if (str != null) {
                this.f8283i.add(str);
            }
        }
    }

    private void h() {
        long currentTimeMillis = System.currentTimeMillis();
        if ((currentTimeMillis - this.f8278d) / 1000 > this.f8276b) {
            this.f8279e.clear();
            this.f8278d = currentTimeMillis;
        }
    }
}
