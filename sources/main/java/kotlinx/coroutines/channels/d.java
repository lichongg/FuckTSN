package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.c0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
@ObsoleteCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public interface d<E> extends c0<E> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static /* synthetic */ void a(d dVar, CancellationException cancellationException, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i6 & 1) != 0) {
                cancellationException = null;
            }
            dVar.b(cancellationException);
        }

        public static /* synthetic */ boolean b(d dVar, Throwable th, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i6 & 1) != 0) {
                th = null;
            }
            return dVar.a(th);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean c(@NotNull d<E> dVar, E e6) {
            return c0.a.c(dVar, e6);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility only")
    /* synthetic */ boolean a(Throwable th);

    void b(@Nullable CancellationException cancellationException);

    @NotNull
    b0<E> m();
}
