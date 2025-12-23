package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class a<E> extends k<E> implements c<E> {
    public a(@NotNull kotlin.coroutines.i iVar, @NotNull j<E> jVar, boolean z5) {
        super(iVar, jVar, false, z5);
        K0((e2) iVar.get(e2.f48569s0));
    }

    @Override // kotlinx.coroutines.l2
    protected boolean I0(@NotNull Throwable th) {
        o0.b(getContext(), th);
        return true;
    }

    @Override // kotlinx.coroutines.l2
    protected void d1(@Nullable Throwable th) {
        j<E> A1 = A1();
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = s1.a(u0.a(this) + " was cancelled", th);
            }
        }
        A1.b(cancellationException);
    }
}
