package androidx.room.util;

import androidx.annotation.RestrictTo;
import java.nio.ByteBuffer;
import java.util.UUID;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "UUIDUtil")
/* loaded from: D:\Downloads\app\classes.dex */
public final class UUIDUtil {
    @NotNull
    public static final UUID convertByteToUUID(@NotNull byte[] bytes) {
        g0.p(bytes, "bytes");
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    @NotNull
    public static final byte[] convertUUIDToByte(@NotNull UUID uuid) {
        g0.p(uuid, "uuid");
        ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
        wrap.putLong(uuid.getMostSignificantBits());
        wrap.putLong(uuid.getLeastSignificantBits());
        byte[] array = wrap.array();
        g0.o(array, "array(...)");
        return array;
    }
}
