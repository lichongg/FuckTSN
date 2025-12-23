package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class a3 extends a<kotlin.n1> {
    public a3(@NotNull kotlin.coroutines.i iVar, boolean z5) {
        super(iVar, true, z5);
    }

    @Override // kotlinx.coroutines.l2
    protected boolean I0(@NotNull Throwable th) {
        o0.b(getContext(), th);
        return true;
    }
}
