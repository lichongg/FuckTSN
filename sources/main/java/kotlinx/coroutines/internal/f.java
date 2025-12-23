package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n1#1,269:1\n46#1,8:284\n107#2,7:270\n107#2,7:277\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n74#1:284,8\n27#1:270,7\n85#1:277,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final int f49256a = 16;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final s0 f49257b = new s0("CLOSED");

    @NotNull
    public static final <S extends p0<S>> Object g(@NotNull S s5, long j6, @NotNull Function2<? super Long, ? super S, ? extends S> function2) {
        while (true) {
            if (s5.f49297c >= j6 && !s5.h()) {
                return q0.b(s5);
            }
            Object f6 = s5.f();
            if (f6 == f49257b) {
                return q0.b(f49257b);
            }
            S s6 = (S) ((g) f6);
            if (s6 == null) {
                s6 = function2.invoke(Long.valueOf(s5.f49297c + 1), s5);
                if (s5.m(s6)) {
                    if (s5.h()) {
                        s5.l();
                    }
                }
            }
            s5 = s6;
        }
    }

    private static final boolean b(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, int i6, Function1<? super Integer, Boolean> function1) {
        int i7;
        do {
            i7 = atomicIntegerFieldUpdater.get(obj);
            if (!function1.invoke(Integer.valueOf(i7)).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i7, i7 + i6));
        return true;
    }

    private static final boolean c(Object obj, AtomicIntegerArray atomicIntegerArray, int i6, int i7, Function1<? super Integer, Boolean> function1) {
        int i8;
        do {
            i8 = atomicIntegerArray.get(i6);
            if (!function1.invoke(Integer.valueOf(i8)).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerArray.compareAndSet(i6, i8, i8 + i7));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.g] */
    @NotNull
    public static final <N extends g<N>> N d(@NotNull N n6) {
        while (true) {
            Object f6 = n6.f();
            if (f6 == f49257b) {
                return n6;
            }
            ?? r02 = (g) f6;
            if (r02 == 0) {
                if (n6.j()) {
                    return n6;
                }
            } else {
                n6 = r02;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final Object e(@Nullable Object obj, @NotNull AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, long j6, @NotNull Object obj2, @NotNull Function2<? super Long, Object, Object> function2) {
        while (true) {
            Object g6 = g(obj2, j6, function2);
            if (!q0.h(g6)) {
                p0 f6 = q0.f(g6);
                while (true) {
                    p0 p0Var = (p0) atomicReferenceFieldUpdater.get(obj);
                    if (p0Var.f49297c >= f6.f49297c) {
                        return g6;
                    }
                    if (!f6.s()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, obj, p0Var, f6)) {
                        if (p0Var.o()) {
                            p0Var.l();
                        }
                        return g6;
                    }
                    if (f6.o()) {
                        f6.l();
                    }
                }
            } else {
                return g6;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final Object f(@Nullable Object obj, @NotNull AtomicReferenceArray atomicReferenceArray, int i6, long j6, @NotNull Object obj2, @NotNull Function2<? super Long, Object, Object> function2) {
        while (true) {
            Object g6 = g(obj2, j6, function2);
            if (!q0.h(g6)) {
                p0 f6 = q0.f(g6);
                while (true) {
                    p0 p0Var = (p0) atomicReferenceArray.get(i6);
                    if (p0Var.f49297c >= f6.f49297c) {
                        return g6;
                    }
                    if (!f6.s()) {
                        break;
                    }
                    if (com.google.common.util.concurrent.b.a(atomicReferenceArray, i6, p0Var, f6)) {
                        if (p0Var.o()) {
                            p0Var.l();
                        }
                        return g6;
                    }
                    if (f6.o()) {
                        f6.l();
                    }
                }
            } else {
                return g6;
            }
        }
    }

    private static final void h(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, n1> function1, Object obj) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private static final void i(AtomicReferenceArray atomicReferenceArray, int i6, Function1<Object, n1> function1) {
        while (true) {
            function1.invoke(atomicReferenceArray.get(i6));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean j(@Nullable Object obj, @NotNull AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, @NotNull Object obj2) {
        while (true) {
            p0 p0Var = (p0) atomicReferenceFieldUpdater.get(obj);
            if (p0Var.f49297c >= obj2.f49297c) {
                return true;
            }
            if (!obj2.s()) {
                return false;
            }
            if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, obj, p0Var, obj2)) {
                if (p0Var.o()) {
                    p0Var.l();
                }
                return true;
            }
            if (obj2.o()) {
                obj2.l();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean k(@Nullable Object obj, @NotNull AtomicReferenceArray atomicReferenceArray, int i6, @NotNull Object obj2) {
        while (true) {
            p0 p0Var = (p0) atomicReferenceArray.get(i6);
            if (p0Var.f49297c >= obj2.f49297c) {
                return true;
            }
            if (!obj2.s()) {
                return false;
            }
            if (com.google.common.util.concurrent.b.a(atomicReferenceArray, i6, p0Var, obj2)) {
                if (p0Var.o()) {
                    p0Var.l();
                }
                return true;
            }
            if (obj2.o()) {
                obj2.l();
            }
        }
    }
}
