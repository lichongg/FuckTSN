package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.Set;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.q;
import kotlin.reflect.jvm.internal.impl.load.java.t;
import kotlin.text.u;
import kotlin.text.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d implements t {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final ClassLoader f44966a;

    public d(@NotNull ClassLoader classLoader) {
        g0.p(classLoader, "classLoader");
        this.f44966a = classLoader;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.t
    @Nullable
    public Set<String> a(@NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName) {
        g0.p(packageFqName, "packageFqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.t
    @Nullable
    public y3.g b(@NotNull t.a request) {
        g0.p(request, "request");
        kotlin.reflect.jvm.internal.impl.name.b a6 = request.a();
        kotlin.reflect.jvm.internal.impl.name.c f6 = a6.f();
        String w22 = u.w2(a6.g().a(), '.', v0.f47959c, false, 4, null);
        if (!f6.c()) {
            w22 = f6.a() + '.' + w22;
        }
        Class<?> a7 = e.a(this.f44966a, w22);
        if (a7 != null) {
            return new q(a7);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.t
    @Nullable
    public y3.u c(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, boolean z5) {
        g0.p(fqName, "fqName");
        return new b0(fqName);
    }
}
