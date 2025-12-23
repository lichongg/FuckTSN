package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.load.kotlin.a0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.e.a;
import kotlin.reflect.jvm.internal.impl.load.kotlin.x;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.m0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAbstractBinaryClassAnnotationLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBinaryClassAnnotationLoader.kt\norg/jetbrains/kotlin/load/kotlin/AbstractBinaryClassAnnotationLoader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,338:1\n1563#2:339\n1634#2,3:340\n1563#2:343\n1634#2,3:344\n*S KotlinDebug\n*F\n+ 1 AbstractBinaryClassAnnotationLoader.kt\norg/jetbrains/kotlin/load/kotlin/AbstractBinaryClassAnnotationLoader\n*L\n197#1:339\n197#1:340,3\n201#1:343\n201#1:344,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class e<A, S extends a<? extends A>> implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.g<A> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f45876b = new b(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final v f45877a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a<A> {
        @NotNull
        public abstract Map<a0, List<A>> a();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nAbstractBinaryClassAnnotationLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBinaryClassAnnotationLoader.kt\norg/jetbrains/kotlin/load/kotlin/AbstractBinaryClassAnnotationLoader$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,338:1\n1#2:339\n*E\n"})
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.v vVar) {
            this();
        }

        private b() {
        }

        @Nullable
        public final x a(@NotNull m0 container, boolean z5, boolean z6, @Nullable Boolean bool, boolean z7, @NotNull v kotlinClassFinder, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c metadataVersion) {
            m0.a h6;
            kotlin.jvm.internal.g0.p(container, "container");
            kotlin.jvm.internal.g0.p(kotlinClassFinder, "kotlinClassFinder");
            kotlin.jvm.internal.g0.p(metadataVersion, "metadataVersion");
            if (z5) {
                if (bool == null) {
                    throw new IllegalStateException(("isConst should not be null for property (container=" + container + ')').toString());
                }
                if (container instanceof m0.a) {
                    m0.a aVar = (m0.a) container;
                    if (aVar.g() == ProtoBuf.Class.Kind.INTERFACE) {
                        kotlin.reflect.jvm.internal.impl.name.b e6 = aVar.e();
                        kotlin.reflect.jvm.internal.impl.name.f h7 = kotlin.reflect.jvm.internal.impl.name.f.h("DefaultImpls");
                        kotlin.jvm.internal.g0.o(h7, "identifier(...)");
                        return w.a(kotlinClassFinder, e6.d(h7), metadataVersion);
                    }
                }
                if (bool.booleanValue() && (container instanceof m0.b)) {
                    e1 c6 = container.c();
                    r rVar = c6 instanceof r ? (r) c6 : null;
                    kotlin.reflect.jvm.internal.impl.resolve.jvm.d f6 = rVar != null ? rVar.f() : null;
                    if (f6 != null) {
                        b.a aVar2 = kotlin.reflect.jvm.internal.impl.name.b.f46334d;
                        String f7 = f6.f();
                        kotlin.jvm.internal.g0.o(f7, "getInternalName(...)");
                        return w.a(kotlinClassFinder, aVar2.c(new kotlin.reflect.jvm.internal.impl.name.c(kotlin.text.u.w2(f7, '/', '.', false, 4, null))), metadataVersion);
                    }
                }
            }
            if (z6 && (container instanceof m0.a)) {
                m0.a aVar3 = (m0.a) container;
                if (aVar3.g() == ProtoBuf.Class.Kind.COMPANION_OBJECT && (h6 = aVar3.h()) != null && (h6.g() == ProtoBuf.Class.Kind.CLASS || h6.g() == ProtoBuf.Class.Kind.ENUM_CLASS || (z7 && (h6.g() == ProtoBuf.Class.Kind.INTERFACE || h6.g() == ProtoBuf.Class.Kind.ANNOTATION_CLASS)))) {
                    e1 c7 = h6.c();
                    z zVar = c7 instanceof z ? (z) c7 : null;
                    if (zVar != null) {
                        return zVar.d();
                    }
                    return null;
                }
            }
            if (!(container instanceof m0.b) || !(container.c() instanceof r)) {
                return null;
            }
            e1 c8 = container.c();
            kotlin.jvm.internal.g0.n(c8, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
            r rVar2 = (r) c8;
            x g6 = rVar2.g();
            return g6 == null ? w.a(kotlinClassFinder, rVar2.d(), metadataVersion) : g6;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f45878a = new c("PROPERTY", 0);

        /* renamed from: b, reason: collision with root package name */
        public static final c f45879b = new c("BACKING_FIELD", 1);

        /* renamed from: c, reason: collision with root package name */
        public static final c f45880c = new c("DELEGATE_FIELD", 2);

        /* renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ c[] f45881d;

        /* renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ kotlin.enums.a f45882e;

        private static final /* synthetic */ c[] a() {
            return new c[]{f45878a, f45879b, f45880c};
        }

        static {
            c[] a6 = a();
            f45881d = a6;
            f45882e = kotlin.enums.c.c(a6);
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f45881d.clone();
        }

        private c(String str, int i6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.e$e, reason: collision with other inner class name */
    public static final class C0892e implements x.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e<A, S> f45884a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<A> f45885b;

        C0892e(e<A, S> eVar, ArrayList<A> arrayList) {
            this.f45884a = eVar;
            this.f45885b = arrayList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.c
        public x.a b(kotlin.reflect.jvm.internal.impl.name.b classId, e1 source) {
            kotlin.jvm.internal.g0.p(classId, "classId");
            kotlin.jvm.internal.g0.p(source, "source");
            return this.f45884a.y(classId, source, this.f45885b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.c
        public void visitEnd() {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public abstract A k(@NotNull ProtoBuf.Annotation annotation, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar);

    @NotNull
    protected abstract S q(@NotNull x xVar);

    @NotNull
    public abstract kotlin.reflect.jvm.internal.impl.metadata.deserialization.c v();

    @Nullable
    protected abstract x.a x(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull e1 e1Var, @NotNull List<A> list);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45883a;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            try {
                iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f45883a = iArr;
        }
    }

    public e(@NotNull v kotlinClassFinder) {
        kotlin.jvm.internal.g0.p(kotlinClassFinder, "kotlinClassFinder");
        this.f45877a = kotlinClassFinder;
    }

    private final int m(m0 m0Var, kotlin.reflect.jvm.internal.impl.protobuf.n nVar) {
        if (nVar instanceof ProtoBuf.Function) {
            return kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.g((ProtoBuf.Function) nVar) ? 1 : 0;
        }
        if (nVar instanceof ProtoBuf.Property) {
            return kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.h((ProtoBuf.Property) nVar) ? 1 : 0;
        }
        if (!(nVar instanceof ProtoBuf.Constructor)) {
            throw new UnsupportedOperationException("Unsupported message: " + nVar.getClass());
        }
        kotlin.jvm.internal.g0.n(m0Var, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
        m0.a aVar = (m0.a) m0Var;
        if (aVar.g() == ProtoBuf.Class.Kind.ENUM_CLASS) {
            return 2;
        }
        return aVar.i() ? 1 : 0;
    }

    private final List<A> n(m0 m0Var, a0 a0Var, boolean z5, boolean z6, Boolean bool, boolean z7) {
        x p5 = p(m0Var, f45876b.a(m0Var, z5, z6, bool, z7, this.f45877a, v()));
        if (p5 == null) {
            return kotlin.collections.f0.J();
        }
        List<A> list = q(p5).a().get(a0Var);
        return list == null ? kotlin.collections.f0.J() : list;
    }

    static /* synthetic */ List o(e eVar, m0 m0Var, a0 a0Var, boolean z5, boolean z6, Boolean bool, boolean z7, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
        }
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        if ((i6 & 8) != 0) {
            z6 = false;
        }
        if ((i6 & 16) != 0) {
            bool = null;
        }
        if ((i6 & 32) != 0) {
            z7 = false;
        }
        return eVar.n(m0Var, a0Var, z5, z6, bool, z7);
    }

    public static /* synthetic */ a0 t(e eVar, kotlin.reflect.jvm.internal.impl.protobuf.n nVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar, AnnotatedCallableKind annotatedCallableKind, boolean z5, int i6, Object obj) {
        if (obj == null) {
            return eVar.s(nVar, dVar, hVar, annotatedCallableKind, (i6 & 16) != 0 ? false : z5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    private final List<A> z(m0 m0Var, ProtoBuf.Property property, c cVar) {
        Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.B.d(property.getFlags());
        kotlin.jvm.internal.g0.o(d6, "get(...)");
        d6.booleanValue();
        boolean f6 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.f(property);
        if (cVar == c.f45878a) {
            a0 b6 = f.b(property, m0Var.b(), m0Var.d(), false, true, false, 40, null);
            return b6 == null ? kotlin.collections.f0.J() : o(this, m0Var, b6, true, false, d6, f6, 8, null);
        }
        a0 b7 = f.b(property, m0Var.b(), m0Var.d(), true, false, false, 48, null);
        if (b7 == null) {
            return kotlin.collections.f0.J();
        }
        return kotlin.text.u.l3(b7.a(), "$delegate", false, 2, null) != (cVar == c.f45880c) ? kotlin.collections.f0.J() : n(m0Var, b7, true, true, d6, f6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> a(@NotNull m0 container, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n callableProto, @NotNull AnnotatedCallableKind kind, int i6, @NotNull ProtoBuf.ValueParameter proto) {
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(callableProto, "callableProto");
        kotlin.jvm.internal.g0.p(kind, "kind");
        kotlin.jvm.internal.g0.p(proto, "proto");
        a0 t5 = t(this, callableProto, container.b(), container.d(), kind, false, 16, null);
        if (t5 == null) {
            return kotlin.collections.f0.J();
        }
        return o(this, container, a0.f45861b.e(t5, i6 + m(container, callableProto)), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> b(@NotNull m0.a container) {
        kotlin.jvm.internal.g0.p(container, "container");
        x A = A(container);
        if (A != null) {
            ArrayList arrayList = new ArrayList(1);
            A.f(new C0892e(this, arrayList), r(A));
            return arrayList;
        }
        throw new IllegalStateException(("Class for loading annotations is not found: " + container.a()).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> c(@NotNull m0 container, @NotNull ProtoBuf.EnumEntry proto) {
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(proto, "proto");
        return o(this, container, a0.f45861b.a(container.b().getString(proto.getName()), kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.b.b(((m0.a) container).e().b())), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> d(@NotNull ProtoBuf.TypeParameter proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver) {
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        Object extension = proto.getExtension(JvmProtoBuf.f46266h);
        kotlin.jvm.internal.g0.o(extension, "getExtension(...)");
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(iterable, 10));
        for (ProtoBuf.Annotation annotation : iterable) {
            kotlin.jvm.internal.g0.m(annotation);
            arrayList.add(k(annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> f(@NotNull m0 container, @NotNull ProtoBuf.Property proto) {
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(proto, "proto");
        return z(container, proto, c.f45879b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> g(@NotNull m0 container, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n proto, @NotNull AnnotatedCallableKind kind) {
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(kind, "kind");
        a0 t5 = t(this, proto, container.b(), container.d(), kind, false, 16, null);
        return t5 != null ? o(this, container, a0.f45861b.e(t5, 0), false, false, null, false, 60, null) : kotlin.collections.f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> h(@NotNull ProtoBuf.Type proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver) {
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        Object extension = proto.getExtension(JvmProtoBuf.f46264f);
        kotlin.jvm.internal.g0.o(extension, "getExtension(...)");
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(iterable, 10));
        for (ProtoBuf.Annotation annotation : iterable) {
            kotlin.jvm.internal.g0.m(annotation);
            arrayList.add(k(annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> i(@NotNull m0 container, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n proto, @NotNull AnnotatedCallableKind kind) {
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(kind, "kind");
        if (kind == AnnotatedCallableKind.PROPERTY) {
            return z(container, (ProtoBuf.Property) proto, c.f45878a);
        }
        a0 t5 = t(this, proto, container.b(), container.d(), kind, false, 16, null);
        return t5 == null ? kotlin.collections.f0.J() : o(this, container, t5, false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> l(@NotNull m0 container, @NotNull ProtoBuf.Property proto) {
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(proto, "proto");
        return z(container, proto, c.f45880c);
    }

    @Nullable
    protected final x p(@NotNull m0 container, @Nullable x xVar) {
        kotlin.jvm.internal.g0.p(container, "container");
        if (xVar != null) {
            return xVar;
        }
        if (container instanceof m0.a) {
            return A((m0.a) container);
        }
        return null;
    }

    @Nullable
    protected byte[] r(@NotNull x kotlinClass) {
        kotlin.jvm.internal.g0.p(kotlinClass, "kotlinClass");
        return null;
    }

    @Nullable
    protected final a0 s(@NotNull kotlin.reflect.jvm.internal.impl.protobuf.n proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable, @NotNull AnnotatedCallableKind kind, boolean z5) {
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.g0.p(typeTable, "typeTable");
        kotlin.jvm.internal.g0.p(kind, "kind");
        if (proto instanceof ProtoBuf.Constructor) {
            a0.a aVar = a0.f45861b;
            d.b b6 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.f46317a.b((ProtoBuf.Constructor) proto, nameResolver, typeTable);
            if (b6 == null) {
                return null;
            }
            return aVar.b(b6);
        }
        if (proto instanceof ProtoBuf.Function) {
            a0.a aVar2 = a0.f45861b;
            d.b e6 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.f46317a.e((ProtoBuf.Function) proto, nameResolver, typeTable);
            if (e6 == null) {
                return null;
            }
            return aVar2.b(e6);
        }
        if (proto instanceof ProtoBuf.Property) {
            GeneratedMessageLite.f<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.f46262d;
            kotlin.jvm.internal.g0.o(propertySignature, "propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a((GeneratedMessageLite.ExtendableMessage) proto, propertySignature);
            if (jvmPropertySignature == null) {
                return null;
            }
            int i6 = d.f45883a[kind.ordinal()];
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        return null;
                    }
                    return f.a((ProtoBuf.Property) proto, nameResolver, typeTable, true, true, z5);
                }
                if (!jvmPropertySignature.hasSetter()) {
                    return null;
                }
                a0.a aVar3 = a0.f45861b;
                JvmProtoBuf.JvmMethodSignature setter = jvmPropertySignature.getSetter();
                kotlin.jvm.internal.g0.o(setter, "getSetter(...)");
                return aVar3.c(nameResolver, setter);
            }
            if (jvmPropertySignature.hasGetter()) {
                a0.a aVar4 = a0.f45861b;
                JvmProtoBuf.JvmMethodSignature getter = jvmPropertySignature.getGetter();
                kotlin.jvm.internal.g0.o(getter, "getGetter(...)");
                return aVar4.c(nameResolver, getter);
            }
        }
        return null;
    }

    @NotNull
    protected final v u() {
        return this.f45877a;
    }

    protected final boolean w(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        x a6;
        kotlin.jvm.internal.g0.p(classId, "classId");
        return classId.e() != null && kotlin.jvm.internal.g0.g(classId.h().b(), "Container") && (a6 = w.a(this.f45877a, classId, v())) != null && kotlin.reflect.jvm.internal.impl.a.f44394a.c(a6);
    }

    @Nullable
    protected final x.a y(@NotNull kotlin.reflect.jvm.internal.impl.name.b annotationClassId, @NotNull e1 source, @NotNull List<A> result) {
        kotlin.jvm.internal.g0.p(annotationClassId, "annotationClassId");
        kotlin.jvm.internal.g0.p(source, "source");
        kotlin.jvm.internal.g0.p(result, "result");
        if (kotlin.reflect.jvm.internal.impl.a.f44394a.b().contains(annotationClassId)) {
            return null;
        }
        return x(annotationClassId, source, result);
    }

    private final x A(m0.a aVar) {
        z zVar;
        e1 c6 = aVar.c();
        if (c6 instanceof z) {
            zVar = (z) c6;
        } else {
            zVar = null;
        }
        if (zVar == null) {
            return null;
        }
        return zVar.d();
    }
}
