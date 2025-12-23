package kotlin;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class NotImplementedError extends Error {
    public NotImplementedError() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotImplementedError(@NotNull String message) {
        super(message);
        kotlin.jvm.internal.g0.p(message, "message");
    }

    public /* synthetic */ NotImplementedError(String str, int i6, kotlin.jvm.internal.v vVar) {
        this((i6 & 1) != 0 ? "An operation is not implemented." : str);
    }
}
