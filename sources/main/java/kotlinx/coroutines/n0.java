package kotlinx.coroutines;

import kotlin.coroutines.i;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface n0 extends i.b {

    /* renamed from: r0, reason: collision with root package name */
    @NotNull
    public static final b f49394r0 = b.f49395a;

    void s(@NotNull kotlin.coroutines.i iVar, @NotNull Throwable th);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static <R> R a(@NotNull n0 n0Var, R r5, @NotNull Function2<? super R, ? super i.b, ? extends R> function2) {
            return (R) i.b.a.a(n0Var, r5, function2);
        }

        @Nullable
        public static <E extends i.b> E b(@NotNull n0 n0Var, @NotNull i.c<E> cVar) {
            return (E) i.b.a.b(n0Var, cVar);
        }

        @NotNull
        public static kotlin.coroutines.i c(@NotNull n0 n0Var, @NotNull i.c<?> cVar) {
            return i.b.a.c(n0Var, cVar);
        }

        @NotNull
        public static kotlin.coroutines.i d(@NotNull n0 n0Var, @NotNull kotlin.coroutines.i iVar) {
            return i.b.a.d(n0Var, iVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements i.c<n0> {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f49395a = new b();

        private b() {
        }
    }
}
