package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.n;
import kotlin.collections.u1;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSmartSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmartSet.kt\norg/jetbrains/kotlin/utils/SmartSet\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n1#2:111\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k<T> extends kotlin.collections.j<T> {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final b f47493c = new b(null);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private Object f47494a;

    /* renamed from: b, reason: collision with root package name */
    private int f47495b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a<T> implements Iterator<T>, m3.d {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final Iterator<T> f47496a;

        public a(@NotNull T[] array) {
            g0.p(array, "array");
            this.f47496a = kotlin.jvm.internal.h.a(array);
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f47496a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f47496a.next();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSmartSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmartSet.kt\norg/jetbrains/kotlin/utils/SmartSet$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n1#2:111\n*E\n"})
    public static final class b {
        public /* synthetic */ b(v vVar) {
            this();
        }

        private b() {
        }

        @JvmStatic
        @NotNull
        public final <T> k<T> a() {
            return new k<>(null);
        }

        @JvmStatic
        @NotNull
        public final <T> k<T> b(@NotNull Collection<? extends T> set) {
            g0.p(set, "set");
            k<T> kVar = new k<>(null);
            kVar.addAll(set);
            return kVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c<T> implements Iterator<T>, m3.d {

        /* renamed from: a, reason: collision with root package name */
        private final T f47497a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f47498b = true;

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f47498b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f47498b) {
                throw new NoSuchElementException();
            }
            this.f47498b = false;
            return this.f47497a;
        }

        public c(T t5) {
            this.f47497a = t5;
        }
    }

    public /* synthetic */ k(v vVar) {
        this();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f47494a = null;
        d(0);
    }

    private k() {
    }

    @JvmStatic
    @NotNull
    public static final <T> k<T> a() {
        return f47493c.a();
    }

    public void d(int i6) {
        this.f47495b = i6;
    }

    @Override // kotlin.collections.j
    public int getSize() {
        return this.f47495b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.AbstractCollection, java.util.LinkedHashSet] */
    @Override // kotlin.collections.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t5) {
        Object[] objArr;
        if (size() == 0) {
            this.f47494a = t5;
        } else if (size() == 1) {
            if (g0.g(this.f47494a, t5)) {
                return false;
            }
            this.f47494a = new Object[]{this.f47494a, t5};
        } else if (size() < 5) {
            Object obj = this.f47494a;
            g0.n(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr2 = (Object[]) obj;
            if (n.B8(objArr2, t5)) {
                return false;
            }
            if (size() == 4) {
                ?? o5 = u1.o(Arrays.copyOf(objArr2, objArr2.length));
                o5.add(t5);
                objArr = o5;
            } else {
                Object[] copyOf = Arrays.copyOf(objArr2, size() + 1);
                g0.o(copyOf, "copyOf(...)");
                copyOf[copyOf.length - 1] = t5;
                objArr = copyOf;
            }
            this.f47494a = objArr;
        } else {
            Object obj2 = this.f47494a;
            g0.n(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!u0.o(obj2).add(t5)) {
                return false;
            }
        }
        d(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return g0.g(this.f47494a, obj);
        }
        if (size() < 5) {
            Object obj2 = this.f47494a;
            g0.n(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return n.B8((Object[]) obj2, obj);
        }
        Object obj3 = this.f47494a;
        g0.n(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @NotNull
    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.EMPTY_SET.iterator();
        }
        if (size() == 1) {
            return new c(this.f47494a);
        }
        if (size() < 5) {
            Object obj = this.f47494a;
            g0.n(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new a((Object[]) obj);
        }
        Object obj2 = this.f47494a;
        g0.n(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return u0.o(obj2).iterator();
    }
}
