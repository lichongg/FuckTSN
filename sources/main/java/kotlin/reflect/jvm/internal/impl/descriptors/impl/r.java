package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.b implements kotlin.reflect.jvm.internal.impl.descriptors.v {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.w0 f44836b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.w0 correspondingProperty) {
        super(annotations);
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        kotlin.jvm.internal.g0.p(correspondingProperty, "correspondingProperty");
        this.f44836b = correspondingProperty;
    }
}
