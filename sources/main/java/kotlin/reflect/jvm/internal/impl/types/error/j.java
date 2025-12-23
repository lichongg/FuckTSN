package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull ErrorScopeKind kind, @NotNull String... formatParams) {
        super(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
        g0.p(kind, "kind");
        g0.p(formatParams, "formatParams");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        throw new IllegalStateException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        throw new IllegalStateException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> f() {
        throw new IllegalStateException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.f g(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        throw new IllegalStateException(k() + ", required name: " + name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<k> h(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        g0.p(kindFilter, "kindFilter");
        g0.p(nameFilter, "nameFilter");
        throw new IllegalStateException(k());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.k, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    /* renamed from: i */
    public Set<d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        throw new IllegalStateException(k() + ", required name: " + name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    /* renamed from: j */
    public Set<w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        throw new IllegalStateException(k() + ", required name: " + name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public Void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        throw new IllegalStateException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.error.f
    @NotNull
    public String toString() {
        return "ThrowingScope{" + k() + '}';
    }
}
