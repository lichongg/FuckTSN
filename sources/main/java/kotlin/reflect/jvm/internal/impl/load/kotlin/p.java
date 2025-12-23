package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.w0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.w {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f45980a = new p();

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.w
    @NotNull
    public t0 a(@NotNull ProtoBuf.Type proto, @NotNull String flexibleId, @NotNull e1 lowerBound, @NotNull e1 upperBound) {
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(flexibleId, "flexibleId");
        kotlin.jvm.internal.g0.p(lowerBound, "lowerBound");
        kotlin.jvm.internal.g0.p(upperBound, "upperBound");
        return !kotlin.jvm.internal.g0.g(flexibleId, "kotlin.jvm.PlatformType") ? kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.ERROR_FLEXIBLE_TYPE, flexibleId, lowerBound.toString(), upperBound.toString()) : proto.hasExtension(JvmProtoBuf.f46265g) ? new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.j(lowerBound, upperBound) : w0.e(lowerBound, upperBound);
    }

    private p() {
    }
}
