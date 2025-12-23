package kotlin.internal;

import java.io.InvalidObjectException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {
    @InlineOnly
    private static final Void a() {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @InlineOnly
    private static final void b(Function0<n1> action) {
        g0.p(action, "action");
        try {
            action.invoke();
        } catch (Throwable th) {
            Throwable initCause = new InvalidObjectException(th.getMessage()).initCause(th);
            g0.o(initCause, "initCause(...)");
            throw initCause;
        }
    }
}
