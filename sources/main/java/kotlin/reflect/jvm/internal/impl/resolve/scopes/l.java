package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMemberScopeImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemberScopeImpl.kt\norg/jetbrains/kotlin/resolve/scopes/MemberScopeImpl\n+ 2 CollectionUtil.kt\norg/jetbrains/kotlin/utils/CollectionUtilKt\n*L\n1#1,56:1\n18#2,6:57\n18#2,6:63\n*S KotlinDebug\n*F\n+ 1 MemberScopeImpl.kt\norg/jetbrains/kotlin/resolve/scopes/MemberScopeImpl\n*L\n44#1:57,6\n49#1:63,6\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class l implements k {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    public Set<kotlin.reflect.jvm.internal.impl.name.f> f() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<? extends d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        return f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h6 = h(d.f46758v, kotlin.reflect.jvm.internal.impl.utils.i.k());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : h6) {
            if (obj instanceof d1) {
                kotlin.reflect.jvm.internal.impl.name.f name = ((d1) obj).getName();
                g0.o(name, "getName(...)");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<? extends w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        return f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h6 = h(d.f46759w, kotlin.reflect.jvm.internal.impl.utils.i.k());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : h6) {
            if (obj instanceof d1) {
                kotlin.reflect.jvm.internal.impl.name.f name = ((d1) obj).getName();
                g0.o(name, "getName(...)");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f g(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h(@NotNull d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        g0.p(kindFilter, "kindFilter");
        g0.p(nameFilter, "nameFilter");
        return f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull u3.b bVar) {
        k.b.a(this, fVar, bVar);
    }
}
