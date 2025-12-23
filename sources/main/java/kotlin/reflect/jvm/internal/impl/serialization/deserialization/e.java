package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e extends a<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> implements d<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final f f46956b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k0 notFoundClasses, @NotNull c4.a protocol) {
        super(protocol);
        kotlin.jvm.internal.g0.p(module, "module");
        kotlin.jvm.internal.g0.p(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.g0.p(protocol, "protocol");
        this.f46956b = new f(module, notFoundClasses);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.g
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.c k(@NotNull ProtoBuf.Annotation proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver) {
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        return this.f46956b.a(proto, nameResolver);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.d
    @Nullable
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> j(@NotNull m0 container, @NotNull ProtoBuf.Property proto, @NotNull kotlin.reflect.jvm.internal.impl.types.t0 expectedType) {
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(expectedType, "expectedType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.d
    @Nullable
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> e(@NotNull m0 container, @NotNull ProtoBuf.Property proto, @NotNull kotlin.reflect.jvm.internal.impl.types.t0 expectedType) {
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(expectedType, "expectedType");
        ProtoBuf.Annotation.Argument.Value value = (ProtoBuf.Annotation.Argument.Value) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a(proto, m().b());
        if (value == null) {
            return null;
        }
        return this.f46956b.f(expectedType, value, container.b());
    }
}
