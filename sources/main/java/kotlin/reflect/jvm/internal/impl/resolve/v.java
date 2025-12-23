package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v {
    @NotNull
    public static final CallableMemberDescriptor a(@NotNull Collection<? extends CallableMemberDescriptor> descriptors) {
        Integer d6;
        g0.p(descriptors, "descriptors");
        descriptors.isEmpty();
        CallableMemberDescriptor callableMemberDescriptor = null;
        for (CallableMemberDescriptor callableMemberDescriptor2 : descriptors) {
            if (callableMemberDescriptor == null || ((d6 = kotlin.reflect.jvm.internal.impl.descriptors.r.d(callableMemberDescriptor.getVisibility(), callableMemberDescriptor2.getVisibility())) != null && d6.intValue() < 0)) {
                callableMemberDescriptor = callableMemberDescriptor2;
            }
        }
        g0.m(callableMemberDescriptor);
        return callableMemberDescriptor;
    }
}
