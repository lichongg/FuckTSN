package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.i;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l implements kotlin.coroutines.i {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public final Throwable f49019a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ kotlin.coroutines.i f49020b;

    @Override // kotlin.coroutines.i
    public <R> R fold(R r5, @NotNull Function2<? super R, ? super i.b, ? extends R> function2) {
        return (R) this.f49020b.fold(r5, function2);
    }

    @Override // kotlin.coroutines.i
    @Nullable
    public <E extends i.b> E get(@NotNull i.c<E> cVar) {
        return (E) this.f49020b.get(cVar);
    }

    @Override // kotlin.coroutines.i
    @NotNull
    public kotlin.coroutines.i minusKey(@NotNull i.c<?> cVar) {
        return this.f49020b.minusKey(cVar);
    }

    @Override // kotlin.coroutines.i
    @NotNull
    public kotlin.coroutines.i plus(@NotNull kotlin.coroutines.i iVar) {
        return this.f49020b.plus(iVar);
    }

    public l(@NotNull Throwable th, @NotNull kotlin.coroutines.i iVar) {
        this.f49019a = th;
        this.f49020b = iVar;
    }
}
