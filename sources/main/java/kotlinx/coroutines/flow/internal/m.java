package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.internal.o0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class m<T> extends o0<T> {
    @Override // kotlinx.coroutines.l2
    public boolean n0(@NotNull Throwable th) {
        if (th instanceof ChildCancelledException) {
            return true;
        }
        return i0(th);
    }

    public m(@NotNull kotlin.coroutines.i iVar, @NotNull kotlin.coroutines.e<? super T> eVar) {
        super(iVar, eVar);
    }
}
