package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nStaticScopeForKotlinEnum.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StaticScopeForKotlinEnum.kt\norg/jetbrains/kotlin/resolve/scopes/StaticScopeForKotlinEnum\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n1#2:69\n865#3,2:70\n865#3,2:72\n*S KotlinDebug\n*F\n+ 1 StaticScopeForKotlinEnum.kt\norg/jetbrains/kotlin/resolve/scopes/StaticScopeForKotlinEnum\n*L\n59#1:70,2\n62#1:72,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q extends l {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f46783f = {o0.u(new PropertyReference1Impl(q.class, "functions", "getFunctions()Ljava/util/List;", 0)), o0.u(new PropertyReference1Impl(q.class, "properties", "getProperties()Ljava/util/List;", 0))};

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f46784b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f46785c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f46786d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f46787e;

    public q(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d containingClass, boolean z5) {
        g0.p(storageManager, "storageManager");
        g0.p(containingClass, "containingClass");
        this.f46784b = containingClass;
        this.f46785c = z5;
        containingClass.h();
        ClassKind classKind = ClassKind.ENUM_CLASS;
        this.f46786d = storageManager.e(new o(this));
        this.f46787e = storageManager.e(new p(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List k(q qVar) {
        return f0.Q(kotlin.reflect.jvm.internal.impl.resolve.h.g(qVar.f46784b), kotlin.reflect.jvm.internal.impl.resolve.h.h(qVar.f46784b));
    }

    private final List<d1> o() {
        return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46786d, this, f46783f[0]);
    }

    private final List<w0> p() {
        return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46787e, this, f46783f[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List q(q qVar) {
        return qVar.f46785c ? f0.R(kotlin.reflect.jvm.internal.impl.resolve.h.f(qVar.f46784b)) : f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        List<w0> p5 = p();
        kotlin.reflect.jvm.internal.impl.utils.j jVar = new kotlin.reflect.jvm.internal.impl.utils.j();
        for (Object obj : p5) {
            if (g0.g(((w0) obj).getName(), name)) {
                jVar.add(obj);
            }
        }
        return jVar;
    }

    @Nullable
    public Void l(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public List<CallableMemberDescriptor> h(@NotNull d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        g0.p(kindFilter, "kindFilter");
        g0.p(nameFilter, "nameFilter");
        return f0.I4(o(), p());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.utils.j<d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        List<d1> o5 = o();
        kotlin.reflect.jvm.internal.impl.utils.j<d1> jVar = new kotlin.reflect.jvm.internal.impl.utils.j<>();
        for (Object obj : o5) {
            if (g0.g(((d1) obj).getName(), name)) {
                jVar.add(obj);
            }
        }
        return jVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.f g(kotlin.reflect.jvm.internal.impl.name.f fVar, u3.b bVar) {
        return (kotlin.reflect.jvm.internal.impl.descriptors.f) l(fVar, bVar);
    }
}
