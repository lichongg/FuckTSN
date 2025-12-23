package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface CallableMemberDescriptor extends a, c0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Kind {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public boolean isReal() {
            return this != FAKE_OVERRIDE;
        }
    }

    void R(@NotNull Collection<? extends CallableMemberDescriptor> collection);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    CallableMemberDescriptor a();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    Collection<? extends CallableMemberDescriptor> e();

    @NotNull
    CallableMemberDescriptor e0(k kVar, Modality modality, s sVar, Kind kind, boolean z5);

    @NotNull
    Kind h();
}
