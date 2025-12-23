package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function2;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class w<T> extends a<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Function2<j<? super T>, kotlin.coroutines.e<? super n1>, Object> f49172a;

    @Override // kotlinx.coroutines.flow.a
    @Nullable
    public Object f(@NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object invoke = this.f49172a.invoke(jVar, eVar);
        return invoke == kotlin.coroutines.intrinsics.a.l() ? invoke : n1.f44123a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(@NotNull Function2<? super j<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        this.f49172a = function2;
    }
}
