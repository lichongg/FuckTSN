package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class m {
    public abstract void a(@NotNull CallableMemberDescriptor callableMemberDescriptor);

    public abstract void b(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2);

    public abstract void c(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2);

    public void d(@NotNull CallableMemberDescriptor member, @NotNull Collection<? extends CallableMemberDescriptor> overridden) {
        g0.p(member, "member");
        g0.p(overridden, "overridden");
        member.R(overridden);
    }
}
