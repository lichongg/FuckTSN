package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function2;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class w<E> extends g<E> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.coroutines.e<n1> f48467e;

    public w(@NotNull kotlin.coroutines.i iVar, @NotNull d<E> dVar, @NotNull Function2<? super z<? super E>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        super(iVar, dVar, false);
        this.f48467e = kotlin.coroutines.intrinsics.a.c(function2, this, this);
    }

    @Override // kotlinx.coroutines.l2
    protected void f1() {
        o4.a.c(this.f48467e, this);
    }

    @Override // kotlinx.coroutines.channels.g, kotlinx.coroutines.channels.d
    @NotNull
    public b0<E> m() {
        b0<E> m6 = A1().m();
        start();
        return m6;
    }
}
