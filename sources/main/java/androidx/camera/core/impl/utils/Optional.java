package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public abstract boolean equals(@Nullable Object obj);

    @NonNull
    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    @NonNull
    public abstract Optional<T> or(@NonNull Optional<? extends T> optional);

    @NonNull
    public abstract T or(@NonNull Supplier<? extends T> supplier);

    @NonNull
    public abstract T or(@NonNull T t5);

    @Nullable
    public abstract T orNull();

    @NonNull
    public abstract String toString();

    @NonNull
    public static <T> Optional<T> fromNullable(@Nullable T t5) {
        return t5 == null ? absent() : new Present(t5);
    }

    @NonNull
    public static <T> Optional<T> of(@NonNull T t5) {
        return new Present(Preconditions.checkNotNull(t5));
    }

    Optional() {
    }

    @NonNull
    public static <T> Optional<T> absent() {
        return Absent.withType();
    }
}
