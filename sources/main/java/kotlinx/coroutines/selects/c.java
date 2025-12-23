package kotlinx.coroutines.selects;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface c<R> {
    void a(@NotNull e eVar, @NotNull Function1<? super kotlin.coroutines.e<? super R>, ? extends Object> function1);

    <P, Q> void c(@NotNull i<? super P, ? extends Q> iVar, P p5, @NotNull Function2<? super Q, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @ReplaceWith(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
    @LowPriorityInOverloadResolution
    @ExperimentalCoroutinesApi
    void d(long j6, @NotNull Function1<? super kotlin.coroutines.e<? super R>, ? extends Object> function1);

    <P, Q> void i(@NotNull i<? super P, ? extends Q> iVar, @NotNull Function2<? super Q, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2);

    <Q> void k(@NotNull g<? extends Q> gVar, @NotNull Function2<? super Q, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static <R, P, Q> void a(@NotNull c<? super R> cVar, @NotNull i<? super P, ? extends Q> iVar, @NotNull Function2<? super Q, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
            cVar.c(iVar, null, function2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @ReplaceWith(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
        @LowPriorityInOverloadResolution
        @ExperimentalCoroutinesApi
        public static <R> void b(@NotNull c<? super R> cVar, long j6, @NotNull Function1<? super kotlin.coroutines.e<? super R>, ? extends Object> function1) {
            b.a(cVar, j6, function1);
        }
    }
}
