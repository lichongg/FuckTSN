package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x extends h implements y3.o {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Object f45038c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Object value) {
        super(fVar, null);
        kotlin.jvm.internal.g0.p(value, "value");
        this.f45038c = value;
    }

    @Override // y3.o
    @NotNull
    public Object getValue() {
        return this.f45038c;
    }
}
