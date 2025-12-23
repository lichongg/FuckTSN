package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class InconsistentKotlinMetadataException extends IllegalArgumentException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InconsistentKotlinMetadataException(@NotNull String message, @Nullable Throwable th) {
        super(message, th);
        g0.p(message, "message");
    }

    public /* synthetic */ InconsistentKotlinMetadataException(String str, Throwable th, int i6, kotlin.jvm.internal.v vVar) {
        this(str, (i6 & 2) != 0 ? null : th);
    }
}
