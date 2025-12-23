package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class b2 extends n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Function1<Throwable, kotlin.n1> f48103a;

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.n1 invoke(Throwable th) {
        l(th);
        return kotlin.n1.f44123a;
    }

    @Override // kotlinx.coroutines.o
    public void l(@Nullable Throwable th) {
        this.f48103a.invoke(th);
    }

    @NotNull
    public String toString() {
        return "InvokeOnCancel[" + u0.a(this.f48103a) + '@' + u0.b(this) + ']';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b2(@NotNull Function1<? super Throwable, kotlin.n1> function1) {
        this.f48103a = function1;
    }
}
