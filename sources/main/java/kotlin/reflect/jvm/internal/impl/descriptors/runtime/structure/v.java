package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v extends h implements y3.m {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Enum<?> f45036c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Enum<?> value) {
        super(fVar, null);
        kotlin.jvm.internal.g0.p(value, "value");
        this.f45036c = value;
    }

    @Override // y3.m
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.b c() {
        Class<?> cls = this.f45036c.getClass();
        if (!cls.isEnum()) {
            cls = cls.getEnclosingClass();
        }
        kotlin.jvm.internal.g0.m(cls);
        return f.e(cls);
    }

    @Override // y3.m
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.f d() {
        return kotlin.reflect.jvm.internal.impl.name.f.h(this.f45036c.name());
    }
}
