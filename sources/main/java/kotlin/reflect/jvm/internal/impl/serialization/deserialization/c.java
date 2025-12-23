package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class c implements kotlin.reflect.jvm.internal.impl.descriptors.r0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.n f46823a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final z f46824b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.f0 f46825c;

    /* renamed from: d, reason: collision with root package name */
    protected m f46826d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.descriptors.l0> f46827e;

    @Nullable
    protected abstract q e(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    public c(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull z finder, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 moduleDescriptor) {
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(finder, "finder");
        kotlin.jvm.internal.g0.p(moduleDescriptor, "moduleDescriptor");
        this.f46823a = storageManager;
        this.f46824b = finder;
        this.f46825c = moduleDescriptor;
        this.f46827e = storageManager.c(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.l0 f(c cVar, kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        q e6 = cVar.e(fqName);
        if (e6 == null) {
            return null;
        }
        e6.G0(cVar.g());
        return e6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m0
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.l0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        return kotlin.collections.f0.R(this.f46827e.invoke(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r0
    public void b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.l0> packageFragments) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        kotlin.jvm.internal.g0.p(packageFragments, "packageFragments");
        kotlin.reflect.jvm.internal.impl.utils.a.a(packageFragments, this.f46827e.invoke(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r0
    public boolean c(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        return (this.f46827e.g(fqName) ? (kotlin.reflect.jvm.internal.impl.descriptors.l0) this.f46827e.invoke(fqName) : e(fqName)) == null;
    }

    @NotNull
    protected final m g() {
        m mVar = this.f46826d;
        if (mVar != null) {
            return mVar;
        }
        kotlin.jvm.internal.g0.S("components");
        return null;
    }

    @NotNull
    protected final z h() {
        return this.f46824b;
    }

    @NotNull
    protected final kotlin.reflect.jvm.internal.impl.descriptors.f0 i() {
        return this.f46825c;
    }

    @NotNull
    protected final kotlin.reflect.jvm.internal.impl.storage.n j() {
        return this.f46823a;
    }

    protected final void k(@NotNull m mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<set-?>");
        this.f46826d = mVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m0
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.name.c> q(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        kotlin.jvm.internal.g0.p(nameFilter, "nameFilter");
        return u1.k();
    }
}
