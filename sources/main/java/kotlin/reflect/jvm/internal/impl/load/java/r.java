package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r implements ExternalOverridabilityCondition {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Contract a() {
        return ExternalOverridabilityCondition.Contract.BOTH;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Result b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.jvm.internal.g0.p(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.g0.p(subDescriptor, "subDescriptor");
        if (!(subDescriptor instanceof w0) || !(superDescriptor instanceof w0)) {
            return ExternalOverridabilityCondition.Result.UNKNOWN;
        }
        w0 w0Var = (w0) subDescriptor;
        w0 w0Var2 = (w0) superDescriptor;
        return !kotlin.jvm.internal.g0.g(w0Var.getName(), w0Var2.getName()) ? ExternalOverridabilityCondition.Result.UNKNOWN : (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.d.a(w0Var) && kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.d.a(w0Var2)) ? ExternalOverridabilityCondition.Result.OVERRIDABLE : (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.d.a(w0Var) || kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.d.a(w0Var2)) ? ExternalOverridabilityCondition.Result.INCOMPATIBLE : ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
