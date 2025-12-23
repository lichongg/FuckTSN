package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a1 extends t0 {
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @Nullable
    protected kotlin.reflect.jvm.internal.impl.descriptors.z0 P() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6) {
        super(c6, null, 2, 0 == true ? 1 : 0);
        kotlin.jvm.internal.g0.p(c6, "c");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    protected void D(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> result) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(result, "result");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    protected t0.a Z(@NotNull y3.r method, @NotNull List<? extends j1> methodTypeParameters, @NotNull kotlin.reflect.jvm.internal.impl.types.t0 returnType, @NotNull List<? extends q1> valueParameters) {
        kotlin.jvm.internal.g0.p(method, "method");
        kotlin.jvm.internal.g0.p(methodTypeParameters, "methodTypeParameters");
        kotlin.jvm.internal.g0.p(returnType, "returnType");
        kotlin.jvm.internal.g0.p(valueParameters, "valueParameters");
        return new t0.a(returnType, null, valueParameters, methodTypeParameters, false, kotlin.collections.f0.J());
    }
}
