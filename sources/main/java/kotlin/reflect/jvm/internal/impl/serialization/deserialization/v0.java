package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.i1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.e2;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.t1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.reflect.jvm.internal.impl.types.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTypeDeserializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/TypeDeserializer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,300:1\n1563#2:301\n1634#2,3:302\n1573#2:305\n1604#2,4:306\n1563#2:311\n1634#2,3:312\n1#3:310\n*S KotlinDebug\n*F\n+ 1 TypeDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/TypeDeserializer\n*L\n76#1:301\n76#1:302,3\n105#1:305\n105#1:306,4\n246#1:311\n246#1:312,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final o f47071a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final v0 f47072b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f47073c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final String f47074d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final Function1<Integer, kotlin.reflect.jvm.internal.impl.descriptors.f> f47075e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final Function1<Integer, kotlin.reflect.jvm.internal.impl.descriptors.f> f47076f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final Map<Integer, j1> f47077g;

    public v0(@NotNull o c6, @Nullable v0 v0Var, @NotNull List<ProtoBuf.TypeParameter> typeParameterProtos, @NotNull String debugName, @NotNull String containerPresentableName) {
        Map<Integer, j1> linkedHashMap;
        kotlin.jvm.internal.g0.p(c6, "c");
        kotlin.jvm.internal.g0.p(typeParameterProtos, "typeParameterProtos");
        kotlin.jvm.internal.g0.p(debugName, "debugName");
        kotlin.jvm.internal.g0.p(containerPresentableName, "containerPresentableName");
        this.f47071a = c6;
        this.f47072b = v0Var;
        this.f47073c = debugName;
        this.f47074d = containerPresentableName;
        this.f47075e = c6.h().c(new q0(this));
        this.f47076f = c6.h().c(new r0(this));
        if (typeParameterProtos.isEmpty()) {
            linkedHashMap = i1.z();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i6 = 0;
            for (ProtoBuf.TypeParameter typeParameter : typeParameterProtos) {
                linkedHashMap.put(Integer.valueOf(typeParameter.getId()), new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.r0(this.f47071a, typeParameter, i6));
                i6++;
            }
        }
        this.f47077g = linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int A(ProtoBuf.Type it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return it.getArgumentCount();
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.f g(int i6) {
        kotlin.reflect.jvm.internal.impl.name.b a6 = k0.a(this.f47071a.g(), i6);
        return a6.i() ? this.f47071a.c().b(a6) : kotlin.reflect.jvm.internal.impl.descriptors.x.c(this.f47071a.c().q(), a6);
    }

    private final e1 h(int i6) {
        if (k0.a(this.f47071a.g(), i6).i()) {
            return this.f47071a.c().o().a();
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.f i(int i6) {
        kotlin.reflect.jvm.internal.impl.name.b a6 = k0.a(this.f47071a.g(), i6);
        if (a6.i()) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.x.f(this.f47071a.c().q(), a6);
    }

    private final e1 l(t1 t1Var, w1 w1Var, List<? extends c2> list, boolean z5) {
        e1 m6 = kotlin.reflect.jvm.internal.impl.types.w0.m(t1Var, w1Var, list, z5, null, 16, null);
        if (kotlin.reflect.jvm.internal.impl.builtins.i.q(m6)) {
            return t(m6);
        }
        return null;
    }

    private final j1 n(int i6) {
        j1 j1Var = this.f47077g.get(Integer.valueOf(i6));
        if (j1Var != null) {
            return j1Var;
        }
        v0 v0Var = this.f47072b;
        if (v0Var != null) {
            return v0Var.n(i6);
        }
        return null;
    }

    public static /* synthetic */ e1 q(v0 v0Var, ProtoBuf.Type type, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = true;
        }
        return v0Var.o(type, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List r(v0 v0Var, ProtoBuf.Type type) {
        return v0Var.f47071a.c().d().h(type, v0Var.f47071a.g());
    }

    private final t1 s(List<? extends s1> list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, w1 w1Var, kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        List<? extends s1> list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((s1) it.next()).a(gVar, w1Var, kVar));
        }
        return t1.f47332b.j(kotlin.collections.f0.f0(arrayList));
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.d y(v0 v0Var, ProtoBuf.Type type, int i6) {
        kotlin.reflect.jvm.internal.impl.name.b a6 = k0.a(v0Var.f47071a.g(), i6);
        List<Integer> J3 = kotlin.sequences.p.J3(kotlin.sequences.p.N1(kotlin.sequences.p.t(type, new t0(v0Var)), u0.f47069a));
        int E0 = kotlin.sequences.p.E0(kotlin.sequences.p.t(a6, new PropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.v0.a
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.p
            public Object get(Object obj) {
                return ((kotlin.reflect.jvm.internal.impl.name.b) obj).e();
            }
        }));
        while (J3.size() < E0) {
            J3.add(0);
        }
        return v0Var.f47071a.c().r().d(a6, J3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProtoBuf.Type z(v0 v0Var, ProtoBuf.Type it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.k(it, v0Var.f47071a.j());
    }

    @NotNull
    public final List<j1> m() {
        return kotlin.collections.f0.a6(this.f47077g.values());
    }

    @NotNull
    public final e1 o(@NotNull ProtoBuf.Type proto, boolean z5) {
        e1 e1Var;
        e1 j6;
        kotlin.jvm.internal.g0.p(proto, "proto");
        e1 h6 = proto.hasClassName() ? h(proto.getClassName()) : proto.hasTypeAliasName() ? h(proto.getTypeAliasName()) : null;
        if (h6 != null) {
            return h6;
        }
        w1 x5 = x(proto);
        if (kotlin.reflect.jvm.internal.impl.types.error.i.m(x5.c())) {
            return kotlin.reflect.jvm.internal.impl.types.error.i.f47232a.c(ErrorTypeKind.TYPE_FOR_ERROR_TYPE_CONSTRUCTOR, x5, x5.toString());
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b(this.f47071a.h(), new s0(this, proto));
        t1 s5 = s(this.f47071a.c().v(), bVar, x5, this.f47071a.e());
        List<ProtoBuf.Type.Argument> p5 = p(proto, this);
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(p5, 10));
        int i6 = 0;
        for (Object obj : p5) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            List<j1> parameters = x5.getParameters();
            kotlin.jvm.internal.g0.o(parameters, "getParameters(...)");
            arrayList.add(w((j1) kotlin.collections.f0.b3(parameters, i6), (ProtoBuf.Type.Argument) obj));
            i6 = i7;
        }
        List<? extends c2> a6 = kotlin.collections.f0.a6(arrayList);
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = x5.c();
        if (z5 && (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.i1)) {
            kotlin.reflect.jvm.internal.impl.types.w0 w0Var = kotlin.reflect.jvm.internal.impl.types.w0.f47361a;
            e1 c7 = kotlin.reflect.jvm.internal.impl.types.w0.c((kotlin.reflect.jvm.internal.impl.descriptors.i1) c6, a6);
            e1Var = c7.M0(kotlin.reflect.jvm.internal.impl.types.x0.b(c7) || proto.getNullable()).O0(s(this.f47071a.c().v(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.a(kotlin.collections.f0.E4(bVar, c7.getAnnotations())), x5, this.f47071a.e()));
        } else if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46206a.d(proto.getFlags()).booleanValue()) {
            e1Var = k(s5, x5, a6, proto.getNullable());
        } else {
            e1 m6 = kotlin.reflect.jvm.internal.impl.types.w0.m(s5, x5, a6, proto.getNullable(), null, 16, null);
            if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46207b.d(proto.getFlags()).booleanValue()) {
                e1Var = z.a.c(kotlin.reflect.jvm.internal.impl.types.z.f47374d, m6, true, false, 4, null);
                if (e1Var == null) {
                    throw new IllegalStateException(("null DefinitelyNotNullType for '" + m6 + '\'').toString());
                }
            } else {
                e1Var = m6;
            }
        }
        ProtoBuf.Type a7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.a(proto, this.f47071a.j());
        return (a7 == null || (j6 = kotlin.reflect.jvm.internal.impl.types.i1.j(e1Var, o(a7, false))) == null) ? e1Var : j6;
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f47073c);
        if (this.f47072b == null) {
            str = "";
        } else {
            str = ". Child of " + this.f47072b.f47073c;
        }
        sb.append(str);
        return sb.toString();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.types.t0 u(@NotNull ProtoBuf.Type proto) {
        kotlin.jvm.internal.g0.p(proto, "proto");
        if (!proto.hasFlexibleTypeCapabilitiesId()) {
            return o(proto, true);
        }
        String string = this.f47071a.g().getString(proto.getFlexibleTypeCapabilitiesId());
        e1 q5 = q(this, proto, false, 2, null);
        ProtoBuf.Type f6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.f(proto, this.f47071a.j());
        kotlin.jvm.internal.g0.m(f6);
        return this.f47071a.c().m().a(proto, string, q5, q(this, f6, false, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.f f(v0 v0Var, int i6) {
        return v0Var.g(i6);
    }

    private final e1 j(kotlin.reflect.jvm.internal.impl.types.t0 t0Var, kotlin.reflect.jvm.internal.impl.types.t0 t0Var2) {
        kotlin.reflect.jvm.internal.impl.builtins.j o5 = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.o(t0Var);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = t0Var.getAnnotations();
        kotlin.reflect.jvm.internal.impl.types.t0 k6 = kotlin.reflect.jvm.internal.impl.builtins.i.k(t0Var);
        List<kotlin.reflect.jvm.internal.impl.types.t0> e6 = kotlin.reflect.jvm.internal.impl.builtins.i.e(t0Var);
        List h22 = kotlin.collections.f0.h2(kotlin.reflect.jvm.internal.impl.builtins.i.m(t0Var), 1);
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(h22, 10));
        Iterator it = h22.iterator();
        while (it.hasNext()) {
            arrayList.add(((c2) it.next()).getType());
        }
        return kotlin.reflect.jvm.internal.impl.builtins.i.b(o5, annotations, k6, e6, arrayList, null, t0Var2, true).M0(t0Var.J0());
    }

    private final e1 k(t1 t1Var, w1 w1Var, List<? extends c2> list, boolean z5) {
        List<? extends c2> list2;
        e1 l6;
        int size;
        int size2 = w1Var.getParameters().size() - list.size();
        if (size2 != 0) {
            l6 = null;
            if (size2 != 1 || (size = list.size() - 1) < 0) {
                list2 = list;
            } else {
                w1 o5 = w1Var.p().Y(size).o();
                kotlin.jvm.internal.g0.o(o5, "getTypeConstructor(...)");
                list2 = list;
                l6 = kotlin.reflect.jvm.internal.impl.types.w0.m(t1Var, o5, list2, z5, null, 16, null);
            }
        } else {
            list2 = list;
            l6 = l(t1Var, w1Var, list2, z5);
        }
        if (l6 == null) {
            return kotlin.reflect.jvm.internal.impl.types.error.i.f47232a.f(ErrorTypeKind.INCONSISTENT_SUSPEND_FUNCTION, list2, w1Var, new String[0]);
        }
        return l6;
    }

    private static final List<ProtoBuf.Type.Argument> p(ProtoBuf.Type type, v0 v0Var) {
        List<ProtoBuf.Type.Argument> list;
        List<ProtoBuf.Type.Argument> argumentList = type.getArgumentList();
        kotlin.jvm.internal.g0.o(argumentList, "getArgumentList(...)");
        List<ProtoBuf.Type.Argument> list2 = argumentList;
        ProtoBuf.Type k6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.k(type, v0Var.f47071a.j());
        if (k6 != null) {
            list = p(k6, v0Var);
        } else {
            list = null;
        }
        if (list == null) {
            list = kotlin.collections.f0.J();
        }
        return kotlin.collections.f0.I4(list2, list);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if (kotlin.jvm.internal.g0.g(r2, r3) == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlin.reflect.jvm.internal.impl.types.e1 t(kotlin.reflect.jvm.internal.impl.types.t0 r6) {
        /*
            r5 = this;
            java.util.List r0 = kotlin.reflect.jvm.internal.impl.builtins.i.m(r6)
            java.lang.Object r0 = kotlin.collections.f0.A3(r0)
            kotlin.reflect.jvm.internal.impl.types.c2 r0 = (kotlin.reflect.jvm.internal.impl.types.c2) r0
            r1 = 0
            if (r0 == 0) goto L7e
            kotlin.reflect.jvm.internal.impl.types.t0 r0 = r0.getType()
            if (r0 != 0) goto L14
            goto L7e
        L14:
            kotlin.reflect.jvm.internal.impl.types.w1 r2 = r0.I0()
            kotlin.reflect.jvm.internal.impl.descriptors.f r2 = r2.c()
            if (r2 == 0) goto L23
            kotlin.reflect.jvm.internal.impl.name.c r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.o(r2)
            goto L24
        L23:
            r2 = r1
        L24:
            java.util.List r3 = r0.G0()
            int r3 = r3.size()
            r4 = 1
            if (r3 != r4) goto L7b
            kotlin.reflect.jvm.internal.impl.name.c r3 = kotlin.reflect.jvm.internal.impl.builtins.o.f44579w
            boolean r3 = kotlin.jvm.internal.g0.g(r2, r3)
            if (r3 != 0) goto L42
            kotlin.reflect.jvm.internal.impl.name.c r3 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.w0.a()
            boolean r2 = kotlin.jvm.internal.g0.g(r2, r3)
            if (r2 != 0) goto L42
            goto L7b
        L42:
            java.util.List r0 = r0.G0()
            java.lang.Object r0 = kotlin.collections.f0.m5(r0)
            kotlin.reflect.jvm.internal.impl.types.c2 r0 = (kotlin.reflect.jvm.internal.impl.types.c2) r0
            kotlin.reflect.jvm.internal.impl.types.t0 r0 = r0.getType()
            java.lang.String r2 = "getType(...)"
            kotlin.jvm.internal.g0.o(r0, r2)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.o r2 = r5.f47071a
            kotlin.reflect.jvm.internal.impl.descriptors.k r2 = r2.e()
            boolean r3 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a
            if (r3 == 0) goto L62
            kotlin.reflect.jvm.internal.impl.descriptors.a r2 = (kotlin.reflect.jvm.internal.impl.descriptors.a) r2
            goto L63
        L62:
            r2 = r1
        L63:
            if (r2 == 0) goto L69
            kotlin.reflect.jvm.internal.impl.name.c r1 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.k(r2)
        L69:
            kotlin.reflect.jvm.internal.impl.name.c r2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.p0.f47052a
            boolean r1 = kotlin.jvm.internal.g0.g(r1, r2)
            if (r1 == 0) goto L76
            kotlin.reflect.jvm.internal.impl.types.e1 r6 = r5.j(r6, r0)
            return r6
        L76:
            kotlin.reflect.jvm.internal.impl.types.e1 r6 = r5.j(r6, r0)
            return r6
        L7b:
            kotlin.reflect.jvm.internal.impl.types.e1 r6 = (kotlin.reflect.jvm.internal.impl.types.e1) r6
            return r6
        L7e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.v0.t(kotlin.reflect.jvm.internal.impl.types.t0):kotlin.reflect.jvm.internal.impl.types.e1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.f v(v0 v0Var, int i6) {
        return v0Var.i(i6);
    }

    private final c2 w(j1 j1Var, ProtoBuf.Type.Argument argument) {
        if (argument.getProjection() == ProtoBuf.Type.Argument.Projection.STAR) {
            if (j1Var == null) {
                return new kotlin.reflect.jvm.internal.impl.types.j1(this.f47071a.c().q().p());
            }
            return new l1(j1Var);
        }
        n0 n0Var = n0.f47030a;
        ProtoBuf.Type.Argument.Projection projection = argument.getProjection();
        kotlin.jvm.internal.g0.o(projection, "getProjection(...)");
        Variance c6 = n0Var.c(projection);
        ProtoBuf.Type q5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.q(argument, this.f47071a.j());
        if (q5 == null) {
            return new e2(kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.NO_RECORDED_TYPE, argument.toString()));
        }
        return new e2(c6, u(q5));
    }

    private final w1 x(ProtoBuf.Type type) {
        kotlin.reflect.jvm.internal.impl.descriptors.f invoke;
        Object obj;
        if (type.hasClassName()) {
            invoke = this.f47075e.invoke(Integer.valueOf(type.getClassName()));
            if (invoke == null) {
                invoke = y(this, type, type.getClassName());
            }
        } else if (type.hasTypeParameter()) {
            invoke = n(type.getTypeParameter());
            if (invoke == null) {
                return kotlin.reflect.jvm.internal.impl.types.error.i.f47232a.e(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER, String.valueOf(type.getTypeParameter()), this.f47074d);
            }
        } else if (type.hasTypeParameterName()) {
            String string = this.f47071a.g().getString(type.getTypeParameterName());
            Iterator<T> it = m().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (kotlin.jvm.internal.g0.g(((j1) obj).getName().b(), string)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            invoke = (j1) obj;
            if (invoke == null) {
                return kotlin.reflect.jvm.internal.impl.types.error.i.f47232a.e(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME, string, this.f47071a.e().toString());
            }
        } else if (type.hasTypeAliasName()) {
            invoke = this.f47076f.invoke(Integer.valueOf(type.getTypeAliasName()));
            if (invoke == null) {
                invoke = y(this, type, type.getTypeAliasName());
            }
        } else {
            return kotlin.reflect.jvm.internal.impl.types.error.i.f47232a.e(ErrorTypeKind.UNKNOWN_TYPE, new String[0]);
        }
        w1 o5 = invoke.o();
        kotlin.jvm.internal.g0.o(o5, "getTypeConstructor(...)");
        return o5;
    }
}
