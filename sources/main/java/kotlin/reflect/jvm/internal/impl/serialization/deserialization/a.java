package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAbstractAnnotationLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractAnnotationLoader.kt\norg/jetbrains/kotlin/serialization/deserialization/AbstractAnnotationLoader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,104:1\n1563#2:105\n1634#2,3:106\n1563#2:109\n1634#2,3:110\n1563#2:114\n1634#2,3:115\n1563#2:118\n1634#2,3:119\n1563#2:122\n1634#2,3:123\n1563#2:126\n1634#2,3:127\n1563#2:130\n1634#2,3:131\n1563#2:134\n1634#2,3:135\n1563#2:138\n1634#2,3:139\n1#3:113\n*S KotlinDebug\n*F\n+ 1 AbstractAnnotationLoader.kt\norg/jetbrains/kotlin/serialization/deserialization/AbstractAnnotationLoader\n*L\n18#1:105\n18#1:106,3\n37#1:109\n37#1:110,3\n44#1:114\n44#1:115,3\n51#1:118\n51#1:119,3\n58#1:122\n58#1:123,3\n71#1:126\n71#1:127,3\n91#1:130\n91#1:131,3\n97#1:134\n97#1:135,3\n101#1:138\n101#1:139,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a<A> implements g<A> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final c4.a f46812a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.a$a, reason: collision with other inner class name */
    public static final /* synthetic */ class C0915a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46813a;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            try {
                iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f46813a = iArr;
        }
    }

    public a(@NotNull c4.a protocol) {
        kotlin.jvm.internal.g0.p(protocol, "protocol");
        this.f46812a = protocol;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> a(@NotNull m0 container, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n callableProto, @NotNull AnnotatedCallableKind kind, int i6, @NotNull ProtoBuf.ValueParameter proto) {
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(callableProto, "callableProto");
        kotlin.jvm.internal.g0.p(kind, "kind");
        kotlin.jvm.internal.g0.p(proto, "proto");
        List list = (List) proto.getExtension(this.f46812a.h());
        if (list == null) {
            list = kotlin.collections.f0.J();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(k((ProtoBuf.Annotation) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> b(@NotNull m0.a container) {
        kotlin.jvm.internal.g0.p(container, "container");
        List list = (List) container.f().getExtension(this.f46812a.a());
        if (list == null) {
            list = kotlin.collections.f0.J();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(k((ProtoBuf.Annotation) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> c(@NotNull m0 container, @NotNull ProtoBuf.EnumEntry proto) {
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(proto, "proto");
        List list = (List) proto.getExtension(this.f46812a.d());
        if (list == null) {
            list = kotlin.collections.f0.J();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(k((ProtoBuf.Annotation) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> d(@NotNull ProtoBuf.TypeParameter proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver) {
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        List list = (List) proto.getExtension(this.f46812a.p());
        if (list == null) {
            list = kotlin.collections.f0.J();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(k((ProtoBuf.Annotation) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> f(@NotNull m0 container, @NotNull ProtoBuf.Property proto) {
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(proto, "proto");
        GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> j6 = this.f46812a.j();
        List list = j6 != null ? (List) proto.getExtension(j6) : null;
        if (list == null) {
            list = kotlin.collections.f0.J();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(k((ProtoBuf.Annotation) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> g(@NotNull m0 container, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n proto, @NotNull AnnotatedCallableKind kind) {
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(kind, "kind");
        List list = null;
        if (proto instanceof ProtoBuf.Function) {
            GeneratedMessageLite.f<ProtoBuf.Function, List<ProtoBuf.Annotation>> g6 = this.f46812a.g();
            if (g6 != null) {
                list = (List) ((ProtoBuf.Function) proto).getExtension(g6);
            }
        } else {
            if (!(proto instanceof ProtoBuf.Property)) {
                throw new IllegalStateException(("Unknown message: " + proto).toString());
            }
            int i6 = C0915a.f46813a[kind.ordinal()];
            if (i6 != 1 && i6 != 2 && i6 != 3) {
                throw new IllegalStateException(("Unsupported callable kind with property proto for receiver annotations: " + kind).toString());
            }
            GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> l6 = this.f46812a.l();
            if (l6 != null) {
                list = (List) ((ProtoBuf.Property) proto).getExtension(l6);
            }
        }
        if (list == null) {
            list = kotlin.collections.f0.J();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(k((ProtoBuf.Annotation) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> h(@NotNull ProtoBuf.Type proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver) {
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        List list = (List) proto.getExtension(this.f46812a.o());
        if (list == null) {
            list = kotlin.collections.f0.J();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(k((ProtoBuf.Annotation) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> i(@NotNull m0 container, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n proto, @NotNull AnnotatedCallableKind kind) {
        List list;
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(kind, "kind");
        if (proto instanceof ProtoBuf.Constructor) {
            list = (List) ((ProtoBuf.Constructor) proto).getExtension(this.f46812a.c());
        } else if (proto instanceof ProtoBuf.Function) {
            list = (List) ((ProtoBuf.Function) proto).getExtension(this.f46812a.f());
        } else {
            if (!(proto instanceof ProtoBuf.Property)) {
                throw new IllegalStateException(("Unknown message: " + proto).toString());
            }
            int i6 = C0915a.f46813a[kind.ordinal()];
            if (i6 == 1) {
                list = (List) ((ProtoBuf.Property) proto).getExtension(this.f46812a.i());
            } else if (i6 == 2) {
                list = (List) ((ProtoBuf.Property) proto).getExtension(this.f46812a.m());
            } else {
                if (i6 != 3) {
                    throw new IllegalStateException("Unsupported callable kind with property proto");
                }
                list = (List) ((ProtoBuf.Property) proto).getExtension(this.f46812a.n());
            }
        }
        if (list == null) {
            list = kotlin.collections.f0.J();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(k((ProtoBuf.Annotation) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    public List<A> l(@NotNull m0 container, @NotNull ProtoBuf.Property proto) {
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(proto, "proto");
        GeneratedMessageLite.f<ProtoBuf.Property, List<ProtoBuf.Annotation>> k6 = this.f46812a.k();
        List list = k6 != null ? (List) proto.getExtension(k6) : null;
        if (list == null) {
            list = kotlin.collections.f0.J();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(k((ProtoBuf.Annotation) it.next(), container.b()));
        }
        return arrayList;
    }

    @NotNull
    protected final c4.a m() {
        return this.f46812a;
    }
}
