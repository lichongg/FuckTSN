package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.e1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface w {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements w {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f47079a = new a();

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.w
        @NotNull
        public kotlin.reflect.jvm.internal.impl.types.t0 a(@NotNull ProtoBuf.Type proto, @NotNull String flexibleId, @NotNull e1 lowerBound, @NotNull e1 upperBound) {
            kotlin.jvm.internal.g0.p(proto, "proto");
            kotlin.jvm.internal.g0.p(flexibleId, "flexibleId");
            kotlin.jvm.internal.g0.p(lowerBound, "lowerBound");
            kotlin.jvm.internal.g0.p(upperBound, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }

        private a() {
        }
    }

    @NotNull
    kotlin.reflect.jvm.internal.impl.types.t0 a(@NotNull ProtoBuf.Type type, @NotNull String str, @NotNull e1 e1Var, @NotNull e1 e1Var2);
}
