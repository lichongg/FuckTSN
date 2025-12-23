package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i extends h implements y3.c {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Annotation f45017c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Annotation annotation) {
        super(fVar, null);
        kotlin.jvm.internal.g0.p(annotation, "annotation");
        this.f45017c = annotation;
    }

    @Override // y3.c
    @NotNull
    public y3.a a() {
        return new g(this.f45017c);
    }
}
