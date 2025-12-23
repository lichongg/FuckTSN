package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.types.f2;
import kotlin.reflect.jvm.internal.impl.types.h2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface y extends CallableMemberDescriptor {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a<D extends y> {
        @NotNull
        a<D> a(@Nullable z0 z0Var);

        @NotNull
        a<D> b(@Nullable z0 z0Var);

        @Nullable
        D build();

        @NotNull
        a<D> c(@NotNull f2 f2Var);

        @NotNull
        <V> a<D> d(@NotNull a.InterfaceC0876a<V> interfaceC0876a, V v5);

        @NotNull
        a<D> e();

        @NotNull
        a<D> f(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

        @NotNull
        a<D> g();

        @NotNull
        a<D> h(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var);

        @NotNull
        a<D> i(@Nullable CallableMemberDescriptor callableMemberDescriptor);

        @NotNull
        a<D> j(boolean z5);

        @NotNull
        a<D> k(@NotNull List<j1> list);

        @NotNull
        a<D> l(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar);

        @NotNull
        a<D> m();

        @NotNull
        a<D> n(@NotNull List<q1> list);

        @NotNull
        a<D> o();

        @NotNull
        a<D> p(@NotNull s sVar);

        @NotNull
        a<D> q(@NotNull Modality modality);

        @NotNull
        a<D> r(@NotNull k kVar);

        @NotNull
        a<D> s(@NotNull CallableMemberDescriptor.Kind kind);

        @NotNull
        a<D> t();
    }

    boolean D0();

    boolean S();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    y a();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    k b();

    @Nullable
    y c(@NotNull h2 h2Var);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    Collection<? extends y> e();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    @NotNull
    a<? extends y> n();

    @Nullable
    y x0();

    boolean y();
}
