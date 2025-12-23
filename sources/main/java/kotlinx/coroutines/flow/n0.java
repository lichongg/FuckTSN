package kotlinx.coroutines.flow;

import kotlin.jvm.JvmField;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n0 implements j<Object> {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public final Throwable f49070a;

    @Override // kotlinx.coroutines.flow.j
    @Nullable
    public Object emit(@Nullable Object obj, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        throw this.f49070a;
    }

    public n0(@NotNull Throwable th) {
        this.f49070a = th;
    }
}
