package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.internal.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface c0<E> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static /* synthetic */ boolean a(c0 c0Var, Throwable th, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i6 & 1) != 0) {
                th = null;
            }
            return c0Var.S(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean c(@NotNull c0<? super E> c0Var, E e6) {
            Object r5 = c0Var.r(e6);
            if (n.m(r5)) {
                return true;
            }
            Throwable f6 = n.f(r5);
            if (f6 == null) {
                return false;
            }
            throw r0.o(f6);
        }

        @DelicateCoroutinesApi
        public static /* synthetic */ void b() {
        }
    }

    boolean S(@Nullable Throwable th);

    @Nullable
    Object T(E e6, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @NotNull
    kotlinx.coroutines.selects.i<E, c0<E>> i();

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    boolean offer(E e6);

    void q(@NotNull Function1<? super Throwable, n1> function1);

    @NotNull
    Object r(E e6);

    boolean z();
}
