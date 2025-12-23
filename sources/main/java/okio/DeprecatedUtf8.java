package okio;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated(message = "changed in Okio 2.x")
/* renamed from: okio.-DeprecatedUtf8, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class DeprecatedUtf8 {

    @NotNull
    public static final DeprecatedUtf8 INSTANCE = new DeprecatedUtf8();

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.utf8Size()", imports = {"okio.utf8Size"}))
    public final long size(@NotNull String string) {
        g0.p(string, "string");
        return Utf8.size$default(string, 0, 0, 3, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.utf8Size(beginIndex, endIndex)", imports = {"okio.utf8Size"}))
    public final long size(@NotNull String string, int i6, int i7) {
        g0.p(string, "string");
        return Utf8.size(string, i6, i7);
    }

    private DeprecatedUtf8() {
    }
}
