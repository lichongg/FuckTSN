package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d implements f0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f47213a = new d();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.f f47214b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final List<f0> f47215c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final List<f0> f47216d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Set<f0> f47217e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final s f47218f;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @Nullable
    public k b() {
        return null;
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.f k6 = kotlin.reflect.jvm.internal.impl.name.f.k(ErrorEntity.ERROR_MODULE.getDebugText());
        g0.o(k6, "special(...)");
        f47214b = k6;
        f47215c = kotlin.collections.f0.J();
        f47216d = kotlin.collections.f0.J();
        f47217e = u1.k();
        f47218f = t.c(c.f47212a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.builtins.g o0() {
        return kotlin.reflect.jvm.internal.impl.builtins.g.f44434i.a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f0
    public boolean B(@NotNull f0 targetModule) {
        g0.p(targetModule, "targetModule");
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f0
    @NotNull
    public s0 M(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        g0.p(fqName, "fqName");
        throw new IllegalStateException("Should not be called!");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f0
    @NotNull
    public List<f0> P() {
        return f47216d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f0
    @Nullable
    public <T> T U(@NotNull e0<T> capability) {
        g0.p(capability, "capability");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @Nullable
    public <R, D> R W(@NotNull m<R, D> visitor, D d6) {
        g0.p(visitor, "visitor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.builtins.j p() {
        return (kotlin.reflect.jvm.internal.impl.builtins.j) f47218f.getValue();
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f p0() {
        return f47214b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f0
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.name.c> q(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        g0.p(fqName, "fqName");
        g0.p(nameFilter, "nameFilter");
        return kotlin.collections.f0.J();
    }

    private d() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        return p0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public k a() {
        return this;
    }
}
