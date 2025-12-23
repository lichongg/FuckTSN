package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class j implements com.bumptech.glide.load.engine.bitmap_recycle.b {

    /* renamed from: h, reason: collision with root package name */
    private static final int f15022h = 4194304;

    /* renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    static final int f15023i = 8;

    /* renamed from: j, reason: collision with root package name */
    private static final int f15024j = 2;

    /* renamed from: b, reason: collision with root package name */
    private final h<a, Object> f15025b;

    /* renamed from: c, reason: collision with root package name */
    private final b f15026c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f15027d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.engine.bitmap_recycle.a<?>> f15028e;

    /* renamed from: f, reason: collision with root package name */
    private final int f15029f;

    /* renamed from: g, reason: collision with root package name */
    private int f15030g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a implements n {

        /* renamed from: a, reason: collision with root package name */
        private final b f15031a;

        /* renamed from: b, reason: collision with root package name */
        int f15032b;

        /* renamed from: c, reason: collision with root package name */
        private Class<?> f15033c;

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.n
        public void a() {
            this.f15031a.c(this);
        }

        void b(int i6, Class<?> cls) {
            this.f15032b = i6;
            this.f15033c = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f15032b == aVar.f15032b && this.f15033c == aVar.f15033c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i6 = this.f15032b * 31;
            Class<?> cls = this.f15033c;
            return i6 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f15032b + "array=" + this.f15033c + '}';
        }

        a(b bVar) {
            this.f15031a = bVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b extends d<a> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        b() {
        }

        a e(int i6, Class<?> cls) {
            a b6 = b();
            b6.b(i6, cls);
            return b6;
        }
    }

    @VisibleForTesting
    public j() {
        this.f15025b = new h<>();
        this.f15026c = new b();
        this.f15027d = new HashMap();
        this.f15028e = new HashMap();
        this.f15029f = 4194304;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    public synchronized void a(int i6) {
        try {
            if (i6 >= 40) {
                b();
            } else if (i6 >= 20 || i6 == 15) {
                h(this.f15029f / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    public synchronized void b() {
        h(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    public synchronized <T> T c(int i6, Class<T> cls) {
        Integer ceilingKey;
        try {
            ceilingKey = n(cls).ceilingKey(Integer.valueOf(i6));
        } catch (Throwable th) {
            throw th;
        }
        return (T) m(q(i6, ceilingKey) ? this.f15026c.e(ceilingKey.intValue(), cls) : this.f15026c.e(i6, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    public synchronized <T> T d(int i6, Class<T> cls) {
        return (T) m(this.f15026c.e(i6, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    public synchronized <T> void put(T t5) {
        Class<?> cls = t5.getClass();
        com.bumptech.glide.load.engine.bitmap_recycle.a<T> j6 = j(cls);
        int a6 = j6.a(t5);
        int b6 = j6.b() * a6;
        if (p(b6)) {
            a e6 = this.f15026c.e(a6, cls);
            this.f15025b.d(e6, t5);
            NavigableMap<Integer, Integer> n6 = n(cls);
            Integer num = n6.get(Integer.valueOf(e6.f15032b));
            Integer valueOf = Integer.valueOf(e6.f15032b);
            int i6 = 1;
            if (num != null) {
                i6 = 1 + num.intValue();
            }
            n6.put(valueOf, Integer.valueOf(i6));
            this.f15030g += b6;
            g();
        }
    }

    private void g() {
        h(this.f15029f);
    }

    private void h(int i6) {
        while (this.f15030g > i6) {
            Object f6 = this.f15025b.f();
            com.bumptech.glide.util.k.d(f6);
            com.bumptech.glide.load.engine.bitmap_recycle.a i7 = i(f6);
            this.f15030g -= i7.a(f6) * i7.b();
            f(i7.a(f6), f6.getClass());
            if (Log.isLoggable(i7.getTag(), 2)) {
                i7.getTag();
                i7.a(f6);
            }
        }
    }

    private <T> com.bumptech.glide.load.engine.bitmap_recycle.a<T> j(Class<T> cls) {
        com.bumptech.glide.load.engine.bitmap_recycle.a<T> gVar;
        com.bumptech.glide.load.engine.bitmap_recycle.a<T> aVar = (com.bumptech.glide.load.engine.bitmap_recycle.a) this.f15028e.get(cls);
        if (aVar != null) {
            return aVar;
        }
        if (cls.equals(int[].class)) {
            gVar = new i();
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            gVar = new g();
        }
        this.f15028e.put(cls, gVar);
        return gVar;
    }

    @Nullable
    private <T> T k(a aVar) {
        return (T) this.f15025b.a(aVar);
    }

    private NavigableMap<Integer, Integer> n(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f15027d.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f15027d.put(cls, treeMap);
        return treeMap;
    }

    private boolean o() {
        int i6 = this.f15030g;
        return i6 == 0 || this.f15029f / i6 >= 2;
    }

    private boolean p(int i6) {
        return i6 <= this.f15029f / 2;
    }

    private boolean q(int i6, Integer num) {
        if (num != null) {
            return o() || num.intValue() <= i6 * 8;
        }
        return false;
    }

    int l() {
        int i6 = 0;
        for (Class<?> cls : this.f15027d.keySet()) {
            for (Integer num : this.f15027d.get(cls).keySet()) {
                i6 += num.intValue() * this.f15027d.get(cls).get(num).intValue() * j(cls).b();
            }
        }
        return i6;
    }

    private void f(int i6, Class<?> cls) {
        NavigableMap<Integer, Integer> n6 = n(cls);
        Integer num = n6.get(Integer.valueOf(i6));
        if (num != null) {
            if (num.intValue() == 1) {
                n6.remove(Integer.valueOf(i6));
                return;
            } else {
                n6.put(Integer.valueOf(i6), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i6 + ", this: " + this);
    }

    private <T> com.bumptech.glide.load.engine.bitmap_recycle.a<T> i(T t5) {
        return j(t5.getClass());
    }

    private <T> T m(a aVar, Class<T> cls) {
        com.bumptech.glide.load.engine.bitmap_recycle.a<T> j6 = j(cls);
        T t5 = (T) k(aVar);
        if (t5 != null) {
            this.f15030g -= j6.a(t5) * j6.b();
            f(j6.a(t5), cls);
        }
        if (t5 == null) {
            if (Log.isLoggable(j6.getTag(), 2)) {
                j6.getTag();
                int i6 = aVar.f15032b;
            }
            return j6.newArray(aVar.f15032b);
        }
        return t5;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    @Deprecated
    public <T> void e(T t5, Class<T> cls) {
        put(t5);
    }

    public j(int i6) {
        this.f15025b = new h<>();
        this.f15026c = new b();
        this.f15027d = new HashMap();
        this.f15028e = new HashMap();
        this.f15029f = i6;
    }
}
