package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nStackTraceRecovery.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,216:1\n1735#2,6:217\n12744#2,2:225\n1627#2,6:229\n12744#2,2:235\n1627#2,6:238\n37#3,2:223\n26#4:227\n26#4:228\n1#5:237\n*S KotlinDebug\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n43#1:217,6\n131#1:225,2\n141#1:229,6\n173#1:235,2\n194#1:238,6\n106#1:223,2\n133#1:227\n135#1:228\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final String f49300a = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f49301b = "kotlinx.coroutines.internal.StackTraceRecoveryKt";

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final StackTraceElement f49302c = new _COROUTINE.a().a();

    /* renamed from: d, reason: collision with root package name */
    private static final String f49303d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f49304e;

    private static final int h(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (kotlin.jvm.internal.g0.g(str, stackTraceElementArr[i6].getClassName())) {
                return i6;
            }
        }
        return -1;
    }

    private static final void k(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                i6 = -1;
                break;
            } else if (j(stackTraceElementArr[i6])) {
                break;
            } else {
                i6++;
            }
        }
        int i7 = i6 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i7 > length2) {
            return;
        }
        while (true) {
            if (g(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i7) {
                return;
            } else {
                length2--;
            }
        }
    }

    static {
        Object m130constructorimpl;
        Object m130constructorimpl2;
        try {
            Result.a aVar = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(kotlin.g0.a(th));
        }
        if (Result.m133exceptionOrNullimpl(m130constructorimpl) != null) {
            m130constructorimpl = f49300a;
        }
        f49303d = (String) m130constructorimpl;
        try {
            Result.a aVar3 = Result.Companion;
            m130constructorimpl2 = Result.m130constructorimpl(r0.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.a aVar4 = Result.Companion;
            m130constructorimpl2 = Result.m130constructorimpl(kotlin.g0.a(th2));
        }
        if (Result.m133exceptionOrNullimpl(m130constructorimpl2) != null) {
            m130constructorimpl2 = f49301b;
        }
        f49304e = (String) m130constructorimpl2;
    }

    private static final <E extends Throwable> E e(E e6, E e7, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(f49302c);
        StackTraceElement[] stackTrace = e6.getStackTrace();
        int h6 = h(stackTrace, f49303d);
        int i6 = 0;
        if (h6 == -1) {
            e7.setStackTrace((StackTraceElement[]) arrayDeque.toArray(new StackTraceElement[0]));
            return e7;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + h6];
        for (int i7 = 0; i7 < h6; i7++) {
            stackTraceElementArr[i7] = stackTrace[i7];
        }
        Iterator<StackTraceElement> it = arrayDeque.iterator();
        while (it.hasNext()) {
            int i8 = i6 + 1;
            stackTraceElementArr[i6 + h6] = it.next();
            i6 = i8;
        }
        e7.setStackTrace(stackTraceElementArr);
        return e7;
    }

    private static final ArrayDeque<StackTraceElement> f(kotlin.coroutines.jvm.internal.c cVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = cVar.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            cVar = cVar.getCallerFrame();
            if (cVar == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = cVar.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> d(E e6) {
        Throwable cause = e6.getCause();
        if (cause != null && kotlin.jvm.internal.g0.g(cause.getClass(), e6.getClass())) {
            StackTraceElement[] stackTrace = e6.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (j(stackTraceElement)) {
                    return kotlin.o0.a(cause, stackTrace);
                }
            }
            return kotlin.o0.a(e6, new StackTraceElement[0]);
        }
        return kotlin.o0.a(e6, new StackTraceElement[0]);
    }

    private static final boolean g(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        if (stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && kotlin.jvm.internal.g0.g(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && kotlin.jvm.internal.g0.g(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && kotlin.jvm.internal.g0.g(stackTraceElement.getClassName(), stackTraceElement2.getClassName())) {
            return true;
        }
        return false;
    }

    public static final void i(@NotNull Throwable th, @NotNull Throwable th2) {
        th.initCause(th2);
    }

    public static final boolean j(@NotNull StackTraceElement stackTraceElement) {
        return kotlin.text.u.H2(stackTraceElement.getClassName(), _COROUTINE.b.c(), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E extends Throwable> E n(E e6, kotlin.coroutines.jvm.internal.c cVar) {
        Pair d6 = d(e6);
        Throwable th = (Throwable) d6.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) d6.component2();
        Throwable g6 = n.g(th);
        if (g6 != null) {
            ArrayDeque<StackTraceElement> f6 = f(cVar);
            if (!f6.isEmpty()) {
                if (th != e6) {
                    k(stackTraceElementArr, f6);
                }
                return (E) e(th, g6, f6);
            }
        }
        return e6;
    }

    private static final <E extends Throwable> E q(E e6) {
        int i6;
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e6.getStackTrace();
        int length = stackTrace.length;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i7 = length2 - 1;
                if (kotlin.jvm.internal.g0.g(f49304e, stackTrace[length2].getClassName())) {
                    break;
                }
                if (i7 < 0) {
                    break;
                }
                length2 = i7;
            }
        }
        length2 = -1;
        int i8 = length2 + 1;
        int h6 = h(stackTrace, f49303d);
        if (h6 == -1) {
            i6 = 0;
        } else {
            i6 = length - h6;
        }
        int i9 = (length - length2) - i6;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            if (i10 == 0) {
                stackTraceElement = f49302c;
            } else {
                stackTraceElement = stackTrace[(i8 + i10) - 1];
            }
            stackTraceElementArr[i10] = stackTraceElement;
        }
        e6.setStackTrace(stackTraceElementArr);
        return e6;
    }

    @PublishedApi
    @NotNull
    public static final <E extends Throwable> E s(@NotNull E e6) {
        E e7 = (E) e6.getCause();
        if (e7 != null && kotlin.jvm.internal.g0.g(e7.getClass(), e6.getClass())) {
            for (StackTraceElement stackTraceElement : e6.getStackTrace()) {
                if (j(stackTraceElement)) {
                    return e7;
                }
            }
        }
        return e6;
    }

    public static /* synthetic */ void a() {
    }

    public static /* synthetic */ void b() {
    }

    @NotNull
    public static final <E extends Throwable> E o(@NotNull E e6) {
        return e6;
    }

    @PublishedApi
    @NotNull
    public static final <E extends Throwable> E r(@NotNull E e6) {
        return e6;
    }

    @Nullable
    public static final Object l(@NotNull Throwable th, @NotNull kotlin.coroutines.e<?> eVar) {
        throw th;
    }

    private static final Object m(Throwable th, kotlin.coroutines.e<?> eVar) {
        throw th;
    }

    @NotNull
    public static final <E extends Throwable> E p(@NotNull E e6, @NotNull kotlin.coroutines.e<?> eVar) {
        return e6;
    }
}
