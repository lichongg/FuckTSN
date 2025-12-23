package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.i1;
import kotlin.collections.u1;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.i0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nModuleDescriptorImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModuleDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/ModuleDescriptorImpl\n+ 2 coreLib.kt\norg/jetbrains/kotlin/utils/CoreLibKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n19#2:181\n19#2:185\n19#2:186\n19#2:188\n774#3:182\n865#3,2:183\n1869#3,2:189\n1563#3:191\n1634#3,3:192\n1#4:187\n*S KotlinDebug\n*F\n+ 1 ModuleDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/ModuleDescriptorImpl\n*L\n72#1:181\n75#1:185\n78#1:186\n91#1:188\n72#1:182\n72#1:183,2\n95#1:189,2\n101#1:191\n101#1:192,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f0 extends m implements kotlin.reflect.jvm.internal.impl.descriptors.f0 {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.n f44708c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.builtins.j f44709d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final a4.c f44710e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private final kotlin.reflect.jvm.internal.impl.name.f f44711f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final Map<kotlin.reflect.jvm.internal.impl.descriptors.e0<?>, Object> f44712g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final i0 f44713h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private b0 f44714i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private kotlin.reflect.jvm.internal.impl.descriptors.m0 f44715j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f44716k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.descriptors.s0> f44717l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final kotlin.s f44718m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public f0(@NotNull kotlin.reflect.jvm.internal.impl.name.f moduleName, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.builtins.j builtIns, @Nullable a4.c cVar) {
        this(moduleName, storageManager, builtIns, cVar, null, null, 48, null);
        kotlin.jvm.internal.g0.p(moduleName, "moduleName");
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(builtIns, "builtIns");
    }

    public /* synthetic */ f0(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.storage.n nVar, kotlin.reflect.jvm.internal.impl.builtins.j jVar, a4.c cVar, Map map, kotlin.reflect.jvm.internal.impl.name.f fVar2, int i6, kotlin.jvm.internal.v vVar) {
        this(fVar, nVar, jVar, (i6 & 8) != 0 ? null : cVar, (i6 & 16) != 0 ? i1.z() : map, (i6 & 32) != 0 ? null : fVar2);
    }

    private final l I0() {
        return (l) this.f44718m.getValue();
    }

    private final boolean K0() {
        return this.f44715j != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l M0(f0 f0Var) {
        b0 b0Var = f0Var.f44714i;
        if (b0Var == null) {
            throw new AssertionError("Dependencies of module " + f0Var.G0() + " were not set before querying module content");
        }
        List<f0> c6 = b0Var.c();
        f0Var.F0();
        c6.contains(f0Var);
        List<f0> list = c6;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((f0) it.next()).K0();
        }
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.m0 m0Var = ((f0) it2.next()).f44715j;
            kotlin.jvm.internal.g0.m(m0Var);
            arrayList.add(m0Var);
        }
        return new l(arrayList, "CompositeProvider@ModuleDescriptor for " + f0Var.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.s0 N0(f0 f0Var, kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        return f0Var.f44713h.a(f0Var, fqName, f0Var.f44708c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f0
    public boolean B(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 targetModule) {
        kotlin.jvm.internal.g0.p(targetModule, "targetModule");
        if (kotlin.jvm.internal.g0.g(this, targetModule)) {
            return true;
        }
        b0 b0Var = this.f44714i;
        kotlin.jvm.internal.g0.m(b0Var);
        return kotlin.collections.f0.a2(b0Var.b(), targetModule) || P().contains(targetModule) || targetModule.P().contains(this);
    }

    public final void J0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.m0 providerForModuleContent) {
        kotlin.jvm.internal.g0.p(providerForModuleContent, "providerForModuleContent");
        K0();
        this.f44715j = providerForModuleContent;
    }

    public boolean L0() {
        return this.f44716k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s0 M(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        F0();
        return this.f44717l.invoke(fqName);
    }

    public final void O0(@NotNull List<f0> descriptors) {
        kotlin.jvm.internal.g0.p(descriptors, "descriptors");
        P0(descriptors, u1.k());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f0
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.f0> P() {
        b0 b0Var = this.f44714i;
        if (b0Var != null) {
            return b0Var.a();
        }
        throw new AssertionError("Dependencies of module " + G0() + " were not set");
    }

    public final void P0(@NotNull List<f0> descriptors, @NotNull Set<f0> friends) {
        kotlin.jvm.internal.g0.p(descriptors, "descriptors");
        kotlin.jvm.internal.g0.p(friends, "friends");
        Q0(new c0(descriptors, friends, kotlin.collections.f0.J(), u1.k()));
    }

    public final void Q0(@NotNull b0 dependencies) {
        kotlin.jvm.internal.g0.p(dependencies, "dependencies");
        this.f44714i = dependencies;
    }

    public final void R0(@NotNull f0... descriptors) {
        kotlin.jvm.internal.g0.p(descriptors, "descriptors");
        O0(kotlin.collections.n.dz(descriptors));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f0
    @Nullable
    public <T> T U(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.e0<T> capability) {
        kotlin.jvm.internal.g0.p(capability, "capability");
        T t5 = (T) this.f44712g.get(capability);
        if (t5 == null) {
            return null;
        }
        return t5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.builtins.j p() {
        return this.f44709d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f0
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.name.c> q(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        kotlin.jvm.internal.g0.p(nameFilter, "nameFilter");
        F0();
        return H0().q(fqName, nameFilter);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (!L0()) {
            sb.append(" !isValid");
        }
        sb.append(" packageFragmentProvider: ");
        kotlin.reflect.jvm.internal.impl.descriptors.m0 m0Var = this.f44715j;
        sb.append(m0Var != null ? m0Var.getClass().getSimpleName() : null);
        return sb.toString();
    }

    private final String G0() {
        String fVar = getName().toString();
        kotlin.jvm.internal.g0.o(fVar, "toString(...)");
        return fVar;
    }

    public void F0() {
        if (!L0()) {
            kotlin.reflect.jvm.internal.impl.descriptors.a0.a(this);
        }
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.m0 H0() {
        F0();
        return I0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @Nullable
    public <R, D> R W(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d6) {
        return (R) f0.a.a(this, mVar, d6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.k b() {
        return f0.a.b(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public f0(@NotNull kotlin.reflect.jvm.internal.impl.name.f moduleName, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.builtins.j builtIns, @Nullable a4.c cVar, @NotNull Map<kotlin.reflect.jvm.internal.impl.descriptors.e0<?>, ? extends Object> capabilities, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b(), moduleName);
        kotlin.jvm.internal.g0.p(moduleName, "moduleName");
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(builtIns, "builtIns");
        kotlin.jvm.internal.g0.p(capabilities, "capabilities");
        this.f44708c = storageManager;
        this.f44709d = builtIns;
        this.f44710e = cVar;
        this.f44711f = fVar;
        if (moduleName.i()) {
            this.f44712g = capabilities;
            i0 i0Var = (i0) U(i0.f44751a.a());
            this.f44713h = i0Var == null ? i0.b.f44754b : i0Var;
            this.f44716k = true;
            this.f44717l = storageManager.i(new d0(this));
            this.f44718m = kotlin.t.c(new e0(this));
            return;
        }
        throw new IllegalArgumentException("Module name must be special: " + moduleName);
    }
}
