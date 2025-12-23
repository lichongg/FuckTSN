package kotlinx.coroutines.flow;

import kotlinx.coroutines.flow.c0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d0 {
    @NotNull
    public static final c0 a(@NotNull c0.a aVar, long j6, long j7) {
        return new g0(kotlin.time.h.x(j6), kotlin.time.h.x(j7));
    }

    public static /* synthetic */ c0 b(c0.a aVar, long j6, long j7, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            j6 = kotlin.time.h.f48019b.T();
        }
        if ((i6 & 2) != 0) {
            j7 = kotlin.time.h.f48019b.n();
        }
        return a(aVar, j6, j7);
    }
}
