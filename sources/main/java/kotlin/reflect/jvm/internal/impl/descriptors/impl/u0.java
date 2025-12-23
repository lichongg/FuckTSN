package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.s1;
import kotlin.reflect.jvm.internal.impl.types.h2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nValueParameterDescriptorImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueParameterDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/ValueParameterDescriptorImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n1563#2:135\n1634#2,3:136\n*S KotlinDebug\n*F\n+ 1 ValueParameterDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/ValueParameterDescriptorImpl\n*L\n129#1:135\n129#1:136,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class u0 extends w0 implements q1 {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public static final a f44894m = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private final int f44895g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f44896h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f44897i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f44898j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private final kotlin.reflect.jvm.internal.impl.types.t0 f44899k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final q1 f44900l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @JvmStatic
        @NotNull
        public final u0 a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a containingDeclaration, @Nullable q1 q1Var, int i6, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.types.t0 outType, boolean z5, boolean z6, boolean z7, @Nullable kotlin.reflect.jvm.internal.impl.types.t0 t0Var, @NotNull e1 source, @Nullable Function0<? extends List<? extends s1>> function0) {
            kotlin.jvm.internal.g0.p(containingDeclaration, "containingDeclaration");
            kotlin.jvm.internal.g0.p(annotations, "annotations");
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(outType, "outType");
            kotlin.jvm.internal.g0.p(source, "source");
            return function0 == null ? new u0(containingDeclaration, q1Var, i6, annotations, name, outType, z5, z6, z7, t0Var, source) : new b(containingDeclaration, q1Var, i6, annotations, name, outType, z5, z6, z7, t0Var, source, function0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends u0 {

        /* renamed from: n, reason: collision with root package name */
        @NotNull
        private final kotlin.s f44901n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a containingDeclaration, @Nullable q1 q1Var, int i6, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.types.t0 outType, boolean z5, boolean z6, boolean z7, @Nullable kotlin.reflect.jvm.internal.impl.types.t0 t0Var, @NotNull e1 source, @NotNull Function0<? extends List<? extends s1>> destructuringVariables) {
            super(containingDeclaration, q1Var, i6, annotations, name, outType, z5, z6, z7, t0Var, source);
            kotlin.jvm.internal.g0.p(containingDeclaration, "containingDeclaration");
            kotlin.jvm.internal.g0.p(annotations, "annotations");
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(outType, "outType");
            kotlin.jvm.internal.g0.p(source, "source");
            kotlin.jvm.internal.g0.p(destructuringVariables, "destructuringVariables");
            this.f44901n = kotlin.t.c(destructuringVariables);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.u0, kotlin.reflect.jvm.internal.impl.descriptors.q1
        @NotNull
        public q1 I(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a newOwner, @NotNull kotlin.reflect.jvm.internal.impl.name.f newName, int i6) {
            kotlin.jvm.internal.g0.p(newOwner, "newOwner");
            kotlin.jvm.internal.g0.p(newName, "newName");
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = getAnnotations();
            kotlin.jvm.internal.g0.o(annotations, "<get-annotations>(...)");
            kotlin.reflect.jvm.internal.impl.types.t0 type = getType();
            kotlin.jvm.internal.g0.o(type, "getType(...)");
            boolean Q = Q();
            boolean w02 = w0();
            boolean u02 = u0();
            kotlin.reflect.jvm.internal.impl.types.t0 z02 = z0();
            e1 NO_SOURCE = e1.f44683a;
            kotlin.jvm.internal.g0.o(NO_SOURCE, "NO_SOURCE");
            return new b(newOwner, null, i6, annotations, newName, type, Q, w02, u02, z02, NO_SOURCE, new v0(this));
        }

        @NotNull
        public final List<s1> L0() {
            return (List) this.f44901n.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List K0(b bVar) {
            return bVar.L0();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s1
    public boolean C() {
        return false;
    }

    @Nullable
    public Void H0() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a containingDeclaration, @Nullable q1 q1Var, int i6, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.types.t0 outType, boolean z5, boolean z6, boolean z7, @Nullable kotlin.reflect.jvm.internal.impl.types.t0 t0Var, @NotNull e1 source) {
        super(containingDeclaration, annotations, name, outType, source);
        kotlin.jvm.internal.g0.p(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(outType, "outType");
        kotlin.jvm.internal.g0.p(source, "source");
        this.f44895g = i6;
        this.f44896h = z5;
        this.f44897i = z6;
        this.f44898j = z7;
        this.f44899k = t0Var;
        this.f44900l = q1Var == null ? this : q1Var;
    }

    @JvmStatic
    @NotNull
    public static final u0 G0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @Nullable q1 q1Var, int i6, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var, boolean z5, boolean z6, boolean z7, @Nullable kotlin.reflect.jvm.internal.impl.types.t0 t0Var2, @NotNull e1 e1Var, @Nullable Function0<? extends List<? extends s1>> function0) {
        return f44894m.a(aVar, q1Var, i6, gVar, fVar, t0Var, z5, z6, z7, t0Var2, e1Var, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q1
    @NotNull
    public q1 I(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a newOwner, @NotNull kotlin.reflect.jvm.internal.impl.name.f newName, int i6) {
        kotlin.jvm.internal.g0.p(newOwner, "newOwner");
        kotlin.jvm.internal.g0.p(newName, "newName");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = getAnnotations();
        kotlin.jvm.internal.g0.o(annotations, "<get-annotations>(...)");
        kotlin.reflect.jvm.internal.impl.types.t0 type = getType();
        kotlin.jvm.internal.g0.o(type, "getType(...)");
        boolean Q = Q();
        boolean w02 = w0();
        boolean u02 = u0();
        kotlin.reflect.jvm.internal.impl.types.t0 z02 = z0();
        e1 NO_SOURCE = e1.f44683a;
        kotlin.jvm.internal.g0.o(NO_SOURCE, "NO_SOURCE");
        return new u0(newOwner, null, i6, annotations, newName, type, Q, w02, u02, z02, NO_SOURCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.g1
    @NotNull
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public q1 c(@NotNull h2 substitutor) {
        kotlin.jvm.internal.g0.p(substitutor, "substitutor");
        if (substitutor.k()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q1
    public boolean Q() {
        if (!this.f44896h) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.a b6 = b();
        kotlin.jvm.internal.g0.n(b6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
        return ((CallableMemberDescriptor) b6).h().isReal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R W(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> visitor, D d6) {
        kotlin.jvm.internal.g0.p(visitor, "visitor");
        return visitor.e(this, d6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.n, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.a b() {
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = super.b();
        kotlin.jvm.internal.g0.n(b6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (kotlin.reflect.jvm.internal.impl.descriptors.a) b6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q1
    public int getIndex() {
        return this.f44895g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s LOCAL = kotlin.reflect.jvm.internal.impl.descriptors.r.f44949f;
        kotlin.jvm.internal.g0.o(LOCAL, "LOCAL");
        return LOCAL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q1
    public boolean u0() {
        return this.f44898j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q1
    public boolean w0() {
        return this.f44897i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q1
    @Nullable
    public kotlin.reflect.jvm.internal.impl.types.t0 z0() {
        return this.f44899k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s1
    public boolean B0() {
        return q1.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.impl.n
    @NotNull
    public q1 a() {
        q1 q1Var = this.f44900l;
        return q1Var == this ? this : q1Var.a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public Collection<q1> e() {
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> e6 = b().e();
        kotlin.jvm.internal.g0.o(e6, "getOverriddenDescriptors(...)");
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> collection = e6;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.a) it.next()).g().get(getIndex()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s1
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.resolve.constants.g t0() {
        return (kotlin.reflect.jvm.internal.impl.resolve.constants.g) H0();
    }
}
