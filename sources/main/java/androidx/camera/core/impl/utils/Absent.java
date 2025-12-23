package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class Absent<T> extends Optional<T> {
    static final Absent<Object> sInstance = new Absent<>();
    private static final long serialVersionUID = 0;

    @Override // androidx.camera.core.impl.utils.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    @NonNull
    public T or(@NonNull T t5) {
        return (T) Preconditions.checkNotNull(t5, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // androidx.camera.core.impl.utils.Optional
    @Nullable
    public T orNull() {
        return null;
    }

    private Object readResolve() {
        return sInstance;
    }

    static <T> Optional<T> withType() {
        return sInstance;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public boolean equals(@Nullable Object obj) {
        return obj == this;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    @NonNull
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // androidx.camera.core.impl.utils.Optional
    @NonNull
    public Optional<T> or(@NonNull Optional<? extends T> optional) {
        return (Optional) Preconditions.checkNotNull(optional);
    }

    @Override // androidx.camera.core.impl.utils.Optional
    @NonNull
    public String toString() {
        return "Optional.absent()";
    }

    private Absent() {
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public int hashCode() {
        return 2040732332;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    @NonNull
    public T or(@NonNull Supplier<? extends T> supplier) {
        return (T) Preconditions.checkNotNull(supplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }
}
