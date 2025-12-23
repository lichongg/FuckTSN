package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class StreamResetException extends IOException {

    @JvmField
    @NotNull
    public final ErrorCode errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamResetException(@NotNull ErrorCode errorCode) {
        super("stream was reset: " + errorCode);
        g0.p(errorCode, "errorCode");
        this.errorCode = errorCode;
    }
}
