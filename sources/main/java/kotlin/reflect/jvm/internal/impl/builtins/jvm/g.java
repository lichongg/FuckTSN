package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJvmBuiltInClassDescriptorFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmBuiltInClassDescriptorFactory.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInClassDescriptorFactory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,57:1\n808#2,11:58\n*S KotlinDebug\n*F\n+ 1 JvmBuiltInClassDescriptorFactory.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInClassDescriptorFactory\n*L\n23#1:58,11\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g implements r3.b {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.f f44490g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.b f44491h;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final f0 f44492a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<f0, kotlin.reflect.jvm.internal.impl.descriptors.k> f44493b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f44494c;

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f44488e = {o0.u(new PropertyReference1Impl(g.class, "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;", 0))};

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f44487d = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f44489f = kotlin.reflect.jvm.internal.impl.builtins.o.B;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b a() {
            return g.f44491h;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull f0 moduleDescriptor, @NotNull Function1<? super f0, ? extends kotlin.reflect.jvm.internal.impl.descriptors.k> computeContainingDeclaration) {
        g0.p(storageManager, "storageManager");
        g0.p(moduleDescriptor, "moduleDescriptor");
        g0.p(computeContainingDeclaration, "computeContainingDeclaration");
        this.f44492a = moduleDescriptor;
        this.f44493b = computeContainingDeclaration;
        this.f44494c = storageManager.e(new e(this, storageManager));
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.d dVar = o.a.f44589d;
        f44490g = dVar.j();
        f44491h = kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(dVar.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.builtins.c d(f0 module) {
        g0.p(module, "module");
        List<l0> L = module.M(f44489f).L();
        ArrayList arrayList = new ArrayList();
        for (Object obj : L) {
            if (obj instanceof kotlin.reflect.jvm.internal.impl.builtins.c) {
                arrayList.add(obj);
            }
        }
        return (kotlin.reflect.jvm.internal.impl.builtins.c) kotlin.collections.f0.G2(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.impl.k h(g gVar, kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.k kVar = new kotlin.reflect.jvm.internal.impl.descriptors.impl.k(gVar.f44493b.invoke(gVar.f44492a), f44490g, Modality.ABSTRACT, ClassKind.INTERFACE, kotlin.collections.f0.l(gVar.f44492a.p().i()), e1.f44683a, false, nVar);
        kVar.F0(new kotlin.reflect.jvm.internal.impl.builtins.jvm.a(nVar, kVar), u1.k(), null);
        return kVar;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.impl.k i() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.impl.k) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f44494c, this, f44488e[0]);
    }

    @Override // r3.b
    public boolean a(@NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName, @NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        g0.p(packageFqName, "packageFqName");
        g0.p(name, "name");
        return g0.g(name, f44490g) && g0.g(packageFqName, f44489f);
    }

    @Override // r3.b
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d b(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        g0.p(classId, "classId");
        if (g0.g(classId, f44491h)) {
            return i();
        }
        return null;
    }

    @Override // r3.b
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> c(@NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName) {
        g0.p(packageFqName, "packageFqName");
        return g0.g(packageFqName, f44489f) ? u1.f(i()) : u1.k();
    }

    public /* synthetic */ g(kotlin.reflect.jvm.internal.impl.storage.n nVar, f0 f0Var, Function1 function1, int i6, kotlin.jvm.internal.v vVar) {
        this(nVar, f0Var, (i6 & 4) != 0 ? f.f44486a : function1);
    }
}
