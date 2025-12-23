package com.bumptech.glide.load.engine.bitmap_recycle;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.bitmap_recycle.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class h<K extends n, V> {

    /* renamed from: a, reason: collision with root package name */
    private final a<K, V> f15015a = new a<>();

    /* renamed from: b, reason: collision with root package name */
    private final Map<K, a<K, V>> f15016b = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f15017a;

        /* renamed from: b, reason: collision with root package name */
        private List<V> f15018b;

        /* renamed from: c, reason: collision with root package name */
        a<K, V> f15019c;

        /* renamed from: d, reason: collision with root package name */
        a<K, V> f15020d;

        a() {
            this(null);
        }

        a(K k6) {
            this.f15020d = this;
            this.f15019c = this;
            this.f15017a = k6;
        }

        public void a(V v5) {
            if (this.f15018b == null) {
                this.f15018b = new ArrayList();
            }
            this.f15018b.add(v5);
        }

        public int c() {
            List<V> list = this.f15018b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Nullable
        public V b() {
            int c6 = c();
            if (c6 > 0) {
                return this.f15018b.remove(c6 - 1);
            }
            return null;
        }
    }

    private static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f15020d;
        aVar2.f15019c = aVar.f15019c;
        aVar.f15019c.f15020d = aVar2;
    }

    private static <K, V> void g(a<K, V> aVar) {
        aVar.f15019c.f15020d = aVar;
        aVar.f15020d.f15019c = aVar;
    }

    @Nullable
    public V a(K k6) {
        a<K, V> aVar = this.f15016b.get(k6);
        if (aVar == null) {
            aVar = new a<>(k6);
            this.f15016b.put(k6, aVar);
        } else {
            k6.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(K k6, V v5) {
        a<K, V> aVar = this.f15016b.get(k6);
        if (aVar == null) {
            aVar = new a<>(k6);
            c(aVar);
            this.f15016b.put(k6, aVar);
        } else {
            k6.a();
        }
        aVar.a(v5);
    }

    @Nullable
    public V f() {
        for (a aVar = this.f15015a.f15020d; !aVar.equals(this.f15015a); aVar = aVar.f15020d) {
            V v5 = (V) aVar.b();
            if (v5 != null) {
                return v5;
            }
            e(aVar);
            this.f15016b.remove(aVar.f15017a);
            ((n) aVar.f15017a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.f15015a.f15019c;
        boolean z5 = false;
        while (!aVar.equals(this.f15015a)) {
            sb.append('{');
            sb.append(aVar.f15017a);
            sb.append(':');
            sb.append(aVar.c());
            sb.append("}, ");
            aVar = aVar.f15019c;
            z5 = true;
        }
        if (z5) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    h() {
    }

    private void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f15015a;
        aVar.f15020d = aVar2;
        aVar.f15019c = aVar2.f15019c;
        g(aVar);
    }

    private void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f15015a;
        aVar.f15020d = aVar2.f15020d;
        aVar.f15019c = aVar2;
        g(aVar);
    }
}
