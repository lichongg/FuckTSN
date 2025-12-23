package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.o1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.i;
import kotlin.reflect.jvm.internal.impl.types.checker.c0;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.checker.h;
import kotlin.reflect.jvm.internal.impl.types.checker.t;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.utils.b;
import kotlin.sequences.m;
import kotlin.sequences.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDescriptorUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DescriptorUtils.kt\norg/jetbrains/kotlin/resolve/descriptorUtil/DescriptorUtilsKt\n+ 2 ClassKind.kt\norg/jetbrains/kotlin/descriptors/ClassKindKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,466:1\n34#2:467\n827#3:468\n855#3,2:469\n1617#3,9:471\n1869#3:480\n1870#3:482\n1626#3:483\n827#3:484\n855#3,2:485\n827#3:489\n855#3,2:490\n360#3,7:493\n1761#3,3:500\n2746#3,3:503\n1563#3:506\n1634#3,3:507\n1#4:481\n1#4:492\n1310#5,2:487\n*S KotlinDebug\n*F\n+ 1 DescriptorUtils.kt\norg/jetbrains/kotlin/resolve/descriptorUtil/DescriptorUtilsKt\n*L\n148#1:467\n167#1:468\n167#1:469,2\n168#1:471,9\n168#1:480\n168#1:482\n168#1:483\n175#1:484\n175#1:485,2\n233#1:489\n233#1:490,2\n303#1:493,7\n449#1:500,3\n455#1:503,3\n208#1:506\n208#1:507,3\n168#1:481\n226#1:487,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final f f46698a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class a extends FunctionReferenceImpl implements Function1<q1, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f46699a = new a();

        a() {
            super(1, q1.class, "declaresDefaultValue", "declaresDefaultValue()Z", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(q1 p02) {
            g0.p(p02, "p0");
            return Boolean.valueOf(p02.Q());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends b.AbstractC0925b<CallableMemberDescriptor, CallableMemberDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<CallableMemberDescriptor> f46700a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<CallableMemberDescriptor, Boolean> f46701b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Ref.ObjectRef<CallableMemberDescriptor> objectRef, Function1<? super CallableMemberDescriptor, Boolean> function1) {
            this.f46700a = objectRef;
            this.f46701b = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.utils.b.AbstractC0925b, kotlin.reflect.jvm.internal.impl.utils.b.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(CallableMemberDescriptor current) {
            g0.p(current, "current");
            if (this.f46700a.element == null && this.f46701b.invoke(current).booleanValue()) {
                this.f46700a.element = current;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.AbstractC0925b, kotlin.reflect.jvm.internal.impl.utils.b.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(CallableMemberDescriptor current) {
            g0.p(current, "current");
            return this.f46700a.element == null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.e
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public CallableMemberDescriptor a() {
            return this.f46700a.element;
        }
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.name.b n(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.f fVar) {
        k b6;
        kotlin.reflect.jvm.internal.impl.name.b n6;
        if (fVar != null && (b6 = fVar.b()) != null) {
            if (b6 instanceof l0) {
                kotlin.reflect.jvm.internal.impl.name.c d6 = ((l0) b6).d();
                f name = fVar.getName();
                g0.o(name, "getName(...)");
                return new kotlin.reflect.jvm.internal.impl.name.b(d6, name);
            }
            if ((b6 instanceof g) && (n6 = n((kotlin.reflect.jvm.internal.impl.descriptors.f) b6)) != null) {
                f name2 = fVar.getName();
                g0.o(name2, "getName(...)");
                return n6.d(name2);
            }
        }
        return null;
    }

    @Nullable
    public static final z<e1> q(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        o1<e1> g02 = dVar != null ? dVar.g0() : null;
        if (g02 instanceof z) {
            return (z) g02;
        }
        return null;
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.descriptors.g0<e1> t(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        o1<e1> g02 = dVar != null ? dVar.g0() : null;
        if (g02 instanceof kotlin.reflect.jvm.internal.impl.descriptors.g0) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.g0) g02;
        }
        return null;
    }

    static {
        f h6 = f.h("value");
        g0.o(h6, "identifier(...)");
        f46698a = h6;
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.descriptors.d B(@NotNull f0 f0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.c topLevelClassFqName, @NotNull u3.b location) {
        g0.p(f0Var, "<this>");
        g0.p(topLevelClassFqName, "topLevelClassFqName");
        g0.p(location, "location");
        topLevelClassFqName.c();
        kotlin.reflect.jvm.internal.impl.descriptors.f g6 = f0Var.M(topLevelClassFqName.d()).r().g(topLevelClassFqName.f(), location);
        if (g6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.d) g6;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k a(k it) {
        g0.p(it, "it");
        return it.b();
    }

    public static final boolean f(@NotNull q1 q1Var) {
        g0.p(q1Var, "<this>");
        Boolean e6 = kotlin.reflect.jvm.internal.impl.utils.b.e(kotlin.collections.f0.l(q1Var), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f46694a, a.f46699a);
        g0.o(e6, "ifAny(...)");
        return e6.booleanValue();
    }

    @Nullable
    public static final CallableMemberDescriptor h(@NotNull CallableMemberDescriptor callableMemberDescriptor, boolean z5, @NotNull Function1<? super CallableMemberDescriptor, Boolean> predicate) {
        g0.p(callableMemberDescriptor, "<this>");
        g0.p(predicate, "predicate");
        return (CallableMemberDescriptor) kotlin.reflect.jvm.internal.impl.utils.b.b(kotlin.collections.f0.l(callableMemberDescriptor), new c(z5), new b(new Ref.ObjectRef(), predicate));
    }

    public static /* synthetic */ CallableMemberDescriptor i(CallableMemberDescriptor callableMemberDescriptor, boolean z5, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        return h(callableMemberDescriptor, z5, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable j(boolean z5, CallableMemberDescriptor callableMemberDescriptor) {
        Collection<? extends CallableMemberDescriptor> e6;
        if (z5) {
            callableMemberDescriptor = callableMemberDescriptor != null ? callableMemberDescriptor.a() : null;
        }
        return (callableMemberDescriptor == null || (e6 = callableMemberDescriptor.e()) == null) ? kotlin.collections.f0.J() : e6;
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.name.c k(@NotNull k kVar) {
        g0.p(kVar, "<this>");
        kotlin.reflect.jvm.internal.impl.name.d p5 = p(kVar);
        if (!p5.f()) {
            p5 = null;
        }
        if (p5 != null) {
            return p5.m();
        }
        return null;
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.descriptors.d l(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        g0.p(cVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = cVar.getType().I0().c();
        if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.d) c6;
        }
        return null;
    }

    @NotNull
    public static final j m(@NotNull k kVar) {
        g0.p(kVar, "<this>");
        return s(kVar).p();
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c o(@NotNull k kVar) {
        g0.p(kVar, "<this>");
        kotlin.reflect.jvm.internal.impl.name.c n6 = i.n(kVar);
        g0.o(n6, "getFqNameSafe(...)");
        return n6;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.d p(@NotNull k kVar) {
        g0.p(kVar, "<this>");
        kotlin.reflect.jvm.internal.impl.name.d m6 = i.m(kVar);
        g0.o(m6, "getFqName(...)");
        return m6;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.types.checker.g r(@NotNull f0 f0Var) {
        g0.p(f0Var, "<this>");
        t tVar = (t) f0Var.U(h.a());
        c0 c0Var = tVar != null ? (c0) tVar.a() : null;
        return c0Var instanceof c0.a ? ((c0.a) c0Var).b() : g.a.f47170a;
    }

    @NotNull
    public static final f0 s(@NotNull k kVar) {
        g0.p(kVar, "<this>");
        f0 g6 = i.g(kVar);
        g0.o(g6, "getContainingModule(...)");
        return g6;
    }

    @NotNull
    public static final m<k> u(@NotNull k kVar) {
        g0.p(kVar, "<this>");
        return p.J0(v(kVar), 1);
    }

    @NotNull
    public static final m<k> v(@NotNull k kVar) {
        g0.p(kVar, "<this>");
        return p.t(kVar, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.b.f46695a);
    }

    @NotNull
    public static final CallableMemberDescriptor w(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        g0.p(callableMemberDescriptor, "<this>");
        if (!(callableMemberDescriptor instanceof v0)) {
            return callableMemberDescriptor;
        }
        w0 h02 = ((v0) callableMemberDescriptor).h0();
        g0.o(h02, "getCorrespondingProperty(...)");
        return h02;
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.descriptors.d x(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        g0.p(dVar, "<this>");
        for (t0 t0Var : dVar.s().I0().i()) {
            if (!j.c0(t0Var)) {
                kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
                if (i.w(c6)) {
                    g0.n(c6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (kotlin.reflect.jvm.internal.impl.descriptors.d) c6;
                }
            }
        }
        return null;
    }

    public static final boolean y(@NotNull f0 f0Var) {
        c0 c0Var;
        g0.p(f0Var, "<this>");
        t tVar = (t) f0Var.U(h.a());
        return (tVar == null || (c0Var = (c0) tVar.a()) == null || !c0Var.a()) ? false : true;
    }

    @NotNull
    public static final m<CallableMemberDescriptor> z(@NotNull CallableMemberDescriptor callableMemberDescriptor, boolean z5) {
        g0.p(callableMemberDescriptor, "<this>");
        if (z5) {
            callableMemberDescriptor = callableMemberDescriptor.a();
        }
        m C = p.C(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> e6 = callableMemberDescriptor.e();
        g0.o(e6, "getOverriddenDescriptors(...)");
        return p.T2(C, p.k1(kotlin.collections.f0.E1(e6), new d(z5)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m A(boolean z5, CallableMemberDescriptor callableMemberDescriptor) {
        g0.m(callableMemberDescriptor);
        return z(callableMemberDescriptor, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable g(q1 q1Var) {
        Collection<q1> e6 = q1Var.e();
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(e6, 10));
        Iterator<T> it = e6.iterator();
        while (it.hasNext()) {
            arrayList.add(((q1) it.next()).a());
        }
        return arrayList;
    }
}
