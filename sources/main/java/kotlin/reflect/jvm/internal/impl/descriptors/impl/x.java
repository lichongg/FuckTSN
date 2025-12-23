package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLazyPackageViewDescriptorImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyPackageViewDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/LazyPackageViewDescriptorImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,71:1\n1563#2:72\n1634#2,3:73\n*S KotlinDebug\n*F\n+ 1 LazyPackageViewDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/LazyPackageViewDescriptorImpl\n*L\n49#1:72\n49#1:73,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class x extends m implements kotlin.reflect.jvm.internal.impl.descriptors.s0 {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f44907h = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(x.class, "fragments", "getFragments()Ljava/util/List;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(x.class, "empty", "getEmpty()Z", 0))};

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final f0 f44908c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.c f44909d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f44910e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f44911f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.k f44912g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(@NotNull f0 module, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b(), fqName.g());
        kotlin.jvm.internal.g0.p(module, "module");
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        this.f44908c = module;
        this.f44909d = fqName;
        this.f44910e = storageManager.e(new u(this));
        this.f44911f = storageManager.e(new v(this));
        this.f44912g = new kotlin.reflect.jvm.internal.impl.resolve.scopes.i(storageManager, new w(this));
    }

    protected final boolean J0() {
        return ((Boolean) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f44911f, this, f44907h[1])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s0
    @NotNull
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public f0 C0() {
        return this.f44908c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s0
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.l0> L() {
        return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f44910e, this, f44907h[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R W(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> visitor, D d6) {
        kotlin.jvm.internal.g0.p(visitor, "visitor");
        return visitor.b(this, d6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.c d() {
        return this.f44909d;
    }

    public boolean equals(@Nullable Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.s0 s0Var = obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.s0 ? (kotlin.reflect.jvm.internal.impl.descriptors.s0) obj : null;
        return s0Var != null && kotlin.jvm.internal.g0.g(d(), s0Var.d()) && kotlin.jvm.internal.g0.g(C0(), s0Var.C0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k r() {
        return this.f44912g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G0(x xVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.q0.b(xVar.C0().H0(), xVar.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List H0(x xVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.q0.c(xVar.C0().H0(), xVar.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.k L0(x xVar) {
        if (xVar.isEmpty()) {
            return k.c.f46780b;
        }
        List<kotlin.reflect.jvm.internal.impl.descriptors.l0> L = xVar.L();
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(L, 10));
        Iterator<T> it = L.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.l0) it.next()).r());
        }
        List J4 = kotlin.collections.f0.J4(arrayList, new p0(xVar.C0(), xVar.d()));
        return kotlin.reflect.jvm.internal.impl.resolve.scopes.b.f46733d.a("package view scope for " + xVar.d() + " in " + xVar.C0().getName(), J4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @Nullable
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.s0 b() {
        if (d().c()) {
            return null;
        }
        return C0().M(d().d());
    }

    public int hashCode() {
        return (C0().hashCode() * 31) + d().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s0
    public boolean isEmpty() {
        return J0();
    }
}
