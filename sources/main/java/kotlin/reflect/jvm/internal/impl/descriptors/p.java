package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class p extends s {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final v1 f44942a;

    public p(@NotNull v1 delegate) {
        kotlin.jvm.internal.g0.p(delegate, "delegate");
        this.f44942a = delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
    @NotNull
    public v1 b() {
        return this.f44942a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
    @NotNull
    public String c() {
        return b().b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
    @NotNull
    public s f() {
        s j6 = r.j(b().d());
        kotlin.jvm.internal.g0.o(j6, "toDescriptorVisibility(...)");
        return j6;
    }
}
