package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.h2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface w0 extends CallableMemberDescriptor, t1 {
    @Nullable
    v D();

    @Nullable
    v O();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    w0 a();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
    w0 c(@NotNull h2 h2Var);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    Collection<? extends w0> e();

    @Nullable
    x0 getGetter();

    @Nullable
    y0 getSetter();

    @NotNull
    List<v0> x();
}
