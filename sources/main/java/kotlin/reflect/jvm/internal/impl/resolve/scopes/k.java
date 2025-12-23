package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface k extends n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f46777a = a.f46778a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f46778a = new a();

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private static final Function1<kotlin.reflect.jvm.internal.impl.name.f, Boolean> f46779b = j.f46776a;

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean a(kotlin.reflect.jvm.internal.impl.name.f it) {
            g0.p(it, "it");
            return true;
        }

        @NotNull
        public final Function1<kotlin.reflect.jvm.internal.impl.name.f, Boolean> c() {
            return f46779b;
        }

        private a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {
        public static void a(@NotNull k kVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
            g0.p(name, "name");
            g0.p(location, "location");
            n.a.b(kVar, name, location);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    Collection<? extends d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull u3.b bVar);

    @NotNull
    Set<kotlin.reflect.jvm.internal.impl.name.f> b();

    @NotNull
    Collection<? extends w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull u3.b bVar);

    @NotNull
    Set<kotlin.reflect.jvm.internal.impl.name.f> d();

    @Nullable
    Set<kotlin.reflect.jvm.internal.impl.name.f> f();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends l {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final c f46780b = new c();

        private c() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
            return u1.k();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
            return u1.k();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> f() {
            return u1.k();
        }
    }
}
