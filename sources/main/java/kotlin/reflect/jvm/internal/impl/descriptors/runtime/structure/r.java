package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r extends h implements y3.h {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Class<?> f45032c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Class<?> klass) {
        super(fVar, null);
        kotlin.jvm.internal.g0.p(klass, "klass");
        this.f45032c = klass;
    }

    @Override // y3.h
    @NotNull
    public y3.x b() {
        return e0.f45001a.a(this.f45032c);
    }
}
