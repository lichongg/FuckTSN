package kotlin.collections;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = BuildConfig.VERSION_NAME)
@SourceDebugExtension({"SMAP\nArrayDeque.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,660:1\n476#1,53:663\n476#1,53:716\n37#2,2:661\n*S KotlinDebug\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n*L\n471#1:663,53\n473#1:716,53\n46#1:661,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m<E> extends h<E> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f43655d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Object[] f43656e = new Object[0];

    /* renamed from: f, reason: collision with root package name */
    private static final int f43657f = 10;

    /* renamed from: a, reason: collision with root package name */
    private int f43658a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private Object[] f43659b;

    /* renamed from: c, reason: collision with root package name */
    private int f43660c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    public m(int i6) {
        Object[] objArr;
        if (i6 == 0) {
            objArr = f43656e;
        } else {
            if (i6 <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i6);
            }
            objArr = new Object[i6];
        }
        this.f43659b = objArr;
    }

    private final void t(int i6, int i7) {
        if (i6 < i7) {
            q.M1(this.f43659b, null, i6, i7);
            return;
        }
        Object[] objArr = this.f43659b;
        q.M1(objArr, null, i6, objArr.length);
        q.M1(this.f43659b, null, 0, i7);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e6) {
        addLast(e6);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        registerModification();
        f(size() + elements.size());
        a(u(this.f43658a + size()), elements);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        kotlin.jvm.internal.g0.p(array, "array");
        if (array.length < size()) {
            array = (T[]) o.a(array, size());
        }
        T[] tArr = array;
        int u5 = u(this.f43658a + size());
        int i6 = this.f43658a;
        if (i6 < u5) {
            q.K0(this.f43659b, tArr, 0, i6, u5, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f43659b;
            q.B0(objArr, tArr, 0, this.f43658a, objArr.length);
            Object[] objArr2 = this.f43659b;
            q.B0(objArr2, tArr, objArr2.length - this.f43658a, 0, u5);
        }
        return (T[]) g0.o(size(), tArr);
    }

    private final void d(int i6) {
        Object[] objArr = new Object[i6];
        Object[] objArr2 = this.f43659b;
        q.B0(objArr2, objArr, 0, this.f43658a, objArr2.length);
        Object[] objArr3 = this.f43659b;
        int length = objArr3.length;
        int i7 = this.f43658a;
        q.B0(objArr3, objArr, length - i7, 0, i7);
        this.f43658a = 0;
        this.f43659b = objArr;
    }

    private final int e(int i6) {
        return i6 == 0 ? a0.Oe(this.f43659b) : i6 - 1;
    }

    private final void f(int i6) {
        if (i6 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f43659b;
        if (i6 <= objArr.length) {
            return;
        }
        if (objArr == f43656e) {
            this.f43659b = new Object[kotlin.ranges.t.u(i6, 10)];
        } else {
            d(d.Companion.e(objArr.length, i6));
        }
    }

    private final int m(int i6) {
        if (i6 == a0.Oe(this.f43659b)) {
            return 0;
        }
        return i6 + 1;
    }

    @InlineOnly
    private final E n(int i6) {
        return (E) this.f43659b[i6];
    }

    @InlineOnly
    private final int o(int i6) {
        return u(this.f43658a + i6);
    }

    private final int r(int i6) {
        return i6 < 0 ? i6 + this.f43659b.length : i6;
    }

    private final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    private final int u(int i6) {
        Object[] objArr = this.f43659b;
        return i6 >= objArr.length ? i6 - objArr.length : i6;
    }

    private final void x(int i6, int i7) {
        int u5 = u(this.f43658a + (i6 - 1));
        int u6 = u(this.f43658a + (i7 - 1));
        while (i6 > 0) {
            int i8 = u5 + 1;
            int min = Math.min(i6, Math.min(i8, u6 + 1));
            Object[] objArr = this.f43659b;
            int i9 = u6 - min;
            int i10 = u5 - min;
            q.B0(objArr, objArr, i9 + 1, i10 + 1, i8);
            u5 = r(i10);
            u6 = r(i9);
            i6 -= min;
        }
    }

    private final void y(int i6, int i7) {
        int u5 = u(this.f43658a + i7);
        int u6 = u(this.f43658a + i6);
        int size = size();
        while (true) {
            size -= i7;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.f43659b;
            i7 = Math.min(size, Math.min(objArr.length - u5, objArr.length - u6));
            Object[] objArr2 = this.f43659b;
            int i8 = u5 + i7;
            q.B0(objArr2, objArr2, u6, u5, i8);
            u5 = u(i8);
            u6 = u(u6 + i7);
        }
    }

    @NotNull
    public final <T> T[] B(@NotNull T[] array) {
        kotlin.jvm.internal.g0.p(array, "array");
        return (T[]) toArray(array);
    }

    @Override // kotlin.collections.h, java.util.AbstractList, java.util.List
    public void add(int i6, E e6) {
        d.Companion.c(i6, size());
        if (i6 == size()) {
            addLast(e6);
            return;
        }
        if (i6 == 0) {
            addFirst(e6);
            return;
        }
        registerModification();
        f(size() + 1);
        int u5 = u(this.f43658a + i6);
        if (i6 < ((size() + 1) >> 1)) {
            int e7 = e(u5);
            int e8 = e(this.f43658a);
            int i7 = this.f43658a;
            if (e7 >= i7) {
                Object[] objArr = this.f43659b;
                objArr[e8] = objArr[i7];
                q.B0(objArr, objArr, i7, i7 + 1, e7 + 1);
            } else {
                Object[] objArr2 = this.f43659b;
                q.B0(objArr2, objArr2, i7 - 1, i7, objArr2.length);
                Object[] objArr3 = this.f43659b;
                objArr3[objArr3.length - 1] = objArr3[0];
                q.B0(objArr3, objArr3, 0, 1, e7 + 1);
            }
            this.f43659b[e7] = e6;
            this.f43658a = e8;
        } else {
            int u6 = u(this.f43658a + size());
            if (u5 < u6) {
                Object[] objArr4 = this.f43659b;
                q.B0(objArr4, objArr4, u5 + 1, u5, u6);
            } else {
                Object[] objArr5 = this.f43659b;
                q.B0(objArr5, objArr5, 1, 0, u6);
                Object[] objArr6 = this.f43659b;
                objArr6[0] = objArr6[objArr6.length - 1];
                q.B0(objArr6, objArr6, u5 + 1, u5, objArr6.length - 1);
            }
            this.f43659b[u5] = e6;
        }
        this.f43660c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i6) {
        d.Companion.b(i6, size());
        return (E) this.f43659b[u(this.f43658a + i6)];
    }

    @Override // kotlin.collections.h
    public int getSize() {
        return this.f43660c;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i6;
        int u5 = u(this.f43658a + size());
        int i7 = this.f43658a;
        if (i7 < u5) {
            while (i7 < u5) {
                if (kotlin.jvm.internal.g0.g(obj, this.f43659b[i7])) {
                    i6 = this.f43658a;
                } else {
                    i7++;
                }
            }
            return -1;
        }
        if (i7 < u5) {
            return -1;
        }
        int length = this.f43659b.length;
        while (true) {
            if (i7 >= length) {
                for (int i8 = 0; i8 < u5; i8++) {
                    if (kotlin.jvm.internal.g0.g(obj, this.f43659b[i8])) {
                        i7 = i8 + this.f43659b.length;
                        i6 = this.f43658a;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.g0.g(obj, this.f43659b[i7])) {
                i6 = this.f43658a;
                break;
            }
            i7++;
        }
        return i7 - i6;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int Oe;
        int i6;
        int u5 = u(this.f43658a + size());
        int i7 = this.f43658a;
        if (i7 < u5) {
            Oe = u5 - 1;
            if (i7 <= Oe) {
                while (!kotlin.jvm.internal.g0.g(obj, this.f43659b[Oe])) {
                    if (Oe != i7) {
                        Oe--;
                    }
                }
                i6 = this.f43658a;
                return Oe - i6;
            }
            return -1;
        }
        if (i7 > u5) {
            int i8 = u5 - 1;
            while (true) {
                if (-1 >= i8) {
                    Oe = a0.Oe(this.f43659b);
                    int i9 = this.f43658a;
                    if (i9 <= Oe) {
                        while (!kotlin.jvm.internal.g0.g(obj, this.f43659b[Oe])) {
                            if (Oe != i9) {
                                Oe--;
                            }
                        }
                        i6 = this.f43658a;
                    }
                } else {
                    if (kotlin.jvm.internal.g0.g(obj, this.f43659b[i8])) {
                        Oe = i8 + this.f43659b.length;
                        i6 = this.f43658a;
                        break;
                    }
                    i8--;
                }
            }
        }
        return -1;
    }

    public final void p(@NotNull Function2<? super Integer, ? super Object[], kotlin.n1> structure) {
        int i6;
        kotlin.jvm.internal.g0.p(structure, "structure");
        structure.invoke(Integer.valueOf((isEmpty() || (i6 = this.f43658a) < u(this.f43658a + size())) ? this.f43658a : i6 - this.f43659b.length), toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@NotNull Collection<?> elements) {
        int u5;
        kotlin.jvm.internal.g0.p(elements, "elements");
        boolean z5 = false;
        z5 = false;
        z5 = false;
        if (!isEmpty() && this.f43659b.length != 0) {
            int u6 = u(this.f43658a + size());
            int i6 = this.f43658a;
            if (i6 < u6) {
                u5 = i6;
                while (i6 < u6) {
                    Object obj = this.f43659b[i6];
                    if (elements.contains(obj)) {
                        z5 = true;
                    } else {
                        this.f43659b[u5] = obj;
                        u5++;
                    }
                    i6++;
                }
                q.M1(this.f43659b, null, u5, u6);
            } else {
                int length = this.f43659b.length;
                int i7 = i6;
                boolean z6 = false;
                while (i6 < length) {
                    Object[] objArr = this.f43659b;
                    Object obj2 = objArr[i6];
                    objArr[i6] = null;
                    if (elements.contains(obj2)) {
                        z6 = true;
                    } else {
                        this.f43659b[i7] = obj2;
                        i7++;
                    }
                    i6++;
                }
                u5 = u(i7);
                for (int i8 = 0; i8 < u6; i8++) {
                    Object[] objArr2 = this.f43659b;
                    Object obj3 = objArr2[i8];
                    objArr2[i8] = null;
                    if (elements.contains(obj3)) {
                        z6 = true;
                    } else {
                        this.f43659b[u5] = obj3;
                        u5 = m(u5);
                    }
                }
                z5 = z6;
            }
            if (z5) {
                registerModification();
                this.f43660c = r(u5 - this.f43658a);
            }
        }
        return z5;
    }

    @Override // kotlin.collections.h
    public E removeAt(int i6) {
        d.Companion.b(i6, size());
        if (i6 == h0.L(this)) {
            return removeLast();
        }
        if (i6 == 0) {
            return removeFirst();
        }
        registerModification();
        int u5 = u(this.f43658a + i6);
        E e6 = (E) this.f43659b[u5];
        if (i6 < (size() >> 1)) {
            int i7 = this.f43658a;
            if (u5 >= i7) {
                Object[] objArr = this.f43659b;
                q.B0(objArr, objArr, i7 + 1, i7, u5);
            } else {
                Object[] objArr2 = this.f43659b;
                q.B0(objArr2, objArr2, 1, 0, u5);
                Object[] objArr3 = this.f43659b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i8 = this.f43658a;
                q.B0(objArr3, objArr3, i8 + 1, i8, objArr3.length - 1);
            }
            Object[] objArr4 = this.f43659b;
            int i9 = this.f43658a;
            objArr4[i9] = null;
            this.f43658a = m(i9);
        } else {
            int u6 = u(this.f43658a + h0.L(this));
            if (u5 <= u6) {
                Object[] objArr5 = this.f43659b;
                q.B0(objArr5, objArr5, u5, u5 + 1, u6 + 1);
            } else {
                Object[] objArr6 = this.f43659b;
                q.B0(objArr6, objArr6, u5, u5 + 1, objArr6.length);
                Object[] objArr7 = this.f43659b;
                objArr7[objArr7.length - 1] = objArr7[0];
                q.B0(objArr7, objArr7, 0, 1, u6 + 1);
            }
            this.f43659b[u6] = null;
        }
        this.f43660c = size() - 1;
        return e6;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i6, int i7) {
        d.Companion.d(i6, i7, size());
        int i8 = i7 - i6;
        if (i8 == 0) {
            return;
        }
        if (i8 == size()) {
            clear();
            return;
        }
        if (i8 == 1) {
            removeAt(i6);
            return;
        }
        registerModification();
        if (i6 < size() - i7) {
            x(i6, i7);
            int u5 = u(this.f43658a + i8);
            t(this.f43658a, u5);
            this.f43658a = u5;
        } else {
            y(i6, i7);
            int u6 = u(this.f43658a + size());
            t(r(u6 - i8), u6);
        }
        this.f43660c = size() - i8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@NotNull Collection<?> elements) {
        int u5;
        kotlin.jvm.internal.g0.p(elements, "elements");
        boolean z5 = false;
        z5 = false;
        z5 = false;
        if (!isEmpty() && this.f43659b.length != 0) {
            int u6 = u(this.f43658a + size());
            int i6 = this.f43658a;
            if (i6 < u6) {
                u5 = i6;
                while (i6 < u6) {
                    Object obj = this.f43659b[i6];
                    if (elements.contains(obj)) {
                        this.f43659b[u5] = obj;
                        u5++;
                    } else {
                        z5 = true;
                    }
                    i6++;
                }
                q.M1(this.f43659b, null, u5, u6);
            } else {
                int length = this.f43659b.length;
                int i7 = i6;
                boolean z6 = false;
                while (i6 < length) {
                    Object[] objArr = this.f43659b;
                    Object obj2 = objArr[i6];
                    objArr[i6] = null;
                    if (elements.contains(obj2)) {
                        this.f43659b[i7] = obj2;
                        i7++;
                    } else {
                        z6 = true;
                    }
                    i6++;
                }
                u5 = u(i7);
                for (int i8 = 0; i8 < u6; i8++) {
                    Object[] objArr2 = this.f43659b;
                    Object obj3 = objArr2[i8];
                    objArr2[i8] = null;
                    if (elements.contains(obj3)) {
                        this.f43659b[u5] = obj3;
                        u5 = m(u5);
                    } else {
                        z6 = true;
                    }
                }
                z5 = z6;
            }
            if (z5) {
                registerModification();
                this.f43660c = r(u5 - this.f43658a);
            }
        }
        return z5;
    }

    @Override // kotlin.collections.h, java.util.AbstractList, java.util.List
    public E set(int i6, E e6) {
        d.Companion.b(i6, size());
        int u5 = u(this.f43658a + i6);
        Object[] objArr = this.f43659b;
        E e7 = (E) objArr[u5];
        objArr[u5] = e6;
        return e7;
    }

    private final void a(int i6, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f43659b.length;
        while (i6 < length && it.hasNext()) {
            this.f43659b[i6] = it.next();
            i6++;
        }
        int i7 = this.f43658a;
        for (int i8 = 0; i8 < i7 && it.hasNext(); i8++) {
            this.f43659b[i8] = it.next();
        }
        this.f43660c = size() + collection.size();
    }

    private final boolean g(Function1<? super E, Boolean> function1) {
        int u5;
        boolean z5 = false;
        z5 = false;
        z5 = false;
        if (!isEmpty() && this.f43659b.length != 0) {
            int u6 = u(this.f43658a + size());
            int i6 = this.f43658a;
            if (i6 < u6) {
                u5 = i6;
                while (i6 < u6) {
                    Object obj = this.f43659b[i6];
                    if (function1.invoke(obj).booleanValue()) {
                        this.f43659b[u5] = obj;
                        u5++;
                    } else {
                        z5 = true;
                    }
                    i6++;
                }
                q.M1(this.f43659b, null, u5, u6);
            } else {
                int length = this.f43659b.length;
                int i7 = i6;
                boolean z6 = false;
                while (i6 < length) {
                    Object[] objArr = this.f43659b;
                    Object obj2 = objArr[i6];
                    objArr[i6] = null;
                    if (function1.invoke(obj2).booleanValue()) {
                        this.f43659b[i7] = obj2;
                        i7++;
                    } else {
                        z6 = true;
                    }
                    i6++;
                }
                u5 = u(i7);
                for (int i8 = 0; i8 < u6; i8++) {
                    Object[] objArr2 = this.f43659b;
                    Object obj3 = objArr2[i8];
                    objArr2[i8] = null;
                    if (function1.invoke(obj3).booleanValue()) {
                        this.f43659b[u5] = obj3;
                        u5 = m(u5);
                    } else {
                        z6 = true;
                    }
                }
                z5 = z6;
            }
            if (z5) {
                registerModification();
                this.f43660c = r(u5 - this.f43658a);
            }
        }
        return z5;
    }

    @NotNull
    public final Object[] A() {
        return toArray();
    }

    public final void addFirst(E e6) {
        registerModification();
        f(size() + 1);
        int e7 = e(this.f43658a);
        this.f43658a = e7;
        this.f43659b[e7] = e6;
        this.f43660c = size() + 1;
    }

    public final void addLast(E e6) {
        registerModification();
        f(size() + 1);
        this.f43659b[u(this.f43658a + size())] = e6;
        this.f43660c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            registerModification();
            t(this.f43658a, u(this.f43658a + size()));
        }
        this.f43658a = 0;
        this.f43660c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final E first() {
        if (!isEmpty()) {
            return (E) this.f43659b[this.f43658a];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public final E j() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f43659b[this.f43658a];
    }

    public final E last() {
        if (!isEmpty()) {
            return (E) this.f43659b[u(this.f43658a + h0.L(this))];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Nullable
    public final E q() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f43659b[u(this.f43658a + h0.L(this))];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            registerModification();
            Object[] objArr = this.f43659b;
            int i6 = this.f43658a;
            E e6 = (E) objArr[i6];
            objArr[i6] = null;
            this.f43658a = m(i6);
            this.f43660c = size() - 1;
            return e6;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        if (!isEmpty()) {
            registerModification();
            int u5 = u(this.f43658a + h0.L(this));
            Object[] objArr = this.f43659b;
            E e6 = (E) objArr[u5];
            objArr[u5] = null;
            this.f43660c = size() - 1;
            return e6;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Nullable
    public final E v() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Nullable
    public final E w() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    public final void z(int i6, int i7) {
        removeRange(i6, i7);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i6, @NotNull Collection<? extends E> elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        d.Companion.c(i6, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i6 == size()) {
            return addAll(elements);
        }
        registerModification();
        f(size() + elements.size());
        int u5 = u(this.f43658a + size());
        int u6 = u(this.f43658a + i6);
        int size = elements.size();
        if (i6 < ((size() + 1) >> 1)) {
            int i7 = this.f43658a;
            int i8 = i7 - size;
            if (u6 < i7) {
                Object[] objArr = this.f43659b;
                q.B0(objArr, objArr, i8, i7, objArr.length);
                if (size >= u6) {
                    Object[] objArr2 = this.f43659b;
                    q.B0(objArr2, objArr2, objArr2.length - size, 0, u6);
                } else {
                    Object[] objArr3 = this.f43659b;
                    q.B0(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f43659b;
                    q.B0(objArr4, objArr4, 0, size, u6);
                }
            } else if (i8 >= 0) {
                Object[] objArr5 = this.f43659b;
                q.B0(objArr5, objArr5, i8, i7, u6);
            } else {
                Object[] objArr6 = this.f43659b;
                i8 += objArr6.length;
                int i9 = u6 - i7;
                int length = objArr6.length - i8;
                if (length >= i9) {
                    q.B0(objArr6, objArr6, i8, i7, u6);
                } else {
                    q.B0(objArr6, objArr6, i8, i7, i7 + length);
                    Object[] objArr7 = this.f43659b;
                    q.B0(objArr7, objArr7, 0, this.f43658a + length, u6);
                }
            }
            this.f43658a = i8;
            a(r(u6 - size), elements);
        } else {
            int i10 = u6 + size;
            if (u6 < u5) {
                int i11 = size + u5;
                Object[] objArr8 = this.f43659b;
                if (i11 <= objArr8.length) {
                    q.B0(objArr8, objArr8, i10, u6, u5);
                } else if (i10 >= objArr8.length) {
                    q.B0(objArr8, objArr8, i10 - objArr8.length, u6, u5);
                } else {
                    int length2 = u5 - (i11 - objArr8.length);
                    q.B0(objArr8, objArr8, 0, length2, u5);
                    Object[] objArr9 = this.f43659b;
                    q.B0(objArr9, objArr9, i10, u6, length2);
                }
            } else {
                Object[] objArr10 = this.f43659b;
                q.B0(objArr10, objArr10, size, 0, u5);
                Object[] objArr11 = this.f43659b;
                if (i10 >= objArr11.length) {
                    q.B0(objArr11, objArr11, i10 - objArr11.length, u6, objArr11.length);
                } else {
                    q.B0(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f43659b;
                    q.B0(objArr12, objArr12, i10, u6, objArr12.length - size);
                }
            }
            a(u6, elements);
        }
        return true;
    }

    public m() {
        this.f43659b = f43656e;
    }

    public m(@NotNull Collection<? extends E> elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        Object[] array = elements.toArray(new Object[0]);
        this.f43659b = array;
        this.f43660c = array.length;
        if (array.length == 0) {
            this.f43659b = f43656e;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
