package kotlin.internal;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.collections.f0;
import kotlin.collections.n;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.random.Random;
import kotlin.text.m;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n1#2:87\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations$ReflectThrowable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n1#2:87\n*E\n"})
    /* renamed from: kotlin.internal.a$a, reason: collision with other inner class name */
    private static final class C0863a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C0863a f43801a = new C0863a();

        /* renamed from: b, reason: collision with root package name */
        @JvmField
        @Nullable
        public static final Method f43802b;

        /* renamed from: c, reason: collision with root package name */
        @JvmField
        @Nullable
        public static final Method f43803c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            g0.m(methods);
            int length = methods.length;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                method = null;
                if (i7 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i7];
                if (g0.g(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    g0.o(parameterTypes, "getParameterTypes(...)");
                    if (g0.g(n.Ut(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i7++;
            }
            f43802b = method2;
            int length2 = methods.length;
            while (true) {
                if (i6 >= length2) {
                    break;
                }
                Method method3 = methods[i6];
                if (g0.g(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i6++;
            }
            f43803c = method;
        }

        private C0863a() {
        }
    }

    public void a(@NotNull Throwable cause, @NotNull Throwable exception) {
        g0.p(cause, "cause");
        g0.p(exception, "exception");
        Method method = C0863a.f43802b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    @NotNull
    public Random b() {
        return new kotlin.random.b();
    }

    @Nullable
    public m c(@NotNull MatchResult matchResult, @NotNull String name) {
        g0.p(matchResult, "matchResult");
        g0.p(name, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    @NotNull
    public List<Throwable> d(@NotNull Throwable exception) {
        Object invoke;
        List<Throwable> t5;
        g0.p(exception, "exception");
        Method method = C0863a.f43803c;
        return (method == null || (invoke = method.invoke(exception, null)) == null || (t5 = n.t((Throwable[]) invoke)) == null) ? f0.J() : t5;
    }

    @ExperimentalTime
    @NotNull
    public kotlin.time.e e() {
        throw new UnsupportedOperationException("getSystemClock should not be called on the base PlatformImplementations.");
    }
}
