package kotlinx.coroutines.channels;

import kotlin.n1;
import kotlinx.coroutines.channels.c0;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class y<E> extends k<E> implements z<E> {
    public y(@NotNull kotlin.coroutines.i iVar, @NotNull j<E> jVar) {
        super(iVar, jVar, true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.a
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void y1(@NotNull n1 n1Var) {
        c0.a.a(A1(), null, 1, null);
    }

    @Override // kotlinx.coroutines.channels.z
    public /* bridge */ /* synthetic */ c0 getChannel() {
        return getChannel();
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.l2, kotlinx.coroutines.e2
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.a
    protected void x1(@NotNull Throwable th, boolean z5) {
        if (!A1().S(th) && !z5) {
            o0.b(getContext(), th);
        }
    }
}
