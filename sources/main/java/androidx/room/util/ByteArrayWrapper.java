package androidx.room.util;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ByteArrayWrapper {

    @JvmField
    @NotNull
    public final byte[] array;

    public ByteArrayWrapper(@NotNull byte[] array) {
        g0.p(array, "array");
        this.array = array;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ByteArrayWrapper) {
            return Arrays.equals(this.array, ((ByteArrayWrapper) obj).array);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.array);
    }
}
