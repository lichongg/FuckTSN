package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b extends a implements f {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f46791c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final kotlin.reflect.jvm.internal.impl.name.f f46792d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor, @NotNull t0 receiverType, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @Nullable h hVar) {
        super(receiverType, hVar);
        g0.p(classDescriptor, "classDescriptor");
        g0.p(receiverType, "receiverType");
        this.f46791c = classDescriptor;
        this.f46792d = fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.f
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.f a() {
        return this.f46792d;
    }

    @NotNull
    public String toString() {
        return getType() + ": Ctx { " + this.f46791c + " }";
    }
}
