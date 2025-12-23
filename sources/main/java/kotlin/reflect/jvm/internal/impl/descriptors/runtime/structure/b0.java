package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b0 extends u implements y3.u {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.c f44990a;

    @Override // y3.d
    public boolean s() {
        return false;
    }

    public b0(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        this.f44990a = fqName;
    }

    @Override // y3.u
    @NotNull
    public Collection<y3.g> G(@NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        kotlin.jvm.internal.g0.p(nameFilter, "nameFilter");
        return kotlin.collections.f0.J();
    }

    @Override // y3.d
    @Nullable
    public y3.a b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        return null;
    }

    @Override // y3.u
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.c d() {
        return this.f44990a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof b0) && kotlin.jvm.internal.g0.g(d(), ((b0) obj).d());
    }

    @Override // y3.d
    @NotNull
    public List<y3.a> getAnnotations() {
        return kotlin.collections.f0.J();
    }

    @NotNull
    public String toString() {
        return b0.class.getName() + ": " + d();
    }

    public int hashCode() {
        return d().hashCode();
    }

    @Override // y3.u
    @NotNull
    public Collection<y3.u> o() {
        return kotlin.collections.f0.J();
    }
}
