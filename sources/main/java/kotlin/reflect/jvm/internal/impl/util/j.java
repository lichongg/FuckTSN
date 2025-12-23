package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.n;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.util.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class j implements f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f47406a = new j();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f47407b = "second parameter must be of type KProperty<*> or its supertype";

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y functionDescriptor) {
        g0.p(functionDescriptor, "functionDescriptor");
        q1 q1Var = functionDescriptor.g().get(1);
        n.b bVar = kotlin.reflect.jvm.internal.impl.builtins.n.f44544k;
        g0.m(q1Var);
        t0 a6 = bVar.a(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.s(q1Var));
        if (a6 == null) {
            return false;
        }
        t0 type = q1Var.getType();
        g0.o(type, "getType(...)");
        return kotlin.reflect.jvm.internal.impl.types.typeUtil.e.x(a6, kotlin.reflect.jvm.internal.impl.types.typeUtil.e.B(type));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    @NotNull
    public String getDescription() {
        return f47407b;
    }

    private j() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    @Nullable
    public String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        return f.a.a(this, yVar);
    }
}
