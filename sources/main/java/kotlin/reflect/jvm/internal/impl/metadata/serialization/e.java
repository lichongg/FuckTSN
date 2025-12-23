package kotlin.reflect.jvm.internal.impl.metadata.serialization;

import java.util.Arrays;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class e<Element extends GeneratedMessageLite.b<?, Element>> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Element f46323a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final byte[] f46324b;

    /* renamed from: c, reason: collision with root package name */
    private final int f46325c;

    public e(@NotNull Element builder) {
        g0.p(builder, "builder");
        this.f46323a = builder;
        byte[] byteArray = builder.build().toByteArray();
        g0.o(byteArray, "toByteArray(...)");
        this.f46324b = byteArray;
        this.f46325c = Arrays.hashCode(byteArray);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof e) && Arrays.equals(this.f46324b, ((e) obj).f46324b);
    }

    public int hashCode() {
        return this.f46325c;
    }
}
