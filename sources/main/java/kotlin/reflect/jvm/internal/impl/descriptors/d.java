package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.f2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface d extends e, g {
    @NotNull
    kotlin.reflect.jvm.internal.impl.resolve.scopes.k G();

    @NotNull
    kotlin.reflect.jvm.internal.impl.resolve.scopes.k H();

    @NotNull
    z0 V();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    d a();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    k b();

    @NotNull
    Collection<c> f();

    @Nullable
    o1<kotlin.reflect.jvm.internal.impl.types.e1> g0();

    @NotNull
    s getVisibility();

    @NotNull
    ClassKind h();

    @NotNull
    Modality i();

    boolean isInline();

    @NotNull
    List<z0> j0();

    boolean l0();

    @NotNull
    kotlin.reflect.jvm.internal.impl.resolve.scopes.k r0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    kotlin.reflect.jvm.internal.impl.types.e1 s();

    @Nullable
    d s0();

    @NotNull
    List<j1> t();

    boolean u();

    boolean v();

    @NotNull
    kotlin.reflect.jvm.internal.impl.resolve.scopes.k v0(@NotNull f2 f2Var);

    boolean w();

    @Nullable
    c z();
}
