package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d extends f {

    @NotNull
    private final d1 H;

    @Nullable
    private final d1 I;

    @NotNull
    private final w0 J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d ownerDescriptor, @NotNull d1 getterMethod, @Nullable d1 d1Var, @NotNull w0 overriddenProperty) {
        super(ownerDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b(), getterMethod.i(), getterMethod.getVisibility(), d1Var != null, overriddenProperty.getName(), getterMethod.getSource(), null, CallableMemberDescriptor.Kind.DECLARATION, false, null);
        g0.p(ownerDescriptor, "ownerDescriptor");
        g0.p(getterMethod, "getterMethod");
        g0.p(overriddenProperty, "overriddenProperty");
        this.H = getterMethod;
        this.I = d1Var;
        this.J = overriddenProperty;
    }
}
