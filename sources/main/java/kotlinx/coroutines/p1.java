package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.o1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class p1 extends n1 {
    @NotNull
    protected abstract Thread P();

    protected void Q(long j6, @NotNull o1.c cVar) {
        v0.f49663g.b0(j6, cVar);
    }

    protected final void R() {
        kotlin.n1 n1Var;
        Thread P = P();
        if (Thread.currentThread() != P) {
            b b6 = c.b();
            if (b6 != null) {
                b6.g(P);
                n1Var = kotlin.n1.f44123a;
            } else {
                n1Var = null;
            }
            if (n1Var == null) {
                LockSupport.unpark(P);
            }
        }
    }
}
