package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.load.kotlin.a0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.x;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.constants.t;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.m0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class d<A, C> extends e<A, g<? extends A, ? extends C>> implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.d<A, C> {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.g<x, g<A, C>> f45865c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements x.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d<A, C> f45866a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap<a0, List<A>> f45867b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ x f45868c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HashMap<a0, C> f45869d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HashMap<a0, C> f45870e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.d$a$a, reason: collision with other inner class name */
        public final class C0891a extends b implements x.e {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f45871d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0891a(a aVar, a0 signature) {
                super(aVar, signature);
                kotlin.jvm.internal.g0.p(signature, "signature");
                this.f45871d = aVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.e
            public x.a a(int i6, kotlin.reflect.jvm.internal.impl.name.b classId, e1 source) {
                kotlin.jvm.internal.g0.p(classId, "classId");
                kotlin.jvm.internal.g0.p(source, "source");
                a0 e6 = a0.f45861b.e(c(), i6);
                List<A> list = this.f45871d.f45867b.get(e6);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f45871d.f45867b.put(e6, list);
                }
                return this.f45871d.f45866a.y(classId, source, list);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class b implements x.c {

            /* renamed from: a, reason: collision with root package name */
            private final a0 f45872a;

            /* renamed from: b, reason: collision with root package name */
            private final ArrayList<A> f45873b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f45874c;

            public b(a aVar, a0 signature) {
                kotlin.jvm.internal.g0.p(signature, "signature");
                this.f45874c = aVar;
                this.f45872a = signature;
                this.f45873b = new ArrayList<>();
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.c
            public x.a b(kotlin.reflect.jvm.internal.impl.name.b classId, e1 source) {
                kotlin.jvm.internal.g0.p(classId, "classId");
                kotlin.jvm.internal.g0.p(source, "source");
                return this.f45874c.f45866a.y(classId, source, this.f45873b);
            }

            protected final a0 c() {
                return this.f45872a;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.c
            public void visitEnd() {
                if (this.f45873b.isEmpty()) {
                    return;
                }
                this.f45874c.f45867b.put(this.f45872a, this.f45873b);
            }
        }

        a(d<A, C> dVar, HashMap<a0, List<A>> hashMap, x xVar, HashMap<a0, C> hashMap2, HashMap<a0, C> hashMap3) {
            this.f45866a = dVar;
            this.f45867b = hashMap;
            this.f45868c = xVar;
            this.f45869d = hashMap2;
            this.f45870e = hashMap3;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.d
        public x.e a(kotlin.reflect.jvm.internal.impl.name.f name, String desc) {
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(desc, "desc");
            a0.a aVar = a0.f45861b;
            String b6 = name.b();
            kotlin.jvm.internal.g0.o(b6, "asString(...)");
            return new C0891a(this, aVar.d(b6, desc));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.d
        public x.c b(kotlin.reflect.jvm.internal.impl.name.f name, String desc, Object obj) {
            C I;
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(desc, "desc");
            a0.a aVar = a0.f45861b;
            String b6 = name.b();
            kotlin.jvm.internal.g0.o(b6, "asString(...)");
            a0 a6 = aVar.a(b6, desc);
            if (obj != null && (I = this.f45866a.I(desc, obj)) != null) {
                this.f45870e.put(a6, I);
            }
            return new b(this, a6);
        }
    }

    @Nullable
    protected abstract C I(@NotNull String str, @NotNull Object obj);

    @Nullable
    protected abstract C M(@NotNull C c6);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull v kotlinClassFinder) {
        super(kotlinClassFinder);
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(kotlinClassFinder, "kotlinClassFinder");
        this.f45865c = storageManager.i(new kotlin.reflect.jvm.internal.impl.load.kotlin.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object G(g loadConstantFromProperty, a0 it) {
        kotlin.jvm.internal.g0.p(loadConstantFromProperty, "$this$loadConstantFromProperty");
        kotlin.jvm.internal.g0.p(it, "it");
        return loadConstantFromProperty.b().get(it);
    }

    private final g<A, C> H(x xVar) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        xVar.d(new a(this, hashMap, xVar, hashMap3, hashMap2), r(xVar));
        return new g<>(hashMap, hashMap2, hashMap3);
    }

    private final C J(m0 m0Var, ProtoBuf.Property property, AnnotatedCallableKind annotatedCallableKind, t0 t0Var, Function2<? super g<? extends A, ? extends C>, ? super a0, ? extends C> function2) {
        C invoke;
        x p5 = p(m0Var, e.f45876b.a(m0Var, true, true, kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.B.d(property.getFlags()), kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.f(property), u(), v()));
        if (p5 == null) {
            return null;
        }
        a0 s5 = s(property, m0Var.b(), m0Var.d(), annotatedCallableKind, p5.e().d().d(n.f45971b.a()));
        if (s5 == null || (invoke = function2.invoke(this.f45865c.invoke(p5), s5)) == null) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.builtins.q.d(t0Var) ? M(invoke) : invoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object K(g loadConstantFromProperty, a0 it) {
        kotlin.jvm.internal.g0.p(loadConstantFromProperty, "$this$loadConstantFromProperty");
        kotlin.jvm.internal.g0.p(it, "it");
        return loadConstantFromProperty.c().get(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g L(d dVar, x kotlinClass) {
        kotlin.jvm.internal.g0.p(kotlinClass, "kotlinClass");
        return dVar.H(kotlinClass);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.e
    @NotNull
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public g<A, C> q(@NotNull x binaryClass) {
        kotlin.jvm.internal.g0.p(binaryClass, "binaryClass");
        return this.f45865c.invoke(binaryClass);
    }

    protected final boolean F(@NotNull kotlin.reflect.jvm.internal.impl.name.b annotationClassId, @NotNull Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> arguments) {
        kotlin.jvm.internal.g0.p(annotationClassId, "annotationClassId");
        kotlin.jvm.internal.g0.p(arguments, "arguments");
        if (!kotlin.jvm.internal.g0.g(annotationClassId, kotlin.reflect.jvm.internal.impl.a.f44394a.a())) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar = arguments.get(kotlin.reflect.jvm.internal.impl.name.f.h("value"));
        kotlin.reflect.jvm.internal.impl.resolve.constants.t tVar = gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.t ? (kotlin.reflect.jvm.internal.impl.resolve.constants.t) gVar : null;
        if (tVar == null) {
            return false;
        }
        t.b a6 = tVar.a();
        t.b.C0913b c0913b = a6 instanceof t.b.C0913b ? (t.b.C0913b) a6 : null;
        if (c0913b == null) {
            return false;
        }
        return w(c0913b.b());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.d
    @Nullable
    public C e(@NotNull m0 container, @NotNull ProtoBuf.Property proto, @NotNull t0 expectedType) {
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(expectedType, "expectedType");
        return J(container, proto, AnnotatedCallableKind.PROPERTY, expectedType, c.f45864a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.d
    @Nullable
    public C j(@NotNull m0 container, @NotNull ProtoBuf.Property proto, @NotNull t0 expectedType) {
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(expectedType, "expectedType");
        return J(container, proto, AnnotatedCallableKind.PROPERTY_GETTER, expectedType, b.f45863a);
    }
}
