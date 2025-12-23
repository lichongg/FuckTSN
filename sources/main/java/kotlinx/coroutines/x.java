package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@InternalCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public interface x extends e2 {
    @InternalCoroutinesApi
    void g(@NotNull u2 u2Var);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static <R> R b(@NotNull x xVar, R r5, @NotNull Function2<? super R, ? super i.b, ? extends R> function2) {
            return (R) e2.a.d(xVar, r5, function2);
        }

        @Nullable
        public static <E extends i.b> E c(@NotNull x xVar, @NotNull i.c<E> cVar) {
            return (E) e2.a.e(xVar, cVar);
        }

        @NotNull
        public static kotlin.coroutines.i d(@NotNull x xVar, @NotNull i.c<?> cVar) {
            return e2.a.h(xVar, cVar);
        }

        @NotNull
        public static kotlin.coroutines.i e(@NotNull x xVar, @NotNull kotlin.coroutines.i iVar) {
            return e2.a.i(xVar, iVar);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        public static e2 f(@NotNull x xVar, @NotNull e2 e2Var) {
            return e2.a.j(xVar, e2Var);
        }
    }
}
