package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface j1 extends f, e4.p {
    boolean E();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    j1 a();

    @NotNull
    kotlin.reflect.jvm.internal.impl.storage.n d0();

    int getIndex();

    @NotNull
    List<kotlin.reflect.jvm.internal.impl.types.t0> getUpperBounds();

    boolean j();

    @NotNull
    Variance l();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    w1 o();
}
