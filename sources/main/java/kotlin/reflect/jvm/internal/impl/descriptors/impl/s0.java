package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.h2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTypeAliasConstructorDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAliasConstructorDescriptor.kt\norg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptorImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,238:1\n1#2:239\n1563#3:240\n1634#3,3:241\n*S KotlinDebug\n*F\n+ 1 TypeAliasConstructorDescriptor.kt\norg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptorImpl\n*L\n87#1:240\n87#1:241,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s0 extends s implements q0 {

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.n E;

    @NotNull
    private final i1 F;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.j G;

    @NotNull
    private kotlin.reflect.jvm.internal.impl.descriptors.c H;
    static final /* synthetic */ kotlin.reflect.n<Object>[] J = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(s0.class, "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;", 0))};

    @NotNull
    public static final a I = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nTypeAliasConstructorDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAliasConstructorDescriptor.kt\norg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptorImpl$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,238:1\n1573#2:239\n1604#2,4:240\n*S KotlinDebug\n*F\n+ 1 TypeAliasConstructorDescriptor.kt\norg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptorImpl$Companion\n*L\n209#1:239\n209#1:240,4\n*E\n"})
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @Nullable
        public final q0 b(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull i1 typeAliasDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.c constructor) {
            kotlin.reflect.jvm.internal.impl.descriptors.c c6;
            List<z0> J;
            kotlin.jvm.internal.g0.p(storageManager, "storageManager");
            kotlin.jvm.internal.g0.p(typeAliasDescriptor, "typeAliasDescriptor");
            kotlin.jvm.internal.g0.p(constructor, "constructor");
            h2 c7 = c(typeAliasDescriptor);
            if (c7 == null || (c6 = constructor.c(c7)) == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = constructor.getAnnotations();
            CallableMemberDescriptor.Kind h6 = constructor.h();
            kotlin.jvm.internal.g0.o(h6, "getKind(...)");
            e1 source = typeAliasDescriptor.getSource();
            kotlin.jvm.internal.g0.o(source, "getSource(...)");
            s0 s0Var = new s0(storageManager, typeAliasDescriptor, c6, null, annotations, h6, source, null);
            List<q1> J0 = s.J0(s0Var, constructor.g(), c7);
            if (J0 == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.types.e1 c8 = kotlin.reflect.jvm.internal.impl.types.n0.c(c6.getReturnType().L0());
            kotlin.reflect.jvm.internal.impl.types.e1 s5 = typeAliasDescriptor.s();
            kotlin.jvm.internal.g0.o(s5, "getDefaultType(...)");
            kotlin.reflect.jvm.internal.impl.types.e1 j6 = kotlin.reflect.jvm.internal.impl.types.i1.j(c8, s5);
            z0 c02 = constructor.c0();
            z0 i6 = c02 != null ? kotlin.reflect.jvm.internal.impl.resolve.h.i(s0Var, c7.n(c02.getType(), Variance.INVARIANT), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b()) : null;
            kotlin.reflect.jvm.internal.impl.descriptors.d m6 = typeAliasDescriptor.m();
            if (m6 != null) {
                List<z0> A0 = constructor.A0();
                kotlin.jvm.internal.g0.o(A0, "getContextReceiverParameters(...)");
                List<z0> list = A0;
                J = new ArrayList<>(kotlin.collections.f0.d0(list, 10));
                int i7 = 0;
                for (Object obj : list) {
                    int i8 = i7 + 1;
                    if (i7 < 0) {
                        kotlin.collections.f0.b0();
                    }
                    z0 z0Var = (z0) obj;
                    kotlin.reflect.jvm.internal.impl.types.t0 n6 = c7.n(z0Var.getType(), Variance.INVARIANT);
                    kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h value = z0Var.getValue();
                    kotlin.jvm.internal.g0.n(value, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.receivers.ImplicitContextReceiver");
                    J.add(kotlin.reflect.jvm.internal.impl.resolve.h.c(m6, n6, ((kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.f) value).a(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b(), i7));
                    i7 = i8;
                }
            } else {
                J = kotlin.collections.f0.J();
            }
            s0Var.M0(i6, null, J, typeAliasDescriptor.t(), J0, j6, Modality.FINAL, typeAliasDescriptor.getVisibility());
            return s0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final h2 c(i1 i1Var) {
            if (i1Var.m() == null) {
                return null;
            }
            return h2.f(i1Var.Z());
        }
    }

    public /* synthetic */ s0(kotlin.reflect.jvm.internal.impl.storage.n nVar, i1 i1Var, kotlin.reflect.jvm.internal.impl.descriptors.c cVar, q0 q0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, CallableMemberDescriptor.Kind kind, e1 e1Var, kotlin.jvm.internal.v vVar) {
        this(nVar, i1Var, cVar, q0Var, gVar, kind, e1Var);
    }

    private s0(kotlin.reflect.jvm.internal.impl.storage.n nVar, i1 i1Var, kotlin.reflect.jvm.internal.impl.descriptors.c cVar, q0 q0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, CallableMemberDescriptor.Kind kind, e1 e1Var) {
        super(i1Var, q0Var, gVar, kotlin.reflect.jvm.internal.impl.name.h.f46364j, kind, e1Var);
        this.E = nVar;
        this.F = i1Var;
        Q0(k1().i0());
        this.G = nVar.g(new r0(this, cVar));
        this.H = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final s0 m1(s0 s0Var, kotlin.reflect.jvm.internal.impl.descriptors.c cVar) {
        kotlin.reflect.jvm.internal.impl.storage.n nVar = s0Var.E;
        i1 k12 = s0Var.k1();
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = cVar.getAnnotations();
        CallableMemberDescriptor.Kind h6 = cVar.h();
        kotlin.jvm.internal.g0.o(h6, "getKind(...)");
        e1 source = s0Var.k1().getSource();
        kotlin.jvm.internal.g0.o(source, "getSource(...)");
        s0 s0Var2 = new s0(nVar, k12, cVar, s0Var, annotations, h6, source);
        h2 c6 = I.c(s0Var.k1());
        if (c6 == null) {
            return null;
        }
        z0 c02 = cVar.c0();
        z0 c7 = c02 != null ? c02.c(c6) : null;
        List<z0> A0 = cVar.A0();
        kotlin.jvm.internal.g0.o(A0, "getContextReceiverParameters(...)");
        List<z0> list = A0;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((z0) it.next()).c(c6));
        }
        s0Var2.M0(null, c7, arrayList, s0Var.k1().t(), s0Var.g(), s0Var.getReturnType(), Modality.FINAL, s0Var.k1().getVisibility());
        return s0Var2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.q0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.c F() {
        return this.H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    /* renamed from: g1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public q0 e0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k newOwner, @NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s visibility, @NotNull CallableMemberDescriptor.Kind kind, boolean z5) {
        kotlin.jvm.internal.g0.p(newOwner, "newOwner");
        kotlin.jvm.internal.g0.p(modality, "modality");
        kotlin.jvm.internal.g0.p(visibility, "visibility");
        kotlin.jvm.internal.g0.p(kind, "kind");
        kotlin.reflect.jvm.internal.impl.descriptors.y build = n().r(newOwner).q(modality).p(visibility).s(kind).j(z5).build();
        kotlin.jvm.internal.g0.n(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (q0) build;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s
    @NotNull
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public s0 G0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k newOwner, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.y yVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, @NotNull e1 source) {
        kotlin.jvm.internal.g0.p(newOwner, "newOwner");
        kotlin.jvm.internal.g0.p(kind, "kind");
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        kotlin.jvm.internal.g0.p(source, "source");
        CallableMemberDescriptor.Kind kind2 = CallableMemberDescriptor.Kind.DECLARATION;
        if (kind != kind2) {
            CallableMemberDescriptor.Kind kind3 = CallableMemberDescriptor.Kind.SYNTHESIZED;
        }
        return new s0(this.E, k1(), F(), this, annotations, kind2, source);
    }

    @NotNull
    public i1 k1() {
        return this.F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.g1
    @Nullable
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public q0 c(@NotNull h2 substitutor) {
        kotlin.jvm.internal.g0.p(substitutor, "substitutor");
        kotlin.reflect.jvm.internal.impl.descriptors.y c6 = super.c(substitutor);
        kotlin.jvm.internal.g0.n(c6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        s0 s0Var = (s0) c6;
        h2 f6 = h2.f(s0Var.getReturnType());
        kotlin.jvm.internal.g0.o(f6, "create(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.c c7 = F().a().c(f6);
        if (c7 == null) {
            return null;
        }
        s0Var.H = c7;
        return s0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d J() {
        kotlin.reflect.jvm.internal.impl.descriptors.d J2 = F().J();
        kotlin.jvm.internal.g0.o(J2, "getConstructedClass(...)");
        return J2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.t0 getReturnType() {
        kotlin.reflect.jvm.internal.impl.types.t0 returnType = super.getReturnType();
        kotlin.jvm.internal.g0.m(returnType);
        return returnType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.n, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public i1 b() {
        return k1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.impl.n
    @NotNull
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public q0 a() {
        kotlin.reflect.jvm.internal.impl.descriptors.y a6 = super.a();
        kotlin.jvm.internal.g0.n(a6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (q0) a6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j
    public boolean m0() {
        return F().m0();
    }
}
