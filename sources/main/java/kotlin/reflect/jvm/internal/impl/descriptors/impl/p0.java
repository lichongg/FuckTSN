package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class p0 extends kotlin.reflect.jvm.internal.impl.resolve.scopes.l {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.f0 f44816b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.c f44817c;

    public p0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 moduleDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        this.f44816b = moduleDescriptor;
        this.f44817c = fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
        kotlin.jvm.internal.g0.p(nameFilter, "nameFilter");
        if (!kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46739c.f())) {
            return kotlin.collections.f0.J();
        }
        if (this.f44817c.c() && kindFilter.l().contains(c.b.f46738a)) {
            return kotlin.collections.f0.J();
        }
        Collection<kotlin.reflect.jvm.internal.impl.name.c> q5 = this.f44816b.q(this.f44817c, nameFilter);
        ArrayList arrayList = new ArrayList(q5.size());
        Iterator<kotlin.reflect.jvm.internal.impl.name.c> it = q5.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.name.f f6 = it.next().f();
            if (nameFilter.invoke(f6).booleanValue()) {
                kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, i(f6));
            }
        }
        return arrayList;
    }

    @Nullable
    protected final kotlin.reflect.jvm.internal.impl.descriptors.s0 i(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        if (name.i()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.s0 M = this.f44816b.M(this.f44817c.b(name));
        if (M.isEmpty()) {
            return null;
        }
        return M;
    }

    @NotNull
    public String toString() {
        return "subpackages of " + this.f44817c + " from " + this.f44816b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> f() {
        return u1.k();
    }
}
