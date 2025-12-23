package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.p;
import kotlin.reflect.jvm.internal.impl.load.java.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import y3.u;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j implements r0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final k f45683a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.a<kotlin.reflect.jvm.internal.impl.name.c, d0> f45684b;

    public j(@NotNull d components) {
        g0.p(components, "components");
        k kVar = new k(components, p.a.f45696a, t.e(null));
        this.f45683a = kVar;
        this.f45684b = kVar.e().d();
    }

    private final d0 e(kotlin.reflect.jvm.internal.impl.name.c cVar) {
        u a6 = s.a(this.f45683a.a().d(), cVar, false, 2, null);
        if (a6 == null) {
            return null;
        }
        return this.f45684b.a(cVar, new i(this, a6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d0 f(j jVar, u uVar) {
        return new d0(jVar.f45683a, uVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m0
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    @NotNull
    public List<d0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        g0.p(fqName, "fqName");
        return f0.R(e(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r0
    public void b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Collection<l0> packageFragments) {
        g0.p(fqName, "fqName");
        g0.p(packageFragments, "packageFragments");
        kotlin.reflect.jvm.internal.impl.utils.a.a(packageFragments, e(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r0
    public boolean c(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        g0.p(fqName, "fqName");
        return s.a(this.f45683a.a().d(), fqName, false, 2, null) == null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m0
    @NotNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.jvm.internal.impl.name.c> q(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        g0.p(fqName, "fqName");
        g0.p(nameFilter, "nameFilter");
        d0 e6 = e(fqName);
        List<kotlin.reflect.jvm.internal.impl.name.c> L0 = e6 != null ? e6.L0() : null;
        return L0 == null ? f0.J() : L0;
    }

    @NotNull
    public String toString() {
        return "LazyJavaPackageFragmentProvider of module " + this.f45683a.a().m();
    }
}
