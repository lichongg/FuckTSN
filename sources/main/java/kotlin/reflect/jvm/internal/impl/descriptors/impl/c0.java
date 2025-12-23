package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c0 implements b0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<f0> f44699a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Set<f0> f44700b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<f0> f44701c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Set<f0> f44702d;

    public c0(@NotNull List<f0> allDependencies, @NotNull Set<f0> modulesWhoseInternalsAreVisible, @NotNull List<f0> directExpectedByDependencies, @NotNull Set<f0> allExpectedByDependencies) {
        kotlin.jvm.internal.g0.p(allDependencies, "allDependencies");
        kotlin.jvm.internal.g0.p(modulesWhoseInternalsAreVisible, "modulesWhoseInternalsAreVisible");
        kotlin.jvm.internal.g0.p(directExpectedByDependencies, "directExpectedByDependencies");
        kotlin.jvm.internal.g0.p(allExpectedByDependencies, "allExpectedByDependencies");
        this.f44699a = allDependencies;
        this.f44700b = modulesWhoseInternalsAreVisible;
        this.f44701c = directExpectedByDependencies;
        this.f44702d = allExpectedByDependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.b0
    @NotNull
    public List<f0> a() {
        return this.f44701c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.b0
    @NotNull
    public Set<f0> b() {
        return this.f44700b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.b0
    @NotNull
    public List<f0> c() {
        return this.f44699a;
    }
}
