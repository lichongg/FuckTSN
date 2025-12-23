package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.PublishedApi;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.d1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@InternalCoroutinesApi
@SourceDebugExtension({"SMAP\nThreadSafeHeap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n28#2,4:169\n28#2,4:174\n28#2,4:179\n28#2,4:184\n28#2,4:189\n28#2,4:194\n28#2,4:199\n28#2,4:204\n20#3:173\n20#3:178\n20#3:183\n20#3:188\n20#3:193\n20#3:198\n20#3:203\n20#3:208\n1#4:209\n*S KotlinDebug\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n35#1:169,4\n42#1:174,4\n50#1:179,4\n52#1:184,4\n60#1:189,4\n69#1:194,4\n72#1:199,4\n81#1:204,4\n35#1:173\n42#1:178\n50#1:183\n52#1:188\n60#1:193\n69#1:198\n72#1:203\n81#1:208\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class c1<T extends d1 & Comparable<? super T>> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f49242b = AtomicIntegerFieldUpdater.newUpdater(c1.class, "_size");

    @Volatile
    private volatile int _size;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private T[] f49243a;

    public final void b(@NotNull T t5) {
        synchronized (this) {
            a(t5);
            n1 n1Var = n1.f44123a;
        }
    }

    public final boolean c(@NotNull T t5, @NotNull Function1<? super T, Boolean> function1) {
        boolean z5;
        synchronized (this) {
            try {
                if (function1.invoke(f()).booleanValue()) {
                    a(t5);
                    z5 = true;
                } else {
                    z5 = false;
                }
                kotlin.jvm.internal.d0.d(1);
            } catch (Throwable th) {
                kotlin.jvm.internal.d0.d(1);
                kotlin.jvm.internal.d0.c(1);
                throw th;
            }
        }
        kotlin.jvm.internal.d0.c(1);
        return z5;
    }

    public final void d() {
        synchronized (this) {
            try {
                T[] tArr = this.f49243a;
                if (tArr != null) {
                    kotlin.collections.n.V1(tArr, null, 0, 0, 6, null);
                }
                f49242b.set(this, 0);
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public final T e(@NotNull Function1<? super T, Boolean> function1) {
        T t5;
        synchronized (this) {
            try {
                int g6 = g();
                int i6 = 0;
                while (true) {
                    t5 = null;
                    if (i6 >= g6) {
                        break;
                    }
                    T[] tArr = this.f49243a;
                    if (tArr != null) {
                        t5 = (Object) tArr[i6];
                    }
                    kotlin.jvm.internal.g0.m(t5);
                    if (function1.invoke(t5).booleanValue()) {
                        break;
                    }
                    i6++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t5;
    }

    @Nullable
    public final T i() {
        T f6;
        synchronized (this) {
            f6 = f();
        }
        return f6;
    }

    public final boolean k(@NotNull T t5) {
        boolean z5;
        synchronized (this) {
            if (t5.c() == null) {
                z5 = false;
            } else {
                l(t5.getIndex());
                z5 = true;
            }
        }
        return z5;
    }

    @Nullable
    public final T m(@NotNull Function1<? super T, Boolean> function1) {
        synchronized (this) {
            try {
                T f6 = f();
                if (f6 == null) {
                    kotlin.jvm.internal.d0.d(2);
                    kotlin.jvm.internal.d0.c(2);
                    return null;
                }
                T l6 = function1.invoke(f6).booleanValue() ? l(0) : null;
                kotlin.jvm.internal.d0.d(1);
                kotlin.jvm.internal.d0.c(1);
                return l6;
            } catch (Throwable th) {
                kotlin.jvm.internal.d0.d(1);
                kotlin.jvm.internal.d0.c(1);
                throw th;
            }
        }
    }

    @Nullable
    public final T n() {
        T l6;
        synchronized (this) {
            l6 = g() > 0 ? l(0) : null;
        }
        return l6;
    }

    private final T[] j() {
        T[] tArr = this.f49243a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new d1[4];
            this.f49243a = tArr2;
            return tArr2;
        }
        if (g() < tArr.length) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, g() * 2);
        kotlin.jvm.internal.g0.o(copyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((d1[]) copyOf);
        this.f49243a = tArr3;
        return tArr3;
    }

    private final void o(int i6) {
        f49242b.set(this, i6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (((java.lang.Comparable) r3).compareTo(r4) < 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void p(int r6) {
        /*
            r5 = this;
        L0:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.g()
            if (r1 < r2) goto Lb
            goto L3e
        Lb:
            T extends kotlinx.coroutines.internal.d1 & java.lang.Comparable<? super T>[] r2 = r5.f49243a
            kotlin.jvm.internal.g0.m(r2)
            int r0 = r0 + 2
            int r3 = r5.g()
            if (r0 >= r3) goto L2b
            r3 = r2[r0]
            kotlin.jvm.internal.g0.m(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            kotlin.jvm.internal.g0.m(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L2b
            goto L2c
        L2b:
            r0 = r1
        L2c:
            r1 = r2[r6]
            kotlin.jvm.internal.g0.m(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            kotlin.jvm.internal.g0.m(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L3f
        L3e:
            return
        L3f:
            r5.r(r6, r0)
            r6 = r0
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.c1.p(int):void");
    }

    private final void q(int i6) {
        while (i6 > 0) {
            T[] tArr = this.f49243a;
            kotlin.jvm.internal.g0.m(tArr);
            int i7 = (i6 - 1) / 2;
            T t5 = tArr[i7];
            kotlin.jvm.internal.g0.m(t5);
            T t6 = tArr[i6];
            kotlin.jvm.internal.g0.m(t6);
            if (((Comparable) t5).compareTo(t6) <= 0) {
                return;
            }
            r(i6, i7);
            i6 = i7;
        }
    }

    private final void r(int i6, int i7) {
        T[] tArr = this.f49243a;
        kotlin.jvm.internal.g0.m(tArr);
        T t5 = tArr[i7];
        kotlin.jvm.internal.g0.m(t5);
        T t6 = tArr[i6];
        kotlin.jvm.internal.g0.m(t6);
        tArr[i6] = t5;
        tArr[i7] = t6;
        t5.setIndex(i6);
        t6.setIndex(i7);
    }

    @PublishedApi
    @Nullable
    public final T f() {
        T[] tArr = this.f49243a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int g() {
        return f49242b.get(this);
    }

    @PublishedApi
    @NotNull
    public final T l(int i6) {
        T[] tArr = this.f49243a;
        kotlin.jvm.internal.g0.m(tArr);
        o(g() - 1);
        if (i6 < g()) {
            r(i6, g());
            int i7 = (i6 - 1) / 2;
            if (i6 > 0) {
                T t5 = tArr[i6];
                kotlin.jvm.internal.g0.m(t5);
                T t6 = tArr[i7];
                kotlin.jvm.internal.g0.m(t6);
                if (((Comparable) t5).compareTo(t6) < 0) {
                    r(i6, i7);
                    q(i7);
                }
            }
            p(i6);
        }
        T t7 = tArr[g()];
        kotlin.jvm.internal.g0.m(t7);
        t7.a(null);
        t7.setIndex(-1);
        tArr[g()] = null;
        return t7;
    }

    @PublishedApi
    public final void a(@NotNull T t5) {
        t5.a(this);
        T[] j6 = j();
        int g6 = g();
        o(g6 + 1);
        j6[g6] = t5;
        t5.setIndex(g6);
        q(g6);
    }

    public final boolean h() {
        if (g() == 0) {
            return true;
        }
        return false;
    }
}
