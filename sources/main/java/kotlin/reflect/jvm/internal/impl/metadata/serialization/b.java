package kotlin.reflect.jvm.internal.impl.metadata.serialization;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class b<Element extends GeneratedMessageLite.b<?, Element>, Table extends GeneratedMessageLite, TableBuilder extends GeneratedMessageLite.b<Table, TableBuilder>> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final a<e<Element>> f46322a;

    public final int a(@NotNull Element type) {
        g0.p(type, "type");
        return this.f46322a.b(new e<>(type));
    }
}
