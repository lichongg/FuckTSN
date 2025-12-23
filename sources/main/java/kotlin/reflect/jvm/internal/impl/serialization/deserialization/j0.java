package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.b;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMemberDeserializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemberDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/MemberDeserializer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,375:1\n1563#2:376\n1634#2,3:377\n1573#2:381\n1604#2,4:382\n1583#2,11:386\n1878#2,2:397\n1880#2:400\n1594#2:401\n1563#2:402\n1634#2,3:403\n1573#2:406\n1604#2,4:407\n1#3:380\n1#3:399\n*S KotlinDebug\n*F\n+ 1 MemberDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/MemberDeserializer\n*L\n29#1:376\n29#1:377,3\n67#1:381\n67#1:382,4\n219#1:386,11\n219#1:397,2\n219#1:400\n219#1:401\n247#1:402\n247#1:403,3\n331#1:406\n331#1:407,4\n219#1:399\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final o f46983a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final f f46984b;

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.w0 u(@NotNull ProtoBuf.Property proto, boolean z5) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar;
        o oVar;
        b.d<ProtoBuf.Visibility> dVar;
        b.d<ProtoBuf.Modality> dVar2;
        String str;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.l0 l0Var;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.l0 l0Var2;
        boolean z6;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.m0 m0Var;
        kotlin.reflect.jvm.internal.impl.types.t0 u5;
        kotlin.jvm.internal.g0.p(proto, "proto");
        int flags = proto.hasFlags() ? proto.getFlags() : t(proto.getOldFlags());
        if (z5) {
            g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0;
            List<ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
            kotlin.jvm.internal.g0.o(annotationList, "getAnnotationList(...)");
            List<ProtoBuf.Annotation> list = annotationList;
            ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
            for (ProtoBuf.Annotation annotation : list) {
                f fVar = this.f46984b;
                kotlin.jvm.internal.g0.m(annotation);
                arrayList.add(fVar.a(annotation, this.f46983a.g()));
            }
            gVar = aVar.a(arrayList);
        } else {
            gVar = null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k e6 = this.f46983a.e();
        if (gVar == null) {
            gVar = j(proto, flags, AnnotatedCallableKind.PROPERTY);
        }
        n0 n0Var = n0.f47030a;
        Modality b6 = n0Var.b(kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46210e.d(flags));
        kotlin.reflect.jvm.internal.impl.descriptors.s a6 = o0.a(n0Var, kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46209d.d(flags));
        Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46230y.d(flags);
        kotlin.jvm.internal.g0.o(d6, "get(...)");
        boolean booleanValue = d6.booleanValue();
        kotlin.reflect.jvm.internal.impl.name.f b7 = k0.b(this.f46983a.g(), proto.getName());
        CallableMemberDescriptor.Kind b8 = o0.b(n0Var, kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46221p.d(flags));
        Boolean d7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.C.d(flags);
        kotlin.jvm.internal.g0.o(d7, "get(...)");
        boolean booleanValue2 = d7.booleanValue();
        Boolean d8 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.B.d(flags);
        kotlin.jvm.internal.g0.o(d8, "get(...)");
        boolean booleanValue3 = d8.booleanValue();
        Boolean d9 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.E.d(flags);
        kotlin.jvm.internal.g0.o(d9, "get(...)");
        boolean booleanValue4 = d9.booleanValue();
        Boolean d10 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.F.d(flags);
        kotlin.jvm.internal.g0.o(d10, "get(...)");
        boolean booleanValue5 = d10.booleanValue();
        Boolean d11 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.G.d(flags);
        kotlin.jvm.internal.g0.o(d11, "get(...)");
        int i6 = flags;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0 n0Var2 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0(e6, null, gVar, b6, a6, booleanValue, b7, b8, booleanValue2, booleanValue3, booleanValue4, booleanValue5, d11.booleanValue(), proto, this.f46983a.g(), this.f46983a.j(), this.f46983a.k(), this.f46983a.d());
        o oVar2 = this.f46983a;
        List<ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        kotlin.jvm.internal.g0.o(typeParameterList, "getTypeParameterList(...)");
        o b9 = o.b(oVar2, n0Var2, typeParameterList, null, null, null, null, 60, null);
        Boolean d12 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46231z.d(i6);
        kotlin.jvm.internal.g0.o(d12, "get(...)");
        boolean booleanValue6 = d12.booleanValue();
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g o5 = (booleanValue6 && kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.h(proto)) ? o(proto, AnnotatedCallableKind.PROPERTY_GETTER) : kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b();
        kotlin.reflect.jvm.internal.impl.types.t0 u6 = b9.i().u(kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.o(proto, this.f46983a.j()));
        List<j1> m6 = b9.i().m();
        z0 l6 = l();
        ProtoBuf.Type m7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.m(proto, this.f46983a.j());
        z0 i7 = (m7 == null || (u5 = b9.i().u(m7)) == null) ? null : kotlin.reflect.jvm.internal.impl.resolve.h.i(n0Var2, u5, o5);
        List<ProtoBuf.Type> d13 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.d(proto, this.f46983a.j());
        ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(d13, 10));
        int i8 = 0;
        for (Object obj : d13) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                kotlin.collections.f0.b0();
            }
            arrayList2.add(B((ProtoBuf.Type) obj, b9, n0Var2, i8));
            i8 = i9;
        }
        n0Var2.X0(u6, m6, l6, i7, arrayList2);
        Boolean d14 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46208c.d(i6);
        kotlin.jvm.internal.g0.o(d14, "get(...)");
        boolean booleanValue7 = d14.booleanValue();
        b.d<ProtoBuf.Visibility> dVar3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46209d;
        ProtoBuf.Visibility d15 = dVar3.d(i6);
        b.d<ProtoBuf.Modality> dVar4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46210e;
        int b10 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.b(booleanValue7, d15, dVar4.d(i6), false, false, false);
        if (booleanValue6) {
            int getterFlags = proto.hasGetterFlags() ? proto.getGetterFlags() : b10;
            Boolean d16 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.K.d(getterFlags);
            kotlin.jvm.internal.g0.o(d16, "get(...)");
            boolean booleanValue8 = d16.booleanValue();
            Boolean d17 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.L.d(getterFlags);
            kotlin.jvm.internal.g0.o(d17, "get(...)");
            boolean booleanValue9 = d17.booleanValue();
            Boolean d18 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.M.d(getterFlags);
            kotlin.jvm.internal.g0.o(d18, "get(...)");
            boolean booleanValue10 = d18.booleanValue();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g j6 = j(proto, getterFlags, AnnotatedCallableKind.PROPERTY_GETTER);
            if (booleanValue8) {
                n0 n0Var3 = n0.f47030a;
                dVar = dVar3;
                oVar = b9;
                dVar2 = dVar4;
                str = "get(...)";
                l0Var = new kotlin.reflect.jvm.internal.impl.descriptors.impl.l0(n0Var2, j6, n0Var3.b(dVar4.d(getterFlags)), o0.a(n0Var3, dVar3.d(getterFlags)), !booleanValue8, booleanValue9, booleanValue10, n0Var2.h(), null, e1.f44683a);
            } else {
                oVar = b9;
                dVar = dVar3;
                dVar2 = dVar4;
                str = "get(...)";
                l0Var = kotlin.reflect.jvm.internal.impl.resolve.h.d(n0Var2, j6);
                kotlin.jvm.internal.g0.m(l0Var);
            }
            l0Var.L0(n0Var2.getReturnType());
        } else {
            oVar = b9;
            dVar = dVar3;
            dVar2 = dVar4;
            str = "get(...)";
            l0Var = null;
        }
        if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.A.d(i6).booleanValue()) {
            if (proto.hasSetterFlags()) {
                b10 = proto.getSetterFlags();
            }
            int i10 = b10;
            Boolean d19 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.K.d(i10);
            kotlin.jvm.internal.g0.o(d19, str);
            boolean booleanValue11 = d19.booleanValue();
            Boolean d20 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.L.d(i10);
            kotlin.jvm.internal.g0.o(d20, str);
            boolean booleanValue12 = d20.booleanValue();
            Boolean d21 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.M.d(i10);
            kotlin.jvm.internal.g0.o(d21, str);
            boolean booleanValue13 = d21.booleanValue();
            AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.PROPERTY_SETTER;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g j7 = j(proto, i10, annotatedCallableKind);
            if (booleanValue11) {
                n0 n0Var4 = n0.f47030a;
                l0Var2 = l0Var;
                z6 = true;
                kotlin.reflect.jvm.internal.impl.descriptors.impl.m0 m0Var2 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.m0(n0Var2, j7, n0Var4.b(dVar2.d(i10)), o0.a(n0Var4, dVar.d(i10)), !booleanValue11, booleanValue12, booleanValue13, n0Var2.h(), null, e1.f44683a);
                m0Var = m0Var2;
                m0Var.M0((q1) kotlin.collections.f0.m5(o.b(oVar, m0Var2, kotlin.collections.f0.J(), null, null, null, null, 60, null).f().C(kotlin.collections.f0.l(proto.getSetterValueParameter()), proto, annotatedCallableKind)));
            } else {
                l0Var2 = l0Var;
                z6 = true;
                kotlin.reflect.jvm.internal.impl.descriptors.impl.m0 e7 = kotlin.reflect.jvm.internal.impl.resolve.h.e(n0Var2, j7, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b());
                kotlin.jvm.internal.g0.m(e7);
                m0Var = e7;
            }
        } else {
            l0Var2 = l0Var;
            z6 = true;
            m0Var = null;
        }
        if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.D.d(i6).booleanValue()) {
            n0Var2.H0(new b0(this, proto, n0Var2));
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k e8 = this.f46983a.e();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar5 = e8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) e8 : null;
        if ((dVar5 != null ? dVar5.h() : null) == ClassKind.ANNOTATION_CLASS) {
            n0Var2.H0(new c0(this, proto, n0Var2));
        }
        n0Var2.R0(l0Var2, m0Var, new kotlin.reflect.jvm.internal.impl.descriptors.impl.r(m(proto, false), n0Var2), new kotlin.reflect.jvm.internal.impl.descriptors.impl.r(m(proto, z6), n0Var2));
        return n0Var2;
    }

    public j0(@NotNull o c6) {
        kotlin.jvm.internal.g0.p(c6, "c");
        this.f46983a = c6;
        this.f46984b = new f(c6.c().q(), c6.c().r());
    }

    private final List<q1> C(List<ProtoBuf.ValueParameter> list, kotlin.reflect.jvm.internal.impl.protobuf.n nVar, AnnotatedCallableKind annotatedCallableKind) {
        kotlin.reflect.jvm.internal.impl.descriptors.k e6 = this.f46983a.e();
        kotlin.jvm.internal.g0.n(e6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.descriptors.a) e6;
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = aVar.b();
        kotlin.jvm.internal.g0.o(b6, "getContainingDeclaration(...)");
        m0 i6 = i(b6);
        List<ProtoBuf.ValueParameter> list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list2, 10));
        int i7 = 0;
        for (Object obj : list2) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.f0.b0();
            }
            ProtoBuf.ValueParameter valueParameter = (ProtoBuf.ValueParameter) obj;
            int flags = valueParameter.hasFlags() ? valueParameter.getFlags() : 0;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b7 = (i6 == null || !kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46208c.d(flags).booleanValue()) ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b() : new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s0(this.f46983a.h(), new g0(this, i6, nVar, annotatedCallableKind, i7, valueParameter));
            kotlin.reflect.jvm.internal.impl.name.f b8 = k0.b(this.f46983a.g(), valueParameter.getName());
            kotlin.reflect.jvm.internal.impl.types.t0 u5 = this.f46983a.i().u(kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.r(valueParameter, this.f46983a.j()));
            Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.H.d(flags);
            kotlin.jvm.internal.g0.o(d6, "get(...)");
            boolean booleanValue = d6.booleanValue();
            Boolean d7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.I.d(flags);
            kotlin.jvm.internal.g0.o(d7, "get(...)");
            boolean booleanValue2 = d7.booleanValue();
            Boolean d8 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.J.d(flags);
            kotlin.jvm.internal.g0.o(d8, "get(...)");
            boolean booleanValue3 = d8.booleanValue();
            ProtoBuf.Type u6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.u(valueParameter, this.f46983a.j());
            kotlin.reflect.jvm.internal.impl.types.t0 u7 = u6 != null ? this.f46983a.i().u(u6) : null;
            e1 NO_SOURCE = e1.f44683a;
            kotlin.jvm.internal.g0.o(NO_SOURCE, "NO_SOURCE");
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar2 = aVar;
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.impl.u0(aVar2, null, i7, b7, b8, u5, booleanValue, booleanValue2, booleanValue3, u7, NO_SOURCE));
            aVar = aVar2;
            i7 = i8;
        }
        return kotlin.collections.f0.a6(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List D(j0 j0Var, m0 m0Var, kotlin.reflect.jvm.internal.impl.protobuf.n nVar, AnnotatedCallableKind annotatedCallableKind, int i6, ProtoBuf.ValueParameter valueParameter) {
        return kotlin.collections.f0.a6(j0Var.f46983a.c().d().a(m0Var, nVar, annotatedCallableKind, i6, valueParameter));
    }

    private final m0 i(kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.l0) {
            return new m0.b(((kotlin.reflect.jvm.internal.impl.descriptors.l0) kVar).d(), this.f46983a.g(), this.f46983a.j(), this.f46983a.d());
        }
        if (kVar instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n) {
            return ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n) kVar).d1();
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g j(kotlin.reflect.jvm.internal.impl.protobuf.n nVar, int i6, AnnotatedCallableKind annotatedCallableKind) {
        return !kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46208c.d(i6).booleanValue() ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b() : new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s0(this.f46983a.h(), new d0(this, nVar, annotatedCallableKind));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List k(j0 j0Var, kotlin.reflect.jvm.internal.impl.protobuf.n nVar, AnnotatedCallableKind annotatedCallableKind) {
        m0 i6 = j0Var.i(j0Var.f46983a.e());
        List a6 = i6 != null ? kotlin.collections.f0.a6(j0Var.f46983a.c().d().i(i6, nVar, annotatedCallableKind)) : null;
        return a6 == null ? kotlin.collections.f0.J() : a6;
    }

    private final z0 l() {
        kotlin.reflect.jvm.internal.impl.descriptors.k e6 = this.f46983a.e();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = e6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) e6 : null;
        if (dVar != null) {
            return dVar.V();
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g m(ProtoBuf.Property property, boolean z5) {
        return !kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46208c.d(property.getFlags()).booleanValue() ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b() : new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s0(this.f46983a.h(), new e0(this, z5, property));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List n(j0 j0Var, boolean z5, ProtoBuf.Property property) {
        m0 i6 = j0Var.i(j0Var.f46983a.e());
        List a6 = i6 != null ? z5 ? kotlin.collections.f0.a6(j0Var.f46983a.c().d().l(i6, property)) : kotlin.collections.f0.a6(j0Var.f46983a.c().d().f(i6, property)) : null;
        return a6 == null ? kotlin.collections.f0.J() : a6;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g o(kotlin.reflect.jvm.internal.impl.protobuf.n nVar, AnnotatedCallableKind annotatedCallableKind) {
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b(this.f46983a.h(), new f0(this, nVar, annotatedCallableKind));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List p(j0 j0Var, kotlin.reflect.jvm.internal.impl.protobuf.n nVar, AnnotatedCallableKind annotatedCallableKind) {
        m0 i6 = j0Var.i(j0Var.f46983a.e());
        List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> g6 = i6 != null ? j0Var.f46983a.c().d().g(i6, nVar, annotatedCallableKind) : null;
        return g6 == null ? kotlin.collections.f0.J() : g6;
    }

    private final int t(int i6) {
        return (i6 & 63) + ((i6 >> 8) << 6);
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.w0 v(j0 j0Var, ProtoBuf.Property property, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return j0Var.u(property, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.storage.j w(j0 j0Var, ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0 n0Var) {
        return j0Var.f46983a.h().g(new h0(j0Var, property, n0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.constants.g x(j0 j0Var, ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0 n0Var) {
        m0 i6 = j0Var.i(j0Var.f46983a.e());
        kotlin.jvm.internal.g0.m(i6);
        d<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> d6 = j0Var.f46983a.c().d();
        kotlin.reflect.jvm.internal.impl.types.t0 returnType = n0Var.getReturnType();
        kotlin.jvm.internal.g0.o(returnType, "getReturnType(...)");
        return d6.e(i6, property, returnType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.storage.j y(j0 j0Var, ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0 n0Var) {
        return j0Var.f46983a.h().g(new i0(j0Var, property, n0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.constants.g z(j0 j0Var, ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0 n0Var) {
        m0 i6 = j0Var.i(j0Var.f46983a.e());
        kotlin.jvm.internal.g0.m(i6);
        d<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> d6 = j0Var.f46983a.c().d();
        kotlin.reflect.jvm.internal.impl.types.t0 returnType = n0Var.getReturnType();
        kotlin.jvm.internal.g0.o(returnType, "getReturnType(...)");
        return d6.j(i6, property, returnType);
    }

    @NotNull
    public final i1 A(@NotNull ProtoBuf.TypeAlias proto) {
        kotlin.jvm.internal.g0.p(proto, "proto");
        g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0;
        List<ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
        kotlin.jvm.internal.g0.o(annotationList, "getAnnotationList(...)");
        List<ProtoBuf.Annotation> list = annotationList;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
        for (ProtoBuf.Annotation annotation : list) {
            f fVar = this.f46984b;
            kotlin.jvm.internal.g0.m(annotation);
            arrayList.add(fVar.a(annotation, this.f46983a.g()));
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.p0 p0Var = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.p0(this.f46983a.h(), this.f46983a.e(), aVar.a(arrayList), k0.b(this.f46983a.g(), proto.getName()), o0.a(n0.f47030a, kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46209d.d(proto.getFlags())), proto, this.f46983a.g(), this.f46983a.j(), this.f46983a.k(), this.f46983a.d());
        o oVar = this.f46983a;
        List<ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        kotlin.jvm.internal.g0.o(typeParameterList, "getTypeParameterList(...)");
        o b6 = o.b(oVar, p0Var, typeParameterList, null, null, null, null, 60, null);
        p0Var.R0(b6.i().m(), b6.i().o(kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.s(proto, this.f46983a.j()), false), b6.i().o(kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.e(proto, this.f46983a.j()), false));
        return p0Var;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.c r(@NotNull ProtoBuf.Constructor proto, boolean z5) {
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.reflect.jvm.internal.impl.descriptors.k e6 = this.f46983a.e();
        kotlin.jvm.internal.g0.n(e6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) e6;
        int flags = proto.getFlags();
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d dVar2 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d(dVar, null, j(proto, flags, annotatedCallableKind), z5, CallableMemberDescriptor.Kind.DECLARATION, proto, this.f46983a.g(), this.f46983a.j(), this.f46983a.k(), this.f46983a.d(), null, 1024, null);
        j0 f6 = o.b(this.f46983a, dVar2, kotlin.collections.f0.J(), null, null, null, null, 60, null).f();
        List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
        kotlin.jvm.internal.g0.o(valueParameterList, "getValueParameterList(...)");
        dVar2.l1(f6.C(valueParameterList, proto, annotatedCallableKind), o0.a(n0.f47030a, kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46209d.d(proto.getFlags())));
        dVar2.b1(dVar.s());
        dVar2.R0(dVar.q0());
        dVar2.T0(!kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46220o.d(proto.getFlags()).booleanValue());
        return dVar2;
    }

    @NotNull
    public final d1 s(@NotNull ProtoBuf.Function proto) {
        kotlin.reflect.jvm.internal.impl.types.t0 u5;
        kotlin.jvm.internal.g0.p(proto, "proto");
        int flags = proto.hasFlags() ? proto.getFlags() : t(proto.getOldFlags());
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g j6 = j(proto, flags, annotatedCallableKind);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g o5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.g(proto) ? o(proto, annotatedCallableKind) : kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.o0 o0Var = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.o0(this.f46983a.e(), null, j6, k0.b(this.f46983a.g(), proto.getName()), o0.b(n0.f47030a, kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46221p.d(flags)), proto, this.f46983a.g(), this.f46983a.j(), kotlin.jvm.internal.g0.g(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.o(this.f46983a.e()).b(k0.b(this.f46983a.g(), proto.getName())), p0.f47052a) ? kotlin.reflect.jvm.internal.impl.metadata.deserialization.j.f46256b.b() : this.f46983a.k(), this.f46983a.d(), null, 1024, null);
        o oVar = this.f46983a;
        List<ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        kotlin.jvm.internal.g0.o(typeParameterList, "getTypeParameterList(...)");
        o b6 = o.b(oVar, o0Var, typeParameterList, null, null, null, null, 60, null);
        ProtoBuf.Type l6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.l(proto, this.f46983a.j());
        z0 i6 = (l6 == null || (u5 = b6.i().u(l6)) == null) ? null : kotlin.reflect.jvm.internal.impl.resolve.h.i(o0Var, u5, o5);
        z0 l7 = l();
        List<ProtoBuf.Type> c6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.c(proto, this.f46983a.j());
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        for (Object obj : c6) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.f0.b0();
            }
            z0 B = B((ProtoBuf.Type) obj, b6, o0Var, i7);
            if (B != null) {
                arrayList.add(B);
            }
            i7 = i8;
        }
        List<j1> m6 = b6.i().m();
        j0 f6 = b6.f();
        List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
        kotlin.jvm.internal.g0.o(valueParameterList, "getValueParameterList(...)");
        List<q1> C = f6.C(valueParameterList, proto, AnnotatedCallableKind.FUNCTION);
        kotlin.reflect.jvm.internal.impl.types.t0 u6 = b6.i().u(kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.n(proto, this.f46983a.j()));
        n0 n0Var = n0.f47030a;
        q(o0Var, i6, l7, arrayList, m6, C, u6, n0Var.b(kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46210e.d(flags)), o0.a(n0Var, kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46209d.d(flags)), kotlin.collections.i1.z());
        Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46222q.d(flags);
        kotlin.jvm.internal.g0.o(d6, "get(...)");
        o0Var.a1(d6.booleanValue());
        Boolean d7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46223r.d(flags);
        kotlin.jvm.internal.g0.o(d7, "get(...)");
        o0Var.X0(d7.booleanValue());
        Boolean d8 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46226u.d(flags);
        kotlin.jvm.internal.g0.o(d8, "get(...)");
        o0Var.S0(d8.booleanValue());
        Boolean d9 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46224s.d(flags);
        kotlin.jvm.internal.g0.o(d9, "get(...)");
        o0Var.Z0(d9.booleanValue());
        Boolean d10 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46225t.d(flags);
        kotlin.jvm.internal.g0.o(d10, "get(...)");
        o0Var.d1(d10.booleanValue());
        Boolean d11 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46227v.d(flags);
        kotlin.jvm.internal.g0.o(d11, "get(...)");
        o0Var.c1(d11.booleanValue());
        Boolean d12 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46228w.d(flags);
        kotlin.jvm.internal.g0.o(d12, "get(...)");
        o0Var.R0(d12.booleanValue());
        o0Var.T0(!kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46229x.d(flags).booleanValue());
        Pair<a.InterfaceC0876a<?>, Object> a6 = this.f46983a.c().h().a(proto, o0Var, this.f46983a.j(), b6.i());
        if (a6 != null) {
            o0Var.P0(a6.getFirst(), a6.getSecond());
        }
        return o0Var;
    }

    private final z0 B(ProtoBuf.Type type, o oVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, int i6) {
        return kotlin.reflect.jvm.internal.impl.resolve.h.b(aVar, oVar.i().u(type), null, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b(), i6);
    }

    private final void q(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.o0 o0Var, z0 z0Var, z0 z0Var2, List<? extends z0> list, List<? extends j1> list2, List<? extends q1> list3, kotlin.reflect.jvm.internal.impl.types.t0 t0Var, Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.s sVar, Map<? extends a.InterfaceC0876a<?>, ?> map) {
        o0Var.j1(z0Var, z0Var2, list, list2, list3, t0Var, modality, sVar, map);
    }
}
