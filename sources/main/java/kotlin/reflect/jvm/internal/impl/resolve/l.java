package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class l extends m {
    protected abstract void e(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2);

    @Override // kotlin.reflect.jvm.internal.impl.resolve.m
    public void b(@NotNull CallableMemberDescriptor first, @NotNull CallableMemberDescriptor second) {
        g0.p(first, "first");
        g0.p(second, "second");
        e(first, second);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.m
    public void c(@NotNull CallableMemberDescriptor fromSuper, @NotNull CallableMemberDescriptor fromCurrent) {
        g0.p(fromSuper, "fromSuper");
        g0.p(fromCurrent, "fromCurrent");
        e(fromSuper, fromCurrent);
    }
}
