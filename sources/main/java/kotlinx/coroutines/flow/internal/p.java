package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@InternalCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public interface p<T> extends kotlinx.coroutines.flow.i<T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static /* synthetic */ kotlinx.coroutines.flow.i a(p pVar, kotlin.coroutines.i iVar, int i6, BufferOverflow bufferOverflow, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            }
            if ((i7 & 1) != 0) {
                iVar = EmptyCoroutineContext.INSTANCE;
            }
            if ((i7 & 2) != 0) {
                i6 = -3;
            }
            if ((i7 & 4) != 0) {
                bufferOverflow = BufferOverflow.SUSPEND;
            }
            return pVar.e(iVar, i6, bufferOverflow);
        }
    }

    @NotNull
    kotlinx.coroutines.flow.i<T> e(@NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow);
}
