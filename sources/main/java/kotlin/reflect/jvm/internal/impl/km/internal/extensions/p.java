package kotlin.reflect.jvm.internal.impl.km.internal.extensions;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.km.q;
import kotlin.reflect.jvm.internal.impl.km.u;
import kotlin.reflect.jvm.internal.impl.km.v;
import kotlin.reflect.jvm.internal.impl.km.w;
import kotlin.reflect.jvm.internal.impl.km.y;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f45189a = a.f45190a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f45190a = new a();

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private static final s<List<p>> f45191b = t.c(o.f45188a);

        /* JADX INFO: Access modifiers changed from: private */
        public static final List a() {
            ServiceLoader load = ServiceLoader.load(p.class, p.class.getClassLoader());
            g0.o(load, "load(...)");
            List a6 = f0.a6(load);
            if (a6.isEmpty()) {
                throw new IllegalStateException("No MetadataExtensions instances found in the classpath. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
            }
            return a6;
        }

        @NotNull
        public final List<p> c() {
            return f45191b.getValue();
        }

        private a() {
        }
    }

    @Nullable
    k a();

    @Nullable
    d b();

    void c(@NotNull y yVar, @NotNull ProtoBuf.ValueParameter.b bVar, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.h hVar);

    void d(@NotNull w wVar, @NotNull ProtoBuf.TypeParameter typeParameter, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e eVar);

    @NotNull
    b e();

    @NotNull
    c f();

    void g(@NotNull kotlin.reflect.jvm.internal.impl.km.s sVar, @NotNull ProtoBuf.Property property, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e eVar);

    @NotNull
    l h();

    void i(@NotNull w wVar, @NotNull ProtoBuf.TypeParameter.b bVar, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.h hVar);

    @NotNull
    m j();

    @Nullable
    n k();

    void l(@NotNull v vVar, @NotNull ProtoBuf.TypeAlias typeAlias, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e eVar);

    void m(@NotNull kotlin.reflect.jvm.internal.impl.km.o oVar, @NotNull ProtoBuf.EnumEntry enumEntry, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e eVar);

    void n(@NotNull kotlin.reflect.jvm.internal.impl.km.j jVar, @NotNull ProtoBuf.Constructor constructor, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e eVar);

    void o(@NotNull u uVar, @NotNull ProtoBuf.Type.b bVar, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.h hVar);

    @NotNull
    j p();

    void q(@NotNull u uVar, @NotNull ProtoBuf.Type type, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e eVar);

    void r(@NotNull kotlin.reflect.jvm.internal.impl.km.g gVar, @NotNull ProtoBuf.Class r22, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e eVar);

    void s(@NotNull kotlin.reflect.jvm.internal.impl.km.s sVar, @NotNull ProtoBuf.Property.b bVar, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.h hVar);

    void t(@NotNull y yVar, @NotNull ProtoBuf.ValueParameter valueParameter, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e eVar);

    @NotNull
    g u();

    void v(@NotNull q qVar, @NotNull ProtoBuf.Function function, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e eVar);
}
