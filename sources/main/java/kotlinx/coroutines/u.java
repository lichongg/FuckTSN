package kotlinx.coroutines;

import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u extends f2 {

    /* renamed from: e, reason: collision with root package name */
    @JvmField
    @NotNull
    public final q<?> f49661e;

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.n1 invoke(Throwable th) {
        z(th);
        return kotlin.n1.f44123a;
    }

    @Override // kotlinx.coroutines.f0
    public void z(@Nullable Throwable th) {
        q<?> qVar = this.f49661e;
        qVar.M(qVar.v(A()));
    }

    public u(@NotNull q<?> qVar) {
        this.f49661e = qVar;
    }
}
