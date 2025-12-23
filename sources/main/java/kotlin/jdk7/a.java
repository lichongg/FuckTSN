package kotlin.jdk7;

import androidx.core.provider.c;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.l;
import kotlin.n1;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "AutoCloseableKt")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nAutoCloseableJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoCloseableJVM.kt\nkotlin/jdk7/AutoCloseableKt$AutoCloseable$1\n*L\n1#1,49:1\n*E\n"})
    /* renamed from: kotlin.jdk7.a$a, reason: collision with other inner class name */
    public static final class C0867a implements AutoCloseable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f43990a;

        public C0867a(Function0<n1> function0) {
            this.f43990a = function0;
        }

        @Override // java.lang.AutoCloseable
        public final void close() {
            this.f43990a.invoke();
        }
    }

    @SinceKotlin(version = "2.0")
    @InlineOnly
    private static final AutoCloseable a(Function0<n1> closeAction) {
        g0.p(closeAction, "closeAction");
        return new C0867a(closeAction);
    }

    @SinceKotlin(version = "1.2")
    @PublishedApi
    public static final void c(@Nullable AutoCloseable autoCloseable, @Nullable Throwable th) {
        if (autoCloseable != null) {
            if (th == null) {
                c.a(autoCloseable);
                return;
            }
            try {
                c.a(autoCloseable);
            } catch (Throwable th2) {
                l.a(th, th2);
            }
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T extends AutoCloseable, R> R d(T t5, Function1<? super T, ? extends R> block) {
        g0.p(block, "block");
        try {
            R invoke = block.invoke(t5);
            d0.d(1);
            c(t5, null);
            d0.c(1);
            return invoke;
        } finally {
        }
    }

    @SinceKotlin(version = "2.0")
    public static /* synthetic */ void b() {
    }
}
