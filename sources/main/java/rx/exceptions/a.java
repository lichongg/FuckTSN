package rx.exceptions;

import java.util.HashSet;
import java.util.List;
import rx.f;
import rx.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f52401a = 25;

    public static Throwable b(Throwable th) {
        int i6 = 0;
        while (th.getCause() != null) {
            int i7 = i6 + 1;
            if (i6 >= 25) {
                return new RuntimeException("Stack too deep to get final cause");
            }
            th = th.getCause();
            i6 = i7;
        }
        return th;
    }

    public static void a(Throwable th, Throwable th2) {
        HashSet hashSet = new HashSet();
        int i6 = 0;
        while (th.getCause() != null) {
            int i7 = i6 + 1;
            if (i6 >= 25) {
                return;
            }
            th = th.getCause();
            if (!hashSet.contains(th.getCause())) {
                hashSet.add(th.getCause());
                i6 = i7;
            }
        }
        try {
            th.initCause(th2);
        } catch (Throwable unused) {
        }
    }

    public static RuntimeException c(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new RuntimeException(th);
    }

    public static void d(List<? extends Throwable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() != 1) {
            throw new CompositeException(list);
        }
        Throwable th = list.get(0);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (!(th instanceof Error)) {
            throw new RuntimeException(th);
        }
        throw ((Error) th);
    }

    public static void e(Throwable th) {
        if (th instanceof OnErrorNotImplementedException) {
            throw ((OnErrorNotImplementedException) th);
        }
        if (th instanceof OnErrorFailedException) {
            throw ((OnErrorFailedException) th);
        }
        if (th instanceof OnCompletedFailedException) {
            throw ((OnCompletedFailedException) th);
        }
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    private a() {
        throw new IllegalStateException("No instances!");
    }

    public static void f(Throwable th, f<?> fVar) {
        e(th);
        fVar.onError(th);
    }

    public static void g(Throwable th, f<?> fVar, Object obj) {
        e(th);
        fVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
    }

    public static void h(Throwable th, k<?> kVar) {
        e(th);
        kVar.onError(th);
    }

    public static void i(Throwable th, k<?> kVar, Object obj) {
        e(th);
        kVar.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
    }
}
