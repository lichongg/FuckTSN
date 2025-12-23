package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class h0 extends n implements kotlin.reflect.jvm.internal.impl.descriptors.l0 {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.c f44749e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final String f44750f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        super(module, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b(), fqName.g(), e1.f44683a);
        kotlin.jvm.internal.g0.p(module, "module");
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        this.f44749e = fqName;
        this.f44750f = "package " + fqName + " of " + module;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R W(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> visitor, D d6) {
        kotlin.jvm.internal.g0.p(visitor, "visitor");
        return visitor.k(this, d6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.n, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.f0 b() {
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = super.b();
        kotlin.jvm.internal.g0.n(b6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
        return (kotlin.reflect.jvm.internal.impl.descriptors.f0) b6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.c d() {
        return this.f44749e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.n, kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public e1 getSource() {
        e1 NO_SOURCE = e1.f44683a;
        kotlin.jvm.internal.g0.o(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m
    @NotNull
    public String toString() {
        return this.f44750f;
    }
}
