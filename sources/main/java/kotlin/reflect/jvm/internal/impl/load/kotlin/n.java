package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.u1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.m0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDeserializedDescriptorResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedDescriptorResolver.kt\norg/jetbrains/kotlin/load/kotlin/DeserializedDescriptorResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,144:1\n116#1,14:145\n116#1,14:159\n1#2:173\n*S KotlinDebug\n*F\n+ 1 DeserializedDescriptorResolver.kt\norg/jetbrains/kotlin/load/kotlin/DeserializedDescriptorResolver\n*L\n45#1:145,14\n60#1:159,14\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f45971b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Set<KotlinClassHeader.Kind> f45972c = u1.f(KotlinClassHeader.Kind.CLASS);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Set<KotlinClassHeader.Kind> f45973d = u1.u(KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c f45974e = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.c(1, 1, 2);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c f45975f = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.c(1, 1, 11);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c f45976g = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.c(1, 1, 13);

    /* renamed from: a, reason: collision with root package name */
    public kotlin.reflect.jvm.internal.impl.serialization.deserialization.m f45977a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c a() {
            return n.f45976g;
        }
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.k c(@NotNull l0 descriptor, @NotNull x kotlinClass) {
        String[] g6;
        Pair<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e, ProtoBuf.Package> pair;
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        kotlin.jvm.internal.g0.p(kotlinClass, "kotlinClass");
        String[] m6 = m(kotlinClass, f45973d);
        if (m6 == null || (g6 = kotlinClass.e().g()) == null) {
            return null;
        }
        try {
            try {
                pair = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.m(m6, g6);
            } catch (InvalidProtocolBufferException e6) {
                throw new IllegalStateException("Could not read data from " + kotlinClass.getLocation(), e6);
            }
        } catch (Throwable th) {
            if (i() || kotlinClass.e().d().h(h())) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e component1 = pair.component1();
        ProtoBuf.Package component2 = pair.component2();
        r rVar = new r(kotlinClass, component2, component1, g(kotlinClass), k(kotlinClass), e(kotlinClass));
        return new m0(descriptor, component2, component1, kotlinClass.e().d(), rVar, f(), "scope for " + rVar + " in " + descriptor, m.f45970a);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.m f() {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.m mVar = this.f45977a;
        if (mVar != null) {
            return mVar;
        }
        kotlin.jvm.internal.g0.S("components");
        return null;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.h l(@NotNull x kotlinClass) {
        String[] g6;
        Pair<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e, ProtoBuf.Class> pair;
        kotlin.jvm.internal.g0.p(kotlinClass, "kotlinClass");
        String[] m6 = m(kotlinClass, f45972c);
        if (m6 == null || (g6 = kotlinClass.e().g()) == null) {
            return null;
        }
        try {
            try {
                pair = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.i(m6, g6);
            } catch (InvalidProtocolBufferException e6) {
                throw new IllegalStateException("Could not read data from " + kotlinClass.getLocation(), e6);
            }
        } catch (Throwable th) {
            if (i() || kotlinClass.e().d().h(h())) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.h(pair.component1(), pair.component2(), kotlinClass.e().d(), new z(kotlinClass, g(kotlinClass), new t0(k(kotlinClass), null, 2, null), e(kotlinClass)));
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.d n(@NotNull x kotlinClass) {
        kotlin.jvm.internal.g0.p(kotlinClass, "kotlinClass");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.h l6 = l(kotlinClass);
        if (l6 == null) {
            return null;
        }
        return f().f().e(kotlinClass.c(), l6);
    }

    public final void o(@NotNull k components) {
        kotlin.jvm.internal.g0.p(components, "components");
        p(components.a());
    }

    public final void p(@NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.m mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<set-?>");
        this.f45977a = mVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection d() {
        return kotlin.collections.f0.J();
    }

    private final DeserializedContainerAbiStability e(x xVar) {
        if (f().g().a()) {
            return DeserializedContainerAbiStability.STABLE;
        }
        if (xVar.e().j()) {
            return DeserializedContainerAbiStability.UNSTABLE;
        }
        return DeserializedContainerAbiStability.STABLE;
    }

    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.x<kotlin.reflect.jvm.internal.impl.metadata.deserialization.c> g(x xVar) {
        if (!i() && !xVar.e().d().h(h())) {
            return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.x<>(xVar.e().d(), kotlin.reflect.jvm.internal.impl.metadata.deserialization.c.f46236i, h(), h().k(xVar.e().d().j()), xVar.getLocation());
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c h() {
        return f().g().f();
    }

    private final boolean i() {
        return f().g().g();
    }

    private final boolean j(x xVar) {
        if (!f().g().d() && xVar.e().i() && kotlin.jvm.internal.g0.g(xVar.e().d(), f45975f)) {
            return true;
        }
        return false;
    }

    private final boolean k(x xVar) {
        if ((f().g().b() && (xVar.e().i() || kotlin.jvm.internal.g0.g(xVar.e().d(), f45974e))) || j(xVar)) {
            return true;
        }
        return false;
    }

    private final String[] m(x xVar, Set<? extends KotlinClassHeader.Kind> set) {
        KotlinClassHeader e6 = xVar.e();
        String[] a6 = e6.a();
        if (a6 == null) {
            a6 = e6.b();
        }
        if (a6 == null || !set.contains(e6.c())) {
            return null;
        }
        return a6;
    }
}
