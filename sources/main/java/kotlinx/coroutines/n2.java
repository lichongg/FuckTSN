package kotlinx.coroutines;

import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class n2<T> extends y0<T> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.coroutines.e<kotlin.n1> f49399d;

    public n2(@NotNull kotlin.coroutines.i iVar, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2) {
        super(iVar, false);
        this.f49399d = kotlin.coroutines.intrinsics.a.c(function2, this, this);
    }

    @Override // kotlinx.coroutines.l2
    protected void f1() {
        o4.a.c(this.f49399d, this);
    }
}
