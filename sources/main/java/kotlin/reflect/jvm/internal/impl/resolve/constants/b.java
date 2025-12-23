package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class b extends g<List<? extends g<?>>> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<kotlin.reflect.jvm.internal.impl.descriptors.f0, t0> f46662b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull List<? extends g<?>> value, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.f0, ? extends t0> computeType) {
        super(value);
        g0.p(value, "value");
        g0.p(computeType, "computeType");
        this.f46662b = computeType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public t0 getType(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module) {
        g0.p(module, "module");
        t0 invoke = this.f46662b.invoke(module);
        if (!kotlin.reflect.jvm.internal.impl.builtins.j.d0(invoke) && !kotlin.reflect.jvm.internal.impl.builtins.j.r0(invoke)) {
            kotlin.reflect.jvm.internal.impl.builtins.j.E0(invoke);
        }
        return invoke;
    }
}
