package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.load.java.e0;
import kotlin.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final d f45685a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final p f45686b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final s<e0> f45687c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.d f45688d;

    public k(@NotNull d components, @NotNull p typeParameterResolver, @NotNull s<e0> delegateForDefaultTypeQualifiers) {
        g0.p(components, "components");
        g0.p(typeParameterResolver, "typeParameterResolver");
        g0.p(delegateForDefaultTypeQualifiers, "delegateForDefaultTypeQualifiers");
        this.f45685a = components;
        this.f45686b = typeParameterResolver;
        this.f45687c = delegateForDefaultTypeQualifiers;
        this.f45688d = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.d(this, typeParameterResolver);
    }

    @NotNull
    public final d a() {
        return this.f45685a;
    }

    @Nullable
    public final e0 b() {
        return this.f45687c.getValue();
    }

    @NotNull
    public final s<e0> c() {
        return this.f45687c;
    }

    @NotNull
    public final f0 d() {
        return this.f45685a.m();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.storage.n e() {
        return this.f45685a.u();
    }

    @NotNull
    public final p f() {
        return this.f45686b;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.d g() {
        return this.f45688d;
    }
}
