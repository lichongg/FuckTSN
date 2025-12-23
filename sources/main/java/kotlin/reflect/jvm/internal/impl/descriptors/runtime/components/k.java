package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.k;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f44974c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.m f44975a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.a f44976b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final k a(@NotNull ClassLoader classLoader) {
            g0.p(classLoader, "classLoader");
            g gVar = new g(classLoader);
            k.a aVar = kotlin.reflect.jvm.internal.impl.load.kotlin.k.f45966b;
            ClassLoader classLoader2 = n1.class.getClassLoader();
            g0.o(classLoader2, "getClassLoader(...)");
            k.a.C0899a a6 = aVar.a(gVar, new g(classLoader2), new d(classLoader), "runtime module for " + classLoader, j.f44973b, l.f44977a);
            return new k(a6.a().a(), new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.a(a6.b(), gVar), null);
        }
    }

    public /* synthetic */ k(kotlin.reflect.jvm.internal.impl.serialization.deserialization.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.a aVar, v vVar) {
        this(mVar, aVar);
    }

    private k(kotlin.reflect.jvm.internal.impl.serialization.deserialization.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.a aVar) {
        this.f44975a = mVar;
        this.f44976b = aVar;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.m a() {
        return this.f44975a;
    }

    @NotNull
    public final f0 b() {
        return this.f44975a.q();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.a c() {
        return this.f44976b;
    }
}
