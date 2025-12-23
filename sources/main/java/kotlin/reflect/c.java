package kotlin.reflect;

import java.util.List;
import java.util.Map;
import kotlin.SinceKotlin;
import kotlin.internal.IntrinsicConstEvaluation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface c<R> extends b {
    R call(@NotNull Object... objArr);

    R callBy(@NotNull Map<KParameter, ? extends Object> map);

    @NotNull
    String getName();

    @NotNull
    List<KParameter> getParameters();

    @NotNull
    r getReturnType();

    @NotNull
    List<s> getTypeParameters();

    @Nullable
    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @IntrinsicConstEvaluation
        public static /* synthetic */ void a() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void b() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void c() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void d() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void e() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void f() {
        }

        @SinceKotlin(version = "1.3")
        public static /* synthetic */ void g() {
        }
    }
}
