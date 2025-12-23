package kotlinx.coroutines.channels;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.p0;
import kotlinx.coroutines.r3;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class a0<E> implements r3 {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public final kotlinx.coroutines.q<n<? extends E>> f48152a;

    @Override // kotlinx.coroutines.r3
    public void b(@NotNull p0<?> p0Var, int i6) {
        this.f48152a.b(p0Var, i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a0(@NotNull kotlinx.coroutines.q<? super n<? extends E>> qVar) {
        this.f48152a = qVar;
    }
}
