package kotlin.internal.jdk7;

import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a extends kotlin.internal.a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nJDK7PlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JDK7PlatformImplementations.kt\nkotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,38:1\n1#2:39\n*E\n"})
    /* renamed from: kotlin.internal.jdk7.a$a, reason: collision with other inner class name */
    private static final class C0864a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C0864a f43805a = new C0864a();

        /* renamed from: b, reason: collision with root package name */
        @JvmField
        @Nullable
        public static final Integer f43806b;

        static {
            Integer num;
            Object obj;
            Integer num2 = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
                if (num != null && num.intValue() > 0) {
                    num2 = num;
                }
                f43806b = num2;
            }
            num = null;
            if (num != null) {
                num2 = num;
            }
            f43806b = num2;
        }

        private C0864a() {
        }
    }

    private final boolean f(int i6) {
        Integer num = C0864a.f43806b;
        return num == null || num.intValue() >= i6;
    }

    @Override // kotlin.internal.a
    public void a(@NotNull Throwable cause, @NotNull Throwable exception) {
        g0.p(cause, "cause");
        g0.p(exception, "exception");
        if (f(19)) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }

    @Override // kotlin.internal.a
    @NotNull
    public List<Throwable> d(@NotNull Throwable exception) {
        g0.p(exception, "exception");
        if (!f(19)) {
            return super.d(exception);
        }
        Throwable[] suppressed = exception.getSuppressed();
        g0.o(suppressed, "getSuppressed(...)");
        return n.t(suppressed);
    }
}
