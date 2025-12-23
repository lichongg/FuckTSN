package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface a extends l, o, g1<a> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.a$a, reason: collision with other inner class name */
    public interface InterfaceC0876a<V> {
    }

    @NotNull
    List<z0> A0();

    @Nullable
    <V> V N(InterfaceC0876a<V> interfaceC0876a);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    a a();

    @Nullable
    z0 c0();

    @NotNull
    Collection<? extends a> e();

    @Nullable
    z0 f0();

    @NotNull
    List<q1> g();

    @Nullable
    kotlin.reflect.jvm.internal.impl.types.t0 getReturnType();

    @NotNull
    List<j1> getTypeParameters();

    boolean n0();
}
