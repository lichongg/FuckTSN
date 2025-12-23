package okio.internal;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import okio.TypedOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "-BufferedSource")
/* renamed from: okio.internal.-BufferedSource, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class BufferedSource {
    @Nullable
    public static final <T> T commonSelect(@NotNull okio.BufferedSource bufferedSource, @NotNull TypedOptions<T> options) {
        g0.p(bufferedSource, "<this>");
        g0.p(options, "options");
        int select = bufferedSource.select(options.getOptions$okio());
        if (select == -1) {
            return null;
        }
        return options.get(select);
    }
}
