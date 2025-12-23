package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class d2 extends k2 {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final Function1<Throwable, kotlin.n1> f48478e;

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.n1 invoke(Throwable th) {
        z(th);
        return kotlin.n1.f44123a;
    }

    @Override // kotlinx.coroutines.f0
    public void z(@Nullable Throwable th) {
        this.f48478e.invoke(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d2(@NotNull Function1<? super Throwable, kotlin.n1> function1) {
        this.f48478e = function1;
    }
}
