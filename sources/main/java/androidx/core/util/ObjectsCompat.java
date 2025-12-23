package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ObjectsCompat {
    @NonNull
    public static <T> T requireNonNull(@Nullable T t5) {
        t5.getClass();
        return t5;
    }

    public static int hashCode(@Nullable Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T t5, @NonNull String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    @Nullable
    public static String toString(@Nullable Object obj, @Nullable String str) {
        return obj != null ? obj.toString() : str;
    }

    private ObjectsCompat() {
    }

    public static boolean equals(@Nullable Object obj, @Nullable Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int hash(@Nullable Object... objArr) {
        return Objects.hash(objArr);
    }
}
