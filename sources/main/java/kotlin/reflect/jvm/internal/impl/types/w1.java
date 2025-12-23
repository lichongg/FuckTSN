package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface w1 extends e4.o {
    @NotNull
    w1 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar);

    @Nullable
    kotlin.reflect.jvm.internal.impl.descriptors.f c();

    boolean d();

    @NotNull
    List<kotlin.reflect.jvm.internal.impl.descriptors.j1> getParameters();

    @NotNull
    Collection<t0> i();

    @NotNull
    kotlin.reflect.jvm.internal.impl.builtins.j p();
}
