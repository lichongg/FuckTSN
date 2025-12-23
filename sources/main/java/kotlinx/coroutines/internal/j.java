package kotlinx.coroutines.internal;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j {
    public static final void a(@NotNull kotlin.coroutines.i iVar, @NotNull Throwable th) {
        Iterator<kotlinx.coroutines.n0> it = i.b().iterator();
        while (it.hasNext()) {
            try {
                it.next().s(iVar, th);
            } catch (ExceptionSuccessfullyProcessed unused) {
                return;
            } catch (Throwable th2) {
                i.c(kotlinx.coroutines.o0.c(th, th2));
            }
        }
        try {
            kotlin.l.a(th, new DiagnosticCoroutineContextException(iVar));
        } catch (Throwable unused2) {
        }
        i.c(th);
    }
}
