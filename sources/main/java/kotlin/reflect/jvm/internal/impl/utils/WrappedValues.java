package kotlin.reflect.jvm.internal.impl.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class WrappedValues {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f47468a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f47469b = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable th) {
            super("Rethrow stored exception", th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        public String toString() {
            return "NULL_VALUE";
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Throwable f47470a;

        /* synthetic */ b(Throwable th, a aVar) {
            this(th);
        }

        private static /* synthetic */ void a(int i6) {
            String str = i6 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i6 != 1 ? 3 : 2];
            if (i6 != 1) {
                objArr[0] = "throwable";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            }
            if (i6 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            } else {
                objArr[1] = "getThrowable";
            }
            if (i6 != 1) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i6 == 1) {
                throw new IllegalStateException(format);
            }
        }

        private b(@NotNull Throwable th) {
            if (th == null) {
                a(0);
            }
            this.f47470a = th;
        }

        @NotNull
        public Throwable b() {
            Throwable th = this.f47470a;
            if (th == null) {
                a(1);
            }
            return th;
        }

        public String toString() {
            return this.f47470a.toString();
        }
    }

    private static /* synthetic */ void a(int i6) {
        String str = (i6 == 1 || i6 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 1 || i6 == 2) ? 2 : 3];
        if (i6 == 1 || i6 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        } else if (i6 != 3) {
            objArr[0] = "value";
        } else {
            objArr[0] = "throwable";
        }
        if (i6 == 1 || i6 == 2) {
            objArr[1] = "escapeNull";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        }
        if (i6 != 1 && i6 != 2) {
            if (i6 == 3) {
                objArr[2] = "escapeThrowable";
            } else if (i6 != 4) {
                objArr[2] = "unescapeNull";
            } else {
                objArr[2] = "unescapeExceptionOrNull";
            }
        }
        String format = String.format(str, objArr);
        if (i6 != 1 && i6 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static <V> Object b(@Nullable V v5) {
        if (v5 == null && (v5 = (V) f47468a) == null) {
            a(1);
        }
        return v5;
    }

    @NotNull
    public static Object c(@NotNull Throwable th) {
        if (th == null) {
            a(3);
        }
        return new b(th, null);
    }

    @Nullable
    public static <V> V d(@NotNull Object obj) {
        if (obj == null) {
            a(4);
        }
        return (V) e(f(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static <V> V e(@NotNull Object obj) {
        if (obj == 0) {
            a(0);
        }
        if (obj == f47468a) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static <V> V f(@Nullable Object obj) {
        if (!(obj instanceof b)) {
            return obj;
        }
        Throwable b6 = ((b) obj).b();
        if (f47469b && c.a(b6)) {
            throw new WrappedProcessCanceledException(b6);
        }
        throw c.b(b6);
    }
}
