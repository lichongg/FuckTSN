package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.flow.internal.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class n {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ i a(i iVar, int i6) {
        return d(iVar, i6, null, 2, null);
    }

    @NotNull
    public static final <T> i<T> b(@NotNull i<? extends T> iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        int i7;
        if (i6 < 0 && i6 != -2 && i6 != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i6).toString());
        }
        if (i6 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i6 == -1) {
            bufferOverflow = BufferOverflow.DROP_OLDEST;
            i7 = 0;
        } else {
            i7 = i6;
        }
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if (iVar instanceof kotlinx.coroutines.flow.internal.p) {
            return p.a.a((kotlinx.coroutines.flow.internal.p) iVar, null, i7, bufferOverflow2, 1, null);
        }
        return new kotlinx.coroutines.flow.internal.h(iVar, null, i7, bufferOverflow2, 2, null);
    }

    @NotNull
    public static final <T> i<T> g(@NotNull i<? extends T> iVar) {
        return d(iVar, -1, null, 2, null);
    }

    public static /* synthetic */ i c(i iVar, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = -2;
        }
        return a(iVar, i6);
    }

    public static /* synthetic */ i d(i iVar, int i6, BufferOverflow bufferOverflow, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = -2;
        }
        if ((i7 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return k.o(iVar, i6, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> i<T> e(@NotNull i<? extends T> iVar) {
        return iVar instanceof c ? iVar : new d(iVar);
    }

    private static final void f(kotlin.coroutines.i iVar) {
        if (iVar.get(e2.f48569s0) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + iVar).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> i<T> h(@NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.i iVar2) {
        f(iVar2);
        if (kotlin.jvm.internal.g0.g(iVar2, EmptyCoroutineContext.INSTANCE)) {
            return iVar;
        }
        if (iVar instanceof kotlinx.coroutines.flow.internal.p) {
            return p.a.a((kotlinx.coroutines.flow.internal.p) iVar, iVar2, 0, null, 6, null);
        }
        return new kotlinx.coroutines.flow.internal.h(iVar, iVar2, 0, null, 12, null);
    }
}
