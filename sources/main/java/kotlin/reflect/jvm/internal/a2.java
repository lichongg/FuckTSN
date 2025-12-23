package kotlin.reflect.jvm.internal;

import com.tencent.connect.common.Constants;
import java.util.Collection;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.f3;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a2 extends KDeclarationContainerImpl {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Class<?> f44246d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.s<a> f44247e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends KDeclarationContainerImpl.b {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ kotlin.reflect.n<Object>[] f44248j = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(a.class, "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(a.class, Constants.PARAM_SCOPE, "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(a.class, "members", "getMembers()Ljava/util/Collection;", 0))};

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private final f3.a f44249d;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private final f3.a f44250e;

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        private final kotlin.s f44251f;

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        private final kotlin.s f44252g;

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        private final f3.a f44253h;

        public a() {
            super();
            this.f44249d = f3.c(new v1(a2.this));
            this.f44250e = f3.c(new w1(this));
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
            this.f44251f = kotlin.t.b(lazyThreadSafetyMode, new x1(this, a2.this));
            this.f44252g = kotlin.t.b(lazyThreadSafetyMode, new y1(this));
            this.f44253h = f3.c(new z1(a2.this, this));
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f i() {
            return (kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f) this.f44249d.b(this, f44248j[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f n(a2 a2Var) {
            return kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f.f44967c.a(a2Var.c());
        }

        @NotNull
        public final Collection<e0<?>> j() {
            T b6 = this.f44253h.b(this, f44248j[2]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (Collection) b6;
        }

        @Nullable
        public final Triple<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e, ProtoBuf.Package, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c> k() {
            return (Triple) this.f44252g.getValue();
        }

        @Nullable
        public final Class<?> l() {
            return (Class) this.f44251f.getValue();
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.k m() {
            T b6 = this.f44250e.b(this, f44248j[1]);
            kotlin.jvm.internal.g0.o(b6, "getValue(...)");
            return (kotlin.reflect.jvm.internal.impl.resolve.scopes.k) b6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection o(a2 a2Var, a aVar) {
            return a2Var.S(aVar.m(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Triple p(a aVar) {
            KotlinClassHeader e6;
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f i6 = aVar.i();
            if (i6 != null && (e6 = i6.e()) != null) {
                String[] a6 = e6.a();
                String[] g6 = e6.g();
                if (a6 != null && g6 != null) {
                    Pair<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e, ProtoBuf.Package> m6 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.m(a6, g6);
                    return new Triple(m6.component1(), m6.component2(), e6.d());
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Class q(a aVar, a2 a2Var) {
            String str;
            KotlinClassHeader e6;
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f i6 = aVar.i();
            if (i6 != null && (e6 = i6.e()) != null) {
                str = e6.e();
            } else {
                str = null;
            }
            if (str == null || str.length() <= 0) {
                return null;
            }
            return a2Var.c().getClassLoader().loadClass(kotlin.text.u.w2(str, '/', '.', false, 4, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.k r(a aVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f i6 = aVar.i();
            if (i6 != null) {
                return aVar.b().c().a(i6);
            }
            return k.c.f46780b;
        }
    }

    public a2(@NotNull Class<?> jClass) {
        kotlin.jvm.internal.g0.p(jClass, "jClass");
        this.f44246d = jClass;
        this.f44247e = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new t1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a c0(a2 a2Var) {
        return a2Var.new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.w0 d0(kotlin.reflect.jvm.internal.impl.serialization.deserialization.j0 deserializeToDescriptor, ProtoBuf.Property proto) {
        kotlin.jvm.internal.g0.p(deserializeToDescriptor, "$this$deserializeToDescriptor");
        kotlin.jvm.internal.g0.p(proto, "proto");
        return deserializeToDescriptor.u(proto, true);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.k e0() {
        return this.f44247e.getValue().m();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.y> Q(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        return e0().a(name, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.w0 R(int i6) {
        Triple<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e, ProtoBuf.Package, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c> k6 = this.f44247e.getValue().k();
        if (k6 != null) {
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e component1 = k6.component1();
            ProtoBuf.Package component2 = k6.component2();
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.c component3 = k6.component3();
            GeneratedMessageLite.f<ProtoBuf.Package, List<ProtoBuf.Property>> packageLocalVariable = JvmProtoBuf.f46272n;
            kotlin.jvm.internal.g0.o(packageLocalVariable, "packageLocalVariable");
            ProtoBuf.Property property = (ProtoBuf.Property) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.b(component2, packageLocalVariable, i6);
            if (property != null) {
                Class<?> c6 = c();
                ProtoBuf.TypeTable typeTable = component2.getTypeTable();
                kotlin.jvm.internal.g0.o(typeTable, "getTypeTable(...)");
                return (kotlin.reflect.jvm.internal.impl.descriptors.w0) p3.h(c6, property, component1, new kotlin.reflect.jvm.internal.impl.metadata.deserialization.h(typeTable), component3, u1.f47602a);
            }
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    protected Class<?> T() {
        Class<?> l6 = this.f44247e.getValue().l();
        return l6 == null ? c() : l6;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> U(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        return e0().c(name, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.jvm.internal.s
    @NotNull
    public Class<?> c() {
        return this.f44246d;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof a2) && kotlin.jvm.internal.g0.g(c(), ((a2) obj).c());
    }

    @Override // kotlin.reflect.h
    @NotNull
    public Collection<kotlin.reflect.c<?>> o() {
        return this.f44247e.getValue().j();
    }

    @NotNull
    public String toString() {
        return "file class " + kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.e(c()).a();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.j> P() {
        return kotlin.collections.f0.J();
    }

    public int hashCode() {
        return c().hashCode();
    }
}
