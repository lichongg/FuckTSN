package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T a(@NotNull GeneratedMessageLite.ExtendableMessage<M> extendableMessage, @NotNull GeneratedMessageLite.f<M, T> extension) {
        g0.p(extendableMessage, "<this>");
        g0.p(extension, "extension");
        if (extendableMessage.hasExtension(extension)) {
            return (T) extendableMessage.getExtension(extension);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T b(@NotNull GeneratedMessageLite.ExtendableMessage<M> extendableMessage, @NotNull GeneratedMessageLite.f<M, List<T>> extension, int i6) {
        g0.p(extendableMessage, "<this>");
        g0.p(extension, "extension");
        if (i6 < extendableMessage.getExtensionCount(extension)) {
            return (T) extendableMessage.getExtension(extension, i6);
        }
        return null;
    }
}
