package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class b implements j1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final j1 f44671a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final k f44672b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44673c;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public boolean E() {
        return true;
    }

    public b(@NotNull j1 originalDescriptor, @NotNull k declarationDescriptor, int i6) {
        kotlin.jvm.internal.g0.p(originalDescriptor, "originalDescriptor");
        kotlin.jvm.internal.g0.p(declarationDescriptor, "declarationDescriptor");
        this.f44671a = originalDescriptor;
        this.f44672b = declarationDescriptor;
        this.f44673c = i6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R W(m<R, D> mVar, D d6) {
        return (R) this.f44671a.W(mVar, d6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public k b() {
        return this.f44672b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.storage.n d0() {
        kotlin.reflect.jvm.internal.impl.storage.n d02 = this.f44671a.d0();
        kotlin.jvm.internal.g0.o(d02, "getStorageManager(...)");
        return d02;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        return this.f44671a.getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public int getIndex() {
        return this.f44673c + this.f44671a.getIndex();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        kotlin.reflect.jvm.internal.impl.name.f name = this.f44671a.getName();
        kotlin.jvm.internal.g0.o(name, "getName(...)");
        return name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public e1 getSource() {
        e1 source = this.f44671a.getSource();
        kotlin.jvm.internal.g0.o(source, "getSource(...)");
        return source;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.types.t0> getUpperBounds() {
        List<kotlin.reflect.jvm.internal.impl.types.t0> upperBounds = this.f44671a.getUpperBounds();
        kotlin.jvm.internal.g0.o(upperBounds, "getUpperBounds(...)");
        return upperBounds;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public boolean j() {
        return this.f44671a.j();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    @NotNull
    public Variance l() {
        Variance l6 = this.f44671a.l();
        kotlin.jvm.internal.g0.o(l6, "getVariance(...)");
        return l6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1, kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public w1 o() {
        w1 o5 = this.f44671a.o();
        kotlin.jvm.internal.g0.o(o5, "getTypeConstructor(...)");
        return o5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.e1 s() {
        kotlin.reflect.jvm.internal.impl.types.e1 s5 = this.f44671a.s();
        kotlin.jvm.internal.g0.o(s5, "getDefaultType(...)");
        return s5;
    }

    @NotNull
    public String toString() {
        return this.f44671a + "[inner-copy]";
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public j1 a() {
        j1 a6 = this.f44671a.a();
        kotlin.jvm.internal.g0.o(a6, "getOriginal(...)");
        return a6;
    }
}
