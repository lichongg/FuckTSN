package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.j;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y3.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final j f46714a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.components.j f46715b;

    public c(@NotNull j packageFragmentProvider, @NotNull kotlin.reflect.jvm.internal.impl.load.java.components.j javaResolverCache) {
        g0.p(packageFragmentProvider, "packageFragmentProvider");
        g0.p(javaResolverCache, "javaResolverCache");
        this.f46714a = packageFragmentProvider;
        this.f46715b = javaResolverCache;
    }

    @NotNull
    public final j a() {
        return this.f46714a;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.d b(@NotNull g javaClass) {
        d0 d0Var;
        g0.p(javaClass, "javaClass");
        kotlin.reflect.jvm.internal.impl.name.c d6 = javaClass.d();
        if (d6 != null && javaClass.w() == LightClassOriginKind.SOURCE) {
            return this.f46715b.d(d6);
        }
        g h6 = javaClass.h();
        if (h6 == null) {
            if (d6 == null || (d0Var = (d0) f0.L2(this.f46714a.a(d6.d()))) == null) {
                return null;
            }
            return d0Var.I0(javaClass);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d b6 = b(h6);
        k G = b6 != null ? b6.G() : null;
        f g6 = G != null ? G.g(javaClass.getName(), NoLookupLocation.FROM_JAVA_LOADER) : null;
        if (g6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.d) g6;
        }
        return null;
    }
}
