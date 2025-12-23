package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class f3 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a<T> extends b<T> implements Function0<T> {

        /* renamed from: b, reason: collision with root package name */
        private final Function0<T> f44347b;

        /* renamed from: c, reason: collision with root package name */
        private volatile SoftReference<Object> f44348c;

        private static /* synthetic */ void d(int i6) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        public a(@Nullable T t5, @NotNull Function0<T> function0) {
            if (function0 == null) {
                d(0);
            }
            this.f44348c = null;
            this.f44347b = function0;
            if (t5 != null) {
                this.f44348c = new SoftReference<>(a(t5));
            }
        }

        @Override // kotlin.reflect.jvm.internal.f3.b, kotlin.jvm.functions.Function0
        public T invoke() {
            Object obj;
            SoftReference<Object> softReference = this.f44348c;
            if (softReference != null && (obj = softReference.get()) != null) {
                return c(obj);
            }
            T invoke = this.f44347b.invoke();
            this.f44348c = new SoftReference<>(a(invoke));
            return invoke;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class b<T> {

        /* renamed from: a, reason: collision with root package name */
        private static final Object f44349a = new a();

        public abstract T invoke();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a {
            a() {
            }
        }

        protected Object a(T t5) {
            return t5 == null ? f44349a : t5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected T c(Object obj) {
            if (obj == f44349a) {
                return null;
            }
            return obj;
        }

        public final T b(Object obj, Object obj2) {
            return invoke();
        }
    }

    private static /* synthetic */ void a(int i6) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"));
    }

    @NotNull
    public static <T> a<T> b(@Nullable T t5, @NotNull Function0<T> function0) {
        if (function0 == null) {
            a(0);
        }
        return new a<>(t5, function0);
    }

    @NotNull
    public static <T> a<T> c(@NotNull Function0<T> function0) {
        if (function0 == null) {
            a(1);
        }
        return b(null, function0);
    }
}
