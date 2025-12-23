package kotlinx.coroutines.flow;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowSlot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a0 extends kotlinx.coroutines.flow.internal.c<y<?>> {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    public long f48840a = -1;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @Nullable
    public kotlin.coroutines.e<? super n1> f48841b;

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull y<?> yVar) {
        if (this.f48840a >= 0) {
            return false;
        }
        this.f48840a = yVar.b0();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public kotlin.coroutines.e<n1>[] b(@NotNull y<?> yVar) {
        long j6 = this.f48840a;
        this.f48840a = -1L;
        this.f48841b = null;
        return yVar.a0(j6);
    }
}
