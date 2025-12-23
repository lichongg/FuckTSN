package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.b0;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ObsoleteCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public interface c<E> extends r0, b0<E> {
    @NotNull
    j<E> getChannel();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @NotNull
        public static <E> kotlinx.coroutines.selects.g<E> b(@NotNull c<E> cVar) {
            return b0.a.d(cVar);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
        @Nullable
        public static <E> E c(@NotNull c<E> cVar) {
            return (E) b0.a.h(cVar);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
        @LowPriorityInOverloadResolution
        @Nullable
        public static <E> Object d(@NotNull c<E> cVar, @NotNull kotlin.coroutines.e<? super E> eVar) {
            return b0.a.i(cVar, eVar);
        }
    }
}
