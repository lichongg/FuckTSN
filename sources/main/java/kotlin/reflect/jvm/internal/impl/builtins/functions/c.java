package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.functions.e;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.storage.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c extends kotlin.reflect.jvm.internal.impl.resolve.scopes.f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull n storageManager, @NotNull b containingClass) {
        super(storageManager, containingClass);
        g0.p(storageManager, "storageManager");
        g0.p(containingClass, "containingClass");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.f
    @NotNull
    protected List<y> k() {
        kotlin.reflect.jvm.internal.impl.descriptors.d n6 = n();
        g0.n(n6, "null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
        e P0 = ((b) n6).P0();
        if (g0.g(P0, e.a.f44424f)) {
            return f0.l(d.E.a((b) n(), false));
        }
        if (g0.g(P0, e.d.f44427f)) {
            return f0.l(d.E.a((b) n(), true));
        }
        return f0.J();
    }
}
