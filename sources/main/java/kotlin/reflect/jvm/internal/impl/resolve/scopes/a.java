package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a implements k {
    @NotNull
    protected abstract k j();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        return j().a(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        return j().c(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        j().e(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f g(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        return j().g(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h(@NotNull d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        g0.p(kindFilter, "kindFilter");
        g0.p(nameFilter, "nameFilter");
        return j().h(kindFilter, nameFilter);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        return j().b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        return j().d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    public Set<kotlin.reflect.jvm.internal.impl.name.f> f() {
        return j().f();
    }

    @NotNull
    public final k i() {
        if (j() instanceof a) {
            k j6 = j();
            g0.n(j6, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter");
            return ((a) j6).i();
        }
        return j();
    }
}
