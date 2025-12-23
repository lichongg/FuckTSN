package kotlinx.coroutines.debug.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlin.ranges.t;
import kotlinx.coroutines.internal.s0;
import m3.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b<K, V> extends kotlin.collections.i<K, V> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f48499b = AtomicIntegerFieldUpdater.newUpdater(b.class, "_size");

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f48500c = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "core");

    @Volatile
    private volatile int _size;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final ReferenceQueue<K> f48501a;

    @Volatile
    @Nullable
    private volatile Object core;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class a {

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        private static final AtomicIntegerFieldUpdater f48502g = AtomicIntegerFieldUpdater.newUpdater(a.class, "load");

        /* renamed from: a, reason: collision with root package name */
        private final int f48503a;

        /* renamed from: b, reason: collision with root package name */
        private final int f48504b;

        /* renamed from: c, reason: collision with root package name */
        private final int f48505c;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private final AtomicReferenceArray f48506d;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private final AtomicReferenceArray f48507e;

        @Volatile
        private volatile int load;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
        /* renamed from: kotlinx.coroutines.debug.internal.b$a$a, reason: collision with other inner class name */
        private final class C0932a<E> implements Iterator<E>, m3.d {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            private final Function2<K, V, E> f48509a;

            /* renamed from: b, reason: collision with root package name */
            private int f48510b = -1;

            /* renamed from: c, reason: collision with root package name */
            private K f48511c;

            /* renamed from: d, reason: collision with root package name */
            private V f48512d;

            /* JADX WARN: Multi-variable type inference failed */
            public C0932a(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
                this.f48509a = function2;
                a();
            }

            private final void a() {
                K k6;
                while (true) {
                    int i6 = this.f48510b + 1;
                    this.f48510b = i6;
                    if (i6 >= ((a) a.this).f48503a) {
                        return;
                    }
                    i iVar = (i) ((a) a.this).f48506d.get(this.f48510b);
                    if (iVar != null && (k6 = (K) iVar.get()) != null) {
                        this.f48511c = k6;
                        Object obj = (V) ((a) a.this).f48507e.get(this.f48510b);
                        if (obj instanceof j) {
                            obj = (V) ((j) obj).f48551a;
                        }
                        if (obj != null) {
                            this.f48512d = (V) obj;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f48510b < ((a) a.this).f48503a;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.f48510b >= ((a) a.this).f48503a) {
                    throw new NoSuchElementException();
                }
                Function2<K, V, E> function2 = this.f48509a;
                K k6 = this.f48511c;
                if (k6 == false) {
                    g0.S("key");
                    k6 = (K) n1.f44123a;
                }
                V v5 = this.f48512d;
                if (v5 == false) {
                    g0.S("value");
                    v5 = (V) n1.f44123a;
                }
                E e6 = (E) function2.invoke(k6, v5);
                a();
                return e6;
            }

            @Override // java.util.Iterator
            @NotNull
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public Void remove() {
                kotlinx.coroutines.debug.internal.c.e();
                throw new KotlinNothingValueException();
            }
        }

        public a(int i6) {
            this.f48503a = i6;
            this.f48504b = Integer.numberOfLeadingZeros(i6) + 1;
            this.f48505c = (i6 * 2) / 3;
            this.f48506d = new AtomicReferenceArray(i6);
            this.f48507e = new AtomicReferenceArray(i6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object i(a aVar, Object obj, Object obj2, i iVar, int i6, Object obj3) {
            if ((i6 & 4) != 0) {
                iVar = null;
            }
            return aVar.h(obj, obj2, iVar);
        }

        private final void k(int i6) {
            Object obj;
            do {
                obj = this.f48507e.get(i6);
                if (obj == null || (obj instanceof j)) {
                    return;
                }
            } while (!com.google.common.util.concurrent.b.a(this.f48507e, i6, obj, null));
            b.this.j();
        }

        public final void d(@NotNull i<?> iVar) {
            int f6 = f(iVar.f48550a);
            while (true) {
                i<?> iVar2 = (i) this.f48506d.get(f6);
                if (iVar2 == null) {
                    return;
                }
                if (iVar2 == iVar) {
                    k(f6);
                    return;
                } else {
                    if (f6 == 0) {
                        f6 = this.f48503a;
                    }
                    f6--;
                }
            }
        }

        @NotNull
        public final <E> Iterator<E> g(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
            return new C0932a(function2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final b<K, V>.a j() {
            Object obj;
            s0 s0Var;
            j d6;
            while (true) {
                b<K, V>.a aVar = (b<K, V>.a) b.this.new a(Integer.highestOneBit(t.u(b.this.size(), 4)) * 4);
                int i6 = this.f48503a;
                for (int i7 = 0; i7 < i6; i7++) {
                    i iVar = (i) this.f48506d.get(i7);
                    Object obj2 = iVar != null ? iVar.get() : null;
                    if (iVar != null && obj2 == null) {
                        k(i7);
                    }
                    while (true) {
                        obj = this.f48507e.get(i7);
                        if (obj instanceof j) {
                            obj = ((j) obj).f48551a;
                            break;
                        }
                        AtomicReferenceArray atomicReferenceArray = this.f48507e;
                        d6 = kotlinx.coroutines.debug.internal.c.d(obj);
                        if (com.google.common.util.concurrent.b.a(atomicReferenceArray, i7, obj, d6)) {
                            break;
                        }
                    }
                    if (obj2 != null && obj != null) {
                        Object h6 = aVar.h(obj2, obj, iVar);
                        s0Var = kotlinx.coroutines.debug.internal.c.f48522c;
                        if (h6 != s0Var) {
                        }
                    }
                }
                return aVar;
            }
        }

        private final int f(int i6) {
            return (i6 * (-1640531527)) >>> this.f48504b;
        }

        private final void l(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Integer> function1, Object obj) {
            int i6;
            do {
                i6 = atomicIntegerFieldUpdater.get(obj);
            } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i6, function1.invoke(Integer.valueOf(i6)).intValue()));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public final V e(@NotNull K k6) {
            int f6 = f(k6.hashCode());
            while (true) {
                i iVar = (i) this.f48506d.get(f6);
                if (iVar == null) {
                    return null;
                }
                T t5 = iVar.get();
                if (g0.g(k6, t5)) {
                    V v5 = (V) this.f48507e.get(f6);
                    if (v5 instanceof j) {
                        return (V) ((j) v5).f48551a;
                    }
                    return v5;
                }
                if (t5 == 0) {
                    k(f6);
                }
                if (f6 == 0) {
                    f6 = this.f48503a;
                }
                f6--;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        
            r6 = r5.f48507e.get(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        
            if ((r6 instanceof kotlinx.coroutines.debug.internal.j) == false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
        
            if (com.google.common.util.concurrent.b.a(r5.f48507e, r0, r6, r7) == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
        
            r6 = kotlinx.coroutines.debug.internal.c.f48522c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
        
            return r6;
         */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object h(@org.jetbrains.annotations.NotNull K r6, @org.jetbrains.annotations.Nullable V r7, @org.jetbrains.annotations.Nullable kotlinx.coroutines.debug.internal.i<K> r8) {
            /*
                r5 = this;
                int r0 = r6.hashCode()
                int r0 = r5.f(r0)
                r1 = 0
            L9:
                java.util.concurrent.atomic.AtomicReferenceArray r2 = r5.f48506d
                java.lang.Object r2 = r2.get(r0)
                kotlinx.coroutines.debug.internal.i r2 = (kotlinx.coroutines.debug.internal.i) r2
                if (r2 != 0) goto L47
                r2 = 0
                if (r7 != 0) goto L17
                return r2
            L17:
                if (r1 != 0) goto L31
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = kotlinx.coroutines.debug.internal.b.a.f48502g
            L1b:
                int r1 = r3.get(r5)
                int r4 = r5.f48505c
                if (r1 < r4) goto L28
                kotlinx.coroutines.internal.s0 r6 = kotlinx.coroutines.debug.internal.c.a()
                return r6
            L28:
                int r4 = r1 + 1
                boolean r1 = r3.compareAndSet(r5, r1, r4)
                if (r1 == 0) goto L1b
                r1 = 1
            L31:
                if (r8 != 0) goto L3e
                kotlinx.coroutines.debug.internal.i r8 = new kotlinx.coroutines.debug.internal.i
                kotlinx.coroutines.debug.internal.b<K, V> r3 = kotlinx.coroutines.debug.internal.b.this
                java.lang.ref.ReferenceQueue r3 = kotlinx.coroutines.debug.internal.b.h(r3)
                r8.<init>(r6, r3)
            L3e:
                java.util.concurrent.atomic.AtomicReferenceArray r3 = r5.f48506d
                boolean r2 = com.google.common.util.concurrent.b.a(r3, r0, r2, r8)
                if (r2 != 0) goto L58
                goto L9
            L47:
                java.lang.Object r2 = r2.get()
                boolean r3 = kotlin.jvm.internal.g0.g(r6, r2)
                if (r3 == 0) goto L70
                if (r1 == 0) goto L58
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = kotlinx.coroutines.debug.internal.b.a.f48502g
                r6.decrementAndGet(r5)
            L58:
                java.util.concurrent.atomic.AtomicReferenceArray r6 = r5.f48507e
                java.lang.Object r6 = r6.get(r0)
                boolean r8 = r6 instanceof kotlinx.coroutines.debug.internal.j
                if (r8 == 0) goto L67
                kotlinx.coroutines.internal.s0 r6 = kotlinx.coroutines.debug.internal.c.a()
                return r6
            L67:
                java.util.concurrent.atomic.AtomicReferenceArray r8 = r5.f48507e
                boolean r8 = com.google.common.util.concurrent.b.a(r8, r0, r6, r7)
                if (r8 == 0) goto L58
                return r6
            L70:
                if (r2 != 0) goto L75
                r5.k(r0)
            L75:
                if (r0 != 0) goto L79
                int r0 = r5.f48503a
            L79:
                int r0 = r0 + (-1)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.b.a.h(java.lang.Object, java.lang.Object, kotlinx.coroutines.debug.internal.i):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlinx.coroutines.debug.internal.b$b, reason: collision with other inner class name */
    private static final class C0933b<K, V> implements Map.Entry<K, V>, g.a {

        /* renamed from: a, reason: collision with root package name */
        private final K f48514a;

        /* renamed from: b, reason: collision with root package name */
        private final V f48515b;

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f48514a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f48515b;
        }

        public C0933b(K k6, V v5) {
            this.f48514a = k6;
            this.f48515b = v5;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            kotlinx.coroutines.debug.internal.c.e();
            throw new KotlinNothingValueException();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class c<E> extends kotlin.collections.j<E> {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final Function2<K, V, E> f48516a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
            this.f48516a = function2;
        }

        @Override // kotlin.collections.j
        public int getSize() {
            return b.this.size();
        }

        @Override // kotlin.collections.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e6) {
            kotlinx.coroutines.debug.internal.c.e();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        @NotNull
        public Iterator<E> iterator() {
            return ((a) b.f48500c.get(b.this)).g(this.f48516a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d extends Lambda implements Function2<K, V, Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f48518a = new d();

        d() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map.Entry<K, V> invoke(@NotNull K k6, @NotNull V v5) {
            return new C0933b(k6, v5);
        }
    }

    public b() {
        this(false, 1, null);
    }

    private final synchronized V k(K k6, V v5) {
        V v6;
        s0 s0Var;
        a aVar = (a) f48500c.get(this);
        while (true) {
            K k7 = k6;
            V v7 = v5;
            v6 = (V) a.i(aVar, k7, v7, null, 4, null);
            s0Var = kotlinx.coroutines.debug.internal.c.f48522c;
            if (v6 == s0Var) {
                aVar = aVar.j();
                f48500c.set(this, aVar);
                k6 = k7;
                v5 = v7;
            }
        }
        return v6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V remove(@Nullable Object obj) {
        s0 s0Var;
        if (obj == 0) {
            return null;
        }
        V v5 = (V) a.i((a) f48500c.get(this), obj, null, null, 4, null);
        s0Var = kotlinx.coroutines.debug.internal.c.f48522c;
        if (v5 == s0Var) {
            v5 = k(obj, null);
        }
        if (v5 != null) {
            f48499b.decrementAndGet(this);
        }
        return v5;
    }

    public /* synthetic */ b(boolean z5, int i6, v vVar) {
        this((i6 & 1) != 0 ? false : z5);
    }

    private final void i(i<?> iVar) {
        ((a) f48500c.get(this)).d(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        f48499b.decrementAndGet(this);
    }

    @Override // kotlin.collections.i
    @NotNull
    public Set<Map.Entry<K, V>> a() {
        return new c(d.f48518a);
    }

    @Override // kotlin.collections.i
    @NotNull
    public Set<K> c() {
        return new c(e.f48519a);
    }

    @Override // kotlin.collections.i
    public int d() {
        return f48499b.get(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return (V) ((a) f48500c.get(this)).e(obj);
    }

    public final void m() {
        if (this.f48501a == null) {
            throw new IllegalStateException("Must be created with weakRefQueue = true");
        }
        while (true) {
            try {
                Reference<? extends K> remove = this.f48501a.remove();
                g0.n(remove, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                i((i) remove);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    @Override // kotlin.collections.i, java.util.AbstractMap, java.util.Map
    @Nullable
    public V put(@NotNull K k6, @NotNull V v5) {
        s0 s0Var;
        V v6 = (V) a.i((a) f48500c.get(this), k6, v5, null, 4, null);
        s0Var = kotlinx.coroutines.debug.internal.c.f48522c;
        if (v6 == s0Var) {
            v6 = k(k6, v5);
        }
        if (v6 == null) {
            f48499b.incrementAndGet(this);
        }
        return v6;
    }

    public b(boolean z5) {
        this.core = new a(16);
        this.f48501a = z5 ? new ReferenceQueue<>() : null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e extends Lambda implements Function2<K, V, K> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f48519a = new e();

        e() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        @NotNull
        public final K invoke(@NotNull K k6, @NotNull V v5) {
            return k6;
        }
    }
}
